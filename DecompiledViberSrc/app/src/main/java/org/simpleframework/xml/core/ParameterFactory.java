package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

class ParameterFactory
{
  private final Format format;

  public ParameterFactory(Support paramSupport)
  {
    this.format = paramSupport.getFormat();
  }

  private ParameterBuilder getBuilder(Annotation paramAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof Element))
      return new ParameterBuilder(ElementParameter.class, Element.class);
    if ((paramAnnotation instanceof ElementList))
      return new ParameterBuilder(ElementListParameter.class, ElementList.class);
    if ((paramAnnotation instanceof ElementArray))
      return new ParameterBuilder(ElementArrayParameter.class, ElementArray.class);
    if ((paramAnnotation instanceof ElementMapUnion))
      return new ParameterBuilder(ElementMapUnionParameter.class, ElementMapUnion.class, ElementMap.class);
    if ((paramAnnotation instanceof ElementListUnion))
      return new ParameterBuilder(ElementListUnionParameter.class, ElementListUnion.class, ElementList.class);
    if ((paramAnnotation instanceof ElementUnion))
      return new ParameterBuilder(ElementUnionParameter.class, ElementUnion.class, Element.class);
    if ((paramAnnotation instanceof ElementMap))
      return new ParameterBuilder(ElementMapParameter.class, ElementMap.class);
    if ((paramAnnotation instanceof Attribute))
      return new ParameterBuilder(AttributeParameter.class, Attribute.class);
    if ((paramAnnotation instanceof Text))
      return new ParameterBuilder(TextParameter.class, Text.class);
    throw new PersistenceException("Annotation %s not supported", new Object[] { paramAnnotation });
  }

  private Constructor getConstructor(Annotation paramAnnotation)
    throws Exception
  {
    Constructor localConstructor = getBuilder(paramAnnotation).getConstructor();
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    return localConstructor;
  }

  public Parameter getInstance(Constructor paramConstructor, Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    return getInstance(paramConstructor, paramAnnotation, null, paramInt);
  }

  public Parameter getInstance(Constructor paramConstructor, Annotation paramAnnotation1, Annotation paramAnnotation2, int paramInt)
    throws Exception
  {
    Constructor localConstructor = getConstructor(paramAnnotation1);
    if (paramAnnotation2 != null)
    {
      Object[] arrayOfObject2 = new Object[5];
      arrayOfObject2[0] = paramConstructor;
      arrayOfObject2[1] = paramAnnotation1;
      arrayOfObject2[2] = paramAnnotation2;
      arrayOfObject2[3] = this.format;
      arrayOfObject2[4] = Integer.valueOf(paramInt);
      return (Parameter)localConstructor.newInstance(arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = paramConstructor;
    arrayOfObject1[1] = paramAnnotation1;
    arrayOfObject1[2] = this.format;
    arrayOfObject1[3] = Integer.valueOf(paramInt);
    return (Parameter)localConstructor.newInstance(arrayOfObject1);
  }

  private static class ParameterBuilder
  {
    private final Class entry;
    private final Class label;
    private final Class type;

    public ParameterBuilder(Class paramClass1, Class paramClass2)
    {
      this(paramClass1, paramClass2, null);
    }

    public ParameterBuilder(Class paramClass1, Class paramClass2, Class paramClass3)
    {
      this.label = paramClass2;
      this.entry = paramClass3;
      this.type = paramClass1;
    }

    private Constructor getConstructor(Class[] paramArrayOfClass)
      throws Exception
    {
      return this.type.getConstructor(paramArrayOfClass);
    }

    public Constructor getConstructor()
      throws Exception
    {
      if (this.entry != null)
        return getConstructor(this.label, this.entry);
      return getConstructor(this.label);
    }

    public Constructor getConstructor(Class paramClass)
      throws Exception
    {
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Constructor.class;
      arrayOfClass[1] = paramClass;
      arrayOfClass[2] = Format.class;
      arrayOfClass[3] = Integer.TYPE;
      return getConstructor(arrayOfClass);
    }

    public Constructor getConstructor(Class paramClass1, Class paramClass2)
      throws Exception
    {
      Class[] arrayOfClass = new Class[5];
      arrayOfClass[0] = Constructor.class;
      arrayOfClass[1] = paramClass1;
      arrayOfClass[2] = paramClass2;
      arrayOfClass[3] = Format.class;
      arrayOfClass[4] = Integer.TYPE;
      return getConstructor(arrayOfClass);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ParameterFactory
 * JD-Core Version:    0.6.2
 */