package com.viber.voip.flatbuffers.c;

import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import java.io.IOException;

public class i extends w<com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a>
{
  public com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a a(com.google.d.d.a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a.fromName(parama.h());
  }

  public void a(c paramc, com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a parama)
    throws IOException
  {
    if (parama == null)
    {
      paramc.f();
      return;
    }
    paramc.b(parama.getTypeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.i
 * JD-Core Version:    0.6.2
 */