package com.viber.voip.messages.ui.media.player.d;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.voip.R.color;
import com.viber.voip.R.fraction;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.f;
import com.viber.voip.messages.a.f.a;
import com.viber.voip.messages.a.f.a.a;
import com.viber.voip.messages.a.i.a;
import com.viber.voip.messages.a.i.b;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage.a;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.ui.media.player.MediaPlayer;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayer.a;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec.a;
import com.viber.voip.messages.ui.media.player.c.a;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.aj;
import com.viber.voip.util.ViberActionRunner.w;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import com.viber.voip.util.dd;
import com.viber.voip.util.dj;
import java.util.concurrent.ScheduledExecutorService;
import org.greenrobot.eventbus.EventBus;

public final class e
{
  private static final com.viber.common.a.e b = ViberEnv.getLogger();
  m a;
  private final Context c;
  private final Resources d;
  private final WindowManager e;
  private final com.viber.voip.analytics.g f;
  private final dagger.a<com.viber.voip.analytics.story.e.c> g;
  private final Handler h;
  private b i;
  private e j;
  private a k;
  private MediaPlayer.a l;
  private com.viber.voip.messages.ui.media.player.c m;
  private final c n;
  private final k o;
  private final Point p = new Point();
  private final com.viber.voip.messages.k q;
  private final com.viber.voip.messages.extensions.c r;
  private final com.viber.voip.messages.controller.manager.c s;
  private final com.viber.voip.messages.controller.manager.f t;
  private d u;
  private f v;
  private final EventBus w;
  private BotReplyRequest x;

  @SuppressLint({"RestrictedApi"})
  public e(Application paramApplication, Engine paramEngine, com.viber.voip.util.d paramd, com.viber.voip.analytics.g paramg, Handler paramHandler, com.viber.voip.messages.k paramk, EventBus paramEventBus, com.viber.voip.messages.extensions.c paramc, dagger.a<com.viber.voip.analytics.story.e.c> parama)
  {
    this.c = new android.support.v7.view.d(paramApplication, ((com.viber.voip.ui.j.av)ViberApplication.getInstance().getThemeController().get()).a(R.style.Theme_Viber));
    this.f = paramg;
    this.g = parama;
    this.q = paramk;
    this.r = paramc;
    this.s = this.q.t();
    this.t = new com.viber.voip.messages.controller.manager.f(1);
    this.u = new d(this, 24);
    this.v = new f(this, 5, ViberApplication.isTablet(this.c));
    this.w = paramEventBus;
    this.h = paramHandler;
    this.d = this.c.getResources();
    this.e = ((WindowManager)this.c.getSystemService("window"));
    this.m = new com.viber.voip.messages.ui.media.player.c(paramEngine, paramEngine.getDelegatesManager().getDialerPhoneStateListener(), r());
    this.n = new c(paramApplication, paramd, paramHandler, p());
    this.o = new k(paramApplication, s());
  }

  private void a(WindowManager.LayoutParams paramLayoutParams)
  {
    if ((this.i != null) && (this.a != null))
      a(this.i, paramLayoutParams, this.a.b(), this.a.c());
  }

  private void a(b paramb, int paramInt1, int paramInt2)
  {
    a(paramb, (WindowManager.LayoutParams)paramb.getLayoutParams(), paramInt1, paramInt2);
    if ((this.a != null) && (!f()))
      paramb.setAlpha(1.0F - this.a.h());
  }

  private void a(b paramb, int paramInt1, int paramInt2, float paramFloat)
  {
    paramb.a(paramInt1, paramInt2);
    paramb.setControlsVisualSpec(paramb.getCurrentControlsVisualSpec().buildUpon().a(paramFloat).a());
  }

  private void a(b paramb, WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    paramLayoutParams.width = -2;
    paramLayoutParams.height = -2;
    paramLayoutParams.x = paramInt1;
    paramLayoutParams.y = paramInt2;
    this.e.updateViewLayout(paramb, paramLayoutParams);
  }

  private void a(b paramb, MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1, Rect paramRect, b paramb1)
  {
    this.a = n();
    int i1;
    if (paramb.getParent() != null)
      i1 = 1;
    while (true)
    {
      Rect localRect;
      if (i1 == 0)
      {
        localRect = new Rect();
        if (paramRect != null)
          break label160;
        localRect.set(this.a.a());
        this.a.a(localRect);
      }
      try
      {
        WindowManager.LayoutParams localLayoutParams = k();
        this.e.addView(paramb, localLayoutParams);
        a(localLayoutParams);
        this.m.a();
        this.n.a();
        this.o.a();
        a(paramb, this.a.d(), this.a.e(), this.a.f());
        paramb.setVisualSpec(paramVisualSpec);
        paramb.setControlsVisualSpec(paramVisualSpec1);
        o();
        return;
        i1 = 0;
        continue;
        label160: localRect.set(paramRect);
      }
      catch (SecurityException localSecurityException)
      {
        do
        {
          com.viber.voip.messages.ui.media.player.c.b localb = paramb.getPlayerView();
          if (localb != null)
            localb.p();
          this.i = null;
          this.a = null;
        }
        while (paramb1 == null);
        paramb1.a();
      }
    }
  }

