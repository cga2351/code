package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zza extends zze
{
  private final Map<String, Long> zzafb = new ArrayMap();
  private final Map<String, Integer> zzafc = new ArrayMap();
  private long zzafd;

  public zza(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  private final void zza(long paramLong, zzdx paramzzdx)
  {
    if (paramzzdx == null)
    {
      zzgt().zzjo().zzby("Not logging ad exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      zzgt().zzjo().zzg("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("_xt", paramLong);
    zzdy.zza(paramzzdx, localBundle, true);
    zzgj().logEvent("am", "_xa", localBundle);
  }

  private final void zza(String paramString, long paramLong)
  {
    zzgg();
    zzaf();
    Preconditions.checkNotEmpty(paramString);
    if (this.zzafc.isEmpty())
      this.zzafd = paramLong;
    Integer localInteger = (Integer)this.zzafc.get(paramString);
    if (localInteger != null)
    {
      this.zzafc.put(paramString, Integer.valueOf(1 + localInteger.intValue()));
      return;
    }
    if (this.zzafc.size() >= 100)
    {
      zzgt().zzjj().zzby("Too many ads visible");
      return;
    }
    this.zzafc.put(paramString, Integer.valueOf(1));
    this.zzafb.put(paramString, Long.valueOf(paramLong));
  }

  private final void zza(String paramString, long paramLong, zzdx paramzzdx)
  {
    if (paramzzdx == null)
    {
      zzgt().zzjo().zzby("Not logging ad unit exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      zzgt().zzjo().zzg("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_ai", paramString);
    localBundle.putLong("_xt", paramLong);
    zzdy.zza(paramzzdx, localBundle, true);
    zzgj().logEvent("am", "_xu", localBundle);
  }

  private final void zzb(String paramString, long paramLong)
  {
    zzgg();
    zzaf();
    Preconditions.checkNotEmpty(paramString);
    Integer localInteger = (Integer)this.zzafc.get(paramString);
    if (localInteger != null)
    {
      zzdx localzzdx = zzgm().zzle();
      int i = -1 + localInteger.intValue();
      if (i == 0)
      {
        this.zzafc.remove(paramString);
        Long localLong = (Long)this.zzafb.get(paramString);
        if (localLong == null)
          zzgt().zzjg().zzby("First ad unit exposure time was never set");
        while (true)
        {
          if (this.zzafc.isEmpty())
          {
            if (this.zzafd != 0L)
              break;
            zzgt().zzjg().zzby("First ad exposure time was never set");
          }
          return;
          long l = paramLong - localLong.longValue();
          this.zzafb.remove(paramString);
          zza(paramString, l, localzzdx);
        }
        zza(paramLong - this.zzafd, localzzdx);
        this.zzafd = 0L;
        return;
      }
      this.zzafc.put(paramString, Integer.valueOf(i));
      return;
    }
    zzgt().zzjg().zzg("Call to endAdUnitExposure for unknown ad unit id", paramString);
  }

  private final void zzn(long paramLong)
  {
    Iterator localIterator = this.zzafb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zzafb.put(str, Long.valueOf(paramLong));
    }
    if (!this.zzafb.isEmpty())
      this.zzafd = paramLong;
  }

  public final void beginAdUnitExposure(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      zzgt().zzjg().zzby("Ad unit id must be a non-empty string");
      return;
    }
    zzgs().zzc(new zzb(this, paramString, paramLong));
  }

  public final void endAdUnitExposure(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      zzgt().zzjg().zzby("Ad unit id must be a non-empty string");
      return;
    }
    zzgs().zzc(new zzc(this, paramString, paramLong));
  }

  public final void zzm(long paramLong)
  {
    zzdx localzzdx = zzgm().zzle();
    Iterator localIterator = this.zzafb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(str, paramLong - ((Long)this.zzafb.get(str)).longValue(), localzzdx);
    }
    if (!this.zzafb.isEmpty())
      zza(paramLong - this.zzafd, localzzdx);
    zzn(paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zza
 * JD-Core Version:    0.6.2
 */