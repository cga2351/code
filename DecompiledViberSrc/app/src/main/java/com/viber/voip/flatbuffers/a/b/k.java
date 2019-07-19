package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class k extends a
{
  public k a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public long b()
  {
    int i = a(4);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public int c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public long d()
  {
    int i = a(8);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public String e()
  {
    int i = a(10);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String f()
  {
    int i = a(12);
    if (i != 0)
      return c(i + this.a);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.k
 * JD-Core Version:    0.6.2
 */