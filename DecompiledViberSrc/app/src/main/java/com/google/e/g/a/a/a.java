package com.google.e.g.a.a;

import com.google.e.d;

public final class a
{
  private final b a = b.a;

  private int[] a(c paramc)
    throws d
  {
    int i = paramc.a();
    int[] arrayOfInt = new int[i];
    int j = 0;
    for (int k = 1; (k < this.a.c()) && (j < i); k++)
      if (paramc.b(k) == 0)
      {
        arrayOfInt[j] = this.a.c(k);
        j++;
      }
    if (j != i)
      throw d.a();
    return arrayOfInt;
  }

  private int[] a(c paramc1, c paramc2, int[] paramArrayOfInt)
  {
    int i = paramc2.a();
    int[] arrayOfInt1 = new int[i];
    for (int j = 1; j <= i; j++)
      arrayOfInt1[(i - j)] = this.a.d(j, paramc2.a(j));
    c localc = new c(this.a, arrayOfInt1);
    int k = paramArrayOfInt.length;
    int[] arrayOfInt2 = new int[k];
    for (int m = 0; m < k; m++)
    {
      int n = this.a.c(paramArrayOfInt[m]);
      int i1 = this.a.c(0, paramc1.b(n));
      int i2 = this.a.c(localc.b(n));
      arrayOfInt2[m] = this.a.d(i1, i2);
    }
    return arrayOfInt2;
  }

  private c[] a(c paramc1, c paramc2, int paramInt)
    throws d
  {
    if (paramc1.a() < paramc2.a());
    while (true)
    {
      Object localObject1 = this.a.a();
      Object localObject2 = this.a.b();
      while (paramc1.a() >= paramInt / 2)
      {
        if (paramc1.b())
          throw d.a();
        c localc2 = this.a.a();
        int k = paramc1.a(paramc1.a());
        int m = this.a.c(k);
        c localc3 = localc2;
        int n;
        int i1;
        for (c localc4 = paramc2; (localc4.a() >= paramc1.a()) && (!localc4.b()); localc4 = localc4.b(paramc1.a(n, i1)))
        {
          n = localc4.a() - paramc1.a();
          i1 = this.a.d(localc4.a(localc4.a()), m);
          localc3 = localc3.a(this.a.a(n, i1));
        }
        c localc5 = localc3.c((c)localObject2).b((c)localObject1).c();
        paramc2 = paramc1;
        paramc1 = localc4;
        Object localObject3 = localObject2;
        localObject2 = localc5;
        localObject1 = localObject3;
      }
      int i = ((c)localObject2).a(0);
      if (i == 0)
        throw d.a();
      int j = this.a.c(i);
      return new c[] { ((c)localObject2).c(j), paramc1.c(j) };
      c localc1 = paramc2;
      paramc2 = paramc1;
      paramc1 = localc1;
    }
  }

  public int a(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
    throws d
  {
    c localc1 = new c(this.a, paramArrayOfInt1);
    int[] arrayOfInt1 = new int[paramInt];
    int i = paramInt;
    int j = 0;
    while (i > 0)
    {
      int i4 = localc1.b(this.a.a(i));
      arrayOfInt1[(paramInt - i)] = i4;
      if (i4 != 0)
        j = 1;
      i--;
    }
    if (j == 0)
      return 0;
    c localc2 = this.a.b();
    if (paramArrayOfInt2 != null)
    {
      int n = paramArrayOfInt2.length;
      c localc6 = localc2;
      for (int i1 = 0; i1 < n; i1++)
      {
        int i2 = paramArrayOfInt2[i1];
        int i3 = this.a.a(-1 + paramArrayOfInt1.length - i2);
        b localb = this.a;
        int[] arrayOfInt4 = new int[2];
        arrayOfInt4[0] = this.a.c(0, i3);
        arrayOfInt4[1] = 1;
        localc6 = localc6.c(new c(localb, arrayOfInt4));
      }
    }
    c localc3 = new c(this.a, arrayOfInt1);
    c[] arrayOfc = a(this.a.a(paramInt, 1), localc3, paramInt);
    c localc4 = arrayOfc[0];
    c localc5 = arrayOfc[1];
    int[] arrayOfInt2 = a(localc4);
    int[] arrayOfInt3 = a(localc5, localc4, arrayOfInt2);
    for (int k = 0; k < arrayOfInt2.length; k++)
    {
      int m = -1 + paramArrayOfInt1.length - this.a.b(arrayOfInt2[k]);
      if (m < 0)
        throw d.a();
      paramArrayOfInt1[m] = this.a.c(paramArrayOfInt1[m], arrayOfInt3[k]);
    }
    return arrayOfInt2.length;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.a.a
 * JD-Core Version:    0.6.2
 */