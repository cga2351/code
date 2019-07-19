package org.simpleframework.xml.convert;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class ConverterFactory
{
  private final Cache<Converter> cache = new ConcurrentCache();

  private Constructor getConstructor(Class paramClass)
    throws Exception
  {
    Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    return localConstructor;
  }

  private Converter getConverter(Class paramClass)
    throws Exception
  {
    Constructor localConstructor = getConstructor(paramClass);
    if (localConstructor == null)
      throw new ConvertException("No default constructor for %s", new Object[] { paramClass });
    return getConverter(paramClass, localConstructor);
  }

  private Converter getConverter(Class paramClass, Constructor paramConstructor)
    throws Exception
  {
    Converter localConverter = (Converter)paramConstructor.newInstance(new Object[0]);
    if (localConverter != null)
      this.cache.cache(paramClass, localConverter);
    return localConverter;
  }

  public Converter getInstance(Class paramClass)
    throws Exception
  {
    Converter localConverter = (Converter)this.cache.fetch(paramClass);
    if (localConverter == null)
      localConverter = getConverter(paramClass);
    return localConverter;
  }

  public Converter getInstance(Convert paramConvert)
    throws Exception
  {
    Class localClass = paramConvert.value();
    if (localClass.isInterface())
      throw new ConvertException("Can not instantiate %s", new Object[] { localClass });
    return getInstance(localClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.ConverterFactory
 * JD-Core Version:    0.6.2
 */