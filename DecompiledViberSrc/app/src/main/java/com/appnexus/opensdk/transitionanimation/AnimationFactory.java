package com.appnexus.opensdk.transitionanimation;

import java.util.ArrayList;
import java.util.Collections;

public class AnimationFactory
{
  public static Transition create(TransitionType paramTransitionType, long paramLong, TransitionDirection paramTransitionDirection)
  {
    ArrayList localArrayList;
    if (paramTransitionType == TransitionType.RANDOM)
    {
      localArrayList = new ArrayList();
      Collections.addAll(localArrayList, TransitionType.values());
      localArrayList.remove(TransitionType.NONE);
      localArrayList.remove(TransitionType.RANDOM);
      Collections.shuffle(localArrayList);
    }
    for (TransitionType localTransitionType = (TransitionType)localArrayList.get(0); ; localTransitionType = paramTransitionType)
    {
      switch (1.a[localTransitionType.ordinal()])
      {
      default:
        return null;
      case 1:
        return new Fade(paramLong);
      case 2:
        return new Push(paramLong, paramTransitionDirection);
      case 3:
        return new MoveIn(paramLong, paramTransitionDirection);
      case 4:
      }
      return new Reveal(paramLong, paramTransitionDirection);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.AnimationFactory
 * JD-Core Version:    0.6.2
 */