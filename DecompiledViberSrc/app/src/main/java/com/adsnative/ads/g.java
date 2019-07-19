package com.adsnative.ads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class g
{
  private final ah a;
  private final Map<View, n> b;
  private final Map<View, af<n>> c;
  private final Handler d;
  private final a e;
  private final ah.b f;
  private ah.d g;

  g(Context paramContext)
  {
    this(new WeakHashMap(), new WeakHashMap(), new ah.b(), new ah(paramContext), new Handler());
  }

  g(Map<View, n> paramMap, Map<View, af<n>> paramMap1, ah.b paramb, ah paramah, Handler paramHandler)
  {
    this.b = paramMap;
    this.c = paramMap1;
    this.f = paramb;
    this.a = paramah;
    this.g = new ah.d()
    {
      public void a(List<View> paramAnonymousList1, List<View> paramAnonymousList2, List<View> paramAnonymousList3)
      {
        Iterator localIterator1 = paramAnonymousList2.iterator();
        while (localIterator1.hasNext())
        {
          View localView3 = (View)localIterator1.next();
          n localn2 = (n)g.a(g.this).get(localView3);
          if (localn2 == null)
            g.this.a(localView3);
          else
            localn2.b(localView3);
        }
        Iterator localIterator2 = paramAnonymousList1.iterator();
        while (localIterator2.hasNext())
        {
          View localView2 = (View)localIterator2.next();
          n localn1 = (n)g.a(g.this).get(localView2);
          if (localn1 == null)
          {
            g.this.a(localView2);
          }
          else
          {
            af localaf = (af)g.b(g.this).get(localView2);
            if ((localaf == null) || (!localn1.equals(localaf.a)))
              g.b(g.this).put(localView2, new af(localn1));
          }
        }
        Iterator localIterator3 = paramAnonymousList3.iterator();
        while (localIterator3.hasNext())
        {
          View localView1 = (View)localIterator3.next();
          g.b(g.this).remove(localView1);
        }
        g.this.a();
      }
    };
    this.a.a(this.g);
    this.d = paramHandler;
    this.e = new a();
  }

  private void b(View paramView)
  {
    this.c.remove(paramView);
  }

  void a()
  {
    if (this.d.hasMessages(0))
      return;
    this.d.postDelayed(this.e, 250L);
  }

  void a(View paramView)
  {
    this.b.remove(paramView);
    b(paramView);
    this.a.a(paramView);
  }

  void a(View paramView, n paramn)
  {
    if (this.b.get(paramView) == paramn);
    do
    {
      return;
      a(paramView);
    }
    while (((paramn.L()) && (paramn.M())) || (paramn.O()));
    this.b.put(paramView, paramn);
    this.a.a(paramView, paramn.D(), paramn.E());
  }

  class a
    implements Runnable
  {
    private final ArrayList<View> b = new ArrayList();

    a()
    {
    }

    public void run()
    {
      Iterator localIterator1 = g.b(g.this).entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        View localView2 = (View)localEntry.getKey();
        af localaf = (af)localEntry.getValue();
        if (g.c(g.this).a(localaf.b, ((n)localaf.a).C()))
        {
          ((n)localaf.a).J();
          this.b.add(localView2);
        }
      }
      Iterator localIterator2 = this.b.iterator();
      while (localIterator2.hasNext())
      {
        View localView1 = (View)localIterator2.next();
        g.this.a(localView1);
      }
      this.b.clear();
      if (!g.b(g.this).isEmpty())
        g.this.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.g
 * JD-Core Version:    0.6.2
 */