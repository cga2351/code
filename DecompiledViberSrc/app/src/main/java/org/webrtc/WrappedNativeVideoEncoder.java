package org.webrtc;

abstract class WrappedNativeVideoEncoder
  implements VideoEncoder
{
  public abstract long createNativeVideoEncoder();

  public VideoCodecStatus encode(VideoFrame paramVideoFrame, VideoEncoder.EncodeInfo paramEncodeInfo)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public String getImplementationName()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public VideoEncoder.ScalingSettings getScalingSettings()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public VideoCodecStatus initEncode(VideoEncoder.Settings paramSettings, VideoEncoder.Callback paramCallback)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public abstract boolean isHardwareEncoder();

  public VideoCodecStatus release()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public VideoCodecStatus setChannelParameters(short paramShort, long paramLong)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation paramBitrateAllocation, int paramInt)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.WrappedNativeVideoEncoder
 * JD-Core Version:    0.6.2
 */