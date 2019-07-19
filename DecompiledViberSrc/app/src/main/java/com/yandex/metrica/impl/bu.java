package com.yandex.metrica.impl;

import android.text.TextUtils;
import java.util.regex.Pattern;

public final class bu
{
  static
  {
    Pattern.compile("[^0-9a-zA-Z,`’\\.\\+\\-'\\s\"]");
    Pattern.compile("\\s+");
  }

  public static String a(String paramString)
  {
    if (paramString == null)
      paramString = "";
    return paramString;
  }

  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfByte[j];
      localStringBuilder.append("0123456789abcdef".charAt((k & 0xF0) >> 4));
      localStringBuilder.append("0123456789abcdef".charAt(k & 0xF));
    }
    return localStringBuilder.toString();
  }

  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null))
      return true;
    if ((paramString1 != null) && (paramString2 != null))
      return paramString1.equals(paramString2);
    return false;
  }

  public static boolean a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null);
    while (true)
    {
      return false;
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
        if (TextUtils.isEmpty(paramArrayOfString[j]))
          return true;
    }
  }

  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    char c;
    do
    {
      return paramString;
      c = paramString.charAt(0);
    }
    while (Character.isUpperCase(c));
    return Character.toUpperCase(c) + paramString.substring(1);
  }

  public static String b(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2;
    return paramString1;
  }

  public static final String b(String[] paramArrayOfString)
  {
    return TextUtils.join(",", paramArrayOfString);
  }

  public static String c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return paramString2;
    return paramString1;
  }

  public static byte[] c(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (Exception localException)
    {
    }
    return new byte[0];
  }

  public static byte[] d(String paramString)
  {
    if (paramString == null)
      return new byte[0];
    return paramString.getBytes();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bu
 * JD-Core Version:    0.6.2
 */