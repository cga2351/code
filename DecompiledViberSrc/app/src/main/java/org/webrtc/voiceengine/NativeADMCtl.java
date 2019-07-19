package org.webrtc.voiceengine;

import android.os.Build;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.av;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.videoengine.ViENative;

public class NativeADMCtl
{
  public static final int DRIVER_FALLBACK_MASK = 4;
  public static final int DRIVER_NATIVE_MASK = 2;
  public static final int DRIVER_OPENSLES_MASK = 1;
  private static final boolean FALLBACK_DRIVER_ENABLED_BY_DEFAULT = true;
  public static final int FEATURE_EMPTY = 0;
  public static final int FEATURE_HW_AEC = 2;
  public static final int FEATURE_HW_AGC = 1;
  public static final int FEATURE_HW_NS = 4;
  public static final int FEATURE_SW_AEC = 16;
  public static final int FEATURE_SW_AGC = 8;
  public static final int FEATURE_SW_NS = 32;
  public static final boolean HW_AEC_ENABLED_BY_DEFAULT = true;
  public static final boolean HW_AGC_ENABLED_BY_DEFAULT = true;
  public static final boolean HW_NS_ENABLED_BY_DEFAULT = true;
  private static final Logger L = ViberEnv.getLogger();
  private static final boolean NATIVE_DRIVER_ENABLED_BY_DEFAULT = true;
  private static final boolean OPENSLES_DRIVER_ENABLED_BY_DEFAULT = true;
  public static final boolean SW_AEC_ENABLED_BY_DEFAULT = true;
  public static final boolean SW_AGC_ENABLED_BY_DEFAULT = true;
  public static final boolean SW_NS_ENABLED_BY_DEFAULT = true;
  private static final boolean USE_NATIVE_ADM_VENDORS_BLACKLIST = true;
  private static volatile NativeADMCtl _instance = null;
  private static final List<String> modelBlacklist;
  private static final List<String> vendorsBlacklist = new ArrayList();
  private int[] _admFeaturesAvailable = null;
  private int[] _admFeaturesRequested = null;
  private volatile boolean _allowFallbackDriver = true;
  private volatile boolean _allowNativeDriver = true;
  private volatile boolean _allowOpenSLESDriver = true;
  private int _hwDeviceMask = 0;
  private boolean _initialized = false;

  static
  {
    modelBlacklist = new ArrayList();
    vendorsBlacklist.add("sony");
    vendorsBlacklist.add("sony ericsson");
    vendorsBlacklist.add("motorola");
    vendorsBlacklist.add("htc");
    modelBlacklist.add("GT-P7510".toLowerCase());
    modelBlacklist.add("GT-I8190".toLowerCase());
    modelBlacklist.add("GT-I8190N".toLowerCase());
    modelBlacklist.add("GT-I9100".toLowerCase());
    modelBlacklist.add("GT-I9060I".toLowerCase());
    modelBlacklist.add("GT-I9031I".toLowerCase());
    modelBlacklist.add("GT-I9103".toLowerCase());
    modelBlacklist.add("GT-S6810P".toLowerCase());
    modelBlacklist.add("SM-G7102".toLowerCase());
    modelBlacklist.add("GT-I9060".toLowerCase());
    modelBlacklist.add("GT-S7580".toLowerCase());
    modelBlacklist.add("GT-S7582".toLowerCase());
    modelBlacklist.add("ASUS_T00J".toLowerCase());
    modelBlacklist.add("ASUS_T00J1".toLowerCase());
    modelBlacklist.add("ASUS_T00F".toLowerCase());
    modelBlacklist.add("ASUS_T00F1".toLowerCase());
    modelBlacklist.add("ASUS_T00K".toLowerCase());
    modelBlacklist.add("ASUS_T00P".toLowerCase());
  }

  public static NativeADMCtl getInstance()
  {
    try
    {
      if (_instance == null)
        _instance = new NativeADMCtl();
      NativeADMCtl localNativeADMCtl = _instance;
      return localNativeADMCtl;
    }
    finally
    {
    }
  }

