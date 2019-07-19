package com.google.android.exoplayer2.extractor.d;

import android.util.Pair;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.extractor.o.a;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;

final class b
  implements c.a
{
  private final long[] a;
  private final long[] b;
  private final long c;

  private b(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.a = paramArrayOfLong1;
    this.b = paramArrayOfLong2;
    this.c = c.b(paramArrayOfLong2[(-1 + paramArrayOfLong2.length)]);
  }

  private static Pair<Long, Long> a(long paramLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = ag.a(paramArrayOfLong1, paramLong, true, true);
    long l1 = paramArrayOfLong1[i];
    long l2 = paramArrayOfLong2[i];
    int j = i + 1;
    if (j == paramArrayOfLong1.length)
      return Pair.create(Long.valueOf(l1), Long.valueOf(l2));
    long l3 = paramArrayOfLong1[j];
    long l4 = paramArrayOfLong2[j];
    if (l3 == l1);
    for (double d = 0.0D; ; d = (paramLong - l1) / (l3 - l1))
    {
      long l5 = l2 + ()(d * (l4 - l2));
      return Pair.create(Long.valueOf(paramLong), Long.valueOf(l5));
    }
  }

  public static b a(long paramLong, MlltFrame paramMlltFrame)
  {
    long l = 0L;
    int i = paramMlltFrame.bytesDeviations.length;
    long[] arrayOfLong1 = new long[i + 1];
    long[] arrayOfLong2 = new long[i + 1];
    arrayOfLong1[0] = paramLong;
    arrayOfLong2[0] = l;
    for (int j = 1; j <= i; j++)
    {
      paramLong += paramMlltFrame.bytesBetweenReference + paramMlltFrame.bytesDeviations[(j - 1)];
      l += paramMlltFrame.millisecondsBetweenReference + paramMlltFrame.millisecondsDeviations[(j - 1)];
      arrayOfLong1[j] = paramLong;
      arrayOfLong2[j] = l;
    }
    return new b(arrayOfLong1, arrayOfLong2);
  }

  public o.a a(long paramLong)
  {
    Pair localPair = a(c.a(ag.a(paramLong, 0L, this.c)), this.b, this.a);
    return new o.a(new p(c.b(((Long)localPair.first).longValue()), ((Long)localPair.second).longValue()));
  }

  public boolean a()
  {
    return true;
  }

  public long b()
  {
    return this.c;
  }

  public long c()
  {
    return -1L;
  }

  public long c(long paramLong)
  {
    return c.b(((Long)a(paramLong, this.a, this.b).second).longValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.d.b
 * JD-Core Version:    0.6.2
 */