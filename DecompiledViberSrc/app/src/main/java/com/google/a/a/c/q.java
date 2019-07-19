package com.google.a.a.c;

import java.io.IOException;

public final class q
{
  private final w a;
  private final r b;

  q(w paramw, r paramr)
  {
    this.a = paramw;
    this.b = paramr;
  }

  public p a(h paramh, i parami)
    throws IOException
  {
    return a("PUT", paramh, parami);
  }

  public p a(String paramString, h paramh, i parami)
    throws IOException
  {
    p localp = this.a.b();
    if (this.b != null)
      this.b.a(localp);
    localp.a(paramString);
    if (paramh != null)
      localp.a(paramh);
    if (parami != null)
      localp.a(parami);
    return localp;
  }

  public w a()
  {
    return this.a;
  }

  public r b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.q
 * JD-Core Version:    0.6.2
 */