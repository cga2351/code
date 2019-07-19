package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzare
final class zzbbg<T>
  implements zzbbi<T>
{
  private final Throwable cause;
  private final zzbbj zzeaa;

  zzbbg(Throwable paramThrowable)
  {
    this.cause = paramThrowable;
    this.zzeaa = new zzbbj();
    this.zzeaa.zzxd();
  }

  public final boolean cancel(boolean paramBoolean)
  {
    return false;
  }

  public final T get()
    throws ExecutionException
  {
    throw new ExecutionException(this.cause);
  }

  public final T get(long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException
  {
    throw new ExecutionException(this.cause);
  }

  public final boolean isCancelled()
  {
    return false;
  }

  public final boolean isDone()
  {
    return true;
  }

  public final void zza(Runnable paramRunnable, Executor paramExecutor)
  {
    this.zzeaa.zza(paramRunnable, paramExecutor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbg
 * JD-Core Version:    0.6.2
 */