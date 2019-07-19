package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class StatsEvent extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public abstract int getEventType();

  public abstract long getTimeMillis();

  public String toString()
  {
    long l1 = getTimeMillis();
    int i = getEventType();
    long l2 = zzu();
    String str = zzv();
    return 53 + String.valueOf(str).length() + l1 + "\t" + i + "\t" + l2 + str;
  }

  public abstract long zzu();

  public abstract String zzv();

  @KeepForSdk
  public static abstract interface Types
  {

    @KeepForSdk
    public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;

    @KeepForSdk
    public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.StatsEvent
 * JD-Core Version:    0.6.2
 */