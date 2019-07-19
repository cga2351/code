package org.objenesis.instantiator.basic;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class FailingInstantiator<T>
  implements ObjectInstantiator<T>
{
  public FailingInstantiator(Class<T> paramClass)
  {
  }

  public T newInstance()
  {
    throw new ObjenesisException("Always failing");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.basic.FailingInstantiator
 * JD-Core Version:    0.6.2
 */