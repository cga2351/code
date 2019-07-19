package com.yandex.mobile.ads.impl;

import java.util.List;

public final class lq extends lo
{
  private final List<a> a;

  public lq(String paramString, List<a> paramList)
  {
    super(paramString);
    this.a = paramList;
  }

  public final List<a> b()
  {
    return this.a;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    boolean bool2;
    do
    {
      Class localClass1;
      Class localClass2;
      do
      {
        do
        {
          return bool1;
          bool1 = false;
        }
        while (paramObject == null);
        localClass1 = getClass();
        localClass2 = paramObject.getClass();
        bool1 = false;
      }
      while (localClass1 != localClass2);
      bool2 = super.equals(paramObject);
      bool1 = false;
    }
    while (!bool2);
    lq locallq = (lq)paramObject;
    return this.a.equals(locallq.a);
  }

  public final int hashCode()
  {
    return 31 * super.hashCode() + this.a.hashCode();
  }

  public static final class a
  {
    private final String a;
    private final String b;

    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public final String a()
    {
      return this.a;
    }

    public final String b()
    {
      return this.b;
    }

    public final boolean equals(Object paramObject)
    {
      boolean bool1;
      if (this == paramObject)
        bool1 = true;
      a locala;
      boolean bool2;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool1;
            bool1 = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool1 = false;
        }
        while (localClass1 != localClass2);
        locala = (a)paramObject;
        bool2 = this.a.equals(locala.a);
        bool1 = false;
      }
      while (!bool2);
      return this.b.equals(locala.b);
    }

    public final int hashCode()
    {
      return 31 * this.a.hashCode() + this.b.hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lq
 * JD-Core Version:    0.6.2
 */