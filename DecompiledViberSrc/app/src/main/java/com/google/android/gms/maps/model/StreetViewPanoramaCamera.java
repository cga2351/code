package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="StreetViewPanoramaCameraCreator")
@SafeParcelable.Reserved({1})
public class StreetViewPanoramaCamera extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new zzm();

  @SafeParcelable.Field(id=4)
  public final float bearing;

  @SafeParcelable.Field(id=3)
  public final float tilt;

  @SafeParcelable.Field(id=2)
  public final float zoom;
  private final StreetViewPanoramaOrientation zzeg;

  @SafeParcelable.Constructor
  public StreetViewPanoramaCamera(@SafeParcelable.Param(id=2) float paramFloat1, @SafeParcelable.Param(id=3) float paramFloat2, @SafeParcelable.Param(id=4) float paramFloat3)
  {
    boolean bool;
    if ((-90.0F <= paramFloat2) && (paramFloat2 <= 90.0F))
    {
      bool = true;
      Preconditions.checkArgument(bool, 62 + "Tilt needs to be between -90 and 90 inclusive: " + paramFloat2);
      if (paramFloat1 <= 0.0D)
        paramFloat1 = 0.0F;
      this.zoom = paramFloat1;
      this.tilt = (paramFloat2 + 0.0F);
      if (paramFloat3 > 0.0D)
        break label122;
    }
    label122: for (float f = 360.0F + paramFloat3 % 360.0F; ; f = paramFloat3)
    {
      this.bearing = (f % 360.0F);
      this.zzeg = new StreetViewPanoramaOrientation.Builder().tilt(paramFloat2).bearing(paramFloat3).build();
      return;
      bool = false;
      break;
    }
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static Builder builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    return new Builder(paramStreetViewPanoramaCamera);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StreetViewPanoramaCamera localStreetViewPanoramaCamera;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaCamera))
        return false;
      localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)paramObject;
    }
    while ((Float.floatToIntBits(this.zoom) == Float.floatToIntBits(localStreetViewPanoramaCamera.zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(localStreetViewPanoramaCamera.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(localStreetViewPanoramaCamera.bearing)));
    return false;
  }

  public StreetViewPanoramaOrientation getOrientation()
  {
    return this.zzeg;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Float.valueOf(this.zoom);
    arrayOfObject[1] = Float.valueOf(this.tilt);
    arrayOfObject[2] = Float.valueOf(this.bearing);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("zoom", Float.valueOf(this.zoom)).add("tilt", Float.valueOf(this.tilt)).add("bearing", Float.valueOf(this.bearing)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeFloat(paramParcel, 2, this.zoom);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.tilt);
    SafeParcelWriter.writeFloat(paramParcel, 4, this.bearing);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static final class Builder
  {
    public float bearing;
    public float tilt;
    public float zoom;

    public Builder()
    {
    }

    public Builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
    {
      Preconditions.checkNotNull(paramStreetViewPanoramaCamera, "StreetViewPanoramaCamera");
      this.zoom = paramStreetViewPanoramaCamera.zoom;
      this.bearing = paramStreetViewPanoramaCamera.bearing;
      this.tilt = paramStreetViewPanoramaCamera.tilt;
    }

    public final Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }

    public final StreetViewPanoramaCamera build()
    {
      return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
    }

    public final Builder orientation(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    {
      Preconditions.checkNotNull(paramStreetViewPanoramaOrientation, "StreetViewPanoramaOrientation");
      this.tilt = paramStreetViewPanoramaOrientation.tilt;
      this.bearing = paramStreetViewPanoramaOrientation.bearing;
      return this;
    }

    public final Builder tilt(float paramFloat)
    {
      this.tilt = paramFloat;
      return this;
    }

    public final Builder zoom(float paramFloat)
    {
      this.zoom = paramFloat;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaCamera
 * JD-Core Version:    0.6.2
 */