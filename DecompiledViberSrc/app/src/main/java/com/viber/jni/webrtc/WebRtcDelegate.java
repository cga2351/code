package com.viber.jni.webrtc;

import java.util.Map;

public abstract interface WebRtcDelegate
{
  public abstract void onConferenceDialed();

  public abstract void onIceCandidateReceivedFromPeer(IceCandidate paramIceCandidate);

  public abstract void onPeerCapabilities(int paramInt, boolean paramBoolean);

  public abstract void onPeerTransferred(ProcessedCallback paramProcessedCallback);

  public abstract void onSdpAnswerReceivedFromPeer(String paramString, int paramInt, ProcessedCallback paramProcessedCallback);

  public abstract void onSdpAnswerableOfferReceivedFromPeer(String paramString, int paramInt, SdpProcessedCallback paramSdpProcessedCallback);

  public abstract void onSdpOfferReceivedFromPeer(String paramString, int paramInt, boolean paramBoolean, SdpProcessedCallback paramSdpProcessedCallback);

  public abstract void onSwitchToConferenceCall(long paramLong, String paramString, Map<String, String> paramMap);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.webrtc.WebRtcDelegate
 * JD-Core Version:    0.6.2
 */