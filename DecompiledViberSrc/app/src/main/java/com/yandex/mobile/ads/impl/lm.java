package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lm
{
  private String a;
  private List<le> b;
  private List<ll> c;
  private ln d;
  private List<bd> e;
  private List<String> f;
  private Map<String, Object> g = new HashMap();

  public final Map<String, Object> a()
  {
    return this.g;
  }

  public final void a(ln paramln)
  {
    this.d = paramln;
  }

  public final void a(String paramString)
  {
    this.a = paramString;
  }

  public final void a(String paramString, Object paramObject)
  {
    this.g.put(paramString, paramObject);
  }

  public final void a(List<le> paramList)
  {
    this.b = paramList;
  }

  public final List<le> b()
  {
    return this.b;
  }

  public final void b(List<ll> paramList)
  {
    this.c = paramList;
  }

  public final List<ll> c()
  {
    return this.c;
  }

  public final void c(List<bd> paramList)
  {
    this.e = paramList;
  }

  public final ln d()
  {
    return this.d;
  }

  public final void d(List<String> paramList)
  {
    this.f = paramList;
  }

  public final List<bd> e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    lm locallm;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      locallm = (lm)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(locallm.a));
      }
      else
        while (locallm.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(locallm.b));
      }
      else
        while (locallm.b != null)
          return false;
      if (this.c != null)
      {
        if (this.c.equals(locallm.c));
      }
      else
        while (locallm.c != null)
          return false;
      if (this.d != null)
      {
        if (this.d.equals(locallm.d));
      }
      else
        while (locallm.d != null)
          return false;
      if (this.e != null)
      {
        if (this.e.equals(locallm.e));
      }
      else
        while (locallm.e != null)
          return false;
      if (this.f != null)
      {
        if (this.f.equals(locallm.f));
      }
      else
        while (locallm.f != null)
          return false;
      if (this.g != null)
        return this.g.equals(locallm.g);
    }
    while (locallm.g == null);
    return false;
  }

  public final List<String> f()
  {
    return this.f;
  }

  public int hashCode()
  {
    int i;
    int k;
    label37: int n;
    label63: int i2;
    label89: int i4;
    label117: int i5;
    if (this.a != null)
    {
      i = this.a.hashCode();
      int j = i * 31;
      if (this.b == null)
        break label191;
      k = this.b.hashCode();
      int m = 31 * (k + j);
      if (this.c == null)
        break label196;
      n = this.c.hashCode();
      int i1 = 31 * (n + m);
      if (this.d == null)
        break label202;
      i2 = this.d.hashCode();
      int i3 = 31 * (i2 + i1);
      if (this.e == null)
        break label208;
      i4 = this.e.hashCode();
      i5 = 31 * (i4 + i3);
      if (this.f == null)
        break label214;
    }
    label191: label196: label202: label208: label214: for (int i6 = this.f.hashCode(); ; i6 = 0)
    {
      int i7 = 31 * (i6 + i5);
      Map localMap = this.g;
      int i8 = 0;
      if (localMap != null)
        i8 = this.g.hashCode();
      return i7 + i8;
      i = 0;
      break;
      k = 0;
      break label37;
      n = 0;
      break label63;
      i2 = 0;
      break label89;
      i4 = 0;
      break label117;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lm
 * JD-Core Version:    0.6.2
 */