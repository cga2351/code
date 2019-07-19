package com.google.a.a.c;

import com.google.a.a.f.ac;
import com.google.a.a.f.z;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ab extends a
{
  private ArrayList<a> a = new ArrayList();

  public ab()
  {
    super(new o("multipart/related").a("boundary", "__END_OF_PART__"));
  }

  public ab a(a parama)
  {
    this.a.add(z.a(parama));
    return this;
  }

  public ab a(Collection<? extends i> paramCollection)
  {
    this.a = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      a(new a((i)localIterator.next()));
    return this;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, c());
    String str = g();
    Iterator localIterator = this.a.iterator();
    m localm;
    i locali;
    j localj;
    long l;
    Object localObject;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      localm = new m().a(null);
      if (locala.b != null)
        localm.a(locala.b);
      localm.c(null).k(null).e(null).a(null).a("Content-Transfer-Encoding", null);
      locali = locala.a;
      if (locali == null)
        break label316;
      localm.a("Content-Transfer-Encoding", Arrays.asList(new String[] { "binary" }));
      localm.e(locali.d());
      localj = locala.c;
      if (localj == null)
      {
        l = locali.a();
        localObject = locali;
        label175: if (l != -1L)
          localm.a(Long.valueOf(l));
      }
    }
    while (true)
    {
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write(str);
      localOutputStreamWriter.write("\r\n");
      m.a(localm, null, null, localOutputStreamWriter);
      if (localObject != null)
      {
        localOutputStreamWriter.write("\r\n");
        localOutputStreamWriter.flush();
        ((ac)localObject).a(paramOutputStream);
      }
      localOutputStreamWriter.write("\r\n");
      break;
      localm.c(localj.a());
      localObject = new k(locali, localj);
      l = a.a(locali);
      break label175;
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write(str);
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write("\r\n");
      localOutputStreamWriter.flush();
      return;
      label316: localObject = null;
    }
  }

  public boolean f()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      if (!((a)localIterator.next()).a.f())
        return false;
    return true;
  }

  public final String g()
  {
    return b().c("boundary");
  }

  public static final class a
  {
    i a;
    m b;
    j c;

    public a()
    {
      this(null);
    }

    public a(i parami)
    {
      this(null, parami);
    }

    public a(m paramm, i parami)
    {
      a(paramm);
      a(parami);
    }

    public a a(i parami)
    {
      this.a = parami;
      return this;
    }

    public a a(m paramm)
    {
      this.b = paramm;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.ab
 * JD-Core Version:    0.6.2
 */