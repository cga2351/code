package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.zzay;

final class zzh extends zzay
{
  zzh(GoogleMap paramGoogleMap, GoogleMap.OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
  }

  public final void zza(IObjectWrapper paramIObjectWrapper)
  {
    this.zzp.onMyLocationChange((Location)ObjectWrapper.unwrap(paramIObjectWrapper));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzh
 * JD-Core Version:    0.6.2
 */