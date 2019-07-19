package com.c.a.a.a;

import com.c.a.a.d.a;
import com.c.a.a.k;
import java.io.IOException;

public abstract class a extends com.c.a.a.d
{
  protected k b;
  protected int c;
  protected boolean d;
  protected com.c.a.a.c.d e;
  protected boolean f;

  protected a(int paramInt, k paramk)
  {
    this.c = paramInt;
    this.e = com.c.a.a.c.d.g();
    this.b = paramk;
    this.d = a(d.a.e);
  }

  public final boolean a(d.a parama)
  {
    return (this.c & parama.c()) != 0;
  }

  public com.c.a.a.d b()
  {
    if (a() != null)
      return this;
    return a(new com.c.a.a.e.c());
  }

  public void close()
    throws IOException
  {
    this.f = true;
  }

  protected abstract void d(String paramString)
    throws IOException, com.c.a.a.c;

  protected void e(String paramString)
    throws com.c.a.a.c
  {
    throw new com.c.a.a.c(paramString);
  }

  public final com.c.a.a.c.d h()
  {
    return this.e;
  }

  protected abstract void i();

  protected void j()
  {
    throw new RuntimeException("Internal error: should never end up through this code path");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.a.a
 * JD-Core Version:    0.6.2
 */