package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class PendingResults
{
  public static PendingResult<Status> canceledPendingResult()
  {
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.cancel();
    return localStatusPendingResult;
  }

  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Status code must be CommonStatusCodes.CANCELED");
      zaa localzaa = new zaa(paramR);
      localzaa.cancel();
      return localzaa;
    }
  }

  @KeepForSdk
  public static <R extends Result> PendingResult<R> immediateFailedResult(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Status code must not be SUCCESS");
      zab localzab = new zab(paramGoogleApiClient, paramR);
      localzab.setResult(paramR);
      return localzab;
    }
  }

  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    zac localzac = new zac(null);
    localzac.setResult(paramR);
    return new OptionalPendingResultImpl(localzac);
  }

  @KeepForSdk
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramR, "Result must not be null");
    zac localzac = new zac(paramGoogleApiClient);
    localzac.setResult(paramR);
    return new OptionalPendingResultImpl(localzac);
  }

  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(Looper.getMainLooper());
    localStatusPendingResult.setResult(paramStatus);
    return localStatusPendingResult;
  }

  @KeepForSdk
  public static PendingResult<Status> immediatePendingResult(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramStatus, "Result must not be null");
    StatusPendingResult localStatusPendingResult = new StatusPendingResult(paramGoogleApiClient);
    localStatusPendingResult.setResult(paramStatus);
    return localStatusPendingResult;
  }

  private static final class zaa<R extends Result> extends BasePendingResult<R>
  {
    private final R zach;

    public zaa(R paramR)
    {
      super();
      this.zach = paramR;
    }

    protected final R createFailedResult(Status paramStatus)
    {
      if (paramStatus.getStatusCode() != this.zach.getStatus().getStatusCode())
        throw new UnsupportedOperationException("Creating failed results is not supported");
      return this.zach;
    }
  }

  private static final class zab<R extends Result> extends BasePendingResult<R>
  {
    private final R zaci;

    public zab(GoogleApiClient paramGoogleApiClient, R paramR)
    {
      super();
      this.zaci = paramR;
    }

    protected final R createFailedResult(Status paramStatus)
    {
      return this.zaci;
    }
  }

  private static final class zac<R extends Result> extends BasePendingResult<R>
  {
    public zac(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    protected final R createFailedResult(Status paramStatus)
    {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * JD-Core Version:    0.6.2
 */