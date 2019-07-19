package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.c.f;
import java.util.List;

public abstract class j extends f
  implements e
{
  private e c;
  private long d;

  public int a(long paramLong)
  {
    return this.c.a(paramLong - this.d);
  }

  public long a(int paramInt)
  {
    return this.c.a(paramInt) + this.d;
  }

  public void a()
  {
    super.a();
    this.c = null;
  }

  public void a(long paramLong1, e parame, long paramLong2)
  {
    this.a = paramLong1;
    this.c = parame;
    if (paramLong2 == 9223372036854775807L)
      paramLong2 = this.a;
    this.d = paramLong2;
  }

  public int b()
  {
    return this.c.b();
  }

  public List<b> b(long paramLong)
  {
    return this.c.b(paramLong - this.d);
  }

  public abstract void e();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.j
 * JD-Core Version:    0.6.2
 */