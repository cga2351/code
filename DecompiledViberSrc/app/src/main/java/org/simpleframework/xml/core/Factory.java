package org.simpleframework.xml.core;

import java.lang.reflect.Modifier;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

abstract class Factory
{
  protected Context context;
  protected Class override;
  protected Support support;
  protected Type type;

  protected Factory(Context paramContext, Type paramType)
  {
    this(paramContext, paramType, null);
  }

  protected Factory(Context paramContext, Type paramType, Class paramClass)
  {
    this.support = paramContext.getSupport();
    this.override = paramClass;
    this.context = paramContext;
    this.type = paramType;
  }

  private Type getPrimitive(Type paramType, Class paramClass)
    throws Exception
  {
    Class localClass = Support.getPrimitive(paramClass);
    if (localClass != paramClass)
      paramType = new OverrideType(paramType, localClass);
    return paramType;
  }

  public static boolean isCompatible(Class paramClass1, Class paramClass2)
  {
    if (paramClass1.isArray())
      paramClass1 = paramClass1.getComponentType();
    return paramClass1.isAssignableFrom(paramClass2);
  }

  public static boolean isInstantiable(Class paramClass)
  {
    int i = paramClass.getModifiers();
    if (Modifier.isAbstract(i));
    while (Modifier.isInterface(i))
      return false;
    return true;
  }

  public Value getConversion(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = this.context.getOverride(this.type, paramInputNode);
    if ((localValue != null) && (this.override != null))
    {
      Class localClass = localValue.getType();
      if (!isCompatible(this.override, localClass))
        return new OverrideValue(localValue, this.override);
    }
    return localValue;
  }

  public Object getInstance()
    throws Exception
  {
    Class localClass = getType();
    if (!isInstantiable(localClass))
      throw new InstantiationException("Type %s can not be instantiated", new Object[] { localClass });
    return localClass.newInstance();
  }

  protected Value getOverride(InputNode paramInputNode)
    throws Exception
  {
    Value localValue = getConversion(paramInputNode);
    if (localValue != null)
    {
      Position localPosition = paramInputNode.getPosition();
      Class localClass = localValue.getType();
      if (!isCompatible(getType(), localClass))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = localClass;
        arrayOfObject[1] = this.type;
        arrayOfObject[2] = localPosition;
        throw new InstantiationException("Incompatible %s for %s at %s", arrayOfObject);
      }
    }
    return localValue;
  }

  public Class getType()
  {
    if (this.override != null)
      return this.override;
    return this.type.getType();
  }

  public boolean setOverride(Type paramType, Object paramObject, OutputNode paramOutputNode)
    throws Exception
  {
    Class localClass = paramType.getType();
    if (localClass.isPrimitive())
      paramType = getPrimitive(paramType, localClass);
    return this.context.setOverride(paramType, paramObject, paramOutputNode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Factory
 * JD-Core Version:    0.6.2
 */