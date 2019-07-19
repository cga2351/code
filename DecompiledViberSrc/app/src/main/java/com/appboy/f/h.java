package com.appboy.f;

import android.content.Context;

public class h
{
  private static final String a = c.a(h.class);

  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.checkCallingOrSelfPermission(paramString);
      boolean bool = false;
      if (i == 0)
        bool = true;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      c.d(a, "Failure checking permission " + paramString, localThrowable);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.h
 * JD-Core Version:    0.6.2
 */