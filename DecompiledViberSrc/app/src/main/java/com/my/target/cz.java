package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.my.target.b.c.a.i;
import com.my.target.b.d.h.a;
import com.my.target.common.a.c;

@SuppressLint({"ViewConstructor"})
public final class cz extends RelativeLayout
  implements dc
{
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private static final int e = bj.a();
  private static final int f = bj.a();
  private final a g;
  private final ax h;
  private final dg i;
  private final df j;
  private final de k;
  private final av l;
  private final cx m;
  private final bj n;
  private final av o;
  private final Bitmap p;
  private final Bitmap q;
  private final int r;
  private final int s;
  private final int t;
  private final int u;
  private float v;
  private dd.a w;
  private h.a x;

  public cz(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    if ((0xF & getContext().getResources().getConfiguration().screenLayout) >= 3);
    for (boolean bool = true; ; bool = false)
    {
      this.n = bj.a(paramContext);
      this.h = new ax(paramContext);
      this.h.setId(e);
      this.i = new dg(paramContext, this.n, bool);
      this.i.setId(c);
      this.j = new df(paramContext, this.n, bool, paramBoolean);
      this.j.setId(b);
      this.l = new av(paramContext);
      this.l.setId(f);
      this.m = new cx(paramContext);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams1.addRule(3, b);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(14, -1);
      this.k = new de(paramContext, this.n);
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams3.addRule(12, -1);
      this.k.setLayoutParams(localLayoutParams3);
      this.k.setId(d);
      this.o = new av(paramContext);
      this.o.setId(a);
      this.p = com.my.target.b.e.b.a(this.n.c(28));
      this.q = com.my.target.b.e.b.b(this.n.c(28));
      this.g = new a();
      this.r = this.n.c(64);
      this.s = this.n.c(20);
      bj.a(this.h, "icon_image");
      bj.a(this.o, "sound_button");
      bj.a(this.i, "vertical_view");
      bj.a(this.j, "media_view");
      bj.a(this.k, "panel_view");
      bj.a(this.l, "close_button");
      bj.a(this.m, "progress_wheel");
      addView(this.k, 0);
      addView(this.h, 0);
      addView(this.i, 0, localLayoutParams1);
      addView(this.j, 0, localLayoutParams2);
      addView(this.o);
      addView(this.l);
      addView(this.m);
      this.t = this.n.c(28);
      this.u = this.n.c(10);
      return;
    }
  }

  public final void a()
  {
    this.j.b();
  }

  public final void a(int paramInt)
  {
    this.j.a(paramInt);
  }

  public final void a(i parami)
  {
    this.o.setVisibility(8);
    this.l.setVisibility(0);
    a(false);
    this.j.a(parami);
  }

  public final void a(boolean paramBoolean)
  {
    this.m.setVisibility(8);
    de localde = this.k;
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.o;
    localde.c(arrayOfView);
    this.j.a(paramBoolean);
  }

  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.o.a(this.q, false);
      this.o.setContentDescription("sound_off");
      return;
    }
    this.o.a(this.p, false);
    this.o.setContentDescription("sound_on");
  }

  public final boolean b()
  {
    return this.j.e();
  }

  public final void c()
  {
    de localde = this.k;
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.o;
    localde.b(arrayOfView);
    this.j.i();
  }

  public final void d()
  {
    de localde = this.k;
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.o;
    localde.b(arrayOfView);
    this.j.f();
  }

  public final void e()
  {
  }

  public final void f()
  {
    this.l.setVisibility(0);
  }

  public final boolean g()
  {
    return this.j.d();
  }

  public final View getCloseButton()
  {
    return this.l;
  }

  public final df getPromoMediaView()
  {
    return this.j;
  }

  public final View getView()
  {
    return this;
  }

  public final void h()
  {
    de localde = this.k;
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.o;
    localde.c(arrayOfView);
    this.j.g();
  }

  public final void i()
  {
    this.j.h();
  }

  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    boolean bool = true;
    if ((this.v > 0.0F) && (!isHardwareAccelerated()))
      bool = false;
    if (this.w != null)
      this.w.a(bool);
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.l.layout(paramInt3 - this.l.getMeasuredWidth(), 0, paramInt3, this.l.getMeasuredHeight());
    this.m.layout(this.u, this.u, this.m.getMeasuredWidth() + this.u, this.m.getMeasuredHeight() + this.u);
    if (paramInt4 > paramInt3)
    {
      if (this.o.getTranslationY() > 0.0F)
        this.o.setTranslationY(0.0F);
      setBackgroundColor(-1);
      int i3 = (paramInt3 - this.j.getMeasuredWidth()) / 2;
      this.j.layout(i3, 0, i3 + this.j.getMeasuredWidth(), this.j.getMeasuredHeight());
      this.i.layout(0, this.j.getBottom(), paramInt3, paramInt4);
      int i4 = this.s;
      if (this.j.getMeasuredHeight() != 0)
        i4 = this.j.getBottom() - this.h.getMeasuredHeight() / 2;
      this.h.layout(this.s, i4, this.s + this.h.getMeasuredWidth(), i4 + this.h.getMeasuredHeight());
      this.k.layout(0, 0, 0, 0);
      this.o.layout(paramInt3 - this.o.getMeasuredWidth(), this.j.getBottom() - this.o.getMeasuredHeight(), paramInt3, this.j.getBottom());
    }
    do
    {
      return;
      setBackgroundColor(-16777216);
      int i1 = (paramInt3 - this.j.getMeasuredWidth()) / 2;
      int i2 = (paramInt4 - this.j.getMeasuredHeight()) / 2;
      this.j.layout(i1, i2, i1 + this.j.getMeasuredWidth(), i2 + this.j.getMeasuredHeight());
      this.h.layout(0, 0, 0, 0);
      this.i.layout(0, 0, 0, 0);
      this.k.layout(0, paramInt4 - this.k.getMeasuredHeight(), paramInt3, paramInt4);
      this.o.layout(paramInt3 - this.o.getMeasuredWidth(), this.k.getTop() - this.o.getMeasuredHeight(), paramInt3, this.k.getTop());
    }
    while (!this.j.d());
    de localde = this.k;
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.o;
    localde.a(arrayOfView);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.o.measure(paramInt1, paramInt2);
    this.l.measure(paramInt1, paramInt2);
    this.m.measure(View.MeasureSpec.makeMeasureSpec(this.t, 1073741824), View.MeasureSpec.makeMeasureSpec(this.t, 1073741824));
    if (i2 > i1)
    {
      this.j.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      this.i.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - this.j.getMeasuredHeight(), -2147483648));
      this.h.measure(View.MeasureSpec.makeMeasureSpec(this.r, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
    }
    while (true)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      this.j.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
      this.k.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, -2147483648));
    }
  }

  public final void setBanner(i parami)
  {
    this.m.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(this.t, this.n.c(28));
    localLayoutParams1.addRule(9);
    localLayoutParams1.topMargin = this.n.c(10);
    localLayoutParams1.leftMargin = this.n.c(10);
    this.m.setLayoutParams(localLayoutParams1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(11);
    this.l.setVisibility(8);
    k localk1 = parami.I();
    if (localk1 == null)
      this.o.setVisibility(8);
    this.l.setLayoutParams(localLayoutParams2);
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (localWindowManager != null)
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i5;
    int i4;
    if (localDisplayMetrics.widthPixels + localDisplayMetrics.heightPixels >= 1280)
    {
      k localk2 = parami.I();
      if (localk2 == null)
        break label593;
      c localc = (c)localk2.F();
      if (localc == null)
        break label718;
      int i7 = localc.c();
      i5 = localc.b();
      i4 = i7;
    }
    while (true)
    {
      int i6;
      label240: boolean bool;
      label248: com.my.target.common.a.b localb2;
      label338: int i2;
      int i1;
      if ((i4 <= 0) || (i5 <= 0))
      {
        i6 = 0;
        if (i6 == 0)
          break label654;
        bool = true;
        this.k.a();
        this.k.setBanner(parami);
        this.i.a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, bool);
        this.i.setBanner(parami);
        this.j.a();
        this.j.a(parami, 0);
        com.my.target.common.a.b localb1 = parami.D();
        if ((localb1 == null) || (localb1.f() == null))
          break label660;
        this.l.a(localb1.f(), true);
        localb2 = parami.j();
        if (localb2 == null)
          break label709;
        i2 = localb2.b();
        i1 = localb2.c();
      }
      while (true)
      {
        RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams3.bottomMargin = this.n.c(4);
        if ((i2 != 0) && (i1 != 0))
        {
          int i3 = (int)(i1 / i2 * this.n.c(64));
          localLayoutParams3.width = this.r;
          localLayoutParams3.height = i3;
          if (!bool)
            localLayoutParams3.bottomMargin = (-i3 / 2);
        }
        localLayoutParams3.addRule(8, b);
        if (Build.VERSION.SDK_INT >= 17)
          localLayoutParams3.setMarginStart(this.n.c(20));
        while (true)
        {
          this.h.setLayoutParams(localLayoutParams3);
          if (localb2 != null)
            this.h.setImageBitmap(localb2.f());
          if ((localk1 != null) && (localk1.K()))
          {
            this.j.i();
            post(new Runnable()
            {
              public final void run()
              {
                de localde = cz.b(cz.this);
                View[] arrayOfView = new View[1];
                arrayOfView[0] = cz.a(cz.this);
                localde.a(arrayOfView);
              }
            });
          }
          if (localk1 != null)
            this.v = localk1.A();
          av localav = this.o;
          localav.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              if (cz.c(cz.this) != null)
                cz.c(cz.this).h();
            }
          });
          localav.a(this.p, false);
          localav.setContentDescription("sound_on");
          return;
          label593: com.my.target.common.a.b localb3 = parami.l();
          if (localb3 == null)
            break label718;
          i4 = localb3.c();
          i5 = localb3.b();
          break;
          if ((i4 > i5) || (i5 / i4 < 1.4F))
          {
            i6 = 1;
            break label240;
          }
          i6 = 0;
          break label240;
          label654: bool = false;
          break label248;
          label660: Bitmap localBitmap = ap.a(this.n.c(28));
          if (localBitmap == null)
            break label338;
          this.l.a(localBitmap, false);
          break label338;
          localLayoutParams3.leftMargin = this.n.c(20);
        }
        label709: i1 = 0;
        i2 = 0;
      }
      label718: i4 = 0;
      i5 = 0;
    }
  }

  public final void setClickArea(g paramg)
  {
    dp.a("Apply click area " + paramg.a() + " to view");
    if ((paramg.e) || (paramg.o))
      this.h.setOnClickListener(this.g);
    while (true)
    {
      this.i.a(paramg, this.g);
      this.k.a(paramg, this.g);
      if ((!paramg.f) && (!paramg.o))
        break;
      this.j.getClickableLayout().setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (cz.d(cz.this) != null)
            cz.d(cz.this).a();
        }
      });
      return;
      this.h.setOnClickListener(null);
    }
    this.j.getClickableLayout().setOnClickListener(null);
    this.j.getClickableLayout().setEnabled(false);
  }

  public final void setInterstitialPromoViewListener(dd.a parama)
  {
    this.w = parama;
  }

  public final void setMediaListener(h.a parama)
  {
    this.x = parama;
    this.j.setInterstitialPromoViewListener(parama);
    this.j.c();
  }

  public final void setTimeChanged(float paramFloat)
  {
    this.m.setVisibility(0);
    if (this.v > 0.0F)
      this.m.setProgress(paramFloat / this.v);
    this.m.setDigit((int)(1.0F + (this.v - paramFloat)));
  }

  final class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public final void onClick(View paramView)
    {
      if ((paramView.isEnabled()) && (cz.d(cz.this) != null))
        cz.d(cz.this).a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cz
 * JD-Core Version:    0.6.2
 */