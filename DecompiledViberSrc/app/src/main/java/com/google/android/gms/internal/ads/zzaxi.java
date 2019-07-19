package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzaxi
  implements ThreadFactory
{
  private final AtomicInteger zzxw = new AtomicInteger(1);

  zzaxi(String paramString)
  {
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    String str = this.zzdvu;
    int i = this.zzxw.getAndIncrement();
    return new Thread(paramRunnable, 23 + String.valueOf(str).length() + "AdWorker(" + str + ") #" + i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxi
 * JD-Core Version:    0.6.2
 */