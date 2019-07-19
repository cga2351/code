package com.viber.voip.gdpr;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.j;
import com.viber.voip.i.f.a;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.v;
import com.viber.voip.util.ax;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class c
  implements f.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final f b;
  private b c;
  private final ICdrController d;
  private final com.viber.voip.gdpr.a.a e;
  private final EventBus f;
  private final SharedPreferences.OnSharedPreferenceChangeListener g;
  private final SharedPreferences.OnSharedPreferenceChangeListener h;
  private final SharedPreferences.OnSharedPreferenceChangeListener i;

  public c(f paramf, b paramb, ICdrController paramICdrController, com.viber.voip.gdpr.a.a parama, EventBus paramEventBus)
  {
    com.viber.common.b.a[] arrayOfa1 = new com.viber.common.b.a[1];
    arrayOfa1[0] = d.v.h;
    this.g = new d.al(arrayOfa1)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        c.a(c.this);
        c.b(c.this);
      }
    };
    com.viber.common.b.a[] arrayOfa2 = new com.viber.common.b.a[1];
    arrayOfa2[0] = d.v.i;
    this.h = new d.al(arrayOfa2)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        c.c(c.this).a(true);
      }
    };
    com.viber.common.b.a[] arrayOfa3 = new com.viber.common.b.a[1];
    arrayOfa3[0] = d.f.d;
    this.i = new d.al(arrayOfa3)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        ICdrController localICdrController = c.d(c.this);
        if (d.f.d.d());
        for (String str = ax.a(); ; str = "")
        {
          localICdrController.setAdvertisingId(str);
          c.e(c.this);
          return;
        }
      }
    };
    this.b = paramf;
    this.c = paramb;
    this.d = paramICdrController;
    this.e = parama;
    this.f = paramEventBus;
  }

  private void b()
  {
    c.j.c.a(this);
    c.j.b.a(this);
    c.j.a.a(this);
    com.viber.voip.settings.d.a(this.g);
    com.viber.voip.settings.d.a(this.h);
    com.viber.voip.settings.d.a(this.i);
    this.f.register(this);
  }

  private void c()
  {
    if (ao.f());
    do
    {
      return;
      if (!c.j.c.e())
      {
        d.v.p.a(false);
        this.c.a(true, 14);
        return;
      }
    }
    while (d.v.p.d());
    this.c.a(false, 8);
  }

  private void d()
  {
    if ((c.j.c.e()) && (1 == d.v.h.d()))
      this.c.a(false);
  }

  private void e()
  {
    if (c.j.c.e())
    {
      if (2 == d.v.h.d())
        this.c.a(true, 7);
      f();
    }
  }

  private void f()
  {
    if (c.j.c.e())
      if ((d.v.h.d() != 2) || (!d.f.d.d()))
        break label43;
    label43: for (int j = 1; j != 0; j = 0)
    {
      this.e.b(3);
      return;
    }
    this.e.a(3);
  }

  public void a()
  {
    b();
    c();
    d();
    this.b.a(true);
  }

  @Subscribe
  public void onCheckGdprEvent(com.viber.voip.ui.e.a parama)
  {
    if (d.v.s.d() < d.v.r.d())
      f();
  }

  public void onFeatureStateChanged(com.viber.voip.i.f paramf)
  {
    if (c.j.b == paramf)
      if (paramf.e())
        this.c.a(true, 4);
    do
    {
      return;
      if (c.j.c.c().equals(paramf.c()))
      {
        c();
        d();
        return;
      }
    }
    while (!c.j.a.c().equals(paramf.c()));
    f();
    this.e.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.c
 * JD-Core Version:    0.6.2
 */