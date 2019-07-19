package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzkk
{
  private int size;
  private long[] zzaqw = new long[32];

  public zzkk()
  {
    this(32);
  }

  private zzkk(int paramInt)
  {
  }

  public final void add(long paramLong)
  {
    if (this.size == this.zzaqw.length)
      this.zzaqw = Arrays.copyOf(this.zzaqw, this.size << 1);
    long[] arrayOfLong = this.zzaqw;
    int i = this.size;
    this.size = (i + 1);
    arrayOfLong[i] = paramLong;
  }

  public final long get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size))
    {
      int i = this.size;
      throw new IndexOutOfBoundsException(45 + "Invalid size " + paramInt + ", size is " + i);
    }
    return this.zzaqw[paramInt];
  }

  public final int size()
  {
    return this.size;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzkk
 * JD-Core Version:    0.6.2
 */