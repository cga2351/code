package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class ov
{
  private final String a;
  private final String b;

  public ov()
  {
    this("AES/CBC/PKCS5Padding", "RSA/ECB/PKCS1Padding");
  }

  ov(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  @SuppressLint({"TrulyRandom"})
  public byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      byte[] arrayOfByte1 = new byte[16];
      byte[] arrayOfByte2 = new byte[16];
      localSecureRandom.nextBytes(arrayOfByte2);
      localSecureRandom.nextBytes(arrayOfByte1);
      byte[] arrayOfByte3 = a(paramArrayOfByte, arrayOfByte2, arrayOfByte1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDhmH/m2qrRjxDHP794CeaZpENQNYydf8pqyXJilo6XxK+n+pvo27VxWfB3Z1yHrtKow+eZXKLQzrQ8wZMfRgADrYCQJ20y2hGZEUCN1tGSM+xqVKMeCtVi3NvQa54Cx7mT5ECVsH5DKEs/aeScDHP56FzcgEbtOSwyRZ8dsEM0wwIDAQAB", 0))));
      return arrayOfByte3;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return null;
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      label69: break label69;
    }
  }

  // ERROR //
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, java.security.PublicKey paramPublicKey)
  {
    // Byte code:
    //   0: new 68	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: aload_2
    //   5: arraylength
    //   6: aload_3
    //   7: arraylength
    //   8: iadd
    //   9: invokespecial 71	java/io/ByteArrayOutputStream:<init>	(I)V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_2
    //   17: invokevirtual 74	java/io/ByteArrayOutputStream:write	([B)V
    //   20: aload 5
    //   22: aload_3
    //   23: invokevirtual 74	java/io/ByteArrayOutputStream:write	([B)V
    //   26: aload 5
    //   28: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   31: astore 10
    //   33: aload 5
    //   35: invokevirtual 81	java/io/ByteArrayOutputStream:close	()V
    //   38: aload_0
    //   39: getfield 22	com/yandex/metrica/impl/ob/ov:b	Ljava/lang/String;
    //   42: invokestatic 86	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   45: astore 11
    //   47: aload 11
    //   49: iconst_1
    //   50: aload 4
    //   52: invokevirtual 90	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   55: new 68	java/io/ByteArrayOutputStream
    //   58: dup
    //   59: aload_1
    //   60: arraylength
    //   61: invokespecial 71	java/io/ByteArrayOutputStream:<init>	(I)V
    //   64: astore 7
    //   66: aload 7
    //   68: aload 11
    //   70: aload 10
    //   72: invokevirtual 93	javax/crypto/Cipher:doFinal	([B)[B
    //   75: invokevirtual 74	java/io/ByteArrayOutputStream:write	([B)V
    //   78: aload 7
    //   80: new 95	com/yandex/metrica/impl/ob/ot
    //   83: dup
    //   84: aload_0
    //   85: getfield 20	com/yandex/metrica/impl/ob/ov:a	Ljava/lang/String;
    //   88: aload_2
    //   89: aload_3
    //   90: invokespecial 98	com/yandex/metrica/impl/ob/ot:<init>	(Ljava/lang/String;[B[B)V
    //   93: aload_1
    //   94: invokevirtual 100	com/yandex/metrica/impl/ob/ot:a	([B)[B
    //   97: invokevirtual 74	java/io/ByteArrayOutputStream:write	([B)V
    //   100: aload 7
    //   102: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   105: astore 13
    //   107: aload 7
    //   109: invokestatic 105	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   112: aload 13
    //   114: areturn
    //   115: astore 9
    //   117: aconst_null
    //   118: astore 7
    //   120: aload 7
    //   122: invokestatic 105	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore 6
    //   129: aconst_null
    //   130: astore 7
    //   132: aload 6
    //   134: astore 8
    //   136: aload 7
    //   138: invokestatic 105	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   141: aload 8
    //   143: athrow
    //   144: astore 8
    //   146: goto -10 -> 136
    //   149: astore 12
    //   151: goto -31 -> 120
    //
    // Exception table:
    //   from	to	target	type
    //   0	66	115	java/lang/Exception
    //   0	66	127	finally
    //   66	107	144	finally
    //   66	107	149	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ov
 * JD-Core Version:    0.6.2
 */