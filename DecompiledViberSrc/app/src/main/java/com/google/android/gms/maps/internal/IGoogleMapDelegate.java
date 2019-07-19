package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzk;
import com.google.android.gms.internal.maps.zzw;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public abstract interface IGoogleMapDelegate extends IInterface
{
  public abstract com.google.android.gms.internal.maps.zzh addCircle(CircleOptions paramCircleOptions)
    throws RemoteException;

  public abstract zzk addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException;

  public abstract com.google.android.gms.internal.maps.zzt addMarker(MarkerOptions paramMarkerOptions)
    throws RemoteException;

  public abstract zzw addPolygon(PolygonOptions paramPolygonOptions)
    throws RemoteException;

  public abstract com.google.android.gms.internal.maps.zzz addPolyline(PolylineOptions paramPolylineOptions)
    throws RemoteException;

  public abstract zzac addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException;

  public abstract void animateCamera(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void animateCameraWithCallback(IObjectWrapper paramIObjectWrapper, zzc paramzzc)
    throws RemoteException;

  public abstract void animateCameraWithDurationAndCallback(IObjectWrapper paramIObjectWrapper, int paramInt, zzc paramzzc)
    throws RemoteException;

  public abstract void clear()
    throws RemoteException;

  public abstract CameraPosition getCameraPosition()
    throws RemoteException;

  public abstract com.google.android.gms.internal.maps.zzn getFocusedBuilding()
    throws RemoteException;

  public abstract void getMapAsync(zzap paramzzap)
    throws RemoteException;

  public abstract int getMapType()
    throws RemoteException;

  public abstract float getMaxZoomLevel()
    throws RemoteException;

  public abstract float getMinZoomLevel()
    throws RemoteException;

  public abstract Location getMyLocation()
    throws RemoteException;

  public abstract IProjectionDelegate getProjection()
    throws RemoteException;

  public abstract IUiSettingsDelegate getUiSettings()
    throws RemoteException;

  public abstract boolean isBuildingsEnabled()
    throws RemoteException;

  public abstract boolean isIndoorEnabled()
    throws RemoteException;

  public abstract boolean isMyLocationEnabled()
    throws RemoteException;

  public abstract boolean isTrafficEnabled()
    throws RemoteException;

  public abstract void moveCamera(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;

  public abstract void onDestroy()
    throws RemoteException;

  public abstract void onEnterAmbient(Bundle paramBundle)
    throws RemoteException;

  public abstract void onExitAmbient()
    throws RemoteException;

  public abstract void onLowMemory()
    throws RemoteException;

  public abstract void onPause()
    throws RemoteException;

  public abstract void onResume()
    throws RemoteException;

  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;

  public abstract void onStart()
    throws RemoteException;

  public abstract void onStop()
    throws RemoteException;

  public abstract void resetMinMaxZoomPreference()
    throws RemoteException;

  public abstract void setBuildingsEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setContentDescription(String paramString)
    throws RemoteException;

  public abstract boolean setIndoorEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setInfoWindowAdapter(zzh paramzzh)
    throws RemoteException;

  public abstract void setLatLngBoundsForCameraTarget(LatLngBounds paramLatLngBounds)
    throws RemoteException;

  public abstract void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
    throws RemoteException;

  public abstract boolean setMapStyle(MapStyleOptions paramMapStyleOptions)
    throws RemoteException;

  public abstract void setMapType(int paramInt)
    throws RemoteException;

  public abstract void setMaxZoomPreference(float paramFloat)
    throws RemoteException;

  public abstract void setMinZoomPreference(float paramFloat)
    throws RemoteException;

  public abstract void setMyLocationEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setOnCameraChangeListener(zzl paramzzl)
    throws RemoteException;

  public abstract void setOnCameraIdleListener(zzn paramzzn)
    throws RemoteException;

  public abstract void setOnCameraMoveCanceledListener(zzp paramzzp)
    throws RemoteException;

  public abstract void setOnCameraMoveListener(zzr paramzzr)
    throws RemoteException;

  public abstract void setOnCameraMoveStartedListener(zzt paramzzt)
    throws RemoteException;

  public abstract void setOnCircleClickListener(zzv paramzzv)
    throws RemoteException;

  public abstract void setOnGroundOverlayClickListener(zzx paramzzx)
    throws RemoteException;

  public abstract void setOnIndoorStateChangeListener(zzz paramzzz)
    throws RemoteException;

  public abstract void setOnInfoWindowClickListener(zzab paramzzab)
    throws RemoteException;

  public abstract void setOnInfoWindowCloseListener(zzad paramzzad)
    throws RemoteException;

  public abstract void setOnInfoWindowLongClickListener(zzaf paramzzaf)
    throws RemoteException;

  public abstract void setOnMapClickListener(zzaj paramzzaj)
    throws RemoteException;

  public abstract void setOnMapLoadedCallback(zzal paramzzal)
    throws RemoteException;

  public abstract void setOnMapLongClickListener(zzan paramzzan)
    throws RemoteException;

  public abstract void setOnMarkerClickListener(zzar paramzzar)
    throws RemoteException;

  public abstract void setOnMarkerDragListener(zzat paramzzat)
    throws RemoteException;

  public abstract void setOnMyLocationButtonClickListener(zzav paramzzav)
    throws RemoteException;

  public abstract void setOnMyLocationChangeListener(zzax paramzzax)
    throws RemoteException;

  public abstract void setOnMyLocationClickListener(zzaz paramzzaz)
    throws RemoteException;

  public abstract void setOnPoiClickListener(zzbb paramzzbb)
    throws RemoteException;

  public abstract void setOnPolygonClickListener(zzbd paramzzbd)
    throws RemoteException;

  public abstract void setOnPolylineClickListener(zzbf paramzzbf)
    throws RemoteException;

  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException;

  public abstract void setTrafficEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setWatermarkEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void snapshot(zzbs paramzzbs, IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void snapshotForTest(zzbs paramzzbs)
    throws RemoteException;

  public abstract void stopAnimation()
    throws RemoteException;

  public abstract boolean useViewLifecycleWhenInFragment()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IGoogleMapDelegate
 * JD-Core Version:    0.6.2
 */