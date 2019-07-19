package com.google.e.g.a;

import java.util.Formatter;

class g
{
  private final c a;
  private final d[] b;

  g(c paramc)
  {
    this.a = new c(paramc);
    this.b = new d[1 + (paramc.d() - paramc.c())];
  }

  final c a()
  {
    return this.a;
  }

  final d a(int paramInt)
  {
    d locald = c(paramInt);
    if (locald != null)
      return locald;
    for (int i = 1; ; i++)
    {
      if (i >= 5)
        break label82;
      int j = b(paramInt) - i;
      if (j >= 0)
      {
        locald = this.b[j];
        if (locald != null)
          break;
      }
      int k = i + b(paramInt);
      if (k < this.b.length)
      {
        locald = this.b[k];
        if (locald != null)
          break;
      }
    }
    label82: return null;
  }

  final void a(int paramInt, d paramd)
  {
    this.b[b(paramInt)] = paramd;
  }

  final int b(int paramInt)
  {
    return paramInt - this.a.c();
  }

  final d[] b()
  {
    return this.b;
  }

  final d c(int paramInt)
  {
    return this.b[b(paramInt)];
  }

  public String toString()
  {
    Formatter localFormatter = new Formatter();
    d[] arrayOfd = this.b;
    int i = arrayOfd.length;
    int j = 0;
    int k = 0;
    if (j < i)
    {
      d locald = arrayOfd[j];
      int m;
      if (locald == null)
      {
        Object[] arrayOfObject2 = new Object[1];
        m = k + 1;
        arrayOfObject2[0] = Integer.valueOf(k);
        localFormatter.format("%3d:    |   %n", arrayOfObject2);
      }
      while (true)
      {
        j++;
        k = m;
        break;
        Object[] arrayOfObject1 = new Object[3];
        m = k + 1;
        arrayOfObject1[0] = Integer.valueOf(k);
        arrayOfObject1[1] = Integer.valueOf(locald.h());
        arrayOfObject1[2] = Integer.valueOf(locald.g());
        localFormatter.format("%3d: %3d|%3d%n", arrayOfObject1);
      }
    }
    String str = localFormatter.toString();
    localFormatter.close();
    return str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.g
 * JD-Core Version:    0.6.2
 */