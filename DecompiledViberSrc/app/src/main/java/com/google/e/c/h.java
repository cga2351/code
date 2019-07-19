package com.google.e.c;

import com.google.e.j;

public class h extends com.google.e.b
{
  private static final byte[] a = new byte[0];
  private byte[] b = a;
  private final int[] c = new int[32];

  public h(com.google.e.h paramh)
  {
    super(paramh);
  }

  private static int a(int[] paramArrayOfInt)
    throws j
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (k < j)
    {
      if (paramArrayOfInt[k] > m)
      {
        m = paramArrayOfInt[k];
        n = k;
      }
      if (paramArrayOfInt[k] > i1)
        i1 = paramArrayOfInt[k];
      k++;
    }
    int i2 = 0;
    int i3 = 0;
    int i12;
    if (i < j)
    {
      int i11 = i - n;
      i12 = i11 * (i11 * paramArrayOfInt[i]);
      if (i12 <= i2)
        break label237;
    }
    for (int i13 = i; ; i13 = i3)
    {
      i++;
      i3 = i13;
      i2 = i12;
      break;
      if (n > i3);
      while (true)
      {
        if (n - i3 <= j / 16)
          throw j.a();
        int i5 = n - 1;
        int i6 = -1;
        int i7 = n - 1;
        int i9;
        if (i7 > i3)
        {
          int i8 = i7 - i3;
          i9 = i8 * i8 * (n - i7) * (i1 - paramArrayOfInt[i7]);
          if (i9 <= i6)
            break label211;
        }
        for (int i10 = i7; ; i10 = i5)
        {
          i7--;
          i5 = i10;
          i6 = i9;
          break;
          return i5 << 3;
          label211: i9 = i6;
        }
        int i4 = i3;
        i3 = n;
        n = i4;
      }
      label237: i12 = i2;
    }
  }

  private void a(int paramInt)
  {
    if (this.b.length < paramInt)
      this.b = new byte[paramInt];
    for (int i = 0; i < 32; i++)
      this.c[i] = 0;
  }

  public com.google.e.b a(com.google.e.h paramh)
  {
    return new h(paramh);
  }

  public a a(int paramInt, a parama)
    throws j
  {
    int i = 1;
    com.google.e.h localh = a();
    int j = localh.b();
    if ((parama == null) || (parama.a() < j))
      parama = new a(j);
    byte[] arrayOfByte;
    int[] arrayOfInt;
    while (true)
    {
      a(j);
      arrayOfByte = localh.a(paramInt, this.b);
      arrayOfInt = this.c;
      for (int k = 0; k < j; k++)
      {
        int i4 = (0xFF & arrayOfByte[k]) >> 3;
        arrayOfInt[i4] = (1 + arrayOfInt[i4]);
      }
      parama.c();
    }
    int m = a(arrayOfInt);
    int n = 0xFF & arrayOfByte[0];
    int i1 = 0xFF & arrayOfByte[i];
    int i2 = n;
    while (i < j - 1)
    {
      int i3 = 0xFF & arrayOfByte[(i + 1)];
      if ((i1 * 4 - i2 - i3) / 2 < m)
        parama.b(i);
      i++;
      i2 = i1;
      i1 = i3;
    }
    return parama;
  }

  public b b()
    throws j
  {
    com.google.e.h localh = a();
    int i = localh.b();
    int j = localh.c();
    b localb = new b(i, j);
    a(i);
    int[] arrayOfInt = this.c;
    for (int k = 1; k < 5; k++)
    {
      byte[] arrayOfByte2 = localh.a(j * k / 5, this.b);
      int i3 = i * 4 / 5;
      for (int i4 = i / 5; i4 < i3; i4++)
      {
        int i5 = (0xFF & arrayOfByte2[i4]) >> 3;
        arrayOfInt[i5] = (1 + arrayOfInt[i5]);
      }
    }
    int m = a(arrayOfInt);
    byte[] arrayOfByte1 = localh.a();
    for (int n = 0; n < j; n++)
    {
      int i1 = n * i;
      for (int i2 = 0; i2 < i; i2++)
        if ((0xFF & arrayOfByte1[(i1 + i2)]) < m)
          localb.b(i2, n);
    }
    return localb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.h
 * JD-Core Version:    0.6.2
 */