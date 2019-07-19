package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibilityTracker.VisibilityChecker;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import com.mopub.common.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class ImpressionTracker
{
  private final VisibilityTracker a;
  private final Map<View, ImpressionInterface> b;
  private final Map<View, k<ImpressionInterface>> c;
  private final Handler d;
  private final a e;
  private final VisibilityTracker.VisibilityChecker f;
  private VisibilityTracker.VisibilityTrackerListener g;

  public ImpressionTracker(Context paramContext)
  {
    this(new WeakHashMap(), new WeakHashMap(), new VisibilityTracker.VisibilityChecker(), new VisibilityTracker(paramContext), new Handler(Looper.getMainLooper()));
  }

  @VisibleForTesting
  ImpressionTracker(Map<View, ImpressionInterface> paramMap, Map<View, k<ImpressionInterface>> paramMap1, VisibilityTracker.VisibilityChecker paramVisibilityChecker, VisibilityTracker paramVisibilityTracker, Handler paramHandler)
  {
    this.b = paramMap;
    this.c = paramMap1;
    this.f = paramVisibilityChecker;
    this.a = paramVisibilityTracker;
    this.g = new VisibilityTracker.VisibilityTrackerListener()
    {
      public void onVisibilityChanged(List<View> paramAnonymousList1, List<View> paramAnonymousList2)
      {
        Iterator localIterator1 = paramAnonymousList1.iterator();
        while (localIterator1.hasNext())
        {
          View localView2 = (View)localIterator1.next();
          ImpressionInterface localImpressionInterface = (ImpressionInterface)ImpressionTracker.a(ImpressionTracker.this).get(localView2);
          if (localImpressionInterface == null)
          {
            ImpressionTracker.this.removeView(localView2);
          }
          else
          {
            k localk = (k)ImpressionTracker.b(ImpressionTracker.this).get(localView2);
            if ((localk == null) || (!localImpressionInterface.equals(localk.a)))
              ImpressionTracker.b(ImpressionTracker.this).put(localView2, new k(localImpressionInterface));
          }
        }
        Iterator localIterator2 = paramAnonymousList2.iterator();
        while (localIterator2.hasNext())
        {
          View localView1 = (View)localIterator2.next();
          ImpressionTracker.b(ImpressionTracker.this).remove(localView1);
        }
        ImpressionTracker.this.a();
      }
    };
    this.a.setVisibilityTrackerListener(this.g);
    this.d = paramHandler;
    this.e = new a();
  }

  private void a(View paramView)
  {
    this.c.remove(paramView);
  }

  @VisibleForTesting
  void a()
  {
    if (this.d.hasMessages(0))
      return;
    this.d.postDelayed(this.e, 250L);
  }

  public void addView(View paramView, ImpressionInterface paramImpressionInterface)
  {
    if (this.b.get(paramView) == paramImpressionInterface);
    do
    {
      return;
      removeView(paramView);
    }
    while (paramImpressionInterface.isImpressionRecorded());
    this.b.put(paramView, paramImpressionInterface);
    this.a.addView(paramView, paramImpressionInterface.getImpressionMinPercentageViewed(), paramImpressionInterface.getImpressionMinVisiblePx());
  }

  public void clear()
  {
    this.b.clear();
    this.c.clear();
    this.a.clear();
    this.d.removeMessages(0);
  }

  public void destroy()
  {
    clear();
    this.a.destroy();
    this.g = null;
  }

  public void removeView(View paramView)
  {
    this.b.remove(paramView);
    a(paramView);
    this.a.removeView(paramView);
  }

  @VisibleForTesting
  class a
    implements Runnable
  {
    private final ArrayList<View> b = new ArrayList();

    a()
    {
    }

    public void run()
    {
      Iterator localIterator1 = ImpressionTracker.b(ImpressionTracker.this).entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        View localView2 = (View)localEntry.getKey();
        k localk = (k)localEntry.getValue();
        if (ImpressionTracker.c(ImpressionTracker.this).hasRequiredTimeElapsed(localk.b, ((ImpressionInterface)localk.a).getImpressionMinTimeViewed()))
        {
          ((ImpressionInterface)localk.a).recordImpression(localView2);
          ((ImpressionInterface)localk.a).setImpressionRecorded();
          this.b.add(localView2);
        }
      }
      Iterator localIterator2 = this.b.iterator();
      while (localIterator2.hasNext())
      {
        View localView1 = (View)localIterator2.next();
        ImpressionTracker.this.removeView(localView1);
      }
      this.b.clear();
      if (!ImpressionTracker.b(ImpressionTracker.this).isEmpty())
        ImpressionTracker.this.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.ImpressionTracker
 * JD-Core Version:    0.6.2
 */