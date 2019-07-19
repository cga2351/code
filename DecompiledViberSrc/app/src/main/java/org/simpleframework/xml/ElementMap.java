package org.simpleframework.xml;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ElementMap
{
  public abstract boolean attribute();

  public abstract boolean data();

  public abstract boolean empty();

  public abstract String entry();

  public abstract boolean inline();

  public abstract String key();

  public abstract Class keyType();

  public abstract String name();

  public abstract boolean required();

  public abstract String value();

  public abstract Class valueType();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.ElementMap
 * JD-Core Version:    0.6.2
 */