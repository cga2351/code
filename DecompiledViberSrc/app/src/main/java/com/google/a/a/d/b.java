package com.google.a.a.d;

import com.google.a.a.f.af;
import com.google.a.a.f.n;
import java.io.IOException;

public class b extends n
  implements Cloneable
{
  private c c;

  public final void a(c paramc)
  {
    this.c = paramc;
  }

  public b b()
  {
    return (b)super.c();
  }

  public b b(String paramString, Object paramObject)
  {
    return (b)super.c(paramString, paramObject);
  }

  public String d()
    throws IOException
  {
    if (this.c != null)
      return this.c.b(this);
    return super.toString();
  }

  public String toString()
  {
    if (this.c != null)
      try
      {
        String str = this.c.a(this);
        return str;
      }
      catch (IOException localIOException)
      {
        throw af.a(localIOException);
      }
    return super.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.d.b
 * JD-Core Version:    0.6.2
 */