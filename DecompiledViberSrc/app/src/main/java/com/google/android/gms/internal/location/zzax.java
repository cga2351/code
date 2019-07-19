package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzy;

final class zzax extends zzy
{
  private final ListenerHolder<LocationListener> zzda;

  zzax(ListenerHolder<LocationListener> paramListenerHolder)
  {
    this.zzda = paramListenerHolder;
  }

  public final void onLocationChanged(Location paramLocation)
  {
    try
    {
      this.zzda.notifyListener(new zzay(this, paramLocation));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
 * Qualified Name:     com.google.android.gms.internal.location.zzax
 * JD-Core Version:    0.6.2
 */