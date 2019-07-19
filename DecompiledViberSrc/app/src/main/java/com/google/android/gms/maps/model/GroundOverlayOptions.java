package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

@SafeParcelable.Class(creator="GroundOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
public final class GroundOverlayOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzd();
  public static final float NO_DIMENSION = -1.0F;

  @SafeParcelable.Field(getter="getBearing", id=7)
  private float bearing;

  @SafeParcelable.Field(getter="getHeight", id=5)
  private float height;

  @SafeParcelable.Field(getter="getWidth", id=4)
  private float width;

  @SafeParcelable.Field(getter="getZIndex", id=8)
  private float zzcs;

  @SafeParcelable.Field(getter="isVisible", id=9)
  private boolean zzct = true;

  @SafeParcelable.Field(getter="isClickable", id=13)
  private boolean zzcu = false;

  @SafeParcelable.Field(getter="getWrappedImageDescriptorImplBinder", id=2, type="android.os.IBinder")
  private BitmapDescriptor zzcx;

  @SafeParcelable.Field(getter="getLocation", id=3)
  private LatLng zzcy;

  @SafeParcelable.Field(getter="getBounds", id=6)
  private LatLngBounds zzcz;

  @SafeParcelable.Field(getter="getTransparency", id=10)
  private float zzda = 0.0F;

  @SafeParcelable.Field(getter="getAnchorU", id=11)
  private float zzdb = 0.5F;

  @SafeParcelable.Field(getter="getAnchorV", id=12)
  private float zzdc = 0.5F;

  public GroundOverlayOptions()
  {
  }

  @SafeParcelable.Constructor
  GroundOverlayOptions(@SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) LatLng paramLatLng, @SafeParcelable.Param(id=4) float paramFloat1, @SafeParcelable.Param(id=5) float paramFloat2, @SafeParcelable.Param(id=6) LatLngBounds paramLatLngBounds, @SafeParcelable.Param(id=7) float paramFloat3, @SafeParcelable.Param(id=8) float paramFloat4, @SafeParcelable.Param(id=9) boolean paramBoolean1, @SafeParcelable.Param(id=10) float paramFloat5, @SafeParcelable.Param(id=11) float paramFloat6, @SafeParcelable.Param(id=12) float paramFloat7, @SafeParcelable.Param(id=13) boolean paramBoolean2)
  {
    this.zzcx = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(paramIBinder));
    this.zzcy = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.zzcz = paramLatLngBounds;
    this.bearing = paramFloat3;
    this.zzcs = paramFloat4;
    this.zzct = paramBoolean1;
    this.zzda = paramFloat5;
    this.zzdb = paramFloat6;
    this.zzdc = paramFloat7;
    this.zzcu = paramBoolean2;
  }

  private final GroundOverlayOptions zza(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.zzcy = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    return this;
  }

  public final GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.zzdb = paramFloat1;
    this.zzdc = paramFloat2;
    return this;
  }

  public final GroundOverlayOptions bearing(float paramFloat)
  {
    this.bearing = ((360.0F + paramFloat % 360.0F) % 360.0F);
    return this;
  }

  public final GroundOverlayOptions clickable(boolean paramBoolean)
  {
    this.zzcu = paramBoolean;
    return this;
  }

  public final float getAnchorU()
  {
    return this.zzdb;
  }

  public final float getAnchorV()
  {
    return this.zzdc;
  }

  public final float getBearing()
  {
    return this.bearing;
  }

  public final LatLngBounds getBounds()
  {
    return this.zzcz;
  }

  public final float getHeight()
  {
    return this.height;
  }

  public final BitmapDescriptor getImage()
  {
    return this.zzcx;
  }

  public final LatLng getLocation()
  {
    return this.zzcy;
  }

  public final float getTransparency()
  {
    return this.zzda;
  }

  public final float getWidth()
  {
    return this.width;
  }

  public final float getZIndex()
  {
    return this.zzcs;
  }

  public final GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    Preconditions.checkNotNull(paramBitmapDescriptor, "imageDescriptor must not be null");
    this.zzcx = paramBitmapDescriptor;
    return this;
  }

  public final boolean isClickable()
  {
    return this.zzcu;
  }

  public final boolean isVisible()
  {
    return this.zzct;
  }

  public final GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (this.zzcz == null)
    {
      bool2 = bool1;
      Preconditions.checkState(bool2, "Position has already been set using positionFromBounds");
      if (paramLatLng == null)
        break label60;
      bool3 = bool1;
      label26: Preconditions.checkArgument(bool3, "Location must be specified");
      if (paramFloat < 0.0F)
        break label66;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "Width must be non-negative");
      return zza(paramLatLng, paramFloat, -1.0F);
      bool2 = false;
      break;
      label60: bool3 = false;
      break label26;
      label66: bool1 = false;
    }
  }

  public final GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label29: boolean bool4;
    if (this.zzcz == null)
    {
      bool2 = bool1;
      Preconditions.checkState(bool2, "Position has already been set using positionFromBounds");
      if (paramLatLng == null)
        break label80;
      bool3 = bool1;
      Preconditions.checkArgument(bool3, "Location must be specified");
      if (paramFloat1 < 0.0F)
        break label86;
      bool4 = bool1;
      label46: Preconditions.checkArgument(bool4, "Width must be non-negative");
      if (paramFloat2 < 0.0F)
        break label92;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "Height must be non-negative");
      return zza(paramLatLng, paramFloat1, paramFloat2);
      bool2 = false;
      break;
      label80: bool3 = false;
      break label29;
      label86: bool4 = false;
      break label46;
      label92: bool1 = false;
    }
  }

  public final GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (this.zzcy == null);
    for (boolean bool = true; ; bool = false)
    {
      String str = String.valueOf(this.zzcy);
      Preconditions.checkState(bool, 46 + String.valueOf(str).length() + "Position has already been set using position: " + str);
      this.zzcz = paramLatLngBounds;
      return this;
    }
  }

  public final GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Transparency must be in the range [0..1]");
      this.zzda = paramFloat;
      return this;
    }
  }

  public final GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.zzct = paramBoolean;
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzcx.zzb().asBinder(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getLocation(), paramInt, false);
    SafeParcelWriter.writeFloat(paramParcel, 4, getWidth());
    SafeParcelWriter.writeFloat(paramParcel, 5, getHeight());
    SafeParcelWriter.writeParcelable(paramParcel, 6, getBounds(), paramInt, false);
    SafeParcelWriter.writeFloat(paramParcel, 7, getBearing());
    SafeParcelWriter.writeFloat(paramParcel, 8, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 9, isVisible());
    SafeParcelWriter.writeFloat(paramParcel, 10, getTransparency());
    SafeParcelWriter.writeFloat(paramParcel, 11, getAnchorU());
    SafeParcelWriter.writeFloat(paramParcel, 12, getAnchorV());
    SafeParcelWriter.writeBoolean(paramParcel, 13, isClickable());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final GroundOverlayOptions zIndex(float paramFloat)
  {
    this.zzcs = paramFloat;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlayOptions
 * JD-Core Version:    0.6.2
 */