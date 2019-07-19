package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class ModelMap extends LinkedHashMap<String, ModelList>
  implements Iterable<ModelList>
{
  private final Detail detail;

  public ModelMap(Detail paramDetail)
  {
    this.detail = paramDetail;
  }

  public ModelMap getModels()
    throws Exception
  {
    ModelMap localModelMap = new ModelMap(this.detail);
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ModelList localModelList = (ModelList)get(str);
      if (localModelList != null)
        localModelList = localModelList.build();
      if (localModelMap.containsKey(str))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = this.detail;
        throw new PathException("Path with name '%s' is a duplicate in %s ", arrayOfObject);
      }
      localModelMap.put(str, localModelList);
    }
    return localModelMap;
  }

  public Iterator<ModelList> iterator()
  {
    return values().iterator();
  }

  public Model lookup(String paramString, int paramInt)
  {
    ModelList localModelList = (ModelList)get(paramString);
    if (localModelList != null)
      return localModelList.lookup(paramInt);
    return null;
  }

  public void register(String paramString, Model paramModel)
  {
    ModelList localModelList = (ModelList)get(paramString);
    if (localModelList == null)
    {
      localModelList = new ModelList();
      put(paramString, localModelList);
    }
    localModelList.register(paramModel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelMap
 * JD-Core Version:    0.6.2
 */