package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeInlineMap
  implements Repeater
{
  private final Entry entry;
  private final MapFactory factory;
  private final Converter key;
  private final Style style;
  private final Converter value;

  public CompositeInlineMap(Context paramContext, Entry paramEntry, Type paramType)
    throws Exception
  {
    this.factory = new MapFactory(paramContext, paramType);
    this.value = paramEntry.getValue(paramContext);
    this.key = paramEntry.getKey(paramContext);
    this.style = paramContext.getStyle();
    this.entry = paramEntry;
  }

  private Object read(InputNode paramInputNode, Map paramMap)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      Object localObject1 = this.key.read(paramInputNode);
      Object localObject2 = this.value.read(paramInputNode);
      if (paramMap != null)
        paramMap.put(localObject1, localObject2);
      paramInputNode = localInputNode.getNext(str);
    }
    return paramMap;
  }

  private void write(OutputNode paramOutputNode, Map paramMap, Mode paramMode)
    throws Exception
  {
    String str1 = this.entry.getEntry();
    String str2 = this.style.getElement(str1);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      OutputNode localOutputNode = paramOutputNode.getChild(str2);
      Object localObject2 = paramMap.get(localObject1);
      localOutputNode.setMode(paramMode);
      this.key.write(localOutputNode, localObject1);
      this.value.write(localOutputNode, localObject2);
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Map localMap = (Map)this.factory.getInstance();
    if (localMap != null)
      return read(paramInputNode, localMap);
    return null;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Map localMap = (Map)paramObject;
    if (localMap != null)
      return read(paramInputNode, localMap);
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      if (!this.key.validate(paramInputNode));
      while (!this.value.validate(paramInputNode))
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
    Map localMap = (Map)paramObject;
    if (!paramOutputNode.isCommitted())
      paramOutputNode.remove();
    write(localOutputNode, localMap, localMode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeInlineMap
 * JD-Core Version:    0.6.2
 */