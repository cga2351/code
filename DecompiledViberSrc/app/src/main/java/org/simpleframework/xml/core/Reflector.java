package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

final class Reflector
{
  private static Class getArrayClass(Type paramType)
  {
    Class localClass = getClass(((GenericArrayType)paramType).getGenericComponentType());
    if (localClass != null)
      return Array.newInstance(localClass, 0).getClass();
    return null;
  }

  private static Class getClass(ParameterizedType paramParameterizedType)
  {
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    if (arrayOfType.length > 0)
      return getClass(arrayOfType[0]);
    return null;
  }

  private static Class getClass(Type paramType)
  {
    if ((paramType instanceof Class))
      return (Class)paramType;
    return getGenericClass(paramType);
  }

  private static Class[] getClasses(ParameterizedType paramParameterizedType)
  {
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    Class[] arrayOfClass = new Class[arrayOfType.length];
    for (int i = 0; i < arrayOfType.length; i++)
      arrayOfClass[i] = getClass(arrayOfType[i]);
    return arrayOfClass;
  }

  public static Class getDependent(Field paramField)
  {
    ParameterizedType localParameterizedType = getType(paramField);
    if (localParameterizedType != null)
      return getClass(localParameterizedType);
    return Object.class;
  }

  public static Class[] getDependents(Field paramField)
  {
    ParameterizedType localParameterizedType = getType(paramField);
    if (localParameterizedType != null)
      return getClasses(localParameterizedType);
    return new Class[0];
  }

  private static Class getGenericClass(Type paramType)
  {
    if ((paramType instanceof GenericArrayType))
      return getArrayClass(paramType);
    return Object.class;
  }

  public static String getName(String paramString)
  {
    if (paramString.length() > 0)
    {
      char[] arrayOfChar = paramString.toCharArray();
      char c = arrayOfChar[0];
      if (!isAcronym(arrayOfChar))
        arrayOfChar[0] = toLowerCase(c);
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }

  public static Class getParameterDependent(Constructor paramConstructor, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramConstructor, paramInt);
    if (localParameterizedType != null)
      return getClass(localParameterizedType);
    return Object.class;
  }

  public static Class getParameterDependent(Method paramMethod, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramMethod, paramInt);
    if (localParameterizedType != null)
      return getClass(localParameterizedType);
    return Object.class;
  }

  public static Class[] getParameterDependents(Constructor paramConstructor, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramConstructor, paramInt);
    if (localParameterizedType != null)
      return getClasses(localParameterizedType);
    return new Class[0];
  }

  public static Class[] getParameterDependents(Method paramMethod, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramMethod, paramInt);
    if (localParameterizedType != null)
      return getClasses(localParameterizedType);
    return new Class[0];
  }

  private static ParameterizedType getParameterType(Constructor paramConstructor, int paramInt)
  {
    Type[] arrayOfType = paramConstructor.getGenericParameterTypes();
    if (arrayOfType.length > paramInt)
    {
      Type localType = arrayOfType[paramInt];
      if ((localType instanceof ParameterizedType))
        return (ParameterizedType)localType;
    }
    return null;
  }

  private static ParameterizedType getParameterType(Method paramMethod, int paramInt)
  {
    Type[] arrayOfType = paramMethod.getGenericParameterTypes();
    if (arrayOfType.length > paramInt)
    {
      Type localType = arrayOfType[paramInt];
      if ((localType instanceof ParameterizedType))
        return (ParameterizedType)localType;
    }
    return null;
  }

  public static Class getReturnDependent(Method paramMethod)
  {
    ParameterizedType localParameterizedType = getReturnType(paramMethod);
    if (localParameterizedType != null)
      return getClass(localParameterizedType);
    return Object.class;
  }

  public static Class[] getReturnDependents(Method paramMethod)
  {
    ParameterizedType localParameterizedType = getReturnType(paramMethod);
    if (localParameterizedType != null)
      return getClasses(localParameterizedType);
    return new Class[0];
  }

  private static ParameterizedType getReturnType(Method paramMethod)
  {
    Type localType = paramMethod.getGenericReturnType();
    if ((localType instanceof ParameterizedType))
      return (ParameterizedType)localType;
    return null;
  }

  private static ParameterizedType getType(Field paramField)
  {
    Type localType = paramField.getGenericType();
    if ((localType instanceof ParameterizedType))
      return (ParameterizedType)localType;
    return null;
  }

  private static boolean isAcronym(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar.length < 2);
    while (!isUpperCase(paramArrayOfChar[0]))
      return false;
    return isUpperCase(paramArrayOfChar[1]);
  }

  private static boolean isUpperCase(char paramChar)
  {
    return Character.isUpperCase(paramChar);
  }

  private static char toLowerCase(char paramChar)
  {
    return Character.toLowerCase(paramChar);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Reflector
 * JD-Core Version:    0.6.2
 */