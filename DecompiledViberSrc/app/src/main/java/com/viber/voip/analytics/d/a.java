package com.viber.voip.analytics.d;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.e.f;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.api.URLSchemeHandlerActivity;
import com.viber.voip.notif.g;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import com.viber.voip.util.i.e;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class a extends com.viber.voip.util.b
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(1L);
  private final Handler c;
  private final Object d = new Object();
  private final e e;
  private final AtomicBoolean f = new AtomicBoolean();
  private final AtomicLong g = new AtomicLong();
  private String h = "App Icon Click";
  private a i;

  public a(Handler paramHandler, e parame)
  {
    this.c = paramHandler;
    this.e = parame;
  }

  private void c()
  {
    if (this.i != null)
    {
      this.i.a(this.h);
      this.h = "App Icon Click";
    }
  }

  private void d()
  {
    if (!this.f.compareAndSet(true, false));
    long l2;
    do
    {
      long l1;
      do
      {
        return;
        if ("URL Scheme".equals(this.h))
          this.h = "App Icon Click";
        l1 = this.g.get();
      }
      while (l1 == 0L);
      l2 = this.e.a() - l1;
    }
    while (this.i == null);
    this.i.a(l2);
  }

  public void a()
  {
    d();
  }

  public void a(a parama)
  {
    this.i = parama;
    if (this.f.get())
      c();
  }

  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (paramActivity.getClass().equals(URLSchemeHandlerActivity.class))
      this.h = "URL Scheme";
  }

  public void onActivityPaused(Activity paramActivity)
  {
    this.c.removeCallbacksAndMessages(this.d);
    this.c.postAtTime(new b(this), this.d, this.e.b() + b);
  }

  public void onActivityResumed(Activity paramActivity)
  {
    this.c.removeCallbacksAndMessages(this.d);
    if (g.a(paramActivity.getIntent()))
      this.h = "Notification";
    while (true)
    {
      if (this.f.compareAndSet(false, true))
      {
        this.g.set(this.e.a());
        c();
      }
      return;
      if (!"URL Scheme".equals(this.h))
        this.h = "App Icon Click";
    }
  }

  public static class a
  {
    private static final Logger a = ViberEnv.getLogger();
    private final Handler b;
    private final d c;
    private final com.viber.voip.analytics.story.g.a d;
    private final af e;
    private final f f;
    private final AtomicBoolean g = new AtomicBoolean();
    private final Runnable h = new Runnable()
    {
      public void run()
      {
        if (!a.a.a(a.a.this).get())
          return;
        String str = da.h(a.a.b(a.a.this).k());
        a.a.d(a.a.this).a(true, ae.b(), str, a.a.c(a.a.this).b());
        a.a.e(a.a.this).a(Locale.getDefault().getLanguage(), ViberApplication.getInstance().getCurrentSystemLanguage(), ao.f());
      }
    };

    public a(Handler paramHandler, d paramd, com.viber.voip.analytics.story.g.a parama, af paramaf, f paramf)
    {
      this.b = paramHandler;
      this.c = paramd;
      this.d = parama;
      this.e = paramaf;
      this.f = paramf;
    }

    public void a(long paramLong)
    {
      if (this.g.compareAndSet(true, false))
        this.d.a(Math.max(1L, TimeUnit.MILLISECONDS.toSeconds(paramLong)));
    }

    public void a(String paramString)
    {
      if (this.g.compareAndSet(false, true))
      {
        this.b.removeCallbacks(this.h);
        this.c.d(paramString);
        this.b.post(this.h);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.d.a
 * JD-Core Version:    0.6.2
 */