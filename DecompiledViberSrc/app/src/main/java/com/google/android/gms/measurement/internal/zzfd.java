package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdl;

public final class zzfd extends zzf
{
  private Handler handler;

  @VisibleForTesting
  private long zzatb = zzbx().elapsedRealtime();

  @VisibleForTesting
  private long zzatc = this.zzatb;
  private final zzy zzatd = new zzfe(this, this.zzada);
  private final zzy zzate = new zzff(this, this.zzada);

  zzfd(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  private final void zzai(long paramLong)
  {
    zzaf();
    zzlm();
    if (zzgv().zze(zzgk().zzal(), zzai.zzaky))
      zzgu().zzant.set(false);
    zzgt().zzjo().zzg("Activity resumed, time", Long.valueOf(paramLong));
    this.zzatb = paramLong;
    this.zzatc = this.zzatb;
    if (zzgv().zzbi(zzgk().zzal()))
    {
      zzaj(zzbx().currentTimeMillis());
      return;
    }
    this.zzatd.cancel();
    this.zzate.cancel();
    if (zzgu().zzaf(zzbx().currentTimeMillis()))
    {
      zzgu().zzanp.set(true);
      zzgu().zzanr.set(0L);
    }
    if (zzgu().zzanp.get())
    {
      this.zzatd.zzh(Math.max(0L, zzgu().zzann.get() - zzgu().zzanr.get()));
      return;
    }
    this.zzate.zzh(Math.max(0L, 3600000L - zzgu().zzanr.get()));
  }

  private final void zzak(long paramLong)
  {
    zzaf();
    zzlm();
    if (zzgv().zze(zzgk().zzal(), zzai.zzaky))
      zzgu().zzant.set(true);
    this.zzatd.cancel();
    this.zzate.cancel();
    zzgt().zzjo().zzg("Activity paused, time", Long.valueOf(paramLong));
    if (this.zzatb != 0L)
      zzgu().zzanr.set(zzgu().zzanr.get() + (paramLong - this.zzatb));
  }

  private final void zzal(long paramLong)
  {
    zzaf();
    long l = zzbx().elapsedRealtime();
    zzgt().zzjo().zzg("Session started, time", Long.valueOf(l));
    if (zzgv().zzbg(zzgk().zzal()));
    for (Long localLong1 = Long.valueOf(paramLong / 1000L); ; localLong1 = null)
    {
      if (zzgv().zzbh(zzgk().zzal()));
      for (Long localLong2 = Long.valueOf(-1L); ; localLong2 = null)
      {
        zzgj().zza("auto", "_sid", localLong1, paramLong);
        zzgj().zza("auto", "_sno", localLong2, paramLong);
        zzgu().zzanp.set(false);
        Bundle localBundle = new Bundle();
        if (zzgv().zzbg(zzgk().zzal()))
          localBundle.putLong("_sid", localLong1.longValue());
        zzgj().zza("auto", "_s", paramLong, localBundle);
        zzgu().zzanq.set(paramLong);
        return;
      }
    }
  }

  private final void zzlm()
  {
    try
    {
      if (this.handler == null)
        this.handler = new zzdl(Looper.getMainLooper());
      return;
    }
    finally
    {
    }
  }

  private final void zzlq()
  {
    zzaf();
    zza(false, false);
    zzgi().zzm(zzbx().elapsedRealtime());
  }

  final void zza(long paramLong, boolean paramBoolean)
  {
    zzaf();
    zzlm();
    this.zzatd.cancel();
    this.zzate.cancel();
    if (zzgu().zzaf(paramLong))
    {
      zzgu().zzanp.set(true);
      zzgu().zzanr.set(0L);
    }
    if ((paramBoolean) && (zzgv().zzbj(zzgk().zzal())))
      zzgu().zzanq.set(paramLong);
    if (zzgu().zzanp.get())
    {
      zzal(paramLong);
      return;
    }
    this.zzate.zzh(Math.max(0L, 3600000L - zzgu().zzanr.get()));
  }

  public final boolean zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    zzaf();
    zzcl();
    long l1 = zzbx().elapsedRealtime();
    zzgu().zzanq.set(zzbx().currentTimeMillis());
    long l2 = l1 - this.zzatb;
    if ((!paramBoolean1) && (l2 < 1000L))
    {
      zzgt().zzjo().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(l2));
      return false;
    }
    zzgu().zzanr.set(l2);
    zzgt().zzjo().zzg("Recording user engagement, ms", Long.valueOf(l2));
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", l2);
    zzdy.zza(zzgm().zzle(), localBundle, true);
    if (zzgv().zzbk(zzgk().zzal()))
    {
      if (!zzgv().zze(zzgk().zzal(), zzai.zzalc))
        break label263;
      if (!paramBoolean2)
        zzlp();
    }
    while (true)
    {
      if ((!zzgv().zze(zzgk().zzal(), zzai.zzalc)) || (!paramBoolean2))
        zzgj().logEvent("auto", "_e", localBundle);
      this.zzatb = l1;
      this.zzate.cancel();
      this.zzate.zzh(Math.max(0L, 3600000L - zzgu().zzanr.get()));
      return true;
      label263: if (paramBoolean2)
        localBundle.putLong("_fr", 1L);
      else
        zzlp();
    }
  }

  final void zzaj(long paramLong)
  {
    zzaf();
    zzlm();
    zza(paramLong, false);
  }

  protected final boolean zzgy()
  {
    return false;
  }

  final void zzln()
  {
    zzaf();
    this.zzatd.cancel();
    this.zzate.cancel();
    this.zzatb = 0L;
    this.zzatc = this.zzatb;
  }

  @VisibleForTesting
  protected final void zzlo()
  {
    zzaf();
    zzal(zzbx().currentTimeMillis());
  }

  @VisibleForTesting
  final long zzlp()
  {
    long l1 = zzbx().elapsedRealtime();
    long l2 = l1 - this.zzatc;
    this.zzatc = l1;
    return l2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfd
 * JD-Core Version:    0.6.2
 */