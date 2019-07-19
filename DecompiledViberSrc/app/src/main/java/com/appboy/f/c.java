package com.appboy.f;

import a.a.ba;
import a.a.dv;
import android.util.Log;

public class c
{
  private static ba a;
  private static final String b = a(c.class);
  private static boolean c;
  private static int d = 4;
  private static final int e = "Appboy v3.2.1 .".length();
  private static final int f = 80 - e;

  public static int a(String paramString1, String paramString2)
  {
    if (d <= 2)
      return Log.v(paramString1, paramString2);
    return 0;
  }

  public static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a(paramString1, paramString2, paramThrowable, true);
  }

  public static int a(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramBoolean)
      e(paramString1, paramString2, null);
    if (d <= 3)
    {
      if (paramThrowable != null)
        return Log.d(paramString1, paramString2, paramThrowable);
      return Log.d(paramString1, paramString2);
    }
    return 0;
  }

  public static int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, paramBoolean);
  }

  public static String a(Class paramClass)
  {
    String str = paramClass.getName();
    int i = str.length();
    if (i <= f);
    while (true)
    {
      return "Appboy v3.2.1 ." + str;
      str = str.substring(i - f);
    }
  }

  public static void a()
  {
    try
    {
      String str = dv.a("log.tag.APPBOY", "");
      if ((!i.c(str)) && (str.trim().equalsIgnoreCase("verbose")))
      {
        c = true;
        d = 2;
        c(b, "AppboyLogger log level set to " + str + " via device system property. Note that subsequent calls to AppboyLogger.setLogLevel() will have no effect.");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void a(ba paramba)
  {
    a = paramba;
  }

  public static int b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, true);
  }

  public static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return b(paramString1, paramString2, paramThrowable, true);
  }

  public static int b(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramBoolean)
      e(paramString1, paramString2, null);
    if (d <= 4)
    {
      if (paramThrowable != null)
        return Log.i(paramString1, paramString2, paramThrowable);
      return Log.i(paramString1, paramString2);
    }
    return 0;
  }

  public static int b(String paramString1, String paramString2, boolean paramBoolean)
  {
    return b(paramString1, paramString2, null, paramBoolean);
  }

  public static int c(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, true);
  }

  public static int c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    e(paramString1, paramString2, paramThrowable);
    if (d <= 5)
      return Log.w(paramString1, paramString2, paramThrowable);
    return 0;
  }

  public static int d(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
    if (d <= 5)
      return Log.w(paramString1, paramString2);
    return 0;
  }

  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    e(paramString1, paramString2, null);
    if (d <= 6)
      return Log.e(paramString1, paramString2, paramThrowable);
    return 0;
  }

  public static int e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
    if (d <= 6)
      return Log.e(paramString1, paramString2);
    return 0;
  }

  private static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((a != null) && (a.a()) && (paramString1 != null))
      a.a(paramString1, paramString2, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.c
 * JD-Core Version:    0.6.2
 */