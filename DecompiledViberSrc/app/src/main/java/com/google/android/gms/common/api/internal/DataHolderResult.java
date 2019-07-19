package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public class DataHolderResult
  implements Releasable, Result
{

  @KeepForSdk
  protected final DataHolder mDataHolder;

  @KeepForSdk
  protected final Status mStatus;

  @KeepForSdk
  protected DataHolderResult(DataHolder paramDataHolder)
  {
    this(paramDataHolder, new Status(paramDataHolder.getStatusCode()));
  }

  @KeepForSdk
  protected DataHolderResult(DataHolder paramDataHolder, Status paramStatus)
  {
    this.mStatus = paramStatus;
    this.mDataHolder = paramDataHolder;
  }

  @KeepForSdk
  public Status getStatus()
  {
    return this.mStatus;
  }

  @KeepForSdk
  public void release()
  {
    if (this.mDataHolder != null)
      this.mDataHolder.close();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.DataHolderResult
 * JD-Core Version:    0.6.2
 */