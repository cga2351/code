package com.viber.voip.phone;

import android.os.Handler;
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

public class PeerConnectionTrackerProxy
  implements IPeerConnectionTracker
{
  private static final Logger L;
  private final Handler mHandler;
  private final IPeerConnectionTracker mTracker;

  static
  {
    if (!PeerConnectionTrackerProxy.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      L = ViberEnv.getLogger();
      return;
    }
  }

  public PeerConnectionTrackerProxy(Handler paramHandler, IPeerConnectionTracker paramIPeerConnectionTracker)
  {
    this.mTracker = paramIPeerConnectionTracker;
    this.mHandler = paramHandler;
    assert (this.mTracker != null);
    assert (this.mHandler != null);
  }

  public void save(final long paramLong, IPeerConnectionTracker.CompletionCallback paramCompletionCallback)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.save(paramLong, this.val$callback);
        }
      });
  }

  public void trackAddIceCandidate(final IceCandidate paramIceCandidate, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackAddIceCandidate(paramIceCandidate, paramBoolean1, paramBoolean2);
        }
      });
  }

  public void trackAddStream(final String paramString, final boolean paramBoolean)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackAddStream(paramString, paramBoolean);
        }
      });
  }

  public void trackCallToken(final long paramLong, String paramString)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackCallToken(paramLong, this.val$description);
        }
      });
  }

  public void trackCreateAnswer(final MediaConstraints paramMediaConstraints)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackCreateAnswer(paramMediaConstraints);
        }
      });
  }

  public void trackCreateAnswerCallback(final String paramString1, final String paramString2, final String paramString3)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackCreateOfferCallback(paramString1, paramString2, paramString3);
        }
      });
  }

  public void trackCreateDataChannel(final String paramString, final boolean paramBoolean)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackCreateDataChannel(paramString, paramBoolean);
        }
      });
  }

  public void trackCreateOffer(final MediaConstraints paramMediaConstraints)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackCreateOffer(paramMediaConstraints);
        }
      });
  }

  public void trackCreateOfferCallback(final String paramString1, final String paramString2, final String paramString3)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackCreateOfferCallback(paramString1, paramString2, paramString3);
        }
      });
  }

  public void trackHostApplicationInfo(final BasicRTCCall.RTCCallDelegate paramRTCCallDelegate)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackHostApplicationInfo(paramRTCCallDelegate);
        }
      });
  }

  public void trackIceConnectionStateChange(final PeerConnection.IceConnectionState paramIceConnectionState)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackIceConnectionStateChange(paramIceConnectionState);
        }
      });
  }

  public void trackIceGatheringStateChange(final PeerConnection.IceGatheringState paramIceGatheringState)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackIceGatheringStateChange(paramIceGatheringState);
        }
      });
  }

  public void trackOnRenegotiationNeeded()
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackOnRenegotiationNeeded();
        }
      });
  }

  public void trackPeerConnection(final PeerConnection paramPeerConnection, final PeerConnection.RTCConfiguration paramRTCConfiguration, final MediaConstraints paramMediaConstraints)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackPeerConnection(paramPeerConnection, paramRTCConfiguration, paramMediaConstraints);
        }
      });
  }

  public void trackRemoveStream(final String paramString, final boolean paramBoolean)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackRemoveStream(paramString, paramBoolean);
        }
      });
  }

  public void trackSetConfiguration(final PeerConnection.RTCConfiguration paramRTCConfiguration)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackSetConfiguration(paramRTCConfiguration);
        }
      });
  }

  public void trackSetSessionDescription(final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackSetSessionDescription(paramString1, paramString2, paramBoolean);
        }
      });
  }

  public void trackSetSessionDescriptionCallback(final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackSetSessionDescriptionCallback(paramString1, paramString2, paramString3, paramBoolean);
        }
      });
  }

  public void trackSignalingStateChange(final PeerConnection.SignalingState paramSignalingState)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackSignalingStateChange(paramSignalingState);
        }
      });
  }

  public void trackStatsReports(final StatsReport[] paramArrayOfStatsReport)
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackStatsReports(paramArrayOfStatsReport);
        }
      });
  }

  public void trackStop()
  {
    if (this.mTracker != null)
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          PeerConnectionTrackerProxy.this.mTracker.trackStop();
        }
      });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PeerConnectionTrackerProxy
 * JD-Core Version:    0.6.2
 */