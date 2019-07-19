package com.google.android.gms.common.api;

public abstract class TransformedResult<R extends Result>
{
  public abstract void andFinally(ResultCallbacks<? super R> paramResultCallbacks);

  public abstract <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.TransformedResult
 * JD-Core Version:    0.6.2
 */