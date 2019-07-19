package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="StreetViewPanoramaOrientationCreator")
@SafeParcelable.Reserved({1})
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new zzp();

  @SafeParcelable.Field(id=3)
  public final float bearing;

  @SafeParcelable.Field(id=2)
  public final float tilt;

  @SafeParcelable.Constructor
  public StreetViewPanoramaOrientation(@SafeParcelable.Param(id=2) float paramFloat1, @SafeParcelable.Param(id=3) float paramFloat2)
  {
    if ((-90.0F <= paramFloat1) && (paramFloat1 <= 90.0F));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, 62 + "Tilt needs to be between -90 and 90 inclusive: " + paramFloat1);
      this.tilt = (0.0F + paramFloat1);
      if (paramFloat2 <= 0.0D)
        paramFloat2 = 360.0F + paramFloat2 % 360.0F;
      this.bearing = (paramFloat2 % 360.0F);
      return;
    }
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static Builder builder(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    return new Builder(paramStreetViewPanoramaOrientation);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StreetViewPanoramaOrientation localStreetViewPanoramaOrientation;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaOrientation))
        return false;
      localStreetViewPanoramaOrientation = (StreetViewPanoramaOrientation)paramObject;
    }
    while ((Float.floatToIntBits(this.tilt) == Float.floatToIntBits(localStreetViewPanoramaOrientation.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(localStreetViewPanoramaOrientation.bearing)));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.tilt);
    arrayOfObject[1] = Float.valueOf(this.bearing);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("tilt", Float.valueOf(this.tilt)).add("bearing", Float.valueOf(this.bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeFloat(paramParcel, 2, this.tilt);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.bearing);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static final class Builder
  {
    public float bearing;
    public float tilt;

    public Builder()
    {
    }

    public Builder(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    {
      Preconditions.checkNotNull(paramStreetViewPanoramaOrientation, "StreetViewPanoramaOrientation");
      this.bearing = paramStreetViewPanoramaOrientation.bearing;
      this.tilt = paramStreetViewPanoramaOrientation.tilt;
    }

    public final Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }

    public final StreetViewPanoramaOrientation build()
    {
      return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
    }

    public final Builder tilt(float paramFloat)
    {
      this.tilt = paramFloat;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaOrientation
 * JD-Core Version:    0.6.2
 */