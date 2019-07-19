package com.google.android.gms.maps.model;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="PolylineOptionsCreator")
@SafeParcelable.Reserved({1})
public final class PolylineOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzl();

  @SafeParcelable.Field(getter="getColor", id=4)
  private int color = -16777216;

  @SafeParcelable.Field(getter="getWidth", id=3)
  private float width = 10.0F;

  @SafeParcelable.Field(getter="getZIndex", id=5)
  private float zzcs = 0.0F;

  @SafeParcelable.Field(getter="isVisible", id=6)
  private boolean zzct = true;

  @SafeParcelable.Field(getter="isClickable", id=8)
  private boolean zzcu = false;

  @SafeParcelable.Field(getter="getPoints", id=2)
  private final List<LatLng> zzdx;

  @SafeParcelable.Field(getter="isGeodesic", id=7)
  private boolean zzdz = false;

  @SafeParcelable.Field(getter="getStartCap", id=9)
  private Cap zzec = new ButtCap();

  @SafeParcelable.Field(getter="getEndCap", id=10)
  private Cap zzed = new ButtCap();

  @SafeParcelable.Field(getter="getJointType", id=11)
  private int zzee = 0;

  @SafeParcelable.Field(getter="getPattern", id=12)
  private List<PatternItem> zzef = null;

  public PolylineOptions()
  {
    this.zzdx = new ArrayList();
  }

  @SafeParcelable.Constructor
  PolylineOptions(@SafeParcelable.Param(id=2) List paramList, @SafeParcelable.Param(id=3) float paramFloat1, @SafeParcelable.Param(id=4) int paramInt1, @SafeParcelable.Param(id=5) float paramFloat2, @SafeParcelable.Param(id=6) boolean paramBoolean1, @SafeParcelable.Param(id=7) boolean paramBoolean2, @SafeParcelable.Param(id=8) boolean paramBoolean3, @SafeParcelable.Param(id=9) Cap paramCap1, @SafeParcelable.Param(id=10) Cap paramCap2, @SafeParcelable.Param(id=11) int paramInt2, @SafeParcelable.Param(id=12) List<PatternItem> paramList1)
  {
    this.zzdx = paramList;
    this.width = paramFloat1;
    this.color = paramInt1;
    this.zzcs = paramFloat2;
    this.zzct = paramBoolean1;
    this.zzdz = paramBoolean2;
    this.zzcu = paramBoolean3;
    if (paramCap1 != null)
      this.zzec = paramCap1;
    if (paramCap2 != null)
      this.zzed = paramCap2;
    this.zzee = paramInt2;
    this.zzef = paramList1;
  }

  public final PolylineOptions add(LatLng paramLatLng)
  {
    this.zzdx.add(paramLatLng);
    return this;
  }

  public final PolylineOptions add(LatLng[] paramArrayOfLatLng)
  {
    this.zzdx.addAll(Arrays.asList(paramArrayOfLatLng));
    return this;
  }

  public final PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      LatLng localLatLng = (LatLng)localIterator.next();
      this.zzdx.add(localLatLng);
    }
    return this;
  }

  public final PolylineOptions clickable(boolean paramBoolean)
  {
    this.zzcu = paramBoolean;
    return this;
  }

  public final PolylineOptions color(int paramInt)
  {
    this.color = paramInt;
    return this;
  }

  public final PolylineOptions endCap(Cap paramCap)
  {
    this.zzed = ((Cap)Preconditions.checkNotNull(paramCap, "endCap must not be null"));
    return this;
  }

  public final PolylineOptions geodesic(boolean paramBoolean)
  {
    this.zzdz = paramBoolean;
    return this;
  }

  public final int getColor()
  {
    return this.color;
  }

  public final Cap getEndCap()
  {
    return this.zzed;
  }

  public final int getJointType()
  {
    return this.zzee;
  }

  public final List<PatternItem> getPattern()
  {
    return this.zzef;
  }

  public final List<LatLng> getPoints()
  {
    return this.zzdx;
  }

  public final Cap getStartCap()
  {
    return this.zzec;
  }

  public final float getWidth()
  {
    return this.width;
  }

  public final float getZIndex()
  {
    return this.zzcs;
  }

  public final boolean isClickable()
  {
    return this.zzcu;
  }

  public final boolean isGeodesic()
  {
    return this.zzdz;
  }

  public final boolean isVisible()
  {
    return this.zzct;
  }

  public final PolylineOptions jointType(int paramInt)
  {
    this.zzee = paramInt;
    return this;
  }

  public final PolylineOptions pattern(List<PatternItem> paramList)
  {
    this.zzef = paramList;
    return this;
  }

  public final PolylineOptions startCap(Cap paramCap)
  {
    this.zzec = ((Cap)Preconditions.checkNotNull(paramCap, "startCap must not be null"));
    return this;
  }

  public final PolylineOptions visible(boolean paramBoolean)
  {
    this.zzct = paramBoolean;
    return this;
  }

  public final PolylineOptions width(float paramFloat)
  {
    this.width = paramFloat;
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getPoints(), false);
    SafeParcelWriter.writeFloat(paramParcel, 3, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 4, getColor());
    SafeParcelWriter.writeFloat(paramParcel, 5, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isVisible());
    SafeParcelWriter.writeBoolean(paramParcel, 7, isGeodesic());
    SafeParcelWriter.writeBoolean(paramParcel, 8, isClickable());
    SafeParcelWriter.writeParcelable(paramParcel, 9, getStartCap(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 10, getEndCap(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 11, getJointType());
    SafeParcelWriter.writeTypedList(paramParcel, 12, getPattern(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final PolylineOptions zIndex(float paramFloat)
  {
    this.zzcs = paramFloat;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolylineOptions
 * JD-Core Version:    0.6.2
 */