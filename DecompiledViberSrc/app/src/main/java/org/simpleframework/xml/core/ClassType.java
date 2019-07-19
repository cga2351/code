package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

class ClassType
  implements Type
{
  private final Class type;

  public ClassType(Class paramClass)
  {
    this.type = paramClass;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return null;
  }

  public Class getType()
  {
    return this.type;
  }

  public String toString()
  {
    return this.type.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ClassType
 * JD-Core Version:    0.6.2
 */