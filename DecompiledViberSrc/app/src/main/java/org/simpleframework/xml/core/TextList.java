package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class TextList
  implements Repeater
{
  private final CollectionFactory factory;
  private final Primitive primitive;
  private final Type type = new ClassType(String.class);

  public TextList(Context paramContext, Type paramType, Label paramLabel)
  {
    this.factory = new CollectionFactory(paramContext, paramType);
    this.primitive = new Primitive(paramContext, this.type);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Object localObject = localInstance.getInstance();
    if (localInstance.isReference())
      return localInstance.getInstance();
    return read(paramInputNode, localObject);
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    Object localObject = this.primitive.read(paramInputNode);
    if (localObject != null)
      localCollection.add(localObject);
    return paramObject;
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    return true;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    OutputNode localOutputNode = paramOutputNode.getParent();
    Iterator localIterator = localCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      this.primitive.write(localOutputNode, localObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TextList
 * JD-Core Version:    0.6.2
 */