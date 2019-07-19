package com.yandex.mobile.ads.impl;

public final class ly
{
  private final int a;

  ly(int paramInt)
  {
    this.a = paramInt;
  }

  final int a(int paramInt)
  {
    if (paramInt > 0)
      return Math.min(paramInt, this.a);
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ly
 * JD-Core Version:    0.6.2
 */