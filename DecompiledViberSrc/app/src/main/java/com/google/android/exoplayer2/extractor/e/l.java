package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.Arrays;

final class l
{
  public static int a(int paramInt)
  {
    int i = 0;
    while (paramInt > 0)
    {
      i++;
      paramInt >>>= 1;
    }
    return i;
  }

  private static long a(long paramLong1, long paramLong2)
  {
    return ()Math.floor(Math.pow(paramLong1, 1.0D / paramLong2));
  }

  public static d a(r paramr)
    throws w
  {
    a(1, paramr, false);
    long l1 = paramr.o();
    int i = paramr.h();
    long l2 = paramr.o();
    int j = paramr.q();
    int k = paramr.q();
    int m = paramr.q();
    int n = paramr.h();
    int i1 = (int)Math.pow(2.0D, n & 0xF);
    int i2 = (int)Math.pow(2.0D, (n & 0xF0) >> 4);
    if ((0x1 & paramr.h()) > 0);
    for (boolean bool = true; ; bool = false)
      return new d(l1, i, l2, j, k, m, i1, i2, bool, Arrays.copyOf(paramr.a, paramr.c()));
  }

  private static void a(int paramInt, j paramj)
    throws w
  {
    int i = 1 + paramj.a(6);
    int j = 0;
    if (j < i)
    {
      int k = paramj.a(16);
      switch (k)
      {
      default:
        com.google.android.exoplayer2.g.l.d("VorbisUtil", "mapping type other than 0 not supported: " + k);
      case 0:
      }
      while (true)
      {
        j++;
        break;
        if (paramj.a());
        for (int m = 1 + paramj.a(4); paramj.a(); m = 1)
        {
          int i2 = 1 + paramj.a(8);
          for (int i3 = 0; i3 < i2; i3++)
          {
            paramj.b(a(paramInt - 1));
            paramj.b(a(paramInt - 1));
          }
        }
        if (paramj.a(2) != 0)
          throw new w("to reserved bits must be zero after mapping coupling steps");
        if (m > 1)
          for (int i1 = 0; i1 < paramInt; i1++)
            paramj.b(4);
        for (int n = 0; n < m; n++)
        {
          paramj.b(8);
          paramj.b(8);
          paramj.b(8);
        }
      }
    }
  }

  public static boolean a(int paramInt, r paramr, boolean paramBoolean)
    throws w
  {
    if (paramr.b() < 7)
      if (!paramBoolean);
    do
    {
      do
      {
        return false;
        throw new w("too short header: " + paramr.b());
        if (paramr.h() == paramInt)
          break;
      }
      while (paramBoolean);
      throw new w("expected header type " + Integer.toHexString(paramInt));
      if ((paramr.h() == 118) && (paramr.h() == 111) && (paramr.h() == 114) && (paramr.h() == 98) && (paramr.h() == 105) && (paramr.h() == 115))
        break;
    }
    while (paramBoolean);
    throw new w("expected characters 'vorbis'");
    return true;
  }

  private static c[] a(j paramj)
  {
    int i = 1 + paramj.a(6);
    c[] arrayOfc = new c[i];
    for (int j = 0; j < i; j++)
      arrayOfc[j] = new c(paramj.a(), paramj.a(16), paramj.a(16), paramj.a(8));
    return arrayOfc;
  }

  public static c[] a(r paramr, int paramInt)
    throws w
  {
    int i = 0;
    a(5, paramr, false);
    int j = 1 + paramr.h();
    j localj = new j(paramr.a);
    localj.b(8 * paramr.d());
    for (int k = 0; k < j; k++)
      d(localj);
    int m = 1 + localj.a(6);
    while (i < m)
    {
      if (localj.a(16) != 0)
        throw new w("placeholder of time domain transforms not zeroed out");
      i++;
    }
    c(localj);
    b(localj);
    a(paramInt, localj);
    c[] arrayOfc = a(localj);
    if (!localj.a())
      throw new w("framing bit after modes not set as expected");
    return arrayOfc;
  }

  public static b b(r paramr)
    throws w
  {
    int i = 0;
    a(3, paramr, false);
    String str = paramr.e((int)paramr.o());
    int j = 11 + str.length();
    long l = paramr.o();
    String[] arrayOfString = new String[(int)l];
    int k = j + 4;
    while (i < l)
    {
      int m = (int)paramr.o();
      int n = k + 4;
      arrayOfString[i] = paramr.e(m);
      k = n + arrayOfString[i].length();
      i++;
    }
    if ((0x1 & paramr.h()) == 0)
      throw new w("framing bit expected to be set");
    return new b(str, arrayOfString, k + 1);
  }

