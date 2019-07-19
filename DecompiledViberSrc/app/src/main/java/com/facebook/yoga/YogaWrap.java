package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaWrap
{
  private final int mIntValue;

  static
  {
    YogaWrap[] arrayOfYogaWrap = new YogaWrap[3];
    arrayOfYogaWrap[0] = NO_WRAP;
    arrayOfYogaWrap[1] = WRAP;
    arrayOfYogaWrap[2] = WRAP_REVERSE;
  }

  private YogaWrap(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaWrap fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return NO_WRAP;
    case 1:
      return WRAP;
    case 2:
    }
    return WRAP_REVERSE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaWrap
 * JD-Core Version:    0.6.2
 */