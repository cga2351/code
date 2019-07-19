package org.webrtc;

import javax.annotation.Nullable;

public class RtpSender
{

  @Nullable
  private MediaStreamTrack cachedTrack;

  @Nullable
  private final DtmfSender dtmfSender;
  final long nativeRtpSender;
  private boolean ownsTrack = true;

  @CalledByNative
  public RtpSender(long paramLong)
  {
    this.nativeRtpSender = paramLong;
    this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(paramLong));
    long l = nativeGetDtmfSender(paramLong);
    if (l != 0L);
    for (DtmfSender localDtmfSender = new DtmfSender(l); ; localDtmfSender = null)
    {
      this.dtmfSender = localDtmfSender;
      return;
    }
  }

  private static native long nativeGetDtmfSender(long paramLong);

  private static native String nativeGetId(long paramLong);

  private static native RtpParameters nativeGetParameters(long paramLong);

  private static native long nativeGetTrack(long paramLong);

  private static native boolean nativeSetParameters(long paramLong, RtpParameters paramRtpParameters);

  private static native boolean nativeSetTrack(long paramLong1, long paramLong2);

  public void dispose()
  {
    if (this.dtmfSender != null)
      this.dtmfSender.dispose();
    if ((this.cachedTrack != null) && (this.ownsTrack))
      this.cachedTrack.dispose();
    JniCommon.nativeReleaseRef(this.nativeRtpSender);
  }

  @Nullable
  public DtmfSender dtmf()
  {
    return this.dtmfSender;
  }

  public RtpParameters getParameters()
  {
    return nativeGetParameters(this.nativeRtpSender);
  }

  public String id()
  {
    return nativeGetId(this.nativeRtpSender);
  }

  public boolean setParameters(RtpParameters paramRtpParameters)
  {
    return nativeSetParameters(this.nativeRtpSender, paramRtpParameters);
  }

  public boolean setTrack(@Nullable MediaStreamTrack paramMediaStreamTrack, boolean paramBoolean)
  {
    long l1 = this.nativeRtpSender;
    if (paramMediaStreamTrack == null);
    for (long l2 = 0L; !nativeSetTrack(l1, l2); l2 = paramMediaStreamTrack.nativeTrack)
      return false;
    if ((this.cachedTrack != null) && (this.ownsTrack))
      this.cachedTrack.dispose();
    this.cachedTrack = paramMediaStreamTrack;
    this.ownsTrack = paramBoolean;
    return true;
  }

  @Nullable
  public MediaStreamTrack track()
  {
    return this.cachedTrack;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RtpSender
 * JD-Core Version:    0.6.2
 */