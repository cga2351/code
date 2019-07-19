package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties
{
  private static Boolean zzgl;
  private static Boolean zzgm;
  private static Boolean zzgn;
  private static Boolean zzgo;
  private static Boolean zzgp;
  private static Boolean zzgq;
  private static Boolean zzgr;
  private static Boolean zzgs;

  @KeepForSdk
  public static boolean isAuto(Context paramContext)
  {
    if (zzgr == null)
      if ((!PlatformVersion.isAtLeastO()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive")))
        break label40;
    label40: for (boolean bool = true; ; bool = false)
    {
      zzgr = Boolean.valueOf(bool);
      return zzgr.booleanValue();
    }
  }

  @KeepForSdk
  public static boolean isLatchsky(Context paramContext)
  {
    if (zzgp == null)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if ((!localPackageManager.hasSystemFeature("com.google.android.feature.services_updater")) || (!localPackageManager.hasSystemFeature("cn.google.services")))
        break label45;
    }
    label45: for (boolean bool = true; ; bool = false)
    {
      zzgp = Boolean.valueOf(bool);
      return zzgp.booleanValue();
    }
  }

  @TargetApi(21)
  @KeepForSdk
  public static boolean isSidewinder(Context paramContext)
  {
    if (zzgo == null)
      if ((!PlatformVersion.isAtLeastLollipop()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google")))
        break label40;
    label40: for (boolean bool = true; ; bool = false)
    {
      zzgo = Boolean.valueOf(bool);
      return zzgo.booleanValue();
    }
  }

  @KeepForSdk
  public static boolean isTablet(Resources paramResources)
  {
    if (paramResources == null)
      return false;
    int i;
    if (zzgl == null)
    {
      if ((0xF & paramResources.getConfiguration().screenLayout) <= 3)
        break label107;
      i = 1;
      if (i == 0)
        if (zzgm == null)
        {
          Configuration localConfiguration = paramResources.getConfiguration();
          if (((0xF & localConfiguration.screenLayout) > 3) || (localConfiguration.smallestScreenWidthDp < 600))
            break label112;
        }
    }
    label107: label112: for (boolean bool3 = true; ; bool3 = false)
    {
      zzgm = Boolean.valueOf(bool3);
      boolean bool2 = zzgm.booleanValue();
      boolean bool1 = false;
      if (bool2)
        bool1 = true;
      zzgl = Boolean.valueOf(bool1);
      return zzgl.booleanValue();
      i = 0;
      break;
    }
  }

  @KeepForSdk
  public static boolean isTv(Context paramContext)
  {
    if (zzgs == null)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if ((!localPackageManager.hasSystemFeature("com.google.android.tv")) && (!localPackageManager.hasSystemFeature("android.hardware.type.television")) && (!localPackageManager.hasSystemFeature("android.software.leanback")))
        break label54;
    }
    label54: for (boolean bool = true; ; bool = false)
    {
      zzgs = Boolean.valueOf(bool);
      return zzgs.booleanValue();
    }
  }

  @KeepForSdk
  public static boolean isUserBuild()
  {
    return "user".equals(Build.TYPE);
  }

  @TargetApi(20)
  @KeepForSdk
  public static boolean isWearable(Context paramContext)
  {
    if (zzgn == null)
      if ((!PlatformVersion.isAtLeastKitKatWatch()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch")))
        break label40;
    label40: for (boolean bool = true; ; bool = false)
    {
      zzgn = Boolean.valueOf(bool);
      return zzgn.booleanValue();
    }
  }

  @TargetApi(26)
  @KeepForSdk
  public static boolean isWearableWithoutPlayStore(Context paramContext)
  {
    return (isWearable(paramContext)) && ((!PlatformVersion.isAtLeastN()) || ((isSidewinder(paramContext)) && (!PlatformVersion.isAtLeastO())));
  }

  public static boolean zzf(Context paramContext)
  {
    if (zzgq == null)
      if ((!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot")) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded")))
        break label46;
    label46: for (boolean bool = true; ; bool = false)
    {
      zzgq = Boolean.valueOf(bool);
      return zzgq.booleanValue();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.DeviceProperties
 * JD-Core Version:    0.6.2
 */