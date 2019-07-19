package org.webrtc;

public class IceCandidate
{
  public final String sdp;
  public final int sdpMLineIndex;
  public final String sdpMid;
  public final String serverUrl;

  public IceCandidate(String paramString1, int paramInt, String paramString2)
  {
    this.sdpMid = paramString1;
    this.sdpMLineIndex = paramInt;
    this.sdp = paramString2;
    this.serverUrl = "";
  }

  @CalledByNative
  IceCandidate(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.sdpMid = paramString1;
    this.sdpMLineIndex = paramInt;
    this.sdp = paramString2;
    this.serverUrl = paramString3;
  }

  @CalledByNative
  String getSdp()
  {
    return this.sdp;
  }

  @CalledByNative
  String getSdpMid()
  {
    return this.sdpMid;
  }

  public String toString()
  {
    return this.sdpMid + ":" + this.sdpMLineIndex + ":" + this.sdp + ":" + this.serverUrl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.IceCandidate
 * JD-Core Version:    0.6.2
 */