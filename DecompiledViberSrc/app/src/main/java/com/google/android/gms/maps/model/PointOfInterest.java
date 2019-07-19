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

@SafeParcelable.Class(creator="PointOfInterestCreator")
@SafeParcelable.Reserved({1})
public final class PointOfInterest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PointOfInterest> CREATOR = new zzj();

  @SafeParcelable.Field(id=2)
  public final LatLng latLng;

  @SafeParcelable.Field(id=4)
  public final String name;

  @SafeParcelable.Field(id=3)
  public final String placeId;

  @SafeParcelable.Constructor
  public PointOfInterest(@SafeParcelable.Param(id=2) LatLng paramLatLng, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) String paramString2)
  {
    this.latLng = paramLatLng;
    this.placeId = paramString1;
    this.name = paramString2;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.latLng, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.placeId, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.name, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PointOfInterest
 * JD-Core Version:    0.6.2
 */