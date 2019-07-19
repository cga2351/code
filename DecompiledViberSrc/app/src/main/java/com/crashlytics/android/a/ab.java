package com.crashlytics.android.a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import c.a.a.a.a;
import c.a.a.a.a.b.o;
import c.a.a.a.a.b.s;
import c.a.a.a.c;
import java.util.concurrent.ScheduledExecutorService;

class ab
  implements l.a
{
  final f a;
  final a b;
  final l c;
  final i d;
  private final long e;

  ab(f paramf, a parama, l paraml, i parami, long paramLong)
  {
    this.a = paramf;
    this.b = parama;
    this.c = paraml;
    this.d = parami;
    this.e = paramLong;
  }

  public static ab a(c.a.a.a.i parami, Context paramContext, s params, String paramString1, String paramString2, long paramLong)
  {
    ag localag = new ag(paramContext, params, paramString1, paramString2);
    g localg = new g(paramContext, new c.a.a.a.a.f.b(parami));
    c.a.a.a.a.e.b localb = new c.a.a.a.a.e.b(c.g());
    a locala = new a(paramContext);
    ScheduledExecutorService localScheduledExecutorService = o.b("Answers Events Handler");
    l locall = new l(localScheduledExecutorService);
    return new ab(new f(parami, paramContext, localg, localag, localb, localScheduledExecutorService, new r(paramContext)), locala, locall, i.a(paramContext), paramLong);
  }

  public void a()
  {
    c.g().a("Answers", "Flush events when app is backgrounded");
    this.a.c();
  }

  public void a(long paramLong)
  {
    c.g().a("Answers", "Logged install");
    this.a.b(ad.a(paramLong));
  }

  public void a(Activity paramActivity, ad.b paramb)
  {
    c.g().a("Answers", "Logged lifecycle event: " + paramb.name());
    this.a.a(ad.a(paramb, paramActivity));
  }

  public void a(c.a.a.a.a.g.b paramb, String paramString)
  {
    this.c.a(paramb.j);
    this.a.a(paramb, paramString);
  }

  public void a(m paramm)
  {
    c.g().a("Answers", "Logged custom event: " + paramm);
    this.a.a(ad.a(paramm));
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString1, String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException("onCrash called from main thread!!!");
    c.g().a("Answers", "Logged crash");
    this.a.c(ad.a(paramString1, paramString2));
  }

  public void b()
  {
    this.a.b();
    this.b.a(new h(this, this.c));
    this.c.a(this);
    if (d())
    {
      a(this.e);
      this.d.a();
    }
  }

  public void c()
  {
    this.b.a();
    this.a.a();
  }

  boolean d()
  {
    return !this.d.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.ab
 * JD-Core Version:    0.6.2
 */