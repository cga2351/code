package org.webrtc.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.ThreadUtils.ThreadChecker;

class WebRtcAudioTrack
{
  private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000L;
  private static final int BITS_PER_SAMPLE = 16;
  private static final int BUFFERS_PER_SECOND = 100;
  private static final int CALLBACK_BUFFER_SIZE_MS = 10;
  private static final int DEFAULT_USAGE = 0;
  private static final String TAG = "WebRtcAudioTrackExternal";
  private final AudioManager audioManager;

  @Nullable
  private AudioTrackThread audioThread = null;

  @Nullable
  private AudioTrack audioTrack = null;
  private ByteBuffer byteBuffer;
  private final Context context;
  private byte[] emptyBytes;

  @Nullable
  private final JavaAudioDeviceModule.AudioTrackErrorCallback errorCallback;
  private long nativeAudioTrack;
  private volatile boolean speakerMute = false;
  private final ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
  private final VolumeLogger volumeLogger;

  @CalledByNative
  WebRtcAudioTrack(Context paramContext, AudioManager paramAudioManager)
  {
    this(paramContext, paramAudioManager, null);
  }

  WebRtcAudioTrack(Context paramContext, AudioManager paramAudioManager, @Nullable JavaAudioDeviceModule.AudioTrackErrorCallback paramAudioTrackErrorCallback)
  {
    this.threadChecker.detachThread();
    this.context = paramContext;
    this.audioManager = paramAudioManager;
    this.errorCallback = paramAudioTrackErrorCallback;
    this.volumeLogger = new VolumeLogger(paramAudioManager);
  }

