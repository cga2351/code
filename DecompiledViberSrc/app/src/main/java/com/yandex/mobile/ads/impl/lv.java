package com.yandex.mobile.ads.impl;

public final class lv
{
  private final String a;
  private final int b;
  private final int c;

  public lv(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    lv locallv;
    int k;
    int m;
    do
    {
      int i;
      int j;
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
        locallv = (lv)paramObject;
        i = this.b;
        j = locallv.b;
        bool = false;
      }
      while (i != j);
      k = this.c;
      m = locallv.c;
      bool = false;
    }
    while (k != m);
    return this.a.equals(locallv.a);
  }

  public final int hashCode()
  {
    return 31 * (31 * this.a.hashCode() + this.b) + this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lv
 * JD-Core Version:    0.6.2
 */