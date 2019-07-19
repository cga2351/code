package com.yandex.mobile.ads.impl;

import java.util.List;

public final class lu
{
  private final List<lv> a;

  public lu(List<lv> paramList)
  {
    this.a = paramList;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    lu locallu = (lu)paramObject;
    return this.a.equals(locallu.a);
  }

  public final int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lu
 * JD-Core Version:    0.6.2
 */