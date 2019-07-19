package com.appnexus.opensdk.transitionanimation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

public class Push
  implements Transition
{
  private static final float[] c = { 0.0F, 0.0F, 1.0F, 0.0F };
  private static final float[] d = { 0.0F, 0.0F, -1.0F, 0.0F };
  private static final float[] e = { -1.0F, 0.0F, 0.0F, 0.0F };
  private static final float[] f = { 1.0F, 0.0F, 0.0F, 0.0F };
  private static final float[] g = { 0.0F, 0.0F, 0.0F, -1.0F };
  private static final float[] h = { 0.0F, 0.0F, 0.0F, 1.0F };
  private static final float[] i = { 0.0F, 1.0F, 0.0F, 0.0F };
  private static final float[] j = { 0.0F, -1.0F, 0.0F, 0.0F };
  private Animation a;
  private Animation b;

  public Push(long paramLong, TransitionDirection paramTransitionDirection)
  {
    AccelerateInterpolator localAccelerateInterpolator = new AccelerateInterpolator();
    this.a = a(a(paramTransitionDirection), localAccelerateInterpolator, paramLong);
    this.b = a(b(paramTransitionDirection), localAccelerateInterpolator, paramLong);
  }

  private Animation a(float[] paramArrayOfFloat, Interpolator paramInterpolator, long paramLong)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, paramArrayOfFloat[0], 2, paramArrayOfFloat[1], 2, paramArrayOfFloat[2], 2, paramArrayOfFloat[3]);
    localTranslateAnimation.setInterpolator(paramInterpolator);
    localTranslateAnimation.setDuration(paramLong);
    return localTranslateAnimation;
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

  private float[] b(TransitionDirection paramTransitionDirection)
  {
    switch (1.a[paramTransitionDirection.ordinal()])
    {
    default:
      return g;
    case 1:
      return g;
    case 2:
      return h;
    case 3:
      return i;
    case 4:
    }
    return j;
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
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.Push
 * JD-Core Version:    0.6.2
 */