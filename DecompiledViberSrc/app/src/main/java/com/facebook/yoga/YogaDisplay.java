package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDisplay
{
  private final int mIntValue;

  static
  {
    YogaDisplay[] arrayOfYogaDisplay = new YogaDisplay[2];
    arrayOfYogaDisplay[0] = FLEX;
    arrayOfYogaDisplay[1] = NONE;
  }

  private YogaDisplay(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaDisplay fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return FLEX;
    case 1:
    }
    return NONE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaDisplay
 * JD-Core Version:    0.6.2
 */