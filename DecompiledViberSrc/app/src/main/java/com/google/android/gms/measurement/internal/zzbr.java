package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbr extends zzcs
{
  private static final AtomicLong zzapc = new AtomicLong(-9223372036854775808L);
  private ExecutorService zzadl;
  private zzbv zzaot;
  private zzbv zzaou;
  private final PriorityBlockingQueue<zzbu<?>> zzaov = new PriorityBlockingQueue();
  private final BlockingQueue<zzbu<?>> zzaow = new LinkedBlockingQueue();
  private final Thread.UncaughtExceptionHandler zzaox = new zzbt(this, "Thread death: Uncaught exception on worker thread");
  private final Thread.UncaughtExceptionHandler zzaoy = new zzbt(this, "Thread death: Uncaught exception on network thread");
  private final Object zzaoz = new Object();
  private final Semaphore zzapa = new Semaphore(2);
  private volatile boolean zzapb;

  zzbr(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  private final void zza(zzbu<?> paramzzbu)
  {
    synchronized (this.zzaoz)
    {
      this.zzaov.add(paramzzbu);
      if (this.zzaot == null)
      {
        this.zzaot = new zzbv(this, "Measurement Worker", this.zzaov);
        this.zzaot.setUncaughtExceptionHandler(this.zzaox);
        this.zzaot.start();
        return;
      }
      this.zzaot.zzki();
    }
  }

  final <T> T zza(AtomicReference<T> paramAtomicReference, long paramLong, String paramString, Runnable paramRunnable)
  {
    while (true)
    {
      try
      {
        zzgs().zzc(paramRunnable);
        zzau localzzau1;
        String str1;
        try
        {
          paramAtomicReference.wait(15000L);
          Object localObject2 = paramAtomicReference.get();
          if (localObject2 == null)
          {
            zzau localzzau2 = zzgt().zzjj();
            String str3 = String.valueOf(paramString);
            if (str3.length() == 0)
              break label141;
            str4 = "Timed out waiting for ".concat(str3);
            localzzau2.zzby(str4);
          }
          return localObject2;
        }
        catch (InterruptedException localInterruptedException)
        {
          localzzau1 = zzgt().zzjj();
          str1 = String.valueOf(paramString);
          if (str1.length() == 0)
            break label127;
        }
        str2 = "Interrupted waiting for ".concat(str1);
        localzzau1.zzby(str2);
        return null;
      }
      finally
      {
      }
      label127: String str2 = new String("Interrupted waiting for ");
      continue;
      label141: String str4 = new String("Timed out waiting for ");
    }
  }

  public final void zzaf()
  {
    if (Thread.currentThread() != this.zzaot)
      throw new IllegalStateException("Call expected from worker thread");
  }

  public final <V> Future<V> zzb(Callable<V> paramCallable)
    throws IllegalStateException
  {
    zzcl();
    Preconditions.checkNotNull(paramCallable);
    zzbu localzzbu = new zzbu(this, paramCallable, false, "Task exception on worker thread");
    if (Thread.currentThread() == this.zzaot)
    {
      if (!this.zzaov.isEmpty())
        zzgt().zzjj().zzby("Callable skipped the worker queue.");
      localzzbu.run();
      return localzzbu;
    }
    zza(localzzbu);
    return localzzbu;
  }

  public final <V> Future<V> zzc(Callable<V> paramCallable)
    throws IllegalStateException
  {
    zzcl();
    Preconditions.checkNotNull(paramCallable);
    zzbu localzzbu = new zzbu(this, paramCallable, true, "Task exception on worker thread");
    if (Thread.currentThread() == this.zzaot)
    {
      localzzbu.run();
      return localzzbu;
    }
    zza(localzzbu);
    return localzzbu;
  }

  public final void zzc(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzcl();
    Preconditions.checkNotNull(paramRunnable);
    zza(new zzbu(this, paramRunnable, false, "Task exception on worker thread"));
  }

  public final void zzd(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzcl();
    Preconditions.checkNotNull(paramRunnable);
    zzbu localzzbu = new zzbu(this, paramRunnable, false, "Task exception on network thread");
    synchronized (this.zzaoz)
    {
      this.zzaow.add(localzzbu);
      if (this.zzaou == null)
      {
        this.zzaou = new zzbv(this, "Measurement Network", this.zzaow);
        this.zzaou.setUncaughtExceptionHandler(this.zzaoy);
        this.zzaou.start();
        return;
      }
      this.zzaou.zzki();
    }
  }

  public final void zzgh()
  {
    if (Thread.currentThread() != this.zzaou)
      throw new IllegalStateException("Call expected from network thread");
  }

  protected final boolean zzgy()
  {
    return false;
  }

  public final boolean zzkf()
  {
    return Thread.currentThread() == this.zzaot;
  }

  public final ExecutorService zzkg()
  {
    synchronized (this.zzaoz)
    {
      if (this.zzadl == null)
        this.zzadl = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
      ExecutorService localExecutorService = this.zzadl;
      return localExecutorService;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbr
 * JD-Core Version:    0.6.2
 */