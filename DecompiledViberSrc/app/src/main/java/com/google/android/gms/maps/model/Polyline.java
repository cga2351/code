package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzz;
import java.util.List;

public final class Polyline
{
  private final zzz zzeb;

  public Polyline(zzz paramzzz)
  {
    this.zzeb = ((zzz)Preconditions.checkNotNull(paramzzz));
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Polyline))
      return false;
    try
    {
      boolean bool = this.zzeb.zzb(((Polyline)paramObject).zzeb);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getColor()
  {
    try
    {
      int i = this.zzeb.getColor();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final Cap getEndCap()
  {
    try
    {
      Cap localCap = this.zzeb.getEndCap().zzh();
      return localCap;
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
      String str = this.zzeb.getId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final int getJointType()
  {
    try
    {
      int i = this.zzeb.getJointType();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final List<PatternItem> getPattern()
  {
    try
    {
      List localList = PatternItem.zza(this.zzeb.getPattern());
      return localList;
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
      List localList = this.zzeb.getPoints();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final Cap getStartCap()
  {
    try
    {
      Cap localCap = this.zzeb.getStartCap().zzh();
      return localCap;
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
      Object localObject = ObjectWrapper.unwrap(this.zzeb.zzk());
      return localObject;
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
      float f = this.zzeb.getWidth();
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
      float f = this.zzeb.getZIndex();
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
      int i = this.zzeb.zzj();
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
      boolean bool = this.zzeb.isClickable();
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
      boolean bool = this.zzeb.isGeodesic();
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
      boolean bool = this.zzeb.isVisible();
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
      this.zzeb.remove();
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
      this.zzeb.setClickable(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setColor(int paramInt)
  {
    try
    {
      this.zzeb.setColor(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setEndCap(Cap paramCap)
  {
    Preconditions.checkNotNull(paramCap, "endCap must not be null");
    try
    {
      this.zzeb.setEndCap(paramCap);
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
      this.zzeb.setGeodesic(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setJointType(int paramInt)
  {
    try
    {
      this.zzeb.setJointType(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setPattern(List<PatternItem> paramList)
  {
    try
    {
      this.zzeb.setPattern(paramList);
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
      this.zzeb.setPoints(paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setStartCap(Cap paramCap)
  {
    Preconditions.checkNotNull(paramCap, "startCap must not be null");
    try
    {
      this.zzeb.setStartCap(paramCap);
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
      this.zzeb.zze(ObjectWrapper.wrap(paramObject));
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
      this.zzeb.setVisible(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setWidth(float paramFloat)
  {
    try
    {
      this.zzeb.setWidth(paramFloat);
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
      this.zzeb.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Polyline
 * JD-Core Version:    0.6.2
 */