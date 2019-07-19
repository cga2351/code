package com.google.a.a.e.a.a.a.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class a<T>
  implements Iterator<T>
{
  private a a = a.b;
  private T b;

  private boolean c()
  {
    this.a = a.d;
    this.b = a();
    if (this.a != a.c)
    {
      this.a = a.a;
      return true;
    }
    return false;
  }

  protected abstract T a();

  protected final T b()
  {
    this.a = a.c;
    return null;
  }

  public final boolean hasNext()
  {
    if (this.a != a.d);
    for (boolean bool1 = true; ; bool1 = false)
    {
      e.b(bool1);
      int i = 1.a[this.a.ordinal()];
      boolean bool2 = false;
      switch (i)
      {
      default:
        bool2 = c();
      case 1:
        return bool2;
      case 2:
      }
    }
    return true;
  }

  public final T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    this.a = a.b;
    Object localObject = this.b;
    this.b = null;
    return localObject;
  }

  public final void remove()
  {
    throw new UnsupportedOperationException();
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.e.a.a.a.a.a
 * JD-Core Version:    0.6.2
 */