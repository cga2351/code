package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;

class ConverterScanner
{
  private final ScannerBuilder builder = new ScannerBuilder();
  private final ConverterFactory factory = new ConverterFactory();

  private <T extends Annotation> T getAnnotation(Class<?> paramClass, Class<T> paramClass1)
  {
    return this.builder.build(paramClass).scan(paramClass1);
  }

  private Convert getConvert(Class paramClass)
    throws Exception
  {
    Convert localConvert = (Convert)getAnnotation(paramClass, Convert.class);
    if ((localConvert != null) && ((Root)getAnnotation(paramClass, Root.class) == null))
      throw new ConvertException("Root annotation required for %s", new Object[] { paramClass });
    return localConvert;
  }

  private Convert getConvert(Type paramType)
    throws Exception
  {
    Convert localConvert = (Convert)paramType.getAnnotation(Convert.class);
    if ((localConvert != null) && ((Element)paramType.getAnnotation(Element.class) == null))
      throw new ConvertException("Element annotation required for %s", new Object[] { paramType });
    return localConvert;
  }

  private Convert getConvert(Type paramType, Class paramClass)
    throws Exception
  {
    Convert localConvert = getConvert(paramType);
    if (localConvert == null)
      localConvert = getConvert(paramClass);
    return localConvert;
  }

  private Class getType(Type paramType, Object paramObject)
  {
    Class localClass = paramType.getType();
    if (paramObject != null)
      localClass = paramObject.getClass();
    return localClass;
  }

  private Class getType(Type paramType, Value paramValue)
  {
    Class localClass = paramType.getType();
    if (paramValue != null)
      localClass = paramValue.getType();
    return localClass;
  }

  public Converter getConverter(Type paramType, Object paramObject)
    throws Exception
  {
    Convert localConvert = getConvert(paramType, getType(paramType, paramObject));
    if (localConvert != null)
      return this.factory.getInstance(localConvert);
    return null;
  }

  public Converter getConverter(Type paramType, Value paramValue)
    throws Exception
  {
    Convert localConvert = getConvert(paramType, getType(paramType, paramValue));
    if (localConvert != null)
      return this.factory.getInstance(localConvert);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.ConverterScanner
 * JD-Core Version:    0.6.2
 */