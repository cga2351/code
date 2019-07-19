package com.iab.omid.library.appnexus.c;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.appnexus.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class d
  implements a
{
  private final int[] a = new int[2];

  private void a(ViewGroup paramViewGroup, JSONObject paramJSONObject, a.a parama)
  {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++)
      parama.a(paramViewGroup.getChildAt(i), this, paramJSONObject);
  }

  @TargetApi(21)
  private void b(ViewGroup paramViewGroup, JSONObject paramJSONObject, a.a parama)
  {
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramViewGroup.getChildCount(); i++)
    {
      View localView = paramViewGroup.getChildAt(i);
      ArrayList localArrayList2 = (ArrayList)localHashMap.get(Float.valueOf(localView.getZ()));
      if (localArrayList2 == null)
      {
        localArrayList2 = new ArrayList();
        localHashMap.put(Float.valueOf(localView.getZ()), localArrayList2);
      }
      localArrayList2.add(localView);
    }
    ArrayList localArrayList1 = new ArrayList(localHashMap.keySet());
    Collections.sort(localArrayList1);
    Iterator localIterator1 = localArrayList1.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localHashMap.get((Float)localIterator1.next())).iterator();
      while (localIterator2.hasNext())
        parama.a((View)localIterator2.next(), this, paramJSONObject);
    }
  }

  public JSONObject a(View paramView)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    paramView.getLocationOnScreen(this.a);
    return b.a(this.a[0], this.a[1], i, j);
  }

  public void a(View paramView, JSONObject paramJSONObject, a.a parama, boolean paramBoolean)
  {
    if (!(paramView instanceof ViewGroup))
      return;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    if ((!paramBoolean) || (Build.VERSION.SDK_INT < 21))
    {
      a(localViewGroup, paramJSONObject, parama);
      return;
    }
    b(localViewGroup, paramJSONObject, parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.c.d
 * JD-Core Version:    0.6.2
 */