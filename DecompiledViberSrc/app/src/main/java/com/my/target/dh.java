package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.my.target.b.c.a.i;
import com.my.target.b.d.h.a;
import com.my.target.b.e.b;

@SuppressLint({"ViewConstructor"})
public final class dh extends ViewGroup
  implements dc
{
  private h.a A;
  private int B;
  private float C;
  private boolean D;
  private boolean E;
  private final int F;
  private String G;
  private String H;
  private boolean I;
  private final b b;
  private final TextView c;
  private final ay d;
  private final Button e;
  private final TextView f;
  private final bj g;
  private final LinearLayout h;
  private final TextView i;
  private final FrameLayout j;
  private final df k;
  private final TextView l;
  private final cx m;
  private final av n;
  private final db o;
  private final db p;
  private final db q;
  private final Runnable r;
  private final d s;
  private final a t;
  private final int u;
  private final int v;
  private final Bitmap w;
  private final Bitmap x;
  private float y;
  private dd.a z;

  public dh(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.f = new TextView(paramContext);
    this.c = new TextView(paramContext);
    this.d = new ay(paramContext);
    this.e = new Button(paramContext);
    this.i = new TextView(paramContext);
    this.j = new FrameLayout(paramContext);
    this.o = new db(paramContext);
    this.p = new db(paramContext);
    this.q = new db(paramContext);
    this.l = new TextView(paramContext);
    this.k = new df(paramContext, bj.a(paramContext), false, paramBoolean);
    this.m = new cx(paramContext);
    this.n = new av(paramContext);
    this.h = new LinearLayout(paramContext);
    this.g = bj.a(paramContext);
    this.r = new c((byte)0);
    this.s = new d((byte)0);
    this.t = new a((byte)0);
    bj.a(this.f, "dismiss_button");
    bj.a(this.c, "title_text");
    bj.a(this.d, "stars_view");
    bj.a(this.e, "cta_button");
    bj.a(this.i, "replay_text");
    bj.a(this.j, "shadow");
    bj.a(this.o, "pause_button");
    bj.a(this.p, "play_button");
    bj.a(this.q, "replay_button");
    bj.a(this.l, "domain_text");
    bj.a(this.k, "media_view");
    bj.a(this.m, "video_progress_wheel");
    bj.a(this.n, "sound_button");
    this.F = this.g.c(28);
    this.u = this.g.c(16);
    this.v = this.g.c(4);
    this.w = b.a(this.g.c(28));
    this.x = b.b(this.g.c(28));
    this.b = new b();
    setBackgroundColor(-16777216);
    int i1 = this.u;
    this.n.setId(a);
    this.k.setOnClickListener(this.s);
    this.k.setBackgroundColor(-16777216);
    this.k.a();
    this.j.setBackgroundColor(-1728053248);
    this.j.setVisibility(8);
    this.f.setTextSize(2, 16.0F);
    this.f.setTransformationMethod(null);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    this.f.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 17)
      this.f.setTextAlignment(4);
    this.f.setTextColor(-1);
    bj.a(this.f, -2013265920, -1, -1, this.g.c(1), this.g.c(4));
    this.c.setMaxLines(2);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setTextSize(2, 18.0F);
    this.c.setTextColor(-1);
    bj.a(this.e, -2013265920, -1, -1, this.g.c(1), this.g.c(4));
    this.e.setTextColor(-1);
    this.e.setTransformationMethod(null);
    this.e.setGravity(1);
    this.e.setTextSize(2, 16.0F);
    this.e.setMinimumWidth(this.g.c(100));
    this.e.setPadding(i1, i1, i1, i1);
    this.c.setShadowLayer(this.g.c(1), this.g.c(1), this.g.c(1), -16777216);
    this.l.setTextColor(-3355444);
    this.l.setMaxEms(10);
    this.l.setShadowLayer(this.g.c(1), this.g.c(1), this.g.c(1), -16777216);
    this.h.setOnClickListener(this.t);
    this.h.setGravity(17);
    this.h.setVisibility(8);
    this.h.setPadding(this.g.c(8), 0, this.g.c(8), 0);
    this.i.setSingleLine();
    this.i.setEllipsize(TextUtils.TruncateAt.END);
    this.i.setTypeface(this.i.getTypeface(), 1);
    this.i.setTextColor(-1);
    this.i.setTextSize(2, 16.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.g.c(4);
    this.q.setPadding(this.g.c(16), this.g.c(16), this.g.c(16), this.g.c(16));
    this.o.setOnClickListener(this.t);
    this.o.setVisibility(8);
    this.o.setPadding(this.g.c(16), this.g.c(16), this.g.c(16), this.g.c(16));
    this.p.setOnClickListener(this.t);
    this.p.setVisibility(8);
    this.p.setPadding(this.g.c(16), this.g.c(16), this.g.c(16), this.g.c(16));
    Context localContext1 = getContext();
    byte[] arrayOfByte1 = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCy8fw79+rQAAAhVJREFUeNrt2y9IXlEYx3H3ooIiiCAIC4JgMRgsCyaLwWaxLK0srZhWVtYWVtYWlpYMNsvK0sKKRTANBivDIIggIiLiZ+URDncHFgzbznN+8d77nvPwvec99zz/xsa6uv4oPMWjzADgK55kBnCvj3icGQBc4hWmsgK41w/sZAPwswLiC9ayAJjGa1wNrt/hAxaaBlBcW8ReZTVc4CUmmwZQ3FvHYQXEd2w3DyDuj/AMJxUQn7HaNIDiuRm8wfUAwi3eY75pAMXzS9ivrIZz7GKiaQDF7zZwVAHxDVvNAyj2h+c4rYD4hJWmARRjzOItbir7wzvMNQ2gGGsZB5XVcIYXGG8aQDHmJo4rII6x2TyAGHc83vpZBcQBlpsGUIw/F/vA7QDCTewbs00DKOZZiS/DUKfxJRk1DaCYbyvOCkMdYaN5ADHnRJwazysg9rHUNIBi7vnwI4b7w3X4HTNNAyhsWA3PcqiT8ERHTQMobNmOWMNQh1hvHkDYMxlRp4sKiD0sNg2gsGsh4pB3AwhXEbecbhpAYd9aRKZVItgPT+v96wAKO3ciVzHUw9J6/wuAsHUqslaXFRC/pfVGY139L9A3wf4Z7AehfhTuzlB3h3tApIfE/jqAtEHRtGHx1ImRtKmxtMnRtOnx1AUSaUtk0hZJpS2TS10ombZUNm2xdPpy+d4w0VtmetNU2ra51I2TuVtnuxrWL/YiKQ6CN9uRAAAAAElFTkSuQmCC", 0);
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inDensity = 420;
    localOptions1.inTargetDensity = localContext1.getResources().getDisplayMetrics().densityDpi;
    Bitmap localBitmap1 = BitmapFactory.decodeByteArray(arrayOfByte1, 0, arrayOfByte1.length, localOptions1);
    if (localBitmap1 != null)
      this.p.setImageBitmap(localBitmap1);
    Context localContext2 = getContext();
    byte[] arrayOfByte2 = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCjITNKc0rQAAAJFJREFUeNrt2tENgCAMQEEwLuD+QzpC3cBURWLsvV+JNRfhi9YkSSpbP3sYETF0WO89s27m3KX6H1AeYL2wdrs5Y3/4ja/OTZ8B2f074h0z5zoDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/lr6rvDoK+xfmWsLNEmSVLUD47EiX/OuE8UAAAAASUVORK5CYII=", 0);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    localOptions2.inDensity = 420;
    localOptions2.inTargetDensity = localContext2.getResources().getDisplayMetrics().densityDpi;
    Bitmap localBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte2, 0, arrayOfByte2.length, localOptions2);
    if (localBitmap2 != null)
      this.o.setImageBitmap(localBitmap2);
    bj.a(this.o, -2013265920, -1, -1, this.g.c(1), this.g.c(4));
    bj.a(this.p, -2013265920, -1, -1, this.g.c(1), this.g.c(4));
    bj.a(this.q, -2013265920, -1, -1, this.g.c(1), this.g.c(4));
    this.d.setStarSize(this.g.c(12));
    this.m.setVisibility(8);
    addView(this.k);
    addView(this.j);
    addView(this.n);
    addView(this.f);
    addView(this.m);
    addView(this.h);
    addView(this.o);
    addView(this.p);
    addView(this.d);
    addView(this.l);
    addView(this.e);
    addView(this.c);
    this.h.addView(this.q);
    this.h.addView(this.i, localLayoutParams);
  }

  private void j()
  {
    this.B = 0;
    this.h.setVisibility(8);
    this.p.setVisibility(8);
    this.o.setVisibility(8);
    this.j.setVisibility(8);
  }

  private void k()
  {
    this.B = 1;
    this.h.setVisibility(8);
    this.p.setVisibility(0);
    this.o.setVisibility(8);
    this.j.setVisibility(0);
  }

  public final void a()
  {
    this.k.b();
  }

  public final void a(int paramInt)
  {
    this.k.a(paramInt);
  }

  public final void a(i parami)
  {
    this.k.setOnClickListener(null);
    this.n.setVisibility(8);
    f();
    j();
  }

  public final void a(boolean paramBoolean)
  {
    this.k.a(true);
  }

  public final void b(boolean paramBoolean)
  {
    av localav = this.n;
    if (paramBoolean)
    {
      localav.a(this.x, false);
      localav.setContentDescription("sound_off");
      return;
    }
    localav.a(this.w, false);
    localav.setContentDescription("sound_on");
  }

  public final boolean b()
  {
    return this.k.e();
  }

  public final void c()
  {
    this.k.i();
  }

  public final void d()
  {
    this.k.f();
  }

  public final void e()
  {
    this.m.setVisibility(8);
    this.B = 4;
    if (this.E)
    {
      this.h.setVisibility(0);
      this.j.setVisibility(0);
    }
    this.p.setVisibility(8);
    this.o.setVisibility(8);
  }

  public final void f()
  {
    this.f.setText(this.G);
    this.f.setTextSize(2, 16.0F);
    this.f.setVisibility(0);
    this.f.setTextColor(-1);
    this.f.setEnabled(true);
    this.f.setPadding(this.u, this.u, this.u, this.u);
    bj.a(this.f, -2013265920, -1, -1, this.g.c(1), this.g.c(4));
    this.I = true;
  }

  public final boolean g()
  {
    return this.k.d();
  }

  public final View getCloseButton()
  {
    return this.f;
  }

  public final df getPromoMediaView()
  {
    return this.k;
  }

  public final View getView()
  {
    return this;
  }

  public final void h()
  {
    if ((this.B == 0) || (this.B == 2))
    {
      k();
      this.k.g();
    }
  }

  public final void i()
  {
    this.k.h();
    this.h.setVisibility(8);
    this.p.setVisibility(8);
    if (this.B != 2)
      this.o.setVisibility(8);
  }

  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    boolean bool = true;
    if ((this.y > 0.0F) && (!isHardwareAccelerated()))
      bool = false;
    if (this.z != null)
      this.z.a(bool);
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    int i3 = this.k.getMeasuredWidth();
    int i4 = this.k.getMeasuredHeight();
    int i5 = i1 - i3 >> 1;
    int i6 = i2 - i4 >> 1;
    this.k.layout(i5, i6, i3 + i5, i4 + i6);
    this.j.layout(this.k.getLeft(), this.k.getTop(), this.k.getRight(), this.k.getBottom());
    int i7 = this.p.getMeasuredWidth();
    int i8 = this.p.getMeasuredHeight();
    this.p.layout((paramInt3 >> 1) - (i7 >> 1), (paramInt4 >> 1) - (i8 >> 1), (paramInt3 >> 1) + (i7 >> 1), (paramInt4 >> 1) + (i8 >> 1));
    int i9 = this.o.getMeasuredWidth();
    int i10 = this.o.getMeasuredHeight();
    this.o.layout((paramInt3 >> 1) - (i9 >> 1), (paramInt4 >> 1) - (i10 >> 1), (paramInt3 >> 1) + (i9 >> 1), (paramInt4 >> 1) + (i10 >> 1));
    int i11 = this.h.getMeasuredWidth();
    int i12 = this.h.getMeasuredHeight();
    this.h.layout((paramInt3 >> 1) - (i11 >> 1), (paramInt4 >> 1) - (i12 >> 1), (paramInt3 >> 1) + (i11 >> 1), (paramInt4 >> 1) + (i12 >> 1));
    this.f.layout(this.u, this.u, this.u + this.f.getMeasuredWidth(), this.u + this.f.getMeasuredHeight());
    if (i1 > i2)
    {
      int i16 = Math.max(this.e.getMeasuredHeight(), Math.max(this.c.getMeasuredHeight(), this.d.getMeasuredHeight()));
      this.e.layout(i1 - this.u - this.e.getMeasuredWidth(), i2 - this.u - this.e.getMeasuredHeight() - (i16 - this.e.getMeasuredHeight() >> 1), i1 - this.u, i2 - this.u - (i16 - this.e.getMeasuredHeight() >> 1));
      this.n.layout(this.e.getRight() - this.n.getMeasuredWidth() + this.n.getPadding(), this.k.getBottom() - (this.u << 1) - this.n.getMeasuredHeight() - i16 + this.n.getPadding(), this.e.getRight() + this.n.getPadding(), this.k.getBottom() - (this.u << 1) - i16 + this.n.getPadding());
      this.d.layout(this.e.getLeft() - this.u - this.d.getMeasuredWidth(), i2 - this.u - this.d.getMeasuredHeight() - (i16 - this.d.getMeasuredHeight() >> 1), this.e.getLeft() - this.u, i2 - this.u - (i16 - this.d.getMeasuredHeight() >> 1));
      this.l.layout(this.e.getLeft() - this.u - this.l.getMeasuredWidth(), i2 - this.u - this.l.getMeasuredHeight() - (i16 - this.l.getMeasuredHeight() >> 1), this.e.getLeft() - this.u, i2 - this.u - (i16 - this.l.getMeasuredHeight() >> 1));
      int i17 = Math.min(this.d.getLeft(), this.l.getLeft());
      this.c.layout(i17 - this.u - this.c.getMeasuredWidth(), i2 - this.u - this.c.getMeasuredHeight() - (i16 - this.c.getMeasuredHeight() >> 1), i17 - this.u, i2 - this.u - (i16 - this.c.getMeasuredHeight() >> 1));
      this.m.layout(this.u, i2 - this.u - this.m.getMeasuredHeight() - (i16 - this.m.getMeasuredHeight() >> 1), this.u + this.m.getMeasuredWidth(), i2 - this.u - (i16 - this.m.getMeasuredHeight() >> 1));
      return;
    }
    this.n.layout(this.k.getRight() - this.u - this.n.getMeasuredWidth() + this.n.getPadding(), this.k.getBottom() - this.u - this.n.getMeasuredHeight() + this.n.getPadding(), this.k.getRight() - this.u + this.n.getPadding(), this.k.getBottom() - this.u + this.n.getPadding());
    int i13 = this.u;
    int i14 = this.c.getMeasuredHeight() + this.d.getMeasuredHeight() + this.l.getMeasuredHeight() + this.e.getMeasuredHeight();
    int i15 = getBottom() - this.k.getBottom();
    if (i14 + i13 * 3 > i15)
      i13 = (i15 - i14) / 3;
    this.c.layout((i1 >> 1) - (this.c.getMeasuredWidth() >> 1), i13 + this.k.getBottom(), (i1 >> 1) + (this.c.getMeasuredWidth() >> 1), i13 + this.k.getBottom() + this.c.getMeasuredHeight());
    this.d.layout((i1 >> 1) - (this.d.getMeasuredWidth() >> 1), i13 + this.c.getBottom(), (i1 >> 1) + (this.d.getMeasuredWidth() >> 1), i13 + this.c.getBottom() + this.d.getMeasuredHeight());
    this.l.layout((i1 >> 1) - (this.l.getMeasuredWidth() >> 1), i13 + this.c.getBottom(), (i1 >> 1) + (this.l.getMeasuredWidth() >> 1), i13 + this.c.getBottom() + this.l.getMeasuredHeight());
    this.e.layout((i1 >> 1) - (this.e.getMeasuredWidth() >> 1), i13 + this.d.getBottom(), (i1 >> 1) + (this.e.getMeasuredWidth() >> 1), i13 + this.d.getBottom() + this.e.getMeasuredHeight());
    this.m.layout(this.u, this.k.getBottom() - this.u - this.m.getMeasuredHeight(), this.u + this.m.getMeasuredWidth(), this.k.getBottom() - this.u);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    this.n.measure(View.MeasureSpec.makeMeasureSpec(this.F, 1073741824), View.MeasureSpec.makeMeasureSpec(this.F, 1073741824));
    this.m.measure(View.MeasureSpec.makeMeasureSpec(this.F, 1073741824), View.MeasureSpec.makeMeasureSpec(this.F, 1073741824));
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.k.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
    int i3 = i1 - (this.u << 1);
    int i4 = i2 - (this.u << 1);
    this.f.measure(View.MeasureSpec.makeMeasureSpec(i3 / 2, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.o.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.p.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.h.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.d.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.j.measure(View.MeasureSpec.makeMeasureSpec(this.k.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.k.getMeasuredHeight(), 1073741824));
    this.e.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.c.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    this.l.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
    if (i1 > i2)
    {
      int i7 = this.e.getMeasuredWidth();
      int i8 = this.c.getMeasuredWidth();
      if (i7 + (Math.max(this.d.getMeasuredWidth(), this.l.getMeasuredWidth()) + (i8 + this.m.getMeasuredWidth())) + 3 * this.u > i3)
      {
        int i9 = i3 - this.m.getMeasuredWidth() - 3 * this.u;
        this.e.measure(View.MeasureSpec.makeMeasureSpec(i9 / 3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
        this.d.measure(View.MeasureSpec.makeMeasureSpec(i9 / 3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
        this.l.measure(View.MeasureSpec.makeMeasureSpec(i9 / 3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
        int i10 = i9 - this.e.getMeasuredWidth() - this.l.getMeasuredWidth() - this.d.getMeasuredWidth();
        this.c.measure(View.MeasureSpec.makeMeasureSpec(i10, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
      }
    }
    while (true)
    {
      setMeasuredDimension(i1, i2);
      return;
      int i5 = this.c.getMeasuredHeight() + this.d.getMeasuredHeight() + this.l.getMeasuredHeight() + this.e.getMeasuredHeight();
      int i6 = (i2 - this.k.getMeasuredHeight()) / 2;
      if (i5 + 3 * this.u > i6)
      {
        this.e.setPadding(this.u, this.u / 2, this.u, this.u / 2);
        this.e.measure(View.MeasureSpec.makeMeasureSpec(i3, -2147483648), View.MeasureSpec.makeMeasureSpec(i4, -2147483648));
      }
    }
  }

  public final void setBanner(i parami)
  {
    this.k.a(parami, 1);
    k localk = parami.I();
    if (localk == null)
      return;
    this.m.setMax(parami.A());
    this.E = localk.N();
    this.C = parami.E();
    this.D = parami.F();
    this.e.setText(parami.d());
    this.c.setText(parami.p());
    if ("store".equals(parami.m()))
      if (parami.n() > 0.0F)
      {
        this.d.setVisibility(0);
        this.d.setRating(parami.n());
        this.l.setVisibility(8);
        label126: this.G = localk.G();
        this.H = localk.T();
        this.f.setText(this.G);
        if (localk.P())
        {
          if (localk.O() <= 0.0F)
            break label452;
          this.C = localk.O();
          this.f.setEnabled(false);
          this.f.setTextColor(-3355444);
          this.f.setPadding(this.v, this.v, this.v, this.v);
          bj.a(this.f, -2013265920, -2013265920, -3355444, this.g.c(1), this.g.c(4));
          this.f.setTextSize(2, 12.0F);
        }
        label261: this.i.setText(localk.H());
        Context localContext = getContext();
        byte[] arrayOfByte = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4AMXCjM59gfMOgAAA59JREFUeNrtmkloFEEUhl/N6KgxriiJOHEXF4gENYlgRFA8uyAoCNGggl68CCJ6EQx6cCFqUFzABQQRMYh4EfSi4IJbiFERQVxRgxuRMWri5yE1UBY9yWh6Znq6+z+96a6ZV/8/tbz3qkRChAgRwiMAFgJngWgQyVcDHXTiFKCCRH4Df6MFKAkK+W0W+VfAxCAQV8A+i/wTIB4E8lHgpEX+LjA8COQHAM8t8o3ATKC338kXA59IjXbgEVAPLAb6+k2AHRbhVrrGV+AwMNVPIpx3INncjRi/gTPAWL+IcMIieBGIAXFgGXAU+OggRALY7ItIEdhvkTsNRIz3MWCp3h1sXAGK/RAHnLKIHUzRdgnwwmr7Epjsh3jggkWsNkXbQuC4Q8g8Ld9F6ANctYht7KL9GiNpAnib94ujDo5uaUIdwMo00uafhghNQL98F2EYcA9YlGb75daoOeqHnSHyj+23WyLMC1oRJQpct7LJXkETYSrwyxBhlQQNwAFrFKigCTDK2hXmBnEUnDMEOBZEARYaArwLogAF1jRIq4YQ8YsASqmEiNw2HpUHSgCNB4Y9KYgCPDXs8UEU4LNhF6bzhW7DRmCEiFTqjx+VUtc8LECrYfd3RQA9lxq03SgiZR4WIGbYv9yaAt8Me5DHp8DAFP3ukQDvDTvu8WxrnGG/dUUApdQrEUkYU2a8hwWYnGJH6PEu0GzYczwaCSoRqTIeNbkpwFXDnu/Rf79URJKnyz9E5Kab6i4wYuxvQKEHR8BO8+DE7R+PAu8MB6s9Rj4GvDH6tzYTTvZaVZeIhwSoMfr2HRiUCSd21aXGI+T7WRcu6jLp7Ijh6AMw1AMCmKXxtozeLgOKgC+Gw4ZcFiCB2fpWSRLbsuF0nXUYsSlH5EfqE+IknmblSo0+1m6wRKjOMvnB+jzQHPpl2ezAEOCx0YEOYH2WfMct8rlZkIES4LXVkXqgTwZ9Vjn43JrLFXgC8Mzq0H2g0mU/BTrSa7d8bfHCPlwE3HC41XWyp9fbdIS3Tt8fxprzq7wUivYGdmnithCXgRXpxgw67K4A9ljhdxKPgVK3+q5cFqJcRA6JyAyn1zpFfaBz9RZdtYnpStNonc/PEpEhDt9vE5FaEdmtlPrh2YoEEAEWpbje9j9o1aNrhOQbgOlAncNC2R0SwCVgZaZTb5VFMUpEpEJEpojIGBEZLJ21+zbpLGe3iMgTEXkoIneUUj8lRIgQIUKECJFJ/AEepzU1TSID5QAAAABJRU5ErkJggg==", 0);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inDensity = 420;
        localOptions.inTargetDensity = localContext.getResources().getDisplayMetrics().densityDpi;
        Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        if (localBitmap != null)
          this.q.setImageBitmap(localBitmap);
        if (!localk.K())
          break label486;
        this.k.i();
        j();
      }
    while (true)
    {
      this.y = localk.A();
      av localav = this.n;
      localav.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (dh.a(dh.this) != null)
            dh.a(dh.this).h();
        }
      });
      localav.a(this.w, false);
      localav.setContentDescription("sound_on");
      return;
      this.d.setVisibility(8);
      break;
      this.d.setVisibility(8);
      this.l.setVisibility(0);
      this.l.setText(parami.h());
      break label126;
      label452: this.f.setPadding(this.u, this.u, this.u, this.u);
      this.f.setVisibility(0);
      break label261;
      label486: k();
    }
  }

  public final void setClickArea(g paramg)
  {
    dp.a("Apply click area " + paramg.a() + " to view");
    if (paramg.o)
      setOnClickListener(this.b);
    if ((paramg.i) || (paramg.o))
    {
      this.e.setOnClickListener(this.b);
      if ((!paramg.c) && (!paramg.o))
        break label186;
      this.c.setOnClickListener(this.b);
      label94: if ((!paramg.g) && (!paramg.o))
        break label197;
      this.d.setOnClickListener(this.b);
      label119: if ((!paramg.l) && (!paramg.o))
        break label208;
      this.l.setOnClickListener(this.b);
    }
    while (true)
    {
      if ((paramg.n) || (paramg.o))
        setOnClickListener(this.b);
      return;
      this.e.setOnClickListener(null);
      this.e.setEnabled(false);
      break;
      label186: this.c.setOnClickListener(null);
      break label94;
      label197: this.d.setOnClickListener(null);
      break label119;
      label208: this.l.setOnClickListener(null);
    }
  }

  public final void setInterstitialPromoViewListener(dd.a parama)
  {
    this.z = parama;
  }

  public final void setMediaListener(h.a parama)
  {
    this.A = parama;
    this.k.setInterstitialPromoViewListener(parama);
  }

  public final void setTimeChanged(float paramFloat)
  {
    if ((!this.I) && (this.D) && (this.C > 0.0F) && (this.C >= paramFloat))
    {
      if (this.f.getVisibility() != 0)
        this.f.setVisibility(0);
      if (this.H != null)
      {
        int i1 = (int)Math.ceil(this.C - paramFloat);
        String str1 = String.valueOf(i1);
        if ((this.C > 9.0F) && (i1 <= 9))
          str1 = "0" + str1;
        String str2 = this.H.replace("%d", str1);
        this.f.setText(str2);
      }
    }
    if (this.m.getVisibility() != 0)
      this.m.setVisibility(0);
    this.m.setProgress(paramFloat / this.y);
    this.m.setDigit((int)Math.ceil(this.y - paramFloat));
  }

  private final class a
    implements View.OnClickListener
  {
    private a()
    {
    }

    public final void onClick(View paramView)
    {
      if (paramView == dh.b(dh.this))
      {
        if (dh.a(dh.this) != null)
          dh.a(dh.this).a();
        dh.c(dh.this);
      }
      do
      {
        do
        {
          return;
          if (paramView != dh.d(dh.this))
            break;
        }
        while ((!dh.e(dh.this).d()) || (dh.a(dh.this) == null));
        dh.a(dh.this).i();
        return;
      }
      while (paramView != dh.f(dh.this));
      if (dh.a(dh.this) != null)
      {
        if (!dh.this.b())
          break label133;
        dh.a(dh.this).j();
      }
      while (true)
      {
        dh.c(dh.this);
        return;
        label133: dh.a(dh.this).a();
      }
    }
  }

  final class b
    implements View.OnClickListener
  {
    b()
    {
    }

    public final void onClick(View paramView)
    {
      if ((paramView.isEnabled()) && (dh.g(dh.this) != null))
        dh.g(dh.this).a();
    }
  }

  private final class c
    implements Runnable
  {
    private c()
    {
    }

    public final void run()
    {
      if ((dh.h(dh.this) == 2) || (dh.h(dh.this) == 0))
        dh.c(dh.this);
    }
  }

  private final class d
    implements View.OnClickListener
  {
    private d()
    {
    }

    public final void onClick(View paramView)
    {
      dh.this.removeCallbacks(dh.i(dh.this));
      if (dh.h(dh.this) == 2)
      {
        dh.c(dh.this);
        return;
      }
      if ((dh.h(dh.this) == 0) || (dh.h(dh.this) == 3))
        dh.j(dh.this);
      dh.this.postDelayed(dh.i(dh.this), 4000L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dh
 * JD-Core Version:    0.6.2
 */