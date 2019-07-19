package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcwp
  implements zzcuz<zzcwo>
{
  private ApplicationInfo applicationInfo;
  private boolean zzdow;
  private ScheduledExecutorService zzfiw;
  private zzamh zzgjk;

  public zzcwp(zzamh paramzzamh, ScheduledExecutorService paramScheduledExecutorService, boolean paramBoolean, ApplicationInfo paramApplicationInfo)
  {
    this.zzgjk = paramzzamh;
    this.zzfiw = paramScheduledExecutorService;
    this.zzdow = paramBoolean;
    this.applicationInfo = paramApplicationInfo;
  }

  public final zzbbi<zzcwo> zzalm()
  {
    if (!this.zzdow)
      return zzbas.zzd(new Exception("Auto Collect Location is false."));
    zzbbi localzzbbi = this.zzgjk.zza(this.applicationInfo);
    zzaci localzzaci = zzact.zzcsr;
    return zzbas.zza(zzbas.zza(localzzbbi, ((Long)zzyr.zzpe().zzd(localzzaci)).longValue(), TimeUnit.MILLISECONDS, this.zzfiw), zzcwq.zzdrp, zzaxh.zzdvr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcwp
 * JD-Core Version:    0.6.2
 */