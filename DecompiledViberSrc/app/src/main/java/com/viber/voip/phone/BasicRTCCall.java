package com.viber.voip.phone;

import com.viber.jni.webrtc.IceCandidate;
import java.util.List;
import org.webrtc.DataChannel;
import org.webrtc.SessionDescription;

public abstract interface BasicRTCCall
{
  public static abstract interface Completion
  {
    public abstract void onFailure();

    public abstract void onSuccess();
  }

  public static abstract interface CreateCallback
  {
    public abstract void onFailure();

    public abstract void onSuccess(SessionDescription paramSessionDescription);
  }

  public static abstract interface DataChannelCallback
  {
    public abstract void onCreated(DataChannel paramDataChannel);
  }

  public static abstract interface RTCCallDelegate
  {
    public abstract long getCurrentCallToken();

    public abstract String getCurrentConferenceId();

    public abstract String getDeviceModel();

    public abstract String getSystemName();

    public abstract String getSystemVersion();

    public abstract String getViberVersion();

    public abstract String getVoiceLibVersion();

    public abstract String getWebRtcVersion();

    public abstract void onRemoteSdp(String paramString);

    public abstract void sendIceCandidates(IceCandidate[] paramArrayOfIceCandidate);
  }

  public static abstract interface SdpCallback
  {
    public abstract void onError();

    public abstract void ready(String paramString);
  }

  public static abstract interface SdpExtendedCallback
  {
    public abstract void onError();

    public abstract void ready(String paramString, List<String> paramList1, List<String> paramList2);
  }

  public static abstract interface SetCallback
  {
    public abstract void onFailure();

    public abstract void onSuccess();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.BasicRTCCall
 * JD-Core Version:    0.6.2
 */