package com.c.a.a.e;

import com.c.a.a.b.k;
import com.c.a.a.d;
import com.c.a.a.l;
import com.c.a.a.m;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class c
  implements l, Serializable
{
  public static final k a = new k(" ");
  protected b b = a.a;
  protected b c = c.a;
  protected final m d;
  protected boolean e = true;
  protected transient int f = 0;

  public c()
  {
    this(a);
  }

  public c(m paramm)
  {
    this.d = paramm;
  }

  public void a(d paramd)
    throws IOException, com.c.a.a.c
  {
    if (this.d != null)
      paramd.b(this.d);
  }

  public void a(d paramd, int paramInt)
    throws IOException, com.c.a.a.c
  {
    if (!this.c.a())
      this.f = (-1 + this.f);
    if (paramInt > 0)
      this.c.a(paramd, this.f);
    while (true)
    {
      paramd.a('}');
      return;
      paramd.a(' ');
    }
  }

  public void b(d paramd)
    throws IOException, com.c.a.a.c
  {
    paramd.a('{');
    if (!this.c.a())
      this.f = (1 + this.f);
  }

  public void b(d paramd, int paramInt)
    throws IOException, com.c.a.a.c
  {
    if (!this.b.a())
      this.f = (-1 + this.f);
    if (paramInt > 0)
      this.b.a(paramd, this.f);
    while (true)
    {
      paramd.a(']');
      return;
      paramd.a(' ');
    }
  }

  public void c(d paramd)
    throws IOException, com.c.a.a.c
  {
    paramd.a(',');
    this.c.a(paramd, this.f);
  }

  public void d(d paramd)
    throws IOException, com.c.a.a.c
  {
    if (this.e)
    {
      paramd.c(" : ");
      return;
    }
    paramd.a(':');
  }

  public void e(d paramd)
    throws IOException, com.c.a.a.c
  {
    if (!this.b.a())
      this.f = (1 + this.f);
    paramd.a('[');
  }

  public void f(d paramd)
    throws IOException, com.c.a.a.c
  {
    paramd.a(',');
    this.b.a(paramd, this.f);
  }

  public void g(d paramd)
    throws IOException, com.c.a.a.c
  {
    this.b.a(paramd, this.f);
  }

  public void h(d paramd)
    throws IOException, com.c.a.a.c
  {
    this.c.a(paramd, this.f);
  }

  public static class a
    implements c.b, Serializable
  {
    public static a a = new a();

    public void a(d paramd, int paramInt)
      throws IOException, com.c.a.a.c
    {
      paramd.a(' ');
    }

    public boolean a()
    {
      return true;
    }
  }

  public static abstract interface b
  {
    public abstract void a(d paramd, int paramInt)
      throws IOException, com.c.a.a.c;

    public abstract boolean a();
  }

  public static class c
    implements c.b, Serializable
  {
    public static c a = new c();
    static final String b;
    static final char[] c;

    static
    {
      try
      {
        String str2 = System.getProperty("line.separator");
        str1 = str2;
        if (str1 == null)
          str1 = "\n";
        b = str1;
        c = new char[64];
        Arrays.fill(c, ' ');
        return;
      }
      catch (Throwable localThrowable)
      {
        while (true)
          String str1 = null;
      }
    }

    public void a(d paramd, int paramInt)
      throws IOException, com.c.a.a.c
    {
      paramd.c(b);
      if (paramInt > 0)
      {
        int i = paramInt + paramInt;
        while (i > 64)
        {
          paramd.a(c, 0, 64);
          i -= c.length;
        }
        paramd.a(c, 0, i);
      }
    }

    public boolean a()
    {
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.e.c
 * JD-Core Version:    0.6.2
 */