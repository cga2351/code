package org.simpleframework.xml.strategy;

import java.util.Map;

class Allocate
  implements Value
{
  private String key;
  private Map map;
  private Value value;

  public Allocate(Value paramValue, Map paramMap, String paramString)
  {
    this.value = paramValue;
    this.map = paramMap;
    this.key = paramString;
  }

  public int getLength()
  {
    return this.value.getLength();
  }

  public Class getType()
  {
    return this.value.getType();
  }

  public Object getValue()
  {
    return this.map.get(this.key);
  }

  public boolean isReference()
  {
    return false;
  }

  public void setValue(Object paramObject)
  {
    if (this.key != null)
      this.map.put(this.key, paramObject);
    this.value.setValue(paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Allocate
 * JD-Core Version:    0.6.2
 */