package com.appnexus.opensdk.transitionanimation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

public class Fade
  implements Transition
{
  private Animation a;
  private Animation b;

  public Fade(long paramLong)
  {
    AccelerateInterpolator localAccelerateInterpolator = new AccelerateInterpolator();
    a(localAccelerateInterpolator, paramLong);
    b(localAccelerateInterpolator, paramLong);
  }

  private void a(Interpolator paramInterpolator, long paramLong)
  {
    this.a = new AlphaAnimation(0.0F, 1.0F);
    this.a.setDuration(paramLong);
    this.a.setInterpolator(paramInterpolator);
  }

  private void b(Interpolator paramInterpolator, long paramLong)
  {
    this.b = new AlphaAnimation(1.0F, 0.0F);
    this.b.setDuration(paramLong);
    this.b.setInterpolator(paramInterpolator);
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
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.Fade
 * JD-Core Version:    0.6.2
 */