package com.viber.voip.phone;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.StatsReport;

public class PeerConnectionNullTrackerImpl
  implements IPeerConnectionTracker
{
  private static final Logger L = ViberEnv.getLogger();

  public void save(long paramLong, IPeerConnectionTracker.CompletionCallback paramCompletionCallback)
  {
    if (paramCompletionCallback != null)
      paramCompletionCallback.onComplete(null, null);
  }

  public void trackAddIceCandidate(IceCandidate paramIceCandidate, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public void trackAddStream(String paramString, boolean paramBoolean)
  {
  }

  public void trackCallToken(long paramLong, String paramString)
  {
  }

  public void trackCreateAnswer(MediaConstraints paramMediaConstraints)
  {
  }

  public void trackCreateAnswerCallback(String paramString1, String paramString2, String paramString3)
  {
  }

  public void trackCreateDataChannel(String paramString, boolean paramBoolean)
  {
  }

  public void trackCreateOffer(MediaConstraints paramMediaConstraints)
  {
  }

  public void trackCreateOfferCallback(String paramString1, String paramString2, String paramString3)
  {
  }

  public void trackHostApplicationInfo(BasicRTCCall.RTCCallDelegate paramRTCCallDelegate)
  {
  }

  public void trackIceConnectionStateChange(PeerConnection.IceConnectionState paramIceConnectionState)
  {
  }

  public void trackIceGatheringStateChange(PeerConnection.IceGatheringState paramIceGatheringState)
  {
  }

  public void trackOnRenegotiationNeeded()
  {
  }

  public void trackPeerConnection(PeerConnection paramPeerConnection, PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints)
  {
  }

  public void trackRemoveStream(String paramString, boolean paramBoolean)
  {
  }

  public void trackSetConfiguration(PeerConnection.RTCConfiguration paramRTCConfiguration)
  {
  }

  public void trackSetSessionDescription(String paramString1, String paramString2, boolean paramBoolean)
  {
  }

  public void trackSetSessionDescriptionCallback(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
  }

  public void trackSignalingStateChange(PeerConnection.SignalingState paramSignalingState)
  {
  }

  public void trackStatsReports(StatsReport[] paramArrayOfStatsReport)
  {
  }

  public void trackStop()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PeerConnectionNullTrackerImpl
 * JD-Core Version:    0.6.2
 */