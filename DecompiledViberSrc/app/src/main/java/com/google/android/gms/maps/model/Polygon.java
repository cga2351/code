package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzw;
import java.util.List;

public final class Polygon
{
  private final zzw zzdw;

  public Polygon(zzw paramzzw)
  {
    this.zzdw = ((zzw)Preconditions.checkNotNull(paramzzw));
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Polygon))
      return false;
    try
    {
      boolean bool = this.zzdw.zzb(((Polygon)paramObject).zzdw);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getFillColor()
  {
    try
    {
      int i = this.zzdw.getFillColor();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final List<List<LatLng>> getHoles()
  {
    try
    {
      List localList = this.zzdw.getHoles();
      return localList;
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
      String str = this.zzdw.getId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final List<LatLng> getPoints()
  {
    try
    {
      List localList = this.zzdw.getPoints();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getStrokeColor()
  {
    try
    {
      int i = this.zzdw.getStrokeColor();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getStrokeJointType()
  {
    try
    {
      int i = this.zzdw.getStrokeJointType();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final List<PatternItem> getStrokePattern()
  {
    try
    {
      List localList = PatternItem.zza(this.zzdw.getStrokePattern());
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final float getStrokeWidth()
  {
    try
    {
      float f = this.zzdw.getStrokeWidth();
      return f;
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
      Object localObject = ObjectWrapper.unwrap(this.zzdw.zzk());
      return localObject;
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
      float f = this.zzdw.getZIndex();
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
      int i = this.zzdw.zzj();
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
      boolean bool = this.zzdw.isClickable();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isGeodesic()
  {
    try
    {
      boolean bool = this.zzdw.isGeodesic();
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
      boolean bool = this.zzdw.isVisible();
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
      this.zzdw.remove();
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
      this.zzdw.setClickable(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setFillColor(int paramInt)
  {
    try
    {
      this.zzdw.setFillColor(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setGeodesic(boolean paramBoolean)
  {
    try
    {
      this.zzdw.setGeodesic(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setHoles(List<? extends List<LatLng>> paramList)
  {
    try
    {
      this.zzdw.setHoles(paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setPoints(List<LatLng> paramList)
  {
    try
    {
      this.zzdw.setPoints(paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setStrokeColor(int paramInt)
  {
    try
    {
      this.zzdw.setStrokeColor(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setStrokeJointType(int paramInt)
  {
    try
    {
      this.zzdw.setStrokeJointType(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setStrokePattern(List<PatternItem> paramList)
  {
    try
    {
      this.zzdw.setStrokePattern(paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setStrokeWidth(float paramFloat)
  {
    try
    {
      this.zzdw.setStrokeWidth(paramFloat);
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
      this.zzdw.zze(ObjectWrapper.wrap(paramObject));
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
      this.zzdw.setVisible(paramBoolean);
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
      this.zzdw.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Polygon
 * JD-Core Version:    0.6.2
 */