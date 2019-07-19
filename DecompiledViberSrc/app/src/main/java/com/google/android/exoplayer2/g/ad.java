package com.google.android.exoplayer2.g;

public final class ad
{
  private long a;
  private long b;
  private volatile long c = -9223372036854775807L;

  public ad(long paramLong)
  {
    a(paramLong);
  }

  public static long d(long paramLong)
  {
    return 1000000L * paramLong / 90000L;
  }

  public static long e(long paramLong)
  {
    return 90000L * paramLong / 1000000L;
  }

  public long a()
  {
    return this.a;
  }

  public void a(long paramLong)
  {
    try
    {
      if (this.c == -9223372036854775807L);
      for (boolean bool = true; ; bool = false)
      {
        a.b(bool);
        this.a = paramLong;
        return;
      }
    }
    finally
    {
    }
  }

  public long b()
  {
    long l = -9223372036854775807L;
    if (this.c != l)
      l = this.c + this.b;
    while (this.a == 9223372036854775807L)
      return l;
    return this.a;
  }

  public long b(long paramLong)
  {
    if (paramLong == -9223372036854775807L)
      return -9223372036854775807L;
    long l1;
    long l4;
    if (this.c != -9223372036854775807L)
    {
      long l2 = e(this.c);
      long l3 = (4294967296L + l2) / 8589934592L;
      l1 = paramLong + 8589934592L * (l3 - 1L);
      l4 = paramLong + l3 * 8589934592L;
      if (Math.abs(l1 - l2) >= Math.abs(l4 - l2));
    }
    while (true)
    {
      return c(d(l1));
      l1 = l4;
      continue;
      l1 = paramLong;
    }
  }

  public long c()
  {
    long l = -9223372036854775807L;
    if (this.a == 9223372036854775807L)
      l = 0L;
    while (this.c == l)
      return l;
    return this.b;
  }

  public long c(long paramLong)
  {
    if (paramLong == -9223372036854775807L)
      return -9223372036854775807L;
    if (this.c != -9223372036854775807L)
      this.c = paramLong;
    while (true)
    {
      return paramLong + this.b;
      if (this.a != 9223372036854775807L)
        this.b = (this.a - paramLong);
      try
      {
        this.c = paramLong;
        notifyAll();
      }
      finally
      {
      }
    }
  }

  public void d()
  {
    this.c = -9223372036854775807L;
  }

  public void e()
    throws InterruptedException
  {
    try
    {
      if (this.c == -9223372036854775807L)
        wait();
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.ad
 * JD-Core Version:    0.6.2
 */