package com.viber.voip.messages.extensions.model.a;

import com.google.d.d.a;
import com.google.d.d.c;
import com.google.d.w;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b extends w<String>
{
  private String a(String paramString)
  {
    if (paramString == null)
      return null;
    String str = Pattern.compile("<link>", 2).matcher(paramString).replaceAll("<lnk>");
    return Pattern.compile("</link>", 2).matcher(str).replaceAll("</lnk>");
  }

  public String a(a parama)
    throws IOException
  {
    if (parama.f() == com.google.d.d.b.i)
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
 * Qualified Name:     com.viber.voip.messages.extensions.model.a.b
 * JD-Core Version:    0.6.2
 */