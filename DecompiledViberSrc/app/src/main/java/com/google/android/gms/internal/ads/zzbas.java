package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zzare
public final class zzbas
{
  public static <V> zzbbd<V> zza(zzbbi<? extends V>[] paramArrayOfzzbbi)
  {
    return zzf(Arrays.asList(paramArrayOfzzbbi));
  }

  public static <V> zzbbi<V> zza(zzbbi<V> paramzzbbi, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService)
  {
    zzbbs localzzbbs = new zzbbs();
    zza(localzzbbs, paramzzbbi);
    ScheduledFuture localScheduledFuture = paramScheduledExecutorService.schedule(new zzbay(localzzbbs), paramLong, paramTimeUnit);
    zza(paramzzbbi, localzzbbs);
    localzzbbs.zza(new zzbaz(localScheduledFuture), zzbbn.zzeah);
    return localzzbbs;
  }

  public static <A, B> zzbbi<B> zza(zzbbi<A> paramzzbbi, zzbam<? super A, ? extends B> paramzzbam, Executor paramExecutor)
  {
    zzbbs localzzbbs = new zzbbs();
    paramzzbbi.zza(new zzbav(localzzbbs, paramzzbam, paramzzbbi), paramExecutor);
    zza(localzzbbs, paramzzbbi);
    return localzzbbs;
  }

  public static <A, B> zzbbi<B> zza(zzbbi<A> paramzzbbi, zzban<A, B> paramzzban, Executor paramExecutor)
  {
    zzbbs localzzbbs = new zzbbs();
    paramzzbbi.zza(new zzbau(localzzbbs, paramzzban, paramzzbbi), paramExecutor);
    zza(localzzbbs, paramzzbbi);
    return localzzbbs;
  }

  public static <V, X extends Throwable> zzbbi<V> zza(zzbbi<? extends V> paramzzbbi, Class<X> paramClass, zzbam<? super X, ? extends V> paramzzbam, Executor paramExecutor)
  {
    zzbbs localzzbbs = new zzbbs();
    zza(localzzbbs, paramzzbbi);
    paramzzbbi.zza(new zzbba(localzzbbs, paramzzbbi, paramClass, paramzzbam, paramExecutor), zzbbn.zzeah);
    return localzzbbs;
  }

  public static <V> void zza(zzbbi<V> paramzzbbi, zzbao<? super V> paramzzbao, Executor paramExecutor)
  {
    paramzzbbi.zza(new zzbat(paramzzbao, paramzzbbi), paramExecutor);
  }

  private static <V> void zza(zzbbi<? extends V> paramzzbbi, zzbbs<V> paramzzbbs)
  {
    zza(paramzzbbs, paramzzbbi);
    paramzzbbi.zza(new zzbbb(paramzzbbs, paramzzbbi), zzbbn.zzeah);
  }

  private static <A, B> void zza(zzbbi<A> paramzzbbi, Future<B> paramFuture)
  {
    paramzzbbi.zza(new zzbbc(paramzzbbi, paramFuture), zzbbn.zzeah);
  }

  public static <T> zzbbg<T> zzd(Throwable paramThrowable)
  {
    return new zzbbg(paramThrowable);
  }

  public static <V> zzbbi<List<V>> zze(Iterable<? extends zzbbi<? extends V>> paramIterable)
  {
    zzbbs localzzbbs = new zzbbs();
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    Iterator localIterator1 = paramIterable.iterator();
    while (localIterator1.hasNext())
    {
      zzbbi localzzbbi2 = (zzbbi)localIterator1.next();
      localAtomicInteger.incrementAndGet();
      zza(localzzbbs, localzzbbi2);
    }
    zzbaw localzzbaw = new zzbaw(paramIterable, localzzbbs);
    Iterator localIterator2 = paramIterable.iterator();
    while (localIterator2.hasNext())
    {
      zzbbi localzzbbi1 = (zzbbi)localIterator2.next();
      localzzbbi1.zza(new zzbax(localzzbbi1, localAtomicInteger, localzzbaw, localzzbbs), zzbbn.zzeah);
    }
    return localzzbbs;
  }

  public static <V> zzbbd<V> zzf(Iterable<? extends zzbbi<? extends V>> paramIterable)
  {
    return new zzbbd(paramIterable);
  }

  public static <T> zzbbh<T> zzm(T paramT)
  {
    return new zzbbh(paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbas
 * JD-Core Version:    0.6.2
 */