package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="ActivityTransitionEventCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransitionEvent extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzd();

  @SafeParcelable.Field(getter="getActivityType", id=1)
  private final int zzi;

  @SafeParcelable.Field(getter="getTransitionType", id=2)
  private final int zzj;

  @SafeParcelable.Field(getter="getElapsedRealTimeNanos", id=3)
  private final long zzk;

  @SafeParcelable.Constructor
  public ActivityTransitionEvent(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) long paramLong)
  {
    DetectedActivity.zzb(paramInt1);
    ActivityTransition.zza(paramInt2);
    this.zzi = paramInt1;
    this.zzj = paramInt2;
    this.zzk = paramLong;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ActivityTransitionEvent localActivityTransitionEvent;
    do
    {
      return true;
      if (!(paramObject instanceof ActivityTransitionEvent))
        return false;
      localActivityTransitionEvent = (ActivityTransitionEvent)paramObject;
    }
    while ((this.zzi == localActivityTransitionEvent.zzi) && (this.zzj == localActivityTransitionEvent.zzj) && (this.zzk == localActivityTransitionEvent.zzk));
    return false;
  }

  public int getActivityType()
  {
    return this.zzi;
  }

  public long getElapsedRealTimeNanos()
  {
    return this.zzk;
  }

  public int getTransitionType()
  {
    return this.zzj;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.zzi);
    arrayOfObject[1] = Integer.valueOf(this.zzj);
    arrayOfObject[2] = Long.valueOf(this.zzk);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = this.zzi;
    localStringBuilder.append(24 + "ActivityType " + i);
    localStringBuilder.append(" ");
    int j = this.zzj;
    localStringBuilder.append(26 + "TransitionType " + j);
    localStringBuilder.append(" ");
    long l = this.zzk;
    localStringBuilder.append(41 + "ElapsedRealTimeNanos " + l);
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getActivityType());
    SafeParcelWriter.writeInt(paramParcel, 2, getTransitionType());
    SafeParcelWriter.writeLong(paramParcel, 3, getElapsedRealTimeNanos());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityTransitionEvent
 * JD-Core Version:    0.6.2
 */