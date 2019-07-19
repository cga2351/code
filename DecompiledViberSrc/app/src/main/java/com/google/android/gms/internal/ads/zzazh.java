package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

@zzare
public final class zzazh
{
  private Handler handler = null;
  private final Object lock = new Object();
  private HandlerThread zzdxu = null;
  private int zzdxv = 0;

  public final Handler getHandler()
  {
    return this.handler;
  }

  public final Looper zzwr()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.zzdxv == 0)
        {
          if (this.zzdxu == null)
          {
            zzaxa.zzds("Starting the looper thread.");
            this.zzdxu = new HandlerThread("LooperProvider");
            this.zzdxu.start();
            this.handler = new zzdbg(this.zzdxu.getLooper());
            zzaxa.zzds("Looper thread started.");
            this.zzdxv = (1 + this.zzdxv);
            Looper localLooper = this.zzdxu.getLooper();
            return localLooper;
          }
          zzaxa.zzds("Resuming the looper thread");
          this.lock.notifyAll();
        }
      }
      Preconditions.checkNotNull(this.zzdxu, "Invalid state: mHandlerThread should already been initialized.");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazh
 * JD-Core Version:    0.6.2
 */