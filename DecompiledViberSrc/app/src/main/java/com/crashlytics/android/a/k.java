package com.crashlytics.android.a;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;

public class k
  implements q
{
  private final Method a;
  private final Object b;

  public k(Object paramObject, Method paramMethod)
  {
    this.b = paramObject;
    this.a = paramMethod;
  }

  public static q a(Context paramContext)
  {
    Class localClass = b(paramContext);
    if (localClass == null);
    Object localObject;
    Method localMethod;
    do
    {
      do
      {
        return null;
        localObject = a(paramContext, localClass);
      }
      while (localObject == null);
      localMethod = b(paramContext, localClass);
    }
    while (localMethod == null);
    return new k(localObject, localMethod);
  }

  private static Object a(Context paramContext, Class paramClass)
  {
    try
    {
      Object localObject = paramClass.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(paramClass, new Object[] { paramContext });
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static Class b(Context paramContext)
  {
    try
    {
      Class localClass = paramContext.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
      return localClass;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static Method b(Context paramContext, Class paramClass)
  {
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("logEventInternal", new Class[] { String.class, String.class, Bundle.class });
      return localMethod;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public void a(String paramString, Bundle paramBundle)
  {
    a("fab", paramString, paramBundle);
  }

  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    try
    {
      this.a.invoke(this.b, new Object[] { paramString1, paramString2, paramBundle });
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.k
 * JD-Core Version:    0.6.2
 */