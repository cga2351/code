package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator="ActivityRecognitionResultCreator")
@SafeParcelable.Reserved({1000})
public class ActivityRecognitionResult extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzb();

  @SafeParcelable.Field(id=5)
  private Bundle extras;

  @SafeParcelable.Field(id=1)
  private List<DetectedActivity> zze;

  @SafeParcelable.Field(id=2)
  private long zzf;

  @SafeParcelable.Field(id=3)
  private long zzg;

  @SafeParcelable.Field(id=4)
  private int zzh;

  @VisibleForTesting
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(paramDetectedActivity, paramLong1, paramLong2, 0, null);
  }

  private ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, 0, null);
  }

  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this(paramList, paramLong1, paramLong2, 0, null);
  }

  @SafeParcelable.Constructor
  public ActivityRecognitionResult(@SafeParcelable.Param(id=1) List<DetectedActivity> paramList, @SafeParcelable.Param(id=2) long paramLong1, @SafeParcelable.Param(id=3) long paramLong2, @SafeParcelable.Param(id=4) int paramInt, @SafeParcelable.Param(id=5) Bundle paramBundle)
  {
    boolean bool2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "Must have at least 1 detected activity");
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
        break label86;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "Must set times");
      this.zze = paramList;
      this.zzf = paramLong1;
      this.zzg = paramLong2;
      this.zzh = paramInt;
      this.extras = paramBundle;
      return;
      bool2 = false;
      break;
      label86: bool1 = false;
    }
  }

  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    Object localObject;
    ActivityRecognitionResult localActivityRecognitionResult;
    if (hasResult(paramIntent))
    {
      localObject = paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
      if ((localObject instanceof byte[]))
        localActivityRecognitionResult = (ActivityRecognitionResult)SafeParcelableSerializer.deserializeFromBytes((byte[])localObject, CREATOR);
    }
    while (localActivityRecognitionResult != null)
    {
      return localActivityRecognitionResult;
      if ((localObject instanceof ActivityRecognitionResult))
        localActivityRecognitionResult = (ActivityRecognitionResult)localObject;
      else
        localActivityRecognitionResult = null;
    }
    List localList = zza(paramIntent);
    if ((localList == null) || (localList.isEmpty()))
      return null;
    return (ActivityRecognitionResult)localList.get(-1 + localList.size());
  }

  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null);
    List localList;
    do
    {
      return false;
      if (paramIntent == null);
      for (boolean bool = false; bool; bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT"))
        return true;
      localList = zza(paramIntent);
    }
    while ((localList == null) || (localList.isEmpty()));
    return true;
  }

  private static List<ActivityRecognitionResult> zza(Intent paramIntent)
  {
    if (paramIntent == null);
    for (boolean bool = false; !bool; bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST"))
      return null;
    return SafeParcelableSerializer.deserializeIterableFromIntentExtra(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
  }

  private static boolean zza(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null))
      return true;
    if (((paramBundle1 == null) && (paramBundle2 != null)) || ((paramBundle1 != null) && (paramBundle2 == null)))
      return false;
    if (paramBundle1.size() != paramBundle2.size())
      return false;
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle2.containsKey(str))
        return false;
      if (paramBundle1.get(str) == null)
      {
        if (paramBundle2.get(str) != null)
          return false;
      }
      else if ((paramBundle1.get(str) instanceof Bundle))
      {
        if (!zza(paramBundle1.getBundle(str), paramBundle2.getBundle(str)))
          return false;
      }
      else if (!paramBundle1.get(str).equals(paramBundle2.get(str)))
        return false;
    }
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ActivityRecognitionResult localActivityRecognitionResult;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localActivityRecognitionResult = (ActivityRecognitionResult)paramObject;
    }
    while ((this.zzf == localActivityRecognitionResult.zzf) && (this.zzg == localActivityRecognitionResult.zzg) && (this.zzh == localActivityRecognitionResult.zzh) && (Objects.equal(this.zze, localActivityRecognitionResult.zze)) && (zza(this.extras, localActivityRecognitionResult.extras)));
    return false;
  }

  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = this.zze.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt)
        return localDetectedActivity.getConfidence();
    }
    return 0;
  }

  public long getElapsedRealtimeMillis()
  {
    return this.zzg;
  }

  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)this.zze.get(0);
  }

  public List<DetectedActivity> getProbableActivities()
  {
    return this.zze;
  }

  public long getTime()
  {
    return this.zzf;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Long.valueOf(this.zzf);
    arrayOfObject[1] = Long.valueOf(this.zzg);
    arrayOfObject[2] = Integer.valueOf(this.zzh);
    arrayOfObject[3] = this.zze;
    arrayOfObject[4] = this.extras;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    String str = String.valueOf(this.zze);
    long l1 = this.zzf;
    long l2 = this.zzg;
    return 124 + String.valueOf(str).length() + "ActivityRecognitionResult [probableActivities=" + str + ", timeMillis=" + l1 + ", elapsedRealtimeMillis=" + l2 + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zze, false);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzf);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzg);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzh);
    SafeParcelWriter.writeBundle(paramParcel, 5, this.extras, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResult
 * JD-Core Version:    0.6.2
 */