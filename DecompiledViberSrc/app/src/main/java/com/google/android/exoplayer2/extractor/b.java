package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class b
  implements o
{
  public final int a;
  public final int[] b;
  public final long[] c;
  public final long[] d;
  public final long[] e;
  private final long f;

  public b(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.b = paramArrayOfInt;
    this.c = paramArrayOfLong1;
    this.d = paramArrayOfLong2;
    this.e = paramArrayOfLong3;
    this.a = paramArrayOfInt.length;
    if (this.a > 0)
    {
      this.f = (paramArrayOfLong2[(-1 + this.a)] + paramArrayOfLong3[(-1 + this.a)]);
      return;
    }
    this.f = 0L;
  }

  public o.a a(long paramLong)
  {
    int i = b(paramLong);
    p localp = new p(this.e[i], this.c[i]);
    if ((localp.b >= paramLong) || (i == -1 + this.a))
      return new o.a(localp);
    return new o.a(localp, new p(this.e[(i + 1)], this.c[(i + 1)]));
  }

  public boolean a()
  {
    return true;
  }

  public int b(long paramLong)
  {
    return ag.a(this.e, paramLong, true, true);
  }

  public long b()
  {
    return this.f;
  }

  public String toString()
  {
    return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.b
 * JD-Core Version:    0.6.2
 */