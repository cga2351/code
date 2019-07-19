package com.yandex.mobile.ads.impl;

public final class lk
{
  private lj a;
  private lh b;

  public lk(lj paramlj, lh paramlh)
  {
    this.a = paramlj;
    this.b = paramlh;
  }

  public final lj a()
  {
    return this.a;
  }

  public final lh b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    lk locallk;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      locallk = (lk)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(locallk.a));
      }
      else
        while (locallk.a != null)
          return false;
      if (this.b != null)
        return this.b.equals(locallk.b);
    }
    while (locallk.b == null);
    return false;
  }

  public final int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = i * 31;
      lh locallh = this.b;
      int k = 0;
      if (locallh != null)
        k = this.b.hashCode();
      return j + k;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lk
 * JD-Core Version:    0.6.2
 */