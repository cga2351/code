package com.yandex.mobile.ads.impl;

public final class gx
{
  private static final Object a = new Object();
  private static volatile gx b;
  private v<String> c;

  public static gx a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new gx();
      return b;
    }
  }

  public final void a(v<String> paramv)
  {
    synchronized (a)
    {
      this.c = paramv;
      return;
    }
  }

  public final v<String> b()
  {
    synchronized (a)
    {
      v localv = this.c;
      return localv;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gx
 * JD-Core Version:    0.6.2
 */