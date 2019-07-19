package com.viber.voip.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class c extends AnimatorListenerAdapter
{
  protected boolean b;

  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b = true;
  }

  public void onAnimationStart(Animator paramAnimator)
  {
    this.b = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.c
 * JD-Core Version:    0.6.2
 */