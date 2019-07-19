package com.appnexus.opensdk.transitionanimation;

public enum TransitionDirection
{
  static
  {
    DOWN = new TransitionDirection("DOWN", 1);
    RIGHT = new TransitionDirection("RIGHT", 2);
    LEFT = new TransitionDirection("LEFT", 3);
    TransitionDirection[] arrayOfTransitionDirection = new TransitionDirection[4];
    arrayOfTransitionDirection[0] = UP;
    arrayOfTransitionDirection[1] = DOWN;
    arrayOfTransitionDirection[2] = RIGHT;
    arrayOfTransitionDirection[3] = LEFT;
  }

  public static TransitionDirection getDirectionForInt(int paramInt)
  {
    for (TransitionDirection localTransitionDirection : values())
      if (localTransitionDirection.ordinal() == paramInt)
        return localTransitionDirection;
    return UP;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.TransitionDirection
 * JD-Core Version:    0.6.2
 */