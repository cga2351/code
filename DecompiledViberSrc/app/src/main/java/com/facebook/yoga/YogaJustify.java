package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaJustify
{
  private final int mIntValue;

  static
  {
    CENTER = new YogaJustify("CENTER", 1, 1);
    FLEX_END = new YogaJustify("FLEX_END", 2, 2);
    SPACE_BETWEEN = new YogaJustify("SPACE_BETWEEN", 3, 3);
    SPACE_AROUND = new YogaJustify("SPACE_AROUND", 4, 4);
    SPACE_EVENLY = new YogaJustify("SPACE_EVENLY", 5, 5);
    YogaJustify[] arrayOfYogaJustify = new YogaJustify[6];
    arrayOfYogaJustify[0] = FLEX_START;
    arrayOfYogaJustify[1] = CENTER;
    arrayOfYogaJustify[2] = FLEX_END;
    arrayOfYogaJustify[3] = SPACE_BETWEEN;
    arrayOfYogaJustify[4] = SPACE_AROUND;
    arrayOfYogaJustify[5] = SPACE_EVENLY;
  }

  private YogaJustify(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaJustify fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return FLEX_START;
    case 1:
      return CENTER;
    case 2:
      return FLEX_END;
    case 3:
      return SPACE_BETWEEN;
    case 4:
      return SPACE_AROUND;
    case 5:
    }
    return SPACE_EVENLY;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaJustify
 * JD-Core Version:    0.6.2
 */