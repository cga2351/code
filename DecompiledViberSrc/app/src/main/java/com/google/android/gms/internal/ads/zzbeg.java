package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;
import android.view.Surface;

final class zzbeg
  implements zzhh
{
  zzbeg(zzbdr paramzzbdr)
  {
  }

  public final void zza(int paramInt1, int paramInt2, float paramFloat)
  {
    zzbdr.zzb(this.zzegd, paramInt1);
    zzbdr.zzc(this.zzegd, paramInt2);
    zzbdr.zza(this.zzegd, paramFloat);
    zzbdr.zza(this.zzegd, zzbdr.zzd(this.zzegd), zzbdr.zze(this.zzegd), zzbdr.zzf(this.zzegd));
  }

  public final void zza(Surface paramSurface)
  {
  }

  public final void zza(String paramString, long paramLong1, long paramLong2)
  {
  }

  public final void zzb(int paramInt, long paramLong)
  {
    zzaxa.zzdp(64 + "Dropped frames. Count: " + paramInt + " Elapsed: " + paramLong);
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzbeg
 * JD-Core Version:    0.6.2
 */