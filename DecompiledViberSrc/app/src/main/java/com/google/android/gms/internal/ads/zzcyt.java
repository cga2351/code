package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzcyt
  implements ThreadFactory
{
  private final AtomicInteger zzxw = new AtomicInteger(1);

  public final Thread newThread(Runnable paramRunnable)
  {
    int i = this.zzxw.getAndIncrement();
    return new Thread(paramRunnable, 25 + "AdWorker(NG) #" + i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcyt
 * JD-Core Version:    0.6.2
 */