package com.google.e.f.a;

public final class f
{
  private static int a(int paramInt1, int paramInt2)
  {
    int i = 1;
    int k;
    if (paramInt1 - paramInt2 > paramInt2)
      k = paramInt1 - paramInt2;
    int m;
    while (true)
    {
      m = i;
      while (paramInt1 > k)
      {
        m *= paramInt1;
        if (i <= paramInt2)
        {
          m /= i;
          i++;
        }
        paramInt1--;
      }
      int j = paramInt1 - paramInt2;
      k = paramInt2;
      paramInt2 = j;
    }
    while (true)
    {
      int n;
      if (i <= paramInt2)
      {
        n /= i;
        i++;
      }
      else
      {
        return n;
        n = m;
      }
    }
  }

  public static int a(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    int i = paramArrayOfInt.length;
    int j = paramArrayOfInt.length;
    int k = 0;
    int i12;
    for (int m = 0; k < j; m = i12)
    {
      i12 = m + paramArrayOfInt[k];
      k++;
    }
    int n = 0;
    int i1 = 0;
    int i2 = m;
    int i3 = 0;
    while (n < i - 1)
    {
      int i4 = i3 | 1 << n;
      int i5 = i1;
      int i6 = i4;
      int i7 = 1;
      if (i7 < paramArrayOfInt[n])
      {
        int i9 = a(-1 + (i2 - i7), -2 + (i - n));
        if ((paramBoolean) && (i6 == 0) && (i2 - i7 - (-1 + (i - n)) >= -1 + (i - n)))
          i9 -= a(i2 - i7 - (i - n), -2 + (i - n));
        if (-1 + (i - n) > 1)
        {
          int i10 = i2 - i7 - (-2 + (i - n));
          int i11 = 0;
          while (i10 > paramInt)
          {
            i11 += a(-1 + (i2 - i7 - i10), -3 + (i - n));
            i10--;
          }
          i9 -= i11 * (i - 1 - n);
        }
        while (true)
        {
          i5 += i9;
          i7++;
          i6 &= (0xFFFFFFFF ^ 1 << n);
          break;
          if (i2 - i7 > paramInt)
            i9--;
        }
      }
      int i8 = i2 - i7;
      n++;
      i2 = i8;
      i3 = i6;
      i1 = i5;
    }
    return i1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.f
 * JD-Core Version:    0.6.2
 */