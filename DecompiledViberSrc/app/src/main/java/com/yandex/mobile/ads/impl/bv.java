package com.yandex.mobile.ads.impl;

public final class bv
  implements bs<String>
{
  private static String a(oh paramoh)
  {
    byte[] arrayOfByte = paramoh.b;
    String str = null;
    if (arrayOfByte != null);
    try
    {
      str = new String(paramoh.b, oz.a(paramoh.c));
      return str;
    }
    catch (Exception localException)
    {
    }
    return new String(paramoh.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bv
 * JD-Core Version:    0.6.2
 */