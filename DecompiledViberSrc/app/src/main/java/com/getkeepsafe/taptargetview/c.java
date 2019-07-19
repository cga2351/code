package com.getkeepsafe.taptargetview;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;

@SuppressLint({"ViewConstructor"})
public class c extends View
{
  boolean A;
  boolean B;
  boolean C;
  boolean D;
  boolean E;
  SpannableStringBuilder F;
  DynamicLayout G;
  TextPaint H;
  Paint I;
  Rect J;
  Rect K;
  Path L;
  float M;
  int N;
  int[] O;
  int P;
  float Q;
  int R;
  float S;
  int T;
  int U;
  int V;
  float W;
  final int a;
  float aa;
  int ab;
  int ac;
  Bitmap ad;
  a ae;
  ViewOutlineProvider af;
  final a.b ag = new a.b()
  {
    public void a(float paramAnonymousFloat)
    {
      float f1 = paramAnonymousFloat * c.this.N;
      int i;
      if (f1 > c.this.M)
      {
        i = 1;
        if (i == 0)
          c.this.e();
        float f2 = 255.0F * c.this.n.c;
        c.this.M = f1;
        c.this.P = ((int)Math.min(f2, f2 * (paramAnonymousFloat * 1.5F)));
        c.this.L.reset();
        c.this.L.addCircle(c.this.O[0], c.this.O[1], c.this.M, Path.Direction.CW);
        c.this.T = ((int)Math.min(255.0F, 255.0F * (paramAnonymousFloat * 1.5F)));
        if (i == 0)
          break label229;
        c.this.S = (c.this.b * Math.min(1.0F, paramAnonymousFloat * 1.5F));
      }
      while (true)
      {
        c.this.U = ((int)(255.0F * c.this.a(paramAnonymousFloat, 0.7F)));
        if (i != 0)
          c.this.e();
        c.this.a(c.this.J);
        return;
        i = 0;
        break;
        label229: c.this.S = (paramAnonymousFloat * c.this.b);
        c localc = c.this;
        localc.Q = (paramAnonymousFloat * localc.Q);
      }
    }
  };
  final ValueAnimator ah = new a().b(250L).a(250L).a(new AccelerateDecelerateInterpolator()).a(new a.b()
  {
    public void a(float paramAnonymousFloat)
    {
      c.this.ag.a(paramAnonymousFloat);
    }
  }).a(new a.a()
  {
    public void a()
    {
      c.this.ai.start();
    }
  }).a();
  final ValueAnimator ai = new a().b(1000L).a(-1).a(new AccelerateDecelerateInterpolator()).a(new a.b()
  {
    public void a(float paramAnonymousFloat)
    {
      float f = c.this.a(paramAnonymousFloat, 0.5F);
      c.this.Q = ((1.0F + f) * c.this.b);
      c.this.R = ((int)(255.0F * (1.0F - f)));
      c.this.S = (c.this.b + c.this.a(paramAnonymousFloat) * c.this.c);
      if (c.this.M != c.this.N)
        c.this.M = c.this.N;
      c.this.e();
      c.this.a(c.this.J);
    }
  }).a();
  final ValueAnimator aj = new a(true).b(250L).a(new AccelerateDecelerateInterpolator()).a(new a.b()
  {
    public void a(float paramAnonymousFloat)
    {
      c.this.ag.a(paramAnonymousFloat);
    }
  }).a(new a.a()
  {
    public void a()
    {
      c.this.a(true);
      f.a(c.this.m, c.this);
    }
  }).a();
  private boolean ak = false;
  private boolean al = false;
  private boolean am = true;
  private final ValueAnimator an = new a().b(250L).a(new AccelerateDecelerateInterpolator()).a(new a.b()
  {
    public void a(float paramAnonymousFloat)
    {
      float f = Math.min(1.0F, 2.0F * paramAnonymousFloat);
      c.this.M = (c.this.N * (1.0F + 0.2F * f));
      c.this.P = ((int)(255.0F * ((1.0F - f) * c.this.n.c)));
      c.this.L.reset();
      c.this.L.addCircle(c.this.O[0], c.this.O[1], c.this.M, Path.Direction.CW);
      c.this.S = ((1.0F - paramAnonymousFloat) * c.this.b);
      c.this.T = ((int)(255.0F * (1.0F - paramAnonymousFloat)));
      c.this.Q = ((1.0F + paramAnonymousFloat) * c.this.b);
      c.this.R = ((int)((1.0F - paramAnonymousFloat) * c.this.R));
      c.this.U = ((int)(255.0F * (1.0F - f)));
      c.this.e();
      c.this.a(c.this.J);
    }
  }).a(new a.a()
  {
    public void a()
    {
      c.this.a(true);
      f.a(c.this.m, c.this);
    }
  }).a();
  private ValueAnimator[] ao;
  private final ViewTreeObserver.OnGlobalLayoutListener ap;
  final int b;
  final int c;
  final int d;
  final int e;
  final int f;
  final int g;
  final int h;
  final int i;
  final int j;
  final int k;
  final ViewGroup l;
  final ViewManager m;
  final b n;
  final Rect o;
  final TextPaint p;
  final TextPaint q;
  final Paint r;
  final Paint s;
  final Paint t;
  final Paint u;
  CharSequence v;
  StaticLayout w;
  CharSequence x;
  StaticLayout y;
  boolean z;

