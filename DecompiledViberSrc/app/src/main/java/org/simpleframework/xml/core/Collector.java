package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class Collector
  implements Criteria
{
  private final Registry alias = new Registry(null);
  private final Registry registry = new Registry(null);

  public void commit(Object paramObject)
    throws Exception
  {
    Iterator localIterator = this.registry.values().iterator();
    while (localIterator.hasNext())
    {
      Variable localVariable = (Variable)localIterator.next();
      localVariable.getContact().set(paramObject, localVariable.getValue());
    }
  }

  public Variable get(Object paramObject)
  {
    return (Variable)this.registry.get(paramObject);
  }

  public Variable get(Label paramLabel)
    throws Exception
  {
    if (paramLabel != null)
    {
      Object localObject = paramLabel.getKey();
      return (Variable)this.registry.get(localObject);
    }
    return null;
  }

  public Iterator<Object> iterator()
  {
    return this.registry.iterator();
  }

  public Variable remove(Object paramObject)
    throws Exception
  {
    return (Variable)this.registry.remove(paramObject);
  }

  public Variable resolve(String paramString)
  {
    return (Variable)this.alias.get(paramString);
  }

  public void set(Label paramLabel, Object paramObject)
    throws Exception
  {
    Variable localVariable = new Variable(paramLabel, paramObject);
    if (paramLabel != null)
    {
      String[] arrayOfString = paramLabel.getPaths();
      Object localObject = paramLabel.getKey();
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = arrayOfString[j];
        this.alias.put(str, localVariable);
      }
      this.registry.put(localObject, localVariable);
    }
  }

  private static class Registry extends LinkedHashMap<Object, Variable>
  {
    public Iterator<Object> iterator()
    {
      return keySet().iterator();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Collector
 * JD-Core Version:    0.6.2
 */