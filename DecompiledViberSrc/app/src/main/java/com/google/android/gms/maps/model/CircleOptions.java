package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@SafeParcelable.Class(creator="CircleOptionsCreator")
@SafeParcelable.Reserved({1})
public final class CircleOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();

  @SafeParcelable.Field(getter="getFillColor", id=6)
  private int fillColor = 0;

  @SafeParcelable.Field(getter="getStrokeColor", id=5)
  private int strokeColor = -16777216;

  @SafeParcelable.Field(getter="getCenter", id=2)
  private LatLng zzcp = null;

  @SafeParcelable.Field(getter="getRadius", id=3)
  private double zzcq = 0.0D;

  @SafeParcelable.Field(getter="getStrokeWidth", id=4)
  private float zzcr = 10.0F;

  @SafeParcelable.Field(getter="getZIndex", id=7)
  private float zzcs = 0.0F;

  @SafeParcelable.Field(getter="isVisible", id=8)
  private boolean zzct = true;

  @SafeParcelable.Field(getter="isClickable", id=9)
  private boolean zzcu = false;

  @SafeParcelable.Field(getter="getStrokePattern", id=10)
  private List<PatternItem> zzcv = null;

  public CircleOptions()
  {
  }

  @SafeParcelable.Constructor
  CircleOptions(@SafeParcelable.Param(id=2) LatLng paramLatLng, @SafeParcelable.Param(id=3) double paramDouble, @SafeParcelable.Param(id=4) float paramFloat1, @SafeParcelable.Param(id=5) int paramInt1, @SafeParcelable.Param(id=6) int paramInt2, @SafeParcelable.Param(id=7) float paramFloat2, @SafeParcelable.Param(id=8) boolean paramBoolean1, @SafeParcelable.Param(id=9) boolean paramBoolean2, @SafeParcelable.Param(id=10) List<PatternItem> paramList)
  {
    this.zzcp = paramLatLng;
    this.zzcq = paramDouble;
    this.zzcr = paramFloat1;
    this.strokeColor = paramInt1;
    this.fillColor = paramInt2;
    this.zzcs = paramFloat2;
    this.zzct = paramBoolean1;
    this.zzcu = paramBoolean2;
    this.zzcv = paramList;
  }

  public final CircleOptions center(LatLng paramLatLng)
  {
    this.zzcp = paramLatLng;
    return this;
  }

  public final CircleOptions clickable(boolean paramBoolean)
  {
    this.zzcu = paramBoolean;
    return this;
  }

  public final CircleOptions fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }

  public final LatLng getCenter()
  {
    return this.zzcp;
  }

  public final int getFillColor()
  {
    return this.fillColor;
  }

  public final double getRadius()
  {
    return this.zzcq;
  }

  public final int getStrokeColor()
  {
    return this.strokeColor;
  }

  public final List<PatternItem> getStrokePattern()
  {
    return this.zzcv;
  }

  public final float getStrokeWidth()
  {
    return this.zzcr;
  }

  public final float getZIndex()
  {
    return this.zzcs;
  }

  public final boolean isClickable()
  {
    return this.zzcu;
  }

  public final boolean isVisible()
  {
    return this.zzct;
  }

  public final CircleOptions radius(double paramDouble)
  {
    this.zzcq = paramDouble;
    return this;
  }

  public final CircleOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }

  public final CircleOptions strokePattern(List<PatternItem> paramList)
  {
    this.zzcv = paramList;
    return this;
  }

  public final CircleOptions strokeWidth(float paramFloat)
  {
    this.zzcr = paramFloat;
    return this;
  }

  public final CircleOptions visible(boolean paramBoolean)
  {
    this.zzct = paramBoolean;
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getCenter(), paramInt, false);
    SafeParcelWriter.writeDouble(paramParcel, 3, getRadius());
    SafeParcelWriter.writeFloat(paramParcel, 4, getStrokeWidth());
    SafeParcelWriter.writeInt(paramParcel, 5, getStrokeColor());
    SafeParcelWriter.writeInt(paramParcel, 6, getFillColor());
    SafeParcelWriter.writeFloat(paramParcel, 7, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 8, isVisible());
    SafeParcelWriter.writeBoolean(paramParcel, 9, isClickable());
    SafeParcelWriter.writeTypedList(paramParcel, 10, getStrokePattern(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final CircleOptions zIndex(float paramFloat)
  {
    this.zzcs = paramFloat;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CircleOptions
 * JD-Core Version:    0.6.2
 */