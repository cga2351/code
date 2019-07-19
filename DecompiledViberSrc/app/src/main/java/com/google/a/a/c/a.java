package com.google.a.a.c;

import com.google.a.a.f.g;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class a
  implements i
{
  private o a;
  private long b = -1L;

  protected a(o paramo)
  {
    this.a = paramo;
  }

  protected a(String paramString)
  {
  }

  public static long a(i parami)
    throws IOException
  {
    if (!parami.f())
      return -1L;
    return com.google.a.a.f.o.a(parami);
  }

  public long a()
    throws IOException
  {
    if (this.b == -1L)
      this.b = e();
    return this.b;
  }

  public final o b()
  {
    return this.a;
  }

  protected final Charset c()
  {
    if ((this.a == null) || (this.a.d() == null))
      return g.a;
    return this.a.d();
  }

  public String d()
  {
    if (this.a == null)
      return null;
    return this.a.c();
  }

  protected long e()
    throws IOException
  {
    return a(this);
  }

  public boolean f()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.a
 * JD-Core Version:    0.6.2
 */