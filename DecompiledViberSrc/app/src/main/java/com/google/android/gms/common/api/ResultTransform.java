package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.zacd;

public abstract class ResultTransform<R extends Result, S extends Result>
{
  public final PendingResult<S> createFailedResult(Status paramStatus)
  {
    return new zacd(paramStatus);
  }

  public Status onFailure(Status paramStatus)
  {
    return paramStatus;
  }

  public abstract PendingResult<S> onSuccess(R paramR);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ResultTransform
 * JD-Core Version:    0.6.2
 */