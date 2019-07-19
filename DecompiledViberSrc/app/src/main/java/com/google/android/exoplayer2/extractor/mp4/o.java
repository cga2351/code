package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;

final class o
{
  public final l a;
  public final int b;
  public final long[] c;
  public final int[] d;
  public final int e;
  public final long[] f;
  public final int[] g;
  public final long h;

  public o(l paraml, long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, long paramLong)
  {
    boolean bool2;
    boolean bool3;
    if (paramArrayOfInt1.length == paramArrayOfLong2.length)
    {
      bool2 = bool1;
      a.a(bool2);
      if (paramArrayOfLong1.length != paramArrayOfLong2.length)
        break label133;
      bool3 = bool1;
      label36: a.a(bool3);
      if (paramArrayOfInt2.length != paramArrayOfLong2.length)
        break label139;
    }
    while (true)
    {
      a.a(bool1);
      this.a = paraml;
      this.c = paramArrayOfLong1;
      this.d = paramArrayOfInt1;
      this.e = paramInt;
      this.f = paramArrayOfLong2;
      this.g = paramArrayOfInt2;
      this.h = paramLong;
      this.b = paramArrayOfLong1.length;
      if (paramArrayOfInt2.length > 0)
      {
        int i = -1 + paramArrayOfInt2.length;
        paramArrayOfInt2[i] = (0x20000000 | paramArrayOfInt2[i]);
      }
      return;
      bool2 = false;
      break;
      label133: bool3 = false;
      break label36;
      label139: bool1 = false;
    }
  }

  public int a(long paramLong)
  {
    for (int i = ag.a(this.f, paramLong, true, false); i >= 0; i--)
      if ((0x1 & this.g[i]) != 0)
        return i;
    return -1;
  }

  public int b(long paramLong)
  {
    for (int i = ag.b(this.f, paramLong, true, false); i < this.f.length; i++)
      if ((0x1 & this.g[i]) != 0)
        return i;
    return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.o
 * JD-Core Version:    0.6.2
 */