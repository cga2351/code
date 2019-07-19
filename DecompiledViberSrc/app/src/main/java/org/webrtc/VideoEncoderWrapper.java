package org.webrtc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;

class VideoEncoderWrapper
{
  @CalledByNative
  static VideoEncoder.Callback createEncoderCallback(long paramLong)
  {
    return new VideoEncoderWrapper..Lambda.0(paramLong);
  }

  @Nullable
  @CalledByNative
  static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings paramScalingSettings)
  {
    return paramScalingSettings.high;
  }

  @Nullable
  @CalledByNative
  static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings paramScalingSettings)
  {
    return paramScalingSettings.low;
  }

  @CalledByNative
  static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings paramScalingSettings)
  {
    return paramScalingSettings.on;
  }

  private static native void nativeOnEncodedFrame(long paramLong1, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4, boolean paramBoolean, Integer paramInteger);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoEncoderWrapper
 * JD-Core Version:    0.6.2
 */