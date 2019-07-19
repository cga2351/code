package com.adsnative.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import com.adsnative.c.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class ah
{
  ViewTreeObserver.OnPreDrawListener a;
  final WeakReference<View> b;
  private final ArrayList<View> c;
  private long d = 0L;
  private final Map<View, a> e;
  private final b f;
  private d g;
  private final c h;
  private final Handler i;
  private boolean j;

  public ah(Context paramContext)
  {
    this(paramContext, new WeakHashMap(10), new b(), new Handler());
  }

  ah(Context paramContext, Map<View, a> paramMap, b paramb, Handler paramHandler)
  {
    this.e = paramMap;
    this.f = paramb;
    this.i = paramHandler;
    this.h = new c();
    this.c = new ArrayList(50);
    View localView = ((Activity)paramContext).getWindow().getDecorView();
    this.b = new WeakReference(localView);
    ViewTreeObserver localViewTreeObserver = localView.getViewTreeObserver();
    if (!localViewTreeObserver.isAlive())
    {
      i.d("Visibility Tracker was unable to track views because the root view tree observer was not alive");
      return;
    }
    this.a = new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        ah.this.a();
        return true;
      }
    };
    localViewTreeObserver.addOnPreDrawListener(this.a);
  }

  private void a(long paramLong)
  {
    Iterator localIterator1 = this.e.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (((a)localEntry.getValue()).c < paramLong)
        this.c.add(localEntry.getKey());
    }
    Iterator localIterator2 = this.c.iterator();
    while (localIterator2.hasNext())
      a((View)localIterator2.next());
    this.c.clear();
  }

  void a()
  {
    if (this.j)
      return;
    this.j = true;
    this.i.postDelayed(this.h, 100L);
  }

  void a(View paramView)
  {
    this.e.remove(paramView);
  }

  void a(View paramView, int paramInt1, int paramInt2)
  {
    a locala = (a)this.e.get(paramView);
    if (locala == null)
    {
      locala = new a();
      this.e.put(paramView, locala);
      a();
    }
    locala.a = paramInt1;
    locala.b = paramInt2;
    locala.c = this.d;
    this.d = (1L + this.d);
    if (this.d % 50L == 0L)
      a(this.d - 50L);
  }

  void a(d paramd)
  {
    this.g = paramd;
  }

  static class a
  {
    int a;
    int b;
    long c;
  }

  static class b
  {
    private final Rect a = new Rect();

    boolean a(long paramLong, int paramInt)
    {
      return SystemClock.uptimeMillis() - paramLong >= paramInt;
    }

    boolean a(View paramView, int paramInt)
    {
      if ((paramView == null) || (paramView.getVisibility() != 0) || (paramView.getParent() == null));
      long l1;
      long l2;
      do
      {
        do
          return false;
        while (!paramView.getGlobalVisibleRect(this.a));
        l1 = this.a.height() * this.a.width();
        l2 = paramView.getHeight() * paramView.getWidth();
      }
      while ((l2 <= 0L) || (l1 * 100L < l2 * paramInt));
      return true;
    }

    boolean a(View paramView, Integer paramInteger)
    {
      if ((paramView == null) || (paramView.getVisibility() != 0) || (paramView.getParent() == null));
      long l;
      do
      {
        do
          return false;
        while (!paramView.getGlobalVisibleRect(this.a));
        l = this.a.height() * this.a.width();
      }
      while ((paramView.getHeight() * paramView.getWidth() <= 0L) || (paramInteger == null) || (paramInteger.intValue() <= 0) || (l < paramInteger.intValue()));
      return true;
    }
  }

  class c
    implements Runnable
  {
    private final ArrayList<View> b = new ArrayList();
    private final ArrayList<View> c = new ArrayList();
    private final ArrayList<View> d = new ArrayList();

    c()
    {
    }

    public void run()
    {
      ah.a(ah.this, false);
      Iterator localIterator = ah.a(ah.this).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        View localView = (View)localEntry.getKey();
        int i = ((ah.a)localEntry.getValue()).a;
        int j = ((ah.a)localEntry.getValue()).b;
        if (ah.b(ah.this).a(localView, Integer.valueOf(j)))
          this.d.add(localView);
        if (ah.b(ah.this).a(localView, i))
          this.b.add(localView);
        else
          this.c.add(localView);
      }
      if (ah.c(ah.this) != null)
        ah.c(ah.this).a(this.b, this.d, this.c);
      this.b.clear();
      this.c.clear();
      this.d.clear();
    }
  }

  static abstract interface d
  {
    public abstract void a(List<View> paramList1, List<View> paramList2, List<View> paramList3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.ah
 * JD-Core Version:    0.6.2
 */