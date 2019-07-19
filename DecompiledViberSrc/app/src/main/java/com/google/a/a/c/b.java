package com.google.a.a.c;

import com.google.a.a.f.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class b
  implements i
{
  private String a;
  private boolean b = true;

  public b(String paramString)
  {
    a(paramString);
  }

  public b a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public b a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    o.a(b(), paramOutputStream, this.b);
    paramOutputStream.flush();
  }

  public abstract InputStream b()
    throws IOException;

  public final boolean c()
  {
    return this.b;
  }

  public String d()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.b
 * JD-Core Version:    0.6.2
 */