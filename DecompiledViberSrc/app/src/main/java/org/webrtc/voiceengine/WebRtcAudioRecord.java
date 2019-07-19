package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.os.Process;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;

public class WebRtcAudioRecord
{
  private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000L;
  private static final int BITS_PER_SAMPLE = 16;
  private static final int BUFFERS_PER_SECOND = 100;
  private static final int BUFFER_SIZE_FACTOR = 2;
  private static final int CALLBACK_BUFFER_SIZE_MS = 10;
  private static final boolean DEBUG = false;
  private static final int DEFAULT_AUDIO_SOURCE = 0;
  private static final String TAG = "WebRtcAudioRecord";

  @Nullable
  private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback = null;
  private static int audioSource = DEFAULT_AUDIO_SOURCE;

  @Nullable
  private static WebRtcAudioRecordErrorCallback errorCallback;
  private static volatile boolean microphoneMute = false;

  @Nullable
  private AudioRecord audioRecord = null;

  @Nullable
  private AudioRecordThread audioThread = null;
  private ByteBuffer byteBuffer;

  @Nullable
  private WebRtcAudioEffects effects = null;
  private byte[] emptyBytes;
  private final long nativeAudioRecord;

  static
  {
    errorCallback = null;
  }

  WebRtcAudioRecord(long paramLong)
  {
    Logging.d("WebRtcAudioRecord", "ctor" + WebRtcAudioUtils.getThreadInfo());
    this.nativeAudioRecord = paramLong;
    this.effects = WebRtcAudioEffects.create();
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

  private boolean enableBuiltInAEC(boolean paramBoolean)
  {
    Logging.d("WebRtcAudioRecord", "enableBuiltInAEC(" + paramBoolean + ')');
    if (this.effects == null)
    {
      Logging.e("WebRtcAudioRecord", "Built-in AEC is not supported on this platform");
      return false;
    }
    return this.effects.setAEC(paramBoolean);
  }

  private boolean enableBuiltInNS(boolean paramBoolean)
  {
    Logging.d("WebRtcAudioRecord", "enableBuiltInNS(" + paramBoolean + ')');
    if (this.effects == null)
    {
      Logging.e("WebRtcAudioRecord", "Built-in NS is not supported on this platform");
      return false;
    }
    return this.effects.setNS(paramBoolean);
  }

  private static int getDefaultAudioSource()
  {
    return 7;
  }

  private int initRecording(int paramInt1, int paramInt2)
  {
    Logging.d("WebRtcAudioRecord", "initRecording(sampleRate=" + paramInt1 + ", channels=" + paramInt2 + ")");
    if (this.audioRecord != null)
    {
      reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
      return -1;
    }
    int i = paramInt2 * 2;
    int j = paramInt1 / 100;
    this.byteBuffer = ByteBuffer.allocateDirect(i * j);
    Logging.d("WebRtcAudioRecord", "byteBuffer.capacity: " + this.byteBuffer.capacity());
    this.emptyBytes = new byte[this.byteBuffer.capacity()];
    nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
    int k = channelCountToConfiguration(paramInt2);
    int m = AudioRecord.getMinBufferSize(paramInt1, k, 2);
    if ((m == -1) || (m == -2))
    {
      reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + m);
      return -1;
    }
    Logging.d("WebRtcAudioRecord", "AudioRecord.getMinBufferSize: " + m);
    int n = Math.max(m * 2, this.byteBuffer.capacity());
    Logging.d("WebRtcAudioRecord", "bufferSizeInBytes: " + n);
    try
    {
      this.audioRecord = new AudioRecord(audioSource, paramInt1, k, 2, n);
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
    if (this.effects != null)
      this.effects.enable(this.audioRecord.getAudioSessionId());
    logMainParameters();
    logMainParametersExtended();
    return j;
  }

  private void logMainParameters()
  {
    Logging.d("WebRtcAudioRecord", "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
  }

  @TargetApi(23)
  private void logMainParametersExtended()
  {
    if (WebRtcAudioUtils.runningOnMarshmallowOrHigher())
      Logging.d("WebRtcAudioRecord", "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
  }

  private native void nativeCacheDirectBufferAddress(ByteBuffer paramByteBuffer, long paramLong);

  private native void nativeDataIsRecorded(int paramInt, long paramLong);

  private void releaseAudioResources()
  {
    Logging.d("WebRtcAudioRecord", "releaseAudioResources");
    if (this.audioRecord != null)
    {
      this.audioRecord.release();
      this.audioRecord = null;
    }
  }

  private void reportWebRtcAudioRecordError(String paramString)
  {
    Logging.e("WebRtcAudioRecord", "Run-time recording error: " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
    if (errorCallback != null)
      errorCallback.onWebRtcAudioRecordError(paramString);
  }

  private void reportWebRtcAudioRecordInitError(String paramString)
  {
    Logging.e("WebRtcAudioRecord", "Init recording error: " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
    if (errorCallback != null)
      errorCallback.onWebRtcAudioRecordInitError(paramString);
  }

  private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString)
  {
    Logging.e("WebRtcAudioRecord", "Start recording error: " + paramAudioRecordStartErrorCode + ". " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
    if (errorCallback != null)
      errorCallback.onWebRtcAudioRecordStartError(paramAudioRecordStartErrorCode, paramString);
  }

  public static void setAudioSource(int paramInt)
  {
    try
    {
      Logging.w("WebRtcAudioRecord", "Audio source is changed from: " + audioSource + " to " + paramInt);
      audioSource = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void setErrorCallback(WebRtcAudioRecordErrorCallback paramWebRtcAudioRecordErrorCallback)
  {
    Logging.d("WebRtcAudioRecord", "Set error callback");
    errorCallback = paramWebRtcAudioRecordErrorCallback;
  }

  public static void setMicrophoneMute(boolean paramBoolean)
  {
    Logging.w("WebRtcAudioRecord", "setMicrophoneMute(" + paramBoolean + ")");
    microphoneMute = paramBoolean;
  }

  public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback paramWebRtcAudioRecordSamplesReadyCallback)
  {
    audioSamplesReadyCallback = paramWebRtcAudioRecordSamplesReadyCallback;
  }

  private boolean startRecording()
  {
    Logging.d("WebRtcAudioRecord", "startRecording");
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
          reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
          return false;
          bool1 = false;
          continue;
          bool2 = false;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + localIllegalStateException.getMessage());
        return false;
      }
    }
    this.audioThread = new AudioRecordThread("AudioRecordJavaThread");
    this.audioThread.start();
    return true;
  }

  private boolean stopRecording()
  {
    Logging.d("WebRtcAudioRecord", "stopRecording");
    if (this.audioThread != null);
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(bool);
      this.audioThread.stopThread();
      if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L))
      {
        Logging.e("WebRtcAudioRecord", "Join of AudioRecordJavaThread timed out");
        WebRtcAudioUtils.logAudioState("WebRtcAudioRecord");
      }
      this.audioThread = null;
      if (this.effects != null)
        this.effects.release();
      releaseAudioResources();
      return true;
    }
  }

