package com.viber.jni.dialer;

import com.viber.jni.webrtc.IceCandidate;
import com.viber.jni.webrtc.ProcessedCallback;
import com.viber.jni.webrtc.SdpProcessedCallback;

public abstract interface WebRtcDialerController
{
  public abstract void handleDial(String paramString1, String paramString2, boolean paramBoolean);

  public abstract void handleDialConference(long paramLong, boolean paramBoolean);

  public abstract void handleDialViberOut(String paramString1, String paramString2);

  public abstract void handleSendIceCandidates(IceCandidate[] paramArrayOfIceCandidate);

  public abstract void handleSendSdpAnswer(String paramString, ProcessedCallback paramProcessedCallback);

  public abstract void handleSendSdpOffer(String paramString, SdpProcessedCallback paramSdpProcessedCallback);

  public abstract void handleSendSdpOfferToHs(String paramString);

  public abstract void handleSetRemoteSdp(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.WebRtcDialerController
 * JD-Core Version:    0.6.2
 */