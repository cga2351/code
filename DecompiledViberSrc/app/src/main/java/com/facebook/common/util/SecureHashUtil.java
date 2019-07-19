package com.facebook.common.util;

import android.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureHashUtil
{
  private static final int BUFFER_SIZE = 4096;
  static final byte[] HEX_CHAR_TABLE = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };

  public static String convertToHex(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      int k = 0xFF & paramArrayOfByte[j];
      localStringBuilder.append((char)HEX_CHAR_TABLE[(k >>> 4)]);
      localStringBuilder.append((char)HEX_CHAR_TABLE[(k & 0xF)]);
    }
    return localStringBuilder.toString();
  }

  private static String makeHash(InputStream paramInputStream, String paramString)
    throws IOException
  {
    try
    {
      localMessageDigest = MessageDigest.getInstance(paramString);
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0)
          break;
        localMessageDigest.update(arrayOfByte, 0, i);
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      MessageDigest localMessageDigest;
      throw new RuntimeException(localNoSuchAlgorithmException);
      String str = convertToHex(localMessageDigest.digest());
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  private static String makeHash(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      String str = convertToHex(localMessageDigest.digest());
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public static String makeMD5Hash(InputStream paramInputStream)
    throws IOException
  {
    return makeHash(paramInputStream, "MD5");
  }

  public static String makeMD5Hash(String paramString)
  {
    try
    {
      String str = makeMD5Hash(paramString.getBytes("utf-8"));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public static String makeMD5Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "MD5");
  }

  public static String makeSHA1Hash(String paramString)
  {
    try
    {
      String str = makeSHA1Hash(paramString.getBytes("utf-8"));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public static String makeSHA1Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "SHA-1");
  }

  public static String makeSHA1HashBase64(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      String str = Base64.encodeToString(localMessageDigest.digest(), 11);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }

  public static String makeSHA256Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "SHA-256");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.SecureHashUtil
 * JD-Core Version:    0.6.2
 */