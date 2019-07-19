package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mc
{
  public List<me> a(List<me> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      me localme = (me)localIterator1.next();
      ArrayList localArrayList2 = new ArrayList(localme.b.size());
      Iterator localIterator2 = localme.b.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (bn.b(str))
          localArrayList2.add(str);
      }
      if (!localArrayList2.isEmpty())
        localArrayList1.add(new me(localme.a, localArrayList2));
    }
    return localArrayList1;
  }

  public JSONObject b(List<me> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      me localme = (me)localIterator.next();
      try
      {
        localJSONObject.put(localme.a, new JSONObject().put("classes", new JSONArray(localme.b)));
      }
      catch (JSONException localJSONException)
      {
      }
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mc
 * JD-Core Version:    0.6.2
 */