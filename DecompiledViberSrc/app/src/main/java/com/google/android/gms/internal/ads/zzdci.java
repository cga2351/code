package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzdci
{

  @Deprecated
  public static final zzdhn zzgpt = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzddn.zzgpt)).zzb(zzdbk.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzgs("TINK_AEAD_1_0_0").zzaya();

  @Deprecated
  private static final zzdhn zzgpu = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzgpt)).zzgs("TINK_AEAD_1_1_0").zzaya();
  public static final zzdhn zzgpv = (zzdhn)((zzdhn.zza)zzdhn.zzatk().zza(zzddn.zzgpv)).zzb(zzdbk.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzb(zzdbk.zza("TinkAead", "Aead", "XChaCha20Poly1305Key", 0, true)).zzgs("TINK_AEAD").zzaya();

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
    zzddn.zzany();
    zzdce.zza("TinkAead", new zzdch());
    zzdbk.zza(zzgpv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdci
 * JD-Core Version:    0.6.2
 */