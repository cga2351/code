package com.facebook.common.memory;

public enum MemoryTrimType
{
  private double mSuggestedTrimRatio;

  static
  {
    OnSystemLowMemoryWhileAppInBackground = new MemoryTrimType("OnSystemLowMemoryWhileAppInBackground", 2, 1.0D);
    OnAppBackgrounded = new MemoryTrimType("OnAppBackgrounded", 3, 1.0D);
    MemoryTrimType[] arrayOfMemoryTrimType = new MemoryTrimType[4];
    arrayOfMemoryTrimType[0] = OnCloseToDalvikHeapLimit;
    arrayOfMemoryTrimType[1] = OnSystemLowMemoryWhileAppInForeground;
    arrayOfMemoryTrimType[2] = OnSystemLowMemoryWhileAppInBackground;
    arrayOfMemoryTrimType[3] = OnAppBackgrounded;
  }

  private MemoryTrimType(double paramDouble)
  {
    this.mSuggestedTrimRatio = paramDouble;
  }

  public double getSuggestedTrimRatio()
  {
    return this.mSuggestedTrimRatio;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.MemoryTrimType
 * JD-Core Version:    0.6.2
 */