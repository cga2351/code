package com.viber.voip.phone.conf.utils;

public class MinMaxAvgCalc
{
  double mAverage;
  long mCount = 0L;
  private int mMax = -2147483648;
  private int mMin = 2147483647;

  public void count(int paramInt)
  {
    if (paramInt < this.mMin)
      this.mMin = paramInt;
    if (paramInt > this.mMax)
      this.mMax = paramInt;
    this.mAverage = (this.mCount / (1L + this.mCount) * this.mAverage + paramInt / (1L + this.mCount));
    this.mCount = (1L + this.mCount);
  }

  public int getAverage()
  {
    return (int)Math.round(this.mAverage);
  }

  public int getMax()
  {
    return this.mMax;
  }

  public int getMin()
  {
    return this.mMin;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.utils.MinMaxAvgCalc
 * JD-Core Version:    0.6.2
 */