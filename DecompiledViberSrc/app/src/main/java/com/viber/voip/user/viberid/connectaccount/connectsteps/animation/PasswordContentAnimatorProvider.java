package com.viber.voip.user.viberid.connectaccount.connectsteps.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;

public class PasswordContentAnimatorProvider extends StepsAnimator.ContentAnimatorProvider
{
  private static final int CHECKBOX_ALPHA_HIDE_DURATION = 100;
  private static final int CHECKBOX_ALPHA_SHOW_DURATION = 150;
  private static final int CHECKBOX_ALPHA_START_DELAY = 350;
  private static final int FORWARD_DELTA_DELAY = 50;
  private final View mCheckboxView;

  public PasswordContentAnimatorProvider(View paramView1, View paramView2, View paramView3, View[] paramArrayOfView)
  {
    super(paramView1, paramView2, paramArrayOfView);
    this.mCheckboxView = paramView3;
  }

  private Animator prepareCheckboxAnimator(boolean paramBoolean)
  {
    float f1 = 1.0F;
    View localView = this.mCheckboxView;
    Property localProperty = View.ALPHA;
    float[] arrayOfFloat = new float[2];
    float f2;
    label34: long l1;
    label58: ObjectAnimator localObjectAnimator2;
    if (paramBoolean)
    {
      f2 = 0.0F;
      arrayOfFloat[0] = f2;
      if (!paramBoolean)
        break label92;
      arrayOfFloat[1] = f1;
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localView, localProperty, arrayOfFloat);
      if (!paramBoolean)
        break label97;
      l1 = 150L;
      localObjectAnimator2 = localObjectAnimator1.setDuration(l1);
      if (!paramBoolean)
        break label105;
    }
    label92: label97: label105: for (long l2 = 350L; ; l2 = 0L)
    {
      localObjectAnimator2.setStartDelay(l2);
      return localObjectAnimator2;
      f2 = f1;
      break;
      f1 = 0.0F;
      break label34;
      l1 = 100L;
      break label58;
    }
  }

  public Animator getAnimator(boolean paramBoolean, int paramInt1, int paramInt2, StepsAnimator.ContentAnimatorProvider.DividerOffsetInfo paramDividerOffsetInfo)
  {
    Animator[] arrayOfAnimator2;
    if (paramBoolean)
    {
      arrayOfAnimator2 = new Animator[2 + this.mViews.length];
      for (int k = 0; k < this.mViews.length; k++)
      {
        View localView2 = this.mViews[k];
        Property localProperty2 = View.TRANSLATION_X;
        float[] arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = paramInt2;
        arrayOfFloat2[1] = 0.0F;
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localView2, localProperty2, arrayOfFloat2).setDuration(paramInt1);
        localObjectAnimator3.setStartDelay(k * 50);
        arrayOfAnimator2[k] = localObjectAnimator3;
      }
    }
    Animator[] arrayOfAnimator1;
    for (Object localObject = arrayOfAnimator2; ; localObject = arrayOfAnimator1)
    {
      localObject[(-2 + localObject.length)] = prepareDividerCorrectionAnimator(paramDividerOffsetInfo, paramInt1);
      localObject[(-1 + localObject.length)] = prepareCheckboxAnimator(paramBoolean);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether((Animator[])localObject);
      return localAnimatorSet;
      arrayOfAnimator1 = new Animator[2 + 2 * this.mViews.length];
      int i = 0;
      int j = 0;
      while (j < 2 * this.mViews.length)
      {
        View localView1 = this.mViews[i];
        Property localProperty1 = View.TRANSLATION_X;
        float[] arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = 0.0F;
        arrayOfFloat1[1] = paramInt2;
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localView1, localProperty1, arrayOfFloat1).setDuration(paramInt1);
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mViews[i], View.ALPHA, new float[] { 1.0F, 0.0F }).setDuration(paramInt1);
        arrayOfAnimator1[j] = localObjectAnimator1;
        arrayOfAnimator1[(j + 1)] = localObjectAnimator2;
        j += 2;
        i++;
      }
    }
  }

  public void init(boolean paramBoolean, int paramInt)
  {
    super.init(paramBoolean, paramInt);
    if (paramBoolean);
    for (float f = paramInt; ; f = 0.0F)
    {
      View[] arrayOfView = this.mViews;
      int i = arrayOfView.length;
      for (int j = 0; j < i; j++)
        arrayOfView[j].setTranslationX(f);
    }
    if (paramBoolean)
    {
      this.mCheckboxView.setVisibility(0);
      this.mCheckboxView.setAlpha(0.0F);
    }
  }

  public void onAnimationEnd(boolean paramBoolean)
  {
    super.onAnimationEnd(paramBoolean);
    for (View localView : this.mViews)
    {
      localView.setTranslationX(0.0F);
      if (!paramBoolean)
        localView.setAlpha(1.0F);
    }
    if (!paramBoolean)
    {
      this.mCheckboxView.setVisibility(8);
      this.mCheckboxView.setAlpha(1.0F);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.animation.PasswordContentAnimatorProvider
 * JD-Core Version:    0.6.2
 */