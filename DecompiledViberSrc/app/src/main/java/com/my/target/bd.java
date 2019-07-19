package com.my.target;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Locale;

public class bd
{
  public static String a(String paramString)
  {
    int i = 0;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("md5");
      localMessageDigest.update(paramString.getBytes(Charset.forName("UTF-8")));
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < arrayOfByte.length)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(arrayOfByte[i]);
        localStringBuilder.append(String.format("%02X", arrayOfObject));
        i++;
      }
      String str = localStringBuilder.toString().toLowerCase(Locale.ROOT);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bd
 * JD-Core Version:    0.6.2
 */