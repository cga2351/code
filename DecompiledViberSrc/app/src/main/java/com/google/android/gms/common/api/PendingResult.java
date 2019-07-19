package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public abstract class PendingResult<R extends Result>
{
  @KeepForSdk
  public void addStatusListener(StatusListener paramStatusListener)
  {
    throw new UnsupportedOperationException();
  }

  public abstract R await();

  public abstract R await(long paramLong, TimeUnit paramTimeUnit);

  public abstract void cancel();

  public abstract boolean isCanceled();

  public abstract void setResultCallback(ResultCallback<? super R> paramResultCallback);

  public abstract void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit);

  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    throw new UnsupportedOperationException();
  }

  public Integer zam()
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  public static abstract interface StatusListener
  {
    @KeepForSdk
    public abstract void onComplete(Status paramStatus);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResult
 * JD-Core Version:    0.6.2
 */