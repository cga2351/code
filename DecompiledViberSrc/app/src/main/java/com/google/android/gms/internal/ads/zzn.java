package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzn extends Thread
{
  private final zzm zzaa;
  private final zzb zzj;
  private final zzab zzk;
  private volatile boolean zzl = false;
  private final BlockingQueue<zzr<?>> zzz;

  public zzn(BlockingQueue<zzr<?>> paramBlockingQueue, zzm paramzzm, zzb paramzzb, zzab paramzzab)
  {
    this.zzz = paramBlockingQueue;
    this.zzaa = paramzzm;
    this.zzj = paramzzb;
    this.zzk = paramzzab;
  }

  private final void processRequest()
    throws InterruptedException
  {
    zzr localzzr = (zzr)this.zzz.take();
    long l = SystemClock.elapsedRealtime();
    localzzr.zza(3);
    try
    {
      localzzr.zzb("network-queue-take");
      localzzr.isCanceled();
      TrafficStats.setThreadStatsTag(localzzr.zzd());
      zzp localzzp = this.zzaa.zzc(localzzr);
      localzzr.zzb("network-http-complete");
      if ((localzzp.zzac) && (localzzr.zzl()))
      {
        localzzr.zzc("not-modified");
        localzzr.zzm();
        return;
      }
      zzy localzzy = localzzr.zza(localzzp);
      localzzr.zzb("network-parse-complete");
      if ((localzzr.zzh()) && (localzzy.zzbh != null))
      {
        this.zzj.zza(localzzr.zze(), localzzy.zzbh);
        localzzr.zzb("network-cache-written");
      }
      localzzr.zzk();
      this.zzk.zzb(localzzr, localzzy);
      localzzr.zza(localzzy);
      return;
    }
    catch (zzaf localzzaf2)
    {
      localzzaf2.zza(SystemClock.elapsedRealtime() - l);
      this.zzk.zza(localzzr, localzzaf2);
      localzzr.zzm();
      return;
    }
    catch (Exception localException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localException.toString();
      zzag.zza(localException, "Unhandled exception %s", arrayOfObject);
      zzaf localzzaf1 = new zzaf(localException);
      localzzaf1.zza(SystemClock.elapsedRealtime() - l);
      this.zzk.zza(localzzr, localzzaf1);
      localzzr.zzm();
      return;
    }
    finally
    {
      localzzr.zza(4);
    }
  }

  public final void quit()
  {
    this.zzl = true;
    interrupt();
  }

  public final void run()
  {
    Process.setThreadPriority(10);
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
        zzag.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzn
 * JD-Core Version:    0.6.2
 */