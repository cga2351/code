package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

public final class zzalb extends zzbbx<zzajx>
{
  private final Object lock = new Object();
  private zzayq<zzajx> zzdce;
  private boolean zzdcy;
  private int zzdcz;

  public zzalb(zzayq<zzajx> paramzzayq)
  {
    this.zzdce = paramzzayq;
    this.zzdcy = false;
    this.zzdcz = 0;
  }

  private final void zzsa()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.zzdcz >= 0)
        {
          bool = true;
          Preconditions.checkState(bool);
          if ((this.zzdcy) && (this.zzdcz == 0))
          {
            zzaxa.zzds("No reference is left (including root). Cleaning up engine.");
            zza(new zzale(this), new zzbbv());
            return;
          }
          zzaxa.zzds("There are still references to the engine. Not destroying.");
        }
      }
      boolean bool = false;
    }
  }

  public final zzakx zzrx()
  {
    zzakx localzzakx = new zzakx(this);
    while (true)
    {
      synchronized (this.lock)
      {
        zza(new zzalc(this, localzzakx), new zzald(this, localzzakx));
        if (this.zzdcz >= 0)
        {
          bool = true;
          Preconditions.checkState(bool);
          this.zzdcz = (1 + this.zzdcz);
          return localzzakx;
        }
      }
      boolean bool = false;
    }
  }

  protected final void zzry()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.zzdcz > 0)
        {
          bool = true;
          Preconditions.checkState(bool);
          zzaxa.zzds("Releasing 1 reference for JS Engine");
          this.zzdcz = (-1 + this.zzdcz);
          zzsa();
          return;
        }
      }
      boolean bool = false;
    }
  }

  public final void zzrz()
  {
    for (boolean bool = true; ; bool = false)
      synchronized (this.lock)
      {
        if (this.zzdcz >= 0)
        {
          Preconditions.checkState(bool);
          zzaxa.zzds("Releasing root reference. JS Engine will be destroyed once other references are released.");
          this.zzdcy = true;
          zzsa();
          return;
        }
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzalb
 * JD-Core Version:    0.6.2
 */