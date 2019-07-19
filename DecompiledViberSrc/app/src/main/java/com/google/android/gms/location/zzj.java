package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="DeviceOrientationRequestCreator")
public final class zzj extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzj> CREATOR = new zzk();

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequest.DEFAULT_SHOULD_USE_MAG", id=1)
  private boolean zzt;

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequest.DEFAULT_MINIMUM_SAMPLING_PERIOD_MS", id=2)
  private long zzu;

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequest.DEFAULT_SMALLEST_ANGLE_CHANGE_RADIANS", id=3)
  private float zzv;

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequest.DEFAULT_EXPIRE_AT_MS", id=4)
  private long zzw;

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequest.DEFAULT_NUM_UPDATES", id=5)
  private int zzx;

  public zzj()
  {
    this(true, 50L, 0.0F, 9223372036854775807L, 2147483647);
  }

  @SafeParcelable.Constructor
  zzj(@SafeParcelable.Param(id=1) boolean paramBoolean, @SafeParcelable.Param(id=2) long paramLong1, @SafeParcelable.Param(id=3) float paramFloat, @SafeParcelable.Param(id=4) long paramLong2, @SafeParcelable.Param(id=5) int paramInt)
  {
    this.zzt = paramBoolean;
    this.zzu = paramLong1;
    this.zzv = paramFloat;
    this.zzw = paramLong2;
    this.zzx = paramInt;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzj localzzj;
    do
    {
      return true;
      if (!(paramObject instanceof zzj))
        return false;
      localzzj = (zzj)paramObject;
    }
    while ((this.zzt == localzzj.zzt) && (this.zzu == localzzj.zzu) && (Float.compare(this.zzv, localzzj.zzv) == 0) && (this.zzw == localzzj.zzw) && (this.zzx == localzzj.zzx));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Boolean.valueOf(this.zzt);
    arrayOfObject[1] = Long.valueOf(this.zzu);
    arrayOfObject[2] = Float.valueOf(this.zzv);
    arrayOfObject[3] = Long.valueOf(this.zzw);
    arrayOfObject[4] = Integer.valueOf(this.zzx);
    return Objects.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceOrientationRequest[mShouldUseMag=").append(this.zzt);
    localStringBuilder.append(" mMinimumSamplingPeriodMs=").append(this.zzu);
    localStringBuilder.append(" mSmallestAngleChangeRadians=").append(this.zzv);
    if (this.zzw != 9223372036854775807L)
    {
      long l = this.zzw - SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l).append("ms");
    }
    if (this.zzx != 2147483647)
      localStringBuilder.append(" num=").append(this.zzx);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, this.zzt);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzu);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.zzv);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzw);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzx);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzj
 * JD-Core Version:    0.6.2
 */