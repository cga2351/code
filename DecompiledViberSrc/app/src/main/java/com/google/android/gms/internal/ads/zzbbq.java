package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

final class zzbbq extends zzbal
{
  private final Executor zzeal;

  private zzbbq(Executor paramExecutor)
  {
    this.zzeal = paramExecutor;
  }

  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public final void execute(Runnable paramRunnable)
  {
    this.zzeal.execute(paramRunnable);
  }

  public final boolean isShutdown()
  {
    return false;
  }

  public final boolean isTerminated()
  {
    return false;
  }

  public final void shutdown()
  {
    throw new UnsupportedOperationException();
  }

  public final List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbq
 * JD-Core Version:    0.6.2
 */