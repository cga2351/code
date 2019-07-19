package com.my.target.b.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.my.target.a.a;
import com.my.target.a.a.a;
import com.my.target.aq;
import com.my.target.b.c.a.g;
import com.my.target.b.d.f;
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

public final class d extends c
{
  private final g b;
  private final com.my.target.b.c.b.c c;
  private final ArrayList<o> d;
  private WeakReference<l> e;

  private d(a parama, g paramg, com.my.target.b.c.b.c paramc)
  {
    super(parama);
    this.b = paramg;
    this.c = paramc;
    this.d = new ArrayList();
    this.d.addAll(paramg.y().d());
  }

  static d a(a parama, g paramg, com.my.target.b.c.b.c paramc)
  {
    return new d(parama, paramg, paramc);
  }

  private void a(ViewGroup paramViewGroup)
  {
    if ("mraid".equals(this.b.r()));
    for (Object localObject = com.my.target.b.d.i.a(paramViewGroup.getContext()); ; localObject = f.a(paramViewGroup.getContext()))
    {
      this.e = new WeakReference(localObject);
      ((l)localObject).a(new a(this, this.a, this.b));
      ((l)localObject).a(this.b);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      paramViewGroup.addView(((l)localObject).f(), localLayoutParams);
      return;
    }
  }

  static void a(com.my.target.i parami, Context paramContext)
  {
    bi.a(parami.y().a("playbackStarted"), paramContext);
  }

  static void a(com.my.target.i parami, String paramString, Context paramContext)
  {
    bi.a(parami.y().a(paramString), paramContext);
  }

  public final void a()
  {
    super.a();
    if (this.e != null)
    {
      l locall = (l)this.e.get();
      if (locall != null)
        locall.e();
    }
    this.e = null;
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
    a(paramFrameLayout);
  }

  public final void a(MyTargetActivity paramMyTargetActivity, Intent paramIntent, FrameLayout paramFrameLayout)
  {
    super.a(paramMyTargetActivity, paramIntent, paramFrameLayout);
    a(paramFrameLayout);
  }

  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    l locall;
    if (this.e != null)
    {
      locall = (l)this.e.get();
      if (locall != null)
      {
        if (!paramBoolean)
          break label38;
        locall.m_();
      }
    }
    return;
    label38: locall.c();
  }

  public final void c()
  {
    super.c();
    if (this.e != null)
    {
      l locall = (l)this.e.get();
      if (locall != null)
        locall.c();
    }
  }

  public final void d()
  {
    super.d();
    if (this.e != null)
    {
      l locall = (l)this.e.get();
      if (locall != null)
        locall.m_();
    }
  }

  public final void e()
  {
    super.e();
    if (this.e != null)
    {
      l locall = (l)this.e.get();
      if (locall != null)
        locall.e();
    }
    this.e = null;
  }

  public static final class a
    implements l.a
  {
    private final d a;
    private final a b;
    private final g c;

    a(d paramd, a parama, g paramg)
    {
      this.a = paramd;
      this.b = parama;
      this.c = paramg;
    }

    public final void a()
    {
      this.a.g();
    }

    public final void a(float paramFloat1, float paramFloat2, Context paramContext)
    {
      this.a.a(paramFloat1, paramFloat2, paramContext);
    }

    public final void a(com.my.target.i parami, Context paramContext)
    {
      d.a(parami, paramContext);
    }

    public final void a(com.my.target.i parami, String paramString, Context paramContext)
    {
      bb localbb = bb.a();
      if (TextUtils.isEmpty(paramString))
        localbb.a(this.c, paramContext);
      while (true)
      {
        a.a locala = this.b.c();
        if (locala != null)
          locala.onClick(this.b);
        return;
        localbb.a(this.c, paramString, paramContext);
      }
    }

    public final void b()
    {
      this.a.g();
    }

    public final void b(com.my.target.i parami, String paramString, Context paramContext)
    {
      d.a(parami, paramString, paramContext);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.b.d
 * JD-Core Version:    0.6.2
 */