package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.c;
import com.google.d.w;
import java.io.IOException;

public class aa extends w<com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b>
{
  public com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b a(a parama)
    throws IOException
  {
    if (parama.f() == com.google.d.d.b.i)
    {
      parama.j();
      return null;
    }
    return com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b.fromName(parama.h());
  }

  public void a(c paramc, com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b paramb)
    throws IOException
  {
    if (paramb == null)
    {
      paramc.f();
      return;
    }
    paramc.b(paramb.getTypeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.aa
 * JD-Core Version:    0.6.2
 */