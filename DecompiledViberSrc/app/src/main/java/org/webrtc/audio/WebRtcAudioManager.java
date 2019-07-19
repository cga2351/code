package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;

class WebRtcAudioManager
{
  private static final int BITS_PER_SAMPLE = 16;
  private static final int DEFAULT_FRAME_PER_BUFFER = 256;
  private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
  private static final String TAG = "WebRtcAudioManagerExternal";

  @CalledByNative
  static AudioManager getAudioManager(Context paramContext)
  {
    return (AudioManager)paramContext.getSystemService("audio");
  }

  @CalledByNative
  static int getInputBufferSize(Context paramContext, AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    if (isLowLatencyInputSupported(paramContext))
      return getLowLatencyFramesPerBuffer(paramAudioManager);
    return getMinInputFrameSize(paramInt1, paramInt2);
  }

  @TargetApi(17)
  private static int getLowLatencyFramesPerBuffer(AudioManager paramAudioManager)
  {
    if (!WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher());
    String str;
    do
    {
      return 256;
      str = paramAudioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
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

  @CalledByNative
  static int getOutputBufferSize(Context paramContext, AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    if (isLowLatencyOutputSupported(paramContext))
      return getLowLatencyFramesPerBuffer(paramAudioManager);
    return getMinOutputFrameSize(paramInt1, paramInt2);
  }

  @CalledByNative
  static int getSampleRate(AudioManager paramAudioManager)
  {
    if (WebRtcAudioUtils.runningOnEmulator())
    {
      Logging.d("WebRtcAudioManagerExternal", "Running emulator, overriding sample rate to 8 kHz.");
      return 8000;
    }
    if (WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher());
    for (int i = getSampleRateOnJellyBeanMR10OrHigher(paramAudioManager); ; i = 16000)
    {
      Logging.d("WebRtcAudioManagerExternal", "Sample rate is set to " + i + " Hz");
      return i;
    }
  }

  @TargetApi(17)
  private static int getSampleRateOnJellyBeanMR10OrHigher(AudioManager paramAudioManager)
  {
    String str = paramAudioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
    if (str == null)
      return 16000;
    return Integer.parseInt(str);
  }

  private static boolean isLowLatencyInputSupported(Context paramContext)
  {
    return (WebRtcAudioUtils.runningOnLollipopOrHigher()) && (isLowLatencyOutputSupported(paramContext));
  }

  private static boolean isLowLatencyOutputSupported(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.WebRtcAudioManager
 * JD-Core Version:    0.6.2
 */