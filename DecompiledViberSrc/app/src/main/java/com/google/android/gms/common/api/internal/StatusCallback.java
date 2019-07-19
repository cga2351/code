package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class StatusCallback extends IStatusCallback.Stub
{

  @KeepForSdk
  private final BaseImplementation.ResultHolder<Status> mResultHolder;

  @KeepForSdk
  public StatusCallback(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.mResultHolder = paramResultHolder;
  }

  @KeepForSdk
  public void onResult(Status paramStatus)
  {
    this.mResultHolder.setResult(paramStatus);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.StatusCallback
 * JD-Core Version:    0.6.2
 */