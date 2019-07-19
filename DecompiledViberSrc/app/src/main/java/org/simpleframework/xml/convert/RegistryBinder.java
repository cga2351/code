package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class RegistryBinder
{
  private final Cache<Class> cache = new ConcurrentCache();
  private final ConverterFactory factory = new ConverterFactory();

  private Converter create(Class paramClass)
    throws Exception
  {
    return this.factory.getInstance(paramClass);
  }

  public void bind(Class paramClass1, Class paramClass2)
    throws Exception
  {
    this.cache.cache(paramClass1, paramClass2);
  }

  public Converter lookup(Class paramClass)
    throws Exception
  {
    Class localClass = (Class)this.cache.fetch(paramClass);
    if (localClass != null)
      return create(localClass);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.RegistryBinder
 * JD-Core Version:    0.6.2
 */