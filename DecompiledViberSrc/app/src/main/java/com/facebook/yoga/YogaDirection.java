package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDirection
{
  private final int mIntValue;

  static
  {
    YogaDirection[] arrayOfYogaDirection = new YogaDirection[3];
    arrayOfYogaDirection[0] = INHERIT;
    arrayOfYogaDirection[1] = LTR;
    arrayOfYogaDirection[2] = RTL;
  }

  private YogaDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return INHERIT;
    case 1:
      return LTR;
    case 2:
    }
    return RTL;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaDirection
 * JD-Core Version:    0.6.2
 */