package org.webrtc;

import android.content.Context;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.LegacyAudioDeviceModule;

public class PeerConnectionFactory
{
  private static final String TAG = "PeerConnectionFactory";
  public static final String TRIAL_ENABLED = "Enabled";
  private static final String VIDEO_CAPTURER_THREAD_NAME = "VideoCapturerThread";

  @Deprecated
  public static final String VIDEO_FRAME_EMIT_TRIAL = "VideoFrameEmit";
  private static volatile boolean internalTracerInitialized = false;

  @Nullable
  private static Thread networkThread;

  @Nullable
  private static Thread signalingThread;

  @Nullable
  private static Thread workerThread;
  private final long nativeFactory;

  @CalledByNative
  PeerConnectionFactory(long paramLong)
  {
    checkInitializeHasBeenCalled();
    if (paramLong == 0L)
      throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
    this.nativeFactory = paramLong;
  }

  private PeerConnectionFactory(Options paramOptions, @Nullable AudioDeviceModule paramAudioDeviceModule, @Nullable VideoEncoderFactory paramVideoEncoderFactory, @Nullable VideoDecoderFactory paramVideoDecoderFactory, @Nullable AudioProcessingFactory paramAudioProcessingFactory, @Nullable FecControllerFactoryFactoryInterface paramFecControllerFactoryFactoryInterface)
  {
    checkInitializeHasBeenCalled();
    Context localContext = ContextUtils.getApplicationContext();
    long l1;
    long l2;
    if (paramAudioDeviceModule == null)
    {
      l1 = 0L;
      if (paramAudioProcessingFactory != null)
        break label85;
      l2 = 0L;
      label28: if (paramFecControllerFactoryFactoryInterface != null)
        break label97;
    }
    label85: label97: for (long l3 = 0L; ; l3 = paramFecControllerFactoryFactoryInterface.createNative())
    {
      this.nativeFactory = nativeCreatePeerConnectionFactory(localContext, paramOptions, l1, paramVideoEncoderFactory, paramVideoDecoderFactory, l2, l3);
      if (this.nativeFactory != 0L)
        return;
      throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
      l1 = paramAudioDeviceModule.getNativeAudioDeviceModulePointer();
      break;
      l2 = paramAudioProcessingFactory.createNative();
      break label28;
    }
  }

  public static Builder builder()
  {
    return new Builder(null);
  }

  private void checkInitializeHasBeenCalled()
  {
    if ((!NativeLibrary.isLoaded()) || (ContextUtils.getApplicationContext() == null))
      throw new IllegalStateException("PeerConnectionFactory.initialize was not called before creating a PeerConnectionFactory.");
  }

  public static String fieldTrialsFindFullName(String paramString)
  {
    if (NativeLibrary.isLoaded())
      return nativeFindFieldTrialsFullName(paramString);
    return "";
  }

  public static void initialize(InitializationOptions paramInitializationOptions)
  {
    ContextUtils.initialize(paramInitializationOptions.applicationContext);
    NativeLibrary.initialize(paramInitializationOptions.nativeLibraryLoader, paramInitializationOptions.nativeLibraryName);
    nativeInitializeAndroidGlobals();
    nativeInitializeFieldTrials(paramInitializationOptions.fieldTrials);
    if ((paramInitializationOptions.enableInternalTracer) && (!internalTracerInitialized))
      initializeInternalTracer();
    if (paramInitializationOptions.loggable != null)
    {
      Logging.injectLoggable(paramInitializationOptions.loggable, paramInitializationOptions.loggableSeverity);
      nativeInjectLoggable(new JNILogging(paramInitializationOptions.loggable), paramInitializationOptions.loggableSeverity.ordinal());
      return;
    }
    Logging.d("PeerConnectionFactory", "PeerConnectionFactory was initialized without an injected Loggable. Any existing Loggable will be deleted.");
    Logging.deleteInjectedLoggable();
    nativeDeleteLoggable();
  }

  @Deprecated
  public static void initializeFieldTrials(String paramString)
  {
    nativeInitializeFieldTrials(paramString);
  }

  private static void initializeInternalTracer()
  {
    internalTracerInitialized = true;
    nativeInitializeInternalTracer();
  }

  private static native long nativeCreateAudioSource(long paramLong, MediaConstraints paramMediaConstraints);

  private static native long nativeCreateAudioTrack(long paramLong1, String paramString, long paramLong2);

  private static native long nativeCreateLocalMediaStream(long paramLong, String paramString);

