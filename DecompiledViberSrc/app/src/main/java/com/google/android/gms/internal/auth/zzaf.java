package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="SendDataRequestCreator")
public final class zzaf extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaf> CREATOR = new zzag();

  @SafeParcelable.Field(id=2)
  private final String accountType;

  @SafeParcelable.Field(id=3)
  private final byte[] zzbp;

  @SafeParcelable.VersionField(id=1)
  private final int zzv = 1;

  @SafeParcelable.Constructor
  zzaf(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) byte[] paramArrayOfByte)
  {
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    this.zzbp = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
  }

  public zzaf(String paramString, byte[] paramArrayOfByte)
  {
    this(1, paramString, paramArrayOfByte);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzv);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, this.zzbp, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzaf
 * JD-Core Version:    0.6.2
 */