package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

final class cl
{
  private final Context a;
  private final ck b;
  private final jn c;
  private final jk d;

  cl(Context paramContext, eo parameo, cn paramcn)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new ck(paramContext, parameo, paramcn);
    this.c = new a(this);
    this.d = jl.a();
  }

  final void a()
  {
    this.b.a(ck.a.b);
  }

  public final void a(fd.a parama)
  {
    this.b.a(parama);
  }

  final void b()
  {
    this.b.b(ck.a.b);
  }

  final void c()
  {
    this.d.a(this.a, this.c);
    this.b.a(ck.a.a);
  }

  final void d()
  {
    this.b.b(ck.a.a);
    this.d.b(this.a, this.c);
  }

  public final void e()
  {
    this.d.a(this.a, this.c);
  }

  public final void f()
  {
    this.d.b(this.a, this.c);
  }

  static final class a
    implements jn
  {
    private WeakReference<Activity> a;
    private final cl b;

    a(cl paramcl)
    {
      this.b = paramcl;
    }

    public final void a(Activity paramActivity)
    {
      new StringBuilder("onResume, activity = ").append(paramActivity);
      if ((this.a != null) && (paramActivity.equals(this.a.get())))
        this.b.d();
    }

    public final void b(Activity paramActivity)
    {
      new StringBuilder("onPause, activity = ").append(paramActivity);
      if (this.a == null)
        this.a = new WeakReference(paramActivity);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cl
 * JD-Core Version:    0.6.2
 */