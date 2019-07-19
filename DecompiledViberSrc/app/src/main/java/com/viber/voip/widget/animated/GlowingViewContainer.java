package com.viber.voip.widget.animated;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.viber.common.d.h;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.b.a.b;

public class GlowingViewContainer extends FrameLayout
{
  private a a;
  private Paint b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private a h;
  private Paint i;
  private float j;
  private float k;
  private float l;
  private float m;
  private int n;
  private float o;
  private float p = 1.0F;
  private AnimatorSet q;
  private AnimatorSet r;

  public GlowingViewContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public GlowingViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public GlowingViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private float a(float paramFloat)
  {
    if (paramFloat >= 0.5F)
      return 2.0F * (1.0F - paramFloat);
    return paramFloat * 2.0F;
  }

  private ObjectAnimator a(View paramView)
  {
    a locala = new a(this);
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[2];
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Float.valueOf(0.0F);
    arrayOfObject1[1] = Float.valueOf(1.0F);
    arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofObject("scaleX", locala, arrayOfObject1);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Float.valueOf(0.0F);
    arrayOfObject2[1] = Float.valueOf(1.0F);
    arrayOfPropertyValuesHolder[1] = PropertyValuesHolder.ofObject("scaleY", locala, arrayOfObject2);
    return ObjectAnimator.ofPropertyValuesHolder(paramView, arrayOfPropertyValuesHolder);
  }

