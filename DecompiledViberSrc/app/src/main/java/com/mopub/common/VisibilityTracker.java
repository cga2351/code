package com.mopub.common;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class VisibilityTracker
{

  @VisibleForTesting
  final ViewTreeObserver.OnPreDrawListener a;

  @VisibleForTesting
  WeakReference<ViewTreeObserver> b;
  private final ArrayList<View> c;
  private long d = 0L;
  private final Map<View, a> e;
  private final VisibilityChecker f;
  private VisibilityTrackerListener g;
  private final b h;
  private final Handler i;
  private boolean j;

  public VisibilityTracker(Context paramContext)
  {
    this(paramContext, new WeakHashMap(10), new VisibilityChecker(), new Handler());
  }

  @VisibleForTesting
  VisibilityTracker(Context paramContext, Map<View, a> paramMap, VisibilityChecker paramVisibilityChecker, Handler paramHandler)
  {
    this.e = paramMap;
    this.f = paramVisibilityChecker;
    this.i = paramHandler;
    this.h = new b();
    this.c = new ArrayList(50);
    this.a = new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        VisibilityTracker.this.scheduleVisibilityCheck();
        return true;
      }
    };
    this.b = new WeakReference(null);
    a(paramContext, null);
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
      removeView((View)localIterator2.next());
    this.c.clear();
  }

  private void a(Context paramContext, View paramView)
  {
    ViewTreeObserver localViewTreeObserver1 = (ViewTreeObserver)this.b.get();
    if ((localViewTreeObserver1 != null) && (localViewTreeObserver1.isAlive()))
      return;
    View localView = Views.getTopmostView(paramContext, paramView);
    if (localView == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to set Visibility Tracker due to no available root view." });
      return;
    }
    ViewTreeObserver localViewTreeObserver2 = localView.getViewTreeObserver();
    if (!localViewTreeObserver2.isAlive())
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Visibility Tracker was unable to track views because the root view tree observer was not alive" });
      return;
    }
    this.b = new WeakReference(localViewTreeObserver2);
    localViewTreeObserver2.addOnPreDrawListener(this.a);
  }

  public void addView(View paramView, int paramInt, Integer paramInteger)
  {
    addView(paramView, paramView, paramInt, paramInteger);
  }

  public void addView(View paramView1, View paramView2, int paramInt1, int paramInt2, Integer paramInteger)
  {
    a(paramView2.getContext(), paramView2);
    a locala = (a)this.e.get(paramView2);
    if (locala == null)
    {
      locala = new a();
      this.e.put(paramView2, locala);
      scheduleVisibilityCheck();
    }
    int k = Math.min(paramInt2, paramInt1);
    locala.d = paramView1;
    locala.a = paramInt1;
    locala.b = k;
    locala.c = this.d;
    locala.e = paramInteger;
    this.d = (1L + this.d);
    if (this.d % 50L == 0L)
      a(this.d - 50L);
  }

  public void addView(View paramView1, View paramView2, int paramInt, Integer paramInteger)
  {
    addView(paramView1, paramView2, paramInt, paramInt, paramInteger);
  }

  public void clear()
  {
    this.e.clear();
    this.i.removeMessages(0);
    this.j = false;
  }

  public void destroy()
  {
    clear();
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.b.get();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()))
      localViewTreeObserver.removeOnPreDrawListener(this.a);
    this.b.clear();
    this.g = null;
  }

  public void removeView(View paramView)
  {
    this.e.remove(paramView);
  }

  public void scheduleVisibilityCheck()
  {
    if (this.j)
      return;
    this.j = true;
    this.i.postDelayed(this.h, 100L);
  }

  public void setVisibilityTrackerListener(VisibilityTrackerListener paramVisibilityTrackerListener)
  {
    this.g = paramVisibilityTrackerListener;
  }

  public static class VisibilityChecker
  {
    private final Rect a = new Rect();

    public boolean hasRequiredTimeElapsed(long paramLong, int paramInt)
    {
      return SystemClock.uptimeMillis() - paramLong >= paramInt;
    }

    public boolean isVisible(View paramView1, View paramView2, int paramInt, Integer paramInteger)
    {
      boolean bool = true;
      if ((paramView2 == null) || (paramView2.getVisibility() != 0) || (paramView1.getParent() == null));
      long l1;
      long l2;
      do
      {
        do
          return false;
        while (!paramView2.getGlobalVisibleRect(this.a));
        l1 = this.a.height() * this.a.width();
        l2 = paramView2.getHeight() * paramView2.getWidth();
      }
      while (l2 <= 0L);
      if ((paramInteger != null) && (paramInteger.intValue() > 0))
      {
        if (l1 >= paramInteger.intValue());
        while (true)
        {
          return bool;
          bool = false;
        }
      }
      if (l1 * 100L >= l2 * paramInt);
      while (true)
      {
        return bool;
        bool = false;
      }
    }
  }

  public static abstract interface VisibilityTrackerListener
  {
    public abstract void onVisibilityChanged(List<View> paramList1, List<View> paramList2);
  }

  static class a
  {
    int a;
    int b;
    long c;
    View d;
    Integer e;
  }

  class b
    implements Runnable
  {
    private final ArrayList<View> b = new ArrayList();
    private final ArrayList<View> c = new ArrayList();

    b()
    {
    }

    public void run()
    {
      VisibilityTracker.a(VisibilityTracker.this, false);
      Iterator localIterator = VisibilityTracker.a(VisibilityTracker.this).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        View localView1 = (View)localEntry.getKey();
        int i = ((VisibilityTracker.a)localEntry.getValue()).a;
        int j = ((VisibilityTracker.a)localEntry.getValue()).b;
        Integer localInteger = ((VisibilityTracker.a)localEntry.getValue()).e;
        View localView2 = ((VisibilityTracker.a)localEntry.getValue()).d;
        if (VisibilityTracker.b(VisibilityTracker.this).isVisible(localView2, localView1, i, localInteger))
          this.b.add(localView1);
        else if (!VisibilityTracker.b(VisibilityTracker.this).isVisible(localView2, localView1, j, null))
          this.c.add(localView1);
      }
      if (VisibilityTracker.c(VisibilityTracker.this) != null)
        VisibilityTracker.c(VisibilityTracker.this).onVisibilityChanged(this.b, this.c);
      this.b.clear();
      this.c.clear();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.VisibilityTracker
 * JD-Core Version:    0.6.2
 */