package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

public class b
{
  public static void a(AnimatorSet paramAnimatorSet, List<Animator> paramList)
  {
    int i = paramList.size();
    long l = 0L;
    for (int j = 0; j < i; j++)
    {
      Animator localAnimator = (Animator)paramList.get(j);
      l = Math.max(l, localAnimator.getStartDelay() + localAnimator.getDuration());
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 0 });
    localValueAnimator.setDuration(l);
    paramList.add(0, localValueAnimator);
    paramAnimatorSet.playTogether(paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.b
 * JD-Core Version:    0.6.2
 */