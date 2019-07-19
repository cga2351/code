package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class zzdln
{
  private static final ThreadLocal<SecureRandom> zzhbl = new zzdlo();

  private static SecureRandom zzavb()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    localSecureRandom.nextLong();
    return localSecureRandom;
  }

  public static byte[] zzff(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    ((SecureRandom)zzhbl.get()).nextBytes(arrayOfByte);
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdln
 * JD-Core Version:    0.6.2
 */