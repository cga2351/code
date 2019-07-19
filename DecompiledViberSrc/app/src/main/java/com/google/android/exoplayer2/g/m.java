package com.google.android.exoplayer2.g;

import java.util.Arrays;

public final class m
{
  private int a;
  private long[] b;

  public m()
  {
    this(32);
  }

  public m(int paramInt)
  {
    this.b = new long[paramInt];
  }

  public int a()
  {
    return this.a;
  }

  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a))
      throw new IndexOutOfBoundsException("Invalid index " + paramInt + ", size is " + this.a);
    return this.b[paramInt];
  }

  public void a(long paramLong)
  {
    if (this.a == this.b.length)
      this.b = Arrays.copyOf(this.b, 2 * this.a);
    long[] arrayOfLong = this.b;
    int i = this.a;
    this.a = (i + 1);
    arrayOfLong[i] = paramLong;
  }

  public long[] b()
  {
    return Arrays.copyOf(this.b, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.m
 * JD-Core Version:    0.6.2
 */