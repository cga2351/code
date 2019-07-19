package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class PrimitiveArray
  implements Converter
{
  private final Type entry;
  private final ArrayFactory factory;
  private final String parent;
  private final Primitive root;
  private final Type type;

  public PrimitiveArray(Context paramContext, Type paramType1, Type paramType2, String paramString)
  {
    this.factory = new ArrayFactory(paramContext, paramType1);
    this.root = new Primitive(paramContext, paramType2);
    this.parent = paramString;
    this.entry = paramType2;
    this.type = paramType1;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    return this.factory.setOverride(this.entry, paramObject, paramOutputNode);
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return true;
      this.root.validate(localInputNode);
    }
  }

  private void write(OutputNode paramOutputNode, Object paramObject, int paramInt)
    throws Exception
  {
    Object localObject = Array.get(paramObject, paramInt);
    if ((localObject != null) && (!isOverridden(paramOutputNode, localObject)))
      this.root.write(paramOutputNode, localObject);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Object localObject = localInstance.getInstance();
    if (!localInstance.isReference())
      localObject = read(paramInputNode, localObject);
    return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    int i = Array.getLength(paramObject);
    for (int j = 0; ; j++)
    {
      Position localPosition = paramInputNode.getPosition();
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return paramObject;
      if (j >= i)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.type;
        arrayOfObject[1] = localPosition;
        throw new ElementException("Array length missing or incorrect for %s at %s", arrayOfObject);
      }
      Array.set(paramObject, j, this.root.read(localInputNode));
    }
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (!localInstance.isReference())
    {
      localInstance.setInstance(null);
      return validate(paramInputNode, localInstance.getType());
    }
    return true;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    int i = Array.getLength(paramObject);
    for (int j = 0; ; j++)
    {
      OutputNode localOutputNode;
      if (j < i)
      {
        localOutputNode = paramOutputNode.getChild(this.parent);
        if (localOutputNode != null);
      }
      else
      {
        return;
      }
      write(localOutputNode, paramObject, j);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveArray
 * JD-Core Version:    0.6.2
 */