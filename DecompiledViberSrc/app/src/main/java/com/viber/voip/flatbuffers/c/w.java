package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import java.io.IOException;

public class w extends com.google.d.w<UnsignedInt>
{
  public UnsignedInt a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return new UnsignedInt(parama.m());
  }

  public void a(c paramc, UnsignedInt paramUnsignedInt)
    throws IOException
  {
    if ((paramUnsignedInt == null) || (paramUnsignedInt.get() == 0))
    {
      paramc.f();
      return;
    }
    paramc.a(paramUnsignedInt.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.w
 * JD-Core Version:    0.6.2
 */