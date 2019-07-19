package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdjj
  implements zzdbi
{
  private final SecretKeySpec zzgxn;
  private final byte[] zzgxq;
  private final byte[] zzgxr;
  private final int zzgxs;

  public zzdjj(byte[] paramArrayOfByte, int paramInt)
    throws GeneralSecurityException
  {
    if ((paramInt != 12) && (paramInt != 16))
      throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    this.zzgxs = paramInt;
    zzdlw.zzfg(paramArrayOfByte.length);
    this.zzgxn = new SecretKeySpec(paramArrayOfByte, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/NOPADDING");
    localCipher.init(1, this.zzgxn);
    this.zzgxq = zzp(localCipher.doFinal(new byte[16]));
    this.zzgxr = zzp(this.zzgxq);
  }

  private final byte[] zza(Cipher paramCipher, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IllegalBlockSizeException, BadPaddingException
  {
    int i = 0;
    byte[] arrayOfByte1 = new byte[16];
    arrayOfByte1[15] = ((byte)paramInt1);
    if (paramInt3 == 0)
      return paramCipher.doFinal(zzd(arrayOfByte1, this.zzgxq));
    byte[] arrayOfByte2 = paramCipher.doFinal(arrayOfByte1);
    int j = 0;
    byte[] arrayOfByte3 = arrayOfByte2;
    while (paramInt3 - j > 16)
    {
      for (int k = 0; k < 16; k++)
        arrayOfByte3[k] = ((byte)(arrayOfByte3[k] ^ paramArrayOfByte[(k + (paramInt2 + j))]));
      arrayOfByte3 = paramCipher.doFinal(arrayOfByte3);
      j += 16;
    }
    byte[] arrayOfByte4 = Arrays.copyOfRange(paramArrayOfByte, paramInt2 + j, paramInt2 + paramInt3);
    if (arrayOfByte4.length == 16);
    byte[] arrayOfByte5;
    for (Object localObject = zzd(arrayOfByte4, this.zzgxq); ; localObject = arrayOfByte5)
    {
      return paramCipher.doFinal(zzd(arrayOfByte3, (byte[])localObject));
      arrayOfByte5 = Arrays.copyOf(this.zzgxr, 16);
      while (i < arrayOfByte4.length)
      {
        arrayOfByte5[i] = ((byte)(arrayOfByte5[i] ^ arrayOfByte4[i]));
        i++;
      }
      arrayOfByte5[arrayOfByte4.length] = ((byte)(0x80 ^ arrayOfByte5[arrayOfByte4.length]));
    }
  }

  private static byte[] zzd(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++)
      arrayOfByte[j] = ((byte)(paramArrayOfByte1[j] ^ paramArrayOfByte2[j]));
    return arrayOfByte;
  }

  private static byte[] zzp(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[16];
    for (int i = 0; i < 15; i++)
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] << 1 ^ (0xFF & paramArrayOfByte[(i + 1)]) >>> 7));
    int j = paramArrayOfByte[15] << 1;
    int k = 0x80 & paramArrayOfByte[0];
    int m = 0;
    if (k == 0);
    while (true)
    {
      arrayOfByte[15] = ((byte)(m ^ j));
      return arrayOfByte;
      m = 135;
    }
  }

  public final byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    int i = 0;
    if (paramArrayOfByte1.length > -16 + (2147483647 - this.zzgxs))
      throw new GeneralSecurityException("plaintext too long");
    byte[] arrayOfByte1 = new byte[16 + (this.zzgxs + paramArrayOfByte1.length)];
    byte[] arrayOfByte2 = zzdln.zzff(this.zzgxs);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, this.zzgxs);
    Cipher localCipher1 = Cipher.getInstance("AES/ECB/NOPADDING");
    localCipher1.init(1, this.zzgxn);
    byte[] arrayOfByte3 = zza(localCipher1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    if (paramArrayOfByte2 == null);
    for (byte[] arrayOfByte4 = new byte[0]; ; arrayOfByte4 = paramArrayOfByte2)
    {
      byte[] arrayOfByte5 = zza(localCipher1, 1, arrayOfByte4, 0, arrayOfByte4.length);
      Cipher localCipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
      localCipher2.init(1, this.zzgxn, new IvParameterSpec(arrayOfByte3));
      localCipher2.doFinal(paramArrayOfByte1, 0, paramArrayOfByte1.length, arrayOfByte1, this.zzgxs);
      byte[] arrayOfByte6 = zza(localCipher1, 2, arrayOfByte1, this.zzgxs, paramArrayOfByte1.length);
      int j = paramArrayOfByte1.length + this.zzgxs;
      while (i < 16)
      {
        arrayOfByte1[(j + i)] = ((byte)(arrayOfByte5[i] ^ arrayOfByte3[i] ^ arrayOfByte6[i]));
        i++;
      }
      return arrayOfByte1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjj
 * JD-Core Version:    0.6.2
 */