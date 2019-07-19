package com.my.target.b.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.my.target.a.a;
import com.my.target.a.a.a;
import com.my.target.aq;
import com.my.target.b.c.a.e;
import com.my.target.b.c.a.h;
import com.my.target.b.d.j;
import com.my.target.b.d.k;
import com.my.target.b.d.k.b;
import com.my.target.b.d.l;
import com.my.target.b.d.l.a;
import com.my.target.bb;
import com.my.target.bi;
import com.my.target.common.MyTargetActivity;
import com.my.target.o;
import com.my.target.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class f extends c
{
  private final com.my.target.b.c.a.i b;
  private final com.my.target.b.c.b.c c;
  private final ArrayList<o> d;
  private WeakReference<j> e;

  private f(a parama, com.my.target.b.c.a.i parami, com.my.target.b.c.b.c paramc)
  {
    super(parama);
    this.b = parami;
    this.c = paramc;
    this.d = new ArrayList();
    this.d.addAll(parami.y().d());
  }

  public static f a(a parama, com.my.target.b.c.a.i parami, com.my.target.b.c.b.c paramc)
  {
    return new f(parama, parami, paramc);
  }

  private void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    k localk = k.a(this.b, this.a.a(), paramViewGroup.getContext());
    this.e = new WeakReference(localk);
    localk.a(paramBoolean);
    localk.a(new a(this));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    paramViewGroup.addView(localk.f(), localLayoutParams);
    bi.a(this.b.y().a("playbackStarted"), paramViewGroup.getContext());
    bi.a(this.c.a("impression"), paramViewGroup.getContext());
  }

  static void a(com.my.target.i parami, Context paramContext)
  {
    bi.a(parami.y().a("playbackStarted"), paramContext);
  }

  static void b(com.my.target.i parami, String paramString, Context paramContext)
  {
    bi.a(parami.y().a(paramString), paramContext);
  }

  private j j()
  {
    if (this.e != null)
      return (j)this.e.get();
    return null;
  }

  public final void a()
  {
    super.a();
    j localj = j();
    if (localj != null)
      localj.e();
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
  }

  final void a(float paramFloat1, float paramFloat2, Context paramContext)
  {
    if (!this.d.isEmpty())
    {
      float f1 = paramFloat2 - paramFloat1;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        float f2 = localo.a();
        if ((f2 < 0.0F) && (localo.b() >= 0.0F))
          f2 = paramFloat2 / 100.0F * localo.b();
        if ((f2 >= 0.0F) && (f2 <= f1))
        {
          localArrayList.add(localo);
          localIterator.remove();
        }
      }
      bi.a(localArrayList, paramContext);
    }
  }

  public final void a(aq paramaq, FrameLayout paramFrameLayout)
  {
    super.a(paramaq, paramFrameLayout);
    a(paramFrameLayout, true);
  }

  public final void a(MyTargetActivity paramMyTargetActivity, Intent paramIntent, FrameLayout paramFrameLayout)
  {
    super.a(paramMyTargetActivity, paramIntent, paramFrameLayout);
    a(paramFrameLayout, false);
  }

  final void a(com.my.target.i parami, String paramString, Context paramContext)
  {
    if (j() == null);
    label119: label123: 
    while (true)
    {
      return;
      bb localbb = bb.a();
      if (TextUtils.isEmpty(paramString))
      {
        localbb.a(parami, paramContext);
        if ((parami instanceof com.my.target.b.c.a.f))
          bi.a(this.b.y().a("click"), paramContext);
        a.a locala = this.a.c();
        if (locala != null)
          locala.onClick(this.a);
        if ((this.b.I() != null) || (!this.b.G()))
          break label119;
      }
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          break label123;
        g();
        return;
        localbb.a(parami, paramString, paramContext);
        break;
      }
    }
  }

  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    j localj = j();
    if (localj != null)
    {
      if (paramBoolean)
        localj.m_();
    }
    else
      return;
    localj.c();
  }

  public final void b()
  {
    super.b();
    j localj = j();
    if (localj != null)
      localj.l_();
  }

  public final void c()
  {
    super.c();
    j localj = j();
    if (localj != null)
      localj.c();
  }

  public final void d()
  {
    super.d();
    j localj = j();
    if (localj != null)
      localj.m_();
  }

  public final void e()
  {
    super.e();
    if (this.e != null)
    {
      j localj = (j)this.e.get();
      if (localj != null)
      {
        View localView = localj.f();
        ViewParent localViewParent = localView.getParent();
        if ((localViewParent instanceof ViewGroup))
          ((ViewGroup)localViewParent).removeView(localView);
        localj.e();
      }
      this.e.clear();
      this.e = null;
    }
  }

  public final boolean f()
  {
    j localj = j();
    if ((localj instanceof k))
      return ((k)localj).j();
    return true;
  }

  final void h()
  {
    a.a locala = this.a.c();
    if (locala != null)
      locala.onVideoCompleted(this.a);
    e locale = this.b.R();
    j localj1 = j();
    ViewParent localViewParent = null;
    if (localj1 != null)
      localViewParent = localj1.f().getParent();
    ViewGroup localViewGroup;
    if ((locale != null) && ((localViewParent instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)localViewParent;
      j localj2 = j();
      if (localj2 != null)
        localj2.e();
      if (!(locale instanceof com.my.target.b.c.a.g))
        break label202;
      localViewGroup.removeAllViews();
      if (!"mraid".equals(locale.r()))
        break label189;
      localObject = com.my.target.b.d.i.a(localViewGroup.getContext());
      this.e = new WeakReference(localObject);
      ((l)localObject).a(new a(this));
      ((l)localObject).a((com.my.target.b.c.a.g)locale);
      localLayoutParams2 = new FrameLayout.LayoutParams(-1, -1);
      localViewGroup.addView(((l)localObject).f(), localLayoutParams2);
    }
    label189: label202: 
    while (!(locale instanceof h))
      while (true)
      {
        FrameLayout.LayoutParams localLayoutParams2;
        return;
        Object localObject = com.my.target.b.d.f.a(localViewGroup.getContext());
      }
    localViewGroup.removeAllViews();
    com.my.target.b.d.g localg = com.my.target.b.d.g.a(localViewGroup.getContext());
    this.e = new WeakReference(localg);
    localg.a(new a(this));
    localg.a((h)locale);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    localViewGroup.addView(localg.f(), localLayoutParams1);
  }

  final void i()
  {
    j localj = j();
    if ((localj instanceof k))
      ((k)localj).k();
  }

  private static final class a
    implements k.b, l.a
  {
    private final f a;

    a(f paramf)
    {
      this.a = paramf;
    }

    public final void a()
    {
    }

    public final void a(float paramFloat1, float paramFloat2, Context paramContext)
    {
      this.a.a(paramFloat1, paramFloat2, paramContext);
    }

    public final void a(com.my.target.i parami, Context paramContext)
    {
      f.a(parami, paramContext);
    }

    public final void a(com.my.target.i parami, String paramString, Context paramContext)
    {
      if (parami != null)
        this.a.a(parami, paramString, paramContext);
    }

    public final void b()
    {
      this.a.g();
    }

    public final void b(com.my.target.i parami, String paramString, Context paramContext)
    {
      f.b(parami, paramString, paramContext);
    }

    public final void c()
    {
      this.a.i();
    }

    public final void d()
    {
      this.a.h();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.b.f
 * JD-Core Version:    0.6.2
 */