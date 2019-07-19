package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.IvmInfo.a;
import java.io.IOException;

public class k extends w<IvmInfo.a>
{
  public IvmInfo.a a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return IvmInfo.a.CIRCLE;
    }
    return IvmInfo.a.fromName(parama.h());
  }

  public void a(c paramc, IvmInfo.a parama)
    throws IOException
  {
    if (parama == null)
    {
      paramc.f();
      return;
    }
    paramc.b(parama.getShapeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.k
 * JD-Core Version:    0.6.2
 */