  public c(final Context paramContext, ViewManager paramViewManager, final ViewGroup paramViewGroup, final b paramb, a parama)
  {
    super(paramContext);
    ValueAnimator[] arrayOfValueAnimator = new ValueAnimator[4];
    arrayOfValueAnimator[0] = this.ah;
    arrayOfValueAnimator[1] = this.ai;
    arrayOfValueAnimator[2] = this.an;
    arrayOfValueAnimator[3] = this.aj;
    this.ao = arrayOfValueAnimator;
    if (paramb == null)
      throw new IllegalArgumentException("Target cannot be null");
    this.n = paramb;
    this.m = paramViewManager;
    this.l = paramViewGroup;
    if (parama != null);
    while (true)
    {
      this.ae = parama;
      this.v = paramb.a;
      this.x = paramb.b;
      this.a = d.a(paramContext, 20);
      this.h = d.a(paramContext, 40);
      this.b = d.a(paramContext, paramb.d);
      this.d = d.a(paramContext, 40);
      this.e = d.a(paramContext, 8);
      this.f = d.a(paramContext, 360);
      this.g = d.a(paramContext, 20);
      this.i = d.a(paramContext, 88);
      this.j = d.a(paramContext, 8);
      this.k = d.a(paramContext, 1);
      this.c = ((int)(0.1F * this.b));
      this.L = new Path();
      this.o = new Rect();
      this.J = new Rect();
      this.p = new TextPaint();
      this.p.setTextSize(paramb.f(paramContext));
      this.p.setTypeface(Typeface.create("sans-serif-medium", 0));
      this.p.setAntiAlias(true);
      this.q = new TextPaint();
      this.q.setTextSize(paramb.g(paramContext));
      this.q.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
      this.q.setAntiAlias(true);
      this.q.setAlpha(137);
      this.r = new Paint();
      this.r.setAntiAlias(true);
      this.r.setAlpha((int)(255.0F * paramb.c));
      this.s = new Paint();
      this.s.setAntiAlias(true);
      this.s.setAlpha(50);
      this.s.setStyle(Paint.Style.STROKE);
      this.s.setStrokeWidth(this.k);
      this.s.setColor(-16777216);
      this.t = new Paint();
      this.t.setAntiAlias(true);
      this.u = new Paint();
      this.u.setAntiAlias(true);
      a(paramContext);
      this.ap = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (c.a(c.this))
            return;
          c.this.c();
          paramb.a(new Runnable()
          {
            public void run()
            {
              int[] arrayOfInt = new int[2];
              c.this.o.set(c.12.this.a.a());
              c.this.getLocationOnScreen(arrayOfInt);
              c.this.o.offset(-arrayOfInt[0], -arrayOfInt[1]);
              if (c.12.this.b != null)
              {
                WindowManager localWindowManager = (WindowManager)c.12.this.c.getSystemService("window");
                DisplayMetrics localDisplayMetrics = new DisplayMetrics();
                localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
                Rect localRect = new Rect();
                c.12.this.b.getWindowVisibleDisplayFrame(localRect);
                c.this.ab = Math.max(0, localRect.top);
                c.this.ac = Math.min(localRect.bottom, localDisplayMetrics.heightPixels);
              }
              c.this.b();
              c.this.requestFocus();
              c.this.d();
              if (!c.this.E)
              {
                c.this.ah.start();
                c.this.E = true;
              }
            }
          });
        }
      };
      getViewTreeObserver().addOnGlobalLayoutListener(this.ap);
      setFocusableInTouchMode(true);
      setClickable(true);
      setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = 1;
          if ((c.this.ae == null) || (c.this.O == null) || (!c.b(c.this)));
          label176: label181: 
          do
          {
            return;
            int j;
            if (c.this.a(c.this.o.centerX(), c.this.o.centerY(), (int)c.this.W, (int)c.this.aa) <= c.this.S)
            {
              j = i;
              if (c.this.a(c.this.O[0], c.this.O[i], (int)c.this.W, (int)c.this.aa) > c.this.M)
                break label176;
            }
            while (true)
            {
              if (j == 0)
                break label181;
              c.a(c.this, false);
              c.this.ae.a(c.this);
              return;
              j = 0;
              break;
              i = 0;
            }
            if (i != 0)
            {
              c.this.ae.d(c.this);
              return;
            }
          }
          while (!c.this.D);
          c.a(c.this, false);
          c.this.ae.c(c.this);
        }
      });
      setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          if (c.this.ae == null);
          while (!c.this.o.contains((int)c.this.W, (int)c.this.aa))
            return false;
          c.this.ae.b(c.this);
          return true;
        }
      });
      return;
      parama = new a();
    }
  }

  public static c a(Activity paramActivity, b paramb)
  {
    return a(paramActivity, paramb, null);
  }

  public static c a(Activity paramActivity, b paramb, a parama)
  {
    if (paramActivity == null)
      throw new IllegalArgumentException("Activity is null");
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    c localc = new c(paramActivity, localViewGroup, (ViewGroup)localViewGroup.findViewById(16908290), paramb, parama);
    localViewGroup.addView(localc, localLayoutParams);
    return localc;
  }

  double a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return Math.sqrt(Math.pow(paramInt3 - paramInt1, 2.0D) + Math.pow(paramInt4 - paramInt2, 2.0D));
  }

  float a(float paramFloat)
  {
    if (paramFloat < 0.5F)
      return paramFloat / 0.5F;
    return (1.0F - paramFloat) / 0.5F;
  }

  float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2)
      return 0.0F;
    return (paramFloat1 - paramFloat2) / (1.0F - paramFloat2);
  }

  int a(int paramInt1, int paramInt2, Rect paramRect)
  {
    return (int)Math.max(a(paramInt1, paramInt2, paramRect.left, paramRect.top), Math.max(a(paramInt1, paramInt2, paramRect.right, paramRect.top), Math.max(a(paramInt1, paramInt2, paramRect.left, paramRect.bottom), a(paramInt1, paramInt2, paramRect.right, paramRect.bottom))));
  }

  int a(int paramInt1, int paramInt2, Rect paramRect1, Rect paramRect2)
  {
    int i1 = paramRect2.centerX();
    int i2 = paramRect2.centerY();
    int i3 = (int)(1.1F * this.b);
    Rect localRect = new Rect(i1, i2, i1, i2);
    localRect.inset(-i3, -i3);
    return Math.max(a(paramInt1, paramInt2, paramRect1), a(paramInt1, paramInt2, localRect)) + this.h;
  }

  protected void a(Context paramContext)
  {
    int i1 = 1;
    int i2 = -16777216;
    this.B = this.n.l;
    this.C = this.n.j;
    this.D = this.n.k;
    if ((this.C) && (Build.VERSION.SDK_INT >= 21) && (!this.n.m))
    {
      this.af = new ViewOutlineProvider()
      {
        @TargetApi(21)
        public void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
        {
          if (c.this.O == null);
          do
          {
            return;
            paramAnonymousOutline.setOval((int)(c.this.O[0] - c.this.M), (int)(c.this.O[1] - c.this.M), (int)(c.this.O[0] + c.this.M), (int)(c.this.O[1] + c.this.M));
            paramAnonymousOutline.setAlpha(c.this.P / 255.0F);
          }
          while (Build.VERSION.SDK_INT < 22);
          paramAnonymousOutline.offset(0, c.this.j);
        }
      };
      setOutlineProvider(this.af);
      setElevation(this.j);
    }
    Resources.Theme localTheme;
    if ((this.C) && (this.af == null) && (Build.VERSION.SDK_INT < 18))
    {
      setLayerType(i1, null);
      localTheme = paramContext.getTheme();
      if (d.a(paramContext, "isLightTheme") != 0)
        break label382;
      label137: this.z = i1;
      Integer localInteger1 = this.n.a(paramContext);
      if (localInteger1 == null)
        break label387;
      this.r.setColor(localInteger1.intValue());
      label169: Integer localInteger2 = this.n.b(paramContext);
      if (localInteger2 == null)
        break label420;
      this.t.setColor(localInteger2.intValue());
      if (this.n.m)
        this.t.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.u.setColor(this.t.getColor());
      Integer localInteger3 = this.n.c(paramContext);
      if (localInteger3 == null)
        break label452;
      this.V = d.a(localInteger3.intValue(), 0.3F);
      label268: Integer localInteger4 = this.n.d(paramContext);
      if (localInteger4 == null)
        break label460;
      this.p.setColor(localInteger4.intValue());
      Integer localInteger5 = this.n.e(paramContext);
      if (localInteger5 == null)
        break label487;
      this.q.setColor(localInteger5.intValue());
    }
    while (true)
    {
      if (this.n.g != null)
        this.p.setTypeface(this.n.g);
      if (this.n.h != null)
        this.q.setTypeface(this.n.h);
      return;
      setLayerType(2, null);
      break;
      label382: i1 = 0;
      break label137;
      label387: if (localTheme != null)
      {
        this.r.setColor(d.a(paramContext, "colorPrimary"));
        break label169;
      }
      this.r.setColor(-1);
      break label169;
      label420: Paint localPaint = this.t;
      if (this.z);
      for (int i3 = i2; ; i3 = -1)
      {
        localPaint.setColor(i3);
        break;
      }
      label452: this.V = -1;
      break label268;
      label460: TextPaint localTextPaint = this.p;
      if (this.z);
      while (true)
      {
        localTextPaint.setColor(i2);
        break;
        i2 = -1;
      }
      label487: this.q.setColor(this.p.getColor());
    }
  }

  void a(Canvas paramCanvas)
  {
    float f1 = 0.2F * this.P;
    this.s.setStyle(Paint.Style.FILL_AND_STROKE);
    this.s.setAlpha((int)f1);
    paramCanvas.drawCircle(this.O[0], this.O[1] + this.j, this.M, this.s);
    this.s.setStyle(Paint.Style.STROKE);
    for (int i1 = 6; i1 > 0; i1--)
    {
      this.s.setAlpha((int)(f1 * (i1 / 7.0F)));
      paramCanvas.drawCircle(this.O[0], this.O[1] + this.j, this.M + (7 - i1) * this.k, this.s);
    }
  }

  void a(Rect paramRect)
  {
    invalidate(paramRect);
    if ((this.af != null) && (Build.VERSION.SDK_INT >= 21))
      invalidateOutline();
  }

  void a(boolean paramBoolean)
  {
    if (this.ak);
    do
    {
      return;
      this.al = false;
      this.ak = true;
      for (ValueAnimator localValueAnimator : this.ao)
      {
        localValueAnimator.cancel();
        localValueAnimator.removeAllUpdateListeners();
      }
      f.a(getViewTreeObserver(), this.ap);
      this.E = false;
    }
    while (this.ae == null);
    this.ae.a(this, paramBoolean);
  }

  public boolean a()
  {
    return (!this.ak) && (this.E);
  }

  boolean a(int paramInt)
  {
    boolean bool;
    if (this.ac > 0)
      if (paramInt >= this.i)
      {
        int i2 = this.ac - this.i;
        bool = false;
        if (paramInt <= i2);
      }
      else
      {
        bool = true;
      }
    int i1;
    do
    {
      return bool;
      if (paramInt < this.i)
        break;
      i1 = getHeight() - this.i;
      bool = false;
    }
    while (paramInt <= i1);
    return true;
  }

  void b()
  {
    Drawable localDrawable = this.n.f;
    if ((!this.B) || (localDrawable == null))
      this.ad = null;
    while (this.ad != null)
      return;
    this.ad = Bitmap.createBitmap(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(this.ad);
    localDrawable.setColorFilter(new PorterDuffColorFilter(this.r.getColor(), PorterDuff.Mode.SRC_ATOP));
    localDrawable.draw(localCanvas);
    localDrawable.setColorFilter(null);
  }

  void b(Canvas paramCanvas)
  {
    if (this.I == null)
    {
      this.I = new Paint();
      this.I.setARGB(255, 255, 0, 0);
      this.I.setStyle(Paint.Style.STROKE);
      this.I.setStrokeWidth(d.a(getContext(), 1));
    }
    if (this.H == null)
    {
      this.H = new TextPaint();
      this.H.setColor(-65536);
      this.H.setTextSize(d.b(getContext(), 16));
    }
    this.I.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRect(this.K, this.I);
    paramCanvas.drawRect(this.o, this.I);
    paramCanvas.drawCircle(this.O[0], this.O[1], 10.0F, this.I);
    paramCanvas.drawCircle(this.O[0], this.O[1], this.N - this.h, this.I);
    paramCanvas.drawCircle(this.o.centerX(), this.o.centerY(), this.b + this.a, this.I);
    this.I.setStyle(Paint.Style.FILL);
    String str = "Text bounds: " + this.K.toShortString() + "\nTarget bounds: " + this.o.toShortString() + "\nCenter: " + this.O[0] + " " + this.O[1] + "\nView size: " + getWidth() + " " + getHeight() + "\nTarget bounds: " + this.o.toShortString();
    if (this.F == null)
      this.F = new SpannableStringBuilder(str);
    while (true)
    {
      if (this.G == null)
        this.G = new DynamicLayout(str, this.H, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      int i1 = paramCanvas.save();
      this.I.setARGB(220, 0, 0, 0);
      paramCanvas.translate(0.0F, this.ab);
      paramCanvas.drawRect(0.0F, 0.0F, this.G.getWidth(), this.G.getHeight(), this.I);
      this.I.setARGB(255, 255, 0, 0);
      this.G.draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
      return;
      this.F.clear();
      this.F.append(str);
    }
  }

  public void b(boolean paramBoolean)
  {
    this.al = true;
    this.ai.cancel();
    this.ah.cancel();
    if (paramBoolean)
    {
      this.an.start();
      return;
    }
    this.aj.start();
  }

  void c()
  {
    int i1 = Math.min(getWidth(), this.f) - 2 * this.d;
    if (i1 <= 0)
      return;
    this.w = new StaticLayout(this.v, this.p, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    if (this.x != null)
    {
      this.y = new StaticLayout(this.x, this.q, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      return;
    }
    this.y = null;
  }

  void d()
  {
    this.K = getTextBounds();
    this.O = getOuterCircleCenterPoint();
    this.N = a(this.O[0], this.O[1], this.K, this.o);
  }

  void e()
  {
    if (this.O == null)
      return;
    this.J.left = ((int)Math.max(0.0F, this.O[0] - this.M));
    this.J.top = ((int)Math.min(0.0F, this.O[1] - this.M));
    this.J.right = ((int)Math.min(getWidth(), this.O[0] + this.M + this.h));
    this.J.bottom = ((int)Math.min(getHeight(), this.O[1] + this.M + this.h));
  }

  int[] getOuterCircleCenterPoint()
  {
    if (a(this.o.centerY()))
    {
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = this.o.centerX();
      arrayOfInt2[1] = this.o.centerY();
      return arrayOfInt2;
    }
    int i1 = Math.max(this.o.width(), this.o.height()) / 2 + this.a;
    int i2 = getTotalTextHeight();
    int i3;
    int i4;
    int i5;
    int i6;
    if (this.o.centerY() - this.b - this.a - i2 > 0)
    {
      i3 = 1;
      i4 = Math.min(this.K.left, this.o.left - i1);
      i5 = Math.max(this.K.right, i1 + this.o.right);
      if (this.w != null)
        break label208;
      i6 = 0;
      label150: if (i3 == 0)
        break label220;
    }
    label208: label220: for (int i7 = i6 + (this.o.centerY() - this.b - this.a - i2); ; i7 = i6 + (this.o.centerY() + this.b + this.a))
    {
      int[] arrayOfInt1 = new int[2];
      arrayOfInt1[0] = ((i4 + i5) / 2);
      arrayOfInt1[1] = i7;
      return arrayOfInt1;
      i3 = 0;
      break;
      i6 = this.w.getHeight();
      break label150;
    }
  }

  Rect getTextBounds()
  {
    int i1 = getTotalTextHeight();
    int i2 = getTotalTextWidth();
    int i3 = this.o.centerY() - this.b - this.a - i1;
    if (i3 > this.ab)
      if (getWidth() / 2 - this.o.centerX() >= 0)
        break label134;
    label134: for (int i4 = -this.g; ; i4 = this.g)
    {
      int i5 = Math.max(this.d, this.o.centerX() - i4 - i2);
      return new Rect(i5, i3, Math.min(getWidth() - this.d, i2 + i5), i1 + i3);
      i3 = this.o.centerY() + this.b + this.a;
      break;
    }
  }

  int getTotalTextHeight()
  {
    if (this.w == null)
      return 0;
    if (this.y == null)
      return this.w.getHeight() + this.e;
    return this.w.getHeight() + this.y.getHeight() + this.e;
  }

  int getTotalTextWidth()
  {
    if (this.w == null)
      return 0;
    if (this.y == null)
      return this.w.getWidth();
    return Math.max(this.w.getWidth(), this.y.getWidth());
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(false);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.ak) || (this.O == null))
      return;
    if ((this.ab > 0) && (this.ac > 0))
      paramCanvas.clipRect(0, this.ab, getWidth(), this.ac);
    if (this.V != -1)
      paramCanvas.drawColor(this.V);
    this.r.setAlpha(this.P);
    if ((this.C) && (this.af == null))
    {
      int i3 = paramCanvas.save();
      paramCanvas.clipPath(this.L, Region.Op.DIFFERENCE);
      a(paramCanvas);
      paramCanvas.restoreToCount(i3);
    }
    paramCanvas.drawCircle(this.O[0], this.O[1], this.M, this.r);
    this.t.setAlpha(this.T);
    if (this.R > 0)
    {
      this.u.setAlpha(this.R);
      paramCanvas.drawCircle(this.o.centerX(), this.o.centerY(), this.Q, this.u);
    }
    paramCanvas.drawCircle(this.o.centerX(), this.o.centerY(), this.S, this.t);
    int i1 = paramCanvas.save();
    paramCanvas.translate(this.K.left, this.K.top);
    this.p.setAlpha(this.U);
    if (this.w != null)
      this.w.draw(paramCanvas);
    if ((this.y != null) && (this.w != null))
    {
      paramCanvas.translate(0.0F, this.w.getHeight() + this.e);
      this.q.setAlpha((int)(this.n.n * this.U));
      this.y.draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i1);
    int i2 = paramCanvas.save();
    if (this.ad != null)
    {
      paramCanvas.translate(this.o.centerX() - this.ad.getWidth() / 2, this.o.centerY() - this.ad.getHeight() / 2);
      paramCanvas.drawBitmap(this.ad, 0.0F, 0.0F, this.t);
    }
    while (true)
    {
      paramCanvas.restoreToCount(i2);
      if (!this.A)
        break;
      b(paramCanvas);
      return;
      if (this.n.f != null)
      {
        paramCanvas.translate(this.o.centerX() - this.n.f.getBounds().width() / 2, this.o.centerY() - this.n.f.getBounds().height() / 2);
        this.n.f.setAlpha(this.t.getAlpha());
        this.n.f.draw(paramCanvas);
      }
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((a()) && (this.D) && (paramInt == 4))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return false;
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = a();
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.am;
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.D;
        bool2 = false;
        if (bool4)
        {
          bool2 = false;
          if (paramInt == 4)
          {
            boolean bool5 = paramKeyEvent.isTracking();
            bool2 = false;
            if (bool5)
            {
              boolean bool6 = paramKeyEvent.isCanceled();
              bool2 = false;
              if (!bool6)
              {
                this.am = false;
                if (this.ae == null)
                  break label102;
                this.ae.c(this);
              }
            }
          }
        }
      }
    }
    while (true)
    {
      bool2 = true;
      return bool2;
      label102: new a().c(this);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.W = paramMotionEvent.getX();
    this.aa = paramMotionEvent.getY();
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setDrawDebug(boolean paramBoolean)
  {
    if (this.A != paramBoolean)
    {
      this.A = paramBoolean;
      postInvalidate();
    }
  }

  public static class a
  {
    public void a(c paramc)
    {
      paramc.b(true);
    }

    public void a(c paramc, boolean paramBoolean)
    {
    }

    public void b(c paramc)
    {
      a(paramc);
    }

    public void c(c paramc)
    {
      paramc.b(false);
    }

    public void d(c paramc)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.getkeepsafe.taptargetview.c
 * JD-Core Version:    0.6.2
 */