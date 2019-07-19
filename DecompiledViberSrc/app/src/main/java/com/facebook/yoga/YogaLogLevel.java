package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaLogLevel
{
  private final int mIntValue;

  static
  {
    INFO = new YogaLogLevel("INFO", 2, 2);
    DEBUG = new YogaLogLevel("DEBUG", 3, 3);
    VERBOSE = new YogaLogLevel("VERBOSE", 4, 4);
    FATAL = new YogaLogLevel("FATAL", 5, 5);
    YogaLogLevel[] arrayOfYogaLogLevel = new YogaLogLevel[6];
    arrayOfYogaLogLevel[0] = ERROR;
    arrayOfYogaLogLevel[1] = WARN;
    arrayOfYogaLogLevel[2] = INFO;
    arrayOfYogaLogLevel[3] = DEBUG;
    arrayOfYogaLogLevel[4] = VERBOSE;
    arrayOfYogaLogLevel[5] = FATAL;
  }

  private YogaLogLevel(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaLogLevel fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return ERROR;
    case 1:
      return WARN;
    case 2:
      return INFO;
    case 3:
      return DEBUG;
    case 4:
      return VERBOSE;
    case 5:
    }
    return FATAL;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaLogLevel
 * JD-Core Version:    0.6.2
 */