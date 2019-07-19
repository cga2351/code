package com.google.android.exoplayer2.d;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.o;

@TargetApi(16)
public final class a
{
  public final String a;
  public final String b;
  public final MediaCodecInfo.CodecCapabilities c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  private final boolean h;

  private a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = ((String)com.google.android.exoplayer2.g.a.a(paramString1));
    this.b = paramString2;
    this.c = paramCodecCapabilities;
    this.g = paramBoolean1;
    boolean bool1;
    if ((!paramBoolean2) && (paramCodecCapabilities != null) && (a(paramCodecCapabilities)))
    {
      bool1 = true;
      this.d = bool1;
      if ((paramCodecCapabilities == null) || (!c(paramCodecCapabilities)))
        break label126;
    }
    label126: for (boolean bool2 = true; ; bool2 = false)
    {
      this.e = bool2;
      boolean bool3;
      if (!paramBoolean3)
      {
        bool3 = false;
        if (paramCodecCapabilities != null)
        {
          boolean bool4 = e(paramCodecCapabilities);
          bool3 = false;
          if (!bool4);
        }
      }
      else
      {
        bool3 = true;
      }
      this.f = bool3;
      this.h = o.b(paramString2);
      return;
      bool1 = false;
      break;
    }
  }

  private static int a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt > 1) || ((ag.a >= 26) && (paramInt > 0)));
    while (("audio/mpeg".equals(paramString2)) || ("audio/3gpp".equals(paramString2)) || ("audio/amr-wb".equals(paramString2)) || ("audio/mp4a-latm".equals(paramString2)) || ("audio/vorbis".equals(paramString2)) || ("audio/opus".equals(paramString2)) || ("audio/raw".equals(paramString2)) || ("audio/flac".equals(paramString2)) || ("audio/g711-alaw".equals(paramString2)) || ("audio/g711-mlaw".equals(paramString2)) || ("audio/gsm".equals(paramString2)))
      return paramInt;
    int i;
    if ("audio/ac3".equals(paramString2))
      i = 6;
    while (true)
    {
      l.c("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + paramString1 + ", [" + paramInt + " to " + i + "]");
      return i;
      if ("audio/eac3".equals(paramString2))
        i = 16;
      else
        i = 30;
    }
  }

  public static a a(String paramString)
  {
    return new a(paramString, null, null, true, false, false);
  }

  public static a a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new a(paramString1, paramString2, paramCodecCapabilities, false, paramBoolean1, paramBoolean2);
  }

  private static boolean a(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (ag.a >= 19) && (b(paramCodecCapabilities));
  }

  @TargetApi(21)
  private static boolean a(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    if ((paramDouble == -1.0D) || (paramDouble <= 0.0D))
      return paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
    return paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
  }

  @TargetApi(19)
  private static boolean b(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("adaptive-playback");
  }

  private void c(String paramString)
  {
    l.a("MediaCodecInfo", "NoSupport [" + paramString + "] [" + this.a + ", " + this.b + "] [" + ag.e + "]");
  }

  private static boolean c(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (ag.a >= 21) && (d(paramCodecCapabilities));
  }

  private void d(String paramString)
  {
    l.a("MediaCodecInfo", "AssumedSupport [" + paramString + "] [" + this.a + ", " + this.b + "] [" + ag.e + "]");
  }

  @TargetApi(21)
  private static boolean d(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("tunneled-playback");
  }

  private static boolean e(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (ag.a >= 21) && (f(paramCodecCapabilities));
  }

  @TargetApi(21)
  private static boolean f(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }

  @TargetApi(21)
  public Point a(int paramInt1, int paramInt2)
  {
    if (this.c == null)
    {
      c("align.caps");
      return null;
    }
    MediaCodecInfo.VideoCapabilities localVideoCapabilities = this.c.getVideoCapabilities();
    if (localVideoCapabilities == null)
    {
      c("align.vCaps");
      return null;
    }
    int i = localVideoCapabilities.getWidthAlignment();
    int j = localVideoCapabilities.getHeightAlignment();
    return new Point(i * ag.a(paramInt1, i), j * ag.a(paramInt2, j));
  }

  @TargetApi(21)
  public boolean a(int paramInt)
  {
    if (this.c == null)
    {
      c("sampleRate.caps");
      return false;
    }
    MediaCodecInfo.AudioCapabilities localAudioCapabilities = this.c.getAudioCapabilities();
    if (localAudioCapabilities == null)
    {
      c("sampleRate.aCaps");
      return false;
    }
    if (!localAudioCapabilities.isSampleRateSupported(paramInt))
    {
      c("sampleRate.support, " + paramInt);
      return false;
    }
    return true;
  }

  @TargetApi(21)
  public boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.c == null)
    {
      c("sizeAndRate.caps");
      return false;
    }
    MediaCodecInfo.VideoCapabilities localVideoCapabilities = this.c.getVideoCapabilities();
    if (localVideoCapabilities == null)
    {
      c("sizeAndRate.vCaps");
      return false;
    }
    if (!a(localVideoCapabilities, paramInt1, paramInt2, paramDouble))
    {
      if ((paramInt1 >= paramInt2) || (!a(localVideoCapabilities, paramInt2, paramInt1, paramDouble)))
      {
        c("sizeAndRate.support, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
        return false;
      }
      d("sizeAndRate.rotated, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
    }
    return true;
  }

  public boolean a(Format paramFormat)
    throws d.b
  {
    boolean bool1 = b(paramFormat.codecs);
    boolean bool2 = false;
    if (!bool1);
    boolean bool3;
    do
    {
      boolean bool4;
      do
      {
        do
        {
          return bool2;
          if (!this.h)
            break;
          if ((paramFormat.width <= 0) || (paramFormat.height <= 0))
            return true;
          if (ag.a >= 21)
            return a(paramFormat.width, paramFormat.height, paramFormat.frameRate);
          int i = paramFormat.width * paramFormat.height;
          int j = d.b();
          bool2 = false;
          if (i <= j)
            bool2 = true;
        }
        while (bool2);
        c("legacyFrameSize, " + paramFormat.width + "x" + paramFormat.height);
        return bool2;
        if (ag.a < 21)
          break label196;
        if (paramFormat.sampleRate == -1)
          break;
        bool4 = a(paramFormat.sampleRate);
        bool2 = false;
      }
      while (!bool4);
      if (paramFormat.channelCount == -1)
        break;
      bool3 = b(paramFormat.channelCount);
      bool2 = false;
    }
    while (!bool3);
    label196: return true;
  }

  public boolean a(Format paramFormat1, Format paramFormat2, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool5;
    boolean bool3;
    if (this.h)
      if ((paramFormat1.sampleMimeType.equals(paramFormat2.sampleMimeType)) && (paramFormat1.rotationDegrees == paramFormat2.rotationDegrees) && ((this.d) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height))) && (((!paramBoolean) && (paramFormat2.colorInfo == null)) || (ag.a(paramFormat1.colorInfo, paramFormat2.colorInfo))))
      {
        bool5 = bool1;
        bool3 = bool5;
      }
    Pair localPair1;
    Pair localPair2;
    do
    {
      do
      {
        int k;
        int m;
        do
        {
          int i;
          int j;
          do
          {
            boolean bool4;
            do
            {
              boolean bool2;
              do
              {
                return bool3;
                bool5 = false;
                break;
                bool2 = "audio/mp4a-latm".equals(this.b);
                bool3 = false;
              }
              while (!bool2);
              bool4 = paramFormat1.sampleMimeType.equals(paramFormat2.sampleMimeType);
              bool3 = false;
            }
            while (!bool4);
            i = paramFormat1.channelCount;
            j = paramFormat2.channelCount;
            bool3 = false;
          }
          while (i != j);
          k = paramFormat1.sampleRate;
          m = paramFormat2.sampleRate;
          bool3 = false;
        }
        while (k != m);
        localPair1 = d.a(paramFormat1.codecs);
        localPair2 = d.a(paramFormat2.codecs);
        bool3 = false;
      }
      while (localPair1 == null);
      bool3 = false;
    }
    while (localPair2 == null);
    int n = ((Integer)localPair1.first).intValue();
    int i1 = ((Integer)localPair2.first).intValue();
    if ((n == 42) && (i1 == 42));
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  public MediaCodecInfo.CodecProfileLevel[] a()
  {
    if ((this.c == null) || (this.c.profileLevels == null))
      return new MediaCodecInfo.CodecProfileLevel[0];
    return this.c.profileLevels;
  }

  @TargetApi(21)
  public boolean b(int paramInt)
  {
    if (this.c == null)
    {
      c("channelCount.caps");
      return false;
    }
    MediaCodecInfo.AudioCapabilities localAudioCapabilities = this.c.getAudioCapabilities();
    if (localAudioCapabilities == null)
    {
      c("channelCount.aCaps");
      return false;
    }
    if (a(this.a, this.b, localAudioCapabilities.getMaxInputChannelCount()) < paramInt)
    {
      c("channelCount.support, " + paramInt);
      return false;
    }
    return true;
  }

  public boolean b(Format paramFormat)
  {
    if (this.h)
      return this.d;
    Pair localPair = d.a(paramFormat.codecs);
    return (localPair != null) && (((Integer)localPair.first).intValue() == 42);
  }

  public boolean b(String paramString)
  {
    if ((paramString == null) || (this.b == null))
      return true;
    String str = o.f(paramString);
    if (str == null)
      return true;
    if (!this.b.equals(str))
    {
      c("codec.mime " + paramString + ", " + str);
      return false;
    }
    Pair localPair = d.a(paramString);
    if (localPair == null)
      return true;
    int i = ((Integer)localPair.first).intValue();
    int j = ((Integer)localPair.second).intValue();
    if ((!this.h) && (i != 42))
      return true;
    for (MediaCodecInfo.CodecProfileLevel localCodecProfileLevel : a())
      if ((localCodecProfileLevel.profile == i) && (localCodecProfileLevel.level >= j))
        return true;
    c("codec.profileLevel, " + paramString + ", " + str);
    return false;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.d.a
 * JD-Core Version:    0.6.2
 */