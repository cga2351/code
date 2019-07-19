package com.yandex.metrica.impl;

public enum t
{
  public final int d;

  static
  {
    t[] arrayOft = new t[3];
    arrayOft[0] = a;
    arrayOft[1] = b;
    arrayOft[2] = c;
  }

  private t(int paramInt)
  {
    this.d = paramInt;
  }

  public static t a(Integer paramInteger)
  {
    if (paramInteger != null)
      for (t localt : values())
        if (localt.d == paramInteger.intValue())
          return localt;
    return a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.t
 * JD-Core Version:    0.6.2
 */