  public static enum AudioRecordStartErrorCode
  {
    static
    {
      AudioRecordStartErrorCode[] arrayOfAudioRecordStartErrorCode = new AudioRecordStartErrorCode[2];
      arrayOfAudioRecordStartErrorCode[0] = AUDIO_RECORD_START_EXCEPTION;
      arrayOfAudioRecordStartErrorCode[1] = AUDIO_RECORD_START_STATE_MISMATCH;
    }
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
      Logging.d("WebRtcAudioRecord", "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
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
          break label281;
        int i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
        if (i == WebRtcAudioRecord.this.byteBuffer.capacity())
        {
          if (WebRtcAudioRecord.microphoneMute)
          {
            WebRtcAudioRecord.this.byteBuffer.clear();
            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
          }
          if (this.keepAlive)
            WebRtcAudioRecord.this.nativeDataIsRecorded(i, WebRtcAudioRecord.this.nativeAudioRecord);
          if (WebRtcAudioRecord.audioSamplesReadyCallback == null)
            continue;
          byte[] arrayOfByte = Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity());
          WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new WebRtcAudioRecord.AudioSamples(WebRtcAudioRecord.this.audioRecord, arrayOfByte, null));
          continue;
          bool = false;
          break;
        }
        String str = "AudioRecord.read failed: " + i;
        Logging.e("WebRtcAudioRecord", str);
        if (i == -3)
        {
          this.keepAlive = false;
          WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
        }
      }
      try
      {
        label281: if (WebRtcAudioRecord.this.audioRecord != null)
          WebRtcAudioRecord.this.audioRecord.stop();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logging.e("WebRtcAudioRecord", "AudioRecord.stop failed: " + localIllegalStateException.getMessage());
      }
    }

    public void stopThread()
    {
      Logging.d("WebRtcAudioRecord", "stopThread");
      this.keepAlive = false;
    }
  }

  public static class AudioSamples
  {
    private final int audioFormat;
    private final int channelCount;
    private final byte[] data;
    private final int sampleRate;

    private AudioSamples(AudioRecord paramAudioRecord, byte[] paramArrayOfByte)
    {
      this.audioFormat = paramAudioRecord.getAudioFormat();
      this.channelCount = paramAudioRecord.getChannelCount();
      this.sampleRate = paramAudioRecord.getSampleRate();
      this.data = paramArrayOfByte;
    }

    public int getAudioFormat()
    {
      return this.audioFormat;
    }

    public int getChannelCount()
    {
      return this.channelCount;
    }

    public byte[] getData()
    {
      return this.data;
    }

    public int getSampleRate()
    {
      return this.sampleRate;
    }
  }

  public static abstract interface WebRtcAudioRecordErrorCallback
  {
    public abstract void onWebRtcAudioRecordError(String paramString);

    public abstract void onWebRtcAudioRecordInitError(String paramString);

    public abstract void onWebRtcAudioRecordStartError(WebRtcAudioRecord.AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString);
  }

  public static abstract interface WebRtcAudioRecordSamplesReadyCallback
  {
    public abstract void onWebRtcAudioRecordSamplesReady(WebRtcAudioRecord.AudioSamples paramAudioSamples);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioRecord
 * JD-Core Version:    0.6.2
 */