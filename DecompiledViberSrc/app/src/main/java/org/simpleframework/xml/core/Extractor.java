package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

abstract interface Extractor<T extends Annotation>
{
  public abstract T[] getAnnotations()
    throws Exception;

  public abstract Label getLabel(T paramT)
    throws Exception;

  public abstract Class getType(T paramT)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Extractor
 * JD-Core Version:    0.6.2
 */