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

@SafeParcelable.Class(creator="StreetViewPanoramaLocationCreator")
@SafeParcelable.Reserved({1})
public class StreetViewPanoramaLocation extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new zzo();

  @SafeParcelable.Field(id=2)
  public final StreetViewPanoramaLink[] links;

  @SafeParcelable.Field(id=4)
  public final String panoId;

  @SafeParcelable.Field(id=3)
  public final LatLng position;

  @SafeParcelable.Constructor
  public StreetViewPanoramaLocation(@SafeParcelable.Param(id=2) StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, @SafeParcelable.Param(id=3) LatLng paramLatLng, @SafeParcelable.Param(id=4) String paramString)
  {
    this.links = paramArrayOfStreetViewPanoramaLink;
    this.position = paramLatLng;
    this.panoId = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StreetViewPanoramaLocation localStreetViewPanoramaLocation;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaLocation))
        return false;
      localStreetViewPanoramaLocation = (StreetViewPanoramaLocation)paramObject;
    }
    while ((this.panoId.equals(localStreetViewPanoramaLocation.panoId)) && (this.position.equals(localStreetViewPanoramaLocation.position)));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.position;
    arrayOfObject[1] = this.panoId;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("panoId", this.panoId).add("position", this.position.toString()).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.links, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.position, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.panoId, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLocation
 * JD-Core Version:    0.6.2
 */