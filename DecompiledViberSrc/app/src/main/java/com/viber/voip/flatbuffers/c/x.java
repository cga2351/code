package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import java.io.IOException;

public class x extends w<UnsignedLong>
{
  public UnsignedLong a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return new UnsignedLong(parama.l());
  }

  public void a(c paramc, UnsignedLong paramUnsignedLong)
    throws IOException
  {
    if ((paramUnsignedLong == null) || (paramUnsignedLong.get() == 0L))
    {
      paramc.f();
      return;
    }
    paramc.a(paramUnsignedLong.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.x
 * JD-Core Version:    0.6.2
 */