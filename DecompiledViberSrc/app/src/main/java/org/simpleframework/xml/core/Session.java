package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class Session
  implements Map
{
  private final Map map = new HashMap();
  private final boolean strict;

  public Session()
  {
    this(true);
  }

  public Session(boolean paramBoolean)
  {
    this.strict = paramBoolean;
  }

  public void clear()
  {
    this.map.clear();
  }

  public boolean containsKey(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return this.map.containsValue(paramObject);
  }

  public Set entrySet()
  {
    return this.map.entrySet();
  }

  public Object get(Object paramObject)
  {
    return this.map.get(paramObject);
  }

  public Map getMap()
  {
    return this.map;
  }

  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }

  public boolean isStrict()
  {
    return this.strict;
  }

  public Set keySet()
  {
    return this.map.keySet();
  }

  public Object put(Object paramObject1, Object paramObject2)
  {
    return this.map.put(paramObject1, paramObject2);
  }

  public void putAll(Map paramMap)
  {
    this.map.putAll(paramMap);
  }

  public Object remove(Object paramObject)
  {
    return this.map.remove(paramObject);
  }

  public int size()
  {
    return this.map.size();
  }

  public Collection values()
  {
    return this.map.values();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Session
 * JD-Core Version:    0.6.2
 */