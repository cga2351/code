package com.mixpanel.android.b;

import android.util.Log;

public class f
{
  private static int a = 5;

  public static void a(int paramInt)
  {
    a = paramInt;
  }

  public static void a(String paramString1, String paramString2)
  {
    if (b(2))
      Log.v(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b(2))
      Log.v(paramString1, paramString2, paramThrowable);
  }

  public static void b(String paramString1, String paramString2)
  {
    if (b(3))
      Log.d(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b(3))
      Log.d(paramString1, paramString2, paramThrowable);
  }

  private static boolean b(int paramInt)
  {
    return a <= paramInt;
  }

  public static void c(String paramString1, String paramString2)
  {
    if (b(4))
      Log.i(paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b(4))
      Log.i(paramString1, paramString2, paramThrowable);
  }

  public static void d(String paramString1, String paramString2)
  {
    if (b(5))
      Log.w(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b(5))
      Log.w(paramString1, paramString2, paramThrowable);
  }

  public static void e(String paramString1, String paramString2)
  {
    if (b(6))
      Log.e(paramString1, paramString2);
  }

  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b(6))
      Log.e(paramString1, paramString2, paramThrowable);
  }

  public static void f(String paramString1, String paramString2)
  {
    if (b(6))
      Log.wtf(paramString1, paramString2);
  }

  public static void f(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b(6))
      Log.wtf(paramString1, paramString2, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.f
 * JD-Core Version:    0.6.2
 */