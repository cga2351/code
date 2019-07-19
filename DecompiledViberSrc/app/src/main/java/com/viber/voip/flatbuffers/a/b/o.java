package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class o extends a
{
  public o a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public double b()
  {
    int i = a(4);
    if (i != 0)
      return this.b.getDouble(i + this.a);
    return 0.0D;
  }

  public double c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getDouble(i + this.a);
    return 0.0D;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.o
 * JD-Core Version:    0.6.2
 */