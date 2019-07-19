package org.objenesis.instantiator;

import java.io.Serializable;

public class SerializationInstantiatorHelper
{
  public static <T> Class<? super T> getNonSerializableSuperClass(Class<T> paramClass)
  {
    while (Serializable.class.isAssignableFrom(paramClass))
    {
      paramClass = paramClass.getSuperclass();
      if (paramClass == null)
        throw new Error("Bad class hierarchy: No non-serializable parents");
    }
    return paramClass;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.SerializationInstantiatorHelper
 * JD-Core Version:    0.6.2
 */