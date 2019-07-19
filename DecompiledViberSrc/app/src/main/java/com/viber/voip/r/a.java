package com.viber.voip.r;

import android.arch.lifecycle.e;
import android.arch.lifecycle.e.b;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.HomeActivity;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.a.a;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.ViberActionRunner.s;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import java.lang.ref.WeakReference;

public class a
  implements a.a, f.a
{
  private static final Logger a = ViberEnv.getLogger();
  private WeakReference<HomeActivity> b;
  private Handler c;
  private com.viber.voip.util.d d;
  private com.viber.common.b.b e;
  private com.viber.common.b.d f;
  private com.viber.common.b.b g;
  private com.viber.common.b.d h;
  private com.viber.common.b.d i;
  private com.viber.common.b.d j;
  private com.viber.common.b.d k;
  private f l;
  private f m;
  private f n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private d.b x;
  private dagger.a<com.viber.voip.engagement.a> y;
  private d.al z;

  public a(Handler paramHandler, com.viber.voip.util.d paramd, dagger.a<com.viber.voip.engagement.a> parama, com.viber.common.b.b paramb1, com.viber.common.b.d paramd1, com.viber.common.b.b paramb2, com.viber.common.b.d paramd2, com.viber.common.b.d paramd3, com.viber.common.b.d paramd4, com.viber.common.b.d paramd5, f paramf1, f paramf2, f paramf3)
  {
    this.c = paramHandler;
    this.d = paramd;
    this.y = parama;
    this.e = paramb1;
    this.f = paramd1;
    this.g = paramb2;
    this.h = paramd2;
    this.i = paramd3;
    this.j = paramd4;
    this.k = paramd5;
    this.l = paramf1;
    this.l.a(this);
    this.m = paramf2;
    this.m.a(this);
    this.n = paramf3;
    this.n.a(this);
    k();
    if ((this.p) || (this.s) || (this.v))
      this.d.a(m(), this.c);
    com.viber.voip.settings.d.a(l());
    if (d() >= 0)
    {
      this.o = true;
      com.viber.voip.settings.d.b(this.z);
    }
    this.c.post(new b(this));
  }

  private void a(int paramInt)
  {
    this.h.a(paramInt);
  }

  private int d()
  {
    return this.h.d();
  }

  private void e()
  {
    int i1 = 2;
    int i2 = d();
    if (!this.o)
      return;
    k();
    if ((!this.r) && ((!this.m.e()) || (this.g.d()) || (this.f.d() != 0)))
      this.i.a(i1);
    if (this.i.d() == 0)
      i1 = 1;
    while (true)
      if (i2 != i1)
      {
        a(i1);
        f();
        return;
        if (this.j.d() != 0)
          if (this.k.d() == 0)
            i1 = 3;
          else if (!j())
            i1 = 4;
      }
      else
      {
        if (j())
          break;
        f();
        return;
        i1 = i2;
      }
  }

  private void f()
  {
    int i1 = d();
    k();
    HomeActivity localHomeActivity = n();
    switch (i1)
    {
    default:
    case 4:
    case 1:
      do
      {
        do
          return;
        while ((localHomeActivity == null) || (localHomeActivity.isFinishing()));
        com.viber.voip.gdpr.d.a(localHomeActivity);
        return;
        if (this.r)
        {
          e();
          return;
        }
      }
      while ((this.q) || (localHomeActivity == null) || (localHomeActivity.isFinishing()));
      com.viber.voip.gdpr.d.a(localHomeActivity);
      return;
    case 2:
      if (this.t)
      {
        e();
        return;
      }
      this.j.a(0);
      return;
    case 3:
    }
    if (this.w)
    {
      e();
      return;
    }
    i();
  }

  private void g()
  {
    h();
    k();
    if ((this.q) && (this.p))
      this.i.a(0);
    do
    {
      return;
      if ((this.s) && (((com.viber.voip.engagement.a)this.y.get()).c()))
      {
        this.j.a(0);
        return;
      }
    }
    while (!this.v);
    this.j.a(2);
    this.k.a(0);
  }

  private void h()
  {
    if (this.i.d() == 0)
      this.i.a(1);
    if (this.j.d() == 0)
      this.j.a(1);
    if (this.k.d() == 0)
      this.k.a(1);
  }

  private void i()
  {
    this.e.a(true);
    HomeActivity localHomeActivity = n();
    if ((localHomeActivity != null) && (localHomeActivity.isInAppCampaignSupported()) && (!z.a(localHomeActivity)))
    {
      AppboyInAppMessageManager.getInstance().requestDisplayInAppMessage();
      this.k.a(2);
      this.w = true;
    }
  }

  private boolean j()
  {
    k();
    return (this.s) || (this.q) || (this.u);
  }

  private void k()
  {
    int i1 = 1;
    int i2;
    int i3;
    label32: int i4;
    label51: int i5;
    label71: int i6;
    label91: int i7;
    if (this.f.d() == 0)
    {
      i2 = i1;
      this.p = i2;
      if (this.i.d() != i1)
        break label138;
      i3 = i1;
      this.q = i3;
      if (this.i.d() != 2)
        break label143;
      i4 = i1;
      this.r = i4;
      if (this.j.d() != i1)
        break label149;
      i5 = i1;
      this.s = i5;
      if (this.j.d() != 2)
        break label155;
      i6 = i1;
      this.t = i6;
      if (this.k.d() != i1)
        break label161;
      i7 = i1;
      label111: this.u = i7;
      if (this.e.d())
        break label167;
    }
    while (true)
    {
      this.v = i1;
      return;
      i2 = 0;
      break;
      label138: i3 = 0;
      break label32;
      label143: i4 = 0;
      break label51;
      label149: i5 = 0;
      break label71;
      label155: i6 = 0;
      break label91;
      label161: i7 = 0;
      break label111;
      label167: i1 = 0;
    }
  }

  private SharedPreferences.OnSharedPreferenceChangeListener l()
  {
    if (this.z == null)
    {
      com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
      arrayOfa[0] = this.h;
      this.z = new d.al(arrayOfa)
      {
        public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
        {
          if ((a.a(a.this).c().equals(paramAnonymousa.c())) && (a.b(a.this) == 0))
          {
            a.a(a.this, true);
            HomeActivity localHomeActivity = a.c(a.this);
            if ((localHomeActivity != null) && (localHomeActivity.getLifecycle().a().a(e.b.e)))
              a.d(a.this);
            com.viber.voip.settings.d.b(a.e(a.this));
          }
        }
      };
    }
    return this.z;
  }

  private d.b m()
  {
    if (this.x == null)
      this.x = new d.b()
      {
        public void onAppStopped()
        {
          a.f(a.this).postDelayed(new c(this), 3000L);
        }

        public void onBackground()
        {
          i.a(this);
        }

        public void onForeground()
        {
          i.b(this);
        }

        public void onForegroundStateChanged(boolean paramAnonymousBoolean)
        {
          i.a(this, paramAnonymousBoolean);
        }
      };
    return this.x;
  }

  private HomeActivity n()
  {
    if (this.b != null)
      return (HomeActivity)this.b.get();
    return null;
  }

  public void a()
  {
    HomeActivity localHomeActivity = n();
    if ((localHomeActivity != null) && (!localHomeActivity.isFinishing()))
      ViberActionRunner.s.a(localHomeActivity);
  }

  public void a(HomeActivity paramHomeActivity)
  {
    this.b = new WeakReference(paramHomeActivity);
  }

  public void b()
  {
    e();
  }

  public void b(HomeActivity paramHomeActivity)
  {
    if ((this.b != null) && (n() == paramHomeActivity))
    {
      this.b.clear();
      this.b = null;
    }
  }

  public void onFeatureStateChanged(f paramf)
  {
    if (!paramf.e())
    {
      if (!paramf.c().equals(this.l.c()))
        break label33;
      this.k.a(2);
    }
    label33: 
    do
    {
      return;
      if (paramf.c().equals(this.m.c()))
      {
        this.i.a(2);
        return;
      }
    }
    while (!paramf.c().equals(this.n.c()));
    this.j.a(2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.r.a
 * JD-Core Version:    0.6.2
 */