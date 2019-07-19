package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzddn
{

  @Deprecated
  public static final zzdhn zzgpt = (zzdhn)zzdhn.zzatk().zzgs("TINK_MAC_1_0_0").zzb(zzdbk.zza("TinkMac", "Mac", "HmacKey", 0, true)).zzaya();

  @Deprecated
  private static final zzdhn zzgpu = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzgpt)).zzgs("TINK_MAC_1_1_0").zzaya();
  public static final zzdhn zzgpv = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzgpt)).zzgs("TINK_MAC").zzaya();

  static
  {
    try
    {
      zzany();
      return;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw new ExceptionInInitializerError(localGeneralSecurityException);
    }
  }

  public static void zzany()
    throws GeneralSecurityException
  {
    zzdce.zza("TinkMac", new zzddm());
    zzdbk.zza(zzgpv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddn
 * JD-Core Version:    0.6.2
 */