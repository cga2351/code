package com.appnexus.opensdk.transitionanimation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

public class MoveIn
  implements Transition
{
  private static final float[] c = { 0.0F, 0.0F, 1.0F, 0.0F };
  private static final float[] d = { 0.0F, 0.0F, -1.0F, 0.0F };
  private static final float[] e = { -1.0F, 0.0F, 0.0F, 0.0F };
  private static final float[] f = { 1.0F, 0.0F, 0.0F, 0.0F };
  private Animation a;
  private Animation b;

  public MoveIn(long paramLong, TransitionDirection paramTransitionDirection)
  {
    AccelerateInterpolator localAccelerateInterpolator = new AccelerateInterpolator();
    a(a(paramTransitionDirection), localAccelerateInterpolator, paramLong);
    a(localAccelerateInterpolator, paramLong);
  }

  private void a(Interpolator paramInterpolator, long paramLong)
  {
    this.b = new AlphaAnimation(1.0F, 0.0F);
    this.b.setDuration(paramLong);
    this.b.setInterpolator(paramInterpolator);
  }

  private void a(float[] paramArrayOfFloat, Interpolator paramInterpolator, long paramLong)
  {
    this.a = new TranslateAnimation(2, paramArrayOfFloat[0], 2, paramArrayOfFloat[1], 2, paramArrayOfFloat[2], 2, paramArrayOfFloat[3]);
    this.a.setInterpolator(paramInterpolator);
    this.a.setDuration(paramLong);
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
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.MoveIn
 * JD-Core Version:    0.6.2
 */