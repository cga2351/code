package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;

abstract interface Scanner
{
  public abstract <T extends Annotation> T scan(Class<T> paramClass);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.Scanner
 * JD-Core Version:    0.6.2
 */