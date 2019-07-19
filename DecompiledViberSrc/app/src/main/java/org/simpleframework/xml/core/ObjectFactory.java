package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

class ObjectFactory extends PrimitiveFactory
{
  public ObjectFactory(Context paramContext, Type paramType, Class paramClass)
  {
    super(paramContext, paramType, paramClass);
  }

  public Instance getInstance(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = getOverride(paramInputNode);
    Class localClass = getType();
    if (localValue == null)
    {
      if (!isInstantiable(localClass))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localClass;
        arrayOfObject[1] = this.type;
        throw new InstantiationException("Cannot instantiate %s for %s", arrayOfObject);
      }
      return this.context.getInstance(localClass);
    }
    return new ObjectInstance(this.context, localValue);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ObjectFactory
 * JD-Core Version:    0.6.2
 */