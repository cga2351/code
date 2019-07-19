package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.extractor.h;
import java.io.IOException;

final class g
{
  private static final long[] a = { 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L };
  private final byte[] b = new byte[8];
  private int c;
  private int d;

  public static int a(int paramInt)
  {
    for (int i = 0; i < a.length; i++)
      if ((a[i] & paramInt) != 0L)
        return i + 1;
    return -1;
  }

  public static long a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l1 = 0xFF & paramArrayOfByte[0];
    if (paramBoolean)
      l1 &= (0xFFFFFFFF ^ a[(paramInt - 1)]);
    long l2 = l1;
    for (int i = 1; i < paramInt; i++)
      l2 = l2 << 8 | 0xFF & paramArrayOfByte[i];
    return l2;
  }

  public long a(h paramh, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    throws IOException, InterruptedException
  {
    if (this.c == 0)
    {
      if (!paramh.a(this.b, 0, 1, paramBoolean1))
        return -1L;
      this.d = a(0xFF & this.b[0]);
      if (this.d == -1)
        throw new IllegalStateException("No valid varint length mask found");
      this.c = 1;
    }
    if (this.d > paramInt)
    {
      this.c = 0;
      return -2L;
    }
    if (this.d != 1)
      paramh.b(this.b, 1, -1 + this.d);
    this.c = 0;
    return a(this.b, this.d, paramBoolean2);
  }

  public void a()
  {
    this.c = 0;
    this.d = 0;
  }

  public int b()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.c.g
 * JD-Core Version:    0.6.2
 */