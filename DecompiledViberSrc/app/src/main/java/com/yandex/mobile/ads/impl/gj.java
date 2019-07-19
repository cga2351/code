package com.yandex.mobile.ads.impl;

public final class gj
{
  private static volatile gj a;
  private static final Object b = new Object();

  public static gi a(boolean paramBoolean)
  {
    if (paramBoolean)
      return new gk();
    return new gh();
  }

  public static gj a()
  {
    if (a == null);
    synchronized (b)
    {
      if (a == null)
        a = new gj();
      return a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gj
 * JD-Core Version:    0.6.2
 */