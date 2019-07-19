package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import java.io.IOException;

public class c extends w<ReplyButton.b>
{
  public ReplyButton.b a(a parama)
    throws IOException
  {
    String str = null;
    if (parama.f() == b.i)
      parama.j();
    while (true)
    {
      return ReplyButton.b.fromName(str);
      str = parama.h();
    }
  }

  public void a(com.google.d.d.c paramc, ReplyButton.b paramb)
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
 * Qualified Name:     com.viber.voip.flatbuffers.c.c
 * JD-Core Version:    0.6.2
 */