package com.yandex.mobile.ads.impl;

public final class et
{
  private final Boolean a;
  private final Boolean b;
  private final String c;
  private final String d;
  private final Boolean e;
  private final long f;
  private final boolean g;
  private final boolean h;
  private final boolean i;

  private et(a parama)
  {
    this.f = a.a(parama);
    this.c = a.b(parama);
    this.g = a.c(parama);
    this.b = a.d(parama);
    this.d = a.e(parama);
    this.e = a.f(parama);
    this.h = a.g(parama);
    this.i = a.h(parama);
    this.a = a.i(parama);
  }

  public final long a()
  {
    return this.f;
  }

  public final boolean b()
  {
    return this.g;
  }

  public final boolean c()
  {
    return this.h;
  }

  public final Boolean d()
  {
    return this.a;
  }

  public final String e()
  {
    return this.c;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    et localet;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localet = (et)paramObject;
      if (this.f != localet.f)
        return false;
      if (this.g != localet.g)
        return false;
      if (this.h != localet.h)
        return false;
      if (this.i != localet.i)
        return false;
      if (this.a != null)
      {
        if (this.a.equals(localet.a));
      }
      else
        while (localet.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(localet.b));
      }
      else
        while (localet.b != null)
          return false;
      if (this.c != null)
      {
        if (this.c.equals(localet.c));
      }
      else
        while (localet.c != null)
          return false;
      if (this.d != null)
      {
        if (this.d.equals(localet.d));
      }
      else
        while (localet.d != null)
          return false;
      if (this.e != null)
        return this.e.equals(localet.e);
    }
    while (localet.e == null);
    return false;
  }

  public final Boolean f()
  {
    return this.e;
  }

  public final boolean g()
  {
    return this.i;
  }

  public final String h()
  {
    return this.d;
  }

  public final int hashCode()
  {
    int j = 1;
    int k;
    int n;
    label38: int i2;
    label63: int i4;
    label89: int i6;
    label115: int i8;
    label152: int i10;
    label172: int i11;
    if (this.a != null)
    {
      k = this.a.hashCode();
      int m = k * 31;
      if (this.b == null)
        break label199;
      n = this.b.hashCode();
      int i1 = 31 * (n + m);
      if (this.c == null)
        break label205;
      i2 = this.c.hashCode();
      int i3 = 31 * (i2 + i1);
      if (this.d == null)
        break label211;
      i4 = this.d.hashCode();
      int i5 = 31 * (i4 + i3);
      if (this.e == null)
        break label217;
      i6 = this.e.hashCode();
      int i7 = 31 * (31 * (i6 + i5) + (int)(this.f ^ this.f >>> 32));
      if (!this.g)
        break label223;
      i8 = j;
      int i9 = 31 * (i8 + i7);
      if (!this.h)
        break label229;
      i10 = j;
      i11 = 31 * (i10 + i9);
      if (!this.i)
        break label235;
    }
    while (true)
    {
      return i11 + j;
      k = 0;
      break;
      label199: n = 0;
      break label38;
      label205: i2 = 0;
      break label63;
      label211: i4 = 0;
      break label89;
      label217: i6 = 0;
      break label115;
      label223: i8 = 0;
      break label152;
      label229: i10 = 0;
      break label172;
      label235: j = 0;
    }
  }

  public final Boolean i()
  {
    return this.b;
  }

  public static final class a
  {
    private Boolean a;
    private Boolean b;
    private String c;
    private Boolean d;
    private String e;
    private long f;
    private boolean g;
    private boolean h;
    private boolean i;

    public final a a(long paramLong)
    {
      this.f = paramLong;
      return this;
    }

    public final a a(Boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }

    public final a a(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public final a a(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }

    public final et a()
    {
      return new et(this, (byte)0);
    }

    public final a b(Boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }

    public final a b(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public final a b(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }

    public final a c(Boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }

    public final a c(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.et
 * JD-Core Version:    0.6.2
 */