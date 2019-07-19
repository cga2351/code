package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;

public class WebRtcAudioManager
{
  private static final int BITS_PER_SAMPLE = 16;
  private static final boolean DEBUG = false;
  private static final int DEFAULT_FRAME_PER_BUFFER = 256;
  private static final String TAG = "WebRtcAudioManager";
  private static final boolean blacklistDeviceForAAudioUsage = true;
  private static boolean blacklistDeviceForOpenSLESUsage = false;
  private static boolean blacklistDeviceForOpenSLESUsageIsOverridden = false;
  private static boolean useStereoInput;
  private static boolean useStereoOutput = false;
  private boolean aAudio;
  private final AudioManager audioManager;
  private boolean hardwareAEC;
  private boolean hardwareAGC;
  private boolean hardwareNS;
  private boolean initialized = false;
  private int inputBufferSize;
  private int inputChannels;
  private boolean lowLatencyInput;
  private boolean lowLatencyOutput;
  private final long nativeAudioManager;
  private int nativeChannels;
  private int nativeSampleRate;
  private int outputBufferSize;
  private int outputChannels;
  private boolean proAudio;
  private int sampleRate;
  private final VolumeLogger volumeLogger;

  static
  {
    useStereoInput = false;
  }

  WebRtcAudioManager(long paramLong)
  {
    Logging.d("WebRtcAudioManager", "ctor" + WebRtcAudioUtils.getThreadInfo());
    this.nativeAudioManager = paramLong;
    this.audioManager = ((AudioManager)ContextUtils.getApplicationContext().getSystemService("audio"));
    this.volumeLogger = new VolumeLogger(this.audioManager);
    storeAudioParameters();
    nativeCacheAudioParameters(this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, paramLong);
    WebRtcAudioUtils.logAudioState("WebRtcAudioManager");
  }

