package com.viber.voip.u.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.viber.voip.R.color;
import com.viber.voip.util.dj;

class e
  implements c.a, f.b
{
  private View a;
  private View b;
  private final Interpolator c = new OvershootInterpolator(0.7F);
  private final Interpolator d = new AnticipateOvershootInterpolator(0.7F);
  private final int e;
  private final int f;

  e(Context paramContext)
  {
    this.e = ContextCompat.getColor(paramContext, R.color.transparent);
    this.f = ContextCompat.getColor(paramContext, R.color.solid_60);
  }

  private Animator a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.e;
      if (!paramBoolean)
        break label91;
    }
    label91: for (int j = this.f; ; j = this.e)
    {
      ArgbEvaluator localArgbEvaluator = new ArgbEvaluator();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = Integer.valueOf(j);
      ValueAnimator localValueAnimator = ValueAnimator.ofObject(localArgbEvaluator, arrayOfObject);
      localValueAnimator.setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          e.a(e.this).setBackgroundColor(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
      });
      return localValueAnimator;
      i = this.f;
      break;
    }
  }

  private void a(Interpolator paramInterpolator, float paramFloat, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    ViewCompat.animate(this.a).translationY(paramFloat).setDuration(a.a).setInterpolator(paramInterpolator).setListener(paramViewPropertyAnimatorListener).start();
  }

  private void b()
  {
    c();
    dj.a(this.b, null);
    this.b.setVisibility(8);
  }

  private void c()
  {
    this.a.setTranslationX(0.0F);
    this.a.setTranslationY(0.0F);
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
  }

  public Animator a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    this.a.getLocationOnScreen(arrayOfInt);
    int i = paramArrayOfInt1[0] - arrayOfInt[0];
    int j = paramArrayOfInt1[1] - arrayOfInt[1];
    int k = Math.min(this.a.getWidth(), this.a.getHeight());
    float f1 = paramArrayOfInt2[0] / k;
    float f2 = paramArrayOfInt2[1] / k;
    View localView1 = this.a;
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = (i - this.a.getWidth() * (1.0F - f1) / 2.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localView1, "translationX", arrayOfFloat1).setDuration(a.a);
    View localView2 = this.a;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = (j - this.a.getHeight() * (1.0F - f2) / 2.0F);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localView2, "translationY", arrayOfFloat2).setDuration(a.a);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.a, "scaleX", new float[] { 1.0F, f1 }).setDuration(a.a);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.a, "scaleY", new float[] { 1.0F, f2 }).setDuration(a.a);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Animator[] arrayOfAnimator = new Animator[5];
    arrayOfAnimator[0] = localObjectAnimator1;
    arrayOfAnimator[1] = localObjectAnimator2;
    arrayOfAnimator[2] = localObjectAnimator3;
    arrayOfAnimator[3] = localObjectAnimator4;
    arrayOfAnimator[4] = a(false);
    localAnimatorSet.playTogether(arrayOfAnimator);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        e.d(e.this);
      }
    });
    return localAnimatorSet;
  }

  f.b a(View paramView)
  {
    this.a = paramView;
    this.b = ((View)this.a.getParent());
    return this;
  }

  public void a()
  {
    a(true).start();
  }

  public void a(final Runnable paramRunnable)
  {
    this.b.setVisibility(0);
    dj.b(this.a, new Runnable()
    {
      public void run()
      {
        e.b(e.this).setTranslationY(e.a(e.this).getBottom());
        e.a(e.this, e.c(e.this), 0.0F, new ViewPropertyAnimatorListenerAdapter()
        {
          public void onAnimationEnd(View paramAnonymous2View)
          {
            if (e.1.this.a != null)
              e.1.this.a.run();
          }
        });
      }
    });
  }

  public void b(final Runnable paramRunnable)
  {
    a(this.d, this.b.getBottom() - this.a.getTop(), new ViewPropertyAnimatorListenerAdapter()
    {
      public void onAnimationEnd(View paramAnonymousView)
      {
        e.d(e.this);
        if (paramRunnable != null)
          paramRunnable.run();
      }

      public void onAnimationStart(View paramAnonymousView)
      {
        e.a(e.this, false).start();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.a.e
 * JD-Core Version:    0.6.2
 */