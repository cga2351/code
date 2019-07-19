package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

public final class zzasg
{
  private float zzbty;
  private int zzdlv;
  private int zzdlw;
  private int zzdpg;
  private boolean zzdph;
  private boolean zzdpi;
  private String zzdpj;
  private String zzdpk;
  private boolean zzdpl;
  private final boolean zzdpm;
  private boolean zzdpn;
  private boolean zzdpo;
  private boolean zzdpp;
  private String zzdpq;
  private String zzdpr;
  private String zzdps;
  private int zzdpt;
  private int zzdpu;
  private int zzdpv;
  private int zzdpw;
  private int zzdpx;
  private int zzdpy;
  private double zzdpz;
  private boolean zzdqa;
  private boolean zzdqb;
  private int zzdqc;
  private String zzdqd;
  private String zzdqe;
  private boolean zzdqf;

  public zzasg(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    zzp(paramContext);
    zzq(paramContext);
    zzr(paramContext);
    Locale localLocale = Locale.getDefault();
    boolean bool2;
    label58: Resources localResources;
    if (zza(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool2 = bool1;
      this.zzdph = bool2;
      if (zza(localPackageManager, "http://www.google.com") == null)
        break label143;
      this.zzdpi = bool1;
      this.zzdpk = localLocale.getCountry();
      zzyr.zzpa();
      this.zzdpl = zzazu.zzwx();
      this.zzdpm = DeviceProperties.isLatchsky(paramContext);
      this.zzdpn = DeviceProperties.isSidewinder(paramContext);
      this.zzdpq = localLocale.getLanguage();
      this.zzdpr = zza(paramContext, localPackageManager);
      this.zzdps = zzs(paramContext);
      localResources = paramContext.getResources();
      if (localResources != null)
        break label148;
    }
    label143: label148: DisplayMetrics localDisplayMetrics;
    do
    {
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label58;
      localDisplayMetrics = localResources.getDisplayMetrics();
    }
    while (localDisplayMetrics == null);
    this.zzbty = localDisplayMetrics.density;
    this.zzdlv = localDisplayMetrics.widthPixels;
    this.zzdlw = localDisplayMetrics.heightPixels;
  }

  public zzasg(Context paramContext, zzasf paramzzasf)
  {
    zzp(paramContext);
    zzq(paramContext);
    zzr(paramContext);
    this.zzdqd = Build.FINGERPRINT;
    this.zzdqe = Build.DEVICE;
    if ((PlatformVersion.isAtLeastIceCreamSandwichMR1()) && (zzadr.zzj(paramContext)));
    for (boolean bool = true; ; bool = false)
    {
      this.zzdqf = bool;
      this.zzdph = paramzzasf.zzdph;
      this.zzdpi = paramzzasf.zzdpi;
      this.zzdpk = paramzzasf.zzdpk;
      this.zzdpl = paramzzasf.zzdpl;
      this.zzdpm = paramzzasf.zzdpm;
      this.zzdpn = paramzzasf.zzdpn;
      this.zzdpq = paramzzasf.zzdpq;
      this.zzdpr = paramzzasf.zzdpr;
      this.zzdps = paramzzasf.zzdps;
      this.zzbty = paramzzasf.zzbty;
      this.zzdlv = paramzzasf.zzdlv;
      this.zzdlw = paramzzasf.zzdlw;
      return;
    }
  }

  private static ResolveInfo zza(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      ResolveInfo localResolveInfo = paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
      return localResolveInfo;
    }
    catch (Throwable localThrowable)
    {
      zzk.zzlk().zza(localThrowable, "DeviceInfo.getResolveInfo");
    }
    return null;
  }

  private static String zza(Context paramContext, PackageManager paramPackageManager)
  {
    ResolveInfo localResolveInfo = zza(paramPackageManager, "market://details?id=com.google.android.gms.ads");
    if (localResolveInfo == null);
    while (true)
    {
      return null;
      ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
      if (localActivityInfo != null)
        try
        {
          PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(localActivityInfo.packageName, 0);
          if (localPackageInfo != null)
          {
            int i = localPackageInfo.versionCode;
            String str1 = localActivityInfo.packageName;
            String str2 = 12 + String.valueOf(str1).length() + i + "." + str1;
            return str2;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
        }
    }
    return null;
  }

  private final void zzp(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    if (localAudioManager != null)
      try
      {
        this.zzdpg = localAudioManager.getMode();
        this.zzdpo = localAudioManager.isMusicActive();
        this.zzdpp = localAudioManager.isSpeakerphoneOn();
        this.zzdpt = localAudioManager.getStreamVolume(3);
        this.zzdpx = localAudioManager.getRingerMode();
        this.zzdpy = localAudioManager.getStreamVolume(2);
        return;
      }
      catch (Throwable localThrowable)
      {
        zzk.zzlk().zza(localThrowable, "DeviceInfo.gatherAudioInfo");
      }
    this.zzdpg = -2;
    this.zzdpo = false;
    this.zzdpp = false;
    this.zzdpt = 0;
    this.zzdpx = 2;
    this.zzdpy = 0;
  }

  @TargetApi(16)
  private final void zzq(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    this.zzdpj = localTelephonyManager.getNetworkOperator();
    this.zzdpv = localTelephonyManager.getNetworkType();
    this.zzdpw = localTelephonyManager.getPhoneType();
    this.zzdpu = -2;
    this.zzdqb = false;
    this.zzdqc = -1;
    zzk.zzlg();
    if (zzaxj.zzp(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
    {
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        break label125;
      this.zzdpu = localNetworkInfo.getType();
      this.zzdqc = localNetworkInfo.getDetailedState().ordinal();
    }
    while (true)
    {
      if (Build.VERSION.SDK_INT >= 16)
        this.zzdqb = localConnectivityManager.isActiveNetworkMetered();
      return;
      label125: this.zzdpu = -1;
    }
  }

  private final void zzr(Context paramContext)
  {
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("status", -1);
      int j = localIntent.getIntExtra("level", -1);
      int k = localIntent.getIntExtra("scale", -1);
      this.zzdpz = (j / k);
      boolean bool;
      if (i != 2)
      {
        bool = false;
        if (i != 5);
      }
      else
      {
        bool = true;
      }
      this.zzdqa = bool;
      return;
    }
    this.zzdpz = -1.0D;
    this.zzdqa = false;
  }

  private static String zzs(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.android.vending", 128);
      Object localObject = null;
      if (localPackageInfo != null)
      {
        int i = localPackageInfo.versionCode;
        String str1 = localPackageInfo.packageName;
        String str2 = 12 + String.valueOf(str1).length() + i + "." + str1;
        localObject = str2;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final zzasf zzty()
  {
    return new zzasf(this.zzdpg, this.zzdph, this.zzdpi, this.zzdpj, this.zzdpk, this.zzdpl, this.zzdpm, this.zzdpn, this.zzdpo, this.zzdpp, this.zzdpq, this.zzdpr, this.zzdps, this.zzdpt, this.zzdpu, this.zzdpv, this.zzdpw, this.zzdpx, this.zzdpy, this.zzbty, this.zzdlv, this.zzdlw, this.zzdpz, this.zzdqa, this.zzdqb, this.zzdqc, this.zzdqd, this.zzdqf, this.zzdqe);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzasg
 * JD-Core Version:    0.6.2
 */