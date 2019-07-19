package com.yandex.metrica.impl.ob;

import java.io.IOException;

public final class g
{
  public static final int[] a = new int[0];
  public static final String[] b = new String[0];
  public static final byte[] c = new byte[0];

  static
  {
    new byte[0][];
  }

  static int a(int paramInt)
  {
    return paramInt & 0x7;
  }

  static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 | paramInt1 << 3;
  }

  public static boolean a(a parama, int paramInt)
    throws IOException
  {
    return parama.b(paramInt);
  }

  public static int b(int paramInt)
  {
    return paramInt >>> 3;
  }

  public static final int b(a parama, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = parama.s();
    parama.b(paramInt);
    while (parama.a() == paramInt)
    {
      parama.b(paramInt);
      i++;
    }
    parama.e(j);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.g
 * JD-Core Version:    0.6.2
 */