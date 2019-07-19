package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzaq;

final class zzab extends zzaq
{
  zzab(MapFragment.zza paramzza, OnMapReadyCallback paramOnMapReadyCallback)
  {
  }

  public final void zza(IGoogleMapDelegate paramIGoogleMapDelegate)
    throws RemoteException
  {
    this.zzbc.onMapReady(new GoogleMap(paramIGoogleMapDelegate));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzab
 * JD-Core Version:    0.6.2
 */