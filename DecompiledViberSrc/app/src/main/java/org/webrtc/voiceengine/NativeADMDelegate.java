package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.SoundFactory;
import com.viber.voip.sound.bluetooth.BtControl;
import com.viber.voip.sound.config.SoundConfig;
import java.util.HashSet;
import java.util.Set;
import org.webrtc.videoengine.ViENative;

public class NativeADMDelegate
{
  static final int AUDIOROUTE_PLAYBACK = 1;
  static final int AUDIOROUTE_PLAYBACK_AND_RECORDING = 3;
  static final int AUDIOROUTE_RECORDING = 2;
  static final int AUDIOROUTE_VOIP = 0;
  static final int DELEGATE_FAIL = -1;
  static final int DELEGATE_INTERCEPT = 1;
  static final int DELEGATE_OK = 0;
  public static final boolean ENABLE_PLATFORMWIDE_AEC = true;
  public static final boolean ENABLE_PLATFORMWIDE_AGC = true;
  public static final boolean ENABLE_PLATFORMWIDE_NS = true;
  public static final boolean ENABLE_SW_AEC_FALLBACK = true;
  public static final boolean ENABLE_SW_AGC_FALLBACK = true;
  public static final boolean ENABLE_SW_NS_FALLBACK = true;
  private static final Logger L = ViberEnv.getLogger();
  private static final int PLAYBACK_THREAD_PRIORITY = -8;
  private static final int RECORDER_THREAD_PRIORITY = -8;
  private static final boolean USE_AUDIOROUTING_API = false;
  private static final boolean USE_PRIORITY_BOOST = true;
  private static final boolean USE_RS_VOICE_COMMUNICATION_ROUTE_BLACKLIST = true;
  private static final boolean USE_RS_VOICE_COMMUNICATION_ROUTE_WHITELIST;
  private static Boolean isPlatformWideAECEffectAvailable;
  private static Boolean isPlatformWideAGCEffectAvailable;
  private static Boolean isPlatformWideNSEffectAvailable;
  private static Set<String> recordBugDeviceBlacklist = new HashSet();
  private static Set<String> voiceCommunicationRouteDeviceBlacklist;
  private static Set<String> voiceCommunicationRouteDeviceWhitelist = new HashSet();
  private static Set<String> voiceCommunicationRouteVendorBlacklist;
  private static Set<String> voiceCommunicationRouteVendorWhitelist = new HashSet();
  private volatile int _audioRoute = 0;

