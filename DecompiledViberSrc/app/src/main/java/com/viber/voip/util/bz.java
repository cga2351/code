package com.viber.voip.util;

public final class bz
{
  public static int a(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }

  public static int a(Object paramObject)
  {
    return a(paramObject, -1);
  }

  public static int a(Object paramObject, int paramInt)
  {
    try
    {
      int i = Integer.parseInt((String)paramObject);
      return i;
    }
    catch (Exception localException)
    {
    }
    return paramInt;
  }

  public static boolean a(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) <= 1.0E-006D;
  }

  public static long b(Object paramObject)
  {
    try
    {
      long l = Long.parseLong((String)paramObject);
      return l;
    }
    catch (Exception localException)
    {
    }
    return -1L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bz
 * JD-Core Version:    0.6.2
 */