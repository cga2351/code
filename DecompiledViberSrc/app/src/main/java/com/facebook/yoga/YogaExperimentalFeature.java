package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaExperimentalFeature
{
  private final int mIntValue;

  static
  {
    YogaExperimentalFeature[] arrayOfYogaExperimentalFeature = new YogaExperimentalFeature[1];
    arrayOfYogaExperimentalFeature[0] = WEB_FLEX_BASIS;
  }

  private YogaExperimentalFeature(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaExperimentalFeature fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
    }
    return WEB_FLEX_BASIS;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaExperimentalFeature
 * JD-Core Version:    0.6.2
 */