  static
  {
    voiceCommunicationRouteDeviceBlacklist = new HashSet();
    voiceCommunicationRouteVendorBlacklist = new HashSet();
    recordBugDeviceBlacklist.add("golfu");
    recordBugDeviceBlacklist.add("vision");
    recordBugDeviceBlacklist.add("GT-I9000");
    recordBugDeviceBlacklist.add("GT-S5570");
    recordBugDeviceBlacklist.add("GT-S5300");
    recordBugDeviceBlacklist.add("vee3e");
    recordBugDeviceBlacklist.add("jflte");
    recordBugDeviceBlacklist.add("LT22i");
    voiceCommunicationRouteVendorWhitelist.add("htc".toLowerCase());
    voiceCommunicationRouteVendorWhitelist.add("samsung".toLowerCase());
    voiceCommunicationRouteVendorWhitelist.add("sony ericsson".toLowerCase());
    voiceCommunicationRouteVendorWhitelist.add("asus".toLowerCase());
    voiceCommunicationRouteDeviceWhitelist.add("lt26i".toLowerCase());
    voiceCommunicationRouteDeviceWhitelist.add("grouper".toLowerCase());
    voiceCommunicationRouteVendorBlacklist.add("huawei".toLowerCase());
    voiceCommunicationRouteVendorBlacklist.add("lenovo".toLowerCase());
    voiceCommunicationRouteVendorBlacklist.add("asus".toLowerCase());
    voiceCommunicationRouteVendorBlacklist.add("htc".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("hwG510".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("D01E".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("golfu".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("vee3e".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("ASUS_T00J".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("ASUS_T00J1".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("ASUS_T00F".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("ASUS_T00F1".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("ASUS_T00K".toLowerCase());
    voiceCommunicationRouteDeviceBlacklist.add("ASUS_T00P".toLowerCase());
  }

  @TargetApi(16)
  private static boolean isPlatformAECAvailable_JBAndUpper()
  {
    return AcousticEchoCanceler.isAvailable();
  }

  @TargetApi(16)
  private static boolean isPlatformAGCAvailable_JBAndUpper()
  {
    return AutomaticGainControl.isAvailable();
  }

  @TargetApi(16)
  private static boolean isPlatformNSAvailable_JBAndUpper()
  {
    return NoiseSuppressor.isAvailable();
  }

  public static boolean isPlatformWideAECEffectAvailable()
  {
    if (isPlatformWideAECEffectAvailable == null)
    {
      if (16 <= Build.VERSION.SDK_INT)
        break label28;
      isPlatformWideAECEffectAvailable = Boolean.valueOf(false);
    }
    while (true)
    {
      return isPlatformWideAECEffectAvailable.booleanValue();
      try
      {
        label28: isPlatformWideAECEffectAvailable = Boolean.valueOf(isPlatformAECAvailable_JBAndUpper());
      }
      catch (Throwable localThrowable)
      {
        isPlatformWideAECEffectAvailable = Boolean.valueOf(false);
      }
    }
  }

  public static boolean isPlatformWideAGCEffectAvailable()
  {
    if (isPlatformWideAGCEffectAvailable == null)
    {
      if (16 <= Build.VERSION.SDK_INT)
        break label28;
      isPlatformWideAGCEffectAvailable = Boolean.valueOf(false);
    }
    while (true)
    {
      return isPlatformWideAGCEffectAvailable.booleanValue();
      try
      {
        label28: isPlatformWideAGCEffectAvailable = Boolean.valueOf(isPlatformAGCAvailable_JBAndUpper());
      }
      catch (Throwable localThrowable)
      {
        isPlatformWideAGCEffectAvailable = Boolean.valueOf(false);
      }
    }
  }

  public static boolean isPlatformWideNSEffectAvailable()
  {
    if (isPlatformWideNSEffectAvailable == null)
    {
      if (16 <= Build.VERSION.SDK_INT)
        break label28;
      isPlatformWideNSEffectAvailable = Boolean.valueOf(false);
    }
    while (true)
    {
      return isPlatformWideNSEffectAvailable.booleanValue();
      try
      {
        label28: isPlatformWideNSEffectAvailable = Boolean.valueOf(isPlatformNSAvailable_JBAndUpper());
      }
      catch (Throwable localThrowable)
      {
        isPlatformWideNSEffectAvailable = Boolean.valueOf(false);
      }
    }
  }

  static int isVoiceCommRouteAvailable(int paramInt1, int paramInt2)
  {
    if (11 > Build.VERSION.SDK_INT);
    while ((voiceCommunicationRouteVendorBlacklist.contains(Build.MANUFACTURER.toLowerCase())) || (voiceCommunicationRouteDeviceBlacklist.contains(Build.DEVICE.toLowerCase())))
      return 1;
    return 0;
  }

  @ViENative
  int CheckDeviceVoiceCommunicationAbility(int paramInt1, int paramInt2)
  {
    return isVoiceCommRouteAvailable(paramInt1, paramInt2);
  }

  int GetStreamMaxVolume(int paramInt)
  {
    return 0;
  }

  int OnAGC()
  {
    return -1;
  }

  int OnCreate()
  {
    return OnCreate(0);
  }

  int OnCreate(int paramInt)
  {
    this._audioRoute = paramInt;
    if (((2 == this._audioRoute) || (3 == this._audioRoute)) && (recordBugDeviceBlacklist.contains(Build.DEVICE)))
      return -1;
    SoundFactory.getSoundService(ViberApplication.getApplication());
    if ((this._audioRoute != 0) && (2 == this._audioRoute));
    return 0;
  }

  int OnDestroy()
  {
    if ((this._audioRoute == 0) || (2 == this._audioRoute))
      SoundFactory.getSoundService(ViberApplication.getApplication());
    return 0;
  }

  int OnGetMicrophoneMute()
  {
    return -1;
  }

  int OnGetSpeakerMute()
  {
    return -1;
  }

  int OnGetSpeakerVolume()
  {
    return -1;
  }

  int OnInitPlayback(int paramInt1, int paramInt2)
  {
    return 0;
  }

  int OnInitRecording(int paramInt1, int paramInt2)
  {
    return 0;
  }

  int OnProbePlayback(int paramInt1, int paramInt2)
  {
    return 0;
  }

  int OnProbeRecording(int paramInt1, int paramInt2)
  {
    return 0;
  }

  int OnSetAGC(boolean paramBoolean)
  {
    return 0;
  }

  int OnSetLoudspeakerState(boolean paramBoolean)
  {
    ISoundService localISoundService = SoundFactory.getSoundService(ViberApplication.getApplication());
    AudioManager localAudioManager = localISoundService.getPlatformAudioManager();
    BtControl localBtControl = localISoundService.getBluetoothCtl();
    if ((this._audioRoute != 0) && ((localISoundService.isHeadsetPluggedIn()) || (localAudioManager.isBluetoothA2dpOn())));
    while (true)
    {
      return 0;
      if ((this._audioRoute != 0) && (localBtControl.isHeadsetConnected()))
      {
        if (paramBoolean)
        {
          localBtControl.enableBluetoothRoute();
          localISoundService.setMode(localISoundService.mode_bluetooth());
        }
        else
        {
          localISoundService.setMode(localISoundService.mode_default());
          localBtControl.disableBluetoothRoute();
        }
      }
      else if (localAudioManager.isSpeakerphoneOn() != paramBoolean)
      {
        if (paramBoolean)
          localBtControl.disableBluetoothRoute();
        localAudioManager.setSpeakerphoneOn(paramBoolean);
        if (!paramBoolean)
          localBtControl.enableBluetoothRoute();
      }
    }
  }

  int OnSetMicrophoneMute(boolean paramBoolean)
  {
    return 0;
  }

  int OnSetSpeakerMute(boolean paramBoolean)
  {
    return 0;
  }

  int OnSetSpeakerVolume(int paramInt)
  {
    return 0;
  }

  int OnStartPlayback()
  {
    if (SoundFactory.getSoundService(ViberApplication.getApplication()).getSoundConfig().useThreadPriorityBoost())
      setCurrentThreadPriority(-8);
    return 0;
  }

  int OnStartRecording()
  {
    if (SoundFactory.getSoundService(ViberApplication.getApplication()).getSoundConfig().useThreadPriorityBoost())
      setCurrentThreadPriority(-8);
    return 0;
  }

  int OnStopPlayback()
  {
    ISoundService localISoundService = SoundFactory.getSoundService(ViberApplication.getApplication());
    if (localISoundService.getSoundConfig().useThreadPriorityBoost())
      setCurrentThreadPriority(localISoundService.getSoundConfig().getUiThreadPriority());
    return 0;
  }

  int OnStopRecording()
  {
    ISoundService localISoundService = SoundFactory.getSoundService(ViberApplication.getApplication());
    if (localISoundService.getSoundConfig().useThreadPriorityBoost())
      setCurrentThreadPriority(localISoundService.getSoundConfig().getUiThreadPriority());
    return 0;
  }

  int PlaybackWarning(int paramInt1, int paramInt2)
  {
    return 0;
  }

  int RecordWarning(int paramInt1, int paramInt2)
  {
    return 0;
  }

  void setCurrentThreadPriority(int paramInt)
  {
    try
    {
      Process.setThreadPriority(paramInt);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.NativeADMDelegate
 * JD-Core Version:    0.6.2
 */