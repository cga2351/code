package com.yandex.mobile.ads.impl;

import java.util.List;

public final class li
{
  private final List<lo> a;
  private final cn b;
  private final String c;
  private final String d;

  public li(List<lo> paramList, cn paramcn, String paramString1, String paramString2)
  {
    this.a = paramList;
    this.b = paramcn;
    this.c = paramString1;
    this.d = paramString2;
  }

  public final List<lo> a()
  {
    return this.a;
  }

  public final cn b()
  {
    return this.b;
  }

  public final String c()
  {
    return this.c;
  }

  public final String d()
  {
    return this.d;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    li localli;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localli = (li)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localli.a));
      }
      else
        while (localli.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(localli.b));
      }
      else
        while (localli.b != null)
          return false;
      if (this.c != null)
      {
        if (this.c.equals(localli.c));
      }
      else
        while (localli.c != null)
          return false;
      if (this.d != null)
        return this.d.equals(localli.d);
    }
    while (localli.d == null);
    return false;
  }

  public final int hashCode()
  {
    int i;
    int k;
    label37: int m;
    if (this.a != null)
    {
      i = this.a.hashCode();
      int j = i * 31;
      if (this.b == null)
        break label105;
      k = this.b.hashCode();
      m = 31 * (k + j);
      if (this.c == null)
        break label110;
    }
    label105: label110: for (int n = this.c.hashCode(); ; n = 0)
    {
      int i1 = 31 * (n + m);
      String str = this.d;
      int i2 = 0;
      if (str != null)
        i2 = this.d.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label37;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.li
 * JD-Core Version:    0.6.2
 */