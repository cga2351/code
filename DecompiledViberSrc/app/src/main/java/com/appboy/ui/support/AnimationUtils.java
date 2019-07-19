package com.appboy.ui.support;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

public class AnimationUtils
{
  private static Interpolator sAccelerateInterpolator = new AccelerateInterpolator();
  private static Interpolator sDecelerateInterpolator = new DecelerateInterpolator();

  public static Animation createVerticalAnimation(float paramFloat1, float paramFloat2, long paramLong, boolean paramBoolean)
  {
    return setAnimationParams(new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, paramFloat1, 1, paramFloat2), paramLong, paramBoolean);
  }

  public static Animation setAnimationParams(Animation paramAnimation, long paramLong, boolean paramBoolean)
  {
    paramAnimation.setDuration(paramLong);
    if (paramBoolean)
    {
      paramAnimation.setInterpolator(sAccelerateInterpolator);
      return paramAnimation;
    }
    paramAnimation.setInterpolator(sDecelerateInterpolator);
    return paramAnimation;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.support.AnimationUtils
 * JD-Core Version:    0.6.2
 */