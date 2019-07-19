package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
public final class zztl
{
  private final zztm zzbpd;
  private final boolean zzbpe;
  private final long zzbpf;
  private final long zzbpg;
  private long zzbph;
  private long zzbpi;
  private long zzbpj;
  private boolean zzbpk;
  private long zzbpl;
  private long zzbpm;
  private long zzbpn;

  public zztl()
  {
    this(-1.0D);
  }

  private zztl(double paramDouble)
  {
    if (paramDouble != -1.0D);
    for (boolean bool = true; ; bool = false)
    {
      this.zzbpe = bool;
      if (!this.zzbpe)
        break;
      this.zzbpd = zztm.zzkn();
      this.zzbpf = (()(1000000000.0D / paramDouble));
      this.zzbpg = (80L * this.zzbpf / 100L);
      return;
    }
    this.zzbpd = null;
    this.zzbpf = -1L;
    this.zzbpg = -1L;
  }

  public zztl(Context paramContext)
  {
  }

  private final boolean zzh(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - this.zzbpm;
    return Math.abs(paramLong2 - this.zzbpl - l) > 20000000L;
  }

  public final void disable()
  {
    if (this.zzbpe)
      this.zzbpd.zzkp();
  }

  public final void enable()
  {
    this.zzbpk = false;
    if (this.zzbpe)
      this.zzbpd.zzko();
  }

  public final long zzg(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1 * 1000L;
    long l3;
    long l2;
    if (this.zzbpk)
    {
      if (paramLong1 != this.zzbph)
      {
        this.zzbpn = (1L + this.zzbpn);
        this.zzbpi = this.zzbpj;
      }
      if (this.zzbpn >= 6L)
      {
        l3 = (l1 - this.zzbpm) / this.zzbpn + this.zzbpi;
        if (zzh(l3, paramLong2))
        {
          this.zzbpk = false;
          l2 = paramLong2;
          l3 = l1;
        }
      }
    }
    while (true)
    {
      if (!this.zzbpk)
      {
        this.zzbpm = l1;
        this.zzbpl = paramLong2;
        this.zzbpn = 0L;
        this.zzbpk = true;
      }
      this.zzbph = paramLong1;
      this.zzbpj = l3;
      if ((this.zzbpd != null) && (this.zzbpd.zzbpo != 0L))
        break;
      return l2;
      l2 = l3 + this.zzbpl - this.zzbpm;
      continue;
      if (zzh(l1, paramLong2))
        this.zzbpk = false;
      l2 = paramLong2;
      l3 = l1;
    }
    long l4 = this.zzbpd.zzbpo;
    long l5 = this.zzbpf;
    long l6 = l4 + l5 * ((l2 - l4) / l5);
    long l8;
    if (l2 <= l6)
    {
      l8 = l6 - l5;
      if (l6 - l2 >= l2 - l8)
        break label286;
    }
    label286: for (long l9 = l6; ; l9 = l8)
    {
      return l9 - this.zzbpg;
      long l7 = l5 + l6;
      l8 = l6;
      l6 = l7;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztl
 * JD-Core Version:    0.6.2
 */