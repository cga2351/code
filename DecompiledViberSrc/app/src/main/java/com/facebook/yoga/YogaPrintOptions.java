package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaPrintOptions
{
  private final int mIntValue;

  static
  {
    CHILDREN = new YogaPrintOptions("CHILDREN", 2, 4);
    YogaPrintOptions[] arrayOfYogaPrintOptions = new YogaPrintOptions[3];
    arrayOfYogaPrintOptions[0] = LAYOUT;
    arrayOfYogaPrintOptions[1] = STYLE;
    arrayOfYogaPrintOptions[2] = CHILDREN;
  }

  private YogaPrintOptions(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaPrintOptions fromInt(int paramInt)
  {
    switch (paramInt)
    {
    case 3:
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 1:
      return LAYOUT;
    case 2:
      return STYLE;
    case 4:
    }
    return CHILDREN;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaPrintOptions
 * JD-Core Version:    0.6.2
 */