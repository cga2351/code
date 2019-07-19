package com.appnexus.opensdk.transitionanimation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

public class Reveal
  implements Transition
{
  private static final float[] c = { 0.0F, 0.0F, 0.0F, -1.0F };
  private static final float[] d = { 0.0F, 0.0F, 0.0F, 1.0F };
  private static final float[] e = { 0.0F, 1.0F, 0.0F, 0.0F };
  private static final float[] f = { 0.0F, -1.0F, 0.0F, 0.0F };
  private Animation a;
  private Animation b;

  public Reveal(long paramLong, TransitionDirection paramTransitionDirection)
  {
    AccelerateInterpolator localAccelerateInterpolator = new AccelerateInterpolator();
    a(localAccelerateInterpolator, paramLong);
    a(a(paramTransitionDirection), localAccelerateInterpolator, paramLong);
  }

  private void a(Interpolator paramInterpolator, long paramLong)
  {
    this.a = new AlphaAnimation(0.0F, 1.0F);
    this.a.setDuration(paramLong);
    this.a.setInterpolator(paramInterpolator);
  }

  private void a(float[] paramArrayOfFloat, Interpolator paramInterpolator, long paramLong)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, paramArrayOfFloat[0], 2, paramArrayOfFloat[1], 2, paramArrayOfFloat[2], 2, paramArrayOfFloat[3]);
    localTranslateAnimation.setInterpolator(paramInterpolator);
    localTranslateAnimation.setDuration(paramLong);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramLong);
    localAlphaAnimation.setInterpolator(paramInterpolator);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.b = localAnimationSet;
  }

  private float[] a(TransitionDirection paramTransitionDirection)
  {
    switch (1.a[paramTransitionDirection.ordinal()])
    {
    default:
      return c;
    case 1:
      return c;
    case 2:
      return d;
    case 3:
      return e;
    case 4:
    }
    return f;
  }

  public Animation getInAnimation()
  {
    return this.a;
  }

  public Animation getOutAnimation()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.Reveal
 * JD-Core Version:    0.6.2
 */