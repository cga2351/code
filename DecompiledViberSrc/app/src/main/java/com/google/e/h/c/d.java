package com.google.e.h.c;

final class d
{
  static int a(b paramb)
  {
    return a(paramb, true) + a(paramb, false);
  }

  private static int a(b paramb, boolean paramBoolean)
  {
    int i;
    int j;
    label18: byte[][] arrayOfByte;
    int k;
    int m;
    if (paramBoolean)
    {
      i = paramb.a();
      if (!paramBoolean)
        break label120;
      j = paramb.b();
      arrayOfByte = paramb.c();
      k = 0;
      m = 0;
    }
    while (true)
    {
      if (k >= i)
        break label199;
      int n = -1;
      int i1 = 0;
      int i2 = 0;
      label45: if (i1 < j)
      {
        int i3;
        label65: int i9;
        int i4;
        int i6;
        if (paramBoolean)
        {
          i3 = arrayOfByte[k][i1];
          if (i3 != n)
            break label141;
          int i8 = i2 + 1;
          i9 = n;
          i4 = i8;
          i6 = m;
        }
        label120: int i5;
        for (int i7 = i9; ; i7 = i5)
        {
          i1++;
          i2 = i4;
          n = i7;
          m = i6;
          break label45;
          i = paramb.b();
          break;
          j = paramb.a();
          break label18;
          i3 = arrayOfByte[i1][k];
          break label65;
          if (i2 >= 5)
            m += 3 + (i2 - 5);
          i4 = 1;
          i5 = i3;
          i6 = m;
        }
      }
      label141: if (i2 >= 5)
        m += 3 + (i2 - 5);
      k++;
    }
    label199: return m;
  }

  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException("Invalid mask pattern: " + paramInt1);
    case 0:
      i = 0x1 & paramInt3 + paramInt2;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (i == 0)
    {
      return true;
      i = paramInt3 & 0x1;
      continue;
      i = paramInt2 % 3;
      continue;
      i = (paramInt3 + paramInt2) % 3;
      continue;
      i = 0x1 & paramInt3 / 2 + paramInt2 / 3;
      continue;
      int k = paramInt3 * paramInt2;
      i = (k & 0x1) + k % 3;
      continue;
      int j = paramInt3 * paramInt2;
      i = 0x1 & (j & 0x1) + j % 3;
      continue;
      i = 0x1 & paramInt3 * paramInt2 % 3 + (0x1 & paramInt3 + paramInt2);
    }
    return false;
  }

  private static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 1;
    while (true)
    {
      if (paramInt1 < paramInt2)
      {
        if ((paramInt1 >= 0) && (paramInt1 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt1] == i))
          i = 0;
      }
      else
        return i;
      paramInt1++;
    }
  }

  private static boolean a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    while (true)
    {
      if (paramInt2 < paramInt3)
      {
        if ((paramInt2 >= 0) && (paramInt2 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt2][paramInt1] == i))
          i = 0;
      }
      else
        return i;
      paramInt2++;
    }
  }

  static int b(b paramb)
  {
    byte[][] arrayOfByte = paramb.c();
    int i = paramb.b();
    int j = paramb.a();
    int k = 0;
    int m = 0;
    while (k < j - 1)
    {
      for (int n = 0; n < i - 1; n++)
      {
        int i1 = arrayOfByte[k][n];
        if ((i1 == arrayOfByte[k][(n + 1)]) && (i1 == arrayOfByte[(k + 1)][n]) && (i1 == arrayOfByte[(k + 1)][(n + 1)]))
          m++;
      }
      k++;
    }
    return m * 3;
  }

  static int c(b paramb)
  {
    byte[][] arrayOfByte = paramb.c();
    int i = paramb.b();
    int j = paramb.a();
    int k = 0;
    int m = 0;
    while (k < j)
    {
      for (int n = 0; n < i; n++)
      {
        byte[] arrayOfByte1 = arrayOfByte[k];
        if ((n + 6 < i) && (arrayOfByte1[n] == 1) && (arrayOfByte1[(n + 1)] == 0) && (arrayOfByte1[(n + 2)] == 1) && (arrayOfByte1[(n + 3)] == 1) && (arrayOfByte1[(n + 4)] == 1) && (arrayOfByte1[(n + 5)] == 0) && (arrayOfByte1[(n + 6)] == 1) && ((a(arrayOfByte1, n - 4, n)) || (a(arrayOfByte1, n + 7, n + 11))))
          m++;
        if ((k + 6 < j) && (arrayOfByte[k][n] == 1) && (arrayOfByte[(k + 1)][n] == 0) && (arrayOfByte[(k + 2)][n] == 1) && (arrayOfByte[(k + 3)][n] == 1) && (arrayOfByte[(k + 4)][n] == 1) && (arrayOfByte[(k + 5)][n] == 0) && (arrayOfByte[(k + 6)][n] == 1) && ((a(arrayOfByte, n, k - 4, k)) || (a(arrayOfByte, n, k + 7, k + 11))))
          m++;
      }
      k++;
    }
    return m * 40;
  }

  static int d(b paramb)
  {
    byte[][] arrayOfByte = paramb.c();
    int i = paramb.b();
    int j = paramb.a();
    int k = 0;
    int m = 0;
    while (k < j)
    {
      byte[] arrayOfByte1 = arrayOfByte[k];
      for (int i1 = 0; i1 < i; i1++)
        if (arrayOfByte1[i1] == 1)
          m++;
      k++;
    }
    int n = paramb.a() * paramb.b();
    return 10 * (10 * Math.abs(m * 2 - n) / n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.c.d
 * JD-Core Version:    0.6.2
 */