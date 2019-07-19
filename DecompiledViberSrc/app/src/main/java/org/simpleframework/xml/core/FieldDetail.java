package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

class FieldDetail
{
  private final Field field;
  private final Annotation[] list;
  private final String name;

  public FieldDetail(Field paramField)
  {
    this.list = paramField.getDeclaredAnnotations();
    this.name = paramField.getName();
    this.field = paramField;
  }

  public Annotation[] getAnnotations()
  {
    return this.list;
  }

  public Field getField()
  {
    return this.field;
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.FieldDetail
 * JD-Core Version:    0.6.2
 */