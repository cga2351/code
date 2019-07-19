package com.yandex.mobile.ads.impl;

import android.content.Context;

final class jo
  implements jk
{
  private static final Object a = new Object();
  private static volatile jo b;

  public static jo a()
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new jo();
      return b;
    }
  }

  public final void a(Context paramContext, jn paramjn)
  {
  }

  public final void b(Context paramContext, jn paramjn)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jo
 * JD-Core Version:    0.6.2
 */