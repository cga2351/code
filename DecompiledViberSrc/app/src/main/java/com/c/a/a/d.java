package com.c.a.a;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class d
  implements Closeable, Flushable
{
  protected l a;

  public d a(int paramInt)
  {
    return this;
  }

  public d a(com.c.a.a.b.c paramc)
  {
    return this;
  }

  public d a(l paraml)
  {
    this.a = paraml;
    return this;
  }

  public d a(m paramm)
  {
    throw new UnsupportedOperationException();
  }

  public l a()
  {
    return this.a;
  }

  public abstract void a(char paramChar)
    throws IOException, c;

  public abstract void a(double paramDouble)
    throws IOException, c;

  public abstract void a(float paramFloat)
    throws IOException, c;

  public abstract void a(long paramLong)
    throws IOException, c;

  public abstract void a(String paramString)
    throws IOException, c;

  public abstract void a(BigDecimal paramBigDecimal)
    throws IOException, c;

  public abstract void a(BigInteger paramBigInteger)
    throws IOException, c;

  public abstract void a(boolean paramBoolean)
    throws IOException, c;

  public abstract void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, c;

  public abstract d b();

  public abstract void b(int paramInt)
    throws IOException, c;

  public void b(m paramm)
    throws IOException, c
  {
    c(paramm.a());
  }

  public abstract void b(String paramString)
    throws IOException, c;

  public abstract void c()
    throws IOException, c;

  public abstract void c(String paramString)
    throws IOException, c;

  public abstract void d()
    throws IOException, c;

  public abstract void e()
    throws IOException, c;

  public abstract void f()
    throws IOException, c;

  public abstract void flush()
    throws IOException;

  public abstract void g()
    throws IOException, c;

  public static enum a
  {
    private final boolean h;
    private final int i = 1 << ordinal();

    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
    }

    private a(boolean paramBoolean)
    {
      this.h = paramBoolean;
    }

    public static int a()
    {
      int k = 0;
      for (a locala : values())
        if (locala.b())
          k |= locala.c();
      return k;
    }

    public boolean b()
    {
      return this.h;
    }

    public int c()
    {
      return this.i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.d
 * JD-Core Version:    0.6.2
 */