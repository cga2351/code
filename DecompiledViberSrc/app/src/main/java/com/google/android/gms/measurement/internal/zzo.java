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

@SafeParcelable.Class(creator="ConditionalUserPropertyParcelCreator")
public final class zzo extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzo> CREATOR = new zzp();

  @SafeParcelable.Field(id=6)
  public boolean active;

  @SafeParcelable.Field(id=5)
  public long creationTimestamp;

  @SafeParcelable.Field(id=3)
  public String origin;

  @SafeParcelable.Field(id=2)
  public String packageName;

  @SafeParcelable.Field(id=11)
  public long timeToLive;

  @SafeParcelable.Field(id=7)
  public String triggerEventName;

  @SafeParcelable.Field(id=9)
  public long triggerTimeout;

  @SafeParcelable.Field(id=4)
  public zzfu zzags;

  @SafeParcelable.Field(id=8)
  public zzag zzagt;

  @SafeParcelable.Field(id=10)
  public zzag zzagu;

  @SafeParcelable.Field(id=12)
  public zzag zzagv;

  zzo(zzo paramzzo)
  {
    Preconditions.checkNotNull(paramzzo);
    this.packageName = paramzzo.packageName;
    this.origin = paramzzo.origin;
    this.zzags = paramzzo.zzags;
    this.creationTimestamp = paramzzo.creationTimestamp;
    this.active = paramzzo.active;
    this.triggerEventName = paramzzo.triggerEventName;
    this.zzagt = paramzzo.zzagt;
    this.triggerTimeout = paramzzo.triggerTimeout;
    this.zzagu = paramzzo.zzagu;
    this.timeToLive = paramzzo.timeToLive;
    this.zzagv = paramzzo.zzagv;
  }

  @SafeParcelable.Constructor
  zzo(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) zzfu paramzzfu, @SafeParcelable.Param(id=5) long paramLong1, @SafeParcelable.Param(id=6) boolean paramBoolean, @SafeParcelable.Param(id=7) String paramString3, @SafeParcelable.Param(id=8) zzag paramzzag1, @SafeParcelable.Param(id=9) long paramLong2, @SafeParcelable.Param(id=10) zzag paramzzag2, @SafeParcelable.Param(id=11) long paramLong3, @SafeParcelable.Param(id=12) zzag paramzzag3)
  {
    this.packageName = paramString1;
    this.origin = paramString2;
    this.zzags = paramzzfu;
    this.creationTimestamp = paramLong1;
    this.active = paramBoolean;
    this.triggerEventName = paramString3;
    this.zzagt = paramzzag1;
    this.triggerTimeout = paramLong2;
    this.zzagu = paramzzag2;
    this.timeToLive = paramLong3;
    this.zzagv = paramzzag3;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.origin, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzags, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.creationTimestamp);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.active);
    SafeParcelWriter.writeString(paramParcel, 7, this.triggerEventName, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzagt, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, this.triggerTimeout);
    SafeParcelWriter.writeParcelable(paramParcel, 10, this.zzagu, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 11, this.timeToLive);
    SafeParcelWriter.writeParcelable(paramParcel, 12, this.zzagv, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzo
 * JD-Core Version:    0.6.2
 */