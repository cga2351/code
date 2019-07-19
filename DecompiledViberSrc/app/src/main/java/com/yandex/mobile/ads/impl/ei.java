package com.yandex.mobile.ads.impl;

import android.graphics.RectF;

public final class ei
{
  private final RectF a;
  private final int b;

  public ei(int paramInt, RectF paramRectF)
  {
    this.b = paramInt;
    this.a = paramRectF;
  }

  public final int a()
  {
    return this.b;
  }

  public final RectF b()
  {
    return this.a;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ei localei;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localei = (ei)paramObject;
      if (this.b != localei.b)
        return false;
      if (this.a != null)
        return this.a.equals(localei.a);
    }
    while (localei.a == null);
    return false;
  }

  public final int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
      return i * 31 + this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ei
 * JD-Core Version:    0.6.2
 */