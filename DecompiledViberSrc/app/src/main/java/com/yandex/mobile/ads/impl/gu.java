package com.yandex.mobile.ads.impl;

final class gu
  implements Runnable
{
  private final int a;
  private final String b;
  private final gs c;

  gu(int paramInt, String paramString, gs paramgs)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramgs;
  }

  public final void run()
  {
    this.c.b(this.a, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gu
 * JD-Core Version:    0.6.2
 */