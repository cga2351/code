package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;

class b
{

  @VisibleForTesting
  final ViewTreeObserver.OnPreDrawListener a;

  @VisibleForTesting
  WeakReference<ViewTreeObserver> b;
  private final View c;
  private final View d;
  private final a e;
  private c f;
  private final b g;
  private final Handler h;
  private boolean i;
  private boolean j;

  @VisibleForTesting
  public b(Context paramContext, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramView1);
    Preconditions.checkNotNull(paramView2);
    this.d = paramView1;
    this.c = paramView2;
    this.e = new a(paramInt1, paramInt2);
    this.h = new Handler();
    this.g = new b();
    this.a = new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        b.this.b();
        return true;
      }
    };
    this.b = new WeakReference(null);
    a(paramContext, this.c);
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

  void a()
  {
    this.h.removeMessages(0);
    this.i = false;
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.b.get();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()))
      localViewTreeObserver.removeOnPreDrawListener(this.a);
    this.b.clear();
    this.f = null;
  }

  void a(c paramc)
  {
    this.f = paramc;
  }

  void b()
  {
    if (this.i)
      return;
    this.i = true;
    this.h.postDelayed(this.g, 100L);
  }

  static class a
  {
    private int a;
    private int b;
    private long c = -9223372036854775808L;
    private final Rect d = new Rect();

    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    boolean a()
    {
      return this.c != -9223372036854775808L;
    }

    boolean a(View paramView1, View paramView2)
    {
      if ((paramView2 == null) || (paramView2.getVisibility() != 0) || (paramView1.getParent() == null));
      while ((paramView2.getWidth() <= 0) || (paramView2.getHeight() <= 0) || (!paramView2.getGlobalVisibleRect(this.d)) || (Dips.pixelsToIntDips(this.d.width(), paramView2.getContext()) * Dips.pixelsToIntDips(this.d.height(), paramView2.getContext()) < this.a))
        return false;
      return true;
    }

    void b()
    {
      this.c = SystemClock.uptimeMillis();
    }

    boolean c()
    {
      if (!a());
      while (SystemClock.uptimeMillis() - this.c < this.b)
        return false;
      return true;
    }
  }

  class b
    implements Runnable
  {
    b()
    {
    }

    public void run()
    {
      if (b.a(b.this));
      do
      {
        return;
        b.a(b.this, false);
        if (b.d(b.this).a(b.b(b.this), b.c(b.this)))
        {
          if (!b.d(b.this).a())
            b.d(b.this).b();
          if ((b.d(b.this).c()) && (b.e(b.this) != null))
          {
            b.e(b.this).onVisibilityChanged();
            b.b(b.this, true);
          }
        }
      }
      while (b.a(b.this));
      b.this.b();
    }
  }

  static abstract interface c
  {
    public abstract void onVisibilityChanged();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.b
 * JD-Core Version:    0.6.2
 */