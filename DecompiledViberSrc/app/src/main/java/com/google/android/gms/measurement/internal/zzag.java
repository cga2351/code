package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzag extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzag> CREATOR = new zzah();

  @SafeParcelable.Field(id=2)
  public final String name;

  @SafeParcelable.Field(id=4)
  public final String origin;

  @SafeParcelable.Field(id=3)
  public final zzad zzahu;

  @SafeParcelable.Field(id=5)
  public final long zzaig;

  zzag(zzag paramzzag, long paramLong)
  {
    Preconditions.checkNotNull(paramzzag);
    this.name = paramzzag.name;
    this.zzahu = paramzzag.zzahu;
    this.origin = paramzzag.origin;
    this.zzaig = paramLong;
  }

  @SafeParcelable.Constructor
  public zzag(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) zzad paramzzad, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) long paramLong)
  {
    this.name = paramString1;
    this.zzahu = paramzzad;
    this.origin = paramString2;
    this.zzaig = paramLong;
  }

  public final String toString()
  {
    String str1 = this.origin;
    String str2 = this.name;
    String str3 = String.valueOf(this.zzahu);
    return 21 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "origin=" + str1 + ",name=" + str2 + ",params=" + str3;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzahu, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.origin, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzaig);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzag
 * JD-Core Version:    0.6.2
 */