package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzdz
  implements ThreadFactory
{
  private final ThreadFactory zzxv = Executors.defaultThreadFactory();
  private final AtomicInteger zzxw = new AtomicInteger(1);

  public final Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = this.zzxv.newThread(paramRunnable);
    int i = this.zzxw.getAndIncrement();
    localThread.setName(16 + "gads-" + i);
    return localThread;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdz
 * JD-Core Version:    0.6.2
 */