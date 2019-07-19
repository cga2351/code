package com.iab.omid.library.appnexus.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.appnexus.d.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class a
{
  private final HashMap<View, String> a = new HashMap();
  private final HashMap<View, ArrayList<String>> b = new HashMap();
  private final HashSet<View> c = new HashSet();
  private final HashSet<String> d = new HashSet();
  private final HashSet<String> e = new HashSet();
  private boolean f;

  private void a(View paramView, com.iab.omid.library.appnexus.adsession.a parama)
  {
    ArrayList localArrayList = (ArrayList)this.b.get(paramView);
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      this.b.put(paramView, localArrayList);
    }
    localArrayList.add(parama.getAdSessionId());
  }

  private void a(com.iab.omid.library.appnexus.adsession.a parama)
  {
    Iterator localIterator = parama.a().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((com.iab.omid.library.appnexus.e.a)localIterator.next()).get();
      if (localView != null)
        a(localView, parama);
    }
  }

  private boolean d(View paramView)
  {
    if (!paramView.hasWindowFocus())
      return false;
    HashSet localHashSet = new HashSet();
    if (paramView != null)
    {
      ViewParent localViewParent;
      if (f.d(paramView))
      {
        localHashSet.add(paramView);
        localViewParent = paramView.getParent();
        if (!(localViewParent instanceof View))
          break label63;
      }
      label63: for (View localView = (View)localViewParent; ; localView = null)
      {
        paramView = localView;
        break;
        return false;
      }
    }
    this.c.addAll(localHashSet);
    return true;
  }

  public String a(View paramView)
  {
    String str;
    if (this.a.size() == 0)
      str = null;
    do
    {
      return str;
      str = (String)this.a.get(paramView);
    }
    while (str == null);
    this.a.remove(paramView);
    return str;
  }

  public HashSet<String> a()
  {
    return this.d;
  }

  public ArrayList<String> b(View paramView)
  {
    Object localObject;
    if (this.b.size() == 0)
      localObject = null;
    do
    {
      return localObject;
      localObject = (ArrayList)this.b.get(paramView);
    }
    while (localObject == null);
    this.b.remove(paramView);
    Collections.sort((List)localObject);
    return localObject;
  }

  public HashSet<String> b()
  {
    return this.e;
  }

  public c c(View paramView)
  {
    if (this.c.contains(paramView))
      return c.a;
    if (this.f)
      return c.b;
    return c.c;
  }

  public void c()
  {
    com.iab.omid.library.appnexus.b.a locala = com.iab.omid.library.appnexus.b.a.a();
    if (locala != null)
    {
      Iterator localIterator = locala.c().iterator();
      while (localIterator.hasNext())
      {
        com.iab.omid.library.appnexus.adsession.a locala1 = (com.iab.omid.library.appnexus.adsession.a)localIterator.next();
        View localView = locala1.c();
        if (locala1.d())
          if ((localView != null) && (d(localView)))
          {
            this.d.add(locala1.getAdSessionId());
            this.a.put(localView, locala1.getAdSessionId());
            a(locala1);
          }
          else
          {
            this.e.add(locala1.getAdSessionId());
          }
      }
    }
  }

  public void d()
  {
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f = false;
  }

  public void e()
  {
    this.f = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.walking.a
 * JD-Core Version:    0.6.2
 */