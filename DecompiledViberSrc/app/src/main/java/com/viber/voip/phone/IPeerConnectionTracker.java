package com.viber.voip.phone;

import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.StatsReport;

public abstract interface IPeerConnectionTracker
{
  public abstract void save(long paramLong, CompletionCallback paramCompletionCallback);

  public abstract void trackAddIceCandidate(IceCandidate paramIceCandidate, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void trackAddStream(String paramString, boolean paramBoolean);

  public abstract void trackCallToken(long paramLong, String paramString);

  public abstract void trackCreateAnswer(MediaConstraints paramMediaConstraints);

  public abstract void trackCreateAnswerCallback(String paramString1, String paramString2, String paramString3);

  public abstract void trackCreateDataChannel(String paramString, boolean paramBoolean);

  public abstract void trackCreateOffer(MediaConstraints paramMediaConstraints);

  public abstract void trackCreateOfferCallback(String paramString1, String paramString2, String paramString3);

  public abstract void trackHostApplicationInfo(BasicRTCCall.RTCCallDelegate paramRTCCallDelegate);

  public abstract void trackIceConnectionStateChange(PeerConnection.IceConnectionState paramIceConnectionState);

  public abstract void trackIceGatheringStateChange(PeerConnection.IceGatheringState paramIceGatheringState);

  public abstract void trackOnRenegotiationNeeded();

  public abstract void trackPeerConnection(PeerConnection paramPeerConnection, PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints);

  public abstract void trackRemoveStream(String paramString, boolean paramBoolean);

  public abstract void trackSetConfiguration(PeerConnection.RTCConfiguration paramRTCConfiguration);

  public abstract void trackSetSessionDescription(String paramString1, String paramString2, boolean paramBoolean);

  public abstract void trackSetSessionDescriptionCallback(String paramString1, String paramString2, String paramString3, boolean paramBoolean);

  public abstract void trackSignalingStateChange(PeerConnection.SignalingState paramSignalingState);

  public abstract void trackStatsReports(StatsReport[] paramArrayOfStatsReport);

  public abstract void trackStop();

  public static abstract interface CompletionCallback
  {
    public abstract void onComplete(String paramString1, String paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.IPeerConnectionTracker
 * JD-Core Version:    0.6.2
 */