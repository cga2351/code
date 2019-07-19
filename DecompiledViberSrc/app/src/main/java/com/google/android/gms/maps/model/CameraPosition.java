package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
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
import com.google.android.gms.maps.GoogleMapOptions;

@SafeParcelable.Class(creator="CameraPositionCreator")
@SafeParcelable.Reserved({1})
public final class CameraPosition extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<CameraPosition> CREATOR = new zza();

  @SafeParcelable.Field(id=5)
  public final float bearing;

  @SafeParcelable.Field(id=2)
  public final LatLng target;

  @SafeParcelable.Field(id=4)
  public final float tilt;

  @SafeParcelable.Field(id=3)
  public final float zoom;

  @SafeParcelable.Constructor
  public CameraPosition(@SafeParcelable.Param(id=2) LatLng paramLatLng, @SafeParcelable.Param(id=3) float paramFloat1, @SafeParcelable.Param(id=4) float paramFloat2, @SafeParcelable.Param(id=5) float paramFloat3)
  {
    Preconditions.checkNotNull(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F));
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Float.valueOf(paramFloat2);
      Preconditions.checkArgument(bool, "Tilt needs to be between 0 and 90 inclusive: %s", arrayOfObject);
      this.target = paramLatLng;
      this.zoom = paramFloat1;
      this.tilt = (paramFloat2 + 0.0F);
      if (paramFloat3 <= 0.0D)
        paramFloat3 = 360.0F + paramFloat3 % 360.0F;
      this.bearing = (paramFloat3 % 360.0F);
      return;
    }
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static Builder builder(CameraPosition paramCameraPosition)
  {
    return new Builder(paramCameraPosition);
  }

  public static CameraPosition createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    return GoogleMapOptions.zzb(paramContext, paramAttributeSet);
  }

  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CameraPosition localCameraPosition;
    do
    {
      return true;
      if (!(paramObject instanceof CameraPosition))
        return false;
      localCameraPosition = (CameraPosition)paramObject;
    }
    while ((this.target.equals(localCameraPosition.target)) && (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(localCameraPosition.zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(localCameraPosition.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(localCameraPosition.bearing)));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.target;
    arrayOfObject[1] = Float.valueOf(this.zoom);
    arrayOfObject[2] = Float.valueOf(this.tilt);
    arrayOfObject[3] = Float.valueOf(this.bearing);
    return Objects.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    return Objects.toStringHelper(this).add("target", this.target).add("zoom", Float.valueOf(this.zoom)).add("tilt", Float.valueOf(this.tilt)).add("bearing", Float.valueOf(this.bearing)).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.target, paramInt, false);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.zoom);
    SafeParcelWriter.writeFloat(paramParcel, 4, this.tilt);
    SafeParcelWriter.writeFloat(paramParcel, 5, this.bearing);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static final class Builder
  {
    private float bearing;
    private LatLng target;
    private float tilt;
    private float zoom;

    public Builder()
    {
    }

    public Builder(CameraPosition paramCameraPosition)
    {
      this.target = paramCameraPosition.target;
      this.zoom = paramCameraPosition.zoom;
      this.tilt = paramCameraPosition.tilt;
      this.bearing = paramCameraPosition.bearing;
    }

    public final Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }

    public final CameraPosition build()
    {
      return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
    }

    public final Builder target(LatLng paramLatLng)
    {
      this.target = paramLatLng;
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
 * Qualified Name:     com.google.android.gms.maps.model.CameraPosition
 * JD-Core Version:    0.6.2
 */