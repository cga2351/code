package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class m extends a
{
  public m a(int paramInt, ByteBuffer paramByteBuffer)
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

  public String c()
  {
    int i = a(6);
    if (i != 0)
      return c(i + this.a);
    return null;
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

  public int h()
  {
    int i = a(16);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.m
 * JD-Core Version:    0.6.2
 */