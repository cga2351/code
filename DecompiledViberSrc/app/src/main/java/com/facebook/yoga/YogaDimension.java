package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDimension
{
  private final int mIntValue;

  static
  {
    HEIGHT = new YogaDimension("HEIGHT", 1, 1);
    YogaDimension[] arrayOfYogaDimension = new YogaDimension[2];
    arrayOfYogaDimension[0] = WIDTH;
    arrayOfYogaDimension[1] = HEIGHT;
  }

  private YogaDimension(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaDimension fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return WIDTH;
    case 1:
    }
    return HEIGHT;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaDimension
 * JD-Core Version:    0.6.2
 */