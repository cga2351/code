package com.google.android.gms.internal.auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzo extends zzg
{
  private BaseImplementation.ResultHolder<Status> zzap;

  zzo(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.zzap = paramResultHolder;
  }

  public final void zzc(Status paramStatus)
  {
    this.zzap.setResult(paramStatus);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzo
 * JD-Core Version:    0.6.2
 */