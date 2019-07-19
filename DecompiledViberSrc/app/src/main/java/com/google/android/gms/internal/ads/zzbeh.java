package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;

final class zzbeh
  implements zzgq
{
  zzbeh(zzbdr paramzzbdr)
  {
  }

  public final void zza(zzhu paramzzhu)
  {
    zzbdr.zza(this.zzegd, "AudioTrackInitializationError", paramzzhu.getMessage());
  }

  public final void zza(zzhv paramzzhv)
  {
    zzbdr.zza(this.zzegd, "AudioTrackWriteError", paramzzhv.getMessage());
  }

  public final void zza(String paramString, long paramLong1, long paramLong2)
  {
  }

  public final void zzb(MediaCodec.CryptoException paramCryptoException)
  {
    zzbdr.zza(this.zzegd, "CryptoError", paramCryptoException.getMessage());
  }

  public final void zzb(zzgv paramzzgv)
  {
    zzbdr.zza(this.zzegd, "DecoderInitializationError", paramzzgv.getMessage());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbeh
 * JD-Core Version:    0.6.2
 */