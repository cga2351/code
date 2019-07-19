package com.viber.voip.util;

public class av
{
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 | 1 << paramInt2;
  }

  public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
      return a(paramInt1, paramInt2);
    return b(paramInt1, paramInt2);
  }

  public static int a(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramInt |= 1 << paramArrayOfInt[i];
      i++;
    }
    return paramInt;
  }

  public static long a(long paramLong, int paramInt)
  {
    return paramLong | 1L << paramInt;
  }

  public static long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      return a(paramLong, paramInt);
    return b(paramLong, paramInt);
  }

  public static long a(long paramLong, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramLong |= 1L << paramArrayOfInt[i];
      i++;
    }
    return paramLong;
  }

  public static boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 & paramLong2) != 0L;
  }

  public static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 & (0xFFFFFFFF ^ 1 << paramInt2);
  }

  public static int b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
      return e(paramInt1, paramInt2);
    return f(paramInt1, paramInt2);
  }

  public static long b(long paramLong, int paramInt)
  {
    return paramLong & (0xFFFFFFFF ^ 1L << paramInt);
  }

  public static long b(long paramLong, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramLong = b(paramLong, paramArrayOfInt[i]);
      i++;
    }
    return paramLong;
  }

  public static boolean c(int paramInt1, int paramInt2)
  {
    return (paramInt1 & 1 << paramInt2) != 0;
  }

  public static boolean c(long paramLong, int paramInt)
  {
    return (paramLong & 1L << paramInt) != 0L;
  }

  public static boolean d(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }

  public static int e(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }

  public static int f(int paramInt1, int paramInt2)
  {
    return paramInt1 & (paramInt2 ^ 0xFFFFFFFF);
  }

  public static boolean g(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.av
 * JD-Core Version:    0.6.2
 */