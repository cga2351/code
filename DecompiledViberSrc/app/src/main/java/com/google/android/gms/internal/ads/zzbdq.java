package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CryptoException;
import android.view.Surface;
import java.lang.ref.WeakReference;

final class zzbdq
  implements zzhh
{
  private WeakReference<zzhh> zzefn = new WeakReference(null);

  private zzbdq(zzbdl paramzzbdl)
  {
  }

  public final void zza(int paramInt1, int paramInt2, float paramFloat)
  {
    zzhh localzzhh = (zzhh)this.zzefn.get();
    if (localzzhh != null)
      localzzhh.zza(paramInt1, paramInt2, paramFloat);
  }

  public final void zza(Surface paramSurface)
  {
    zzhh localzzhh = (zzhh)this.zzefn.get();
    if (localzzhh != null)
      localzzhh.zza(paramSurface);
  }

  public final void zza(zzhh paramzzhh)
  {
    this.zzefn = new WeakReference(paramzzhh);
  }

  public final void zza(String paramString, long paramLong1, long paramLong2)
  {
    zzhh localzzhh = (zzhh)this.zzefn.get();
    if (localzzhh != null)
      localzzhh.zza(paramString, paramLong1, paramLong2);
  }

  public final void zzb(int paramInt, long paramLong)
  {
    zzhh localzzhh = (zzhh)this.zzefn.get();
    if (localzzhh != null)
      localzzhh.zzb(paramInt, paramLong);
  }

  public final void zzb(MediaCodec.CryptoException paramCryptoException)
  {
    zzbdl.zza(this.zzefo, "CryptoError", paramCryptoException.getMessage());
    zzhh localzzhh = (zzhh)this.zzefn.get();
    if (localzzhh != null)
      localzzhh.zzb(paramCryptoException);
  }

  public final void zzb(zzgv paramzzgv)
  {
    zzbdl.zza(this.zzefo, "DecoderInitializationError", paramzzgv.getMessage());
    zzhh localzzhh = (zzhh)this.zzefn.get();
    if (localzzhh != null)
      localzzhh.zzb(paramzzgv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdq
 * JD-Core Version:    0.6.2
 */