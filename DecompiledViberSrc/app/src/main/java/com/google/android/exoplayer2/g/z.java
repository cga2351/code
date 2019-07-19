package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.y;

public final class z
  implements n
{
  private final b a;
  private boolean b;
  private long c;
  private long d;
  private y e;

  public z(b paramb)
  {
    this.a = paramb;
    this.e = y.a;
  }

  public y a(y paramy)
  {
    if (this.b)
      a(d());
    this.e = paramy;
    return paramy;
  }

  public void a()
  {
    if (!this.b)
    {
      this.d = this.a.a();
      this.b = true;
    }
  }

  public void a(long paramLong)
  {
    this.c = paramLong;
    if (this.b)
      this.d = this.a.a();
  }

  public void b()
  {
    if (this.b)
    {
      a(d());
      this.b = false;
    }
  }

  public long d()
  {
    long l1 = this.c;
    long l2;
    if (this.b)
    {
      l2 = this.a.a() - this.d;
      if (this.e.b == 1.0F)
        l1 += c.b(l2);
    }
    else
    {
      return l1;
    }
    return l1 + this.e.a(l2);
  }

  public y e()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.z
 * JD-Core Version:    0.6.2
 */