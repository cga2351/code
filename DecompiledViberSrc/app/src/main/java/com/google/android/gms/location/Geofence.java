package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.location.zzbh;

@VisibleForTesting
public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;

  public abstract String getRequestId();

  @VisibleForTesting
  public static final class Builder
  {
    private String zzad = null;
    private int zzae = 0;
    private long zzaf = -9223372036854775808L;
    private short zzag = -1;
    private double zzah;
    private double zzai;
    private float zzaj;
    private int zzak = 0;
    private int zzal = -1;

    public final Geofence build()
    {
      if (this.zzad == null)
        throw new IllegalArgumentException("Request ID not set.");
      if (this.zzae == 0)
        throw new IllegalArgumentException("Transitions types not set.");
      if (((0x4 & this.zzae) != 0) && (this.zzal < 0))
        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
      if (this.zzaf == -9223372036854775808L)
        throw new IllegalArgumentException("Expiration not set.");
      if (this.zzag == -1)
        throw new IllegalArgumentException("Geofence region not set.");
      if (this.zzak < 0)
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
      return new zzbh(this.zzad, this.zzae, (short)1, this.zzah, this.zzai, this.zzaj, this.zzaf, this.zzak, this.zzal);
    }

    public final Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.zzag = 1;
      this.zzah = paramDouble1;
      this.zzai = paramDouble2;
      this.zzaj = paramFloat;
      return this;
    }

    public final Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.zzaf = -1L;
        return this;
      }
      this.zzaf = (paramLong + SystemClock.elapsedRealtime());
      return this;
    }

    public final Builder setLoiteringDelay(int paramInt)
    {
      this.zzal = paramInt;
      return this;
    }

    public final Builder setNotificationResponsiveness(int paramInt)
    {
      this.zzak = paramInt;
      return this;
    }

    public final Builder setRequestId(String paramString)
    {
      this.zzad = paramString;
      return this;
    }

    public final Builder setTransitionTypes(int paramInt)
    {
      this.zzae = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.Geofence
 * JD-Core Version:    0.6.2
 */