package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread
{
  private static final boolean DEBUG = zzag.DEBUG;
  private final BlockingQueue<zzr<?>> zzh;
  private final BlockingQueue<zzr<?>> zzi;
  private final zzb zzj;
  private final zzab zzk;
  private volatile boolean zzl = false;
  private final zzf zzm;

  public zzd(BlockingQueue<zzr<?>> paramBlockingQueue1, BlockingQueue<zzr<?>> paramBlockingQueue2, zzb paramzzb, zzab paramzzab)
  {
    this.zzh = paramBlockingQueue1;
    this.zzi = paramBlockingQueue2;
    this.zzj = paramzzb;
    this.zzk = paramzzab;
    this.zzm = new zzf(this);
  }

  private final void processRequest()
    throws InterruptedException
  {
    int i = 1;
    zzr localzzr = (zzr)this.zzh.take();
    localzzr.zzb("cache-queue-take");
    localzzr.zza(i);
    while (true)
    {
      zzy localzzy;
      try
      {
        localzzr.isCanceled();
        zzc localzzc = this.zzj.zza(localzzr.zze());
        if (localzzc == null)
        {
          localzzr.zzb("cache-miss");
          if (!zzf.zza(this.zzm, localzzr))
            this.zzi.put(localzzr);
          return;
        }
        if (localzzc.isExpired())
        {
          localzzr.zzb("cache-hit-expired");
          localzzr.zza(localzzc);
          if (!zzf.zza(this.zzm, localzzr))
            this.zzi.put(localzzr);
          return;
        }
        localzzr.zzb("cache-hit");
        localzzy = localzzr.zza(new zzp(localzzc.data, localzzc.zzf));
        localzzr.zzb("cache-hit-parsed");
        if (localzzc.zze < System.currentTimeMillis())
        {
          if (i == 0)
            this.zzk.zzb(localzzr, localzzy);
        }
        else
        {
          i = 0;
          continue;
        }
        localzzr.zzb("cache-hit-refresh-needed");
        localzzr.zza(localzzc);
        localzzy.zzbj = true;
        if (!zzf.zza(this.zzm, localzzr))
        {
          this.zzk.zza(localzzr, localzzy, new zze(this, localzzr));
          continue;
        }
      }
      finally
      {
        localzzr.zza(2);
      }
      this.zzk.zzb(localzzr, localzzy);
    }
  }

  public final void quit()
  {
    this.zzl = true;
    interrupt();
  }

  public final void run()
  {
    if (DEBUG)
      zzag.v("start new dispatcher", new Object[0]);
    Process.setThreadPriority(10);
    this.zzj.zza();
    while (true)
      try
      {
        processRequest();
      }
      catch (InterruptedException localInterruptedException)
      {
        if (this.zzl)
        {
          Thread.currentThread().interrupt();
          return;
        }
        zzag.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzd
 * JD-Core Version:    0.6.2
 */