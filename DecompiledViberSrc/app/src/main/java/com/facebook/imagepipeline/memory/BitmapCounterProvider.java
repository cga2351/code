package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.ThreadSafe;

public class BitmapCounterProvider
{
  private static final long KB = 1024L;
  public static final int MAX_BITMAP_TOTAL_SIZE = 0;
  private static final long MB = 1048576L;
  private static final Class<?> TAG = BitmapCounterProvider.class;
  private static volatile BitmapCounter sBitmapCounter;
  private static int sMaxBitmapCount = 384;

  @ThreadSafe
  public static BitmapCounter get()
  {
    if (sBitmapCounter == null);
    try
    {
      if (sBitmapCounter == null)
        sBitmapCounter = new BitmapCounter(sMaxBitmapCount, MAX_BITMAP_TOTAL_SIZE);
      return sBitmapCounter;
    }
    finally
    {
    }
  }

  private static int getMaxSizeHardCap()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i > 16777216L)
      return 3 * (i / 4);
    return i / 2;
  }

  public static void initialize(BitmapCounterConfig paramBitmapCounterConfig)
  {
    if (sBitmapCounter != null)
      throw new IllegalStateException("BitmapCounter has already been created! `BitmapCounterProvider.initialize(...)` should only be called before `BitmapCounterProvider.get()` or not at all!");
    sMaxBitmapCount = paramBitmapCounterConfig.getMaxBitmapCount();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.BitmapCounterProvider
 * JD-Core Version:    0.6.2
 */