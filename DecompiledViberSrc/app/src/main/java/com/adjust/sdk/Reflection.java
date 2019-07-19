package com.adjust.sdk;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection
{
  public static Object createDefaultInstance(Class paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static Object createDefaultInstance(String paramString)
  {
    return createDefaultInstance(forName(paramString));
  }

  public static Object createInstance(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = Class.forName(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static Class forName(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static Object getAdvertisingInfoObject(Context paramContext)
    throws Exception
  {
    return invokeStaticMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class }, new Object[] { paramContext });
  }

  public static String getPlayAdId(Context paramContext)
  {
    try
    {
      String str = (String)invokeInstanceMethod(getAdvertisingInfoObject(paramContext), "getId", null, new Object[0]);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static Object invokeInstanceMethod(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    return invokeMethod(paramObject.getClass(), paramString, paramObject, paramArrayOfClass, paramArrayOfObject);
  }

  public static Object invokeMethod(Class paramClass, String paramString, Object paramObject, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    Method localMethod = paramClass.getMethod(paramString, paramArrayOfClass);
    if (localMethod == null)
      return null;
    return localMethod.invoke(paramObject, paramArrayOfObject);
  }

  public static Object invokeStaticMethod(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    return invokeMethod(Class.forName(paramString1), paramString2, null, paramArrayOfClass, paramArrayOfObject);
  }

  public static Boolean isPlayTrackingEnabled(Context paramContext)
  {
    try
    {
      Boolean localBoolean1 = (Boolean)invokeInstanceMethod(getAdvertisingInfoObject(paramContext), "isLimitAdTrackingEnabled", null, new Object[0]);
      if (localBoolean1 == null)
        return null;
      if (!localBoolean1.booleanValue());
      for (boolean bool = true; ; bool = false)
      {
        Boolean localBoolean2 = Boolean.valueOf(bool);
        return localBoolean2;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static Object readField(String paramString1, String paramString2)
    throws Exception
  {
    return readField(paramString1, paramString2, null);
  }

  public static Object readField(String paramString1, String paramString2, Object paramObject)
    throws Exception
  {
    Class localClass = forName(paramString1);
    if (localClass == null);
    Field localField;
    do
    {
      return null;
      localField = localClass.getField(paramString2);
    }
    while (localField == null);
    return localField.get(paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Reflection
 * JD-Core Version:    0.6.2
 */