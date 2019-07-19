package com.google.android.gms.common.util.concurrent;

import android.os.Process;

final class zza
  implements Runnable
{
  private final int priority;
  private final Runnable zzhs;

  public zza(Runnable paramRunnable, int paramInt)
  {
    this.zzhs = paramRunnable;
    this.priority = paramInt;
  }

  public final void run()
  {
    Process.setThreadPriority(this.priority);
    this.zzhs.run();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.zza
 * JD-Core Version:    0.6.2
 */