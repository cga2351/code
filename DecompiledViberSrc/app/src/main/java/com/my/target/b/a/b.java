package com.my.target.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.my.target.ar;
import com.my.target.ax;
import com.my.target.be;
import com.my.target.bj;
import com.my.target.bz;
import com.my.target.bz.a;
import com.my.target.cb;
import com.my.target.cc;
import com.my.target.cc.a;
import com.my.target.cd;
import com.my.target.common.a.c;
import com.my.target.dp;
import com.my.target.k;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private final boolean a;
  private final boolean b;
  private final a c;
  private final com.my.target.b.c.a.a d;
  private final cd e;
  private int f = 0;
  private WeakReference<View> g;
  private WeakReference<cc> h;
  private WeakReference<bz> i;
  private HashSet<WeakReference<View>> j;
  private a k;
  private WeakReference<com.my.target.c.b.a> l;
  private boolean m;
  private Parcelable n;
  private boolean o;

  private b(com.my.target.b.c.a.a parama, a parama1)
  {
    this.c = parama1;
    this.d = parama;
    boolean bool2;
    if (parama.G().size() > 0)
    {
      bool2 = bool1;
      this.a = bool2;
      k localk = parama.F();
      if ((localk == null) || (localk.F() == null))
        break label84;
    }
    while (true)
    {
      this.b = bool1;
      this.e = cd.a(parama.C());
      return;
      bool2 = false;
      break;
      label84: bool1 = false;
    }
  }

  public static b a(com.my.target.b.c.a.a parama, a parama1)
  {
    return new b(parama, parama1);
  }

  private static cb a(com.my.target.c.b.a parama)
  {
    for (int i1 = 0; i1 < parama.getChildCount(); i1++)
    {
      View localView = parama.getChildAt(i1);
      if ((localView instanceof cb))
        return (cb)localView;
    }
    return null;
  }

  private void a(View paramView)
  {
    ViewGroup localViewGroup;
    com.my.target.c.b.a locala;
    com.my.target.common.a.b localb;
    int i3;
    int i2;
    if ((paramView instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)paramView;
      if ((this.a) && ((localViewGroup instanceof com.my.target.c.b.b)))
      {
        com.my.target.c.b.b localb1 = (com.my.target.c.b.b)localViewGroup;
        this.f = 2;
        localb1.setPromoCardSliderListener(this.c);
        if (this.n != null)
          localb1.a(this.n);
        this.h = new WeakReference(localb1);
        return;
      }
      if ((localViewGroup instanceof com.my.target.c.b.a))
      {
        locala = (com.my.target.c.b.a)localViewGroup;
        this.l = new WeakReference(locala);
        localb = this.d.l();
        if (localb == null)
          break label693;
        int i4 = localb.b();
        int i5 = localb.c();
        locala.a(i4, i5);
        i3 = i4;
        i2 = i5;
      }
    }
    while (true)
    {
      if (this.a)
      {
        if (this.f == 2)
          break;
        this.f = 3;
        com.my.target.b.c.a.a locala3 = this.d;
        Context localContext2 = locala.getContext();
        cb localcb = a(locala);
        if (localcb == null)
        {
          localcb = new cb(localContext2);
          locala.addView(localcb, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.n != null)
          localcb.a(this.n);
        if ((this.j == null) || (this.m));
        for (boolean bool = true; ; bool = false)
        {
          localcb.setClickable(bool);
          localcb.setupCards(locala3.G());
          localcb.setPromoCardSliderListener(this.c);
          locala.setBackgroundColor(0);
          localcb.setVisibility(0);
          return;
        }
      }
      ax localax = (ax)locala.getImageView();
      label335: k localk;
      if (localb != null)
      {
        Bitmap localBitmap = localb.e();
        if (localBitmap != null)
        {
          localax.setImageBitmap(localBitmap);
          if (!this.b)
            break label552;
          this.f = 1;
          localk = this.d.F();
          if (localk == null)
            break label687;
          if ((i2 == 0) || (i3 == 0))
            locala.a(localk.u(), localk.i());
        }
      }
      label552: label687: for (c localc = (c)localk.F(); ; localc = null)
      {
        if ((this.k == null) && (localc != null))
        {
          this.f = 1;
          this.k = new a(this.d, localk, localc);
        }
        if (this.k == null)
          break;
        a locala1 = this.c;
        if (this.k == null)
          break;
        this.k.a(locala1);
        a locala2 = this.k;
        locala2.a(this.c);
        WeakReference localWeakReference = this.g;
        Context localContext1 = null;
        if (localWeakReference != null)
        {
          View localView2 = (View)this.g.get();
          localContext1 = null;
          if (localView2 != null)
            localContext1 = localView2.getContext();
        }
        locala2.a(locala, localContext1);
        return;
        localax.setImageBitmap(null);
        be.a(localb, localax);
        break label335;
        localax.setImageBitmap(null);
        break label335;
        this.f = 0;
        locala.getImageView().setVisibility(0);
        locala.getPlayButtonView().setVisibility(8);
        locala.getProgressBarView().setVisibility(8);
        if ((this.j != null) && (!this.m))
          break;
        locala.setOnClickListener(this.c);
        return;
        HashSet localHashSet = this.j;
        int i1 = 0;
        if (localHashSet == null)
          localViewGroup.setOnClickListener(this.c);
        while (i1 < localViewGroup.getChildCount())
        {
          View localView1 = localViewGroup.getChildAt(i1);
          if (localView1 != null)
            a(localView1);
          i1++;
        }
        break;
        if (((paramView instanceof ar)) || (this.j != null))
          break;
        paramView.setOnClickListener(this.c);
        return;
      }
      label693: i2 = 0;
      i3 = 0;
    }
  }

  private void b(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      if ((!(paramView instanceof RecyclerView)) && (!(paramView instanceof com.my.target.c.b.a)))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        for (int i1 = 0; i1 < localViewGroup.getChildCount(); i1++)
        {
          View localView = localViewGroup.getChildAt(i1);
          if (localView != null)
            b(localView);
        }
        localViewGroup.setOnClickListener(null);
      }
      return;
    }
    paramView.setOnClickListener(null);
  }

  public final Context a()
  {
    if (this.g != null)
    {
      View localView = (View)this.g.get();
      if (localView != null)
        return localView.getContext();
    }
    return null;
  }

  public final void a(View paramView, List<View> paramList, bz.a parama, int paramInt)
  {
    Object localObject1 = null;
    if (paramList != null)
    {
      this.j = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        View localView2 = (View)localIterator.next();
        this.j.add(new WeakReference(localView2));
        if ((localView2 instanceof com.my.target.c.b.a))
          this.m = true;
        else
          localView2.setOnClickListener(this.c);
      }
    }
    this.g = new WeakReference(paramView);
    ViewGroup localViewGroup;
    int i2;
    Object localObject2;
    View localView1;
    Object localObject3;
    Object localObject4;
    if ((paramView instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)paramView;
      int i1 = localViewGroup.getChildCount();
      i2 = 0;
      localObject2 = null;
      if (i2 < i1)
      {
        localView1 = localViewGroup.getChildAt(i2);
        if ((localView1 instanceof ar))
        {
          localObject3 = (ar)localView1;
          localObject4 = localObject2;
        }
      }
    }
    while (true)
    {
      i2++;
      localObject2 = localObject4;
      localObject1 = localObject3;
      break;
      if ((localView1 instanceof bz))
      {
        bz localbz = (bz)localView1;
        Object localObject5 = localObject1;
        localObject4 = localbz;
        localObject3 = localObject5;
        continue;
        if (localObject2 == null)
        {
          localObject2 = new bz(localViewGroup.getContext());
          ((bz)localObject2).setId(bj.a());
          bj.a((View)localObject2, "viewability_view");
        }
        try
        {
          localViewGroup.addView((View)localObject2);
          ((bz)localObject2).setViewabilityListener(parama);
          this.i = new WeakReference(localObject2);
          this.e.a(localViewGroup, localObject1, paramInt);
          a(paramView);
          return;
        }
        catch (Exception localException)
        {
          while (true)
          {
            dp.a("Unable to add Viewability View: " + localException.getMessage());
            this.o = true;
          }
        }
      }
      else
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
    }
  }

  public final void a(boolean paramBoolean)
  {
    if (this.k != null)
    {
      if (paramBoolean)
        this.k.i();
    }
    else
      return;
    this.k.j();
  }

  public final boolean b()
  {
    return this.o;
  }

  public final int c()
  {
    return this.f;
  }

  public final int d()
  {
    WeakReference localWeakReference = this.g;
    View localView = null;
    if (localWeakReference != null)
      localView = (View)this.g.get();
    if (localView == null)
      return -1;
    if ((localView.getVisibility() != 0) || (localView.getParent() == null) || (localView.getAlpha() < 0.5F))
      return 0;
    Rect localRect = new Rect();
    if ((localView.getGlobalVisibleRect(localRect)) && (localRect.width() * localRect.height() >= localView.getWidth() * localView.getHeight() * this.d.H()))
      return 1;
    return 0;
  }

  public final void e()
  {
    if (this.k != null)
      this.k.h();
  }

  public final void f()
  {
    if (this.g != null);
    for (View localView1 = (View)this.g.get(); ; localView1 = null)
    {
      e();
      if (this.h != null)
      {
        cc localcc = (cc)this.h.get();
        if (localcc != null)
        {
          localcc.setPromoCardSliderListener(null);
          this.n = localcc.getState();
          localcc.a();
        }
        this.h = null;
      }
      if (this.l != null)
      {
        com.my.target.c.b.a locala = (com.my.target.c.b.a)this.l.get();
        if (locala != null)
        {
          com.my.target.common.a.b localb = this.d.l();
          ax localax = (ax)locala.getImageView();
          if (localb != null)
            be.b(localb, localax);
          locala.getProgressBarView().setVisibility(8);
          locala.getPlayButtonView().setVisibility(8);
          localax.setImageData(null);
          locala.a(0, 0);
          locala.setOnClickListener(null);
          locala.setBackgroundColor(-1118482);
          cb localcb = a(locala);
          if (localcb != null)
          {
            this.n = localcb.getState();
            localcb.a();
            ((View)localcb).setVisibility(8);
          }
        }
        this.l = null;
      }
      g();
      if (this.j == null)
        break label331;
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference != null)
        {
          View localView2 = (View)localWeakReference.get();
          if (localView2 != null)
            localView2.setOnClickListener(null);
        }
      }
    }
    this.j = null;
    while (true)
    {
      if (localView1 != null)
        this.e.a(localView1);
      if (this.g != null)
      {
        this.g.clear();
        this.g = null;
      }
      return;
      label331: if (localView1 != null)
        b(localView1);
    }
  }

  public final void g()
  {
    if (this.i != null)
    {
      bz localbz = (bz)this.i.get();
      if (localbz != null)
        localbz.setViewabilityListener(null);
      this.i.clear();
      this.i = null;
    }
  }

  public final int[] h()
  {
    if (this.f == 2)
    {
      if (this.h != null)
      {
        cc localcc = (cc)this.h.get();
        if (localcc != null)
          return localcc.getVisibleCardNumbers();
      }
    }
    else if ((this.f == 3) && (this.l != null))
    {
      com.my.target.c.b.a locala = (com.my.target.c.b.a)this.l.get();
      if (locala != null)
      {
        cb localcb = a(locala);
        if (localcb != null)
          return localcb.getVisibleCardNumbers();
      }
    }
    return null;
  }

  public final boolean i()
  {
    if (this.i != null)
    {
      bz localbz = (bz)this.i.get();
      if (localbz != null)
        return localbz.a();
    }
    return false;
  }

  public static abstract interface a extends View.OnClickListener, a.b, cc.a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.a.b
 * JD-Core Version:    0.6.2
 */