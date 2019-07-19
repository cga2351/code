package com.viber.voip.messages.controller.a;

import com.viber.voip.util.LongSparseSet;

public class d
{
  private static final LongSparseSet a = LongSparseSet.from(new long[] { 1L, 2L, 10118L, 3001L, 3024L, 3034L, 3344L, 3379L, 5002L, 5292L, 7833L, 10211L, 12502L });

  public static boolean a(long paramLong)
  {
    return a.contains(paramLong);
  }

  public LongSparseSet a()
  {
    return a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.a.d
 * JD-Core Version:    0.6.2
 */