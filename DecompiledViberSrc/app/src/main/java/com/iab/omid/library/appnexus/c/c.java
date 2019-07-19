package com.iab.omid.library.appnexus.c;

import android.view.View;
import com.iab.omid.library.appnexus.d.b;
import com.iab.omid.library.appnexus.d.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c
  implements a
{
  private final a a;

  public c(a parama)
  {
    this.a = parama;
  }

  ArrayList<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    com.iab.omid.library.appnexus.b.a locala = com.iab.omid.library.appnexus.b.a.a();
    if (locala != null)
    {
      Collection localCollection = locala.c();
      IdentityHashMap localIdentityHashMap = new IdentityHashMap(3 + 2 * localCollection.size());
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        View localView1 = ((com.iab.omid.library.appnexus.adsession.a)localIterator.next()).c();
        if ((localView1 != null) && (f.c(localView1)))
        {
          View localView2 = localView1.getRootView();
          if ((localView2 != null) && (!localIdentityHashMap.containsKey(localView2)))
          {
            localIdentityHashMap.put(localView2, localView2);
            float f = f.a(localView2);
            for (int i = localArrayList.size(); (i > 0) && (f.a((View)localArrayList.get(i - 1)) > f); i--);
            localArrayList.add(i, localView2);
          }
        }
      }
    }
    return localArrayList;
  }

  public JSONObject a(View paramView)
  {
    return b.a(0, 0, 0, 0);
  }

  public void a(View paramView, JSONObject paramJSONObject, a.a parama, boolean paramBoolean)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      parama.a((View)localIterator.next(), this.a, paramJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.c.c
 * JD-Core Version:    0.6.2
 */