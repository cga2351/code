package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaMeasureMode
{
  private final int mIntValue;

  static
  {
    EXACTLY = new YogaMeasureMode("EXACTLY", 1, 1);
    AT_MOST = new YogaMeasureMode("AT_MOST", 2, 2);
    YogaMeasureMode[] arrayOfYogaMeasureMode = new YogaMeasureMode[3];
    arrayOfYogaMeasureMode[0] = UNDEFINED;
    arrayOfYogaMeasureMode[1] = EXACTLY;
    arrayOfYogaMeasureMode[2] = AT_MOST;
  }

  private YogaMeasureMode(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaMeasureMode fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return UNDEFINED;
    case 1:
      return EXACTLY;
    case 2:
    }
    return AT_MOST;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaMeasureMode
 * JD-Core Version:    0.6.2
 */