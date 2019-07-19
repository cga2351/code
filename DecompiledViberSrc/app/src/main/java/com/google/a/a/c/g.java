package com.google.a.a.c;

import com.google.a.a.f.ac;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class g
  implements j
{
  public String a()
  {
    return "gzip";
  }

  public void a(ac paramac, OutputStream paramOutputStream)
    throws IOException
  {
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(paramOutputStream)
    {
      public void close()
        throws IOException
      {
        try
        {
          flush();
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    });
    paramac.a(localGZIPOutputStream);
    localGZIPOutputStream.close();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.g
 * JD-Core Version:    0.6.2
 */