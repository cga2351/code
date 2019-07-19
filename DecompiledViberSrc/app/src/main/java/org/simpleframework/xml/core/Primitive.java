package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class Primitive
  implements Converter
{
  private final Context context;
  private final String empty;
  private final Class expect;
  private final PrimitiveFactory factory;
  private final Type type;

  public Primitive(Context paramContext, Type paramType)
  {
    this(paramContext, paramType, null);
  }

  public Primitive(Context paramContext, Type paramType, String paramString)
  {
    this.factory = new PrimitiveFactory(paramContext, paramType);
    this.expect = paramType.getType();
    this.context = paramContext;
    this.empty = paramString;
    this.type = paramType;
  }

  private Object readElement(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (!localInstance.isReference())
      return readElement(paramInputNode, localInstance);
    return localInstance.getInstance();
  }

  private Object readElement(InputNode paramInputNode, Instance paramInstance)
    throws Exception
  {
    Object localObject = read(paramInputNode, this.expect);
    if (paramInstance != null)
      paramInstance.setInstance(localObject);
    return localObject;
  }

  private Object readTemplate(String paramString, Class paramClass)
    throws Exception
  {
    String str = this.context.getProperty(paramString);
    if (str != null)
      return this.factory.getInstance(str, paramClass);
    return null;
  }

  private boolean validateElement(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (!localInstance.isReference())
      localInstance.setInstance(null);
    return true;
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    if (paramInputNode.isElement())
      return readElement(paramInputNode);
    return read(paramInputNode, this.expect);
  }

  public Object read(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    String str = paramInputNode.getValue();
    if (str == null)
      return null;
    if ((this.empty != null) && (str.equals(this.empty)))
      return this.empty;
    return readTemplate(str, paramClass);
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    if (paramObject != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.expect;
      arrayOfObject[1] = this.type;
      throw new PersistenceException("Can not read existing %s for %s", arrayOfObject);
    }
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    if (paramInputNode.isElement())
      validateElement(paramInputNode);
    while (true)
    {
      return true;
      paramInputNode.getValue();
    }
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    String str = this.factory.getText(paramObject);
    if (str != null)
      paramOutputNode.setValue(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Primitive
 * JD-Core Version:    0.6.2
 */