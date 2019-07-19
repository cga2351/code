package org.webrtc;

import javax.annotation.Nullable;

public class RtpReceiver
{

  @Nullable
  private MediaStreamTrack cachedTrack;
  private long nativeObserver;
  final long nativeRtpReceiver;

  @CalledByNative
  public RtpReceiver(long paramLong)
  {
    this.nativeRtpReceiver = paramLong;
    this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(paramLong));
  }

  private static native String nativeGetId(long paramLong);

  private static native RtpParameters nativeGetParameters(long paramLong);

  private static native long nativeGetTrack(long paramLong);

  private static native long nativeSetObserver(long paramLong, Observer paramObserver);

  private static native boolean nativeSetParameters(long paramLong, RtpParameters paramRtpParameters);

  private static native void nativeUnsetObserver(long paramLong1, long paramLong2);

  public void SetObserver(Observer paramObserver)
  {
    if (this.nativeObserver != 0L)
      nativeUnsetObserver(this.nativeRtpReceiver, this.nativeObserver);
    this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, paramObserver);
  }

  @CalledByNative
  public void dispose()
  {
    this.cachedTrack.dispose();
    if (this.nativeObserver != 0L)
    {
      nativeUnsetObserver(this.nativeRtpReceiver, this.nativeObserver);
      this.nativeObserver = 0L;
    }
    JniCommon.nativeReleaseRef(this.nativeRtpReceiver);
  }

  public RtpParameters getParameters()
  {
    return nativeGetParameters(this.nativeRtpReceiver);
  }

  public String id()
  {
    return nativeGetId(this.nativeRtpReceiver);
  }

  public boolean setParameters(@Nullable RtpParameters paramRtpParameters)
  {
    if (paramRtpParameters == null)
      return false;
    return nativeSetParameters(this.nativeRtpReceiver, paramRtpParameters);
  }

  @Nullable
  public MediaStreamTrack track()
  {
    return this.cachedTrack;
  }

  public static abstract interface Observer
  {
    @CalledByNative("Observer")
    public abstract void onFirstPacketReceived(MediaStreamTrack.MediaType paramMediaType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RtpReceiver
 * JD-Core Version:    0.6.2
 */