package com.google.e.d.a;

import com.google.e.g;

public final class d
{
  private final com.google.e.c.b.c a = new com.google.e.c.b.c(com.google.e.c.b.a.f);

  private void a(byte[] paramArrayOfByte, int paramInt)
    throws com.google.e.d
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j];
    for (int k = 0; k < j; k++)
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    int m = paramArrayOfByte.length - paramInt;
    try
    {
      this.a.a(arrayOfInt, m);
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)arrayOfInt[i]);
        i++;
      }
    }
    catch (com.google.e.c.b.e locale)
    {
      throw com.google.e.d.a();
    }
  }

  public com.google.e.c.e a(com.google.e.c.b paramb)
    throws g, com.google.e.d
  {
    a locala = new a(paramb);
    e locale = locala.a();
    b[] arrayOfb = b.a(locala.b(), locale);
    int i = arrayOfb.length;
    int j = arrayOfb.length;
    int k = 0;
    int m = 0;
    while (k < j)
    {
      m += arrayOfb[k].a();
      k++;
    }
    byte[] arrayOfByte1 = new byte[m];
    for (int n = 0; n < i; n++)
    {
      b localb = arrayOfb[n];
      byte[] arrayOfByte2 = localb.b();
      int i1 = localb.a();
      a(arrayOfByte2, i1);
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfByte1[(n + i2 * i)] = arrayOfByte2[i2];
    }
    return c.a(arrayOfByte1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.d.a.d
 * JD-Core Version:    0.6.2
 */