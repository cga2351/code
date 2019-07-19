package com.c.a.a;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class g
  implements Closeable
{
  protected int a;

  protected f a(String paramString)
  {
    return new f(paramString, e());
  }

  public abstract j a()
    throws IOException, f;

  public boolean a(a parama)
  {
    return (this.a & parama.c()) != 0;
  }

  public abstract g b()
    throws IOException, f;

  public abstract j c();

  public abstract void close()
    throws IOException;

  public abstract String d()
    throws IOException, f;

  public abstract e e();

  public abstract String f()
    throws IOException, f;

  public byte g()
    throws IOException, f
  {
    int i = i();
    if ((i < -128) || (i > 255))
      throw a("Numeric value (" + f() + ") out of range of Java byte");
    return (byte)i;
  }

  public short h()
    throws IOException, f
  {
    int i = i();
    if ((i < -32768) || (i > 32767))
      throw a("Numeric value (" + f() + ") out of range of Java short");
    return (short)i;
  }

  public abstract int i()
    throws IOException, f;

  public abstract long j()
    throws IOException, f;

  public abstract BigInteger k()
    throws IOException, f;

  public abstract float l()
    throws IOException, f;

  public abstract double m()
    throws IOException, f;

  public abstract BigDecimal n()
    throws IOException, f;

  public static enum a
  {
    private final boolean i;

    static
    {
      a[] arrayOfa = new a[8];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
    }

    private a(boolean paramBoolean)
    {
      this.i = paramBoolean;
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
      return this.i;
    }

    public int c()
    {
      return 1 << ordinal();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.g
 * JD-Core Version:    0.6.2
 */