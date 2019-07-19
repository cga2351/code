package com.google.android.gms.internal.ads;

public final class zzakx extends zzbbx<zzalg>
{
  private final Object lock = new Object();
  private final zzalb zzdcv;
  private boolean zzdcw;

  public zzakx(zzalb paramzzalb)
  {
    this.zzdcv = paramzzalb;
  }

  public final void release()
  {
    synchronized (this.lock)
    {
      if (this.zzdcw)
        return;
      this.zzdcw = true;
      zza(new zzaky(this), new zzbbv());
      zza(new zzakz(this), new zzala(this));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzakx
 * JD-Core Version:    0.6.2
 */