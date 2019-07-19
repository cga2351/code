package com.yandex.mobile.ads.impl;

import java.util.List;

public final class ls extends lo
{
  private final String a;
  private final List<lt> b;

  public ls(String paramString1, String paramString2, List<lt> paramList)
  {
    super(paramString1);
    this.a = paramString2;
    this.b = paramList;
  }

  public final String b()
  {
    return this.a;
  }

  public final List<lt> c()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    ls localls;
    boolean bool3;
    do
    {
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
      localls = (ls)paramObject;
      bool3 = this.a.equals(localls.a);
      bool1 = false;
    }
    while (!bool3);
    return this.b.equals(localls.b);
  }

  public final int hashCode()
  {
    return 31 * (31 * super.hashCode() + this.a.hashCode()) + this.b.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ls
 * JD-Core Version:    0.6.2
 */