package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaNodeType
{
  private final int mIntValue;

  static
  {
    YogaNodeType[] arrayOfYogaNodeType = new YogaNodeType[2];
    arrayOfYogaNodeType[0] = DEFAULT;
    arrayOfYogaNodeType[1] = TEXT;
  }

  private YogaNodeType(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaNodeType fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return DEFAULT;
    case 1:
    }
    return TEXT;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaNodeType
 * JD-Core Version:    0.6.2
 */