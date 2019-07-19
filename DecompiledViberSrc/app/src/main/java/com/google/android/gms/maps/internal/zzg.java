package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzi;
import com.google.android.gms.internal.maps.zzk;
import com.google.android.gms.internal.maps.zzo;
import com.google.android.gms.internal.maps.zzu;
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

public final class zzg extends zza
  implements IGoogleMapDelegate
{
  zzg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
  }

  public final com.google.android.gms.internal.maps.zzh addCircle(CircleOptions paramCircleOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramCircleOptions);
    Parcel localParcel2 = zza(35, localParcel1);
    com.google.android.gms.internal.maps.zzh localzzh = zzi.zzc(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzh;
  }

  public final zzk addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramGroundOverlayOptions);
    Parcel localParcel2 = zza(12, localParcel1);
    zzk localzzk = com.google.android.gms.internal.maps.zzl.zzd(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzk;
  }

  public final com.google.android.gms.internal.maps.zzt addMarker(MarkerOptions paramMarkerOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramMarkerOptions);
    Parcel localParcel2 = zza(11, localParcel1);
    com.google.android.gms.internal.maps.zzt localzzt = zzu.zzg(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzt;
  }

  public final zzw addPolygon(PolygonOptions paramPolygonOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramPolygonOptions);
    Parcel localParcel2 = zza(10, localParcel1);
    zzw localzzw = com.google.android.gms.internal.maps.zzx.zzh(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzw;
  }

  public final com.google.android.gms.internal.maps.zzz addPolyline(PolylineOptions paramPolylineOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramPolylineOptions);
    Parcel localParcel2 = zza(9, localParcel1);
    com.google.android.gms.internal.maps.zzz localzzz = zzaa.zzi(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzz;
  }

  public final zzac addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramTileOverlayOptions);
    Parcel localParcel2 = zza(13, localParcel1);
    zzac localzzac = com.google.android.gms.internal.maps.zzad.zzj(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localzzac;
  }

  public final void animateCamera(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramIObjectWrapper);
    zzb(5, localParcel);
  }

  public final void animateCameraWithCallback(IObjectWrapper paramIObjectWrapper, zzc paramzzc)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramIObjectWrapper);
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzc);
    zzb(6, localParcel);
  }

  public final void animateCameraWithDurationAndCallback(IObjectWrapper paramIObjectWrapper, int paramInt, zzc paramzzc)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramIObjectWrapper);
    localParcel.writeInt(paramInt);
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzc);
    zzb(7, localParcel);
  }

  public final void clear()
    throws RemoteException
  {
    zzb(14, zza());
  }

  public final CameraPosition getCameraPosition()
    throws RemoteException
  {
    Parcel localParcel = zza(1, zza());
    CameraPosition localCameraPosition = (CameraPosition)com.google.android.gms.internal.maps.zzc.zza(localParcel, CameraPosition.CREATOR);
    localParcel.recycle();
    return localCameraPosition;
  }

  public final com.google.android.gms.internal.maps.zzn getFocusedBuilding()
    throws RemoteException
  {
    Parcel localParcel = zza(44, zza());
    com.google.android.gms.internal.maps.zzn localzzn = zzo.zze(localParcel.readStrongBinder());
    localParcel.recycle();
    return localzzn;
  }

  public final void getMapAsync(zzap paramzzap)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzap);
    zzb(53, localParcel);
  }

  public final int getMapType()
    throws RemoteException
  {
    Parcel localParcel = zza(15, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final float getMaxZoomLevel()
    throws RemoteException
  {
    Parcel localParcel = zza(2, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final float getMinZoomLevel()
    throws RemoteException
  {
    Parcel localParcel = zza(3, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final Location getMyLocation()
    throws RemoteException
  {
    Parcel localParcel = zza(23, zza());
    Location localLocation = (Location)com.google.android.gms.internal.maps.zzc.zza(localParcel, Location.CREATOR);
    localParcel.recycle();
    return localLocation;
  }

  public final IProjectionDelegate getProjection()
    throws RemoteException
  {
    Parcel localParcel = zza(26, zza());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
      if ((localIInterface instanceof IProjectionDelegate))
        localObject = (IProjectionDelegate)localIInterface;
      else
        localObject = new zzbr(localIBinder);
    }
  }

  public final IUiSettingsDelegate getUiSettings()
    throws RemoteException
  {
    Parcel localParcel = zza(25, zza());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if ((localIInterface instanceof IUiSettingsDelegate))
        localObject = (IUiSettingsDelegate)localIInterface;
      else
        localObject = new zzbx(localIBinder);
    }
  }

  public final boolean isBuildingsEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(40, zza());
    boolean bool = com.google.android.gms.internal.maps.zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isIndoorEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(19, zza());
    boolean bool = com.google.android.gms.internal.maps.zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isMyLocationEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(21, zza());
    boolean bool = com.google.android.gms.internal.maps.zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isTrafficEnabled()
    throws RemoteException
  {
    Parcel localParcel = zza(17, zza());
    boolean bool = com.google.android.gms.internal.maps.zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void moveCamera(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramIObjectWrapper);
    zzb(4, localParcel);
  }

  public final void onCreate(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramBundle);
    zzb(54, localParcel);
  }

  public final void onDestroy()
    throws RemoteException
  {
    zzb(57, zza());
  }

  public final void onEnterAmbient(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramBundle);
    zzb(81, localParcel);
  }

  public final void onExitAmbient()
    throws RemoteException
  {
    zzb(82, zza());
  }

  public final void onLowMemory()
    throws RemoteException
  {
    zzb(58, zza());
  }

  public final void onPause()
    throws RemoteException
  {
    zzb(56, zza());
  }

  public final void onResume()
    throws RemoteException
  {
    zzb(55, zza());
  }

  public final void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramBundle);
    Parcel localParcel2 = zza(60, localParcel1);
    if (localParcel2.readInt() != 0)
      paramBundle.readFromParcel(localParcel2);
    localParcel2.recycle();
  }

  public final void onStart()
    throws RemoteException
  {
    zzb(101, zza());
  }

  public final void onStop()
    throws RemoteException
  {
    zzb(102, zza());
  }

  public final void resetMinMaxZoomPreference()
    throws RemoteException
  {
    zzb(94, zza());
  }

  public final void setBuildingsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.writeBoolean(localParcel, paramBoolean);
    zzb(41, localParcel);
  }

  public final void setContentDescription(String paramString)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeString(paramString);
    zzb(61, localParcel);
  }

  public final boolean setIndoorEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.writeBoolean(localParcel1, paramBoolean);
    Parcel localParcel2 = zza(20, localParcel1);
    boolean bool = com.google.android.gms.internal.maps.zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final void setInfoWindowAdapter(zzh paramzzh)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzh);
    zzb(33, localParcel);
  }

  public final void setLatLngBoundsForCameraTarget(LatLngBounds paramLatLngBounds)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramLatLngBounds);
    zzb(95, localParcel);
  }

  public final void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramILocationSourceDelegate);
    zzb(24, localParcel);
  }

  public final boolean setMapStyle(MapStyleOptions paramMapStyleOptions)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel1, paramMapStyleOptions);
    Parcel localParcel2 = zza(91, localParcel1);
    boolean bool = com.google.android.gms.internal.maps.zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final void setMapType(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeInt(paramInt);
    zzb(16, localParcel);
  }

  public final void setMaxZoomPreference(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(93, localParcel);
  }

  public final void setMinZoomPreference(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(92, localParcel);
  }

  public final void setMyLocationEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.writeBoolean(localParcel, paramBoolean);
    zzb(22, localParcel);
  }

  public final void setOnCameraChangeListener(zzl paramzzl)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzl);
    zzb(27, localParcel);
  }

  public final void setOnCameraIdleListener(zzn paramzzn)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzn);
    zzb(99, localParcel);
  }

  public final void setOnCameraMoveCanceledListener(zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzp);
    zzb(98, localParcel);
  }

  public final void setOnCameraMoveListener(zzr paramzzr)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzr);
    zzb(97, localParcel);
  }

  public final void setOnCameraMoveStartedListener(zzt paramzzt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzt);
    zzb(96, localParcel);
  }

  public final void setOnCircleClickListener(zzv paramzzv)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzv);
    zzb(89, localParcel);
  }

  public final void setOnGroundOverlayClickListener(zzx paramzzx)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzx);
    zzb(83, localParcel);
  }

  public final void setOnIndoorStateChangeListener(zzz paramzzz)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzz);
    zzb(45, localParcel);
  }

  public final void setOnInfoWindowClickListener(zzab paramzzab)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzab);
    zzb(32, localParcel);
  }

  public final void setOnInfoWindowCloseListener(zzad paramzzad)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzad);
    zzb(86, localParcel);
  }

  public final void setOnInfoWindowLongClickListener(zzaf paramzzaf)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzaf);
    zzb(84, localParcel);
  }

  public final void setOnMapClickListener(zzaj paramzzaj)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzaj);
    zzb(28, localParcel);
  }

  public final void setOnMapLoadedCallback(zzal paramzzal)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzal);
    zzb(42, localParcel);
  }

  public final void setOnMapLongClickListener(zzan paramzzan)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzan);
    zzb(29, localParcel);
  }

  public final void setOnMarkerClickListener(zzar paramzzar)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzar);
    zzb(30, localParcel);
  }

  public final void setOnMarkerDragListener(zzat paramzzat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzat);
    zzb(31, localParcel);
  }

  public final void setOnMyLocationButtonClickListener(zzav paramzzav)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzav);
    zzb(37, localParcel);
  }

  public final void setOnMyLocationChangeListener(zzax paramzzax)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzax);
    zzb(36, localParcel);
  }

  public final void setOnMyLocationClickListener(zzaz paramzzaz)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzaz);
    zzb(107, localParcel);
  }

  public final void setOnPoiClickListener(zzbb paramzzbb)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzbb);
    zzb(80, localParcel);
  }

  public final void setOnPolygonClickListener(zzbd paramzzbd)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzbd);
    zzb(85, localParcel);
  }

  public final void setOnPolylineClickListener(zzbf paramzzbf)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzbf);
    zzb(87, localParcel);
  }

  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeInt(paramInt1);
    localParcel.writeInt(paramInt2);
    localParcel.writeInt(paramInt3);
    localParcel.writeInt(paramInt4);
    zzb(39, localParcel);
  }

  public final void setTrafficEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.writeBoolean(localParcel, paramBoolean);
    zzb(18, localParcel);
  }

  public final void setWatermarkEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.writeBoolean(localParcel, paramBoolean);
    zzb(51, localParcel);
  }

  public final void snapshot(zzbs paramzzbs, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzbs);
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramIObjectWrapper);
    zzb(38, localParcel);
  }

  public final void snapshotForTest(zzbs paramzzbs)
    throws RemoteException
  {
    Parcel localParcel = zza();
    com.google.android.gms.internal.maps.zzc.zza(localParcel, paramzzbs);
    zzb(71, localParcel);
  }

  public final void stopAnimation()
    throws RemoteException
  {
    zzb(8, zza());
  }

  public final boolean useViewLifecycleWhenInFragment()
    throws RemoteException
  {
    Parcel localParcel = zza(59, zza());
    boolean bool = com.google.android.gms.internal.maps.zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzg
 * JD-Core Version:    0.6.2
 */