package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
public final class cn extends RelativeLayout
  implements View.OnTouchListener, cm
{
  private static final int a = bj.a();
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private final RelativeLayout e;
  private final ax f;
  private final TextView g;
  private final TextView h;
  private final Button i;
  private final ax j;
  private final FrameLayout k;
  private final bj l;
  private final LinearLayout m;
  private final TextView n;
  private final ay o;
  private final ax p;
  private final FrameLayout q;
  private final at r;
  private final HashMap<View, Boolean> s = new HashMap();
  private final int t;
  private final int u;
  private int v;
  private int w;
  private View.OnClickListener x;

  public cn(Context paramContext)
  {
    this(paramContext, (byte)0);
  }

  private cn(Context paramContext, byte paramByte)
  {
    super(paramContext, null);
    this.e = new RelativeLayout(paramContext);
    this.f = new ax(paramContext);
    this.g = new TextView(paramContext);
    this.h = new TextView(paramContext);
    this.i = new Button(paramContext);
    this.j = new ax(paramContext);
    this.k = new FrameLayout(paramContext);
    this.l = bj.a(paramContext);
    this.m = new LinearLayout(paramContext);
    this.n = new TextView(paramContext);
    this.o = new ay(paramContext);
    this.p = new ax(paramContext);
    this.q = new FrameLayout(paramContext);
    this.r = new at(paramContext);
    bj.a(this, "ad_view");
    bj.a(this.f, "icon_image");
    bj.a(this.g, "title_text");
    bj.a(this.h, "domain_text");
    bj.a(this.i, "cta_button");
    bj.a(this.j, "main_image");
    bj.a(this.k, "icon_layout");
    bj.a(this.n, "votes_text");
    bj.a(this.o, "rating_view");
    bj.a(this.p, "banner_image");
    bj.a(this.r, "age_border");
    bj localbj = bj.a(paramContext);
    this.t = localbj.c(250);
    this.u = localbj.c(300);
    Context localContext = getContext();
    if (localContext != null)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(localContext);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, this.l.c(42));
      localLayoutParams1.leftMargin = this.l.c(2);
      localLayoutParams1.rightMargin = this.l.c(2);
      this.e.setId(a);
      this.e.setLayoutParams(localLayoutParams1);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(this.l.c(38), this.l.c(38));
      localLayoutParams2.rightMargin = this.l.c(2);
      this.k.setId(b);
      this.k.setLayoutParams(localLayoutParams2);
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams3.gravity = 17;
      this.f.setLayoutParams(localLayoutParams3);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams4.addRule(1, b);
      localRelativeLayout.setLayoutParams(localLayoutParams4);
      this.g.setTextSize(18.0F);
      this.g.setMaxLines(1);
      this.g.setEllipsize(TextUtils.TruncateAt.END);
      this.g.setTransformationMethod(null);
      this.g.setIncludeFontPadding(false);
      this.g.setId(d);
      this.h.setTextSize(14.0F);
      this.h.setMaxLines(1);
      this.h.setEllipsize(TextUtils.TruncateAt.END);
      this.h.setTransformationMethod(null);
      this.h.setIncludeFontPadding(false);
      RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams5.addRule(3, d);
      this.h.setLayoutParams(localLayoutParams5);
      this.i.setId(c);
      this.i.setTextSize(20.0F);
      this.i.setPadding(this.l.c(4), 0, this.l.c(4), 0);
      this.i.setTransformationMethod(null);
      this.i.setLines(1);
      this.i.setEllipsize(TextUtils.TruncateAt.END);
      RelativeLayout.LayoutParams localLayoutParams6 = new RelativeLayout.LayoutParams(-1, this.l.c(36));
      localLayoutParams6.leftMargin = this.l.c(2);
      localLayoutParams6.rightMargin = this.l.c(2);
      localLayoutParams6.bottomMargin = this.l.c(2);
      localLayoutParams6.addRule(12, -1);
      getCtaButton().setLayoutParams(localLayoutParams6);
      if (Build.VERSION.SDK_INT >= 21)
        getCtaButton().setStateListAnimator(null);
      FrameLayout localFrameLayout = new FrameLayout(localContext);
      RelativeLayout.LayoutParams localLayoutParams7 = new RelativeLayout.LayoutParams(this.l.c(296), this.l.c(168));
      localLayoutParams7.addRule(3, a);
      localLayoutParams7.addRule(2, c);
      localLayoutParams7.addRule(14, -1);
      localLayoutParams7.bottomMargin = this.l.c(2);
      localFrameLayout.setLayoutParams(localLayoutParams7);
      FrameLayout.LayoutParams localLayoutParams8 = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams8.gravity = 17;
      this.j.setLayoutParams(localLayoutParams8);
      this.n.setTransformationMethod(null);
      this.n.setTextSize(14.0F);
      this.n.setIncludeFontPadding(false);
      RelativeLayout.LayoutParams localLayoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams9.addRule(3, d);
      this.m.setLayoutParams(localLayoutParams9);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.l.c(73), this.l.c(10));
      localLayoutParams.topMargin = this.l.c(2);
      localLayoutParams.bottomMargin = this.l.c(2);
      localLayoutParams.rightMargin = this.l.c(2);
      localLayoutParams.gravity = 48;
      this.o.setLayoutParams(localLayoutParams);
      RelativeLayout.LayoutParams localLayoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams10.addRule(11, -1);
      localLayoutParams10.rightMargin = this.l.c(2);
      this.r.setLayoutParams(localLayoutParams10);
      this.r.setPadding(this.l.c(2), this.l.c(4), 0, 0);
      this.r.setLines(1);
      this.r.setTextSize(2, 12.0F);
      RelativeLayout.LayoutParams localLayoutParams11 = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams11.addRule(13, -1);
      addView(this.p, localLayoutParams11);
      addView(this.q, -1, -1);
      this.m.addView(this.o);
      this.m.addView(this.n);
      localRelativeLayout.addView(this.g);
      localRelativeLayout.addView(this.h);
      localRelativeLayout.addView(this.m);
      this.k.addView(this.f);
      this.e.addView(this.k);
      this.e.addView(localRelativeLayout);
      addView(this.e);
      addView(getCtaButton());
      localFrameLayout.addView(this.j);
      addView(localFrameLayout);
      addView(this.r);
    }
  }

  public final View a()
  {
    return this;
  }

  public final void a(int paramInt1, int paramInt2)
  {
    this.v = paramInt1;
    this.w = paramInt2;
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(g paramg, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    dp.a("Apply click area " + paramg.a() + " to view");
    this.x = paramOnClickListener;
    int i1;
    boolean bool1;
    label144: boolean bool2;
    label184: boolean bool3;
    label224: boolean bool4;
    label264: boolean bool5;
    label304: boolean bool6;
    label344: boolean bool7;
    label384: HashMap localHashMap8;
    if ((paramBoolean) || (paramg.o))
    {
      i1 = 1;
      setOnTouchListener(this);
      this.g.setOnTouchListener(this);
      this.f.setOnTouchListener(this);
      this.j.setOnTouchListener(this);
      this.o.setOnTouchListener(this);
      this.n.setOnTouchListener(this);
      this.h.setOnTouchListener(this);
      this.r.setOnTouchListener(this);
      this.i.setOnTouchListener(this);
      HashMap localHashMap1 = this.s;
      TextView localTextView1 = this.g;
      if ((!paramg.c) && (i1 == 0))
        break label480;
      bool1 = true;
      localHashMap1.put(localTextView1, Boolean.valueOf(bool1));
      HashMap localHashMap2 = this.s;
      ax localax1 = this.f;
      if ((!paramg.e) && (i1 == 0))
        break label486;
      bool2 = true;
      localHashMap2.put(localax1, Boolean.valueOf(bool2));
      HashMap localHashMap3 = this.s;
      ax localax2 = this.j;
      if ((!paramg.f) && (i1 == 0))
        break label492;
      bool3 = true;
      localHashMap3.put(localax2, Boolean.valueOf(bool3));
      HashMap localHashMap4 = this.s;
      ay localay = this.o;
      if ((!paramg.g) && (i1 == 0))
        break label498;
      bool4 = true;
      localHashMap4.put(localay, Boolean.valueOf(bool4));
      HashMap localHashMap5 = this.s;
      TextView localTextView2 = this.n;
      if ((!paramg.h) && (i1 == 0))
        break label504;
      bool5 = true;
      localHashMap5.put(localTextView2, Boolean.valueOf(bool5));
      HashMap localHashMap6 = this.s;
      at localat = this.r;
      if ((!paramg.j) && (i1 == 0))
        break label510;
      bool6 = true;
      localHashMap6.put(localat, Boolean.valueOf(bool6));
      HashMap localHashMap7 = this.s;
      TextView localTextView3 = this.h;
      if ((!paramg.l) && (i1 == 0))
        break label516;
      bool7 = true;
      localHashMap7.put(localTextView3, Boolean.valueOf(bool7));
      localHashMap8 = this.s;
      if ((!paramg.n) && (i1 == 0))
        break label522;
    }
    label516: label522: for (boolean bool8 = true; ; bool8 = false)
    {
      localHashMap8.put(this, Boolean.valueOf(bool8));
      HashMap localHashMap9 = this.s;
      Button localButton = this.i;
      boolean bool9;
      if (!paramg.i)
      {
        bool9 = false;
        if (i1 == 0);
      }
      else
      {
        bool9 = true;
      }
      localHashMap9.put(localButton, Boolean.valueOf(bool9));
      return;
      i1 = 0;
      break;
      label480: bool1 = false;
      break label144;
      label486: bool2 = false;
      break label184;
      label492: bool3 = false;
      break label224;
      label498: bool4 = false;
      break label264;
      label504: bool5 = false;
      break label304;
      label510: bool6 = false;
      break label344;
      bool7 = false;
      break label384;
    }
  }

  public final void a(i parami)
  {
    if ("teaser".equals(parami.r()))
    {
      View[] arrayOfView2 = new View[3];
      arrayOfView2[0] = this.k;
      arrayOfView2[1] = this.q;
      arrayOfView2[2] = this;
      for (int i2 = 0; i2 < 3; i2++)
        bj.a(arrayOfView2[i2], this.v, this.w);
      this.p.setVisibility(8);
      this.q.setVisibility(8);
      if ("store".equals(parami.m()))
      {
        this.h.setVisibility(8);
        this.m.setVisibility(0);
        if (parami.n() > 0.0F)
        {
          this.o.setVisibility(0);
          if (parami.t() > 0)
            this.n.setVisibility(0);
        }
        while (true)
        {
          this.h.setVisibility(8);
          return;
          this.n.setVisibility(8);
          continue;
          this.o.setVisibility(8);
          this.n.setVisibility(8);
        }
      }
      this.h.setVisibility(0);
      this.m.setVisibility(8);
      return;
    }
    View[] arrayOfView1 = new View[3];
    arrayOfView1[0] = this.k;
    arrayOfView1[1] = this.q;
    arrayOfView1[2] = this;
    for (int i1 = 0; i1 < 3; i1++)
      bj.a(arrayOfView1[i1], 0, bj.b(this.w));
    this.r.setVisibility(8);
    this.e.setVisibility(8);
    getCtaButton().setVisibility(8);
    this.j.setVisibility(8);
    this.q.setVisibility(0);
    this.p.setVisibility(0);
  }

  public final void b()
  {
  }

  public final void c()
  {
  }

  public final at getAgeRestrictionsView()
  {
    return this.r;
  }

  public final ax getBannerImage()
  {
    return this.p;
  }

  public final Button getCtaButton()
  {
    return this.i;
  }

  public final TextView getDescriptionTextView()
  {
    return null;
  }

  public final TextView getDisclaimerTextView()
  {
    return null;
  }

  public final TextView getDomainTextView()
  {
    return this.h;
  }

  public final ax getIconImage()
  {
    return this.f;
  }

  public final ax getMainImage()
  {
    return this.j;
  }

  public final TextView getRatingTextView()
  {
    return this.n;
  }

  public final ay getStarsRatingView()
  {
    return this.o;
  }

  public final TextView getTitleTextView()
  {
    return this.g;
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.u, 1073741824), View.MeasureSpec.makeMeasureSpec(this.t, 1073741824));
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return true;
      if (!this.s.containsKey(paramView))
        return false;
      if (!((Boolean)this.s.get(paramView)).booleanValue())
        return true;
      if (paramView == this.i)
      {
        paramView.setPressed(true);
      }
      else
      {
        setBackgroundColor(this.w);
        this.f.setBackgroundColor(this.v);
        continue;
        if (!this.s.containsKey(paramView))
          return false;
        if (!((Boolean)this.s.get(paramView)).booleanValue())
          return true;
        if (paramView == this.i)
          paramView.setPressed(false);
        while (true)
        {
          performClick();
          if (this.x == null)
            break;
          this.x.onClick(paramView);
          break;
          setBackgroundColor(this.v);
          this.f.setBackgroundColor(this.v);
        }
        if (paramView == this.i)
        {
          paramView.setPressed(false);
        }
        else
        {
          setBackgroundColor(this.v);
          this.f.setBackgroundColor(this.v);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cn
 * JD-Core Version:    0.6.2
 */