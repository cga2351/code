package com.viber.voip.notif.e;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.at;
import com.viber.voip.model.entity.q;
import com.viber.voip.notif.d.e.a;
import com.viber.voip.notif.d.e.b;
import com.viber.voip.notif.d.j;
import com.viber.voip.notif.i.l;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.util.ViberActionRunner.av;
import com.viber.voip.util.ViberActionRunner.bo;
import com.viber.voip.util.br;
import com.viber.voip.util.u;
import java.util.Iterator;
import java.util.List;

public class m
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final j c;
  private final dagger.a<com.viber.voip.notif.f> d;
  private final dagger.a<IRingtonePlayer> e;
  private final l f;
  private final dagger.a<at> g;
  private Runnable h;
  private Runnable i;
  private Handler j;
  private Runnable k = new Runnable()
  {
    public void run()
    {
      ViberActionRunner.av.a();
    }
  };

  m(Context paramContext, j paramj, dagger.a<com.viber.voip.notif.f> parama, Handler paramHandler, dagger.a<IRingtonePlayer> parama1, l paraml, dagger.a<at> parama2)
  {
    this.b = paramContext;
    this.c = paramj;
    this.d = parama;
    this.j = paramHandler;
    this.e = parama1;
    this.f = paraml;
    this.g = parama2;
  }

  private void a(com.viber.voip.notif.d.e parame)
  {
    a(parame, null);
  }

  private void a(final com.viber.voip.notif.d.e parame, final com.viber.voip.notif.c paramc)
  {
    Runnable local4 = new Runnable()
    {
      public void run()
      {
        try
        {
          parame.a(m.b(m.this), m.e(m.this), paramc).a((com.viber.voip.notif.f)m.d(m.this).get());
          return;
        }
        catch (Exception localException)
        {
          m.p().a(localException, "Can't show notification!");
        }
      }
    };
    if (Looper.myLooper() == this.j.getLooper())
    {
      local4.run();
      return;
    }
    this.j.post(local4);
  }

  public void a()
  {
    if (com.viber.common.d.a.g())
    {
      this.h = new b();
      this.j.postDelayed(this.h, 1000L);
    }
    while ((!com.viber.common.d.a.d()) || ((!br.a.a()) && (!br.b.a())))
      return;
    this.h = new a();
    this.j.postDelayed(this.h, 2000L);
  }

  public void a(int paramInt)
  {
    a(new com.viber.voip.notif.b.d.a.b.f(paramInt));
  }

  public void a(int paramInt1, int paramInt2)
  {
    a(new com.viber.voip.notif.b.d.a.b.e(paramInt1, paramInt2));
  }

  public void a(int paramInt, String paramString)
  {
    a(new com.viber.voip.notif.b.d.a.b.d(paramInt, paramString));
  }

  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(new com.viber.voip.notif.b.d.a.b.c(paramInt1, paramString, paramInt2));
  }

  public void a(long paramLong)
  {
    ((com.viber.voip.notif.f)this.d.get()).a("recent_contact", (int)paramLong);
  }

  public void a(Bundle paramBundle)
  {
    this.i = new c(paramBundle);
    this.j.post(this.i);
  }

  public void a(com.viber.voip.model.a parama, Member paramMember, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int m = 3; ; m = 1)
    {
      a(new com.viber.voip.notif.b.b.a(parama, paramMember, m));
      return;
    }
  }

  public void a(com.viber.voip.notif.h.c paramc, String paramString)
  {
    a(new com.viber.voip.notif.b.f.a.b(paramc, paramString));
  }

  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    for (com.viber.voip.notif.c localc = com.viber.voip.notif.c.a; ; localc = null)
    {
      a(new com.viber.voip.notif.b.h.a(paramString), localc);
      return;
    }
  }

  public void a(List<q> paramList)
  {
    if (u.a(paramList));
    while (true)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        a(new com.viber.voip.notif.b.g.a((q)localIterator.next(), false));
    }
  }

  public void b()
  {
    if (com.viber.common.d.a.g())
    {
      this.j.removeCallbacks(this.h);
      ((com.viber.voip.notif.f)this.d.get()).a(-110);
    }
    while ((!com.viber.common.d.a.d()) || ((!br.a.a()) && (!br.b.a())))
      return;
    this.j.removeCallbacks(this.h);
    com.viber.voip.registration.a.a().c();
  }

  public void b(int paramInt)
  {
    a(new com.viber.voip.notif.b.d.a.b.b(paramInt));
  }

  public void b(int paramInt, String paramString)
  {
    a(new com.viber.voip.notif.b.d.a.a.d(paramInt, paramString));
  }

  public void b(int paramInt1, String paramString, int paramInt2)
  {
    a(new com.viber.voip.notif.b.d.a.a.c(paramInt1, paramString, paramInt2));
  }

  public void b(long paramLong)
  {
    a(new com.viber.voip.notif.b.f.c.d(paramLong));
  }

  public void b(com.viber.voip.model.a parama, Member paramMember, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int m = 4; ; m = 2)
    {
      a(new com.viber.voip.notif.b.b.a(parama, paramMember, m));
      return;
    }
  }

  public void c()
  {
    ((com.viber.voip.notif.f)this.d.get()).a(-170);
  }

  public void c(int paramInt)
  {
    a(new com.viber.voip.notif.b.d.a.a.e(paramInt));
  }

  public void d()
  {
    a(new com.viber.voip.notif.b.h.b());
  }

  public void d(int paramInt)
  {
    a(new com.viber.voip.notif.b.d.a.a.b(paramInt));
  }

  public void e()
  {
    ((com.viber.voip.notif.f)this.d.get()).a(-240);
  }

  public void e(int paramInt)
  {
    ((com.viber.voip.notif.f)this.d.get()).a("you_joined_as_member", paramInt);
  }

  public void f()
  {
    a(new com.viber.voip.notif.b.j.a());
  }

  public void g()
  {
    ((com.viber.voip.notif.f)this.d.get()).a("message", -101);
  }

  public void h()
  {
    ((com.viber.voip.notif.f)this.d.get()).a(-180);
  }

  public void i()
  {
    this.j.post(new Runnable()
    {
      public void run()
      {
        ((at)m.a(m.this).get()).a(false);
      }
    });
  }

  public void j()
  {
    a(new com.viber.voip.notif.b.j.d());
  }

  public void k()
  {
    ((com.viber.voip.notif.f)this.d.get()).a(-190);
  }

  public void l()
  {
    final com.viber.voip.fcm.b localb = new com.viber.voip.fcm.b();
    localb.a(this.b, this.c).a((com.viber.voip.notif.f)this.d.get(), new e.a()
    {
      public void a(Notification paramAnonymousNotification)
      {
        ViberActionRunner.bo.a(m.b(m.this), paramAnonymousNotification, localb.a());
        Handler localHandler = av.e.f.a();
        localHandler.removeCallbacks(m.c(m.this));
        localHandler.postDelayed(m.c(m.this), 120000L);
      }
    });
  }

  public void m()
  {
    ViberActionRunner.bo.a(this.b);
    ((com.viber.voip.notif.f)this.d.get()).a(-220);
  }

  public void n()
  {
    a(com.viber.voip.notif.b.c.a.e());
  }

  public void o()
  {
    a(com.viber.voip.notif.b.c.a.f());
  }

  class a
    implements Runnable
  {
    a()
    {
    }

    public void run()
    {
      com.viber.voip.registration.a.a().b();
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
      m.a(m.this, new com.viber.voip.notif.b.h.c());
    }
  }

  class c
    implements Runnable
  {
    private final Bundle b;

    public c(Bundle arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      boolean bool = m.f(m.this).a();
      String str1 = this.b.getString("title", "");
      String str2 = this.b.getString("text", "");
      String str3 = this.b.getString("action", "");
      String str4 = this.b.getString("image", "");
      String str5 = this.b.getString("sound");
      if ((TextUtils.isEmpty(str5)) && (bool));
      for (com.viber.voip.notif.c localc = com.viber.voip.notif.c.a; ; localc = com.viber.voip.notif.c.f)
      {
        m.a(m.this, new com.viber.voip.notif.b.g.c(str1, str2, str3, str4), localc);
        if ((bool) && (!TextUtils.isEmpty(str5)) && (!str5.equalsIgnoreCase("none")))
          ((IRingtonePlayer)m.g(m.this).get()).playCustomTone(Uri.parse(str5));
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.m
 * JD-Core Version:    0.6.2
 */