package org.simpleframework.xml.filter;

import java.util.Map;

public class MapFilter
  implements Filter
{
  private Filter filter;
  private Map map;

  public MapFilter(Map paramMap)
  {
    this(paramMap, null);
  }

  public MapFilter(Map paramMap, Filter paramFilter)
  {
    this.filter = paramFilter;
    this.map = paramMap;
  }

  public String replace(String paramString)
  {
    if (this.map != null);
    for (Object localObject = this.map.get(paramString); ; localObject = null)
    {
      String str;
      if (localObject != null)
        str = localObject.toString();
      Filter localFilter;
      do
      {
        return str;
        localFilter = this.filter;
        str = null;
      }
      while (localFilter == null);
      return this.filter.replace(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.filter.MapFilter
 * JD-Core Version:    0.6.2
 */