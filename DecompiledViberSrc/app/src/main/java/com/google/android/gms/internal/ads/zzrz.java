package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzrz
  implements zzrt
{
  private final int zzaph;
  private int zzapi;
  private final boolean zzbme;
  private final byte[] zzbmf;
  private final zzrs[] zzbmg;
  private int zzbmh;
  private int zzbmi;
  private zzrs[] zzbmj;

  public zzrz(boolean paramBoolean, int paramInt)
  {
    this(true, 65536, 0);
  }

  private zzrz(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    zzsk.checkArgument(true);
    zzsk.checkArgument(true);
    this.zzbme = true;
    this.zzaph = 65536;
    this.zzbmi = 0;
    this.zzbmj = new zzrs[100];
    this.zzbmf = null;
    this.zzbmg = new zzrs[1];
  }

  public final void reset()
  {
    try
    {
      if (this.zzbme)
        zzbl(0);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzrs paramzzrs)
  {
    try
    {
      this.zzbmg[0] = paramzzrs;
      zza(this.zzbmg);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzrs[] paramArrayOfzzrs)
  {
    while (true)
    {
      try
      {
        if (this.zzbmi + paramArrayOfzzrs.length >= this.zzbmj.length)
          this.zzbmj = ((zzrs[])Arrays.copyOf(this.zzbmj, Math.max(this.zzbmj.length << 1, this.zzbmi + paramArrayOfzzrs.length)));
        int i = paramArrayOfzzrs.length;
        int j = 0;
        if (j < i)
        {
          zzrs localzzrs = paramArrayOfzzrs[j];
          if (localzzrs.data == null)
            break label151;
          if (localzzrs.data.length != this.zzaph)
            break label157;
          break label151;
          zzsk.checkArgument(bool);
          zzrs[] arrayOfzzrs = this.zzbmj;
          int k = this.zzbmi;
          this.zzbmi = (k + 1);
          arrayOfzzrs[k] = localzzrs;
          j++;
          continue;
        }
        this.zzapi -= paramArrayOfzzrs.length;
        notifyAll();
        return;
      }
      finally
      {
      }
      label151: boolean bool = true;
      continue;
      label157: bool = false;
    }
  }

  public final void zzbl(int paramInt)
  {
    try
    {
      if (paramInt < this.zzbmh);
      for (int i = 1; ; i = 0)
      {
        this.zzbmh = paramInt;
        if (i != 0)
          zzn();
        return;
      }
    }
    finally
    {
    }
  }

  public final int zzfz()
  {
    return this.zzaph;
  }

  public final int zzga()
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

  public final zzrs zzjt()
  {
    try
    {
      this.zzapi = (1 + this.zzapi);
      zzrs localzzrs;
      if (this.zzbmi > 0)
      {
        zzrs[] arrayOfzzrs = this.zzbmj;
        int i = -1 + this.zzbmi;
        this.zzbmi = i;
        localzzrs = arrayOfzzrs[i];
        this.zzbmj[this.zzbmi] = null;
      }
      while (true)
      {
        return localzzrs;
        localzzrs = new zzrs(new byte[this.zzaph], 0);
      }
    }
    finally
    {
    }
  }

  public final void zzn()
  {
    try
    {
      int i = Math.max(0, zzsy.zzb(this.zzbmh, this.zzaph) - this.zzapi);
      int j = this.zzbmi;
      if (i >= j);
      while (true)
      {
        return;
        Arrays.fill(this.zzbmj, i, this.zzbmi, null);
        this.zzbmi = i;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrz
 * JD-Core Version:    0.6.2
 */