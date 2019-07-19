package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

abstract class ParameterContact<T extends Annotation>
  implements Contact
{
  protected final Constructor factory;
  protected final int index;
  protected final T label;
  protected final Annotation[] labels = paramConstructor.getParameterAnnotations()[paramInt];
  protected final Class owner;

  public ParameterContact(T paramT, Constructor paramConstructor, int paramInt)
  {
    this.owner = paramConstructor.getDeclaringClass();
    this.factory = paramConstructor;
    this.index = paramInt;
    this.label = paramT;
  }

  public Object get(Object paramObject)
  {
    return null;
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    for (Annotation localAnnotation : this.labels)
      if (localAnnotation.annotationType().equals(paramClass))
        return localAnnotation;
    return null;
  }

  public Class getDeclaringClass()
  {
    return this.owner;
  }

  public Class getDependent()
  {
    return Reflector.getParameterDependent(this.factory, this.index);
  }

  public Class[] getDependents()
  {
    return Reflector.getParameterDependents(this.factory, this.index);
  }

  public abstract String getName();

  public Class getType()
  {
    return this.factory.getParameterTypes()[this.index];
  }

  public boolean isReadOnly()
  {
    return false;
  }

  public void set(Object paramObject1, Object paramObject2)
  {
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.index);
    arrayOfObject[1] = this.factory;
    return String.format("parameter %s of constructor %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ParameterContact
 * JD-Core Version:    0.6.2
 */