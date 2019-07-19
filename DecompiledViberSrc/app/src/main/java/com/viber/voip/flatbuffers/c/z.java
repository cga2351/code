package com.viber.voip.flatbuffers.c;

import android.net.Uri;
import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.w;
import java.io.IOException;

public class z extends w<Uri>
{
  public static Uri c(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      return localUri;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public Uri a(a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return a(parama.h());
  }

  protected Uri a(String paramString)
  {
    return c(paramString);
  }

  public void a(c paramc, Uri paramUri)
    throws IOException
  {
    if (paramUri == null)
    {
      paramc.f();
      return;
    }
    paramc.b(paramUri.toString());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.z
 * JD-Core Version:    0.6.2
 */