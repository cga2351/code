package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdjl
  implements zzdbi
{
  private final SecretKey zzgxc;

  public zzdjl(byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    zzdlw.zzfg(paramArrayOfByte.length);
    this.zzgxc = new SecretKeySpec(paramArrayOfByte, "AES");
  }

  private static AlgorithmParameterSpec zzf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws GeneralSecurityException
  {
    try
    {
      Class.forName("javax.crypto.spec.GCMParameterSpec");
      GCMParameterSpec localGCMParameterSpec = new GCMParameterSpec(128, paramArrayOfByte, 0, paramInt2);
      return localGCMParameterSpec;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      if (zzdlu.zzavd())
        return new IvParameterSpec(paramArrayOfByte, 0, paramInt2);
    }
    throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
  }

  public final byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    if (paramArrayOfByte1.length > 2147483619)
      throw new GeneralSecurityException("plaintext too long");
    byte[] arrayOfByte1 = new byte[16 + (12 + paramArrayOfByte1.length)];
    byte[] arrayOfByte2 = zzdln.zzff(12);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 12);
    Cipher localCipher = (Cipher)zzdkw.zzhap.zzgt("AES/GCM/NoPadding");
    AlgorithmParameterSpec localAlgorithmParameterSpec = zzf(arrayOfByte2, 0, arrayOfByte2.length);
    localCipher.init(1, this.zzgxc, localAlgorithmParameterSpec);
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
      localCipher.updateAAD(paramArrayOfByte2);
    int i = localCipher.doFinal(paramArrayOfByte1, 0, paramArrayOfByte1.length, arrayOfByte1, 12);
    if (i != 16 + paramArrayOfByte1.length)
    {
      int j = i - paramArrayOfByte1.length;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(16);
      arrayOfObject[1] = Integer.valueOf(j);
      throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", arrayOfObject));
    }
    return arrayOfByte1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjl
 * JD-Core Version:    0.6.2
 */