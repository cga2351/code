package org.simpleframework.xml.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

class MapFactory extends Factory
{
  public MapFactory(Context paramContext, Type paramType)
  {
    super(paramContext, paramType);
  }

  private boolean isMap(Class paramClass)
  {
    return Map.class.isAssignableFrom(paramClass);
  }

  public Class getConversion(Class paramClass)
    throws Exception
  {
    if (paramClass.isAssignableFrom(HashMap.class))
      return HashMap.class;
    if (paramClass.isAssignableFrom(TreeMap.class))
      return TreeMap.class;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramClass;
    arrayOfObject[1] = this.type;
    throw new InstantiationException("Cannot instantiate %s for %s", arrayOfObject);
  }

  public Object getInstance()
    throws Exception
  {
    Class localClass1 = getType();
    if (!isInstantiable(localClass1));
    for (Class localClass2 = getConversion(localClass1); ; localClass2 = localClass1)
    {
      if (!isMap(localClass2))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localClass1;
        arrayOfObject[1] = this.type;
        throw new InstantiationException("Invalid map %s for %s", arrayOfObject);
      }
      return localClass2.newInstance();
    }
  }

  public Instance getInstance(Value paramValue)
    throws Exception
  {
    Class localClass = paramValue.getType();
    if (!isInstantiable(localClass))
      localClass = getConversion(localClass);
    if (!isMap(localClass))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = this.type;
      throw new InstantiationException("Invalid map %s for %s", arrayOfObject);
    }
    return new ConversionInstance(this.context, paramValue, localClass);
  }

  public Instance getInstance(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = getOverride(paramInputNode);
    Class localClass = getType();
    if (localValue != null)
      return getInstance(localValue);
    if (!isInstantiable(localClass))
      localClass = getConversion(localClass);
    if (!isMap(localClass))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = this.type;
      throw new InstantiationException("Invalid map %s for %s", arrayOfObject);
    }
    return this.context.getInstance(localClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MapFactory
 * JD-Core Version:    0.6.2
 */