package org.webrtc;

public class VideoSource extends MediaSource
{
  private final NativeCapturerObserver capturerObserver;

  public VideoSource(long paramLong)
  {
    super(paramLong);
    this.capturerObserver = new NativeCapturerObserver(nativeGetInternalSource(paramLong));
  }

  private static native void nativeAdaptOutputFormat(long paramLong, int paramInt1, int paramInt2, int paramInt3);

  private static native long nativeGetInternalSource(long paramLong);

  public void adaptOutputFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    nativeAdaptOutputFormat(this.nativeSource, paramInt1, paramInt2, paramInt3);
  }

  public CapturerObserver getCapturerObserver()
  {
    return this.capturerObserver;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoSource
 * JD-Core Version:    0.6.2
 */