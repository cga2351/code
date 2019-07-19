package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzjr
  implements zzjl
{
  private final int zzaph;
  private int zzapi;
  private int zzapj;
  private zzjk[] zzapk;

  public zzjr(int paramInt)
  {
    zzkh.checkArgument(true);
    this.zzaph = 262144;
    this.zzapk = new zzjk[100];
  }

  private final int zzga()
  {
    try
    {
      int i = this.zzapi;
      int j = this.zzaph;
      int k = i * j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzjk paramzzjk)
  {
    try
    {
      if (paramzzjk.data.length == this.zzaph);
      for (boolean bool = true; ; bool = false)
      {
        zzkh.checkArgument(bool);
        this.zzapi = (-1 + this.zzapi);
        if (this.zzapj == this.zzapk.length)
          this.zzapk = ((zzjk[])Arrays.copyOf(this.zzapk, this.zzapk.length << 1));
        zzjk[] arrayOfzzjk = this.zzapk;
        int i = this.zzapj;
        this.zzapj = (i + 1);
        arrayOfzzjk[i] = paramzzjk;
        notifyAll();
        return;
      }
    }
    finally
    {
    }
  }

  public final void zzaa(int paramInt)
    throws InterruptedException
  {
    try
    {
      if (zzga() > paramInt)
        wait();
    }
    finally
    {
    }
  }

  public final zzjk zzfy()
  {
    try
    {
      this.zzapi = (1 + this.zzapi);
      zzjk[] arrayOfzzjk;
      int i;
      if (this.zzapj > 0)
      {
        arrayOfzzjk = this.zzapk;
        i = -1 + this.zzapj;
        this.zzapj = i;
      }
      for (zzjk localzzjk = arrayOfzzjk[i]; ; localzzjk = new zzjk(new byte[this.zzaph], 0))
        return localzzjk;
    }
    finally
    {
    }
  }

  public final int zzfz()
  {
    return this.zzaph;
  }

  public final void zzz(int paramInt)
  {
    try
    {
      int i = Math.max(0, zzkq.zzb(0, this.zzaph) - this.zzapi);
      if (i < this.zzapj)
      {
        Arrays.fill(this.zzapk, i, this.zzapj, null);
        this.zzapj = i;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjr
 * JD-Core Version:    0.6.2
 */