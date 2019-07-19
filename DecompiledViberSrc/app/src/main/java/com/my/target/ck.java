package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewFlipper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class ck extends RelativeLayout
  implements View.OnTouchListener, cm
{
  static long a = 4000L;
  private static final int b = bj.a();
  private static final int c = bj.a();
  private static final int d = bj.a();
  private static final int e = bj.a();
  private static final int f = bj.a();
  private final int A;
  private final int B;
  private final int C;
  private final int D;
  private final int E;
  private final int F;
  private int G;
  private int H;
  private int I;
  private boolean J;
  private View.OnClickListener K;
  private boolean L;
  private boolean M;
  private final at g;
  private final TextView h;
  private final TextView i;
  private final TextView j;
  private final LinearLayout k;
  private final Button l;
  private final ay m;
  private final ax n;
  private final RelativeLayout o;
  private final RelativeLayout p;
  private final ViewFlipper q;
  private final bj r;
  private final FrameLayout s;
  private final TextView t;
  private final TextView u;
  private final a v;
  private final HashMap<View, Boolean> w = new HashMap();
  private final int x;
  private final float y;
  private final int z;

  public ck(String paramString, Context paramContext)
  {
    this(paramString, paramContext, (byte)0);
  }

  private ck(String paramString, Context paramContext, byte paramByte)
  {
    super(paramContext, null);
    this.r = bj.a(paramContext);
    this.n = new ax(paramContext);
    this.s = new FrameLayout(paramContext);
    this.q = new ViewFlipper(paramContext);
    this.k = new LinearLayout(paramContext);
    this.l = new Button(paramContext);
    this.h = new TextView(paramContext);
    this.g = new at(paramContext);
    this.m = new ay(paramContext);
    this.i = new TextView(paramContext);
    this.j = new TextView(paramContext);
    this.o = new RelativeLayout(paramContext);
    this.p = new RelativeLayout(paramContext);
    this.t = new TextView(paramContext);
    this.u = new TextView(paramContext);
    bj.a(this, "ad_view");
    bj.a(this.n, "icon_image");
    bj.a(this.s, "icon_layout");
    bj.a(this.l, "cta_button");
    bj.a(this.h, "title_text");
    bj.a(this.g, "age_border");
    bj.a(this.m, "rating_view");
    bj.a(this.i, "votes_text");
    bj.a(this.j, "domain_text");
    bj.a(this.t, "description_text");
    bj.a(this.u, "disclaimer_text");
    if ("standard_728x90".equals(paramString))
    {
      this.x = 20;
      this.A = 24;
      this.z = 32;
      this.B = 16;
      this.C = 24;
      this.D = 24;
      this.E = this.r.c(180);
    }
    for (this.F = this.r.c(270); ; this.F = this.r.c(100))
    {
      this.y = 1.2F;
      this.n.setId(c);
      this.l.setId(e);
      this.l.setPadding(this.r.c(8), this.r.c(8), this.r.c(8), this.r.c(8));
      this.l.setMinimumWidth(this.E);
      this.l.setTextSize(2, this.z);
      this.l.setMaxWidth(this.F);
      this.l.setLines(1);
      this.l.setEllipsize(TextUtils.TruncateAt.END);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams1.addRule(11, -1);
      this.l.setLayoutParams(localLayoutParams1);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(0, e);
      localLayoutParams2.addRule(1, c);
      this.q.setLayoutParams(localLayoutParams2);
      ViewFlipper localViewFlipper1 = this.q;
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
      localTranslateAnimation1.setDuration(400L);
      localTranslateAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
      localViewFlipper1.setInAnimation(localTranslateAnimation1);
      ViewFlipper localViewFlipper2 = this.q;
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, -1.0F);
      localTranslateAnimation2.setDuration(400L);
      localTranslateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
      localViewFlipper2.setOutAnimation(localTranslateAnimation2);
      this.k.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams3.weight = 1.0F;
      this.o.setLayoutParams(localLayoutParams3);
      this.o.setGravity(16);
      this.h.setId(d);
      this.h.setMaxLines(1);
      this.h.setHorizontallyScrolling(true);
      this.h.setSingleLine(true);
      this.h.setMaxEms(25);
      this.h.setTextSize(2, this.A);
      this.h.setEllipsize(TextUtils.TruncateAt.END);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams4.rightMargin = this.r.c(4);
      localLayoutParams4.leftMargin = this.r.c(4);
      localLayoutParams4.topMargin = this.r.c(2);
      localLayoutParams4.addRule(15);
      this.h.setLayoutParams(localLayoutParams4);
      this.g.setId(b);
      this.g.a(1, -7829368);
      this.g.setGravity(17);
      this.g.setTextSize(2, this.B);
      this.g.setPadding(this.r.c(2), this.r.c(4), 0, 0);
      this.g.setLines(1);
      RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams5.addRule(15);
      localLayoutParams5.topMargin = this.r.c(2);
      localLayoutParams5.addRule(1, d);
      this.g.setLayoutParams(localLayoutParams5);
      LinearLayout.LayoutParams localLayoutParams6 = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams6.weight = 1.0F;
      this.p.setLayoutParams(localLayoutParams6);
      this.m.setId(f);
      this.m.setStarSize(this.r.c(this.C));
      RelativeLayout.LayoutParams localLayoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams7.leftMargin = this.r.c(4);
      localLayoutParams7.rightMargin = this.r.c(4);
      localLayoutParams7.topMargin = this.r.c(4);
      localLayoutParams7.bottomMargin = this.r.c(2);
      localLayoutParams7.addRule(15);
      this.m.setLayoutParams(localLayoutParams7);
      RelativeLayout.LayoutParams localLayoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams8.addRule(1, f);
      localLayoutParams8.addRule(15);
      this.i.setTextSize(2, this.D);
      this.i.setLayoutParams(localLayoutParams8);
      RelativeLayout.LayoutParams localLayoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams9.leftMargin = this.r.c(4);
      this.j.setTextSize(2, this.D);
      this.j.setLayoutParams(localLayoutParams9);
      new RelativeLayout.LayoutParams(-2, -2).addRule(15);
      this.l.setTransformationMethod(null);
      addView(this.n);
      addView(this.s);
      addView(this.l);
      this.p.addView(this.m);
      this.p.addView(this.i);
      this.p.addView(this.j);
      this.o.addView(this.h);
      this.o.addView(this.g);
      this.k.addView(this.o);
      this.k.addView(this.p);
      this.q.addView(this.k);
      addView(this.q);
      this.v = new a((byte)0);
      return;
      this.x = 15;
      this.A = 16;
      this.z = 20;
      this.B = 10;
      this.C = 12;
      this.D = 16;
      this.E = this.r.c(50);
    }
  }

  public final View a()
  {
    return this;
  }

  public final void a(int paramInt1, int paramInt2)
  {
    this.G = paramInt1;
    this.H = paramInt2;
    this.n.setBackgroundColor(this.G);
    setBackgroundColor(this.G);
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(g paramg, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    dp.a("Apply click area " + paramg.a() + " to view");
    int i1;
    boolean bool1;
    label136: boolean bool2;
    label176: boolean bool3;
    label216: boolean bool4;
    label256: boolean bool5;
    label296: boolean bool6;
    label336: boolean bool7;
    label370: boolean bool8;
    if ((paramBoolean) || (paramg.o))
    {
      i1 = 1;
      this.K = paramOnClickListener;
      setOnTouchListener(this);
      this.h.setOnTouchListener(this);
      this.n.setOnTouchListener(this);
      this.m.setOnTouchListener(this);
      this.i.setOnTouchListener(this);
      this.j.setOnTouchListener(this);
      this.g.setOnTouchListener(this);
      this.t.setOnTouchListener(this);
      HashMap localHashMap1 = this.w;
      TextView localTextView1 = this.h;
      if ((!paramg.c) && (i1 == 0))
        break label459;
      bool1 = true;
      localHashMap1.put(localTextView1, Boolean.valueOf(bool1));
      HashMap localHashMap2 = this.w;
      ax localax = this.n;
      if ((!paramg.e) && (i1 == 0))
        break label465;
      bool2 = true;
      localHashMap2.put(localax, Boolean.valueOf(bool2));
      HashMap localHashMap3 = this.w;
      ay localay = this.m;
      if ((!paramg.g) && (i1 == 0))
        break label471;
      bool3 = true;
      localHashMap3.put(localay, Boolean.valueOf(bool3));
      HashMap localHashMap4 = this.w;
      TextView localTextView2 = this.i;
      if ((!paramg.h) && (i1 == 0))
        break label477;
      bool4 = true;
      localHashMap4.put(localTextView2, Boolean.valueOf(bool4));
      HashMap localHashMap5 = this.w;
      at localat = this.g;
      if ((!paramg.j) && (i1 == 0))
        break label483;
      bool5 = true;
      localHashMap5.put(localat, Boolean.valueOf(bool5));
      HashMap localHashMap6 = this.w;
      TextView localTextView3 = this.j;
      if ((!paramg.l) && (i1 == 0))
        break label489;
      bool6 = true;
      localHashMap6.put(localTextView3, Boolean.valueOf(bool6));
      HashMap localHashMap7 = this.w;
      if ((!paramg.n) && (i1 == 0))
        break label495;
      bool7 = true;
      localHashMap7.put(this, Boolean.valueOf(bool7));
      if ((!paramg.n) && (i1 == 0))
        break label501;
      bool8 = true;
      label397: this.L = bool8;
      if ((!paramg.d) && (i1 == 0))
        break label507;
    }
    label459: label465: label471: label477: label483: label489: label495: label501: label507: for (boolean bool9 = true; ; bool9 = false)
    {
      this.M = bool9;
      if ((!paramg.i) && (i1 == 0))
        break label513;
      this.l.setOnClickListener(paramOnClickListener);
      this.l.setEnabled(true);
      return;
      i1 = 0;
      break;
      bool1 = false;
      break label136;
      bool2 = false;
      break label176;
      bool3 = false;
      break label216;
      bool4 = false;
      break label256;
      bool5 = false;
      break label296;
      bool6 = false;
      break label336;
      bool7 = false;
      break label370;
      bool8 = false;
      break label397;
    }
    label513: this.l.setOnClickListener(null);
    this.l.setEnabled(false);
  }

  public final void a(i parami)
  {
    String str = parami.r();
    if ("teaser".equals(str))
    {
      this.J = true;
      bj.a(this, this.G, this.H);
      bj.a(this.q, this.G, this.H);
      bj.a(this.s, 0, bj.b(this.H));
      this.l.setVisibility(0);
      this.q.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
      this.n.setPadding(this.r.c(2), this.r.c(2), this.r.c(2), this.r.c(2));
      this.n.setLayoutParams(localLayoutParams2);
      this.n.setMaxWidth(this.F);
      this.s.setLayoutParams(localLayoutParams2);
      localLayoutParams2.addRule(9, -1);
      localLayoutParams2.addRule(15, -1);
      this.n.setLayoutParams(localLayoutParams2);
      if (!"store".equalsIgnoreCase(parami.m()))
        break label370;
      if (parami.n() <= 0.0F)
        break label349;
      this.m.setVisibility(0);
      if (parami.t() <= 0)
        break label337;
      this.i.setVisibility(0);
    }
    while (true)
    {
      this.j.setVisibility(8);
      return;
      if (!"banner".equals(str))
        break;
      this.J = false;
      bj.a(this, 0, bj.b(this.H));
      this.l.setVisibility(8);
      this.q.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams1.addRule(14);
      this.n.setPadding(0, 0, 0, 0);
      this.n.setLayoutParams(localLayoutParams1);
      this.n.setMaxWidth(0);
      this.s.setLayoutParams(localLayoutParams1);
      break;
      label337: this.i.setVisibility(8);
      continue;
      label349: this.m.setVisibility(8);
      this.i.setVisibility(8);
    }
    label370: this.j.setVisibility(0);
    this.m.setVisibility(8);
    this.i.setVisibility(8);
  }

  public final void b()
  {
    removeCallbacks(this.v);
    postDelayed(this.v, a);
  }

  public final void c()
  {
    this.q.stopFlipping();
    removeCallbacks(this.v);
  }

  public final at getAgeRestrictionsView()
  {
    return this.g;
  }

  public final ax getBannerImage()
  {
    return this.n;
  }

  public final Button getCtaButton()
  {
    return this.l;
  }

  public final TextView getDescriptionTextView()
  {
    return this.t;
  }

  public final TextView getDisclaimerTextView()
  {
    return this.u;
  }

  public final TextView getDomainTextView()
  {
    return this.j;
  }

  public final ax getIconImage()
  {
    return this.n;
  }

  public final ax getMainImage()
  {
    return null;
  }

  public final TextView getRatingTextView()
  {
    return this.i;
  }

  public final ay getStarsRatingView()
  {
    return this.m;
  }

  public final TextView getTitleTextView()
  {
    return this.h;
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i3 = this.n.getMeasuredWidth();
    int i4 = this.l.getMeasuredWidth();
    if ((this.J) && (i1 != 0) && (this.I != i1) && (i3 > 0) && (i4 > 0))
    {
      if (this.I != 0)
      {
        if (this.q.getChildCount() > 1)
          this.q.setDisplayedChild(0);
        while (this.q.getChildCount() > 1)
          this.q.removeViewAt(-1 + this.q.getChildCount());
      }
      this.I = i1;
      int i5 = i1 - this.q.getPaddingRight() - this.q.getPaddingLeft() - i3 - i4;
      CharSequence localCharSequence1 = this.g.getText();
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        int i6 = i5 - localCharSequence1.length() * this.r.c(10) - this.r.c(10);
        this.h.setMaxWidth(i6);
      }
      CharSequence localCharSequence2 = this.t.getText();
      boolean bool = TextUtils.isEmpty(localCharSequence2);
      LinearLayout localLinearLayout = null;
      if (!bool)
      {
        Paint localPaint1 = new Paint();
        localPaint1.setTextSize(this.r.d(this.x));
        localPaint1.setTypeface(this.t.getTypeface());
        Iterator localIterator1 = cl.a(localCharSequence2.toString(), i5, localPaint1).iterator();
        while (localIterator1.hasNext())
        {
          String str2 = (String)localIterator1.next();
          if ((localLinearLayout == null) || (localLinearLayout.getChildCount() > 1))
          {
            ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(-1, i2);
            localLinearLayout = new LinearLayout(getContext());
            localLinearLayout.setGravity(16);
            localLinearLayout.setOrientation(1);
            localLinearLayout.setLayoutParams(localLayoutParams2);
            localLinearLayout.setBackgroundColor(0);
            this.q.addView(localLinearLayout);
          }
          TextView localTextView2 = new TextView(getContext());
          this.w.put(localTextView2, Boolean.valueOf(this.M));
          localTextView2.setOnTouchListener(this);
          this.w.put(localLinearLayout, Boolean.valueOf(this.L));
          localLinearLayout.setOnTouchListener(this);
          localTextView2.setGravity(16);
          localTextView2.setTextSize(2, this.x);
          localTextView2.setLineSpacing(0.0F, this.y);
          localTextView2.setLines(1);
          localTextView2.setTextColor(this.t.getCurrentTextColor());
          localTextView2.setTypeface(this.t.getTypeface());
          localTextView2.setText(str2);
          localLinearLayout.addView(localTextView2);
        }
      }
      CharSequence localCharSequence3 = this.u.getText();
      if (!TextUtils.isEmpty(localCharSequence3))
      {
        Paint localPaint2 = new Paint();
        localPaint2.setTextSize(this.r.d(this.x));
        localPaint2.setTypeface(this.u.getTypeface());
        Iterator localIterator2 = cl.a(localCharSequence3.toString(), i5, localPaint2).iterator();
        while (localIterator2.hasNext())
        {
          String str1 = (String)localIterator2.next();
          if ((localLinearLayout == null) || (localLinearLayout.getChildCount() > 1))
          {
            ViewGroup.LayoutParams localLayoutParams1 = new ViewGroup.LayoutParams(-1, i2);
            localLinearLayout = new LinearLayout(getContext());
            localLinearLayout.setGravity(16);
            localLinearLayout.setOrientation(1);
            localLinearLayout.setLayoutParams(localLayoutParams1);
            this.q.addView(localLinearLayout);
          }
          TextView localTextView1 = new TextView(getContext());
          localTextView1.setGravity(16);
          localTextView1.setLineSpacing(0.0F, this.y);
          localTextView1.setTextSize(2, this.x);
          localTextView1.setLines(1);
          localTextView1.setTextColor(this.u.getCurrentTextColor());
          localTextView1.setTypeface(this.u.getTypeface());
          localTextView1.setText(str1);
          localLinearLayout.addView(localTextView1);
        }
      }
    }
    super.onMeasure(paramInt1, paramInt2);
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
      boolean bool1 = true;
      boolean bool2;
      do
      {
        boolean bool3;
        do
        {
          return bool1;
          bool3 = this.w.containsKey(paramView);
          bool1 = false;
        }
        while (!bool3);
        if (!((Boolean)this.w.get(paramView)).booleanValue())
          return true;
        setBackgroundColor(this.H);
        getIconImage().setBackgroundColor(this.G);
        break;
        setBackgroundColor(this.G);
        getIconImage().setBackgroundColor(this.G);
        bool2 = this.w.containsKey(paramView);
        bool1 = false;
      }
      while (!bool2);
      if (!((Boolean)this.w.get(paramView)).booleanValue())
        return true;
      performClick();
      if (this.K != null)
      {
        this.K.onClick(paramView);
        continue;
        setBackgroundColor(this.G);
        getIconImage().setBackgroundColor(this.G);
      }
    }
  }

  private final class a
    implements Runnable
  {
    private a()
    {
    }

    public final void run()
    {
      if (ck.a(ck.this).getChildCount() > 1)
      {
        ck.a(ck.this).showNext();
        ck.this.postDelayed(ck.b(ck.this), ck.a);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ck
 * JD-Core Version:    0.6.2
 */