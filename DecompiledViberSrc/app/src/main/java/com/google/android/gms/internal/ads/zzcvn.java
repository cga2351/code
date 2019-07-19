package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcvn
  implements zzcuz<zzcvm>
{
  private final Executor zzfiv;
  private final ScheduledExecutorService zzfiw;
  private final zzawj zzgir;
  private final Context zzlj;

  public zzcvn(zzawj paramzzawj, Context paramContext, ScheduledExecutorService paramScheduledExecutorService, Executor paramExecutor)
  {
    this.zzgir = paramzzawj;
    this.zzlj = paramContext;
    this.zzfiw = paramScheduledExecutorService;
    this.zzfiv = paramExecutor;
  }

  public final zzbbi<zzcvm> zzalm()
  {
    zzaci localzzaci1 = zzact.zzcpa;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
    {
      zzbbs localzzbbs = new zzbbs();
      zzbbi localzzbbi = this.zzgir.zzag(this.zzlj);
      localzzbbi.zza(new zzcvo(this, localzzbbi, localzzbbs), this.zzfiv);
      ScheduledExecutorService localScheduledExecutorService = this.zzfiw;
      zzcvp localzzcvp = new zzcvp(localzzbbi);
      zzaci localzzaci2 = zzact.zzcpb;
      localScheduledExecutorService.schedule(localzzcvp, ((Long)zzyr.zzpe().zzd(localzzaci2)).longValue(), TimeUnit.MILLISECONDS);
      return localzzbbs;
    }
    return zzbas.zzd(new Exception("Did not ad Ad ID into query param."));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcvn
 * JD-Core Version:    0.6.2
 */