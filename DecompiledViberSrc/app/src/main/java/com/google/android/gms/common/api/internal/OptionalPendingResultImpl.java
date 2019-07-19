package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R>
{
  private final BasePendingResult<R> zajp;

  public OptionalPendingResultImpl(PendingResult<R> paramPendingResult)
  {
    this.zajp = ((BasePendingResult)paramPendingResult);
  }

  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    this.zajp.addStatusListener(paramStatusListener);
  }

  public final R await()
  {
    return this.zajp.await();
  }

  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.zajp.await(paramLong, paramTimeUnit);
  }

  public final void cancel()
  {
    this.zajp.cancel();
  }

  public final R get()
  {
    if (isDone())
      return await(0L, TimeUnit.MILLISECONDS);
    throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
  }

  public final boolean isCanceled()
  {
    return this.zajp.isCanceled();
  }

  public final boolean isDone()
  {
    return this.zajp.isReady();
  }

  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    this.zajp.setResultCallback(paramResultCallback);
  }

  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    this.zajp.setResultCallback(paramResultCallback, paramLong, paramTimeUnit);
  }

  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    return this.zajp.then(paramResultTransform);
  }

  public final Integer zam()
  {
    return this.zajp.zam();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.OptionalPendingResultImpl
 * JD-Core Version:    0.6.2
 */