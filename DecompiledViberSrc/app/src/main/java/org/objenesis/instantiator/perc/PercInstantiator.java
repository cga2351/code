package org.objenesis.instantiator.perc;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class PercInstantiator<T>
  implements ObjectInstantiator<T>
{
  private final Method newInstanceMethod;
  private final Object[] typeArgs;

  public PercInstantiator(Class<T> paramClass)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = null;
    arrayOfObject[1] = Boolean.FALSE;
    this.typeArgs = arrayOfObject;
    this.typeArgs[0] = paramClass;
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Class.class;
      arrayOfClass[1] = Boolean.TYPE;
      this.newInstanceMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", arrayOfClass);
      this.newInstanceMethod.setAccessible(true);
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
      Object localObject = this.newInstanceMethod.invoke(null, this.typeArgs);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.perc.PercInstantiator
 * JD-Core Version:    0.6.2
 */