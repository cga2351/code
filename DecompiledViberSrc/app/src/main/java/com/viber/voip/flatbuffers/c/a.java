package com.viber.voip.flatbuffers.c;

import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import java.io.IOException;

abstract class a extends w<Integer>
{
  public Integer a(com.google.d.d.a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return c();
    }
    try
    {
      Integer localInteger = a(parama.h());
      return localInteger;
    }
    catch (Exception localException)
    {
    }
    return b();
  }

  protected abstract Integer a(String paramString)
    throws Exception;

  protected abstract String a(Integer paramInteger);

  public void a(c paramc, Integer paramInteger)
    throws IOException
  {
    if ((paramInteger == null) || (paramInteger.intValue() == 0))
    {
      paramc.f();
      return;
    }
    paramc.b(a(paramInteger));
  }

  protected abstract Integer b();

  protected Integer c()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.a
 * JD-Core Version:    0.6.2
 */