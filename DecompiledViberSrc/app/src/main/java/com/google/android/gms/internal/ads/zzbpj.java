package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbpj
{
  private volatile boolean zzarx = true;
  private final Executor zzfiv;
  private final ScheduledExecutorService zzfiw;
  private final zzbbi<zzbpg> zzfix;

  public zzbpj(Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, zzbbi<zzbpg> paramzzbbi)
  {
    this.zzfiv = paramExecutor;
    this.zzfiw = paramScheduledExecutorService;
    this.zzfix = paramzzbbi;
  }

  private final void zza(List<? extends zzbbi<? extends zzbpb>> paramList, zzbao<zzbpb> paramzzbao)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.zzfiv.execute(new zzbpk(paramzzbao));
      return;
    }
    zzbbh localzzbbh = zzbas.zzm(null);
    Iterator localIterator = paramList.iterator();
    zzbbi localzzbbi;
    for (Object localObject = localzzbbh; localIterator.hasNext(); localObject = zzbas.zza(zzbas.zza((zzbbi)localObject, Throwable.class, new zzbpl(paramzzbao), this.zzfiv), new zzbpm(this, paramzzbao, localzzbbi), this.zzfiv))
      localzzbbi = (zzbbi)localIterator.next();
    zzbas.zza((zzbbi)localObject, new zzbpo(this, paramzzbao), this.zzfiv);
  }

  private final void zzafz()
  {
    this.zzarx = false;
  }

  public final boolean isLoading()
  {
    return this.zzarx;
  }

  public final void zza(zzbao<zzbpb> paramzzbao)
  {
    zzbas.zza(this.zzfix, new zzbpn(this, paramzzbao), this.zzfiv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbpj
 * JD-Core Version:    0.6.2
 */