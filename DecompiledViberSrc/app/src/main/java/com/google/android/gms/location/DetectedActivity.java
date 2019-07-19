package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Comparator;

@SafeParcelable.Class(creator="DetectedActivityCreator")
@SafeParcelable.Reserved({1000})
public class DetectedActivity extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzi();
  public static final int IN_VEHICLE = 0;
  public static final int ON_BICYCLE = 1;
  public static final int ON_FOOT = 2;
  public static final int RUNNING = 8;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  private static final Comparator<DetectedActivity> zzo = new zzh();
  private static final int[] zzp = { 9, 10 };
  private static final int[] zzq = { 0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19 };
  private static final int[] zzr = { 0, 1, 2, 3, 7, 8, 16, 17 };

  @SafeParcelable.Field(id=1)
  private int zzi;

  @SafeParcelable.Field(id=2)
  private int zzs;

  @SafeParcelable.Constructor
  public DetectedActivity(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2)
  {
    this.zzi = paramInt1;
    this.zzs = paramInt2;
  }

  public static void zzb(int paramInt)
  {
    int i = 0;
    int[] arrayOfInt = zzr;
    int j = arrayOfInt.length;
    for (int k = 0; k < j; k++)
      if (arrayOfInt[k] == paramInt)
        i = 1;
    if (i == 0)
      Log.w("DetectedActivity", 81 + paramInt + " is not a valid DetectedActivity supported by Activity Transition API.");
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    DetectedActivity localDetectedActivity;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localDetectedActivity = (DetectedActivity)paramObject;
    }
    while ((this.zzi == localDetectedActivity.zzi) && (this.zzs == localDetectedActivity.zzs));
    return false;
  }

  public int getConfidence()
  {
    return this.zzs;
  }

  public int getType()
  {
    int i = this.zzi;
    if ((i > 19) || (i < 0))
      i = 4;
    return i;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.zzi);
    arrayOfObject[1] = Integer.valueOf(this.zzs);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    int i = getType();
    String str;
    switch (i)
    {
    case 6:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    default:
      str = Integer.toString(i);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 7:
    case 8:
    case 16:
    case 17:
    case 18:
    case 19:
    }
    while (true)
    {
      int j = this.zzs;
      return 48 + String.valueOf(str).length() + "DetectedActivity [type=" + str + ", confidence=" + j + "]";
      str = "IN_VEHICLE";
      continue;
      str = "ON_BICYCLE";
      continue;
      str = "ON_FOOT";
      continue;
      str = "STILL";
      continue;
      str = "UNKNOWN";
      continue;
      str = "TILTING";
      continue;
      str = "WALKING";
      continue;
      str = "RUNNING";
      continue;
      str = "IN_ROAD_VEHICLE";
      continue;
      str = "IN_RAIL_VEHICLE";
      continue;
      str = "IN_TWO_WHEELER_VEHICLE";
      continue;
      str = "IN_FOUR_WHEELER_VEHICLE";
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzi);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzs);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.DetectedActivity
 * JD-Core Version:    0.6.2
 */