package com.google.a.a.d;

import com.google.a.a.f.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class c
{
  private String a(Object paramObject, boolean paramBoolean)
    throws IOException
  {
    return b(paramObject, paramBoolean).toString("UTF-8");
  }

  private ByteArrayOutputStream b(Object paramObject, boolean paramBoolean)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    d locald = a(localByteArrayOutputStream, g.a);
    if (paramBoolean)
      locald.g();
    locald.a(paramObject);
    locald.a();
    return localByteArrayOutputStream;
  }

  public abstract d a(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException;

  public abstract f a(InputStream paramInputStream)
    throws IOException;

  public abstract f a(InputStream paramInputStream, Charset paramCharset)
    throws IOException;

  public abstract f a(String paramString)
    throws IOException;

  public final String a(Object paramObject)
    throws IOException
  {
    return a(paramObject, false);
  }

  public final String b(Object paramObject)
    throws IOException
  {
    return a(paramObject, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.d.c
 * JD-Core Version:    0.6.2
 */