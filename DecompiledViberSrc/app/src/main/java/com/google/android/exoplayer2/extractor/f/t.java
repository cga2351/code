package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class t
{
  private final ad a = new ad(0L);
  private final r b = new r();
  private boolean c;
  private boolean d;
  private boolean e;
  private long f = -9223372036854775807L;
  private long g = -9223372036854775807L;
  private long h = -9223372036854775807L;

  private int a(h paramh)
  {
    this.b.a(ag.f);
    this.c = true;
    paramh.a();
    return 0;
  }

  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (0xFF & paramArrayOfByte[paramInt]) << 24 | (0xFF & paramArrayOfByte[(paramInt + 1)]) << 16 | (0xFF & paramArrayOfByte[(paramInt + 2)]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 3)];
  }

  public static long a(r paramr)
  {
    int i = paramr.d();
    if (paramr.b() < 9);
    byte[] arrayOfByte;
    do
    {
      return -9223372036854775807L;
      arrayOfByte = new byte[9];
      paramr.a(arrayOfByte, 0, arrayOfByte.length);
      paramr.c(i);
    }
    while (!a(arrayOfByte));
    return b(arrayOfByte);
  }

  private static boolean a(byte[] paramArrayOfByte)
  {
    int i = 1;
    if ((0xC4 & paramArrayOfByte[0]) != 68);
    while (((0x4 & paramArrayOfByte[2]) != 4) || ((0x4 & paramArrayOfByte[4]) != 4) || ((0x1 & paramArrayOfByte[5]) != i))
      return false;
    if ((0x3 & paramArrayOfByte[8]) == 3);
    while (true)
    {
      return i;
      int j = 0;
    }
  }

  private int b(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    int i = (int)Math.min(20000L, paramh.d());
    if (paramh.c() != 0)
    {
      paramn.a = 0;
      return 1;
    }
    this.b.a(i);
    paramh.a();
    paramh.c(this.b.a, 0, i);
    this.f = b(this.b);
    this.d = true;
    return 0;
  }

  private long b(r paramr)
  {
    int i = paramr.d();
    int j = paramr.c();
    for (int k = i; k < j - 3; k++)
      if (a(paramr.a, k) == 442)
      {
        paramr.c(k + 4);
        long l = a(paramr);
        if (l != -9223372036854775807L)
          return l;
      }
    return -9223372036854775807L;
  }

  private static long b(byte[] paramArrayOfByte)
  {
    return (0x38 & paramArrayOfByte[0]) >> 3 << 30 | (0x3 & paramArrayOfByte[0]) << 28 | (0xFF & paramArrayOfByte[1]) << 20 | (0xF8 & paramArrayOfByte[2]) >> 3 << 15 | (0x3 & paramArrayOfByte[2]) << 13 | (0xFF & paramArrayOfByte[3]) << 5 | (0xF8 & paramArrayOfByte[4]) >> 3;
  }

  private int c(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    long l1 = paramh.d();
    int i = (int)Math.min(20000L, l1);
    long l2 = l1 - i;
    if (paramh.c() != l2)
    {
      paramn.a = l2;
      return 1;
    }
    this.b.a(i);
    paramh.a();
    paramh.c(this.b.a, 0, i);
    this.g = c(this.b);
    this.e = true;
    return 0;
  }

  private long c(r paramr)
  {
    int i = paramr.d();
    for (int j = -4 + paramr.c(); j >= i; j--)
      if (a(paramr.a, j) == 442)
      {
        paramr.c(j + 4);
        long l = a(paramr);
        if (l != -9223372036854775807L)
          return l;
      }
    return -9223372036854775807L;
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    if (!this.e)
      return c(paramh, paramn);
    if (this.g == -9223372036854775807L)
      return a(paramh);
    if (!this.d)
      return b(paramh, paramn);
    if (this.f == -9223372036854775807L)
      return a(paramh);
    long l = this.a.b(this.f);
    this.h = (this.a.b(this.g) - l);
    return a(paramh);
  }

  public boolean a()
  {
    return this.c;
  }

  public ad b()
  {
    return this.a;
  }

  public long c()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.t
 * JD-Core Version:    0.6.2
 */