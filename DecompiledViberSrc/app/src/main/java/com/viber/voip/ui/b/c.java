package com.viber.voip.ui.b;

import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

public final class c
{
  public static final Interpolator a = new LinearInterpolator();
  public static final Interpolator b = new FastOutSlowInInterpolator();
  public static final Interpolator c = PathInterpolatorCompat.create(0.0F, 0.0F, 0.2F, 1.0F);
  public static final Interpolator d = PathInterpolatorCompat.create(0.4F, 0.0F, 1.0F, 1.0F);
  public static final Interpolator e = new AccelerateInterpolator();
  public static final Interpolator f = new DecelerateInterpolator();
  public static final Interpolator g = new OvershootInterpolator();
  public static final Interpolator h = new AnticipateInterpolator();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.b.c
 * JD-Core Version:    0.6.2
 */