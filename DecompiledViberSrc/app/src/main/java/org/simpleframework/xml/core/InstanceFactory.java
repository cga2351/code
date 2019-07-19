package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class InstanceFactory
{
  private final Cache<Constructor> cache = new ConcurrentCache();

  public Instance getInstance(Class paramClass)
  {
    return new ClassInstance(paramClass);
  }

  public Instance getInstance(Value paramValue)
  {
    return new ValueInstance(paramValue);
  }

  protected Object getObject(Class paramClass)
    throws Exception
  {
    Constructor localConstructor = (Constructor)this.cache.fetch(paramClass);
    if (localConstructor == null)
    {
      localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      if (!localConstructor.isAccessible())
        localConstructor.setAccessible(true);
      this.cache.cache(paramClass, localConstructor);
    }
    return localConstructor.newInstance(new Object[0]);
  }

  private class ClassInstance
    implements Instance
  {
    private Class type;
    private Object value;

    public ClassInstance(Class arg2)
    {
      Object localObject;
      this.type = localObject;
    }

    public Object getInstance()
      throws Exception
    {
      if (this.value == null)
        this.value = InstanceFactory.this.getObject(this.type);
      return this.value;
    }

    public Class getType()
    {
      return this.type;
    }

    public boolean isReference()
    {
      return false;
    }

    public Object setInstance(Object paramObject)
      throws Exception
    {
      this.value = paramObject;
      return paramObject;
    }
  }

  private class ValueInstance
    implements Instance
  {
    private final Class type;
    private final Value value;

    public ValueInstance(Value arg2)
    {
      Object localObject;
      this.type = localObject.getType();
      this.value = localObject;
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
        localObject = InstanceFactory.this.getObject(this.type);
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.InstanceFactory
 * JD-Core Version:    0.6.2
 */