package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="GassEventParcelCreator")
public final class zzdax extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdax> CREATOR = new zzday();

  @SafeParcelable.VersionField(id=1)
  private final int versionCode;

  @SafeParcelable.Field(id=2)
  private final byte[] zzgou;

  @SafeParcelable.Constructor
  zzdax(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) byte[] paramArrayOfByte)
  {
    this.versionCode = paramInt;
    this.zzgou = paramArrayOfByte;
  }

  public zzdax(byte[] paramArrayOfByte)
  {
    this(1, paramArrayOfByte);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeByteArray(paramParcel, 2, this.zzgou, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdax
 * JD-Core Version:    0.6.2
 */