package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;
import java.lang.ref.WeakReference;

final class zzbdn
  implements zzgq
{
  private WeakReference<zzgq> zzefn = new WeakReference(null);

  private zzbdn(zzbdl paramzzbdl)
  {
  }

  public final void zza(zzgq paramzzgq)
  {
    this.zzefn = new WeakReference(paramzzgq);
  }

  public final void zza(zzhu paramzzhu)
  {
    zzbdl.zza(this.zzefo, "AudioTrackInitializationError", paramzzhu.getMessage());
    zzgq localzzgq = (zzgq)this.zzefn.get();
    if (localzzgq != null)
      localzzgq.zza(paramzzhu);
  }

  public final void zza(zzhv paramzzhv)
  {
    zzbdl.zza(this.zzefo, "AudioTrackWriteError", paramzzhv.getMessage());
    zzgq localzzgq = (zzgq)this.zzefn.get();
    if (localzzgq != null)
      localzzgq.zza(paramzzhv);
  }

  public final void zza(String paramString, long paramLong1, long paramLong2)
  {
    zzgq localzzgq = (zzgq)this.zzefn.get();
    if (localzzgq != null)
      localzzgq.zza(paramString, paramLong1, paramLong2);
  }

  public final void zzb(MediaCodec.CryptoException paramCryptoException)
  {
    zzbdl.zza(this.zzefo, "CryptoError", paramCryptoException.getMessage());
    zzgq localzzgq = (zzgq)this.zzefn.get();
    if (localzzgq != null)
      localzzgq.zzb(paramCryptoException);
  }

  public final void zzb(zzgv paramzzgv)
  {
    zzbdl.zza(this.zzefo, "DecoderInitializationError", paramzzgv.getMessage());
    zzgq localzzgq = (zzgq)this.zzefn.get();
    if (localzzgq != null)
      localzzgq.zzb(paramzzgv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdn
 * JD-Core Version:    0.6.2
 */