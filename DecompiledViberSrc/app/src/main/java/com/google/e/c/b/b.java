package com.google.e.c.b;

final class b
{
  private final a a;
  private final int[] b;

  b(a parama, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0)
      throw new IllegalArgumentException();
    this.a = parama;
    int i = paramArrayOfInt.length;
    if ((i > 1) && (paramArrayOfInt[0] == 0))
    {
      for (int j = 1; (j < i) && (paramArrayOfInt[j] == 0); j++);
      if (j == i)
      {
        this.b = new int[] { 0 };
        return;
      }
      this.b = new int[i - j];
      System.arraycopy(paramArrayOfInt, j, this.b, 0, this.b.length);
      return;
    }
    this.b = paramArrayOfInt;
  }

  int a(int paramInt)
  {
    return this.b[(-1 + this.b.length - paramInt)];
  }

  b a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException();
    if (paramInt2 == 0)
      return this.a.a();
    int i = this.b.length;
    int[] arrayOfInt = new int[i + paramInt1];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = this.a.c(this.b[j], paramInt2);
    return new b(this.a, arrayOfInt);
  }

  b a(b paramb)
  {
    if (!this.a.equals(paramb.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if (c())
      return paramb;
    if (paramb.c())
      return this;
    Object localObject1 = this.b;
    Object localObject2 = paramb.b;
    if (localObject1.length > localObject2.length);
    while (true)
    {
      int[] arrayOfInt = new int[localObject1.length];
      int i = localObject1.length - localObject2.length;
      System.arraycopy(localObject1, 0, arrayOfInt, 0, i);
      for (int j = i; j < localObject1.length; j++)
        arrayOfInt[j] = a.b(localObject2[(j - i)], localObject1[j]);
      return new b(this.a, arrayOfInt);
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }

  int[] a()
  {
    return this.b;
  }

  int b()
  {
    return -1 + this.b.length;
  }

  int b(int paramInt)
  {
    int i = 0;
    int k;
    if (paramInt == 0)
      k = a(0);
    while (true)
    {
      return k;
      int j = this.b.length;
      if (paramInt == 1)
      {
        int[] arrayOfInt = this.b;
        int i1 = arrayOfInt.length;
        int i2;
        for (k = 0; i < i1; k = i2)
        {
          i2 = a.b(k, arrayOfInt[i]);
          i++;
        }
      }
      else
      {
        k = this.b[0];
        int m = 1;
        while (m < j)
        {
          int n = a.b(this.a.c(paramInt, k), this.b[m]);
          m++;
          k = n;
        }
      }
    }
  }

  b b(b paramb)
  {
    if (!this.a.equals(paramb.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if ((c()) || (paramb.c()))
      return this.a.a();
    int[] arrayOfInt1 = this.b;
    int i = arrayOfInt1.length;
    int[] arrayOfInt2 = paramb.b;
    int j = arrayOfInt2.length;
    int[] arrayOfInt3 = new int[-1 + (i + j)];
    for (int k = 0; k < i; k++)
    {
      int m = arrayOfInt1[k];
      for (int n = 0; n < j; n++)
        arrayOfInt3[(k + n)] = a.b(arrayOfInt3[(k + n)], this.a.c(m, arrayOfInt2[n]));
    }
    return new b(this.a, arrayOfInt3);
  }

  b c(int paramInt)
  {
    if (paramInt == 0)
      this = this.a.a();
    while (paramInt == 1)
      return this;
    int i = this.b.length;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = this.a.c(this.b[j], paramInt);
    return new b(this.a, arrayOfInt);
  }

  boolean c()
  {
    int i = this.b[0];
    boolean bool = false;
    if (i == 0)
      bool = true;
    return bool;
  }

  b[] c(b paramb)
  {
    if (!this.a.equals(paramb.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if (paramb.c())
      throw new IllegalArgumentException("Divide by 0");
    b localb1 = this.a.a();
    int i = paramb.a(paramb.b());
    int j = this.a.c(i);
    b localb2 = localb1;
    b localb4;
    for (b localb3 = this; (localb3.b() >= paramb.b()) && (!localb3.c()); localb3 = localb3.a(localb4))
    {
      int k = localb3.b() - paramb.b();
      int m = this.a.c(localb3.a(localb3.b()), j);
      localb4 = paramb.a(k, m);
      localb2 = localb2.a(this.a.a(k, m));
    }
    return new b[] { localb2, localb3 };
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(8 * b());
    int i = b();
    if (i >= 0)
    {
      int j = a(i);
      label48: int k;
      if (j != 0)
      {
        if (j >= 0)
          break label101;
        localStringBuilder.append(" - ");
        j = -j;
        if ((i == 0) || (j != 1))
        {
          k = this.a.b(j);
          if (k != 0)
            break label118;
          localStringBuilder.append('1');
        }
        label79: if (i != 0)
        {
          if (i != 1)
            break label151;
          localStringBuilder.append('x');
        }
      }
      while (true)
      {
        i--;
        break;
        label101: if (localStringBuilder.length() <= 0)
          break label48;
        localStringBuilder.append(" + ");
        break label48;
        label118: if (k == 1)
        {
          localStringBuilder.append('a');
          break label79;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(k);
        break label79;
        label151: localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.b.b
 * JD-Core Version:    0.6.2
 */