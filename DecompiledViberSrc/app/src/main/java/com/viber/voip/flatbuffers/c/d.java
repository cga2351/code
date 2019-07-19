package com.viber.voip.flatbuffers.c;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import java.io.IOException;

public class d extends w<String>
{
  public static String a(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (paramString.length() <= 250)
      return paramString;
    return paramString.substring(0, 247) + '…';
  }

  public String a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return a(parama.h());
  }

  public void a(c paramc, String paramString)
    throws IOException
  {
    if (paramString == null)
    {
      paramc.f();
      return;
    }
    paramc.b(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.d
 * JD-Core Version:    0.6.2
 */