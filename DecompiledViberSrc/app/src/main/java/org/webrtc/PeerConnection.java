package org.webrtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class PeerConnection
{
  private final List<MediaStream> localStreams = new ArrayList();
  private final long nativePeerConnection;
  private List<RtpReceiver> receivers = new ArrayList();
  private List<RtpSender> senders = new ArrayList();
  private List<RtpTransceiver> transceivers = new ArrayList();

  PeerConnection(long paramLong)
  {
    this.nativePeerConnection = paramLong;
  }

  public PeerConnection(NativePeerConnectionFactory paramNativePeerConnectionFactory)
  {
    this(paramNativePeerConnectionFactory.createNativePeerConnection());
  }

  public static long createNativePeerConnectionObserver(Observer paramObserver)
  {
    return nativeCreatePeerConnectionObserver(paramObserver);
  }

  private native boolean nativeAddIceCandidate(String paramString1, int paramInt, String paramString2);

  private native boolean nativeAddLocalStream(long paramLong);

  private native RtpSender nativeAddTrack(long paramLong, List<String> paramList);

  private native RtpTransceiver nativeAddTransceiverOfType(MediaStreamTrack.MediaType paramMediaType, RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit);

  private native RtpTransceiver nativeAddTransceiverWithTrack(long paramLong, RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit);

  private native void nativeClose();

  private native void nativeCreateAnswer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints);

  private native DataChannel nativeCreateDataChannel(String paramString, DataChannel.Init paramInit);

  private native void nativeCreateOffer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints);

  private static native long nativeCreatePeerConnectionObserver(Observer paramObserver);

  private native RtpSender nativeCreateSender(String paramString1, String paramString2);

  private static native void nativeFreeOwnedPeerConnection(long paramLong);

  private native SessionDescription nativeGetLocalDescription();

  private native long nativeGetNativePeerConnection();

  private native List<RtpReceiver> nativeGetReceivers();

  private native SessionDescription nativeGetRemoteDescription();

  private native List<RtpSender> nativeGetSenders();

  private native List<RtpTransceiver> nativeGetTransceivers();

  private native IceConnectionState nativeIceConnectionState();

  private native IceGatheringState nativeIceGatheringState();

  private native void nativeNewGetStats(RTCStatsCollectorCallback paramRTCStatsCollectorCallback);

  private native boolean nativeOldGetStats(StatsObserver paramStatsObserver, long paramLong);

  private native boolean nativeRemoveIceCandidates(IceCandidate[] paramArrayOfIceCandidate);

  private native void nativeRemoveLocalStream(long paramLong);

  private native boolean nativeRemoveTrack(long paramLong);

  private native void nativeSetAudioPlayout(boolean paramBoolean);

  private native void nativeSetAudioRecording(boolean paramBoolean);

  private native boolean nativeSetBitrate(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);

  private native boolean nativeSetConfiguration(RTCConfiguration paramRTCConfiguration);

  private native void nativeSetLocalDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription);

  private native void nativeSetRemoteDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription);

  private native SignalingState nativeSignalingState();

  private native boolean nativeStartRtcEventLog(int paramInt1, int paramInt2);

  private native void nativeStopRtcEventLog();

  public boolean addIceCandidate(IceCandidate paramIceCandidate)
  {
    return nativeAddIceCandidate(paramIceCandidate.sdpMid, paramIceCandidate.sdpMLineIndex, paramIceCandidate.sdp);
  }

  public boolean addStream(MediaStream paramMediaStream)
  {
    if (!nativeAddLocalStream(paramMediaStream.nativeStream))
      return false;
    this.localStreams.add(paramMediaStream);
    return true;
  }

  public RtpSender addTrack(MediaStreamTrack paramMediaStreamTrack)
  {
    return addTrack(paramMediaStreamTrack, Collections.emptyList());
  }

  public RtpSender addTrack(MediaStreamTrack paramMediaStreamTrack, List<String> paramList)
  {
    if ((paramMediaStreamTrack == null) || (paramList == null))
      throw new NullPointerException("No MediaStreamTrack specified in addTrack.");
    RtpSender localRtpSender = nativeAddTrack(paramMediaStreamTrack.nativeTrack, paramList);
    if (localRtpSender == null)
      throw new IllegalStateException("C++ addTrack failed.");
    this.senders.add(localRtpSender);
    return localRtpSender;
  }

  public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType paramMediaType)
  {
    return addTransceiver(paramMediaType, new RtpTransceiver.RtpTransceiverInit());
  }

  public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType paramMediaType, @Nullable RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit)
  {
    if (paramMediaType == null)
      throw new NullPointerException("No MediaType specified for addTransceiver.");
    if (paramRtpTransceiverInit == null)
      paramRtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
    RtpTransceiver localRtpTransceiver = nativeAddTransceiverOfType(paramMediaType, paramRtpTransceiverInit);
    if (localRtpTransceiver == null)
      throw new IllegalStateException("C++ addTransceiver failed.");
    this.transceivers.add(localRtpTransceiver);
    return localRtpTransceiver;
  }

  public RtpTransceiver addTransceiver(MediaStreamTrack paramMediaStreamTrack)
  {
    return addTransceiver(paramMediaStreamTrack, new RtpTransceiver.RtpTransceiverInit());
  }

  public RtpTransceiver addTransceiver(MediaStreamTrack paramMediaStreamTrack, @Nullable RtpTransceiver.RtpTransceiverInit paramRtpTransceiverInit)
  {
    if (paramMediaStreamTrack == null)
      throw new NullPointerException("No MediaStreamTrack specified for addTransceiver.");
    if (paramRtpTransceiverInit == null)
      paramRtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
    RtpTransceiver localRtpTransceiver = nativeAddTransceiverWithTrack(paramMediaStreamTrack.nativeTrack, paramRtpTransceiverInit);
    if (localRtpTransceiver == null)
      throw new IllegalStateException("C++ addTransceiver failed.");
    this.transceivers.add(localRtpTransceiver);
    return localRtpTransceiver;
  }

  public void close()
  {
    nativeClose();
  }

  public void createAnswer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints)
  {
    nativeCreateAnswer(paramSdpObserver, paramMediaConstraints);
  }

  public DataChannel createDataChannel(String paramString, DataChannel.Init paramInit)
  {
    return nativeCreateDataChannel(paramString, paramInit);
  }

  public void createOffer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints)
  {
    nativeCreateOffer(paramSdpObserver, paramMediaConstraints);
  }

  public RtpSender createSender(String paramString1, String paramString2)
  {
    RtpSender localRtpSender = nativeCreateSender(paramString1, paramString2);
    if (localRtpSender != null)
      this.senders.add(localRtpSender);
    return localRtpSender;
  }

  public void dispose()
  {
    close();
    Iterator localIterator1 = this.localStreams.iterator();
    while (localIterator1.hasNext())
    {
      MediaStream localMediaStream = (MediaStream)localIterator1.next();
      nativeRemoveLocalStream(localMediaStream.nativeStream);
      localMediaStream.dispose();
    }
    this.localStreams.clear();
    Iterator localIterator2 = this.senders.iterator();
    while (localIterator2.hasNext())
      ((RtpSender)localIterator2.next()).dispose();
    this.senders.clear();
    Iterator localIterator3 = this.receivers.iterator();
    while (localIterator3.hasNext())
      ((RtpReceiver)localIterator3.next()).dispose();
    Iterator localIterator4 = this.transceivers.iterator();
    while (localIterator4.hasNext())
      ((RtpTransceiver)localIterator4.next()).dispose();
    this.transceivers.clear();
    this.receivers.clear();
    nativeFreeOwnedPeerConnection(this.nativePeerConnection);
  }

  public SessionDescription getLocalDescription()
  {
    return nativeGetLocalDescription();
  }

  @CalledByNative
  long getNativeOwnedPeerConnection()
  {
    return this.nativePeerConnection;
  }

  public long getNativePeerConnection()
  {
    return nativeGetNativePeerConnection();
  }

  public List<RtpReceiver> getReceivers()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
      ((RtpReceiver)localIterator.next()).dispose();
    this.receivers = nativeGetReceivers();
    return Collections.unmodifiableList(this.receivers);
  }

  public SessionDescription getRemoteDescription()
  {
    return nativeGetRemoteDescription();
  }

  public List<RtpSender> getSenders()
  {
    Iterator localIterator = this.senders.iterator();
    while (localIterator.hasNext())
      ((RtpSender)localIterator.next()).dispose();
    this.senders = nativeGetSenders();
    return Collections.unmodifiableList(this.senders);
  }

  public void getStats(RTCStatsCollectorCallback paramRTCStatsCollectorCallback)
  {
    nativeNewGetStats(paramRTCStatsCollectorCallback);
  }

  @Deprecated
  public boolean getStats(StatsObserver paramStatsObserver, @Nullable MediaStreamTrack paramMediaStreamTrack)
  {
    if (paramMediaStreamTrack == null);
    for (long l = 0L; ; l = paramMediaStreamTrack.nativeTrack)
      return nativeOldGetStats(paramStatsObserver, l);
  }

  public List<RtpTransceiver> getTransceivers()
  {
    Iterator localIterator = this.transceivers.iterator();
    while (localIterator.hasNext())
      ((RtpTransceiver)localIterator.next()).dispose();
    this.transceivers = nativeGetTransceivers();
    return Collections.unmodifiableList(this.transceivers);
  }

  public IceConnectionState iceConnectionState()
  {
    return nativeIceConnectionState();
  }

  public IceGatheringState iceGatheringState()
  {
    return nativeIceGatheringState();
  }

  public boolean removeIceCandidates(IceCandidate[] paramArrayOfIceCandidate)
  {
    return nativeRemoveIceCandidates(paramArrayOfIceCandidate);
  }

  public void removeStream(MediaStream paramMediaStream)
  {
    nativeRemoveLocalStream(paramMediaStream.nativeStream);
    this.localStreams.remove(paramMediaStream);
  }

  public boolean removeTrack(RtpSender paramRtpSender)
  {
    if (paramRtpSender == null)
      throw new NullPointerException("No RtpSender specified for removeTrack.");
    return nativeRemoveTrack(paramRtpSender.nativeRtpSender);
  }

  public void setAudioPlayout(boolean paramBoolean)
  {
    nativeSetAudioPlayout(paramBoolean);
  }

  public void setAudioRecording(boolean paramBoolean)
  {
    nativeSetAudioRecording(paramBoolean);
  }

  public boolean setBitrate(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    return nativeSetBitrate(paramInteger1, paramInteger2, paramInteger3);
  }

  public boolean setConfiguration(RTCConfiguration paramRTCConfiguration)
  {
    return nativeSetConfiguration(paramRTCConfiguration);
  }

  public void setLocalDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription)
  {
    nativeSetLocalDescription(paramSdpObserver, paramSessionDescription);
  }

  public void setRemoteDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription)
  {
    nativeSetRemoteDescription(paramSdpObserver, paramSessionDescription);
  }

  public SignalingState signalingState()
  {
    return nativeSignalingState();
  }

  public boolean startRtcEventLog(int paramInt1, int paramInt2)
  {
    return nativeStartRtcEventLog(paramInt1, paramInt2);
  }

  public void stopRtcEventLog()
  {
    nativeStopRtcEventLog();
  }

  public static enum AdapterType
  {
    static
    {
      ETHERNET = new AdapterType("ETHERNET", 1);
      WIFI = new AdapterType("WIFI", 2);
      CELLULAR = new AdapterType("CELLULAR", 3);
      VPN = new AdapterType("VPN", 4);
      LOOPBACK = new AdapterType("LOOPBACK", 5);
      AdapterType[] arrayOfAdapterType = new AdapterType[6];
      arrayOfAdapterType[0] = UNKNOWN;
      arrayOfAdapterType[1] = ETHERNET;
      arrayOfAdapterType[2] = WIFI;
      arrayOfAdapterType[3] = CELLULAR;
      arrayOfAdapterType[4] = VPN;
      arrayOfAdapterType[5] = LOOPBACK;
    }
  }

  public static enum BundlePolicy
  {
    static
    {
      BundlePolicy[] arrayOfBundlePolicy = new BundlePolicy[3];
      arrayOfBundlePolicy[0] = BALANCED;
      arrayOfBundlePolicy[1] = MAXBUNDLE;
      arrayOfBundlePolicy[2] = MAXCOMPAT;
    }
  }

  public static enum CandidateNetworkPolicy
  {
    static
    {
      CandidateNetworkPolicy[] arrayOfCandidateNetworkPolicy = new CandidateNetworkPolicy[2];
      arrayOfCandidateNetworkPolicy[0] = ALL;
      arrayOfCandidateNetworkPolicy[1] = LOW_COST;
    }
  }

  public static enum ContinualGatheringPolicy
  {
    static
    {
      GATHER_CONTINUALLY = new ContinualGatheringPolicy("GATHER_CONTINUALLY", 1);
      ContinualGatheringPolicy[] arrayOfContinualGatheringPolicy = new ContinualGatheringPolicy[2];
      arrayOfContinualGatheringPolicy[0] = GATHER_ONCE;
      arrayOfContinualGatheringPolicy[1] = GATHER_CONTINUALLY;
    }
  }

  public static enum IceConnectionState
  {
    static
    {
      CHECKING = new IceConnectionState("CHECKING", 1);
      CONNECTED = new IceConnectionState("CONNECTED", 2);
      COMPLETED = new IceConnectionState("COMPLETED", 3);
      FAILED = new IceConnectionState("FAILED", 4);
      DISCONNECTED = new IceConnectionState("DISCONNECTED", 5);
      CLOSED = new IceConnectionState("CLOSED", 6);
      IceConnectionState[] arrayOfIceConnectionState = new IceConnectionState[7];
      arrayOfIceConnectionState[0] = NEW;
      arrayOfIceConnectionState[1] = CHECKING;
      arrayOfIceConnectionState[2] = CONNECTED;
      arrayOfIceConnectionState[3] = COMPLETED;
      arrayOfIceConnectionState[4] = FAILED;
      arrayOfIceConnectionState[5] = DISCONNECTED;
      arrayOfIceConnectionState[6] = CLOSED;
    }

    @CalledByNative("IceConnectionState")
    static IceConnectionState fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }

  public static enum IceGatheringState
  {
    static
    {
      GATHERING = new IceGatheringState("GATHERING", 1);
      COMPLETE = new IceGatheringState("COMPLETE", 2);
      IceGatheringState[] arrayOfIceGatheringState = new IceGatheringState[3];
      arrayOfIceGatheringState[0] = NEW;
      arrayOfIceGatheringState[1] = GATHERING;
      arrayOfIceGatheringState[2] = COMPLETE;
    }

    @CalledByNative("IceGatheringState")
    static IceGatheringState fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }

  public static class IceServer
  {
    public final String hostname;
    public final String password;
    public final List<String> tlsAlpnProtocols;
    public final PeerConnection.TlsCertPolicy tlsCertPolicy;
    public final List<String> tlsEllipticCurves;

    @Deprecated
    public final String uri;
    public final List<String> urls;
    public final String username;

    @Deprecated
    public IceServer(String paramString)
    {
      this(paramString, "", "");
    }

    @Deprecated
    public IceServer(String paramString1, String paramString2, String paramString3)
    {
      this(paramString1, paramString2, paramString3, PeerConnection.TlsCertPolicy.TLS_CERT_POLICY_SECURE);
    }

    @Deprecated
    public IceServer(String paramString1, String paramString2, String paramString3, PeerConnection.TlsCertPolicy paramTlsCertPolicy)
    {
      this(paramString1, paramString2, paramString3, paramTlsCertPolicy, "");
    }

    @Deprecated
    public IceServer(String paramString1, String paramString2, String paramString3, PeerConnection.TlsCertPolicy paramTlsCertPolicy, String paramString4)
    {
      this(paramString1, Collections.singletonList(paramString1), paramString2, paramString3, paramTlsCertPolicy, paramString4, null, null);
    }

    private IceServer(String paramString1, List<String> paramList1, String paramString2, String paramString3, PeerConnection.TlsCertPolicy paramTlsCertPolicy, String paramString4, List<String> paramList2, List<String> paramList3)
    {
      if ((paramString1 == null) || (paramList1 == null) || (paramList1.isEmpty()))
        throw new IllegalArgumentException("uri == null || urls == null || urls.isEmpty()");
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
        if ((String)localIterator.next() == null)
          throw new IllegalArgumentException("urls element is null: " + paramList1);
      if (paramString2 == null)
        throw new IllegalArgumentException("username == null");
      if (paramString3 == null)
        throw new IllegalArgumentException("password == null");
      if (paramString4 == null)
        throw new IllegalArgumentException("hostname == null");
      this.uri = paramString1;
      this.urls = paramList1;
      this.username = paramString2;
      this.password = paramString3;
      this.tlsCertPolicy = paramTlsCertPolicy;
      this.hostname = paramString4;
      this.tlsAlpnProtocols = paramList2;
      this.tlsEllipticCurves = paramList3;
    }

    public static Builder builder(String paramString)
    {
      return new Builder(Collections.singletonList(paramString), null);
    }

    public static Builder builder(List<String> paramList)
    {
      return new Builder(paramList, null);
    }

    @Nullable
    @CalledByNative("IceServer")
    String getHostname()
    {
      return this.hostname;
    }

    @Nullable
    @CalledByNative("IceServer")
    String getPassword()
    {
      return this.password;
    }

    @CalledByNative("IceServer")
    List<String> getTlsAlpnProtocols()
    {
      return this.tlsAlpnProtocols;
    }

    @CalledByNative("IceServer")
    PeerConnection.TlsCertPolicy getTlsCertPolicy()
    {
      return this.tlsCertPolicy;
    }

    @CalledByNative("IceServer")
    List<String> getTlsEllipticCurves()
    {
      return this.tlsEllipticCurves;
    }

    @Nullable
    @CalledByNative("IceServer")
    List<String> getUrls()
    {
      return this.urls;
    }

    @Nullable
    @CalledByNative("IceServer")
    String getUsername()
    {
      return this.username;
    }

    public String toString()
    {
      return this.urls + " [" + this.username + ":" + this.password + "] [" + this.tlsCertPolicy + "] [" + this.hostname + "] [" + this.tlsAlpnProtocols + "] [" + this.tlsEllipticCurves + "]";
    }

    public static class Builder
    {
      private String hostname = "";
      private String password = "";
      private List<String> tlsAlpnProtocols;
      private PeerConnection.TlsCertPolicy tlsCertPolicy = PeerConnection.TlsCertPolicy.TLS_CERT_POLICY_SECURE;
      private List<String> tlsEllipticCurves;

      @Nullable
      private final List<String> urls;
      private String username = "";

      private Builder(List<String> paramList)
      {
        if ((paramList == null) || (paramList.isEmpty()))
          throw new IllegalArgumentException("urls == null || urls.isEmpty(): " + paramList);
        this.urls = paramList;
      }

      public PeerConnection.IceServer createIceServer()
      {
        return new PeerConnection.IceServer((String)this.urls.get(0), this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves, null);
      }

      public Builder setHostname(String paramString)
      {
        this.hostname = paramString;
        return this;
      }

      public Builder setPassword(String paramString)
      {
        this.password = paramString;
        return this;
      }

      public Builder setTlsAlpnProtocols(List<String> paramList)
      {
        this.tlsAlpnProtocols = paramList;
        return this;
      }

      public Builder setTlsCertPolicy(PeerConnection.TlsCertPolicy paramTlsCertPolicy)
      {
        this.tlsCertPolicy = paramTlsCertPolicy;
        return this;
      }

      public Builder setTlsEllipticCurves(List<String> paramList)
      {
        this.tlsEllipticCurves = paramList;
        return this;
      }

      public Builder setUsername(String paramString)
      {
        this.username = paramString;
        return this;
      }
    }
  }

  public static enum IceTransportsType
  {
    static
    {
      NOHOST = new IceTransportsType("NOHOST", 2);
      ALL = new IceTransportsType("ALL", 3);
      IceTransportsType[] arrayOfIceTransportsType = new IceTransportsType[4];
      arrayOfIceTransportsType[0] = NONE;
      arrayOfIceTransportsType[1] = RELAY;
      arrayOfIceTransportsType[2] = NOHOST;
      arrayOfIceTransportsType[3] = ALL;
    }
  }

  public static class IntervalRange
  {
    private final int max;
    private final int min;

    public IntervalRange(int paramInt1, int paramInt2)
    {
      this.min = paramInt1;
      this.max = paramInt2;
    }

    @CalledByNative("IntervalRange")
    public int getMax()
    {
      return this.max;
    }

    @CalledByNative("IntervalRange")
    public int getMin()
    {
      return this.min;
    }
  }

  public static enum KeyType
  {
    static
    {
      ECDSA = new KeyType("ECDSA", 1);
      KeyType[] arrayOfKeyType = new KeyType[2];
      arrayOfKeyType[0] = RSA;
      arrayOfKeyType[1] = ECDSA;
    }
  }

  public static abstract interface Observer
  {
    @CalledByNative("Observer")
    public abstract void onAddStream(MediaStream paramMediaStream);

    @CalledByNative("Observer")
    public abstract void onAddTrack(RtpReceiver paramRtpReceiver, MediaStream[] paramArrayOfMediaStream);

    @CalledByNative("Observer")
    public abstract void onDataChannel(DataChannel paramDataChannel);

    @CalledByNative("Observer")
    public abstract void onIceCandidate(IceCandidate paramIceCandidate);

    @CalledByNative("Observer")
    public abstract void onIceCandidatesRemoved(IceCandidate[] paramArrayOfIceCandidate);

    @CalledByNative("Observer")
    public abstract void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState);

    @CalledByNative("Observer")
    public abstract void onIceConnectionReceivingChange(boolean paramBoolean);

    @CalledByNative("Observer")
    public abstract void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState);

    @CalledByNative("Observer")
    public abstract void onRemoveStream(MediaStream paramMediaStream);

    @CalledByNative("Observer")
    public abstract void onRenegotiationNeeded();

    @CalledByNative("Observer")
    public abstract void onSignalingChange(PeerConnection.SignalingState paramSignalingState);

    @CalledByNative("Observer")
    public abstract void onTrack(RtpTransceiver paramRtpTransceiver);
  }

  public static class RTCConfiguration
  {
    public boolean activeResetSrtpParams;
    public boolean audioJitterBufferFastAccelerate;
    public int audioJitterBufferMaxPackets;
    public PeerConnection.BundlePolicy bundlePolicy = PeerConnection.BundlePolicy.BALANCED;
    public PeerConnection.CandidateNetworkPolicy candidateNetworkPolicy = PeerConnection.CandidateNetworkPolicy.ALL;

    @Nullable
    public Boolean combinedAudioVideoBwe;
    public PeerConnection.ContinualGatheringPolicy continualGatheringPolicy;
    public boolean disableIPv6OnWifi;
    public boolean disableIpv6;
    public boolean enableCpuOveruseDetection;
    public boolean enableDscp;

    @Nullable
    public Boolean enableDtlsSrtp;
    public boolean enableRtpDataChannel;
    public int iceBackupCandidatePairPingInterval;
    public int iceCandidatePoolSize;

    @Nullable
    public Integer iceCheckIntervalStrongConnectivityMs;

    @Nullable
    public Integer iceCheckIntervalWeakConnectivityMs;

    @Nullable
    public Integer iceCheckMinInterval;
    public int iceConnectionReceivingTimeout;

    @Nullable
    public PeerConnection.IntervalRange iceRegatherIntervalRange;
    public List<PeerConnection.IceServer> iceServers;
    public PeerConnection.IceTransportsType iceTransportsType = PeerConnection.IceTransportsType.ALL;

    @Nullable
    public Integer iceUnwritableMinChecks;

    @Nullable
    public Integer iceUnwritableTimeMs;
    public PeerConnection.KeyType keyType;
    public int maxIPv6Networks;
    public PeerConnection.AdapterType networkPreference;
    public boolean presumeWritableWhenFullyRelayed;
    public boolean pruneTurnPorts;
    public PeerConnection.RtcpMuxPolicy rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;

    @Nullable
    public Integer screencastMinBitrate;
    public PeerConnection.SdpSemantics sdpSemantics;

    @Nullable
    public Integer stunCandidateKeepaliveIntervalMs;
    public boolean suspendBelowMinBitrate;
    public PeerConnection.TcpCandidatePolicy tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.ENABLED;

    @Nullable
    public TurnCustomizer turnCustomizer;

    public RTCConfiguration(List<PeerConnection.IceServer> paramList)
    {
      this.iceServers = paramList;
      this.audioJitterBufferMaxPackets = 50;
      this.audioJitterBufferFastAccelerate = false;
      this.iceConnectionReceivingTimeout = -1;
      this.iceBackupCandidatePairPingInterval = -1;
      this.keyType = PeerConnection.KeyType.ECDSA;
      this.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_ONCE;
      this.iceCandidatePoolSize = 0;
      this.pruneTurnPorts = false;
      this.presumeWritableWhenFullyRelayed = false;
      this.iceCheckIntervalStrongConnectivityMs = null;
      this.iceCheckIntervalWeakConnectivityMs = null;
      this.iceCheckMinInterval = null;
      this.iceUnwritableTimeMs = null;
      this.iceUnwritableMinChecks = null;
      this.stunCandidateKeepaliveIntervalMs = null;
      this.disableIPv6OnWifi = false;
      this.maxIPv6Networks = 5;
      this.iceRegatherIntervalRange = null;
      this.disableIpv6 = false;
      this.enableDscp = false;
      this.enableCpuOveruseDetection = true;
      this.enableRtpDataChannel = false;
      this.suspendBelowMinBitrate = false;
      this.screencastMinBitrate = null;
      this.combinedAudioVideoBwe = null;
      this.enableDtlsSrtp = null;
      this.networkPreference = PeerConnection.AdapterType.UNKNOWN;
      this.sdpSemantics = PeerConnection.SdpSemantics.PLAN_B;
      this.activeResetSrtpParams = false;
    }

    @CalledByNative("RTCConfiguration")
    boolean getActiveResetSrtpParams()
    {
      return this.activeResetSrtpParams;
    }

    @CalledByNative("RTCConfiguration")
    boolean getAudioJitterBufferFastAccelerate()
    {
      return this.audioJitterBufferFastAccelerate;
    }

    @CalledByNative("RTCConfiguration")
    int getAudioJitterBufferMaxPackets()
    {
      return this.audioJitterBufferMaxPackets;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.BundlePolicy getBundlePolicy()
    {
      return this.bundlePolicy;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.CandidateNetworkPolicy getCandidateNetworkPolicy()
    {
      return this.candidateNetworkPolicy;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Boolean getCombinedAudioVideoBwe()
    {
      return this.combinedAudioVideoBwe;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.ContinualGatheringPolicy getContinualGatheringPolicy()
    {
      return this.continualGatheringPolicy;
    }

    @CalledByNative("RTCConfiguration")
    boolean getDisableIPv6OnWifi()
    {
      return this.disableIPv6OnWifi;
    }

    @CalledByNative("RTCConfiguration")
    boolean getDisableIpv6()
    {
      return this.disableIpv6;
    }

    @CalledByNative("RTCConfiguration")
    boolean getEnableCpuOveruseDetection()
    {
      return this.enableCpuOveruseDetection;
    }

    @CalledByNative("RTCConfiguration")
    boolean getEnableDscp()
    {
      return this.enableDscp;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Boolean getEnableDtlsSrtp()
    {
      return this.enableDtlsSrtp;
    }

    @CalledByNative("RTCConfiguration")
    boolean getEnableRtpDataChannel()
    {
      return this.enableRtpDataChannel;
    }

    @CalledByNative("RTCConfiguration")
    int getIceBackupCandidatePairPingInterval()
    {
      return this.iceBackupCandidatePairPingInterval;
    }

    @CalledByNative("RTCConfiguration")
    int getIceCandidatePoolSize()
    {
      return this.iceCandidatePoolSize;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Integer getIceCheckIntervalStrongConnectivity()
    {
      return this.iceCheckIntervalStrongConnectivityMs;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Integer getIceCheckIntervalWeakConnectivity()
    {
      return this.iceCheckIntervalWeakConnectivityMs;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Integer getIceCheckMinInterval()
    {
      return this.iceCheckMinInterval;
    }

    @CalledByNative("RTCConfiguration")
    int getIceConnectionReceivingTimeout()
    {
      return this.iceConnectionReceivingTimeout;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    PeerConnection.IntervalRange getIceRegatherIntervalRange()
    {
      return this.iceRegatherIntervalRange;
    }

    @CalledByNative("RTCConfiguration")
    List<PeerConnection.IceServer> getIceServers()
    {
      return this.iceServers;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.IceTransportsType getIceTransportsType()
    {
      return this.iceTransportsType;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Integer getIceUnwritableMinChecks()
    {
      return this.iceUnwritableMinChecks;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Integer getIceUnwritableTimeout()
    {
      return this.iceUnwritableTimeMs;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.KeyType getKeyType()
    {
      return this.keyType;
    }

    @CalledByNative("RTCConfiguration")
    int getMaxIPv6Networks()
    {
      return this.maxIPv6Networks;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.AdapterType getNetworkPreference()
    {
      return this.networkPreference;
    }

    @CalledByNative("RTCConfiguration")
    boolean getPresumeWritableWhenFullyRelayed()
    {
      return this.presumeWritableWhenFullyRelayed;
    }

    @CalledByNative("RTCConfiguration")
    boolean getPruneTurnPorts()
    {
      return this.pruneTurnPorts;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.RtcpMuxPolicy getRtcpMuxPolicy()
    {
      return this.rtcpMuxPolicy;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Integer getScreencastMinBitrate()
    {
      return this.screencastMinBitrate;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.SdpSemantics getSdpSemantics()
    {
      return this.sdpSemantics;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    Integer getStunCandidateKeepaliveInterval()
    {
      return this.stunCandidateKeepaliveIntervalMs;
    }

    @CalledByNative("RTCConfiguration")
    boolean getSuspendBelowMinBitrate()
    {
      return this.suspendBelowMinBitrate;
    }

    @CalledByNative("RTCConfiguration")
    PeerConnection.TcpCandidatePolicy getTcpCandidatePolicy()
    {
      return this.tcpCandidatePolicy;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    TurnCustomizer getTurnCustomizer()
    {
      return this.turnCustomizer;
    }
  }

  public static enum RtcpMuxPolicy
  {
    static
    {
      RtcpMuxPolicy[] arrayOfRtcpMuxPolicy = new RtcpMuxPolicy[2];
      arrayOfRtcpMuxPolicy[0] = NEGOTIATE;
      arrayOfRtcpMuxPolicy[1] = REQUIRE;
    }
  }

  public static enum SdpSemantics
  {
    static
    {
      SdpSemantics[] arrayOfSdpSemantics = new SdpSemantics[2];
      arrayOfSdpSemantics[0] = PLAN_B;
      arrayOfSdpSemantics[1] = UNIFIED_PLAN;
    }
  }

  public static enum SignalingState
  {
    static
    {
      HAVE_LOCAL_OFFER = new SignalingState("HAVE_LOCAL_OFFER", 1);
      HAVE_LOCAL_PRANSWER = new SignalingState("HAVE_LOCAL_PRANSWER", 2);
      HAVE_REMOTE_OFFER = new SignalingState("HAVE_REMOTE_OFFER", 3);
      HAVE_REMOTE_PRANSWER = new SignalingState("HAVE_REMOTE_PRANSWER", 4);
      CLOSED = new SignalingState("CLOSED", 5);
      SignalingState[] arrayOfSignalingState = new SignalingState[6];
      arrayOfSignalingState[0] = STABLE;
      arrayOfSignalingState[1] = HAVE_LOCAL_OFFER;
      arrayOfSignalingState[2] = HAVE_LOCAL_PRANSWER;
      arrayOfSignalingState[3] = HAVE_REMOTE_OFFER;
      arrayOfSignalingState[4] = HAVE_REMOTE_PRANSWER;
      arrayOfSignalingState[5] = CLOSED;
    }

    @CalledByNative("SignalingState")
    static SignalingState fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }

  public static enum TcpCandidatePolicy
  {
    static
    {
      DISABLED = new TcpCandidatePolicy("DISABLED", 1);
      TcpCandidatePolicy[] arrayOfTcpCandidatePolicy = new TcpCandidatePolicy[2];
      arrayOfTcpCandidatePolicy[0] = ENABLED;
      arrayOfTcpCandidatePolicy[1] = DISABLED;
    }
  }

  public static enum TlsCertPolicy
  {
    static
    {
      TLS_CERT_POLICY_INSECURE_NO_CHECK = new TlsCertPolicy("TLS_CERT_POLICY_INSECURE_NO_CHECK", 1);
      TlsCertPolicy[] arrayOfTlsCertPolicy = new TlsCertPolicy[2];
      arrayOfTlsCertPolicy[0] = TLS_CERT_POLICY_SECURE;
      arrayOfTlsCertPolicy[1] = TLS_CERT_POLICY_INSECURE_NO_CHECK;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.PeerConnection
 * JD-Core Version:    0.6.2
 */