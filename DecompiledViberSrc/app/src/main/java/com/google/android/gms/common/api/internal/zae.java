package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab
{
  private final A zacn;

  public zae(int paramInt, A paramA)
  {
    super(paramInt);
    this.zacn = paramA;
  }

  public final void zaa(Status paramStatus)
  {
    this.zacn.setFailedResult(paramStatus);
  }

  public final void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException
  {
    try
    {
      this.zacn.run(paramzaa.zaab());
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zaa(localRuntimeException);
    }
  }

  public final void zaa(zaab paramzaab, boolean paramBoolean)
  {
    paramzaab.zaa(this.zacn, paramBoolean);
  }

  public final void zaa(RuntimeException paramRuntimeException)
  {
    String str1 = paramRuntimeException.getClass().getSimpleName();
    String str2 = paramRuntimeException.getLocalizedMessage();
    Status localStatus = new Status(10, 2 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + ": " + str2);
    this.zacn.setFailedResult(localStatus);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zae
 * JD-Core Version:    0.6.2
 */