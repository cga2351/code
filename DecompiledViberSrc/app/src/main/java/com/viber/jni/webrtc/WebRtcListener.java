package com.viber.jni.webrtc;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import java.util.Map;

public class WebRtcListener extends ControllerListener<WebRtcDelegate>
  implements WebRtcDelegate
{
  public void onConferenceDialed()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onConferenceDialed();
      }
    });
  }

  public void onIceCandidateReceivedFromPeer(final IceCandidate paramIceCandidate)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onIceCandidateReceivedFromPeer(paramIceCandidate);
      }
    });
  }

  public void onPeerCapabilities(final int paramInt, final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onPeerCapabilities(paramInt, paramBoolean);
      }
    });
  }

  public void onPeerTransferred(final ProcessedCallback paramProcessedCallback)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onPeerTransferred(paramProcessedCallback);
      }
    });
  }

  public void onSdpAnswerReceivedFromPeer(final String paramString, final int paramInt, final ProcessedCallback paramProcessedCallback)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onSdpAnswerReceivedFromPeer(paramString, paramInt, paramProcessedCallback);
      }
    });
  }

  public void onSdpAnswerableOfferReceivedFromPeer(final String paramString, final int paramInt, final SdpProcessedCallback paramSdpProcessedCallback)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onSdpAnswerableOfferReceivedFromPeer(paramString, paramInt, paramSdpProcessedCallback);
      }
    });
  }

  public void onSdpOfferReceivedFromPeer(final String paramString, final int paramInt, final boolean paramBoolean, final SdpProcessedCallback paramSdpProcessedCallback)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onSdpOfferReceivedFromPeer(paramString, paramInt, paramBoolean, paramSdpProcessedCallback);
      }
    });
  }

  public void onSwitchToConferenceCall(final long paramLong, String paramString, final Map<String, String> paramMap)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WebRtcDelegate paramAnonymousWebRtcDelegate)
      {
        paramAnonymousWebRtcDelegate.onSwitchToConferenceCall(paramLong, paramMap, this.val$conferenceMembers);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.webrtc.WebRtcListener
 * JD-Core Version:    0.6.2
 */