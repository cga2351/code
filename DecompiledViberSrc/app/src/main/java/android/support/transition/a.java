package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import java.util.ArrayList;

class a
{
  static void a(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 19)
      paramAnimator.pause();
    while (true)
    {
      return;
      ArrayList localArrayList = paramAnimator.getListeners();
      if (localArrayList != null)
      {
        int i = localArrayList.size();
        for (int j = 0; j < i; j++)
        {
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(j);
          if ((localAnimatorListener instanceof a))
            ((a)localAnimatorListener).onAnimationPause(paramAnimator);
        }
      }
    }
  }

  static void a(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    if (Build.VERSION.SDK_INT >= 19)
      paramAnimator.addPauseListener(paramAnimatorListenerAdapter);
  }

  static void b(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 19)
      paramAnimator.resume();
    while (true)
    {
      return;
      ArrayList localArrayList = paramAnimator.getListeners();
      if (localArrayList != null)
      {
        int i = localArrayList.size();
        for (int j = 0; j < i; j++)
        {
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(j);
          if ((localAnimatorListener instanceof a))
            ((a)localAnimatorListener).onAnimationResume(paramAnimator);
        }
      }
    }
  }

  static abstract interface a
  {
    public abstract void onAnimationPause(Animator paramAnimator);

    public abstract void onAnimationResume(Animator paramAnimator);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.a
 * JD-Core Version:    0.6.2
 */