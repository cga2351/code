package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

@SafeParcelable.Class(creator="StreetViewPanoramaOptionsCreator")
@SafeParcelable.Reserved({1})
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzai();

  @SafeParcelable.Field(getter="getPanoramaId", id=3)
  private String panoId;

  @SafeParcelable.Field(getter="getPosition", id=4)
  private LatLng position;

  @SafeParcelable.Field(getter="getUseViewLifecycleInFragmentForParcel", id=10, type="byte")
  private Boolean zzak;

  @SafeParcelable.Field(getter="getZoomGesturesEnabledForParcel", id=7, type="byte")
  private Boolean zzap = Boolean.valueOf(true);

  @SafeParcelable.Field(getter="getStreetViewPanoramaCamera", id=2)
  private StreetViewPanoramaCamera zzbx;

  @SafeParcelable.Field(getter="getRadius", id=5)
  private Integer zzby;

  @SafeParcelable.Field(getter="getUserNavigationEnabledForParcel", id=6, type="byte")
  private Boolean zzbz = Boolean.valueOf(true);

  @SafeParcelable.Field(getter="getPanningGesturesEnabledForParcel", id=8, type="byte")
  private Boolean zzca = Boolean.valueOf(true);

  @SafeParcelable.Field(getter="getStreetNamesEnabledForParcel", id=9, type="byte")
  private Boolean zzcb = Boolean.valueOf(true);

  @SafeParcelable.Field(getter="getSource", id=11)
  private StreetViewSource zzcc = StreetViewSource.DEFAULT;

  public StreetViewPanoramaOptions()
  {
  }

  @SafeParcelable.Constructor
  StreetViewPanoramaOptions(@SafeParcelable.Param(id=2) StreetViewPanoramaCamera paramStreetViewPanoramaCamera, @SafeParcelable.Param(id=3) String paramString, @SafeParcelable.Param(id=4) LatLng paramLatLng, @SafeParcelable.Param(id=5) Integer paramInteger, @SafeParcelable.Param(id=6) byte paramByte1, @SafeParcelable.Param(id=7) byte paramByte2, @SafeParcelable.Param(id=8) byte paramByte3, @SafeParcelable.Param(id=9) byte paramByte4, @SafeParcelable.Param(id=10) byte paramByte5, @SafeParcelable.Param(id=11) StreetViewSource paramStreetViewSource)
  {
    this.zzbx = paramStreetViewPanoramaCamera;
    this.position = paramLatLng;
    this.zzby = paramInteger;
    this.panoId = paramString;
    this.zzbz = zza.zza(paramByte1);
    this.zzap = zza.zza(paramByte2);
    this.zzca = zza.zza(paramByte3);
    this.zzcb = zza.zza(paramByte4);
    this.zzak = zza.zza(paramByte5);
    this.zzcc = paramStreetViewSource;
  }

  public final Boolean getPanningGesturesEnabled()
  {
    return this.zzca;
  }

  public final String getPanoramaId()
  {
    return this.panoId;
  }

  public final LatLng getPosition()
  {
    return this.position;
  }

  public final Integer getRadius()
  {
    return this.zzby;
  }

  public final StreetViewSource getSource()
  {
    return this.zzcc;
  }

  public final Boolean getStreetNamesEnabled()
  {
    return this.zzcb;
  }

  public final StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return this.zzbx;
  }

  public final Boolean getUseViewLifecycleInFragment()
  {
    return this.zzak;
  }

  public final Boolean getUserNavigationEnabled()
  {
    return this.zzbz;
  }

  public final Boolean getZoomGesturesEnabled()
  {
    return this.zzap;
  }

  public final StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean)
  {
    this.zzca = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.zzbx = paramStreetViewPanoramaCamera;
    return this;
  }

  public final StreetViewPanoramaOptions panoramaId(String paramString)
  {
    this.panoId = paramString;
    return this;
  }

  public final StreetViewPanoramaOptions position(LatLng paramLatLng)
  {
    this.position = paramLatLng;
    return this;
  }

  public final StreetViewPanoramaOptions position(LatLng paramLatLng, StreetViewSource paramStreetViewSource)
  {
    this.position = paramLatLng;
    this.zzcc = paramStreetViewSource;
    return this;
  }

  public final StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger)
  {
    this.position = paramLatLng;
    this.zzby = paramInteger;
    return this;
  }

  public final StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger, StreetViewSource paramStreetViewSource)
  {
    this.position = paramLatLng;
    this.zzby = paramInteger;
    this.zzcc = paramStreetViewSource;
    return this;
  }

  public final StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean)
  {
    this.zzcb = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final String toString()
  {
    return Objects.toStringHelper(this).add("PanoramaId", this.panoId).add("Position", this.position).add("Radius", this.zzby).add("Source", this.zzcc).add("StreetViewPanoramaCamera", this.zzbx).add("UserNavigationEnabled", this.zzbz).add("ZoomGesturesEnabled", this.zzap).add("PanningGesturesEnabled", this.zzca).add("StreetNamesEnabled", this.zzcb).add("UseViewLifecycleInFragment", this.zzak).toString();
  }

  public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.zzak = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean)
  {
    this.zzbz = Boolean.valueOf(paramBoolean);
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStreetViewPanoramaCamera(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, getPanoramaId(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, getPosition(), paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, getRadius(), false);
    SafeParcelWriter.writeByte(paramParcel, 6, zza.zza(this.zzbz));
    SafeParcelWriter.writeByte(paramParcel, 7, zza.zza(this.zzap));
    SafeParcelWriter.writeByte(paramParcel, 8, zza.zza(this.zzca));
    SafeParcelWriter.writeByte(paramParcel, 9, zza.zza(this.zzcb));
    SafeParcelWriter.writeByte(paramParcel, 10, zza.zza(this.zzak));
    SafeParcelWriter.writeParcelable(paramParcel, 11, getSource(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.zzap = Boolean.valueOf(paramBoolean);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaOptions
 * JD-Core Version:    0.6.2
 */