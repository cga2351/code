package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator="ActivityTransitionCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransition extends AbstractSafeParcelable
{
  public static final int ACTIVITY_TRANSITION_ENTER = 0;
  public static final int ACTIVITY_TRANSITION_EXIT = 1;
  public static final Parcelable.Creator<ActivityTransition> CREATOR = new zzc();

  @SafeParcelable.Field(getter="getActivityType", id=1)
  private final int zzi;

  @SafeParcelable.Field(getter="getTransitionType", id=2)
  private final int zzj;

  @SafeParcelable.Constructor
  ActivityTransition(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2)
  {
    this.zzi = paramInt1;
    this.zzj = paramInt2;
  }

  public static void zza(int paramInt)
  {
    int i = 1;
    if ((paramInt >= 0) && (paramInt <= i));
    while (true)
    {
      Preconditions.checkArgument(i, 41 + "Transition type " + paramInt + " is not valid.");
      return;
      i = 0;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ActivityTransition localActivityTransition;
    do
    {
      return true;
      if (!(paramObject instanceof ActivityTransition))
        return false;
      localActivityTransition = (ActivityTransition)paramObject;
    }
    while ((this.zzi == localActivityTransition.zzi) && (this.zzj == localActivityTransition.zzj));
    return false;
  }

  public int getActivityType()
  {
    return this.zzi;
  }

  public int getTransitionType()
  {
    return this.zzj;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.zzi);
    arrayOfObject[1] = Integer.valueOf(this.zzj);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    int i = this.zzi;
    int j = this.zzj;
    return 75 + "ActivityTransition [mActivityType=" + i + ", mTransitionType=" + j + ']';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getActivityType());
    SafeParcelWriter.writeInt(paramParcel, 2, getTransitionType());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public static class Builder
  {
    private int zzi = -1;
    private int zzj = -1;

    public ActivityTransition build()
    {
      boolean bool1 = true;
      boolean bool2;
      if (this.zzi != -1)
      {
        bool2 = bool1;
        Preconditions.checkState(bool2, "Activity type not set.");
        if (this.zzj == -1)
          break label53;
      }
      while (true)
      {
        Preconditions.checkState(bool1, "Activity transition type not set.");
        return new ActivityTransition(this.zzi, this.zzj);
        bool2 = false;
        break;
        label53: bool1 = false;
      }
    }

    public Builder setActivityTransition(int paramInt)
    {
      ActivityTransition.zza(paramInt);
      this.zzj = paramInt;
      return this;
    }

    public Builder setActivityType(int paramInt)
    {
      DetectedActivity.zzb(paramInt);
      this.zzi = paramInt;
      return this;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface SupportedActivityTransition
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityTransition
 * JD-Core Version:    0.6.2
 */