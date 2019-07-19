package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class InputNodeMap extends LinkedHashMap<String, InputNode>
  implements NodeMap<InputNode>
{
  private final InputNode source;

  protected InputNodeMap(InputNode paramInputNode)
  {
    this.source = paramInputNode;
  }

  public InputNodeMap(InputNode paramInputNode, EventNode paramEventNode)
  {
    this.source = paramInputNode;
    build(paramEventNode);
  }

  private void build(EventNode paramEventNode)
  {
    Iterator localIterator = paramEventNode.iterator();
    while (localIterator.hasNext())
    {
      Attribute localAttribute = (Attribute)localIterator.next();
      InputAttribute localInputAttribute = new InputAttribute(this.source, localAttribute);
      if (!localAttribute.isReserved())
        put(localInputAttribute.getName(), localInputAttribute);
    }
  }

  public InputNode get(String paramString)
  {
    return (InputNode)super.get(paramString);
  }

  public String getName()
  {
    return this.source.getName();
  }

  public InputNode getNode()
  {
    return this.source;
  }

  public Iterator<String> iterator()
  {
    return keySet().iterator();
  }

  public InputNode put(String paramString1, String paramString2)
  {
    InputAttribute localInputAttribute = new InputAttribute(this.source, paramString1, paramString2);
    if (paramString1 != null)
      put(paramString1, localInputAttribute);
    return localInputAttribute;
  }

  public InputNode remove(String paramString)
  {
    return (InputNode)super.remove(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.InputNodeMap
 * JD-Core Version:    0.6.2
 */