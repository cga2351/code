package com.google.d;

import com.google.d.b.j;
import com.google.d.d.c;
import java.io.IOException;
import java.io.StringWriter;

public abstract class l
{
  public Number a()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public String b()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public double c()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public long d()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public int e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public boolean f()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public boolean g()
  {
    return this instanceof i;
  }

  public boolean h()
  {
    return this instanceof o;
  }

  public boolean i()
  {
    return this instanceof r;
  }

  public boolean j()
  {
    return this instanceof n;
  }

  public o k()
  {
    if (h())
      return (o)this;
    throw new IllegalStateException("Not a JSON Object: " + this);
  }

  public i l()
  {
    if (g())
      return (i)this;
    throw new IllegalStateException("This is not a JSON Array.");
  }

  public r m()
  {
    if (i())
      return (r)this;
    throw new IllegalStateException("This is not a JSON Primitive.");
  }

  Boolean n()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }

  public String toString()
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      c localc = new c(localStringWriter);
      localc.b(true);
      j.a(this, localc);
      String str = localStringWriter.toString();
      return str;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.l
 * JD-Core Version:    0.6.2
 */