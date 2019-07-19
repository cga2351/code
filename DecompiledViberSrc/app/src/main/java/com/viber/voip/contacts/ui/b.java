package com.viber.voip.contacts.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.viber.voip.R.dimen;

public class b
{
  private final int a;
  private int b = 0;
  private View c;
  private View d;
  private int e;
  private int f;
  private Context g;
  private ViewGroup h;
  private ViewGroup i;
  private ViewGroup j;
  private ViewGroup k;
  private LayoutInflater l;

  public b(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, LayoutInflater paramLayoutInflater)
  {
    this.g = paramContext;
    this.h = paramViewGroup1;
    this.i = paramViewGroup2;
    this.l = paramLayoutInflater;
    this.a = paramContext.getResources().getDimensionPixelSize(R.dimen.contact_details_photo_top_left_margin);
  }

  private void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, float paramFloat4, Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { paramFloat1, paramFloat2 });
    View localView1 = this.d;
    float[] arrayOfFloat1 = new float[1];
    arrayOfFloat1[0] = paramInt1;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localView1, "translationX", arrayOfFloat1);
    View localView2 = this.d;
    float[] arrayOfFloat2 = new float[1];
    arrayOfFloat2[0] = paramInt2;
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localView2, "translationY", arrayOfFloat2);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.d, "scaleX", new float[] { paramFloat3, paramFloat4 });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.d, "scaleY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).with(localObjectAnimator5);
    localAnimatorSet.setDuration(500L);
    if (paramAnimatorListener != null)
      localAnimatorSet.addListener(paramAnimatorListener);
    localAnimatorSet.start();
  }

  private void b()
  {
    this.b = 4;
    a(1.0F, 0.0F, 0, 0, 1.4F, 1.0F, new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        b.b(b.this).removeView(b.a(b.this));
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)b.c(b.this).getLayoutParams();
        b.d(b.this).removeView(b.c(b.this));
        localLayoutParams.leftMargin = b.e(b.this);
        localLayoutParams.topMargin = b.f(b.this);
        localLayoutParams.gravity = 51;
        b.c(b.this).setLayoutParams(localLayoutParams);
        b.c(b.this).requestLayout();
        b.g(b.this).addView(b.c(b.this));
        b.a(b.this, 2);
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
  }

  public boolean a()
  {
    if ((this.b == 1) && (this.b != 4))
    {
      b();
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.b
 * JD-Core Version:    0.6.2
 */