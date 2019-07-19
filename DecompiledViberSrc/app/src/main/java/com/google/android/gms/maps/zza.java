package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzn;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.model.IndoorBuilding;

final class zza extends zzaa
{
  zza(GoogleMap paramGoogleMap, GoogleMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
  }

  public final void onIndoorBuildingFocused()
  {
    this.zzi.onIndoorBuildingFocused();
  }

  public final void zza(zzn paramzzn)
  {
    this.zzi.onIndoorLevelActivated(new IndoorBuilding(paramzzn));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zza
 * JD-Core Version:    0.6.2
 */