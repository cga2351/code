package com.my.target.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import com.my.target.az;
import com.my.target.b.d.a;
import com.my.target.b.d.a.c;
import com.my.target.b.d.c.a;
import com.my.target.b.d.d.a;
import com.my.target.bb;
import com.my.target.bi;
import com.my.target.bj;
import com.my.target.ce;
import com.my.target.ce.a;
import com.my.target.cj;
import com.my.target.dp;
import com.my.target.i;
import com.my.target.o;
import com.my.target.q;
import com.my.target.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private final com.my.target.a.b a;
  private final z b;
  private final Context c;
  private final az<com.my.target.b.c.b.b> d;
  private final c.a e;
  private final b f;
  private final e g;
  private final a h;
  private final ArrayList<o> i;
  private com.my.target.b.d.c j;
  private boolean k;
  private long l;
  private long m;
  private boolean n = true;
  private int o = -1;

  private b(com.my.target.a.b paramb, z paramz)
  {
    this.a = paramb;
    this.b = paramz;
    this.c = paramb.getContext();
    this.e = new c(paramb);
    this.f = new b(this);
    this.d = ce.a(paramz);
    this.g = new e(this);
    this.h = new a();
    this.i = new ArrayList();
  }

  public static b a(com.my.target.a.b paramb, z paramz)
  {
    return new b(paramb, paramz);
  }

  private void a(cj paramcj, String paramString)
  {
    bj localbj = bj.a(this.a.getContext());
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default:
      switch (i1)
      {
      default:
        paramcj.a(localbj.c(320), localbj.c(50));
        paramcj.setFlexibleWidth(true);
        paramcj.setMaxWidth(localbj.c(640));
      case 0:
      case 1:
      }
      break;
    case -1476994234:
    case -1177968780:
    }
    while (true)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      paramcj.setLayoutParams(localLayoutParams);
      this.a.removeAllViews();
      this.a.addView(paramcj);
      return;
      if (!paramString.equals("standard_300x250"))
        break;
      i1 = 0;
      break;
      if (!paramString.equals("standard_728x90"))
        break;
      i1 = 1;
      break;
      paramcj.a(localbj.c(300), localbj.c(250));
      continue;
      paramcj.a(localbj.c(728), localbj.c(90));
    }
  }

  private void e()
  {
    if ((this.o > 0) && (this.k))
      this.a.postDelayed(this.g, this.o);
    if (this.j != null)
      this.j.b();
    this.h.d(true);
  }

  private void f()
  {
    if ((this.m > 0L) && (this.k))
    {
      this.l = (System.currentTimeMillis() + this.m);
      this.a.postDelayed(this.g, this.m);
      this.m = 0L;
    }
    if (this.j != null)
      this.j.e();
    this.h.a(false);
  }

  private void g()
  {
    this.a.removeCallbacks(this.g);
    if (this.k)
      this.m = (this.l - System.currentTimeMillis());
    if (this.j != null)
      this.j.d();
    this.h.a(true);
  }

  private void h()
  {
    this.h.d(false);
    this.a.removeCallbacks(this.g);
    if (this.j != null)
      this.j.c();
  }

  public final void a()
  {
    if (this.h.f())
      h();
    this.h.d();
    this.a.removeAllViews();
    if (this.j != null)
    {
      this.j.f();
      this.j = null;
    }
  }

  final void a(float paramFloat1, float paramFloat2, Context paramContext)
  {
    if (!this.i.isEmpty())
    {
      float f1 = paramFloat2 - paramFloat1;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.i.iterator();
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

  public final void a(com.my.target.b.c.b.b paramb)
  {
    if (this.h.f())
      h();
    boolean bool;
    com.my.target.b.c.a.c localc;
    String str3;
    a locala1;
    if ((paramb.c()) && (this.b.i()) && (!this.b.b().equals("standard_300x250")))
    {
      bool = true;
      this.k = bool;
      localc = paramb.f();
      if (localc != null)
      {
        this.o = (1000 * localc.H());
        this.l = (System.currentTimeMillis() + this.o);
        this.m = 0L;
        this.i.clear();
        this.i.addAll(localc.y().d());
        if ((this.k) && (this.h.e()))
          this.m = this.o;
        if (!"mraid".equals(localc.r()))
          break label280;
        if (this.a.getListener() != null)
        {
          str3 = this.b.b();
          if (!(this.j instanceof a))
            break label216;
          locala1 = (a)this.j;
          label191: locala1.a(new d(this));
          locala1.a(paramb);
        }
      }
    }
    label216: 
    do
    {
      do
      {
        com.my.target.a.b.a locala;
        do
        {
          return;
          bool = false;
          break;
          if (this.j != null)
          {
            this.j.a(null);
            this.j.f();
          }
          locala1 = a.a(this.a);
          locala1.a(this.e);
          this.j = locala1;
          a(locala1.g(), str3);
          break label191;
          if (!"native".equals(localc.E().a()))
            break label448;
          locala = this.a.getListener();
        }
        while (locala == null);
        String str2 = this.b.b();
        if (this.j != null)
        {
          this.j.a(null);
          this.j.f();
        }
        com.my.target.b.d.b localb = com.my.target.b.d.b.a(str2, this.c);
        this.j = localb;
        localb.a(this.e);
        localb.a(paramb);
        a(localb.a(), str2);
        if (this.n)
        {
          locala.a(this.a);
          this.n = false;
        }
        this.h.c(this.a.hasWindowFocus());
        this.h.e(true);
      }
      while (!this.h.a());
      e();
      return;
    }
    while (this.a.getListener() == null);
    label280: label448: String str1 = this.b.b();
    com.my.target.b.d.d locald;
    if ((this.j instanceof com.my.target.b.d.d))
      locald = (com.my.target.b.d.d)this.j;
    while (true)
    {
      locald.a(new d.a()
      {
        public final void a()
        {
          if (b.a(b.this))
          {
            com.my.target.a.b.a locala = b.b(b.this).getListener();
            if (locala != null)
              locala.a(b.b(b.this));
            b.c(b.this);
          }
          b.d(b.this).c(b.b(b.this).hasWindowFocus());
          b.d(b.this).e(true);
          if (b.d(b.this).a())
            b.e(b.this);
        }

        public final void a(String paramAnonymousString)
        {
          if (b.a(b.this))
          {
            com.my.target.a.b.a locala = b.b(b.this).getListener();
            if (locala != null)
              locala.a(paramAnonymousString, b.b(b.this));
            b.c(b.this);
          }
          b.d(b.this).e(false);
        }
      });
      locald.a(paramb);
      return;
      if (this.j != null)
      {
        this.j.a(null);
        this.j.f();
      }
      locald = com.my.target.b.d.d.a(str1, this.c);
      locald.a(this.e);
      this.j = locald;
      a(locald.a(), str1);
    }
  }

  final void a(String paramString)
  {
    if (this.n)
    {
      com.my.target.a.b.a locala = this.a.getListener();
      if (locala != null)
        locala.a(paramString, this.a);
      this.n = false;
    }
    this.h.e(false);
  }

  public final void a(boolean paramBoolean)
  {
    this.h.b(paramBoolean);
    this.h.c(this.a.hasWindowFocus());
    if (this.h.a())
      e();
    while ((paramBoolean) || (!this.h.f()))
      return;
    h();
  }

  final void b()
  {
    this.h.f(false);
    if (this.h.b())
      f();
  }

  public final void b(boolean paramBoolean)
  {
    this.h.c(paramBoolean);
    if (this.h.a())
      e();
    do
    {
      return;
      if (this.h.b())
      {
        f();
        return;
      }
    }
    while (!this.h.c());
    g();
  }

  final void c()
  {
    if (this.h.c())
      g();
    this.h.f(true);
  }

  final void d()
  {
    if (this.n)
    {
      com.my.target.a.b.a locala = this.a.getListener();
      if (locala != null)
        locala.a(this.a);
      this.n = false;
    }
    this.h.c(this.a.hasWindowFocus());
    this.h.e(true);
    if (this.h.a())
      e();
  }

  static final class a
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;

    public final void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public final boolean a()
    {
      return (this.d) && (this.c) && (this.e) && (!this.a);
    }

    public final void b(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }

    public final boolean b()
    {
      return (this.c) && (this.a) && (this.e) && (!this.f) && (this.b);
    }

    public final void c(boolean paramBoolean)
    {
      this.e = paramBoolean;
    }

    public final boolean c()
    {
      return (!this.b) && (this.a) && (!this.e);
    }

    public final void d()
    {
      this.f = false;
      this.c = false;
    }

    public final void d(boolean paramBoolean)
    {
      this.a = paramBoolean;
      this.b = false;
    }

    public final void e(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }

    public final boolean e()
    {
      return this.b;
    }

    public final void f(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }

    public final boolean f()
    {
      return this.a;
    }
  }

  private static final class b
    implements ce.a
  {
    private final WeakReference<b> a;

    b(b paramb)
    {
      this.a = new WeakReference(paramb);
    }
  }

  private static final class c
    implements c.a
  {
    private final com.my.target.a.b a;

    c(com.my.target.a.b paramb)
    {
      this.a = paramb;
    }

    public final void a(i parami)
    {
      bi.a(parami.y().a("playbackStarted"), this.a.getContext());
    }

    public final void a(i parami, String paramString)
    {
      com.my.target.a.b.a locala = this.a.getListener();
      if (locala != null)
        locala.b(this.a);
      bb localbb = bb.a();
      if (TextUtils.isEmpty(paramString))
      {
        localbb.a(parami, this.a.getContext());
        return;
      }
      localbb.a(parami, paramString, this.a.getContext());
    }
  }

  private static final class d
    implements a.c
  {
    private b a;

    public d(b paramb)
    {
      this.a = paramb;
    }

    public final void a()
    {
      this.a.d();
    }

    public final void a(float paramFloat1, float paramFloat2, Context paramContext)
    {
      this.a.a(paramFloat1, paramFloat2, paramContext);
    }

    public final void a(String paramString)
    {
      this.a.a(paramString);
    }

    public final void a(String paramString, com.my.target.b.c.a.c paramc, Context paramContext)
    {
      bi.a(paramc.y().a(paramString), paramContext);
    }

    public final void b()
    {
      this.a.c();
    }

    public final void c()
    {
      this.a.b();
    }
  }

  private static final class e
    implements Runnable
  {
    private final WeakReference<b> a;

    e(b paramb)
    {
      this.a = new WeakReference(paramb);
    }

    public final void run()
    {
      b localb = (b)this.a.get();
      if (localb != null)
      {
        dp.a("load new standard ad");
        b.i(localb).a(b.h(localb)).a(b.g(localb));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.b.b
 * JD-Core Version:    0.6.2
 */