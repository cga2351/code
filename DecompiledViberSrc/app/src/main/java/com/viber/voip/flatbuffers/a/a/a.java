package com.viber.voip.flatbuffers.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a extends com.google.c.a
{
  public static a a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, new a());
  }

  public static a a(ByteBuffer paramByteBuffer, a parama)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return parama.a(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
  }

  public a a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public b a(b paramb, int paramInt)
  {
    int i = a(4);
    if (i != 0)
      return paramb.a(b(e(i) + paramInt * 4), this.b);
    return null;
  }

  public int b()
  {
    int i = a(4);
    if (i != 0)
      return d(i);
    return 0;
  }

  public boolean c()
  {
    int i = a(6);
    boolean bool = false;
    if (i != 0)
    {
      int j = this.b.get(i + this.a);
      bool = false;
      if (j != 0)
        bool = true;
    }
    return bool;
  }

  public b f(int paramInt)
  {
    return a(new b(), paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.a.a
 * JD-Core Version:    0.6.2
 */