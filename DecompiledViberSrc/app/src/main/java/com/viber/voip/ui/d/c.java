package com.viber.voip.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class c extends Drawable
  implements Animatable
{
  private static final Interpolator a = new LinearInterpolator();
  private static final Interpolator b = new a(null);
  private static final Interpolator c = new c(null);
  private static final Interpolator d = new AccelerateDecelerateInterpolator();
  private final int[] e = { -9418623 };
  private final ArrayList<Animation> f = new ArrayList();
  private final b g;
  private float h;
  private Resources i;
  private View j;
  private Animation k;
  private float l;
  private double m;
  private double n;
  private Animation o;
  private int p;
  private final Drawable.Callback q = new Drawable.Callback()
  {
    public void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      c.this.invalidateSelf();
    }

    public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      c.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }

    public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      c.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };

  public c(Context paramContext, View paramView)
  {
    this.j = paramView;
    this.i = paramContext.getResources();
    this.g = new b(this.q);
    this.g.a(this.e);
    a(1);
    c();
  }

  private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2)
  {
    b localb = this.g;
    float f1 = this.i.getDisplayMetrics().density;
    float f2;
    float f3;
    if (this.p != 2)
    {
      f2 = f1;
      this.m = (paramDouble1 * f2);
      this.n = (paramDouble2 * f2);
      if (this.p == 2)
        break label139;
      f3 = f1 * (float)paramDouble4;
      label64: localb.a(f3);
      if (this.p == 2)
        break label147;
    }
    label139: label147: for (double d1 = f1 * (float)paramDouble3; ; d1 = (float)paramDouble3)
    {
      localb.a(d1);
      localb.a(0);
      localb.a(paramFloat1 * f1, f1 * paramFloat2);
      localb.a((int)this.m, (int)this.n);
      return;
      f2 = 1.1F;
      break;
      f3 = (float)paramDouble4;
      break label64;
    }
  }

  private void c()
  {
    final b localb = this.g;
    Animation local1 = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = (float)(1.0D + Math.floor(localb.i() / 0.8F));
        float f2 = localb.e() + paramAnonymousFloat * (localb.f() - localb.e());
        localb.b(f2);
        float f3 = localb.i() + paramAnonymousFloat * (f1 - localb.i());
        localb.d(f3);
        localb.e(1.0F - paramAnonymousFloat);
      }
    };
    local1.setInterpolator(d);
    local1.setDuration(666L);
    local1.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        localb.a();
        localb.j();
        localb.a(false);
        if (c.this.isRunning())
          c.b(c.this).startAnimation(c.a(c.this));
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    Animation local3 = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = (float)Math.toRadians(localb.c() / (6.283185307179586D * localb.h()));
        float f2 = localb.f();
        float f3 = localb.e();
        float f4 = localb.i();
        float f5 = f2 + (0.8F - f1) * c.a().getInterpolation(paramAnonymousFloat);
        localb.c(f5);
        float f6 = f3 + 0.8F * c.b().getInterpolation(paramAnonymousFloat);
        localb.b(f6);
        float f7 = f4 + 0.25F * paramAnonymousFloat;
        localb.d(f7);
        float f8 = 144.0F * paramAnonymousFloat + 720.0F * (c.c(c.this) / 5.0F);
        c.this.a(f8);
      }
    };
    local3.setRepeatCount(-1);
    local3.setRepeatMode(1);
    local3.setInterpolator(a);
    local3.setDuration(1333L);
    local3.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        localb.j();
        localb.a();
        localb.b(localb.g());
        c.a(c.this, (1.0F + c.c(c.this)) % 5.0F);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        c.a(c.this, 0.0F);
      }
    });
    this.o = local1;
    this.k = local3;
  }

  void a(float paramFloat)
  {
    this.h = paramFloat;
    invalidateSelf();
  }

  public void a(int paramInt)
  {
    a(paramInt, 0);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.p = paramInt1;
    if (paramInt1 == 0)
    {
      a(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      return;
    }
    if (paramInt1 == 1)
    {
      a(40.0D, 40.0D, 8.75D, 3.0D, 10.0F, 5.0F);
      return;
    }
    a(paramInt2, paramInt2, 0.42D * paramInt2, 0.08D * paramInt2, 10.0F, 5.0F);
  }

  public void a(int[] paramArrayOfInt)
  {
    this.g.a(paramArrayOfInt);
    this.g.a(0);
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    paramCanvas.rotate(this.h, localRect.exactCenterX(), localRect.exactCenterY());
    this.g.a(paramCanvas, localRect);
    paramCanvas.restoreToCount(i1);
  }

  public int getAlpha()
  {
    return this.g.b();
  }

  public int getIntrinsicHeight()
  {
    return (int)this.n;
  }

  public int getIntrinsicWidth()
  {
    return (int)this.m;
  }

  public int getOpacity()
  {
    return -3;
  }

  public boolean isRunning()
  {
    ArrayList localArrayList = this.f;
    int i1 = localArrayList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      Animation localAnimation = (Animation)localArrayList.get(i2);
      if ((localAnimation.hasStarted()) && (!localAnimation.hasEnded()))
        return true;
    }
    return false;
  }

  public void setAlpha(int paramInt)
  {
    this.g.b(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.g.a(paramColorFilter);
  }

  public void start()
  {
    this.k.reset();
    this.g.j();
    if (this.g.g() != this.g.d())
    {
      this.j.startAnimation(this.o);
      return;
    }
    this.g.a(0);
    this.g.k();
    this.j.startAnimation(this.k);
  }

  public void stop()
  {
    if (this.k != null)
      this.k.cancel();
    this.j.clearAnimation();
    a(0.0F);
    this.g.a(false);
    this.g.a(0);
    this.g.k();
  }

  private static class a extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.max(0.0F, 2.0F * (paramFloat - 0.5F)));
    }
  }

  private static class b
  {
    private final RectF a = new RectF();
    private final Paint b = new Paint();
    private final Paint c = new Paint();
    private final Drawable.Callback d;
    private float e = 0.0F;
    private float f = 0.0F;
    private float g = 0.0F;
    private float h = 5.0F;
    private float i = 2.5F;
    private int[] j;
    private int k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private Path p;
    private float q;
    private double r;
    private int s;
    private int t;
    private int u;
    private final Paint v = new Paint();
    private int w;

    public b(Drawable.Callback paramCallback)
    {
      this.d = paramCallback;
      this.b.setStrokeCap(Paint.Cap.SQUARE);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
    }

    private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Rect paramRect)
    {
      if (this.o)
      {
        if (this.p != null)
          break label214;
        this.p = new Path();
        this.p.setFillType(Path.FillType.EVEN_ODD);
      }
      while (true)
      {
        float f1 = (int)this.i / 2 * this.q;
        float f2 = (float)(this.r * Math.cos(0.0D) + paramRect.exactCenterX());
        float f3 = (float)(this.r * Math.sin(0.0D) + paramRect.exactCenterY());
        this.p.moveTo(0.0F, 0.0F);
        this.p.lineTo(this.s * this.q, 0.0F);
        this.p.lineTo(this.s * this.q / 2.0F, this.t * this.q);
        this.p.offset(f2 - f1, f3);
        this.p.close();
        this.c.setColor(this.j[this.k]);
        paramCanvas.rotate(paramFloat1 + paramFloat2 - 5.0F, paramRect.exactCenterX(), paramRect.exactCenterY());
        paramCanvas.drawPath(this.p, this.c);
        return;
        label214: this.p.reset();
      }
    }

    private void l()
    {
      this.d.invalidateDrawable(null);
    }

    public void a()
    {
      this.k = ((1 + this.k) % this.j.length);
    }

    public void a(double paramDouble)
    {
      this.r = paramDouble;
    }

    public void a(float paramFloat)
    {
      this.h = paramFloat;
      this.b.setStrokeWidth(paramFloat);
      l();
    }

    public void a(float paramFloat1, float paramFloat2)
    {
      this.s = ((int)paramFloat1);
      this.t = ((int)paramFloat2);
    }

    public void a(int paramInt)
    {
      this.k = paramInt;
    }

    public void a(int paramInt1, int paramInt2)
    {
      float f1 = Math.min(paramInt1, paramInt2);
      if ((this.r <= 0.0D) || (f1 < 0.0F));
      for (float f2 = (float)Math.ceil(this.h / 2.0F); ; f2 = (float)(f1 / 2.0F - this.r))
      {
        this.i = f2;
        return;
      }
    }

    public void a(Canvas paramCanvas, Rect paramRect)
    {
      RectF localRectF = this.a;
      localRectF.set(paramRect);
      localRectF.inset(this.i, this.i);
      float f1 = 360.0F * (this.e + this.g);
      float f2 = 360.0F * (this.f + this.g) - f1;
      this.b.setColor(this.j[this.k]);
      paramCanvas.drawArc(localRectF, f1, f2, false, this.b);
      a(paramCanvas, f1, f2, paramRect);
      if (this.u < 255)
      {
        this.v.setColor(this.w);
        this.v.setAlpha(255 - this.u);
        paramCanvas.drawCircle(paramRect.exactCenterX(), paramRect.exactCenterY(), paramRect.width() / 2, this.v);
      }
    }

    public void a(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
      l();
    }

    public void a(boolean paramBoolean)
    {
      if (this.o != paramBoolean)
      {
        this.o = paramBoolean;
        l();
      }
    }

    public void a(int[] paramArrayOfInt)
    {
      this.j = paramArrayOfInt;
      a(0);
    }

    public int b()
    {
      return this.u;
    }

    public void b(float paramFloat)
    {
      this.e = paramFloat;
      l();
    }

    public void b(int paramInt)
    {
      this.u = paramInt;
    }

    public float c()
    {
      return this.h;
    }

    public void c(float paramFloat)
    {
      this.f = paramFloat;
      l();
    }

    public float d()
    {
      return this.e;
    }

    public void d(float paramFloat)
    {
      this.g = paramFloat;
      l();
    }

    public float e()
    {
      return this.l;
    }

    public void e(float paramFloat)
    {
      if (paramFloat != this.q)
      {
        this.q = paramFloat;
        l();
      }
    }

    public float f()
    {
      return this.m;
    }

    public float g()
    {
      return this.f;
    }

    public double h()
    {
      return this.r;
    }

    public float i()
    {
      return this.n;
    }

    public void j()
    {
      this.l = this.e;
      this.m = this.f;
      this.n = this.g;
    }

    public void k()
    {
      this.l = 0.0F;
      this.m = 0.0F;
      this.n = 0.0F;
      b(0.0F);
      c(0.0F);
      d(0.0F);
    }
  }

  private static class c extends AccelerateDecelerateInterpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.min(1.0F, 2.0F * paramFloat));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d.c
 * JD-Core Version:    0.6.2
 */