package com.yandex.mobile.ads.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class fn
{
  public static <T> T a(Class<T> paramClass, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    for (int i = 0; i < paramArrayOfObject.length; i++)
      arrayOfClass[i] = paramArrayOfObject[i].getClass();
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(arrayOfClass);
      boolean bool = localConstructor.isAccessible();
      if (!bool)
        localConstructor.setAccessible(true);
      Object localObject = localConstructor.newInstance(paramArrayOfObject);
      if (!bool)
        localConstructor.setAccessible(false);
      return localObject;
    }
    catch (Exception localException)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramClass.getCanonicalName();
      arrayOfObject[1] = Arrays.toString(paramArrayOfObject);
    }
    return null;
  }

  public static void a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      Method[] arrayOfMethod = paramObject.getClass().getDeclaredMethods();
      int i = arrayOfMethod.length;
      int j = 0;
      Method localMethod;
      if (j < i)
      {
        localMethod = arrayOfMethod[j];
        if (!paramString.equals(localMethod.getName()));
      }
      while (true)
      {
        if (localMethod != null)
        {
          localMethod.setAccessible(true);
          localMethod.invoke(paramObject, paramArrayOfObject);
          localMethod.setAccessible(false);
        }
        return;
        j++;
        break;
        localMethod = null;
      }
    }
    catch (Exception localException)
    {
      new Object[] { paramString };
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fn
 * JD-Core Version:    0.6.2
 */