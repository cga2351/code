package org.webrtc;

import javax.annotation.Nullable;

public abstract interface VideoEncoder
{
  @CalledByNative
  public abstract long createNativeVideoEncoder();

  @CalledByNative
  public abstract VideoCodecStatus encode(VideoFrame paramVideoFrame, EncodeInfo paramEncodeInfo);

  @CalledByNative
  public abstract String getImplementationName();

  @CalledByNative
  public abstract ScalingSettings getScalingSettings();

  @CalledByNative
  public abstract VideoCodecStatus initEncode(Settings paramSettings, Callback paramCallback);

  @CalledByNative
  public abstract boolean isHardwareEncoder();

  @CalledByNative
  public abstract VideoCodecStatus release();

  @CalledByNative
  public abstract VideoCodecStatus setChannelParameters(short paramShort, long paramLong);

  @CalledByNative
  public abstract VideoCodecStatus setRateAllocation(BitrateAllocation paramBitrateAllocation, int paramInt);

  public static class BitrateAllocation
  {
    public final int[][] bitratesBbs;

    @CalledByNative("BitrateAllocation")
    public BitrateAllocation(int[][] paramArrayOfInt)
    {
      this.bitratesBbs = paramArrayOfInt;
    }

    public int getSum()
    {
      int[][] arrayOfInt = this.bitratesBbs;
      int i = arrayOfInt.length;
      int j = 0;
      int n;
      for (int k = 0; j < i; k = n)
      {
        int[] arrayOfInt1 = arrayOfInt[j];
        int m = arrayOfInt1.length;
        n = k;
        for (int i1 = 0; i1 < m; i1++)
          n += arrayOfInt1[i1];
        j++;
      }
      return k;
    }
  }

  public static abstract interface Callback
  {
    public abstract void onEncodedFrame(EncodedImage paramEncodedImage, VideoEncoder.CodecSpecificInfo paramCodecSpecificInfo);
  }

  public static class CodecSpecificInfo
  {
  }

  public static class CodecSpecificInfoH264 extends VideoEncoder.CodecSpecificInfo
  {
  }

  public static class CodecSpecificInfoVP8 extends VideoEncoder.CodecSpecificInfo
  {
  }

  public static class CodecSpecificInfoVP9 extends VideoEncoder.CodecSpecificInfo
  {
  }

  public static class EncodeInfo
  {
    public final EncodedImage.FrameType[] frameTypes;

    @CalledByNative("EncodeInfo")
    public EncodeInfo(EncodedImage.FrameType[] paramArrayOfFrameType)
    {
      this.frameTypes = paramArrayOfFrameType;
    }
  }

  public static class ScalingSettings
  {
    public static final ScalingSettings OFF = new ScalingSettings();

    @Nullable
    public final Integer high;

    @Nullable
    public final Integer low;
    public final boolean on;

    private ScalingSettings()
    {
      this.on = false;
      this.low = null;
      this.high = null;
    }

    public ScalingSettings(int paramInt1, int paramInt2)
    {
      this.on = true;
      this.low = Integer.valueOf(paramInt1);
      this.high = Integer.valueOf(paramInt2);
    }

    @Deprecated
    public ScalingSettings(boolean paramBoolean)
    {
      this.on = paramBoolean;
      this.low = null;
      this.high = null;
    }

    @Deprecated
    public ScalingSettings(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.on = paramBoolean;
      this.low = Integer.valueOf(paramInt1);
      this.high = Integer.valueOf(paramInt2);
    }

    public String toString()
    {
      if (this.on)
        return "[ " + this.low + ", " + this.high + " ]";
      return "OFF";
    }
  }

  public static class Settings
  {
    public final boolean automaticResizeOn;
    public final int height;
    public final int maxFramerate;
    public final int numberOfCores;
    public final int numberOfSimulcastStreams;
    public final int startBitrate;
    public final int width;

    @CalledByNative("Settings")
    public Settings(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
    {
      this.numberOfCores = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
      this.startBitrate = paramInt4;
      this.maxFramerate = paramInt5;
      this.numberOfSimulcastStreams = paramInt6;
      this.automaticResizeOn = paramBoolean;
    }

    public Settings(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1, paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoEncoder
 * JD-Core Version:    0.6.2
 */