  private static native long nativeCreatePeerConnection(long paramLong1, PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints, long paramLong2, SSLCertificateVerifier paramSSLCertificateVerifier);

  private static native long nativeCreatePeerConnectionFactory(Context paramContext, Options paramOptions, long paramLong1, VideoEncoderFactory paramVideoEncoderFactory, VideoDecoderFactory paramVideoDecoderFactory, long paramLong2, long paramLong3);

  private static native long nativeCreateVideoSource(long paramLong, boolean paramBoolean);

  private static native long nativeCreateVideoTrack(long paramLong1, String paramString, long paramLong2);

  private static native void nativeDeleteLoggable();

  private static native String nativeFindFieldTrialsFullName(String paramString);

  private static native void nativeFreeFactory(long paramLong);

  private static native long nativeGetNativePeerConnectionFactory(long paramLong);

  private static native void nativeInitializeAndroidGlobals();

  private static native void nativeInitializeFieldTrials(String paramString);

  private static native void nativeInitializeInternalTracer();

  private static native void nativeInjectLoggable(JNILogging paramJNILogging, int paramInt);

  private static native void nativeInvokeThreadsCallbacks(long paramLong);

  private static native void nativeShutdownInternalTracer();

  private static native boolean nativeStartAecDump(long paramLong, int paramInt1, int paramInt2);

  private static native boolean nativeStartInternalTracingCapture(String paramString);

  private static native void nativeStopAecDump(long paramLong);

  private static native void nativeStopInternalTracingCapture();

  @CalledByNative
  private static void onNetworkThreadReady()
  {
    networkThread = Thread.currentThread();
    Logging.d("PeerConnectionFactory", "onNetworkThreadReady");
  }

  @CalledByNative
  private static void onSignalingThreadReady()
  {
    signalingThread = Thread.currentThread();
    Logging.d("PeerConnectionFactory", "onSignalingThreadReady");
  }

  @CalledByNative
  private static void onWorkerThreadReady()
  {
    workerThread = Thread.currentThread();
    Logging.d("PeerConnectionFactory", "onWorkerThreadReady");
  }

  private static void printStackTrace(@Nullable Thread paramThread, String paramString)
  {
    if (paramThread != null)
    {
      StackTraceElement[] arrayOfStackTraceElement = paramThread.getStackTrace();
      if (arrayOfStackTraceElement.length > 0)
      {
        Logging.d("PeerConnectionFactory", paramString + " stacks trace:");
        int i = arrayOfStackTraceElement.length;
        for (int j = 0; j < i; j++)
          Logging.d("PeerConnectionFactory", arrayOfStackTraceElement[j].toString());
      }
    }
  }

  public static void printStackTraces()
  {
    printStackTrace(networkThread, "Network thread");
    printStackTrace(workerThread, "Worker thread");
    printStackTrace(signalingThread, "Signaling thread");
  }

  public static void shutdownInternalTracer()
  {
    internalTracerInitialized = false;
    nativeShutdownInternalTracer();
  }

  public static boolean startInternalTracingCapture(String paramString)
  {
    return nativeStartInternalTracingCapture(paramString);
  }

  public static void stopInternalTracingCapture()
  {
    nativeStopInternalTracingCapture();
  }

  public AudioSource createAudioSource(MediaConstraints paramMediaConstraints)
  {
    return new AudioSource(nativeCreateAudioSource(this.nativeFactory, paramMediaConstraints));
  }

  public AudioTrack createAudioTrack(String paramString, AudioSource paramAudioSource)
  {
    return new AudioTrack(nativeCreateAudioTrack(this.nativeFactory, paramString, paramAudioSource.nativeSource));
  }

  public MediaStream createLocalMediaStream(String paramString)
  {
    return new MediaStream(nativeCreateLocalMediaStream(this.nativeFactory, paramString));
  }

  @Deprecated
  @Nullable
  public PeerConnection createPeerConnection(List<PeerConnection.IceServer> paramList, MediaConstraints paramMediaConstraints, PeerConnection.Observer paramObserver)
  {
    return createPeerConnection(new PeerConnection.RTCConfiguration(paramList), paramMediaConstraints, paramObserver);
  }

  @Nullable
  public PeerConnection createPeerConnection(List<PeerConnection.IceServer> paramList, PeerConnection.Observer paramObserver)
  {
    return createPeerConnection(new PeerConnection.RTCConfiguration(paramList), paramObserver);
  }

