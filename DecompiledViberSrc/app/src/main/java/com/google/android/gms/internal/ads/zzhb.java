package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

final class zzhb
  implements zzha
{
  public final int getCodecCount()
  {
    return MediaCodecList.getCodecCount();
  }

  public final MediaCodecInfo getCodecInfoAt(int paramInt)
  {
    return MediaCodecList.getCodecInfoAt(paramInt);
  }

  public final boolean zza(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return "video/avc".equals(paramString);
  }

  public final boolean zzeh()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzhb
 * JD-Core Version:    0.6.2
 */