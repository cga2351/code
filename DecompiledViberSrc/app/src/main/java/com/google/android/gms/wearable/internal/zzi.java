package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="AmsEntityUpdateParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzi extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzi> CREATOR = new zzj();

  @SafeParcelable.Field(getter="getValue", id=4)
  private final String value;

  @SafeParcelable.Field(getter="getEntityId", id=2)
  private byte zzbd;

  @SafeParcelable.Field(getter="getAttributeId", id=3)
  private final byte zzbe;

  @SafeParcelable.Constructor
  public zzi(@SafeParcelable.Param(id=2) byte paramByte1, @SafeParcelable.Param(id=3) byte paramByte2, @SafeParcelable.Param(id=4) String paramString)
  {
    this.zzbd = paramByte1;
    this.zzbe = paramByte2;
    this.value = paramString;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzi localzzi;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzi = (zzi)paramObject;
      if (this.zzbd != localzzi.zzbd)
        return false;
      if (this.zzbe != localzzi.zzbe)
        return false;
    }
    while (this.value.equals(localzzi.value));
    return false;
  }

  public final int hashCode()
  {
    return 31 * (31 * (31 + this.zzbd) + this.zzbe) + this.value.hashCode();
  }

  public final String toString()
  {
    int i = this.zzbd;
    int j = this.zzbe;
    String str = this.value;
    return 73 + String.valueOf(str).length() + "AmsEntityUpdateParcelable{, mEntityId=" + i + ", mAttributeId=" + j + ", mValue='" + str + '\'' + '}';
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeByte(paramParcel, 2, this.zzbd);
    SafeParcelWriter.writeByte(paramParcel, 3, this.zzbe);
    SafeParcelWriter.writeString(paramParcel, 4, this.value, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzi
 * JD-Core Version:    0.6.2
 */