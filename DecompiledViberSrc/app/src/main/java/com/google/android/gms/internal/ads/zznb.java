package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
final class zznb
{
  private final MediaCodec.CryptoInfo zzabn;
  private final MediaCodec.CryptoInfo.Pattern zzayz;

  private zznb(MediaCodec.CryptoInfo paramCryptoInfo)
  {
    this.zzabn = paramCryptoInfo;
    this.zzayz = new MediaCodec.CryptoInfo.Pattern(0, 0);
  }

  private final void set(int paramInt1, int paramInt2)
  {
    this.zzayz.set(paramInt1, paramInt2);
    this.zzabn.setPattern(this.zzayz);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zznb
 * JD-Core Version:    0.6.2
 */