  @ViENative
  private void initialize(int paramInt)
  {
    if (isNativeBlacklisted())
      paramInt &= -3;
    this._hwDeviceMask = paramInt;
    this._initialized = true;
    if (d.av.a.a());
    try
    {
      int i = paramInt & Integer.parseInt(d.av.a.d());
      if (i == 0)
        i |= 4;
      setDeviceMask(i);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
  }

  @ViENative
  private static boolean isNativeBlacklisted()
  {
    return (vendorsBlacklist.contains(Build.MANUFACTURER.toLowerCase())) || (modelBlacklist.contains(Build.DEVICE.toLowerCase()));
  }

  @ViENative
  private void setAvailableFeaturesMask(int paramInt1, int paramInt2)
  {
    int i = (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D));
    if (this._admFeaturesAvailable == null)
      this._admFeaturesAvailable = new int[i + 1];
    if (this._admFeaturesAvailable.length <= i)
    {
      int[] arrayOfInt = new int[i + 1];
      System.arraycopy(this._admFeaturesAvailable, 0, arrayOfInt, 0, this._admFeaturesAvailable.length);
      this._admFeaturesAvailable = arrayOfInt;
    }
    this._admFeaturesAvailable[i] = paramInt2;
    int j;
    if ((paramInt2 & 0x1) != 0)
      j = 1;
    while (true)
    {
      int k = 0x0 | j;
      int m;
      label102: int i1;
      label118: int i3;
      label136: int i5;
      label154: int i9;
      if ((paramInt2 & 0x2) != 0)
      {
        m = 2;
        int n = k | m;
        if ((paramInt2 & 0x4) == 0)
          break label427;
        i1 = 4;
        int i2 = n | i1;
        if ((paramInt2 & 0x8) == 0)
          break label433;
        i3 = 8;
        int i4 = i2 | i3;
        if ((paramInt2 & 0x10) == 0)
          break label439;
        i5 = 16;
        int i6 = i5 | i4;
        int i7 = paramInt2 & 0x20;
        int i8 = 0;
        if (i7 != 0)
          i8 = 32;
        i9 = i8 | i6;
        if (!d.av.b.a());
      }
      try
      {
        int i16 = Integer.valueOf(d.av.b.d()).intValue();
        if (i16 == 0)
        {
          i9 &= -2;
          label221: if (!d.av.c.a());
        }
        try
        {
          int i15 = Integer.valueOf(d.av.c.d()).intValue();
          if (i15 == 0)
          {
            i9 &= -3;
            label256: if (!d.av.d.a());
          }
          try
          {
            int i14 = Integer.valueOf(d.av.d.d()).intValue();
            if (i14 == 0)
            {
              i9 &= -5;
              label291: if (!d.av.e.a());
            }
            try
            {
              int i13 = Integer.valueOf(d.av.e.d()).intValue();
              if (i13 == 0)
              {
                i9 &= -9;
                label326: if (!d.av.f.a());
              }
              try
              {
                int i12 = Integer.valueOf(d.av.f.d()).intValue();
                if (i12 == 0)
                {
                  i9 &= -17;
                  label361: if (!d.av.g.a());
                }
                try
                {
                  int i11 = Integer.valueOf(d.av.g.d()).intValue();
                  if (i11 == 0)
                    i9 &= -33;
                  while (true)
                  {
                    label396: int i10 = i9 & paramInt2;
                    if (i10 != 0)
                      setFeaturesMask(paramInt1, i10);
                    return;
                    j = 0;
                    break;
                    m = 0;
                    break label102;
                    label427: i1 = 0;
                    break label118;
                    label433: i3 = 0;
                    break label136;
                    label439: i5 = 0;
                    break label154;
                    i9 |= 1;
                    break label221;
                    i9 |= 2;
                    break label256;
                    i9 |= 4;
                    break label291;
                    i9 |= 8;
                    break label326;
                    i9 |= 16;
                    break label361;
                    i9 |= 32;
                  }
                }
                catch (Exception localException1)
                {
                  break label396;
                }
              }
              catch (Exception localException2)
              {
                break label361;
              }
            }
            catch (Exception localException3)
            {
              break label326;
            }
          }
          catch (Exception localException4)
          {
            break label291;
          }
        }
        catch (Exception localException5)
        {
          break label256;
        }
      }
      catch (Exception localException6)
      {
        break label221;
      }
    }
  }

