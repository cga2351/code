package com.google.a.a.c.c;

import com.google.a.a.d.c;
import com.google.a.a.d.d;
import com.google.a.a.f.z;
import java.io.IOException;
import java.io.OutputStream;

public class a extends com.google.a.a.c.a
{
  private final Object a;
  private final c b;
  private String c;

  public a(c paramc, Object paramObject)
  {
    super("application/json; charset=UTF-8");
    this.b = ((c)z.a(paramc));
    this.a = z.a(paramObject);
  }

  public a a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    d locald = this.b.a(paramOutputStream, c());
    if (this.c != null)
    {
      locald.d();
      locald.a(this.c);
    }
    locald.a(this.a);
    if (this.c != null)
      locald.e();
    locald.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.c.a
 * JD-Core Version:    0.6.2
 */