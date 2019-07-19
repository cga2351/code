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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="PolygonOptionsCreator")
@SafeParcelable.Reserved({1})
public final class PolygonOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzk();

  @SafeParcelable.Field(getter="getFillColor", id=6)
  private int fillColor = 0;

  @SafeParcelable.Field(getter="getStrokeColor", id=5)
  private int strokeColor = -16777216;

  @SafeParcelable.Field(getter="getStrokeWidth", id=4)
  private float zzcr = 10.0F;

  @SafeParcelable.Field(getter="getZIndex", id=7)
  private float zzcs = 0.0F;

  @SafeParcelable.Field(getter="isVisible", id=8)
  private boolean zzct = true;

  @SafeParcelable.Field(getter="isClickable", id=10)
  private boolean zzcu = false;

  @SafeParcelable.Field(getter="getStrokePattern", id=12)
  private List<PatternItem> zzcv = null;

  @SafeParcelable.Field(getter="getPoints", id=2)
  private final List<LatLng> zzdx;

  @SafeParcelable.Field(getter="getHolesForParcel", id=3, type="java.util.List")
  private final List<List<LatLng>> zzdy;

  @SafeParcelable.Field(getter="isGeodesic", id=9)
  private boolean zzdz = false;

  @SafeParcelable.Field(getter="getStrokeJointType", id=11)
  private int zzea = 0;

  public PolygonOptions()
  {
    this.zzdx = new ArrayList();
    this.zzdy = new ArrayList();
  }

  @SafeParcelable.Constructor
  PolygonOptions(@SafeParcelable.Param(id=2) List<LatLng> paramList, @SafeParcelable.Param(id=3) List paramList1, @SafeParcelable.Param(id=4) float paramFloat1, @SafeParcelable.Param(id=5) int paramInt1, @SafeParcelable.Param(id=6) int paramInt2, @SafeParcelable.Param(id=7) float paramFloat2, @SafeParcelable.Param(id=8) boolean paramBoolean1, @SafeParcelable.Param(id=9) boolean paramBoolean2, @SafeParcelable.Param(id=10) boolean paramBoolean3, @SafeParcelable.Param(id=11) int paramInt3, @SafeParcelable.Param(id=12) List<PatternItem> paramList2)
  {
    this.zzdx = paramList;
    this.zzdy = paramList1;
    this.zzcr = paramFloat1;
    this.strokeColor = paramInt1;
    this.fillColor = paramInt2;
    this.zzcs = paramFloat2;
    this.zzct = paramBoolean1;
    this.zzdz = paramBoolean2;
    this.zzcu = paramBoolean3;
    this.zzea = paramInt3;
    this.zzcv = paramList2;
  }

  public final PolygonOptions add(LatLng paramLatLng)
  {
    this.zzdx.add(paramLatLng);
    return this;
  }

  public final PolygonOptions add(LatLng[] paramArrayOfLatLng)
  {
    this.zzdx.addAll(Arrays.asList(paramArrayOfLatLng));
    return this;
  }

  public final PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      LatLng localLatLng = (LatLng)localIterator.next();
      this.zzdx.add(localLatLng);
    }
    return this;
  }

  public final PolygonOptions addHole(Iterable<LatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localArrayList.add((LatLng)localIterator.next());
    this.zzdy.add(localArrayList);
    return this;
  }

  public final PolygonOptions clickable(boolean paramBoolean)
  {
    this.zzcu = paramBoolean;
    return this;
  }

  public final PolygonOptions fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }

  public final PolygonOptions geodesic(boolean paramBoolean)
  {
    this.zzdz = paramBoolean;
    return this;
  }

  public final int getFillColor()
  {
    return this.fillColor;
  }

  public final List<List<LatLng>> getHoles()
  {
    return this.zzdy;
  }

  public final List<LatLng> getPoints()
  {
    return this.zzdx;
  }

  public final int getStrokeColor()
  {
    return this.strokeColor;
  }

  public final int getStrokeJointType()
  {
    return this.zzea;
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

  public final boolean isGeodesic()
  {
    return this.zzdz;
  }

  public final boolean isVisible()
  {
    return this.zzct;
  }

  public final PolygonOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }

  public final PolygonOptions strokeJointType(int paramInt)
  {
    this.zzea = paramInt;
    return this;
  }

  public final PolygonOptions strokePattern(List<PatternItem> paramList)
  {
    this.zzcv = paramList;
    return this;
  }

  public final PolygonOptions strokeWidth(float paramFloat)
  {
    this.zzcr = paramFloat;
    return this;
  }

  public final PolygonOptions visible(boolean paramBoolean)
  {
    this.zzct = paramBoolean;
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getPoints(), false);
    SafeParcelWriter.writeList(paramParcel, 3, this.zzdy, false);
    SafeParcelWriter.writeFloat(paramParcel, 4, getStrokeWidth());
    SafeParcelWriter.writeInt(paramParcel, 5, getStrokeColor());
    SafeParcelWriter.writeInt(paramParcel, 6, getFillColor());
    SafeParcelWriter.writeFloat(paramParcel, 7, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 8, isVisible());
    SafeParcelWriter.writeBoolean(paramParcel, 9, isGeodesic());
    SafeParcelWriter.writeBoolean(paramParcel, 10, isClickable());
    SafeParcelWriter.writeInt(paramParcel, 11, getStrokeJointType());
    SafeParcelWriter.writeTypedList(paramParcel, 12, getStrokePattern(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final PolygonOptions zIndex(float paramFloat)
  {
    this.zzcs = paramFloat;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolygonOptions
 * JD-Core Version:    0.6.2
 */