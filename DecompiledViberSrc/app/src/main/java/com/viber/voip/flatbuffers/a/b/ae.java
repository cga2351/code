package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class ae extends a
{
  public ae a(int paramInt, ByteBuffer paramByteBuffer)
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.ae
 * JD-Core Version:    0.6.2
 */