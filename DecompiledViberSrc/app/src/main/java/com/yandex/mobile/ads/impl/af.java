package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class af
{
  private static volatile af a;
  private static final Object b = new Object();

  public static af a()
  {
    if (a == null);
    synchronized (b)
    {
      if (a == null)
        a = new af();
      return a;
    }
  }

  public final void a(Context paramContext, oi paramoi)
  {
    try
    {
      bk.a(paramContext).a(paramoi);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(Context paramContext, final String paramString)
  {
    bk.a(paramContext).a(new oj.a()
    {
      public final boolean a(oi<?> paramAnonymousoi)
      {
        return paramString.equals(paramAnonymousoi.e());
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.af
 * JD-Core Version:    0.6.2
 */