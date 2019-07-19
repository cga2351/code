package com.android.camera.a;

import android.net.Uri;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class g
  implements d
{
  private final d[] a;
  private final PriorityQueue<c> b;
  private long[] c;
  private int d;
  private int[] e;
  private int f;

  public g(d[] paramArrayOfd, int paramInt)
  {
    this.a = ((d[])paramArrayOfd.clone());
    if (paramInt == 1);
    for (Object localObject = new a(null); ; localObject = new b(null))
    {
      this.b = new PriorityQueue(4, (Comparator)localObject);
      this.c = new long[16];
      this.d = 0;
      this.e = new int[this.a.length];
      this.f = -1;
      this.b.clear();
      int i = this.a.length;
      for (int j = 0; j < i; j++)
      {
        c localc = new c(this.a[j], j);
        if (localc.a())
          this.b.add(localc);
      }
    }
  }

  private c c()
  {
    c localc = (c)this.b.poll();
    if (localc == null)
      return null;
    if (localc.a == this.f)
    {
      int j = -1 + this.d;
      long[] arrayOfLong3 = this.c;
      arrayOfLong3[j] = (1L + arrayOfLong3[j]);
      return localc;
    }
    this.f = localc.a;
    if (this.c.length == this.d)
    {
      long[] arrayOfLong2 = new long[2 * this.d];
      System.arraycopy(this.c, 0, arrayOfLong2, 0, this.d);
      this.c = arrayOfLong2;
    }
    long[] arrayOfLong1 = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfLong1[i] = (1L | this.f << 32);
    return localc;
  }

  public c a(int paramInt)
  {
    int i = 0;
    if ((paramInt < 0) || (paramInt > b()))
      throw new IndexOutOfBoundsException("index " + paramInt + " out of range max is " + b());
    Arrays.fill(this.e, 0);
    int j = this.d;
    int k = 0;
    int m;
    int n;
    c localc;
    if (k < j)
    {
      long l = this.c[k];
      m = (int)(0xFFFFFFFF & l);
      n = (int)(l >> 32);
      if (i + m > paramInt)
      {
        int i2 = this.e[n] + (paramInt - i);
        localc = this.a[n].a(i2);
      }
    }
    Object localObject;
    do
    {
      return localc;
      int i1 = i + m;
      int[] arrayOfInt = this.e;
      arrayOfInt[n] = (m + arrayOfInt[n]);
      k++;
      i = i1;
      break;
      do
      {
        if (((c)localObject).a())
          this.b.add(localObject);
        i++;
        localObject = c();
        if (localObject == null)
          return null;
      }
      while (i != paramInt);
      localc = ((c)localObject).c;
    }
    while (!((c)localObject).a());
    this.b.add(localObject);
    return localc;
  }

  public c a(Uri paramUri)
  {
    d[] arrayOfd = this.a;
    int i = arrayOfd.length;
    for (int j = 0; j < i; j++)
    {
      c localc = arrayOfd[j].a(paramUri);
      if (localc != null)
        return localc;
    }
    return null;
  }

  public void a()
  {
    int i = 0;
    int j = this.a.length;
    while (i < j)
    {
      this.a[i].a();
      i++;
    }
  }

  public int b()
  {
    int i = 0;
    d[] arrayOfd = this.a;
    int j = arrayOfd.length;
    int k = 0;
    while (i < j)
    {
      k += arrayOfd[i].b();
      i++;
    }
    return k;
  }

  private static class a
    implements Comparator<g.c>
  {
    public int a(g.c paramc1, g.c paramc2)
    {
      if (paramc1.b != paramc2.b)
      {
        if (paramc1.b < paramc2.b)
          return -1;
        return 1;
      }
      return paramc1.a - paramc2.a;
    }
  }

  private static class b
    implements Comparator<g.c>
  {
    public int a(g.c paramc1, g.c paramc2)
    {
      if (paramc1.b != paramc2.b)
      {
        if (paramc1.b < paramc2.b)
          return 1;
        return -1;
      }
      return paramc1.a - paramc2.a;
    }
  }

  private static class c
  {
    int a;
    long b;
    c c;
    private int d = -1;
    private final d e;

    public c(d paramd, int paramInt)
    {
      this.e = paramd;
      this.a = paramInt;
    }

    public boolean a()
    {
      if (this.d >= -1 + this.e.b())
        return false;
      d locald = this.e;
      int i = 1 + this.d;
      this.d = i;
      this.c = locald.a(i);
      this.b = this.c.a();
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a.g
 * JD-Core Version:    0.6.2
 */