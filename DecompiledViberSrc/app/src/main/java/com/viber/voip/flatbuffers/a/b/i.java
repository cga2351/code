package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class i extends a
{
  public i a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public q a(q paramq)
  {
    int i = a(22);
    if (i != 0)
      return paramq.a(b(i + this.a), this.b);
    return null;
  }

  public String b()
  {
    int i = a(4);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String c()
  {
    int i = a(6);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public long d()
  {
    int i = a(8);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public long e()
  {
    int i = a(10);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public String f()
  {
    int i = a(12);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String g()
  {
    int i = a(14);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String h()
  {
    int i = a(16);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public double i()
  {
    int i = a(18);
    if (i != 0)
      return this.b.getDouble(i + this.a);
    return 0.0D;
  }

  public int j()
  {
    int i = a(20);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public q k()
  {
    return a(new q());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.i
 * JD-Core Version:    0.6.2
 */