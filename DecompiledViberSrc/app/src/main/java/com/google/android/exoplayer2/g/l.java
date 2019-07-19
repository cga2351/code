package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import android.util.Log;

public final class l
{
  private static int a = 0;
  private static boolean b = true;

  private static String a(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable == null);
    String str;
    do
    {
      return paramString;
      str = paramThrowable.getMessage();
    }
    while (TextUtils.isEmpty(str));
    return paramString + " - " + str;
  }

  public static void a(String paramString1, String paramString2)
  {
    if (a == 0)
      Log.d(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!b)
      c(paramString1, a(paramString2, paramThrowable));
    if (a <= 2)
      Log.w(paramString1, paramString2, paramThrowable);
  }

  public static void b(String paramString1, String paramString2)
  {
    if (a <= 1)
      Log.i(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!b)
      d(paramString1, a(paramString2, paramThrowable));
    if (a <= 3)
      Log.e(paramString1, paramString2, paramThrowable);
  }

  public static void c(String paramString1, String paramString2)
  {
    if (a <= 2)
      Log.w(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2)
  {
    if (a <= 3)
      Log.e(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.l
 * JD-Core Version:    0.6.2
 */