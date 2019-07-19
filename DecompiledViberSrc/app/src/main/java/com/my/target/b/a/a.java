package com.my.target.b.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.my.target.aq;
import com.my.target.aq.a;
import com.my.target.bi;
import com.my.target.bl;
import com.my.target.bn.a;
import com.my.target.bo;
import com.my.target.bw;
import com.my.target.bw.d;
import com.my.target.common.a.b;
import com.my.target.common.a.c;
import com.my.target.dp;
import com.my.target.k;
import com.my.target.o;
import com.my.target.q;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  implements aq.a, bn.a, bw.d
{
  private final k a;
  private final c b;
  private final AudioManager.OnAudioFocusChangeListener c;
  private final com.my.target.b.c.a.a d;
  private final HashSet<o> e;
  private final bl f;
  private View.OnClickListener g;
  private WeakReference<com.my.target.c.b.a> h;
  private WeakReference<aq> i;
  private WeakReference<bw> j;
  private WeakReference<Context> k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private b q;
  private bo r;
  private boolean s;
  private long t;

  public a(com.my.target.b.c.a.a parama, k paramk, c paramc)
  {
    this.a = paramk;
    this.d = parama;
    this.e = new HashSet();
    this.b = paramc;
    this.m = this.a.K();
    this.p = this.a.I();
    q localq = this.a.y();
    this.f = bl.a(localq);
    this.e.addAll(localq.d());
    this.c = new a((byte)0);
  }

  private void a(float paramFloat, Context paramContext)
  {
    if (!this.e.isEmpty())
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (localo.a() <= paramFloat)
        {
          bi.a(localo, paramContext);
          localIterator.remove();
        }
      }
    }
  }

  private void a(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    if (localAudioManager != null)
      localAudioManager.abandonAudioFocus(this.c);
  }

  private void a(TextureView paramTextureView, boolean paramBoolean)
  {
    if (this.r == null)
    {
      this.r = bo.a(paramTextureView.getContext());
      this.r.a(this);
    }
    if (paramBoolean)
      r();
    while (true)
    {
      this.r.a(this.b, paramTextureView);
      if (this.t > 0L)
        this.r.a(this.t);
      return;
      t();
    }
  }

  private void a(String paramString, Context paramContext)
  {
    bi.a(this.a.y().a(paramString), paramContext);
  }

  private com.my.target.c.b.a p()
  {
    WeakReference localWeakReference = this.h;
    com.my.target.c.b.a locala = null;
    if (localWeakReference != null)
      locala = (com.my.target.c.b.a)this.h.get();
    return locala;
  }

  private void q()
  {
    if (this.r == null)
      return;
    this.r.a(null);
    this.r.b();
    this.r = null;
  }

  private void r()
  {
    if (this.r != null)
      this.r.f();
  }

  private void s()
  {
    if ((this.n) && (this.j != null))
    {
      this.l = 2;
      bw localbw = (bw)this.j.get();
      if (localbw != null)
      {
        if (this.r != null)
          this.r.i();
        localbw.c();
      }
    }
  }

  private void t()
  {
    if (this.r != null)
      this.r.g();
  }

  private void u()
  {
    if ((this.r != null) && (this.r.c()))
      this.r.h();
    while (true)
    {
      f();
      return;
      if ((this.n) && (this.j != null))
        a(((bw)this.j.get()).getTextureView(), true);
    }
  }

  public final void a()
  {
    dp.a("Dismiss dialog");
    this.i = null;
    this.n = false;
    r();
    com.my.target.c.b.a locala = p();
    if (locala == null)
      return;
    a(locala.getContext());
    switch (this.l)
    {
    default:
      this.m = false;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      a("fullscreenOff", locala.getContext());
      this.j = null;
      return;
      this.l = 4;
      c();
      if (this.a.K())
        this.m = true;
      View localView2 = locala.getChildAt(0);
      if ((localView2 instanceof TextureView))
      {
        a((TextureView)localView2, true);
        continue;
        this.m = false;
        b();
        continue;
        this.m = true;
        f();
        View localView1 = locala.getChildAt(0);
        if ((localView1 instanceof TextureView))
          a((TextureView)localView1, true);
      }
    }
  }

  public final void a(float paramFloat)
  {
    bw localbw;
    if (this.j != null)
    {
      localbw = (bw)this.j.get();
      if (localbw != null)
      {
        if (paramFloat <= 0.0F)
          break label34;
        localbw.a(false);
      }
    }
    return;
    label34: localbw.a(true);
  }

  public final void a(float paramFloat1, float paramFloat2)
  {
    while (true)
    {
      this.t = 0L;
      WeakReference localWeakReference = this.h;
      Context localContext = null;
      if (localWeakReference != null)
      {
        View localView = (View)this.h.get();
        localContext = null;
        if (localView != null)
          localContext = localView.getContext();
      }
      c();
      this.f.a(paramFloat1);
      if (!this.o)
      {
        if (this.q != null)
          this.q.a();
        if (localContext != null)
        {
          a("playbackStarted", localContext);
          this.e.clear();
          q localq = this.a.y();
          this.e.addAll(localq.d());
          a(0.0F, localContext);
        }
        this.o = true;
      }
      float f1 = this.a.A();
      if (this.j != null)
      {
        bw localbw = (bw)this.j.get();
        if (localbw != null)
          localbw.a(paramFloat1, f1);
      }
      if (paramFloat1 <= f1)
      {
        if ((paramFloat1 > 0.0F) && (localContext != null))
          a(paramFloat1, localContext);
        if (paramFloat1 == f1)
        {
          b();
          this.l = 3;
          this.m = false;
          if (this.r != null)
            this.r.d();
          if (this.q != null)
            this.q.c();
        }
        return;
      }
      paramFloat1 = f1;
    }
  }

  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }

  public final void a(View paramView)
  {
    if (this.l == 1)
    {
      if (this.r != null)
        this.r.i();
      d();
    }
    if (this.g != null)
      this.g.onClick(paramView);
  }

  public final void a(aq paramaq, FrameLayout paramFrameLayout)
  {
    bw localbw = new bw(paramFrameLayout.getContext());
    this.l = 4;
    this.i = new WeakReference(paramaq);
    localbw.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    paramFrameLayout.addView(localbw);
    this.j = new WeakReference(localbw);
    localbw.a(this.d, this.b);
    localbw.setVideoDialogViewListener(this);
    localbw.a(this.p);
    a("fullscreenOn", paramFrameLayout.getContext());
    a(localbw.getTextureView(), this.p);
  }

  public final void a(b paramb)
  {
    this.q = paramb;
  }

  public final void a(com.my.target.c.b.a parama, Context paramContext)
  {
    dp.a("register video ad with view " + parama);
    h();
    this.h = new WeakReference(parama);
    this.k = new WeakReference(paramContext);
    TextureView localTextureView = new TextureView(parama.getContext());
    parama.addView(localTextureView, 0);
    this.f.a(localTextureView);
    if (!this.n)
    {
      if (!this.m)
        break label105;
      f();
    }
    while (true)
    {
      parama.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          a.a(a.this, paramAnonymousView);
        }
      });
      return;
      label105: b();
    }
  }

  public final void a(String paramString)
  {
    this.l = 3;
    b();
  }

  public final void a(boolean paramBoolean)
  {
    if ((this.r != null) && (!paramBoolean))
    {
      this.t = this.r.m();
      q();
      d();
    }
  }

  public final void b()
  {
    this.o = false;
    com.my.target.c.b.a locala = p();
    if (locala != null)
    {
      ImageView localImageView = locala.getImageView();
      b localb = this.a.l();
      if (localb != null)
        localImageView.setImageBitmap(localb.e());
      localImageView.setVisibility(0);
      locala.getPlayButtonView().setVisibility(0);
      locala.getProgressBarView().setVisibility(8);
    }
    for (Context localContext = locala.getContext(); ; localContext = null)
    {
      if ((this.n) && (this.j != null))
      {
        bw localbw = (bw)this.j.get();
        if (localbw != null)
        {
          localbw.a();
          localContext = localbw.getContext();
        }
      }
      if (localContext != null)
        a(localContext);
      return;
    }
  }

  public final void c()
  {
    if (this.l == 1);
    bw localbw;
    do
    {
      do
      {
        return;
        this.l = 1;
        com.my.target.c.b.a locala = p();
        if (locala != null)
        {
          locala.getImageView().setVisibility(4);
          locala.getProgressBarView().setVisibility(8);
          locala.getPlayButtonView().setVisibility(8);
        }
      }
      while ((!this.n) || (this.j == null));
      localbw = (bw)this.j.get();
    }
    while (localbw == null);
    localbw.d();
  }

  public final void d()
  {
    com.my.target.c.b.a locala = p();
    Context localContext = null;
    if (locala != null)
    {
      localContext = locala.getContext();
      locala.getPlayButtonView().setVisibility(0);
      locala.getProgressBarView().setVisibility(8);
    }
    s();
    if (locala != null)
      a(localContext);
    if (this.q != null)
      this.q.b();
  }

  public final void e()
  {
  }

  public final void f()
  {
    this.l = 4;
    com.my.target.c.b.a locala = p();
    if (locala != null)
    {
      locala.getProgressBarView().setVisibility(0);
      locala.getImageView().setVisibility(0);
      locala.getPlayButtonView().setVisibility(8);
    }
    if ((this.n) && (this.j != null))
    {
      bw localbw = (bw)this.j.get();
      if (localbw != null)
        localbw.b();
    }
  }

  public final void g()
  {
  }

  public final void h()
  {
    j();
    this.f.a(null);
    q();
    com.my.target.c.b.a locala;
    if (this.h != null)
    {
      locala = (com.my.target.c.b.a)this.h.get();
      if ((locala != null) && ((locala.getChildAt(0) instanceof TextureView)))
        locala.removeViewAt(0);
    }
    while (true)
    {
      if (!this.n)
      {
        if (locala != null)
          locala.setOnClickListener(null);
        this.h = null;
      }
      return;
      locala = null;
    }
  }

  public final void i()
  {
    com.my.target.c.b.a locala = p();
    if (locala == null)
    {
      dp.a("Trying to play video in unregistered view");
      q();
    }
    TextureView localTextureView;
    do
    {
      do
      {
        return;
        if (locala.getWindowVisibility() != 0)
        {
          if (this.l == 1)
          {
            if (this.r != null)
              this.t = this.r.m();
            q();
            this.l = 4;
            this.s = false;
            f();
            return;
          }
          q();
          return;
        }
      }
      while (this.s);
      this.s = true;
      boolean bool = locala.getChildAt(0) instanceof TextureView;
      localTextureView = null;
      if (bool)
        localTextureView = (TextureView)locala.getChildAt(0);
      if (localTextureView == null)
      {
        q();
        return;
      }
      if ((this.r != null) && (this.b != this.r.k()))
        q();
      if (!this.m)
      {
        locala.getImageView().setVisibility(0);
        locala.getPlayButtonView().setVisibility(0);
        locala.getProgressBarView().setVisibility(8);
      }
    }
    while ((!this.m) || (this.n));
    if ((this.r != null) && (this.r.c()))
      this.r.h();
    while (true)
    {
      r();
      return;
      a(localTextureView, true);
    }
  }

  public final void j()
  {
    if ((!this.s) || (this.n));
    do
    {
      return;
      this.s = false;
    }
    while ((this.l != 1) || (this.r == null));
    this.r.i();
    this.l = 2;
  }

  public final void k()
  {
    if (this.i != null)
    {
      aq localaq = (aq)this.i.get();
      if (localaq != null)
      {
        Context localContext = localaq.getContext();
        u();
        a("playbackResumed", localContext);
      }
    }
    if (this.q != null)
      this.q.a();
  }

  public final void l()
  {
    u();
    if (this.j != null)
    {
      bw localbw = (bw)this.j.get();
      if (localbw != null)
      {
        localbw.getMediaAdView().getImageView().setVisibility(8);
        localbw.e();
      }
    }
    if (this.q != null)
      this.q.a();
  }

  public final void m()
  {
    if (this.l == 1)
    {
      s();
      this.l = 2;
      if (this.q != null)
        this.q.b();
      if (this.i != null)
      {
        aq localaq = (aq)this.i.get();
        if (localaq != null)
          a("playbackPaused", localaq.getContext());
      }
    }
  }

  public final void n()
  {
    if (this.i == null);
    for (aq localaq = null; ; localaq = (aq)this.i.get())
    {
      if ((localaq != null) && (localaq.isShowing()))
        localaq.dismiss();
      return;
    }
  }

  public final void o()
  {
    boolean bool = true;
    com.my.target.c.b.a locala = p();
    Context localContext;
    if ((locala != null) && (this.r != null))
    {
      localContext = locala.getContext();
      if (this.r.l())
      {
        this.r.g();
        a("volumeOn", localContext);
        bool = false;
      }
    }
    while (true)
    {
      this.p = bool;
      return;
      this.r.f();
      a("volumeOff", localContext);
      this.p = bool;
      return;
      if (this.p)
        break;
    }
  }

  private final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    private a()
    {
    }

    public final void onAudioFocusChange(int paramInt)
    {
      switch (paramInt)
      {
      case 0:
      case 3:
      default:
      case -2:
      case -1:
      case 1:
      case 2:
      case 4:
        do
        {
          return;
          a.a(a.this);
          dp.a("Audiofocus loss, pausing");
          return;
        }
        while (!a.b(a.this));
        dp.a("Audiofocus gain, unmuting");
        a.c(a.this);
        return;
      case -3:
      }
      a.d(a.this);
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.a.a
 * JD-Core Version:    0.6.2
 */