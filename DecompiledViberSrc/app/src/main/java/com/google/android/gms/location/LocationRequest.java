package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;

@SafeParcelable.Class(creator="LocationRequestCreator")
@SafeParcelable.Reserved({1000})
public final class LocationRequest extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<LocationRequest> CREATOR = new zzab();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_PRIORITY", id=1)
  private int priority;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_EXPIRE_AT", id=5)
  private long zzaf;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_INTERVAL", id=2)
  private long zzaw;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_FASTEST_INTERVAL", id=3)
  private long zzax;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_EXPLICIT_FASTEST_INTERVAL", id=4)
  private boolean zzay;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_SMALLEST_DISPLACEMENT", id=7)
  private float zzaz;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_MAX_WAIT_TIME", id=8)
  private long zzba;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequest.DEFAULT_NUM_UPDATES", id=6)
  private int zzx;

  public LocationRequest()
  {
    this.priority = 102;
    this.zzaw = 3600000L;
    this.zzax = 600000L;
    this.zzay = false;
    this.zzaf = 9223372036854775807L;
    this.zzx = 2147483647;
    this.zzaz = 0.0F;
    this.zzba = 0L;
  }

  @SafeParcelable.Constructor
  LocationRequest(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) long paramLong1, @SafeParcelable.Param(id=3) long paramLong2, @SafeParcelable.Param(id=4) boolean paramBoolean, @SafeParcelable.Param(id=5) long paramLong3, @SafeParcelable.Param(id=6) int paramInt2, @SafeParcelable.Param(id=7) float paramFloat, @SafeParcelable.Param(id=8) long paramLong4)
  {
    this.priority = paramInt1;
    this.zzaw = paramLong1;
    this.zzax = paramLong2;
    this.zzay = paramBoolean;
    this.zzaf = paramLong3;
    this.zzx = paramInt2;
    this.zzaz = paramFloat;
    this.zzba = paramLong4;
  }

  @VisibleForTesting
  public static LocationRequest create()
  {
    return new LocationRequest();
  }

  private static void zza(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException(38 + "invalid interval: " + paramLong);
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationRequest localLocationRequest;
    do
    {
      return true;
      if (!(paramObject instanceof LocationRequest))
        return false;
      localLocationRequest = (LocationRequest)paramObject;
    }
    while ((this.priority == localLocationRequest.priority) && (this.zzaw == localLocationRequest.zzaw) && (this.zzax == localLocationRequest.zzax) && (this.zzay == localLocationRequest.zzay) && (this.zzaf == localLocationRequest.zzaf) && (this.zzx == localLocationRequest.zzx) && (this.zzaz == localLocationRequest.zzaz) && (getMaxWaitTime() == localLocationRequest.getMaxWaitTime()));
    return false;
  }

  public final long getExpirationTime()
  {
    return this.zzaf;
  }

  public final long getFastestInterval()
  {
    return this.zzax;
  }

  public final long getInterval()
  {
    return this.zzaw;
  }

  public final long getMaxWaitTime()
  {
    long l = this.zzba;
    if (l < this.zzaw)
      l = this.zzaw;
    return l;
  }

  public final int getNumUpdates()
  {
    return this.zzx;
  }

  public final int getPriority()
  {
    return this.priority;
  }

  public final float getSmallestDisplacement()
  {
    return this.zzaz;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.priority);
    arrayOfObject[1] = Long.valueOf(this.zzaw);
    arrayOfObject[2] = Float.valueOf(this.zzaz);
    arrayOfObject[3] = Long.valueOf(this.zzba);
    return Objects.hashCode(arrayOfObject);
  }

  public final boolean isFastestIntervalExplicitlySet()
  {
    return this.zzay;
  }

  public final LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong > 9223372036854775807L - l);
    for (this.zzaf = 9223372036854775807L; ; this.zzaf = (l + paramLong))
    {
      if (this.zzaf < 0L)
        this.zzaf = 0L;
      return this;
    }
  }

  @VisibleForTesting
  public final LocationRequest setExpirationTime(long paramLong)
  {
    this.zzaf = paramLong;
    if (this.zzaf < 0L)
      this.zzaf = 0L;
    return this;
  }

  public final LocationRequest setFastestInterval(long paramLong)
  {
    zza(paramLong);
    this.zzay = true;
    this.zzax = paramLong;
    return this;
  }

  public final LocationRequest setInterval(long paramLong)
  {
    zza(paramLong);
    this.zzaw = paramLong;
    if (!this.zzay)
      this.zzax = (()(this.zzaw / 6.0D));
    return this;
  }

  @VisibleForTesting
  public final LocationRequest setMaxWaitTime(long paramLong)
  {
    zza(paramLong);
    this.zzba = paramLong;
    return this;
  }

  @VisibleForTesting
  public final LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException(31 + "invalid numUpdates: " + paramInt);
    this.zzx = paramInt;
    return this;
  }

  @VisibleForTesting
  public final LocationRequest setPriority(int paramInt)
  {
    switch (paramInt)
    {
    case 101:
    case 103:
    default:
      throw new IllegalArgumentException(28 + "invalid quality: " + paramInt);
    case 100:
    case 102:
    case 104:
    case 105:
    }
    this.priority = paramInt;
    return this;
  }

  @VisibleForTesting
  public final LocationRequest setSmallestDisplacement(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException(37 + "invalid displacement: " + paramFloat);
    this.zzaz = paramFloat;
    return this;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Request[");
    String str;
    switch (this.priority)
    {
    case 101:
    case 103:
    default:
      str = "???";
    case 100:
    case 102:
    case 104:
    case 105:
    }
    while (true)
    {
      localStringBuilder2.append(str);
      if (this.priority != 105)
      {
        localStringBuilder1.append(" requested=");
        localStringBuilder1.append(this.zzaw).append("ms");
      }
      localStringBuilder1.append(" fastest=");
      localStringBuilder1.append(this.zzax).append("ms");
      if (this.zzba > this.zzaw)
      {
        localStringBuilder1.append(" maxWait=");
        localStringBuilder1.append(this.zzba).append("ms");
      }
      if (this.zzaz > 0.0F)
      {
        localStringBuilder1.append(" smallestDisplacement=");
        localStringBuilder1.append(this.zzaz).append("m");
      }
      if (this.zzaf != 9223372036854775807L)
      {
        long l = this.zzaf - SystemClock.elapsedRealtime();
        localStringBuilder1.append(" expireIn=");
        localStringBuilder1.append(l).append("ms");
      }
      if (this.zzx != 2147483647)
        localStringBuilder1.append(" num=").append(this.zzx);
      localStringBuilder1.append(']');
      return localStringBuilder1.toString();
      str = "PRIORITY_HIGH_ACCURACY";
      continue;
      str = "PRIORITY_BALANCED_POWER_ACCURACY";
      continue;
      str = "PRIORITY_LOW_POWER";
      continue;
      str = "PRIORITY_NO_POWER";
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.priority);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzaw);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzax);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzay);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzaf);
    SafeParcelWriter.writeInt(paramParcel, 6, this.zzx);
    SafeParcelWriter.writeFloat(paramParcel, 7, this.zzaz);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzba);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * JD-Core Version:    0.6.2
 */