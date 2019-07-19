package com.yandex.mobile.ads.impl;

public final class lj
{
  private final String a;
  private final float b;

  public lj(String paramString, float paramFloat)
  {
    this.a = paramString;
    this.b = paramFloat;
  }

  public final String a()
  {
    return this.a;
  }

  public final float b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    lj locallj;
    int i;
    do
    {
      Class localClass1;
      Class localClass2;
      do
      {
        do
        {
          return bool;
          bool = false;
        }
        while (paramObject == null);
        localClass1 = getClass();
        localClass2 = paramObject.getClass();
        bool = false;
      }
      while (localClass1 != localClass2);
      locallj = (lj)paramObject;
      i = Float.compare(locallj.b, this.b);
      bool = false;
    }
    while (i != 0);
    return this.a.equals(locallj.a);
  }

  public final int hashCode()
  {
    int i = 31 * this.a.hashCode();
    if (this.b != 0.0F);
    for (int j = Float.floatToIntBits(this.b); ; j = 0)
      return j + i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lj
 * JD-Core Version:    0.6.2
 */