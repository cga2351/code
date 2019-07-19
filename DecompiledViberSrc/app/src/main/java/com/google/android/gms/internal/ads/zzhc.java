package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
final class zzhc
  implements zzha
{
  private final int zzaes;
  private MediaCodecInfo[] zzaet;

  public zzhc(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      this.zzaes = i;
      return;
    }
  }

  private final void zzei()
  {
    if (this.zzaet == null)
      this.zzaet = new MediaCodecList(this.zzaes).getCodecInfos();
  }

  public final int getCodecCount()
  {
    zzei();
    return this.zzaet.length;
  }

  public final MediaCodecInfo getCodecInfoAt(int paramInt)
  {
    zzei();
    return this.zzaet[paramInt];
  }

  public final boolean zza(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }

  public final boolean zzeh()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzhc
 * JD-Core Version:    0.6.2
 */