package com.google.e.c;

import java.util.Arrays;

public final class b
  implements Cloneable
{
  private final int a;
  private final int b;
  private final int c;
  private final int[] d;

  public b(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1))
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = ((paramInt1 + 31) / 32);
    this.d = new int[paramInt2 * this.c];
  }

  private b(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramArrayOfInt;
  }

  public a a(int paramInt, a parama)
  {
    if ((parama == null) || (parama.a() < this.a))
      parama = new a(this.a);
    while (true)
    {
      int i = paramInt * this.c;
      for (int j = 0; j < this.c; j++)
        parama.a(j * 32, this.d[(i + j)]);
      parama.c();
    }
    return parama;
  }

  public String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "\n");
  }

  @Deprecated
  public String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * (1 + this.a));
    for (int i = 0; i < this.b; i++)
    {
      int j = 0;
      if (j < this.a)
      {
        if (a(j, i));
        for (String str = paramString1; ; str = paramString2)
        {
          localStringBuilder.append(str);
          j++;
          break;
        }
      }
      localStringBuilder.append(paramString3);
    }
    return localStringBuilder.toString();
  }

  public void a()
  {
    int i = e();
    int j = f();
    a locala1 = new a(i);
    a locala2 = new a(i);
    for (int k = 0; k < (j + 1) / 2; k++)
    {
      locala1 = a(k, locala1);
      locala2 = a(j - 1 - k, locala2);
      locala1.e();
      locala2.e();
      b(k, locala2);
      b(j - 1 - k, locala1);
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0))
      throw new IllegalArgumentException("Left and top must be nonnegative");
    if ((paramInt4 < 1) || (paramInt3 < 1))
      throw new IllegalArgumentException("Height and width must be at least 1");
    int i = paramInt1 + paramInt3;
    int j = paramInt2 + paramInt4;
    if ((j > this.b) || (i > this.a))
      throw new IllegalArgumentException("The region must fit inside the matrix");
    while (true)
    {
      paramInt2++;
      if (paramInt2 >= j)
        break;
      int k = paramInt2 * this.c;
      for (int m = paramInt1; m < i; m++)
      {
        int[] arrayOfInt = this.d;
        int n = k + m / 32;
        arrayOfInt[n] |= 1 << (m & 0x1F);
      }
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + paramInt1 / 32;
    return (0x1 & this.d[i] >>> (paramInt1 & 0x1F)) != 0;
  }

  public void b(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + paramInt1 / 32;
    int[] arrayOfInt = this.d;
    arrayOfInt[i] |= 1 << (paramInt1 & 0x1F);
  }

  public void b(int paramInt, a parama)
  {
    System.arraycopy(parama.d(), 0, this.d, paramInt * this.c, this.c);
  }

  public int[] b()
  {
    int i = this.a;
    int j = this.b;
    int k = i;
    int m = -1;
    int n = -1;
    int i1 = 0;
    int i4;
    label33: int i6;
    label135: int i7;
    int i8;
    int i9;
    if (i1 < this.b)
    {
      i4 = 0;
      if (i4 < this.c)
      {
        int i5 = this.d[(i4 + i1 * this.c)];
        if (i5 == 0)
          break label292;
        if (i1 < j)
          j = i1;
        if (i1 > n)
          n = i1;
        if (i4 * 32 >= k)
          break label286;
        for (int i12 = 0; i5 << 31 - i12 == 0; i12++);
        if (i12 + i4 * 32 >= k)
          break label286;
        i6 = i12 + i4 * 32;
        if (31 + i4 * 32 <= m)
          break label272;
        for (int i10 = 31; i5 >>> i10 == 0; i10--);
        if (i10 + i4 * 32 <= m)
          break label272;
        int i11 = i10 + i4 * 32;
        i7 = j;
        i8 = i11;
        i9 = n;
      }
    }
    while (true)
    {
      i4++;
      n = i9;
      m = i8;
      j = i7;
      k = i6;
      break label33;
      i1++;
      break;
      int i2 = m - k;
      int i3 = n - j;
      if ((i2 < 0) || (i3 < 0))
        return null;
      return new int[] { k, j, i2, i3 };
      label272: i7 = j;
      i8 = m;
      i9 = n;
      continue;
      label286: i6 = k;
      break label135;
      label292: i6 = k;
      i7 = j;
      i8 = m;
      i9 = n;
    }
  }

  public void c(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + paramInt1 / 32;
    int[] arrayOfInt = this.d;
    arrayOfInt[i] ^= 1 << (paramInt1 & 0x1F);
  }

  public int[] c()
  {
    for (int i = 0; (i < this.d.length) && (this.d[i] == 0); i++);
    if (i == this.d.length)
      return null;
    int j = i / this.c;
    int k = 32 * (i % this.c);
    int m = this.d[i];
    for (int n = 0; m << 31 - n == 0; n++);
    return new int[] { k + n, j };
  }

  public int[] d()
  {
    for (int i = -1 + this.d.length; (i >= 0) && (this.d[i] == 0); i--);
    if (i < 0)
      return null;
    int j = i / this.c;
    int k = 32 * (i % this.c);
    int m = this.d[i];
    for (int n = 31; m >>> n == 0; n--);
    return new int[] { k + n, j };
  }

  public int e()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b));
    b localb;
    do
    {
      return false;
      localb = (b)paramObject;
    }
    while ((this.a != localb.a) || (this.b != localb.b) || (this.c != localb.c) || (!Arrays.equals(this.d, localb.d)));
    return true;
  }

  public int f()
  {
    return this.b;
  }

  public b g()
  {
    return new b(this.a, this.b, this.c, (int[])this.d.clone());
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 * this.a + this.a) + this.b) + this.c) + Arrays.hashCode(this.d);
  }

  public String toString()
  {
    return a("X ", "  ");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.b
 * JD-Core Version:    0.6.2
 */