package org.webrtc;

class NativeCapturerObserver
  implements CapturerObserver
{
  private final long nativeSource;

  @CalledByNative
  public NativeCapturerObserver(long paramLong)
  {
    this.nativeSource = paramLong;
  }

  private static native void nativeCapturerStarted(long paramLong, boolean paramBoolean);

  private static native void nativeCapturerStopped(long paramLong);

  private static native void nativeOnFrameCaptured(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, VideoFrame.Buffer paramBuffer);

  public void onCapturerStarted(boolean paramBoolean)
  {
    nativeCapturerStarted(this.nativeSource, paramBoolean);
  }

  public void onCapturerStopped()
  {
    nativeCapturerStopped(this.nativeSource);
  }

  public void onFrameCaptured(VideoFrame paramVideoFrame)
  {
    nativeOnFrameCaptured(this.nativeSource, paramVideoFrame.getBuffer().getWidth(), paramVideoFrame.getBuffer().getHeight(), paramVideoFrame.getRotation(), paramVideoFrame.getTimestampNs(), paramVideoFrame.getBuffer());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.NativeCapturerObserver
 * JD-Core Version:    0.6.2
 */