package org.simpleframework.xml.transform;

import java.lang.reflect.Constructor;
import java.util.Date;

class DateFactory<T extends Date>
{
  private final Constructor<T> factory;

  public DateFactory(Class<T> paramClass)
    throws Exception
  {
    this(paramClass, arrayOfClass);
  }

  public DateFactory(Class<T> paramClass, Class[] paramArrayOfClass)
    throws Exception
  {
    this.factory = paramClass.getDeclaredConstructor(paramArrayOfClass);
  }

  public T getInstance(Object[] paramArrayOfObject)
    throws Exception
  {
    return (Date)this.factory.newInstance(paramArrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DateFactory
 * JD-Core Version:    0.6.2
 */