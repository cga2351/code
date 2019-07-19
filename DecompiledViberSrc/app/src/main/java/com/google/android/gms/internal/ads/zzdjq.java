package com.google.android.gms.internal.ads;

final class zzdjq extends zzdjp
{
  private static final int[] zzgyb = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] zzgyc = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int state;
  private int value;
  private final int[] zzgyd;

  public zzdjq(int paramInt, byte[] paramArrayOfByte)
  {
    this.zzgxz = paramArrayOfByte;
    if ((paramInt & 0x8) == 0);
    for (int[] arrayOfInt = zzgyb; ; arrayOfInt = zzgyc)
    {
      this.zzgyd = arrayOfInt;
      this.state = 0;
      this.value = 0;
      return;
    }
  }

  public final boolean zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.state == 6)
      return false;
    int i = this.state;
    int j = 0;
    int k = 0;
    byte[] arrayOfByte = this.zzgxz;
    int[] arrayOfInt = this.zzgyd;
    int m = 0;
    int n = i;
    if (m < paramInt2)
      if (n == 0)
      {
        while (m + 4 <= paramInt2)
        {
          j = arrayOfInt[(0xFF & paramArrayOfByte[m])] << 18 | arrayOfInt[(0xFF & paramArrayOfByte[(m + 1)])] << 12 | arrayOfInt[(0xFF & paramArrayOfByte[(m + 2)])] << 6 | arrayOfInt[(0xFF & paramArrayOfByte[(m + 3)])];
          if (j < 0)
            break;
          arrayOfByte[(k + 2)] = ((byte)j);
          arrayOfByte[(k + 1)] = ((byte)(j >> 8));
          arrayOfByte[k] = ((byte)(j >> 16));
          k += 3;
          m += 4;
        }
        if (m >= paramInt2);
      }
      else
      {
        int i4 = m + 1;
        int i5 = arrayOfInt[(0xFF & paramArrayOfByte[m])];
        switch (n)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    m = i4;
                    break;
                    if (i5 >= 0)
                    {
                      n++;
                      j = i5;
                      m = i4;
                      break;
                    }
                  }
                  while (i5 == -1);
                  this.state = 6;
                  return false;
                  if (i5 >= 0)
                  {
                    j = i5 | j << 6;
                    n++;
                    m = i4;
                    break;
                  }
                }
                while (i5 == -1);
                this.state = 6;
                return false;
                if (i5 >= 0)
                {
                  j = i5 | j << 6;
                  n++;
                  m = i4;
                  break;
                }
                if (i5 == -2)
                {
                  int i6 = k + 1;
                  arrayOfByte[k] = ((byte)(j >> 4));
                  n = 4;
                  k = i6;
                  m = i4;
                  break;
                }
              }
              while (i5 == -1);
              this.state = 6;
              return false;
              if (i5 >= 0)
              {
                j = i5 | j << 6;
                arrayOfByte[(k + 2)] = ((byte)j);
                arrayOfByte[(k + 1)] = ((byte)(j >> 8));
                arrayOfByte[k] = ((byte)(j >> 16));
                k += 3;
                m = i4;
                n = 0;
                break;
              }
              if (i5 == -2)
              {
                arrayOfByte[(k + 1)] = ((byte)(j >> 2));
                arrayOfByte[k] = ((byte)(j >> 10));
                k += 2;
                n = 5;
                m = i4;
                break;
              }
            }
            while (i5 == -1);
            this.state = 6;
            return false;
            if (i5 == -2)
            {
              n++;
              m = i4;
              break;
            }
          }
          while (i5 == -1);
          this.state = 6;
          return false;
        }
        while (i5 == -1);
        this.state = 6;
        return false;
      }
    int i1 = j;
    switch (n)
    {
    case 0:
    default:
    case 1:
    case 2:
    case 3:
      while (true)
      {
        this.state = n;
        this.zzgya = k;
        return true;
        this.state = 6;
        return false;
        int i3 = k + 1;
        arrayOfByte[k] = ((byte)(i1 >> 4));
        k = i3;
        continue;
        int i2 = k + 1;
        arrayOfByte[k] = ((byte)(i1 >> 10));
        k = i2 + 1;
        arrayOfByte[i2] = ((byte)(i1 >> 2));
      }
    case 4:
    }
    this.state = 6;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjq
 * JD-Core Version:    0.6.2
 */