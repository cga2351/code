package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class OutputNodeMap extends LinkedHashMap<String, OutputNode>
  implements NodeMap<OutputNode>
{
  private final OutputNode source;

  public OutputNodeMap(OutputNode paramOutputNode)
  {
    this.source = paramOutputNode;
  }

  public OutputNode get(String paramString)
  {
    return (OutputNode)super.get(paramString);
  }

  public String getName()
  {
    return this.source.getName();
  }

  public OutputNode getNode()
  {
    return this.source;
  }

  public Iterator<String> iterator()
  {
    return keySet().iterator();
  }

  public OutputNode put(String paramString1, String paramString2)
  {
    OutputAttribute localOutputAttribute = new OutputAttribute(this.source, paramString1, paramString2);
    if (this.source != null)
      put(paramString1, localOutputAttribute);
    return localOutputAttribute;
  }

  public OutputNode remove(String paramString)
  {
    return (OutputNode)super.remove(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputNodeMap
 * JD-Core Version:    0.6.2
 */