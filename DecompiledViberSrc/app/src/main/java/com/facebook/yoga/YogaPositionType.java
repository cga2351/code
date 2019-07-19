package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaPositionType
{
  private final int mIntValue;

  static
  {
    ABSOLUTE = new YogaPositionType("ABSOLUTE", 1, 1);
    YogaPositionType[] arrayOfYogaPositionType = new YogaPositionType[2];
    arrayOfYogaPositionType[0] = RELATIVE;
    arrayOfYogaPositionType[1] = ABSOLUTE;
  }

  private YogaPositionType(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaPositionType fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return RELATIVE;
    case 1:
    }
    return ABSOLUTE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaPositionType
 * JD-Core Version:    0.6.2
 */