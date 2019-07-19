package com.google.android.gms.internal.auth-api-phone;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzm extends TaskApiCall<zzi, Void>
{
  private TaskCompletionSource<Void> zzf;

  protected abstract void zza(zze paramzze)
    throws RemoteException;

  protected final void zzb(Status paramStatus)
  {
    TaskUtil.setResultOrApiException(paramStatus, this.zzf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zzm
 * JD-Core Version:    0.6.2
 */