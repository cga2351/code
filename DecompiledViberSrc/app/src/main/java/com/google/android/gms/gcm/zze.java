package com.google.android.gms.gcm;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zze
  implements ThreadFactory
{
  private final AtomicInteger zzy = new AtomicInteger(1);

  zze(GcmTaskService paramGcmTaskService)
  {
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    int i = this.zzy.getAndIncrement();
    Thread localThread = new Thread(paramRunnable, 20 + "gcm-task#" + i);
    localThread.setPriority(4);
    return localThread;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.zze
 * JD-Core Version:    0.6.2
 */