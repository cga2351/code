package com.c.a.a;

import com.c.a.a.b.j;
import com.c.a.a.c.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

public class b
  implements Serializable
{
  protected static final int a = a.a();
  protected static final int b = g.a.a();
  protected static final int c = d.a.a();
  protected static final ThreadLocal<SoftReference<com.c.a.a.e.a>> d = new ThreadLocal();
  private static final m o = com.c.a.a.e.c.a;
  protected final transient com.c.a.a.d.b e = com.c.a.a.d.b.a();
  protected final transient com.c.a.a.d.a f = com.c.a.a.d.a.a();
  protected k g;
  protected int h = a;
  protected int i = b;
  protected int j = c;
  protected com.c.a.a.b.c k;
  protected com.c.a.a.b.e l;
  protected j m;
  protected m n = o;

  public b()
  {
    this(null);
  }

  public b(k paramk)
  {
    this.g = paramk;
  }

  protected com.c.a.a.b.d a(Object paramObject, boolean paramBoolean)
  {
    return new com.c.a.a.b.d(a(), paramObject, paramBoolean);
  }

  public b a(d.a parama)
  {
    this.j |= parama.c();
    return this;
  }

  public final b a(d.a parama, boolean paramBoolean)
  {
    if (paramBoolean)
      return a(parama);
    return b(parama);
  }

  public d a(OutputStream paramOutputStream, a parama)
    throws IOException
  {
    com.c.a.a.b.d locald = a(paramOutputStream, false);
    locald.a(parama);
    if (parama == a.a)
    {
      if (this.m != null)
        paramOutputStream = this.m.a(locald, paramOutputStream);
      return a(paramOutputStream, locald);
    }
    Writer localWriter = a(paramOutputStream, parama, locald);
    if (this.m != null)
      localWriter = this.m.a(locald, localWriter);
    return a(localWriter, locald);
  }

  @Deprecated
  protected d a(OutputStream paramOutputStream, com.c.a.a.b.d paramd)
    throws IOException
  {
    com.c.a.a.c.f localf = new com.c.a.a.c.f(paramd, this.j, this.g, paramOutputStream);
    if (this.k != null)
      localf.a(this.k);
    m localm = this.n;
    if (localm != o)
      localf.a(localm);
    return localf;
  }

  protected d a(Writer paramWriter, com.c.a.a.b.d paramd)
    throws IOException
  {
    return b(paramWriter, paramd);
  }

  public com.c.a.a.e.a a()
  {
    SoftReference localSoftReference = (SoftReference)d.get();
    if (localSoftReference == null);
    for (com.c.a.a.e.a locala = null; ; locala = (com.c.a.a.e.a)localSoftReference.get())
    {
      if (locala == null)
      {
        locala = new com.c.a.a.e.a();
        d.set(new SoftReference(locala));
      }
      return locala;
    }
  }

  public g a(InputStream paramInputStream)
    throws IOException, f
  {
    com.c.a.a.b.d locald = a(paramInputStream, false);
    if (this.l != null)
      paramInputStream = this.l.a(locald, paramInputStream);
    return a(paramInputStream, locald);
  }

  protected g a(InputStream paramInputStream, com.c.a.a.b.d paramd)
    throws IOException, f
  {
    return b(paramInputStream, paramd);
  }

  protected g a(Reader paramReader, com.c.a.a.b.d paramd)
    throws IOException, f
  {
    return b(paramReader, paramd);
  }

  public g a(String paramString)
    throws IOException, f
  {
    Object localObject = new StringReader(paramString);
    com.c.a.a.b.d locald = a(localObject, true);
    if (this.l != null)
      localObject = this.l.a(locald, (Reader)localObject);
    return a((Reader)localObject, locald);
  }

  protected Writer a(OutputStream paramOutputStream, a parama, com.c.a.a.b.d paramd)
    throws IOException
  {
    if (parama == a.a)
      return new com.c.a.a.b.m(paramd, paramOutputStream);
    return new OutputStreamWriter(paramOutputStream, parama.a());
  }

  public final boolean a(a parama)
  {
    return (this.h & parama.c()) != 0;
  }

  public b b(d.a parama)
  {
    this.j &= (0xFFFFFFFF ^ parama.c());
    return this;
  }

  @Deprecated
  protected d b(Writer paramWriter, com.c.a.a.b.d paramd)
    throws IOException
  {
    h localh = new h(paramd, this.j, this.g, paramWriter);
    if (this.k != null)
      localh.a(this.k);
    m localm = this.n;
    if (localm != o)
      localh.a(localm);
    return localh;
  }

  @Deprecated
  protected g b(InputStream paramInputStream, com.c.a.a.b.d paramd)
    throws IOException, f
  {
    return new com.c.a.a.c.a(paramd, paramInputStream).a(this.i, this.g, this.f, this.e, a(a.b), a(a.a));
  }

  @Deprecated
  protected g b(Reader paramReader, com.c.a.a.b.d paramd)
    throws IOException, f
  {
    return new com.c.a.a.c.e(paramd, this.i, paramReader, this.g, this.e.a(a(a.b), a(a.a)));
  }

  public static enum a
  {
    private final boolean c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }

    public static int a()
    {
      int i = 0;
      for (a locala : values())
        if (locala.b())
          i |= locala.c();
      return i;
    }

    public boolean b()
    {
      return this.c;
    }

    public int c()
    {
      return 1 << ordinal();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b
 * JD-Core Version:    0.6.2
 */