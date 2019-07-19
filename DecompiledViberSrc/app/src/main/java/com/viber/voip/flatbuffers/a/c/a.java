package com.viber.voip.flatbuffers.a.c;

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
    int i = a(30);
    if (i != 0)
      return paramb.a(b(e(i) + paramInt * 4), this.b);
    return null;
  }

  public String b()
  {
    int i = a(4);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public int c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public String d()
  {
    int i = a(8);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String e()
  {
    int i = a(10);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public b f(int paramInt)
  {
    return a(new b(), paramInt);
  }

  public String f()
  {
    int i = a(12);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public long g()
  {
    int i = a(14);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public boolean h()
  {
    int i = a(16);
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

  public String i()
  {
    int i = a(18);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public long j()
  {
    int i = a(20);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public int k()
  {
    int i = a(22);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public String l()
  {
    int i = a(24);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String m()
  {
    int i = a(26);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String n()
  {
    int i = a(28);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public int o()
  {
    int i = a(30);
    if (i != 0)
      return d(i);
    return 0;
  }

  public int p()
  {
    int i = a(32);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.c.a
 * JD-Core Version:    0.6.2
 */