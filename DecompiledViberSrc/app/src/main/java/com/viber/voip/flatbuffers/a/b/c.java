package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class c extends a
{
  public ac a(ac paramac, int paramInt)
  {
    int i = a(12);
    if (i != 0)
      return paramac.a(b(e(i) + paramInt * 4), this.b);
    return null;
  }

  public c a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public boolean b()
  {
    int i = a(4);
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

  public int c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public String d()
  {
    int i = a(8);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public long e()
  {
    int i = a(10);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public int f()
  {
    int i = a(12);
    if (i != 0)
      return d(i);
    return 0;
  }

  public ac f(int paramInt)
  {
    return a(new ac(), paramInt);
  }

  public int g()
  {
    int i = a(14);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public int h()
  {
    int i = a(16);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public int i()
  {
    int i = a(18);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public String j()
  {
    int i = a(20);
    if (i != 0)
      return c(i + this.a);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.c
 * JD-Core Version:    0.6.2
 */