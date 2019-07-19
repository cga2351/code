package com.viber.voip.messages.ui.media.player;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.viber.common.dialogs.l.a;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.voip.R.fraction;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.a.f.a;
import com.viber.voip.messages.a.f.a.a;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage.a;
import com.viber.voip.messages.controller.manager.f;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ui.banner.AlertView;
import com.viber.voip.messages.conversation.ui.banner.AlertView.b;
import com.viber.voip.messages.conversation.ui.banner.o;
import com.viber.voip.messages.conversation.ui.banner.o.b;
import com.viber.voip.messages.conversation.ui.bd;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.PositioningAwareFrameLayout;
import com.viber.voip.messages.ui.cd.a;
import com.viber.voip.messages.ui.media.player.d.e.b;
import com.viber.voip.messages.ui.media.player.d.e.c;
import com.viber.voip.ui.an;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.aj;
import com.viber.voip.util.ViberActionRunner.w;
import com.viber.voip.util.ch;
import com.viber.voip.util.dj;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class FullScreenVideoPlayerActivity extends ViberFragmentActivity
  implements AlertView.b, o.b, e.c
{
  private static final com.viber.common.a.e e = ViberEnv.getLogger();
  boolean a;

  @Inject
  dagger.a<com.viber.voip.messages.extensions.c> b;

  @Inject
  dagger.a<com.viber.voip.analytics.story.e.c> c;

  @Inject
  ScheduledExecutorService d;
  private g f;
  private Handler g;
  private PositioningAwareFrameLayout h;
  private int i;
  private int j;
  private com.viber.voip.messages.ui.media.player.c.b k;
  private com.viber.voip.messages.ui.media.player.a.a l;
  private an m;
  private VideoPlayerScreenSpec n;
  private BotReplyRequest o;
  private float p;
  private int q = 0;
  private c r;
  private bd s;
  private f t;
  private b u;
  private a v = new a()
  {
    public void a(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) || (1 == paramAnonymousInt))
        ch.a(FullScreenVideoPlayerActivity.f(FullScreenVideoPlayerActivity.this), FullScreenVideoPlayerActivity.c(FullScreenVideoPlayerActivity.this).getDurationMillis(), FullScreenVideoPlayerActivity.c(FullScreenVideoPlayerActivity.this).getCurrentPositionMillis());
      super.a(paramAnonymousMediaPlayer, paramAnonymousInt);
    }

    public void b(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      super.b(paramAnonymousMediaPlayer, paramAnonymousInt);
      if ((1 == paramAnonymousInt) && (ViberActionRunner.a(FullScreenVideoPlayerActivity.this.getApplicationContext(), paramAnonymousMediaPlayer.getSourceUrl())))
        FullScreenVideoPlayerActivity.this.finish();
    }

    public void c(MediaPlayer paramAnonymousMediaPlayer)
    {
      if (ViberActionRunner.aj.a(FullScreenVideoPlayerActivity.this.getApplicationContext(), paramAnonymousMediaPlayer))
        FullScreenVideoPlayerActivity.this.finish();
    }
  };
  private final b w = new b()
  {
    public void c()
    {
      super.c();
      FullScreenVideoPlayerActivity.this.a = true;
      FullScreenVideoPlayerActivity.this.finish();
    }

    public void e()
    {
      super.e();
      FullScreenVideoPlayerActivity.this.a(new FullScreenVideoPlayerActivity.a(FullScreenVideoPlayerActivity.g(FullScreenVideoPlayerActivity.this)));
    }

    public void f()
    {
      super.f();
      FullScreenVideoPlayerActivity.this.d();
    }

    public void g()
    {
    }

    public void h()
    {
      if (ViberActionRunner.aj.b(FullScreenVideoPlayerActivity.this.getApplicationContext(), FullScreenVideoPlayerActivity.c(FullScreenVideoPlayerActivity.this)))
        FullScreenVideoPlayerActivity.this.finish();
    }
  };

  private int a(int paramInt)
  {
    return (int)(paramInt * this.p);
  }

  private VideoPlayerScreenSpec a(Bundle paramBundle, String paramString)
  {
    if (paramBundle != null)
      return (VideoPlayerScreenSpec)paramBundle.getParcelable(paramString);
    return null;
  }

  private int b(int paramInt)
  {
    return (int)(paramInt / this.p);
  }

  private BotReplyRequest b(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
      return null;
    return (BotReplyRequest)paramBundle.getParcelable(paramString);
  }

  private void e()
  {
    if (this.k == null);
    label103: label110: 
    while (true)
    {
      return;
      int i1 = this.i;
      int i2 = this.j;
      int i3 = this.h.getWidth();
      int i4 = this.h.getHeight();
      int i5;
      int i6;
      if ((i3 > 0) && (i4 > 0) && (i3 > i4))
      {
        i5 = 1;
        if ((this.k.q()) || (i5 == 0))
          break label103;
        i6 = i4;
      }
      for (int i7 = i3; ; i7 = i1)
      {
        if ((i7 <= 0) || (i6 <= 0))
          break label110;
        this.k.a(i7, i6);
        return;
        i5 = 0;
        break;
        i6 = i2;
      }
    }
  }

  private void f()
  {
    if (this.k != null);
    switch (this.q)
    {
    default:
      return;
    case 1:
      this.k.a();
      return;
    case 2:
    }
    this.k.b();
  }

  private void g()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.h.addView(this.k, 0, localLayoutParams);
    e();
    this.w.a(this.k);
    this.k.setCallbacks(this.v);
    f();
    this.l.setControlsEnabled(true);
    ch.a(this.l, this.k.getDurationMillis(), this.k.getCurrentPositionMillis());
    if (this.k.c())
      this.l.b();
    while (true)
    {
      dj.b(this.l, true);
      k();
      return;
      this.l.a();
    }
  }

  private void h()
  {
    if ((this.i > 0) && (this.j > 0))
      g();
  }

  private void i()
  {
    ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper(getApplicationContext(), R.style.Theme_Viber_Black_MediaPlayer);
    this.l = new com.viber.voip.messages.ui.media.player.b.a.c(this.f).b(localContextThemeWrapper);
    j();
    dj.b(this.l, false);
    if (1 == this.n.visualSpec.getPlayerType());
    for (this.k = new com.viber.voip.messages.ui.media.player.b.b.d().b(localContextThemeWrapper); ; this.k = new com.viber.voip.messages.ui.media.player.b.b.b().b(localContextThemeWrapper))
    {
      this.k.setVisualSpec(this.n.visualSpec);
      h();
      return;
    }
  }

  private void j()
  {
    this.l.d();
    this.l.setVisualSpec(this.n.controlsVisualSpec);
    this.v.a(this.l);
    this.l.setCallbacks(this.w);
    int i1 = dj.a(this.h, R.id.bottom_alert_banner);
    if (i1 >= 0)
    {
      this.h.addView(this.l, i1, new FrameLayout.LayoutParams(-1, -1));
      return;
    }
    this.h.addView(this.l, new FrameLayout.LayoutParams(-1, -1));
  }

  private void k()
  {
    if (isFinishing());
    String str;
    MediaPlayerControls.VisualSpec localVisualSpec;
    do
    {
      do
        return;
      while ((this.k == null) || (this.l == null));
      str = this.k.getCurrentVisualSpec().getSourceUrl();
      localVisualSpec = this.l.getCurrentVisualSpec();
    }
    while (localVisualSpec.getFavoriteOptionVisualState() == 0);
    com.viber.voip.messages.ui.media.player.a.a locala = this.l;
    MediaPlayerControls.VisualSpec.a locala1 = localVisualSpec.buildUpon();
    if (this.t.b(str));
    for (int i1 = 2; ; i1 = 1)
    {
      locala.setVisualSpec(locala1.a(i1).a());
      return;
    }
  }

  public AlertView M_()
  {
    return (AlertView)dj.e(getWindow().getDecorView().getRootView(), R.id.bottom_alert_banner);
  }

  void a(final int paramInt1, final int paramInt2)
  {
    this.g.post(new Runnable()
    {
      public void run()
      {
        FullScreenVideoPlayerActivity.a(FullScreenVideoPlayerActivity.this, paramInt1);
        FullScreenVideoPlayerActivity.b(FullScreenVideoPlayerActivity.this, FullScreenVideoPlayerActivity.c(FullScreenVideoPlayerActivity.this, FullScreenVideoPlayerActivity.a(FullScreenVideoPlayerActivity.this)));
        if (FullScreenVideoPlayerActivity.b(FullScreenVideoPlayerActivity.this) > paramInt2)
        {
          FullScreenVideoPlayerActivity.b(FullScreenVideoPlayerActivity.this, paramInt2);
          FullScreenVideoPlayerActivity.a(FullScreenVideoPlayerActivity.this, FullScreenVideoPlayerActivity.d(FullScreenVideoPlayerActivity.this, FullScreenVideoPlayerActivity.b(FullScreenVideoPlayerActivity.this)));
        }
        if (FullScreenVideoPlayerActivity.c(FullScreenVideoPlayerActivity.this) != null)
        {
          if (FullScreenVideoPlayerActivity.c(FullScreenVideoPlayerActivity.this).getParent() == null)
            FullScreenVideoPlayerActivity.d(FullScreenVideoPlayerActivity.this);
        }
        else
          return;
        FullScreenVideoPlayerActivity.e(FullScreenVideoPlayerActivity.this);
      }
    });
  }

  public boolean a(com.viber.voip.messages.ui.media.player.c.b paramb, com.viber.voip.messages.ui.media.player.a.a parama)
  {
    if (isFinishing())
      return false;
    this.k = paramb;
    this.l = parama;
    j();
    h();
    return true;
  }

  boolean a(e.b paramb)
  {
    if (!dj.f(getApplicationContext()))
      return false;
    com.viber.voip.messages.ui.media.player.c.b localb = this.k;
    localb.setTemporaryDetaching(true);
    localb.setCallbacks(null);
    this.h.removeView(localb);
    com.viber.voip.messages.ui.media.player.a.a locala = this.l;
    locala.setCallbacks(null);
    this.h.removeView(locala);
    ViberApplication.getInstance().getPlayerWindowManager().a(this.o);
    ViberApplication.getInstance().getPlayerWindowManager().a(this.n.visualSpec, this.n.controlsVisualSpec, new com.viber.voip.messages.ui.media.player.b.b.c(localb), new com.viber.voip.messages.ui.media.player.b.a.b(locala), this.n.minimizedWindowRect, paramb);
    this.a = false;
    finish();
    return true;
  }

  public void b()
  {
    if (isFinishing())
      return;
    i();
  }

  public void c()
  {
    if (!a(null))
      finish();
  }

  void d()
  {
    if ((this.k == null) || (this.l == null));
    MediaPlayer.VisualSpec localVisualSpec;
    MediaPlayerControls.VisualSpec localVisualSpec1;
    String str1;
    do
    {
      return;
      localVisualSpec = this.k.getCurrentVisualSpec();
      localVisualSpec1 = this.l.getCurrentVisualSpec();
      str1 = localVisualSpec.getSourceUrl();
    }
    while (this.t.b(str1));
    String str2 = this.t.a(str1);
    BotFavoriteLinksCommunicator.SaveLinkActionMessage.a locala = BotFavoriteLinksCommunicator.SaveLinkActionMessage.builder().a(str1).c(localVisualSpec.getThumbnailUrl()).b(localVisualSpec1.getTitle()).e(((com.viber.voip.messages.extensions.c)this.b.get()).e()).g("video").h("Media Player").a(16);
    if (1 == localVisualSpec.getPlayerType());
    for (boolean bool = true; ; bool = false)
    {
      BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = locala.c(bool).f(str2).b();
      k();
      ViberApplication.getInstance().getMessagesManager().t().a().a(localSaveLinkActionMessage);
      this.d.execute(new d(this, localSaveLinkActionMessage));
      return;
    }
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.m.b();
  }

  public void onBackPressed()
  {
    this.a = true;
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    this.t = ViberApplication.getInstance().getPlayerWindowManager().c();
    this.u = new b(this, 24);
    com.viber.voip.h.a.b().register(this.u);
    this.f = g.a();
    Bundle localBundle;
    if (paramBundle == null)
    {
      localBundle = getIntent().getExtras();
      this.n = a(localBundle, "video_player_spec");
    }
    for (this.o = b(localBundle, "bot_reply_request"); this.n == null; this.o = b(paramBundle, "bot_reply_request"))
    {
      finish();
      return;
      this.n = a(paramBundle, "video_player_spec");
      this.q = paramBundle.getInt("play_state_on_screen_resume", 0);
    }
    setContentView(R.layout.activity_full_screen_player);
    this.g = av.a(av.e.a);
    this.p = getResources().getFraction(R.fraction.player_minimized_height_ratio, 1, 1);
    this.h = ((PositioningAwareFrameLayout)findViewById(R.id.root_container));
    this.h.setPositioningListener(new cd.a()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        FullScreenVideoPlayerActivity.this.a(paramAnonymousInt1, paramAnonymousInt2);
      }
    });
    if (paramBundle == null)
      ViberApplication.getInstance().getPlayerWindowManager().a(this);
    while (true)
    {
      this.m = new an(this);
      this.m.a();
      Engine localEngine = ViberApplication.getInstance().getEngine(false);
      this.r = new c(localEngine, localEngine.getDelegatesManager().getDialerPhoneStateListener(), new c.a()
      {
        public void a()
        {
          FullScreenVideoPlayerActivity.this.a = true;
          FullScreenVideoPlayerActivity.this.finish();
        }
      });
      this.s = new bd(this, this, av.e.a.a(), com.viber.voip.h.a.b(), 16, o.a, getLayoutInflater());
      this.s.a(this);
      return;
      i();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    com.viber.voip.h.a.b().unregister(this.u);
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.m.c();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    VideoPlayerScreenSpec localVideoPlayerScreenSpec = a(paramIntent.getExtras(), "video_player_spec");
    if (localVideoPlayerScreenSpec != null)
    {
      this.k.setVisualSpec(localVideoPlayerScreenSpec.visualSpec);
      this.l.setVisualSpec(localVideoPlayerScreenSpec.controlsVisualSpec);
      this.n.set(localVideoPlayerScreenSpec);
      e();
    }
    this.o = b(paramIntent.getExtras(), "bot_reply_request");
  }

  protected void onPause()
  {
    if (this.k != null)
      if (!this.k.c())
        break label50;
    label50: for (int i1 = 1; ; i1 = 2)
    {
      this.q = i1;
      if (!isFinishing())
        this.k.b();
      this.r.b();
      super.onPause();
      return;
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.m.d();
    f();
    this.r.a();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("video_player_spec", this.n);
    paramBundle.putInt("play_state_on_screen_resume", this.q);
    paramBundle.putParcelable("bot_reply_request", this.o);
  }

  protected void onStart()
  {
    super.onStart();
    this.s.a();
  }

  protected void onStop()
  {
    super.onStop();
    this.s.b();
    if (this.a)
      this.t.a();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.m.a(paramBoolean);
  }

  private static class a
    implements e.b
  {
    private final VideoPlayerScreenSpec a;

    public a(VideoPlayerScreenSpec paramVideoPlayerScreenSpec)
    {
      this.a = paramVideoPlayerScreenSpec;
    }

    public void a()
    {
      ViberActionRunner.w.b(ViberApplication.getApplication(), this.a.visualSpec, this.a.controlsVisualSpec, this.a.minimizedWindowRect);
      com.viber.voip.ui.dialogs.a.l().d();
    }
  }

  private static final class b extends f.a.a<FullScreenVideoPlayerActivity>
  {
    public b(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity, int paramInt)
    {
      super(paramInt);
    }

    protected void a(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity, f.a parama)
    {
      if ((FullScreenVideoPlayerActivity.h(paramFullScreenVideoPlayerActivity).a(parama.a, parama.c)) && (!paramFullScreenVideoPlayerActivity.isFinishing()))
        FullScreenVideoPlayerActivity.i(paramFullScreenVideoPlayerActivity);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.FullScreenVideoPlayerActivity
 * JD-Core Version:    0.6.2
 */