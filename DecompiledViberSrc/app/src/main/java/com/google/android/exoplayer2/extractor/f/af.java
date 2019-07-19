package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.g.r;

public final class af
{
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] != 71))
      paramInt1++;
    return paramInt1;
  }

  public static long a(r paramr, int paramInt1, int paramInt2)
  {
    int i = 1;
    paramr.c(paramInt1);
    if (paramr.b() < 5);
    label56: label121: label123: label126: 
    while (true)
    {
      return -9223372036854775807L;
      int j = paramr.p();
      if (((0x800000 & j) == 0) && ((0x1FFF00 & j) >> 8 == paramInt2))
      {
        int k;
        if ((j & 0x20) != 0)
        {
          k = i;
          if ((k == 0) || (paramr.h() < 7) || (paramr.b() < 7))
            break label121;
          if ((0x10 & paramr.h()) != 16)
            break label123;
        }
        while (true)
        {
          if (i == 0)
            break label126;
          byte[] arrayOfByte = new byte[6];
          paramr.a(arrayOfByte, 0, arrayOfByte.length);
          return a(arrayOfByte);
          k = 0;
          break label56;
          break;
          i = 0;
        }
      }
    }
  }

  private static long a(byte[] paramArrayOfByte)
  {
    return (0xFF & paramArrayOfByte[0]) << 25 | (0xFF & paramArrayOfByte[1]) << 17 | (0xFF & paramArrayOfByte[2]) << 9 | (0xFF & paramArrayOfByte[3]) << 1 | (0xFF & paramArrayOfByte[4]) >> 7;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.af
 * JD-Core Version:    0.6.2
 */