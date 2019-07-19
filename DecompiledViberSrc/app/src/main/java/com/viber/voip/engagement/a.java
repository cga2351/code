package com.viber.voip.engagement;

import android.os.Handler;
import com.viber.common.b.e;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.contacts.c.d.n.a;
import com.viber.voip.i.f.a;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.settings.d.al;
import com.viber.voip.ui.e.c;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class a
  implements n.a, f.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(2L);
  private static final long c = TimeUnit.HOURS.toMillis(24L);
  private boolean A = false;
  private final Runnable B = new Runnable()
  {
    public void run()
    {
      if (a.h(a.this) == null);
      do
      {
        return;
        if (a.i(a.this))
        {
          if (a.h(a.this) != null)
            a.h(a.this).a();
          a.j(a.this).g();
          a.k(a.this).a(System.currentTimeMillis());
        }
      }
      while (a.f(a.this));
      a.this.b();
    }
  };
  private final com.viber.voip.contacts.c.f.b.f d;
  private final EventBus e;
  private final n f;
  private final CallHandler g;
  private final Handler h;
  private final com.viber.voip.i.f i;
  private final com.viber.common.b.d j;
  private final com.viber.common.b.b k;
  private final com.viber.voip.settings.b l;
  private final e m;
  private final com.viber.common.b.b n;
  private final h o;
  private a p;
  private final b q;
  private volatile boolean r = false;
  private volatile boolean s = false;
  private volatile boolean t = false;
  private volatile int u = 0;
  private volatile boolean v = false;
  private volatile int w = 0;
  private boolean x = false;
  private d.al y;
  private boolean z = false;

  public a(com.viber.voip.contacts.c.f.b.f paramf, EventBus paramEventBus, n paramn, CallHandler paramCallHandler, Handler paramHandler, com.viber.voip.i.f paramf1, com.viber.common.b.d paramd, com.viber.common.b.b paramb1, com.viber.voip.settings.b paramb, e parame, com.viber.common.b.b paramb2, h paramh, b paramb3)
  {
    this.d = paramf;
    this.e = paramEventBus;
    this.f = paramn;
    this.g = paramCallHandler;
    this.h = paramHandler;
    this.i = paramf1;
    this.j = paramd;
    this.k = paramb1;
    this.l = paramb;
    this.m = parame;
    this.n = paramb2;
    this.o = paramh;
    this.q = paramb3;
  }

  private boolean d()
  {
    return (this.i.e()) && (!this.k.d()) && (this.l.d() < 2);
  }

  private void e()
  {
    if (this.A)
      return;
    if (!this.f.a())
    {
      this.s = true;
      if (this.n.d())
        break label76;
    }
    label76: for (boolean bool = true; ; bool = false)
    {
      this.x = bool;
      com.viber.voip.settings.d.a(f());
      this.e.register(this);
      this.A = true;
      return;
      this.f.a(this);
      break;
    }
  }

  private final d.al f()
  {
    if (this.y == null)
    {
      Handler localHandler = this.h;
      com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[3];
      arrayOfa[0] = this.j;
      arrayOfa[1] = this.n;
      arrayOfa[2] = this.k;
      this.y = new d.al(localHandler, arrayOfa)
      {
        public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
        {
          String str = paramAnonymousa.c();
          if (str.equals(a.a(a.this).c()))
            a.b(a.this);
          do
          {
            return;
            if (str.equals(a.c(a.this).c()))
            {
              a locala = a.this;
              if (!a.c(a.this).d());
              for (boolean bool = true; ; bool = false)
              {
                a.a(locala, bool);
                if (!a.d(a.this))
                  break;
                a.b(a.this);
                return;
              }
            }
          }
          while ((!str.equals(a.e(a.this).c())) || (a.f(a.this)));
          a.this.b();
        }
      };
    }
    return this.y;
  }

  private void g()
  {
    this.h.post(new Runnable()
    {
      public void run()
      {
        a.b(a.this, true);
        a.a(a.this, a.g(a.this).e());
        a.b(a.this);
      }
    });
  }

  private boolean h()
  {
    return c + this.m.d() < System.currentTimeMillis();
  }

  private void i()
  {
    boolean bool = j();
    int i1;
    if (bool != this.z)
    {
      i1 = 1;
      if (i1 != 0)
        this.h.removeCallbacks(this.B);
      this.z = bool;
      if (!bool)
        break label60;
      this.h.postDelayed(this.B, b);
    }
    label60: 
    while ((this.t) || (!this.s))
    {
      return;
      i1 = 0;
      break;
    }
    g();
  }

  private boolean j()
  {
    return (this.j.d() == 0) && (this.r) && (c());
  }

  public void a()
  {
    if (d())
      e();
    this.i.a(this);
  }

  public void a(a parama)
  {
    this.p = parama;
  }

  public void b()
  {
    this.h.removeCallbacks(this.B);
    this.e.unregister(this);
    this.f.b(this);
    this.A = false;
  }

  public boolean c()
  {
    int i1 = 1;
    if ((this.t) && (this.v) && (this.s) && (this.u >= 6) && (this.w <= 3) && (this.x) && (h()) && (d()) && (this.g.getCallInfo() == null));
    for (int i2 = i1; ; i2 = 0)
    {
      int i3;
      if ((this.q != null) && (this.q.a()))
      {
        i3 = i1;
        if (i3 != 0)
          break label107;
      }
      while (true)
      {
        return i2 & i1;
        i3 = 0;
        break;
        label107: i1 = 0;
      }
    }
  }

  @Subscribe(sticky=true, threadMode=ThreadMode.POSTING)
  public void onConversationsLoaded(com.viber.voip.ui.e.b paramb)
  {
    this.v = true;
    this.w = paramb.a();
    i();
  }

  public void onFeatureStateChanged(com.viber.voip.i.f paramf)
  {
    if (d())
    {
      e();
      return;
    }
    b();
  }

  @Subscribe(sticky=true, threadMode=ThreadMode.POSTING)
  public void onHomeTabChanged(c paramc)
  {
    if ((paramc.a() == 0) && (paramc.b()));
    for (this.r = true; ; this.r = false)
    {
      i();
      return;
    }
  }

  public void onSyncStateChanged(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4)
    {
      this.s = true;
      this.f.b(this);
      i();
    }
  }

  public static abstract interface a
  {
    public abstract void a();
  }

  public static abstract interface b
  {
    public abstract boolean a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.a
 * JD-Core Version:    0.6.2
 */