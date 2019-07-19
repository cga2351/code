package com.my.target;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils.TruncateAt;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.my.target.common.a.b;
import com.my.target.common.a.c;

public final class bw extends ViewGroup
{
  private static final int a = bj.a();
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private static final int e = bj.a();
  private static final int f = bj.a();
  private static final int g = bj.a();
  private static final int h = bj.a();
  private static final int i = bj.a();
  private static final int j = bj.a();
  private static final int k = bj.a();
  private final bv A;
  private final Runnable B;
  private final c C;
  private final View.OnClickListener D;
  private final int E;
  private final Bitmap F;
  private final Bitmap G;
  private int H;
  private final int I;
  private boolean J;
  private d K;
  private final TextView l;
  private final ay m;
  private final Button n;
  private final Button o;
  private final bj p;
  private final LinearLayout q;
  private final TextView r;
  private final FrameLayout s;
  private final com.my.target.c.b.a t;
  private final TextView u;
  private final bx v;
  private final av w;
  private final TextureView x;
  private final bv y;
  private final bv z;

  public bw(Context paramContext)
  {
    super(paramContext);
    this.o = new Button(paramContext);
    this.l = new TextView(paramContext);
    this.m = new ay(paramContext);
    this.n = new Button(paramContext);
    this.r = new TextView(paramContext);
    this.s = new FrameLayout(paramContext);
    this.y = new bv(paramContext);
    this.z = new bv(paramContext);
    this.A = new bv(paramContext);
    this.u = new TextView(paramContext);
    this.t = new com.my.target.c.b.a(paramContext);
    this.v = new bx(paramContext);
    this.w = new av(paramContext);
    this.q = new LinearLayout(paramContext);
    this.p = bj.a(paramContext);
    this.B = new b((byte)0);
    this.C = new c((byte)0);
    this.D = new a((byte)0);
    this.x = new TextureView(paramContext);
    this.F = com.my.target.b.e.a.c(this.p.c(28));
    this.G = com.my.target.b.e.a.b(this.p.c(28));
    bj.a(this.o, "dismiss_button");
    bj.a(this.l, "title_text");
    bj.a(this.m, "stars_view");
    bj.a(this.n, "cta_button");
    bj.a(this.r, "replay_text");
    bj.a(this.s, "shadow");
    bj.a(this.y, "pause_button");
    bj.a(this.z, "play_button");
    bj.a(this.A, "replay_button");
    bj.a(this.u, "domain_text");
    bj.a(this.t, "media_view");
    bj.a(this.v, "video_progress_wheel");
    bj.a(this.w, "sound_button");
    this.I = this.p.c(28);
    this.E = this.p.c(16);
    setBackgroundColor(-16777216);
    int i1 = this.E;
    this.w.setId(j);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    this.t.setLayoutParams(localLayoutParams);
    this.t.setId(i);
    this.t.setOnClickListener(this.C);
    this.t.setBackgroundColor(-16777216);
    this.s.setBackgroundColor(-1728053248);
    this.s.setVisibility(8);
    this.o.setId(a);
    this.o.setTextSize(2, 16.0F);
    this.o.setTransformationMethod(null);
    this.o.setEllipsize(TextUtils.TruncateAt.END);
    this.o.setMaxLines(2);
    this.o.setPadding(i1, i1, i1, i1);
    this.o.setTextColor(-1);
    bj.a(this.o, -2013265920, -1, -1, this.p.c(1), this.p.c(4));
    this.l.setId(g);
    this.l.setMaxLines(2);
    this.l.setEllipsize(TextUtils.TruncateAt.END);
    this.l.setTextSize(2, 18.0F);
    this.l.setTextColor(-1);
    bj.a(this.n, -2013265920, -1, -1, this.p.c(1), this.p.c(4));
    this.n.setId(b);
    this.n.setTextColor(-1);
    this.n.setTransformationMethod(null);
    this.n.setGravity(1);
    this.n.setTextSize(2, 16.0F);
    this.n.setMinimumWidth(this.p.c(100));
    this.n.setPadding(i1, i1, i1, i1);
    this.l.setShadowLayer(this.p.c(1), this.p.c(1), this.p.c(1), -16777216);
    this.u.setId(h);
    this.u.setTextColor(-3355444);
    this.u.setMaxEms(10);
    this.u.setShadowLayer(this.p.c(1), this.p.c(1), this.p.c(1), -16777216);
    this.q.setId(c);
    this.q.setOnClickListener(this.D);
    this.q.setGravity(17);
    this.q.setVisibility(8);
    this.q.setPadding(this.p.c(8), 0, this.p.c(8), 0);
    this.r.setSingleLine();
    this.r.setEllipsize(TextUtils.TruncateAt.END);
    this.r.setTypeface(this.r.getTypeface(), 1);
    this.r.setTextColor(-1);
    this.r.setTextSize(2, 16.0F);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.leftMargin = this.p.c(4);
    this.A.setPadding(this.p.c(16), this.p.c(16), this.p.c(16), this.p.c(16));
    this.y.setId(e);
    this.y.setOnClickListener(this.D);
    this.y.setVisibility(8);
    this.y.setPadding(this.p.c(16), this.p.c(16), this.p.c(16), this.p.c(16));
    this.z.setId(d);
    this.z.setOnClickListener(this.D);
    this.z.setVisibility(8);
    this.z.setPadding(this.p.c(16), this.p.c(16), this.p.c(16), this.p.c(16));
    this.s.setId(k);
    Context localContext1 = getContext();
    byte[] arrayOfByte1 = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCy8fw79+rQAAAhVJREFUeNrt2y9IXlEYx3H3ooIiiCAIC4JgMRgsCyaLwWaxLK0srZhWVtYWVtYWlpYMNsvK0sKKRTANBivDIIggIiLiZ+URDncHFgzbznN+8d77nvPwvec99zz/xsa6uv4oPMWjzADgK55kBnCvj3icGQBc4hWmsgK41w/sZAPwswLiC9ayAJjGa1wNrt/hAxaaBlBcW8ReZTVc4CUmmwZQ3FvHYQXEd2w3DyDuj/AMJxUQn7HaNIDiuRm8wfUAwi3eY75pAMXzS9ivrIZz7GKiaQDF7zZwVAHxDVvNAyj2h+c4rYD4hJWmARRjzOItbir7wzvMNQ2gGGsZB5XVcIYXGG8aQDHmJo4rII6x2TyAGHc83vpZBcQBlpsGUIw/F/vA7QDCTewbs00DKOZZiS/DUKfxJRk1DaCYbyvOCkMdYaN5ADHnRJwazysg9rHUNIBi7vnwI4b7w3X4HTNNAyhsWA3PcqiT8ERHTQMobNmOWMNQh1hvHkDYMxlRp4sKiD0sNg2gsGsh4pB3AwhXEbecbhpAYd9aRKZVItgPT+v96wAKO3ciVzHUw9J6/wuAsHUqslaXFRC/pfVGY139L9A3wf4Z7AehfhTuzlB3h3tApIfE/jqAtEHRtGHx1ImRtKmxtMnRtOnx1AUSaUtk0hZJpS2TS10ombZUNm2xdPpy+d4w0VtmetNU2ra51I2TuVtnuxrWL/YiKQ6CN9uRAAAAAElFTkSuQmCC", 0);
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inDensity = 420;
    localOptions1.inTargetDensity = localContext1.getResources().getDisplayMetrics().densityDpi;
    Bitmap localBitmap1 = BitmapFactory.decodeByteArray(arrayOfByte1, 0, arrayOfByte1.length, localOptions1);
    if (localBitmap1 != null)
      this.z.setImageBitmap(localBitmap1);
    Context localContext2 = getContext();
    byte[] arrayOfByte2 = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCjITNKc0rQAAAJFJREFUeNrt2tENgCAMQEEwLuD+QzpC3cBURWLsvV+JNRfhi9YkSSpbP3sYETF0WO89s27m3KX6H1AeYL2wdrs5Y3/4ja/OTZ8B2f074h0z5zoDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/lr6rvDoK+xfmWsLNEmSVLUD47EiX/OuE8UAAAAASUVORK5CYII=", 0);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    localOptions2.inDensity = 420;
    localOptions2.inTargetDensity = localContext2.getResources().getDisplayMetrics().densityDpi;
    Bitmap localBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte2, 0, arrayOfByte2.length, localOptions2);
    if (localBitmap2 != null)
      this.y.setImageBitmap(localBitmap2);
    bj.a(this.y, -2013265920, -1, -1, this.p.c(1), this.p.c(4));
    bj.a(this.z, -2013265920, -1, -1, this.p.c(1), this.p.c(4));
    bj.a(this.A, -2013265920, -1, -1, this.p.c(1), this.p.c(4));
    this.m.setStarSize(this.p.c(12));
    this.v.setId(f);
    this.v.setVisibility(8);
    this.t.addView(this.x, new ViewGroup.LayoutParams(-1, -1));
    addView(this.t);
    addView(this.s);
    addView(this.w);
    addView(this.o);
    addView(this.v);
    addView(this.q);
    addView(this.y);
    addView(this.z);
    addView(this.m);
    addView(this.u);
    addView(this.n);
    addView(this.l);
    this.q.addView(this.A);
    this.q.addView(this.r, localLayoutParams1);
    this.n.setOnClickListener(this.D);
    this.o.setOnClickListener(this.D);
    this.w.setOnClickListener(this.D);
  }

  public final void a()
  {
    if (this.H != 4)
    {
      this.H = 4;
      this.t.getImageView().setVisibility(0);
      this.t.getProgressBarView().setVisibility(8);
      if (this.J)
      {
        this.q.setVisibility(0);
        this.s.setVisibility(0);
      }
      this.z.setVisibility(8);
      this.y.setVisibility(8);
      this.v.setVisibility(8);
    }
  }

  public final void a(float paramFloat1, float paramFloat2)
  {
    if (this.v.getVisibility() != 0)
      this.v.setVisibility(0);
    this.v.setProgress(paramFloat1 / paramFloat2);
    this.v.setDigit((int)Math.ceil(paramFloat2 - paramFloat1));
  }

  public final void a(com.my.target.b.c.a.a parama, c paramc)
  {
    k localk = parama.F();
    if (localk == null)
      return;
    this.v.setMax(parama.A());
    this.J = localk.N();
    this.n.setText(parama.d());
    this.l.setText(parama.p());
    if ("store".equals(parama.m()))
    {
      this.u.setVisibility(8);
      if ((parama.t() != 0) && (parama.n() > 0.0F))
      {
        this.m.setVisibility(0);
        this.m.setRating(parama.n());
      }
    }
    while (true)
    {
      this.o.setText(localk.G());
      this.r.setText(localk.H());
      Context localContext = getContext();
      byte[] arrayOfByte = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCjM59gfMOgAAA59JREFUeNrtmkloFEEUhl/N6KgxriiJOHEXF4gENYlgRFA8uyAoCNGggl68CCJ6EQx6cCFqUFzABQQRMYh4EfSi4IJbiFERQVxRgxuRMWri5yE1UBY9yWh6Znq6+z+96a6ZV/8/tbz3qkRChAgRwiMAFgJngWgQyVcDHXTiFKCCRH4Df6MFKAkK+W0W+VfAxCAQV8A+i/wTIB4E8lHgpEX+LjA8COQHAM8t8o3ATKC338kXA59IjXbgEVAPLAb6+k2AHRbhVrrGV+AwMNVPIpx3INncjRi/gTPAWL+IcMIieBGIAXFgGXAU+OggRALY7ItIEdhvkTsNRIz3MWCp3h1sXAGK/RAHnLKIHUzRdgnwwmr7Epjsh3jggkWsNkXbQuC4Q8g8Ld9F6ANctYht7KL9GiNpAnib94ujDo5uaUIdwMo00uafhghNQL98F2EYcA9YlGb75daoOeqHnSHyj+23WyLMC1oRJQpct7LJXkETYSrwyxBhlQQNwAFrFKigCTDK2hXmBnEUnDMEOBZEARYaArwLogAF1jRIq4YQ8YsASqmEiNw2HpUHSgCNB4Y9KYgCPDXs8UEU4LNhF6bzhW7DRmCEiFTqjx+VUtc8LECrYfd3RQA9lxq03SgiZR4WIGbYv9yaAt8Me5DHp8DAFP3ukQDvDTvu8WxrnGG/dUUApdQrEUkYU2a8hwWYnGJH6PEu0GzYczwaCSoRqTIeNbkpwFXDnu/Rf79URJKnyz9E5Kab6i4wYuxvQKEHR8BO8+DE7R+PAu8MB6s9Rj4GvDH6tzYTTvZaVZeIhwSoMfr2HRiUCSd21aXGI+T7WRcu6jLp7Ijh6AMw1AMCmKXxtozeLgOKgC+Gw4ZcFiCB2fpWSRLbsuF0nXUYsSlH5EfqE+IknmblSo0+1m6wRKjOMvnB+jzQHPpl2ezAEOCx0YEOYH2WfMct8rlZkIES4LXVkXqgTwZ9Vjn43JrLFXgC8Mzq0H2g0mU/BTrSa7d8bfHCPlwE3HC41XWyp9fbdIS3Tt8fxprzq7wUivYGdmnithCXgRXpxgw67K4A9ljhdxKPgVK3+q5cFqJcRA6JyAyn1zpFfaBz9RZdtYnpStNonc/PEpEhDt9vE5FaEdmtlPrh2YoEEAEWpbje9j9o1aNrhOQbgOlAncNC2R0SwCVgZaZTb5VFMUpEpEJEpojIGBEZLJ21+zbpLGe3iMgTEXkoIneUUj8lRIgQIUKECJFJ/AEepzU1TSID5QAAAABJRU5ErkJggg==", 0);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = 420;
      localOptions.inTargetDensity = localContext.getResources().getDisplayMetrics().densityDpi;
      Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      if (localBitmap != null)
        this.A.setImageBitmap(localBitmap);
      this.t.a(paramc.b(), paramc.c());
      b localb = parama.l();
      if (localb == null)
        break;
      this.t.getImageView().setImageBitmap(localb.e());
      return;
      this.m.setVisibility(8);
      continue;
      this.m.setVisibility(8);
      this.u.setVisibility(0);
      this.u.setText(parama.h());
    }
  }

  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.w.a(this.G, false);
      this.w.setContentDescription("sound off");
      return;
    }
    this.w.a(this.F, false);
    this.w.setContentDescription("sound on");
  }

  public final void b()
  {
    if (this.H != 3)
    {
      this.H = 3;
      this.t.getProgressBarView().setVisibility(0);
      this.q.setVisibility(8);
      this.z.setVisibility(8);
      this.y.setVisibility(8);
      this.s.setVisibility(8);
    }
  }

  public final void c()
  {
    if (this.H != 1)
    {
      this.H = 1;
      this.t.getImageView().setVisibility(0);
      this.t.getProgressBarView().setVisibility(8);
      this.q.setVisibility(8);
      this.z.setVisibility(0);
      this.y.setVisibility(8);
      this.s.setVisibility(0);
    }
  }

  public final void d()
  {
    if ((this.H != 0) && (this.H != 2))
    {
      this.H = 0;
      this.t.getImageView().setVisibility(8);
      this.t.getProgressBarView().setVisibility(8);
      this.q.setVisibility(8);
      this.z.setVisibility(8);
      if (this.H != 2)
        this.y.setVisibility(8);
    }
  }

  public final void e()
  {
    this.t.getImageView().setVisibility(0);
  }

  public final com.my.target.c.b.a getMediaAdView()
  {
    return this.t;
  }

  public final TextureView getTextureView()
  {
    return this.x;
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    int i3 = this.t.getMeasuredWidth();
    int i4 = this.t.getMeasuredHeight();
    int i5 = i1 - i3 >> 1;
    int i6 = i2 - i4 >> 1;
    this.t.layout(i5, i6, i3 + i5, i4 + i6);
    this.s.layout(this.t.getLeft(), this.t.getTop(), this.t.getRight(), this.t.getBottom());
    int i7 = this.z.getMeasuredWidth();
    int i8 = this.z.getMeasuredHeight();
    this.z.layout((paramInt3 >> 1) - (i7 >> 1), (paramInt4 >> 1) - (i8 >> 1), (paramInt3 >> 1) + (i7 >> 1), (paramInt4 >> 1) + (i8 >> 1));
    int i9 = this.y.getMeasuredWidth();
    int i10 = this.y.getMeasuredHeight();
    this.y.layout((paramInt3 >> 1) - (i9 >> 1), (paramInt4 >> 1) - (i10 >> 1), (paramInt3 >> 1) + (i9 >> 1), (paramInt4 >> 1) + (i10 >> 1));
    int i11 = this.q.getMeasuredWidth();
    int i12 = this.q.getMeasuredHeight();
    this.q.layout((paramInt3 >> 1) - (i11 >> 1), (paramInt4 >> 1) - (i12 >> 1), (paramInt3 >> 1) + (i11 >> 1), (paramInt4 >> 1) + (i12 >> 1));
    this.o.layout(this.E, this.E, this.E + this.o.getMeasuredWidth(), this.E + this.o.getMeasuredHeight());
    if (i1 > i2)
    {
      int i13 = Math.max(this.n.getMeasuredHeight(), Math.max(this.l.getMeasuredHeight(), this.m.getMeasuredHeight()));
      this.n.layout(i1 - this.E - this.n.getMeasuredWidth(), i2 - this.E - this.n.getMeasuredHeight() - (i13 - this.n.getMeasuredHeight() >> 1), i1 - this.E, i2 - this.E - (i13 - this.n.getMeasuredHeight() >> 1));
      this.w.layout(this.n.getRight() - this.w.getMeasuredWidth() + this.w.getPadding(), this.t.getBottom() - (this.E << 1) - this.w.getMeasuredHeight() - i13 + this.w.getPadding(), this.n.getRight() + this.w.getPadding(), this.t.getBottom() - (this.E << 1) - i13 + this.w.getPadding());
      this.m.layout(this.n.getLeft() - this.E - this.m.getMeasuredWidth(), i2 - this.E - this.m.getMeasuredHeight() - (i13 - this.m.getMeasuredHeight() >> 1), this.n.getLeft() - this.E, i2 - this.E - (i13 - this.m.getMeasuredHeight() >> 1));
      this.u.layout(this.n.getLeft() - this.E - this.u.getMeasuredWidth(), i2 - this.E - this.u.getMeasuredHeight() - (i13 - this.u.getMeasuredHeight() >> 1), this.n.getLeft() - this.E, i2 - this.E - (i13 - this.u.getMeasuredHeight() >> 1));
      int i14 = Math.min(this.m.getLeft(), this.u.getLeft());
      this.l.layout(i14 - this.E - this.l.getMeasuredWidth(), i2 - this.E - this.l.getMeasuredHeight() - (i13 - this.l.getMeasuredHeight() >> 1), i14 - this.E, i2 - this.E - (i13 - this.l.getMeasuredHeight() >> 1));
      this.v.layout(this.E, i2 - this.E - this.v.getMeasuredHeight() - (i13 - this.v.getMeasuredHeight() >> 1), this.E + this.v.getMeasuredWidth(), i2 - this.E - (i13 - this.v.getMeasuredHeight() >> 1));
      return;
    }
    this.w.layout(this.t.getRight() - this.E - this.w.getMeasuredWidth() + this.w.getPadding(), this.t.getBottom() - this.E - this.w.getMeasuredHeight() + this.w.getPadding(), this.t.getRight() - this.E + this.w.getPadding(), this.t.getBottom() - this.E + this.w.getPadding());
    this.l.layout((i1 >> 1) - (this.l.getMeasuredWidth() >> 1), this.t.getBottom() + this.E, (i1 >> 1) + (this.l.getMeasuredWidth() >> 1), this.t.getBottom() + this.E + this.l.getMeasuredHeight());
    this.m.layout((i1 >> 1) - (this.m.getMeasuredWidth() >> 1), this.l.getBottom() + this.E, (i1 >> 1) + (this.m.getMeasuredWidth() >> 1), this.l.getBottom() + this.E + this.m.getMeasuredHeight());
    this.u.layout((i1 >> 1) - (this.u.getMeasuredWidth() >> 1), this.l.getBottom() + this.E, (i1 >> 1) + (this.u.getMeasuredWidth() >> 1), this.l.getBottom() + this.E + this.u.getMeasuredHeight());
    this.n.layout((i1 >> 1) - (this.n.getMeasuredWidth() >> 1), this.m.getBottom() + this.E, (i1 >> 1) + (this.n.getMeasuredWidth() >> 1), this.m.getBottom() + this.E + this.n.getMeasuredHeight());
    this.v.layout(this.E, this.t.getBottom() - this.E - this.v.getMeasuredHeight(), this.E + this.v.getMeasuredWidth(), this.t.getBottom() - this.E);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    this.w.measure(View.MeasureSpec.makeMeasureSpec(this.I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.I, 1073741824));
    this.v.measure(View.MeasureSpec.makeMeasureSpec(this.I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.I, 1073741824));
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.t.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
    int i3 = i1 - (this.E << 1);
    int i4 = i2 - (this.E << 1);
    this.o.measure(View.MeasureSpec.makeMeasureSpec(i3 / 2, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.y.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.z.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.q.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.m.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.s.measure(View.MeasureSpec.makeMeasureSpec(this.t.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.t.getMeasuredHeight(), 1073741824));
    this.n.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.l.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.u.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    if (i1 > i2)
    {
      int i5 = this.n.getMeasuredWidth();
      int i6 = this.l.getMeasuredWidth();
      if (i5 + (Math.max(this.m.getMeasuredWidth(), this.u.getMeasuredWidth()) + (i6 + this.v.getMeasuredWidth())) + 3 * this.E > i3)
      {
        int i7 = i3 - this.v.getMeasuredWidth() - 3 * this.E;
        this.n.measure(View.MeasureSpec.makeMeasureSpec(i7 / 3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
        this.m.measure(View.MeasureSpec.makeMeasureSpec(i7 / 3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
        this.u.measure(View.MeasureSpec.makeMeasureSpec(i7 / 3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
        int i8 = i7 - this.n.getMeasuredWidth() - this.u.getMeasuredWidth() - this.m.getMeasuredWidth();
        this.l.measure(View.MeasureSpec.makeMeasureSpec(i8, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
      }
    }
    setMeasuredDimension(i1, i2);
  }

  public final void setVideoDialogViewListener(d paramd)
  {
    this.K = paramd;
  }

  private final class a
    implements View.OnClickListener
  {
    private a()
    {
    }

    public final void onClick(View paramView)
    {
      int i;
      if (bw.a(bw.this) != null)
      {
        i = paramView.getId();
        if (i != bw.f())
          break label36;
        bw.a(bw.this).a(paramView);
      }
      label36: 
      do
      {
        return;
        if (i == bw.g())
        {
          bw.a(bw.this).l();
          return;
        }
        if (i == bw.h())
        {
          bw.a(bw.this).m();
          return;
        }
        if (i == bw.i())
        {
          bw.a(bw.this).k();
          return;
        }
        if (i == bw.j())
        {
          bw.a(bw.this).n();
          return;
        }
      }
      while (i != bw.k());
      bw.a(bw.this).o();
    }
  }

  private final class b
    implements Runnable
  {
    private b()
    {
    }

    public final void run()
    {
      if (bw.b(bw.this) == 2)
        bw.c(bw.this);
    }
  }

  private final class c
    implements View.OnClickListener
  {
    private c()
    {
    }

    public final void onClick(View paramView)
    {
      bw.this.removeCallbacks(bw.d(bw.this));
      if (bw.b(bw.this) == 2)
      {
        bw.c(bw.this);
        return;
      }
      if (bw.b(bw.this) == 0)
        bw.e(bw.this);
      bw.this.postDelayed(bw.d(bw.this), 4000L);
    }
  }

  public static abstract interface d
  {
    public abstract void a(View paramView);

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void o();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bw
 * JD-Core Version:    0.6.2
 */