package com.google.e;

import com.google.e.c.a;

public final class c
{
  private final b a;
  private com.google.e.c.b b;

  public c(b paramb)
  {
    if (paramb == null)
      throw new IllegalArgumentException("Binarizer must be non-null.");
    this.a = paramb;
  }

  public int a()
  {
    return this.a.c();
  }

  public a a(int paramInt, a parama)
    throws j
  {
    return this.a.a(paramInt, parama);
  }

  public int b()
  {
    return this.a.d();
  }

  public com.google.e.c.b c()
    throws j
  {
    if (this.b == null)
      this.b = this.a.b();
    return this.b;
  }

  public boolean d()
  {
    return this.a.a().d();
  }

  public c e()
  {
    h localh = this.a.a().e();
    return new c(this.a.a(localh));
  }

  public String toString()
  {
    try
    {
      String str = c().toString();
      return str;
    }
    catch (j localj)
    {
    }
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c
 * JD-Core Version:    0.6.2
 */