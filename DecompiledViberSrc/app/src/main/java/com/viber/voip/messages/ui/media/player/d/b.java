package com.viber.voip.messages.ui.media.player.d;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.viber.voip.R.id;
import com.viber.voip.R.style;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.ui.b.a.b;
import com.viber.voip.messages.ui.media.player.MediaPlayer;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayer.a;
import com.viber.voip.messages.ui.media.player.MediaPlayer.b;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.util.ch;

public final class b extends FrameLayout
  implements MediaPlayer
{
  e.e c = e.e.b;
  com.viber.voip.messages.ui.media.player.c.b d;
  private MediaPlayer.a e = MediaPlayer.a;
  private com.viber.voip.messages.ui.media.player.b.b.a<? extends com.viber.voip.messages.ui.media.player.c.b> f;
  private com.viber.voip.messages.ui.media.player.b.a.a<? extends com.viber.voip.messages.ui.media.player.a.a> g;
  private MediaPlayer h = MediaPlayer.b;
  private com.viber.voip.messages.ui.media.player.a.a i;
  private MediaPlayerControls j = MediaPlayerControls.b;
  private final com.viber.voip.messages.ui.b.a k = new com.viber.voip.messages.ui.b.a(this, new a(null));
  private g l;
  private MediaPlayer.b m = MediaPlayer.b.a;
  private final com.viber.voip.messages.ui.media.player.b n = new com.viber.voip.messages.ui.media.player.b()
  {
    public void a()
    {
      super.a();
      b.a(b.this).a();
    }

    public void c()
    {
      super.c();
      b.this.c.a();
    }

    public void d()
    {
      super.d();
      if (b.this.c.b())
        b.b(b.this).setControlsEnabled(false);
    }

    public void f()
    {
      super.f();
      b.this.c.d();
    }

    public void g()
    {
      super.g();
      b.this.c.e();
    }

    public void h()
    {
      b.this.c.f();
    }
  };
  private final com.viber.voip.messages.ui.media.player.a o = new com.viber.voip.messages.ui.media.player.a()
  {
    public void a(MediaPlayer paramAnonymousMediaPlayer)
    {
      super.a(paramAnonymousMediaPlayer);
      b.c(b.this).a(paramAnonymousMediaPlayer);
    }

    public void a(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      super.a(paramAnonymousMediaPlayer, paramAnonymousInt);
      b.c(b.this).a(paramAnonymousMediaPlayer, paramAnonymousInt);
    }

    public void a(MediaPlayer paramAnonymousMediaPlayer, long paramAnonymousLong1, long paramAnonymousLong2)
    {
      super.a(paramAnonymousMediaPlayer, paramAnonymousLong1, paramAnonymousLong2);
      b.c(b.this).a(paramAnonymousMediaPlayer, paramAnonymousLong1, paramAnonymousLong2);
    }

    public void b(MediaPlayer paramAnonymousMediaPlayer)
    {
      super.b(paramAnonymousMediaPlayer);
      b.c(b.this).b(paramAnonymousMediaPlayer);
    }

    public void b(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      super.b(paramAnonymousMediaPlayer, paramAnonymousInt);
      b.c(b.this).b(paramAnonymousMediaPlayer, paramAnonymousInt);
    }

    public void c(MediaPlayer paramAnonymousMediaPlayer)
    {
      b.c(b.this).c(paramAnonymousMediaPlayer);
    }
  };

  public b(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, R.style.Theme_Viber_Black_MediaPlayer));
  }

  private void e()
  {
    if (this.h.c())
    {
      this.j.b();
      return;
    }
    this.j.a();
  }

  private void f()
  {
    ch.a(this.j, this.h.getDurationMillis(), this.h.getCurrentPositionMillis());
  }

  private void g()
  {
    e();
    f();
  }

  private void h()
  {
    if (this.d != null)
    {
      removeView(this.d);
      this.d = null;
    }
    if (this.f != null)
    {
      this.d = ((com.viber.voip.messages.ui.media.player.c.b)this.f.a(getContext()));
      this.d.setId(R.id.window_minimized_player);
      addView(this.d, 0, new ViewGroup.LayoutParams(-2, -2));
    }
    if (this.d != null);
    for (Object localObject = this.d; ; localObject = MediaPlayer.b)
    {
      this.h = ((MediaPlayer)localObject);
      this.h.setCallbacks(this.o);
      this.n.a(this.h);
      g();
      return;
    }
  }

  private void i()
  {
    if (this.i != null)
    {
      removeView(this.i);
      this.i = null;
    }
    if (this.g != null)
    {
      this.i = ((com.viber.voip.messages.ui.media.player.a.a)this.g.a(getContext()));
      addView(this.i, new FrameLayout.LayoutParams(-1, -1));
    }
    if (this.i != null);
    for (Object localObject = this.i; ; localObject = MediaPlayerControls.b)
    {
      this.j = ((MediaPlayerControls)localObject);
      this.j.c();
      this.j.setCallbacks(this.n);
      this.o.a(this.j);
      g();
      return;
    }
  }

  public void a()
  {
    this.h.a();
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (this.d != null)
      this.d.a(paramInt1, paramInt2);
    if (this.i != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.i.getLayoutParams();
      if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
      {
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
        this.i.setLayoutParams(localLayoutParams);
      }
    }
  }

  public void a(long paramLong)
  {
    this.h.a(paramLong);
  }

  public void a(boolean paramBoolean)
  {
    this.m.a(paramBoolean);
  }

  public void b()
  {
    this.h.b();
  }

  public boolean c()
  {
    return this.h.c();
  }

  public boolean d()
  {
    return this.h.d();
  }

  public String getActionReplyData()
  {
    return this.h.getActionReplyData();
  }

  public MediaPlayerControls.VisualSpec getCurrentControlsVisualSpec()
  {
    return this.j.getCurrentVisualSpec();
  }

  public long getCurrentPositionMillis()
  {
    return this.h.getCurrentPositionMillis();
  }

  public MediaPlayer.VisualSpec getCurrentVisualSpec()
  {
    return this.h.getCurrentVisualSpec();
  }

  public long getDurationMillis()
  {
    return this.h.getDurationMillis();
  }

  com.viber.voip.messages.ui.media.player.a.a getPlayerControlsView()
  {
    return this.i;
  }

  public int getPlayerType()
  {
    return this.h.getPlayerType();
  }

  com.viber.voip.messages.ui.media.player.c.b getPlayerView()
  {
    return this.d;
  }

  public String getSourceUrl()
  {
    return this.h.getSourceUrl();
  }

  public int getThumbnailResource()
  {
    return this.h.getThumbnailResource();
  }

  public ImageView.ScaleType getThumbnailScaleType()
  {
    return this.h.getThumbnailScaleType();
  }

  public String getThumbnailUrl()
  {
    return this.h.getThumbnailUrl();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    e.e locale = this.c;
    if (paramConfiguration.orientation == 2);
    for (boolean bool = true; ; bool = false)
    {
      locale.a(bool);
      return;
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.k.a(paramMotionEvent);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.k.a(paramMotionEvent);
    return true;
  }

  public void setActionReplyData(String paramString)
  {
    this.h.setActionReplyData(paramString);
  }

  public void setAnalyticsManager(g paramg)
  {
    this.l = paramg;
  }

  public void setCallbacks(MediaPlayer.a parama)
  {
    if (parama != null);
    while (true)
    {
      this.e = parama;
      return;
      parama = MediaPlayer.a;
    }
  }

  public void setControlsVisualSpec(MediaPlayerControls.VisualSpec paramVisualSpec)
  {
    this.j.setVisualSpec(paramVisualSpec);
  }

  public void setHasVisualContent(boolean paramBoolean)
  {
    this.h.setHasVisualContent(paramBoolean);
  }

  public void setLogoLayoutId(int paramInt)
  {
    this.h.setLogoLayoutId(paramInt);
  }

  public void setLoop(boolean paramBoolean)
  {
    this.h.setLoop(paramBoolean);
  }

  public void setPlayerBackgroundBehaviour(MediaPlayer.b paramb)
  {
    if (paramb != null);
    while (true)
    {
      this.m = paramb;
      return;
      paramb = MediaPlayer.b.a;
    }
  }

  public void setPlayerControlsViewCreator(com.viber.voip.messages.ui.media.player.b.a.a<? extends com.viber.voip.messages.ui.media.player.a.a> parama)
  {
    this.g = parama;
    i();
  }

  public void setPlayerViewCreator(com.viber.voip.messages.ui.media.player.b.b.a<? extends com.viber.voip.messages.ui.media.player.c.b> parama)
  {
    this.f = parama;
    h();
  }

  public void setPlayerWindowManagerCallbacks(e.e parame)
  {
    this.c = parame;
  }

  public void setSourceUrl(String paramString)
  {
    this.h.setSourceUrl(paramString);
  }

  public void setThumbnailResource(int paramInt)
  {
    this.h.setThumbnailResource(paramInt);
  }

  public void setThumbnailScaleType(ImageView.ScaleType paramScaleType)
  {
    this.h.setThumbnailScaleType(paramScaleType);
  }

  public void setThumbnailUrl(String paramString)
  {
    this.h.setThumbnailUrl(paramString);
  }

  public void setVisualSpec(MediaPlayer.VisualSpec paramVisualSpec)
  {
    this.h.setVisualSpec(paramVisualSpec);
  }

  private class a
    implements a.b
  {
    private boolean b;

    private a()
    {
    }

    public boolean onDrag(int paramInt1, int paramInt2)
    {
      return b.this.c.a(paramInt1, paramInt2);
    }

    public void onGesturesComplete()
    {
      if (this.b)
        this.b = false;
      b.this.c.c();
    }

    public boolean onScale(float paramFloat, int paramInt1, int paramInt2)
    {
      this.b = true;
      return b.this.c.a(paramFloat, paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.b
 * JD-Core Version:    0.6.2
 */