package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.g;
import java.io.IOException;

public class v extends w<ReplyButton.g>
{
  public ReplyButton.g a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return ReplyButton.g.REGULAR;
    }
    return ReplyButton.g.fromName(parama.h());
  }

  public void a(c paramc, ReplyButton.g paramg)
    throws IOException
  {
    if (paramg == null)
    {
      paramc.f();
      return;
    }
    paramc.b(paramg.getTypeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.v
 * JD-Core Version:    0.6.2
 */