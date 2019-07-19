package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class PrefixResolver extends LinkedHashMap<String, String>
  implements NamespaceMap
{
  private final OutputNode source;

  public PrefixResolver(OutputNode paramOutputNode)
  {
    this.source = paramOutputNode;
  }

  private String resolvePrefix(String paramString)
  {
    NamespaceMap localNamespaceMap = this.source.getNamespaces();
    if (localNamespaceMap != null)
    {
      String str = localNamespaceMap.getPrefix(paramString);
      if (!containsValue(str))
        return str;
    }
    return null;
  }

  private String resolveReference(String paramString)
  {
    NamespaceMap localNamespaceMap = this.source.getNamespaces();
    if (localNamespaceMap != null)
      return localNamespaceMap.getReference(paramString);
    return null;
  }

  public String getPrefix()
  {
    return this.source.getPrefix();
  }

  public String getPrefix(String paramString)
  {
    if (size() > 0)
    {
      String str = (String)get(paramString);
      if (str != null)
        return str;
    }
    return resolvePrefix(paramString);
  }

  public String getReference(String paramString)
  {
    if (containsValue(paramString))
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)get(str1);
        if ((str2 != null) && (str2.equals(paramString)))
          return str1;
      }
    }
    return resolveReference(paramString);
  }

  public Iterator<String> iterator()
  {
    return keySet().iterator();
  }

  public String setReference(String paramString)
  {
    return setReference(paramString, "");
  }

  public String setReference(String paramString1, String paramString2)
  {
    if (resolvePrefix(paramString1) != null)
      return null;
    return (String)put(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.PrefixResolver
 * JD-Core Version:    0.6.2
 */