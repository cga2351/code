package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdji
  implements zzdlj
{
  private final SecretKeySpec zzgxn;
  private final int zzgxo;
  private final int zzgxp;

  public zzdji(byte[] paramArrayOfByte, int paramInt)
    throws GeneralSecurityException
  {
    zzdlw.zzfg(paramArrayOfByte.length);
    this.zzgxn = new SecretKeySpec(paramArrayOfByte, "AES");
    this.zzgxp = ((Cipher)zzdkw.zzhap.zzgt("AES/CTR/NoPadding")).getBlockSize();
    if ((paramInt < 12) || (paramInt > this.zzgxp))
      throw new GeneralSecurityException("invalid IV size");
    this.zzgxo = paramInt;
  }

  public final byte[] zzo(byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    if (paramArrayOfByte.length > 2147483647 - this.zzgxo)
    {
      int k = 2147483647 - this.zzgxo;
      throw new GeneralSecurityException(43 + "plaintext length can not exceed " + k);
    }
    byte[] arrayOfByte1 = new byte[this.zzgxo + paramArrayOfByte.length];
    byte[] arrayOfByte2 = zzdln.zzff(this.zzgxo);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, this.zzgxo);
    int i = paramArrayOfByte.length;
    int j = this.zzgxo;
    Cipher localCipher = (Cipher)zzdkw.zzhap.zzgt("AES/CTR/NoPadding");
    byte[] arrayOfByte3 = new byte[this.zzgxp];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, this.zzgxo);
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(arrayOfByte3);
    localCipher.init(1, this.zzgxn, localIvParameterSpec);
    if (localCipher.doFinal(paramArrayOfByte, 0, i, arrayOfByte1, j) != i)
      throw new GeneralSecurityException("stored output's length does not match input's length");
    return arrayOfByte1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdji
 * JD-Core Version:    0.6.2
 */