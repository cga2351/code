package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;

public class bc
{
  private final String a;
  private final Map<String, String> b;
  private final List<String> c;
  private final List<String> d;
  private final List<String> e;

  private bc(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
  }

  public final String a()
  {
    return this.a;
  }

  public final Map<String, String> b()
  {
    return this.b;
  }

  public final List<String> c()
  {
    return this.c;
  }

  public final List<String> d()
  {
    return this.d;
  }

  public final List<String> e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    bc localbc;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localbc = (bc)paramObject;
      if (!this.a.equals(localbc.a))
        return false;
      if (!this.b.equals(localbc.b))
        return false;
      if (this.c != null)
      {
        if (this.c.equals(localbc.c));
      }
      else
        while (localbc.c != null)
          return false;
      if (this.d != null)
      {
        if (this.d.equals(localbc.d));
      }
      else
        while (localbc.d != null)
          return false;
      if (this.e != null)
        return this.e.equals(localbc.e);
    }
    while (localbc.e == null);
    return false;
  }

  public int hashCode()
  {
    int i = 31 * (31 * this.a.hashCode() + this.b.hashCode());
    int j;
    int k;
    if (this.c != null)
    {
      j = this.c.hashCode();
      k = 31 * (j + i);
      if (this.d == null)
        break label111;
    }
    label111: for (int m = this.d.hashCode(); ; m = 0)
    {
      int n = 31 * (m + k);
      List localList = this.e;
      int i1 = 0;
      if (localList != null)
        i1 = this.e.hashCode();
      return n + i1;
      j = 0;
      break;
    }
  }

  public static final class a
  {
    private final String a;
    private final Map<String, String> b;
    private List<String> c;
    private List<String> d;
    private List<String> e;

    public a(String paramString, Map<String, String> paramMap)
    {
      this.a = paramString;
      this.b = paramMap;
    }

    public final a a(List<String> paramList)
    {
      this.c = paramList;
      return this;
    }

    public final bc a()
    {
      return new bc(this, (byte)0);
    }

    public final a b(List<String> paramList)
    {
      this.d = paramList;
      return this;
    }

    public final a c(List<String> paramList)
    {
      this.e = paramList;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bc
 * JD-Core Version:    0.6.2
 */