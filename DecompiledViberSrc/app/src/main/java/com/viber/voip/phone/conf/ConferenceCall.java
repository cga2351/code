package com.viber.voip.phone.conf;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.CallStatistics;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.phone.BasicRTCCall.Completion;
import com.viber.voip.phone.BasicRTCCall.SdpExtendedCallback;
import com.viber.voip.phone.conf.protocol.PeerID;
import com.viber.voip.phone.conf.protocol.PeerInfo;
import com.viber.voip.phone.conf.protocol.PeerInfo.PeerState;
import com.viber.voip.phone.conf.protocol.PeerInfo.PeerState.ConnectionStatus;
import com.viber.voip.phone.conf.protocol.PeerInfo.PeerState.DisconnectionReason;
import com.viber.voip.registration.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.webrtc.DataChannel;
import org.webrtc.DataChannel.Init;

public class ConferenceCall
  implements ConferenceConnectivityTracker.ConnectivityListener, DataChannelCoordinator.DccObserver, IConferenceCall.SnConferenceObserver, IConferenceCall.Ui, VoiceActivityUpdater.LevelUpdateCallback
{
  private static final int CLIP_LEVEL = 9000;
  private static final boolean DEBUG_REMOVE_RENOMITATION = true;
  private static final boolean DEBUG_SDP_FILE_OVERRIDER = false;
  private static final String DEFAULT_DATACHANNEL_ID = "default";
  private static final String EMPTY_JSON_ATTACHMENT = "{}";
  private static final Logger L = ViberEnv.getLogger();
  private RTCConfCall mCall;
  private long mConferenceCallToken = 0L;
  private String mConferenceId = "";
  private Set<String> mConnectedMemberIds;
  private ConferenceConnectivityTracker mConnectionTracker;
  private IConferenceCall.CreateConferenceCallback mCreateCallback = null;
  private DataChannel mDataChannel;
  private DataChannelCoordinator mDcCoordinator;
  private DominantDetector mDominantDetector;
  private final IConferenceCall.SnConferenceDelegate mIm2ServerDelegate;
  private IConferenceCall.JoinConferenceCallback mJoinCallback = null;
  private String mLastDominantSpeaker;
  private String mLatestSdpToApply = "";
  private String mLocalSdp;
  private final long mMyCid;
  private String mMyMemberId;
  private boolean mSdpApplicationInProgress = false;
  private final Object mSdpReapplyLock = new Object();
  private ConferenceStatsCollector mStatsUpdater;
  private Map<String, String> mTrackIdToMemberId;
  private ConferenceCallNotifier mUiNotifier;
  private VoiceActivityUpdater mVadUpdater;

  public ConferenceCall(IConferenceCall.SnConferenceDelegate paramSnConferenceDelegate, RTCConfCall paramRTCConfCall, long paramLong)
  {
    this.mMyCid = paramLong;
    this.mUiNotifier = new ConferenceCallNotifier();
    this.mStatsUpdater = new ConferenceStatsCollector();
    this.mDominantDetector = new DominantDetector();
    this.mConnectionTracker = new ConferenceConnectivityTracker(this);
    addUiDelegate(this.mStatsUpdater);
    this.mIm2ServerDelegate = paramSnConferenceDelegate;
    this.mIm2ServerDelegate.setObserver(this);
    this.mTrackIdToMemberId = new HashMap();
    this.mConnectedMemberIds = new HashSet();
    this.mMyMemberId = new af().l();
    this.mLastDominantSpeaker = this.mMyMemberId;
    if (paramRTCConfCall != null)
      setPeerConnection(paramRTCConfCall);
  }

  private void finishSdpApplication()
  {
    synchronized (this.mSdpReapplyLock)
    {
      this.mSdpApplicationInProgress = false;
      if (!this.mLatestSdpToApply.isEmpty())
      {
        String str = this.mLatestSdpToApply;
        this.mLatestSdpToApply = "";
        onSdpUpdateRequest(str);
      }
      return;
    }
  }

  private String getMidByTrackId(String paramString)
  {
    return (String)this.mTrackIdToMemberId.get(paramString);
  }

  private static float normalizeLevel(int paramInt)
  {
    return Math.min(9000, paramInt) / 9000.0F;
  }

  private void notifyUi(Collection<PeerInfo> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    label21: if (localIterator.hasNext())
    {
      PeerInfo localPeerInfo = (PeerInfo)localIterator.next();
      IConferenceCall.UiDelegate.PeerState localPeerState = IConferenceCall.UiDelegate.PeerState.UNKNOWN;
      IConferenceCall.UiDelegate.PeerDetailedState localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.UNKNOWN;
      switch (4.$SwitchMap$com$viber$voip$phone$conf$protocol$PeerInfo$PeerState[localPeerInfo.peerState.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        localArrayList.add(new IConferenceCall.UiDelegate.PeerInfo(localPeerInfo.peerID.memberID, localPeerState, localPeerDetailedState));
        break;
        localPeerState = IConferenceCall.UiDelegate.PeerState.CONNECTED;
        if (localPeerInfo.connectionStatus == null)
          break;
        switch (4.$SwitchMap$com$viber$voip$phone$conf$protocol$PeerInfo$PeerState$ConnectionStatus[localPeerInfo.connectionStatus.ordinal()])
        {
        default:
          localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.UNKNOWN;
          break;
        case 1:
          localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.ON_AIR;
          if ((localPeerInfo.isDominant != null) && (localPeerInfo.isDominant.booleanValue()))
            this.mLastDominantSpeaker = localPeerInfo.peerID.memberID;
          break;
        case 4:
          localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.CONNECTING;
          break;
        case 2:
          localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.ON_HOLD;
          break;
        case 3:
          localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.RECONNECTING;
          continue;
          localPeerState = IConferenceCall.UiDelegate.PeerState.DISCONNECTED;
          if (localPeerInfo.disconnectionReason == null)
            break label21;
          switch (4.$SwitchMap$com$viber$voip$phone$conf$protocol$PeerInfo$PeerState$DisconnectionReason[localPeerInfo.disconnectionReason.ordinal()])
          {
          default:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.UNKNOWN;
            break;
          case 1:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.UNKNOWN;
            break;
          case 2:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.INVITED;
            break;
          case 3:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.BUSY;
            break;
          case 4:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.DECLINED;
            break;
          case 5:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.UNAVAILABLE;
            break;
          case 6:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.HANG_UP;
            break;
          case 7:
            localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.CONNECTION_LOST;
          }
          break;
        }
      }
    }
    if (localArrayList.size() > 0)
      this.mUiNotifier.onPeersChanged(localArrayList);
  }

  private void setLocalSdp(String paramString, List<String> paramList)
  {
    this.mLocalSdp = paramString;
    if (this.mDcCoordinator != null)
      this.mDcCoordinator.setLocalOfferSdp(paramString, paramList);
  }

  private void updateMidToTrackIdMapping(Collection<PeerInfo> paramCollection)
  {
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      PeerInfo localPeerInfo = (PeerInfo)localIterator1.next();
      if (localPeerInfo.audioTracks != null)
      {
        Iterator localIterator4 = localPeerInfo.audioTracks.iterator();
        while (localIterator4.hasNext())
        {
          String str2 = (String)localIterator4.next();
          this.mTrackIdToMemberId.put(str2, localPeerInfo.peerID.memberID);
        }
      }
      switch (4.$SwitchMap$com$viber$voip$phone$conf$protocol$PeerInfo$PeerState[localPeerInfo.peerState.ordinal()])
      {
      default:
        break;
      case 1:
        if (localPeerInfo.connectionStatus != null)
          switch (4.$SwitchMap$com$viber$voip$phone$conf$protocol$PeerInfo$PeerState$ConnectionStatus[localPeerInfo.connectionStatus.ordinal()])
          {
          default:
            break;
          case 1:
            if (!this.mConnectedMemberIds.contains(localPeerInfo.peerID.memberID))
              this.mConnectedMemberIds.add(localPeerInfo.peerID.memberID);
            break;
          }
        break;
      case 2:
        if (this.mConnectedMemberIds.contains(localPeerInfo.peerID.memberID))
        {
          this.mConnectedMemberIds.remove(localPeerInfo.peerID.memberID);
          if (this.mConnectedMemberIds.size() <= 1)
            this.mUiNotifier.onLastPeerLeft(this);
        }
        HashSet localHashSet = new HashSet();
        Iterator localIterator2 = this.mTrackIdToMemberId.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          if (((String)localEntry.getValue()).equals(localPeerInfo.peerID.memberID))
            localHashSet.add(localEntry.getKey());
        }
        Iterator localIterator3 = localHashSet.iterator();
        while (localIterator3.hasNext())
        {
          String str1 = (String)localIterator3.next();
          this.mTrackIdToMemberId.remove(str1);
        }
      }
    }
  }

  public void addUiDelegate(IConferenceCall.UiDelegate paramUiDelegate)
  {
    this.mUiNotifier.addUiDelegate(paramUiDelegate);
  }

  public void createConference(String[] paramArrayOfString, int paramInt, IConferenceCall.CreateConferenceCallback paramCreateConferenceCallback)
  {
    this.mCreateCallback = paramCreateConferenceCallback;
    this.mIm2ServerDelegate.handleCreateConferenceCall(paramArrayOfString, "{}", paramInt);
  }

  public void deinit()
  {
    if (this.mConnectionTracker != null)
      this.mConnectionTracker.unsubscribe();
    if (this.mVadUpdater != null)
      this.mVadUpdater.dispose();
    if (this.mStatsUpdater != null)
      this.mStatsUpdater.dispose();
    if (this.mDataChannel != null)
      this.mDataChannel = null;
    if (this.mDcCoordinator != null)
    {
      this.mDcCoordinator.dispose();
      this.mDcCoordinator = null;
    }
    if (this.mCall != null)
    {
      this.mCall.deinitCall();
      this.mCall = null;
    }
    this.mUiNotifier.clear();
  }

  public long getCallToken()
  {
    return this.mConferenceCallToken;
  }

  public CallStatistics getStats()
  {
    return this.mStatsUpdater.getReport();
  }

  public void hold()
  {
    if ((this.mCall == null) || (this.mDcCoordinator == null))
      return;
    this.mDcCoordinator.hold();
  }

  public void invitePeers(String[] paramArrayOfString)
  {
    if ((this.mConferenceCallToken != 0L) && (!this.mLocalSdp.isEmpty()))
      this.mIm2ServerDelegate.handleInviteToConference(this.mConferenceCallToken, paramArrayOfString, "{}");
  }

  public void joinConference(long paramLong, IConferenceCall.JoinConferenceCallback paramJoinConferenceCallback)
  {
    this.mConferenceCallToken = paramLong;
    this.mJoinCallback = paramJoinConferenceCallback;
    this.mCall.startOutgoingCall(new BasicRTCCall.SdpExtendedCallback()
    {
      public void onError()
      {
        ConferenceCall.this.mJoinCallback.onJoinConference(false);
      }

      public void ready(String paramAnonymousString, List<String> paramAnonymousList1, List<String> paramAnonymousList2)
      {
        ConferenceCall.this.setLocalSdp(paramAnonymousString, paramAnonymousList1);
        if ((ConferenceCall.this.mConferenceCallToken != 0L) && (!ConferenceCall.this.mLocalSdp.isEmpty()))
          ConferenceCall.this.mIm2ServerDelegate.handleJoinConferenceCall(ConferenceCall.this.mConferenceCallToken, ConferenceCall.this.mLocalSdp, "{}");
      }
    });
  }

  public void leaveConference()
  {
    if (this.mDcCoordinator != null)
      this.mDcCoordinator.bye();
  }

  public void mute()
  {
    if ((this.mCall == null) || (this.mDcCoordinator == null))
      return;
    this.mCall.mute();
    this.mDcCoordinator.mute();
  }

  public void onConnected()
  {
    DataChannelCoordinator localDataChannelCoordinator = this.mDcCoordinator;
    boolean bool = false;
    if (localDataChannelCoordinator != null)
      bool = this.mDcCoordinator.isOnHold();
    ConferenceCallNotifier localConferenceCallNotifier = this.mUiNotifier;
    String str = this.mMyMemberId;
    IConferenceCall.UiDelegate.PeerState localPeerState = IConferenceCall.UiDelegate.PeerState.CONNECTED;
    if (!bool);
    for (IConferenceCall.UiDelegate.PeerDetailedState localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.ON_AIR; ; localPeerDetailedState = IConferenceCall.UiDelegate.PeerDetailedState.ON_HOLD)
    {
      localConferenceCallNotifier.onPeersChanged(Collections.singleton(new IConferenceCall.UiDelegate.PeerInfo(str, localPeerState, localPeerDetailedState)));
      return;
    }
  }

  public void onCreateConference(int paramInt, String paramString, long paramLong, Map<String, Integer> paramMap)
  {
    this.mConferenceId = paramString;
    if (this.mDcCoordinator != null)
      this.mDcCoordinator.setConferenceId(paramString);
    IConferenceCall.UiDelegate.CreationStatus localCreationStatus = IConferenceCall.UiDelegate.CreationStatus.SUCCESS;
    if (paramInt != 0)
      localCreationStatus = IConferenceCall.UiDelegate.CreationStatus.FAILED_TO_CREATE;
    this.mConferenceCallToken = paramLong;
    this.mUiNotifier.onConferenceCreated(paramInt, paramLong, paramMap);
    this.mCreateCallback.onConferenceCreated(localCreationStatus, paramLong, paramString);
  }

  public void onDisconnected()
  {
    this.mUiNotifier.onDisconnected();
  }

  public void onFirstPeerMessage(String paramString)
  {
    this.mUiNotifier.onFirstPeerJoined(this, paramString);
    this.mVadUpdater = new VoiceActivityUpdater(this);
    this.mCall.startGatherStats();
  }

  public void onInviteToConverenceReply(int paramInt, Map<String, Integer> paramMap, String paramString)
  {
    this.mUiNotifier.onPeersInvited(paramInt, paramMap);
  }

  public void onJoinConference(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((this.mCall == null) || (this.mDcCoordinator == null) || (paramInt != 0))
    {
      if (this.mJoinCallback != null)
        this.mJoinCallback.onJoinConference(false);
      return;
    }
    this.mDcCoordinator.setConferenceId(paramString1);
    String str = paramString2.replace(" renomination", "");
    this.mStatsUpdater.onCallTokenChanged(paramLong);
    this.mCall.applySdpAnswer(str, null, new BasicRTCCall.Completion()
    {
      public void onFailure()
      {
        if (ConferenceCall.this.mJoinCallback != null)
          ConferenceCall.this.mJoinCallback.onJoinConference(false);
      }

      public void onSuccess()
      {
        if (ConferenceCall.this.mJoinCallback != null)
          ConferenceCall.this.mJoinCallback.onJoinConference(true);
      }
    });
  }

  public void onLevelsUpdated(Map<String, Integer> paramMap, int paramInt)
  {
    av.a(av.e.g).post(new ConferenceCall..Lambda.2(this, paramMap, paramInt));
  }

  public void onPeerConnectionRestartNeeded()
  {
    this.mCall.deinitCall();
    setPeerConnection(null);
    this.mUiNotifier.onNewPeerConnectionNeeded();
  }

  public void onReconnecting()
  {
    this.mUiNotifier.onPeersChanged(Collections.singleton(new IConferenceCall.UiDelegate.PeerInfo(this.mMyMemberId, IConferenceCall.UiDelegate.PeerState.CONNECTED, IConferenceCall.UiDelegate.PeerDetailedState.RECONNECTING)));
  }

  public void onSdpUpdateRequest(String paramString)
  {
    av.a(av.e.g).post(new ConferenceCall..Lambda.1(this, paramString));
  }

  public void onStateChanged(Collection<PeerInfo> paramCollection)
  {
    updateMidToTrackIdMapping(paramCollection);
    notifyUi(paramCollection);
    this.mStatsUpdater.onPeersCountChanged(this.mConnectedMemberIds.size());
  }

  public void removeUiDelegate(IConferenceCall.UiDelegate paramUiDelegate)
  {
    this.mUiNotifier.removeUiDelegate(paramUiDelegate);
  }

  public void resetPeerConnection(RTCConfCall paramRTCConfCall)
  {
    setPeerConnection(paramRTCConfCall);
    joinConference(this.mConferenceCallToken, new ConferenceCall..Lambda.3(this));
  }

  public void setPeerConnection(RTCConfCall paramRTCConfCall)
  {
    this.mCall = paramRTCConfCall;
    if (this.mCall == null)
    {
      this.mDataChannel = null;
      return;
    }
    this.mConnectionTracker.subscribeToConnectivityChange(this.mCall);
    DataChannel.Init localInit = new DataChannel.Init();
    localInit.id = 0;
    this.mCall.createDataChannel("default", localInit, new ConferenceCall..Lambda.0(this));
  }

  public void unhold()
  {
    if ((this.mCall == null) || (this.mDcCoordinator == null))
      return;
    this.mDcCoordinator.unhold();
  }

  public void unmute()
  {
    if ((this.mCall == null) || (this.mDcCoordinator == null))
      return;
    this.mCall.unmute();
    this.mDcCoordinator.unmute();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ConferenceCall
 * JD-Core Version:    0.6.2
 */