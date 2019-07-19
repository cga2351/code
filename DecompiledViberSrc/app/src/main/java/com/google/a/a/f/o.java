package com.google.a.a.f;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class o
{
  public static long a(ac paramac)
    throws IOException
  {
    e locale = new e();
    try
    {
      paramac.a(locale);
      return locale.a;
    }
    finally
    {
      locale.close();
    }
  }

  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramInputStream, paramOutputStream, true);
  }

  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    try
    {
      f.a(paramInputStream, paramOutputStream);
      return;
    }
    finally
    {
      if (paramBoolean)
        paramInputStream.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.o
 * JD-Core Version:    0.6.2
 */