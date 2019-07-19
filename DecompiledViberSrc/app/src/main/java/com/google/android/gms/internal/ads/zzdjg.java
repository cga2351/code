package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class zzdjg
  implements zzdbx
{
  private final SecretKey zzgxc;
  private final int zzgxd;
  private byte[] zzgxe;
  private byte[] zzgxf;

  public zzdjg(byte[] paramArrayOfByte, int paramInt)
    throws GeneralSecurityException
  {
    zzdlw.zzfg(paramArrayOfByte.length);
    this.zzgxc = new SecretKeySpec(paramArrayOfByte, "AES");
    this.zzgxd = 16;
    Cipher localCipher = zzauu();
    localCipher.init(1, this.zzgxc);
    this.zzgxe = zzdjn.zzq(localCipher.doFinal(new byte[16]));
    this.zzgxf = zzdjn.zzq(this.zzgxe);
  }

  private static Cipher zzauu()
    throws GeneralSecurityException
  {
    return (Cipher)zzdkw.zzhap.zzgt("AES/ECB/NoPadding");
  }

  public final byte[] zzk(byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    Cipher localCipher = zzauu();
    localCipher.init(1, this.zzgxc);
    int i = Math.max(1, (int)Math.ceil(paramArrayOfByte.length / 16.0D));
    if (i << 4 == paramArrayOfByte.length);
    byte[] arrayOfByte4;
    byte[] arrayOfByte2;
    for (byte[] arrayOfByte3 = zzdjr.zza(paramArrayOfByte, i - 1 << 4, this.zzgxe, 0, 16); ; arrayOfByte3 = zzdjr.zzd(arrayOfByte2, this.zzgxf))
    {
      arrayOfByte4 = new byte[16];
      for (int j = 0; j < i - 1; j++)
        arrayOfByte4 = localCipher.doFinal(zzdjr.zza(arrayOfByte4, 0, paramArrayOfByte, j << 4, 16));
      byte[] arrayOfByte1 = Arrays.copyOfRange(paramArrayOfByte, i - 1 << 4, paramArrayOfByte.length);
      if (arrayOfByte1.length >= 16)
        throw new IllegalArgumentException("x must be smaller than a block.");
      arrayOfByte2 = Arrays.copyOf(arrayOfByte1, 16);
      arrayOfByte2[arrayOfByte1.length] = -128;
    }
    byte[] arrayOfByte5 = zzdjr.zzd(arrayOfByte3, arrayOfByte4);
    byte[] arrayOfByte6 = new byte[this.zzgxd];
    System.arraycopy(localCipher.doFinal(arrayOfByte5), 0, arrayOfByte6, 0, this.zzgxd);
    return arrayOfByte6;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjg
 * JD-Core Version:    0.6.2
 */