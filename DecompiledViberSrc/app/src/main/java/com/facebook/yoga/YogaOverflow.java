package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaOverflow
{
  private final int mIntValue;

  static
  {
    HIDDEN = new YogaOverflow("HIDDEN", 1, 1);
    SCROLL = new YogaOverflow("SCROLL", 2, 2);
    YogaOverflow[] arrayOfYogaOverflow = new YogaOverflow[3];
    arrayOfYogaOverflow[0] = VISIBLE;
    arrayOfYogaOverflow[1] = HIDDEN;
    arrayOfYogaOverflow[2] = SCROLL;
  }

  private YogaOverflow(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaOverflow fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return VISIBLE;
    case 1:
      return HIDDEN;
    case 2:
    }
    return SCROLL;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaOverflow
 * JD-Core Version:    0.6.2
 */