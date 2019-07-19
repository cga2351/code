package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings
{
  private final IUiSettingsDelegate zzcj;

  UiSettings(IUiSettingsDelegate paramIUiSettingsDelegate)
  {
    this.zzcj = paramIUiSettingsDelegate;
  }

  public final boolean isCompassEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isCompassEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isIndoorLevelPickerEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isIndoorLevelPickerEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isMapToolbarEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isMapToolbarEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isMyLocationButtonEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isMyLocationButtonEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isRotateGesturesEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isRotateGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isScrollGesturesEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isScrollGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isScrollGesturesEnabledDuringRotateOrZoom()
  {
    try
    {
      boolean bool = this.zzcj.isScrollGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isTiltGesturesEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isTiltGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isZoomControlsEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isZoomControlsEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final boolean isZoomGesturesEnabled()
  {
    try
    {
      boolean bool = this.zzcj.isZoomGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setAllGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setCompassEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setCompassEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setIndoorLevelPickerEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setMapToolbarEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setMapToolbarEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setMyLocationButtonEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setRotateGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setScrollGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setScrollGesturesEnabledDuringRotateOrZoom(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setTiltGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setZoomControlsEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setZoomControlsEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }

  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzcj.setZoomGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.UiSettings
 * JD-Core Version:    0.6.2
 */