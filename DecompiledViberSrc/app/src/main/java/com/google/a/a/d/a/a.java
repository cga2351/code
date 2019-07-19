package com.google.a.a.d.a;

import com.c.a.a.d.a;
import com.c.a.a.j;
import com.google.a.a.d.d;
import com.google.a.a.d.f;
import com.google.a.a.d.i;
import com.google.a.a.f.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class a extends com.google.a.a.d.c
{
  private final com.c.a.a.b a = new com.c.a.a.b();

  public a()
  {
    this.a.a(d.a.b, false);
  }

  public static a a()
  {
    return a.a;
  }

  static i a(j paramj)
  {
    if (paramj == null)
      return null;
    switch (1.a[paramj.ordinal()])
    {
    default:
      return i.l;
    case 1:
      return i.b;
    case 2:
      return i.a;
    case 3:
      return i.d;
    case 4:
      return i.c;
    case 5:
      return i.j;
    case 6:
      return i.i;
    case 7:
      return i.k;
    case 8:
      return i.f;
    case 9:
      return i.h;
    case 10:
      return i.g;
    case 11:
    }
    return i.e;
  }

  public d a(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    return new b(this, this.a.a(paramOutputStream, com.c.a.a.a.a));
  }

  public f a(InputStream paramInputStream)
    throws IOException
  {
    z.a(paramInputStream);
    return new c(this, this.a.a(paramInputStream));
  }

  public f a(InputStream paramInputStream, Charset paramCharset)
    throws IOException
  {
    z.a(paramInputStream);
    return new c(this, this.a.a(paramInputStream));
  }

  public f a(String paramString)
    throws IOException
  {
    z.a(paramString);
    return new c(this, this.a.a(paramString));
  }

  static class a
  {
    static final a a = new a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.d.a.a
 * JD-Core Version:    0.6.2
 */