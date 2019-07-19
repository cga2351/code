package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class PrimitiveList
  implements Converter
{
  private final Type entry;
  private final CollectionFactory factory;
  private final String parent;
  private final Primitive root;

  public PrimitiveList(Context paramContext, Type paramType1, Type paramType2, String paramString)
  {
    this.factory = new CollectionFactory(paramContext, paramType1);
    this.root = new Primitive(paramContext, paramType2);
    this.parent = paramString;
    this.entry = paramType2;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    return this.factory.setOverride(this.entry, paramObject, paramOutputNode);
  }

  private Object populate(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return localCollection;
      localCollection.add(this.root.read(localInputNode));
    }
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

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Object localObject = localInstance.getInstance();
    if (!localInstance.isReference())
      localObject = populate(paramInputNode, localObject);
    return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (localInstance.isReference())
      paramObject = localInstance.getInstance();
    do
    {
      return paramObject;
      localInstance.setInstance(paramObject);
    }
    while (paramObject == null);
    return populate(paramInputNode, paramObject);
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
    Iterator localIterator = ((Collection)paramObject).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject != null)
      {
        OutputNode localOutputNode = paramOutputNode.getChild(this.parent);
        if (!isOverridden(localOutputNode, localObject))
          this.root.write(localOutputNode, localObject);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveList
 * JD-Core Version:    0.6.2
 */