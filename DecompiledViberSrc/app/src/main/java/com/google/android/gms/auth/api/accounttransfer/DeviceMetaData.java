package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="DeviceMetaDataCreator")
public class DeviceMetaData extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzv();

  @SafeParcelable.Field(getter="isLockScreenSolved", id=2)
  private boolean zzbs;

  @SafeParcelable.Field(getter="getMinAgeOfLockScreen", id=3)
  private long zzbt;

  @SafeParcelable.Field(getter="isChallengeAllowed", id=4)
  private final boolean zzbu;

  @SafeParcelable.VersionField(id=1)
  private final int zzv;

  @SafeParcelable.Constructor
  DeviceMetaData(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) boolean paramBoolean1, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=4) boolean paramBoolean2)
  {
    this.zzv = paramInt;
    this.zzbs = paramBoolean1;
    this.zzbt = paramLong;
    this.zzbu = paramBoolean2;
  }

  public long getMinAgeOfLockScreen()
  {
    return this.zzbt;
  }

  public boolean isChallengeAllowed()
  {
    return this.zzbu;
  }

  public boolean isLockScreenSolved()
  {
    return this.zzbs;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzv);
    SafeParcelWriter.writeBoolean(paramParcel, 2, isLockScreenSolved());
    SafeParcelWriter.writeLong(paramParcel, 3, getMinAgeOfLockScreen());
    SafeParcelWriter.writeBoolean(paramParcel, 4, isChallengeAllowed());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.DeviceMetaData
 * JD-Core Version:    0.6.2
 */