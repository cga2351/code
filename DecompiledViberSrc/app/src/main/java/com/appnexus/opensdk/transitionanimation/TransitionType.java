package com.appnexus.opensdk.transitionanimation;

public enum TransitionType
{
  static
  {
    FADE = new TransitionType("FADE", 2);
    PUSH = new TransitionType("PUSH", 3);
    MOVEIN = new TransitionType("MOVEIN", 4);
    REVEAL = new TransitionType("REVEAL", 5);
    TransitionType[] arrayOfTransitionType = new TransitionType[6];
    arrayOfTransitionType[0] = NONE;
    arrayOfTransitionType[1] = RANDOM;
    arrayOfTransitionType[2] = FADE;
    arrayOfTransitionType[3] = PUSH;
    arrayOfTransitionType[4] = MOVEIN;
    arrayOfTransitionType[5] = REVEAL;
  }

  public static TransitionType getTypeForInt(int paramInt)
  {
    for (TransitionType localTransitionType : values())
      if (localTransitionType.ordinal() == paramInt)
        return localTransitionType;
    return NONE;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.transitionanimation.TransitionType
 * JD-Core Version:    0.6.2
 */