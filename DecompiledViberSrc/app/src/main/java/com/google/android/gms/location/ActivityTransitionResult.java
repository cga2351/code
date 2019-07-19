package com.google.android.gms.location;

import android.content.Intent;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="ActivityTransitionResultCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransitionResult extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new zzg();

  @SafeParcelable.Field(getter="getTransitionEvents", id=1)
  private final List<ActivityTransitionEvent> zzn;

  @SafeParcelable.Constructor
  public ActivityTransitionResult(@SafeParcelable.Param(id=1) List<ActivityTransitionEvent> paramList)
  {
    Preconditions.checkNotNull(paramList, "transitionEvents list can't be null.");
    if (!paramList.isEmpty())
    {
      int i = 1;
      if (i < paramList.size())
      {
        if (((ActivityTransitionEvent)paramList.get(i)).getElapsedRealTimeNanos() >= ((ActivityTransitionEvent)paramList.get(i - 1)).getElapsedRealTimeNanos());
        for (boolean bool = true; ; bool = false)
        {
          Preconditions.checkArgument(bool);
          i++;
          break;
        }
      }
    }
    this.zzn = Collections.unmodifiableList(paramList);
  }

  public static ActivityTransitionResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent))
      return null;
    return (ActivityTransitionResult)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT", CREATOR);
  }

  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null)
      return false;
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT");
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    return this.zzn.equals(((ActivityTransitionResult)paramObject).zzn);
  }

  public List<ActivityTransitionEvent> getTransitionEvents()
  {
    return this.zzn;
  }

  public int hashCode()
  {
    return this.zzn.hashCode();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getTransitionEvents(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityTransitionResult
 * JD-Core Version:    0.6.2
 */