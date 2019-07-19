package com.yandex.mobile.ads.nativeads;

public final class al
{
  private static final Object a = new Object();
  private static volatile al b;
  private boolean c = true;

  public static al a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new al();
      return b;
    }
  }

  public final boolean b()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.al
 * JD-Core Version:    0.6.2
 */