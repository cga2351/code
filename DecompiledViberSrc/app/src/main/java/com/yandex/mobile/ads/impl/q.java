package com.yandex.mobile.ads.impl;

public final class q extends ov
{
  private static final long serialVersionUID = 9076708591501334094L;
  private final int b;

  q()
  {
    this.b = 9;
  }

  public q(oh paramoh, int paramInt)
  {
    super(paramoh);
    this.b = paramInt;
  }

  public static q a(oh paramoh)
  {
    int i;
    q localq;
    if (paramoh != null)
    {
      i = paramoh.a;
      if (204 != i)
        break label44;
      localq = new q(paramoh, 6);
    }
    while (true)
    {
      new Object[1][0] = Integer.valueOf(i);
      return localq;
      i = -1;
      break;
      label44: if (403 == i)
      {
        localq = new q(paramoh, 10);
      }
      else if (404 == i)
      {
        localq = new q(paramoh, 4);
      }
      else
      {
        if ((500 <= i) && (i < 600));
        for (int j = 1; ; j = 0)
        {
          if (j == 0)
            break label124;
          localq = new q(paramoh, 9);
          break;
        }
        label124: if (-1 == i)
          localq = new q(paramoh, 7);
        else
          localq = new q(paramoh, 8);
      }
    }
  }

  public final int a()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    q localq;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localq = (q)paramObject;
    }
    while (this.b == localq.b);
    return false;
  }

  public final int hashCode()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.q
 * JD-Core Version:    0.6.2
 */