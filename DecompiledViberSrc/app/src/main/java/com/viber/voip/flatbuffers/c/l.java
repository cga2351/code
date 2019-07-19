package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import java.io.IOException;

public class l extends w<MediaInfo.a>
{
  public MediaInfo.a a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return MediaInfo.a.UNKNOWN;
    }
    return MediaInfo.a.fromName(parama.h());
  }

  public void a(c paramc, MediaInfo.a parama)
    throws IOException
  {
    if ((parama == null) || (parama == MediaInfo.a.UNKNOWN))
    {
      paramc.f();
      return;
    }
    paramc.b(parama.getTypeName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.l
 * JD-Core Version:    0.6.2
 */