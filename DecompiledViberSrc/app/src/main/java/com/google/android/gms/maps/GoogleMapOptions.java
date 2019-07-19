package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

@SafeParcelable.Class(creator="GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
public final class GoogleMapOptions extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzaa();

  @SafeParcelable.Field(getter="getMapType", id=4)
  private int mapType = -1;

  @SafeParcelable.Field(defaultValue="-1", getter="getZOrderOnTopForParcel", id=2, type="byte")
  private Boolean zzaj;

  @SafeParcelable.Field(defaultValue="-1", getter="getUseViewLifecycleInFragmentForParcel", id=3, type="byte")
  private Boolean zzak;

  @SafeParcelable.Field(getter="getCamera", id=5)
  private CameraPosition zzal;

  @SafeParcelable.Field(defaultValue="-1", getter="getZoomControlsEnabledForParcel", id=6, type="byte")
  private Boolean zzam;

  @SafeParcelable.Field(defaultValue="-1", getter="getCompassEnabledForParcel", id=7, type="byte")
  private Boolean zzan;

  @SafeParcelable.Field(defaultValue="-1", getter="getScrollGesturesEnabledForParcel", id=8, type="byte")
  private Boolean zzao;

  @SafeParcelable.Field(defaultValue="-1", getter="getZoomGesturesEnabledForParcel", id=9, type="byte")
  private Boolean zzap;

  @SafeParcelable.Field(defaultValue="-1", getter="getTiltGesturesEnabledForParcel", id=10, type="byte")
  private Boolean zzaq;

  @SafeParcelable.Field(defaultValue="-1", getter="getRotateGesturesEnabledForParcel", id=11, type="byte")
  private Boolean zzar;

  @SafeParcelable.Field(defaultValue="-1", getter="getLiteModeForParcel", id=12, type="byte")
  private Boolean zzas;

  @SafeParcelable.Field(defaultValue="-1", getter="getMapToolbarEnabledForParcel", id=14, type="byte")
  private Boolean zzat;

  @SafeParcelable.Field(defaultValue="-1", getter="getAmbientEnabledForParcel", id=15, type="byte")
  private Boolean zzau;

  @SafeParcelable.Field(getter="getMinZoomPreference", id=16)
  private Float zzav = null;

  @SafeParcelable.Field(getter="getMaxZoomPreference", id=17)
  private Float zzaw = null;

  @SafeParcelable.Field(getter="getLatLngBoundsForCameraTarget", id=18)
  private LatLngBounds zzax = null;

  @SafeParcelable.Field(defaultValue="-1", getter="getScrollGesturesEnabledDuringRotateOrZoomForParcel", id=19, type="byte")
  private Boolean zzay;

  public GoogleMapOptions()
  {
  }

  @SafeParcelable.Constructor
  GoogleMapOptions(@SafeParcelable.Param(id=2) byte paramByte1, @SafeParcelable.Param(id=3) byte paramByte2, @SafeParcelable.Param(id=4) int paramInt, @SafeParcelable.Param(id=5) CameraPosition paramCameraPosition, @SafeParcelable.Param(id=6) byte paramByte3, @SafeParcelable.Param(id=7) byte paramByte4, @SafeParcelable.Param(id=8) byte paramByte5, @SafeParcelable.Param(id=9) byte paramByte6, @SafeParcelable.Param(id=10) byte paramByte7, @SafeParcelable.Param(id=11) byte paramByte8, @SafeParcelable.Param(id=12) byte paramByte9, @SafeParcelable.Param(id=14) byte paramByte10, @SafeParcelable.Param(id=15) byte paramByte11, @SafeParcelable.Param(id=16) Float paramFloat1, @SafeParcelable.Param(id=17) Float paramFloat2, @SafeParcelable.Param(id=18) LatLngBounds paramLatLngBounds, @SafeParcelable.Param(id=19) byte paramByte12)
  {
    this.zzaj = zza.zza(paramByte1);
    this.zzak = zza.zza(paramByte2);
    this.mapType = paramInt;
    this.zzal = paramCameraPosition;
    this.zzam = zza.zza(paramByte3);
    this.zzan = zza.zza(paramByte4);
    this.zzao = zza.zza(paramByte5);
    this.zzap = zza.zza(paramByte6);
    this.zzaq = zza.zza(paramByte7);
    this.zzar = zza.zza(paramByte8);
    this.zzas = zza.zza(paramByte9);
    this.zzat = zza.zza(paramByte10);
    this.zzau = zza.zza(paramByte11);
    this.zzav = paramFloat1;
    this.zzaw = paramFloat2;
    this.zzax = paramLatLngBounds;
    this.zzay = zza.zza(paramByte12);
  }

  public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((paramContext == null) || (paramAttributeSet == null))
      return null;
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(R.styleable.MapAttrs_mapType))
      localGoogleMapOptions.mapType(localTypedArray.getInt(R.styleable.MapAttrs_mapType, -1));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_zOrderOnTop))
      localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_useViewLifecycle))
      localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiCompass))
      localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiCompass, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiRotateGestures))
      localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom))
      localGoogleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(localTypedArray.getBoolean(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiScrollGestures))
      localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiTiltGestures))
      localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomGestures))
      localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomControls))
      localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_liteMode))
      localGoogleMapOptions.liteMode(localTypedArray.getBoolean(R.styleable.MapAttrs_liteMode, false));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiMapToolbar))
      localGoogleMapOptions.mapToolbarEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_ambientEnabled))
      localGoogleMapOptions.ambientEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference))
      localGoogleMapOptions.minZoomPreference(localTypedArray.getFloat(R.styleable.MapAttrs_cameraMinZoomPreference, (1.0F / -1.0F)));
    if (localTypedArray.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference))
      localGoogleMapOptions.maxZoomPreference(localTypedArray.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, (1.0F / 1.0F)));
    localGoogleMapOptions.latLngBoundsForCameraTarget(zza(paramContext, paramAttributeSet));
    localGoogleMapOptions.camera(zzb(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }

  public static LatLngBounds zza(Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((paramContext == null) || (paramAttributeSet == null))
      return null;
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    if (localTypedArray.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude));
    for (Float localFloat1 = Float.valueOf(localTypedArray.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0F)); ; localFloat1 = null)
    {
      if (localTypedArray.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude));
      for (Float localFloat2 = Float.valueOf(localTypedArray.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0F)); ; localFloat2 = null)
      {
        if (localTypedArray.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude));
        for (Float localFloat3 = Float.valueOf(localTypedArray.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0F)); ; localFloat3 = null)
        {
          if (localTypedArray.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude));
          for (Float localFloat4 = Float.valueOf(localTypedArray.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0F)); ; localFloat4 = null)
          {
            localTypedArray.recycle();
            if ((localFloat1 == null) || (localFloat2 == null) || (localFloat3 == null) || (localFloat4 == null))
              break;
            return new LatLngBounds(new LatLng(localFloat1.floatValue(), localFloat2.floatValue()), new LatLng(localFloat3.floatValue(), localFloat4.floatValue()));
          }
        }
      }
    }
  }

  public static CameraPosition zzb(Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((paramContext == null) || (paramAttributeSet == null))
      return null;
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    if (localTypedArray.hasValue(R.styleable.MapAttrs_cameraTargetLat));
    for (float f1 = localTypedArray.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0F); ; f1 = 0.0F)
    {
      if (localTypedArray.hasValue(R.styleable.MapAttrs_cameraTargetLng));
      for (float f2 = localTypedArray.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0F); ; f2 = 0.0F)
      {
        LatLng localLatLng = new LatLng(f1, f2);
        CameraPosition.Builder localBuilder = CameraPosition.builder();
        localBuilder.target(localLatLng);
        if (localTypedArray.hasValue(R.styleable.MapAttrs_cameraZoom))
          localBuilder.zoom(localTypedArray.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0F));
        if (localTypedArray.hasValue(R.styleable.MapAttrs_cameraBearing))
          localBuilder.bearing(localTypedArray.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0F));
        if (localTypedArray.hasValue(R.styleable.MapAttrs_cameraTilt))
          localBuilder.tilt(localTypedArray.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0F));
        localTypedArray.recycle();
        return localBuilder.build();
      }
    }
  }

  public final GoogleMapOptions ambientEnabled(boolean paramBoolean)
  {
    this.zzau = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions camera(CameraPosition paramCameraPosition)
  {
    this.zzal = paramCameraPosition;
    return this;
  }

  public final GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    this.zzan = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final Boolean getAmbientEnabled()
  {
    return this.zzau;
  }

  public final CameraPosition getCamera()
  {
    return this.zzal;
  }

  public final Boolean getCompassEnabled()
  {
    return this.zzan;
  }

  public final LatLngBounds getLatLngBoundsForCameraTarget()
  {
    return this.zzax;
  }

  public final Boolean getLiteMode()
  {
    return this.zzas;
  }

  public final Boolean getMapToolbarEnabled()
  {
    return this.zzat;
  }

  public final int getMapType()
  {
    return this.mapType;
  }

  public final Float getMaxZoomPreference()
  {
    return this.zzaw;
  }

  public final Float getMinZoomPreference()
  {
    return this.zzav;
  }

  public final Boolean getRotateGesturesEnabled()
  {
    return this.zzar;
  }

  public final Boolean getScrollGesturesEnabled()
  {
    return this.zzao;
  }

  public final Boolean getScrollGesturesEnabledDuringRotateOrZoom()
  {
    return this.zzay;
  }

  public final Boolean getTiltGesturesEnabled()
  {
    return this.zzaq;
  }

  public final Boolean getUseViewLifecycleInFragment()
  {
    return this.zzak;
  }

  public final Boolean getZOrderOnTop()
  {
    return this.zzaj;
  }

  public final Boolean getZoomControlsEnabled()
  {
    return this.zzam;
  }

  public final Boolean getZoomGesturesEnabled()
  {
    return this.zzap;
  }

  public final GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds paramLatLngBounds)
  {
    this.zzax = paramLatLngBounds;
    return this;
  }

  public final GoogleMapOptions liteMode(boolean paramBoolean)
  {
    this.zzas = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions mapToolbarEnabled(boolean paramBoolean)
  {
    this.zzat = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions mapType(int paramInt)
  {
    this.mapType = paramInt;
    return this;
  }

  public final GoogleMapOptions maxZoomPreference(float paramFloat)
  {
    this.zzaw = Float.valueOf(paramFloat);
    return this;
  }

  public final GoogleMapOptions minZoomPreference(float paramFloat)
  {
    this.zzav = Float.valueOf(paramFloat);
    return this;
  }

  public final GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.zzar = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.zzao = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean paramBoolean)
  {
    this.zzay = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.zzaq = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final String toString()
  {
    return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.mapType)).add("LiteMode", this.zzas).add("Camera", this.zzal).add("CompassEnabled", this.zzan).add("ZoomControlsEnabled", this.zzam).add("ScrollGesturesEnabled", this.zzao).add("ZoomGesturesEnabled", this.zzap).add("TiltGesturesEnabled", this.zzaq).add("RotateGesturesEnabled", this.zzar).add("ScrollGesturesEnabledDuringRotateOrZoom", this.zzay).add("MapToolbarEnabled", this.zzat).add("AmbientEnabled", this.zzau).add("MinZoomPreference", this.zzav).add("MaxZoomPreference", this.zzaw).add("LatLngBoundsForCameraTarget", this.zzax).add("ZOrderOnTop", this.zzaj).add("UseViewLifecycleInFragment", this.zzak).toString();
  }

  public final GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.zzak = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeByte(paramParcel, 2, zza.zza(this.zzaj));
    SafeParcelWriter.writeByte(paramParcel, 3, zza.zza(this.zzak));
    SafeParcelWriter.writeInt(paramParcel, 4, getMapType());
    SafeParcelWriter.writeParcelable(paramParcel, 5, getCamera(), paramInt, false);
    SafeParcelWriter.writeByte(paramParcel, 6, zza.zza(this.zzam));
    SafeParcelWriter.writeByte(paramParcel, 7, zza.zza(this.zzan));
    SafeParcelWriter.writeByte(paramParcel, 8, zza.zza(this.zzao));
    SafeParcelWriter.writeByte(paramParcel, 9, zza.zza(this.zzap));
    SafeParcelWriter.writeByte(paramParcel, 10, zza.zza(this.zzaq));
    SafeParcelWriter.writeByte(paramParcel, 11, zza.zza(this.zzar));
    SafeParcelWriter.writeByte(paramParcel, 12, zza.zza(this.zzas));
    SafeParcelWriter.writeByte(paramParcel, 14, zza.zza(this.zzat));
    SafeParcelWriter.writeByte(paramParcel, 15, zza.zza(this.zzau));
    SafeParcelWriter.writeFloatObject(paramParcel, 16, getMinZoomPreference(), false);
    SafeParcelWriter.writeFloatObject(paramParcel, 17, getMaxZoomPreference(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 18, getLatLngBoundsForCameraTarget(), paramInt, false);
    SafeParcelWriter.writeByte(paramParcel, 19, zza.zza(this.zzay));
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.zzaj = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.zzam = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.zzap = Boolean.valueOf(paramBoolean);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.GoogleMapOptions
 * JD-Core Version:    0.6.2
 */