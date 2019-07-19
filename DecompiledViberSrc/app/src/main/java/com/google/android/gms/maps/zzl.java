package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.ILocationSourceDelegate.zza;
import com.google.android.gms.maps.internal.zzah;

final class zzl extends ILocationSourceDelegate.zza
{
  zzl(GoogleMap paramGoogleMap, LocationSource paramLocationSource)
  {
  }

  public final void activate(zzah paramzzah)
  {
    this.zzt.activate(new zzm(this, paramzzah));
  }

  public final void deactivate()
  {
    this.zzt.deactivate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzl
 * JD-Core Version:    0.6.2
 */