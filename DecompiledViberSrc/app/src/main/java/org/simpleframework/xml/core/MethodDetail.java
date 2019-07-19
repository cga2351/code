package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class MethodDetail
{
  private final Annotation[] list;
  private final Method method;
  private final String name;

  public MethodDetail(Method paramMethod)
  {
    this.list = paramMethod.getDeclaredAnnotations();
    this.name = paramMethod.getName();
    this.method = paramMethod;
  }

  public Annotation[] getAnnotations()
  {
    return this.list;
  }

  public Method getMethod()
  {
    return this.method;
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodDetail
 * JD-Core Version:    0.6.2
 */