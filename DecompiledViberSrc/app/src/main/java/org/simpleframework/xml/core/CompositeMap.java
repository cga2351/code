package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeMap
  implements Converter
{
  private final Entry entry;
  private final MapFactory factory;
  private final Converter key;
  private final Style style;
  private final Converter value;

  public CompositeMap(Context paramContext, Entry paramEntry, Type paramType)
    throws Exception
  {
    this.factory = new MapFactory(paramContext, paramType);
    this.value = paramEntry.getValue(paramContext);
    this.key = paramEntry.getKey(paramContext);
    this.style = paramContext.getStyle();
    this.entry = paramEntry;
  }

  private Object populate(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Map localMap = (Map)paramObject;
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return localMap;
      localMap.put(this.key.read(localInputNode), this.value.read(localInputNode));
    }
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    InputNode localInputNode;
    do
    {
      localInputNode = paramInputNode.getNext();
      boolean bool2;
      if (localInputNode == null)
        bool2 = true;
      boolean bool1;
      do
      {
        return bool2;
        bool1 = this.key.validate(localInputNode);
        bool2 = false;
      }
      while (!bool1);
    }
    while (this.value.validate(localInputNode));
    return false;
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
    Map localMap = (Map)paramObject;
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      String str = this.entry.getEntry();
      OutputNode localOutputNode = paramOutputNode.getChild(this.style.getElement(str));
      Object localObject2 = localMap.get(localObject1);
      this.key.write(localOutputNode, localObject1);
      this.value.write(localOutputNode, localObject2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeMap
 * JD-Core Version:    0.6.2
 */