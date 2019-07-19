package org.simpleframework.xml.strategy;

import java.lang.annotation.Annotation;

public abstract interface Type
{
  public abstract <T extends Annotation> T getAnnotation(Class<T> paramClass);

  public abstract Class getType();

  public abstract String toString();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Type
 * JD-Core Version:    0.6.2
 */