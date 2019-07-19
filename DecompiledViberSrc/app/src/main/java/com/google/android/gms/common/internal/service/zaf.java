package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zaf extends zaa
{
  private final BaseImplementation.ResultHolder<Status> mResultHolder;

  public zaf(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.mResultHolder = paramResultHolder;
  }

  public final void zaj(int paramInt)
    throws RemoteException
  {
    this.mResultHolder.setResult(new Status(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.service.zaf
 * JD-Core Version:    0.6.2
 */