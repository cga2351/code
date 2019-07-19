package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class ParameterMap extends LinkedHashMap<Object, Parameter>
  implements Iterable<Parameter>
{
  public Parameter get(int paramInt)
  {
    return (Parameter)getAll().get(paramInt);
  }

  public List<Parameter> getAll()
  {
    Collection localCollection = values();
    if (!localCollection.isEmpty())
      return new ArrayList(localCollection);
    return Collections.emptyList();
  }

  public Iterator<Parameter> iterator()
  {
    return values().iterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ParameterMap
 * JD-Core Version:    0.6.2
 */