package com.google.android.gms.internal.ads;

final class zzqr
{
  private int length;
  private int[] zzahp = new int[this.zzajq];
  private long[] zzahq = new long[this.zzajq];
  private long[] zzahs = new long[this.zzajq];
  private int zzajq = 1000;
  private int[] zzajr = new int[this.zzajq];
  private int[] zzbjs = new int[this.zzajq];
  private zznx[] zzbjt = new zznx[this.zzajq];
  private zzlh[] zzbju = new zzlh[this.zzajq];
  private int zzbjv;
  private int zzbjw;
  private int zzbjx;
  private long zzbjy = -9223372036854775808L;
  private long zzbjz = -9223372036854775808L;
  private boolean zzbka = true;
  private boolean zzbkb = true;
  private zzlh zzbkc;

  public final int zza(zzlj paramzzlj, zznd paramzznd, boolean paramBoolean1, boolean paramBoolean2, zzlh paramzzlh, zzqs paramzzqs)
  {
    int i = -4;
    label303: label310: label322: label326: 
    while (true)
    {
      int j;
      try
      {
        if (!zzjk())
        {
          if (paramBoolean2)
          {
            paramzznd.setFlags(4);
            return i;
          }
          if ((this.zzbkc == null) || ((!paramBoolean1) && (this.zzbkc == paramzzlh)))
            break label303;
          paramzzlj.zzaue = this.zzbkc;
          i = -5;
          continue;
        }
        if ((paramBoolean1) || (this.zzbju[this.zzbjw] != paramzzlh))
        {
          paramzzlj.zzaue = this.zzbju[this.zzbjw];
          i = -5;
          continue;
        }
        if (paramzznd.zzde != null)
          break label322;
        j = 1;
        break label310;
        paramzznd.zzaga = this.zzahs[this.zzbjw];
        paramzznd.setFlags(this.zzajr[this.zzbjw]);
        paramzzqs.size = this.zzahp[this.zzbjw];
        paramzzqs.zzajx = this.zzahq[this.zzbjw];
        paramzzqs.zzbbj = this.zzbjt[this.zzbjw];
        this.zzbjy = Math.max(this.zzbjy, paramzznd.zzaga);
        this.length = (-1 + this.length);
        this.zzbjw = (1 + this.zzbjw);
        this.zzbjv = (1 + this.zzbjv);
        if (this.zzbjw == this.zzajq)
          this.zzbjw = 0;
        if (this.length > 0)
        {
          l2 = this.zzahq[this.zzbjw];
          paramzzqs.zzbkd = l2;
          continue;
        }
      }
      finally
      {
      }
      long l1 = paramzzqs.zzajx;
      int k = paramzzqs.size;
      long l2 = l1 + k;
      continue;
      i = -3;
      continue;
      while (true)
      {
        if (j == 0)
          break label326;
        i = -3;
        break;
        j = 0;
      }
    }
  }

  public final void zza(long paramLong1, int paramInt1, long paramLong2, int paramInt2, zznx paramzznx)
  {
    while (true)
    {
      try
      {
        boolean bool1 = this.zzbka;
        if (bool1)
        {
          if ((paramInt1 & 0x1) == 0)
            return;
          this.zzbka = false;
        }
        if (!this.zzbkb)
        {
          bool2 = true;
          zzsk.checkState(bool2);
          zzep(paramLong1);
          this.zzahs[this.zzbjx] = paramLong1;
          this.zzahq[this.zzbjx] = paramLong2;
          this.zzahp[this.zzbjx] = paramInt2;
          this.zzajr[this.zzbjx] = paramInt1;
          this.zzbjt[this.zzbjx] = paramzznx;
          this.zzbju[this.zzbjx] = this.zzbkc;
          this.zzbjs[this.zzbjx] = 0;
          this.length = (1 + this.length);
          if (this.length != this.zzajq)
            break label510;
          int i = 1000 + this.zzajq;
          int[] arrayOfInt1 = new int[i];
          long[] arrayOfLong1 = new long[i];
          long[] arrayOfLong2 = new long[i];
          int[] arrayOfInt2 = new int[i];
          int[] arrayOfInt3 = new int[i];
          zznx[] arrayOfzznx = new zznx[i];
          zzlh[] arrayOfzzlh = new zzlh[i];
          int j = this.zzajq - this.zzbjw;
          System.arraycopy(this.zzahq, this.zzbjw, arrayOfLong1, 0, j);
          System.arraycopy(this.zzahs, this.zzbjw, arrayOfLong2, 0, j);
          System.arraycopy(this.zzajr, this.zzbjw, arrayOfInt2, 0, j);
          System.arraycopy(this.zzahp, this.zzbjw, arrayOfInt3, 0, j);
          System.arraycopy(this.zzbjt, this.zzbjw, arrayOfzznx, 0, j);
          System.arraycopy(this.zzbju, this.zzbjw, arrayOfzzlh, 0, j);
          System.arraycopy(this.zzbjs, this.zzbjw, arrayOfInt1, 0, j);
          int k = this.zzbjw;
          System.arraycopy(this.zzahq, 0, arrayOfLong1, j, k);
          System.arraycopy(this.zzahs, 0, arrayOfLong2, j, k);
          System.arraycopy(this.zzajr, 0, arrayOfInt2, j, k);
          System.arraycopy(this.zzahp, 0, arrayOfInt3, j, k);
          System.arraycopy(this.zzbjt, 0, arrayOfzznx, j, k);
          System.arraycopy(this.zzbju, 0, arrayOfzzlh, j, k);
          System.arraycopy(this.zzbjs, 0, arrayOfInt1, j, k);
          this.zzahq = arrayOfLong1;
          this.zzahs = arrayOfLong2;
          this.zzajr = arrayOfInt2;
          this.zzahp = arrayOfInt3;
          this.zzbjt = arrayOfzznx;
          this.zzbju = arrayOfzzlh;
          this.zzbjs = arrayOfInt1;
          this.zzbjw = 0;
          this.zzbjx = this.zzajq;
          this.length = this.zzajq;
          this.zzajq = i;
          continue;
        }
      }
      finally
      {
      }
      boolean bool2 = false;
      continue;
      label510: this.zzbjx = (1 + this.zzbjx);
      if (this.zzbjx == this.zzajq)
        this.zzbjx = 0;
    }
  }

