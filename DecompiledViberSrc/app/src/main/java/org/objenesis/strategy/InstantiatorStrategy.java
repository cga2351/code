package org.objenesis.strategy;

import org.objenesis.instantiator.ObjectInstantiator;

public abstract interface InstantiatorStrategy
{
  public abstract <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> paramClass);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.strategy.InstantiatorStrategy
 * JD-Core Version:    0.6.2
 */