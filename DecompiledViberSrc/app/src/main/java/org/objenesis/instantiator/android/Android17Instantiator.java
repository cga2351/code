package org.objenesis.instantiator.android;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class Android17Instantiator<T>
  implements ObjectInstantiator<T>
{
  private final Method newInstanceMethod;
  private final Integer objectConstructorId;
  private final Class<T> type;

  public Android17Instantiator(Class<T> paramClass)
  {
    this.type = paramClass;
    this.newInstanceMethod = getNewInstanceMethod();
    this.objectConstructorId = findConstructorIdForJavaLangObjectConstructor();
  }

  private static Integer findConstructorIdForJavaLangObjectConstructor()
  {
    try
    {
      Method localMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
      localMethod.setAccessible(true);
      Integer localInteger = (Integer)localMethod.invoke(null, new Object[] { Object.class });
      return localInteger;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw new ObjenesisException(localRuntimeException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
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

  private static Method getNewInstanceMethod()
  {
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Class.class;
      arrayOfClass[1] = Integer.TYPE;
      Method localMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrayOfClass);
      localMethod.setAccessible(true);
      return localMethod;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw new ObjenesisException(localRuntimeException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
  }

  public T newInstance()
  {
    try
    {
      Class localClass = this.type;
      Method localMethod = this.newInstanceMethod;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.type;
      arrayOfObject[1] = this.objectConstructorId;
      Object localObject = localClass.cast(localMethod.invoke(null, arrayOfObject));
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.android.Android17Instantiator
 * JD-Core Version:    0.6.2
 */