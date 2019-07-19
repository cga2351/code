package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.maps.internal.zzau;
import com.google.android.gms.maps.model.Marker;

final class zzc extends zzau
{
  zzc(GoogleMap paramGoogleMap, GoogleMap.OnMarkerDragListener paramOnMarkerDragListener)
  {
  }

  public final void zzb(zzt paramzzt)
  {
    this.zzk.onMarkerDragStart(new Marker(paramzzt));
  }

  public final void zzc(zzt paramzzt)
  {
    this.zzk.onMarkerDragEnd(new Marker(paramzzt));
  }

  public final void zzd(zzt paramzzt)
  {
    this.zzk.onMarkerDrag(new Marker(paramzzt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzc
 * JD-Core Version:    0.6.2
 */