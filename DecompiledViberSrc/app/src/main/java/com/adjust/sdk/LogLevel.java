package com.adjust.sdk;

public enum LogLevel
{
  final int androidLogLevel;

  static
  {
    DEBUG = new LogLevel("DEBUG", 1, 3);
    INFO = new LogLevel("INFO", 2, 4);
    WARN = new LogLevel("WARN", 3, 5);
    ERROR = new LogLevel("ERROR", 4, 6);
    ASSERT = new LogLevel("ASSERT", 5, 7);
    SUPRESS = new LogLevel("SUPRESS", 6, 8);
    LogLevel[] arrayOfLogLevel = new LogLevel[7];
    arrayOfLogLevel[0] = VERBOSE;
    arrayOfLogLevel[1] = DEBUG;
    arrayOfLogLevel[2] = INFO;
    arrayOfLogLevel[3] = WARN;
    arrayOfLogLevel[4] = ERROR;
    arrayOfLogLevel[5] = ASSERT;
    arrayOfLogLevel[6] = SUPRESS;
  }

  private LogLevel(int paramInt)
  {
    this.androidLogLevel = paramInt;
  }

  public int getAndroidLogLevel()
  {
    return this.androidLogLevel;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.LogLevel
 * JD-Core Version:    0.6.2
 */