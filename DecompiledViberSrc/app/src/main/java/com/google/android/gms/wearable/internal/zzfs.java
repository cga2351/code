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

@SafeParcelable.Class(creator="PackageStorageInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzfs extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfs> CREATOR = new zzft();

  @SafeParcelable.Field(id=3)
  private final String label;

  @SafeParcelable.Field(id=2)
  private final String packageName;

  @SafeParcelable.Field(id=4)
  private final long zzep;

  @SafeParcelable.Constructor
  public zzfs(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) long paramLong)
  {
    this.packageName = paramString1;
    this.label = paramString2;
    this.zzep = paramLong;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.label, false);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzep);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfs
 * JD-Core Version:    0.6.2
 */