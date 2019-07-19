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

@SafeParcelable.Class(creator="StreetViewPanoramaLinkCreator")
@SafeParcelable.Reserved({1})
public class StreetViewPanoramaLink extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new zzn();

  @SafeParcelable.Field(id=3)
  public final float bearing;

  @SafeParcelable.Field(id=2)
  public final String panoId;

  @SafeParcelable.Constructor
  public StreetViewPanoramaLink(@SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) float paramFloat)
  {
    this.panoId = paramString;
    if (paramFloat <= 0.0D)
      paramFloat = 360.0F + paramFloat % 360.0F;
    this.bearing = (paramFloat % 360.0F);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StreetViewPanoramaLink localStreetViewPanoramaLink;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaLink))
        return false;
      localStreetViewPanoramaLink = (StreetViewPanoramaLink)paramObject;
    }
    while ((this.panoId.equals(localStreetViewPanoramaLink.panoId)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(localStreetViewPanoramaLink.bearing)));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.panoId;
    arrayOfObject[1] = Float.valueOf(this.bearing);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("panoId", this.panoId).add("bearing", Float.valueOf(this.bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.panoId, false);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.bearing);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLink
 * JD-Core Version:    0.6.2
 */