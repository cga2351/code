package org.objenesis;

import java.io.Serializable;
import org.objenesis.instantiator.ObjectInstantiator;

public final class ObjenesisHelper
{
  private static final Objenesis OBJENESIS_SERIALIZER = new ObjenesisSerializer();
  private static final Objenesis OBJENESIS_STD = new ObjenesisStd();

  public static <T> ObjectInstantiator<T> getInstantiatorOf(Class<T> paramClass)
  {
    return OBJENESIS_STD.getInstantiatorOf(paramClass);
  }

  public static <T extends Serializable> ObjectInstantiator<T> getSerializableObjectInstantiatorOf(Class<T> paramClass)
  {
    return OBJENESIS_SERIALIZER.getInstantiatorOf(paramClass);
  }

  public static <T> T newInstance(Class<T> paramClass)
  {
    return OBJENESIS_STD.newInstance(paramClass);
  }

  public static <T extends Serializable> T newSerializableInstance(Class<T> paramClass)
  {
    return (Serializable)OBJENESIS_SERIALIZER.newInstance(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.ObjenesisHelper
 * JD-Core Version:    0.6.2
 */