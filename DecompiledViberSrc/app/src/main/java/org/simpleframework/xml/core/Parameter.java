package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

abstract interface Parameter
{
  public abstract Annotation getAnnotation();

  public abstract Expression getExpression();

  public abstract int getIndex();

  public abstract Object getKey();

  public abstract String getName();

  public abstract String getPath();

  public abstract Class getType();

  public abstract boolean isAttribute();

  public abstract boolean isPrimitive();

  public abstract boolean isRequired();

  public abstract boolean isText();

  public abstract String toString();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Parameter
 * JD-Core Version:    0.6.2
 */