package com.getkeepsafe.taptargetview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class a
{
  final ValueAnimator a;
  a b;

  protected a()
  {
    this(false);
  }

  protected a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      return;
    }
    this.a = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  }

  public ValueAnimator a()
  {
    if (this.b != null)
      this.a.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          a.this.b.a();
        }
      });
    return this.a;
  }

  public a a(int paramInt)
  {
    this.a.setRepeatCount(paramInt);
    return this;
  }

  public a a(long paramLong)
  {
    this.a.setStartDelay(paramLong);
    return this;
  }

  public a a(TimeInterpolator paramTimeInterpolator)
  {
    this.a.setInterpolator(paramTimeInterpolator);
    return this;
  }

  public a a(a parama)
  {
    this.b = parama;
    return this;
  }

  public a a(final b paramb)
  {
    this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramb.a(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
    return this;
  }

  public a b(long paramLong)
  {
    this.a.setDuration(paramLong);
    return this;
  }

  static abstract interface a
  {
    public abstract void a();
  }

  static abstract interface b
  {
    public abstract void a(float paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.getkeepsafe.taptargetview.a
 * JD-Core Version:    0.6.2
 */