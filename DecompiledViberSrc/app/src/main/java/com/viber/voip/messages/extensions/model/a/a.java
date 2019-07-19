package com.viber.voip.messages.extensions.model.a;

import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import com.viber.voip.messages.extensions.model.c.a;
import java.io.IOException;

public class a extends w<c.a>
{
  public c.a a(com.google.d.d.a parama)
    throws IOException
  {
    if (parama.f() == b.i)
      return null;
    return c.a.a(parama.h());
  }

  public void a(c paramc, c.a parama)
    throws IOException
  {
    if (parama == null)
      return;
    paramc.b(parama.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.model.a.a
 * JD-Core Version:    0.6.2
 */