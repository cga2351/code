package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

public final class zzdy extends zzf
{

  @VisibleForTesting
  protected zzdx zzart;
  private volatile zzdx zzaru;
  private zzdx zzarv;
  private final Map<Activity, zzdx> zzarw = new ArrayMap();
  private zzdx zzarx;
  private String zzary;

  public zzdy(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  private final void zza(Activity paramActivity, zzdx paramzzdx, boolean paramBoolean)
  {
    if (this.zzaru == null);
    for (zzdx localzzdx = this.zzarv; ; localzzdx = this.zzaru)
    {
      if (paramzzdx.zzarq == null)
        paramzzdx = new zzdx(paramzzdx.zzuw, zzcq(paramActivity.getClass().getCanonicalName()), paramzzdx.zzarr);
      this.zzarv = this.zzaru;
      this.zzaru = paramzzdx;
      zzgs().zzc(new zzdz(this, paramBoolean, localzzdx, paramzzdx));
      return;
    }
  }

  public static void zza(zzdx paramzzdx, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramBundle != null) && (paramzzdx != null) && ((!paramBundle.containsKey("_sc")) || (paramBoolean)))
      if (paramzzdx.zzuw != null)
      {
        paramBundle.putString("_sn", paramzzdx.zzuw);
        paramBundle.putString("_sc", paramzzdx.zzarq);
        paramBundle.putLong("_si", paramzzdx.zzarr);
      }
    while ((paramBundle == null) || (paramzzdx != null) || (!paramBoolean))
      while (true)
      {
        return;
        paramBundle.remove("_sn");
      }
    paramBundle.remove("_sn");
    paramBundle.remove("_sc");
    paramBundle.remove("_si");
  }

  private final void zza(zzdx paramzzdx, boolean paramBoolean)
  {
    zzgi().zzm(zzbx().elapsedRealtime());
    if (zzgo().zza(paramzzdx.zzars, paramBoolean))
      paramzzdx.zzars = false;
  }

  @VisibleForTesting
  private static String zzcq(String paramString)
  {
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length > 0);
    for (String str = arrayOfString[(-1 + arrayOfString.length)]; ; str = "")
    {
      if (str.length() > 100)
        str = str.substring(0, 100);
      return str;
    }
  }

  private final zzdx zze(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity);
    zzdx localzzdx = (zzdx)this.zzarw.get(paramActivity);
    if (localzzdx == null)
    {
      localzzdx = new zzdx(null, zzcq(paramActivity.getClass().getCanonicalName()), zzgr().zzmj());
      this.zzarw.put(paramActivity, localzzdx);
    }
    return localzzdx;
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle == null);
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramBundle.getBundle("com.google.app_measurement.screen_service");
    }
    while (localBundle == null);
    zzdx localzzdx = new zzdx(localBundle.getString("name"), localBundle.getString("referrer_name"), localBundle.getLong("id"));
    this.zzarw.put(paramActivity, localzzdx);
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.zzarw.remove(paramActivity);
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    zzdx localzzdx = zze(paramActivity);
    this.zzarv = this.zzaru;
    this.zzaru = null;
    zzgs().zzc(new zzea(this, localzzdx));
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    zza(paramActivity, zze(paramActivity), false);
    zza localzza = zzgi();
    long l = localzza.zzbx().elapsedRealtime();
    localzza.zzgs().zzc(new zzd(localzza, l));
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle == null);
    zzdx localzzdx;
    do
    {
      return;
      localzzdx = (zzdx)this.zzarw.get(paramActivity);
    }
    while (localzzdx == null);
    Bundle localBundle = new Bundle();
    localBundle.putLong("id", localzzdx.zzarr);
    localBundle.putString("name", localzzdx.zzuw);
    localBundle.putString("referrer_name", localzzdx.zzarq);
    paramBundle.putBundle("com.google.app_measurement.screen_service", localBundle);
  }

  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    if (this.zzaru == null)
    {
      zzgt().zzjj().zzby("setCurrentScreen cannot be called while no activity active");
      return;
    }
    if (this.zzarw.get(paramActivity) == null)
    {
      zzgt().zzjj().zzby("setCurrentScreen must be called with an activity in the activity lifecycle");
      return;
    }
    if (paramString2 == null)
      paramString2 = zzcq(paramActivity.getClass().getCanonicalName());
    boolean bool1 = this.zzaru.zzarq.equals(paramString2);
    boolean bool2 = zzfx.zzv(this.zzaru.zzuw, paramString1);
    if ((bool1) && (bool2))
    {
      zzgt().zzjl().zzby("setCurrentScreen cannot be called with the same class and name");
      return;
    }
    if ((paramString1 != null) && ((paramString1.length() <= 0) || (paramString1.length() > 100)))
    {
      zzgt().zzjj().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(paramString1.length()));
      return;
    }
    if ((paramString2 != null) && ((paramString2.length() <= 0) || (paramString2.length() > 100)))
    {
      zzgt().zzjj().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(paramString2.length()));
      return;
    }
    zzau localzzau = zzgt().zzjo();
    if (paramString1 == null);
    for (String str = "null"; ; str = paramString1)
    {
      localzzau.zze("Setting current screen to name, class", str, paramString2);
      zzdx localzzdx = new zzdx(paramString1, paramString2, zzgr().zzmj());
      this.zzarw.put(paramActivity, localzzdx);
      zza(paramActivity, localzzdx, true);
      return;
    }
  }

  public final void zza(String paramString, zzdx paramzzdx)
  {
    zzaf();
    try
    {
      if ((this.zzary == null) || (this.zzary.equals(paramString)) || (paramzzdx != null))
      {
        this.zzary = paramString;
        this.zzarx = paramzzdx;
      }
      return;
    }
    finally
    {
    }
  }

  protected final boolean zzgy()
  {
    return false;
  }

  public final zzdx zzle()
  {
    zzcl();
    zzaf();
    return this.zzart;
  }

  public final zzdx zzlf()
  {
    zzgg();
    return this.zzaru;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzdy
 * JD-Core Version:    0.6.2
 */