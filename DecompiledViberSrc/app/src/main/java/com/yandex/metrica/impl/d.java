package com.yandex.metrica.impl;

import java.util.concurrent.TimeUnit;

public abstract interface d
{
  public static class a<T>
  {
    public static final long a = TimeUnit.SECONDS.toMillis(10L);
    private long b;
    private long c = 0L;
    private T d = null;
    private boolean e = true;

    public a()
    {
      this(a);
    }

    public a(long paramLong)
    {
      this.b = paramLong;
    }

    public T a()
    {
      return this.d;
    }

    public void a(T paramT)
    {
      this.d = paramT;
      this.c = System.currentTimeMillis();
      this.e = false;
    }

    public final boolean a(long paramLong)
    {
      long l = System.currentTimeMillis() - this.c;
      return (l > paramLong) || (l < 0L);
    }

    public final boolean b()
    {
      return this.d == null;
    }

    public final boolean c()
    {
      return a(this.b);
    }

    public T d()
    {
      if (c())
        return null;
      return this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.d
 * JD-Core Version:    0.6.2
 */