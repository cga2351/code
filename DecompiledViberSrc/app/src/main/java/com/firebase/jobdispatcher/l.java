package com.firebase.jobdispatcher;

import android.os.Bundle;

public final class l
  implements p
{
  private final String a;
  private final String b;
  private final r c;
  private final u d;
  private final int e;
  private final boolean f;
  private final int[] g;
  private final boolean h;
  private final Bundle i;

  private l(a parama)
  {
    this.a = a.a(parama);
    this.i = a.b(parama);
    this.b = a.c(parama);
    this.c = a.d(parama);
    this.d = a.e(parama);
    this.e = a.f(parama);
    this.f = a.g(parama);
    if (a.h(parama) != null);
    for (int[] arrayOfInt = a.h(parama); ; arrayOfInt = new int[0])
    {
      this.g = arrayOfInt;
      this.h = a.i(parama);
      return;
    }
  }

  public int[] a()
  {
    return this.g;
  }

  public Bundle b()
  {
    return this.i;
  }

  public u c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.h;
  }

  public String e()
  {
    return this.b;
  }

  public r f()
  {
    return this.c;
  }

  public int g()
  {
    return this.e;
  }

  public boolean h()
  {
    return this.f;
  }

  public String i()
  {
    return this.a;
  }

  public static final class a
    implements p
  {
    private final x a;
    private String b;
    private Bundle c;
    private String d;
    private r e = v.a;
    private int f = 1;
    private int[] g;
    private u h = u.a;
    private boolean i = false;
    private boolean j = false;

    a(x paramx)
    {
      this.a = paramx;
    }

    a(x paramx, p paramp)
    {
      this.a = paramx;
      this.d = paramp.e();
      this.b = paramp.i();
      this.e = paramp.f();
      this.j = paramp.h();
      this.f = paramp.g();
      this.g = paramp.a();
      this.c = paramp.b();
      this.h = paramp.c();
    }

    public a a(int paramInt)
    {
      if (this.g == null);
      for (int k = 1; ; k = 1 + this.g.length)
      {
        int[] arrayOfInt = new int[k];
        if ((this.g != null) && (this.g.length != 0))
          System.arraycopy(this.g, 0, arrayOfInt, 0, this.g.length);
        arrayOfInt[(-1 + arrayOfInt.length)] = paramInt;
        this.g = arrayOfInt;
        return this;
      }
    }

    public a a(r paramr)
    {
      this.e = paramr;
      return this;
    }

    public a a(Class<? extends JobService> paramClass)
    {
      if (paramClass == null);
      for (String str = null; ; str = paramClass.getName())
      {
        this.b = str;
        return this;
      }
    }

    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }

    public int[] a()
    {
      if (this.g == null)
        return new int[0];
      return this.g;
    }

    public Bundle b()
    {
      return this.c;
    }

    public a b(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }

    public u c()
    {
      return this.h;
    }

    public boolean d()
    {
      return this.i;
    }

    public String e()
    {
      return this.d;
    }

    public r f()
    {
      return this.e;
    }

    public int g()
    {
      return this.f;
    }

    public boolean h()
    {
      return this.j;
    }

    public String i()
    {
      return this.b;
    }

    public l j()
    {
      this.a.b(this);
      return new l(this, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.l
 * JD-Core Version:    0.6.2
 */