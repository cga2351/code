package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.e;
import java.io.IOException;

public class t extends w<ReplyButton.e>
{
  public ReplyButton.e a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return ReplyButton.e.fromName(parama.h());
  }

  public void a(c paramc, ReplyButton.e parame)
    throws IOException
  {
    if (parame == null)
    {
      paramc.f();
      return;
    }
    paramc.b(parame.getTypeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.t
 * JD-Core Version:    0.6.2
 */