package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaExtractor;

public final class zzgb
{
  public byte[] iv;
  private byte[] key;
  private int mode;
  public int[] numBytesOfClearData;
  public int[] numBytesOfEncryptedData;
  private int numSubSamples;
  private final MediaCodec.CryptoInfo zzabn;

  public zzgb()
  {
    if (zzkq.SDK_INT >= 16);
    for (MediaCodec.CryptoInfo localCryptoInfo = new MediaCodec.CryptoInfo(); ; localCryptoInfo = null)
    {
      this.zzabn = localCryptoInfo;
      return;
    }
  }

  public final void set(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    this.numSubSamples = paramInt1;
    this.numBytesOfClearData = paramArrayOfInt1;
    this.numBytesOfEncryptedData = paramArrayOfInt2;
    this.key = paramArrayOfByte1;
    this.iv = paramArrayOfByte2;
    this.mode = 1;
    if (zzkq.SDK_INT >= 16)
      this.zzabn.set(this.numSubSamples, this.numBytesOfClearData, this.numBytesOfEncryptedData, this.key, this.iv, this.mode);
  }

  @TargetApi(16)
  public final void zza(MediaExtractor paramMediaExtractor)
  {
    paramMediaExtractor.getSampleCryptoInfo(this.zzabn);
    this.numSubSamples = this.zzabn.numSubSamples;
    this.numBytesOfClearData = this.zzabn.numBytesOfClearData;
    this.numBytesOfEncryptedData = this.zzabn.numBytesOfEncryptedData;
    this.key = this.zzabn.key;
    this.iv = this.zzabn.iv;
    this.mode = this.zzabn.mode;
  }

  @TargetApi(16)
  public final MediaCodec.CryptoInfo zzdl()
  {
    return this.zzabn;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzgb
 * JD-Core Version:    0.6.2
 */