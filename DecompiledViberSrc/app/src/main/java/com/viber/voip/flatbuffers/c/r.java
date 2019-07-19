package com.viber.voip.flatbuffers.c;

import com.google.d.d.c;
import java.io.IOException;

public class r extends a
{
  protected Integer a(String paramString)
    throws Exception
  {
    int i = Integer.parseInt(paramString);
    if (i < 0)
      return b();
    return Integer.valueOf(i);
  }

  protected String a(Integer paramInteger)
  {
    return String.valueOf(paramInteger);
  }

  public void a(c paramc, Integer paramInteger)
    throws IOException
  {
    if (paramInteger == null)
    {
      paramc.f();
      return;
    }
    paramc.b(a(paramInteger));
  }

  protected Integer b()
  {
    return Integer.valueOf(100);
  }

  protected Integer c()
  {
    return b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.r
 * JD-Core Version:    0.6.2
 */