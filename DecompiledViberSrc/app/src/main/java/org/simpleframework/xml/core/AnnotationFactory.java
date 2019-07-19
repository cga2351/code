package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Verbosity;

class AnnotationFactory
{
  private final Format format;
  private final boolean required;

  public AnnotationFactory(Detail paramDetail, Support paramSupport)
  {
    this.required = paramDetail.isRequired();
    this.format = paramSupport.getFormat();
  }

  private ClassLoader getClassLoader()
    throws Exception
  {
    return AnnotationFactory.class.getClassLoader();
  }

  private Annotation getInstance(Class paramClass)
    throws Exception
  {
    ClassLoader localClassLoader = getClassLoader();
    Class localClass = paramClass.getComponentType();
    if (paramClass.isArray())
    {
      if (isPrimitive(localClass))
        return getInstance(localClassLoader, Element.class);
      return getInstance(localClassLoader, ElementArray.class);
    }
    if ((isPrimitive(paramClass)) && (isAttribute()))
      return getInstance(localClassLoader, Attribute.class);
    return getInstance(localClassLoader, Element.class);
  }

  private Annotation getInstance(ClassLoader paramClassLoader, Class paramClass)
    throws Exception
  {
    return getInstance(paramClassLoader, paramClass, false);
  }

  private Annotation getInstance(ClassLoader paramClassLoader, Class paramClass, boolean paramBoolean)
    throws Exception
  {
    AnnotationHandler localAnnotationHandler = new AnnotationHandler(paramClass, this.required, paramBoolean);
    return (Annotation)Proxy.newProxyInstance(paramClassLoader, new Class[] { paramClass }, localAnnotationHandler);
  }

  private boolean isAttribute()
  {
    Verbosity localVerbosity1 = this.format.getVerbosity();
    boolean bool = false;
    if (localVerbosity1 != null)
    {
      Verbosity localVerbosity2 = Verbosity.LOW;
      bool = false;
      if (localVerbosity1 == localVerbosity2)
        bool = true;
    }
    return bool;
  }

  private boolean isPrimitive(Class paramClass)
  {
    if (Number.class.isAssignableFrom(paramClass));
    while ((paramClass == Boolean.class) || (paramClass == Character.class))
      return true;
    return paramClass.isPrimitive();
  }

  private boolean isPrimitiveKey(Class[] paramArrayOfClass)
  {
    if ((paramArrayOfClass != null) && (paramArrayOfClass.length > 0))
    {
      Class localClass1 = paramArrayOfClass[0].getSuperclass();
      Class localClass2 = paramArrayOfClass[0];
      if (localClass1 != null)
      {
        if (localClass1.isEnum());
        while (localClass2.isEnum())
          return true;
      }
      return isPrimitive(localClass2);
    }
    return false;
  }

  public Annotation getInstance(Class paramClass, Class[] paramArrayOfClass)
    throws Exception
  {
    ClassLoader localClassLoader = getClassLoader();
    if (Map.class.isAssignableFrom(paramClass))
    {
      if ((isPrimitiveKey(paramArrayOfClass)) && (isAttribute()))
        return getInstance(localClassLoader, ElementMap.class, true);
      return getInstance(localClassLoader, ElementMap.class);
    }
    if (Collection.class.isAssignableFrom(paramClass))
      return getInstance(localClassLoader, ElementList.class);
    return getInstance(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.AnnotationFactory
 * JD-Core Version:    0.6.2
 */