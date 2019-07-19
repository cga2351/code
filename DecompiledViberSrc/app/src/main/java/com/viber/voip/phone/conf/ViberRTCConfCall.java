package com.viber.voip.phone.conf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.phone.BasicRTCCall.Completion;
import com.viber.voip.phone.BasicRTCCall.CreateCallback;
import com.viber.voip.phone.BasicRTCCall.DataChannelCallback;
import com.viber.voip.phone.BasicRTCCall.RTCCallDelegate;
import com.viber.voip.phone.BasicRTCCall.SdpExtendedCallback;
import com.viber.voip.phone.BasicRTCCall.SetCallback;
import com.viber.voip.phone.IPeerConnectionTracker;
import com.viber.voip.phone.IPeerConnectionTracker.CompletionCallback;
import com.viber.voip.phone.PeerConnectionTrackerFactory;
import com.viber.voip.phone.StatisticsHelper;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.webrtc.AudioTrack;
import org.webrtc.DataChannel;
import org.webrtc.DataChannel.Init;
import org.webrtc.EglBase;
import org.webrtc.EglBase..CC;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaConstraints.KeyValuePair;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.ContinualGatheringPolicy;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.Observer..CC;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.PeerConnection.TcpCandidatePolicy;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import org.webrtc.videoengine.ViberRTCWorkarounds;

