package org.webrtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RtpTransceiver
{
  private RtpReceiver cachedReceiver;
  private RtpSender cachedSender;
  private final long nativeRtpTransceiver;

  @CalledByNative
  protected RtpTransceiver(long paramLong)
  {
    this.nativeRtpTransceiver = paramLong;
    this.cachedSender = nativeGetSender(paramLong);
    this.cachedReceiver = nativeGetReceiver(paramLong);
  }

  private static native RtpTransceiverDirection nativeCurrentDirection(long paramLong);

  private static native RtpTransceiverDirection nativeDirection(long paramLong);

  private static native MediaStreamTrack.MediaType nativeGetMediaType(long paramLong);

  private static native String nativeGetMid(long paramLong);

  private static native RtpReceiver nativeGetReceiver(long paramLong);

  private static native RtpSender nativeGetSender(long paramLong);

  private static native void nativeSetDirection(long paramLong, RtpTransceiverDirection paramRtpTransceiverDirection);

  private static native void nativeStop(long paramLong);

  private static native boolean nativeStopped(long paramLong);

  @CalledByNative
  public void dispose()
  {
    this.cachedSender.dispose();
    this.cachedReceiver.dispose();
    JniCommon.nativeReleaseRef(this.nativeRtpTransceiver);
  }

  public RtpTransceiverDirection getCurrentDirection()
  {
    return nativeCurrentDirection(this.nativeRtpTransceiver);
  }

  public RtpTransceiverDirection getDirection()
  {
    return nativeDirection(this.nativeRtpTransceiver);
  }

  public MediaStreamTrack.MediaType getMediaType()
  {
    return nativeGetMediaType(this.nativeRtpTransceiver);
  }

  public String getMid()
  {
    return nativeGetMid(this.nativeRtpTransceiver);
  }

  public RtpReceiver getReceiver()
  {
    return this.cachedReceiver;
  }

  public RtpSender getSender()
  {
    return this.cachedSender;
  }

  public boolean isStopped()
  {
    return nativeStopped(this.nativeRtpTransceiver);
  }

  public void setDirection(RtpTransceiverDirection paramRtpTransceiverDirection)
  {
    nativeSetDirection(this.nativeRtpTransceiver, paramRtpTransceiverDirection);
  }

  public void stop()
  {
    nativeStop(this.nativeRtpTransceiver);
  }

  public static enum RtpTransceiverDirection
  {
    private final int nativeIndex;

    static
    {
      SEND_ONLY = new RtpTransceiverDirection("SEND_ONLY", 1, 1);
      RECV_ONLY = new RtpTransceiverDirection("RECV_ONLY", 2, 2);
      INACTIVE = new RtpTransceiverDirection("INACTIVE", 3, 3);
      RtpTransceiverDirection[] arrayOfRtpTransceiverDirection = new RtpTransceiverDirection[4];
      arrayOfRtpTransceiverDirection[0] = SEND_RECV;
      arrayOfRtpTransceiverDirection[1] = SEND_ONLY;
      arrayOfRtpTransceiverDirection[2] = RECV_ONLY;
      arrayOfRtpTransceiverDirection[3] = INACTIVE;
    }

    private RtpTransceiverDirection(int paramInt)
    {
      this.nativeIndex = paramInt;
    }

    @CalledByNative("RtpTransceiverDirection")
    static RtpTransceiverDirection fromNativeIndex(int paramInt)
    {
      for (RtpTransceiverDirection localRtpTransceiverDirection : values())
        if (localRtpTransceiverDirection.getNativeIndex() == paramInt)
          return localRtpTransceiverDirection;
      throw new IllegalArgumentException("Uknown native RtpTransceiverDirection type" + paramInt);
    }

    @CalledByNative("RtpTransceiverDirection")
    int getNativeIndex()
    {
      return this.nativeIndex;
    }
  }

  public static final class RtpTransceiverInit
  {
    private final RtpTransceiver.RtpTransceiverDirection direction;
    private final List<String> streamIds;

    public RtpTransceiverInit()
    {
      this(RtpTransceiver.RtpTransceiverDirection.SEND_RECV);
    }

    public RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection paramRtpTransceiverDirection)
    {
      this(paramRtpTransceiverDirection, Collections.emptyList());
    }

    public RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection paramRtpTransceiverDirection, List<String> paramList)
    {
      this.direction = paramRtpTransceiverDirection;
      this.streamIds = new ArrayList(paramList);
    }

    @CalledByNative("RtpTransceiverInit")
    int getDirectionNativeIndex()
    {
      return this.direction.getNativeIndex();
    }

    @CalledByNative("RtpTransceiverInit")
    List<String> getStreamIds()
    {
      return new ArrayList(this.streamIds);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RtpTransceiver
 * JD-Core Version:    0.6.2
 */