package com.viber.voip.settings.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.viber.voip.R.color;

public class aj
{
  private final View a;
  private AnimatorSet b;

  public aj(View paramView)
  {
    this.a = paramView;
  }

  private ValueAnimator a(View paramView)
  {
    Context localContext = paramView.getContext();
    int i = ContextCompat.getColor(localContext, R.color.negative);
    int j = ContextCompat.getColor(localContext, R.color.grey_light);
    ArgbEvaluator localArgbEvaluator = new ArgbEvaluator();
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = Integer.valueOf(j);
    arrayOfObject[2] = Integer.valueOf(i);
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(localArgbEvaluator, arrayOfObject);
    localValueAnimator.addUpdateListener(new ak(paramView));
    localValueAnimator.setDuration(500L);
    return localValueAnimator;
  }

  public void a()
  {
    this.b = new AnimatorSet();
    AnimatorSet localAnimatorSet = this.b;
    Animator[] arrayOfAnimator = new Animator[3];
    arrayOfAnimator[0] = a(this.a);
    arrayOfAnimator[1] = a(this.a);
    arrayOfAnimator[2] = a(this.a);
    localAnimatorSet.playSequentially(arrayOfAnimator);
    this.b.start();
  }

  public void b()
  {
    if (this.b != null)
      this.b.cancel();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.aj
 * JD-Core Version:    0.6.2
 */