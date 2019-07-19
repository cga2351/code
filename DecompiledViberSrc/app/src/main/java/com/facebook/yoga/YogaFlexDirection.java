package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaFlexDirection
{
  private final int mIntValue;

  static
  {
    YogaFlexDirection[] arrayOfYogaFlexDirection = new YogaFlexDirection[4];
    arrayOfYogaFlexDirection[0] = COLUMN;
    arrayOfYogaFlexDirection[1] = COLUMN_REVERSE;
    arrayOfYogaFlexDirection[2] = ROW;
    arrayOfYogaFlexDirection[3] = ROW_REVERSE;
  }

  private YogaFlexDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaFlexDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return COLUMN;
    case 1:
      return COLUMN_REVERSE;
    case 2:
      return ROW;
    case 3:
    }
    return ROW_REVERSE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaFlexDirection
 * JD-Core Version:    0.6.2
 */