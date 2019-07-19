package com.viber.voip.messages.ui.media;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.android.exoplayer2.aa.a;
import com.google.android.exoplayer2.aj;
import com.google.android.exoplayer2.aj.b;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.f.n;
import com.google.android.exoplayer2.f.q;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.a.a;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.y;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.ui.b.a;
import com.viber.voip.ui.b.c;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.bj;
import com.viber.voip.util.ca;
import com.viber.voip.util.cj;
import com.viber.voip.util.dd;
import com.viber.voip.util.dj;
import com.viber.voip.util.dk;
import com.viber.voip.util.upload.o;
import com.viber.voip.widget.PlayableImageView;

public abstract class e
  implements SeekBar.OnSeekBarChangeListener, aa.a, aj.b
{
  private static final Logger a = ViberEnv.getLogger();
  private PlayableImageView b;
  private final PlayerView c;
  private aj d;
  private final SeekBar e;
  private final TextView f;
  private final TextView g;
  private c h;
  private d i = d.d;
  private a j = a.h;
  private Handler k;
  private PowerManager.WakeLock l;
  private long m = 0L;
  private Uri n;
  private Uri o;
  private String p;
  private e q;
  private final h r;
  private final h.a s = new h.a()
  {
    public boolean a()
    {
      if (e.this.n())
      {
        e.this.i();
        return true;
      }
      return false;
    }

    public boolean b()
    {
      if (e.this.l())
      {
        e.this.j();
        return true;
      }
      return false;
    }
  };
  private boolean t = false;
  private b u = new b(null);

  public e(h paramh, PlayerView paramPlayerView, PlayableImageView paramPlayableImageView, SeekBar paramSeekBar, TextView paramTextView1, TextView paramTextView2, a parama)
  {
    this.r = paramh;
    this.c = paramPlayerView;
    this.e = paramSeekBar;
    this.f = paramTextView1;
    this.g = paramTextView2;
    this.b = paramPlayableImageView;
    this.j = parama;
    this.h = new c(null);
    this.k = av.a(av.e.a);
    if (this.b != null)
      this.b.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          e.this.h();
        }
      });
  }

  private void A()
  {
    if ((this.l != null) && (this.l.isHeld()))
      this.l.release();
    this.l = null;
  }

  private void B()
  {
    x();
    z();
  }

  private void C()
  {
    y();
    A();
  }

  private void a(a parama)
  {
    if ((parama == a.g) && (this.j == a.h))
      return;
    if (this.j != parama);
    for (boolean bool = true; ; bool = false)
    {
      this.j = parama;
      if (this.b == null)
        break;
      switch (5.a[parama.ordinal()])
      {
      case 7:
      default:
        this.b.c();
        this.b.a();
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 8:
      case 9:
      }
    }
    this.b.c();
    this.b.d(true);
    return;
    this.b.b();
    this.b.b(true);
    return;
    this.b.d(true);
    return;
    this.b.b(false);
    return;
    this.b.c();
    this.b.c(true);
    return;
    this.b.c();
    this.b.b(bool);
    return;
    this.b.setVisibility(8);
    return;
    this.b.c();
    this.b.a(bool);
  }

  private void a(d paramd)
  {
    this.i = paramd;
    switch (5.b[paramd.ordinal()])
    {
    default:
      C();
    case 6:
      return;
    case 1:
      a(a.f);
      B();
      return;
    case 2:
      a(a.i);
      C();
      return;
    case 3:
    case 4:
    case 5:
    }
    a(a.g);
    C();
  }

  private void b(Uri paramUri)
  {
    Application localApplication = ViberApplication.getApplication();
    if (this.d != null)
    {
      this.d.c();
      this.d.q();
      this.d = null;
    }
    this.d = k.a(localApplication, new DefaultTrackSelector(new a.a(new n())));
    this.c.setPlayer(this.d);
    l locall = new l(paramUri, new q(localApplication, ag.a(localApplication, "Viber")), new j()
    {
      public com.google.android.exoplayer2.extractor.g[] createExtractors()
      {
        com.google.android.exoplayer2.extractor.g[] arrayOfg = new com.google.android.exoplayer2.extractor.g[1];
        arrayOfg[0] = new com.google.android.exoplayer2.extractor.mp4.h();
        return arrayOfg;
      }
    }
    , null, null);
    this.d.a(locall);
    this.d.a(this);
    this.d.a(this);
    this.m = 0L;
    this.g.setText(ae.h(this.m));
  }

  private void b(d paramd)
  {
    while (true)
    {
      try
      {
        switch (5.b[paramd.ordinal()])
        {
        case 2:
        case 3:
        case 6:
        case 7:
        default:
          a(paramd);
          return;
        case 4:
          if (this.d != null)
            this.d.a(false);
          this.e.removeCallbacks(this.h);
          continue;
        case 5:
        case 1:
        case 8:
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        a(d.f);
        return;
      }
      if (this.d != null)
      {
        this.d.a(false);
        this.f.setText(ae.h(this.d.t()));
      }
      this.e.removeCallbacks(this.h);
      continue;
      this.e.removeCallbacks(this.h);
      this.e.post(this.h);
      if (this.d != null)
      {
        this.d.a(true);
        continue;
        if (this.d != null)
        {
          this.n = null;
          this.o = null;
          this.p = null;
          this.d.c();
          this.d.q();
          this.d.b(this);
          this.d = null;
        }
        this.e.removeCallbacks(this.h);
      }
    }
  }

  private String w()
  {
    Application localApplication = ViberApplication.getApplication();
    String str = "";
    a(d.f);
    if (!o.b())
      str = localApplication.getString(R.string.dialog_337_title);
    do
    {
      return str;
      if ((!cj.b(localApplication)) || (ViberApplication.getInstance().getEngine(false).getServiceState() != ServiceStateDelegate.ServiceState.SERVICE_CONNECTED))
      {
        com.viber.voip.ui.dialogs.f.b().d();
        return localApplication.getString(R.string.dialog_201_title);
      }
      if ((this.n != null) && (!at.d(localApplication, this.n.getPath())))
        return localApplication.getString(R.string.file_not_found);
    }
    while (o.a());
    return localApplication.getString(R.string.dialog_351_title);
  }

  private void x()
  {
    if (this.r.c())
      this.r.a(this.s);
  }

  private void y()
  {
    if (this.r.c())
      this.r.a();
  }

  private void z()
  {
    if ((this.l != null) && (this.l.isHeld()))
      this.l.release();
    this.l = dj.a(this.c.getContext(), "com.viber.voip:video_player");
    this.l.acquire(7200000L);
  }

  public void a()
  {
    if (this.b != null)
    {
      this.b.setOnClickListener(null);
      this.b.setVisibility(8);
      this.b = null;
    }
  }

  public void a(final int paramInt)
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        if (paramInt < 100)
        {
          if (e.a(e.this) != null)
            e.a(e.this).a(paramInt / 100.0D);
          return;
        }
        e.this.a(false, false);
        e.a(e.this, e.a.g);
      }
    });
  }

  public void a(Uri paramUri)
  {
    a(paramUri, null);
  }

  public void a(Uri paramUri, String paramString)
  {
    if ((!ca.b(this.o, paramUri)) || (!ca.b(this.p, paramString)))
    {
      this.o = paramUri;
      this.p = paramString;
      String str = ae.h(0L);
      this.f.setText(str);
      this.g.setText(str);
      this.e.setProgress(0);
      this.e.setSecondaryProgress(0);
    }
    this.k.removeCallbacks(this.u);
    this.k.postDelayed(this.u, 500L);
  }

  public void a(e parame)
  {
    this.q = parame;
  }

  public void a(boolean paramBoolean)
  {
    int i1 = 8;
    if (((paramBoolean) && (this.c.getVisibility() == 0)) || ((!paramBoolean) && (this.c.getVisibility() == i1)))
      return;
    try
    {
      PlayerView localPlayerView = this.c;
      if (paramBoolean)
        i1 = 0;
      localPlayerView.setVisibility(i1);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b == null);
    while (true)
    {
      return;
      if (this.b.getVisibility() == 0);
      for (boolean bool = true; paramBoolean1 != bool; bool = false)
      {
        if (!paramBoolean2)
          break label66;
        if (!paramBoolean1)
          break label52;
        a.a(this.b, 600L, c.f);
        return;
      }
    }
    label52: a.b(this.b, 600L, c.e);
    return;
    label66: PlayableImageView localPlayableImageView = this.b;
    int i1 = 0;
    if (paramBoolean1);
    while (true)
    {
      localPlayableImageView.setVisibility(i1);
      return;
      i1 = 8;
    }
  }

  public void b()
  {
    if ((this.j != a.i) || (this.b == null))
      return;
    this.b.a(false);
    this.b.c();
  }

  public void b(int paramInt)
  {
    if (this.d != null)
    {
      this.m = paramInt;
      this.d.a(this.m);
      this.e.setProgress((int)(100.0F * (paramInt / (float)this.d.s())));
    }
  }

  public void b(boolean paramBoolean)
  {
    this.c.setKeepScreenOn(paramBoolean);
  }

  public Uri c()
  {
    return this.o;
  }

  public d d()
  {
    return this.i;
  }

  public boolean e()
  {
    return (!this.j.equals(a.a)) && (!this.j.equals(a.b)) && (!this.j.equals(a.d)) && (!this.j.equals(a.c)) && (this.n != null);
  }

  public void f()
  {
    this.e.removeCallbacks(this.h);
    if (this.d != null)
    {
      this.d.a(0L);
      this.d.a(false);
      this.e.setProgress((int)this.d.s());
      this.f.setText(ae.h(this.d.s()));
    }
    if (this.q != null)
      this.q.e();
    a(d.g);
  }

  public void g()
  {
    a(d.c);
    long l1 = this.d.s();
    this.g.setText(ae.h(l1));
    if (this.m <= 0L)
      this.e.setProgress(0);
    this.e.setOnSeekBarChangeListener(this);
    if (this.q != null)
      this.q.c();
  }

  public void h()
  {
    switch (5.a[this.j.ordinal()])
    {
    default:
      b(d.b);
      if (this.q != null)
        this.q.a(l());
      break;
    case 1:
    case 5:
    case 3:
    case 2:
    case 4:
    case 6:
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            a(a.d);
          }
          while (this.q == null);
          this.q.a();
          return;
          a(a.c);
        }
        while (this.q == null);
        this.q.a();
        return;
        a(a.b);
      }
      while (this.q == null);
      this.q.b();
      return;
      b(d.e);
    }
    while (this.q == null);
    this.q.a(l());
  }

  public void i()
  {
    if (!l())
      dd.a(new f(this));
  }

  public void j()
  {
    if (l())
      k();
    try
    {
      this.d.c();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void k()
  {
    if (l())
      dd.a(new g(this));
  }

  public boolean l()
  {
    if (this.d == null)
      return false;
    switch (this.d.j())
    {
    default:
      return false;
    case 2:
    case 3:
    }
    return this.d.l();
  }

  public boolean m()
  {
    return (this.i == d.b) || (this.i == d.e);
  }

  public boolean n()
  {
    return (this.i == d.c) || (this.i == d.d) || (this.i == d.e);
  }

  public void o()
  {
    if (!this.i.equals(d.f))
      b(d.d);
    a(false);
    a(false, false);
  }

  public void onLoadingChanged(boolean paramBoolean)
  {
  }

  public void onPlaybackParametersChanged(y paramy)
  {
  }

  public void onPlayerError(i parami)
  {
    this.e.removeCallbacks(this.h);
    if (this.i == d.d);
    String str;
    do
    {
      return;
      str = w();
    }
    while (this.q == null);
    this.q.a(str);
  }

  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    if (this.t);
    switch (paramInt)
    {
    default:
      label32: if (this.i == d.a)
        switch (paramInt)
        {
        default:
        case 3:
        }
      break;
    case 3:
    case 4:
    }
    while (true)
      switch (paramInt)
      {
      case 1:
      case 3:
      default:
        return;
        this.t = false;
        break label32;
        g();
      case 2:
      case 4:
      }
    this.t = true;
    return;
    f();
  }

  public void onPositionDiscontinuity(int paramInt)
  {
  }

  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.d != null))
      this.d.a(paramInt * this.d.s() / 100L);
  }

  public void onRenderedFirstFrame()
  {
  }

  public void onRepeatModeChanged(int paramInt)
  {
  }

  public void onSeekProcessed()
  {
  }

  public void onShuffleModeEnabledChanged(boolean paramBoolean)
  {
  }

  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
  }

  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
  }

  public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
  {
  }

  public void onTimelineChanged(ak paramak, Object paramObject, int paramInt)
  {
  }

  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.g paramg)
  {
  }

  public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
  }

  public void p()
  {
    this.k.removeCallbacks(this.u);
  }

  public boolean q()
  {
    return (this.i == d.c) || (this.i == d.e) || (this.i == d.b) || (this.i == d.d);
  }

  public void r()
  {
    b(d.h);
  }

  public long s()
  {
    if (this.d != null)
      this.m = this.d.t();
    return this.m;
  }

  public void t()
  {
    this.r.b();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[10];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
    }
  }

  private class b
    implements Runnable
  {
    private b()
    {
    }

    public void run()
    {
      if ((e.b(e.this) != null) || (e.c(e.this) != null));
      for (boolean bool = true; ; bool = false)
      {
        e.this.a(bool);
        e.this.a(bool, false);
        if ((e.d(e.this) == null) || (!e.d(e.this).equals(e.b(e.this))) || (e.e(e.this) == e.d.f) || (dk.f(e.d(e.this))))
          break;
        e.a(e.this, e.e(e.this));
        return;
      }
      e.a(e.this, e.b(e.this));
      while (true)
      {
        try
        {
          if (e.d(e.this) != null)
            break label254;
          if ((!e.f(e.this).equals(e.a.d)) && (!e.f(e.this).equals(e.a.b)) && (!e.f(e.this).equals(e.a.c)))
            e.a(e.this, e.a.a);
          e.b(e.this, e.d(e.this));
          return;
        }
        catch (Exception localException)
        {
          e.b(e.this, e.d.f);
        }
        if (e.g(e.this) == null)
          break;
        e.g(e.this).a(e.h(e.this));
        return;
        label254: if ((dk.f(e.d(e.this))) || (at.d(ViberApplication.getApplication(), e.d(e.this).toString())))
        {
          e.a(e.this, e.a.g);
          e.a(e.this, e.d.a);
        }
        else if (!bj.a(e.d(e.this)))
        {
          e.a(e.this, e.d.f);
          e.a(e.this, e.a.j);
          if (e.g(e.this) != null)
            e.g(e.this).f();
          e.a(e.this, null);
        }
      }
    }
  }

  private class c
    implements Runnable
  {
    private c()
    {
    }

    public int a(long paramLong1, long paramLong2)
    {
      long l1 = (int)(paramLong1 / 1000L);
      long l2 = (int)(paramLong2 / 1000L);
      return Double.valueOf(100.0D * (l1 / l2)).intValue();
    }

    public void run()
    {
      if (e.i(e.this) == null)
        return;
      long l1 = e.i(e.this).t();
      if ((e.j(e.this) == l1) && (e.e(e.this) != e.d.a) && (e.e(e.this) != e.d.b))
        e.a(e.this, e.d.a);
      while (true)
      {
        e.a(e.this, l1);
        if (e.a.f != e.f(e.this))
          break;
        long l2 = e.i(e.this).s();
        int i = a(e.j(e.this), l2);
        e.k(e.this).setProgress(i);
        e.k(e.this).postDelayed(this, 1000L);
        e.l(e.this).setText(ae.h(e.j(e.this)));
        if (e.g(e.this) == null)
          break;
        e.g(e.this).a(l2, e.j(e.this));
        return;
        if ((e.j(e.this) != l1) && (e.e(e.this) != e.d.b))
        {
          e.a(e.this, e.d.b);
          if (e.g(e.this) != null)
            e.g(e.this).d();
        }
      }
    }
  }

  public static enum d
  {
    static
    {
      d[] arrayOfd = new d[8];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
      arrayOfd[2] = c;
      arrayOfd[3] = d;
      arrayOfd[4] = e;
      arrayOfd[5] = f;
      arrayOfd[6] = g;
      arrayOfd[7] = h;
    }
  }

  public static abstract interface e
  {
    public abstract void a();

    public abstract void a(long paramLong1, long paramLong2);

    public abstract void a(String paramString);

    public abstract void a(boolean paramBoolean);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.e
 * JD-Core Version:    0.6.2
 */