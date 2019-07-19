package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.Map;

public class VastVideoViewController extends BaseVideoViewController
{
  public static final int WEBVIEW_PADDING = 16;
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private int D;
  private boolean E = false;
  private final VastVideoConfig a;
  private final VastVideoView b;
  private ExternalViewabilitySessionManager c;
  private VastVideoGradientStripWidget d;
  private VastVideoGradientStripWidget e;
  private ImageView f;
  private VastVideoProgressBarWidget g;
  private VastVideoRadialCountdownWidget h;
  private VastVideoCtaButtonWidget i;
  private VastVideoCloseButtonWidget j;
  private VastCompanionAdConfig k;
  private final i l;
  private final View m;
  private final View n;
  private final Map<String, VastCompanionAdConfig> o;
  private View p;
  private final View q;
  private final View r;
  private final VastVideoViewProgressRunnable s;
  private final VastVideoViewCountdownRunnable t;
  private final View.OnTouchListener u;
  private int v = 5000;
  private boolean w;
  private int x = -1;
  private boolean y;
  private boolean z;

  VastVideoViewController(final Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2, long paramLong, BaseVideoViewController.BaseVideoViewControllerListener paramBaseVideoViewControllerListener)
    throws IllegalStateException
  {
    super(paramActivity, Long.valueOf(paramLong), paramBaseVideoViewControllerListener);
    Serializable localSerializable1 = null;
    if (paramBundle2 != null)
      localSerializable1 = paramBundle2.getSerializable("resumed_vast_config");
    Serializable localSerializable2 = paramBundle1.getSerializable("vast_video_config");
    if ((localSerializable1 != null) && ((localSerializable1 instanceof VastVideoConfig)))
    {
      this.a = ((VastVideoConfig)localSerializable1);
      this.x = paramBundle2.getInt("current_position", -1);
    }
    while (this.a.getDiskMediaFileUrl() == null)
    {
      throw new IllegalStateException("VastVideoConfig does not have a video disk path");
      if ((localSerializable2 != null) && ((localSerializable2 instanceof VastVideoConfig)))
        this.a = ((VastVideoConfig)localSerializable2);
      else
        throw new IllegalStateException("VastVideoConfig is invalid");
    }
    this.k = this.a.getVastCompanionAd(paramActivity.getResources().getConfiguration().orientation);
    this.o = this.a.getSocialActionsCompanionAds();
    this.l = this.a.getVastIconConfig();
    this.u = new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        VastVideoConfig localVastVideoConfig;
        Activity localActivity;
        if ((paramAnonymousMotionEvent.getAction() == 1) && (VastVideoViewController.a(VastVideoViewController.this)))
        {
          VastVideoViewController.b(VastVideoViewController.this).recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_CLICK_THRU, VastVideoViewController.this.j());
          VastVideoViewController.a(VastVideoViewController.this, true);
          VastVideoViewController.this.a("com.mopub.action.interstitial.click");
          localVastVideoConfig = VastVideoViewController.e(VastVideoViewController.this);
          localActivity = paramActivity;
          if (!VastVideoViewController.c(VastVideoViewController.this))
            break label102;
        }
        label102: for (int i = VastVideoViewController.d(VastVideoViewController.this); ; i = VastVideoViewController.this.j())
        {
          localVastVideoConfig.handleClickForResult(localActivity, i, 1);
          return true;
        }
      }
    };
    getLayout().setBackgroundColor(-16777216);
    e(paramActivity, 4);
    this.b = a(paramActivity, 0);
    this.b.requestFocus();
    this.c = new ExternalViewabilitySessionManager(paramActivity);
    this.c.createVideoSession(paramActivity, this.b, this.a);
    this.c.registerVideoObstruction(this.f);
    this.m = a(paramActivity, this.a.getVastCompanionAd(2), 4);
    this.n = a(paramActivity, this.a.getVastCompanionAd(1), 4);
    a(paramActivity);
    b(paramActivity, 4);
    b(paramActivity);
    c(paramActivity, 4);
    this.r = a(paramActivity, this.l, 4);
    this.r.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        VastVideoViewController.a(VastVideoViewController.this, VastVideoViewController.this.a(paramActivity));
        VastVideoViewController.f(VastVideoViewController.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    });
    c(paramActivity);
    int i1 = Dips.dipsToIntPixels(38.0F, paramActivity);
    this.q = a(paramActivity, (VastCompanionAdConfig)this.o.get("socialActions"), i1, 6, this.i, 4, 16);
    d(paramActivity, 8);
    Handler localHandler = new Handler(Looper.getMainLooper());
    this.s = new VastVideoViewProgressRunnable(this, this.a, localHandler);
    this.t = new VastVideoViewCountdownRunnable(this, localHandler);
  }

  private VastVideoView a(final Context paramContext, int paramInt)
  {
    if (this.a.getDiskMediaFileUrl() == null)
      throw new IllegalStateException("VastVideoConfig does not have a video disk path");
    final VastVideoView localVastVideoView = new VastVideoView(paramContext);
    localVastVideoView.setId((int)Utils.generateUniqueId());
    localVastVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        VastVideoViewController.a(VastVideoViewController.this, VastVideoViewController.g(VastVideoViewController.this).getDuration());
        VastVideoViewController.b(VastVideoViewController.this).onVideoPrepared(VastVideoViewController.this.getLayout(), VastVideoViewController.d(VastVideoViewController.this));
        VastVideoViewController.h(VastVideoViewController.this);
        if ((VastVideoViewController.i(VastVideoViewController.this) == null) || (VastVideoViewController.j(VastVideoViewController.this)))
          localVastVideoView.prepareBlurredLastVideoFrame(VastVideoViewController.k(VastVideoViewController.this), VastVideoViewController.e(VastVideoViewController.this).getDiskMediaFileUrl());
        VastVideoViewController.m(VastVideoViewController.this).calibrateAndMakeVisible(VastVideoViewController.this.i(), VastVideoViewController.l(VastVideoViewController.this));
        VastVideoViewController.n(VastVideoViewController.this).calibrateAndMakeVisible(VastVideoViewController.l(VastVideoViewController.this));
        VastVideoViewController.b(VastVideoViewController.this, true);
      }
    });
    localVastVideoView.setOnTouchListener(this.u);
    localVastVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        VastVideoViewController.o(VastVideoViewController.this);
        VastVideoViewController.this.k();
        VastVideoViewController.this.b(false);
        VastVideoViewController.c(VastVideoViewController.this, true);
        if (VastVideoViewController.e(VastVideoViewController.this).isRewardedVideo())
          VastVideoViewController.this.a("com.mopub.action.rewardedvideo.complete");
        if ((!VastVideoViewController.p(VastVideoViewController.this)) && (VastVideoViewController.e(VastVideoViewController.this).getRemainingProgressTrackerCount() == 0))
        {
          VastVideoViewController.b(VastVideoViewController.this).recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_COMPLETE, VastVideoViewController.this.j());
          VastVideoViewController.e(VastVideoViewController.this).handleComplete(VastVideoViewController.this.h(), VastVideoViewController.this.j());
        }
        localVastVideoView.setVisibility(4);
        VastVideoViewController.m(VastVideoViewController.this).setVisibility(8);
        if (VastVideoViewController.j(VastVideoViewController.this))
        {
          if (VastVideoViewController.k(VastVideoViewController.this).getDrawable() != null)
          {
            VastVideoViewController.k(VastVideoViewController.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
            VastVideoViewController.k(VastVideoViewController.this).setVisibility(0);
          }
          VastVideoViewController.q(VastVideoViewController.this).a();
          VastVideoViewController.r(VastVideoViewController.this).a();
          VastVideoViewController.s(VastVideoViewController.this).b();
          if (VastVideoViewController.i(VastVideoViewController.this) == null)
            break label306;
          if (paramContext.getResources().getConfiguration().orientation != 1)
            break label292;
          VastVideoViewController.t(VastVideoViewController.this).setVisibility(0);
          VastVideoViewController.i(VastVideoViewController.this).a(paramContext, VastVideoViewController.d(VastVideoViewController.this));
        }
        label292: label306: 
        while (VastVideoViewController.k(VastVideoViewController.this).getDrawable() == null)
          while (true)
          {
            return;
            VastVideoViewController.f(VastVideoViewController.this).setVisibility(8);
            break;
            VastVideoViewController.u(VastVideoViewController.this).setVisibility(0);
          }
        VastVideoViewController.k(VastVideoViewController.this).setVisibility(0);
      }
    });
    localVastVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        VastVideoViewController.b(VastVideoViewController.this).recordVideoEvent(ExternalViewabilitySession.VideoEvent.RECORD_AD_ERROR, VastVideoViewController.this.j());
        VastVideoViewController.o(VastVideoViewController.this);
        VastVideoViewController.this.k();
        VastVideoViewController.this.a(false);
        VastVideoViewController.d(VastVideoViewController.this, true);
        VastVideoViewController.e(VastVideoViewController.this).handleError(VastVideoViewController.this.h(), VastErrorCode.GENERAL_LINEAR_AD_ERROR, VastVideoViewController.this.j());
        return false;
      }
    });
    localVastVideoView.setVideoPath(this.a.getDiskMediaFileUrl());
    localVastVideoView.setVisibility(paramInt);
    return localVastVideoView;
  }

  private o a(final Context paramContext, final VastCompanionAdConfig paramVastCompanionAdConfig)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramVastCompanionAdConfig);
    o localo = o.a(paramContext, paramVastCompanionAdConfig.getVastResource());
    localo.a(new o.a()
    {
      public void onVastWebViewClick()
      {
        VastVideoViewController.this.a("com.mopub.action.interstitial.click");
        TrackingRequest.makeVastTrackingHttpRequest(paramVastCompanionAdConfig.getClickTrackers(), null, Integer.valueOf(VastVideoViewController.d(VastVideoViewController.this)), null, paramContext);
        paramVastCompanionAdConfig.a(paramContext, 1, null, VastVideoViewController.e(VastVideoViewController.this).getDspCreativeId());
      }
    });
    localo.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramVastCompanionAdConfig.a(paramContext, 1, paramAnonymousString, VastVideoViewController.e(VastVideoViewController.this).getDspCreativeId());
        return true;
      }
    });
    return localo;
  }

  private void a(Context paramContext)
  {
    if (this.k != null);
    for (boolean bool = true; ; bool = false)
    {
      this.d = new VastVideoGradientStripWidget(paramContext, GradientDrawable.Orientation.TOP_BOTTOM, this.a.getCustomForceOrientation(), bool, 0, 6, getLayout().getId());
      getLayout().addView(this.d);
      this.c.registerVideoObstruction(this.d);
      return;
    }
  }

  private void b(Context paramContext)
  {
    if (this.k != null);
    for (boolean bool = true; ; bool = false)
    {
      this.e = new VastVideoGradientStripWidget(paramContext, GradientDrawable.Orientation.BOTTOM_TOP, this.a.getCustomForceOrientation(), bool, 8, 2, this.g.getId());
      getLayout().addView(this.e);
      this.c.registerVideoObstruction(this.e);
      return;
    }
  }

  private void b(Context paramContext, int paramInt)
  {
    this.g = new VastVideoProgressBarWidget(paramContext);
    this.g.setAnchorId(this.b.getId());
    this.g.setVisibility(paramInt);
    getLayout().addView(this.g);
    this.c.registerVideoObstruction(this.g);
  }

  private void c(Context paramContext)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.k != null)
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(this.a.getClickThroughUrl()))
        break label107;
    }
    while (true)
    {
      this.i = new VastVideoCtaButtonWidget(paramContext, this.b.getId(), bool2, bool1);
      getLayout().addView(this.i);
      this.c.registerVideoObstruction(this.i);
      this.i.setOnTouchListener(this.u);
      String str = this.a.getCustomCtaText();
      if (str != null)
        this.i.a(str);
      return;
      bool2 = false;
      break;
      label107: bool1 = false;
    }
  }

  private void c(Context paramContext, int paramInt)
  {
    this.h = new VastVideoRadialCountdownWidget(paramContext);
    this.h.setVisibility(paramInt);
    getLayout().addView(this.h);
    this.c.registerVideoObstruction(this.h);
  }

  private void d(Context paramContext, int paramInt)
  {
    this.j = new VastVideoCloseButtonWidget(paramContext);
    this.j.setVisibility(paramInt);
    getLayout().addView(this.j);
    this.c.registerVideoObstruction(this.j);
    View.OnTouchListener local8 = new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (VastVideoViewController.c(VastVideoViewController.this));
        for (int i = VastVideoViewController.d(VastVideoViewController.this); ; i = VastVideoViewController.this.j())
        {
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            VastVideoViewController.a(VastVideoViewController.this, true);
            if (!VastVideoViewController.c(VastVideoViewController.this))
              VastVideoViewController.b(VastVideoViewController.this).recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_SKIPPED, VastVideoViewController.this.j());
            VastVideoViewController.e(VastVideoViewController.this).handleClose(VastVideoViewController.this.h(), i);
            VastVideoViewController.this.g().onFinish();
          }
          return true;
        }
      }
    };
    this.j.setOnTouchListenerToContent(local8);
    String str1 = this.a.getCustomSkipText();
    if (str1 != null)
      this.j.a(str1);
    String str2 = this.a.getCustomCloseIconUrl();
    if (str2 != null)
      this.j.b(str2);
  }

  private void e(Context paramContext, int paramInt)
  {
    this.f = new ImageView(paramContext);
    this.f.setVisibility(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    getLayout().addView(this.f, localLayoutParams);
  }

  private void p()
  {
    int i1 = i();
    if (this.a.isRewardedVideo())
      this.v = i1;
    Integer localInteger;
    do
    {
      return;
      if (i1 < 16000)
        this.v = i1;
      localInteger = this.a.getSkipOffsetMillis(i1);
    }
    while (localInteger == null);
    this.v = localInteger.intValue();
    this.A = true;
  }

  private boolean q()
  {
    return this.w;
  }

  private void r()
  {
    this.s.startRepeating(50L);
    this.t.startRepeating(250L);
  }

  private void s()
  {
    this.s.stop();
    this.t.stop();
  }

  @VisibleForTesting
  View a(Activity paramActivity)
  {
    return a(paramActivity, (VastCompanionAdConfig)this.o.get("adsBy"), this.r.getHeight(), 1, this.r, 0, 6);
  }

  @VisibleForTesting
  View a(Context paramContext, VastCompanionAdConfig paramVastCompanionAdConfig, int paramInt)
  {
    Preconditions.checkNotNull(paramContext);
    if (paramVastCompanionAdConfig == null)
    {
      View localView = new View(paramContext);
      localView.setVisibility(4);
      return localView;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    getLayout().addView(localRelativeLayout, localLayoutParams1);
    this.c.registerVideoObstruction(localRelativeLayout);
    o localo = a(paramContext, paramVastCompanionAdConfig);
    localo.setVisibility(paramInt);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(16 + paramVastCompanionAdConfig.getWidth(), paramContext), Dips.dipsToIntPixels(16 + paramVastCompanionAdConfig.getHeight(), paramContext));
    localLayoutParams2.addRule(13, -1);
    localRelativeLayout.addView(localo, localLayoutParams2);
    this.c.registerVideoObstruction(localo);
    return localo;
  }

  @VisibleForTesting
  View a(Context paramContext, VastCompanionAdConfig paramVastCompanionAdConfig, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramView);
    if (paramVastCompanionAdConfig == null)
    {
      View localView = new View(paramContext);
      localView.setVisibility(4);
      return localView;
    }
    this.C = true;
    this.i.setHasSocialActions(this.C);
    o localo = a(paramContext, paramVastCompanionAdConfig);
    int i1 = Dips.dipsToIntPixels(paramVastCompanionAdConfig.getWidth(), paramContext);
    int i2 = Dips.dipsToIntPixels(paramVastCompanionAdConfig.getHeight(), paramContext);
    int i3 = (paramInt1 - i2) / 2;
    int i4 = Dips.dipsToIntPixels(paramInt4, paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i2);
    localLayoutParams.addRule(paramInt2, paramView.getId());
    localLayoutParams.addRule(6, paramView.getId());
    localLayoutParams.setMargins(i4, i3, 0, 0);
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setGravity(16);
    localRelativeLayout.addView(localo, new RelativeLayout.LayoutParams(-2, -2));
    this.c.registerVideoObstruction(localo);
    getLayout().addView(localRelativeLayout, localLayoutParams);
    this.c.registerVideoObstruction(localRelativeLayout);
    localo.setVisibility(paramInt3);
    return localo;
  }

  @VisibleForTesting
  View a(final Context paramContext, final i parami, int paramInt)
  {
    Preconditions.checkNotNull(paramContext);
    if (parami == null)
      return new View(paramContext);
    o localo = o.a(paramContext, parami.e());
    localo.a(new o.a()
    {
      public void onVastWebViewClick()
      {
        TrackingRequest.makeVastTrackingHttpRequest(parami.f(), null, Integer.valueOf(VastVideoViewController.this.j()), VastVideoViewController.this.o(), paramContext);
        parami.a(VastVideoViewController.this.h(), null, VastVideoViewController.e(VastVideoViewController.this).getDspCreativeId());
      }
    });
    localo.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        parami.a(VastVideoViewController.this.h(), paramAnonymousString, VastVideoViewController.e(VastVideoViewController.this).getDspCreativeId());
        return true;
      }
    });
    localo.setVisibility(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Dips.asIntPixels(parami.a(), paramContext), Dips.asIntPixels(parami.b(), paramContext));
    localLayoutParams.setMargins(Dips.dipsToIntPixels(12.0F, paramContext), Dips.dipsToIntPixels(12.0F, paramContext), 0, 0);
    getLayout().addView(localo, localLayoutParams);
    this.c.registerVideoObstruction(localo);
    return localo;
  }

  protected void a()
  {
    super.a();
    switch (3.a[this.a.getCustomForceOrientation().ordinal()])
    {
    case 3:
    case 4:
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      this.a.handleImpression(h(), j());
      a("com.mopub.action.interstitial.show");
      return;
      g().onSetRequestedOrientation(1);
      continue;
      g().onSetRequestedOrientation(6);
    }
  }

  void a(int paramInt)
  {
    if ((this.l == null) || (paramInt < this.l.c()));
    do
    {
      return;
      this.r.setVisibility(0);
      this.l.a(h(), paramInt, o());
    }
    while ((this.l.d() == null) || (paramInt < this.l.c() + this.l.d().intValue()));
    this.r.setVisibility(8);
  }

  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
      g().onFinish();
  }

  protected void a(Configuration paramConfiguration)
  {
    int i1 = h().getResources().getConfiguration().orientation;
    this.k = this.a.getVastCompanionAd(i1);
    if ((this.m.getVisibility() == 0) || (this.n.getVisibility() == 0))
    {
      if (i1 != 1)
        break label90;
      this.m.setVisibility(4);
      this.n.setVisibility(0);
    }
    while (true)
    {
      if (this.k != null)
        this.k.a(h(), this.D);
      return;
      label90: this.n.setVisibility(4);
      this.m.setVisibility(0);
    }
  }

  protected void a(Bundle paramBundle)
  {
    paramBundle.putInt("current_position", this.x);
    paramBundle.putSerializable("resumed_vast_config", this.a);
  }

  protected VideoView b()
  {
    return this.b;
  }

  void b(String paramString)
  {
    ExternalViewabilitySession.VideoEvent localVideoEvent = (ExternalViewabilitySession.VideoEvent)Enum.valueOf(ExternalViewabilitySession.VideoEvent.class, paramString);
    this.c.recordVideoEvent(localVideoEvent, j());
  }

  public boolean backButtonEnabled()
  {
    return this.w;
  }

  protected void c()
  {
    s();
    this.x = j();
    this.b.pause();
    if ((!this.y) && (!this.E))
    {
      this.c.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_PAUSED, j());
      this.a.handlePause(h(), this.x);
    }
  }

  protected void d()
  {
    r();
    if (this.x > 0)
    {
      this.c.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_PLAYING, this.x);
      this.b.seekTo(this.x);
    }
    while (true)
    {
      if (!this.y)
        this.b.start();
      if (this.x != -1)
        this.a.handleResume(h(), this.x);
      return;
      this.c.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_LOADED, j());
    }
  }

  protected void e()
  {
    s();
    this.c.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_STOPPED, j());
    this.c.endVideoSession();
    a("com.mopub.action.interstitial.dismiss");
    this.b.onDestroy();
  }

  protected void f()
  {
    if (!this.y)
      this.c.recordVideoEvent(ExternalViewabilitySession.VideoEvent.AD_SKIPPED, j());
  }

  int i()
  {
    return this.b.getDuration();
  }

  int j()
  {
    return this.b.getCurrentPosition();
  }

  void k()
  {
    this.w = true;
    this.h.setVisibility(8);
    this.j.setVisibility(0);
    this.i.a();
    this.q.setVisibility(0);
  }

  boolean l()
  {
    return (!this.w) && (j() >= this.v);
  }

  void m()
  {
    if (this.B)
      this.h.updateCountdownProgress(this.v, j());
  }

  void n()
  {
    this.g.updateProgress(j());
  }

  String o()
  {
    if (this.a == null)
      return null;
    return this.a.getNetworkMediaFileUrl();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoViewController
 * JD-Core Version:    0.6.2
 */