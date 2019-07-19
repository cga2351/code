package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcwt
  implements zzcuz<zzcws>
{
  private ScheduledExecutorService zzfiw;
  private zzaqn zzgjn;
  private Context zzlj;

  public zzcwt(zzaqn paramzzaqn, ScheduledExecutorService paramScheduledExecutorService, Context paramContext)
  {
    this.zzgjn = paramzzaqn;
    this.zzfiw = paramScheduledExecutorService;
    this.zzlj = paramContext;
  }

  public final zzbbi<zzcws> zzalm()
  {
    zzbbi localzzbbi = this.zzgjn.zzn(this.zzlj);
    zzaci localzzaci = zzact.zzcth;
    return zzbas.zza(zzbas.zza(localzzbbi, ((Long)zzyr.zzpe().zzd(localzzaci)).longValue(), TimeUnit.MILLISECONDS, this.zzfiw), zzcwu.zzdrp, zzaxh.zzdvr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcwt
 * JD-Core Version:    0.6.2
 */