package com.viber.voip.util;

import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class z
{
  private static final Logger a = ViberEnv.getLogger();
  private static final char[] b = "0123456789abcdef".toCharArray();

  public static String a(String paramString)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
    localMessageDigest.reset();
    localMessageDigest.update(paramString.getBytes());
    return a(localMessageDigest.digest());
  }

  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfByte.length; i++)
      localStringBuilder.append(Integer.toString(256 + (0xFF & paramArrayOfByte[i]), 16).substring(1));
    return localStringBuilder.toString();
  }

  public static byte[] a(String paramString1, String paramString2)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes("UTF-8"), "HmacSHA256");
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(localSecretKeySpec);
      byte[] arrayOfByte = localMac.doFinal(paramString1.getBytes("UTF-8"));
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException("Could not find the SHA256 algorithm. HMac conversion failed.", localNoSuchAlgorithmException);
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new RuntimeException("Invalid key exception detected. HMac conversion failed.", localInvalidKeyException);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new RuntimeException("IIllegal state exception detected. HMac conversion failed.", localIllegalStateException);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("Unsuported encoding UTF-8. HMac conversion failed.", localUnsupportedEncodingException);
    }
  }

  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, localSecretKeySpec);
    return localCipher.doFinal(paramArrayOfByte2);
  }

  public static String b(String paramString1, String paramString2)
    throws Exception
  {
    return b(a(c(paramString1), paramString2.getBytes()));
  }

  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return "";
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = 0xFF & paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = b[(j >>> 4)];
      arrayOfChar[(1 + i * 2)] = b[(j & 0xF)];
    }
    return new String(arrayOfChar);
  }

  public static byte[] b(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    byte[] arrayOfByte;
    if (j % 2 == 1)
      arrayOfByte = new byte[0];
    while (true)
    {
      return arrayOfByte;
      arrayOfByte = new byte[j / 2];
      while (i < j)
      {
        arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
        i += 2;
      }
    }
  }

  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, localSecretKeySpec);
    return localCipher.doFinal(paramArrayOfByte2);
  }

  public static String c(String paramString1, String paramString2)
    throws Exception
  {
    byte[] arrayOfByte1 = b(paramString2);
    try
    {
      byte[] arrayOfByte3 = b(c(paramString1), arrayOfByte1);
      arrayOfByte2 = arrayOfByte3;
      return new String(arrayOfByte2);
    }
    catch (Exception localException)
    {
      while (true)
      {
        byte[] arrayOfByte2;
        a.a(localException, "can't decrypt keychain using new API");
        if (!a.k())
          arrayOfByte2 = b(c(paramString1.getBytes()), arrayOfByte1);
        else
          arrayOfByte2 = new byte[0];
      }
    }
  }

  private static byte[] c(String paramString)
    throws Exception
  {
    byte[] arrayOfByte = bu.a(paramString).getBytes();
    PBEKeySpec localPBEKeySpec = new PBEKeySpec(paramString.toCharArray(), arrayOfByte, 1000, 256);
    return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(localPBEKeySpec).getEncoded();
  }

  @Deprecated
  private static byte[] c(byte[] paramArrayOfByte)
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    try
    {
      SecureRandom localSecureRandom2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
      localSecureRandom1 = localSecureRandom2;
      localSecureRandom1.setSeed(paramArrayOfByte);
      localKeyGenerator.init(128, localSecureRandom1);
      return localKeyGenerator.generateKey().getEncoded();
    }
    catch (NoSuchProviderException localNoSuchProviderException)
    {
      while (true)
        SecureRandom localSecureRandom1 = SecureRandom.getInstance("SHA1PRNG");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.z
 * JD-Core Version:    0.6.2
 */