package com.appnexus.opensdk;

import android.graphics.Rect;
import android.view.View;
import com.appnexus.opensdk.utils.Clog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class v
{
  private boolean a = false;
  private View b;
  private ArrayList<a> c;
  private Runnable d;
  private ScheduledExecutorService e;

  private v(View paramView)
  {
    this.b = paramView;
    this.c = new ArrayList();
    a();
  }

  static v a(View paramView)
  {
    if (paramView == null)
    {
      Clog.d(Clog.nativeLogTag, "Unable to check visibility");
      return null;
    }
    return new v(paramView);
  }

  void a()
  {
    if (this.a)
      return;
    this.a = true;
    this.d = new Runnable()
    {
      public void run()
      {
        if (v.a(v.this) != null)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator1 = v.a(v.this).iterator();
          while (localIterator1.hasNext())
            localArrayList.add((v.a)localIterator1.next());
          if (v.this.b())
          {
            Iterator localIterator3 = localArrayList.iterator();
            while (localIterator3.hasNext())
              ((v.a)localIterator3.next()).a(true);
          }
          Iterator localIterator2 = localArrayList.iterator();
          while (localIterator2.hasNext())
            ((v.a)localIterator2.next()).a(false);
        }
      }
    };
    this.e = Executors.newSingleThreadScheduledExecutor();
    this.e.scheduleAtFixedRate(new Runnable()
    {
      public void run()
      {
        v.c(v.this).post(v.b(v.this));
      }
    }
    , 0L, 250L, TimeUnit.MILLISECONDS);
  }

  void a(a parama)
  {
    if (parama != null)
      this.c.add(parama);
  }

  boolean b()
  {
    if ((this.b == null) || (this.b.getVisibility() != 0) || (this.b.getParent() == null));
    int i;
    int j;
    do
    {
      Rect localRect;
      do
      {
        return false;
        localRect = new Rect();
      }
      while (!this.b.getGlobalVisibleRect(localRect));
      i = localRect.height() * localRect.width();
      j = this.b.getHeight() * this.b.getWidth();
    }
    while ((j <= 0) || (i * 100 < j * 50));
    return true;
  }

  boolean b(a parama)
  {
    return this.c.remove(parama);
  }

  void c()
  {
    if (this.e != null)
      this.e.shutdownNow();
    this.b.removeCallbacks(this.d);
    this.b = null;
    this.c = null;
  }

  static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.v
 * JD-Core Version:    0.6.2
 */