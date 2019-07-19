package org.webrtc;

class VideoDecoderWrapper
{
  @CalledByNative
  static VideoDecoder.Callback createDecoderCallback(long paramLong)
  {
    return new VideoDecoderWrapper..Lambda.0(paramLong);
  }

  private static native void nativeOnDecodedFrame(long paramLong, VideoFrame paramVideoFrame, Integer paramInteger1, Integer paramInteger2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoDecoderWrapper
 * JD-Core Version:    0.6.2
 */