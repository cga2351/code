package com.google.e.d.a;

final class b
{
  private final int a;
  private final byte[] b;

  private b(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }

  static b[] a(byte[] paramArrayOfByte, e parame)
  {
    e.b localb = parame.g();
    e.a[] arrayOfa = localb.b();
    int i = arrayOfa.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfa[j].a();
      j++;
    }
    b[] arrayOfb = new b[k];
    int m = arrayOfa.length;
    int n = 0;
    int i20;
    for (int i1 = 0; n < m; i1 = i20)
    {
      e.a locala = arrayOfa[n];
      i20 = i1;
      int i21 = 0;
      while (i21 < locala.a())
      {
        int i22 = locala.b();
        int i23 = i22 + localb.a();
        int i24 = i20 + 1;
        arrayOfb[i20] = new b(i22, new byte[i23]);
        i21++;
        i20 = i24;
      }
      n++;
    }
    int i2 = arrayOfb[0].b.length - localb.a();
    int i3 = i2 - 1;
    int i4 = 0;
    int i5 = 0;
    while (i4 < i3)
    {
      int i18 = 0;
      while (i18 < i1)
      {
        byte[] arrayOfByte3 = arrayOfb[i18].b;
        int i19 = i5 + 1;
        arrayOfByte3[i4] = paramArrayOfByte[i5];
        i18++;
        i5 = i19;
      }
      i4++;
    }
    int i6;
    if (parame.a() == 24)
    {
      i6 = 1;
      if (i6 == 0)
        break label315;
    }
    label315: for (int i7 = 8; ; i7 = i1)
    {
      int i8 = 0;
      while (i8 < i7)
      {
        byte[] arrayOfByte2 = arrayOfb[i8].b;
        int i16 = i2 - 1;
        int i17 = i5 + 1;
        arrayOfByte2[i16] = paramArrayOfByte[i5];
        i8++;
        i5 = i17;
      }
      i6 = 0;
      break;
    }
    int i9 = arrayOfb[0].b.length;
    int i12;
    for (int i10 = i5; i2 < i9; i10 = i12)
    {
      int i11 = 0;
      i12 = i10;
      if (i11 < i1)
      {
        int i13;
        if (i6 != 0)
        {
          i13 = (i11 + 8) % i1;
          label372: if ((i6 == 0) || (i13 <= 7))
            break label432;
        }
        label432: for (int i14 = i2 - 1; ; i14 = i2)
        {
          byte[] arrayOfByte1 = arrayOfb[i13].b;
          int i15 = i12 + 1;
          arrayOfByte1[i14] = paramArrayOfByte[i12];
          i11++;
          i12 = i15;
          break;
          i13 = i11;
          break label372;
        }
      }
      i2++;
    }
    if (i10 != paramArrayOfByte.length)
      throw new IllegalArgumentException();
    return arrayOfb;
  }

  int a()
  {
    return this.a;
  }

  byte[] b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.d.a.b
 * JD-Core Version:    0.6.2
 */