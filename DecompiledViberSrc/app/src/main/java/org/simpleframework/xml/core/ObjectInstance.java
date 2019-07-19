package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

class ObjectInstance
  implements Instance
{
  private final Context context;
  private final Class type;
  private final Value value;

  public ObjectInstance(Context paramContext, Value paramValue)
  {
    this.type = paramValue.getType();
    this.context = paramContext;
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
      localObject = getInstance(this.type);
    }
    while (this.value == null);
    this.value.setValue(localObject);
    return localObject;
  }

  public Object getInstance(Class paramClass)
    throws Exception
  {
    return this.context.getInstance(paramClass).getInstance();
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
 * Qualified Name:     org.simpleframework.xml.core.ObjectInstance
 * JD-Core Version:    0.6.2
 */