package com.mixpanel.android.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class d extends k<Activity>
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private final Map<String, List<o>> b = new HashMap();
  private final Set<a> c = new HashSet();

  private void a(View paramView, List<o> paramList)
  {
    synchronized (this.c)
    {
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        a locala = new a(paramView, (o)paramList.get(j), this.a);
        this.c.add(locala);
      }
      return;
    }
  }

  private void b()
  {
    if (Thread.currentThread() == this.a.getLooper().getThread())
    {
      c();
      return;
    }
    this.a.post(new Runnable()
    {
      public void run()
      {
        d.a(d.this);
      }
    });
  }

  private void c()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      String str = localActivity.getClass().getCanonicalName();
      View localView = localActivity.getWindow().getDecorView().getRootView();
      synchronized (this.b)
      {
        List localList1 = (List)this.b.get(str);
        List localList2 = (List)this.b.get(null);
        if (localList1 != null)
          a(localView, localList1);
        if (localList2 != null)
          a(localView, localList2);
      }
    }
  }

  public void a(Activity paramActivity)
  {
    super.b(paramActivity);
    b();
  }

  public void a(Map<String, List<o>> paramMap)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      if (localIterator.hasNext())
        ((a)localIterator.next()).a();
    }
    this.c.clear();
    synchronized (this.b)
    {
      this.b.clear();
      this.b.putAll(paramMap);
      b();
      return;
    }
  }

  public void b(Activity paramActivity)
  {
    super.a(paramActivity);
  }

  private static class a
    implements ViewTreeObserver.OnGlobalLayoutListener, Runnable
  {
    private volatile boolean a;
    private boolean b;
    private final WeakReference<View> c;
    private final o d;
    private final Handler e;

    public a(View paramView, o paramo, Handler paramHandler)
    {
      this.d = paramo;
      this.c = new WeakReference(paramView);
      this.e = paramHandler;
      this.b = true;
      this.a = false;
      ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
        localViewTreeObserver.addOnGlobalLayoutListener(this);
      run();
    }

    private void b()
    {
      if (this.b)
      {
        View localView = (View)this.c.get();
        if (localView != null)
        {
          ViewTreeObserver localViewTreeObserver = localView.getViewTreeObserver();
          if (localViewTreeObserver.isAlive())
            localViewTreeObserver.removeGlobalOnLayoutListener(this);
        }
        this.d.a();
      }
      this.b = false;
    }

    public void a()
    {
      this.a = true;
      this.e.post(this);
    }

    public void onGlobalLayout()
    {
      run();
    }

    public void run()
    {
      if (!this.b)
        return;
      View localView = (View)this.c.get();
      if ((localView == null) || (this.a))
      {
        b();
        return;
      }
      this.d.b(localView);
      this.e.removeCallbacks(this);
      this.e.postDelayed(this, 1000L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.d
 * JD-Core Version:    0.6.2
 */