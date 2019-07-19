package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;

abstract class IndeterminateProgressDrawableBase extends ProgressDrawableBase
  implements Animatable
{
  protected Animator[] mAnimators;

  public IndeterminateProgressDrawableBase(Context paramContext)
  {
    super(paramContext);
  }

  private boolean isStarted()
  {
    Animator[] arrayOfAnimator = this.mAnimators;
    int i = arrayOfAnimator.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfAnimator[j].isStarted())
          bool = true;
      }
      else
        return bool;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (isStarted())
      invalidateSelf();
  }

  public boolean isRunning()
  {
    Animator[] arrayOfAnimator = this.mAnimators;
    int i = arrayOfAnimator.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfAnimator[j].isRunning())
          bool = true;
      }
      else
        return bool;
    }
  }

  public void start()
  {
    if (isStarted())
      return;
    Animator[] arrayOfAnimator = this.mAnimators;
    int i = arrayOfAnimator.length;
    for (int j = 0; j < i; j++)
      arrayOfAnimator[j].start();
    invalidateSelf();
  }

  public void stop()
  {
    Animator[] arrayOfAnimator = this.mAnimators;
    int i = arrayOfAnimator.length;
    for (int j = 0; j < i; j++)
      arrayOfAnimator[j].end();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawableBase
 * JD-Core Version:    0.6.2
 */