package com.viber.voip.phone.viber.conference.ui.incall;

import android.arch.lifecycle.h;
import android.os.Handler;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.conf.ConferenceCall;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate..CC;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerDetailedState;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.PeerState;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener..CC;
import com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper;
import com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper.Listener;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository.OnParticipantsLoadedListener;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.phone.viber.conference.model.ConferenceCallStatus;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantModel;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantRepositoryEntity;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceHoldStateResolver;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceMicStateResolver;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceSpeakerStateResolver;
import com.viber.voip.phone.viber.conference.ui.controls.ControlState;
import com.viber.voip.phone.viber.conference.ui.controls.ControlStateResolver;
import com.viber.voip.phone.viber.conference.ui.controls.ControlStateResolver.OnControlStateChangeListener;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.m;
import com.viber.voip.user.editinfo.UserInfoRepository;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.da;
import com.viber.voip.util.e.f;
import com.viber.voip.util.i.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;

public class ConferenceInCallPresenter extends BaseMvpPresenter<ConferenceInCallContract.ConferenceMvpView, ConferenceInCallContract.ConferenceState>
  implements ConferenceInCallContract.ConferencePresenter
{
  private static final long KEEP_MEMBER_TEMP_STATUS_DURATION_MILLIS = 0L;
  private static final Logger L = ViberEnv.getLogger();
  private static final long VOLUME_LEVEL_ANIMATION_DURATION = 1000L;
  private final Object ACTIVE_SPEAKER_TASK_TOKEN = new Object();
  private final Object ACTIVE_SPEAKER_VOLUME_LEVEL_TASK_TOKEN = new Object();
  private final Object MAKE_MEMBER_IN_CALL_AFTER_TEMP_STATUS_TASK_TOKEN = new Object();
  private final Object PROCESS_AND_DISPLAY_PARTICIPANTS_TASK_TOKEN = new Object();
  private long mActiveSpeakerUnlockTime;
  private Handler mBackgroundExecutor;
  private final CallHandler mCallHandler;
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

    public void onPeersChanged(Collection paramAnonymousCollection)
    {
      IConferenceCall.UiDelegate..CC.onPeersChanged(this, paramAnonymousCollection);
    }

    public void onPeersInvited(int paramAnonymousInt, Map<String, Integer> paramAnonymousMap)
    {
      if ((paramAnonymousInt != 0) || (ConferenceInCallPresenter.this.mInvitedParticipants == null));
      ArrayList localArrayList;
      do
      {
        return;
        localArrayList = new ArrayList();
        for (ConferenceParticipant localConferenceParticipant : ConferenceInCallPresenter.this.mInvitedParticipants)
        {
          Iterator localIterator = paramAnonymousMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str = (String)localEntry.getKey();
            if ((!da.a(str)) && (str.equals(localConferenceParticipant.getMemberId())) && (3 == ((Integer)localEntry.getValue()).intValue()))
              localArrayList.add(localConferenceParticipant);
          }
        }
        ConferenceInCallPresenter.this.mInviteFailedParticipants = null;
      }
      while (localArrayList.isEmpty());
      ConferenceInCallPresenter.this.mInviteFailedParticipants = ((ConferenceParticipant[])localArrayList.toArray(new ConferenceParticipant[0]));
      ((ConferenceInCallContract.ConferenceMvpView)ConferenceInCallPresenter.this.mView).showPeersUnsupportedVersionError(ConferenceInCallPresenter.this.mInviteFailedParticipants);
    }

    public void onVolumeLevelChanged(Map<String, Float> paramAnonymousMap, String paramAnonymousString)
    {
      String str = ConferenceInCallPresenter.this.mState.getSpeakingPersonMemberId();
      Iterator localIterator1 = ConferenceInCallPresenter.this.mState.getParticipants().iterator();
      while (localIterator1.hasNext())
      {
        ConferenceParticipantModel localConferenceParticipantModel = (ConferenceParticipantModel)localIterator1.next();
        if ((!da.a(paramAnonymousString)) && (paramAnonymousString.equals(localConferenceParticipantModel.memberId)))
          if (!ConferenceInCallPresenter.this.setActiveSpeaker(localConferenceParticipantModel, ConferenceInCallPresenter.ActiveSpeakerLockSource.DOMINANT_SPEAKER_CHANGE))
            break;
      }
      while (true)
      {
        Iterator localIterator2 = paramAnonymousMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          if ((!da.a(paramAnonymousString)) && (paramAnonymousString.equals(localEntry.getKey())))
          {
            float f = ((Float)localEntry.getValue()).floatValue();
            ConferenceInCallPresenter.this.setActiveSpeakerVolumeLevel(f);
          }
        }
        return;
        paramAnonymousString = str;
      }
    }
  };
  private final c mCallsTracker;
  private e mClockTimeProvider;
  private final ConferenceCallsRepository.ConferenceAvailabilityListener mConferenceAvailabilityListener = new ConferenceCallsRepository.ConferenceAvailabilityListener()
  {
    public void onConferenceMissedInProgress(OngoingConferenceCallModel paramAnonymousOngoingConferenceCallModel, String paramAnonymousString1, String paramAnonymousString2)
    {
      ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferenceMissedInProgress(this, paramAnonymousOngoingConferenceCallModel, paramAnonymousString1, paramAnonymousString2);
    }

    public void onConferencesAvailable(Map<Long, OngoingConferenceCallModel> paramAnonymousMap)
    {
      ConferenceInCallPresenter.this.adjustConferenceDuration();
    }

    public void onConferencesUnavailable(Map paramAnonymousMap)
    {
      ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferencesUnavailable(this, paramAnonymousMap);
    }
  };
  private final ConferenceCallsRepository mConferenceCallsRepository;
  private final ConferenceGroupCreationHelper mConferenceGroupCreationHelper;
  private final Engine mEngine;
  private final ControlStateResolver mHoldStateResolver;
  ConferenceParticipant[] mInviteFailedParticipants;
  ConferenceParticipant[] mInvitedParticipants;
  private final bs mMessageEditHelper;
  private Handler mMessagesExecutor;
  private final ControlStateResolver mMicStateResolver;
  private final ControlStateResolver.OnControlStateChangeListener mOnHoldControlStateChangeListener = new ConferenceInCallPresenter..Lambda.2(this);
  private final ControlStateResolver.OnControlStateChangeListener mOnMicControlStateChangeListener = new ConferenceInCallPresenter..Lambda.1(this);
  private final ConferenceParticipantsRepository.OnParticipantsLoadedListener mOnParticipantsLoadedListener = new ConferenceInCallPresenter..Lambda.3(this);
  private final ControlStateResolver.OnControlStateChangeListener mOnSpeakerControlStateChangeListener = new ConferenceInCallPresenter..Lambda.0(this);
  private final ConferenceParticipantMapper mParticipantMapper;
  private final ConferenceParticipantsRepository mParticipantsRepository;
  private final cj mReachability;
  private final af mRegistrationValues;
  private final cn mResourceProvider;
  private final ControlStateResolver mSpeakerStateResolver;
  private final f mSpeakingPersonPhotoFetcherConfig;
  ConferenceInCallContract.ConferenceState mState;
  private e mSystemTimeProvider;
  private Handler mUiExecutor;
  private final UserInfoRepository mUserInfoRepository;

  @Inject
  public ConferenceInCallPresenter(UserInfoRepository paramUserInfoRepository, af paramaf, CallHandler paramCallHandler, ConferenceSpeakerStateResolver paramConferenceSpeakerStateResolver, ConferenceMicStateResolver paramConferenceMicStateResolver, ConferenceHoldStateResolver paramConferenceHoldStateResolver, ConferenceParticipantsRepository paramConferenceParticipantsRepository, ConferenceCallsRepository paramConferenceCallsRepository, cn paramcn, ConferenceParticipantMapper paramConferenceParticipantMapper, ConferenceGroupCreationHelper paramConferenceGroupCreationHelper, bs parambs, cj paramcj, c paramc, Engine paramEngine, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, e parame1, @Named("clock") e parame2)
  {
    this.mUiExecutor = paramHandler1;
    this.mBackgroundExecutor = paramHandler2;
    this.mMessagesExecutor = paramHandler3;
    this.mParticipantMapper = paramConferenceParticipantMapper;
    this.mResourceProvider = paramcn;
    this.mCallHandler = paramCallHandler;
    this.mUserInfoRepository = paramUserInfoRepository;
    this.mRegistrationValues = paramaf;
    this.mSystemTimeProvider = parame1;
    this.mClockTimeProvider = parame2;
    this.mSpeakingPersonPhotoFetcherConfig = f.a(R.drawable.phone_contact_generic);
    this.mSpeakerStateResolver = paramConferenceSpeakerStateResolver;
    this.mMicStateResolver = paramConferenceMicStateResolver;
    this.mHoldStateResolver = paramConferenceHoldStateResolver;
    this.mParticipantsRepository = paramConferenceParticipantsRepository;
    this.mConferenceCallsRepository = paramConferenceCallsRepository;
    this.mConferenceGroupCreationHelper = paramConferenceGroupCreationHelper;
    this.mMessageEditHelper = parambs;
    this.mReachability = paramcj;
    this.mCallsTracker = paramc;
    this.mEngine = paramEngine;
  }

  private void adjustConferenceDuration()
  {
    OngoingConferenceCallModel localOngoingConferenceCallModel = this.mConferenceCallsRepository.getConferenceTalkingTo();
    if (localOngoingConferenceCallModel == null)
      return;
    long l = Math.max(this.mSystemTimeProvider.a() - localOngoingConferenceCallModel.startTimeMillis, 0L);
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).adjustConferenceStartTime(this.mClockTimeProvider.a() - l);
  }

  private ConferenceInCallContract.ConferenceState createInitialViewState()
  {
    String str = this.mUserInfoRepository.getNameOrNumber();
    return ConferenceInCallContract.ConferenceState.builder().setSpeakingPersonMemberId(this.mRegistrationValues.l()).setSpeakingPersonPhoto(this.mUserInfoRepository.getImageUri()).setSpeakingPersonName(this.mResourceProvider.b(R.string.conversation_info_your_list_item, new Object[] { str })).setConferenceName(this.mResourceProvider.a(R.string.participants)).setMicControlState(ControlState.DISABLED_INACTIVE).setSpeakerControlState(ControlState.DISABLED_INACTIVE).setHoldControlState(ControlState.DISABLED_INACTIVE).build();
  }

  private ConferenceParticipantModel createYouParticipantModel()
  {
    String str1 = this.mRegistrationValues.l();
    String str2 = this.mUserInfoRepository.getNameOrNumber();
    return new ConferenceParticipantModel(str1, this.mResourceProvider.b(R.string.conversation_info_your_list_item, new Object[] { str2 }), str2, this.mUserInfoRepository.getImageUri(), new ConferenceCallStatus(IConferenceCall.UiDelegate.PeerState.CONNECTED, IConferenceCall.UiDelegate.PeerDetailedState.ON_AIR), 0L);
  }

  private void disableActiveSpeakerObservation()
  {
    ConferenceCall localConferenceCall = this.mCallHandler.getCurrentConferenceCall();
    if (localConferenceCall != null)
      localConferenceCall.removeUiDelegate(this.mCallback);
  }

  private void disableControlsStateObservation()
  {
    this.mSpeakerStateResolver.setOnControlStateChangeListener(null);
    this.mSpeakerStateResolver.disable();
    this.mMicStateResolver.setOnControlStateChangeListener(null);
    this.mMicStateResolver.disable();
    this.mHoldStateResolver.setOnControlStateChangeListener(null);
    this.mHoldStateResolver.disable();
  }

  private void enableActiveSpeakerObservation()
  {
    ConferenceCall localConferenceCall = this.mCallHandler.getCurrentConferenceCall();
    if (localConferenceCall != null)
      localConferenceCall.addUiDelegate(this.mCallback);
  }

  private void enableControlsStateObservation()
  {
    this.mSpeakerStateResolver.setOnControlStateChangeListener(this.mOnSpeakerControlStateChangeListener);
    this.mSpeakerStateResolver.enable();
    this.mMicStateResolver.setOnControlStateChangeListener(this.mOnMicControlStateChangeListener);
    this.mMicStateResolver.enable();
    this.mHoldStateResolver.setOnControlStateChangeListener(this.mOnHoldControlStateChangeListener);
    this.mHoldStateResolver.enable();
  }

  private ConferenceParticipantModel findParticipant(String paramString)
  {
    Iterator localIterator = this.mState.getParticipants().iterator();
    while (localIterator.hasNext())
    {
      ConferenceParticipantModel localConferenceParticipantModel = (ConferenceParticipantModel)localIterator.next();
      if (paramString.equals(localConferenceParticipantModel.memberId))
        return localConferenceParticipantModel;
    }
    return null;
  }

  private GroupController.GroupMember[] getGroupMembersWithoutOwner()
  {
    List localList = this.mState.getParticipants();
    int i = localList.size();
    GroupController.GroupMember[] arrayOfGroupMember = new GroupController.GroupMember[i - 1];
    for (int j = 1; j < i; j++)
    {
      ConferenceParticipantModel localConferenceParticipantModel = (ConferenceParticipantModel)localList.get(j);
      arrayOfGroupMember[(j - 1)] = this.mParticipantMapper.mapToGroupMember(localConferenceParticipantModel);
    }
    return arrayOfGroupMember;
  }

  private String[] getMemberIdsWithoutOwner()
  {
    List localList = this.mState.getParticipants();
    int i = localList.size();
    String[] arrayOfString = new String[i - 1];
    for (int j = 1; j < i; j++)
      arrayOfString[(j - 1)] = ((ConferenceParticipantModel)localList.get(j)).memberId;
    return arrayOfString;
  }

  private boolean isParticipantBusy(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    long l = paramConferenceParticipantModel.statusUpdateTimeMillis + KEEP_MEMBER_TEMP_STATUS_DURATION_MILLIS;
    return (IConferenceCall.UiDelegate.PeerDetailedState.BUSY == paramConferenceParticipantModel.callStatus.detailedState) && (l > this.mSystemTimeProvider.a());
  }

  private boolean isParticipantBusyOutdated(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    long l = paramConferenceParticipantModel.statusUpdateTimeMillis + KEEP_MEMBER_TEMP_STATUS_DURATION_MILLIS;
    return (IConferenceCall.UiDelegate.PeerDetailedState.BUSY == paramConferenceParticipantModel.callStatus.detailedState) && (l <= this.mSystemTimeProvider.a());
  }

  private void onParticipantsLoaded(List<ConferenceParticipantRepositoryEntity> paramList)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    Collections.sort(localArrayList1, new ParticipantEntitySortComparator());
    ArrayList localArrayList2 = new ArrayList(1 + localArrayList1.size());
    ConferenceParticipantModel localConferenceParticipantModel = findParticipant(this.mRegistrationValues.l());
    Object localObject1;
    ConferenceParticipantRepositoryEntity localConferenceParticipantRepositoryEntity2;
    if (localConferenceParticipantModel != null)
    {
      Iterator localIterator2 = localArrayList1.iterator();
      localObject1 = localConferenceParticipantModel;
      if (localIterator2.hasNext())
      {
        localConferenceParticipantRepositoryEntity2 = (ConferenceParticipantRepositoryEntity)localIterator2.next();
        if (!this.mRegistrationValues.l().equals(localConferenceParticipantRepositoryEntity2.memberId))
          break label264;
      }
    }
    label264: for (Object localObject2 = this.mParticipantMapper.mapToModel((ConferenceParticipantModel)localObject1, localConferenceParticipantRepositoryEntity2.callStatus, localConferenceParticipantRepositoryEntity2.statusUpdateTimestampMillis); ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      localArrayList2.add(localObject1);
      Iterator localIterator1 = localArrayList1.iterator();
      while (localIterator1.hasNext())
      {
        ConferenceParticipantRepositoryEntity localConferenceParticipantRepositoryEntity1 = (ConferenceParticipantRepositoryEntity)localIterator1.next();
        if (!this.mRegistrationValues.l().equals(localConferenceParticipantRepositoryEntity1.memberId))
          localArrayList2.add(this.mParticipantMapper.mapToModel(localConferenceParticipantRepositoryEntity1));
      }
      List localList = resetBusyOutdatedStatuses(localArrayList2);
      this.mUiExecutor.removeCallbacksAndMessages(this.PROCESS_AND_DISPLAY_PARTICIPANTS_TASK_TOKEN);
      this.mUiExecutor.postAtTime(new ConferenceInCallPresenter..Lambda.6(this, localList), this.PROCESS_AND_DISPLAY_PARTICIPANTS_TASK_TOKEN, this.mClockTimeProvider.b());
      scheduleBusyStatusesReset(localList);
      return;
    }
  }

  private void onParticipantsReadyToDisplay(List<ConferenceParticipantModel> paramList)
  {
    int i = 1;
    this.mState = this.mState.buildUpon().setParticipants(paramList).build();
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).displayParticipantItems(paramList);
    int j = paramList.size();
    ConferenceInCallContract.ConferenceMvpView localConferenceMvpView1 = (ConferenceInCallContract.ConferenceMvpView)this.mView;
    ConferenceInCallContract.ConferenceMvpView localConferenceMvpView2;
    if (j < d.m.w.d())
    {
      int k = i;
      localConferenceMvpView1.updateAddParticipantVisibility(k);
      localConferenceMvpView2 = (ConferenceInCallContract.ConferenceMvpView)this.mView;
      if (j <= i)
        break label100;
    }
    while (true)
    {
      localConferenceMvpView2.updateMessageVisibility(i);
      return;
      int m = 0;
      break;
      label100: i = 0;
    }
  }

  private void onSetActiveSpeaker(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    this.mState = this.mState.buildUpon().setSpeakingPersonMemberId(paramConferenceParticipantModel.memberId).setSpeakingPersonName(paramConferenceParticipantModel.displayName).setSpeakingPersonPhoto(paramConferenceParticipantModel.photoUri).build();
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).displaySpeakingPersonName(paramConferenceParticipantModel.displayName);
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).displaySpeakingPersonPhoto(paramConferenceParticipantModel.photoUri, this.mSpeakingPersonPhotoFetcherConfig);
  }

  private void renderInitialState()
  {
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).displaySpeakingPersonPhoto(this.mState.getSpeakingPersonPhotoUri(), this.mSpeakingPersonPhotoFetcherConfig);
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).displaySpeakingPersonName(this.mState.getSpeakingPersonName());
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).displayConferenceName(this.mState.getConferenceName());
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).displayParticipantItems(this.mState.getParticipants());
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).updateSpeakerControlState(this.mState.getSpeakerControlState());
    renderSilentCallControlState();
  }

  private void renderSilentCallControlState()
  {
    ControlState localControlState = this.mState.getHoldControlState();
    if (localControlState.checked)
    {
      ((ConferenceInCallContract.ConferenceMvpView)this.mView).updateSilentCallControlState(localControlState, false);
      return;
    }
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).updateSilentCallControlState(this.mState.getMicControlState(), true);
  }

  private List<ConferenceParticipantModel> resetBusyOutdatedStatuses(List<ConferenceParticipantModel> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ConferenceParticipantModel localConferenceParticipantModel = (ConferenceParticipantModel)localIterator.next();
      if (isParticipantBusyOutdated(localConferenceParticipantModel))
        localConferenceParticipantModel = this.mParticipantMapper.mapToModel(localConferenceParticipantModel, ConferenceCallStatus.UNKNOWN);
      localArrayList.add(localConferenceParticipantModel);
    }
    return localArrayList;
  }

  private void scheduleBusyStatusesReset(List<ConferenceParticipantModel> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ConferenceParticipantModel localConferenceParticipantModel = (ConferenceParticipantModel)localIterator.next();
      if (isParticipantBusy(localConferenceParticipantModel))
        this.mUiExecutor.postAtTime(new ConferenceInCallPresenter..Lambda.8(this, localConferenceParticipantModel), this.MAKE_MEMBER_IN_CALL_AFTER_TEMP_STATUS_TASK_TOKEN, this.mClockTimeProvider.b() + KEEP_MEMBER_TEMP_STATUS_DURATION_MILLIS);
    }
  }

  private boolean setActiveSpeaker(ConferenceParticipantModel paramConferenceParticipantModel, ActiveSpeakerLockSource paramActiveSpeakerLockSource)
  {
    long l = this.mClockTimeProvider.a();
    if (this.mActiveSpeakerUnlockTime > l)
      return false;
    this.mActiveSpeakerUnlockTime = (l + paramActiveSpeakerLockSource.lockDuration);
    this.mUiExecutor.removeCallbacksAndMessages(this.ACTIVE_SPEAKER_TASK_TOKEN);
    this.mUiExecutor.postAtTime(new ConferenceInCallPresenter..Lambda.5(this, paramConferenceParticipantModel), this.ACTIVE_SPEAKER_TASK_TOKEN, this.mClockTimeProvider.b());
    return true;
  }

  private void setActiveSpeakerVolumeLevel(float paramFloat)
  {
    this.mUiExecutor.removeCallbacksAndMessages(this.ACTIVE_SPEAKER_VOLUME_LEVEL_TASK_TOKEN);
    this.mUiExecutor.postAtTime(new ConferenceInCallPresenter..Lambda.4(this, paramFloat), this.ACTIVE_SPEAKER_VOLUME_LEVEL_TASK_TOKEN, this.mClockTimeProvider.b());
  }

  private void updateDisplayedParticipantStatus(String paramString, long paramLong, ConferenceCallStatus paramConferenceCallStatus)
  {
    ArrayList localArrayList = new ArrayList(this.mState.getParticipants().size());
    Iterator localIterator = this.mState.getParticipants().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ConferenceParticipantModel localConferenceParticipantModel = (ConferenceParticipantModel)localIterator.next();
      if ((!paramString.equals(localConferenceParticipantModel.memberId)) || (paramLong != localConferenceParticipantModel.statusUpdateTimeMillis))
        localArrayList.add(localConferenceParticipantModel);
      for (int j = i; ; j = 1)
      {
        i = j;
        break;
        localArrayList.add(this.mParticipantMapper.mapToModel(localConferenceParticipantModel, paramConferenceCallStatus));
      }
    }
    if (i != 0)
      onParticipantsReadyToDisplay(localArrayList);
  }

  protected ConferenceInCallContract.ConferenceState getSaveState()
  {
    return this.mState.getStateToSave();
  }

  public void handleCancelSendUpdateLink()
  {
  }

  public void onAddParticipantClicked()
  {
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).openContactsSelectionScreen(getMemberIdsWithoutOwner());
    this.mCallsTracker.b("Add Participant");
  }

  public void onBackPressed()
  {
    this.mCallsTracker.b("Minimize");
  }

  public void onDestroy(h paramh)
  {
    ((ConferenceInCallContract.ConferenceMvpView)this.mView).stopSpeakingPersonAnimation();
    super.onDestroy(paramh);
    disableControlsStateObservation();
    disableActiveSpeakerObservation();
    this.mParticipantsRepository.unregisterOngoingConferenceParticipantsLoadedListener(this.mOnParticipantsLoadedListener);
    this.mConferenceCallsRepository.unregisterConferenceAvailabilityListener(this.mConferenceAvailabilityListener);
    this.mConferenceGroupCreationHelper.unregister();
    this.mUiExecutor.removeCallbacksAndMessages(this.MAKE_MEMBER_IN_CALL_AFTER_TEMP_STATUS_TASK_TOKEN);
  }

  public void onInviteParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    if (this.mReachability.a() == -1)
      ((ConferenceInCallContract.ConferenceMvpView)this.mView).showNoConnectionError();
    while (true)
    {
      this.mCallsTracker.b("Redial");
      return;
      if (this.mEngine.getServiceState() != ServiceStateDelegate.ServiceState.SERVICE_CONNECTED)
      {
        ((ConferenceInCallContract.ConferenceMvpView)this.mView).showNoServiceError();
      }
      else
      {
        String[] arrayOfString = new String[1];
        this.mInvitedParticipants = new ConferenceParticipant[1];
        arrayOfString[0] = paramConferenceParticipantModel.memberId;
        this.mInvitedParticipants[0] = this.mParticipantMapper.mapToConferenceParticipant(paramConferenceParticipantModel);
        this.mCallHandler.handleAddPeersToConference(arrayOfString);
      }
    }
  }

  public void onInviteParticipantsToConference(List<ParticipantSelector.Participant> paramList)
  {
    if (this.mReachability.a() == -1)
      ((ConferenceInCallContract.ConferenceMvpView)this.mView).showNoConnectionError();
    while (true)
    {
      this.mCallsTracker.b(paramList.size());
      return;
      if (this.mEngine.getServiceState() != ServiceStateDelegate.ServiceState.SERVICE_CONNECTED)
      {
        ((ConferenceInCallContract.ConferenceMvpView)this.mView).showNoServiceError();
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        this.mInvitedParticipants = new ConferenceParticipant[paramList.size()];
        Iterator localIterator = paramList.iterator();
        int j;
        for (int i = 0; localIterator.hasNext(); i = j)
        {
          ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localIterator.next();
          localArrayList.add(localParticipant.getMemberId());
          ConferenceParticipant[] arrayOfConferenceParticipant = this.mInvitedParticipants;
          j = i + 1;
          arrayOfConferenceParticipant[i] = this.mParticipantMapper.mapToConferenceParticipant(localParticipant);
        }
        this.mCallHandler.handleAddPeersToConference((String[])localArrayList.toArray(new String[0]));
      }
    }
  }

  public void onLeaveConferenceClicked()
  {
    this.mCallHandler.handleHangup();
    this.mCallsTracker.b("Hangup");
  }

  public void onMessageClicked()
  {
    GroupController.GroupMember[] arrayOfGroupMember = getGroupMembersWithoutOwner();
    if (arrayOfGroupMember.length == 1)
      ((ConferenceInCallContract.ConferenceMvpView)this.mView).open1To1ConversationScreen(arrayOfGroupMember[0].mMID);
    while (true)
    {
      this.mCallsTracker.b("Message");
      return;
      if (arrayOfGroupMember.length > 1)
        this.mConferenceGroupCreationHelper.createGroup(arrayOfGroupMember, new ConferenceGroupCreationHelper.Listener()
        {
          public void onGroupCreateError()
          {
            ((ConferenceInCallContract.ConferenceMvpView)ConferenceInCallPresenter.this.mView).showGroupCreateError();
          }

          public void onGroupCreated(long paramAnonymousLong, boolean paramAnonymousBoolean)
          {
            ((ConferenceInCallContract.ConferenceMvpView)ConferenceInCallPresenter.this.mView).openGroupConversationScreen(paramAnonymousLong);
          }
        });
    }
  }

  public void onParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    setActiveSpeaker(paramConferenceParticipantModel, ActiveSpeakerLockSource.PARTICIPANT_CLICK);
    this.mCallsTracker.b("Participant");
  }

  public void onSilentCallClicked()
  {
    ControlState localControlState1 = this.mState.getHoldControlState();
    ControlState localControlState2 = this.mState.getMicControlState();
    if (localControlState1.checked)
    {
      this.mState = this.mState.buildUpon().setMicControlState(ControlState.ENABLED_INACTIVE).setHoldControlState(ControlState.DISABLED_INACTIVE).build();
      this.mHoldStateResolver.activate(false);
    }
    while (true)
    {
      renderSilentCallControlState();
      this.mCallsTracker.b("Mute");
      return;
      if (localControlState2.checked)
      {
        this.mState = this.mState.buildUpon().setMicControlState(localControlState2.apply(4)).build();
        this.mMicStateResolver.activate(false);
      }
      else
      {
        this.mState = this.mState.buildUpon().setMicControlState(localControlState2.apply(8)).build();
        this.mMicStateResolver.activate(true);
      }
    }
  }

  public void onSilentCallLongClicked()
  {
    if (this.mState.getHoldControlState().checked)
    {
      this.mState = this.mState.buildUpon().setMicControlState(ControlState.ENABLED_ACTIVE).setHoldControlState(ControlState.DISABLED_INACTIVE).build();
      this.mMicStateResolver.activate(true);
      this.mHoldStateResolver.activate(false);
    }
    while (true)
    {
      renderSilentCallControlState();
      this.mCallsTracker.b("Mute");
      return;
      this.mState = this.mState.buildUpon().setMicControlState(ControlState.DISABLED_INACTIVE).setHoldControlState(ControlState.ENABLED_ACTIVE).build();
      this.mMicStateResolver.activate(false);
      this.mHoldStateResolver.activate(true);
    }
  }

  public void onSpeakerPhoneClicked()
  {
    ControlState localControlState1 = this.mState.getSpeakerControlState();
    if (localControlState1.checked)
    {
      ControlState localControlState3 = localControlState1.apply(4);
      this.mState = this.mState.buildUpon().setSpeakerControlState(localControlState3).build();
      ((ConferenceInCallContract.ConferenceMvpView)this.mView).updateSpeakerControlState(localControlState3);
      this.mSpeakerStateResolver.activate(false);
    }
    while (true)
    {
      this.mCallsTracker.b("Speaker");
      return;
      ControlState localControlState2 = localControlState1.apply(8);
      this.mState = this.mState.buildUpon().setSpeakerControlState(localControlState2).build();
      ((ConferenceInCallContract.ConferenceMvpView)this.mView).updateSpeakerControlState(localControlState2);
      this.mSpeakerStateResolver.activate(true);
    }
  }

  protected void onViewAttached(ConferenceInCallContract.ConferenceState paramConferenceState)
  {
    super.onViewAttached(paramConferenceState);
    if (paramConferenceState != null);
    for (this.mState = paramConferenceState; ; this.mState = createInitialViewState())
    {
      this.mState = this.mState.buildUpon().setParticipants(Collections.singletonList(createYouParticipantModel())).build();
      renderInitialState();
      enableControlsStateObservation();
      enableActiveSpeakerObservation();
      this.mParticipantsRepository.registerOngoingConferenceParticipantsLoadedListener(this.mOnParticipantsLoadedListener);
      this.mConferenceCallsRepository.registerConferenceAvailabilityListener(this.mConferenceAvailabilityListener);
      this.mConferenceGroupCreationHelper.register();
      ((ConferenceInCallContract.ConferenceMvpView)this.mView).startSpeakingPersonAnimation();
      return;
    }
  }

  public void sendUpdateLink()
  {
    if (this.mInviteFailedParticipants == null)
      return;
    String str1 = this.mUserInfoRepository.getName();
    if (da.a(str1))
      str1 = this.mRegistrationValues.h();
    String str2 = this.mResourceProvider.b(R.string.send_update_link_no_calls_support_text, new Object[] { str1 });
    this.mMessagesExecutor.post(new ConferenceInCallPresenter..Lambda.7(this, str2));
  }

  private static enum ActiveSpeakerLockSource
  {
    final long lockDuration;

    static
    {
      DOMINANT_SPEAKER_CHANGE = new ActiveSpeakerLockSource("DOMINANT_SPEAKER_CHANGE", 1, TimeUnit.SECONDS.toMillis(2L));
      ActiveSpeakerLockSource[] arrayOfActiveSpeakerLockSource = new ActiveSpeakerLockSource[2];
      arrayOfActiveSpeakerLockSource[0] = PARTICIPANT_CLICK;
      arrayOfActiveSpeakerLockSource[1] = DOMINANT_SPEAKER_CHANGE;
    }

    private ActiveSpeakerLockSource(long paramLong)
    {
      this.lockDuration = paramLong;
    }
  }

  static class ParticipantEntitySortComparator
    implements Comparator<ConferenceParticipantRepositoryEntity>
  {
    public int compare(ConferenceParticipantRepositoryEntity paramConferenceParticipantRepositoryEntity1, ConferenceParticipantRepositoryEntity paramConferenceParticipantRepositoryEntity2)
    {
      if ((da.a(paramConferenceParticipantRepositoryEntity1.displayName)) && (!da.a(paramConferenceParticipantRepositoryEntity2.displayName)))
        return 1;
      if ((!da.a(paramConferenceParticipantRepositoryEntity1.displayName)) && (da.a(paramConferenceParticipantRepositoryEntity2.displayName)))
        return -1;
      if ((!da.a(paramConferenceParticipantRepositoryEntity1.displayName)) && (!da.a(paramConferenceParticipantRepositoryEntity2.displayName)))
        return paramConferenceParticipantRepositoryEntity1.displayName.compareToIgnoreCase(paramConferenceParticipantRepositoryEntity2.displayName);
      return da.h(paramConferenceParticipantRepositoryEntity1.number).compareTo(da.h(paramConferenceParticipantRepositoryEntity2.number));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallPresenter
 * JD-Core Version:    0.6.2
 */