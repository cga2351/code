package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzfi
{
  private long startTime;
  private final Clock zzrz;

  public zzfi(Clock paramClock)
  {
    Preconditions.checkNotNull(paramClock);
    this.zzrz = paramClock;
  }

  public final void clear()
  {
    this.startTime = 0L;
  }

  public final void start()
  {
    this.startTime = this.zzrz.elapsedRealtime();
  }

  public final boolean zzj(long paramLong)
  {
    if (this.startTime == 0L);
    while (this.zzrz.elapsedRealtime() - this.startTime >= 3600000L)
      return true;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfi
 * JD-Core Version:    0.6.2
 */