package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.ag;

final class d
{
  public static a a(int paramInt, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong)
  {
    int i = 8192 / paramInt;
    int j = paramArrayOfInt.length;
    int k = 0;
    int i14;
    for (int m = 0; k < j; m = i14)
    {
      i14 = m + ag.a(paramArrayOfInt[k], i);
      k++;
    }
    long[] arrayOfLong1 = new long[m];
    int[] arrayOfInt1 = new int[m];
    long[] arrayOfLong2 = new long[m];
    int[] arrayOfInt2 = new int[m];
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i9;
    for (int i3 = 0; n < paramArrayOfInt.length; i3 = i9)
    {
      int i4 = paramArrayOfInt[n];
      long l = paramArrayOfLong[n];
      int i5 = i3;
      int i6 = i2;
      int i7 = i1;
      int i8 = i5;
      while (i4 > 0)
      {
        int i10 = Math.min(i, i4);
        arrayOfLong1[i8] = l;
        arrayOfInt1[i8] = (paramInt * i10);
        int i11 = Math.max(i7, arrayOfInt1[i8]);
        arrayOfLong2[i8] = (paramLong * i6);
        arrayOfInt2[i8] = 1;
        l += arrayOfInt1[i8];
        int i12 = i6 + i10;
        int i13 = i4 - i10;
        i8++;
        i4 = i13;
        i6 = i12;
        i7 = i11;
      }
      n++;
      i9 = i8;
      i1 = i7;
      i2 = i6;
    }
    return new a(arrayOfLong1, arrayOfInt1, i1, arrayOfLong2, arrayOfInt2, paramLong * i2, null);
  }

  public static final class a
  {
    public final long[] a;
    public final int[] b;
    public final int c;
    public final long[] d;
    public final int[] e;
    public final long f;

    private a(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, long paramLong)
    {
      this.a = paramArrayOfLong1;
      this.b = paramArrayOfInt1;
      this.c = paramInt;
      this.d = paramArrayOfLong2;
      this.e = paramArrayOfInt2;
      this.f = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.d
 * JD-Core Version:    0.6.2
 */