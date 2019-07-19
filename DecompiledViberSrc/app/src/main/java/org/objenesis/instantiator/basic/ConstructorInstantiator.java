package org.objenesis.instantiator.basic;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class ConstructorInstantiator<T>
  implements ObjectInstantiator<T>
{
  protected Constructor<T> constructor;

  public ConstructorInstantiator(Class<T> paramClass)
  {
    try
    {
      this.constructor = paramClass.getDeclaredConstructor((Class[])null);
      return;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }

  public T newInstance()
  {
    try
    {
      Object localObject = this.constructor.newInstance((Object[])null);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.basic.ConstructorInstantiator
 * JD-Core Version:    0.6.2
 */