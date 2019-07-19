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
import java.util.List;

@SafeParcelable.Class(creator="StorageInfoResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzge extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzge> CREATOR = new zzgf();

  @SafeParcelable.Field(id=2)
  private final int statusCode;

  @SafeParcelable.Field(id=3)
  private final long zzep;

  @SafeParcelable.Field(id=4)
  private final List<zzfs> zzer;

  @SafeParcelable.Constructor
  public zzge(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=4) List<zzfs> paramList)
  {
    this.statusCode = paramInt;
    this.zzep = paramLong;
    this.zzer = paramList;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzep);
    SafeParcelWriter.writeTypedList(paramParcel, 4, this.zzer, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzge
 * JD-Core Version:    0.6.2
 */