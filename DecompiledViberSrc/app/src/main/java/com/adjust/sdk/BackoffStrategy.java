package com.adjust.sdk;

public enum BackoffStrategy
{
  double maxRange;
  long maxWait;
  long milliSecondMultiplier;
  double minRange;
  int minRetries;

  static
  {
    NO_WAIT = new BackoffStrategy("NO_WAIT", 3, 100, 1L, 1000L, 1.0D, 1.0D);
    BackoffStrategy[] arrayOfBackoffStrategy = new BackoffStrategy[4];
    arrayOfBackoffStrategy[0] = LONG_WAIT;
    arrayOfBackoffStrategy[1] = SHORT_WAIT;
    arrayOfBackoffStrategy[2] = TEST_WAIT;
    arrayOfBackoffStrategy[3] = NO_WAIT;
  }

  private BackoffStrategy(int paramInt, long paramLong1, long paramLong2, double paramDouble1, double paramDouble2)
  {
    this.minRetries = paramInt;
    this.milliSecondMultiplier = paramLong1;
    this.maxWait = paramLong2;
    this.minRange = paramDouble1;
    this.maxRange = paramDouble2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.BackoffStrategy
 * JD-Core Version:    0.6.2
 */