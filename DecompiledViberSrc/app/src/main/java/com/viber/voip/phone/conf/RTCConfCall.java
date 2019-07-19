package com.viber.voip.phone.conf;

import com.viber.voip.phone.BasicRTCCall;
import com.viber.voip.phone.BasicRTCCall.Completion;
import com.viber.voip.phone.BasicRTCCall.DataChannelCallback;
import com.viber.voip.phone.BasicRTCCall.SdpExtendedCallback;
import org.webrtc.DataChannel.Init;
import org.webrtc.PeerConnection.Observer;

public abstract interface RTCConfCall extends BasicRTCCall
{
  public abstract void addPcObserver(PeerConnection.Observer paramObserver);

  public abstract void applySdpAnswer(String paramString1, String paramString2, BasicRTCCall.Completion paramCompletion);

  public abstract void applySdpOffer(String paramString, BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback, boolean paramBoolean);

  public abstract void createDataChannel(String paramString, DataChannel.Init paramInit, BasicRTCCall.DataChannelCallback paramDataChannelCallback);

  public abstract void deinitCall();

  public abstract void generateOffer(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback);

  public abstract void localHoldWithCompletion(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback);

  public abstract void localUnholdWithCompletion(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback);

  public abstract void mute();

  public abstract void startGatherStats();

  public abstract void startOutgoingCall(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback);

  public abstract void unmute();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.RTCConfCall
 * JD-Core Version:    0.6.2
 */