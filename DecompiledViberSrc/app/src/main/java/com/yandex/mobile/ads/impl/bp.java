package com.yandex.mobile.ads.impl;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

public final class bp
{
  public static String a(String paramString)
  {
    return b(paramString.getBytes());
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      String str = c(paramArrayOfByte);
      return str;
    }
    catch (Exception localException)
    {
    }
    return new String(paramArrayOfByte);
  }

  private static String b(byte[] paramArrayOfByte)
  {
    try
    {
      String str = c(paramArrayOfByte);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String c(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    return new String(Base64.decode(paramArrayOfByte, 0), "UTF-8");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bp
 * JD-Core Version:    0.6.2
 */