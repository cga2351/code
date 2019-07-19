package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.TextMetaInfo.a;
import java.io.IOException;

public class g extends w<TextMetaInfo.a>
{
  public TextMetaInfo.a a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return TextMetaInfo.a.UNKNOWN;
    }
    return TextMetaInfo.a.fromValue(parama.m());
  }

  public void a(c paramc, TextMetaInfo.a parama)
    throws IOException
  {
    if (parama == null)
    {
      paramc.f();
      return;
    }
    paramc.a(parama.getValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.g
 * JD-Core Version:    0.6.2
 */