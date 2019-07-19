package com.google.android.exoplayer2.g;

import java.util.Arrays;

public final class ac<V>
{
  private long[] a;
  private V[] b;
  private int c;
  private int d;

  public ac()
  {
    this(10);
  }

  public ac(int paramInt)
  {
    this.a = new long[paramInt];
    this.b = a(paramInt);
  }

  private V a(long paramLong, boolean paramBoolean)
  {
    long l1 = 9223372036854775807L;
    Object localObject1 = null;
    while (true)
    {
      long l2;
      if (this.d > 0)
      {
        l2 = paramLong - this.a[this.c];
        if ((l2 >= 0L) || ((!paramBoolean) && (-l2 < l1)));
      }
      else
      {
        return localObject1;
      }
      Object localObject2 = this.b[this.c];
      this.b[this.c] = null;
      this.c = ((1 + this.c) % this.b.length);
      this.d = (-1 + this.d);
      localObject1 = localObject2;
      l1 = l2;
    }
  }

  private static <V> V[] a(int paramInt)
  {
    return (Object[])new Object[paramInt];
  }

  private void b()
  {
    int i = this.b.length;
    if (this.d < i)
      return;
    int j = i * 2;
    long[] arrayOfLong = new long[j];
    Object[] arrayOfObject = a(j);
    int k = i - this.c;
    System.arraycopy(this.a, this.c, arrayOfLong, 0, k);
    System.arraycopy(this.b, this.c, arrayOfObject, 0, k);
    if (this.c > 0)
    {
      System.arraycopy(this.a, 0, arrayOfLong, k, this.c);
      System.arraycopy(this.b, 0, arrayOfObject, k, this.c);
    }
    this.a = arrayOfLong;
    this.b = arrayOfObject;
    this.c = 0;
  }

  private void b(long paramLong, V paramV)
  {
    int i = (this.c + this.d) % this.b.length;
    this.a[i] = paramLong;
    this.b[i] = paramV;
    this.d = (1 + this.d);
  }

  private void c(long paramLong)
  {
    if (this.d > 0)
    {
      int i = (-1 + (this.c + this.d)) % this.b.length;
      if (paramLong <= this.a[i])
        a();
    }
  }

  public V a(long paramLong)
  {
    try
    {
      Object localObject2 = a(paramLong, true);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public void a()
  {
    try
    {
      this.c = 0;
      this.d = 0;
      Arrays.fill(this.b, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(long paramLong, V paramV)
  {
    try
    {
      c(paramLong);
      b();
      b(paramLong, paramV);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public V b(long paramLong)
  {
    try
    {
      Object localObject2 = a(paramLong, false);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.ac
 * JD-Core Version:    0.6.2
 */