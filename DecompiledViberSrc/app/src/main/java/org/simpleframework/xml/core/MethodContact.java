package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class MethodContact
  implements Contact
{
  private MethodPart get;
  private Class item;
  private Class[] items;
  private Annotation label;
  private String name;
  private Class owner;
  private MethodPart set;
  private Class type;

  public MethodContact(MethodPart paramMethodPart)
  {
    this(paramMethodPart, null);
  }

  public MethodContact(MethodPart paramMethodPart1, MethodPart paramMethodPart2)
  {
    this.owner = paramMethodPart1.getDeclaringClass();
    this.label = paramMethodPart1.getAnnotation();
    this.items = paramMethodPart1.getDependents();
    this.item = paramMethodPart1.getDependent();
    this.type = paramMethodPart1.getType();
    this.name = paramMethodPart1.getName();
    this.set = paramMethodPart2;
    this.get = paramMethodPart1;
  }

  public Object get(Object paramObject)
    throws Exception
  {
    return this.get.getMethod().invoke(paramObject, new Object[0]);
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Annotation localAnnotation = this.get.getAnnotation(paramClass);
    if (paramClass == this.label.annotationType())
      localAnnotation = this.label;
    while ((localAnnotation != null) || (this.set == null))
      return localAnnotation;
    return this.set.getAnnotation(paramClass);
  }

  public Class getDeclaringClass()
  {
    return this.owner;
  }

  public Class getDependent()
  {
    return this.item;
  }

  public Class[] getDependents()
  {
    return this.items;
  }

  public String getName()
  {
    return this.name;
  }

  public MethodPart getRead()
  {
    return this.get;
  }

  public Class getType()
  {
    return this.type;
  }

  public MethodPart getWrite()
  {
    return this.set;
  }

  public boolean isReadOnly()
  {
    return this.set == null;
  }

  public void set(Object paramObject1, Object paramObject2)
    throws Exception
  {
    Class localClass = this.get.getMethod().getDeclaringClass();
    if (this.set == null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.name;
      arrayOfObject[1] = localClass;
      throw new MethodException("Property '%s' is read only in %s", arrayOfObject);
    }
    this.set.getMethod().invoke(paramObject1, new Object[] { paramObject2 });
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.name;
    return String.format("method '%s'", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodContact
 * JD-Core Version:    0.6.2
 */