package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.yandex.mobile.ads.VideoController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a extends f
{
  private final VideoController h;
  private final dj i;
  private final ho j;
  private c k;
  private com.yandex.mobile.ads.mediation.banner.b l;
  private com.yandex.mobile.ads.mediation.banner.b m;
  private final ViewTreeObserver.OnPreDrawListener n = new ViewTreeObserver.OnPreDrawListener()
  {
    public final boolean onPreDraw()
    {
      new StringBuilder("onPreDraw(), clazz = ").append(this);
      a.c(a.this);
      a.e(a.this).postDelayed(new Runnable()
      {
        public final void run()
        {
          a.d(a.this);
        }
      }
      , 50L);
      return true;
    }
  };

  public a(Context paramContext, c paramc)
  {
    super(paramContext, com.yandex.mobile.ads.b.a);
    paramc.setHorizontalScrollBarEnabled(false);
    paramc.setVerticalScrollBarEnabled(false);
    paramc.setVisibility(8);
    paramc.setBackgroundColor(0);
    this.k = paramc;
    this.i = new dj();
    this.h = new VideoController(this.i);
    this.j = new ho();
  }

  private static void a(Context paramContext, com.yandex.mobile.ads.mediation.banner.b[] paramArrayOfb)
  {
    Iterator localIterator = new HashSet(Arrays.asList(paramArrayOfb)).iterator();
    while (localIterator.hasNext())
    {
      com.yandex.mobile.ads.mediation.banner.b localb = (com.yandex.mobile.ads.mediation.banner.b)localIterator.next();
      if (localb != null)
        localb.a(paramContext);
    }
  }

  private void c(boolean paramBoolean)
  {
    int i1 = 0;
    c localc = this.k;
    if ((localc != null) && (localc.getChildCount() > 0))
    {
      int i2 = localc.getChildCount();
      if (!paramBoolean);
      int i4;
      ArrayList localArrayList;
      for (int i3 = 1; ; i3 = 0)
      {
        i4 = i2 - i3;
        if (i4 <= 0)
          return;
        localArrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++)
        {
          View localView = localc.getChildAt(i5);
          if ((localView instanceof z))
            localArrayList.add((z)localView);
        }
      }
      localc.removeViews(0, i4);
      while (i1 < localArrayList.size())
      {
        ((z)localArrayList.get(i1)).g();
        i1++;
      }
      localArrayList.clear();
    }
  }

  private boolean c(aj paramaj)
  {
    if (paramaj != null)
    {
      aj localaj = this.f.b();
      if (localaj != null)
        return a(paramaj, localaj);
    }
    return false;
  }

  public final c a()
  {
    return this.k;
  }

  protected final gf a(String paramString, v<String> paramv, aj paramaj)
  {
    b localb = new b(this.b, paramv, paramaj);
    new gg();
    boolean bool = gg.a(paramString);
    gj.a();
    return gj.a(bool).a(localb, this, this.i);
  }

  public final void a(WebView paramWebView, Map<String, String> paramMap)
  {
    if (paramWebView != null)
    {
      final b localb = (b)paramWebView;
      if ((this.k != null) && (c(localb.c())))
      {
        this.k.setVisibility(0);
        this.a.post(new Runnable()
        {
          public final void run()
          {
            c localc = a.this.a();
            if ((localc != null) && (localc.indexOfChild(localb) == -1))
            {
              aj localaj = localb.c();
              RelativeLayout.LayoutParams localLayoutParams = fx.d.a(a.a(a.this), localaj);
              a.a(a.this, localc, localb);
              localc.addView(localb, localLayoutParams);
              dh.a(localb, a.b(a.this));
            }
          }
        });
        super.a(paramWebView, paramMap);
      }
    }
  }

  public final void a(v<String> paramv)
  {
    super.a(paramv);
    this.l = ho.a(paramv).a(this);
    this.l.a(this.b, paramv);
  }

  protected final boolean a(int paramInt)
  {
    if (this.k != null)
      return dh.a(this.k.findViewById(2), paramInt);
    return false;
  }

  protected final boolean a(aj paramaj)
  {
    int i1 = paramaj.b(this.b);
    int i2 = paramaj.a(this.b);
    return (i1 >= 0) && (i2 >= 0);
  }

  protected final boolean b()
  {
    return (this.k != null) && (!dh.d(this.k));
  }

  protected final boolean c()
  {
    if (this.k != null)
    {
      View localView = this.k.findViewById(2);
      return dh.a(this.b, localView);
    }
    return false;
  }

  final boolean d()
  {
    v localv = w();
    aj localaj = null;
    if (localv != null)
      localaj = localv.c();
    return (localaj != null) && (c(localaj));
  }

  public final void e()
  {
    super.e();
    if (this.k != null)
    {
      c(true);
      this.k.setVisibility(8);
      dh.a(this.k);
      this.k = null;
    }
  }

  public final void f()
  {
    Context localContext = this.b;
    com.yandex.mobile.ads.mediation.banner.b[] arrayOfb = new com.yandex.mobile.ads.mediation.banner.b[2];
    arrayOfb[0] = this.m;
    arrayOfb[1] = this.l;
    a(localContext, arrayOfb);
    super.f();
  }

  public final VideoController g()
  {
    return this.h;
  }

  public final void onAdLoaded()
  {
    super.onAdLoaded();
    if (this.m != this.l)
    {
      Context localContext = this.b;
      com.yandex.mobile.ads.mediation.banner.b[] arrayOfb = new com.yandex.mobile.ads.mediation.banner.b[1];
      arrayOfb[0] = this.m;
      a(localContext, arrayOfb);
      this.m = this.l;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.a
 * JD-Core Version:    0.6.2
 */