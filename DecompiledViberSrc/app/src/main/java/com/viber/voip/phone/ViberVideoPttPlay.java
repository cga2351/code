package com.viber.voip.phone;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.phone.vptt.VideoPttPlayer;
import com.viber.voip.phone.vptt.VideoPttPlayer.Completion;
import com.viber.voip.phone.vptt.VideoPttPlayerProxy;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.util.at;
import com.viber.voip.widget.d.a;
import com.viber.voip.widget.d.c;
import java.io.File;
import java.util.Collections;
import java.util.List;
import org.webrtc.DataChannel;
import org.webrtc.EglBase;
import org.webrtc.EglBase..CC;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaConstraints.KeyValuePair;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.BundlePolicy;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.Observer..CC;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnection.RtcpMuxPolicy;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.PeerConnection.TcpCandidatePolicy;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.PeerConnectionFactory.Builder;
import org.webrtc.PeerConnectionFactory.Options;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoSink;
import org.webrtc.VideoTrack;
import org.webrtc.videoengine.ViberRTCWorkarounds;

public final class ViberVideoPttPlay
  implements VideoPttPlayer
{
  private static final Logger L = ViberEnv.getLogger();
  private final Context mContext;
  private final Handler mHandler;
  private boolean mIsDisposed;
  private PeerConnectionObserver mPcObserver;
  private PeerConnection mPeerConnection;
  private PeerConnectionFactory mPeerConnectionFactory;
  private NativeVideoPttPlayer mPlayer;
  private VideoTrack mRemoteVideoTrack;
  private EglBase mRootEglBase;
  private final Handler mUiHandler;
  private int seq;

  private ViberVideoPttPlay(Handler paramHandler1, Handler paramHandler2, Context paramContext)
  {
    if (paramHandler2 == null)
      throw new IllegalArgumentException("handler");
    if (paramHandler1 == null)
      throw new IllegalArgumentException("uiHandler");
    if (paramContext == null)
      throw new IllegalStateException("context");
    this.mHandler = paramHandler2;
    this.mUiHandler = paramHandler1;
    this.mContext = paramContext;
  }

  private void SetOfferSdp(String paramString1, final String paramString2, final SetCallback paramSetCallback, final VideoPttPlayer.Completion paramCompletion)
  {
    checkOnHandlerThread();
    if (this.mPeerConnection == null)
    {
      paramCompletion.onCompletion(new Error("No peer connection"));
      return;
    }
    this.mPlayer.setRemoteSdp(paramString1);
    SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.OFFER, paramString1);
    this.mPeerConnection.setRemoteDescription(new SdpResultObserver(this.mHandler, new SetCallback()
    {
      public void onSuccess()
      {
        ViberVideoPttPlay.this.checkOnHandlerThread();
        if (ViberVideoPttPlay.this.mPeerConnection == null)
        {
          paramCompletion.onCompletion(new Error("No peer connection after remote SDP is set"));
          return;
        }
        com.viber.jni.webrtc.IceCandidate localIceCandidate = ViberVideoPttPlay.this.mPlayer.getIceCandidate();
        if (localIceCandidate != null)
          ViberVideoPttPlay.this.mPeerConnection.addIceCandidate(new org.webrtc.IceCandidate(localIceCandidate.sdpMid, localIceCandidate.sdpMLineIndex, localIceCandidate.sdp));
        MediaConstraints localMediaConstraints = ViberVideoPttPlay.access$1200();
        ViberVideoPttPlay.this.mPeerConnection.createAnswer(new ViberVideoPttPlay.SdpResultObserver(ViberVideoPttPlay.this.mHandler, new ViberVideoPttPlay.CreateCallback()
        {
          public void onSuccess(SessionDescription paramAnonymous2SessionDescription)
          {
            ViberVideoPttPlay.this.checkOnHandlerThread();
            if (ViberVideoPttPlay.this.mPeerConnection == null)
            {
              ViberVideoPttPlay.1.this.val$onErrorCompletion.onCompletion(new Error("No peer connection after local SDP is set"));
              return;
            }
            ViberVideoPttPlay.this.mPeerConnection.setLocalDescription(new ViberVideoPttPlay.SdpResultObserver(ViberVideoPttPlay.this.mHandler, ViberVideoPttPlay.1.this.val$successCallback, ViberVideoPttPlay.1.this.val$methodName + ", startWithRemoteSdp, onSetFailure setLocalDescription", ViberVideoPttPlay.1.this.val$onErrorCompletion), paramAnonymous2SessionDescription);
          }
        }
        , paramString2 + ", startWithRemoteSdp, onCreateFailure answer create", paramCompletion), localMediaConstraints);
      }
    }
    , paramString2 + ", startWithRemoteSdp, onSetFailure remote offer", paramCompletion), localSessionDescription);
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

  public static VideoPttPlayer create(Handler paramHandler)
  {
    ViberRTCWorkarounds.initParentContextSupported();
    Handler localHandler = av.a(av.e.e);
    return new VideoPttPlayerProxy(new ViberVideoPttPlay(paramHandler, localHandler, ViberApplication.getApplication()), localHandler);
  }

  private void disposeNativeObjectsAndStopPlay()
  {
    checkOnHandlerThread();
    if (((this.mPlayer == null) || (this.mPlayer.stopSendData())) || (this.mPeerConnection != null))
    {
      this.mPeerConnection.dispose();
      this.mPeerConnection = null;
    }
    if (this.mPeerConnectionFactory != null)
    {
      this.mPeerConnectionFactory.dispose();
      this.mPeerConnectionFactory = null;
    }
    if (this.mPlayer != null)
    {
      this.mPlayer.dispose();
      this.mPlayer = null;
    }
    if (this.mRootEglBase != null)
    {
      this.mRootEglBase.release();
      this.mRootEglBase = null;
    }
    this.mPcObserver = null;
    this.mIsDisposed = true;
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

  public static void getPreview(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramString.isEmpty()));
    while (!at.a(new File(paramString)))
      return;
    ViberApplication.getInstance().logToCrashlytics("Video Ptt Get Preview");
    handleVideoPttGetPreview(paramString, paramBundle);
  }

  private static native void handleVideoPttGetPreview(String paramString, Bundle paramBundle);

  private static MediaConstraints prepareMediaConstraints()
  {
    MediaConstraints localMediaConstraints = new MediaConstraints();
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("VoiceActivityDetection", "true"));
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("IceRestart", "false"));
    return localMediaConstraints;
  }

  public void dispose()
  {
    checkOnHandlerThread();
    disposeNativeObjectsAndStopPlay();
  }

  public void restartUnmuted(final VideoPttPlayer.Completion paramCompletion)
  {
    checkOnHandlerThread();
    if (this.mPlayer == null)
    {
      paramCompletion.onCompletion(new Error("No player"));
      return;
    }
    if (!this.mPlayer.restartVideoPtt())
    {
      paramCompletion.onCompletion(new Error("Native player failed to restart"));
      return;
    }
    SetOfferSdp(this.mPlayer.generateSdp(false), "ViberVideoPttPlay.restartUnmuted", new SetCallback()
    {
      public void onSuccess()
      {
        paramCompletion.onCompletion(null);
      }
    }
    , paramCompletion);
  }

  public void startVideoPttPlay(int paramInt, String paramString, final a parama, boolean paramBoolean, final VideoPttPlayer.Completion paramCompletion1, VideoPttPlayer.Completion paramCompletion2)
  {
    checkOnHandlerThread();
    if (paramString == null)
      throw new IllegalStateException("pttPath");
    if (parama == null)
      throw new IllegalArgumentException("surfaceView");
    if (paramCompletion1 == null)
      throw new IllegalStateException("startedCompletion");
    if (paramCompletion2 == null)
      throw new IllegalStateException("stoppedCompletion");
    if (this.mIsDisposed)
    {
      paramCompletion1.onCompletion(new Error("Is already stopped"));
      return;
    }
    PlayDelegate localPlayDelegate = new PlayDelegate(null);
    this.mPlayer = NativeVideoPttPlayer.create(paramString, paramInt, localPlayDelegate);
    if (this.mPlayer == null)
    {
      paramCompletion1.onCompletion(new Error("creation of VideoPttNativePlayer failed"));
      return;
    }
    this.seq = paramInt;
    localPlayDelegate.setStartedCallback(paramCompletion1);
    localPlayDelegate.setStoppedCallback(paramCompletion2);
    localPlayDelegate.setErrorCallback(paramCompletion2);
    WebRTCInitializer.ensureInitialized();
    PeerConnectionFactory.Options localOptions = new PeerConnectionFactory.Options();
    localOptions.disableEncryption = true;
    localOptions.disableNetworkMonitor = true;
    localOptions.networkIgnoreMask = 15;
    this.mPeerConnectionFactory = PeerConnectionFactory.builder().setOptions(localOptions).setVideoEncoderFactory(ViberRTCWorkarounds.getEncoderFactory(this.mRootEglBase)).setVideoDecoderFactory(ViberRTCWorkarounds.getVideoPttDecoderFactory(this.mRootEglBase)).createPeerConnectionFactory();
    this.mPcObserver = new PeerConnectionObserver(parama);
    PeerConnection.RTCConfiguration localRTCConfiguration = new PeerConnection.RTCConfiguration(Collections.EMPTY_LIST);
    localRTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
    localRTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
    localRTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.BALANCED;
    MediaConstraints localMediaConstraints = new MediaConstraints();
    localMediaConstraints.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "false"));
    this.mPeerConnection = this.mPeerConnectionFactory.createPeerConnection(localRTCConfiguration, localMediaConstraints, this.mPcObserver);
    this.mRootEglBase = EglBase..CC.create$$STATIC$$();
    try
    {
      ThreadUtils.invokeAtFrontUninterruptibly(this.mUiHandler, new Runnable()
      {
        public void run()
        {
          ((c)parama.getView()).init(ViberRTCWorkarounds.getEglBaseContext(ViberVideoPttPlay.this.mRootEglBase), null);
        }
      });
      SetOfferSdp(this.mPlayer.generateSdp(paramBoolean), "ViberVideoPttPlay.startVideoPttPlay", new SetCallback()
      {
        public void onSuccess()
        {
          ViberVideoPttPlay.forwardActionTo(ViberVideoPttPlay.this.mHandler, new Runnable()
          {
            public void run()
            {
              ViberVideoPttPlay.this.checkOnHandlerThread();
              if (ViberVideoPttPlay.this.mPlayer == null)
                ViberVideoPttPlay.3.this.val$startedCompletion.onCompletion(new Error("ViberVideoPttPlay.startVideoPttPlay, onSuccess for setLocalDescription native players is disposed"));
            }
          });
        }
      }
      , paramCompletion1);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      disposeNativeObjectsAndStopPlay();
      paramCompletion1.onCompletion(new Error("surfaceView init failed with runtime exception: " + localRuntimeException.toString()));
    }
  }

  public void stopVideoPttPlay(VideoPttPlayer.Completion paramCompletion)
  {
    checkOnHandlerThread();
    ViberApplication.getInstance().getSoundService().cleanupAudioRoute();
    disposeNativeObjectsAndStopPlay();
    paramCompletion.onCompletion(null);
  }

  private static abstract interface CreateCallback
  {
    public abstract void onSuccess(SessionDescription paramSessionDescription);
  }

  private static final class NativePlayDelegate
  {
    final ViberVideoPttPlay.PlayDelegate mDelegate;

    public NativePlayDelegate(ViberVideoPttPlay.PlayDelegate paramPlayDelegate)
    {
      this.mDelegate = paramPlayDelegate;
    }

    public void onError(int paramInt)
    {
      this.mDelegate.notifyError(new Error("Error from native code on stopped completion: " + Integer.toString(paramInt)));
    }

    public void onRestarted()
    {
    }

    public void onStarted()
    {
      this.mDelegate.notifyStarted();
    }

    public void onStopped()
    {
      this.mDelegate.notifyStopped();
    }
  }

  private static final class NativeVideoPttPlayer
  {
    final ViberVideoPttPlay.PlayDelegate mDelegate;
    long nativeHandlers;
    long nativePlayer;

    private NativeVideoPttPlayer(long paramLong, ViberVideoPttPlay.PlayDelegate paramPlayDelegate)
    {
      if (paramLong == 0L)
        throw new IllegalArgumentException("nativePlayer is null");
      this.nativePlayer = paramLong;
      this.mDelegate = paramPlayDelegate;
    }

    public static NativeVideoPttPlayer create(String paramString, int paramInt, ViberVideoPttPlay.PlayDelegate paramPlayDelegate)
    {
      long l = nativeCreatePlayer(paramString, paramInt, new ViberVideoPttPlay.NativePlayDelegate(paramPlayDelegate));
      if (l == 0L)
        return null;
      return new NativeVideoPttPlayer(l, paramPlayDelegate);
    }

    private void ensureNotDisposed()
    {
      if (this.nativePlayer == 0L)
        throw new IllegalStateException("object is disposed");
    }

    private static native long nativeCreatePlayer(String paramString, int paramInt, ViberVideoPttPlay.NativePlayDelegate paramNativePlayDelegate);

    private static native boolean nativeDisposePlayer(long paramLong);

    private static native String nativeGenerateVideoPttSdp(boolean paramBoolean);

    private static native com.viber.jni.webrtc.IceCandidate nativeGetIceCandidate(long paramLong);

    private static native boolean nativeRestartVideoPtt(long paramLong);

    private static native boolean nativeSetRemoteSdp(long paramLong, String paramString);

    private static native boolean nativeStartSendData(long paramLong);

    private static native boolean nativeStopSendData(long paramLong);

    public void dispose()
    {
      if (this.nativePlayer != 0L)
      {
        nativeDisposePlayer(this.nativePlayer);
        this.nativeHandlers = 0L;
        this.nativePlayer = 0L;
      }
    }

    public String generateSdp(boolean paramBoolean)
    {
      ensureNotDisposed();
      return nativeGenerateVideoPttSdp(paramBoolean);
    }

    public com.viber.jni.webrtc.IceCandidate getIceCandidate()
    {
      ensureNotDisposed();
      return nativeGetIceCandidate(this.nativePlayer);
    }

    public boolean restartVideoPtt()
    {
      ensureNotDisposed();
      return nativeRestartVideoPtt(this.nativePlayer);
    }

    public boolean setRemoteSdp(String paramString)
    {
      ensureNotDisposed();
      return nativeSetRemoteSdp(this.nativePlayer, paramString);
    }

    public boolean startSendData()
    {
      ensureNotDisposed();
      return nativeStartSendData(this.nativePlayer);
    }

    public boolean stopSendData()
    {
      ensureNotDisposed();
      return nativeStopSendData(this.nativePlayer);
    }
  }

  private class PeerConnectionObserver
    implements PeerConnection.Observer
  {
    VideoSink remoteRenderer;
    a remoteView;

    public PeerConnectionObserver(a arg2)
    {
      Object localObject;
      this.remoteView = localObject;
    }

    public void onAddStream(MediaStream paramMediaStream)
    {
      if ((paramMediaStream != null) && (paramMediaStream.videoTracks != null) && (paramMediaStream.videoTracks.size() == 1))
      {
        ViberVideoPttPlay.access$402(ViberVideoPttPlay.this, (VideoTrack)paramMediaStream.videoTracks.get(0));
        ViberVideoPttPlay.this.mRemoteVideoTrack.setEnabled(true);
        if (this.remoteView != null)
          this.remoteRenderer = ((c)this.remoteView.getView());
      }
      try
      {
        ViberVideoPttPlay.this.mRemoteVideoTrack.addSink(this.remoteRenderer);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        ViberVideoPttPlay.L.a(localRuntimeException, "ViberVideoPttPlay, video track has 0 native");
        this.remoteRenderer = null;
      }
    }

    public void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream)
    {
    }

    public void onDataChannel(DataChannel paramDataChannel)
    {
    }

    public void onIceCandidate(org.webrtc.IceCandidate paramIceCandidate)
    {
    }

    public void onIceCandidatesRemoved(org.webrtc.IceCandidate[] paramArrayOfIceCandidate)
    {
    }

    public void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState)
    {
      switch (ViberVideoPttPlay.5.$SwitchMap$org$webrtc$PeerConnection$IceConnectionState[paramIceConnectionState.ordinal()])
      {
      default:
        return;
      case 1:
      }
      ViberVideoPttPlay.forwardActionTo(ViberVideoPttPlay.this.mHandler, new Runnable()
      {
        public void run()
        {
          if ((ViberVideoPttPlay.this.mPlayer != null) && (!ViberVideoPttPlay.this.mPlayer.startSendData()))
            ViberVideoPttPlay.this.disposeNativeObjectsAndStopPlay();
        }
      });
    }

    public void onIceConnectionReceivingChange(boolean paramBoolean)
    {
    }

    public void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState)
    {
    }

    public void onRemoveStream(MediaStream paramMediaStream)
    {
      if (ViberVideoPttPlay.this.mRemoteVideoTrack != null)
      {
        ViberVideoPttPlay.this.mRemoteVideoTrack.dispose();
        ViberVideoPttPlay.access$402(ViberVideoPttPlay.this, null);
      }
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
  }

  private static final class PlayDelegate
  {
    private VideoPttPlayer.Completion mErrorCallback;
    private VideoPttPlayer.Completion mStartedCallback;
    private VideoPttPlayer.Completion mStoppedCallback;

    public void notifyError(Error paramError)
    {
      if (this.mErrorCallback != null)
        this.mErrorCallback.onCompletion(paramError);
    }

    public void notifyStarted()
    {
      ViberApplication.getInstance().logToCrashlytics("Video Ptt Player Started");
      ViberApplication.getInstance().getSoundService().prepareVideoPttAudioRoute();
      if (this.mStartedCallback != null)
        this.mStartedCallback.onCompletion(null);
    }

    public void notifyStopped()
    {
      if (this.mStoppedCallback != null)
        this.mStoppedCallback.onCompletion(null);
    }

    public void reset()
    {
      this.mErrorCallback = null;
      this.mStartedCallback = null;
      this.mStoppedCallback = null;
    }

    public void setErrorCallback(VideoPttPlayer.Completion paramCompletion)
    {
      this.mErrorCallback = paramCompletion;
    }

    public void setStartedCallback(VideoPttPlayer.Completion paramCompletion)
    {
      this.mStartedCallback = paramCompletion;
    }

    public void setStoppedCallback(VideoPttPlayer.Completion paramCompletion)
    {
      this.mStoppedCallback = paramCompletion;
    }
  }

  private static final class SdpResultObserver
    implements SdpObserver
  {
    private final VideoPttPlayer.Completion completion;
    private final Handler mHandler;
    private final ViberVideoPttPlay.CreateCallback mOnCreated;
    private final String mOnErrorMsg;
    private final ViberVideoPttPlay.SetCallback mOnSet;

    SdpResultObserver(Handler paramHandler, ViberVideoPttPlay.CreateCallback paramCreateCallback, String paramString, VideoPttPlayer.Completion paramCompletion)
    {
      this.mHandler = paramHandler;
      this.mOnCreated = paramCreateCallback;
      this.mOnErrorMsg = paramString;
      this.mOnSet = null;
      this.completion = paramCompletion;
    }

    SdpResultObserver(Handler paramHandler, ViberVideoPttPlay.SetCallback paramSetCallback, String paramString, VideoPttPlayer.Completion paramCompletion)
    {
      this.mHandler = paramHandler;
      this.mOnSet = paramSetCallback;
      this.mOnCreated = null;
      this.mOnErrorMsg = paramString;
      this.completion = paramCompletion;
    }

    public void onCreateFailure(final String paramString)
    {
      if (this.completion == null)
        return;
      ViberVideoPttPlay.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttPlay.SdpResultObserver.this.completion.onCompletion(new Error(ViberVideoPttPlay.SdpResultObserver.this.mOnErrorMsg + ": " + paramString));
        }
      });
    }

    public void onCreateSuccess(final SessionDescription paramSessionDescription)
    {
      if (this.mOnCreated == null)
        return;
      ViberVideoPttPlay.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttPlay.SdpResultObserver.this.mOnCreated.onSuccess(paramSessionDescription);
        }
      });
    }

    public void onSetFailure(final String paramString)
    {
      if (this.completion == null)
        return;
      ViberVideoPttPlay.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttPlay.SdpResultObserver.this.completion.onCompletion(new Error(ViberVideoPttPlay.SdpResultObserver.this.mOnErrorMsg + ": " + paramString));
        }
      });
    }

    public void onSetSuccess()
    {
      if (this.mOnSet == null)
        return;
      ViberVideoPttPlay.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttPlay.SdpResultObserver.this.mOnSet.onSuccess();
        }
      });
    }
  }

  private static abstract interface SetCallback
  {
    public abstract void onSuccess();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.ViberVideoPttPlay
 * JD-Core Version:    0.6.2
 */