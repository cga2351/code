package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class gw
{
  public static boolean a(Context paramContext, aj paramaj)
  {
    return a(paramContext, paramaj, dh.c(paramContext), dh.d(paramContext));
  }

  private static boolean a(Context paramContext, aj paramaj, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramaj != null)
    {
      int i = paramaj.b(paramContext);
      int j = paramaj.a(paramContext);
      bool = false;
      if (i <= paramInt1)
      {
        bool = false;
        if (j <= paramInt2)
          bool = true;
      }
    }
    return bool;
  }

  public static boolean a(Context paramContext, aj paramaj1, aj paramaj2)
  {
    int i = paramaj2.b(paramContext);
    int j = paramaj2.a(paramContext);
    int k = paramaj1.b(paramContext);
    int m = paramaj1.a(paramContext);
    int n;
    switch (1.a[paramaj2.c().ordinal()])
    {
    default:
      n = 0;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if ((n == 0) || (!a(paramContext, paramaj1)))
        break label145;
      return true;
      if ((k <= i) && (i > 0) && (m <= j))
      {
        n = 1;
      }
      else
      {
        n = 0;
        continue;
        if ((k > i) || (i <= 0) || ((m > j) && (j != 0)))
          break;
        n = 1;
        continue;
        n = 1;
      }
    }
    label145: return false;
  }

  public static boolean b(Context paramContext, aj paramaj)
  {
    return a(paramContext, paramaj, dh.d(paramContext), dh.c(paramContext));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gw
 * JD-Core Version:    0.6.2
 */