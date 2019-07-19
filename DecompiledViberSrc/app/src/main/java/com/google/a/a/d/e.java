package com.google.a.a.d;

import com.google.a.a.f.aa;
import com.google.a.a.f.x;
import com.google.a.a.f.z;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class e
  implements x
{
  private final c a;
  private final Set<String> b;

  protected e(a parama)
  {
    this.a = parama.a;
    this.b = new HashSet(parama.b);
  }

  private void a(f paramf)
    throws IOException
  {
    boolean bool = true;
    if (this.b.isEmpty())
      return;
    while (true)
    {
      try
      {
        if ((paramf.a(this.b) != null) && (paramf.d() != i.d))
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.b;
          z.a(bool, "wrapper key(s) not found: %s", arrayOfObject);
          return;
        }
      }
      finally
      {
        paramf.b();
      }
      bool = false;
    }
  }

  public final c a()
  {
    return this.a;
  }

  public <T> T a(InputStream paramInputStream, Charset paramCharset, Class<T> paramClass)
    throws IOException
  {
    return a(paramInputStream, paramCharset, paramClass);
  }

  public Object a(InputStream paramInputStream, Charset paramCharset, Type paramType)
    throws IOException
  {
    f localf = this.a.a(paramInputStream, paramCharset);
    a(localf);
    return localf.a(paramType, true);
  }

  public Set<String> b()
  {
    return Collections.unmodifiableSet(this.b);
  }

  public static class a
  {
    final c a;
    Collection<String> b = aa.a();

    public a(c paramc)
    {
      this.a = ((c)z.a(paramc));
    }

    public a a(Collection<String> paramCollection)
    {
      this.b = paramCollection;
      return this;
    }

    public e a()
    {
      return new e(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.d.e
 * JD-Core Version:    0.6.2
 */