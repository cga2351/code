package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.internal.location.zzak;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzp extends zzak
{
  zzp(FusedLocationProviderClient paramFusedLocationProviderClient, TaskCompletionSource paramTaskCompletionSource)
  {
  }

  public final void zza(zzad paramzzad)
    throws RemoteException
  {
    Status localStatus = paramzzad.getStatus();
    if (localStatus == null)
    {
      this.zzab.trySetException(new ApiException(new Status(8, "Got null status from location service")));
      return;
    }
    if (localStatus.getStatusCode() == 0)
    {
      this.zzab.setResult(Boolean.valueOf(true));
      return;
    }
    this.zzab.trySetException(ApiExceptionUtil.fromStatus(localStatus));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzp
 * JD-Core Version:    0.6.2
 */