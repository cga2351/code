package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzavv
  implements ThreadFactory
{
  private final AtomicInteger zzxw = new AtomicInteger(1);

  zzavv(zzavh paramzzavh)
  {
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    int i = this.zzxw.getAndIncrement();
    return new Thread(paramRunnable, 42 + "AdWorker(SCION_TASK_EXECUTOR) #" + i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzavv
 * JD-Core Version:    0.6.2
 */