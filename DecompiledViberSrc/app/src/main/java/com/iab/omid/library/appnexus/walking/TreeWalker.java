package com.iab.omid.library.appnexus.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.appnexus.c.a.a;
import com.iab.omid.library.appnexus.d.d;
import com.iab.omid.library.appnexus.d.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class TreeWalker
  implements a.a
{
  private static TreeWalker a = new TreeWalker();
  private static Handler b = new Handler(Looper.getMainLooper());
  private static Handler c = null;
  private static final Runnable j = new Runnable()
  {
    public void run()
    {
      TreeWalker.b(TreeWalker.getInstance());
    }
  };
  private static final Runnable k = new Runnable()
  {
    public void run()
    {
      if (TreeWalker.e() != null)
      {
        TreeWalker.e().post(TreeWalker.f());
        TreeWalker.e().postDelayed(TreeWalker.g(), 200L);
      }
    }
  };
  private List<TreeWalkerTimeLogger> d = new ArrayList();
  private int e;
  private com.iab.omid.library.appnexus.c.b f = new com.iab.omid.library.appnexus.c.b();
  private a g = new a();
  private b h = new b(new com.iab.omid.library.appnexus.walking.a.c());
  private double i;

  private void a(long paramLong)
  {
    if (this.d.size() > 0)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
        ((TreeWalkerTimeLogger)localIterator.next()).onTreeProcessed(this.e, paramLong);
    }
  }

  private void a(View paramView, com.iab.omid.library.appnexus.c.a parama, JSONObject paramJSONObject, c paramc)
  {
    if (paramc == c.a);
    for (boolean bool = true; ; bool = false)
    {
      parama.a(paramView, paramJSONObject, this, bool);
      return;
    }
  }

  private boolean a(View paramView, JSONObject paramJSONObject)
  {
    String str = this.g.a(paramView);
    if (str != null)
    {
      com.iab.omid.library.appnexus.d.b.a(paramJSONObject, str);
      this.g.e();
      return true;
    }
    return false;
  }

  private void b(View paramView, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = this.g.b(paramView);
    if (localArrayList != null)
      com.iab.omid.library.appnexus.d.b.a(paramJSONObject, localArrayList);
  }

  public static TreeWalker getInstance()
  {
    return a;
  }

  private void h()
  {
    i();
    d();
    j();
  }

  private void i()
  {
    this.e = 0;
    this.i = d.a();
  }

  private void j()
  {
    a(()(d.a() - this.i));
  }

  private void k()
  {
    if (c == null)
    {
      c = new Handler(Looper.getMainLooper());
      c.post(j);
      c.postDelayed(k, 200L);
    }
  }

  private void l()
  {
    if (c != null)
    {
      c.removeCallbacks(k);
      c = null;
    }
  }

  public void a()
  {
    k();
  }

  public void a(View paramView, com.iab.omid.library.appnexus.c.a parama, JSONObject paramJSONObject)
  {
    if (!f.d(paramView));
    c localc;
    do
    {
      return;
      localc = this.g.c(paramView);
    }
    while (localc == c.c);
    JSONObject localJSONObject = parama.a(paramView);
    com.iab.omid.library.appnexus.d.b.a(paramJSONObject, localJSONObject);
    if (!a(paramView, localJSONObject))
    {
      b(paramView, localJSONObject);
      a(paramView, parama, localJSONObject, localc);
    }
    this.e = (1 + this.e);
  }

  public void addTimeLogger(TreeWalkerTimeLogger paramTreeWalkerTimeLogger)
  {
    if (!this.d.contains(paramTreeWalkerTimeLogger))
      this.d.add(paramTreeWalkerTimeLogger);
  }

  public void b()
  {
    c();
    this.d.clear();
    b.post(new Runnable()
    {
      public void run()
      {
        TreeWalker.a(TreeWalker.this).a();
      }
    });
  }

  public void c()
  {
    l();
  }

  void d()
  {
    this.g.c();
    double d1 = d.a();
    com.iab.omid.library.appnexus.c.a locala = this.f.a();
    if (this.g.b().size() > 0)
    {
      JSONObject localJSONObject2 = locala.a(null);
      this.h.b(localJSONObject2, this.g.b(), d1);
    }
    if (this.g.a().size() > 0)
    {
      JSONObject localJSONObject1 = locala.a(null);
      a(null, locala, localJSONObject1, c.a);
      com.iab.omid.library.appnexus.d.b.a(localJSONObject1);
      this.h.a(localJSONObject1, this.g.a(), d1);
    }
    while (true)
    {
      this.g.d();
      return;
      this.h.a();
    }
  }

  public void removeTimeLogger(TreeWalkerTimeLogger paramTreeWalkerTimeLogger)
  {
    if (this.d.contains(paramTreeWalkerTimeLogger))
      this.d.remove(paramTreeWalkerTimeLogger);
  }

  public static abstract interface TreeWalkerTimeLogger
  {
    public abstract void onTreeProcessed(int paramInt, long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.walking.TreeWalker
 * JD-Core Version:    0.6.2
 */