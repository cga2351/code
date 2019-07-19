package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.c;
import java.io.IOException;

public class q extends w<ReplyButton.c>
{
  public ReplyButton.c a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return ReplyButton.c.UNKNOWN;
    }
    return ReplyButton.c.fromName(parama.h());
  }

  public void a(c paramc, ReplyButton.c paramc1)
    throws IOException
  {
    if (paramc1 == null)
    {
      paramc.f();
      return;
    }
    paramc.b(paramc1.getTypeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.q
 * JD-Core Version:    0.6.2
 */