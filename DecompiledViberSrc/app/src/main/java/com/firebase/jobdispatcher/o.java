package com.firebase.jobdispatcher;

import android.os.Bundle;

final class o
  implements p
{
  private final String a;
  private final String b;
  private final r c;
  private final boolean d;
  private final int e;
  private final int[] f;
  private final Bundle g;
  private final u h;
  private final boolean i;
  private final w j;

  private o(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.h = a.d(parama);
    this.d = a.e(parama);
    this.e = a.f(parama);
    this.f = a.g(parama);
    this.g = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
  }

  public int[] a()
  {
    return this.f;
  }

  public Bundle b()
  {
    return this.g;
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
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    o localo;
    do
    {
      return true;
      if ((paramObject == null) || (!getClass().equals(paramObject.getClass())))
        return false;
      localo = (o)paramObject;
    }
    while ((this.a.equals(localo.a)) && (this.b.equals(localo.b)));
    return false;
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
    return this.d;
  }

  public int hashCode()
  {
    return 31 * this.a.hashCode() + this.b.hashCode();
  }

  public String i()
  {
    return this.b;
  }

  static final class a
  {
    private String a;
    private String b;
    private r c;
    private boolean d;
    private int e;
    private int[] f;
    private final Bundle g = new Bundle();
    private u h;
    private boolean i;
    private w j;

    public a a(int paramInt)
    {
      this.e = paramInt;
      return this;
    }

    public a a(Bundle paramBundle)
    {
      if (paramBundle != null)
        this.g.putAll(paramBundle);
      return this;
    }

    public a a(r paramr)
    {
      this.c = paramr;
      return this;
    }

    public a a(u paramu)
    {
      this.h = paramu;
      return this;
    }

    public a a(w paramw)
    {
      this.j = paramw;
      return this;
    }

    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }

    public a a(int[] paramArrayOfInt)
    {
      this.f = paramArrayOfInt;
      return this;
    }

    o a()
    {
      if ((this.a == null) || (this.b == null) || (this.c == null))
        throw new IllegalArgumentException("Required fields were not populated.");
      return new o(this, null);
    }

    public a b(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.o
 * JD-Core Version:    0.6.2
 */