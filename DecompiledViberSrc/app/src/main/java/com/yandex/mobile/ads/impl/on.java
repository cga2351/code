package com.yandex.mobile.ads.impl;

import android.util.Log;
import java.util.Locale;

public class on
{
  public static String a = "Volley";
  public static boolean b = Log.isLoggable("Volley", 2);

  public static void a(String paramString)
  {
    b("Changing log tag to %s", new Object[] { paramString });
    a = paramString;
    b = Log.isLoggable(paramString, 2);
  }

  public static void a(String paramString, Object[] paramArrayOfObject)
  {
    if (b)
      Log.v(a, d(paramString, paramArrayOfObject));
  }

  public static void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.e(a, d(paramString, paramArrayOfObject), paramThrowable);
  }

  public static void b(String paramString, Object[] paramArrayOfObject)
  {
    Log.d(a, d(paramString, paramArrayOfObject));
  }

  public static void c(String paramString, Object[] paramArrayOfObject)
  {
    Log.e(a, d(paramString, paramArrayOfObject));
  }

  private static String d(String paramString, Object[] paramArrayOfObject)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    int i;
    label20: String str4;
    if (paramArrayOfObject == null)
    {
      arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= arrayOfStackTraceElement.length)
        break label174;
      if (arrayOfStackTraceElement[i].getClass().equals(on.class))
        break label168;
      String str2 = arrayOfStackTraceElement[i].getClassName();
      String str3 = str2.substring(1 + str2.lastIndexOf('.'));
      str4 = str3.substring(1 + str3.lastIndexOf('$'));
    }
    label168: label174: for (String str1 = str4 + "." + arrayOfStackTraceElement[i].getMethodName(); ; str1 = "<unknown>")
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(Thread.currentThread().getId());
      arrayOfObject[1] = str1;
      arrayOfObject[2] = paramString;
      return String.format(localLocale, "[%d] %s: %s", arrayOfObject);
      paramString = String.format(Locale.US, paramString, paramArrayOfObject);
      break;
      i++;
      break label20;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.on
 * JD-Core Version:    0.6.2
 */