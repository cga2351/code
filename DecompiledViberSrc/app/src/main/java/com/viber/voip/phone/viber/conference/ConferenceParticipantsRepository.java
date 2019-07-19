package com.viber.voip.phone.viber.conference;

import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState..CC;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.model.entity.m;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.CallType;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore;
import com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore.Listener;
import com.viber.voip.phone.conf.ConferenceCall;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate..CC;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerDetailedState;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerInfo;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerState;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.phone.viber.conference.model.ConferenceCallStatus;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantRepositoryEntity;
import com.viber.voip.registration.af;
import com.viber.voip.util.ca;
import com.viber.voip.util.da;
import com.viber.voip.util.n;
import com.viber.voip.util.u;
import com.viber.voip.util.w;
import dagger.a;
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
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ConferenceParticipantsRepository
{
  private static final Logger L = ViberEnv.getLogger();
  private final Handler mBackgroundExecutor;
  private final CallHandler mCallHandler;
  private final CallHandler.CallInfoReadyListener mCallInfoReadyListener = new CallHandler.CallInfoReadyListener()
  {
    public void onCallInfoReady(CallInfo paramAnonymousCallInfo)
    {
      ConferenceParticipantsRepository.this.mCurrentConferenceParticipants.clear();
      if (!paramAnonymousCallInfo.isConference());
      ConferenceInfo localConferenceInfo;
      do
      {
        return;
        localConferenceInfo = paramAnonymousCallInfo.getCallerInfo().getConferenceInfo();
      }
      while (localConferenceInfo == null);
      ConferenceParticipant[] arrayOfConferenceParticipant = localConferenceInfo.getParticipants();
      ArrayList localArrayList = new ArrayList(arrayOfConferenceParticipant.length);
      int i = arrayOfConferenceParticipant.length;
      int j = 0;
      if (j < i)
      {
        String str = arrayOfConferenceParticipant[j].getMemberId();
        if (CallInfo.CallType.OUTGOING == paramAnonymousCallInfo.getType());
        for (IConferenceCall.UiDelegate.PeerInfo localPeerInfo = new IConferenceCall.UiDelegate.PeerInfo(str, IConferenceCall.UiDelegate.PeerState.DISCONNECTED, IConferenceCall.UiDelegate.PeerDetailedState.INVITED); ; localPeerInfo = new IConferenceCall.UiDelegate.PeerInfo(str, IConferenceCall.UiDelegate.PeerState.DISCONNECTED, IConferenceCall.UiDelegate.PeerDetailedState.UNKNOWN))
        {
          localArrayList.add(localPeerInfo);
          j++;
          break;
        }
      }
      ConferenceParticipantsRepository.this.mBackgroundExecutor.post(new ConferenceParticipantsRepository.2..Lambda.0(this, localArrayList));
    }
  };
  private final IConferenceCall.UiDelegate mCallback = new IConferenceCall.UiDelegate()
  {
    public void onConferenceCreated(int paramAnonymousInt, long paramAnonymousLong, Map paramAnonymousMap)
    {
      IConferenceCall.UiDelegate..CC.onConferenceCreated(this, paramAnonymousInt, paramAnonymousLong, paramAnonymousMap);
    }

    public void onDisconnected()
    {
      IConferenceCall.UiDelegate..CC.onDisconnected(this);
    }

    public void onFirstPeerJoined(ConferenceCall paramAnonymousConferenceCall, String paramAnonymousString)
    {
      IConferenceCall.UiDelegate..CC.onFirstPeerJoined(this, paramAnonymousConferenceCall, paramAnonymousString);
    }

    public void onLastPeerLeft(ConferenceCall paramAnonymousConferenceCall)
    {
      IConferenceCall.UiDelegate..CC.onLastPeerLeft(this, paramAnonymousConferenceCall);
    }

    public void onNewPeerConnectionNeeded()
    {
      IConferenceCall.UiDelegate..CC.onNewPeerConnectionNeeded(this);
    }

    public void onPeersChanged(Collection<IConferenceCall.UiDelegate.PeerInfo> paramAnonymousCollection)
    {
      ConferenceParticipantsRepository.this.mBackgroundExecutor.post(new ConferenceParticipantsRepository.1..Lambda.0(this, paramAnonymousCollection));
    }

    public void onPeersInvited(int paramAnonymousInt, Map paramAnonymousMap)
    {
      IConferenceCall.UiDelegate..CC.onPeersInvited(this, paramAnonymousInt, paramAnonymousMap);
    }

    public void onVolumeLevelChanged(Map paramAnonymousMap, String paramAnonymousString)
    {
      IConferenceCall.UiDelegate..CC.onVolumeLevelChanged(this, paramAnonymousMap, paramAnonymousString);
    }
  };
  private final ConferenceInitializationListenersStore.Listener mConferenceInitializationListener = new ConferenceParticipantsRepository..Lambda.0(this);
  final Map<String, ConferenceParticipantRepositoryEntity> mCurrentConferenceParticipants = new ConcurrentHashMap();
  private final DialerControllerDelegate.DialerLocalCallState mDialerLocalCallState = new DialerControllerDelegate.DialerLocalCallState()
  {
    public void onCallEnded(long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ConferenceParticipantsRepository.this.mCurrentConferenceParticipants.clear();
    }

    public void onCallStarted(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
    {
      DialerControllerDelegate.DialerLocalCallState..CC.onCallStarted(this, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousInt);
    }

    public void onHangup()
    {
      DialerControllerDelegate.DialerLocalCallState..CC.onHangup(this);
    }
  };
  private final DialerLocalCallStateListener mDialerLocalCallStateListener;
  private final Handler mMainExecutor;
  private final ConferenceParticipantMapper mParticipantMapper;
  private final Set<OnParticipantsLoadedListener> mParticipantsLoadedListeners = Collections.newSetFromMap(new WeakHashMap());
  private final af mRegistrationValues;
  private final a<ci> mUserDataController;

  @Inject
  public ConferenceParticipantsRepository(af paramaf, CallHandler paramCallHandler, Handler paramHandler1, Handler paramHandler2, ConferenceParticipantMapper paramConferenceParticipantMapper, a<ci> parama, DialerLocalCallStateListener paramDialerLocalCallStateListener)
  {
    this.mRegistrationValues = paramaf;
    this.mCallHandler = paramCallHandler;
    this.mMainExecutor = paramHandler1;
    this.mBackgroundExecutor = paramHandler2;
    this.mParticipantMapper = paramConferenceParticipantMapper;
    this.mUserDataController = parama;
    this.mDialerLocalCallStateListener = paramDialerLocalCallStateListener;
  }

  private void changeListenersRegistration(boolean paramBoolean)
  {
    ConferenceCall localConferenceCall = this.mCallHandler.getCurrentConferenceCall();
    if (localConferenceCall == null);
    do
    {
      return;
      localConferenceCall.removeUiDelegate(this.mCallback);
    }
    while (!paramBoolean);
    localConferenceCall.addUiDelegate(this.mCallback);
  }

  private ConferenceParticipant createConferenceParticipant(Map<String, ConferenceParticipantRepositoryEntity> paramMap, String paramString1, String paramString2)
  {
    ConferenceParticipant localConferenceParticipant = new ConferenceParticipant();
    localConferenceParticipant.setMemberId(paramString1);
    ConferenceParticipantRepositoryEntity localConferenceParticipantRepositoryEntity = (ConferenceParticipantRepositoryEntity)paramMap.get(paramString1);
    if (localConferenceParticipantRepositoryEntity == null)
    {
      localConferenceParticipant.setName(paramString2);
      if (localConferenceParticipantRepositoryEntity != null)
        if (localConferenceParticipantRepositoryEntity.photo == null)
          break label88;
    }
    label88: for (String str = localConferenceParticipantRepositoryEntity.photo.toString(); ; str = null)
    {
      localConferenceParticipant.setImage(str);
      return localConferenceParticipant;
      localConferenceParticipant.setName(ca.a(localConferenceParticipantRepositoryEntity.displayName, paramString2));
      break;
    }
  }

  private boolean hasParticipantsLoadedListener(OnParticipantsLoadedListener paramOnParticipantsLoadedListener)
  {
    synchronized (this.mParticipantsLoadedListeners)
    {
      boolean bool = this.mParticipantsLoadedListeners.contains(paramOnParticipantsLoadedListener);
      return bool;
    }
  }

  private void notifyParticipantsListChanged(Collection<ConferenceParticipantRepositoryEntity> paramCollection)
  {
    int i = 0;
    synchronized (this.mParticipantsLoadedListeners)
    {
      OnParticipantsLoadedListener[] arrayOfOnParticipantsLoadedListener = (OnParticipantsLoadedListener[])this.mParticipantsLoadedListeners.toArray(new OnParticipantsLoadedListener[0]);
      List localList = Collections.unmodifiableList(new ArrayList(paramCollection));
      int j = arrayOfOnParticipantsLoadedListener.length;
      if (i < j)
      {
        OnParticipantsLoadedListener localOnParticipantsLoadedListener = arrayOfOnParticipantsLoadedListener[i];
        if ((localOnParticipantsLoadedListener != null) && (hasParticipantsLoadedListener(localOnParticipantsLoadedListener)))
          this.mMainExecutor.post(new ConferenceParticipantsRepository..Lambda.4(localOnParticipantsLoadedListener, localList));
        i++;
      }
    }
  }

  private void onPeerListUpdated(Collection<IConferenceCall.UiDelegate.PeerInfo> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      IConferenceCall.UiDelegate.PeerInfo localPeerInfo2 = (IConferenceCall.UiDelegate.PeerInfo)localIterator1.next();
      String str = localPeerInfo2.memberId;
      ConferenceParticipantRepositoryEntity localConferenceParticipantRepositoryEntity2 = (ConferenceParticipantRepositoryEntity)this.mCurrentConferenceParticipants.get(str);
      if ((localConferenceParticipantRepositoryEntity2 == null) || (!localConferenceParticipantRepositoryEntity2.callStatus.isSame(localPeerInfo2)))
        if (this.mRegistrationValues.l().equals(str))
          this.mCurrentConferenceParticipants.put(str, this.mParticipantMapper.mapToRepositoryEntity(localPeerInfo2, str));
        else if (localConferenceParticipantRepositoryEntity2 == null)
          localHashMap.put(str, localPeerInfo2);
        else
          this.mCurrentConferenceParticipants.put(str, this.mParticipantMapper.mapToRepositoryEntity(localConferenceParticipantRepositoryEntity2, localPeerInfo2));
    }
    Iterator localIterator2 = loadParticipantInfos(localHashMap.keySet()).values().iterator();
    while (localIterator2.hasNext())
    {
      ConferenceParticipantRepositoryEntity localConferenceParticipantRepositoryEntity1 = (ConferenceParticipantRepositoryEntity)localIterator2.next();
      IConferenceCall.UiDelegate.PeerInfo localPeerInfo1 = (IConferenceCall.UiDelegate.PeerInfo)localHashMap.get(localConferenceParticipantRepositoryEntity1.memberId);
      this.mCurrentConferenceParticipants.put(localConferenceParticipantRepositoryEntity1.memberId, this.mParticipantMapper.mapToRepositoryEntity(localConferenceParticipantRepositoryEntity1, localPeerInfo1));
    }
    Collection localCollection = this.mCurrentConferenceParticipants.values();
    updateConferenceInfoParticipants(localCollection);
    notifyParticipantsListChanged(localCollection);
  }

  private void updateConferenceInfoParticipants(Collection<ConferenceParticipantRepositoryEntity> paramCollection)
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if (localCallInfo != null);
    for (CallerInfo localCallerInfo = localCallInfo.getCallerInfo(); ; localCallerInfo = null)
    {
      if (localCallerInfo != null)
      {
        List localList = u.a(paramCollection, new ConferenceParticipantsRepository..Lambda.2(this));
        ConferenceParticipantMapper localConferenceParticipantMapper = this.mParticipantMapper;
        localConferenceParticipantMapper.getClass();
        localCallerInfo.updateConferenceInfoParticipants((ConferenceParticipant[])n.a(ConferenceParticipant.class, localList, ConferenceParticipantsRepository..Lambda.3.get$Lambda(localConferenceParticipantMapper)));
      }
      return;
    }
  }

  private Map<String, m> updateParticipantInfos(Collection<String> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    if (paramCollection.isEmpty())
      return localHashMap;
    FetchParticipantInfosFuture localFetchParticipantInfosFuture = new FetchParticipantInfosFuture(null);
    ((ci)this.mUserDataController.get()).a(new HashSet(paramCollection), localFetchParticipantInfosFuture, true);
    m[] arrayOfm = (m[])localFetchParticipantInfosFuture.getSafe();
    if (arrayOfm != null)
    {
      int i = arrayOfm.length;
      for (int j = 0; j < i; j++)
      {
        m localm = arrayOfm[j];
        localHashMap.put(localm.a(), localm);
      }
    }
    return localHashMap;
  }

  public void initialize()
  {
    this.mCallHandler.getConferenceInitializationListenersStore().registerListener(this.mConferenceInitializationListener);
    this.mCallHandler.addCallInfoReadyListener(this.mCallInfoReadyListener);
    this.mDialerLocalCallStateListener.registerDelegate(this.mDialerLocalCallState, this.mBackgroundExecutor);
  }

  public ConferenceInfo loadConferenceInfo(String paramString, Map<String, String> paramMap)
  {
    if (u.a(paramMap))
      return null;
    Map localMap = loadParticipantInfos(paramMap.keySet());
    ConferenceInfo localConferenceInfo = new ConferenceInfo();
    ArrayList localArrayList = new ArrayList();
    if ((!da.a(paramString)) && (paramMap.containsKey(paramString)))
      localArrayList.add(createConferenceParticipant(localMap, paramString, (String)paramMap.remove(paramString)));
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(createConferenceParticipant(localMap, (String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    localConferenceInfo.setParticipants((ConferenceParticipant[])localArrayList.toArray(new ConferenceParticipant[0]));
    return localConferenceInfo;
  }

  public ConferenceInfo loadConferenceInfo(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return loadConferenceInfo(paramString1, u.a(paramArrayOfString, new ConferenceParticipantsRepository..Lambda.1(paramString2)));
  }

  public Map<String, ConferenceParticipantRepositoryEntity> loadParticipantInfos(Collection<String> paramCollection)
  {
    HashMap localHashMap = new HashMap(paramCollection.size());
    Map localMap = updateParticipantInfos(paramCollection);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      m localm = (m)localMap.get(str);
      localHashMap.put(str, this.mParticipantMapper.mapToRepositoryEntity(localm, str));
    }
    return localHashMap;
  }

  public final void registerOngoingConferenceParticipantsLoadedListener(OnParticipantsLoadedListener paramOnParticipantsLoadedListener)
  {
    synchronized (this.mParticipantsLoadedListeners)
    {
      this.mParticipantsLoadedListeners.add(paramOnParticipantsLoadedListener);
      if (!this.mCurrentConferenceParticipants.isEmpty())
        notifyParticipantsListChanged(this.mCurrentConferenceParticipants.values());
      return;
    }
  }

  public final void unregisterOngoingConferenceParticipantsLoadedListener(OnParticipantsLoadedListener paramOnParticipantsLoadedListener)
  {
    synchronized (this.mParticipantsLoadedListeners)
    {
      this.mParticipantsLoadedListeners.remove(paramOnParticipantsLoadedListener);
      return;
    }
  }

  private static class FetchParticipantInfosFuture extends w<m[]>
    implements ci.a
  {
    public void onGetUserDetail(m[] paramArrayOfm)
    {
      setResult(paramArrayOfm);
    }

    public void onGetUserError()
    {
      setResult(null);
    }
  }

  public static abstract interface OnParticipantsLoadedListener
  {
    public abstract void onParticipantsUpdated(List<ConferenceParticipantRepositoryEntity> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository
 * JD-Core Version:    0.6.2
 */