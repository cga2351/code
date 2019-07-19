package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public final class fx
{
  private static final class a
  {
    static final int a = Color.parseColor("#cc000000");
  }

  public static final class b
  {
    public static final GradientDrawable a;
    public static final ColorDrawable b;
    static final GradientDrawable c = localGradientDrawable2;

    static
    {
      int[] arrayOfInt1 = new int[3];
      arrayOfInt1[0] = Color.parseColor("#ff303030");
      arrayOfInt1[1] = Color.parseColor("#ff181818");
      arrayOfInt1[2] = Color.parseColor("#ff000000");
      GradientDrawable localGradientDrawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, arrayOfInt1);
      localGradientDrawable1.setCornerRadius(0.0F);
      a = localGradientDrawable1;
      b = new ColorDrawable(Color.parseColor("#ff000000"));
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = Color.parseColor("#ff949494");
      arrayOfInt2[1] = Color.parseColor("#ff5a5f62");
      GradientDrawable localGradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, arrayOfInt2);
      localGradientDrawable2.setCornerRadius(0.0F);
    }
  }

  public static final class c
  {
    public static RelativeLayout a(Context paramContext)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
      localRelativeLayout.setBackgroundColor(0);
      return localRelativeLayout;
    }

    public static RelativeLayout b(Context paramContext)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
      localRelativeLayout.setBackgroundDrawable(fx.b.c);
      return localRelativeLayout;
    }
  }

  public static final class d
  {
    public static RelativeLayout.LayoutParams a()
    {
      return new RelativeLayout.LayoutParams(-1, -1);
    }

    private static RelativeLayout.LayoutParams a(Context paramContext, int paramInt1, int paramInt2)
    {
      return new RelativeLayout.LayoutParams(dh.a(paramContext, paramInt1), dh.a(paramContext, paramInt2));
    }

    public static RelativeLayout.LayoutParams a(Context paramContext, View paramView)
    {
      int i = 1;
      int j = dh.a(paramContext, 25.0F);
      int k = dh.a(paramContext, 45.0F);
      int m = k >> 1;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(7, paramView.getId());
      localLayoutParams.addRule(6, paramView.getId());
      ViewGroup.LayoutParams localLayoutParams1 = paramView.getLayoutParams();
      int n;
      label113: int i1;
      if ((localLayoutParams1.width == -1) || (j + localLayoutParams1.width >= dh.a(paramContext)))
      {
        n = i;
        if ((localLayoutParams1.height != -1) && (j + localLayoutParams1.height < dh.b(paramContext)))
          break label158;
        i1 = (j >> 1) - (k - j) / 2;
        if ((n == 0) && (i == 0))
          break label163;
      }
      label158: label163: for (int i2 = i1; ; i2 = -m)
      {
        localLayoutParams.setMargins(0, i2, i2, 0);
        return localLayoutParams;
        n = 0;
        break;
        i = 0;
        break label113;
      }
    }

    public static RelativeLayout.LayoutParams a(Context paramContext, aj paramaj)
    {
      if (paramaj != null);
      for (RelativeLayout.LayoutParams localLayoutParams = a(paramContext, paramaj.b(paramContext), paramaj.a(paramContext)); ; localLayoutParams = new RelativeLayout.LayoutParams(-2, -2))
      {
        localLayoutParams.addRule(13);
        return localLayoutParams;
      }
    }

    public static RelativeLayout.LayoutParams a(Context paramContext, v paramv)
    {
      if (paramv != null);
      for (RelativeLayout.LayoutParams localLayoutParams = a(paramContext, paramv.d(), paramv.e()); ; localLayoutParams = new RelativeLayout.LayoutParams(-2, -2))
      {
        localLayoutParams.addRule(13);
        return localLayoutParams;
      }
    }

    public static RelativeLayout.LayoutParams b(Context paramContext, v paramv)
    {
      RelativeLayout.LayoutParams localLayoutParams = a(paramContext, paramv);
      int i = dh.a(paramContext, 45.0F);
      localLayoutParams.width = Math.min(i + localLayoutParams.width, dh.a(paramContext));
      localLayoutParams.height = Math.min(i + localLayoutParams.height, dh.b(paramContext));
      return localLayoutParams;
    }
  }

  static final class e extends View
  {
    Paint a;
    Paint b;
    Paint c;
    int d = fx.a.a;
    int e = fx.a.a;
    int f = -1;
    float g = -1.0F;

    public e(Context paramContext)
    {
      this(paramContext, Integer.valueOf(fx.a.a));
    }

    private e(Context paramContext, Integer paramInteger)
    {
      super();
      if (paramInteger != null)
      {
        this.e = paramInteger.intValue();
        a(paramInteger.intValue());
      }
      this.a = new Paint(0);
      this.a.setAntiAlias(true);
      this.a.setStyle(Paint.Style.FILL);
      this.b = new Paint(0);
      this.b.setAntiAlias(true);
      this.b.setStrokeWidth(2.0F);
      this.b.setStyle(Paint.Style.STROKE);
      this.c = new Paint(0);
      this.c.setAntiAlias(true);
      this.c.setStyle(Paint.Style.STROKE);
      a();
    }

    private void a()
    {
      this.a.setColor(this.d);
      this.b.setColor(this.f);
      this.c.setColor(this.f);
    }

    private void a(int paramInt)
    {
      this.d = dh.a(paramInt, 20.0F);
      if (dh.a(this.d))
      {
        this.f = -1;
        return;
      }
      this.f = -16777216;
    }

    private void b(int paramInt)
    {
      a(paramInt);
      a();
      invalidate();
    }

    protected final void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      paramCanvas.drawColor(0);
      int i = Math.min(getWidth(), getHeight());
      float f1 = i / 2.0F;
      paramCanvas.drawCircle(f1, f1, f1, this.a);
      float f2 = i / 5.0F;
      paramCanvas.drawLine(f1 - f2, f1 - f2, f1 + f2, f1 + f2, this.b);
      paramCanvas.drawLine(f1 - f2, f1 + f2, f1 + f2, f1 - f2, this.b);
      if (this.g > 0.0F)
      {
        this.c.setStrokeWidth(this.g);
        paramCanvas.drawCircle(f1, f1, f1 - this.g, this.c);
      }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
        b(u.a.a);
      while (true)
      {
        return super.onTouchEvent(paramMotionEvent);
        if (1 == paramMotionEvent.getAction())
          b(this.e);
      }
    }

    public final void setBackgroundColor(int paramInt)
    {
      this.e = paramInt;
      a(this.e);
      a();
      invalidate();
    }
  }

  public static final class f extends RelativeLayout
  {
    private boolean a = true;
    private boolean b = false;
    private long c = 500L;
    private RelativeLayout d;
    private RelativeLayout e;
    private Interpolator f;
    private Interpolator g;
    private float h;
    private float i;
    private float j;

    public f(Context paramContext)
    {
      super();
      setBackgroundColor(0);
    }

    public final void a()
    {
      boolean bool1 = true;
      fw.b localb;
      if (this.a)
      {
        boolean bool2 = bool1;
        float f1 = bool2 * true;
        this.b = bool1;
        localb = new fw.b(0.0F, f1, this.h, this.i, this.j, 0.0F);
        localb.setDuration(this.c);
        localb.setFillAfter(bool1);
        localb.setInterpolator(this.f);
        localb.setAnimationListener(new b(this.a));
        if (!this.a)
          break label121;
        this.d.startAnimation(localb);
        label103: if (this.a)
          break label133;
      }
      while (true)
      {
        this.a = bool1;
        return;
        int k = -1;
        break;
        label121: this.e.startAnimation(localb);
        break label103;
        label133: bool1 = false;
      }
    }

    public final void setAnimationDuration(long paramLong)
    {
      this.c = (paramLong / 2L);
    }

    public final void setBackFace(RelativeLayout paramRelativeLayout, RelativeLayout.LayoutParams paramLayoutParams)
    {
      if (this.e != null)
        removeView(this.e);
      this.e = paramRelativeLayout;
      RelativeLayout localRelativeLayout;
      if (this.e != null)
      {
        addView(this.e, paramLayoutParams);
        localRelativeLayout = this.e;
        if (!this.a)
          break label58;
      }
      label58: for (int k = 4; ; k = 0)
      {
        localRelativeLayout.setVisibility(k);
        return;
      }
    }

    public final void setDepthZ(float paramFloat)
    {
      this.j = paramFloat;
    }

    public final void setFromInterpolator(Interpolator paramInterpolator)
    {
      this.f = paramInterpolator;
    }

    public final void setFrontFace(RelativeLayout paramRelativeLayout, RelativeLayout.LayoutParams paramLayoutParams)
    {
      if (this.d != null)
        removeView(this.d);
      this.d = paramRelativeLayout;
      RelativeLayout localRelativeLayout;
      if (this.d != null)
      {
        addView(this.d, paramLayoutParams);
        localRelativeLayout = this.d;
        if (!this.a)
          break label58;
      }
      label58: for (int k = 0; ; k = 4)
      {
        localRelativeLayout.setVisibility(k);
        return;
      }
    }

    public final void setPivot(float paramFloat1, float paramFloat2)
    {
      this.h = paramFloat1;
      this.i = paramFloat2;
    }

    public final void setToInterpolator(Interpolator paramInterpolator)
    {
      this.g = paramInterpolator;
    }

    private final class a
      implements Animation.AnimationListener
    {
      private a()
      {
      }

      public final void onAnimationEnd(Animation paramAnimation)
      {
        fx.f.a(fx.f.this);
      }

      public final void onAnimationRepeat(Animation paramAnimation)
      {
      }

      public final void onAnimationStart(Animation paramAnimation)
      {
      }
    }

    private final class b
      implements Animation.AnimationListener
    {
      private boolean b;

      public b(boolean arg2)
      {
        boolean bool;
        this.b = bool;
      }

      public final void onAnimationEnd(Animation paramAnimation)
      {
        fx.f.a(fx.f.this, this.b);
      }

      public final void onAnimationRepeat(Animation paramAnimation)
      {
      }

      public final void onAnimationStart(Animation paramAnimation)
      {
      }
    }
  }

  public static final class g
  {
    public static View a(Context paramContext)
    {
      fx.e locale = new fx.e(paramContext);
      FrameLayout localFrameLayout = new FrameLayout(paramContext);
      int i = dh.a(paramContext, 25.0F);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.gravity = 17;
      int j = dh.a(paramContext, 10.0F);
      localLayoutParams.setMargins(j, j, j, j);
      localFrameLayout.addView(locale, localLayoutParams);
      new dg();
      locale.setTag(dg.a("close_button"));
      locale.g = 1.0F;
      locale.invalidate();
      return localFrameLayout;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fx
 * JD-Core Version:    0.6.2
 */