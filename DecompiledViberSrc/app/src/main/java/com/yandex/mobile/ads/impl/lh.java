package com.yandex.mobile.ads.impl;

public final class lh
{
  private int a;
  private int b;
  private String c;
  private String d;

  public final int a()
  {
    return this.a;
  }

  public final void a(int paramInt)
  {
    this.a = paramInt;
  }

  public final void a(String paramString)
  {
    this.c = paramString;
  }

  public final int b()
  {
    return this.b;
  }

  public final void b(int paramInt)
  {
    this.b = paramInt;
  }

  public final void b(String paramString)
  {
    this.d = paramString;
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
    lh locallh;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      locallh = (lh)paramObject;
      if (this.a != locallh.a)
        return false;
      if (this.b != locallh.b)
        return false;
      if (this.c != null)
      {
        if (this.c.equals(locallh.c));
      }
      else
        while (locallh.c != null)
          return false;
      if (this.d != null)
        return this.d.equals(locallh.d);
    }
    while (locallh.d == null);
    return false;
  }

  public final int hashCode()
  {
    int i = 31 * (31 * this.a + this.b);
    if (this.c != null);
    for (int j = this.c.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      String str = this.d;
      int m = 0;
      if (str != null)
        m = this.d.hashCode();
      return k + m;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lh
 * JD-Core Version:    0.6.2
 */