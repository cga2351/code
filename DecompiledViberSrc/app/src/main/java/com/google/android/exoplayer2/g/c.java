package com.google.android.exoplayer2.g;

import android.util.Pair;
import com.google.android.exoplayer2.w;

public final class c
{
  private static final byte[] a = { 0, 0, 0, 1 };
  private static final int[] b = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] c = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };

  private static int a(q paramq)
  {
    int i = paramq.c(5);
    if (i == 31)
      i = 32 + paramq.c(6);
    return i;
  }

  public static Pair<Integer, Integer> a(q paramq, boolean paramBoolean)
    throws w
  {
    int i = a(paramq);
    int j = b(paramq);
    int k = paramq.c(4);
    if ((i == 5) || (i == 29))
    {
      j = b(paramq);
      i = a(paramq);
      if (i == 22)
        k = paramq.c(4);
    }
    if (paramBoolean)
    {
      switch (i)
      {
      case 5:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 18:
      default:
        throw new w("Unsupported audio object type: " + i);
      case 1:
      case 2:
      case 3:
      case 4:
      case 6:
      case 7:
      case 17:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      }
      a(paramq, i, k);
    }
    int m;
    switch (i)
    {
    case 18:
    default:
      m = c[k];
      if (m == -1)
        break;
    case 17:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    }
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      return Pair.create(Integer.valueOf(j), Integer.valueOf(m));
      int n = paramq.c(2);
      if ((n != 2) && (n != 3))
        break;
      throw new w("Unsupported epConfig: " + n);
    }
  }

  public static Pair<Integer, Integer> a(byte[] paramArrayOfByte)
    throws w
  {
    return a(new q(paramArrayOfByte), false);
  }

  private static void a(q paramq, int paramInt1, int paramInt2)
  {
    paramq.b(1);
    if (paramq.e())
      paramq.b(14);
    boolean bool = paramq.e();
    if (paramInt2 == 0)
      throw new UnsupportedOperationException();
    if ((paramInt1 == 6) || (paramInt1 == 20))
      paramq.b(3);
    if (bool)
    {
      if (paramInt1 == 22)
        paramq.b(16);
      if ((paramInt1 == 17) || (paramInt1 == 19) || (paramInt1 == 20) || (paramInt1 == 23))
        paramq.b(3);
      paramq.b(1);
    }
  }

  public static byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = ((byte)(0xF8 & paramInt1 << 3 | 0x7 & paramInt2 >> 1));
    arrayOfByte[1] = ((byte)(0x80 & paramInt2 << 7 | 0x78 & paramInt3 << 3));
    return arrayOfByte;
  }

  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2 + a.length];
    System.arraycopy(a, 0, arrayOfByte, 0, a.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, a.length, paramInt2);
    return arrayOfByte;
  }

  private static int b(q paramq)
  {
    int i = paramq.c(4);
    if (i == 15)
      return paramq.c(24);
    if (i < 13);
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      return b[i];
    }
  }

  public static String b(int paramInt1, int paramInt2, int paramInt3)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    return String.format("avc1.%02X%02X%02X", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.c
 * JD-Core Version:    0.6.2
 */