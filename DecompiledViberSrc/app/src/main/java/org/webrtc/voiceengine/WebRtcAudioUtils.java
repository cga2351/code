package org.webrtc.voiceengine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;

public final class WebRtcAudioUtils
{
  private static final String[] BLACKLISTED_AEC_MODELS = new String[0];
  private static final String[] BLACKLISTED_NS_MODELS = new String[0];
  private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
  private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
  private static final String TAG = "WebRtcAudioUtils";
  private static int defaultSampleRateHz = 16000;
  private static boolean isDefaultSampleRateOverridden = false;
  private static boolean useWebRtcBasedAcousticEchoCanceler = false;
  private static boolean useWebRtcBasedNoiseSuppressor = false;

  public static boolean deviceIsBlacklistedForOpenSLESUsage()
  {
    return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
  }

  private static String deviceTypeToString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "TYPE_UNKNOWN";
    case 0:
      return "TYPE_UNKNOWN";
    case 1:
      return "TYPE_BUILTIN_EARPIECE";
    case 2:
      return "TYPE_BUILTIN_SPEAKER";
    case 3:
      return "TYPE_WIRED_HEADSET";
    case 4:
      return "TYPE_WIRED_HEADPHONES";
    case 5:
      return "TYPE_LINE_ANALOG";
    case 6:
      return "TYPE_LINE_DIGITAL";
    case 7:
      return "TYPE_BLUETOOTH_SCO";
    case 8:
      return "TYPE_BLUETOOTH_A2DP";
    case 9:
      return "TYPE_HDMI";
    case 10:
      return "TYPE_HDMI_ARC";
    case 11:
      return "TYPE_USB_DEVICE";
    case 12:
      return "TYPE_USB_ACCESSORY";
    case 13:
      return "TYPE_DOCK";
    case 14:
      return "TYPE_FM";
    case 15:
      return "TYPE_BUILTIN_MIC";
    case 16:
      return "TYPE_FM_TUNER";
    case 17:
      return "TYPE_TV_TUNER";
    case 18:
      return "TYPE_TELEPHONY";
    case 19:
      return "TYPE_AUX_LINE";
    case 20:
      return "TYPE_IP";
    case 21:
      return "TYPE_BUS";
    case 22:
    }
    return "TYPE_USB_HEADSET";
  }

  public static List<String> getBlackListedModelsForAecUsage()
  {
    return Arrays.asList(BLACKLISTED_AEC_MODELS);
  }

  public static List<String> getBlackListedModelsForNsUsage()
  {
    return Arrays.asList(BLACKLISTED_NS_MODELS);
  }

  public static int getDefaultSampleRateHz()
  {
    try
    {
      int i = defaultSampleRateHz;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static String getThreadInfo()
  {
    return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
  }

  private static boolean hasMicrophone()
  {
    return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
  }

  public static boolean isAcousticEchoCancelerSupported()
  {
    return WebRtcAudioEffects.canUseAcousticEchoCanceler();
  }

  public static boolean isAutomaticGainControlSupported()
  {
    return false;
  }

  public static boolean isDefaultSampleRateOverridden()
  {
    try
    {
      boolean bool = isDefaultSampleRateOverridden;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean isNoiseSuppressorSupported()
  {
    return WebRtcAudioEffects.canUseNoiseSuppressor();
  }

  @TargetApi(23)
  private static void logAudioDeviceInfo(String paramString, AudioManager paramAudioManager)
  {
    if (!runningOnMarshmallowOrHigher());
    AudioDeviceInfo[] arrayOfAudioDeviceInfo;
    do
    {
      return;
      arrayOfAudioDeviceInfo = paramAudioManager.getDevices(3);
    }
    while (arrayOfAudioDeviceInfo.length == 0);
    Logging.d(paramString, "Audio Devices: ");
    int i = arrayOfAudioDeviceInfo.length;
    int j = 0;
    label30: AudioDeviceInfo localAudioDeviceInfo;
    StringBuilder localStringBuilder;
    if (j < i)
    {
      localAudioDeviceInfo = arrayOfAudioDeviceInfo[j];
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  ").append(deviceTypeToString(localAudioDeviceInfo.getType()));
      if (!localAudioDeviceInfo.isSource())
        break label229;
    }
    label229: for (String str = "(in): "; ; str = "(out): ")
    {
      localStringBuilder.append(str);
      if (localAudioDeviceInfo.getChannelCounts().length > 0)
      {
        localStringBuilder.append("channels=").append(Arrays.toString(localAudioDeviceInfo.getChannelCounts()));
        localStringBuilder.append(", ");
      }
      if (localAudioDeviceInfo.getEncodings().length > 0)
      {
        localStringBuilder.append("encodings=").append(Arrays.toString(localAudioDeviceInfo.getEncodings()));
        localStringBuilder.append(", ");
      }
      if (localAudioDeviceInfo.getSampleRates().length > 0)
      {
        localStringBuilder.append("sample rates=").append(Arrays.toString(localAudioDeviceInfo.getSampleRates()));
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id=").append(localAudioDeviceInfo.getId());
      Logging.d(paramString, localStringBuilder.toString());
      j++;
      break label30;
      break;
    }
  }

  static void logAudioState(String paramString)
  {
    logDeviceInfo(paramString);
    AudioManager localAudioManager = (AudioManager)ContextUtils.getApplicationContext().getSystemService("audio");
    logAudioStateBasic(paramString, localAudioManager);
    logAudioStateVolume(paramString, localAudioManager);
    logAudioDeviceInfo(paramString, localAudioManager);
  }

  private static void logAudioStateBasic(String paramString, AudioManager paramAudioManager)
  {
    Logging.d(paramString, "Audio State: audio mode: " + modeToString(paramAudioManager.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + paramAudioManager.isMicrophoneMute() + ", music active: " + paramAudioManager.isMusicActive() + ", speakerphone: " + paramAudioManager.isSpeakerphoneOn() + ", BT SCO: " + paramAudioManager.isBluetoothScoOn());
  }

  @SuppressLint({"NewApi"})
  private static void logAudioStateVolume(String paramString, AudioManager paramAudioManager)
  {
    int i = 0;
    int[] arrayOfInt = { 0, 3, 2, 4, 5, 1 };
    Logging.d(paramString, "Audio State: ");
    boolean bool;
    if (runningOnLollipopOrHigher())
    {
      bool = paramAudioManager.isVolumeFixed();
      Logging.d(paramString, "  fixed volume=" + bool);
    }
    while (true)
    {
      if (!bool)
      {
        int j = arrayOfInt.length;
        while (i < j)
        {
          int k = arrayOfInt[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("  " + streamTypeToString(k) + ": ");
          localStringBuilder.append("volume=").append(paramAudioManager.getStreamVolume(k));
          localStringBuilder.append(", max=").append(paramAudioManager.getStreamMaxVolume(k));
          logIsStreamMute(paramString, paramAudioManager, k, localStringBuilder);
          Logging.d(paramString, localStringBuilder.toString());
          i++;
        }
      }
      return;
      bool = false;
    }
  }

  static void logDeviceInfo(String paramString)
  {
    Logging.d(paramString, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
  }

  @TargetApi(23)
  private static void logIsStreamMute(String paramString, AudioManager paramAudioManager, int paramInt, StringBuilder paramStringBuilder)
  {
    if (runningOnMarshmallowOrHigher())
      paramStringBuilder.append(", muted=").append(paramAudioManager.isStreamMute(paramInt));
  }

  static String modeToString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "MODE_INVALID";
    case 2:
      return "MODE_IN_CALL";
    case 3:
      return "MODE_IN_COMMUNICATION";
    case 0:
      return "MODE_NORMAL";
    case 1:
    }
    return "MODE_RINGTONE";
  }

  public static boolean runningOnEmulator()
  {
    return (Build.HARDWARE.equals("goldfish")) && (Build.BRAND.startsWith("generic_"));
  }

  public static boolean runningOnJellyBeanMR1OrHigher()
  {
    return Build.VERSION.SDK_INT >= 17;
  }

  public static boolean runningOnJellyBeanMR2OrHigher()
  {
    return Build.VERSION.SDK_INT >= 18;
  }

  public static boolean runningOnLollipopOrHigher()
  {
    return Build.VERSION.SDK_INT >= 21;
  }

  public static boolean runningOnMarshmallowOrHigher()
  {
    return Build.VERSION.SDK_INT >= 23;
  }

  public static boolean runningOnNougatOrHigher()
  {
    return Build.VERSION.SDK_INT >= 24;
  }

  public static boolean runningOnOreoMR1OrHigher()
  {
    return Build.VERSION.SDK_INT >= 27;
  }

  public static boolean runningOnOreoOrHigher()
  {
    return Build.VERSION.SDK_INT >= 26;
  }

  public static void setDefaultSampleRateHz(int paramInt)
  {
    try
    {
      isDefaultSampleRateOverridden = true;
      defaultSampleRateHz = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void setWebRtcBasedAcousticEchoCanceler(boolean paramBoolean)
  {
    try
    {
      useWebRtcBasedAcousticEchoCanceler = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void setWebRtcBasedAutomaticGainControl(boolean paramBoolean)
  {
    try
    {
      Logging.w("WebRtcAudioUtils", "setWebRtcBasedAutomaticGainControl() is deprecated");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void setWebRtcBasedNoiseSuppressor(boolean paramBoolean)
  {
    try
    {
      useWebRtcBasedNoiseSuppressor = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static String streamTypeToString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "STREAM_INVALID";
    case 0:
      return "STREAM_VOICE_CALL";
    case 3:
      return "STREAM_MUSIC";
    case 2:
      return "STREAM_RING";
    case 4:
      return "STREAM_ALARM";
    case 5:
      return "STREAM_NOTIFICATION";
    case 1:
    }
    return "STREAM_SYSTEM";
  }

  public static boolean useWebRtcBasedAcousticEchoCanceler()
  {
    try
    {
      if (useWebRtcBasedAcousticEchoCanceler)
        Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC AEC!");
      boolean bool = useWebRtcBasedAcousticEchoCanceler;
      return bool;
    }
    finally
    {
    }
  }

  public static boolean useWebRtcBasedAutomaticGainControl()
  {
    return true;
  }

  public static boolean useWebRtcBasedNoiseSuppressor()
  {
    try
    {
      if (useWebRtcBasedNoiseSuppressor)
        Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC NS!");
      boolean bool = useWebRtcBasedNoiseSuppressor;
      return bool;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioUtils
 * JD-Core Version:    0.6.2
 */