  private void a(b paramb, com.viber.voip.messages.ui.media.player.b.b.a<? extends com.viber.voip.messages.ui.media.player.c.b> parama, com.viber.voip.messages.ui.media.player.b.a.a<? extends com.viber.voip.messages.ui.media.player.a.a> parama1)
  {
    paramb.setBackgroundResource(R.color.solid);
    paramb.setPlayerViewCreator(parama);
    paramb.setPlayerControlsViewCreator(parama1);
  }

  private void a(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.e.removeView(this.i);
      this.i = null;
      this.m.b();
      this.n.b();
      this.o.b();
    }
    if (this.a != null)
    {
      this.a.i();
      this.a = null;
    }
    if (!paramBoolean)
    {
      this.t.a();
      this.x = null;
    }
    this.w.unregister(this.u);
    this.w.unregister(this.v);
  }

  @SuppressLint({"RtlHardcoded"})
  private WindowManager.LayoutParams k()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    if (com.viber.common.d.a.m());
    for (int i1 = 2038; ; i1 = 2003)
    {
      localLayoutParams.type = i1;
      localLayoutParams.flags = 17039912;
      localLayoutParams.format = -3;
      localLayoutParams.gravity = 51;
      return localLayoutParams;
    }
  }

  private b l()
  {
    if (this.i == null)
    {
      this.i = new b(this.c);
      this.i.setPlayerWindowManagerCallbacks(p());
      this.i.setCallbacks(m());
      this.i.setAnalyticsManager(this.f);
      this.i.setPlayerBackgroundBehaviour(new a(this.c, this.i));
    }
    return this.i;
  }

  private MediaPlayer.a m()
  {
    if (this.l == null)
      this.l = new MediaPlayer.a()
      {
        public void a(MediaPlayer paramAnonymousMediaPlayer)
        {
        }

        public void a(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
        {
        }

        public void a(MediaPlayer paramAnonymousMediaPlayer, long paramAnonymousLong1, long paramAnonymousLong2)
        {
          if ((e.b(e.this) != null) && (e.b(e.this).getBackground() != null))
            dj.a(e.b(e.this), null);
        }

        public void b(MediaPlayer paramAnonymousMediaPlayer)
        {
        }

        public void b(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
        {
          if ((1 == paramAnonymousInt) && (ViberActionRunner.a(e.a(e.this), paramAnonymousMediaPlayer.getSourceUrl())))
            e.this.e();
        }

        public void c(MediaPlayer paramAnonymousMediaPlayer)
        {
          if (ViberActionRunner.aj.a(e.a(e.this), paramAnonymousMediaPlayer))
            e.this.e();
        }
      };
    return this.l;
  }

  private m n()
  {
    if (this.a == null)
      this.a = new h(this.c, ViberApplication.isTablet(this.c), dj.c(this.c), this.d.getFraction(R.fraction.player_minimized_height_ratio, 1, 1), g(), q());
    return this.a;
  }

  private void o()
  {
    if (this.i == null);
    String str;
    MediaPlayerControls.VisualSpec localVisualSpec;
    do
    {
      return;
      str = this.i.getCurrentVisualSpec().getSourceUrl();
      localVisualSpec = this.i.getCurrentControlsVisualSpec();
    }
    while (localVisualSpec.getFavoriteOptionVisualState() == 0);
    b localb = this.i;
    MediaPlayerControls.VisualSpec.a locala = localVisualSpec.buildUpon();
    if (this.t.b(str));
    for (int i1 = 2; ; i1 = 1)
    {
      localb.setControlsVisualSpec(locala.a(i1).a());
      return;
    }
  }

  private e p()
  {
    if (this.j == null)
      this.j = new e()
      {
        public void a()
        {
          e.this.e();
        }

        public void a(boolean paramAnonymousBoolean)
        {
          if (e.this.f())
            e.this.e();
          while (e.this.a == null)
            return;
          e.this.a.a(paramAnonymousBoolean);
        }

        public boolean a(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return (e.this.a == null) || (e.this.f()) || (e.this.a.a(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2));
        }

        public boolean a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return (e.this.a == null) || (e.this.f()) || (e.this.a.a(paramAnonymousInt1, paramAnonymousInt2));
        }

        public void b(boolean paramAnonymousBoolean)
        {
          if (e.b(e.this) != null)
            e.b(e.this).a(paramAnonymousBoolean);
        }

        public boolean b()
        {
          if (e.this.f());
          MediaPlayer.VisualSpec localVisualSpec;
          MediaPlayerControls.VisualSpec localVisualSpec1;
          do
          {
            do
              return false;
            while ((e.b(e.this) == null) || (e.this.a == null));
            localVisualSpec = e.b(e.this).getCurrentVisualSpec();
            localVisualSpec1 = e.b(e.this).getCurrentControlsVisualSpec();
          }
          while ((da.a(localVisualSpec.getSourceUrl())) || (-1 == localVisualSpec.getPlayerType()));
          ViberActionRunner.w.a(e.a(e.this), e.c(e.this), localVisualSpec, localVisualSpec1, e.this.h());
          return true;
        }

        public void c()
        {
          if (e.this.f());
          while (e.this.a == null)
            return;
          if (e.this.a.h() > 0.3F)
          {
            e.this.a.j();
            return;
          }
          e.this.a.g();
        }

        public void d()
        {
          e.this.i();
        }

        public void e()
        {
          e.this.j();
        }

        public void f()
        {
          if (ViberActionRunner.aj.b(e.a(e.this), e.b(e.this)))
            e.this.e();
        }
      };
    return this.j;
  }

  private a q()
  {
    if (this.k == null)
      this.k = new a()
      {
        public Point a()
        {
          return e.this.g();
        }

        public void a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          e.this.a(paramAnonymousInt1, paramAnonymousInt2);
        }

        public void a(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
        {
          e.this.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousFloat);
        }

        public void a(boolean paramAnonymousBoolean)
        {
          if (!paramAnonymousBoolean)
            e.this.e();
        }
      };
    return this.k;
  }

  private c.a r()
  {
    return new c.a()
    {
      public void a()
      {
        e.this.e();
      }
    };
  }

  private k.a s()
  {
    return new k.a()
    {
      public void a()
      {
        e.this.b();
      }
    };
  }

  public void a()
  {
    a(2);
  }

  public void a(int paramInt)
  {
    if ((this.i != null) && (this.a != null) && (!f()))
    {
      j localj = new j(this.h, this.i);
      this.a.a(localj, paramInt);
    }
  }

  void a(int paramInt1, int paramInt2)
  {
    if (this.i != null)
      a(this.i, paramInt1, paramInt2);
  }

  void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.i != null)
      a(this.i, paramInt1, paramInt2, paramFloat);
  }

  public void a(BotReplyRequest paramBotReplyRequest)
  {
    this.x = paramBotReplyRequest;
  }

  public void a(MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1, com.viber.voip.messages.ui.media.player.b.b.a<? extends com.viber.voip.messages.ui.media.player.c.b> parama, com.viber.voip.messages.ui.media.player.b.a.a<? extends com.viber.voip.messages.ui.media.player.a.a> parama1, Rect paramRect, b paramb)
  {
    if (f())
      return;
    if (!this.w.isRegistered(this.u))
      this.w.register(this.u);
    if (!this.w.isRegistered(this.v))
      this.w.register(this.v);
    b localb = l();
    a(localb, parama, parama1);
    a(localb, paramVisualSpec, paramVisualSpec1, paramRect, paramb);
  }

  public void a(MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1, b paramb)
  {
    switch (paramVisualSpec.getPlayerType())
    {
    default:
      return;
    case 0:
      a(paramVisualSpec, paramVisualSpec1, new com.viber.voip.messages.ui.media.player.b.b.b(), new com.viber.voip.messages.ui.media.player.b.a.c(this.f), null, paramb);
      return;
    case 1:
    }
    a(paramVisualSpec, paramVisualSpec1, new com.viber.voip.messages.ui.media.player.b.b.d(), new com.viber.voip.messages.ui.media.player.b.a.c(this.f), null, paramb);
  }

  public void a(c paramc)
  {
    com.viber.voip.messages.ui.media.player.c.b localb;
    com.viber.voip.messages.ui.media.player.a.a locala;
    if (this.i != null)
    {
      localb = this.i.getPlayerView();
      if (this.i == null)
        break label57;
      locala = this.i.getPlayerControlsView();
      label30: if ((localb != null) && (locala != null) && (!f()))
        break label62;
      paramc.b();
    }
    label57: label62: 
    do
    {
      return;
      localb = null;
      break;
      locala = null;
      break label30;
      b localb1 = this.i;
      localb.setTemporaryDetaching(true);
      a(true);
      localb.setCallbacks(null);
      localb1.removeView(localb);
      locala.setCallbacks(null);
      localb1.removeView(locala);
    }
    while (paramc.a(localb, locala));
    localb.p();
    this.t.a();
  }

  public void b()
  {
    if (dd.a())
    {
      d();
      return;
    }
    this.h.post(new f(this));
  }

  public com.viber.voip.messages.controller.manager.f c()
  {
    return this.t;
  }

  void d()
  {
    if (this.i != null)
      this.i.b();
  }

  public void e()
  {
    a(false);
  }

  boolean f()
  {
    return (this.a != null) && (this.a.k());
  }

  Point g()
  {
    this.e.getDefaultDisplay().getSize(this.p);
    Point localPoint = this.p;
    localPoint.y -= dj.m(this.c);
    return this.p;
  }

  Rect h()
  {
    if (this.a != null)
    {
      int i1 = this.a.b();
      int i2 = this.a.c();
      return new Rect(i1, i2, i1 + this.a.d(), i2 + this.a.e());
    }
    return null;
  }

  void i()
  {
    int i1 = 1;
    if (this.i == null);
    MediaPlayer.VisualSpec localVisualSpec;
    MediaPlayerControls.VisualSpec localVisualSpec1;
    String str1;
    do
    {
      return;
      localVisualSpec = this.i.getCurrentVisualSpec();
      localVisualSpec1 = this.i.getCurrentControlsVisualSpec();
      str1 = localVisualSpec.getSourceUrl();
    }
    while (this.t.b(str1));
    String str2 = this.t.a(str1);
    BotFavoriteLinksCommunicator.SaveLinkActionMessage.a locala = BotFavoriteLinksCommunicator.SaveLinkActionMessage.builder().a(str1).c(localVisualSpec.getThumbnailUrl()).b(localVisualSpec1.getTitle()).e(this.r.e()).g("video").a(8).h("Media Player");
    if (i1 == localVisualSpec.getPlayerType());
    while (true)
    {
      BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = locala.c(i1).f(str2).b();
      o();
      this.s.a().a(localSaveLinkActionMessage);
      av.f.d.execute(new g(this, localSaveLinkActionMessage));
      return;
      int i2 = 0;
    }
  }

  void j()
  {
    if (this.i == null);
    while (this.x == null)
      return;
    MediaPlayer.VisualSpec localVisualSpec = this.i.getCurrentVisualSpec();
    MediaPlayerControls.VisualSpec localVisualSpec1 = this.i.getCurrentControlsVisualSpec();
    new com.viber.voip.messages.controller.publicaccount.ag(this.w, this.q, this.x, this.r, localVisualSpec.getSourceUrl(), localVisualSpec1.getTitle(), localVisualSpec.getActionReplyData()).a(this.c);
  }

  public static abstract interface a
  {
    public abstract Point a();

    public abstract void a(int paramInt1, int paramInt2);

    public abstract void a(int paramInt1, int paramInt2, float paramFloat);

    public abstract void a(boolean paramBoolean);
  }

  public static abstract interface b
  {
    public abstract void a();
  }

  public static abstract interface c
  {
    public abstract boolean a(com.viber.voip.messages.ui.media.player.c.b paramb, com.viber.voip.messages.ui.media.player.a.a parama);

    public abstract void b();
  }

  private static final class d extends f.a.a<e>
  {
    public d(e parame, int paramInt)
    {
      super(paramInt);
    }

    protected void a(e parame, f.a parama)
    {
      if (e.d(parame).a(parama.a, parama.c))
        e.e(parame);
    }
  }

  public static abstract interface e extends l
  {
    public static final e b = (e)cl.b(e.class);

    public abstract void a();

    public abstract void b(boolean paramBoolean);

    @com.viber.voip.util.ag
    public abstract boolean b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();
  }

  private static final class f extends i.a<e>
  {
    private final boolean a;

    f(e parame, int paramInt, boolean paramBoolean)
    {
      super(paramInt);
      this.a = paramBoolean;
    }

    protected void a(e parame, i.b paramb)
    {
      if (this.a);
      do
      {
        return;
        if (com.viber.voip.util.av.d(paramb.a, 1))
        {
          parame.a(1);
          return;
        }
      }
      while (!com.viber.voip.util.av.d(paramb.a, 4));
      parame.a(2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.e
 * JD-Core Version:    0.6.2
 */