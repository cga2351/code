package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="NetworkLocationStatusCreator")
public final class zzaj extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaj> CREATOR = new zzak();

  @SafeParcelable.Field(defaultValueUnchecked="LocationAvailability.STATUS_UNKNOWN", id=2)
  private final int zzar;

  @SafeParcelable.Field(defaultValueUnchecked="LocationAvailability.STATUS_UNKNOWN", id=1)
  private final int zzas;

  @SafeParcelable.Field(defaultValueUnchecked="NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id=4)
  private final long zzat;

  @SafeParcelable.Field(defaultValueUnchecked="NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id=3)
  private final long zzbt;

  @SafeParcelable.Constructor
  zzaj(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) long paramLong1, @SafeParcelable.Param(id=4) long paramLong2)
  {
    this.zzas = paramInt1;
    this.zzar = paramInt2;
    this.zzbt = paramLong1;
    this.zzat = paramLong2;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzaj localzzaj;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzaj = (zzaj)paramObject;
    }
    while ((this.zzas == localzzaj.zzas) && (this.zzar == localzzaj.zzar) && (this.zzbt == localzzaj.zzbt) && (this.zzat == localzzaj.zzat));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.zzar);
    arrayOfObject[1] = Integer.valueOf(this.zzas);
    arrayOfObject[2] = Long.valueOf(this.zzat);
    arrayOfObject[3] = Long.valueOf(this.zzbt);
    return Objects.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NetworkLocationStatus:");
    localStringBuilder.append(" Wifi status: ").append(this.zzas).append(" Cell status: ").append(this.zzar).append(" elapsed time NS: ").append(this.zzat).append(" system time ms: ").append(this.zzbt);
    return localStringBuilder.toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzas);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzar);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzbt);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzat);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzaj
 * JD-Core Version:    0.6.2
 */