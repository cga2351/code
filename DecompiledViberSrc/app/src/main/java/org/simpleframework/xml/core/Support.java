package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;
import org.simpleframework.xml.transform.Transformer;

class Support
  implements Filter
{
  private final DetailExtractor defaults = new DetailExtractor(this, DefaultType.FIELD);
  private final DetailExtractor details;
  private final Filter filter;
  private final Format format;
  private final InstanceFactory instances;
  private final LabelExtractor labels;
  private final Matcher matcher;
  private final ScannerFactory scanners;
  private final Transformer transform;

  public Support()
  {
    this(new PlatformFilter());
  }

  public Support(Filter paramFilter)
  {
    this(paramFilter, new EmptyMatcher());
  }

  public Support(Filter paramFilter, Matcher paramMatcher)
  {
    this(paramFilter, paramMatcher, new Format());
  }

  public Support(Filter paramFilter, Matcher paramMatcher, Format paramFormat)
  {
    this.transform = new Transformer(paramMatcher);
    this.scanners = new ScannerFactory(this);
    this.details = new DetailExtractor(this);
    this.labels = new LabelExtractor(paramFormat);
    this.instances = new InstanceFactory();
    this.matcher = paramMatcher;
    this.filter = paramFilter;
    this.format = paramFormat;
  }

  private String getClassName(Class paramClass)
    throws Exception
  {
    if (paramClass.isArray())
      paramClass = paramClass.getComponentType();
    String str = paramClass.getSimpleName();
    if (paramClass.isPrimitive())
      return str;
    return Reflector.getName(str);
  }

  public static Class getPrimitive(Class paramClass)
  {
    if (paramClass == Double.TYPE)
      paramClass = Double.class;
    do
    {
      return paramClass;
      if (paramClass == Float.TYPE)
        return Float.class;
      if (paramClass == Integer.TYPE)
        return Integer.class;
      if (paramClass == Long.TYPE)
        return Long.class;
      if (paramClass == Boolean.TYPE)
        return Boolean.class;
      if (paramClass == Character.TYPE)
        return Character.class;
      if (paramClass == Short.TYPE)
        return Short.class;
    }
    while (paramClass != Byte.TYPE);
    return Byte.class;
  }

  public static boolean isAssignable(Class paramClass1, Class paramClass2)
  {
    if (paramClass1.isPrimitive())
      paramClass1 = getPrimitive(paramClass1);
    if (paramClass2.isPrimitive())
      paramClass2 = getPrimitive(paramClass2);
    return paramClass2.isAssignableFrom(paramClass1);
  }

  public static boolean isFloat(Class paramClass)
    throws Exception
  {
    if (paramClass == Double.class);
    while ((paramClass == Float.class) || (paramClass == Float.TYPE) || (paramClass == Double.TYPE))
      return true;
    return false;
  }

  public Detail getDetail(Class paramClass)
  {
    return getDetail(paramClass, null);
  }

  public Detail getDetail(Class paramClass, DefaultType paramDefaultType)
  {
    if (paramDefaultType != null)
      return this.defaults.getDetail(paramClass);
    return this.details.getDetail(paramClass);
  }

  public ContactList getFields(Class paramClass)
    throws Exception
  {
    return getFields(paramClass, null);
  }

  public ContactList getFields(Class paramClass, DefaultType paramDefaultType)
    throws Exception
  {
    if (paramDefaultType != null)
      return this.defaults.getFields(paramClass);
    return this.details.getFields(paramClass);
  }

  public Format getFormat()
  {
    return this.format;
  }

  public Instance getInstance(Class paramClass)
  {
    return this.instances.getInstance(paramClass);
  }

  public Instance getInstance(Value paramValue)
  {
    return this.instances.getInstance(paramValue);
  }

  public Label getLabel(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    return this.labels.getLabel(paramContact, paramAnnotation);
  }

  public List<Label> getLabels(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    return this.labels.getList(paramContact, paramAnnotation);
  }

  public ContactList getMethods(Class paramClass)
    throws Exception
  {
    return getMethods(paramClass, null);
  }

  public ContactList getMethods(Class paramClass, DefaultType paramDefaultType)
    throws Exception
  {
    if (paramDefaultType != null)
      return this.defaults.getMethods(paramClass);
    return this.details.getMethods(paramClass);
  }

  public String getName(Class paramClass)
    throws Exception
  {
    String str = getScanner(paramClass).getName();
    if (str != null)
      return str;
    return getClassName(paramClass);
  }

  public Scanner getScanner(Class paramClass)
    throws Exception
  {
    return this.scanners.getInstance(paramClass);
  }

  public Style getStyle()
  {
    return this.format.getStyle();
  }

  public Transform getTransform(Class paramClass)
    throws Exception
  {
    return this.matcher.match(paramClass);
  }

  public boolean isContainer(Class paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass));
    while (Map.class.isAssignableFrom(paramClass))
      return true;
    return paramClass.isArray();
  }

  public boolean isPrimitive(Class paramClass)
    throws Exception
  {
    if (paramClass == String.class);
    while ((paramClass == Float.class) || (paramClass == Double.class) || (paramClass == Long.class) || (paramClass == Integer.class) || (paramClass == Boolean.class) || (paramClass.isEnum()) || (paramClass.isPrimitive()))
      return true;
    return this.transform.valid(paramClass);
  }

  public Object read(String paramString, Class paramClass)
    throws Exception
  {
    return this.transform.read(paramString, paramClass);
  }

  public String replace(String paramString)
  {
    return this.filter.replace(paramString);
  }

  public boolean valid(Class paramClass)
    throws Exception
  {
    return this.transform.valid(paramClass);
  }

  public String write(Object paramObject, Class paramClass)
    throws Exception
  {
    return this.transform.write(paramObject, paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Support
 * JD-Core Version:    0.6.2
 */