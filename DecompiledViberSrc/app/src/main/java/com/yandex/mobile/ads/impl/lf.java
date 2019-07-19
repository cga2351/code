package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.ar.a;

public final class lf
{
  private final String a;
  private final ar.a b;

  public lf(ar.a parama, String paramString)
  {
    this.b = parama;
    this.a = paramString;
  }

  public final String a()
  {
    return this.a;
  }

  public final ar.a b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    lf locallf;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      locallf = (lf)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(locallf.a));
      }
      else
        while (locallf.a != null)
          return false;
    }
    while (this.b == locallf.b);
    return false;
  }

  public final int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = i * 31;
      ar.a locala = this.b;
      int k = 0;
      if (locala != null)
        k = this.b.hashCode();
      return j + k;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lf
 * JD-Core Version:    0.6.2
 */