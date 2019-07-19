package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag<ResultT> extends zac
{
  private final TaskCompletionSource<ResultT> zacm;
  private final TaskApiCall<Api.AnyClient, ResultT> zacq;
  private final StatusExceptionMapper zacr;

  public zag(int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper)
  {
    super(paramInt);
    this.zacm = paramTaskCompletionSource;
    this.zacq = paramTaskApiCall;
    this.zacr = paramStatusExceptionMapper;
  }

  public final void zaa(Status paramStatus)
  {
    this.zacm.trySetException(this.zacr.getException(paramStatus));
  }

  public final void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException
  {
    try
    {
      this.zacq.doExecute(paramzaa.zaab(), this.zacm);
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      throw localDeadObjectException;
    }
    catch (RemoteException localRemoteException)
    {
      zaa(zab.zab(localRemoteException));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zaa(localRuntimeException);
    }
  }

  public final void zaa(zaab paramzaab, boolean paramBoolean)
  {
    paramzaab.zaa(this.zacm, paramBoolean);
  }

  public final void zaa(RuntimeException paramRuntimeException)
  {
    this.zacm.trySetException(paramRuntimeException);
  }

  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zacq.zabt();
  }

  public final boolean zac(GoogleApiManager.zaa<?> paramzaa)
  {
    return this.zacq.shouldAutoResolveMissingFeatures();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zag
 * JD-Core Version:    0.6.2
 */