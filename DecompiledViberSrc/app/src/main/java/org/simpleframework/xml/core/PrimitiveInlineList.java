package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;

class PrimitiveInlineList
  implements Repeater
{
  private final Type entry;
  private final CollectionFactory factory;
  private final String parent;
  private final Primitive root;

  public PrimitiveInlineList(Context paramContext, Type paramType1, Type paramType2, String paramString)
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

  private Object read(InputNode paramInputNode, Collection paramCollection)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      Object localObject = this.root.read(paramInputNode);
      if (localObject != null)
        paramCollection.add(localObject);
      paramInputNode = localInputNode.getNext(str);
    }
    return paramCollection;
  }

  private void write(OutputNode paramOutputNode, Object paramObject, Mode paramMode)
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
        {
          localOutputNode.setMode(paramMode);
          this.root.write(localOutputNode, localObject);
        }
      }
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Collection localCollection = (Collection)this.factory.getInstance();
    if (localCollection != null)
      return read(paramInputNode, localCollection);
    return null;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    if (localCollection != null)
      return read(paramInputNode, localCollection);
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      if (!this.root.validate(paramInputNode))
        return false;
      paramInputNode = localInputNode.getNext(str);
    }
    return true;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    OutputNode localOutputNode = paramOutputNode.getParent();
    Mode localMode = paramOutputNode.getMode();
    if (!paramOutputNode.isCommitted())
      paramOutputNode.remove();
    write(localOutputNode, paramObject, localMode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveInlineList
 * JD-Core Version:    0.6.2
 */