  private a a(Paint paramPaint, int paramInt)
  {
    a locala = new a(getContext(), paramPaint);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.gravity = 17;
    addView(locala, localLayoutParams);
    return locala;
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.b = new Paint();
    this.b.setColor(paramInt1);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setStrokeWidth(0.0F);
    this.i = new Paint();
    this.i.setColor(paramInt2);
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(0.0F);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (isInEditMode())
      return;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GlowingViewContainer);
    float f1 = localTypedArray.getDimension(R.styleable.GlowingViewContainer_startRadius, 0.0F);
    float f2 = localTypedArray.getDimension(R.styleable.GlowingViewContainer_endStrokeRadius, 0.0F);
    float f3 = localTypedArray.getDimension(R.styleable.GlowingViewContainer_endFillRadius, 0.0F);
    float f4 = localTypedArray.getDimension(R.styleable.GlowingViewContainer_startStrokeWidth, 0.0F);
    float f5 = localTypedArray.getDimension(R.styleable.GlowingViewContainer_endStrokeWidth, 0.0F);
    this.n = localTypedArray.getResourceId(R.styleable.GlowingViewContainer_viewId, 0);
    int i1 = localTypedArray.getColor(R.styleable.GlowingViewContainer_fillColor, 0);
    int i2 = localTypedArray.getColor(R.styleable.GlowingViewContainer_strokeColor, 0);
    localTypedArray.recycle();
    this.c = f1;
    this.d = f3;
    this.e = 0.25F;
    this.f = 0.1F;
    this.j = f1;
    this.k = f2;
    this.l = f4;
    this.m = f5;
    this.o = 0.9F;
    a(i1, i2);
    d();
  }

  private float b(float paramFloat)
  {
    return b(paramFloat, Float.valueOf(this.e), Float.valueOf(this.f));
  }

  private float b(float paramFloat, Float paramFloat1, Float paramFloat2)
  {
    return paramFloat1.floatValue() + paramFloat * (paramFloat2.floatValue() - paramFloat1.floatValue());
  }

  private float c(float paramFloat)
  {
    return b(paramFloat, Float.valueOf(getScaledStartFillRadius()), Float.valueOf(getScaledEndFillRadius()));
  }

  private void d()
  {
    int i1 = getStrokeInitialSize();
    this.a = a(this.b, i1);
    this.h = a(this.i, i1);
  }

  private float getScaledEndFillRadius()
  {
    return this.d * this.p;
  }

  private float getScaledEndStrokeRadius()
  {
    return this.k * this.p;
  }

  private float getScaledStartFillRadius()
  {
    return this.c * this.p;
  }

  private float getScaledStartStrokeRadius()
  {
    return this.j * this.p;
  }

  private int getStrokeInitialSize()
  {
    return Math.round(2.0F * this.k + 2.0F * this.m);
  }

  public void a()
  {
    final long l1 = 3000L - 400L - 1000L;
    ObjectAnimator localObjectAnimator1 = a(findViewById(this.n));
    ObjectAnimator localObjectAnimator2 = a(this.a);
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet1.setDuration(400L);
    localAnimatorSet1.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    a locala1 = this.h;
    TypeEvaluator local1 = new TypeEvaluator()
    {
      public Float a(float paramAnonymousFloat, Float paramAnonymousFloat1, Float paramAnonymousFloat2)
      {
        return Float.valueOf(GlowingViewContainer.a(GlowingViewContainer.this, paramAnonymousFloat, Float.valueOf(GlowingViewContainer.a(GlowingViewContainer.this)), Float.valueOf(GlowingViewContainer.b(GlowingViewContainer.this))));
      }
    };
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Float.valueOf(0.0F);
    arrayOfObject1[1] = Float.valueOf(1.0F);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofObject(locala1, "radius", local1, arrayOfObject1);
    a locala2 = this.h;
    TypeEvaluator local2 = new TypeEvaluator()
    {
      public Float a(float paramAnonymousFloat, Float paramAnonymousFloat1, Float paramAnonymousFloat2)
      {
        return Float.valueOf(GlowingViewContainer.a(GlowingViewContainer.this, paramAnonymousFloat));
      }
    };
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Float.valueOf(0.0F);
    arrayOfObject2[1] = Float.valueOf(1.0F);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofObject(locala2, "alpha", local2, arrayOfObject2);
    a locala3 = this.h;
    TypeEvaluator local3 = new TypeEvaluator()
    {
      public Float a(float paramAnonymousFloat, Float paramAnonymousFloat1, Float paramAnonymousFloat2)
      {
        return Float.valueOf(GlowingViewContainer.a(GlowingViewContainer.this, GlowingViewContainer.a(GlowingViewContainer.this, paramAnonymousFloat), Float.valueOf(GlowingViewContainer.c(GlowingViewContainer.this)), Float.valueOf(GlowingViewContainer.d(GlowingViewContainer.this))));
      }
    };
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Float.valueOf(0.0F);
    arrayOfObject3[1] = Float.valueOf(1.0F);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofObject(locala3, "strokeWidth", local3, arrayOfObject3);
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet2.playTogether(new Animator[] { localObjectAnimator3, localObjectAnimator4, localObjectAnimator5 });
    localAnimatorSet2.setDuration(1000L);
    this.q = new AnimatorSet();
    this.q.playSequentially(new Animator[] { localAnimatorSet1, localAnimatorSet2 });
    this.q.addListener(new a.b()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator.setStartDelay(l1);
        paramAnonymousAnimator.start();
      }
    });
    this.q.start();
  }

  public void a(long paramLong, float paramFloat)
  {
    a locala1 = this.a;
    TypeEvaluator local5 = new TypeEvaluator()
    {
      public Float a(float paramAnonymousFloat, Float paramAnonymousFloat1, Float paramAnonymousFloat2)
      {
        return Float.valueOf(GlowingViewContainer.b(GlowingViewContainer.this, GlowingViewContainer.a(GlowingViewContainer.this, paramAnonymousFloat, paramAnonymousFloat1, paramAnonymousFloat2)));
      }
    };
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Float.valueOf(this.g);
    arrayOfObject1[1] = Float.valueOf(paramFloat);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofObject(locala1, "radius", local5, arrayOfObject1);
    a locala2 = this.a;
    TypeEvaluator local6 = new TypeEvaluator()
    {
      public Float a(float paramAnonymousFloat, Float paramAnonymousFloat1, Float paramAnonymousFloat2)
      {
        return Float.valueOf(GlowingViewContainer.c(GlowingViewContainer.this, GlowingViewContainer.a(GlowingViewContainer.this, paramAnonymousFloat, paramAnonymousFloat1, paramAnonymousFloat2)));
      }
    };
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Float.valueOf(this.g);
    arrayOfObject2[1] = Float.valueOf(paramFloat);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofObject(locala2, "alpha", local6, arrayOfObject2);
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet1.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet1.setDuration(paramLong);
    a locala3 = this.a;
    TypeEvaluator local7 = new TypeEvaluator()
    {
      public Float a(float paramAnonymousFloat, Float paramAnonymousFloat1, Float paramAnonymousFloat2)
      {
        return Float.valueOf(GlowingViewContainer.b(GlowingViewContainer.this, GlowingViewContainer.a(GlowingViewContainer.this, paramAnonymousFloat, paramAnonymousFloat1, paramAnonymousFloat2)));
      }
    };
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Float.valueOf(paramFloat);
    arrayOfObject3[1] = Float.valueOf(0.0F);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofObject(locala3, "radius", local7, arrayOfObject3);
    a locala4 = this.a;
    TypeEvaluator local8 = new TypeEvaluator()
    {
      public Float a(float paramAnonymousFloat, Float paramAnonymousFloat1, Float paramAnonymousFloat2)
      {
        return Float.valueOf(GlowingViewContainer.c(GlowingViewContainer.this, GlowingViewContainer.a(GlowingViewContainer.this, paramAnonymousFloat, paramAnonymousFloat1, paramAnonymousFloat2)));
      }
    };
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Float.valueOf(paramFloat);
    arrayOfObject4[1] = Float.valueOf(0.0F);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofObject(locala4, "alpha", local8, arrayOfObject4);
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.setInterpolator(new LinearInterpolator());
    localAnimatorSet2.playTogether(new Animator[] { localObjectAnimator3, localObjectAnimator4 });
    localAnimatorSet2.setDuration(paramLong);
    this.g = paramFloat;
    this.r = new AnimatorSet();
    this.r.playSequentially(new Animator[] { localAnimatorSet1, localAnimatorSet2 });
    this.r.start();
  }

  public void b()
  {
    if (this.q == null)
      return;
    this.q.removeAllListeners();
    this.q.end();
  }

  public void c()
  {
    if (this.r == null)
      return;
    this.r.end();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
    c();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.p = (paramInt1 / getStrokeInitialSize());
    if ((this.r != null) && (!this.r.isRunning()))
    {
      this.a.a(getScaledStartFillRadius());
      this.a.setAlpha(this.e);
    }
  }

  private static class a extends View
  {
    private Paint a;
    private float b;
    private Path c;

    public a(Context paramContext, Paint paramPaint)
    {
      super();
      this.a = paramPaint;
      this.c = new Path();
    }

    public void a(float paramFloat)
    {
      this.b = paramFloat;
      invalidate();
    }

    protected void onDraw(Canvas paramCanvas)
    {
      int i = getWidth() / 2;
      int j = getHeight() / 2;
      h.a(2.0F * this.b, 2.0F * this.b, i - this.b, j - this.b, this.c);
      paramCanvas.drawPath(this.c, this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.animated.GlowingViewContainer
 * JD-Core Version:    0.6.2
 */