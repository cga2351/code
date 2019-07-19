package com.appnexus.opensdk.transitionanimation;

import android.content.Context;
import android.widget.ViewAnimator;

public class Animator extends ViewAnimator
{
  private Transition a = null;
  private TransitionType b;
  private TransitionDirection c;
  private long d;

  public Animator(Context paramContext, TransitionType paramTransitionType, TransitionDirection paramTransitionDirection, long paramLong)
  {
    super(paramContext);
    this.b = paramTransitionType;
    this.c = paramTransitionDirection;
    this.d = paramLong;
  }

  public void clearAnimation()
  {
    setInAnimation(null);
    setOutAnimation(null);
  }

  public TransitionDirection getTransitionDirection()
  {
    return this.c;
  }

  public long getTransitionDuration()
  {
    return this.d;
  }

  public TransitionType getTransitionType()
  {
    return this.b;
  }

  public void setAnimation()
  {
    if (this.a != null)
    {
      setInAnimation(this.a.getInAnimation());
      setOutAnimation(this.a.getOutAnimation());
    }
  }

  public void setTransitionDirection(TransitionDirection paramTransitionDirection)
  {
    if (this.c != paramTransitionDirection)
    {
      this.c = paramTransitionDirection;
      this.a = AnimationFactory.create(this.b, this.d, paramTransitionDirection);
      setAnimation();
    }
  }

  public void setTransitionDuration(long paramLong)
  {
    if (this.d != paramLong)
    {
      this.d = paramLong;
      this.a = AnimationFactory.create(this.b, paramLong, this.c);
      setAnimation();
    }
  }

  public void setTransitionType(TransitionType paramTransitionType)
  {
    if (this.b != paramTransitionType)
    {
      this.b = paramTransitionType;
      this.a = AnimationFactory.create(paramTransitionType, this.d, this.c);
      setAnimation();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.Animator
 * JD-Core Version:    0.6.2
 */