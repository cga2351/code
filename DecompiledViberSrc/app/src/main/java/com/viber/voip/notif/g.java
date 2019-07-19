package com.viber.voip.notif;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.notif.e.b;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.e.n;
import com.viber.voip.notif.e.s;
import com.viber.voip.notif.e.u;
import com.viber.voip.notif.e.v;
import com.viber.voip.notif.i.k;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import java.util.Iterator;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class g
{
  private final Context a;
  private final dagger.a<f> b;
  private final m c;
  private final v d;
  private final u e;
  private final s f;
  private final b g;
  private final n h;
  private final com.viber.voip.notif.e.a i;
  private final com.viber.voip.notif.e.h j;
  private final com.viber.voip.banner.notificationsoff.c k;
  private final k l;

  public g(Context paramContext, dagger.a<f> parama, v paramv, m paramm, b paramb, u paramu, s params, n paramn, com.viber.voip.notif.e.a parama1, com.viber.voip.notif.e.h paramh, com.viber.voip.banner.notificationsoff.c paramc, k paramk)
  {
    this.a = paramContext;
    this.b = parama;
    this.d = paramv;
    this.c = paramm;
    this.g = paramb;
    this.e = paramu;
    this.f = params;
    this.h = paramn;
    this.i = parama1;
    this.j = paramh;
    this.k = paramc;
    this.l = paramk;
    h();
  }

  public static g a(Context paramContext)
  {
    g localg = ViberApplication.getInstance().getNotifier();
    if (localg == null)
      throw new AssertionError("Notifier not found.");
    return localg;
  }

  public static boolean a(Intent paramIntent)
  {
    int m = 1;
    if (paramIntent != null);
    try
    {
      int n = paramIntent.getIntExtra("from_notification", 0);
      if (n == m);
      while (true)
      {
        return m;
        m = 0;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    return false;
  }

  private void l()
  {
    if (!com.viber.common.d.a.m());
    while (true)
    {
      return;
      for (c localc : c.values())
      {
        localc.d(this.a);
        localc.a(this.a, (f)this.b.get());
      }
    }
  }

  public m a()
  {
    return this.c;
  }

  public void a(long paramLong)
  {
    this.f.b(paramLong);
    this.h.a(paramLong);
    this.j.a(paramLong);
  }

  public void a(com.viber.voip.notif.i.a parama, o paramo, d paramd, EventBus paramEventBus, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    com.viber.voip.util.d.b(this.k, this.k.c());
    this.l.b();
    this.g.a(parama, paramConferenceCallsRepository);
    this.e.a(paramEventBus);
    this.f.a(paramo, paramEventBus);
    this.h.a(paramo);
    this.j.a(paramo);
    paramd.a((f)this.b.get());
    l();
  }

  public void a(String paramString, int paramInt)
  {
    ((f)this.b.get()).a(paramString, paramInt);
  }

  public void a(Set<Long> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (localLong != null)
        a(localLong.longValue());
    }
  }

  public b b()
  {
    return this.g;
  }

  public v c()
  {
    return this.d;
  }

  public s d()
  {
    return this.f;
  }

  public n e()
  {
    return this.h;
  }

  public com.viber.voip.notif.e.a f()
  {
    return this.i;
  }

  public com.viber.voip.notif.e.h g()
  {
    return this.j;
  }

  public void h()
  {
    ((f)this.b.get()).a();
  }

  @Deprecated
  public boolean i()
  {
    return ((f)this.b.get()).b();
  }

  public com.viber.voip.banner.notificationsoff.h j()
  {
    return this.k;
  }

  public boolean k()
  {
    return this.l.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.g
 * JD-Core Version:    0.6.2
 */