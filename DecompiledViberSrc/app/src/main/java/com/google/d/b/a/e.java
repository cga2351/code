package com.google.d.b.a;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.i;
import com.google.d.l;
import com.google.d.n;
import com.google.d.o;
import com.google.d.r;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class e extends a
{
  private static final Reader b = new Reader()
  {
    public void close()
      throws IOException
    {
      throw new AssertionError();
    }

    public int read(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
      throws IOException
    {
      throw new AssertionError();
    }
  };
  private static final Object c = new Object();
  private Object[] d = new Object[32];
  private int e = 0;
  private String[] f = new String[32];
  private int[] g = new int[32];

  public e(l paraml)
  {
    super(b);
    a(paraml);
  }

  private void a(b paramb)
    throws IOException
  {
    if (f() != paramb)
      throw new IllegalStateException("Expected " + paramb + " but was " + f() + u());
  }

  private void a(Object paramObject)
  {
    if (this.e == this.d.length)
    {
      Object[] arrayOfObject2 = new Object[2 * this.e];
      int[] arrayOfInt = new int[2 * this.e];
      String[] arrayOfString = new String[2 * this.e];
      System.arraycopy(this.d, 0, arrayOfObject2, 0, this.e);
      System.arraycopy(this.g, 0, arrayOfInt, 0, this.e);
      System.arraycopy(this.f, 0, arrayOfString, 0, this.e);
      this.d = arrayOfObject2;
      this.g = arrayOfInt;
      this.f = arrayOfString;
    }
    Object[] arrayOfObject1 = this.d;
    int i = this.e;
    this.e = (i + 1);
    arrayOfObject1[i] = paramObject;
  }

  private Object s()
  {
    return this.d[(-1 + this.e)];
  }

  private Object t()
  {
    Object[] arrayOfObject = this.d;
    int i = -1 + this.e;
    this.e = i;
    Object localObject = arrayOfObject[i];
    this.d[this.e] = null;
    return localObject;
  }

  private String u()
  {
    return " at path " + p();
  }

  public void a()
    throws IOException
  {
    a(b.a);
    a(((i)s()).iterator());
    this.g[(-1 + this.e)] = 0;
  }

  public void b()
    throws IOException
  {
    a(b.b);
    t();
    t();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
    }
  }

  public void c()
    throws IOException
  {
    a(b.c);
    a(((o)s()).o().iterator());
  }

  public void close()
    throws IOException
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = c;
    this.d = arrayOfObject;
    this.e = 1;
  }

  public void d()
    throws IOException
  {
    a(b.d);
    t();
    t();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
    }
  }

  public boolean e()
    throws IOException
  {
    b localb = f();
    return (localb != b.d) && (localb != b.b);
  }

  public b f()
    throws IOException
  {
    if (this.e == 0)
      return b.j;
    Object localObject = s();
    if ((localObject instanceof Iterator))
    {
      boolean bool = this.d[(-2 + this.e)] instanceof o;
      Iterator localIterator = (Iterator)localObject;
      if (localIterator.hasNext())
      {
        if (bool)
          return b.e;
        a(localIterator.next());
        return f();
      }
      if (bool)
        return b.d;
      return b.b;
    }
    if ((localObject instanceof o))
      return b.c;
    if ((localObject instanceof i))
      return b.a;
    if ((localObject instanceof r))
    {
      r localr = (r)localObject;
      if (localr.q())
        return b.f;
      if (localr.o())
        return b.h;
      if (localr.p())
        return b.g;
      throw new AssertionError();
    }
    if ((localObject instanceof n))
      return b.i;
    if (localObject == c)
      throw new IllegalStateException("JsonReader is closed");
    throw new AssertionError();
  }

  public String g()
    throws IOException
  {
    a(b.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)s()).next();
    String str = (String)localEntry.getKey();
    this.f[(-1 + this.e)] = str;
    a(localEntry.getValue());
    return str;
  }

  public String h()
    throws IOException
  {
    b localb = f();
    if ((localb != b.f) && (localb != b.g))
      throw new IllegalStateException("Expected " + b.f + " but was " + localb + u());
    String str = ((r)t()).b();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
    }
    return str;
  }

  public boolean i()
    throws IOException
  {
    a(b.h);
    boolean bool = ((r)t()).f();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
    }
    return bool;
  }

  public void j()
    throws IOException
  {
    a(b.i);
    t();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
    }
  }

  public double k()
    throws IOException
  {
    b localb = f();
    if ((localb != b.g) && (localb != b.f))
      throw new IllegalStateException("Expected " + b.g + " but was " + localb + u());
    double d1 = ((r)s()).c();
    if ((!q()) && ((Double.isNaN(d1)) || (Double.isInfinite(d1))))
      throw new NumberFormatException("JSON forbids NaN and infinities: " + d1);
    t();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
    }
    return d1;
  }

  public long l()
    throws IOException
  {
    b localb = f();
    if ((localb != b.g) && (localb != b.f))
      throw new IllegalStateException("Expected " + b.g + " but was " + localb + u());
    long l = ((r)s()).d();
    t();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
    }
    return l;
  }

  public int m()
    throws IOException
  {
    b localb = f();
    if ((localb != b.g) && (localb != b.f))
      throw new IllegalStateException("Expected " + b.g + " but was " + localb + u());
    int i = ((r)s()).e();
    t();
    if (this.e > 0)
    {
      int[] arrayOfInt = this.g;
      int j = -1 + this.e;
      arrayOfInt[j] = (1 + arrayOfInt[j]);
    }
    return i;
  }

  public void n()
    throws IOException
  {
    if (f() == b.e)
    {
      g();
      this.f[(-2 + this.e)] = "null";
    }
    while (true)
    {
      int[] arrayOfInt = this.g;
      int i = -1 + this.e;
      arrayOfInt[i] = (1 + arrayOfInt[i]);
      return;
      t();
      this.f[(-1 + this.e)] = "null";
    }
  }

  public void o()
    throws IOException
  {
    a(b.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)s()).next();
    a(localEntry.getValue());
    a(new r((String)localEntry.getKey()));
  }

  public String p()
  {
    StringBuilder localStringBuilder = new StringBuilder().append('$');
    int i = 0;
    if (i < this.e)
    {
      if ((this.d[i] instanceof i))
      {
        Object[] arrayOfObject2 = this.d;
        i++;
        if ((arrayOfObject2[i] instanceof Iterator))
          localStringBuilder.append('[').append(this.g[i]).append(']');
      }
      while (true)
      {
        i++;
        break;
        if ((this.d[i] instanceof o))
        {
          Object[] arrayOfObject1 = this.d;
          i++;
          if ((arrayOfObject1[i] instanceof Iterator))
          {
            localStringBuilder.append('.');
            if (this.f[i] != null)
              localStringBuilder.append(this.f[i]);
          }
        }
      }
    }
    return localStringBuilder.toString();
  }

  public String toString()
  {
    return getClass().getSimpleName();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.e
 * JD-Core Version:    0.6.2
 */