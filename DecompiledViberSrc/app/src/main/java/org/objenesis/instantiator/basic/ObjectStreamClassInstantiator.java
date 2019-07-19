package org.objenesis.instantiator.basic;

import java.io.ObjectStreamClass;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class ObjectStreamClassInstantiator<T>
  implements ObjectInstantiator<T>
{
  private static Method newInstanceMethod;
  private final ObjectStreamClass objStreamClass;

  public ObjectStreamClassInstantiator(Class<T> paramClass)
  {
    initialize();
    this.objStreamClass = ObjectStreamClass.lookup(paramClass);
  }

  private static void initialize()
  {
    if (newInstanceMethod == null);
    try
    {
      newInstanceMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[0]);
      newInstanceMethod.setAccessible(true);
      return;
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
      Object localObject = newInstanceMethod.invoke(this.objStreamClass, new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.basic.ObjectStreamClassInstantiator
 * JD-Core Version:    0.6.2
 */