  @Deprecated
  @Nullable
  public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints, PeerConnection.Observer paramObserver)
  {
    return createPeerConnectionInternal(paramRTCConfiguration, paramMediaConstraints, paramObserver, null);
  }

  @Nullable
  public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration paramRTCConfiguration, PeerConnection.Observer paramObserver)
  {
    return createPeerConnection(paramRTCConfiguration, null, paramObserver);
  }

  @Nullable
  public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration paramRTCConfiguration, PeerConnectionDependencies paramPeerConnectionDependencies)
  {
    return createPeerConnectionInternal(paramRTCConfiguration, null, paramPeerConnectionDependencies.getObserver(), paramPeerConnectionDependencies.getSSLCertificateVerifier());
  }

  @Nullable
  PeerConnection createPeerConnectionInternal(PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints, PeerConnection.Observer paramObserver, SSLCertificateVerifier paramSSLCertificateVerifier)
  {
    long l1 = PeerConnection.createNativePeerConnectionObserver(paramObserver);
    if (l1 == 0L)
      return null;
    long l2 = nativeCreatePeerConnection(this.nativeFactory, paramRTCConfiguration, paramMediaConstraints, l1, paramSSLCertificateVerifier);
    if (l2 == 0L)
      return null;
    return new PeerConnection(l2);
  }

  public VideoSource createVideoSource(boolean paramBoolean)
  {
    return new VideoSource(nativeCreateVideoSource(this.nativeFactory, paramBoolean));
  }

  public VideoTrack createVideoTrack(String paramString, VideoSource paramVideoSource)
  {
    return new VideoTrack(nativeCreateVideoTrack(this.nativeFactory, paramString, paramVideoSource.nativeSource));
  }

  public void dispose()
  {
    nativeFreeFactory(this.nativeFactory);
    networkThread = null;
    workerThread = null;
    signalingThread = null;
    MediaCodecVideoEncoder.disposeEglContext();
    MediaCodecVideoDecoder.disposeEglContext();
  }

  public long getNativeOwnedFactoryAndThreads()
  {
    return this.nativeFactory;
  }

  public long getNativePeerConnectionFactory()
  {
    return nativeGetNativePeerConnectionFactory(this.nativeFactory);
  }

  public boolean startAecDump(int paramInt1, int paramInt2)
  {
    return nativeStartAecDump(this.nativeFactory, paramInt1, paramInt2);
  }

  public void stopAecDump()
  {
    nativeStopAecDump(this.nativeFactory);
  }

  public void threadsCallbacks()
  {
    nativeInvokeThreadsCallbacks(this.nativeFactory);
  }

  public static class Builder
  {

    @Nullable
    private AudioDeviceModule audioDeviceModule = new LegacyAudioDeviceModule();

    @Nullable
    private AudioProcessingFactory audioProcessingFactory;

    @Nullable
    private VideoDecoderFactory decoderFactory;

    @Nullable
    private VideoEncoderFactory encoderFactory;

    @Nullable
    private FecControllerFactoryFactoryInterface fecControllerFactoryFactory;

    @Nullable
    private PeerConnectionFactory.Options options;

    public PeerConnectionFactory createPeerConnectionFactory()
    {
      return new PeerConnectionFactory(this.options, this.audioDeviceModule, this.encoderFactory, this.decoderFactory, this.audioProcessingFactory, this.fecControllerFactoryFactory, null);
    }

    public Builder setAudioDeviceModule(AudioDeviceModule paramAudioDeviceModule)
    {
      this.audioDeviceModule = paramAudioDeviceModule;
      return this;
    }

    public Builder setAudioProcessingFactory(AudioProcessingFactory paramAudioProcessingFactory)
    {
      if (paramAudioProcessingFactory == null)
        throw new NullPointerException("PeerConnectionFactory builder does not accept a null AudioProcessingFactory.");
      this.audioProcessingFactory = paramAudioProcessingFactory;
      return this;
    }

    public Builder setFecControllerFactoryFactoryInterface(FecControllerFactoryFactoryInterface paramFecControllerFactoryFactoryInterface)
    {
      this.fecControllerFactoryFactory = paramFecControllerFactoryFactoryInterface;
      return this;
    }

    public Builder setOptions(PeerConnectionFactory.Options paramOptions)
    {
      this.options = paramOptions;
      return this;
    }

    public Builder setVideoDecoderFactory(VideoDecoderFactory paramVideoDecoderFactory)
    {
      this.decoderFactory = paramVideoDecoderFactory;
      return this;
    }

    public Builder setVideoEncoderFactory(VideoEncoderFactory paramVideoEncoderFactory)
    {
      this.encoderFactory = paramVideoEncoderFactory;
      return this;
    }
  }

  public static class InitializationOptions
  {
    final Context applicationContext;
    final boolean enableInternalTracer;
    final String fieldTrials;

    @Nullable
    Loggable loggable;

    @Nullable
    Logging.Severity loggableSeverity;
    final NativeLibraryLoader nativeLibraryLoader;
    final String nativeLibraryName;

    private InitializationOptions(Context paramContext, String paramString1, boolean paramBoolean, NativeLibraryLoader paramNativeLibraryLoader, String paramString2, @Nullable Loggable paramLoggable, @Nullable Logging.Severity paramSeverity)
    {
      this.applicationContext = paramContext;
      this.fieldTrials = paramString1;
      this.enableInternalTracer = paramBoolean;
      this.nativeLibraryLoader = paramNativeLibraryLoader;
      this.nativeLibraryName = paramString2;
      this.loggable = paramLoggable;
      this.loggableSeverity = paramSeverity;
    }

    public static Builder builder(Context paramContext)
    {
      return new Builder(paramContext);
    }

    public static class Builder
    {
      private final Context applicationContext;
      private boolean enableInternalTracer = false;
      private String fieldTrials = "";

      @Nullable
      private Loggable loggable = null;

      @Nullable
      private Logging.Severity loggableSeverity = null;
      private NativeLibraryLoader nativeLibraryLoader = new NativeLibrary.DefaultLoader();
      private String nativeLibraryName = "jingle_peerconnection_so";

      Builder(Context paramContext)
      {
        this.applicationContext = paramContext;
      }

      public PeerConnectionFactory.InitializationOptions createInitializationOptions()
      {
        return new PeerConnectionFactory.InitializationOptions(this.applicationContext, this.fieldTrials, this.enableInternalTracer, this.nativeLibraryLoader, this.nativeLibraryName, this.loggable, this.loggableSeverity, null);
      }

      public Builder setEnableInternalTracer(boolean paramBoolean)
      {
        this.enableInternalTracer = paramBoolean;
        return this;
      }

      public Builder setFieldTrials(String paramString)
      {
        this.fieldTrials = paramString;
        return this;
      }

      public Builder setInjectableLogger(Loggable paramLoggable, Logging.Severity paramSeverity)
      {
        this.loggable = paramLoggable;
        this.loggableSeverity = paramSeverity;
        return this;
      }

      public Builder setNativeLibraryLoader(NativeLibraryLoader paramNativeLibraryLoader)
      {
        this.nativeLibraryLoader = paramNativeLibraryLoader;
        return this;
      }

      public Builder setNativeLibraryName(String paramString)
      {
        this.nativeLibraryName = paramString;
        return this;
      }
    }
  }

  public static class Options
  {
    static final int ADAPTER_TYPE_ANY = 32;
    static final int ADAPTER_TYPE_CELLULAR = 4;
    static final int ADAPTER_TYPE_ETHERNET = 1;
    static final int ADAPTER_TYPE_LOOPBACK = 16;
    static final int ADAPTER_TYPE_UNKNOWN = 0;
    static final int ADAPTER_TYPE_VPN = 8;
    static final int ADAPTER_TYPE_WIFI = 2;
    public boolean disableEncryption;
    public boolean disableNetworkMonitor;
    public boolean enableAes128Sha1_32CryptoCipher;
    public boolean enableGcmCryptoSuites;
    public int networkIgnoreMask;

    @CalledByNative("Options")
    boolean getDisableEncryption()
    {
      return this.disableEncryption;
    }

    @CalledByNative("Options")
    boolean getDisableNetworkMonitor()
    {
      return this.disableNetworkMonitor;
    }

    @CalledByNative("Options")
    boolean getEnableAes128Sha1_32CryptoCipher()
    {
      return this.enableAes128Sha1_32CryptoCipher;
    }

    @CalledByNative("Options")
    boolean getEnableGcmCryptoSuites()
    {
      return this.enableGcmCryptoSuites;
    }

    @CalledByNative("Options")
    int getNetworkIgnoreMask()
    {
      return this.networkIgnoreMask;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.PeerConnectionFactory
 * JD-Core Version:    0.6.2
 */