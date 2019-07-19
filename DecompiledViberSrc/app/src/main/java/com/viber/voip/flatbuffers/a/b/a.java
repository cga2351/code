package com.viber.voip.flatbuffers.a.b;

import java.nio.ByteBuffer;

public final class a extends com.google.c.a
{
  public a a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public String b()
  {
    int i = a(4);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public long c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.a
 * JD-Core Version:    0.6.2
 */