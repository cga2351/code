package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

abstract interface MethodPart
{
  public abstract Annotation getAnnotation();

  public abstract <T extends Annotation> T getAnnotation(Class<T> paramClass);

  public abstract Class getDeclaringClass();

  public abstract Class getDependent();

  public abstract Class[] getDependents();

  public abstract Method getMethod();

  public abstract MethodType getMethodType();

  public abstract String getName();

  public abstract Class getType();

  public abstract String toString();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodPart
 * JD-Core Version:    0.6.2
 */