package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;

@zzare
public abstract class zzbal extends AbstractExecutorService
  implements zzbbm
{
  protected final <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new zzbbl(paramRunnable, paramT);
  }

  protected final <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new zzbbl(paramCallable);
  }

  public final <T> zzbbi<T> zza(Callable<T> paramCallable)
    throws RejectedExecutionException
  {
    return (zzbbi)super.submit(paramCallable);
  }

  public final zzbbi<?> zze(Runnable paramRunnable)
    throws RejectedExecutionException
  {
    return (zzbbi)super.submit(paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbal
 * JD-Core Version:    0.6.2
 */