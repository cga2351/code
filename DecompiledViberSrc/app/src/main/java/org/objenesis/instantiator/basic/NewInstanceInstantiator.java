package org.objenesis.instantiator.basic;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class NewInstanceInstantiator<T>
  implements ObjectInstantiator<T>
{
  private final Class<T> type;

  public NewInstanceInstantiator(Class<T> paramClass)
  {
    this.type = paramClass;
  }

  public T newInstance()
  {
    try
    {
      Object localObject = this.type.newInstance();
      return localObject;
    }
    catch (Exception localException)
    {
      throw new ObjenesisException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.basic.NewInstanceInstantiator
 * JD-Core Version:    0.6.2
 */