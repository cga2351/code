package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

class OverrideType
  implements Type
{
  private final Class override;
  private final Type type;

  public OverrideType(Type paramType, Class paramClass)
  {
    this.override = paramClass;
    this.type = paramType;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.type.getAnnotation(paramClass);
  }

  public Class getType()
  {
    return this.override;
  }

  public String toString()
  {
    return this.type.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.OverrideType
 * JD-Core Version:    0.6.2
 */