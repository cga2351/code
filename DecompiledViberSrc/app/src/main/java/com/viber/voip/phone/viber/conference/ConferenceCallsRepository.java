package com.viber.voip.phone.viber.conference;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.CMissedCall;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.b;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.model.entity.h;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore;
import com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore.Listener;
import com.viber.voip.phone.conf.ConferenceCall;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate..CC;
import com.viber.voip.phone.viber.conference.data.ConferenceCallsDatabaseHelper;
import com.viber.voip.phone.viber.conference.mapper.ConferenceCallMapper;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallEntity;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.registration.af;
import com.viber.voip.util.ca;
import com.viber.voip.util.cn;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.da;
import com.viber.voip.util.dd;
import com.viber.voip.util.i;
import com.viber.voip.util.i.e;
import com.viber.voip.util.n;
import com.viber.voip.util.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ConferenceCallsRepository
{
  private static final long CONFERENCE_EXPIRE_TIME_MILLIS = TimeUnit.HOURS.toMillis(2L);
  private static final Logger L = ViberEnv.getLogger();
  private final d mAppBackgroundChecker;
  private final d.b mAppStateListener = new d.b()
  {
    public void onAppStopped()
    {
      i.c(this);
    }

    public void onBackground()
    {
      i.a(this);
    }

    public void onForeground()
    {
      i.b(this);
    }

    public void onForegroundStateChanged(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
        ConferenceCallsRepository.this.mBackgroundExecutor.post(ConferenceCallsRepository.this.mClearInvalidConferencesOnForegroundAction);
    }
  };
  final Map<Long, OngoingConferenceCallModel> mAvailableConferencesIdsMapping = new ConcurrentHashMap();
  final Map<Long, OngoingConferenceCallModel> mAvailableConferencesTokensMapping = new ConcurrentHashMap();
  private Handler mBackgroundExecutor;
  private CallHandler mCallHandler;
  private final CallHandler.CallInfoReadyListener mCallInfoReadyListener = new ConferenceCallsRepository..Lambda.2(this);
  private final Observer mCallerInfoObserver = new ConferenceCallsRepository..Lambda.3(this);
  private final Runnable mClearInvalidConferencesOnForegroundAction = new ConferenceCallsRepository..Lambda.1(this);
  private final Set<ConferenceAvailabilityListener> mConferenceAvailabilityListeners = Collections.newSetFromMap(new WeakHashMap());
  private final ConferenceCallMapper mConferenceCallMapper;
  private final IConferenceCall.UiDelegate mConferenceCallback = new IConferenceCall.UiDelegate()
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
      CallInfo localCallInfo = ConferenceCallsRepository.this.mCallHandler.getLastCallInfo();
      if (localCallInfo == null);
      CallerInfo localCallerInfo;
      ConferenceInfo localConferenceInfo;
      do
      {
        do
        {
          return;
          localCallerInfo = localCallInfo.getCallerInfo();
        }
        while (localCallerInfo == null);
        localConferenceInfo = localCallerInfo.getConferenceInfo();
      }
      while (localConferenceInfo == null);
      ConferenceCallsRepository.this.mBackgroundExecutor.post(new ConferenceCallsRepository.2..Lambda.0(this, localCallInfo, paramAnonymousString, paramAnonymousConferenceCall, localCallerInfo, localConferenceInfo));
    }

    public void onLastPeerLeft(ConferenceCall paramAnonymousConferenceCall)
    {
      IConferenceCall.UiDelegate..CC.onLastPeerLeft(this, paramAnonymousConferenceCall);
    }

    public void onNewPeerConnectionNeeded()
    {
      IConferenceCall.UiDelegate..CC.onNewPeerConnectionNeeded(this);
    }

    public void onPeersChanged(Collection paramAnonymousCollection)
    {
      IConferenceCall.UiDelegate..CC.onPeersChanged(this, paramAnonymousCollection);
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
  private final ConferenceCallsDatabaseHelper mConferenceDatabase;
  private final ConferenceInitializationListenersStore.Listener mConferenceInitializationListener = new ConferenceInitializationListenersStore.Listener()
  {
    public void onConferenceDeinitialized(ConferenceCall paramAnonymousConferenceCall)
    {
      ConferenceCallsRepository.this.notifyConferencesAvailabilityChanged(ConferenceCallsRepository.this.mAvailableConferencesIdsMapping, true);
    }

    public void onConferenceInitialized(ConferenceCall paramAnonymousConferenceCall)
    {
      ConferenceCallsRepository.this.changeConferenceCallListenersRegistration(true);
    }
  };
  private final z mConversationQueryHelper;
  private final EngineDelegatesManager mDelegatesManager;
  private final Runnable mInitializeAllConferencesAction = new ConferenceCallsRepository..Lambda.0(this);
  private final b<ConferenceInfo> mJsonSerializer;
  private final Handler mMainExecutor;
  private final bs mMessageEditHelper;
  private final ConferenceParticipantsRepository mParticipantsRepository;
  private final PhoneControllerDelegateAdapter mPhoneControllerDelegateAdapter = new PhoneControllerDelegateAdapter()
  {
    private void onMissedCall(int paramAnonymousInt1, long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, long paramAnonymousLong2, String[] paramAnonymousArrayOfString)
    {
      if (3 != paramAnonymousInt1)
        return;
      switch (paramAnonymousInt2)
      {
      default:
        return;
      case 0:
        ConferenceCallsRepository.this.onMissedConferenceInProgress(paramAnonymousLong1, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong2, paramAnonymousArrayOfString);
        return;
      case 1:
      case 2:
      case 3:
      }
      ConferenceCallsRepository.this.onConferenceUnavailable(paramAnonymousLong1);
    }

    public void onCallMissed(long paramAnonymousLong1, String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2, int paramAnonymousInt3, String paramAnonymousString3, int paramAnonymousInt4, String[] paramAnonymousArrayOfString, String paramAnonymousString4, long paramAnonymousLong2, long paramAnonymousLong3)
    {
      onMissedCall(paramAnonymousInt3, paramAnonymousLong1, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt4, paramAnonymousLong3, paramAnonymousArrayOfString);
    }

    public boolean onGetMissedCalls(CMissedCall[] paramAnonymousArrayOfCMissedCall)
    {
      int i = paramAnonymousArrayOfCMissedCall.length;
      for (int j = 0; j < i; j++)
      {
        CMissedCall localCMissedCall = paramAnonymousArrayOfCMissedCall[j];
        onMissedCall(localCMissedCall.getCallType(), localCMissedCall.getToken(), localCMissedCall.getMemberId(), localCMissedCall.getPhoneNumber(), localCMissedCall.getConferenceState(), localCMissedCall.getDuration(), localCMissedCall.getConferenceMemberIDs());
      }
      return false;
    }
  };
  private final af mRegistrationValues;
  private final cn mResourcesProvider;
  private final e mTimeProvider;

  @Inject
  public ConferenceCallsRepository(CallHandler paramCallHandler, EngineDelegatesManager paramEngineDelegatesManager, ConferenceCallMapper paramConferenceCallMapper, ConferenceCallsDatabaseHelper paramConferenceCallsDatabaseHelper, Handler paramHandler1, Handler paramHandler2, b<ConferenceInfo> paramb, d paramd, z paramz, bs parambs, ConferenceParticipantsRepository paramConferenceParticipantsRepository, cn paramcn, af paramaf, e parame)
  {
    this.mCallHandler = paramCallHandler;
    this.mDelegatesManager = paramEngineDelegatesManager;
    this.mConferenceCallMapper = paramConferenceCallMapper;
    this.mConferenceDatabase = paramConferenceCallsDatabaseHelper;
    this.mMainExecutor = paramHandler1;
    this.mBackgroundExecutor = paramHandler2;
    this.mJsonSerializer = paramb;
    this.mAppBackgroundChecker = paramd;
    this.mConversationQueryHelper = paramz;
    this.mMessageEditHelper = parambs;
    this.mParticipantsRepository = paramConferenceParticipantsRepository;
    this.mResourcesProvider = paramcn;
    this.mRegistrationValues = paramaf;
    this.mTimeProvider = parame;
  }

  private void changeCallerInfoObserversRegistration(boolean paramBoolean)
  {
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    CallerInfo localCallerInfo;
    if (localCallInfo != null)
    {
      localCallerInfo = localCallInfo.getCallerInfo();
      if (localCallerInfo != null)
        break label27;
    }
    label27: 
    do
    {
      return;
      localCallerInfo = null;
      break;
      localCallerInfo.deleteObserver(this.mCallerInfoObserver);
    }
    while (!paramBoolean);
    localCallerInfo.addObserver(this.mCallerInfoObserver);
  }

  private void changeConferenceCallListenersRegistration(boolean paramBoolean)
  {
    ConferenceCall localConferenceCall = this.mCallHandler.getCurrentConferenceCall();
    if (localConferenceCall == null);
    do
    {
      return;
      localConferenceCall.removeUiDelegate(this.mConferenceCallback);
    }
    while (!paramBoolean);
    localConferenceCall.addUiDelegate(this.mConferenceCallback);
  }

  private List<OngoingConferenceCallModel> clearDatabaseInvalidConferences()
  {
    Set localSet = this.mConversationQueryHelper.g();
    List localList = this.mConferenceDatabase.loadInvalidConferences(localSet, CONFERENCE_EXPIRE_TIME_MILLIS);
    OngoingConferenceCallModel localOngoingConferenceCallModel1 = getConferenceTalkingTo();
    ArrayList localArrayList1 = new ArrayList(localList.size());
    ArrayList localArrayList2 = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      OngoingConferenceCallEntity localOngoingConferenceCallEntity = (OngoingConferenceCallEntity)localIterator.next();
      OngoingConferenceCallModel localOngoingConferenceCallModel2 = this.mConferenceCallMapper.mapToModel(localOngoingConferenceCallEntity);
      if ((localOngoingConferenceCallModel1 == null) || (localOngoingConferenceCallModel1.callToken != localOngoingConferenceCallEntity.callToken))
      {
        localArrayList1.add(localOngoingConferenceCallModel2);
        localArrayList2.add(Long.valueOf(localOngoingConferenceCallEntity.id));
      }
    }
    this.mConferenceDatabase.removeConferencesByIds(localArrayList2);
    return localArrayList1;
  }

  @SuppressLint({"all"})
  private void clearInvalidConferencesOnBecomeAlive()
  {
    List localList = clearDatabaseInvalidConferences();
    HashMap localHashMap = new HashMap(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      OngoingConferenceCallModel localOngoingConferenceCallModel = (OngoingConferenceCallModel)localIterator.next();
      localHashMap.put(Long.valueOf(localOngoingConferenceCallModel.conversationId), localOngoingConferenceCallModel);
      this.mAvailableConferencesIdsMapping.remove(Long.valueOf(localOngoingConferenceCallModel.conversationId));
      this.mAvailableConferencesTokensMapping.remove(Long.valueOf(localOngoingConferenceCallModel.callToken));
    }
    notifyConferencesAvailabilityChanged(localHashMap, false);
  }

  private OngoingConferenceCallEntity createOngoingConferenceEntity(long paramLong1, long paramLong2, ConferenceInfo paramConferenceInfo, long paramLong3)
  {
    String str = this.mJsonSerializer.a(paramConferenceInfo);
    if (paramLong3 < 0L);
    for (long l = this.mTimeProvider.a(); ; l = paramLong3)
      return new OngoingConferenceCallEntity(paramLong1, paramLong2, str, l);
  }

  private OngoingConferenceCallModel deleteConferenceByCallToken(long paramLong)
  {
    this.mConferenceDatabase.deleteConferenceCallByCallToken(paramLong);
    OngoingConferenceCallModel localOngoingConferenceCallModel = (OngoingConferenceCallModel)this.mAvailableConferencesTokensMapping.remove(Long.valueOf(paramLong));
    if ((localOngoingConferenceCallModel != null) && (((OngoingConferenceCallModel)this.mAvailableConferencesIdsMapping.get(Long.valueOf(localOngoingConferenceCallModel.conversationId))).callToken == paramLong))
      this.mAvailableConferencesIdsMapping.remove(Long.valueOf(localOngoingConferenceCallModel.conversationId));
    return localOngoingConferenceCallModel;
  }

  @SuppressLint({"all"})
  private Map<Long, OngoingConferenceCallModel> deleteConferenceByConversationIds(Collection<Long> paramCollection)
  {
    this.mConferenceDatabase.deleteConferenceCallByConversationIds(paramCollection);
    HashMap localHashMap = new HashMap(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      OngoingConferenceCallModel localOngoingConferenceCallModel = (OngoingConferenceCallModel)this.mAvailableConferencesIdsMapping.remove(localLong);
      if (localOngoingConferenceCallModel != null)
      {
        this.mAvailableConferencesTokensMapping.remove(Long.valueOf(localOngoingConferenceCallModel.callToken));
        localHashMap.put(localLong, localOngoingConferenceCallModel);
      }
    }
    return localHashMap;
  }

  private boolean hasConferenceAvailabilityListener(ConferenceAvailabilityListener paramConferenceAvailabilityListener)
  {
    synchronized (this.mConferenceAvailabilityListeners)
    {
      boolean bool = this.mConferenceAvailabilityListeners.contains(paramConferenceAvailabilityListener);
      return bool;
    }
  }

  private void initializeAllConferences()
  {
    clearInvalidConferencesOnBecomeAlive();
    this.mAvailableConferencesIdsMapping.clear();
    this.mAvailableConferencesTokensMapping.clear();
    Iterator localIterator = this.mConferenceDatabase.loadAllConferences().iterator();
    while (localIterator.hasNext())
    {
      OngoingConferenceCallEntity localOngoingConferenceCallEntity = (OngoingConferenceCallEntity)localIterator.next();
      updateAvailableConferencesMapping(this.mConferenceCallMapper.mapToModel(localOngoingConferenceCallEntity));
    }
    notifyConferencesAvailabilityChanged(this.mAvailableConferencesIdsMapping, true);
  }

  private boolean isConversationConferenceTalkingTo(OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    ConferenceCall localConferenceCall = this.mCallHandler.getCurrentConferenceCall();
    return (paramOngoingConferenceCallModel != null) && (localConferenceCall != null) && (paramOngoingConferenceCallModel.callToken == localConferenceCall.getCallToken());
  }

  private void notifyConferenceAvailabilityChanged(OngoingConferenceCallModel paramOngoingConferenceCallModel, boolean paramBoolean)
  {
    notifyConferencesAvailabilityChanged(Collections.singletonMap(Long.valueOf(paramOngoingConferenceCallModel.conversationId), paramOngoingConferenceCallModel), paramBoolean, false);
  }

  private void notifyConferencesAvailabilityChanged(Map<Long, OngoingConferenceCallModel> paramMap, boolean paramBoolean)
  {
    notifyConferencesAvailabilityChanged(paramMap, paramBoolean, true);
  }

  @SuppressLint({"all"})
  private void notifyConferencesAvailabilityChanged(Map<Long, OngoingConferenceCallModel> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (u.a(paramMap));
    while (true)
    {
      return;
      synchronized (this.mConferenceAvailabilityListeners)
      {
        ConferenceAvailabilityListener[] arrayOfConferenceAvailabilityListener = (ConferenceAvailabilityListener[])this.mConferenceAvailabilityListeners.toArray(new ConferenceAvailabilityListener[0]);
        if (paramBoolean2)
          paramMap = Collections.unmodifiableMap(new HashMap(paramMap));
        int j = arrayOfConferenceAvailabilityListener.length;
        if (i >= j)
          continue;
        ConferenceAvailabilityListener localConferenceAvailabilityListener = arrayOfConferenceAvailabilityListener[i];
        if ((localConferenceAvailabilityListener != null) && (hasConferenceAvailabilityListener(localConferenceAvailabilityListener)))
          this.mMainExecutor.post(new ConferenceCallsRepository..Lambda.9(paramBoolean1, localConferenceAvailabilityListener, paramMap));
        i++;
      }
    }
  }

  private void notifyMissedConferenceInProgress(OngoingConferenceCallModel paramOngoingConferenceCallModel, String paramString1, String paramString2)
  {
    int i = 0;
    synchronized (this.mConferenceAvailabilityListeners)
    {
      ConferenceAvailabilityListener[] arrayOfConferenceAvailabilityListener = (ConferenceAvailabilityListener[])this.mConferenceAvailabilityListeners.toArray(new ConferenceAvailabilityListener[0]);
      int j = arrayOfConferenceAvailabilityListener.length;
      if (i < j)
      {
        ConferenceAvailabilityListener localConferenceAvailabilityListener = arrayOfConferenceAvailabilityListener[i];
        if ((localConferenceAvailabilityListener != null) && (hasConferenceAvailabilityListener(localConferenceAvailabilityListener)))
          this.mMainExecutor.post(new ConferenceCallsRepository..Lambda.10(localConferenceAvailabilityListener, paramOngoingConferenceCallModel, paramString1, paramString2));
        i++;
      }
    }
  }

  private OngoingConferenceCallModel onConferenceAvailable(long paramLong1, String paramString1, String paramString2, long paramLong2, CallerInfo paramCallerInfo, ConferenceInfo paramConferenceInfo, long paramLong3)
  {
    OngoingConferenceCallEntity localOngoingConferenceCallEntity1 = this.mConferenceDatabase.getConferenceCallByToken(paramLong2);
    if (localOngoingConferenceCallEntity1 != null)
      return this.mConferenceCallMapper.mapToModel(localOngoingConferenceCallEntity1);
    long l = selectOrCreateCallAssociatedConversationId(paramLong1, paramString1, paramString2, paramCallerInfo, paramConferenceInfo.isSelfInitiated());
    if (l <= 0L)
      return null;
    OngoingConferenceCallEntity localOngoingConferenceCallEntity2 = createOngoingConferenceEntity(l, paramLong2, paramConferenceInfo, paramLong3);
    if (!this.mConferenceDatabase.insertConferenceCall(localOngoingConferenceCallEntity2))
      return null;
    OngoingConferenceCallModel localOngoingConferenceCallModel1 = this.mConferenceCallMapper.mapToModel(localOngoingConferenceCallEntity2);
    OngoingConferenceCallModel localOngoingConferenceCallModel2 = updateAvailableConferencesMapping(localOngoingConferenceCallModel1);
    if (localOngoingConferenceCallModel2 != null)
      notifyConferenceAvailabilityChanged(localOngoingConferenceCallModel2, false);
    notifyConferenceAvailabilityChanged(localOngoingConferenceCallModel1, true);
    return localOngoingConferenceCallModel1;
  }

  private void onConferenceUnavailable(long paramLong)
  {
    OngoingConferenceCallModel localOngoingConferenceCallModel = deleteConferenceByCallToken(paramLong);
    if ((localOngoingConferenceCallModel != null) || (localOngoingConferenceCallModel != null))
      notifyConferenceAvailabilityChanged(localOngoingConferenceCallModel, false);
  }

  private void onConferenceUpdated(ConferenceCall paramConferenceCall, ConferenceInfo paramConferenceInfo)
  {
    OngoingConferenceCallEntity localOngoingConferenceCallEntity1 = this.mConferenceDatabase.getConferenceCallByToken(paramConferenceCall.getCallToken());
    if (localOngoingConferenceCallEntity1 == null);
    OngoingConferenceCallEntity localOngoingConferenceCallEntity2;
    do
    {
      return;
      localOngoingConferenceCallEntity2 = localOngoingConferenceCallEntity1.copyWith(this.mJsonSerializer.a(paramConferenceInfo));
    }
    while (!this.mConferenceDatabase.updateConferenceCallInfo(localOngoingConferenceCallEntity2));
    OngoingConferenceCallModel localOngoingConferenceCallModel = this.mConferenceCallMapper.mapToModel(localOngoingConferenceCallEntity2);
    updateAvailableConferencesMapping(localOngoingConferenceCallModel);
    notifyConferenceAvailabilityChanged(localOngoingConferenceCallModel, true);
  }

  private void onMissedConferenceInProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, String[] paramArrayOfString)
  {
    String[] arrayOfString = (String[])n.a(paramArrayOfString, new ConferenceCallsRepository..Lambda.7(this));
    ConferenceInfo localConferenceInfo = this.mParticipantsRepository.loadConferenceInfo(paramString1, arrayOfString, this.mResourcesProvider.a(R.string.unknown));
    if (localConferenceInfo == null);
    OngoingConferenceCallModel localOngoingConferenceCallModel;
    do
    {
      return;
      localConferenceInfo.setIsSelfInitiated(false);
      localOngoingConferenceCallModel = onConferenceAvailable(-1L, paramString1, paramString2, paramLong1, null, localConferenceInfo, this.mTimeProvider.a() - paramLong2);
    }
    while (localOngoingConferenceCallModel == null);
    ConferenceParticipant localConferenceParticipant = (ConferenceParticipant)n.b(localConferenceInfo.getParticipants(), new ConferenceCallsRepository..Lambda.8(paramString1));
    if (localConferenceParticipant != null);
    for (String str = localConferenceParticipant.getName(); ; str = null)
    {
      notifyMissedConferenceInProgress(localOngoingConferenceCallModel, paramString1, ca.a(str, paramString2));
      return;
    }
  }

  private OngoingConferenceCallModel updateAvailableConferencesMapping(OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    OngoingConferenceCallModel localOngoingConferenceCallModel = (OngoingConferenceCallModel)this.mAvailableConferencesIdsMapping.put(Long.valueOf(paramOngoingConferenceCallModel.conversationId), paramOngoingConferenceCallModel);
    if (localOngoingConferenceCallModel != null)
      this.mAvailableConferencesTokensMapping.remove(Long.valueOf(localOngoingConferenceCallModel.callToken));
    this.mAvailableConferencesTokensMapping.put(Long.valueOf(paramOngoingConferenceCallModel.callToken), paramOngoingConferenceCallModel);
    return localOngoingConferenceCallModel;
  }

  public OngoingConferenceCallModel getConferenceTalkingTo()
  {
    ConferenceCall localConferenceCall = this.mCallHandler.getCurrentConferenceCall();
    if (localConferenceCall != null)
      return (OngoingConferenceCallModel)this.mAvailableConferencesTokensMapping.get(Long.valueOf(localConferenceCall.getCallToken()));
    return null;
  }

  public OngoingConferenceCallModel getConversationConferenceAvailableToJoin(long paramLong)
  {
    OngoingConferenceCallModel localOngoingConferenceCallModel = (OngoingConferenceCallModel)this.mAvailableConferencesIdsMapping.get(Long.valueOf(paramLong));
    if ((localOngoingConferenceCallModel != null) && (!isConversationConferenceTalkingTo(localOngoingConferenceCallModel.conversationId)))
      return localOngoingConferenceCallModel;
    return null;
  }

  public List<Long> getConversationConferenceIdsAvailableToJoin()
  {
    Iterator localIterator = this.mAvailableConferencesIdsMapping.values().iterator();
    ArrayList localArrayList = null;
    while (localIterator.hasNext())
    {
      OngoingConferenceCallModel localOngoingConferenceCallModel = (OngoingConferenceCallModel)localIterator.next();
      if (!isConversationConferenceTalkingTo(localOngoingConferenceCallModel))
      {
        if (localArrayList == null)
          localArrayList = new ArrayList(1);
        if (localOngoingConferenceCallModel != null)
          localArrayList.add(Long.valueOf(localOngoingConferenceCallModel.conversationId));
      }
    }
    if (localArrayList != null)
      return localArrayList;
    return Collections.emptyList();
  }

  public boolean hasConversationConferenceAvailableToJoin(long paramLong)
  {
    return getConversationConferenceAvailableToJoin(paramLong) != null;
  }

  public void initialize()
  {
    this.mCallHandler.getConferenceInitializationListenersStore().registerListener(this.mConferenceInitializationListener);
    this.mCallHandler.addCallInfoReadyListener(this.mCallInfoReadyListener);
    this.mDelegatesManager.registerDelegate(this.mPhoneControllerDelegateAdapter, this.mBackgroundExecutor);
    this.mAppBackgroundChecker.a(this.mAppStateListener);
  }

  public void invalidate()
  {
    this.mBackgroundExecutor.post(this.mInitializeAllConferencesAction);
  }

  public boolean isConversationConferenceTalkingTo(long paramLong)
  {
    return isConversationConferenceTalkingTo((OngoingConferenceCallModel)this.mAvailableConferencesIdsMapping.get(Long.valueOf(paramLong)));
  }

  public void makeConferenceWithCallTokenUnavailable(long paramLong)
  {
    dd.a(this.mBackgroundExecutor, new ConferenceCallsRepository..Lambda.6(this, paramLong));
  }

  public void makeConferencesWithConversationIdsUnavailable(Collection<Long> paramCollection)
  {
    if (u.a(paramCollection))
      return;
    dd.a(this.mBackgroundExecutor, new ConferenceCallsRepository..Lambda.5(this, paramCollection));
  }

  @SuppressLint({"all"})
  public final void registerConferenceAvailabilityListener(ConferenceAvailabilityListener paramConferenceAvailabilityListener)
  {
    synchronized (this.mConferenceAvailabilityListeners)
    {
      this.mConferenceAvailabilityListeners.add(paramConferenceAvailabilityListener);
      if (!this.mAvailableConferencesIdsMapping.isEmpty())
        this.mMainExecutor.post(new ConferenceCallsRepository..Lambda.4(this, paramConferenceAvailabilityListener));
      return;
    }
  }

  long selectOrCreateCallAssociatedConversationId(long paramLong, String paramString1, String paramString2, CallerInfo paramCallerInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramLong > 0L))
      return paramLong;
    if ((paramCallerInfo != null) && (!da.a(paramCallerInfo.getMemberId())) && ((!paramBoolean) || (da.a(paramString1))))
    {
      paramString1 = paramCallerInfo.getMemberId();
      paramString2 = paramCallerInfo.getPhoneNumber();
    }
    if (da.a(paramString1))
      return -1L;
    Member localMember = new Member(paramString1, paramString2);
    return this.mMessageEditHelper.a(localMember).getId();
  }

  public final void unregisterConferenceAvailabilityListener(ConferenceAvailabilityListener paramConferenceAvailabilityListener)
  {
    synchronized (this.mConferenceAvailabilityListeners)
    {
      this.mConferenceAvailabilityListeners.remove(paramConferenceAvailabilityListener);
      return;
    }
  }

  public static abstract interface ConferenceAvailabilityListener
  {
    public abstract void onConferenceMissedInProgress(OngoingConferenceCallModel paramOngoingConferenceCallModel, String paramString1, String paramString2);

    public abstract void onConferencesAvailable(Map<Long, OngoingConferenceCallModel> paramMap);

    public abstract void onConferencesUnavailable(Map<Long, OngoingConferenceCallModel> paramMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ConferenceCallsRepository
 * JD-Core Version:    0.6.2
 */