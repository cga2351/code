package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbbd<V>
{
  private final zzbbs<Void> zzdzx = new zzbbs();

  zzbbd(Iterable<? extends zzbbi<? extends V>> paramIterable)
  {
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    Iterator localIterator1 = paramIterable.iterator();
    while (localIterator1.hasNext())
    {
      zzbbi localzzbbi = (zzbbi)localIterator1.next();
      localAtomicInteger.incrementAndGet();
      zzbas.zzb(this.zzdzx, localzzbbi);
    }
    if (localAtomicInteger.get() == 0)
      this.zzdzx.set(null);
    while (true)
    {
      return;
      Iterator localIterator2 = paramIterable.iterator();
      while (localIterator2.hasNext())
        ((zzbbi)localIterator2.next()).zza(new zzbbe(this, localAtomicInteger), zzbbn.zzeah);
    }
  }

  public final <C> zzbbi<C> zza(Callable<C> paramCallable, Executor paramExecutor)
  {
    return zzbas.zza(this.zzdzx, new zzbbf(paramCallable), paramExecutor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbd
 * JD-Core Version:    0.6.2
 */