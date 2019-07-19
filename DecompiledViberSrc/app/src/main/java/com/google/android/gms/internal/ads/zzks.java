package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzks
  implements zzlo, zzlp
{
  private int index;
  private int state;
  private final int zzara;
  private zzlq zzarb;
  private zzqw zzarc;
  private long zzard;
  private boolean zzare;
  private boolean zzarf;

  public zzks(int paramInt)
  {
    this.zzara = paramInt;
    this.zzare = true;
  }

  public final void disable()
  {
    int i = 1;
    if (this.state == i);
    while (true)
    {
      zzsk.checkState(i);
      this.state = 0;
      this.zzarc = null;
      this.zzarf = false;
      zzdz();
      return;
      int j = 0;
    }
  }

  protected final int getIndex()
  {
    return this.index;
  }

  public final int getState()
  {
    return this.state;
  }

  public final int getTrackType()
  {
    return this.zzara;
  }

  protected void onStarted()
    throws zzku
  {
  }

  protected void onStopped()
    throws zzku
  {
  }

  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }

  public final void start()
    throws zzku
  {
    int i = 1;
    if (this.state == i);
    while (true)
    {
      zzsk.checkState(i);
      this.state = 2;
      onStarted();
      return;
      int j = 0;
    }
  }

  public final void stop()
    throws zzku
  {
    if (this.state == 2);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      this.state = 1;
      onStopped();
      return;
    }
  }

  protected final int zza(zzlj paramzzlj, zznd paramzznd, boolean paramBoolean)
  {
    int i = this.zzarc.zzb(paramzzlj, paramzznd, paramBoolean);
    if (i == -4)
    {
      if (paramzznd.zzic())
      {
        this.zzare = true;
        if (this.zzarf)
          return -4;
        return -3;
      }
      paramzznd.zzaga += this.zzard;
    }
    while (true)
    {
      return i;
      if (i == -5)
      {
        zzlh localzzlh = paramzzlj.zzaue;
        if (localzzlh.zzaua != 9223372036854775807L)
          paramzzlj.zzaue = localzzlh.zzed(localzzlh.zzaua + this.zzard);
      }
    }
  }

  public void zza(int paramInt, Object paramObject)
    throws zzku
  {
  }

  public final void zza(zzlq paramzzlq, zzlh[] paramArrayOfzzlh, zzqw paramzzqw, long paramLong1, boolean paramBoolean, long paramLong2)
    throws zzku
  {
    if (this.state == 0);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      this.zzarb = paramzzlq;
      this.state = 1;
      zzg(paramBoolean);
      zza(paramArrayOfzzlh, paramzzqw, paramLong2);
      zzd(paramLong1, paramBoolean);
      return;
    }
  }

  protected void zza(zzlh[] paramArrayOfzzlh, long paramLong)
    throws zzku
  {
  }

  public final void zza(zzlh[] paramArrayOfzzlh, zzqw paramzzqw, long paramLong)
    throws zzku
  {
    if (!this.zzarf);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      this.zzarc = paramzzqw;
      this.zzare = false;
      this.zzard = paramLong;
      zza(paramArrayOfzzlh, paramLong);
      return;
    }
  }

  protected void zzd(long paramLong, boolean paramBoolean)
    throws zzku
  {
  }

  public final void zzdx(long paramLong)
    throws zzku
  {
    this.zzarf = false;
    this.zzare = false;
    zzd(paramLong, false);
  }

  protected final void zzdy(long paramLong)
  {
    this.zzarc.zzeo(paramLong - this.zzard);
  }

  protected void zzdz()
  {
  }

  protected void zzg(boolean paramBoolean)
    throws zzku
  {
  }

  public final zzlp zzgi()
  {
    return this;
  }

  public zzso zzgj()
  {
    return null;
  }

  public final zzqw zzgk()
  {
    return this.zzarc;
  }

  public final boolean zzgl()
  {
    return this.zzare;
  }

  public final void zzgm()
  {
    this.zzarf = true;
  }

  public final boolean zzgn()
  {
    return this.zzarf;
  }

  public final void zzgo()
    throws IOException
  {
    this.zzarc.zzjb();
  }

  public int zzgp()
    throws zzku
  {
    return 0;
  }

  protected final zzlq zzgq()
  {
    return this.zzarb;
  }

  protected final boolean zzgr()
  {
    if (this.zzare)
      return this.zzarf;
    return this.zzarc.isReady();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzks
 * JD-Core Version:    0.6.2
 */