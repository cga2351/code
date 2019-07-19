package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;

@SafeParcelable.Class(creator="LocationAvailabilityCreator")
@SafeParcelable.Reserved({1000})
public final class LocationAvailability extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzaa();

  @Deprecated
  @SafeParcelable.Field(defaultValueUnchecked="LocationAvailability.STATUS_UNKNOWN", id=1)
  private int zzar;

  @Deprecated
  @SafeParcelable.Field(defaultValueUnchecked="LocationAvailability.STATUS_UNKNOWN", id=2)
  private int zzas;

  @SafeParcelable.Field(defaultValueUnchecked="0", id=3)
  private long zzat;

  @SafeParcelable.Field(defaultValueUnchecked="LocationAvailability.STATUS_UNSUCCESSFUL", id=4)
  private int zzau;

  @SafeParcelable.Field(id=5)
  private zzaj[] zzav;

  @SafeParcelable.Constructor
  LocationAvailability(@SafeParcelable.Param(id=4) int paramInt1, @SafeParcelable.Param(id=1) int paramInt2, @SafeParcelable.Param(id=2) int paramInt3, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=5) zzaj[] paramArrayOfzzaj)
  {
    this.zzau = paramInt1;
    this.zzar = paramInt2;
    this.zzas = paramInt3;
    this.zzat = paramLong;
    this.zzav = paramArrayOfzzaj;
  }

  public static LocationAvailability extractLocationAvailability(Intent paramIntent)
  {
    if (!hasLocationAvailability(paramIntent))
      return null;
    return (LocationAvailability)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }

  public static boolean hasLocationAvailability(Intent paramIntent)
  {
    if (paramIntent == null)
      return false;
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationAvailability localLocationAvailability;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationAvailability = (LocationAvailability)paramObject;
    }
    while ((this.zzar == localLocationAvailability.zzar) && (this.zzas == localLocationAvailability.zzas) && (this.zzat == localLocationAvailability.zzat) && (this.zzau == localLocationAvailability.zzau) && (Arrays.equals(this.zzav, localLocationAvailability.zzav)));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Integer.valueOf(this.zzau);
    arrayOfObject[1] = Integer.valueOf(this.zzar);
    arrayOfObject[2] = Integer.valueOf(this.zzas);
    arrayOfObject[3] = Long.valueOf(this.zzat);
    arrayOfObject[4] = this.zzav;
    return Objects.hashCode(arrayOfObject);
  }

  public final boolean isLocationAvailable()
  {
    return this.zzau < 1000;
  }

  public final String toString()
  {
    boolean bool = isLocationAvailable();
    return 48 + "LocationAvailability[isLocationAvailable: " + bool + "]";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzar);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzas);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzat);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzau);
    SafeParcelWriter.writeTypedArray(paramParcel, 5, this.zzav, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationAvailability
 * JD-Core Version:    0.6.2
 */