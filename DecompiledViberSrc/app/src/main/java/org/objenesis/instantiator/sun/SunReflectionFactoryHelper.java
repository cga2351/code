package org.objenesis.instantiator.sun;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

class SunReflectionFactoryHelper
{
  private static Object createReflectionFactory(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.getDeclaredMethod("getReflectionFactory", new Class[0]).invoke(null, new Object[0]);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ObjenesisException(localIllegalAccessException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ObjenesisException(localIllegalArgumentException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ObjenesisException(localInvocationTargetException);
    }
  }

  private static Method getNewConstructorForSerializationMethod(Class<?> paramClass)
  {
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("newConstructorForSerialization", new Class[] { Class.class, Constructor.class });
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
  }

  private static Class<?> getReflectionFactoryClass()
  {
    try
    {
      Class localClass = Class.forName("sun.reflect.ReflectionFactory");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new ObjenesisException(localClassNotFoundException);
    }
  }

  public static <T> Constructor<T> newConstructorForSerialization(Class<T> paramClass, Constructor<?> paramConstructor)
  {
    Class localClass = getReflectionFactoryClass();
    Object localObject = createReflectionFactory(localClass);
    Method localMethod = getNewConstructorForSerializationMethod(localClass);
    try
    {
      Constructor localConstructor = (Constructor)localMethod.invoke(localObject, new Object[] { paramClass, paramConstructor });
      return localConstructor;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ObjenesisException(localIllegalArgumentException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ObjenesisException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ObjenesisException(localInvocationTargetException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.sun.SunReflectionFactoryHelper
 * JD-Core Version:    0.6.2
 */