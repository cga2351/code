package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Dictionary<T extends Entry> extends AbstractSet<T>
{
  protected final Table<T> map = new Table();

  public boolean add(T paramT)
  {
    return this.map.put(paramT.getName(), paramT) != null;
  }

  public T get(String paramString)
  {
    return (Entry)this.map.get(paramString);
  }

  public Iterator<T> iterator()
  {
    return this.map.values().iterator();
  }

  public T remove(String paramString)
  {
    return (Entry)this.map.remove(paramString);
  }

  public int size()
  {
    return this.map.size();
  }

  private static class Table<T> extends HashMap<String, T>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.Dictionary
 * JD-Core Version:    0.6.2
 */