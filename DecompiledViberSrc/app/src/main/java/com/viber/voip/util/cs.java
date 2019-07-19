package com.viber.voip.util;

public class cs
{
  private int[][] a;

  public cs(int[][] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
  }

  public int a(int paramInt)
  {
    for (int[] arrayOfInt1 : this.a)
    {
      int k = 0;
      int m = 0;
      while (k < -1 + arrayOfInt1.length)
      {
        m |= arrayOfInt1[k];
        k++;
      }
      if (m == paramInt)
        return arrayOfInt1[(-1 + arrayOfInt1.length)];
    }
    return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cs
 * JD-Core Version:    0.6.2
 */