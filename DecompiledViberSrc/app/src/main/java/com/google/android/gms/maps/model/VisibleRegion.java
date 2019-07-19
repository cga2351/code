package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="VisibleRegionCreator")
@SafeParcelable.Reserved({1})
public final class VisibleRegion extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<VisibleRegion> CREATOR = new zzv();

  @SafeParcelable.Field(id=4)
  public final LatLng farLeft;

  @SafeParcelable.Field(id=5)
  public final LatLng farRight;

  @SafeParcelable.Field(id=6)
  public final LatLngBounds latLngBounds;

  @SafeParcelable.Field(id=2)
  public final LatLng nearLeft;

  @SafeParcelable.Field(id=3)
  public final LatLng nearRight;

  @SafeParcelable.Constructor
  public VisibleRegion(@SafeParcelable.Param(id=2) LatLng paramLatLng1, @SafeParcelable.Param(id=3) LatLng paramLatLng2, @SafeParcelable.Param(id=4) LatLng paramLatLng3, @SafeParcelable.Param(id=5) LatLng paramLatLng4, @SafeParcelable.Param(id=6) LatLngBounds paramLatLngBounds)
  {
    this.nearLeft = paramLatLng1;
    this.nearRight = paramLatLng2;
    this.farLeft = paramLatLng3;
    this.farRight = paramLatLng4;
    this.latLngBounds = paramLatLngBounds;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VisibleRegion localVisibleRegion;
    do
    {
      return true;
      if (!(paramObject instanceof VisibleRegion))
        return false;
      localVisibleRegion = (VisibleRegion)paramObject;
    }
    while ((this.nearLeft.equals(localVisibleRegion.nearLeft)) && (this.nearRight.equals(localVisibleRegion.nearRight)) && (this.farLeft.equals(localVisibleRegion.farLeft)) && (this.farRight.equals(localVisibleRegion.farRight)) && (this.latLngBounds.equals(localVisibleRegion.latLngBounds)));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.nearLeft;
    arrayOfObject[1] = this.nearRight;
    arrayOfObject[2] = this.farLeft;
    arrayOfObject[3] = this.farRight;
    arrayOfObject[4] = this.latLngBounds;
    return Objects.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    return Objects.toStringHelper(this).add("nearLeft", this.nearLeft).add("nearRight", this.nearRight).add("farLeft", this.farLeft).add("farRight", this.farRight).add("latLngBounds", this.latLngBounds).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.nearLeft, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.nearRight, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.farLeft, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.farRight, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.latLngBounds, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.VisibleRegion
 * JD-Core Version:    0.6.2
 */