package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzare
@SafeParcelable.Class(creator="HttpResponseParcelCreator")
public final class zzaib extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaib> CREATOR = new zzaic();

  @SafeParcelable.Field(id=4)
  public final byte[] data;

  @SafeParcelable.Field(id=3)
  public final int statusCode;

  @SafeParcelable.Field(id=7)
  public final boolean zzac;

  @SafeParcelable.Field(id=8)
  public final long zzad;

  @SafeParcelable.Field(id=5)
  public final String[] zzdat;

  @SafeParcelable.Field(id=6)
  public final String[] zzdau;

  @SafeParcelable.Field(id=1)
  public final boolean zzdav;

  @SafeParcelable.Field(id=2)
  public final String zzdaw;

  @SafeParcelable.Constructor
  zzaib(@SafeParcelable.Param(id=1) boolean paramBoolean1, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt, @SafeParcelable.Param(id=4) byte[] paramArrayOfByte, @SafeParcelable.Param(id=5) String[] paramArrayOfString1, @SafeParcelable.Param(id=6) String[] paramArrayOfString2, @SafeParcelable.Param(id=7) boolean paramBoolean2, @SafeParcelable.Param(id=8) long paramLong)
  {
    this.zzdav = paramBoolean1;
    this.zzdaw = paramString;
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.zzdat = paramArrayOfString1;
    this.zzdau = paramArrayOfString2;
    this.zzac = paramBoolean2;
    this.zzad = paramLong;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, this.zzdav);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzdaw, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.statusCode);
    SafeParcelWriter.writeByteArray(paramParcel, 4, this.data, false);
    SafeParcelWriter.writeStringArray(paramParcel, 5, this.zzdat, false);
    SafeParcelWriter.writeStringArray(paramParcel, 6, this.zzdau, false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzac);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzad);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaib
 * JD-Core Version:    0.6.2
 */