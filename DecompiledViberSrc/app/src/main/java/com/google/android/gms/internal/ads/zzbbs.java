package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
public class zzbbs<T>
  implements zzbbi<T>
{
  private final Object lock = new Object();

  @GuardedBy("lock")
  private T value;
  private final zzbbj zzeaa = new zzbbj();

  @GuardedBy("lock")
  private Throwable zzean;

  @GuardedBy("lock")
  private boolean zzeao;

  @GuardedBy("lock")
  private boolean zzeap;

  @GuardedBy("lock")
  private final boolean zzxf()
  {
    return (this.zzean != null) || (this.zzeao);
  }

  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean)
      return false;
    synchronized (this.lock)
    {
      if (zzxf())
        return false;
    }
    this.zzeap = true;
    this.zzeao = true;
    this.lock.notifyAll();
    this.zzeaa.zzxd();
    return true;
  }

  public T get()
    throws CancellationException, ExecutionException, InterruptedException
  {
    synchronized (this.lock)
    {
      if (!zzxf())
        this.lock.wait();
    }
    if (this.zzean != null)
      throw new ExecutionException(this.zzean);
    if (this.zzeap)
      throw new CancellationException("SettableFuture was cancelled.");
    Object localObject3 = this.value;
    return localObject3;
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    synchronized (this.lock)
    {
      long l1 = paramTimeUnit.toMillis(paramLong);
      long l2 = System.currentTimeMillis();
      long l3 = l1 + l2;
      while ((!zzxf()) && (l2 < l3))
      {
        this.lock.wait(l3 - l2);
        l2 = System.currentTimeMillis();
      }
      if (this.zzeap)
        throw new CancellationException("SettableFuture was cancelled.");
    }
    if (this.zzean != null)
      throw new ExecutionException(this.zzean);
    if (!this.zzeao)
      throw new TimeoutException("SettableFuture timed out.");
    Object localObject3 = this.value;
    return localObject3;
  }

  public boolean isCancelled()
  {
    synchronized (this.lock)
    {
      boolean bool = this.zzeap;
      return bool;
    }
  }

  public boolean isDone()
  {
    synchronized (this.lock)
    {
      boolean bool = zzxf();
      return bool;
    }
  }

  public final void set(T paramT)
  {
    synchronized (this.lock)
    {
      if (this.zzeap)
        return;
      if (zzxf())
      {
        zzk.zzlk().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
        return;
      }
    }
    this.zzeao = true;
    this.value = paramT;
    this.lock.notifyAll();
    this.zzeaa.zzxd();
  }

  public final void setException(Throwable paramThrowable)
  {
    synchronized (this.lock)
    {
      if (this.zzeap)
        return;
      if (zzxf())
      {
        zzk.zzlk().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
        return;
      }
    }
    this.zzean = paramThrowable;
    this.lock.notifyAll();
    this.zzeaa.zzxd();
  }

  public final void zza(Runnable paramRunnable, Executor paramExecutor)
  {
    this.zzeaa.zza(paramRunnable, paramExecutor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbs
 * JD-Core Version:    0.6.2
 */