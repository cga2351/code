package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult>
{
  private final Object mLock = new Object();
  private int zaaz;
  private boolean zaba;
  private boolean zabb;
  private final PendingResult<?>[] zabc;

  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    this.zaaz = paramList.size();
    this.zabc = new PendingResult[this.zaaz];
    if (paramList.isEmpty())
      setResult(new BatchResult(Status.RESULT_SUCCESS, this.zabc));
    while (true)
    {
      return;
      for (int i = 0; i < paramList.size(); i++)
      {
        PendingResult localPendingResult = (PendingResult)paramList.get(i);
        this.zabc[i] = localPendingResult;
        localPendingResult.addStatusListener(new zaa(this));
      }
    }
  }

  public final void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zabc;
    int i = arrayOfPendingResult.length;
    for (int j = 0; j < i; j++)
      arrayOfPendingResult[j].cancel();
  }

  public final BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.zabc);
  }

  public static final class Builder
  {
    private List<PendingResult<?>> zabe = new ArrayList();
    private GoogleApiClient zabf;

    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.zabf = paramGoogleApiClient;
    }

    public final <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.zabe.size());
      this.zabe.add(paramPendingResult);
      return localBatchResultToken;
    }

    public final Batch build()
    {
      return new Batch(this.zabe, this.zabf, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.6.2
 */