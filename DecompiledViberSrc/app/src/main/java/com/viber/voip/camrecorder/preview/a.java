package com.viber.voip.camrecorder.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

abstract class a extends AnimatorListenerAdapter
{
  private boolean a;

  abstract void a(Animator paramAnimator);

  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a = true;
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.a)
      a(paramAnimator);
  }

  public void onAnimationStart(Animator paramAnimator)
  {
    this.a = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.a
 * JD-Core Version:    0.6.2
 */