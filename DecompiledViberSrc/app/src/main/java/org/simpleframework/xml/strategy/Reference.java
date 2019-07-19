package org.simpleframework.xml.strategy;

class Reference
  implements Value
{
  private Class type;
  private Object value;

  public Reference(Object paramObject, Class paramClass)
  {
    this.value = paramObject;
    this.type = paramClass;
  }

  public int getLength()
  {
    return 0;
  }

  public Class getType()
  {
    return this.type;
  }

  public Object getValue()
  {
    return this.value;
  }

  public boolean isReference()
  {
    return true;
  }

  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Reference
 * JD-Core Version:    0.6.2
 */