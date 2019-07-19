package com.viber.voip.user.viberid.connectaccount.connectsteps.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;

public class EmailContentAnimatorProvider extends StepsAnimator.ContentAnimatorProvider
{
  public EmailContentAnimatorProvider(View paramView1, View paramView2, View[] paramArrayOfView)
  {
    super(paramView1, paramView2, paramArrayOfView);
  }

  public Animator getAnimator(boolean paramBoolean, int paramInt1, int paramInt2, StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo paramDividerOffsetInfo)
  {
    Animator[] arrayOfAnimator2;
    if (paramBoolean)
    {
      arrayOfAnimator2 = new Animator[1 + 2 * this.mViews.length];
      int j = 0;
      int k = 0;
      while (k < 2 * this.mViews.length)
      {
        View localView2 = this.mViews[j];
        Property localProperty2 = View.TRANSLATION_X;
        float[] arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = 0.0F;
        arrayOfFloat2[1] = (-paramInt2);
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localView2, localProperty2, arrayOfFloat2).setDuration(paramInt1);
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mViews[j], View.ALPHA, new float[] { 1.0F, 0.0F }).setDuration(paramInt1);
        arrayOfAnimator2[k] = localObjectAnimator1;
        arrayOfAnimator2[(k + 1)] = localObjectAnimator2;
        k += 2;
        j++;
      }
    }
    Animator[] arrayOfAnimator1;
    for (Object localObject = arrayOfAnimator2; ; localObject = arrayOfAnimator1)
    {
      localObject[(-1 + localObject.length)] = prepareDividerCorrectionAnimator(paramDividerOffsetInfo, paramInt1);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether((Animator[])localObject);
      return localAnimatorSet;
      arrayOfAnimator1 = new Animator[1 + this.mViews.length];
      for (int i = 0; i < this.mViews.length; i++)
      {
        View localView1 = this.mViews[i];
        Property localProperty1 = View.TRANSLATION_X;
        float[] arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = (-paramInt2);
        arrayOfFloat1[1] = 0.0F;
        arrayOfAnimator1[i] = ObjectAnimator.ofFloat(localView1, localProperty1, arrayOfFloat1).setDuration(paramInt1);
      }
    }
  }

  public void init(boolean paramBoolean, int paramInt)
  {
    super.init(paramBoolean, paramInt);
    if (paramBoolean);
    for (float f = 0.0F; ; f = -paramInt)
    {
      View[] arrayOfView = this.mViews;
      int i = arrayOfView.length;
      for (int j = 0; j < i; j++)
        arrayOfView[j].setTranslationX(f);
    }
  }

  public void onAnimationEnd(boolean paramBoolean)
  {
    super.onAnimationEnd(paramBoolean);
    if (paramBoolean)
      for (View localView : this.mViews)
      {
        localView.setTranslationX(0.0F);
        localView.setAlpha(1.0F);
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.animation.EmailContentAnimatorProvider
 * JD-Core Version:    0.6.2
 */