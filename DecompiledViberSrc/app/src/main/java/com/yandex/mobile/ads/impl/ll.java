package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.NativeAdType;
import java.util.Iterator;
import java.util.List;

public class ll
{
  private li a;
  private NativeAdType b;
  private List<le> c;
  private bd d;
  private String e;
  private String f;
  private lu g;
  private lu h;

  public final li a()
  {
    return this.a;
  }

  public final void a(bd parambd)
  {
    this.d = parambd;
  }

  public final void a(li paramli)
  {
    if (paramli != null)
      this.a = paramli;
  }

  public final void a(lu paramlu)
  {
    this.g = paramlu;
  }

  public final void a(String paramString)
  {
    NativeAdType[] arrayOfNativeAdType = NativeAdType.values();
    int i = arrayOfNativeAdType.length;
    int j = 0;
    NativeAdType localNativeAdType;
    if (j < i)
    {
      localNativeAdType = arrayOfNativeAdType[j];
      if (!localNativeAdType.getValue().equals(paramString));
    }
    while (true)
    {
      this.b = localNativeAdType;
      return;
      j++;
      break;
      localNativeAdType = null;
    }
  }

  public final void a(List<le> paramList)
  {
    this.c = paramList;
  }

  public final le b(String paramString)
  {
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        le localle = (le)localIterator.next();
        if (localle.a().equals(paramString))
          return localle;
      }
    }
    return null;
  }

  public final NativeAdType b()
  {
    return this.b;
  }

  public final void b(lu paramlu)
  {
    this.h = paramlu;
  }

  public final List<le> c()
  {
    return this.c;
  }

  public final void c(String paramString)
  {
    this.e = paramString;
  }

  public final bd d()
  {
    return this.d;
  }

  public final void d(String paramString)
  {
    this.f = paramString;
  }

  public final String e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ll localll;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localll = (ll)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localll.a));
      }
      else
        while (localll.a != null)
          return false;
      if (this.b != localll.b)
        return false;
      if (this.c != null)
      {
        if (this.c.equals(localll.c));
      }
      else
        while (localll.c != null)
          return false;
      if (this.d != null)
      {
        if (this.d.equals(localll.d));
      }
      else
        while (localll.d != null)
          return false;
      if (this.e != null)
      {
        if (this.e.equals(localll.e));
      }
      else
        while (localll.e != null)
          return false;
      if (this.f != null)
      {
        if (this.f.equals(localll.f));
      }
      else
        while (localll.f != null)
          return false;
      if (this.g != null)
      {
        if (this.g.equals(localll.g));
      }
      else
        while (localll.g != null)
          return false;
      if (this.h != null)
        return this.h.equals(localll.h);
    }
    while (localll.h == null);
    return false;
  }

  public final String f()
  {
    return this.f;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label61: int i2;
    label87: int i4;
    label113: int i6;
    label139: int i7;
    if (this.a != null)
    {
      i = this.a.hashCode();
      int j = i * 31;
      if (this.b == null)
        break label209;
      k = this.b.hashCode();
      int m = 31 * (k + j);
      if (this.c == null)
        break label214;
      n = this.c.hashCode();
      int i1 = 31 * (n + m);
      if (this.d == null)
        break label220;
      i2 = this.d.hashCode();
      int i3 = 31 * (i2 + i1);
      if (this.e == null)
        break label226;
      i4 = this.e.hashCode();
      int i5 = 31 * (i4 + i3);
      if (this.f == null)
        break label232;
      i6 = this.f.hashCode();
      i7 = 31 * (i6 + i5);
      if (this.g == null)
        break label238;
    }
    label209: label214: label220: label226: label232: label238: for (int i8 = this.g.hashCode(); ; i8 = 0)
    {
      int i9 = 31 * (i8 + i7);
      lu locallu = this.h;
      int i10 = 0;
      if (locallu != null)
        i10 = this.h.hashCode();
      return i9 + i10;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label61;
      i2 = 0;
      break label87;
      i4 = 0;
      break label113;
      i6 = 0;
      break label139;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ll
 * JD-Core Version:    0.6.2
 */