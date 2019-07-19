package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T> extends zac
{
  protected final TaskCompletionSource<T> zacm;

  public zad(int paramInt, TaskCompletionSource<T> paramTaskCompletionSource)
  {
    super(paramInt);
    this.zacm = paramTaskCompletionSource;
  }

  public void zaa(Status paramStatus)
  {
    this.zacm.trySetException(new ApiException(paramStatus));
  }

  public final void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException
  {
    try
    {
      zad(paramzaa);
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      zaa(zab.zab(localDeadObjectException));
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

  public void zaa(zaab paramzaab, boolean paramBoolean)
  {
  }

  public void zaa(RuntimeException paramRuntimeException)
  {
    this.zacm.trySetException(paramRuntimeException);
  }

  protected abstract void zad(GoogleApiManager.zaa<?> paramzaa)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zad
 * JD-Core Version:    0.6.2
 */