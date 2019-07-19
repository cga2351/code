package com.my.target.b.d;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import com.my.target.b.c.a.i;
import com.my.target.bi;
import com.my.target.bl;
import com.my.target.dc;
import com.my.target.df.a;
import com.my.target.dp;
import com.my.target.dq;
import com.my.target.k;
import com.my.target.o;
import com.my.target.q;
import java.util.Set;

public final class h
{
  private final k a;
  private final a b;
  private final dc c;
  private final bl d;
  private float e;
  private boolean f;
  private boolean g = true;
  private Set<o> h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private k.b m;
  private boolean n;

  private h(k paramk, dc paramdc)
  {
    this.a = paramk;
    this.b = new a();
    this.c = paramdc;
    paramdc.setMediaListener(this.b);
    this.d = bl.a(paramk.y());
    this.d.a(paramdc.getPromoMediaView());
  }

  public static h a(k paramk, dc paramdc)
  {
    return new h(paramk, paramdc);
  }

  private void a(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
      localAudioManager.requestAudioFocus(this.b, 3, 2);
  }

  private void b(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
      localAudioManager.abandonAudioFocus(this.b);
  }

  private void f()
  {
    if (this.c.g())
      a(this.c.getView().getContext());
    this.c.a(2);
  }

  public final void a()
  {
    b(this.c.getView().getContext());
  }

  public final void a(i parami)
  {
    this.c.f();
    this.c.a(parami);
  }

  public final void a(k.b paramb)
  {
    this.m = paramb;
  }

  public final void a(k paramk, Context paramContext)
  {
    this.l = paramk.R();
    this.j = paramk.P();
    if ((this.j) && (paramk.O() == 0.0F) && (paramk.K()))
    {
      dp.a("banner is allowed to close");
      this.c.f();
    }
    this.e = paramk.A();
    this.f = paramk.I();
    if (this.f)
    {
      this.c.a(0);
      return;
    }
    if (paramk.K())
      a(paramContext);
    this.c.a(2);
  }

  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public final void b()
  {
    b(this.c.getView().getContext());
    this.c.a();
  }

  public final void c()
  {
    this.c.h();
    b(this.c.getView().getContext());
    if ((this.c.g()) && (!this.c.b()))
      bi.a(this.a.y().a("playbackPaused"), this.c.getView().getContext());
  }

  public final void d()
  {
    this.c.a(true);
    b(this.c.getView().getContext());
    if (this.k)
      bi.a(this.a.y().a("closedByUser"), this.c.getView().getContext());
  }

  public final boolean e()
  {
    return this.l;
  }

  public final class a
    implements df.a
  {
    public a()
    {
    }

    public final void a()
    {
      if (!h.a(h.this))
        h.a(h.this, h.b(h.this).getView().getContext());
      h.b(h.this).c();
    }

    public final void a(float paramFloat)
    {
      dc localdc = h.b(h.this);
      if (paramFloat <= 0.0F);
      for (boolean bool = true; ; bool = false)
      {
        localdc.b(bool);
        return;
      }
    }

    public final void a(float paramFloat1, float paramFloat2)
    {
      while (true)
      {
        h.b(h.this).setTimeChanged(paramFloat1);
        h.b(h.this, false);
        if (h.h(h.this))
        {
          h.i(h.this);
          bi.a(h.d(h.this).y().a("playbackStarted"), h.b(h.this).getView().getContext());
          h.a(h.this, 0.0F);
          h.j(h.this);
        }
        if (!h.k(h.this))
          h.l(h.this);
        if ((h.f(h.this)) && (h.d(h.this).K()) && (h.d(h.this).O() <= paramFloat1))
          h.b(h.this).f();
        if (paramFloat1 <= h.m(h.this))
        {
          if (paramFloat1 != 0.0F)
            h.a(h.this, paramFloat1);
          if (paramFloat1 == h.m(h.this))
            g();
          return;
        }
        paramFloat1 = h.m(h.this);
      }
    }

    public final void a(String paramString)
    {
      dp.a("Video playing error: " + paramString);
      h.n(h.this);
      if (h.o(h.this) != null)
        h.o(h.this).c();
    }

    public final void b()
    {
    }

    public final void c()
    {
      if ((h.f(h.this)) && (h.d(h.this).O() == 0.0F))
        h.b(h.this).f();
      h.b(h.this).i();
    }

    public final void d()
    {
      if (h.g(h.this))
        h.b(h.this).h();
    }

    public final void e()
    {
    }

    public final void f()
    {
    }

    public final void g()
    {
      if (h.p(h.this))
        return;
      h.b(h.this, true);
      dp.a("Video playing complete:");
      h.q(h.this);
      h.n(h.this);
      if (h.o(h.this) != null)
        h.o(h.this).d();
      h.b(h.this).f();
      h.b(h.this).e();
    }

    public final void h()
    {
      if (!h.a(h.this))
      {
        h.c(h.this);
        bi.a(h.d(h.this).y().a("volumeOff"), h.b(h.this).getView().getContext());
        h.a(h.this, true);
        return;
      }
      h.e(h.this);
      bi.a(h.d(h.this).y().a("volumeOn"), h.b(h.this).getView().getContext());
      h.a(h.this, false);
    }

    public final void i()
    {
      h.b(h.this, h.b(h.this).getView().getContext());
      bi.a(h.d(h.this).y().a("playbackPaused"), h.b(h.this).getView().getContext());
      h.b(h.this).h();
    }

    public final void j()
    {
      bi.a(h.d(h.this).y().a("playbackResumed"), h.b(h.this).getView().getContext());
      h.b(h.this).d();
      if (h.a(h.this))
      {
        h.c(h.this);
        return;
      }
      h.e(h.this);
    }

    public final void onAudioFocusChange(final int paramInt)
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 23)
        bool = Looper.getMainLooper().isCurrentThread();
      while (bool)
      {
        h.a(h.this, paramInt);
        return;
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
          bool = true;
        else
          bool = false;
      }
      dq.c(new Runnable()
      {
        public final void run()
        {
          h.a(h.this, paramInt);
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.h
 * JD-Core Version:    0.6.2
 */