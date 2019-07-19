package com.viber.voip.messages.ui.media.player.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;

public class d
{
  private final a a;
  private final ValueAnimator b;

  public d(a parama)
  {
    this.a = parama;
    this.b = new ValueAnimator().setDuration(100L);
    this.b.setInterpolator(new LinearInterpolator());
    this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        d.a(d.this).a(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    this.b.addListener(new AnimatorListenerAdapter()
    {
      private boolean b;

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.b = true;
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        d.a(d.this).a(this.b);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.b = false;
      }
    });
  }

  public void a()
  {
    if (this.b.isRunning())
      this.b.cancel();
  }

  public void a(Rect paramRect1, Rect paramRect2)
  {
    a();
    int i = paramRect2.left - paramRect1.right;
    int j = paramRect2.right - paramRect1.left;
    if (Math.abs(i) < Math.abs(j));
    while (true)
    {
      ValueAnimator localValueAnimator = this.b;
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = paramRect1.left;
      arrayOfInt[1] = (i + paramRect1.left);
      localValueAnimator.setIntValues(arrayOfInt);
      this.b.start();
      return;
      i = j;
    }
  }

  public boolean b()
  {
    return this.b.isRunning();
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.d
 * JD-Core Version:    0.6.2
 */