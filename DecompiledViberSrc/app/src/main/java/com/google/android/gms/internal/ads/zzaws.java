package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzaws
{
  private final Object lock = new Object();

  @VisibleForTesting
  private long zzdug = -1L;

  @VisibleForTesting
  private long zzduh = -1L;

  @VisibleForTesting
  @GuardedBy("lock")
  private int zzdui = -1;

  @VisibleForTesting
  int zzduj = -1;

  @VisibleForTesting
  private long zzduk = 0L;

  @VisibleForTesting
  private final String zzdul;
  private final zzaxc zzdum;

  @VisibleForTesting
  @GuardedBy("lock")
  private int zzdun = 0;

  @VisibleForTesting
  @GuardedBy("lock")
  private int zzduo = 0;

  public zzaws(String paramString, zzaxc paramzzaxc)
  {
    this.zzdul = paramString;
    this.zzdum = paramzzaxc;
  }

  private static boolean zzai(Context paramContext)
  {
    Context localContext = zzasr.zzw(paramContext);
    int i = localContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      zzaxa.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(localContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == localContext.getPackageManager().getActivityInfo(localComponentName, 0).theme)
        return true;
      zzaxa.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      zzaxa.zzep("Fail to fetch AdActivity theme");
      zzaxa.zzeo("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }

  public final void zza(zzxx paramzzxx, long paramLong)
  {
    long l2;
    while (true)
    {
      synchronized (this.lock)
      {
        long l1 = this.zzdum.zzvs();
        l2 = zzk.zzln().currentTimeMillis();
        if (this.zzduh == -1L)
        {
          long l3 = l2 - l1;
          zzaci localzzaci = zzact.zzcoz;
          if (l3 > ((Long)zzyr.zzpe().zzd(localzzaci)).longValue())
          {
            this.zzduj = -1;
            this.zzduh = paramLong;
            this.zzdug = this.zzduh;
            if ((paramzzxx == null) || (paramzzxx.extras == null) || (paramzzxx.extras.getInt("gw", 2) != 1))
              break;
            return;
          }
          this.zzduj = this.zzdum.zzvt();
        }
      }
      this.zzdug = paramLong;
    }
    this.zzdui = (1 + this.zzdui);
    this.zzduj = (1 + this.zzduj);
    if (this.zzduj == 0)
    {
      this.zzduk = 0L;
      this.zzdum.zzfd(l2);
    }
    while (true)
    {
      return;
      this.zzduk = (l2 - this.zzdum.zzvu());
    }
  }

  public final Bundle zzn(Context paramContext, String paramString)
  {
    synchronized (this.lock)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.zzdul);
      localBundle.putLong("basets", this.zzduh);
      localBundle.putLong("currts", this.zzdug);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.zzdui);
      localBundle.putInt("preqs_in_session", this.zzduj);
      localBundle.putLong("time_in_session", this.zzduk);
      localBundle.putInt("pclick", this.zzdun);
      localBundle.putInt("pimp", this.zzduo);
      localBundle.putBoolean("support_transparent_background", zzai(paramContext));
      return localBundle;
    }
  }

  public final void zzuj()
  {
    synchronized (this.lock)
    {
      this.zzduo = (1 + this.zzduo);
      return;
    }
  }

  public final void zzuk()
  {
    synchronized (this.lock)
    {
      this.zzdun = (1 + this.zzdun);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaws
 * JD-Core Version:    0.6.2
 */