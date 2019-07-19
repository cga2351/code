package org.objenesis.instantiator.basic;

import org.objenesis.instantiator.ObjectInstantiator;

public class NullInstantiator<T>
  implements ObjectInstantiator<T>
{
  public NullInstantiator(Class<T> paramClass)
  {
  }

  public T newInstance()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.basic.NullInstantiator
 * JD-Core Version:    0.6.2
 */