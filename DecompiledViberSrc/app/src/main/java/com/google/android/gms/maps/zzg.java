package com.google.android.gms.maps;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.model.Marker;

final class zzg extends zzi
{
  zzg(GoogleMap paramGoogleMap, GoogleMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
  }

  public final IObjectWrapper zzh(zzt paramzzt)
  {
    return ObjectWrapper.wrap(this.zzo.getInfoWindow(new Marker(paramzzt)));
  }

  public final IObjectWrapper zzi(zzt paramzzt)
  {
    return ObjectWrapper.wrap(this.zzo.getInfoContents(new Marker(paramzzt)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzg
 * JD-Core Version:    0.6.2
 */