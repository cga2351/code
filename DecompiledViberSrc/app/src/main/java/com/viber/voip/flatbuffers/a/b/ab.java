package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class ab extends a
{
  public ab a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public ag a(ag paramag, int paramInt)
  {
    int i = a(14);
    if (i != 0)
      return paramag.a(b(e(i) + paramInt * 4), this.b);
    return null;
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

  public int f()
  {
    int i = a(12);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public ag f(int paramInt)
  {
    return a(new ag(), paramInt);
  }

  public int g()
  {
    int i = a(14);
    if (i != 0)
      return d(i);
    return 0;
  }

  public int h()
  {
    int i = a(16);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.ab
 * JD-Core Version:    0.6.2
 */