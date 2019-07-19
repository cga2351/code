package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

final class zzat extends zzv
{
  private final ListenerHolder<LocationCallback> zzda;

  zzat(ListenerHolder<LocationCallback> paramListenerHolder)
  {
    this.zzda = paramListenerHolder;
  }

  public final void onLocationAvailability(LocationAvailability paramLocationAvailability)
  {
    this.zzda.notifyListener(new zzav(this, paramLocationAvailability));
  }

  public final void onLocationResult(LocationResult paramLocationResult)
  {
    this.zzda.notifyListener(new zzau(this, paramLocationResult));
  }

  public final void release()
  {
    try
    {
      this.zzda.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzat
 * JD-Core Version:    0.6.2
 */