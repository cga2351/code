package org.objenesis;

import java.util.concurrent.ConcurrentHashMap;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

public class ObjenesisBase
  implements Objenesis
{
  protected ConcurrentHashMap<String, ObjectInstantiator<?>> cache;
  protected final InstantiatorStrategy strategy;

  public ObjenesisBase(InstantiatorStrategy paramInstantiatorStrategy)
  {
    this(paramInstantiatorStrategy, true);
  }

  public ObjenesisBase(InstantiatorStrategy paramInstantiatorStrategy, boolean paramBoolean)
  {
    if (paramInstantiatorStrategy == null)
      throw new IllegalArgumentException("A strategy can't be null");
    this.strategy = paramInstantiatorStrategy;
    if (paramBoolean);
    for (ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(); ; localConcurrentHashMap = null)
    {
      this.cache = localConcurrentHashMap;
      return;
    }
  }

  public <T> ObjectInstantiator<T> getInstantiatorOf(Class<T> paramClass)
  {
    ObjectInstantiator localObjectInstantiator1;
    if (this.cache == null)
      localObjectInstantiator1 = this.strategy.newInstantiatorOf(paramClass);
    ObjectInstantiator localObjectInstantiator2;
    do
    {
      do
      {
        return localObjectInstantiator1;
        localObjectInstantiator1 = (ObjectInstantiator)this.cache.get(paramClass.getName());
      }
      while (localObjectInstantiator1 != null);
      localObjectInstantiator2 = this.strategy.newInstantiatorOf(paramClass);
      localObjectInstantiator1 = (ObjectInstantiator)this.cache.putIfAbsent(paramClass.getName(), localObjectInstantiator2);
    }
    while (localObjectInstantiator1 != null);
    return localObjectInstantiator2;
  }

  public <T> T newInstance(Class<T> paramClass)
  {
    return getInstantiatorOf(paramClass).newInstance();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(" using ").append(this.strategy.getClass().getName());
    if (this.cache == null);
    for (String str = " without"; ; str = " with")
      return str + " caching";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.ObjenesisBase
 * JD-Core Version:    0.6.2
 */