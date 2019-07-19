package org.objenesis.instantiator.basic;

import java.lang.reflect.Constructor;

public class AccessibleInstantiator<T> extends ConstructorInstantiator<T>
{
  public AccessibleInstantiator(Class<T> paramClass)
  {
    super(paramClass);
    if (this.constructor != null)
      this.constructor.setAccessible(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.basic.AccessibleInstantiator
 * JD-Core Version:    0.6.2
 */