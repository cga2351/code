package com.google.android.gms.internal.firebase_messaging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzc
  implements zzb
{
  public final ExecutorService zza(ThreadFactory paramThreadFactory, int paramInt)
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService(localThreadPoolExecutor);
  }

  public final ScheduledExecutorService zza(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2)
  {
    return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, paramThreadFactory));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzc
 * JD-Core Version:    0.6.2
 */