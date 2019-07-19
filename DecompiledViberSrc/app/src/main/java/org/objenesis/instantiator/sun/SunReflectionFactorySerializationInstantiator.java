package org.objenesis.instantiator.sun;

import java.io.NotSerializableException;
import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.SerializationInstantiatorHelper;

public class SunReflectionFactorySerializationInstantiator<T>
  implements ObjectInstantiator<T>
{
  private final Constructor<T> mungedConstructor;

  public SunReflectionFactorySerializationInstantiator(Class<T> paramClass)
  {
    Class localClass = SerializationInstantiatorHelper.getNonSerializableSuperClass(paramClass);
    try
    {
      Constructor localConstructor = localClass.getConstructor((Class[])null);
      this.mungedConstructor = SunReflectionFactoryHelper.newConstructorForSerialization(paramClass, localConstructor);
      this.mungedConstructor.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    throw new ObjenesisException(new NotSerializableException(paramClass + " has no suitable superclass constructor"));
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
 * Qualified Name:     org.objenesis.instantiator.sun.SunReflectionFactorySerializationInstantiator
 * JD-Core Version:    0.6.2
 */