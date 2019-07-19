package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class Registry
{
  private final RegistryBinder binder = new RegistryBinder();
  private final Cache<Converter> cache = new ConcurrentCache();

  private Converter create(Class paramClass)
    throws Exception
  {
    Converter localConverter = this.binder.lookup(paramClass);
    if (localConverter != null)
      this.cache.cache(paramClass, localConverter);
    return localConverter;
  }

  public Registry bind(Class paramClass1, Class paramClass2)
    throws Exception
  {
    if (paramClass1 != null)
      this.binder.bind(paramClass1, paramClass2);
    return this;
  }

  public Registry bind(Class paramClass, Converter paramConverter)
    throws Exception
  {
    if (paramClass != null)
      this.cache.cache(paramClass, paramConverter);
    return this;
  }

  public Converter lookup(Class paramClass)
    throws Exception
  {
    Converter localConverter = (Converter)this.cache.fetch(paramClass);
    if (localConverter == null)
      localConverter = create(paramClass);
    return localConverter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.Registry
 * JD-Core Version:    0.6.2
 */