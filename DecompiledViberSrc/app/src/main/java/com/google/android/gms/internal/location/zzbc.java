package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsResult;

final class zzbc extends zzar
{
  private BaseImplementation.ResultHolder<LocationSettingsResult> zzdf;

  public zzbc(BaseImplementation.ResultHolder<LocationSettingsResult> paramResultHolder)
  {
    if (paramResultHolder != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "listener can't be null.");
      this.zzdf = paramResultHolder;
      return;
    }
  }

  public final void zza(LocationSettingsResult paramLocationSettingsResult)
    throws RemoteException
  {
    this.zzdf.setResult(paramLocationSettingsResult);
    this.zzdf = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzbc
 * JD-Core Version:    0.6.2
 */