package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Process;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;

class WebRtcAudioRecord
{
  private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000L;
  private static final int BITS_PER_SAMPLE = 16;
  private static final int BUFFERS_PER_SECOND = 100;
  private static final int BUFFER_SIZE_FACTOR = 2;
  private static final int CALLBACK_BUFFER_SIZE_MS = 10;
  public static final int DEFAULT_AUDIO_SOURCE = 7;
  private static final String TAG = "WebRtcAudioRecordExternal";
  private final AudioManager audioManager;

  @Nullable
  private AudioRecord audioRecord = null;

  @Nullable
  private final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
  private final int audioSource;

  @Nullable
  private AudioRecordThread audioThread = null;

  @Nullable
  private ByteBuffer byteBuffer;
  private final Context context;
  private final WebRtcAudioEffects effects = new WebRtcAudioEffects();
  private byte[] emptyBytes;

  @Nullable
  private final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
  private final boolean isAcousticEchoCancelerSupported;
  private final boolean isNoiseSuppressorSupported;
  private volatile boolean microphoneMute = false;
  private long nativeAudioRecord;

  @CalledByNative
  WebRtcAudioRecord(Context paramContext, AudioManager paramAudioManager)
  {
    this(paramContext, paramAudioManager, 7, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported());
  }

  public WebRtcAudioRecord(Context paramContext, AudioManager paramAudioManager, int paramInt, @Nullable JavaAudioDeviceModule.AudioRecordErrorCallback paramAudioRecordErrorCallback, @Nullable JavaAudioDeviceModule.SamplesReadyCallback paramSamplesReadyCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!WebRtcAudioEffects.isAcousticEchoCancelerSupported()))
      throw new IllegalArgumentException("HW AEC not supported");
    if ((paramBoolean2) && (!WebRtcAudioEffects.isNoiseSuppressorSupported()))
      throw new IllegalArgumentException("HW NS not supported");
    this.context = paramContext;
    this.audioManager = paramAudioManager;
    this.audioSource = paramInt;
    this.errorCallback = paramAudioRecordErrorCallback;
    this.audioSamplesReadyCallback = paramSamplesReadyCallback;
    this.isAcousticEchoCancelerSupported = paramBoolean1;
    this.isNoiseSuppressorSupported = paramBoolean2;
  }

  private static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new AssertionError("Expected condition to be true");
  }

  private int channelCountToConfiguration(int paramInt)
  {
    if (paramInt == 1)
      return 16;
    return 12;
  }

  @CalledByNative
  private boolean enableBuiltInAEC(boolean paramBoolean)
  {
    Logging.d("WebRtcAudioRecordExternal", "enableBuiltInAEC(" + paramBoolean + ")");
    return this.effects.setAEC(paramBoolean);
  }

  @CalledByNative
  private boolean enableBuiltInNS(boolean paramBoolean)
  {
    Logging.d("WebRtcAudioRecordExternal", "enableBuiltInNS(" + paramBoolean + ")");
    return this.effects.setNS(paramBoolean);
  }

  @CalledByNative
  private int initRecording(int paramInt1, int paramInt2)
  {
    Logging.d("WebRtcAudioRecordExternal", "initRecording(sampleRate=" + paramInt1 + ", channels=" + paramInt2 + ")");
    if (this.audioRecord != null)
    {
      reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
      return -1;
    }
    int i = paramInt2 * 2;
    int j = paramInt1 / 100;
    this.byteBuffer = ByteBuffer.allocateDirect(i * j);
    if (!this.byteBuffer.hasArray())
    {
      reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
      return -1;
    }
    Logging.d("WebRtcAudioRecordExternal", "byteBuffer.capacity: " + this.byteBuffer.capacity());
    this.emptyBytes = new byte[this.byteBuffer.capacity()];
    nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
    int k = channelCountToConfiguration(paramInt2);
    int m = AudioRecord.getMinBufferSize(paramInt1, k, 2);
    if ((m == -1) || (m == -2))
    {
      reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + m);
      return -1;
    }
    Logging.d("WebRtcAudioRecordExternal", "AudioRecord.getMinBufferSize: " + m);
    int n = Math.max(m * 2, this.byteBuffer.capacity());
    Logging.d("WebRtcAudioRecordExternal", "bufferSizeInBytes: " + n);
    try
    {
      this.audioRecord = new AudioRecord(this.audioSource, paramInt1, k, 2, n);
      if ((this.audioRecord == null) || (this.audioRecord.getState() != 1))
      {
        reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
        releaseAudioResources();
        return -1;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + localIllegalArgumentException.getMessage());
      releaseAudioResources();
      return -1;
    }
    this.effects.enable(this.audioRecord.getAudioSessionId());
    logMainParameters();
    logMainParametersExtended();
    return j;
  }

  private void logMainParameters()
  {
    Logging.d("WebRtcAudioRecordExternal", "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
  }

  @TargetApi(23)
  private void logMainParametersExtended()
  {
    if (WebRtcAudioUtils.runningOnMarshmallowOrHigher())
      Logging.d("WebRtcAudioRecordExternal", "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
  }

  private native void nativeCacheDirectBufferAddress(long paramLong, ByteBuffer paramByteBuffer);

  private native void nativeDataIsRecorded(long paramLong, int paramInt);

  private void releaseAudioResources()
  {
    Logging.d("WebRtcAudioRecordExternal", "releaseAudioResources");
    if (this.audioRecord != null)
    {
      this.audioRecord.release();
      this.audioRecord = null;
    }
  }

  private void reportWebRtcAudioRecordError(String paramString)
  {
    Logging.e("WebRtcAudioRecordExternal", "Run-time recording error: " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
    if (this.errorCallback != null)
      this.errorCallback.onWebRtcAudioRecordError(paramString);
  }

  private void reportWebRtcAudioRecordInitError(String paramString)
  {
    Logging.e("WebRtcAudioRecordExternal", "Init recording error: " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
    if (this.errorCallback != null)
      this.errorCallback.onWebRtcAudioRecordInitError(paramString);
  }

  private void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString)
  {
    Logging.e("WebRtcAudioRecordExternal", "Start recording error: " + paramAudioRecordStartErrorCode + ". " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
    if (this.errorCallback != null)
      this.errorCallback.onWebRtcAudioRecordStartError(paramAudioRecordStartErrorCode, paramString);
  }

  @CalledByNative
  private boolean startRecording()
  {
    Logging.d("WebRtcAudioRecordExternal", "startRecording");
    boolean bool1;
    if (this.audioRecord != null)
      bool1 = true;
    while (true)
    {
      assertTrue(bool1);
      boolean bool2;
      if (this.audioThread == null)
      {
        bool2 = true;
        assertTrue(bool2);
      }
      try
      {
        this.audioRecord.startRecording();
        if (this.audioRecord.getRecordingState() != 3)
        {
          reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
          return false;
          bool1 = false;
          continue;
          bool2 = false;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + localIllegalStateException.getMessage());
        return false;
      }
    }
    this.audioThread = new AudioRecordThread("AudioRecordJavaThread");
    this.audioThread.start();
    return true;
  }

  @CalledByNative
  private boolean stopRecording()
  {
    Logging.d("WebRtcAudioRecordExternal", "stopRecording");
    if (this.audioThread != null);
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(bool);
      this.audioThread.stopThread();
      if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L))
      {
        Logging.e("WebRtcAudioRecordExternal", "Join of AudioRecordJavaThread timed out");
        WebRtcAudioUtils.logAudioState("WebRtcAudioRecordExternal", this.context, this.audioManager);
      }
      this.audioThread = null;
      this.effects.release();
      releaseAudioResources();
      return true;
    }
  }

  @CalledByNative
  boolean isAcousticEchoCancelerSupported()
  {
    return this.isAcousticEchoCancelerSupported;
  }

  @CalledByNative
  boolean isNoiseSuppressorSupported()
  {
    return this.isNoiseSuppressorSupported;
  }

  public void setMicrophoneMute(boolean paramBoolean)
  {
    Logging.w("WebRtcAudioRecordExternal", "setMicrophoneMute(" + paramBoolean + ")");
    this.microphoneMute = paramBoolean;
  }

  @CalledByNative
  public void setNativeAudioRecord(long paramLong)
  {
    this.nativeAudioRecord = paramLong;
  }

  private class AudioRecordThread extends Thread
  {
    private volatile boolean keepAlive = true;

    public AudioRecordThread(String arg2)
    {
      super();
    }

    public void run()
    {
      Process.setThreadPriority(-19);
      Logging.d("WebRtcAudioRecordExternal", "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
      boolean bool;
      if (WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3)
      {
        bool = true;
        WebRtcAudioRecord.assertTrue(bool);
        System.nanoTime();
      }
      while (true)
      {
        if (!this.keepAlive)
          break label336;
        int i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
        if (i == WebRtcAudioRecord.this.byteBuffer.capacity())
        {
          if (WebRtcAudioRecord.this.microphoneMute)
          {
            WebRtcAudioRecord.this.byteBuffer.clear();
            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
          }
          if (this.keepAlive)
            WebRtcAudioRecord.this.nativeDataIsRecorded(WebRtcAudioRecord.this.nativeAudioRecord, i);
          if (WebRtcAudioRecord.this.audioSamplesReadyCallback == null)
            continue;
          byte[] arrayOfByte = Arrays.copyOfRange(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.arrayOffset(), WebRtcAudioRecord.this.byteBuffer.capacity() + WebRtcAudioRecord.this.byteBuffer.arrayOffset());
          WebRtcAudioRecord.this.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.this.audioRecord.getAudioFormat(), WebRtcAudioRecord.this.audioRecord.getChannelCount(), WebRtcAudioRecord.this.audioRecord.getSampleRate(), arrayOfByte));
          continue;
          bool = false;
          break;
        }
        String str = "AudioRecord.read failed: " + i;
        Logging.e("WebRtcAudioRecordExternal", str);
        if (i == -3)
        {
          this.keepAlive = false;
          WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
        }
      }
      try
      {
        label336: if (WebRtcAudioRecord.this.audioRecord != null)
          WebRtcAudioRecord.this.audioRecord.stop();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logging.e("WebRtcAudioRecordExternal", "AudioRecord.stop failed: " + localIllegalStateException.getMessage());
      }
    }

    public void stopThread()
    {
      Logging.d("WebRtcAudioRecordExternal", "stopThread");
      this.keepAlive = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.WebRtcAudioRecord
 * JD-Core Version:    0.6.2
 */