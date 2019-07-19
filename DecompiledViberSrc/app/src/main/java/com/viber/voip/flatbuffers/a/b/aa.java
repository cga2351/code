package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class aa extends a
{
  public aa a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public ac a(ac paramac)
  {
    int i = a(4);
    if (i != 0)
      return paramac.a(b(i + this.a), this.b);
    return null;
  }

  public ac b()
  {
    return a(new ac());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.aa
 * JD-Core Version:    0.6.2
 */