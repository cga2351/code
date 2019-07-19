package com.google.e.c;

import java.util.Arrays;

public final class a
  implements Cloneable
{
  private int[] a;
  private int b;

  public a()
  {
    this.b = 0;
    this.a = new int[1];
  }

  public a(int paramInt)
  {
    this.b = paramInt;
    this.a = f(paramInt);
  }

  a(int[] paramArrayOfInt, int paramInt)
  {
    this.a = paramArrayOfInt;
    this.b = paramInt;
  }

  private void e(int paramInt)
  {
    if (paramInt > 32 * this.a.length)
    {
      int[] arrayOfInt = f(paramInt);
      System.arraycopy(this.a, 0, arrayOfInt, 0, this.a.length);
      this.a = arrayOfInt;
    }
  }

  private static int[] f(int paramInt)
  {
    return new int[(paramInt + 31) / 32];
  }

  public int a()
  {
    return this.b;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a[(paramInt1 / 32)] = paramInt2;
  }

  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    int m;
    for (int j = paramInt1; i < paramInt3; j = m)
    {
      int k = 0;
      m = j;
      int n = 0;
      while (k < 8)
      {
        if (a(m))
          n |= 1 << 7 - k;
        m++;
        k++;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)n);
      i++;
    }
  }

  public void a(a parama)
  {
    int i = parama.b;
    e(i + this.b);
    for (int j = 0; j < i; j++)
      a(parama.a(j));
  }

  public void a(boolean paramBoolean)
  {
    e(1 + this.b);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.a;
      int i = this.b / 32;
      arrayOfInt[i] |= 1 << (0x1F & this.b);
    }
    this.b = (1 + this.b);
  }

  public boolean a(int paramInt)
  {
    return (this.a[(paramInt / 32)] & 1 << (paramInt & 0x1F)) != 0;
  }

  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException();
    if (paramInt2 == paramInt1)
      return true;
    int i = paramInt2 - 1;
    int j = paramInt1 / 32;
    int k = i / 32;
    label129: label162: label168: for (int m = j; m <= k; m++)
    {
      int n;
      int i1;
      label70: int i3;
      label85: int i5;
      if (m > j)
      {
        n = 0;
        if (m >= k)
          break label119;
        i1 = 31;
        if ((n != 0) || (i1 != 31))
          break label129;
        i3 = -1;
        i5 = i3 & this.a[m];
        if (!paramBoolean)
          break label162;
      }
      while (true)
      {
        if (i5 == i3)
          break label168;
        return false;
        n = paramInt1 & 0x1F;
        break;
        label119: i1 = i & 0x1F;
        break label70;
        int i2 = n;
        int i4;
        for (i3 = 0; i2 <= i1; i3 = i4)
        {
          i4 = i3 | 1 << i2;
          i2++;
        }
        break label85;
        i3 = 0;
      }
    }
    return true;
  }

  public int b()
  {
    return (7 + this.b) / 8;
  }

  public void b(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = paramInt / 32;
    arrayOfInt[i] |= 1 << (paramInt & 0x1F);
  }

  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32))
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    e(paramInt2 + this.b);
    if (paramInt2 > 0)
    {
      if ((0x1 & paramInt1 >> paramInt2 - 1) == 1);
      for (boolean bool = true; ; bool = false)
      {
        a(bool);
        paramInt2--;
        break;
      }
    }
  }

  public void b(a parama)
  {
    if (this.a.length != parama.a.length)
      throw new IllegalArgumentException("Sizes don't match");
    for (int i = 0; i < this.a.length; i++)
    {
      int[] arrayOfInt = this.a;
      arrayOfInt[i] ^= parama.a[i];
    }
  }

  public int c(int paramInt)
  {
    int k;
    if (paramInt >= this.b)
      k = this.b;
    do
    {
      return k;
      int i = paramInt / 32;
      for (int j = this.a[i] & (0xFFFFFFFF ^ -1 + (1 << (paramInt & 0x1F))); j == 0; j = this.a[i])
      {
        i++;
        if (i == this.a.length)
          return this.b;
      }
      k = i * 32 + Integer.numberOfTrailingZeros(j);
    }
    while (k <= this.b);
    return this.b;
  }

  public void c()
  {
    int i = this.a.length;
    for (int j = 0; j < i; j++)
      this.a[j] = 0;
  }

  public int d(int paramInt)
  {
    int k;
    if (paramInt >= this.b)
      k = this.b;
    do
    {
      return k;
      int i = paramInt / 32;
      for (int j = (0xFFFFFFFF ^ this.a[i]) & (0xFFFFFFFF ^ -1 + (1 << (paramInt & 0x1F))); j == 0; j = 0xFFFFFFFF ^ this.a[i])
      {
        i++;
        if (i == this.a.length)
          return this.b;
      }
      k = i * 32 + Integer.numberOfTrailingZeros(j);
    }
    while (k <= this.b);
    return this.b;
  }

  public int[] d()
  {
    return this.a;
  }

  public void e()
  {
    int i = 1;
    int[] arrayOfInt = new int[this.a.length];
    int j = (-1 + this.b) / 32;
    int k = j + 1;
    for (int m = 0; m < k; m++)
    {
      long l1 = this.a[m];
      long l2 = 0x55555555 & l1 >> i | (l1 & 0x55555555) << i;
      long l3 = 0x33333333 & l2 >> 2 | (l2 & 0x33333333) << 2;
      long l4 = 0xF0F0F0F & l3 >> 4 | (l3 & 0xF0F0F0F) << 4;
      long l5 = 0xFF00FF & l4 >> 8 | (l4 & 0xFF00FF) << 8;
      long l6 = 0xFFFF & l5 >> 16 | (l5 & 0xFFFF) << 16;
      arrayOfInt[(j - m)] = ((int)l6);
    }
    if (this.b != k * 32)
    {
      int n = k * 32 - this.b;
      int i1 = 0;
      int i2 = i;
      while (i1 < 31 - n)
      {
        i2 = 0x1 | i2 << 1;
        i1++;
      }
      int i3 = i2 & arrayOfInt[0] >> n;
      while (i < k)
      {
        int i4 = arrayOfInt[i];
        int i5 = i3 | i4 << 32 - n;
        arrayOfInt[(i - 1)] = i5;
        i3 = i2 & i4 >> n;
        i++;
      }
      arrayOfInt[(k - 1)] = i3;
    }
    this.a = arrayOfInt;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a));
    a locala;
    do
    {
      return false;
      locala = (a)paramObject;
    }
    while ((this.b != locala.b) || (!Arrays.equals(this.a, locala.a)));
    return true;
  }

  public a f()
  {
    return new a((int[])this.a.clone(), this.b);
  }

  public int hashCode()
  {
    return 31 * this.b + Arrays.hashCode(this.a);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b);
    int i = 0;
    if (i < this.b)
    {
      if ((i & 0x7) == 0)
        localStringBuilder.append(' ');
      if (a(i));
      for (char c = 'X'; ; c = '.')
      {
        localStringBuilder.append(c);
        i++;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.a
 * JD-Core Version:    0.6.2
 */