package org.objenesis.strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class SingleInstantiatorStrategy
  implements InstantiatorStrategy
{
  private Constructor<?> constructor;

  public <T extends ObjectInstantiator<?>> SingleInstantiatorStrategy(Class<T> paramClass)
  {
    try
    {
      this.constructor = paramClass.getConstructor(new Class[] { Class.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
  }

  public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> paramClass)
  {
    try
    {
      ObjectInstantiator localObjectInstantiator = (ObjectInstantiator)this.constructor.newInstance(new Object[] { paramClass });
      return localObjectInstantiator;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new ObjenesisException(localInstantiationException);
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
 * Qualified Name:     org.objenesis.strategy.SingleInstantiatorStrategy
 * JD-Core Version:    0.6.2
 */