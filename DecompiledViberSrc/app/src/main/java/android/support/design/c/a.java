package android.support.design.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class a
{
  public static Animator.AnimatorListener a(d paramd)
  {
    return new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.a.b();
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.a.a();
      }
    };
  }

  public static Animator a(d paramd, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Property localProperty = d.b.a;
    TypeEvaluator localTypeEvaluator = d.a.a;
    d.d[] arrayOfd = new d.d[1];
    arrayOfd[0] = new d.d(paramFloat1, paramFloat2, paramFloat3);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramd, localProperty, localTypeEvaluator, arrayOfd);
    if (Build.VERSION.SDK_INT >= 21)
    {
      d.d locald = paramd.getRevealInfo();
      if (locald == null)
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
      float f = locald.c;
      Animator localAnimator = ViewAnimationUtils.createCircularReveal((View)paramd, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, localAnimator });
      return localAnimatorSet;
    }
    return localObjectAnimator;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.c.a
 * JD-Core Version:    0.6.2
 */