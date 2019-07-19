package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class bk
{
  private static final Object a = new Object();
  private static volatile oj b;

  public static oj a(Context paramContext)
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
      {
        oj localoj = bl.a(paramContext);
        b = localoj;
        localoj.a();
      }
      return b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bk
 * JD-Core Version:    0.6.2
 */