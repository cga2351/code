package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultBitmapPoolParams
{
  private static final SparseIntArray DEFAULT_BUCKETS = new SparseIntArray(0);
  private static final int MAX_SIZE_SOFT_CAP;

  public static PoolParams get()
  {
    return new PoolParams(0, getMaxSizeHardCap(), DEFAULT_BUCKETS);
  }

  private static int getMaxSizeHardCap()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i > 16777216)
      return 3 * (i / 4);
    return i / 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.DefaultBitmapPoolParams
 * JD-Core Version:    0.6.2
 */