  public final void zzep(long paramLong)
  {
    try
    {
      this.zzbjz = Math.max(this.zzbjz, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final long zzg(long paramLong, boolean paramBoolean)
  {
    long l1 = -1L;
    try
    {
      if (zzjk())
      {
        long l2 = this.zzahs[this.zzbjw];
        if (paramLong >= l2)
          break label37;
      }
      while (true)
      {
        return l1;
        label37: if ((paramLong <= this.zzbjz) || (paramBoolean))
        {
          int i = 0;
          int j = this.zzbjw;
          int k = -1;
          while ((j != this.zzbjx) && (this.zzahs[j] <= paramLong))
          {
            if ((0x1 & this.zzajr[j]) != 0)
              k = i;
            j = (j + 1) % this.zzajq;
            i++;
          }
          if (k != -1)
          {
            this.zzbjw = ((k + this.zzbjw) % this.zzajq);
            this.zzbjv = (k + this.zzbjv);
            this.length -= k;
            l1 = this.zzahq[this.zzbjw];
          }
        }
      }
    }
    finally
    {
    }
  }

  public final boolean zzg(zzlh paramzzlh)
  {
    boolean bool1 = false;
    if (paramzzlh == null);
    try
    {
      this.zzbkb = true;
      while (true)
      {
        return bool1;
        this.zzbkb = false;
        boolean bool2 = zzsy.zza(paramzzlh, this.zzbkc);
        bool1 = false;
        if (!bool2)
        {
          this.zzbkc = paramzzlh;
          bool1 = true;
        }
      }
    }
    finally
    {
    }
  }

  public final long zzje()
  {
    try
    {
      long l = Math.max(this.zzbjy, this.zzbjz);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzjh()
  {
    this.zzbjv = 0;
    this.zzbjw = 0;
    this.zzbjx = 0;
    this.length = 0;
    this.zzbka = true;
  }

  public final void zzji()
  {
    this.zzbjy = -9223372036854775808L;
    this.zzbjz = -9223372036854775808L;
  }

  public final int zzjj()
  {
    return this.zzbjv + this.length;
  }

  public final boolean zzjk()
  {
    try
    {
      int i = this.length;
      if (i != 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final zzlh zzjl()
  {
    try
    {
      boolean bool = this.zzbkb;
      if (bool);
      for (zzlh localzzlh = null; ; localzzlh = this.zzbkc)
        return localzzlh;
    }
    finally
    {
    }
  }

  public final long zzjm()
  {
    try
    {
      boolean bool = zzjk();
      if (!bool);
      long l1;
      int j;
      for (long l2 = -1L; ; l2 = l1 + j)
      {
        return l2;
        int i = (-1 + (this.zzbjw + this.length)) % this.zzajq;
        this.zzbjw = ((this.zzbjw + this.length) % this.zzajq);
        this.zzbjv += this.length;
        this.length = 0;
        l1 = this.zzahq[i];
        j = this.zzahp[i];
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqr
 * JD-Core Version:    0.6.2
 */