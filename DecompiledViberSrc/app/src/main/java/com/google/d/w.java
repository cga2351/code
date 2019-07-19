package com.google.d;

import com.google.d.b.a.f;
import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.c;
import java.io.IOException;

public abstract class w<T>
{
  public final l a(T paramT)
  {
    try
    {
      f localf = new f();
      a(localf, paramT);
      l locall = localf.a();
      return locall;
    }
    catch (IOException localIOException)
    {
      throw new m(localIOException);
    }
  }

  public final w<T> a()
  {
    return new w()
    {
      public void a(c paramAnonymousc, T paramAnonymousT)
        throws IOException
      {
        if (paramAnonymousT == null)
        {
          paramAnonymousc.f();
          return;
        }
        w.this.a(paramAnonymousc, paramAnonymousT);
      }

      public T b(a paramAnonymousa)
        throws IOException
      {
        if (paramAnonymousa.f() == b.i)
        {
          paramAnonymousa.j();
          return null;
        }
        return w.this.b(paramAnonymousa);
      }
    };
  }

  public abstract void a(c paramc, T paramT)
    throws IOException;

  public abstract T b(a parama)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.w
 * JD-Core Version:    0.6.2
 */