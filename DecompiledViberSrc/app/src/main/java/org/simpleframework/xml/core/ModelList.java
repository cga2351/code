package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

class ModelList extends ArrayList<Model>
{
  public ModelList build()
  {
    ModelList localModelList = new ModelList();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
      localModelList.register((Model)localIterator.next());
    return localModelList;
  }

  public boolean isEmpty()
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Model localModel = (Model)localIterator.next();
      if ((localModel != null) && (!localModel.isEmpty()))
        return false;
    }
    return true;
  }

  public Model lookup(int paramInt)
  {
    if (paramInt <= size())
      return (Model)get(paramInt - 1);
    return null;
  }

  public void register(Model paramModel)
  {
    int i = paramModel.getIndex();
    int j = size();
    for (int k = 0; k < i; k++)
    {
      if (k >= j)
        add(null);
      if (k == i - 1)
        set(i - 1, paramModel);
    }
  }

  public Model take()
  {
    while (!isEmpty())
    {
      Model localModel = (Model)remove(0);
      if (!localModel.isEmpty())
        return localModel;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelList
 * JD-Core Version:    0.6.2
 */