package com.viber.voip.ui.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import com.viber.voip.R.id;
import com.viber.voip.util.ca;
import com.viber.voip.util.dj;

public final class a
{
  public static Animator a(View paramView, int paramInt)
  {
    return a(paramView, paramInt, c.b);
  }

  public static Animator a(View paramView, int paramInt, Interpolator paramInterpolator)
  {
    paramView.setAlpha(0.0F);
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F }), PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F }) });
    localObjectAnimator.setInterpolator(paramInterpolator);
    localObjectAnimator.addListener(new b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a.setAlpha(1.0F);
        this.a.setScaleX(1.0F);
        this.a.setScaleY(1.0F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.a.setVisibility(0);
      }
    });
    localObjectAnimator.setStartDelay(paramInt);
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.start();
    return localObjectAnimator;
  }

  public static Animator a(View paramView, final int paramInt, boolean paramBoolean, long paramLong)
  {
    int i;
    int j;
    if (paramView.getVisibility() == 0)
    {
      i = 1;
      dj.b(paramView, true);
      if (!paramBoolean)
        break label93;
      j = 0;
      label22: if (!paramBoolean)
        break label99;
    }
    while (true)
    {
      if ((((Integer)ca.a((Integer)paramView.getTag(R.id.tag_pendingAnimationToHeight), Integer.valueOf(paramView.getLayoutParams().height))).intValue() != paramInt) || ((i == 0) && (paramInt != 0)))
        break label104;
      return ValueAnimator.ofInt(new int[] { 0, 0 }).setDuration(0L);
      i = 0;
      break;
      label93: j = paramInt;
      break label22;
      label99: paramInt = 0;
    }
    label104: float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = j;
    arrayOfFloat1[1] = paramInt;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(arrayOfFloat1);
    localValueAnimator.addUpdateListener(new b(paramView));
    localValueAnimator.addListener(new b()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.a.getLayoutParams().height = paramInt;
        this.a.setLayoutParams(this.a.getLayoutParams());
        this.a.setTag(R.id.tag_pendingAnimationToHeight, null);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.a.setTag(R.id.tag_pendingAnimationToHeight, Integer.valueOf(paramInt));
      }
    });
    int k;
    if (paramBoolean)
    {
      k = 0;
      if (!paramBoolean)
        break label263;
    }
    label263: for (final int m = 1; ; m = 0)
    {
      Property localProperty = View.ALPHA;
      float[] arrayOfFloat2 = new float[2];
      arrayOfFloat2[0] = k;
      arrayOfFloat2[1] = m;
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, localProperty, arrayOfFloat2);
      localObjectAnimator.addListener(new b()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          this.a.setAlpha(m);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, localValueAnimator });
      localAnimatorSet.setDuration(paramLong);
      return localAnimatorSet;
      k = 1;
      break;
    }
  }

  public static ValueAnimator a(View paramView, int paramInt1, final int paramInt2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramInt1;
    arrayOfFloat[1] = paramInt2;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(arrayOfFloat);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        this.a.getLayoutParams().height = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        this.a.requestLayout();
      }
    });
    localValueAnimator.addListener(new b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a.getLayoutParams().height = paramInt2;
        this.a.requestLayout();
      }
    });
    return localValueAnimator;
  }

  public static void a(View paramView)
  {
    a(paramView, -1L, c.a);
  }

  public static void a(View paramView, float paramFloat1, final float paramFloat2, long paramLong, Interpolator paramInterpolator)
  {
    a(paramView, paramFloat1, paramFloat2, paramLong, paramInterpolator, new b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a.setTranslationY(paramFloat2);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        dj.b(this.a, true);
      }
    });
  }

  private static void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    paramView.setTranslationY(paramFloat1);
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    localViewPropertyAnimator.cancel();
    localViewPropertyAnimator.translationY(paramFloat2);
    if (paramLong >= 0L)
      localViewPropertyAnimator.setDuration(paramLong);
    localViewPropertyAnimator.setInterpolator(paramInterpolator);
    localViewPropertyAnimator.setListener(paramAnimatorListener);
    localViewPropertyAnimator.start();
  }

  public static void a(View paramView, long paramLong, Interpolator paramInterpolator)
  {
    paramView.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    localViewPropertyAnimator.cancel();
    if (com.viber.common.d.a.a())
      localViewPropertyAnimator.withLayer();
    localViewPropertyAnimator.alpha(1.0F);
    if (paramLong >= 0L)
      localViewPropertyAnimator.setDuration(paramLong);
    localViewPropertyAnimator.setInterpolator(paramInterpolator);
    localViewPropertyAnimator.setListener(new b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a.setAlpha(1.0F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.a.setVisibility(0);
      }
    });
    localViewPropertyAnimator.start();
  }

  public static Animator b(View paramView, int paramInt, Interpolator paramInterpolator)
  {
    ObjectAnimator localObjectAnimator = c(paramView, paramInt, paramInterpolator);
    localObjectAnimator.start();
    return localObjectAnimator;
  }

  public static ObjectAnimator b(View paramView, int paramInt)
  {
    return c(paramView, paramInt, c.b);
  }

  public static void b(View paramView)
  {
    b(paramView, -1L, c.a);
  }

  public static void b(View paramView, float paramFloat1, final float paramFloat2, long paramLong, Interpolator paramInterpolator)
  {
    a(paramView, paramFloat1, paramFloat2, paramLong, paramInterpolator, new b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a.setTranslationY(paramFloat2);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        dj.b(this.a, false);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        dj.b(this.a, true);
      }
    });
  }

  public static void b(View paramView, long paramLong, Interpolator paramInterpolator)
  {
    paramView.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    localViewPropertyAnimator.cancel();
    if (com.viber.common.d.a.a())
      localViewPropertyAnimator.withLayer();
    localViewPropertyAnimator.alpha(0.0F);
    if (paramLong >= 0L)
      localViewPropertyAnimator.setDuration(paramLong);
    localViewPropertyAnimator.setInterpolator(paramInterpolator);
    localViewPropertyAnimator.setListener(new b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a.setVisibility(8);
        this.a.setAlpha(1.0F);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.a.setVisibility(8);
        this.a.setAlpha(1.0F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.a.setVisibility(0);
      }
    });
    localViewPropertyAnimator.start();
  }

  public static ObjectAnimator c(View paramView, int paramInt, Interpolator paramInterpolator)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.0F }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.4F }) });
    localObjectAnimator.setInterpolator(paramInterpolator);
    localObjectAnimator.addListener(new b()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a.setScaleX(0.0F);
        this.a.setScaleY(0.0F);
        this.a.setVisibility(8);
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.a.setVisibility(8);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.a.setVisibility(0);
      }
    });
    localObjectAnimator.setStartDelay(paramInt);
    localObjectAnimator.setDuration(300L);
    return localObjectAnimator;
  }

  public static class a
    implements Animation.AnimationListener
  {
    public void onAnimationEnd(Animation paramAnimation)
    {
    }

    public void onAnimationRepeat(Animation paramAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnimation)
    {
    }
  }

  public static class b
    implements Animator.AnimatorListener
  {
    public void onAnimationCancel(Animator paramAnimator)
    {
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
    }

    public void onAnimationRepeat(Animator paramAnimator)
    {
    }

    public void onAnimationStart(Animator paramAnimator)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.b.a
 * JD-Core Version:    0.6.2
 */