public final class ViberRTCConfCall
  implements RTCConfCall
{
  private static final String AUDIO_TRACK_ID = "audioTrackId_";
  private static final boolean ENABLE_PEER_CONNECTION_TRACKER = false;
  private static final Logger L = ViberEnv.getLogger();
  private static final String MEDIA_STREAM_TRACK_KIND_AUDIO = "audio";
  private final BasicRTCCall.RTCCallDelegate mDelegate;
  private final Handler mHandler;
  private boolean mLocalHold = false;
  private MediaStream mLocalMediaStream;
  private boolean mMuted = false;
  ProxiedPCObserver mObserverProxy = new ProxiedPCObserver(null);
  private final PCObserver mPcObserver = new PCObserver(null);
  private PeerConnection mPeerConnection;
  private PeerConnectionFactory mPeerConnectionFactory;
  private IPeerConnectionTracker mPeerConnectionTracker = PeerConnectionTrackerFactory.newPeerConnectionTracker(true);
  private boolean mPeerHold = false;
  private EglBase mRootEglBase;
  private StatisticsHelper mStatisticsHelper;

  private ViberRTCConfCall(Handler paramHandler, Context paramContext, BasicRTCCall.RTCCallDelegate paramRTCCallDelegate)
  {
    this.mHandler = paramHandler;
    this.mRootEglBase = EglBase..CC.create$$STATIC$$();
    this.mDelegate = paramRTCCallDelegate;
    this.mPeerConnectionTracker.trackHostApplicationInfo(paramRTCCallDelegate);
    forwardActionTo(paramHandler, new ViberRTCConfCall..Lambda.0(this));
  }

  private void addAudioTrack(String paramString)
  {
    boolean bool = true;
    checkOnHandlerThread();
    ensurePeerConnection();
    if (getAudioTrack() != null)
      return;
    if (this.mLocalMediaStream == null)
    {
      this.mLocalMediaStream = this.mPeerConnectionFactory.createLocalMediaStream(generateStreamId("media"));
      this.mPeerConnectionTracker.trackAddStream(this.mLocalMediaStream.getId(), bool);
      this.mPeerConnection.addStream(this.mLocalMediaStream);
    }
    AudioTrack localAudioTrack = this.mPeerConnectionFactory.createAudioTrack(paramString, this.mPeerConnectionFactory.createAudioSource(new MediaConstraints()));
    if (!this.mMuted);
    while (true)
    {
      localAudioTrack.setEnabled(bool);
      this.mLocalMediaStream.addTrack(localAudioTrack);
      return;
      bool = false;
    }
  }

  private void checkOnHandlerThread()
  {
    if (this.mHandler.getLooper().getThread() != Thread.currentThread())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.mHandler;
      throw new IllegalStateException(String.format("not on required handler %s", arrayOfObject));
    }
  }

  public static RTCConfCall create(BasicRTCCall.RTCCallDelegate paramRTCCallDelegate)
  {
    ViberRTCWorkarounds.initParentContextSupported();
    Handler localHandler = av.a(av.e.e);
    return new RTCConfCallProxy(new ViberRTCConfCall(localHandler, ViberApplication.getApplication(), paramRTCCallDelegate), localHandler);
  }

  private void createOffer(BasicRTCCall.CreateCallback paramCreateCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramCreateCallback.onFailure();
      return;
    }
    MediaConstraints localMediaConstraints = prepareMediaConstraints();
    this.mPeerConnectionTracker.trackCreateOffer(localMediaConstraints);
    this.mPeerConnection.createOffer(new SdpResultObserver(this.mHandler, paramCreateCallback, "createOffer failed"), localMediaConstraints);
  }

  private void createPeerConnection()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection != null)
      return;
    PeerConnection.RTCConfiguration localRTCConfiguration = new PeerConnection.RTCConfiguration(Collections.EMPTY_LIST);
    localRTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
    localRTCConfiguration.disableIpv6 = true;
    localRTCConfiguration.disableIPv6OnWifi = true;
    localRTCConfiguration.maxIPv6Networks = 0;
    localRTCConfiguration.audioJitterBufferMaxPackets = 18;
    localRTCConfiguration.audioJitterBufferFastAccelerate = true;
    localRTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
    this.mObserverProxy.addObserver(this.mPcObserver);
    this.mPeerConnection = this.mPeerConnectionFactory.createPeerConnection(localRTCConfiguration, this.mObserverProxy);
    this.mStatisticsHelper = new StatisticsHelper(this.mPeerConnection, this.mPeerConnectionTracker);
    this.mPeerConnectionTracker.trackPeerConnection(this.mPeerConnection, localRTCConfiguration, null);
  }

  private void ensureCompletionCallback(BasicRTCCall.Completion paramCompletion)
  {
    if (paramCompletion == null)
      throw new IllegalStateException("Completion cannot be null");
  }

  private void ensurePeerConnection()
  {
    if (this.mPeerConnection == null)
      throw new IllegalStateException("PeerConnection uninitialized");
  }

  private void ensureSdpCallback(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    if (paramSdpExtendedCallback == null)
      throw new IllegalStateException("SdpCallback cannot be null");
  }

  private static void forwardActionTo(Handler paramHandler, Runnable paramRunnable)
  {
    if (Thread.currentThread() == paramHandler.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    paramHandler.post(paramRunnable);
  }

  private void generateAnswer(final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpExtendedCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    MediaConstraints localMediaConstraints = prepareMediaConstraints();
    this.mPeerConnectionTracker.trackCreateAnswer(localMediaConstraints);
    this.mPeerConnection.createAnswer(new SdpResultObserver(this.mHandler, new BasicRTCCall.CreateCallback()
    {
      public void onFailure()
      {
        ViberRTCConfCall.this.mPeerConnectionTracker.trackCreateAnswerCallback(null, null, "createAnswer failed");
        paramSdpExtendedCallback.onError();
      }

      public void onSuccess(SessionDescription paramAnonymousSessionDescription)
      {
        ViberRTCConfCall.this.checkOnHandlerThread();
        ViberRTCConfCall.this.mPeerConnectionTracker.trackCreateAnswerCallback(paramAnonymousSessionDescription.type.toString(), paramAnonymousSessionDescription.description, null);
        if (ViberRTCConfCall.this.mPeerConnection == null)
        {
          paramSdpExtendedCallback.onError();
          return;
        }
        ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescription(paramAnonymousSessionDescription.type.toString(), paramAnonymousSessionDescription.description, true);
        ViberRTCConfCall.this.mPeerConnection.setLocalDescription(new ViberRTCConfCall.SdpResultObserver(ViberRTCConfCall.this.mHandler, new BasicRTCCall.SetCallback()
        {
          public void onFailure()
          {
            ViberRTCConfCall.4.this.val$cb.onError();
            if (ViberRTCConfCall.this.mPeerConnection != null)
              ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(ViberRTCConfCall.this.mPeerConnection.getLocalDescription().type.toString(), ViberRTCConfCall.this.mPeerConnection.getLocalDescription().description, "failed to set local description", true);
          }

          public void onSuccess()
          {
            if (ViberRTCConfCall.this.mPeerConnection == null)
            {
              ViberRTCConfCall.4.this.val$cb.onError();
              return;
            }
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            Iterator localIterator = ViberRTCConfCall.this.mPeerConnection.getSenders().iterator();
            while (localIterator.hasNext())
            {
              RtpSender localRtpSender = (RtpSender)localIterator.next();
              if (localRtpSender.track().kind().equals("audio"))
                localArrayList1.add(localRtpSender.track().id());
              else if (localRtpSender.track().kind().equals("video"))
                localArrayList2.add(localRtpSender.track().id());
            }
            ViberRTCConfCall.4.this.val$cb.ready(ViberRTCConfCall.this.mPeerConnection.getLocalDescription().description, localArrayList1, localArrayList2);
            ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(ViberRTCConfCall.this.mPeerConnection.getLocalDescription().type.toString(), ViberRTCConfCall.this.mPeerConnection.getLocalDescription().description, null, true);
          }
        }
        , "generateAnswer :failed to set local description"), paramAnonymousSessionDescription);
      }
    }
    , "generateAnswer sdp create failed"), localMediaConstraints);
    this.mPeerConnectionTracker.trackCreateAnswer(localMediaConstraints);
  }

  private static String generateStreamId(String paramString)
  {
    return paramString + UUID.randomUUID().toString();
  }

  private AudioTrack getAudioTrack()
  {
    checkOnHandlerThread();
    if ((this.mLocalMediaStream != null) && (this.mLocalMediaStream.audioTracks.size() > 0))
      return (AudioTrack)this.mLocalMediaStream.audioTracks.get(0);
    return null;
  }

  private static String getRandomID()
  {
    return Long.toHexString(0xFFFFFFFF & new SecureRandom().nextInt() | (0xFFFFFFFF & System.currentTimeMillis() / 1000L) << 32);
  }

  private void holdWithCompletion(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    removeAudioTrack();
    generateOffer(paramSdpExtendedCallback);
  }

  private MediaConstraints prepareMediaConstraints()
  {
    MediaConstraints localMediaConstraints = new MediaConstraints();
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "false"));
    return localMediaConstraints;
  }

  private void removeAudioTrack()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    while (this.mLocalMediaStream == null)
      return;
    Iterator localIterator = Collections.unmodifiableList(this.mLocalMediaStream.audioTracks).iterator();
    while (localIterator.hasNext())
    {
      AudioTrack localAudioTrack = (AudioTrack)localIterator.next();
      this.mLocalMediaStream.removeTrack(localAudioTrack);
    }
    removeEmptyLocalStreams();
  }

  private void removeEmptyLocalStreams()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    while ((this.mLocalMediaStream == null) || (this.mLocalMediaStream.audioTracks.size() != 0) || (this.mLocalMediaStream.videoTracks.size() != 0))
      return;
    this.mPeerConnection.removeStream(this.mLocalMediaStream);
    this.mPeerConnectionTracker.trackRemoveStream(this.mLocalMediaStream.getId(), true);
    this.mLocalMediaStream.dispose();
    this.mLocalMediaStream = null;
  }

  private void resolveCollidingPeerOffer(final String paramString, final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    applySdpAnswer(paramString, null, new BasicRTCCall.Completion()
    {
      public void onFailure()
      {
        paramSdpExtendedCallback.onError();
      }

      public void onSuccess()
      {
        ViberRTCConfCall.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            ViberRTCConfCall.this.applySdpOffer(ViberRTCConfCall.6.this.val$remoteSdp, ViberRTCConfCall.6.this.val$onProcessed, true);
          }
        });
      }
    });
  }

  private void unholdWithCompletion(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    addAudioTrack("audioTrackId_");
    generateOffer(paramSdpExtendedCallback);
  }

  public void addPcObserver(PeerConnection.Observer paramObserver)
  {
    this.mObserverProxy.addObserver(paramObserver);
  }

  public void applySdpAnswer(String paramString1, String paramString2, final BasicRTCCall.Completion paramCompletion)
  {
    checkOnHandlerThread();
    ensureCompletionCallback(paramCompletion);
    if (this.mPeerConnection == null)
    {
      paramCompletion.onFailure();
      return;
    }
    if ((this.mPeerConnection.signalingState() == PeerConnection.SignalingState.HAVE_LOCAL_OFFER) && (paramString2 != null) && (!this.mPeerConnection.getLocalDescription().description.equals(paramString2)))
    {
      paramCompletion.onSuccess();
      return;
    }
    final SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.ANSWER, paramString1);
    this.mPeerConnectionTracker.trackSetSessionDescription(localSessionDescription.type.toString(), localSessionDescription.description, false);
    this.mPeerConnection.setRemoteDescription(new SdpResultObserver(this.mHandler, new BasicRTCCall.SetCallback()
    {
      public void onFailure()
      {
        ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, "applyPeerAnswer(sdpAnswer, sdpOffer): onFailure remote answer!", false);
        paramCompletion.onFailure();
      }

      public void onSuccess()
      {
        ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, null, false);
        paramCompletion.onSuccess();
      }
    }
    , "applyPeerAnswer(sdpAnswer, sdpOffer): onFailure remote answer!"), localSessionDescription);
  }

  public void applySdpOffer(String paramString, final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback, boolean paramBoolean)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpExtendedCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    if (this.mPeerConnection.signalingState() == PeerConnection.SignalingState.HAVE_LOCAL_OFFER);
    for (int i = 1; (i != 0) && (paramBoolean); i = 0)
    {
      resolveCollidingPeerOffer(paramString, paramSdpExtendedCallback);
      return;
    }
    final SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.OFFER, paramString);
    this.mPeerConnectionTracker.trackSetSessionDescription(localSessionDescription.type.toString(), localSessionDescription.description, false);
    this.mPeerConnection.setRemoteDescription(new SdpResultObserver(this.mHandler, new BasicRTCCall.SetCallback()
    {
      public void onFailure()
      {
        ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, "applyPeerOffer(sdpOffer): onFailure remote offer!", false);
        paramSdpExtendedCallback.onError();
      }

      public void onSuccess()
      {
        ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, null, false);
        ViberRTCConfCall.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            ViberRTCConfCall.this.generateAnswer(ViberRTCConfCall.1.this.val$completion);
          }
        });
      }
    }
    , "applyPeerOffer(sdpOffer): onFailure remote offer!"), localSessionDescription);
  }

  public void createDataChannel(String paramString, DataChannel.Init paramInit, BasicRTCCall.DataChannelCallback paramDataChannelCallback)
  {
    paramDataChannelCallback.onCreated(this.mPeerConnection.createDataChannel(paramString, paramInit));
  }

  public void deinitCall()
  {
    checkOnHandlerThread();
    this.mPeerConnectionTracker.trackStop();
    this.mObserverProxy.removeAll();
    if (this.mStatisticsHelper != null)
    {
      this.mStatisticsHelper.dispose();
      this.mStatisticsHelper = null;
    }
    if (this.mPeerConnection != null)
    {
      this.mPeerConnection.dispose();
      this.mPeerConnection = null;
    }
    if (this.mPeerConnectionFactory != null)
    {
      this.mPeerConnectionFactory.dispose();
      this.mPeerConnectionFactory = null;
    }
    if (this.mDelegate != null)
    {
      this.mPeerConnectionTracker.trackCallToken(this.mDelegate.getCurrentCallToken(), this.mDelegate.getCurrentConferenceId());
      this.mPeerConnectionTracker.save(this.mDelegate.getCurrentCallToken(), new IPeerConnectionTracker.CompletionCallback()
      {
        public void onComplete(String paramAnonymousString1, String paramAnonymousString2)
        {
        }
      });
    }
  }

  public void generateOffer(final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpExtendedCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    createOffer(new BasicRTCCall.CreateCallback()
    {
      public void onFailure()
      {
        paramSdpExtendedCallback.onError();
      }

      public void onSuccess(SessionDescription paramAnonymousSessionDescription)
      {
        ViberRTCConfCall.this.checkOnHandlerThread();
        if (ViberRTCConfCall.this.mPeerConnection == null)
        {
          paramSdpExtendedCallback.onError();
          return;
        }
        ViberRTCConfCall.this.mPeerConnection.setLocalDescription(new ViberRTCConfCall.SdpResultObserver(ViberRTCConfCall.this.mHandler, new BasicRTCCall.SetCallback()
        {
          public void onFailure()
          {
            if (ViberRTCConfCall.this.mPeerConnection != null)
              ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(ViberRTCConfCall.this.mPeerConnection.getLocalDescription().type.toString(), ViberRTCConfCall.this.mPeerConnection.getLocalDescription().description, "failed to set local description", true);
            ViberRTCConfCall.3.this.val$cb.onError();
          }

          public void onSuccess()
          {
            if (ViberRTCConfCall.this.mPeerConnection == null)
            {
              ViberRTCConfCall.3.this.val$cb.onError();
              return;
            }
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            Iterator localIterator = ViberRTCConfCall.this.mPeerConnection.getSenders().iterator();
            while (localIterator.hasNext())
            {
              RtpSender localRtpSender = (RtpSender)localIterator.next();
              if (localRtpSender.track().kind().equals("audio"))
                localArrayList1.add(localRtpSender.id());
              else if (localRtpSender.track().kind().equals("video"))
                localArrayList2.add(localRtpSender.id());
            }
            ViberRTCConfCall.3.this.val$cb.ready(ViberRTCConfCall.this.mPeerConnection.getLocalDescription().description, localArrayList1, localArrayList2);
            ViberRTCConfCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(ViberRTCConfCall.this.mPeerConnection.getLocalDescription().type.toString(), ViberRTCConfCall.this.mPeerConnection.getLocalDescription().description, null, true);
          }
        }
        , "generateOffer :failed to set local description"), paramAnonymousSessionDescription);
      }
    });
  }

  public void localHoldWithCompletion(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    if (this.mLocalHold)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    this.mLocalHold = true;
    if (this.mPeerHold)
    {
      paramSdpExtendedCallback.ready("", Collections.emptyList(), Collections.emptyList());
      return;
    }
    holdWithCompletion(paramSdpExtendedCallback);
  }

  public void localUnholdWithCompletion(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    if (!this.mLocalHold)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    this.mLocalHold = false;
    if (this.mPeerHold)
    {
      paramSdpExtendedCallback.ready("", Collections.emptyList(), Collections.emptyList());
      return;
    }
    unholdWithCompletion(paramSdpExtendedCallback);
  }

  public void mute()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    while (true)
    {
      return;
      this.mMuted = true;
      Iterator localIterator = this.mPeerConnection.getSenders().iterator();
      while (localIterator.hasNext())
      {
        MediaStreamTrack localMediaStreamTrack = ((RtpSender)localIterator.next()).track();
        if ((localMediaStreamTrack != null) && ("audio".equals(localMediaStreamTrack.kind())))
          localMediaStreamTrack.setEnabled(false);
      }
    }
  }

  public void startGatherStats()
  {
    if (this.mStatisticsHelper != null)
      this.mStatisticsHelper.maybeScheduleStreamStatistics(null);
  }

  public void startOutgoingCall(BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpExtendedCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpExtendedCallback.onError();
      return;
    }
    generateOffer(paramSdpExtendedCallback);
  }

  public void unmute()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    while (true)
    {
      return;
      this.mMuted = false;
      Iterator localIterator = this.mPeerConnection.getSenders().iterator();
      while (localIterator.hasNext())
      {
        MediaStreamTrack localMediaStreamTrack = ((RtpSender)localIterator.next()).track();
        if ((localMediaStreamTrack != null) && ("audio".equals(localMediaStreamTrack.kind())))
          localMediaStreamTrack.setEnabled(true);
      }
    }
  }

  private class PCObserver extends ViberRTCConfCall.ProxiedPCObserver
  {
    private PCObserver()
    {
      super(null);
    }

    public void onAddStream(MediaStream paramMediaStream)
    {
      try
      {
        ViberRTCConfCall.this.mPeerConnectionTracker.trackAddStream(paramMediaStream.getId(), false);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream)
    {
      int i = paramArrayOfMediaStream.length;
      for (int j = 0; j < i; j++)
        paramArrayOfMediaStream[j];
    }

    public void onDataChannel(DataChannel paramDataChannel)
    {
      ViberRTCConfCall.this.mPeerConnectionTracker.trackCreateDataChannel(paramDataChannel.label(), false);
    }

    public void onIceCandidate(IceCandidate paramIceCandidate)
    {
      ViberRTCConfCall.this.mPeerConnectionTracker.trackAddIceCandidate(paramIceCandidate, true, true);
    }

    public void onIceCandidatesRemoved(IceCandidate[] paramArrayOfIceCandidate)
    {
      if (paramArrayOfIceCandidate == null);
      while (true)
      {
        return;
        int i = paramArrayOfIceCandidate.length;
        for (int j = 0; j < i; j++)
          paramArrayOfIceCandidate[j];
      }
    }

    public void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState)
    {
      ViberRTCConfCall.this.mPeerConnectionTracker.trackIceConnectionStateChange(paramIceConnectionState);
    }

    public void onIceConnectionReceivingChange(boolean paramBoolean)
    {
    }

    public void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState)
    {
      ViberRTCConfCall.this.mPeerConnectionTracker.trackIceGatheringStateChange(paramIceGatheringState);
    }

    public void onRemoveStream(MediaStream paramMediaStream)
    {
      try
      {
        ViberRTCConfCall.this.mPeerConnectionTracker.trackRemoveStream(paramMediaStream.getId(), false);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void onRenegotiationNeeded()
    {
      ViberRTCConfCall.this.mPeerConnectionTracker.trackOnRenegotiationNeeded();
    }

    public void onSignalingChange(PeerConnection.SignalingState paramSignalingState)
    {
      ViberRTCConfCall.this.mPeerConnectionTracker.trackSignalingStateChange(paramSignalingState);
    }
  }

  private class ProxiedPCObserver
    implements PeerConnection.Observer
  {
    private List<PeerConnection.Observer> mObservers = new CopyOnWriteArrayList();

    private ProxiedPCObserver()
    {
    }

    public void addObserver(PeerConnection.Observer paramObserver)
    {
      this.mObservers.add(paramObserver);
    }

    public void onAddStream(MediaStream paramMediaStream)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onAddStream(paramMediaStream);
    }

    public void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onAddTrack(paramRtpReceiver, paramArrayOfMediaStream);
    }

    public void onDataChannel(DataChannel paramDataChannel)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onDataChannel(paramDataChannel);
    }

    public void onIceCandidate(IceCandidate paramIceCandidate)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onIceCandidate(paramIceCandidate);
    }

    public void onIceCandidatesRemoved(IceCandidate[] paramArrayOfIceCandidate)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onIceCandidatesRemoved(paramArrayOfIceCandidate);
    }

    public void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onIceConnectionChange(paramIceConnectionState);
    }

    public void onIceConnectionReceivingChange(boolean paramBoolean)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onIceConnectionReceivingChange(paramBoolean);
    }

    public void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onIceGatheringChange(paramIceGatheringState);
    }

    public void onRemoveStream(MediaStream paramMediaStream)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onRemoveStream(paramMediaStream);
    }

    public void onRenegotiationNeeded()
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onRenegotiationNeeded();
    }

    public void onSignalingChange(PeerConnection.SignalingState paramSignalingState)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext())
        ((PeerConnection.Observer)localIterator.next()).onSignalingChange(paramSignalingState);
    }

    public void onTrack(RtpTransceiver paramRtpTransceiver)
    {
      PeerConnection.Observer..CC.onTrack(this, paramRtpTransceiver);
    }

    public void removeAll()
    {
      this.mObservers.clear();
    }
  }

  private static final class SdpResultObserver
    implements SdpObserver
  {
    private final Handler mHandler;
    private final BasicRTCCall.CreateCallback mOnCreated;
    private final String mOnErrorMsg;
    private final BasicRTCCall.SetCallback mOnSet;

    SdpResultObserver(Handler paramHandler, BasicRTCCall.CreateCallback paramCreateCallback, String paramString)
    {
      this.mHandler = paramHandler;
      this.mOnErrorMsg = paramString;
      this.mOnCreated = paramCreateCallback;
      this.mOnSet = null;
    }

    SdpResultObserver(Handler paramHandler, BasicRTCCall.SetCallback paramSetCallback, String paramString)
    {
      this.mHandler = paramHandler;
      this.mOnErrorMsg = paramString;
      this.mOnSet = paramSetCallback;
      this.mOnCreated = null;
    }

    public void onCreateFailure(String paramString)
    {
      if (this.mOnCreated == null)
        return;
      ViberRTCConfCall.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberRTCConfCall.SdpResultObserver.this.mOnCreated.onFailure();
        }
      });
    }

    public void onCreateSuccess(SessionDescription paramSessionDescription)
    {
      if (this.mOnCreated == null)
        return;
      ViberRTCConfCall.forwardActionTo(this.mHandler, new ViberRTCConfCall.SdpResultObserver..Lambda.0(this, paramSessionDescription));
    }

    public void onSetFailure(String paramString)
    {
      if (this.mOnSet == null)
        return;
      ViberRTCConfCall.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberRTCConfCall.SdpResultObserver.this.mOnSet.onFailure();
        }
      });
    }

    public void onSetSuccess()
    {
      if (this.mOnSet == null)
        return;
      ViberRTCConfCall.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberRTCConfCall.SdpResultObserver.this.mOnSet.onSuccess();
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ViberRTCConfCall
 * JD-Core Version:    0.6.2
 */