package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaUnit
{
  private final int mIntValue;

  static
  {
    POINT = new YogaUnit("POINT", 1, 1);
    PERCENT = new YogaUnit("PERCENT", 2, 2);
    AUTO = new YogaUnit("AUTO", 3, 3);
    YogaUnit[] arrayOfYogaUnit = new YogaUnit[4];
    arrayOfYogaUnit[0] = UNDEFINED;
    arrayOfYogaUnit[1] = POINT;
    arrayOfYogaUnit[2] = PERCENT;
    arrayOfYogaUnit[3] = AUTO;
  }

  private YogaUnit(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaUnit fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return UNDEFINED;
    case 1:
      return POINT;
    case 2:
      return PERCENT;
    case 3:
    }
    return AUTO;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaUnit
 * JD-Core Version:    0.6.2
 */