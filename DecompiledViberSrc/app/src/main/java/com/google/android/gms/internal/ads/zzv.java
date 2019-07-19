package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzv
{
  private final zzm zzaa;
  private final AtomicInteger zzba = new AtomicInteger();
  private final Set<zzr<?>> zzbb = new HashSet();
  private final PriorityBlockingQueue<zzr<?>> zzbc = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<zzr<?>> zzbd = new PriorityBlockingQueue();
  private final zzn[] zzbe;
  private final List<zzx> zzbf = new ArrayList();
  private final List<zzw> zzbg = new ArrayList();
  private final zzb zzj;
  private final zzab zzk;
  private zzd zzq;

  public zzv(zzb paramzzb, zzm paramzzm)
  {
    this(paramzzb, paramzzm, 4);
  }

  private zzv(zzb paramzzb, zzm paramzzm, int paramInt)
  {
    this(paramzzb, paramzzm, 4, new zzi(new Handler(Looper.getMainLooper())));
  }

  private zzv(zzb paramzzb, zzm paramzzm, int paramInt, zzab paramzzab)
  {
    this.zzj = paramzzb;
    this.zzaa = paramzzm;
    this.zzbe = new zzn[4];
    this.zzk = paramzzab;
  }

  public final void start()
  {
    int i = 0;
    if (this.zzq != null)
      this.zzq.quit();
    for (zzn localzzn2 : this.zzbe)
      if (localzzn2 != null)
        localzzn2.quit();
    this.zzq = new zzd(this.zzbc, this.zzbd, this.zzj, this.zzk);
    this.zzq.start();
    while (i < this.zzbe.length)
    {
      zzn localzzn1 = new zzn(this.zzbd, this.zzaa, this.zzj, this.zzk);
      this.zzbe[i] = localzzn1;
      localzzn1.start();
      i++;
    }
  }

  final void zza(zzr<?> paramzzr, int paramInt)
  {
    synchronized (this.zzbg)
    {
      Iterator localIterator = this.zzbg.iterator();
      if (localIterator.hasNext())
        ((zzw)localIterator.next()).zzb(paramzzr, paramInt);
    }
  }

  public final <T> zzr<T> zze(zzr<T> paramzzr)
  {
    paramzzr.zza(this);
    synchronized (this.zzbb)
    {
      this.zzbb.add(paramzzr);
      paramzzr.zzb(this.zzba.incrementAndGet());
      paramzzr.zzb("add-to-queue");
      zza(paramzzr, 0);
      if (!paramzzr.zzh())
      {
        this.zzbd.add(paramzzr);
        return paramzzr;
      }
    }
    this.zzbc.add(paramzzr);
    return paramzzr;
  }

  final <T> void zzf(zzr<T> paramzzr)
  {
    synchronized (this.zzbb)
    {
      this.zzbb.remove(paramzzr);
      synchronized (this.zzbf)
      {
        Iterator localIterator = this.zzbf.iterator();
        if (localIterator.hasNext())
          ((zzx)localIterator.next()).zzg(paramzzr);
      }
    }
    zza(paramzzr, 5);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzv
 * JD-Core Version:    0.6.2
 */