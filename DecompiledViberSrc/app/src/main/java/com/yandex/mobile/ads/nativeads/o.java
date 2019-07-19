package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.v;

public final class o
{
  private final v a;
  private final eo b;
  private final lm c;

  public o(lm paramlm, v paramv, eo parameo)
  {
    this.a = paramv;
    this.b = parameo;
    this.c = paramlm;
  }

  public final eo a()
  {
    return this.b;
  }

  public final v b()
  {
    return this.a;
  }

  public final lm c()
  {
    return this.c;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    o localo;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localo = (o)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localo.a));
      }
      else
        while (localo.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(localo.b));
      }
      else
        while (localo.b != null)
          return false;
      if (this.c != null)
        return this.c.equals(localo.c);
    }
    while (localo.c == null);
    return false;
  }

  public final int hashCode()
  {
    int i;
    int j;
    if (this.a != null)
    {
      i = this.a.hashCode();
      j = i * 31;
      if (this.b == null)
        break label77;
    }
    label77: for (int k = this.b.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      lm locallm = this.c;
      int n = 0;
      if (locallm != null)
        n = this.c.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.o
 * JD-Core Version:    0.6.2
 */