package com.yandex.mobile.ads.impl;

public final class le<T>
{
  private final T a;
  private final String b;
  private final String c;
  private final li d;
  private final boolean e;
  private final boolean f;

  public le(String paramString1, String paramString2, T paramT, li paramli, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramT;
    this.d = paramli;
    this.f = paramBoolean1;
    this.e = paramBoolean2;
  }

  public final String a()
  {
    return this.b;
  }

  public final String b()
  {
    return this.c;
  }

  public final T c()
  {
    return this.a;
  }

  public final li d()
  {
    return this.d;
  }

  public final boolean e()
  {
    return this.f;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    le localle;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localle = (le)paramObject;
      if (this.e != localle.e)
        return false;
      if (this.f != localle.f)
        return false;
      if (!this.a.equals(localle.a))
        return false;
      if (!this.b.equals(localle.b))
        return false;
      if (!this.c.equals(localle.c))
        return false;
      if (this.d != null)
        return this.d.equals(localle.d);
    }
    while (localle.d == null);
    return false;
  }

  public final boolean f()
  {
    return this.e;
  }

  public final int hashCode()
  {
    int i = 1;
    int j = 31 * (31 * (31 * this.a.hashCode() + this.b.hashCode()) + this.c.hashCode());
    int k;
    int n;
    label68: int i1;
    if (this.d != null)
    {
      k = this.d.hashCode();
      int m = 31 * (k + j);
      if (!this.e)
        break label95;
      n = i;
      i1 = 31 * (n + m);
      if (!this.f)
        break label101;
    }
    while (true)
    {
      return i1 + i;
      k = 0;
      break;
      label95: n = 0;
      break label68;
      label101: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.le
 * JD-Core Version:    0.6.2
 */