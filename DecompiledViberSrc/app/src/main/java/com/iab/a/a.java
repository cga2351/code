package com.iab.a;

import com.iab.a.b.b;
import com.iab.a.b.c;
import com.iab.a.b.d;

public class a
{
  private static final byte[] a = { -128, 64, 32, 16, 8, 4, 2, 1 };
  private final byte[] b;

  public a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }

  private void c(int paramInt1, int paramInt2, long paramLong)
  {
    for (int i = paramInt2 - 1; i >= 0; i--)
    {
      int j = paramInt1 + i;
      int k = j / 8;
      int m = -1 + (8 * (k + 1) - j);
      byte[] arrayOfByte = this.b;
      arrayOfByte[k] = ((byte)(int)(arrayOfByte[k] | paramLong % 2L << m));
      paramLong /= 2L;
    }
  }

  private long d(int paramInt)
  {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
      l = ()(l + Math.pow(2.0D, i));
    return l;
  }

  public int a(int paramInt1, int paramInt2)
    throws c
  {
    int i = 0;
    if (paramInt2 > 32)
      throw new d("can't fit bit range in int " + paramInt2);
    int j = paramInt2 - 1;
    for (int k = 0; k < paramInt2; k++)
    {
      if (a(paramInt1 + k))
        i += (1 << j);
      j--;
    }
    return i;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
    throws c
  {
    if ((paramInt2 > 32) || (paramInt3 > d(paramInt2)) || (paramInt3 < 0))
      throw new b("can't fit integer into bit range of size" + paramInt2);
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(int paramInt1, int paramInt2, long paramLong)
    throws c
  {
    if ((paramInt2 > 64) || (paramLong > d(paramInt2)) || (paramLong < 0L))
      throw new b("can't fit long into bit range of size " + paramInt2);
    c(paramInt1, paramInt2, paramLong);
  }

  public void a(int paramInt1, int paramInt2, String paramString)
    throws c
  {
    if ((paramInt2 % 6 != 0) || (paramInt2 / 6 != paramString.length()))
      throw new b("bit array size must be multiple of six and equal to 6 times the size of string");
    char[] arrayOfChar = paramString.toCharArray();
    for (int i = 0; i < arrayOfChar.length; i++)
    {
      int j = '﾿' + arrayOfChar[i];
      a(paramInt1 + i * 6, 6, j);
    }
  }

  public boolean a(int paramInt)
  {
    int i = paramInt / 8;
    int j = paramInt % 8;
    return (this.b[i] & a[j]) != 0;
  }

  public byte[] a()
  {
    return this.b;
  }

  public long b(int paramInt1, int paramInt2)
    throws c
  {
    if (paramInt2 > 64)
      throw new d("can't fit bit range in long: " + paramInt2);
    int i = paramInt2 - 1;
    long l = 0L;
    int j = 0;
    int k = i;
    while (j < paramInt2)
    {
      if (a(paramInt1 + j))
        l += (1L << k);
      k--;
      j++;
    }
    return l;
  }

  public void b(int paramInt)
  {
    int i = paramInt / 8;
    int j = -1 + (8 * (i + 1) - paramInt);
    byte[] arrayOfByte = this.b;
    arrayOfByte[i] = ((byte)(arrayOfByte[i] | 1 << j));
  }

  public void b(int paramInt1, int paramInt2, long paramLong)
    throws c
  {
    a(paramInt1, paramInt2, paramLong / 100L);
  }

  public long c(int paramInt1, int paramInt2)
    throws c
  {
    return 100L * b(paramInt1, paramInt2);
  }

  public void c(int paramInt)
  {
    int i = paramInt / 8;
    int j = -1 + (8 * (i + 1) - paramInt);
    byte[] arrayOfByte = this.b;
    arrayOfByte[i] = ((byte)(arrayOfByte[i] & (0xFFFFFFFF ^ 1 << j)));
  }

  public String d(int paramInt1, int paramInt2)
    throws c
  {
    if (paramInt2 % 6 != 0)
      throw new d("string bit length must be multiple of six: " + paramInt2);
    int i = paramInt2 / 6;
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; j < i; j++)
      localStringBuilder.append((char)(65 + a(paramInt1 + j * 6, 6)));
    return localStringBuilder.toString().toUpperCase();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.a.a
 * JD-Core Version:    0.6.2
 */