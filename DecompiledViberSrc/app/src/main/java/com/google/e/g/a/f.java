package com.google.e.g.a;

import java.util.Formatter;

final class f
{
  private final a a;
  private final g[] b;
  private c c;
  private final int d;

  f(a parama, c paramc)
  {
    this.a = parama;
    this.d = parama.a();
    this.c = paramc;
    this.b = new g[2 + this.d];
  }

  private static int a(int paramInt1, int paramInt2, d paramd)
  {
    if (paramd == null);
    while (paramd.a())
      return paramInt2;
    if (paramd.a(paramInt1))
    {
      paramd.b(paramInt1);
      return 0;
    }
    return paramInt2 + 1;
  }

  private void a(int paramInt1, int paramInt2, d[] paramArrayOfd)
  {
    d locald = paramArrayOfd[paramInt2];
    d[] arrayOfd1 = this.b[(paramInt1 - 1)].b();
    if (this.b[(paramInt1 + 1)] != null);
    for (d[] arrayOfd2 = this.b[(paramInt1 + 1)].b(); ; arrayOfd2 = arrayOfd1)
    {
      d[] arrayOfd3 = new d[14];
      arrayOfd3[2] = arrayOfd1[paramInt2];
      arrayOfd3[3] = arrayOfd2[paramInt2];
      if (paramInt2 > 0)
      {
        arrayOfd3[0] = paramArrayOfd[(paramInt2 - 1)];
        arrayOfd3[4] = arrayOfd1[(paramInt2 - 1)];
        arrayOfd3[5] = arrayOfd2[(paramInt2 - 1)];
      }
      if (paramInt2 > 1)
      {
        arrayOfd3[8] = paramArrayOfd[(paramInt2 - 2)];
        arrayOfd3[10] = arrayOfd1[(paramInt2 - 2)];
        arrayOfd3[11] = arrayOfd2[(paramInt2 - 2)];
      }
      if (paramInt2 < -1 + paramArrayOfd.length)
      {
        arrayOfd3[1] = paramArrayOfd[(paramInt2 + 1)];
        arrayOfd3[6] = arrayOfd1[(paramInt2 + 1)];
        arrayOfd3[7] = arrayOfd2[(paramInt2 + 1)];
      }
      if (paramInt2 < -2 + paramArrayOfd.length)
      {
        arrayOfd3[9] = paramArrayOfd[(paramInt2 + 2)];
        arrayOfd3[12] = arrayOfd1[(paramInt2 + 2)];
        arrayOfd3[13] = arrayOfd2[(paramInt2 + 2)];
      }
      int i = arrayOfd3.length;
      for (int j = 0; ; j++)
        if ((j >= i) || (a(locald, arrayOfd3[j])))
          return;
    }
  }

  private void a(g paramg)
  {
    if (paramg != null)
      ((h)paramg).a(this.a);
  }

  private static boolean a(d paramd1, d paramd2)
  {
    if (paramd2 == null);
    while ((!paramd2.a()) || (paramd2.f() != paramd1.f()))
      return false;
    paramd1.b(paramd2.h());
    return true;
  }

  private int f()
  {
    int i = g();
    if (i == 0)
      return 0;
    for (int j = 1; j < 1 + this.d; j++)
    {
      d[] arrayOfd = this.b[j].b();
      int k = 0;
      if (k < arrayOfd.length)
      {
        if (arrayOfd[k] == null);
        while (true)
        {
          k++;
          break;
          if (!arrayOfd[k].a())
            a(j, k, arrayOfd);
        }
      }
    }
    return i;
  }

  private int g()
  {
    h();
    return j() + i();
  }

  private void h()
  {
    int i = 0;
    if ((this.b[0] == null) || (this.b[(1 + this.d)] == null));
    while (true)
    {
      return;
      d[] arrayOfd1 = this.b[0].b();
      d[] arrayOfd2 = this.b[(1 + this.d)].b();
      while (i < arrayOfd1.length)
      {
        if ((arrayOfd1[i] != null) && (arrayOfd2[i] != null) && (arrayOfd1[i].h() == arrayOfd2[i].h()))
        {
          int j = 1;
          if (j <= this.d)
          {
            d locald = this.b[j].b()[i];
            if (locald == null);
            while (true)
            {
              j++;
              break;
              locald.b(arrayOfd1[i].h());
              if (!locald.a())
                this.b[j].b()[i] = null;
            }
          }
        }
        i++;
      }
    }
  }

  private int i()
  {
    if (this.b[(1 + this.d)] == null)
      return 0;
    d[] arrayOfd = this.b[(1 + this.d)].b();
    int i = 0;
    int j = 0;
    if (i < arrayOfd.length)
      if (arrayOfd[i] != null);
    while (true)
    {
      i++;
      break;
      int k = arrayOfd[i].h();
      int m = 1 + this.d;
      int n = j;
      int i1 = 0;
      while ((m > 0) && (i1 < 2))
      {
        d locald = this.b[m].b()[i];
        if (locald != null)
        {
          i1 = a(k, i1, locald);
          if (!locald.a())
            n++;
        }
        m--;
        continue;
        return j;
      }
      j = n;
    }
  }

  private int j()
  {
    if (this.b[0] == null)
      return 0;
    d[] arrayOfd = this.b[0].b();
    int i = 0;
    int j = 0;
    if (i < arrayOfd.length)
      if (arrayOfd[i] != null);
    while (true)
    {
      i++;
      break;
      int k = arrayOfd[i].h();
      int m = j;
      int n = 1;
      int i1 = 0;
      while ((n < 1 + this.d) && (i1 < 2))
      {
        d locald = this.b[n].b()[i];
        if (locald != null)
        {
          i1 = a(k, i1, locald);
          if (!locald.a())
            m++;
        }
        n++;
        continue;
        return j;
      }
      j = m;
    }
  }

  g a(int paramInt)
  {
    return this.b[paramInt];
  }

  void a(int paramInt, g paramg)
  {
    this.b[paramInt] = paramg;
  }

  public void a(c paramc)
  {
    this.c = paramc;
  }

  g[] a()
  {
    a(this.b[0]);
    a(this.b[(1 + this.d)]);
    int j;
    for (int i = 928; ; i = j)
    {
      j = f();
      if ((j <= 0) || (j >= i))
        return this.b;
    }
  }

  int b()
  {
    return this.d;
  }

  int c()
  {
    return this.a.c();
  }

  int d()
  {
    return this.a.b();
  }

  c e()
  {
    return this.c;
  }

  public String toString()
  {
    g localg = this.b[0];
    if (localg == null)
      localg = this.b[(1 + this.d)];
    Formatter localFormatter = new Formatter();
    for (int i = 0; i < localg.b().length; i++)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i);
      localFormatter.format("CW %3d:", arrayOfObject1);
      int j = 0;
      if (j < 2 + this.d)
      {
        if (this.b[j] == null)
          localFormatter.format("    |   ", new Object[0]);
        while (true)
        {
          j++;
          break;
          d locald = this.b[j].b()[i];
          if (locald == null)
          {
            localFormatter.format("    |   ", new Object[0]);
          }
          else
          {
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = Integer.valueOf(locald.h());
            arrayOfObject2[1] = Integer.valueOf(locald.g());
            localFormatter.format(" %3d|%3d", arrayOfObject2);
          }
        }
      }
      localFormatter.format("%n", new Object[0]);
    }
    String str = localFormatter.toString();
    localFormatter.close();
    return str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.f
 * JD-Core Version:    0.6.2
 */