package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

@SafeParcelable.Class(creator="MarkerOptionsCreator")
@SafeParcelable.Reserved({1})
public final class MarkerOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzh();

  @SafeParcelable.Field(defaultValue="1.0f", getter="getAlpha", id=14)
  private float alpha = 1.0F;

  @SafeParcelable.Field(getter="getPosition", id=2)
  private LatLng position;

  @SafeParcelable.Field(getter="getZIndex", id=15)
  private float zzcs;

  @SafeParcelable.Field(getter="isVisible", id=9)
  private boolean zzct = true;

  @SafeParcelable.Field(getter="getAnchorU", id=6)
  private float zzdb = 0.5F;

  @SafeParcelable.Field(getter="getAnchorV", id=7)
  private float zzdc = 1.0F;

  @SafeParcelable.Field(getter="getTitle", id=3)
  private String zzdn;

  @SafeParcelable.Field(getter="getSnippet", id=4)
  private String zzdo;

  @SafeParcelable.Field(getter="getWrappedIconDescriptorImplBinder", id=5, type="android.os.IBinder")
  private BitmapDescriptor zzdp;

  @SafeParcelable.Field(getter="isDraggable", id=8)
  private boolean zzdq;

  @SafeParcelable.Field(getter="isFlat", id=10)
  private boolean zzdr = false;

  @SafeParcelable.Field(getter="getRotation", id=11)
  private float zzds = 0.0F;

  @SafeParcelable.Field(defaultValue="0.5f", getter="getInfoWindowAnchorU", id=12)
  private float zzdt = 0.5F;

  @SafeParcelable.Field(getter="getInfoWindowAnchorV", id=13)
  private float zzdu = 0.0F;

  public MarkerOptions()
  {
  }

  @SafeParcelable.Constructor
  MarkerOptions(@SafeParcelable.Param(id=2) LatLng paramLatLng, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) IBinder paramIBinder, @SafeParcelable.Param(id=6) float paramFloat1, @SafeParcelable.Param(id=7) float paramFloat2, @SafeParcelable.Param(id=8) boolean paramBoolean1, @SafeParcelable.Param(id=9) boolean paramBoolean2, @SafeParcelable.Param(id=10) boolean paramBoolean3, @SafeParcelable.Param(id=11) float paramFloat3, @SafeParcelable.Param(id=12) float paramFloat4, @SafeParcelable.Param(id=13) float paramFloat5, @SafeParcelable.Param(id=14) float paramFloat6, @SafeParcelable.Param(id=15) float paramFloat7)
  {
    this.position = paramLatLng;
    this.zzdn = paramString1;
    this.zzdo = paramString2;
    if (paramIBinder == null);
    for (this.zzdp = null; ; this.zzdp = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(paramIBinder)))
    {
      this.zzdb = paramFloat1;
      this.zzdc = paramFloat2;
      this.zzdq = paramBoolean1;
      this.zzct = paramBoolean2;
      this.zzdr = paramBoolean3;
      this.zzds = paramFloat3;
      this.zzdt = paramFloat4;
      this.zzdu = paramFloat5;
      this.alpha = paramFloat6;
      this.zzcs = paramFloat7;
      return;
    }
  }

  public final MarkerOptions alpha(float paramFloat)
  {
    this.alpha = paramFloat;
    return this;
  }

  public final MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.zzdb = paramFloat1;
    this.zzdc = paramFloat2;
    return this;
  }

  public final MarkerOptions draggable(boolean paramBoolean)
  {
    this.zzdq = paramBoolean;
    return this;
  }

  public final MarkerOptions flat(boolean paramBoolean)
  {
    this.zzdr = paramBoolean;
    return this;
  }

  public final float getAlpha()
  {
    return this.alpha;
  }

  public final float getAnchorU()
  {
    return this.zzdb;
  }

  public final float getAnchorV()
  {
    return this.zzdc;
  }

  public final BitmapDescriptor getIcon()
  {
    return this.zzdp;
  }

  public final float getInfoWindowAnchorU()
  {
    return this.zzdt;
  }

  public final float getInfoWindowAnchorV()
  {
    return this.zzdu;
  }

  public final LatLng getPosition()
  {
    return this.position;
  }

  public final float getRotation()
  {
    return this.zzds;
  }

  public final String getSnippet()
  {
    return this.zzdo;
  }

  public final String getTitle()
  {
    return this.zzdn;
  }

  public final float getZIndex()
  {
    return this.zzcs;
  }

  public final MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.zzdp = paramBitmapDescriptor;
    return this;
  }

  public final MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.zzdt = paramFloat1;
    this.zzdu = paramFloat2;
    return this;
  }

  public final boolean isDraggable()
  {
    return this.zzdq;
  }

  public final boolean isFlat()
  {
    return this.zzdr;
  }

  public final boolean isVisible()
  {
    return this.zzct;
  }

  public final MarkerOptions position(LatLng paramLatLng)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    this.position = paramLatLng;
    return this;
  }

  public final MarkerOptions rotation(float paramFloat)
  {
    this.zzds = paramFloat;
    return this;
  }

  public final MarkerOptions snippet(String paramString)
  {
    this.zzdo = paramString;
    return this;
  }

  public final MarkerOptions title(String paramString)
  {
    this.zzdn = paramString;
    return this;
  }

  public final MarkerOptions visible(boolean paramBoolean)
  {
    this.zzct = paramBoolean;
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getPosition(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, getTitle(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getSnippet(), false);
    if (this.zzdp == null);
    for (IBinder localIBinder = null; ; localIBinder = this.zzdp.zzb().asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 5, localIBinder, false);
      SafeParcelWriter.writeFloat(paramParcel, 6, getAnchorU());
      SafeParcelWriter.writeFloat(paramParcel, 7, getAnchorV());
      SafeParcelWriter.writeBoolean(paramParcel, 8, isDraggable());
      SafeParcelWriter.writeBoolean(paramParcel, 9, isVisible());
      SafeParcelWriter.writeBoolean(paramParcel, 10, isFlat());
      SafeParcelWriter.writeFloat(paramParcel, 11, getRotation());
      SafeParcelWriter.writeFloat(paramParcel, 12, getInfoWindowAnchorU());
      SafeParcelWriter.writeFloat(paramParcel, 13, getInfoWindowAnchorV());
      SafeParcelWriter.writeFloat(paramParcel, 14, getAlpha());
      SafeParcelWriter.writeFloat(paramParcel, 15, getZIndex());
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }

  public final MarkerOptions zIndex(float paramFloat)
  {
    this.zzcs = paramFloat;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.MarkerOptions
 * JD-Core Version:    0.6.2
 */