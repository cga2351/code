package org.simpleframework.xml.util;

public abstract interface Cache<T>
{
  public abstract void cache(Object paramObject, T paramT);

  public abstract boolean contains(Object paramObject);

  public abstract T fetch(Object paramObject);

  public abstract boolean isEmpty();

  public abstract T take(Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.Cache
 * JD-Core Version:    0.6.2
 */