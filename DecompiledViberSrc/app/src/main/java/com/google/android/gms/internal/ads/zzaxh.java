package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzare
public final class zzaxh
{
  public static final zzbbm zzdvr = zzbbn.zza(new ThreadPoolExecutor(2, 2147483647, 10L, TimeUnit.SECONDS, new SynchronousQueue(), zzdx("Default")));
  public static final zzbbm zzdvs = zzbbn.zza(localThreadPoolExecutor);
  public static final ScheduledExecutorService zzdvt = new ScheduledThreadPoolExecutor(3, zzdx("Schedule"));

  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzdx("Loader"));
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
  }

  public static <T> zzbbi<T> zza(Callable<T> paramCallable)
  {
    return zzdvr.zza(paramCallable);
  }

  public static zzbbi<?> zzc(Runnable paramRunnable)
  {
    return zzdvr.zze(paramRunnable);
  }

  private static ThreadFactory zzdx(String paramString)
  {
    return new zzaxi(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxh
 * JD-Core Version:    0.6.2
 */