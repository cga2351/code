package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzddb
{

  @Deprecated
  public static final zzdhn zzgpt = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzdci.zzgpt)).zzb(zzdbk.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzdbk.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzgs("TINK_HYBRID_1_0_0").zzaya();

  @Deprecated
  public static final zzdhn zzgpu = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzgpt)).zzgs("TINK_HYBRID_1_1_0").zzaya();
  public static final zzdhn zzgpv = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzdci.zzgpv)).zzb(zzdbk.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzdbk.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzgs("TINK_HYBRID").zzaya();

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
    zzdci.zzany();
    zzdce.zza("TinkHybridEncrypt", new zzdde());
    zzdce.zza("TinkHybridDecrypt", new zzddc());
    zzdbk.zza(zzgpv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddb
 * JD-Core Version:    0.6.2
 */