  private static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new AssertionError("Expected condition to be true");
  }

  private int channelCountToConfiguration(int paramInt)
  {
    if (paramInt == 1)
      return 4;
    return 12;
  }

  @TargetApi(21)
  private static AudioTrack createAudioTrackOnLollipopOrHigher(int paramInt1, int paramInt2, int paramInt3)
  {
    Logging.d("WebRtcAudioTrackExternal", "createAudioTrackOnLollipopOrHigher");
    int i = AudioTrack.getNativeOutputSampleRate(0);
    Logging.d("WebRtcAudioTrackExternal", "nativeOutputSampleRate: " + i);
    if (paramInt1 != i)
      Logging.w("WebRtcAudioTrackExternal", "Unable to use fast mode since requested sample rate is not native");
    return new AudioTrack(new AudioAttributes.Builder().setUsage(DEFAULT_USAGE).setContentType(1).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(paramInt1).setChannelMask(paramInt2).build(), paramInt3, 1, 0);
  }

  private static AudioTrack createAudioTrackOnLowerThanLollipop(int paramInt1, int paramInt2, int paramInt3)
  {
    return new AudioTrack(0, paramInt1, paramInt2, 2, paramInt3, 1);
  }

  private static int getDefaultUsageAttribute()
  {
    if (WebRtcAudioUtils.runningOnLollipopOrHigher())
      return getDefaultUsageAttributeOnLollipopOrHigher();
    return 0;
  }

  @TargetApi(21)
  private static int getDefaultUsageAttributeOnLollipopOrHigher()
  {
    return 2;
  }

  @CalledByNative
  private int getStreamMaxVolume()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrackExternal", "getStreamMaxVolume");
    return this.audioManager.getStreamMaxVolume(0);
  }

  @CalledByNative
  private int getStreamVolume()
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrackExternal", "getStreamVolume");
    return this.audioManager.getStreamVolume(0);
  }

  @CalledByNative
  private boolean initPlayout(int paramInt1, int paramInt2)
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrackExternal", "initPlayout(sampleRate=" + paramInt1 + ", channels=" + paramInt2 + ")");
    this.byteBuffer = ByteBuffer.allocateDirect(paramInt2 * 2 * (paramInt1 / 100));
    Logging.d("WebRtcAudioTrackExternal", "byteBuffer.capacity: " + this.byteBuffer.capacity());
    this.emptyBytes = new byte[this.byteBuffer.capacity()];
    nativeCacheDirectBufferAddress(this.nativeAudioTrack, this.byteBuffer);
    int i = channelCountToConfiguration(paramInt2);
    int j = AudioTrack.getMinBufferSize(paramInt1, i, 2);
    Logging.d("WebRtcAudioTrackExternal", "AudioTrack.getMinBufferSize: " + j);
    if (j < this.byteBuffer.capacity())
    {
      reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
      return false;
    }
    if (this.audioTrack != null)
    {
      reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
      return false;
    }
    try
    {
      if (WebRtcAudioUtils.runningOnLollipopOrHigher());
      for (this.audioTrack = createAudioTrackOnLollipopOrHigher(paramInt1, i, j); (this.audioTrack == null) || (this.audioTrack.getState() != 1); this.audioTrack = createAudioTrackOnLowerThanLollipop(paramInt1, i, j))
      {
        reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
        releaseAudioResources();
        return false;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      reportWebRtcAudioTrackInitError(localIllegalArgumentException.getMessage());
      releaseAudioResources();
      return false;
    }
    logMainParameters();
    logMainParametersExtended();
    return true;
  }

  @SuppressLint({"NewApi"})
  private boolean isVolumeFixed()
  {
    if (!WebRtcAudioUtils.runningOnLollipopOrHigher())
      return false;
    return this.audioManager.isVolumeFixed();
  }

  private void logMainParameters()
  {
    Logging.d("WebRtcAudioTrackExternal", "AudioTrack: session ID: " + this.audioTrack.getAudioSessionId() + ", channels: " + this.audioTrack.getChannelCount() + ", sample rate: " + this.audioTrack.getSampleRate() + ", max gain: " + AudioTrack.getMaxVolume());
  }

  @TargetApi(24)
  private void logMainParametersExtended()
  {
    if (WebRtcAudioUtils.runningOnMarshmallowOrHigher())
      Logging.d("WebRtcAudioTrackExternal", "AudioTrack: buffer size in frames: " + this.audioTrack.getBufferSizeInFrames());
    if (WebRtcAudioUtils.runningOnNougatOrHigher())
      Logging.d("WebRtcAudioTrackExternal", "AudioTrack: buffer capacity in frames: " + this.audioTrack.getBufferCapacityInFrames());
  }

  @TargetApi(24)
  private void logUnderrunCount()
  {
    if (WebRtcAudioUtils.runningOnNougatOrHigher())
      Logging.d("WebRtcAudioTrackExternal", "underrun count: " + this.audioTrack.getUnderrunCount());
  }

  private static native void nativeCacheDirectBufferAddress(long paramLong, ByteBuffer paramByteBuffer);

  private static native void nativeGetPlayoutData(long paramLong, int paramInt);

  private void releaseAudioResources()
  {
    Logging.d("WebRtcAudioTrackExternal", "releaseAudioResources");
    if (this.audioTrack != null)
    {
      this.audioTrack.release();
      this.audioTrack = null;
    }
  }

  private void reportWebRtcAudioTrackError(String paramString)
  {
    Logging.e("WebRtcAudioTrackExternal", "Run-time playback error: " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
    if (this.errorCallback != null)
      this.errorCallback.onWebRtcAudioTrackError(paramString);
  }

  private void reportWebRtcAudioTrackInitError(String paramString)
  {
    Logging.e("WebRtcAudioTrackExternal", "Init playout error: " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
    if (this.errorCallback != null)
      this.errorCallback.onWebRtcAudioTrackInitError(paramString);
  }

  private void reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode paramAudioTrackStartErrorCode, String paramString)
  {
    Logging.e("WebRtcAudioTrackExternal", "Start playout error: " + paramAudioTrackStartErrorCode + ". " + paramString);
    WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
    if (this.errorCallback != null)
      this.errorCallback.onWebRtcAudioTrackStartError(paramAudioTrackStartErrorCode, paramString);
  }

  @CalledByNative
  private boolean setStreamVolume(int paramInt)
  {
    this.threadChecker.checkIsOnValidThread();
    Logging.d("WebRtcAudioTrackExternal", "setStreamVolume(" + paramInt + ")");
    if (isVolumeFixed())
    {
      Logging.e("WebRtcAudioTrackExternal", "The device implements a fixed volume policy.");
      return false;
    }
    this.audioManager.setStreamVolume(0, paramInt, 0);
    return true;
  }

  @CalledByNative
  private boolean startPlayout()
  {
    this.threadChecker.checkIsOnValidThread();
    this.volumeLogger.start();
    Logging.d("WebRtcAudioTrackExternal", "startPlayout");
    boolean bool1;
    if (this.audioTrack != null)
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
        this.audioTrack.play();
        if (this.audioTrack.getPlayState() != 3)
        {
          reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
          releaseAudioResources();
          return false;
          bool1 = false;
          continue;
          bool2 = false;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION, "AudioTrack.play failed: " + localIllegalStateException.getMessage());
        releaseAudioResources();
        return false;
      }
    }
    this.audioThread = new AudioTrackThread("AudioTrackJavaThread");
    this.audioThread.start();
    return true;
  }

  @CalledByNative
  private boolean stopPlayout()
  {
    this.threadChecker.checkIsOnValidThread();
    this.volumeLogger.stop();
    Logging.d("WebRtcAudioTrackExternal", "stopPlayout");
    if (this.audioThread != null);
    for (boolean bool = true; ; bool = false)
    {
      assertTrue(bool);
      logUnderrunCount();
      this.audioThread.stopThread();
      Logging.d("WebRtcAudioTrackExternal", "Stopping the AudioTrackThread...");
      this.audioThread.interrupt();
      if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L))
      {
        Logging.e("WebRtcAudioTrackExternal", "Join of AudioTrackThread timed out.");
        WebRtcAudioUtils.logAudioState("WebRtcAudioTrackExternal", this.context, this.audioManager);
      }
      Logging.d("WebRtcAudioTrackExternal", "AudioTrackThread has now been stopped.");
      this.audioThread = null;
      releaseAudioResources();
      return true;
    }
  }

  @CalledByNative
  public void setNativeAudioTrack(long paramLong)
  {
    this.nativeAudioTrack = paramLong;
  }

  public void setSpeakerMute(boolean paramBoolean)
  {
    Logging.w("WebRtcAudioTrackExternal", "setSpeakerMute(" + paramBoolean + ")");
    this.speakerMute = paramBoolean;
  }

  private class AudioTrackThread extends Thread
  {
    private volatile boolean keepAlive = true;

    public AudioTrackThread(String arg2)
    {
      super();
    }

    @TargetApi(21)
    private int writeOnLollipop(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
    {
      return paramAudioTrack.write(paramByteBuffer, paramInt, 0);
    }

    private int writePreLollipop(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
    {
      return paramAudioTrack.write(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramInt);
    }

    public void run()
    {
      Process.setThreadPriority(-19);
      Logging.d("WebRtcAudioTrackExternal", "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
      boolean bool1;
      int i;
      label62: boolean bool2;
      if (WebRtcAudioTrack.this.audioTrack.getPlayState() == 3)
      {
        bool1 = true;
        WebRtcAudioTrack.assertTrue(bool1);
        i = WebRtcAudioTrack.this.byteBuffer.capacity();
        if (!this.keepAlive)
          break label297;
        WebRtcAudioTrack.nativeGetPlayoutData(WebRtcAudioTrack.this.nativeAudioTrack, i);
        if (i > WebRtcAudioTrack.this.byteBuffer.remaining())
          break label267;
        bool2 = true;
        label97: WebRtcAudioTrack.assertTrue(bool2);
        if (WebRtcAudioTrack.this.speakerMute)
        {
          WebRtcAudioTrack.this.byteBuffer.clear();
          WebRtcAudioTrack.this.byteBuffer.put(WebRtcAudioTrack.this.emptyBytes);
          WebRtcAudioTrack.this.byteBuffer.position(0);
        }
        if (!WebRtcAudioUtils.runningOnLollipopOrHigher())
          break label273;
      }
      label267: label273: for (int j = writeOnLollipop(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, i); ; j = writePreLollipop(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, i))
      {
        if (j != i)
        {
          Logging.e("WebRtcAudioTrackExternal", "AudioTrack.write played invalid number of bytes: " + j);
          if (j < 0)
          {
            this.keepAlive = false;
            WebRtcAudioTrack.this.reportWebRtcAudioTrackError("AudioTrack.write failed: " + j);
          }
        }
        WebRtcAudioTrack.this.byteBuffer.rewind();
        break label62;
        bool1 = false;
        break;
        bool2 = false;
        break label97;
      }
      label297: if (WebRtcAudioTrack.this.audioTrack != null)
        Logging.d("WebRtcAudioTrackExternal", "Calling AudioTrack.stop...");
      try
      {
        WebRtcAudioTrack.this.audioTrack.stop();
        Logging.d("WebRtcAudioTrackExternal", "AudioTrack.stop is done.");
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logging.e("WebRtcAudioTrackExternal", "AudioTrack.stop failed: " + localIllegalStateException.getMessage());
      }
    }

    public void stopThread()
    {
      Logging.d("WebRtcAudioTrackExternal", "stopThread");
      this.keepAlive = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.WebRtcAudioTrack
 * JD-Core Version:    0.6.2
 */