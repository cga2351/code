package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.d;
import java.io.IOException;

public class s extends w<ReplyButton.d>
{
  public ReplyButton.d a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return ReplyButton.d.fromName(parama.h());
  }

  public void a(c paramc, ReplyButton.d paramd)
    throws IOException
  {
    if (paramd == null)
    {
      paramc.f();
      return;
    }
    paramc.b(paramd.getTypeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.s
 * JD-Core Version:    0.6.2
 */