  public boolean allowFallbackDriver()
  {
    return this._allowFallbackDriver & isFallbackDriverAvailable();
  }

  public boolean allowNativeDriver()
  {
    return this._allowNativeDriver & isNativeDriverAvailable();
  }

  public boolean allowOpenSLESDriver()
  {
    return this._allowOpenSLESDriver & isOpenSLESDriverAvailable();
  }

  public int getAvailableFeaturesMask(int paramInt)
  {
    if (this._admFeaturesAvailable == null);
    int i;
    do
    {
      return 0;
      i = (int)Math.ceil(Math.log(paramInt) / Math.log(2.0D));
    }
    while (this._admFeaturesAvailable.length <= i);
    return this._admFeaturesAvailable[i];
  }

  public int getDeviceMask()
  {
    return this._hwDeviceMask;
  }

  public int getFeaturesMask(int paramInt)
  {
    if (this._admFeaturesAvailable == null);
    int i;
    do
    {
      return 0;
      i = (int)Math.ceil(Math.log(paramInt) / Math.log(2.0D));
    }
    while (this._admFeaturesAvailable.length <= i);
    if ((this._admFeaturesRequested == null) || (this._admFeaturesRequested.length <= i))
    {
      int[] arrayOfInt = new int[i + 1];
      if (this._admFeaturesRequested != null)
        System.arraycopy(this._admFeaturesRequested, 0, arrayOfInt, 0, this._admFeaturesRequested.length);
      this._admFeaturesRequested = arrayOfInt;
    }
    return this._admFeaturesAvailable[i] & this._admFeaturesRequested[i];
  }

  public int getUsableDeviceMask()
  {
    int i;
    if (allowNativeDriver())
    {
      i = 2;
      if (!allowOpenSLESDriver())
        break label51;
    }
    label51: for (int j = 1; ; j = 0)
    {
      int k = i | j;
      boolean bool = allowFallbackDriver();
      int m = 0;
      if (bool)
        m = 4;
      return 0x0 | (k | m);
      i = 0;
      break;
    }
  }

  public boolean isFallbackDriverAvailable()
  {
    return 4 == (0x4 & this._hwDeviceMask);
  }

  public boolean isInitialized()
  {
    return this._initialized;
  }

  public boolean isNativeDriverAvailable()
  {
    return 2 == (0x2 & this._hwDeviceMask);
  }

  public boolean isOpenSLESDriverAvailable()
  {
    return 1 == (0x1 & this._hwDeviceMask);
  }

  public void setDeviceMask(int paramInt)
  {
    int i = 1;
    if (isNativeBlacklisted())
      paramInt &= -3;
    if (2 == (paramInt & 0x2))
    {
      int k = i;
      setNativeDriver(k);
      if (i != (paramInt & 0x1))
        break label61;
      int n = i;
      label37: setOpenSLESDriver(n);
      if (4 != (paramInt & 0x4))
        break label67;
    }
    while (true)
    {
      setFallbackDriver(i);
      return;
      int m = 0;
      break;
      label61: int i1 = 0;
      break label37;
      label67: int j = 0;
    }
  }

  public void setFallbackDriver(boolean paramBoolean)
  {
    this._allowFallbackDriver = paramBoolean;
  }

  public void setFeaturesMask(int paramInt1, int paramInt2)
  {
    if (this._admFeaturesAvailable == null);
    int i;
    do
    {
      return;
      i = (int)Math.ceil(Math.log(paramInt1) / Math.log(2.0D));
    }
    while (this._admFeaturesAvailable.length <= i);
    if ((this._admFeaturesRequested == null) || (this._admFeaturesRequested.length <= i))
    {
      int[] arrayOfInt = new int[i + 1];
      if (this._admFeaturesRequested != null)
        System.arraycopy(this._admFeaturesRequested, 0, arrayOfInt, 0, this._admFeaturesRequested.length);
      this._admFeaturesRequested = arrayOfInt;
    }
    this._admFeaturesRequested[i] = paramInt2;
  }

  public void setNativeDriver(boolean paramBoolean)
  {
    this._allowNativeDriver = paramBoolean;
  }

  public void setOpenSLESDriver(boolean paramBoolean)
  {
    this._allowOpenSLESDriver = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.NativeADMCtl
 * JD-Core Version:    0.6.2
 */