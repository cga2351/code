package com.viber.voip.engagement.carousel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.viber.voip.util.cl;

class a
{
  private static final float[] a = { 1.0F, 0.0F };
  private static final float[] b = { 0.0F, 1.1F, 1.0F };
  private a c = (a)cl.b(a.class);
  private AnimatorSet d;
  private final ValueAnimator e;
  private final ValueAnimator f;
  private final CarouselLinearLayoutManager g;

  a(CarouselLinearLayoutManager paramCarouselLinearLayoutManager)
  {
    this.g = paramCarouselLinearLayoutManager;
    this.e = ValueAnimator.ofFloat(a);
    this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.a(a.this).d(f1);
        float f2 = 0.3F + f1 * 0.7F;
        a.a(a.this).c(f2);
      }
    });
    this.e.setDuration(300L);
    this.e.setInterpolator(new AccelerateDecelerateInterpolator());
    this.e.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        a.b(a.this).b();
      }
    });
    this.f = ValueAnimator.ofFloat(b);
    this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.a(a.this).d(f);
      }
    });
    this.f.setDuration(600L);
    this.f.setInterpolator(new AccelerateDecelerateInterpolator());
    this.f.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.a(a.this).c(1.0F);
      }
    });
  }

  void a()
  {
    this.d = new AnimatorSet();
    this.d.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        a.a(a.this).c(1.0F);
        a.a(a.this).d(1.0F);
        a.b(a.this).c();
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.b(a.this).a();
      }
    });
    AnimatorSet localAnimatorSet = this.d;
    Animator[] arrayOfAnimator = new Animator[2];
    arrayOfAnimator[0] = this.e;
    arrayOfAnimator[1] = this.f;
    localAnimatorSet.playSequentially(arrayOfAnimator);
    this.d.start();
  }

  public void a(a parama)
  {
    this.c = parama;
  }

  void b()
  {
    if ((this.d != null) && (this.d.isRunning()))
    {
      this.d.end();
      this.d = null;
    }
  }

  static abstract interface a
  {
    public abstract void a();

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.a
 * JD-Core Version:    0.6.2
 */