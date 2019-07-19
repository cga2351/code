package com.viber.voip.phone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.b;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.webrtc.AudioTrack;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.CameraVideoCapturer.CameraSwitchHandler;
import org.webrtc.DataChannel;
import org.webrtc.DtmfSender;
import org.webrtc.EglBase;
import org.webrtc.EglBase..CC;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaConstraints.KeyValuePair;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.AdapterType;
import org.webrtc.PeerConnection.BundlePolicy;
import org.webrtc.PeerConnection.CandidateNetworkPolicy;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.Observer..CC;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnection.RtcpMuxPolicy;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.PeerConnection.TcpCandidatePolicy;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.videoengine.ViberRTCWorkarounds;

public final class ViberRTCCall
  implements RTCCall
{
  private static final String AUDIO_TRACK_ID = "audioTrackId";
  private static final boolean ENABLE_PEER_CONNECTION_TRACKER = false;
  private static final Logger L = ViberEnv.getLogger();
  private static final String MEDIA_STREAM_TRACK_KIND_AUDIO = "audio";
  private static final String MEDIA_STREAM_TRACK_KIND_VIDEO = "video";
  private static final String VIDEO_TRACK_ID = "videoTrackId";
  private String mAudioSenderId;
  private final BasicRTCCall.RTCCallDelegate mDelegate;
  private final Handler mHandler;
  private boolean mIsViberOut = false;
  private boolean mLocalHold = false;
  private MediaStream mLocalMediaStream;
  private CameraVideoCapturer mLocalVideoCapturer;
  private AtomicReference<VideoRenderingPair> mLocalVideoRenderer = new AtomicReference();
  private boolean mMuted = false;
  private final PCObserver mPcObserver = new PCObserver(null);
  private final HashMap<Integer, String> mPeerAnswers = new HashMap();
  private PeerConnection mPeerConnection;
  private PeerConnectionFactory mPeerConnectionFactory;
  private IPeerConnectionTracker mPeerConnectionTracker = PeerConnectionTrackerFactory.newPeerConnectionTracker(true);
  private boolean mPeerHold = false;
  private final List<com.viber.jni.webrtc.IceCandidate> mPeerIceCandidates = new ArrayList();
  private AtomicReference<VideoRenderingPair> mRemoteVideoRenderer = new AtomicReference();
  private MediaStreamTrack mReplacedAudioTrack;
  private EglBase mRootEglBase;
  private final Set<com.viber.jni.webrtc.IceCandidate> mSelfIceCandidates = new HashSet();
  private boolean mStarted = false;
  private StatisticsHelper mStatisticsHelper;
  private SurfaceTextureHelper mSurfaceTextureHelper;

  private ViberRTCCall(Handler paramHandler, Context paramContext, BasicRTCCall.RTCCallDelegate paramRTCCallDelegate)
  {
    this.mHandler = paramHandler;
    this.mRootEglBase = EglBase..CC.create$$STATIC$$();
    this.mDelegate = paramRTCCallDelegate;
    this.mPeerConnectionTracker.trackHostApplicationInfo(paramRTCCallDelegate);
    forwardActionTo(paramHandler, new ViberRTCCall..Lambda.0(this));
  }

  private void addAudioTrack()
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
    AudioTrack localAudioTrack = this.mPeerConnectionFactory.createAudioTrack("audioTrackId", this.mPeerConnectionFactory.createAudioSource(new MediaConstraints()));
    if (!this.mMuted);
    while (true)
    {
      localAudioTrack.setEnabled(bool);
      this.mLocalMediaStream.addTrack(localAudioTrack);
      this.mAudioSenderId = getSenderByTrackId("audioTrackId").id();
      return;
      bool = false;
    }
  }

  private void addRendererToLocalVideoTrack(VideoRenderingPair paramVideoRenderingPair)
  {
    checkOnHandlerThread();
    if (paramVideoRenderingPair == null);
    label8: VideoTrack localVideoTrack;
    do
    {
      Iterator localIterator;
      do
      {
        MediaStream localMediaStream;
        do
        {
          return;
          break label8;
          while (paramVideoRenderingPair.isAlreadyInTrack());
          localMediaStream = this.mLocalMediaStream;
        }
        while (localMediaStream == null);
        localIterator = localMediaStream.videoTracks.iterator();
      }
      while (!localIterator.hasNext());
      localVideoTrack = (VideoTrack)localIterator.next();
    }
    while (!localVideoTrack.id().equals("videoTrackId"));
    paramVideoRenderingPair.addVideoTrack(localVideoTrack);
  }

  private void addRendererToRemoteVideoTrack(VideoRenderingPair paramVideoRenderingPair)
  {
    if (paramVideoRenderingPair == null);
    VideoTrack localVideoTrack;
    do
    {
      do
        return;
      while (paramVideoRenderingPair.isAlreadyInTrack());
      localVideoTrack = this.mPcObserver.getRemoteVideoTrack();
    }
    while (localVideoTrack == null);
    paramVideoRenderingPair.addVideoTrack(localVideoTrack);
  }

  private void addVideoTrack(Context paramContext)
  {
    checkOnHandlerThread();
    ensurePeerConnection();
    if (getVideoTrack() != null);
    do
    {
      return;
      if (this.mLocalVideoCapturer == null)
        this.mLocalVideoCapturer = createVideoCapturer(paramContext);
    }
    while (this.mLocalVideoCapturer == null);
    AudioTrack localAudioTrack1 = getAudioTrack();
    if (localAudioTrack1 != null)
    {
      MediaStream localMediaStream = this.mPeerConnectionFactory.createLocalMediaStream(generateStreamId("media"));
      AudioTrack localAudioTrack2 = this.mPeerConnectionFactory.createAudioTrack("audioTrackId", this.mPeerConnectionFactory.createAudioSource(new MediaConstraints()));
      localMediaStream.addTrack(localAudioTrack2);
      localAudioTrack2.setEnabled(localAudioTrack1.enabled());
      this.mPeerConnection.addStream(localMediaStream);
      this.mPeerConnectionTracker.trackAddStream(localMediaStream.getId(), true);
      if (this.mLocalMediaStream != null)
      {
        this.mPeerConnection.removeStream(this.mLocalMediaStream);
        this.mPeerConnectionTracker.trackRemoveStream(this.mLocalMediaStream.getId(), true);
      }
      this.mLocalMediaStream = localMediaStream;
      this.mAudioSenderId = getSenderByTrackId("audioTrackId").id();
    }
    if (this.mLocalMediaStream == null)
    {
      this.mLocalMediaStream = this.mPeerConnectionFactory.createLocalMediaStream(generateStreamId("media"));
      this.mPeerConnection.addStream(this.mLocalMediaStream);
      this.mPeerConnectionTracker.trackAddStream(this.mLocalMediaStream.getId(), true);
    }
    this.mSurfaceTextureHelper = SurfaceTextureHelper.create("CallCaptureThread", ViberRTCWorkarounds.getEglBaseContext(this.mRootEglBase));
    VideoSource localVideoSource = this.mPeerConnectionFactory.createVideoSource(false);
    this.mLocalVideoCapturer.initialize(this.mSurfaceTextureHelper, paramContext, localVideoSource.getCapturerObserver());
    try
    {
      VideoTrack localVideoTrack = this.mPeerConnectionFactory.createVideoTrack("videoTrackId", localVideoSource);
      this.mLocalMediaStream.addTrack(localVideoTrack);
      this.mLocalVideoCapturer.startCapture(640, 480, 30);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      L.a(localRuntimeException, "ViberRTVCall, video track creation failed");
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

  public static RTCCall create(BasicRTCCall.RTCCallDelegate paramRTCCallDelegate)
  {
    ViberRTCWorkarounds.initParentContextSupported();
    Handler localHandler = av.a(av.e.e);
    return new RTCCallProxy(new ViberRTCCall(localHandler, ViberApplication.getApplication(), paramRTCCallDelegate), localHandler);
  }

  private static CameraVideoCapturer createCameraCapturer(CameraEnumerator paramCameraEnumerator)
  {
    int i = 0;
    CameraVideoCapturer localCameraVideoCapturer;
    for (String str2 : paramCameraEnumerator.getDeviceNames())
      if (paramCameraEnumerator.isFrontFacing(str2))
      {
        localCameraVideoCapturer = paramCameraEnumerator.createCapturer(str2, null);
        if (localCameraVideoCapturer != null)
          return localCameraVideoCapturer;
      }
    int m = ???.length;
    while (true)
    {
      if (i >= m)
        break label111;
      String str1 = ???[i];
      if (!paramCameraEnumerator.isFrontFacing(str1))
      {
        localCameraVideoCapturer = paramCameraEnumerator.createCapturer(str1, null);
        if (localCameraVideoCapturer != null)
          break;
      }
      i++;
    }
    label111: return null;
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
    localRTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
    localRTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
    localRTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.BALANCED;
    localRTCConfiguration.iceCandidatePoolSize = 2;
    localRTCConfiguration.audioJitterBufferMaxPackets = 18;
    localRTCConfiguration.audioJitterBufferFastAccelerate = true;
    localRTCConfiguration.candidateNetworkPolicy = PeerConnection.CandidateNetworkPolicy.LOW_COST;
    localRTCConfiguration.disableIpv6 = true;
    localRTCConfiguration.disableIPv6OnWifi = true;
    localRTCConfiguration.maxIPv6Networks = 0;
    localRTCConfiguration.networkPreference = PeerConnection.AdapterType.LOOPBACK;
    localRTCConfiguration.enableDtlsSrtp = Boolean.valueOf(false);
    this.mPeerConnection = this.mPeerConnectionFactory.createPeerConnection(localRTCConfiguration, this.mPcObserver);
    this.mStatisticsHelper = new StatisticsHelper(this.mPeerConnection, this.mPeerConnectionTracker);
    this.mPeerConnectionTracker.trackPeerConnection(this.mPeerConnection, localRTCConfiguration, null);
  }

  private static CameraVideoCapturer createVideoCapturer(Context paramContext)
  {
    CameraVideoCapturer localCameraVideoCapturer = createCameraCapturer(new Camera1Enumerator(ViberRTCWorkarounds.allowHWAcceleration()));
    if (localCameraVideoCapturer == null)
      localCameraVideoCapturer = null;
    return localCameraVideoCapturer;
  }

  private void destroyVideoCapturer()
  {
    checkOnHandlerThread();
    if (this.mLocalVideoCapturer == null)
      return;
    try
    {
      this.mLocalVideoCapturer.stopCapture();
      this.mLocalVideoCapturer.dispose();
      this.mLocalVideoCapturer = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
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

  private void ensureSdpCallback(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    if (paramSdpCallback == null)
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

  private void generateAnswer(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    MediaConstraints localMediaConstraints = prepareMediaConstraints();
    this.mPeerConnectionTracker.trackCreateAnswer(localMediaConstraints);
    this.mPeerConnection.createAnswer(new SdpResultObserver(this.mHandler, new BasicRTCCall.CreateCallback()
    {
      public void onFailure()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackCreateAnswerCallback(null, null, "createAnswer failed");
        paramSdpCallback.onError();
      }

      public void onSuccess(SessionDescription paramAnonymousSessionDescription)
      {
        ViberRTCCall.this.checkOnHandlerThread();
        if (ViberRTCCall.this.mStarted);
        final SessionDescription localSessionDescription;
        for (SessionDescription.Type localType = SessionDescription.Type.ANSWER; ; localType = SessionDescription.Type.PRANSWER)
        {
          localSessionDescription = new SessionDescription(localType, paramAnonymousSessionDescription.description);
          ViberRTCCall.this.mPeerConnectionTracker.trackCreateAnswerCallback(localSessionDescription.type.toString(), localSessionDescription.description, null);
          if (ViberRTCCall.this.mPeerConnection != null)
            break;
          paramSdpCallback.onError();
          return;
        }
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescription(localSessionDescription.type.toString(), localSessionDescription.description, true);
        ViberRTCCall.this.mPeerConnection.setLocalDescription(new ViberRTCCall.SdpResultObserver(ViberRTCCall.this.mHandler, new BasicRTCCall.SetCallback()
        {
          public void onFailure()
          {
            ViberRTCCall.8.this.val$cb.onError();
            if (ViberRTCCall.this.mPeerConnection != null)
              ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, "failed to set local description", true);
          }

          public void onSuccess()
          {
            if (ViberRTCCall.this.mPeerConnection == null)
            {
              ViberRTCCall.8.this.val$cb.onError();
              return;
            }
            ViberRTCCall.8.this.val$cb.ready(ViberRTCCall.this.mPeerConnection.getLocalDescription().description);
            ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, null, true);
          }
        }
        , "generateAnswer :failed to set local description"), localSessionDescription);
      }
    }
    , "generateAnswer sdp create failed"), localMediaConstraints);
    this.mPeerConnectionTracker.trackCreateAnswer(localMediaConstraints);
  }

  private void generateOffer(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    createOffer(new BasicRTCCall.CreateCallback()
    {
      public void onFailure()
      {
        paramSdpCallback.onError();
      }

      public void onSuccess(final SessionDescription paramAnonymousSessionDescription)
      {
        ViberRTCCall.this.checkOnHandlerThread();
        if (ViberRTCCall.this.mPeerConnection == null)
        {
          paramSdpCallback.onError();
          return;
        }
        ViberRTCCall.this.mPeerConnection.setLocalDescription(new ViberRTCCall.SdpResultObserver(ViberRTCCall.this.mHandler, new BasicRTCCall.SetCallback()
        {
          public void onFailure()
          {
            if (ViberRTCCall.this.mPeerConnection != null)
              ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(paramAnonymousSessionDescription.type.toString(), paramAnonymousSessionDescription.description, "failed to set local description", true);
            ViberRTCCall.7.this.val$cb.onError();
          }

          public void onSuccess()
          {
            if (ViberRTCCall.this.mPeerConnection == null)
            {
              ViberRTCCall.7.this.val$cb.onError();
              return;
            }
            ViberRTCCall.7.this.val$cb.ready(ViberRTCCall.this.mPeerConnection.getLocalDescription().description);
            ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(paramAnonymousSessionDescription.type.toString(), paramAnonymousSessionDescription.description, null, true);
          }
        }
        , "generateOffer :failed to set local description"), paramAnonymousSessionDescription);
      }
    });
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

  private Context getContext()
  {
    return ViberApplication.getApplication();
  }

  private RtpSender getSenderById(String paramString)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
      return null;
    Iterator localIterator = this.mPeerConnection.getSenders().iterator();
    while (localIterator.hasNext())
    {
      RtpSender localRtpSender = (RtpSender)localIterator.next();
      if (localRtpSender.id().equals(paramString))
        return localRtpSender;
    }
    return null;
  }

  private RtpSender getSenderByTrackId(String paramString)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
      return null;
    Iterator localIterator = this.mPeerConnection.getSenders().iterator();
    while (localIterator.hasNext())
    {
      RtpSender localRtpSender = (RtpSender)localIterator.next();
      MediaStreamTrack localMediaStreamTrack = localRtpSender.track();
      if ((localMediaStreamTrack != null) && (localMediaStreamTrack.id().equals(paramString)))
        return localRtpSender;
    }
    return null;
  }

  private VideoTrack getVideoTrack()
  {
    checkOnHandlerThread();
    if ((this.mLocalMediaStream != null) && (this.mLocalMediaStream.videoTracks.size() > 0))
      return (VideoTrack)this.mLocalMediaStream.videoTracks.get(0);
    return null;
  }

  private void holdWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    destroyVideoCapturer();
    VideoRenderingPair localVideoRenderingPair = (VideoRenderingPair)this.mLocalVideoRenderer.getAndSet(null);
    removeRendererFromLocalVideoTrack(localVideoRenderingPair);
    removeVideoTrack();
    if (localVideoRenderingPair != null)
      localVideoRenderingPair.dispose();
    removeAudioTrack();
    generateOffer(paramSdpCallback);
  }

  private void onCallStarted()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
      return;
    trySetRemoteSdp();
    trySendSelfIceCandidates();
    tryConsumePeerIceCandidates();
  }

  // ERROR //
  private static String patchSdp(String paramString)
  {
    // Byte code:
    //   0: new 728	com/viber/jni/SDPProcessor
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 729	com/viber/jni/SDPProcessor:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 732	com/viber/jni/SDPProcessor:generate	()Ljava/lang/String;
    //   13: astore 4
    //   15: aload_1
    //   16: ifnull +7 -> 23
    //   19: aload_1
    //   20: invokevirtual 733	com/viber/jni/SDPProcessor:dispose	()V
    //   23: aload 4
    //   25: areturn
    //   26: astore_2
    //   27: aconst_null
    //   28: astore_1
    //   29: aload_2
    //   30: athrow
    //   31: astore_3
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 733	com/viber/jni/SDPProcessor:dispose	()V
    //   40: aload_3
    //   41: athrow
    //   42: astore_3
    //   43: aconst_null
    //   44: astore_1
    //   45: goto -13 -> 32
    //   48: astore_2
    //   49: goto -20 -> 29
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	26	java/lang/Throwable
    //   9	15	31	finally
    //   29	31	31	finally
    //   0	9	42	finally
    //   9	15	48	java/lang/Throwable
  }

  private MediaConstraints prepareMediaConstraints()
  {
    MediaConstraints localMediaConstraints = new MediaConstraints();
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
    List localList = localMediaConstraints.mandatory;
    if (this.mIsViberOut);
    for (String str = "false"; ; str = "true")
    {
      localList.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", str));
      localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("VoiceActivityDetection", "false"));
      return localMediaConstraints;
    }
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
    this.mPeerConnectionTracker.trackRemoveStream(this.mLocalMediaStream.getId(), true);
    this.mPeerConnection.removeStream(this.mLocalMediaStream);
    this.mLocalMediaStream = null;
  }

  private void removeRendererFromLocalVideoTrack(VideoRenderingPair paramVideoRenderingPair)
  {
    checkOnHandlerThread();
    if (paramVideoRenderingPair == null)
      break label8;
    while (true)
    {
      label8: return;
      if (paramVideoRenderingPair.isAlreadyInTrack())
      {
        MediaStream localMediaStream = this.mLocalMediaStream;
        if (localMediaStream == null)
          break;
        Iterator localIterator = localMediaStream.videoTracks.iterator();
        while (localIterator.hasNext())
        {
          VideoTrack localVideoTrack = (VideoTrack)localIterator.next();
          if (localVideoTrack.id().equals("videoTrackId"))
            paramVideoRenderingPair.removeVideoTrack(localVideoTrack);
        }
      }
    }
  }

  private void removeRendererFromRemoteVideoTrack(VideoRenderingPair paramVideoRenderingPair)
  {
    if (paramVideoRenderingPair == null);
    VideoTrack localVideoTrack;
    do
    {
      do
        return;
      while (!paramVideoRenderingPair.isAlreadyInTrack());
      localVideoTrack = this.mPcObserver.getRemoteVideoTrack();
    }
    while (localVideoTrack == null);
    paramVideoRenderingPair.removeVideoTrack(localVideoTrack);
  }

  private void removeVideoTrack()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    while (this.mLocalMediaStream == null)
      return;
    Iterator localIterator = Collections.unmodifiableList(this.mLocalMediaStream.videoTracks).iterator();
    while (localIterator.hasNext())
    {
      VideoTrack localVideoTrack = (VideoTrack)localIterator.next();
      this.mLocalMediaStream.removeTrack(localVideoTrack);
    }
    removeEmptyLocalStreams();
  }

  private void resetAudioTrack()
  {
    checkOnHandlerThread();
    RtpSender localRtpSender = getSenderById(this.mAudioSenderId);
    if (localRtpSender != null)
    {
      MediaStreamTrack localMediaStreamTrack = localRtpSender.track();
      if (localMediaStreamTrack != null)
      {
        localRtpSender.setTrack(null, false);
        this.mReplacedAudioTrack = localMediaStreamTrack;
      }
    }
  }

  private void resolveCollidingPeerOffer(String paramString, int paramInt, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    applySdpAnswer(paramString, null, new BasicRTCCall.Completion()
    {
      public void onFailure()
      {
        paramSdpCallback.onError();
      }

      public void onSuccess()
      {
        ViberRTCCall.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (ViberRTCCall.this.mPeerConnection == null)
            {
              ViberRTCCall.13.this.val$onProcessed.onError();
              return;
            }
            ViberRTCCall.13.this.val$onProcessed.ready(ViberRTCCall.this.mPeerConnection.getLocalDescription().description);
          }
        });
      }
    });
  }

  private void resolveLegacyCall(final String paramString, final int paramInt, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    applySdpAnswer(paramString, null, new BasicRTCCall.Completion()
    {
      public void onFailure()
      {
        paramSdpCallback.onError();
      }

      public void onSuccess()
      {
        ViberRTCCall.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            ViberRTCCall.this.applySdpOffer(ViberRTCCall.11.this.val$remoteSdp, ViberRTCCall.11.this.val$peerId, new BasicRTCCall.SdpCallback()
            {
              public void onError()
              {
                ViberRTCCall.11.this.val$onProcessed.onError();
              }

              public void ready(String paramAnonymous3String)
              {
                ViberRTCCall.this.onCallStarted();
                ViberRTCCall.11.this.val$onProcessed.ready(paramAnonymous3String);
              }
            });
          }
        });
      }
    });
  }

  private void resolveTalmonFeature(String paramString, int paramInt, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    applyPeerAnswer(paramString, paramInt, new BasicRTCCall.Completion()
    {
      public void onFailure()
      {
        paramSdpCallback.onError();
      }

      public void onSuccess()
      {
        ViberRTCCall.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (ViberRTCCall.this.mPeerConnection == null)
            {
              ViberRTCCall.12.this.val$onProcessed.onError();
              return;
            }
            ViberRTCCall.this.trySetRemoteSdp();
            ViberRTCCall.12.this.val$onProcessed.ready(ViberRTCCall.this.mPeerConnection.getLocalDescription().description);
          }
        });
      }
    });
  }

  private void restoreAudioTrack()
  {
    checkOnHandlerThread();
    RtpSender localRtpSender = getSenderById(this.mAudioSenderId);
    if ((localRtpSender != null) && (this.mReplacedAudioTrack != null))
    {
      localRtpSender.setTrack(this.mReplacedAudioTrack, false);
      this.mReplacedAudioTrack = null;
    }
  }

  private void tryConsumePeerIceCandidates()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    SessionDescription localSessionDescription;
    do
    {
      return;
      localSessionDescription = this.mPeerConnection.getRemoteDescription();
    }
    while ((localSessionDescription == null) || (localSessionDescription.description == null) || (this.mPeerIceCandidates.size() <= 0));
    Iterator localIterator = this.mPeerIceCandidates.iterator();
    while (localIterator.hasNext())
    {
      com.viber.jni.webrtc.IceCandidate localIceCandidate = (com.viber.jni.webrtc.IceCandidate)localIterator.next();
      org.webrtc.IceCandidate localIceCandidate1 = new org.webrtc.IceCandidate(localIceCandidate.sdpMid, localIceCandidate.sdpMLineIndex, localIceCandidate.sdp);
      boolean bool = this.mPeerConnection.addIceCandidate(localIceCandidate1);
      this.mPeerConnectionTracker.trackAddIceCandidate(localIceCandidate1, false, bool);
    }
    this.mPeerIceCandidates.clear();
  }

  private void trySendSelfIceCandidates()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    SessionDescription localSessionDescription;
    do
    {
      return;
      localSessionDescription = this.mPeerConnection.getRemoteDescription();
    }
    while ((localSessionDescription == null) || (localSessionDescription.description == null));
    this.mDelegate.sendIceCandidates((com.viber.jni.webrtc.IceCandidate[])this.mSelfIceCandidates.toArray(new com.viber.jni.webrtc.IceCandidate[0]));
  }

  private void trySetRemoteSdp()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    SessionDescription localSessionDescription;
    do
    {
      return;
      localSessionDescription = this.mPeerConnection.getRemoteDescription();
    }
    while ((localSessionDescription == null) || (localSessionDescription.description == null));
    this.mDelegate.onRemoteSdp(localSessionDescription.description);
  }

  private void unholdWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    addAudioTrack();
    generateOffer(paramSdpCallback);
  }

  private boolean useCamera2(Context paramContext)
  {
    return Camera2Enumerator.isSupported(paramContext.getApplicationContext());
  }

  public void addPeerIceCandidate(com.viber.jni.webrtc.IceCandidate paramIceCandidate)
  {
    checkOnHandlerThread();
    if (paramIceCandidate == null)
      throw new IllegalStateException("ice");
    this.mPeerIceCandidates.add(paramIceCandidate);
    tryConsumePeerIceCandidates();
  }

  public void applyPeerAnswer(String paramString, int paramInt, final BasicRTCCall.Completion paramCompletion)
  {
    checkOnHandlerThread();
    ensureCompletionCallback(paramCompletion);
    if (this.mStarted)
      applySdpAnswer(paramString, null, new BasicRTCCall.Completion()
      {
        public void onFailure()
        {
          paramCompletion.onFailure();
        }

        public void onSuccess()
        {
          if (ViberRTCCall.this.mStarted)
            ViberRTCCall.this.onCallStarted();
          paramCompletion.onSuccess();
        }
      });
    while (this.mPeerAnswers.containsValue(paramString))
      return;
    this.mPeerAnswers.put(Integer.valueOf(paramInt), paramString);
    final SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.PRANSWER, paramString);
    this.mPeerConnectionTracker.trackSetSessionDescription(localSessionDescription.type.toString(), localSessionDescription.description, false);
    this.mPeerConnection.setRemoteDescription(new SdpResultObserver(this.mHandler, new BasicRTCCall.SetCallback()
    {
      public void onFailure()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, "Failed to set remote pre answer!", false);
        paramCompletion.onFailure();
      }

      public void onSuccess()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, null, false);
        paramCompletion.onSuccess();
      }
    }
    , "Failed to set remote pre answer"), localSessionDescription);
  }

  public void applyPeerOffer(String paramString, int paramInt, boolean paramBoolean, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    PeerConnection.SignalingState localSignalingState = this.mPeerConnection.signalingState();
    if ((localSignalingState == PeerConnection.SignalingState.HAVE_LOCAL_OFFER) || (localSignalingState == PeerConnection.SignalingState.HAVE_REMOTE_PRANSWER))
    {
      if (paramBoolean)
      {
        resolveLegacyCall(paramString, paramInt, paramSdpCallback);
        return;
      }
      resolveTalmonFeature(paramString, paramInt, paramSdpCallback);
      return;
    }
    applySdpOffer(paramString, paramInt, new BasicRTCCall.SdpCallback()
    {
      public void onError()
      {
        paramSdpCallback.onError();
      }

      public void ready(String paramAnonymousString)
      {
        if (ViberRTCCall.this.mStarted)
          ViberRTCCall.this.onCallStarted();
        paramSdpCallback.ready(paramAnonymousString);
      }
    });
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
    if (g.a().a(a.b.k))
      paramString1 = patchSdp(paramString1);
    final SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.ANSWER, paramString1);
    this.mPeerConnectionTracker.trackSetSessionDescription(localSessionDescription.type.toString(), localSessionDescription.description, false);
    this.mPeerConnection.setRemoteDescription(new SdpResultObserver(this.mHandler, new BasicRTCCall.SetCallback()
    {
      public void onFailure()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, "applyPeerAnswer(sdpAnswer, sdpOffer): onFailure remote answer!", false);
        paramCompletion.onFailure();
      }

      public void onSuccess()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, null, false);
        paramCompletion.onSuccess();
      }
    }
    , "applyPeerAnswer(sdpAnswer, sdpOffer): onFailure remote answer!"), localSessionDescription);
  }

  public void applySdpOffer(String paramString, int paramInt, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    if (g.a().a(a.b.k))
      paramString = patchSdp(paramString);
    if (this.mPeerConnection.signalingState() == PeerConnection.SignalingState.HAVE_LOCAL_OFFER)
    {
      resolveCollidingPeerOffer(paramString, paramInt, paramSdpCallback);
      return;
    }
    final SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.OFFER, paramString);
    this.mPeerConnectionTracker.trackSetSessionDescription(localSessionDescription.type.toString(), localSessionDescription.description, false);
    this.mPeerConnection.setRemoteDescription(new SdpResultObserver(this.mHandler, new BasicRTCCall.SetCallback()
    {
      public void onFailure()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, "applySdpOffer(sdpOffer): onFailure remote offer!", false);
        paramSdpCallback.onError();
      }

      public void onSuccess()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, null, false);
        ViberRTCCall.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            ViberRTCCall.this.generateAnswer(ViberRTCCall.4.this.val$completion);
          }
        });
      }
    }
    , "applySdpOffer(sdpOffer): onFailure remote offer!"), localSessionDescription);
  }

  public void deinitCall()
  {
    checkOnHandlerThread();
    this.mPeerConnectionTracker.trackStop();
    destroyVideoCapturer();
    if (this.mStatisticsHelper != null)
    {
      this.mStatisticsHelper.dispose();
      this.mStatisticsHelper = null;
    }
    VideoRenderingPair localVideoRenderingPair1 = (VideoRenderingPair)this.mLocalVideoRenderer.getAndSet(null);
    removeRendererFromLocalVideoTrack(localVideoRenderingPair1);
    if (localVideoRenderingPair1 != null)
      localVideoRenderingPair1.dispose();
    VideoRenderingPair localVideoRenderingPair2 = (VideoRenderingPair)this.mRemoteVideoRenderer.getAndSet(null);
    removeRendererFromRemoteVideoTrack(localVideoRenderingPair2);
    if (localVideoRenderingPair2 != null)
      localVideoRenderingPair2.dispose();
    if (this.mSurfaceTextureHelper != null)
    {
      this.mSurfaceTextureHelper.dispose();
      this.mSurfaceTextureHelper = null;
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
      this.mPeerConnectionTracker.save(this.mDelegate.getCurrentCallToken(), ViberRTCCall..Lambda.2.$instance);
    }
  }

  public void finalizeTransfer(BasicRTCCall.Completion paramCompletion)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramCompletion.onFailure();
      return;
    }
    if (this.mPeerConnection.signalingState() != PeerConnection.SignalingState.STABLE)
    {
      paramCompletion.onFailure();
      return;
    }
    paramCompletion.onSuccess();
    trySetRemoteSdp();
  }

  public int getCameraCount(Context paramContext)
  {
    if (useCamera2(paramContext))
      return new Camera2Enumerator(paramContext).getDeviceNames().length;
    return new Camera1Enumerator(ViberRTCWorkarounds.allowHWAcceleration()).getDeviceNames().length;
  }

  public SurfaceViewRenderer getLocalVideo(Context paramContext)
  {
    VideoRenderingPair localVideoRenderingPair = (VideoRenderingPair)this.mLocalVideoRenderer.get();
    if (localVideoRenderingPair == null)
    {
      localVideoRenderingPair = VideoRenderingPair.tryCreate(paramContext, this.mRootEglBase);
      this.mLocalVideoRenderer.set(localVideoRenderingPair);
      forwardActionTo(this.mHandler, new ViberRTCCall..Lambda.1(this, localVideoRenderingPair));
    }
    if (localVideoRenderingPair != null)
    {
      localVideoRenderingPair.getView().setMirror(true);
      return localVideoRenderingPair.getView();
    }
    return null;
  }

  public void getOffer(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    createOffer(new BasicRTCCall.CreateCallback()
    {
      public void onFailure()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackCreateOfferCallback(null, null, "failed to create offer");
        paramSdpCallback.onError();
      }

      public void onSuccess(SessionDescription paramAnonymousSessionDescription)
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackCreateOfferCallback(paramAnonymousSessionDescription.type.toString(), paramAnonymousSessionDescription.description, null);
        paramSdpCallback.ready(paramAnonymousSessionDescription.description);
      }
    });
  }

  public SurfaceViewRenderer getRemoteVideo(Context paramContext)
  {
    VideoRenderingPair localVideoRenderingPair = (VideoRenderingPair)this.mRemoteVideoRenderer.get();
    if (localVideoRenderingPair == null)
    {
      localVideoRenderingPair = VideoRenderingPair.tryCreate(paramContext, this.mRootEglBase);
      addRendererToRemoteVideoTrack(localVideoRenderingPair);
      this.mRemoteVideoRenderer.set(localVideoRenderingPair);
    }
    if (localVideoRenderingPair != null)
      return localVideoRenderingPair.getView();
    return null;
  }

  public void localHoldWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    if (this.mLocalHold)
    {
      paramSdpCallback.onError();
      return;
    }
    this.mLocalHold = true;
    if (this.mPeerHold)
    {
      paramSdpCallback.ready("");
      return;
    }
    holdWithCompletion(paramSdpCallback);
  }

  public void localUnholdWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    if (!this.mLocalHold)
    {
      paramSdpCallback.onError();
      return;
    }
    this.mLocalHold = false;
    if (this.mPeerHold)
    {
      paramSdpCallback.ready("");
      return;
    }
    unholdWithCompletion(paramSdpCallback);
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

  public void peerHoldWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    if (this.mPeerHold)
    {
      paramSdpCallback.onError();
      return;
    }
    this.mPeerHold = true;
    if (this.mLocalHold)
    {
      paramSdpCallback.ready("");
      return;
    }
    holdWithCompletion(paramSdpCallback);
  }

  public void peerUnholdWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    if (!this.mPeerHold)
    {
      paramSdpCallback.onError();
      return;
    }
    this.mPeerHold = false;
    if (this.mLocalHold)
    {
      paramSdpCallback.ready("");
      return;
    }
    unholdWithCompletion(paramSdpCallback);
  }

  public void sendDtmf(String paramString, int paramInt)
  {
    checkOnHandlerThread();
    if (this.mMuted);
    DtmfSender localDtmfSender;
    do
    {
      RtpSender localRtpSender;
      do
      {
        return;
        localRtpSender = getSenderByTrackId("audioTrackId");
      }
      while (localRtpSender == null);
      localDtmfSender = localRtpSender.dtmf();
    }
    while ((localDtmfSender == null) || (!localDtmfSender.canInsertDtmf()) || (localDtmfSender.insertDtmf(paramString, paramInt, localDtmfSender.interToneGap())));
  }

  public void startCall(int paramInt)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    PeerConnection.SignalingState localSignalingState;
    do
    {
      String str;
      do
      {
        do
          return;
        while (this.mStarted);
        this.mStarted = true;
        restoreAudioTrack();
        if (this.mStatisticsHelper != null)
          this.mStatisticsHelper.maybeScheduleStreamStatistics(null);
        localSignalingState = this.mPeerConnection.signalingState();
        if (localSignalingState != PeerConnection.SignalingState.HAVE_REMOTE_PRANSWER)
          break;
        str = (String)this.mPeerAnswers.get(Integer.valueOf(paramInt));
      }
      while ((str == null) || (str.isEmpty()));
      applyPeerAnswer(str, paramInt, new BasicRTCCall.Completion()
      {
        public void onFailure()
        {
        }

        public void onSuccess()
        {
        }
      });
      return;
    }
    while (localSignalingState != PeerConnection.SignalingState.HAVE_LOCAL_PRANSWER);
    final SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.ANSWER, this.mPeerConnection.getLocalDescription().description);
    this.mPeerConnectionTracker.trackSetSessionDescription(localSessionDescription.type.toString(), localSessionDescription.description, true);
    this.mPeerConnection.setLocalDescription(new SdpResultObserver(this.mHandler, new BasicRTCCall.SetCallback()
    {
      public void onFailure()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, "Failed to set local answer!", true);
      }

      public void onSuccess()
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackSetSessionDescriptionCallback(localSessionDescription.type.toString(), localSessionDescription.description, null, true);
      }
    }
    , "Failed to set local answer"), localSessionDescription);
  }

  public void startOutgoingCall(boolean paramBoolean1, boolean paramBoolean2, BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    this.mIsViberOut = paramBoolean2;
    if (paramBoolean1)
      addVideoTrack(getContext());
    addAudioTrack();
    generateOffer(paramSdpCallback);
  }

  public void startRecvVideo(Context paramContext)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    while (true)
    {
      return;
      Iterator localIterator = this.mPeerConnection.getReceivers().iterator();
      while (localIterator.hasNext())
        ((RtpReceiver)localIterator.next()).track();
    }
  }

  public void startSendVideoWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    if ((this.mLocalHold) || (this.mPeerHold))
    {
      paramSdpCallback.onError();
      return;
    }
    if (getVideoTrack() != null)
    {
      paramSdpCallback.ready("");
      return;
    }
    addVideoTrack(getContext());
    if (getVideoTrack() != null)
    {
      addRendererToLocalVideoTrack((VideoRenderingPair)this.mLocalVideoRenderer.get());
      generateOffer(paramSdpCallback);
      return;
    }
    paramSdpCallback.onError();
  }

  public void stopRecvVideo()
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null);
    VideoRenderingPair localVideoRenderingPair;
    do
    {
      return;
      localVideoRenderingPair = (VideoRenderingPair)this.mRemoteVideoRenderer.getAndSet(null);
      removeRendererFromRemoteVideoTrack(localVideoRenderingPair);
    }
    while (localVideoRenderingPair == null);
    localVideoRenderingPair.dispose();
  }

  public void stopSendVideoWithCompletion(BasicRTCCall.SdpCallback paramSdpCallback)
  {
    checkOnHandlerThread();
    ensureSdpCallback(paramSdpCallback);
    if (this.mPeerConnection == null)
    {
      paramSdpCallback.onError();
      return;
    }
    if ((this.mLocalHold) || (this.mPeerHold))
    {
      paramSdpCallback.onError();
      return;
    }
    destroyVideoCapturer();
    VideoRenderingPair localVideoRenderingPair = (VideoRenderingPair)this.mLocalVideoRenderer.getAndSet(null);
    removeRendererFromLocalVideoTrack(localVideoRenderingPair);
    VideoTrack localVideoTrack = getVideoTrack();
    int i = 0;
    if (localVideoTrack != null)
    {
      removeVideoTrack();
      i = 1;
    }
    if (localVideoRenderingPair != null)
      localVideoRenderingPair.dispose();
    if (i != 0)
    {
      generateOffer(paramSdpCallback);
      return;
    }
    paramSdpCallback.ready("");
  }

  public void switchCamera()
  {
    checkOnHandlerThread();
    if (this.mLocalVideoCapturer != null)
      this.mLocalVideoCapturer.switchCamera(new CameraVideoCapturer.CameraSwitchHandler()
      {
        public void onCameraSwitchDone(boolean paramAnonymousBoolean)
        {
          ViberRTCCall.VideoRenderingPair localVideoRenderingPair = (ViberRTCCall.VideoRenderingPair)ViberRTCCall.this.mLocalVideoRenderer.get();
          if ((localVideoRenderingPair != null) && (localVideoRenderingPair.getView() != null))
            localVideoRenderingPair.getView().setMirror(paramAnonymousBoolean);
        }

        public void onCameraSwitchError(String paramAnonymousString)
        {
        }
      });
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

  private class PCObserver
    implements PeerConnection.Observer
  {
    private ViberRTCCall.StreamBoundedRemoteVideoTrack mRemoteVideoTrack;

    private PCObserver()
    {
    }

    private void onRemoteVideoTrackAdded(VideoTrack paramVideoTrack, String paramString)
    {
      if (this.mRemoteVideoTrack != null)
      {
        ViberRTCCall.this.removeRendererFromRemoteVideoTrack((ViberRTCCall.VideoRenderingPair)ViberRTCCall.this.mRemoteVideoRenderer.get());
        this.mRemoteVideoTrack = null;
      }
      this.mRemoteVideoTrack = new ViberRTCCall.StreamBoundedRemoteVideoTrack(paramVideoTrack, paramString);
      ViberRTCCall.this.addRendererToRemoteVideoTrack((ViberRTCCall.VideoRenderingPair)ViberRTCCall.this.mRemoteVideoRenderer.get());
    }

    public VideoTrack getRemoteVideoTrack()
    {
      try
      {
        ViberRTCCall.StreamBoundedRemoteVideoTrack localStreamBoundedRemoteVideoTrack = this.mRemoteVideoTrack;
        VideoTrack localVideoTrack1;
        if (localStreamBoundedRemoteVideoTrack != null)
          localVideoTrack1 = localStreamBoundedRemoteVideoTrack.getTrack();
        for (VideoTrack localVideoTrack2 = localVideoTrack1; ; localVideoTrack2 = null)
          return localVideoTrack2;
      }
      finally
      {
      }
    }

    public void onAddStream(MediaStream paramMediaStream)
    {
      try
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackAddStream(paramMediaStream.getId(), false);
        if (paramMediaStream.videoTracks.size() > 0)
          onRemoteVideoTrackAdded((VideoTrack)paramMediaStream.videoTracks.get(0), paramMediaStream.getId());
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
      VideoTrack localVideoTrack;
      if ((paramRtpReceiver.track() instanceof VideoTrack))
      {
        localVideoTrack = (VideoTrack)paramRtpReceiver.track();
        if (paramArrayOfMediaStream.length <= 0)
          break label64;
      }
      label64: for (String str = paramArrayOfMediaStream[0].getId(); ; str = "")
      {
        onRemoteVideoTrackAdded(localVideoTrack, str);
        return;
      }
    }

    public void onDataChannel(DataChannel paramDataChannel)
    {
      ViberRTCCall.this.mPeerConnectionTracker.trackCreateDataChannel(paramDataChannel.label(), false);
    }

    public void onIceCandidate(org.webrtc.IceCandidate paramIceCandidate)
    {
      ViberRTCCall.this.mPeerConnectionTracker.trackAddIceCandidate(paramIceCandidate, true, true);
    }

    public void onIceCandidatesRemoved(org.webrtc.IceCandidate[] paramArrayOfIceCandidate)
    {
    }

    public void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState)
    {
      ViberRTCCall.this.mPeerConnectionTracker.trackIceConnectionStateChange(paramIceConnectionState);
    }

    public void onIceConnectionReceivingChange(boolean paramBoolean)
    {
    }

    public void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState)
    {
      ViberRTCCall.this.mPeerConnectionTracker.trackIceGatheringStateChange(paramIceGatheringState);
    }

    public void onRemoveStream(MediaStream paramMediaStream)
    {
      try
      {
        ViberRTCCall.this.mPeerConnectionTracker.trackRemoveStream(paramMediaStream.getId(), false);
        if ((this.mRemoteVideoTrack != null) && (paramMediaStream.videoTracks.size() > 0) && (paramMediaStream.getId().equals(this.mRemoteVideoTrack.getStreamLabel())))
        {
          ViberRTCCall.this.removeRendererFromRemoteVideoTrack((ViberRTCCall.VideoRenderingPair)ViberRTCCall.this.mRemoteVideoRenderer.get());
          this.mRemoteVideoTrack = null;
        }
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
      ViberRTCCall.this.mPeerConnectionTracker.trackOnRenegotiationNeeded();
    }

    public void onSignalingChange(final PeerConnection.SignalingState paramSignalingState)
    {
      ViberRTCCall.this.mPeerConnectionTracker.trackSignalingStateChange(paramSignalingState);
      ViberRTCCall.forwardActionTo(ViberRTCCall.this.mHandler, new Runnable()
      {
        public void run()
        {
          if ((paramSignalingState == PeerConnection.SignalingState.HAVE_LOCAL_PRANSWER) || (paramSignalingState == PeerConnection.SignalingState.HAVE_REMOTE_PRANSWER))
          {
            ViberRTCCall.this.resetAudioTrack();
            ViberRTCCall.this.trySetRemoteSdp();
            ViberRTCCall.this.trySendSelfIceCandidates();
            ViberRTCCall.this.tryConsumePeerIceCandidates();
          }
        }
      });
    }

    public void onTrack(RtpTransceiver paramRtpTransceiver)
    {
      PeerConnection.Observer..CC.onTrack(this, paramRtpTransceiver);
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
      ViberRTCCall.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberRTCCall.SdpResultObserver.this.mOnCreated.onFailure();
        }
      });
    }

    public void onCreateSuccess(SessionDescription paramSessionDescription)
    {
      if (this.mOnCreated == null)
        return;
      ViberRTCCall.forwardActionTo(this.mHandler, new ViberRTCCall.SdpResultObserver..Lambda.0(this, paramSessionDescription));
    }

    public void onSetFailure(String paramString)
    {
      if (this.mOnSet == null)
        return;
      ViberRTCCall.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberRTCCall.SdpResultObserver.this.mOnSet.onFailure();
        }
      });
    }

    public void onSetSuccess()
    {
      if (this.mOnSet == null)
        return;
      ViberRTCCall.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberRTCCall.SdpResultObserver.this.mOnSet.onSuccess();
        }
      });
    }
  }

  private static final class StreamBoundedRemoteVideoTrack
  {
    private final String streamLabel;
    private final VideoTrack track;

    public StreamBoundedRemoteVideoTrack(VideoTrack paramVideoTrack, String paramString)
    {
      if (paramVideoTrack == null)
        throw new IllegalArgumentException("track");
      if ((paramString == null) || (paramString.isEmpty()))
        throw new IllegalArgumentException("streamLabel");
      this.track = paramVideoTrack;
      this.streamLabel = paramString;
    }

    public String getStreamLabel()
    {
      return this.streamLabel;
    }

    public VideoTrack getTrack()
    {
      return this.track;
    }

    public String toString()
    {
      return "StreamBoundedRemoteVideoTrack{streamLabel='" + this.streamLabel + '\'' + ", track=VideoTrack(id=" + this.track.id() + ", toString=" + this.track.toString() + ")" + '}';
    }
  }

  private static class VideoRenderingPair
  {
    private boolean disposed;
    private VideoSink mSink;
    private final SurfaceViewRenderer view;

    private VideoRenderingPair(SurfaceViewRenderer paramSurfaceViewRenderer)
    {
      if (paramSurfaceViewRenderer == null)
        throw new IllegalArgumentException("view");
      this.view = paramSurfaceViewRenderer;
    }

    private void dispose()
    {
      if (this.disposed)
        return;
      this.disposed = true;
      if (this.mSink != null)
        this.mSink = null;
      this.view.release();
    }

    private void ensureNotDisposed()
    {
      if (this.disposed)
        throw new IllegalStateException("object is already disposed");
    }

    // ERROR //
    public static VideoRenderingPair tryCreate(Context paramContext, EglBase paramEglBase)
    {
      // Byte code:
      //   0: new 34	org/webrtc/SurfaceViewRenderer
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 50	org/webrtc/SurfaceViewRenderer:<init>	(Landroid/content/Context;)V
      //   8: astore_2
      //   9: aload_2
      //   10: aload_1
      //   11: invokestatic 56	org/webrtc/videoengine/ViberRTCWorkarounds:getEglBaseContext	(Lorg/webrtc/EglBase;)Lorg/webrtc/EglBase$Context;
      //   14: aconst_null
      //   15: invokevirtual 60	org/webrtc/SurfaceViewRenderer:init	(Lorg/webrtc/EglBase$Context;Lorg/webrtc/RendererCommon$RendererEvents;)V
      //   18: aload_2
      //   19: getstatic 66	org/webrtc/RendererCommon$ScalingType:SCALE_ASPECT_FILL	Lorg/webrtc/RendererCommon$ScalingType;
      //   22: invokevirtual 70	org/webrtc/SurfaceViewRenderer:setScalingType	(Lorg/webrtc/RendererCommon$ScalingType;)V
      //   25: new 2	com/viber/voip/phone/ViberRTCCall$VideoRenderingPair
      //   28: dup
      //   29: aload_2
      //   30: invokespecial 72	com/viber/voip/phone/ViberRTCCall$VideoRenderingPair:<init>	(Lorg/webrtc/SurfaceViewRenderer;)V
      //   33: astore 5
      //   35: aload 5
      //   37: areturn
      //   38: astore 6
      //   40: aconst_null
      //   41: astore 4
      //   43: aload 4
      //   45: ifnull +8 -> 53
      //   48: aload 4
      //   50: invokevirtual 37	org/webrtc/SurfaceViewRenderer:release	()V
      //   53: aconst_null
      //   54: areturn
      //   55: astore_3
      //   56: aload_2
      //   57: astore 4
      //   59: goto -16 -> 43
      //
      // Exception table:
      //   from	to	target	type
      //   0	9	38	java/lang/Throwable
      //   9	35	55	java/lang/Throwable
    }

    public void addVideoTrack(VideoTrack paramVideoTrack)
    {
      ensureNotDisposed();
      if (this.mSink != null)
        throw new IllegalStateException("renderer is already added to some track");
      this.mSink = getView();
      try
      {
        paramVideoTrack.addSink(this.mSink);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        ViberRTCCall.L.a(localRuntimeException, "ViberRTCCall, video track has 0 native");
        this.mSink = null;
      }
    }

    public SurfaceViewRenderer getView()
    {
      ensureNotDisposed();
      return this.view;
    }

    public boolean isAlreadyInTrack()
    {
      return this.mSink != null;
    }

    public void removeVideoTrack(VideoTrack paramVideoTrack)
    {
      ensureNotDisposed();
      if (this.mSink == null)
        throw new IllegalStateException("renderer is not yet created or already disposed ");
      this.mSink = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.ViberRTCCall
 * JD-Core Version:    0.6.2
 */