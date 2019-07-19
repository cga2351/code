package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Log;
import android.util.Pair;

@TargetApi(16)
public final class zzpd
{
  private final String mimeType;
  public final String name;
  public final boolean zzabo;
  public final boolean zzaer;
  public final boolean zzawy;
  private final MediaCodecInfo.CodecCapabilities zzbgo;

  private zzpd(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.name = ((String)zzsk.checkNotNull(paramString1));
    this.mimeType = paramString2;
    this.zzbgo = paramCodecCapabilities;
    int k;
    boolean bool1;
    label62: int j;
    label92: boolean bool2;
    label100: boolean bool3;
    if ((!paramBoolean1) && (paramCodecCapabilities != null))
      if ((zzsy.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback")))
      {
        k = 1;
        if (k == 0)
          break label162;
        bool1 = true;
        this.zzabo = bool1;
        if (paramCodecCapabilities == null)
          break label174;
        if ((zzsy.SDK_INT < 21) || (!paramCodecCapabilities.isFeatureSupported("tunneled-playback")))
          break label168;
        j = 1;
        if (j == 0)
          break label174;
        bool2 = true;
        this.zzawy = bool2;
        if (!paramBoolean2)
        {
          bool3 = false;
          if (paramCodecCapabilities == null)
            break label149;
          if ((zzsy.SDK_INT < 21) || (!paramCodecCapabilities.isFeatureSupported("secure-playback")))
            break label180;
        }
      }
    label149: label162: label168: label174: label180: for (int i = 1; ; i = 0)
    {
      bool3 = false;
      if (i != 0)
        bool3 = true;
      this.zzaer = bool3;
      return;
      k = 0;
      break;
      bool1 = false;
      break label62;
      j = 0;
      break label92;
      bool2 = false;
      break label100;
    }
  }

  public static zzpd zza(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new zzpd(paramString1, paramString2, paramCodecCapabilities, paramBoolean1, paramBoolean2);
  }

  @TargetApi(21)
  private static boolean zza(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    if ((paramDouble == -1.0D) || (paramDouble <= 0.0D))
      return paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
    return paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
  }

  public static zzpd zzbc(String paramString)
  {
    return new zzpd(paramString, null, null, false, false);
  }

  private final void zzbd(String paramString)
  {
    String str1 = this.name;
    String str2 = this.mimeType;
    String str3 = zzsy.zzbnq;
    Log.d("MediaCodecInfo", 20 + String.valueOf(paramString).length() + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "NoSupport [" + paramString + "] [" + str1 + ", " + str2 + "] [" + str3 + "]");
  }

  @TargetApi(21)
  public final boolean zza(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.zzbgo == null)
    {
      zzbd("sizeAndRate.caps");
      return false;
    }
    MediaCodecInfo.VideoCapabilities localVideoCapabilities = this.zzbgo.getVideoCapabilities();
    if (localVideoCapabilities == null)
    {
      zzbd("sizeAndRate.vCaps");
      return false;
    }
    if (!zza(localVideoCapabilities, paramInt1, paramInt2, paramDouble))
    {
      if ((paramInt1 >= paramInt2) || (!zza(localVideoCapabilities, paramInt2, paramInt1, paramDouble)))
      {
        zzbd(69 + "sizeAndRate.support, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
        return false;
      }
      String str1 = 69 + "sizeAndRate.rotated, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble;
      String str2 = this.name;
      String str3 = this.mimeType;
      String str4 = zzsy.zzbnq;
      Log.d("MediaCodecInfo", 25 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + "AssumedSupport [" + str1 + "] [" + str2 + ", " + str3 + "] [" + str4 + "]");
    }
    return true;
  }

  public final boolean zzat(String paramString)
  {
    if ((paramString == null) || (this.mimeType == null))
      return true;
    String str2;
    String str1;
    if (paramString != null)
    {
      str2 = paramString.trim();
      if ((str2.startsWith("avc1")) || (str2.startsWith("avc3")))
        str1 = "video/avc";
    }
    while (str1 == null)
    {
      return true;
      if ((str2.startsWith("hev1")) || (str2.startsWith("hvc1")))
        str1 = "video/hevc";
      else if (str2.startsWith("vp9"))
        str1 = "video/x-vnd.on2.vp9";
      else if (str2.startsWith("vp8"))
        str1 = "video/x-vnd.on2.vp8";
      else if (str2.startsWith("mp4a"))
        str1 = "audio/mp4a-latm";
      else if ((str2.startsWith("ac-3")) || (str2.startsWith("dac3")))
        str1 = "audio/ac3";
      else if ((str2.startsWith("ec-3")) || (str2.startsWith("dec3")))
        str1 = "audio/eac3";
      else if ((str2.startsWith("dtsc")) || (str2.startsWith("dtse")))
        str1 = "audio/vnd.dts";
      else if ((str2.startsWith("dtsh")) || (str2.startsWith("dtsl")))
        str1 = "audio/vnd.dts.hd";
      else if (str2.startsWith("opus"))
        str1 = "audio/opus";
      else if (str2.startsWith("vorbis"))
        str1 = "audio/vorbis";
      else
        str1 = null;
    }
    if (!this.mimeType.equals(str1))
    {
      zzbd(13 + String.valueOf(paramString).length() + String.valueOf(str1).length() + "codec.mime " + paramString + ", " + str1);
      return false;
    }
    Pair localPair = zzpi.zzbe(paramString);
    if (localPair == null)
      return true;
    for (MediaCodecInfo.CodecProfileLevel localCodecProfileLevel : zziq())
      if ((localCodecProfileLevel.profile == ((Integer)localPair.first).intValue()) && (localCodecProfileLevel.level >= ((Integer)localPair.second).intValue()))
        return true;
    zzbd(22 + String.valueOf(paramString).length() + String.valueOf(str1).length() + "codec.profileLevel, " + paramString + ", " + str1);
    return false;
  }

  @TargetApi(21)
  public final boolean zzba(int paramInt)
  {
    if (this.zzbgo == null)
    {
      zzbd("sampleRate.caps");
      return false;
    }
    MediaCodecInfo.AudioCapabilities localAudioCapabilities = this.zzbgo.getAudioCapabilities();
    if (localAudioCapabilities == null)
    {
      zzbd("sampleRate.aCaps");
      return false;
    }
    if (!localAudioCapabilities.isSampleRateSupported(paramInt))
    {
      zzbd(31 + "sampleRate.support, " + paramInt);
      return false;
    }
    return true;
  }

  @TargetApi(21)
  public final boolean zzbb(int paramInt)
  {
    if (this.zzbgo == null)
    {
      zzbd("channelCount.caps");
      return false;
    }
    MediaCodecInfo.AudioCapabilities localAudioCapabilities = this.zzbgo.getAudioCapabilities();
    if (localAudioCapabilities == null)
    {
      zzbd("channelCount.aCaps");
      return false;
    }
    if (localAudioCapabilities.getMaxInputChannelCount() < paramInt)
    {
      zzbd(33 + "channelCount.support, " + paramInt);
      return false;
    }
    return true;
  }

  @TargetApi(21)
  public final Point zze(int paramInt1, int paramInt2)
  {
    if (this.zzbgo == null)
    {
      zzbd("align.caps");
      return null;
    }
    MediaCodecInfo.VideoCapabilities localVideoCapabilities = this.zzbgo.getVideoCapabilities();
    if (localVideoCapabilities == null)
    {
      zzbd("align.vCaps");
      return null;
    }
    int i = localVideoCapabilities.getWidthAlignment();
    int j = localVideoCapabilities.getHeightAlignment();
    return new Point(i * zzsy.zzb(paramInt1, i), j * zzsy.zzb(paramInt2, j));
  }

  public final MediaCodecInfo.CodecProfileLevel[] zziq()
  {
    if ((this.zzbgo == null) || (this.zzbgo.profileLevels == null))
      return new MediaCodecInfo.CodecProfileLevel[0];
    return this.zzbgo.profileLevels;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpd
 * JD-Core Version:    0.6.2
 */