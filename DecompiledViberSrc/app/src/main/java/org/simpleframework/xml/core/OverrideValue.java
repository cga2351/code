package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

class OverrideValue
  implements Value
{
  private final Class type;
  private final Value value;

  public OverrideValue(Value paramValue, Class paramClass)
  {
    this.value = paramValue;
    this.type = paramClass;
  }

  public int getLength()
  {
    return this.value.getLength();
  }

  public Class getType()
  {
    return this.type;
  }

  public Object getValue()
  {
    return this.value.getValue();
  }

  public boolean isReference()
  {
    return this.value.isReference();
  }

  public void setValue(Object paramObject)
  {
    this.value.setValue(paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.OverrideValue
 * JD-Core Version:    0.6.2
 */