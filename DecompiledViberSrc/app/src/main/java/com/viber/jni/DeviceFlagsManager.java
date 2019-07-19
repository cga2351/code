package com.viber.jni;

import android.annotation.SuppressLint;
import android.os.Build;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.av;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.NativeMediaDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.webrtc.voiceengine.NativeADMDelegate;

public class DeviceFlagsManager
{
  public static final int DF_USE_16000_SAMPLE_RATE = 1;
  public static final int DF_USE_AGC = 8;
  public static final int DF_USE_EC = 4;
  public static final int DF_USE_H264 = 128;
  public static final int DF_USE_HI_VOLUME = 16;
  public static final int DF_USE_MIC_BOOST = 32;
  public static final int DF_USE_NS = 2;
  public static final int DF_USE_VIDEO = 64;
  public static final int DF_USE_VP9 = 256;
  private static final Logger L = ViberEnv.getLogger();
  private static int SONY_STANDARD_FLAGS;
  private static int STANDARD_FLAGS = 14;
  public static final boolean WEAK_DEVICE;
  public static int _AECmode;
  public static int _AGCmode;
  public static int _NSmode;
  public static int _RxAGCmode;
  public static int _RxNSmode;
  private static Map<String, DeviceModes> mFlagMap;
  private static final List<String> weak_devices_list;

  static
  {
    SONY_STANDARD_FLAGS = 0x1 | STANDARD_FLAGS;
    weak_devices_list = new ArrayList();
    weak_devices_list.add("buzz");
    WEAK_DEVICE = weak_devices_list.contains(Build.DEVICE);
    DeviceFlags.WEAK_DEVICE = WEAK_DEVICE;
    mFlagMap = new HashMap();
    populateMap();
  }

  @SuppressLint({"NewApi"})
  public static int getFlagsForDeviceModel()
  {
    String str = Build.DEVICE;
    int i = STANDARD_FLAGS;
    if (mFlagMap.containsKey(str));
    while (true)
    {
      try
      {
        j = ((DeviceModes)mFlagMap.get(str)).deviceFlags;
        if (j != -1);
      }
      catch (Exception localException1)
      {
        try
        {
          j = STANDARD_FLAGS;
          if (NativeMediaDelegate.isVideoSupportBuiltin())
          {
            k = 64;
            int m = j | k;
            if (((m & 0x40) != 0) && (!"0".equals(d.av.z.d())))
              m |= 128;
            if (((m & 0x40) != 0) && (!"0".equals(d.av.A.d())))
              m |= 256;
            if (!d.m.j.d())
              m &= -5;
            if ((NativeADMDelegate.isPlatformWideAECEffectAvailable()) && (!"0".equals(d.av.c.d())))
              m &= -5;
            if ((NativeADMDelegate.isPlatformWideNSEffectAvailable()) && (!"0".equals(d.av.d.d())))
              m &= -3;
            if ((NativeADMDelegate.isPlatformWideAGCEffectAvailable()) && (!"0".equals(d.av.b.d())))
              m &= -9;
            return m;
          }
          int k = 0;
          continue;
          localException1 = localException1;
          j = i;
          continue;
        }
        catch (Exception localException2)
        {
          continue;
        }
      }
      int j = i;
    }
  }

  // ERROR //
  public static DeviceModes getSpeechEnhancementsModeForDeviceModel()
  {
    // Byte code:
    //   0: new 110	com/viber/jni/DeviceFlagsManager$DeviceModes
    //   3: dup
    //   4: iconst_0
    //   5: invokespecial 175	com/viber/jni/DeviceFlagsManager$DeviceModes:<init>	(I)V
    //   8: astore_0
    //   9: getstatic 75	android/os/Build:DEVICE	Ljava/lang/String;
    //   12: astore_1
    //   13: getstatic 88	com/viber/jni/DeviceFlagsManager:mFlagMap	Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface 104 2 0
    //   22: ifeq +60 -> 82
    //   25: getstatic 88	com/viber/jni/DeviceFlagsManager:mFlagMap	Ljava/util/Map;
    //   28: aload_1
    //   29: invokeinterface 108 2 0
    //   34: checkcast 110	com/viber/jni/DeviceFlagsManager$DeviceModes
    //   37: astore_3
    //   38: aload_3
    //   39: getfield 178	com/viber/jni/DeviceFlagsManager$DeviceModes:AEC_mode	I
    //   42: putstatic 180	com/viber/jni/DeviceFlagsManager:_AECmode	I
    //   45: aload_3
    //   46: getfield 183	com/viber/jni/DeviceFlagsManager$DeviceModes:AGC_mode	I
    //   49: putstatic 185	com/viber/jni/DeviceFlagsManager:_AGCmode	I
    //   52: aload_3
    //   53: getfield 188	com/viber/jni/DeviceFlagsManager$DeviceModes:NS_mode	I
    //   56: putstatic 190	com/viber/jni/DeviceFlagsManager:_NSmode	I
    //   59: aload_3
    //   60: getfield 193	com/viber/jni/DeviceFlagsManager$DeviceModes:RxAGC_mode	I
    //   63: putstatic 195	com/viber/jni/DeviceFlagsManager:_RxAGCmode	I
    //   66: aload_3
    //   67: getfield 198	com/viber/jni/DeviceFlagsManager$DeviceModes:RxNS_mode	I
    //   70: putstatic 200	com/viber/jni/DeviceFlagsManager:_RxNSmode	I
    //   73: aload_3
    //   74: areturn
    //   75: astore_2
    //   76: aload_0
    //   77: areturn
    //   78: astore 4
    //   80: aload_3
    //   81: areturn
    //   82: aload_0
    //   83: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   25	38	75	java/lang/Exception
    //   38	73	78	java/lang/Exception
  }

