package com.viber.voip.phone.conf;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.b;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.Observer..CC;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;

public class ConferenceConnectivityTracker
  implements cj.b, PeerConnection.Observer
{
  private static final long CONNECTION_CHECK_DELAY_MS = 1000L;
  private static final Logger L = ViberEnv.getLogger();
  private static final long RECONNECTING_INTERVAL_MS = 22000L;
  private boolean mAlreadyTriedToReconnect = false;
  private boolean mConnectionEstablished = false;
  private PeerConnection.IceConnectionState mCurrentIceState;
  private int mCurrentNetworkType = -1;
  final Runnable mDisconnectedRunnable = new Runnable()
  {
    public void run()
    {
      if (ConferenceConnectivityTracker.this.mListener != null)
        ConferenceConnectivityTracker.this.mListener.onDisconnected();
    }
  };
  final Handler mHandler = av.a(av.e.e);
  private boolean mIgnoreIceChange = false;
  private final ConnectivityListener mListener;
  private int mPreviousNetworkType = -1;
  private final cj mReachability = cj.a(ViberApplication.getApplication());
  private boolean mReconnectingPcIsInProgress = false;
  private final Object mStateFlagsLock = new Object();

  public ConferenceConnectivityTracker(ConnectivityListener paramConnectivityListener)
  {
    this.mReachability.a(this);
    this.mListener = paramConnectivityListener;
  }

  private void cancelDisconnectTimer()
  {
    this.mHandler.removeCallbacks(this.mDisconnectedRunnable);
  }

  private void startDisconnectTimer()
  {
    this.mHandler.postDelayed(this.mDisconnectedRunnable, 22000L);
  }

  public void backgroundDataChanged(boolean paramBoolean)
  {
  }

  public void connectivityChanged(int paramInt1, int paramInt2)
  {
    synchronized (this.mStateFlagsLock)
    {
      this.mPreviousNetworkType = this.mCurrentNetworkType;
      this.mCurrentNetworkType = paramInt1;
      return;
    }
  }

  public void onAddStream(MediaStream paramMediaStream)
  {
  }

  public void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream)
  {
  }

  public void onDataChannel(DataChannel paramDataChannel)
  {
  }

  public void onIceCandidate(IceCandidate paramIceCandidate)
  {
  }

  public void onIceCandidatesRemoved(IceCandidate[] paramArrayOfIceCandidate)
  {
  }

  public void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState)
  {
    if (this.mIgnoreIceChange);
    boolean bool;
    do
    {
      return;
      synchronized (this.mStateFlagsLock)
      {
        this.mCurrentIceState = paramIceConnectionState;
        bool = this.mConnectionEstablished;
        switch (2.$SwitchMap$org$webrtc$PeerConnection$IceConnectionState[paramIceConnectionState.ordinal()])
        {
        case 3:
        default:
          return;
        case 1:
          synchronized (this.mStateFlagsLock)
          {
            this.mConnectionEstablished = true;
            this.mAlreadyTriedToReconnect = false;
            this.mReconnectingPcIsInProgress = false;
            cancelDisconnectTimer();
            if (bool)
              this.mListener.onConnected();
            return;
          }
        case 2:
        case 4:
        }
      }
      if (bool)
        this.mListener.onReconnecting();
      startDisconnectTimer();
      return;
    }
    while (bool);
    this.mListener.onDisconnected();
  }

  public void onIceConnectionReceivingChange(boolean paramBoolean)
  {
  }

  public void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState)
  {
  }

  public void onRemoveStream(MediaStream paramMediaStream)
  {
  }

  public void onRenegotiationNeeded()
  {
  }

  public void onSignalingChange(PeerConnection.SignalingState paramSignalingState)
  {
  }

  public void onTrack(RtpTransceiver paramRtpTransceiver)
  {
    PeerConnection.Observer..CC.onTrack(this, paramRtpTransceiver);
  }

  public void subscribeToConnectivityChange(RTCConfCall paramRTCConfCall)
  {
    synchronized (this.mStateFlagsLock)
    {
      paramRTCConfCall.addPcObserver(this);
      this.mConnectionEstablished = false;
      return;
    }
  }

  public void unsubscribe()
  {
    synchronized (this.mStateFlagsLock)
    {
      this.mReachability.b(this);
      this.mConnectionEstablished = false;
      this.mIgnoreIceChange = true;
      return;
    }
  }

  public void wifiConnectivityChanged()
  {
  }

  public static abstract interface ConnectivityListener
  {
    public abstract void onConnected();

    public abstract void onDisconnected();

    public abstract void onPeerConnectionRestartNeeded();

    public abstract void onReconnecting();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ConferenceConnectivityTracker
 * JD-Core Version:    0.6.2
 */