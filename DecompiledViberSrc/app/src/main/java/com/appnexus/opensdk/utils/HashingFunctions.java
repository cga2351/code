package com.appnexus.opensdk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingFunctions
{
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length;
    int j = 0;
    int k;
    int m;
    int n;
    if (j < i)
    {
      k = paramArrayOfByte[j];
      m = 0xF & k >>> 4;
      n = 0;
    }
    while (true)
    {
      if ((m >= 0) && (m <= 9));
      int i1;
      int i2;
      for (char c = (char)(m + 48); ; c = (char)(97 + (m - 10)))
      {
        localStringBuilder.append(c);
        i1 = k & 0xF;
        i2 = n + 1;
        if (n < 1)
          break label106;
        j++;
        break;
      }
      return localStringBuilder.toString();
      label106: n = i2;
      m = i1;
    }
  }

  public static String md5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      String str = a(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return "";
  }

  public static String sha1(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes());
      String str = a(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.HashingFunctions
 * JD-Core Version:    0.6.2
 */