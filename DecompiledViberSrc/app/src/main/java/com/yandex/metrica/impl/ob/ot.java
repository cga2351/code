package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ot
{
  private final String a;
  private final byte[] b;
  private final byte[] c;

  public ot(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramString;
    this.b = paramArrayOfByte1;
    this.c = paramArrayOfByte2;
  }

  @SuppressLint({"TrulyRandom"})
  public byte[] a(byte[] paramArrayOfByte)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.b, "AES");
    Cipher localCipher = Cipher.getInstance(this.a);
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(this.c));
    return localCipher.doFinal(paramArrayOfByte);
  }

  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.b, "AES");
    Cipher localCipher = Cipher.getInstance(this.a);
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(this.c));
    return localCipher.doFinal(paramArrayOfByte, paramInt1, paramInt2);
  }

  @SuppressLint({"TrulyRandom"})
  public byte[] b(byte[] paramArrayOfByte)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ot
 * JD-Core Version:    0.6.2
 */