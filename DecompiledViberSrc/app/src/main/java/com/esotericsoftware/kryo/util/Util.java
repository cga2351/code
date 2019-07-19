package com.esotericsoftware.kryo.util;

import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Method;

public class Util
{
  public static boolean isAndroid;

  static
  {
    try
    {
      Class.forName("android.os.Process");
      isAndroid = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static String className(Class paramClass)
  {
    if (paramClass.isArray())
    {
      Class localClass = getElementClass(paramClass);
      StringBuilder localStringBuilder = new StringBuilder(16);
      int i = 0;
      int j = getDimensionCount(paramClass);
      while (i < j)
      {
        localStringBuilder.append("[]");
        i++;
      }
      return className(localClass) + localStringBuilder;
    }
    if ((paramClass.isPrimitive()) || (paramClass == Object.class) || (paramClass == Boolean.class) || (paramClass == Byte.class) || (paramClass == Character.class) || (paramClass == Short.class) || (paramClass == Integer.class) || (paramClass == Long.class) || (paramClass == Float.class) || (paramClass == Double.class) || (paramClass == String.class))
      return paramClass.getSimpleName();
    return paramClass.getName();
  }

  public static int getDimensionCount(Class paramClass)
  {
    int i = 0;
    for (Class localClass = paramClass.getComponentType(); localClass != null; localClass = localClass.getComponentType())
      i++;
    return i;
  }

  public static Class getElementClass(Class paramClass)
  {
    while (paramClass.getComponentType() != null)
      paramClass = paramClass.getComponentType();
    return paramClass;
  }

  public static Class getPrimitiveClass(Class paramClass)
  {
    if (paramClass == Integer.class)
      paramClass = Integer.TYPE;
    do
    {
      return paramClass;
      if (paramClass == Float.class)
        return Float.TYPE;
      if (paramClass == Boolean.class)
        return Boolean.TYPE;
      if (paramClass == Long.class)
        return Long.TYPE;
      if (paramClass == Byte.class)
        return Byte.TYPE;
      if (paramClass == Character.class)
        return Character.TYPE;
      if (paramClass == Short.class)
        return Short.TYPE;
      if (paramClass == Double.class)
        return Double.TYPE;
    }
    while (paramClass != Void.class);
    return Void.TYPE;
  }

  public static Class getWrapperClass(Class paramClass)
  {
    if (paramClass == Integer.TYPE)
      return Integer.class;
    if (paramClass == Float.TYPE)
      return Float.class;
    if (paramClass == Boolean.TYPE)
      return Boolean.class;
    if (paramClass == Long.TYPE)
      return Long.class;
    if (paramClass == Byte.TYPE)
      return Byte.class;
    if (paramClass == Character.TYPE)
      return Character.class;
    if (paramClass == Short.TYPE)
      return Short.class;
    if (paramClass == Double.TYPE)
      return Double.class;
    return Void.class;
  }

  public static boolean isWrapperClass(Class paramClass)
  {
    return (paramClass == Integer.class) || (paramClass == Float.class) || (paramClass == Boolean.class) || (paramClass == Long.class) || (paramClass == Byte.class) || (paramClass == Character.class) || (paramClass == Short.class) || (paramClass == Double.class);
  }

  public static void log(String paramString, Object paramObject)
  {
    if (paramObject == null)
      if (Log.TRACE)
        Log.trace("kryo", paramString + ": null");
    do
    {
      return;
      Class localClass = paramObject.getClass();
      if ((!localClass.isPrimitive()) && (localClass != Boolean.class) && (localClass != Byte.class) && (localClass != Character.class) && (localClass != Short.class) && (localClass != Integer.class) && (localClass != Long.class) && (localClass != Float.class) && (localClass != Double.class) && (localClass != String.class))
        break;
    }
    while (!Log.TRACE);
    Log.trace("kryo", paramString + ": " + string(paramObject));
    return;
    Log.debug("kryo", paramString + ": " + string(paramObject));
  }

  public static String string(Object paramObject)
  {
    if (paramObject == null)
      return "null";
    Class localClass = paramObject.getClass();
    if (localClass.isArray())
      return className(localClass);
    try
    {
      if (localClass.getMethod("toString", new Class[0]).getDeclaringClass() == Object.class)
      {
        if (Log.TRACE)
          return className(localClass);
        String str = localClass.getSimpleName();
        return str;
      }
    }
    catch (Exception localException)
    {
    }
    return String.valueOf(paramObject);
  }

  public static int swapInt(int paramInt)
  {
    return (paramInt & 0xFF) << 24 | (0xFF00 & paramInt) << 8 | (0xFF0000 & paramInt) >> 8 | 0xFF & paramInt >> 24;
  }

  public static long swapLong(long paramLong)
  {
    return (0xFF & paramLong >> 0) << 56 | (0xFF & paramLong >> 8) << 48 | (0xFF & paramLong >> 16) << 40 | (0xFF & paramLong >> 24) << 32 | (0xFF & paramLong >> 32) << 24 | (0xFF & paramLong >> 40) << 16 | (0xFF & paramLong >> 48) << 8 | (0xFF & paramLong >> 56) << 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.util.Util
 * JD-Core Version:    0.6.2
 */