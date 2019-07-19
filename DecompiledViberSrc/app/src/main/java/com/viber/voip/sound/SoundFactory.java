package com.viber.voip.sound;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.jni.DeviceFlagsManager;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.sound.tones.RingtonePlayer;

public class SoundFactory
{
  private static final Logger L = ViberEnv.getLogger();
  static IRingtonePlayer _ringtonePlayerInstance;
  static ISoundService _soundServiceInstance;
  private static final boolean isGalaxyS4S5;
  private static final boolean isHtcDesireC;
  private static final boolean isHtcDesireV;
  private static final boolean isLenovoYoga;
  private static final boolean isNexusS = Build.MODEL.equalsIgnoreCase("Nexus S");
  private static final boolean isZenfon5;

  static
  {
    isHtcDesireC = "golfu".equalsIgnoreCase(Build.DEVICE);
    isHtcDesireV = "primods".equalsIgnoreCase(Build.DEVICE);
    isLenovoYoga = "YT2".equalsIgnoreCase(Build.DEVICE);
    if ((Build.DEVICE != null) && (Build.DEVICE.toLowerCase().contains("ASUS_T00".toLowerCase())));
    for (boolean bool1 = true; ; bool1 = false)
    {
      isZenfon5 = bool1;
      boolean bool2;
      if ((!Build.MODEL.contains("SGH-I337")) && (!Build.MODEL.contains("SGH-I537")) && (!Build.MODEL.equalsIgnoreCase("SGH-M919")) && (!Build.MODEL.contains("GT-I919")) && (!Build.MODEL.equalsIgnoreCase("SCH-I545")) && (!Build.MODEL.equalsIgnoreCase("SM-G530H")) && (!Build.MODEL.equalsIgnoreCase("GT-I9295")) && (!Build.MODEL.equalsIgnoreCase("GT-S7275B")))
      {
        boolean bool3 = Build.MODEL.equalsIgnoreCase("GT-S7275R");
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      isGalaxyS4S5 = bool2;
      return;
    }
  }

  private static ISoundService chooseAndInitSoundService(Context paramContext)
  {
    int i = 3;
    if ((isNexusS) || (isHtcDesireC) || (isHtcDesireV) || (isLenovoYoga) || (isGalaxyS4S5) || (isZenfon5))
      i = 0;
    return new GenericSoundService(paramContext, i, DeviceFlagsManager.shouldUse16kSampleRate());
  }

  public static IRingtonePlayer getRingtonePlayer(Context paramContext)
  {
    try
    {
      if (_ringtonePlayerInstance == null)
        _ringtonePlayerInstance = new RingtonePlayer(paramContext);
      IRingtonePlayer localIRingtonePlayer = _ringtonePlayerInstance;
      return localIRingtonePlayer;
    }
    finally
    {
    }
  }

  public static ISoundService getSoundService(Context paramContext)
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if ((_soundServiceInstance == null) && (paramContext != null))
        init(paramContext.getApplicationContext());
      if (SystemClock.elapsedRealtime() - l > 100L);
      ISoundService localISoundService = _soundServiceInstance;
      return localISoundService;
    }
    finally
    {
    }
  }

  private static void init(Context paramContext)
  {
    if (_soundServiceInstance == null)
    {
      Engine localEngine = ViberApplication.getInstance().getEngine(false);
      _soundServiceInstance = chooseAndInitSoundService(paramContext);
      localEngine.registerDelegate(_soundServiceInstance);
      DialerPhoneStateListener localDialerPhoneStateListener = localEngine.getDelegatesManager().getDialerPhoneStateListener();
      DialerControllerDelegate.DialerPhoneState[] arrayOfDialerPhoneState = new DialerControllerDelegate.DialerPhoneState[1];
      arrayOfDialerPhoneState[0] = _soundServiceInstance;
      localDialerPhoneStateListener.registerDelegate(arrayOfDialerPhoneState);
      DialerLocalCallStateListener localDialerLocalCallStateListener = localEngine.getDelegatesManager().getDialerLocalCallStateListener();
      DialerControllerDelegate.DialerLocalCallState[] arrayOfDialerLocalCallState = new DialerControllerDelegate.DialerLocalCallState[1];
      arrayOfDialerLocalCallState[0] = _soundServiceInstance;
      localDialerLocalCallStateListener.registerDelegate(arrayOfDialerLocalCallState);
    }
  }

  public static boolean isInitialized()
  {
    try
    {
      ISoundService localISoundService = _soundServiceInstance;
      if (localISoundService != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.SoundFactory
 * JD-Core Version:    0.6.2
 */