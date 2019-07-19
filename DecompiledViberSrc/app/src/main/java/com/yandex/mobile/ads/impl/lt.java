package com.yandex.mobile.ads.impl;

import java.util.Map;

public final class lt
{
  private final String a;
  private final String b;
  private final Map<String, Object> c;

  public lt(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramMap;
  }

  public final String a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.b;
  }

  public final Map<String, Object> c()
  {
    return this.c;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    lt locallt;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      locallt = (lt)paramObject;
      if (!this.a.equals(locallt.a))
        return false;
      if (!this.b.equals(locallt.b))
        return false;
      if (this.c != null)
        return this.c.equals(locallt.c);
    }
    while (locallt.c == null);
    return false;
  }

  public final int hashCode()
  {
    int i = 31 * (31 * this.a.hashCode() + this.b.hashCode());
    if (this.c != null);
    for (int j = this.c.hashCode(); ; j = 0)
      return j + i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lt
 * JD-Core Version:    0.6.2
 */