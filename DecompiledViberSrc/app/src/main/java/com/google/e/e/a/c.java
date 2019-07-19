package com.google.e.e.a;

import com.google.e.d;
import com.google.e.g;
import java.util.Map;

public final class c
{
  private final com.google.e.c.b.c a = new com.google.e.c.b.c(com.google.e.c.b.a.h);

  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws d
  {
    int i = 0;
    int j = paramInt2 + paramInt3;
    if (paramInt4 == 0);
    int[] arrayOfInt;
    for (int k = 1; ; k = 2)
    {
      arrayOfInt = new int[j / k];
      for (int m = 0; m < j; m++)
        if ((paramInt4 == 0) || (m % 2 == paramInt4 - 1))
          arrayOfInt[(m / k)] = (0xFF & paramArrayOfByte[(m + paramInt1)]);
    }
    try
    {
      this.a.a(arrayOfInt, paramInt3 / k);
      while (i < paramInt2)
      {
        if ((paramInt4 == 0) || (i % 2 == paramInt4 - 1))
          paramArrayOfByte[(i + paramInt1)] = ((byte)arrayOfInt[(i / k)]);
        i++;
      }
    }
    catch (com.google.e.c.b.e locale)
    {
      throw d.a();
    }
  }

  public com.google.e.c.e a(com.google.e.c.b paramb, Map<com.google.e.e, ?> paramMap)
    throws g, d
  {
    byte[] arrayOfByte1 = new a(paramb).a();
    a(arrayOfByte1, 0, 10, 10, 0);
    int i = 0xF & arrayOfByte1[0];
    switch (i)
    {
    default:
      throw g.a();
    case 2:
    case 3:
    case 4:
      a(arrayOfByte1, 20, 84, 40, 1);
      a(arrayOfByte1, 20, 84, 40, 2);
    case 5:
    }
    for (byte[] arrayOfByte2 = new byte[94]; ; arrayOfByte2 = new byte[78])
    {
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 10);
      System.arraycopy(arrayOfByte1, 20, arrayOfByte2, 10, -10 + arrayOfByte2.length);
      return b.a(arrayOfByte2, i);
      a(arrayOfByte1, 20, 68, 56, 1);
      a(arrayOfByte1, 20, 68, 56, 2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.e.a.c
 * JD-Core Version:    0.6.2
 */