package org.simpleframework.xml.convert;

import org.simpleframework.xml.strategy.Value;

class Reference
  implements Value
{
  private Class actual;
  private Object data;
  private Value value;

  public Reference(Value paramValue, Object paramObject, Class paramClass)
  {
    this.actual = paramClass;
    this.value = paramValue;
    this.data = paramObject;
  }

  public int getLength()
  {
    return 0;
  }

  public Class getType()
  {
    if (this.data != null)
      return this.data.getClass();
    return this.actual;
  }

  public Object getValue()
  {
    return this.data;
  }

  public boolean isReference()
  {
    return true;
  }

  public void setValue(Object paramObject)
  {
    if (this.value != null)
      this.value.setValue(paramObject);
    this.data = paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.Reference
 * JD-Core Version:    0.6.2
 */