package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.b;
import java.io.IOException;

public class ab extends w<FileInfo.b>
{
  public FileInfo.b a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return FileInfo.b.VIDEO;
    }
    return FileInfo.b.fromName(parama.h());
  }

  public void a(c paramc, FileInfo.b paramb)
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
 * Qualified Name:     com.viber.voip.flatbuffers.c.ab
 * JD-Core Version:    0.6.2
 */