  private static void populateMap()
  {
    mFlagMap.clear();
    mFlagMap.put("E10a", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("E10i", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("E16i", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("E16a", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("X10i", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("X10a", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("U20i", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("U20a", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("E15i", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("E15a", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("C1905", new DeviceModes(SONY_STANDARD_FLAGS));
    mFlagMap.put("legend", new DeviceModes(0x1 | STANDARD_FLAGS));
    mFlagMap.put("thunderg", new DeviceModes(0x1 | STANDARD_FLAGS));
    mFlagMap.put("U8150", new DeviceModes(0x1 | STANDARD_FLAGS));
    mFlagMap.put("GT-I5500", new DeviceModes(5));
    mFlagMap.put("S5570I", new DeviceModes(5));
    mFlagMap.put("GIONEE", new DeviceModes(5));
    mFlagMap.put("C5302", new DeviceModes(5));
    mFlagMap.put("C5303", new DeviceModes(5));
    mFlagMap.put("LT25i", new DeviceModes(5));
    mFlagMap.put("K00Z", new DeviceModes(5));
    mFlagMap.put("runnymede", new DeviceModes(1, 0, 0, 3, 0, -1));
    mFlagMap.put("ja3g", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("vision", new DeviceModes(2, 0, 1, 0, 0, -1));
    mFlagMap.put("DiabloHD", new DeviceModes(3, 0, 0, 2, 0, -1));
    mFlagMap.put("hwG510-0010", new DeviceModes(2, 0, 1, 2, 0, -1));
    mFlagMap.put("buzz", new DeviceModes(2, 0, 0, 0, 0, 1));
    mFlagMap.put("vee3e", new DeviceModes(2, 0, 0, 0, 0, -1));
    mFlagMap.put("vee7ds", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("LT26i", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("Pixo_GSM", new DeviceModes(3, 0, 0, 3, 0, -1));
    mFlagMap.put("GT-I9000", new DeviceModes(3, 0, 1, 3, 0, -1));
    mFlagMap.put("g2", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("ace", new DeviceModes(0, 0, 0, 2, 0, -1));
    mFlagMap.put("hwY300-0000", new DeviceModes(1, 0, 1, 2, 0, -1));
    mFlagMap.put("X10i", new DeviceModes(2, 0, 0, 3, 0, SONY_STANDARD_FLAGS));
    mFlagMap.put("GT-S5570", new DeviceModes(1, 0, 1, 2, 0, -1));
    mFlagMap.put("saga", new DeviceModes(1, 0, 1, 2, 0, -1));
    mFlagMap.put("Scribe5HD", new DeviceModes(1, 0, 0, 2, 0, -1));
    mFlagMap.put("bravo", new DeviceModes(1, 0, 1, 3, 0, -1));
    mFlagMap.put("hwY300-0151", new DeviceModes(2, 0, 1, 0, 0, -1));
    mFlagMap.put("evita", new DeviceModes(1, 0, 0, 0, 0, -1));
    mFlagMap.put("vivo", new DeviceModes(2, 0, 0, 2, 0, -1));
    mFlagMap.put("GT-I5510", new DeviceModes(0, 0, 1, 0, 0, -1));
    mFlagMap.put("pyramid", new DeviceModes(0, 0, 1, 2, 0, -1));
    mFlagMap.put("mintss", new DeviceModes(1, 0, 0, 2, 0, -1));
    mFlagMap.put("mako", new DeviceModes(3, 3, 2, 3, 0, -1));
    mFlagMap.put("hwu8825D", new DeviceModes(3, 0, 1, 3, 0, -1));
    mFlagMap.put("chacha", new DeviceModes(1, 0, 1, 2, 0, -1));
    mFlagMap.put("GT-I9100", new DeviceModes(0, 0, 0, 2, 0, -1));
    mFlagMap.put("GT-N7000", new DeviceModes(0, 3, 0, 0, 0, -1));
    mFlagMap.put("blade", new DeviceModes(2, 0, 0, 2, 0, -1));
    mFlagMap.put("Martell_lite_GSM", new DeviceModes(3, 0, 0, 3, 1, -1));
    mFlagMap.put("maguro", new DeviceModes(2, 0, 1, 2, 0, -1));
    mFlagMap.put("A68", new DeviceModes(1, 0, 0, 2, 0, -1));
    mFlagMap.put("LT18a", new DeviceModes(1, 0, 1, 2, 0, -1));
    mFlagMap.put("marvel", new DeviceModes(1, 0, 0, 2, 0, -1));
    mFlagMap.put("t03g", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("u8800", new DeviceModes(2, 0, 1, 3, 0, -1));
    mFlagMap.put("m7", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("GT-S5300", new DeviceModes(0, 0, 0, 2, 0, -1));
    mFlagMap.put("GT-S5830", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("GT-S5360", new DeviceModes(1, 0, 0, 3, 0, -1));
    mFlagMap.put("Martell_GSM", new DeviceModes(0, 0, 0, 2, 0, -1));
    mFlagMap.put("kyleopen", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("hsdroid", new DeviceModes(1, 0, 1, 2, 0, -1));
    mFlagMap.put("m0", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("ST25i", new DeviceModes(1, 0, 1, 0, 0, -1));
    mFlagMap.put("jflte", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("golden", new DeviceModes(0, 3, 0, 0, 0, -1));
    mFlagMap.put("geeb", new DeviceModes(2, 0, 0, 2, 0, -1));
    mFlagMap.put("smi", new DeviceModes(1));
    mFlagMap.put("bird77_a_cu_ics2", new DeviceModes(0, 0, 0, 0, 0, -1));
    mFlagMap.put("byt_t_ffrd8", new DeviceModes(0x1 | STANDARD_FLAGS));
    mFlagMap.put("HTF8A4", new DeviceModes(0x1 | STANDARD_FLAGS));
  }

  public static boolean shouldUse16kSampleRate()
  {
    String str = Build.DEVICE;
    boolean bool1 = mFlagMap.containsKey(str);
    boolean bool2 = false;
    if (bool1);
    try
    {
      int i = ((DeviceModes)mFlagMap.get(str)).deviceFlags;
      if ((i & 0x1) == 1);
      for (boolean bool3 = true; ; bool3 = false)
      {
        bool2 = bool3;
        return bool2;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static class AEC_mode
  {
    public static final int DF_USE_EC_DISABLED = 0;
    public static final int DF_USE_EC_EARPIECE = 2;
    public static final int DF_USE_EC_LOUD_EARPIECE = 3;
    public static final int DF_USE_EC_LOUD_SPEAKERPHONE = 5;
    public static final int DF_USE_EC_QUIET_EARPIECE = 1;
    public static final int DF_USE_EC_SPEAKERPHONE = 4;
  }

  public static class AGC_mode
  {
    public static final int DF_USE_AGC_ADAPTIVE_ANALOG = 1;
    public static final int DF_USE_AGC_ADAPTIVE_DIGITAL = 2;
    public static final int DF_USE_AGC_DISABLED = 0;
    public static final int DF_USE_AGC_FIXED_DIGITAL = 3;
  }

  public static class DeviceModes
  {
    public int AEC_mode = 0;
    public int AGC_mode = 0;
    public int NS_mode = 0;
    public int RxAGC_mode = 0;
    public int RxNS_mode = 0;
    public int deviceFlags = 0;

    public DeviceModes(int paramInt)
    {
      this(1, 0, 0, 2, 0, paramInt);
    }

    public DeviceModes(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.AEC_mode = paramInt1;
      this.AGC_mode = paramInt2;
      this.NS_mode = paramInt3;
      this.RxAGC_mode = paramInt4;
      this.RxNS_mode = paramInt5;
      this.deviceFlags = paramInt6;
    }
  }

  public static class NS_mode
  {
    public static final int DF_USE_NS_CONFERENCE = 1;
    public static final int DF_USE_NS_DISABLED = 0;
    public static final int DF_USE_NS_HIGH_SUPPRESSION = 4;
    public static final int DF_USE_NS_LOW_SUPPRESSION = 2;
    public static final int DF_USE_NS_MODERATE_SUPPRESSION = 3;
    public static final int DF_USE_NS_VERY_HIGH_SUPPRESSION = 5;
  }

  public static class RxAGC_mode
  {
    public static final int DF_USE_RxAGC_ADAPTIVE_ANALOG = 1;
    public static final int DF_USE_RxAGC_ADAPTIVE_DIGITAL = 2;
    public static final int DF_USE_RxAGC_DISABLED = 0;
    public static final int DF_USE_RxAGC_FIXED_DIGITAL = 3;
  }

  public static class RxNS_mode
  {
    public static final int DF_USE_RxNS_CONFERENCE = 1;
    public static final int DF_USE_RxNS_DISABLED = 0;
    public static final int DF_USE_RxNS_HIGH_SUPPRESSION = 4;
    public static final int DF_USE_RxNS_LOW_SUPPRESSION = 2;
    public static final int DF_USE_RxNS_MODERATE_SUPPRESSION = 3;
    public static final int DF_USE_RxNS_VERY_HIGH_SUPPRESSION = 5;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.DeviceFlagsManager
 * JD-Core Version:    0.6.2
 */