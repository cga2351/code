package com.viber.voip.phone;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.vptt.VideoPttRecord;
import com.viber.voip.phone.vptt.VideoPttRecord.Completion;
import com.viber.voip.phone.vptt.VideoPttRecord.StopCompletion;
import com.viber.voip.util.e.j;
import com.viber.voip.widget.d.a;
import com.viber.voip.widget.d.c;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerationAndroid.CaptureFormat;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.DataChannel;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer.FrameListener;
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
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.videoengine.ViberRTCWorkarounds;

public class ViberVideoPttRecord
  implements VideoPttRecord
{
  private static final Logger L = ViberEnv.getLogger();
  private RtpSender mAudioSender;
  private AudioSource mAudioSource;
  private VideoCapturer mCapturer;
  private final Handler mHandler;
  private AtomicReference<byte[]> mJpegPreview = new AtomicReference();
  private VideoSink mLocalRender;
  private a mLocalView;
  private PeerConnection mPeerConnection;
  private PeerConnectionFactory mPeerConnectionFactory;
  private NativeVideoPttRecorder mRecorder;
  private final EglBase mRootEglBase;
  private SurfaceTextureHelper mSurfaceTextureHelper;
  private RtpSender mVideoSender;
  private VideoSource mVideoSource;

  public ViberVideoPttRecord(Handler paramHandler, a parama, EglBase paramEglBase)
  {
    if (parama == null)
      throw new IllegalArgumentException("surfaceView");
    if (paramHandler == null)
      throw new IllegalArgumentException("handler");
    if (paramEglBase == null)
      throw new IllegalArgumentException("rootEglBase");
    this.mLocalView = parama;
    this.mRootEglBase = paramEglBase;
    this.mHandler = paramHandler;
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

  private static VideoCapturerWithCaptureResolution createCameraCapturer(CameraEnumerator paramCameraEnumerator)
  {
    int i = 0;
    VideoCapturerWithCaptureResolution localVideoCapturerWithCaptureResolution;
    for (String str2 : paramCameraEnumerator.getDeviceNames())
      if (paramCameraEnumerator.isFrontFacing(str2))
      {
        localVideoCapturerWithCaptureResolution = VideoCapturerWithCaptureResolution.createWithCaptureResolution(paramCameraEnumerator, str2);
        if (localVideoCapturerWithCaptureResolution != null)
          return localVideoCapturerWithCaptureResolution;
      }
    int m = ???.length;
    while (true)
    {
      if (i >= m)
        break label105;
      String str1 = ???[i];
      if (!paramCameraEnumerator.isFrontFacing(str1))
      {
        localVideoCapturerWithCaptureResolution = VideoCapturerWithCaptureResolution.createWithCaptureResolution(paramCameraEnumerator, str1);
        if (localVideoCapturerWithCaptureResolution != null)
          break;
      }
      i++;
    }
    label105: return null;
  }

  private static VideoCapturerWithCaptureResolution createVideoCapturer()
  {
    VideoCapturerWithCaptureResolution localVideoCapturerWithCaptureResolution = createCameraCapturer(new Camera1Enumerator(ViberRTCWorkarounds.allowHWAcceleration()));
    if (localVideoCapturerWithCaptureResolution == null)
      localVideoCapturerWithCaptureResolution = null;
    return localVideoCapturerWithCaptureResolution;
  }

  private void disposeNativeObjects()
  {
    checkOnHandlerThread();
    if (this.mVideoSender != null)
      this.mVideoSender = null;
    if (this.mLocalRender != null)
      this.mLocalRender = null;
    if (this.mCapturer != null)
    {
      this.mCapturer.dispose();
      this.mCapturer = null;
    }
    if (this.mSurfaceTextureHelper != null)
    {
      this.mSurfaceTextureHelper.dispose();
      this.mSurfaceTextureHelper = null;
    }
    if (this.mAudioSender != null)
      this.mAudioSender = null;
    if (this.mPeerConnection != null)
    {
      this.mPeerConnection.dispose();
      this.mPeerConnection = null;
    }
    if (this.mVideoSource != null)
    {
      this.mVideoSource.dispose();
      this.mVideoSource = null;
    }
    if (this.mAudioSource != null)
    {
      this.mAudioSource.dispose();
      this.mAudioSource = null;
    }
    if (this.mPeerConnectionFactory != null)
    {
      this.mPeerConnectionFactory.dispose();
      this.mPeerConnectionFactory = null;
    }
    if (this.mRecorder != null)
    {
      this.mRecorder.dispose();
      this.mRecorder = null;
    }
    if (this.mLocalView != null)
    {
      ((c)this.mLocalView.getView()).release();
      this.mLocalView = null;
    }
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

  private static MediaConstraints getAnswerMediaConstraints()
  {
    MediaConstraints localMediaConstraints = new MediaConstraints();
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("VoiceActivityDetection", "true"));
    localMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("IceRestart", "false"));
    return localMediaConstraints;
  }

  private boolean setupPreview(byte[] paramArrayOfByte)
  {
    checkOnHandlerThread();
    NativeVideoPttRecorder localNativeVideoPttRecorder = this.mRecorder;
    boolean bool = false;
    if (localNativeVideoPttRecorder != null)
    {
      bool = this.mRecorder.instrumentPreview(paramArrayOfByte);
      if (bool);
    }
    if (bool)
      this.mJpegPreview.set(paramArrayOfByte);
    return bool;
  }

  private boolean stopCaptureAndRecord()
  {
    checkOnHandlerThread();
    if (this.mCapturer != null);
    try
    {
      this.mCapturer.stopCapture();
      label20: NativeVideoPttRecorder localNativeVideoPttRecorder = this.mRecorder;
      boolean bool = false;
      if (localNativeVideoPttRecorder != null)
        bool = this.mRecorder.stopRecord();
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label20;
    }
  }

  private void stopRecordAndDisposeNativeObjects()
  {
    checkOnHandlerThread();
    stopCaptureAndRecord();
    disposeNativeObjects();
  }

  private static boolean useCamera2()
  {
    return Camera2Enumerator.isSupported(ViberApplication.getApplication());
  }

  public void dispose()
  {
    checkOnHandlerThread();
    stopRecordAndDisposeNativeObjects();
  }

  public byte[] getJpegPreview()
  {
    return (byte[])this.mJpegPreview.get();
  }

  public boolean isRecording()
  {
    return this.mRecorder != null;
  }

  public void startVideoPttRecord(final String paramString, final VideoPttRecord.Completion paramCompletion)
  {
    checkOnHandlerThread();
    try
    {
      if (this.mRecorder != null)
        throw new IllegalStateException("start recording is already called");
    }
    catch (Exception localException)
    {
      stopRecordAndDisposeNativeObjects();
      paramCompletion.onCompletion(new Error(localException));
      return;
    }
    this.mRecorder = NativeVideoPttRecorder.create();
    if (this.mRecorder == null)
    {
      paramCompletion.onCompletion(new Error("ViberVideoPttRecord, unable to create native recorder"));
      return;
    }
    MediaConstraints localMediaConstraints1 = new MediaConstraints();
    localMediaConstraints1.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "false"));
    WebRTCInitializer.ensureInitialized();
    PeerConnectionFactory.Options localOptions = new PeerConnectionFactory.Options();
    localOptions.disableEncryption = true;
    localOptions.disableNetworkMonitor = true;
    localOptions.networkIgnoreMask = 15;
    this.mPeerConnectionFactory = PeerConnectionFactory.builder().setOptions(localOptions).setVideoEncoderFactory(ViberRTCWorkarounds.getEncoderFactory(this.mRootEglBase)).setVideoDecoderFactory(ViberRTCWorkarounds.getVideoPttDecoderFactory(this.mRootEglBase)).createPeerConnectionFactory();
    PeerConnectionObserver localPeerConnectionObserver = new PeerConnectionObserver(null);
    PeerConnection.RTCConfiguration localRTCConfiguration = new PeerConnection.RTCConfiguration(Collections.EMPTY_LIST);
    localRTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
    localRTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
    localRTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.BALANCED;
    this.mPeerConnection = this.mPeerConnectionFactory.createPeerConnection(localRTCConfiguration, localMediaConstraints1, localPeerConnectionObserver);
    MediaConstraints localMediaConstraints2 = new MediaConstraints();
    this.mAudioSource = this.mPeerConnectionFactory.createAudioSource(localMediaConstraints2);
    AudioTrack localAudioTrack = this.mPeerConnectionFactory.createAudioTrack("ATL0", this.mAudioSource);
    this.mAudioSender = this.mPeerConnection.createSender("audio", "audio_stream_viber");
    this.mAudioSender.setTrack(localAudioTrack, true);
    VideoCapturerWithCaptureResolution localVideoCapturerWithCaptureResolution = createVideoCapturer();
    if (localVideoCapturerWithCaptureResolution == null)
    {
      stopRecordAndDisposeNativeObjects();
      paramCompletion.onCompletion(new Error("ViberVideoPttRecord, video capturer creation failed"));
      return;
    }
    this.mCapturer = localVideoCapturerWithCaptureResolution.capturer;
    this.mSurfaceTextureHelper = SurfaceTextureHelper.create("VpttCaptureThread", ViberRTCWorkarounds.getEglBaseContext(this.mRootEglBase));
    this.mVideoSource = this.mPeerConnectionFactory.createVideoSource(false);
    this.mCapturer.initialize(this.mSurfaceTextureHelper, ViberApplication.getApplication(), this.mVideoSource.getCapturerObserver());
    this.mVideoSource.adaptOutputFormat(localVideoCapturerWithCaptureResolution.vpttWidth, localVideoCapturerWithCaptureResolution.vpttHeight, localVideoCapturerWithCaptureResolution.fps);
    this.mLocalRender = ((c)this.mLocalView.getView());
    try
    {
      VideoTrack localVideoTrack = this.mPeerConnectionFactory.createVideoTrack("LVT0", this.mVideoSource);
      localVideoTrack.setEnabled(true);
      localVideoTrack.addSink(this.mLocalRender);
      this.mVideoSender = this.mPeerConnection.createSender("video", "video_stream_viber");
      this.mVideoSender.setTrack(localVideoTrack, true);
      this.mCapturer.startCapture(localVideoCapturerWithCaptureResolution.captureWidth, localVideoCapturerWithCaptureResolution.captureHeight, localVideoCapturerWithCaptureResolution.fps);
      final String str = this.mRecorder.generateRemoteSdp();
      SessionDescription localSessionDescription = new SessionDescription(SessionDescription.Type.OFFER, str);
      this.mPeerConnection.setRemoteDescription(new SdpResultObserver(this.mHandler, new SetCallback()
      {
        public void onSuccess()
        {
          ViberVideoPttRecord.this.checkOnHandlerThread();
          if (ViberVideoPttRecord.this.mPeerConnection == null)
          {
            paramCompletion.onCompletion(new Error("ViberVideoPttRecord, peer connection is already disposed (after remote description is set)"));
            return;
          }
          ViberVideoPttRecord.this.mRecorder.setRemoteSdp(str);
          com.viber.jni.webrtc.IceCandidate localIceCandidate = ViberVideoPttRecord.this.mRecorder.getIceCandidate();
          if (localIceCandidate != null)
            ViberVideoPttRecord.this.mPeerConnection.addIceCandidate(new org.webrtc.IceCandidate(localIceCandidate.sdpMid, localIceCandidate.sdpMLineIndex, localIceCandidate.sdp));
          MediaConstraints localMediaConstraints = ViberVideoPttRecord.access$1300();
          ViberVideoPttRecord.this.mPeerConnection.createAnswer(new ViberVideoPttRecord.SdpResultObserver(ViberVideoPttRecord.this.mHandler, new ViberVideoPttRecord.CreateCallback()
          {
            public void onSuccess(SessionDescription paramAnonymous2SessionDescription)
            {
              ViberVideoPttRecord.this.checkOnHandlerThread();
              if (ViberVideoPttRecord.this.mPeerConnection == null)
              {
                ViberVideoPttRecord.1.this.val$completion.onCompletion(new Error("ViberVideoPttRecord, peer connection is already disposed (after local description is set)"));
                return;
              }
              ViberVideoPttRecord.this.mPeerConnection.setLocalDescription(new ViberVideoPttRecord.SdpResultObserver(ViberVideoPttRecord.this.mHandler, new ViberVideoPttRecord.SetCallback()
              {
                public void onSuccess()
                {
                  ViberVideoPttRecord.this.checkOnHandlerThread();
                  if (ViberVideoPttRecord.this.mRecorder == null)
                  {
                    ViberVideoPttRecord.1.this.val$completion.onCompletion(new Error("ViberVideoPttRecord, native StartPttRecord failed"));
                    return;
                  }
                  if (ViberVideoPttRecord.this.mRecorder.startRecord(ViberVideoPttRecord.1.this.val$pttPath))
                  {
                    ViberVideoPttRecord.this.mHandler.postDelayed(new Runnable()
                    {
                      public void run()
                      {
                        ViberVideoPttRecord.this.checkOnHandlerThread();
                        if (ViberVideoPttRecord.this.mLocalView != null)
                          ((c)ViberVideoPttRecord.this.mLocalView.getView()).addFrameListener(new ViberVideoPttRecord.PreviewListener(ViberVideoPttRecord.this), 1.0F);
                      }
                    }
                    , 1200L);
                    ViberVideoPttRecord.1.this.val$completion.onCompletion(null);
                    return;
                  }
                  ViberVideoPttRecord.this.stopRecordAndDisposeNativeObjects();
                  ViberVideoPttRecord.1.this.val$completion.onCompletion(new Error("ViberVideoPttRecord, native StartPttRecord failed"));
                }
              }
              , "ViberVideoPttRecord.startVideoPttRecord, startWithRemoteSdp, onSetFailure setLocalDescription", ViberVideoPttRecord.1.this.val$completion), paramAnonymous2SessionDescription);
            }
          }
          , "ViberVideoPttRecord.startVideoPttRecord, startWithRemoteSdp, onCreateFailure answer create", paramCompletion), localMediaConstraints);
        }
      }
      , "ViberVideoPttRecord.startVideoPttRecord, startWithRemoteSdp, onSetFailure remote offer", paramCompletion), localSessionDescription);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      L.a(localRuntimeException, "ViberVideoPttRecord, video track creation failed");
      stopRecordAndDisposeNativeObjects();
      paramCompletion.onCompletion(new Error("ViberVideoPttRecord, video track creation failed"));
    }
  }

  public void stopVideoPttRecord(VideoPttRecord.StopCompletion paramStopCompletion)
  {
    checkOnHandlerThread();
    byte[] arrayOfByte = getJpegPreview();
    if (this.mRecorder == null)
    {
      paramStopCompletion.onCompletion(false, null, arrayOfByte);
      return;
    }
    if (stopCaptureAndRecord())
      paramStopCompletion.onCompletion(false, null, arrayOfByte);
    while (true)
    {
      disposeNativeObjects();
      return;
      if (arrayOfByte == null)
        paramStopCompletion.onCompletion(true, null, arrayOfByte);
      else
        paramStopCompletion.onCompletion(false, new Error("ViberVideoPttRecord, error during stop"), arrayOfByte);
    }
  }

  private static abstract interface CreateCallback
  {
    public abstract void onSuccess(SessionDescription paramSessionDescription);
  }

  private static final class NativeVideoPttRecorder
  {
    private long nativeRecorder;

    public NativeVideoPttRecorder(long paramLong)
    {
      if (paramLong == 0L)
        throw new IllegalArgumentException("nativeRecorder is null");
      this.nativeRecorder = paramLong;
    }

    public static NativeVideoPttRecorder create()
    {
      long l = nativeCreateRecorder();
      if (l == 0L)
        return null;
      return new NativeVideoPttRecorder(l);
    }

    private void ensureNotDisposed()
    {
      if (this.nativeRecorder == 0L)
        throw new IllegalStateException("object is disposed");
    }

    private static native long nativeCreateRecorder();

    private static native boolean nativeDisposeRecorder(long paramLong);

    private static native String nativeGenerateVideoPttSdp();

    private static native com.viber.jni.webrtc.IceCandidate nativeGetIceCandidate(long paramLong);

    private static native boolean nativeInstrumentPreview(long paramLong, byte[] paramArrayOfByte);

    private static native boolean nativeSetRemoteSdp(long paramLong, String paramString);

    private static native boolean nativeStartPttRecord(long paramLong, String paramString);

    private static native boolean nativeStopPttRecord(long paramLong);

    public void dispose()
    {
      if (this.nativeRecorder != 0L)
      {
        nativeDisposeRecorder(this.nativeRecorder);
        this.nativeRecorder = 0L;
      }
    }

    public String generateRemoteSdp()
    {
      ensureNotDisposed();
      return nativeGenerateVideoPttSdp();
    }

    public com.viber.jni.webrtc.IceCandidate getIceCandidate()
    {
      ensureNotDisposed();
      return nativeGetIceCandidate(this.nativeRecorder);
    }

    public boolean instrumentPreview(byte[] paramArrayOfByte)
    {
      ensureNotDisposed();
      return nativeInstrumentPreview(this.nativeRecorder, paramArrayOfByte);
    }

    public void setRemoteSdp(String paramString)
    {
      ensureNotDisposed();
      nativeSetRemoteSdp(this.nativeRecorder, paramString);
    }

    public boolean startRecord(String paramString)
    {
      ensureNotDisposed();
      return nativeStartPttRecord(this.nativeRecorder, paramString);
    }

    public boolean stopRecord()
    {
      ensureNotDisposed();
      return nativeStopPttRecord(this.nativeRecorder);
    }
  }

  private static final class PeerConnectionObserver
    implements PeerConnection.Observer
  {
    public void onAddStream(MediaStream paramMediaStream)
    {
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
  }

  private static final class PreviewListener
    implements EglRenderer.FrameListener
  {
    public static final long BEFORE_PREVIEW_DELAY_TIME_MILLISEC = 1200L;
    private final AtomicBoolean mIsPreviewCaptured = new AtomicBoolean(false);
    private final ViberVideoPttRecord mRecorder;

    public PreviewListener(ViberVideoPttRecord paramViberVideoPttRecord)
    {
      this.mRecorder = paramViberVideoPttRecord;
    }

    public boolean isCapturedPreview()
    {
      return this.mIsPreviewCaptured.get();
    }

    public void onFrame(Bitmap paramBitmap)
    {
      if (!isCapturedPreview())
      {
        Bitmap localBitmap = j.g(paramBitmap);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
        final byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        j.c(localBitmap);
        ViberVideoPttRecord.forwardActionTo(this.mRecorder.mHandler, new Runnable()
        {
          public void run()
          {
            if (!ViberVideoPttRecord.PreviewListener.this.isCapturedPreview())
            {
              boolean bool = ViberVideoPttRecord.this.setupPreview(arrayOfByte);
              if (bool)
                ViberVideoPttRecord.PreviewListener.this.mIsPreviewCaptured.set(bool);
            }
          }
        });
      }
    }
  }

  private static final class SdpResultObserver
    implements SdpObserver
  {
    private final VideoPttRecord.Completion completion;
    private final Handler mHandler;
    private final ViberVideoPttRecord.CreateCallback mOnCreated;
    private final String mOnErrorMsg;
    private final ViberVideoPttRecord.SetCallback mOnSet;

    SdpResultObserver(Handler paramHandler, ViberVideoPttRecord.CreateCallback paramCreateCallback, String paramString, VideoPttRecord.Completion paramCompletion)
    {
      this.mHandler = paramHandler;
      this.mOnCreated = paramCreateCallback;
      this.mOnErrorMsg = paramString;
      this.mOnSet = null;
      this.completion = paramCompletion;
    }

    SdpResultObserver(Handler paramHandler, ViberVideoPttRecord.SetCallback paramSetCallback, String paramString, VideoPttRecord.Completion paramCompletion)
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
      ViberVideoPttRecord.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttRecord.SdpResultObserver.this.completion.onCompletion(new Error(ViberVideoPttRecord.SdpResultObserver.this.mOnErrorMsg + ": " + paramString));
        }
      });
    }

    public void onCreateSuccess(final SessionDescription paramSessionDescription)
    {
      if (this.mOnCreated == null)
        return;
      ViberVideoPttRecord.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttRecord.SdpResultObserver.this.mOnCreated.onSuccess(paramSessionDescription);
        }
      });
    }

    public void onSetFailure(final String paramString)
    {
      if (this.completion == null)
        return;
      ViberVideoPttRecord.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttRecord.SdpResultObserver.this.completion.onCompletion(new Error(ViberVideoPttRecord.SdpResultObserver.this.mOnErrorMsg + ": " + paramString));
        }
      });
    }

    public void onSetSuccess()
    {
      if (this.mOnSet == null)
        return;
      ViberVideoPttRecord.forwardActionTo(this.mHandler, new Runnable()
      {
        public void run()
        {
          ViberVideoPttRecord.SdpResultObserver.this.mOnSet.onSuccess();
        }
      });
    }
  }

  private static abstract interface SetCallback
  {
    public abstract void onSuccess();
  }

  private static class VideoCapturerWithCaptureResolution
  {
    private static final int DEFAULT_CAPTURE_HEIGHT = 640;
    private static final int DEFAULT_CAPTURE_WIDTH = 480;
    public final int captureHeight;
    public final int captureWidth;
    public final VideoCapturer capturer;
    public final int fps;
    public final int vpttHeight;
    public final int vpttWidth;

    private VideoCapturerWithCaptureResolution(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, VideoCapturer paramVideoCapturer)
    {
      if (paramVideoCapturer == null)
        throw new IllegalArgumentException("capturer");
      this.captureWidth = paramInt1;
      this.captureHeight = paramInt2;
      this.capturer = paramVideoCapturer;
      this.vpttHeight = paramInt3;
      this.vpttWidth = paramInt4;
      this.fps = paramInt5;
    }

    public static VideoCapturerWithCaptureResolution createWithCaptureResolution(CameraEnumerator paramCameraEnumerator, String paramString)
    {
      CameraVideoCapturer localCameraVideoCapturer = paramCameraEnumerator.createCapturer(paramString, null);
      if (localCameraVideoCapturer == null)
        return null;
      ArrayList localArrayList = new ArrayList(paramCameraEnumerator.getSupportedFormats(paramString));
      Collections.sort(localArrayList, new Comparator()
      {
        public int compare(CameraEnumerationAndroid.CaptureFormat paramAnonymousCaptureFormat1, CameraEnumerationAndroid.CaptureFormat paramAnonymousCaptureFormat2)
        {
          int i = -1;
          int j = Math.min(paramAnonymousCaptureFormat1.width, paramAnonymousCaptureFormat1.height);
          int k = Math.max(paramAnonymousCaptureFormat1.width, paramAnonymousCaptureFormat1.height);
          int m = Math.min(paramAnonymousCaptureFormat2.width, paramAnonymousCaptureFormat2.height);
          int n = Math.max(paramAnonymousCaptureFormat2.width, paramAnonymousCaptureFormat2.height);
          int i1;
          if (j < m)
          {
            i1 = i;
            if (i1 == 0)
              break label93;
            i = i1;
          }
          label93: 
          while (k < n)
          {
            return i;
            if (j > m)
            {
              i1 = 1;
              break;
            }
            i1 = 0;
            break;
          }
          if (k > n)
            return 1;
          return 0;
        }
      });
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
        ((CameraEnumerationAndroid.CaptureFormat)localIterator1.next());
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        CameraEnumerationAndroid.CaptureFormat localCaptureFormat = (CameraEnumerationAndroid.CaptureFormat)localIterator2.next();
        if (((localCaptureFormat.width >= 480) && (localCaptureFormat.height >= 640)) || ((localCaptureFormat.width >= 640) && (localCaptureFormat.height >= 480)))
          return new VideoCapturerWithCaptureResolution(localCaptureFormat.width, localCaptureFormat.height, 240, 240, 15, localCameraVideoCapturer);
      }
      return new VideoCapturerWithCaptureResolution(480, 640, 240, 240, 15, localCameraVideoCapturer);
    }

    public String toString()
    {
      return "VideoCapturerWithCaptureResolution{captureSize=" + this.captureWidth + "x" + this.captureHeight + ", vpttSize=" + this.vpttHeight + "x" + this.vpttWidth + ", fps=" + this.fps + ", capturer=" + this.capturer + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.ViberVideoPttRecord
 * JD-Core Version:    0.6.2
 */