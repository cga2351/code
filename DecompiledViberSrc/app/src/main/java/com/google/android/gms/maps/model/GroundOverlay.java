package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzk;

public final class GroundOverlay
{
  private final zzk zzcw;

  public GroundOverlay(zzk paramzzk)
  {
    this.zzcw = ((zzk)Preconditions.checkNotNull(paramzzk));
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GroundOverlay))
      return false;
    try
    {
      boolean bool = this.zzcw.zzb(((GroundOverlay)paramObject).zzcw);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getBearing()
  {
    try
    {
      float f = this.zzcw.getBearing();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final LatLngBounds getBounds()
  {
    try
    {
      LatLngBounds localLatLngBounds = this.zzcw.getBounds();
      return localLatLngBounds;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getHeight()
  {
    try
    {
      float f = this.zzcw.getHeight();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final String getId()
  {
    try
    {
      String str = this.zzcw.getId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final LatLng getPosition()
  {
    try
    {
      LatLng localLatLng = this.zzcw.getPosition();
      return localLatLng;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final Object getTag()
  {
    try
    {
      Object localObject = ObjectWrapper.unwrap(this.zzcw.zzk());
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getTransparency()
  {
    try
    {
      float f = this.zzcw.getTransparency();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getWidth()
  {
    try
    {
      float f = this.zzcw.getWidth();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getZIndex()
  {
    try
    {
      float f = this.zzcw.getZIndex();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int hashCode()
  {
    try
    {
      int i = this.zzcw.zzj();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isClickable()
  {
    try
    {
      boolean bool = this.zzcw.isClickable();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isVisible()
  {
    try
    {
      boolean bool = this.zzcw.isVisible();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void remove()
  {
    try
    {
      this.zzcw.remove();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setBearing(float paramFloat)
  {
    try
    {
      this.zzcw.setBearing(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setClickable(boolean paramBoolean)
  {
    try
    {
      this.zzcw.setClickable(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setDimensions(float paramFloat)
  {
    try
    {
      this.zzcw.setDimensions(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setDimensions(float paramFloat1, float paramFloat2)
  {
    try
    {
      this.zzcw.zza(paramFloat1, paramFloat2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setImage(BitmapDescriptor paramBitmapDescriptor)
  {
    Preconditions.checkNotNull(paramBitmapDescriptor, "imageDescriptor must not be null");
    try
    {
      IObjectWrapper localIObjectWrapper = paramBitmapDescriptor.zzb();
      this.zzcw.zzf(localIObjectWrapper);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.zzcw.setPosition(paramLatLng);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setPositionFromBounds(LatLngBounds paramLatLngBounds)
  {
    try
    {
      this.zzcw.setPositionFromBounds(paramLatLngBounds);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setTag(Object paramObject)
  {
    try
    {
      this.zzcw.zze(ObjectWrapper.wrap(paramObject));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setTransparency(float paramFloat)
  {
    try
    {
      this.zzcw.setTransparency(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setVisible(boolean paramBoolean)
  {
    try
    {
      this.zzcw.setVisible(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setZIndex(float paramFloat)
  {
    try
    {
      this.zzcw.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlay
 * JD-Core Version:    0.6.2
 */