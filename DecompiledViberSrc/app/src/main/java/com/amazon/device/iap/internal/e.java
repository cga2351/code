package com.amazon.device.iap.internal;

import android.util.Log;
import com.amazon.device.iap.internal.a.d;
import com.amazon.device.iap.internal.b.g;

public final class e
{
  private static final String a = e.class.getName();
  private static volatile boolean b;
  private static volatile boolean c;
  private static volatile c d;
  private static volatile a e;
  private static volatile b f;

  private static <T> T a(Class<T> paramClass)
  {
    try
    {
      Object localObject = d().a(paramClass).newInstance();
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e(a, "error getting instance for " + paramClass, localException);
    }
    return null;
  }

  public static boolean a()
  {
    if (c)
      return b;
    try
    {
      if (c)
      {
        boolean bool = b;
        return bool;
      }
    }
    finally
    {
    }
    try
    {
      e.class.getClassLoader().loadClass("com.amazon.android.Kiwi");
      b = false;
      c = true;
      return b;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        b = true;
    }
  }

  public static c b()
  {
    if (d == null);
    try
    {
      if (d == null)
        d = (c)a(c.class);
      return d;
    }
    finally
    {
    }
  }

  public static a c()
  {
    if (e == null);
    try
    {
      if (e == null)
        e = (a)a(a.class);
      return e;
    }
    finally
    {
    }
  }

  private static b d()
  {
    if (f == null);
    try
    {
      if (f == null)
        if (!a())
          break label38;
      label38: for (f = new d(); ; f = new g())
        return f;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.e
 * JD-Core Version:    0.6.2
 */