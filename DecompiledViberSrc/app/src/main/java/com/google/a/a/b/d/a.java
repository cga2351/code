package com.google.a.a.b.d;

import com.google.a.a.c.q;
import com.google.a.a.c.r;
import com.google.a.a.c.w;
import com.google.a.a.f.ae;
import com.google.a.a.f.x;
import com.google.a.a.f.z;
import java.io.IOException;
import java.util.logging.Logger;

public abstract class a
{
  static final Logger a = Logger.getLogger(a.class.getName());
  private final q b;
  private final c c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final x h;
  private final boolean i;
  private final boolean j;

  protected a(a parama)
  {
    this.c = parama.b;
    this.d = a(parama.e);
    this.e = b(parama.f);
    this.f = parama.g;
    if (ae.a(parama.h))
      a.warning("Application name is not set. Call Builder#setApplicationName.");
    this.g = parama.h;
    if (parama.c == null);
    for (q localq = parama.a.a(); ; localq = parama.a.a(parama.c))
    {
      this.b = localq;
      this.h = parama.d;
      this.i = parama.i;
      this.j = parama.j;
      return;
    }
  }

  static String a(String paramString)
  {
    z.a(paramString, "root URL cannot be null.");
    if (!paramString.endsWith("/"))
      paramString = String.valueOf(paramString).concat("/");
    return paramString;
  }

  static String b(String paramString)
  {
    z.a(paramString, "service path cannot be null");
    if (paramString.length() == 1)
    {
      z.a("/".equals(paramString), "service path must equal \"/\" if it is of length 1.");
      paramString = "";
    }
    do
    {
      do
        return paramString;
      while (paramString.length() <= 0);
      if (!paramString.endsWith("/"))
        paramString = String.valueOf(paramString).concat("/");
    }
    while (!paramString.startsWith("/"));
    return paramString.substring(1);
  }

  public final String a()
  {
    return this.d;
  }

  protected void a(b<?> paramb)
    throws IOException
  {
    if (f() != null)
      f().a(paramb);
  }

  public final String b()
  {
    return this.e;
  }

  public final String c()
  {
    String str1 = String.valueOf(this.d);
    String str2 = String.valueOf(this.e);
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }

  public final String d()
  {
    return this.g;
  }

  public final q e()
  {
    return this.b;
  }

  public final c f()
  {
    return this.c;
  }

  public x g()
  {
    return this.h;
  }

  public static abstract class a
  {
    final w a;
    c b;
    r c;
    final x d;
    String e;
    String f;
    String g;
    String h;
    boolean i;
    boolean j;

    protected a(w paramw, String paramString1, String paramString2, x paramx, r paramr)
    {
      this.a = ((w)z.a(paramw));
      this.d = paramx;
      a(paramString1);
      b(paramString2);
      this.c = paramr;
    }

    public a a(String paramString)
    {
      this.e = a.a(paramString);
      return this;
    }

    public a b(String paramString)
    {
      this.f = a.b(paramString);
      return this;
    }

    public a c(String paramString)
    {
      this.g = paramString;
      return this;
    }

    public a d(String paramString)
    {
      this.h = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.d.a
 * JD-Core Version:    0.6.2
 */