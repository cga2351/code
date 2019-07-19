package com.facebook.yoga;

public class YogaMeasureOutput
{
  public static float getHeight(long paramLong)
  {
    return Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
  }

  public static float getWidth(long paramLong)
  {
    return Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong >> 32));
  }

  public static long make(float paramFloat1, float paramFloat2)
  {
    int i = Float.floatToRawIntBits(paramFloat1);
    int j = Float.floatToRawIntBits(paramFloat2);
    return i << 32 | j;
  }

  public static long make(int paramInt1, int paramInt2)
  {
    return make(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaMeasureOutput
 * JD-Core Version:    0.6.2
 */