package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.w;
import java.io.IOException;

public class t
  implements y
{
  private final int a;

  public t()
  {
    this(-1);
  }

  public t(int paramInt)
  {
    this.a = paramInt;
  }

  public int a(int paramInt)
  {
    if (this.a == -1)
    {
      if (paramInt == 7)
        return 6;
      return 3;
    }
    return this.a;
  }

  public long a(int paramInt1, long paramLong, IOException paramIOException, int paramInt2)
  {
    long l = -9223372036854775807L;
    if ((paramIOException instanceof v.e))
    {
      int i = ((v.e)paramIOException).c;
      if ((i == 404) || (i == 410))
        l = 60000L;
    }
    return l;
  }

  public long b(int paramInt1, long paramLong, IOException paramIOException, int paramInt2)
  {
    if ((paramIOException instanceof w))
      return -9223372036854775807L;
    return Math.min(1000 * (paramInt2 - 1), 5000);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.t
 * JD-Core Version:    0.6.2
 */