  private static void b(j paramj)
    throws w
  {
    int i = 1 + paramj.a(6);
    int j = 0;
    int k;
    int[] arrayOfInt;
    int m;
    label77: int i2;
    if (j < i)
    {
      if (paramj.a(16) > 2)
        throw new w("residueType greater than 2 is not decodable");
      paramj.b(24);
      paramj.b(24);
      paramj.b(24);
      k = 1 + paramj.a(6);
      paramj.b(8);
      arrayOfInt = new int[k];
      m = 0;
      if (m < k)
      {
        i2 = paramj.a(3);
        if (!paramj.a())
          break label180;
      }
    }
    label180: for (int i3 = paramj.a(5); ; i3 = 0)
    {
      arrayOfInt[m] = (i2 + i3 * 8);
      m++;
      break label77;
      for (int n = 0; n < k; n++)
        for (int i1 = 0; i1 < 8; i1++)
          if ((arrayOfInt[n] & 1 << i1) != 0)
            paramj.b(8);
      j++;
      break;
      return;
    }
  }

  private static void c(j paramj)
    throws w
  {
    int i = 1 + paramj.a(6);
    for (int j = 0; j < i; j++)
    {
      int k = paramj.a(16);
      int i9;
      int i10;
      switch (k)
      {
      default:
        throw new w("floor type greater than 1 not decodable: " + k);
      case 0:
        paramj.b(8);
        paramj.b(16);
        paramj.b(16);
        paramj.b(6);
        paramj.b(8);
        i9 = 1 + paramj.a(4);
        i10 = 0;
      case 1:
      }
      while (i10 < i9)
      {
        paramj.b(8);
        i10++;
        continue;
        int m = paramj.a(5);
        int n = -1;
        int[] arrayOfInt1 = new int[m];
        for (int i1 = 0; i1 < m; i1++)
        {
          arrayOfInt1[i1] = paramj.a(4);
          if (arrayOfInt1[i1] > n)
            n = arrayOfInt1[i1];
        }
        int[] arrayOfInt2 = new int[n + 1];
        for (int i2 = 0; i2 < arrayOfInt2.length; i2++)
        {
          arrayOfInt2[i2] = (1 + paramj.a(3));
          int i7 = paramj.a(2);
          if (i7 > 0)
            paramj.b(8);
          for (int i8 = 0; i8 < 1 << i7; i8++)
            paramj.b(8);
        }
        paramj.b(2);
        int i3 = paramj.a(4);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < m)
        {
          i6 += arrayOfInt2[arrayOfInt1[i5]];
          while (i4 < i6)
          {
            paramj.b(i3);
            i4++;
          }
          i5++;
        }
      }
    }
  }

  private static a d(j paramj)
    throws w
  {
    int i = 0;
    if (paramj.a(24) != 5653314)
      throw new w("expected code book to start with [0x56, 0x43, 0x42] at " + paramj.b());
    int j = paramj.a(16);
    int k = paramj.a(24);
    long[] arrayOfLong = new long[k];
    boolean bool1 = paramj.a();
    if (!bool1)
    {
      boolean bool2 = paramj.a();
      if (i < arrayOfLong.length)
      {
        if (bool2)
          if (paramj.a())
            arrayOfLong[i] = (1 + paramj.a(5));
        while (true)
        {
          i++;
          break;
          arrayOfLong[i] = 0L;
          continue;
          arrayOfLong[i] = (1 + paramj.a(5));
        }
      }
    }
    else
    {
      int m = 1 + paramj.a(5);
      int n = 0;
      while (n < arrayOfLong.length)
      {
        int i3 = paramj.a(a(k - n));
        int i4 = 0;
        while ((i4 < i3) && (n < arrayOfLong.length))
        {
          arrayOfLong[n] = m;
          int i5 = n + 1;
          i4++;
          n = i5;
        }
        m++;
      }
    }
    int i1 = paramj.a(4);
    if (i1 > 2)
      throw new w("lookup type greater than 2 not decodable: " + i1);
    int i2;
    long l;
    if ((i1 == 1) || (i1 == 2))
    {
      paramj.b(32);
      paramj.b(32);
      i2 = 1 + paramj.a(4);
      paramj.b(1);
      if (i1 != 1)
        break label351;
      if (j == 0)
        break label345;
      l = a(k, j);
    }
    while (true)
    {
      paramj.b((int)(l * i2));
      return new a(j, k, arrayOfLong, i1, bool1);
      label345: l = 0L;
      continue;
      label351: l = k * j;
    }
  }

  public static final class a
  {
    public final int a;
    public final int b;
    public final long[] c;
    public final int d;
    public final boolean e;

    public a(int paramInt1, int paramInt2, long[] paramArrayOfLong, int paramInt3, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramArrayOfLong;
      this.d = paramInt3;
      this.e = paramBoolean;
    }
  }

  public static final class b
  {
    public final String a;
    public final String[] b;
    public final int c;

    public b(String paramString, String[] paramArrayOfString, int paramInt)
    {
      this.a = paramString;
      this.b = paramArrayOfString;
      this.c = paramInt;
    }
  }

  public static final class c
  {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;

    public c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramBoolean;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
    }
  }

  public static final class d
  {
    public final long a;
    public final int b;
    public final long c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final byte[] j;

    public d(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      this.a = paramLong1;
      this.b = paramInt1;
      this.c = paramLong2;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
      this.g = paramInt5;
      this.h = paramInt6;
      this.i = paramBoolean;
      this.j = paramArrayOfByte;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.l
 * JD-Core Version:    0.6.2
 */