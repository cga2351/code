package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class StateListAnimator
{
  private final Animator.AnimatorListener animationListener = new AnimatorListenerAdapter()
  {
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (StateListAnimator.this.runningAnimator == paramAnonymousAnimator)
        StateListAnimator.this.runningAnimator = null;
    }
  };
  private Tuple lastMatch = null;
  ValueAnimator runningAnimator = null;
  private final ArrayList<Tuple> tuples = new ArrayList();

  private void cancel()
  {
    if (this.runningAnimator != null)
    {
      this.runningAnimator.cancel();
      this.runningAnimator = null;
    }
  }

  private void start(Tuple paramTuple)
  {
    this.runningAnimator = paramTuple.animator;
    this.runningAnimator.start();
  }

  public void addState(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    Tuple localTuple = new Tuple(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.animationListener);
    this.tuples.add(localTuple);
  }

  public void jumpToCurrentState()
  {
    if (this.runningAnimator != null)
    {
      this.runningAnimator.end();
      this.runningAnimator = null;
    }
  }

  public void setState(int[] paramArrayOfInt)
  {
    int i = this.tuples.size();
    int j = 0;
    Tuple localTuple;
    if (j < i)
    {
      localTuple = (Tuple)this.tuples.get(j);
      if (!StateSet.stateSetMatches(localTuple.specs, paramArrayOfInt));
    }
    while (true)
    {
      if (localTuple == this.lastMatch);
      do
      {
        return;
        j++;
        break;
        if (this.lastMatch != null)
          cancel();
        this.lastMatch = localTuple;
      }
      while (localTuple == null);
      start(localTuple);
      return;
      localTuple = null;
    }
  }

  static class Tuple
  {
    final ValueAnimator animator;
    final int[] specs;

    Tuple(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.specs = paramArrayOfInt;
      this.animator = paramValueAnimator;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.StateListAnimator
 * JD-Core Version:    0.6.2
 */