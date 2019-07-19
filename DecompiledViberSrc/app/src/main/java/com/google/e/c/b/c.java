package com.google.e.c.b;

public final class c
{
  private final a a;

  public c(a parama)
  {
    this.a = parama;
  }

  private int[] a(b paramb)
    throws e
  {
    int i = 0;
    int j = 1;
    int k = paramb.b();
    if (k == j)
    {
      int[] arrayOfInt2 = new int[j];
      arrayOfInt2[0] = paramb.a(j);
      return arrayOfInt2;
    }
    int[] arrayOfInt1 = new int[k];
    while ((j < this.a.c()) && (i < k))
    {
      if (paramb.b(j) == 0)
      {
        arrayOfInt1[i] = this.a.c(j);
        i++;
      }
      j++;
    }
    if (i != k)
      throw new e("Error locator degree does not match number of roots");
    return arrayOfInt1;
  }

  private int[] a(b paramb, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i];
    int j = 0;
    int k;
    int m;
    int n;
    label36: int i2;
    int i3;
    if (j < i)
    {
      k = this.a.c(paramArrayOfInt[j]);
      m = 1;
      n = 0;
      if (n < i)
      {
        if (j == n)
          break label175;
        i2 = this.a.c(paramArrayOfInt[n], k);
        if ((i2 & 0x1) == 0)
          i3 = i2 | 0x1;
      }
    }
    label77: for (int i1 = this.a.c(m, i3); ; i1 = m)
    {
      n++;
      m = i1;
      break label36;
      i3 = i2 & 0xFFFFFFFE;
      break label77;
      arrayOfInt[j] = this.a.c(paramb.b(k), this.a.c(m));
      if (this.a.d() != 0)
        arrayOfInt[j] = this.a.c(arrayOfInt[j], k);
      j++;
      break;
      return arrayOfInt;
    }
  }

  private b[] a(b paramb1, b paramb2, int paramInt)
    throws e
  {
    if (paramb1.b() < paramb2.b());
    while (true)
    {
      Object localObject1 = this.a.a();
      Object localObject2 = this.a.b();
      while (paramb1.b() >= paramInt / 2)
      {
        if (paramb1.c())
          throw new e("r_{i-1} was zero");
        b localb2 = this.a.a();
        int k = paramb1.a(paramb1.b());
        int m = this.a.c(k);
        b localb3 = localb2;
        int n;
        int i1;
        for (b localb4 = paramb2; (localb4.b() >= paramb1.b()) && (!localb4.c()); localb4 = localb4.a(paramb1.a(n, i1)))
        {
          n = localb4.b() - paramb1.b();
          i1 = this.a.c(localb4.a(localb4.b()), m);
          localb3 = localb3.a(this.a.a(n, i1));
        }
        b localb5 = localb3.b((b)localObject2).a((b)localObject1);
        if (localb4.b() >= paramb1.b())
          throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
        paramb2 = paramb1;
        paramb1 = localb4;
        Object localObject3 = localObject2;
        localObject2 = localb5;
        localObject1 = localObject3;
      }
      int i = ((b)localObject2).a(0);
      if (i == 0)
        throw new e("sigmaTilde(0) was zero");
      int j = this.a.c(i);
      return new b[] { ((b)localObject2).c(j), paramb1.c(j) };
      b localb1 = paramb2;
      paramb2 = paramb1;
      paramb1 = localb1;
    }
  }

  public void a(int[] paramArrayOfInt, int paramInt)
    throws e
  {
    int i = 0;
    b localb1 = new b(this.a, paramArrayOfInt);
    int[] arrayOfInt1 = new int[paramInt];
    int j = 0;
    int k = 1;
    while (j < paramInt)
    {
      int n = localb1.b(this.a.a(j + this.a.d()));
      arrayOfInt1[(-1 + arrayOfInt1.length - j)] = n;
      if (n != 0)
        k = 0;
      j++;
    }
    if (k != 0);
    while (true)
    {
      return;
      b localb2 = new b(this.a, arrayOfInt1);
      b[] arrayOfb = a(this.a.a(paramInt, 1), localb2, paramInt);
      b localb3 = arrayOfb[0];
      b localb4 = arrayOfb[1];
      int[] arrayOfInt2 = a(localb3);
      int[] arrayOfInt3 = a(localb4, arrayOfInt2);
      while (i < arrayOfInt2.length)
      {
        int m = -1 + paramArrayOfInt.length - this.a.b(arrayOfInt2[i]);
        if (m < 0)
          throw new e("Bad error location");
        paramArrayOfInt[m] = a.b(paramArrayOfInt[m], arrayOfInt3[i]);
        i++;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.b.c
 * JD-Core Version:    0.6.2
 */