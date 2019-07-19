package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

class ConversionInstance
  implements Instance
{
  private final Context context;
  private final Class convert;
  private final Value value;

  public ConversionInstance(Context paramContext, Value paramValue, Class paramClass)
    throws Exception
  {
    this.context = paramContext;
    this.convert = paramClass;
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
      localObject = getInstance(this.convert);
    }
    while (localObject == null);
    setInstance(localObject);
    return localObject;
  }

  public Object getInstance(Class paramClass)
    throws Exception
  {
    return this.context.getInstance(paramClass).getInstance();
  }

  public Class getType()
  {
    return this.convert;
  }

  public boolean isReference()
  {
    return this.value.isReference();
  }

  public Object setInstance(Object paramObject)
    throws Exception
  {
    if (this.value != null)
      this.value.setValue(paramObject);
    return paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ConversionInstance
 * JD-Core Version:    0.6.2
 */