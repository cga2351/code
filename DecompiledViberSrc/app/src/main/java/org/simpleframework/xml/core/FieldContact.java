package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class FieldContact
  implements Contact
{
  private final Cache<Annotation> cache = new ConcurrentCache();
  private final Field field;
  private final Annotation label;
  private final Annotation[] list;
  private final int modifier;
  private final String name;

  public FieldContact(Field paramField, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    this.modifier = paramField.getModifiers();
    this.name = paramField.getName();
    this.label = paramAnnotation;
    this.field = paramField;
    this.list = paramArrayOfAnnotation;
  }

  private <T extends Annotation> T getCache(Class<T> paramClass)
  {
    if (this.cache.isEmpty())
      for (Annotation localAnnotation : this.list)
      {
        Class localClass = localAnnotation.annotationType();
        this.cache.cache(localClass, localAnnotation);
      }
    return (Annotation)this.cache.fetch(paramClass);
  }

  public Object get(Object paramObject)
    throws Exception
  {
    return this.field.get(paramObject);
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    if (paramClass == this.label.annotationType())
      return this.label;
    return getCache(paramClass);
  }

  public Class getDeclaringClass()
  {
    return this.field.getDeclaringClass();
  }

  public Class getDependent()
  {
    return Reflector.getDependent(this.field);
  }

  public Class[] getDependents()
  {
    return Reflector.getDependents(this.field);
  }

  public String getName()
  {
    return this.name;
  }

  public Class getType()
  {
    return this.field.getType();
  }

  public boolean isFinal()
  {
    return Modifier.isFinal(this.modifier);
  }

  public boolean isReadOnly()
  {
    return (!isStatic()) && (isFinal());
  }

  public boolean isStatic()
  {
    return Modifier.isStatic(this.modifier);
  }

  public void set(Object paramObject1, Object paramObject2)
    throws Exception
  {
    if (!isFinal())
      this.field.set(paramObject1, paramObject2);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = getName();
    arrayOfObject[1] = this.field.toString();
    return String.format("field '%s' %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.FieldContact
 * JD-Core Version:    0.6.2
 */