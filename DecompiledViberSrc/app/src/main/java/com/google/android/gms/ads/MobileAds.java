package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzabc;
import com.google.android.gms.internal.ads.zzabh;

public class MobileAds
{
  public static InitializationStatus getInitializationStatus()
  {
    return zzabc.zzqf().getInitializationStatus();
  }

  public static RewardedVideoAd getRewardedVideoAdInstance(Context paramContext)
  {
    return zzabc.zzqf().getRewardedVideoAdInstance(paramContext);
  }

  @KeepForSdk
  public static String getVersionString()
  {
    return zzabc.zzqf().getVersionString();
  }

  public static void initialize(Context paramContext)
  {
    initialize(paramContext, null, null);
  }

  public static void initialize(Context paramContext, String paramString)
  {
    initialize(paramContext, paramString, null);
  }

  @Deprecated
  public static void initialize(Context paramContext, String paramString, Settings paramSettings)
  {
    zzabc localzzabc = zzabc.zzqf();
    if (paramSettings == null);
    for (zzabh localzzabh = null; ; localzzabh = paramSettings.zzdg())
    {
      localzzabc.zza(paramContext, paramString, localzzabh, null);
      return;
    }
  }

  public static void openDebugMenu(Context paramContext, String paramString)
  {
    zzabc.zzqf().openDebugMenu(paramContext, paramString);
  }

  @KeepForSdk
  public static void registerRtbAdapter(Class<? extends RtbAdapter> paramClass)
  {
    zzabc.zzqf().registerRtbAdapter(paramClass);
  }

  public static void setAppMuted(boolean paramBoolean)
  {
    zzabc.zzqf().setAppMuted(paramBoolean);
  }

  public static void setAppVolume(float paramFloat)
  {
    zzabc.zzqf().setAppVolume(paramFloat);
  }

  public static final class Settings
  {
    private final zzabh zzaat = new zzabh();

    @Deprecated
    public final String getTrackingId()
    {
      return null;
    }

    @Deprecated
    public final boolean isGoogleAnalyticsEnabled()
    {
      return false;
    }

    @Deprecated
    public final Settings setGoogleAnalyticsEnabled(boolean paramBoolean)
    {
      return this;
    }

    @Deprecated
    public final Settings setTrackingId(String paramString)
    {
      return this;
    }

    final zzabh zzdg()
    {
      return this.zzaat;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.MobileAds
 * JD-Core Version:    0.6.2
 */