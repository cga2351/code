package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

public final class zzdlu
{
  public static String zza(zzdlf paramzzdlf)
    throws GeneralSecurityException
  {
    zzdlw.zzc(paramzzdlf);
    String str = String.valueOf(paramzzdlf);
    return 9 + String.valueOf(str).length() + str + "withECDSA";
  }

  public static byte[] zza(BigInteger paramBigInteger, int paramInt)
    throws GeneralSecurityException
  {
    byte[] arrayOfByte1 = paramBigInteger.toByteArray();
    if (arrayOfByte1.length == paramInt)
      return arrayOfByte1;
    if (arrayOfByte1.length > paramInt + 1)
      throw new GeneralSecurityException("integer too large");
    if (arrayOfByte1.length == paramInt + 1)
    {
      if (arrayOfByte1[0] == 0)
        return Arrays.copyOfRange(arrayOfByte1, 1, arrayOfByte1.length);
      throw new GeneralSecurityException("integer too large");
    }
    byte[] arrayOfByte2 = new byte[paramInt];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramInt - arrayOfByte1.length, arrayOfByte1.length);
    return arrayOfByte2;
  }

  public static byte[] zza(byte[] paramArrayOfByte, int paramInt, zzdlf paramzzdlf)
    throws GeneralSecurityException
  {
    MessageDigest localMessageDigest = (MessageDigest)zzdkw.zzhas.zzgt(zzb(paramzzdlf));
    int i = localMessageDigest.getDigestLength();
    byte[] arrayOfByte1 = new byte[paramInt];
    int j = 0;
    int k = 0;
    while (j <= (paramInt - 1) / i)
    {
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      localMessageDigest.update(zza(BigInteger.valueOf(j), 4));
      byte[] arrayOfByte2 = localMessageDigest.digest();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, k, Math.min(arrayOfByte2.length, arrayOfByte1.length - k));
      k += arrayOfByte2.length;
      j++;
    }
    return arrayOfByte1;
  }

  public static boolean zzavd()
  {
    try
    {
      Class.forName("android.app.Application", false, null);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static String zzb(zzdlf paramzzdlf)
    throws GeneralSecurityException
  {
    switch (zzdlv.zzhbp[paramzzdlf.ordinal()])
    {
    default:
      String str = String.valueOf(paramzzdlf);
      throw new GeneralSecurityException(17 + String.valueOf(str).length() + "Unsupported hash " + str);
    case 1:
      return "SHA-1";
    case 2:
      return "SHA-256";
    case 3:
    }
    return "SHA-512";
  }

  public static BigInteger zzx(byte[] paramArrayOfByte)
  {
    return new BigInteger(1, paramArrayOfByte);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdlu
 * JD-Core Version:    0.6.2
 */