  private static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new AssertionError("Expected condition to be true");
  }

  private void dispose()
  {
    Logging.d("WebRtcAudioManager", "dispose" + WebRtcAudioUtils.getThreadInfo());
    if (!this.initialized)
      return;
    this.volumeLogger.stop();
  }

  private int getLowLatencyInputFramesPerBuffer()
  {
    assertTrue(isLowLatencyInputSupported());
    return getLowLatencyOutputFramesPerBuffer();
  }

  @TargetApi(17)
  private int getLowLatencyOutputFramesPerBuffer()
  {
    assertTrue(isLowLatencyOutputSupported());
    if (!WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher());
    String str;
    do
    {
      return 256;
      str = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
    }
    while (str == null);
    return Integer.parseInt(str);
  }

  private static int getMinInputFrameSize(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * 2;
    if (paramInt2 == 1);
    for (int j = 16; ; j = 12)
      return AudioRecord.getMinBufferSize(paramInt1, j, 2) / i;
  }

  private static int getMinOutputFrameSize(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * 2;
    if (paramInt2 == 1);
    for (int j = 4; ; j = 12)
      return AudioTrack.getMinBufferSize(paramInt1, j, 2) / i;
  }

  private int getNativeOutputSampleRate()
  {
    if (WebRtcAudioUtils.runningOnEmulator())
    {
      Logging.d("WebRtcAudioManager", "Running emulator, overriding sample rate to 8 kHz.");
      return 8000;
    }
    if (WebRtcAudioUtils.isDefaultSampleRateOverridden())
    {
      Logging.d("WebRtcAudioManager", "Default sample rate is overriden to " + WebRtcAudioUtils.getDefaultSampleRateHz() + " Hz");
      return WebRtcAudioUtils.getDefaultSampleRateHz();
    }
    if (WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher());
    for (int i = getSampleRateOnJellyBeanMR10OrHigher(); ; i = WebRtcAudioUtils.getDefaultSampleRateHz())
    {
      Logging.d("WebRtcAudioManager", "Sample rate is set to " + i + " Hz");
      return i;
    }
  }

  @TargetApi(17)
  private int getSampleRateOnJellyBeanMR10OrHigher()
  {
    String str = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
    if (str == null)
      return WebRtcAudioUtils.getDefaultSampleRateHz();
    return Integer.parseInt(str);
  }

  public static boolean getStereoInput()
  {
    try
    {
      boolean bool = useStereoInput;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean getStereoOutput()
  {
    try
    {
      boolean bool = useStereoOutput;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean hasEarpiece()
  {
    return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
  }

  private boolean init()
  {
    Logging.d("WebRtcAudioManager", "init" + WebRtcAudioUtils.getThreadInfo());
    if (this.initialized)
      return true;
    Logging.d("WebRtcAudioManager", "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
    this.initialized = true;
    this.volumeLogger.start();
    return true;
  }

  private boolean isAAudioSupported()
  {
    Logging.w("WebRtcAudioManager", "AAudio support is currently disabled on all devices!");
    return false;
  }

  private static boolean isAcousticEchoCancelerSupported()
  {
    return WebRtcAudioEffects.canUseAcousticEchoCanceler();
  }

  private boolean isCommunicationModeEnabled()
  {
    return this.audioManager.getMode() == 3;
  }

  private boolean isDeviceBlacklistedForOpenSLESUsage()
  {
    if (blacklistDeviceForOpenSLESUsageIsOverridden);
    for (boolean bool = blacklistDeviceForOpenSLESUsage; ; bool = WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage())
    {
      if (bool)
        Logging.d("WebRtcAudioManager", Build.MODEL + " is blacklisted for OpenSL ES usage!");
      return bool;
    }
  }

  private boolean isLowLatencyOutputSupported()
  {
    return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
  }

  private static boolean isNoiseSuppressorSupported()
  {
    return WebRtcAudioEffects.canUseNoiseSuppressor();
  }

  @TargetApi(23)
  private boolean isProAudioSupported()
  {
    return (WebRtcAudioUtils.runningOnMarshmallowOrHigher()) && (ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro"));
  }

  private native void nativeCacheAudioParameters(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt4, int paramInt5, long paramLong);

  public static void setBlacklistDeviceForOpenSLESUsage(boolean paramBoolean)
  {
    try
    {
      blacklistDeviceForOpenSLESUsageIsOverridden = true;
      blacklistDeviceForOpenSLESUsage = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void setStereoInput(boolean paramBoolean)
  {
    try
    {
      Logging.w("WebRtcAudioManager", "Overriding default input behavior: setStereoInput(" + paramBoolean + ')');
      useStereoInput = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void setStereoOutput(boolean paramBoolean)
  {
    try
    {
      Logging.w("WebRtcAudioManager", "Overriding default output behavior: setStereoOutput(" + paramBoolean + ')');
      useStereoOutput = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void storeAudioParameters()
  {
    int i = 2;
    int j;
    label21: int k;
    if (getStereoOutput())
    {
      j = i;
      this.outputChannels = j;
      if (!getStereoInput())
        break label127;
      this.inputChannels = i;
      this.sampleRate = getNativeOutputSampleRate();
      this.hardwareAEC = isAcousticEchoCancelerSupported();
      this.hardwareAGC = false;
      this.hardwareNS = isNoiseSuppressorSupported();
      this.lowLatencyOutput = isLowLatencyOutputSupported();
      this.lowLatencyInput = isLowLatencyInputSupported();
      this.proAudio = isProAudioSupported();
      this.aAudio = isAAudioSupported();
      if (!this.lowLatencyOutput)
        break label132;
      k = getLowLatencyOutputFramesPerBuffer();
      label97: this.outputBufferSize = k;
      if (!this.lowLatencyInput)
        break label147;
    }
    label132: label147: for (int m = getLowLatencyInputFramesPerBuffer(); ; m = getMinInputFrameSize(this.sampleRate, this.inputChannels))
    {
      this.inputBufferSize = m;
      return;
      j = 1;
      break;
      label127: i = 1;
      break label21;
      k = getMinOutputFrameSize(this.sampleRate, this.outputChannels);
      break label97;
    }
  }

  public boolean isLowLatencyInputSupported()
  {
    return (WebRtcAudioUtils.runningOnLollipopOrHigher()) && (isLowLatencyOutputSupported());
  }

  private static class VolumeLogger
  {
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;

    @Nullable
    private Timer timer;

    public VolumeLogger(AudioManager paramAudioManager)
    {
      this.audioManager = paramAudioManager;
    }

    private void stop()
    {
      if (this.timer != null)
      {
        this.timer.cancel();
        this.timer = null;
      }
    }

    public void start()
    {
      this.timer = new Timer("WebRtcVolumeLevelLoggerThread");
      this.timer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
    }

    private class LogVolumeTask extends TimerTask
    {
      private final int maxRingVolume;
      private final int maxVoiceCallVolume;

      LogVolumeTask(int paramInt1, int arg3)
      {
        this.maxRingVolume = paramInt1;
        int i;
        this.maxVoiceCallVolume = i;
      }

      public void run()
      {
        int i = WebRtcAudioManager.VolumeLogger.this.audioManager.getMode();
        if (i == 1)
          Logging.d("WebRtcAudioManager", "STREAM_RING stream volume: " + WebRtcAudioManager.VolumeLogger.this.audioManager.getStreamVolume(2) + " (max=" + this.maxRingVolume + ")");
        while (i != 3)
          return;
        Logging.d("WebRtcAudioManager", "VOICE_CALL stream volume: " + WebRtcAudioManager.VolumeLogger.this.audioManager.getStreamVolume(0) + " (max=" + this.maxVoiceCallVolume + ")");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioManager
 * JD-Core Version:    0.6.2
 */