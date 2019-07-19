package com.google.android.gms.internal.ads;

final class zzim
{
  private int[] zzahp = new int[this.zzajq];
  private long[] zzahq = new long[this.zzajq];
  private long[] zzahs = new long[this.zzajq];
  private int zzajq = 1000;
  private int[] zzajr = new int[this.zzajq];
  private byte[][] zzajs = new byte[this.zzajq][];
  private int zzajt;
  private int zzaju;
  private int zzajv;
  private int zzajw;

  public final void clear()
  {
    this.zzaju = 0;
    this.zzajv = 0;
    this.zzajw = 0;
    this.zzajt = 0;
  }

  public final void zza(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    try
    {
      this.zzahs[this.zzajw] = paramLong1;
      this.zzahq[this.zzajw] = paramLong2;
      this.zzahp[this.zzajw] = paramInt2;
      this.zzajr[this.zzajw] = paramInt1;
      this.zzajs[this.zzajw] = paramArrayOfByte;
      this.zzajt = (1 + this.zzajt);
      if (this.zzajt == this.zzajq)
      {
        int i = 1000 + this.zzajq;
        long[] arrayOfLong1 = new long[i];
        long[] arrayOfLong2 = new long[i];
        int[] arrayOfInt1 = new int[i];
        int[] arrayOfInt2 = new int[i];
        byte[][] arrayOfByte = new byte[i][];
        int j = this.zzajq - this.zzajv;
        System.arraycopy(this.zzahq, this.zzajv, arrayOfLong1, 0, j);
        System.arraycopy(this.zzahs, this.zzajv, arrayOfLong2, 0, j);
        System.arraycopy(this.zzajr, this.zzajv, arrayOfInt1, 0, j);
        System.arraycopy(this.zzahp, this.zzajv, arrayOfInt2, 0, j);
        System.arraycopy(this.zzajs, this.zzajv, arrayOfByte, 0, j);
        int k = this.zzajv;
        System.arraycopy(this.zzahq, 0, arrayOfLong1, j, k);
        System.arraycopy(this.zzahs, 0, arrayOfLong2, j, k);
        System.arraycopy(this.zzajr, 0, arrayOfInt1, j, k);
        System.arraycopy(this.zzahp, 0, arrayOfInt2, j, k);
        System.arraycopy(this.zzajs, 0, arrayOfByte, j, k);
        this.zzahq = arrayOfLong1;
        this.zzahs = arrayOfLong2;
        this.zzajr = arrayOfInt1;
        this.zzahp = arrayOfInt2;
        this.zzajs = arrayOfByte;
        this.zzajv = 0;
        this.zzajw = this.zzajq;
        this.zzajt = this.zzajq;
        this.zzajq = i;
      }
      while (true)
      {
        return;
        this.zzajw = (1 + this.zzajw);
        if (this.zzajw == this.zzajq)
          this.zzajw = 0;
      }
    }
    finally
    {
    }
  }

  public final boolean zza(zzhm paramzzhm, zzin paramzzin)
  {
    try
    {
      int i = this.zzajt;
      if (i == 0);
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        paramzzhm.zzaga = this.zzahs[this.zzajv];
        paramzzhm.size = this.zzahp[this.zzajv];
        paramzzhm.flags = this.zzajr[this.zzajv];
        paramzzin.zzajx = this.zzahq[this.zzajv];
        paramzzin.zzajy = this.zzajs[this.zzajv];
      }
    }
    finally
    {
    }
  }

  public final long zzdv(long paramLong)
  {
    long l1 = -1L;
    try
    {
      if (this.zzajt != 0)
      {
        long l2 = this.zzahs[this.zzajv];
        if (paramLong >= l2)
          break label35;
      }
      while (true)
      {
        return l1;
        label35: if (this.zzajw == 0);
        int n;
        for (int i = this.zzajq; ; i = this.zzajw)
        {
          int j = i - 1;
          if (paramLong > this.zzahs[j])
            break;
          int k = 0;
          int m = this.zzajv;
          n = -1;
          while ((m != this.zzajw) && (this.zzahs[m] <= paramLong))
          {
            if ((0x1 & this.zzajr[m]) != 0)
              n = k;
            m = (m + 1) % this.zzajq;
            k++;
          }
        }
        if (n != -1)
        {
          this.zzajt -= n;
          this.zzajv = ((n + this.zzajv) % this.zzajq);
          this.zzaju = (n + this.zzaju);
          l1 = this.zzahq[this.zzajv];
        }
      }
    }
    finally
    {
    }
  }

  public final long zzfv()
  {
    try
    {
      this.zzajt = (-1 + this.zzajt);
      int i = this.zzajv;
      this.zzajv = (i + 1);
      this.zzaju = (1 + this.zzaju);
      if (this.zzajv == this.zzajq)
        this.zzajv = 0;
      if (this.zzajt > 0);
      long l1;
      long l2;
      for (long l3 = this.zzahq[this.zzajv]; ; l3 = l2 + l1)
      {
        return l3;
        l1 = this.zzahp[i];
        l2 = this.zzahq[i];
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzim
 * JD-Core Version:    0.6.2
 */