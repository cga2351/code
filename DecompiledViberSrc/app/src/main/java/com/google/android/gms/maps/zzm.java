package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.model.RuntimeRemoteException;

final class zzm
  implements LocationSource.OnLocationChangedListener
{
  zzm(zzl paramzzl, zzah paramzzah)
  {
  }

  public final void onLocationChanged(Location paramLocation)
  {
    try
    {
      this.zzu.zza(paramLocation);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzm
 * JD-Core Version:    0.6.2
 */