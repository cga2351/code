package org.simpleframework.xml.core;

import java.lang.reflect.Method;

class MethodName
{
  private Method method;
  private String name;
  private MethodType type;

  public MethodName(Method paramMethod, MethodType paramMethodType, String paramString)
  {
    this.method = paramMethod;
    this.type = paramMethodType;
    this.name = paramString;
  }

  public Method getMethod()
  {
    return this.method;
  }

  public String getName()
  {
    return this.name;
  }

  public MethodType getType()
  {
    return this.type;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodName
 * JD-Core Version:    0.6.2
 */