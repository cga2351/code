package org.objenesis;

import org.objenesis.instantiator.ObjectInstantiator;

public abstract interface Objenesis
{
  public abstract <T> ObjectInstantiator<T> getInstantiatorOf(Class<T> paramClass);

  public abstract <T> T newInstance(Class<T> paramClass);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.Objenesis
 * JD-Core Version:    0.6.2
 */