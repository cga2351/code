package com.yandex.metrica.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.a;
import com.yandex.metrica.g;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.oq;
import com.yandex.metrica.impl.ob.pr;
import com.yandex.metrica.impl.ob.pt;
import com.yandex.metrica.impl.ob.px;
import com.yandex.metrica.impl.ob.u;

public class ad extends c
  implements ag
{
  private static final px<String> e = new pt(new pr("Deeplink"));
  private static final px<String> f = new pt(new pr("Referral url"));
  private boolean g = true;
  private a h;

  ad(Context paramContext, g paramg, bj parambj, bg parambg, a parama)
  {
    super(paramContext, parambj, parambg);
    this.b.a(new ax(paramg.preloadInfo, this.c));
    this.g = oq.a(paramg.crashReporting, true);
    this.h = parama;
  }

  public ad(Context paramContext, u paramu, g paramg, bj parambj)
  {
  }

  private void g(String paramString)
  {
    if (this.c.c())
    {
      StringBuilder localStringBuilder = new StringBuilder("App opened ");
      localStringBuilder.append(" via deeplink: ");
      localStringBuilder.append(d(paramString));
      this.c.a(localStringBuilder.toString());
    }
  }

  public void a(Activity paramActivity)
  {
    if (paramActivity != null)
      if (paramActivity.getIntent() != null)
      {
        str = paramActivity.getIntent().getDataString();
        if (!TextUtils.isEmpty(str))
          this.d.a(s.e(str, this.c), this.b);
        g(str);
      }
    while (!this.c.c())
    {
      String str;
      return;
    }
    this.c.b("Null activity parameter for reportAppOpen(Activity)");
  }

  public void a(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (this.c.c())
        this.c.a("Enable activity auto tracking");
      paramApplication.registerActivityLifecycleCallbacks(new n(this));
    }
    while (!this.c.c())
      return;
    this.c.b("Could not enable activity auto tracking. API level should be more than 14 (ICE_CREAM_SANDWICH)");
  }

  public void a(Location paramLocation)
  {
    this.b.b().a(paramLocation);
    if (this.c.c())
      this.c.a("Set location: %s" + paramLocation.toString(), new Object[0]);
  }

  void a(g paramg, boolean paramBoolean)
  {
    a(paramg.nativeCrashReporting);
    if (paramBoolean)
      b();
    b(paramg.i);
    a(paramg.h);
  }

  public void a(Boolean paramBoolean)
  {
    this.d.a(oq.a(paramBoolean, true));
    if (this.c.c())
      this.c.a("Set report native crashes enabled: %b", new Object[] { paramBoolean });
  }

  public void a(boolean paramBoolean)
  {
    this.b.b().a(paramBoolean);
  }

  public void b(Activity paramActivity)
  {
    a(d(paramActivity));
    this.h.a();
  }

  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.c.c())
    {
      of localof = this.c;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localof.a("Set report crashes enabled: %b", arrayOfObject);
    }
  }

  public void c(Activity paramActivity)
  {
    b(d(paramActivity));
    this.h.b();
  }

  String d(Activity paramActivity)
  {
    String str = null;
    if (paramActivity != null)
      str = paramActivity.getClass().getSimpleName();
    return str;
  }

  public void e(String paramString)
  {
    e.a(paramString);
    this.d.a(s.e(paramString, this.c), this.b);
    g(paramString);
  }

  public void f(String paramString)
  {
    f.a(paramString);
    this.d.a(s.f(paramString, this.c), this.b);
    if (this.c.c())
    {
      StringBuilder localStringBuilder = new StringBuilder("Referral URL received: ");
      localStringBuilder.append(d(paramString));
      this.c.a(localStringBuilder.toString());
    }
  }

  public boolean f()
  {
    return this.g;
  }

  public void reportError(String paramString, Throwable paramThrowable)
  {
    super.reportError(paramString, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ad
 * JD-Core Version:    0.6.2
 */