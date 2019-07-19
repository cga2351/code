package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.zzbc;
import com.google.android.gms.maps.model.PointOfInterest;

final class zzs extends zzbc
{
  zzs(GoogleMap paramGoogleMap, GoogleMap.OnPoiClickListener paramOnPoiClickListener)
  {
  }

  public final void zza(PointOfInterest paramPointOfInterest)
    throws RemoteException
  {
    this.zzaa.onPoiClick(paramPointOfInterest);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzs
 * JD-Core Version:    0.6.2
 */