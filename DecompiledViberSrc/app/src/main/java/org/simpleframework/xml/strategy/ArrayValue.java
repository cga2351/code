package org.simpleframework.xml.strategy;

class ArrayValue
  implements Value
{
  private int size;
  private Class type;
  private Object value;

  public ArrayValue(Class paramClass, int paramInt)
  {
    this.type = paramClass;
    this.size = paramInt;
  }

  public int getLength()
  {
    return this.size;
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
    return false;
  }

  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.ArrayValue
 * JD-Core Version:    0.6.2
 */