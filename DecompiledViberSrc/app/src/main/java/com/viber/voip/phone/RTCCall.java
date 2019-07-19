package com.viber.voip.phone;

import android.content.Context;
import com.viber.jni.webrtc.IceCandidate;
import org.webrtc.SurfaceViewRenderer;

public abstract interface RTCCall extends BasicRTCCall
{
  public abstract void addPeerIceCandidate(IceCandidate paramIceCandidate);

  public abstract void applyPeerAnswer(String paramString, int paramInt, BasicRTCCall.Completion paramCompletion);

  public abstract void applyPeerOffer(String paramString, int paramInt, boolean paramBoolean, BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void applySdpAnswer(String paramString1, String paramString2, BasicRTCCall.Completion paramCompletion);

  public abstract void applySdpOffer(String paramString, int paramInt, BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void deinitCall();

  public abstract void finalizeTransfer(BasicRTCCall.Completion paramCompletion);

  public abstract int getCameraCount(Context paramContext);

  public abstract SurfaceViewRenderer getLocalVideo(Context paramContext);

  public abstract void getOffer(BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract SurfaceViewRenderer getRemoteVideo(Context paramContext);

  public abstract void localHoldWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void localUnholdWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void mute();

  public abstract void peerHoldWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void peerUnholdWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void sendDtmf(String paramString, int paramInt);

  public abstract void startCall(int paramInt);

  public abstract void startOutgoingCall(boolean paramBoolean1, boolean paramBoolean2, BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void startRecvVideo(Context paramContext);

  public abstract void startSendVideoWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void stopRecvVideo();

  public abstract void stopSendVideoWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback);

  public abstract void switchCamera();

  public abstract void unmute();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.RTCCall
 * JD-Core Version:    0.6.2
 */