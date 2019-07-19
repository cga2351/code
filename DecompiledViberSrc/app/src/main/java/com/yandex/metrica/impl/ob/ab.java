package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.CounterConfiguration.a;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.b;
import com.yandex.metrica.impl.b.a;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.i;
import java.util.HashMap;

public class ab
  implements ag, ai, fg, mt
{
  private boolean a = false;
  private final HandlerThread b;
  private final Handler c;
  private final Context d;
  private final y e;
  private fw f;
  private fy g;
  private fu h;
  private bi i;
  private fh j;
  private bw k;
  private final bt l;
  private b m;
  private final a n;
  private pa o;
  private long p;
  private long q;
  private int r;
  private int s;
  private volatile eg t;
  private mo u;
  private mx v;
  private ap w;
  private ds x;
  private of y;

  public ab(Context paramContext, mo parammo, com.yandex.metrica.impl.ap paramap, y paramy, t paramt, a parama, ap.a parama1, mz parammz)
  {
    this(paramContext, parammo, paramap, paramy, paramt, parama, parama1, parammz, og.a(paramt.b().f()));
  }

  ab(Context paramContext, mo parammo, com.yandex.metrica.impl.ap paramap, y paramy, t paramt, a parama, ap.a parama1, mz parammz, of paramof)
  {
    this(paramContext, parammo, paramap, paramy, paramt, parama, new pa(paramContext), parama1, parammz, paramof);
  }

  ab(Context paramContext, mo parammo, com.yandex.metrica.impl.ap paramap, y paramy, t paramt, a parama, pa parampa, ap.a parama1, mz parammz, of paramof)
  {
    this.d = paramContext.getApplicationContext();
    this.e = paramy;
    this.o = parampa;
    this.n = parama;
    this.y = paramof;
    this.u = parammo;
    fk localfk = fj.a(this.d).b(this.e);
    this.f = new fw(localfk);
    this.h = new fu(localfk);
    this.g = new fy(fj.a(this.d).c());
    this.j = new fh(this, fj.a(this.d).a(this.e));
    this.i = new bi(this, parammz.a(this, this.u), paramap);
    this.b = od.b(paramy.b());
    this.b.start();
    this.c = new Handler(this.b.getLooper());
    try
    {
      this.v = this.u.d(this, paramt);
      this.w = new ap(new lr.b(this), parama1, this.v.f(), paramt);
      int i1 = YandexMetrica.getLibraryApiLevel();
      if (this.f.d() < i1)
      {
        new aa(this, new jf(C())).a();
        this.f.e(i1).i();
      }
      this.p = this.f.a(0L);
      this.q = this.f.b(0L);
      this.r = this.f.a(-1);
      this.s = com.yandex.metrica.impl.bw.c(paramContext, paramy.b());
      this.t = new eg(this, new eg.a()
      {
        public void a(i paramAnonymousi, eh paramAnonymouseh)
        {
          ab.this.a(paramAnonymousi, paramAnonymouseh);
        }
      });
      this.m = this.n.a(this, this.f);
      if (this.y.c())
      {
        of localof = this.y;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.e.toString();
        arrayOfObject[1] = this.m.b().a;
        localof.a("Read app environment for component %s. Value: %s", arrayOfObject);
      }
      this.x = new ds(this.d, this.e, this.s);
      this.j.a(this);
      this.l = new bt(this);
      this.k = new bw(this.l, this);
      return;
    }
    finally
    {
    }
  }

  public ab(Context paramContext, mo parammo, com.yandex.metrica.impl.ap paramap, y paramy, t paramt, ap.a parama, mz parammz)
  {
    this(paramContext, parammo, paramap, paramy, paramt, new a(), parama, parammz);
  }

  private void J()
  {
    this.q = (System.currentTimeMillis() / 1000L);
    this.f.d(this.q).i();
  }

  public boolean A()
  {
    return (x()) && (l().H()) && (l().e());
  }

  public fu B()
  {
    return this.h;
  }

  @Deprecated
  public final jg C()
  {
    return new jg(this.d, this.e.a());
  }

  public fw D()
  {
    return this.f;
  }

  public boolean E()
  {
    CounterConfiguration.a locala1 = this.g.a();
    CounterConfiguration.a locala2 = this.f.c();
    CounterConfiguration.a locala3 = CounterConfiguration.a.c;
    boolean bool = false;
    if (locala1 == locala3)
    {
      CounterConfiguration.a locala4 = CounterConfiguration.a.c;
      bool = false;
      if (locala2 == locala4)
        bool = true;
    }
    return bool;
  }

  public boolean F()
  {
    boolean bool1 = this.h.b(false);
    boolean bool2 = this.w.c().u;
    if ((bool1) && (bool2));
    for (int i1 = 1; i1 == 0; i1 = 0)
      return true;
    return false;
  }

  public fw G()
  {
    return this.f;
  }

  public String H()
  {
    return this.f.e();
  }

  public ds I()
  {
    return this.x;
  }

  public t a()
  {
    return this.w.a();
  }

  public void a(CounterConfiguration.a parama)
  {
    this.f.a(parama).i();
    if (this.d.getPackageName().equals(this.e.b()))
      this.g.a(parama).i();
  }

  public void a(i parami)
  {
    if (this.y.c())
      this.y.a(parami, "Event received on service");
    if (!com.yandex.metrica.impl.bw.a(this.e.a()))
      return;
    this.k.b(parami);
  }

  void a(i parami, eh parameh)
  {
    b(parami, parameh);
  }

  public void a(mq parammq)
  {
  }

  public void a(mw parammw)
  {
    try
    {
      this.w.a(parammw);
      j();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(t paramt)
  {
    try
    {
      this.w.a(paramt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString)
  {
    this.f.b(paramString).i();
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public y b()
  {
    return this.e;
  }

  public void b(i parami)
  {
    b(parami, this.t.b());
  }

  void b(i parami, eh parameh)
  {
    if (TextUtils.isEmpty(parami.m()))
      parami.a(k());
    parami.d(H());
    b.a locala = this.m.b();
    oz localoz = this.o.a(parami);
    this.j.a(localoz.a(parami), parameh, locala);
    this.i.b();
  }

  public void b(String paramString)
  {
    this.f.e(paramString).i();
  }

  public Context c()
  {
    return this.d;
  }

  public void c(i parami)
  {
    this.t.c(parami);
  }

  public eg d()
  {
    return this.t;
  }

  public void d(i parami)
  {
    b(parami, this.t.d(parami));
  }

  public mt e()
  {
    return this;
  }

  public void e(i parami)
  {
    a(true);
    d(parami);
    s();
  }

  protected bt f()
  {
    return this.l;
  }

  public void f(i parami)
  {
    d(parami);
    J();
  }

  public void g()
  {
    if (this.j.a() >= ((lr)this.w.e()).Q());
    for (int i1 = 1; ; i1 = 0)
    {
      if ((i1 | this.a) != 0)
        j();
      return;
    }
  }

  public void g(i parami)
  {
    d(parami);
    v();
  }

  public void h()
  {
    try
    {
      i();
      this.u.a(this);
      com.yandex.metrica.impl.bw.a(this.i);
      com.yandex.metrica.impl.bw.a(this.j);
      this.c.removeCallbacksAndMessages(null);
      this.b.quit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void h(i parami)
  {
    this.m.a(parami.l());
    b.a locala = this.m.b();
    if ((this.n.a(locala, this.f)) && (this.y.c()))
    {
      of localof = this.y;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = b();
      arrayOfObject[1] = locala.a;
      localof.a("Save new app environment for %s. Value: %s", arrayOfObject);
    }
  }

  void i()
  {
  }

  public void j()
  {
    try
    {
      this.i.d();
      this.a = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String k()
  {
    return this.f.a(null);
  }

  public lr l()
  {
    return (lr)this.w.e();
  }

  public fh m()
  {
    return this.j;
  }

  public Handler n()
  {
    return this.c;
  }

  public of o()
  {
    return this.y;
  }

  public void p()
  {
    J();
  }

  public void q()
  {
    v();
  }

  public void r()
  {
    this.m.a();
    this.n.b(this.m.b(), this.f);
  }

  public void s()
  {
    this.p = (System.currentTimeMillis() / 1000L);
    this.f.c(this.p).i();
  }

  public void t()
  {
    this.f.c(1 + u()).i();
    this.w.b();
  }

  public int u()
  {
    return this.f.d(1);
  }

  void v()
  {
    this.r = this.s;
    this.f.b(this.r).i();
  }

  boolean w()
  {
    return System.currentTimeMillis() / 1000L - this.q > ee.b;
  }

  boolean x()
  {
    return this.r < this.s;
  }

  public boolean y()
  {
    if (System.currentTimeMillis() / 1000L - this.p > ee.a);
    for (int i1 = 1; (i1 != 0) && (l().e()); i1 = 0)
      return true;
    return false;
  }

  public boolean z()
  {
    return (w()) && (l().G()) && (l().e());
  }

  static class a
  {
    private final HashMap<String, b> a = new HashMap();

    public b a(ab paramab, fw paramfw)
    {
      try
      {
        b localb = (b)this.a.get(paramab.b().toString());
        if (localb == null)
        {
          b.a locala = paramfw.a();
          localb = new b(locala.a, locala.b, paramab.o());
          this.a.put(paramab.b().toString(), localb);
        }
        return localb;
      }
      finally
      {
      }
    }

    public boolean a(b.a parama, fw paramfw)
    {
      try
      {
        if (parama.b > paramfw.a().b)
        {
          paramfw.a(parama).i();
          bool = true;
          return bool;
        }
        boolean bool = false;
      }
      finally
      {
      }
    }

    public void b(b.a parama, fw paramfw)
    {
      try
      {
        paramfw.a(parama).i();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ab
 * JD-Core Version:    0.6.2
 */