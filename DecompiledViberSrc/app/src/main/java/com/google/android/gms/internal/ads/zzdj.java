package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdj
{
  private static Cipher zzwr = null;
  private static final Object zzws = new Object();
  private static final Object zzwt = new Object();
  private final SecureRandom zzwq = null;

  public zzdj(SecureRandom paramSecureRandom)
  {
  }

  private static Cipher getCipher()
    throws NoSuchAlgorithmException, NoSuchPaddingException
  {
    synchronized (zzwt)
    {
      if (zzwr == null)
        zzwr = Cipher.getInstance("AES/CBC/PKCS5Padding");
      Cipher localCipher = zzwr;
      return localCipher;
    }
  }

  public final byte[] zza(byte[] paramArrayOfByte, String paramString)
    throws zzdk
  {
    if (paramArrayOfByte.length != 16)
      throw new zzdk(this);
    try
    {
      arrayOfByte1 = zzcg.zza(paramString, false);
      if (arrayOfByte1.length <= 16)
        throw new zzdk(this);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      byte[] arrayOfByte1;
      throw new zzdk(this, localNoSuchAlgorithmException);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte1.length);
      localByteBuffer.put(arrayOfByte1);
      localByteBuffer.flip();
      byte[] arrayOfByte2 = new byte[16];
      byte[] arrayOfByte3 = new byte[-16 + arrayOfByte1.length];
      localByteBuffer.get(arrayOfByte2);
      localByteBuffer.get(arrayOfByte3);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
      synchronized (zzws)
      {
        getCipher().init(2, localSecretKeySpec, new IvParameterSpec(arrayOfByte2));
        byte[] arrayOfByte4 = getCipher().doFinal(arrayOfByte3);
        return arrayOfByte4;
      }
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new zzdk(this, localInvalidKeyException);
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      throw new zzdk(this, localIllegalBlockSizeException);
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      throw new zzdk(this, localNoSuchPaddingException);
    }
    catch (BadPaddingException localBadPaddingException)
    {
      throw new zzdk(this, localBadPaddingException);
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      throw new zzdk(this, localInvalidAlgorithmParameterException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new zzdk(this, localIllegalArgumentException);
    }
  }

  public final byte[] zzan(String paramString)
    throws zzdk
  {
    int i = 0;
    byte[] arrayOfByte1;
    try
    {
      arrayOfByte1 = zzcg.zza(paramString, false);
      if (arrayOfByte1.length != 32)
        throw new zzdk(this);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new zzdk(this, localIllegalArgumentException);
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte1, 4, 16);
    byte[] arrayOfByte2 = new byte[16];
    localByteBuffer.get(arrayOfByte2);
    while (i < 16)
    {
      arrayOfByte2[i] = ((byte)(0x44 ^ arrayOfByte2[i]));
      i++;
    }
    return arrayOfByte2;
  }

  public final String zzb(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws zzdk
  {
    if (paramArrayOfByte1.length != 16)
      throw new zzdk(this);
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
      synchronized (zzws)
      {
        getCipher().init(1, localSecretKeySpec, null);
        byte[] arrayOfByte1 = getCipher().doFinal(paramArrayOfByte2);
        byte[] arrayOfByte2 = getCipher().getIV();
        int i = arrayOfByte1.length + arrayOfByte2.length;
        ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
        localByteBuffer.put(arrayOfByte2).put(arrayOfByte1);
        localByteBuffer.flip();
        byte[] arrayOfByte3 = new byte[i];
        localByteBuffer.get(arrayOfByte3);
        String str = zzcg.zza(arrayOfByte3, false);
        return str;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new zzdk(this, localNoSuchAlgorithmException);
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new zzdk(this, localInvalidKeyException);
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      throw new zzdk(this, localIllegalBlockSizeException);
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      throw new zzdk(this, localNoSuchPaddingException);
    }
    catch (BadPaddingException localBadPaddingException)
    {
      throw new zzdk(this, localBadPaddingException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdj
 * JD-Core Version:    0.6.2
 */