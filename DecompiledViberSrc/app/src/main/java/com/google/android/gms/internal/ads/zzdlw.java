package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.regex.Pattern;

public final class zzdlw
{
  private static final Pattern zzhbt = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", new Object[] { "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+" }), 2);
  private static final Pattern zzhbu = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", new Object[] { "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+" }), 2);

  public static void zzc(zzdlf paramzzdlf)
    throws GeneralSecurityException
  {
    switch (zzdlx.zzhbp[paramzzdlf.ordinal()])
    {
    default:
      String str = String.valueOf(paramzzdlf);
      throw new GeneralSecurityException(17 + String.valueOf(str).length() + "Unsupported hash " + str);
    case 3:
      throw new GeneralSecurityException("SHA1 is not safe for signature");
    case 1:
    case 2:
    }
  }

  public static void zzfg(int paramInt)
    throws InvalidAlgorithmParameterException
  {
    if ((paramInt != 16) && (paramInt != 32))
      throw new InvalidAlgorithmParameterException("invalid key size; only 128-bit and 256-bit AES keys are supported");
  }

  public static void zzfh(int paramInt)
    throws GeneralSecurityException
  {
    if (paramInt < 2048)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      throw new GeneralSecurityException(String.format("Modulus size is %d; only modulus size >= 2048-bit is supported", arrayOfObject));
    }
  }

  public static void zzu(int paramInt1, int paramInt2)
    throws GeneralSecurityException
  {
    if ((paramInt1 < 0) || (paramInt1 > 0))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(0);
      throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", arrayOfObject));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdlw
 * JD-Core Version:    0.6.2
 */