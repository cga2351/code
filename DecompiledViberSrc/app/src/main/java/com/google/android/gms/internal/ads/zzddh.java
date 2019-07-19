package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class zzddh
{
  public static zzdks zza(zzdge paramzzdge)
    throws GeneralSecurityException
  {
    switch (zzddi.zzgqc[paramzzdge.ordinal()])
    {
    default:
      String str = String.valueOf(paramzzdge);
      throw new GeneralSecurityException(20 + String.valueOf(str).length() + "unknown curve type: " + str);
    case 1:
      return zzdks.zzhaa;
    case 2:
      return zzdks.zzhab;
    case 3:
    }
    return zzdks.zzhac;
  }

  public static zzdku zza(zzdfc paramzzdfc)
    throws GeneralSecurityException
  {
    switch (zzddi.zzgqd[paramzzdfc.ordinal()])
    {
    default:
      String str = String.valueOf(paramzzdfc);
      throw new GeneralSecurityException(22 + String.valueOf(str).length() + "unknown point format: " + str);
    case 1:
      return zzdku.zzhah;
    case 2:
      return zzdku.zzhaj;
    case 3:
    }
    return zzdku.zzhai;
  }

  public static String zza(zzdgi paramzzdgi)
    throws NoSuchAlgorithmException
  {
    switch (zzddi.zzgqb[paramzzdgi.ordinal()])
    {
    default:
      String str = String.valueOf(paramzzdgi);
      throw new NoSuchAlgorithmException(27 + String.valueOf(str).length() + "hash unsupported for HMAC: " + str);
    case 1:
      return "HmacSha1";
    case 2:
      return "HmacSha256";
    case 3:
    }
    return "HmacSha512";
  }

  public static void zza(zzdfs paramzzdfs)
    throws GeneralSecurityException
  {
    zzdkq.zza(zza(paramzzdfs.zzaqp().zzara()));
    zza(paramzzdfs.zzaqp().zzaoo());
    if (paramzzdfs.zzaqr() == zzdfc.zzgrt)
      throw new GeneralSecurityException("unknown EC point format");
    zzdce.zza(paramzzdfs.zzaqq().zzaqk());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddh
 * JD-Core Version:    0.6.2
 */