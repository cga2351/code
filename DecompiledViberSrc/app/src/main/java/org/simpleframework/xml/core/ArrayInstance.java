package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Value;

class ArrayInstance
  implements Instance
{
  private final int length;
  private final Class type;
  private final Value value;

  public ArrayInstance(Value paramValue)
  {
    this.length = paramValue.getLength();
    this.type = paramValue.getType();
    this.value = paramValue;
  }

  public Object getInstance()
    throws Exception
  {
    Object localObject;
    if (this.value.isReference())
      localObject = this.value.getValue();
    do
    {
      return localObject;
      localObject = Array.newInstance(this.type, this.length);
    }
    while (this.value == null);
    this.value.setValue(localObject);
    return localObject;
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isReference()
  {
    return this.value.isReference();
  }

  public Object setInstance(Object paramObject)
  {
    if (this.value != null)
      this.value.setValue(paramObject);
    return paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ArrayInstance
 * JD-Core Version:    0.6.2
 */