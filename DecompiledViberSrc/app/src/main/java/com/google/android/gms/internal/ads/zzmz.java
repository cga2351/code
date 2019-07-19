package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;

public final class zzmz
{
  public byte[] iv;
  private byte[] key;
  private int mode;
  public int[] numBytesOfClearData;
  public int[] numBytesOfEncryptedData;
  private int numSubSamples;
  private final MediaCodec.CryptoInfo zzabn;
  private int zzayw;
  private int zzayx;
  private final zznb zzayy;

  public zzmz()
  {
    if (zzsy.SDK_INT >= 16);
    for (MediaCodec.CryptoInfo localCryptoInfo = new MediaCodec.CryptoInfo(); ; localCryptoInfo = null)
    {
      this.zzabn = localCryptoInfo;
      int i = zzsy.SDK_INT;
      zznb localzznb = null;
      if (i >= 24)
        localzznb = new zznb(this.zzabn, null);
      this.zzayy = localzznb;
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
    this.mode = paramInt2;
    this.zzayw = 0;
    this.zzayx = 0;
    if (zzsy.SDK_INT >= 16)
    {
      this.zzabn.numSubSamples = this.numSubSamples;
      this.zzabn.numBytesOfClearData = this.numBytesOfClearData;
      this.zzabn.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
      this.zzabn.key = this.key;
      this.zzabn.iv = this.iv;
      this.zzabn.mode = this.mode;
      if (zzsy.SDK_INT >= 24)
        zznb.zza(this.zzayy, 0, 0);
    }
  }

  @TargetApi(16)
  public final MediaCodec.CryptoInfo zzdl()
  {
    return this.zzabn;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmz
 * JD-Core Version:    0.6.2
 */