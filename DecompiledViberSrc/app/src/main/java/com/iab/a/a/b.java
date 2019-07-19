package com.iab.a.a;

import android.util.Base64;

public class b
{
  private static int a(com.iab.a.a parama)
  {
    return parama.a(0, 6);
  }

  public static a a(String paramString)
  {
    if (b(paramString))
      throw new IllegalArgumentException("Null or empty consent string passed as an argument");
    return a(Base64.decode(paramString, 8));
  }

  public static a a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      throw new IllegalArgumentException("Null or empty consent bytes passed as an argument");
    com.iab.a.a locala = new com.iab.a.a(paramArrayOfByte);
    int i = a(locala);
    switch (i)
    {
    default:
      throw new IllegalStateException("Unsupported version: " + i);
    case 1:
    }
    return new com.iab.a.a.a.a.a(locala);
  }

  private static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.a.a.b
 * JD-Core Version:    0.6.2
 */