package org.objenesis.instantiator.sun;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class SunReflectionFactoryInstantiator<T>
  implements ObjectInstantiator<T>
{
  private final Constructor<T> mungedConstructor;

  public SunReflectionFactoryInstantiator(Class<T> paramClass)
  {
    this.mungedConstructor = SunReflectionFactoryHelper.newConstructorForSerialization(paramClass, getJavaLangObjectConstructor());
    this.mungedConstructor.setAccessible(true);
  }

  private static Constructor<Object> getJavaLangObjectConstructor()
  {
    try
    {
      Constructor localConstructor = Object.class.getConstructor((Class[])null);
      return localConstructor;
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
      Object localObject = this.mungedConstructor.newInstance((Object[])null);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.sun.SunReflectionFactoryInstantiator
 * JD-Core Version:    0.6.2
 */