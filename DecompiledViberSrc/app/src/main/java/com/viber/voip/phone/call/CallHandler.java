package com.viber.voip.phone.call;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.CMissedCall;
import com.viber.jni.CallStatistics;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PeerTrustState;
import com.viber.jni.PhoneControllerDelegate;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.PhoneControllerReadyListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerCallInterruptionListener;
import com.viber.jni.dialer.DialerCallbackListener;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerCallback;
import com.viber.jni.dialer.DialerControllerDelegate.DialerHoldState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerIncomingScreen;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerMuteState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerVideo;
import com.viber.jni.dialer.DialerHoldStateListener;
import com.viber.jni.dialer.DialerIncomingScreenListener;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.jni.dialer.DialerMuteStateListener;
import com.viber.jni.dialer.DialerOutgoingScreenListener;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.jni.dialer.DialerRemoteCallStateListener;
import com.viber.jni.dialer.DialerTransferCallListener;
import com.viber.jni.dialer.DialerVideoListener;
import com.viber.jni.dialer.WebRtcDialerController;
import com.viber.jni.secure.TrustPeerCallsListener;
import com.viber.jni.secure.TrustPeerController;
import com.viber.jni.webrtc.IceCandidate;
import com.viber.jni.webrtc.ProcessedCallback;
import com.viber.jni.webrtc.SdpProcessedCallback;
import com.viber.jni.webrtc.WebRtcDelegate;
import com.viber.jni.webrtc.WebRtcListener;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.f.b;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.i;
import com.viber.voip.calls.d.a;
import com.viber.voip.contacts.ui.ContactDetailsFragment;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.i.c.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.BasicRTCCall.Completion;
import com.viber.voip.phone.BasicRTCCall.RTCCallDelegate;
import com.viber.voip.phone.BasicRTCCall.SdpCallback;
import com.viber.voip.phone.CallController;
import com.viber.voip.phone.PhoneApp;
import com.viber.voip.phone.RTCCall;
import com.viber.voip.phone.ViberRTCCall;
import com.viber.voip.phone.call.listeners.CallInitiationListenersStore;
import com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore;
import com.viber.voip.phone.call.listeners.RingerListener;
import com.viber.voip.phone.call.listeners.StartCallListener;
import com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore;
import com.viber.voip.phone.conf.ConferenceCall;
import com.viber.voip.phone.conf.IConferenceCall.CreateConferenceCallback;
import com.viber.voip.phone.conf.IConferenceCall.JoinConferenceCallback;
import com.viber.voip.phone.conf.IConferenceCall.SnConferenceDelegate;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate..CC;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate.CreationStatus;
import com.viber.voip.phone.conf.Im2ConferenceApi;
import com.viber.voip.phone.conf.RTCConfCall;
import com.viber.voip.phone.conf.ViberRTCConfCall;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.bj;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.az;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.ao;
import com.viber.voip.util.cg;
import com.viber.voip.util.ci;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import com.viber.voip.util.p;
import com.viber.voip.util.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.webrtc.videoengine.ViEVideoSupport;

public class CallHandler
  implements PhoneControllerReadyListener, DialerControllerDelegate.DialerCallback, DialerControllerDelegate.DialerHoldState, DialerControllerDelegate.DialerIncomingScreen, DialerControllerDelegate.DialerLocalCallState, DialerControllerDelegate.DialerMuteState, DialerControllerDelegate.DialerPhoneState, DialerControllerDelegate.DialerVideo, WebRtcDelegate, BasicRTCCall.RTCCallDelegate, IConferenceCall.UiDelegate
{
  private static final String KEY_CONTACT_DETAILS_ANALYTICS = "contact_details_analytics_call_info";
  private static final String KEY_NEXT_CALL_VO_TRIGGER_ANALYTICS = "next_call_vo_trigger_analytics";
  private static final Logger L = ViberEnv.getLogger();
  private Set<CallInfoReadyListener> callInfoListeners = new HashSet(10);
  private CallController mCallController;
  private final Handler mCallControllerHandler;
  private final CallInitiationListenersStore mCallInitiationListenersStore = new CallInitiationListenersStore();
  private com.viber.voip.notif.i.a mCallNotifier;
  private final CallReceptionHandler mCallReceptionHandler = new CallReceptionHandler();
  private ConferenceCall mConference;
  private final ConferenceInitializationListenersStore mConferenceInitializationListenersStore = new ConferenceInitializationListenersStore(new CallHandler..Lambda.0(this));
  private ContactDetailsAnalyticsCallInfo mContactDetailsAnalyticsCallInfo;
  private final Context mContext;
  private JoiningConferenceData mCurrentDialingConferenceDetails = null;
  private DialerController mDialerController;
  private final Runnable mHandleLocalHoldAction = new CallHandler..Lambda.1(this);
  private final Runnable mHandleLocalUnholdAction = new CallHandler..Lambda.2(this);
  private IConferenceCall.SnConferenceDelegate mIm2ConferenceDelegate;
  private AtomicBoolean mIsNextCallFromSecretConversation = new AtomicBoolean(false);
  private String mLastConferenceId = "none";
  private int mLastPeerCID;
  private volatile boolean mLastPeerConferenceSupportStatus;
  private RTCCall mOneOnOneRtcCall;
  private final dagger.a<com.viber.common.permission.c> mPermissionManager;
  private PhoneControllerDelegateAdapter mPhoneControllerDelegateAdapter = new PhoneControllerDelegateAdapter()
  {
    private boolean insertMissedCallToCallLog(long paramAnonymousLong1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2, String[] paramAnonymousArrayOfString, long paramAnonymousLong2, long paramAnonymousLong3, int paramAnonymousInt3, String paramAnonymousString3, d.a paramAnonymousa)
    {
      long l = TimeUnit.MILLISECONDS.toSeconds(paramAnonymousLong3);
      if (3 != paramAnonymousInt1)
      {
        String str1;
        if (TextUtils.isEmpty(paramAnonymousString2))
        {
          str1 = "private_number";
          if (!TextUtils.isEmpty(paramAnonymousString1))
            break label72;
        }
        label72: for (String str2 = str1; ; str2 = paramAnonymousString1)
        {
          p.a(paramAnonymousLong1, str1, str2, System.currentTimeMillis(), 0L, 3, 0, 0, paramAnonymousInt3, paramAnonymousInt1, null, paramAnonymousString3, paramAnonymousa);
          return true;
          str1 = paramAnonymousString2;
          break;
        }
      }
      if (2 == paramAnonymousInt2)
      {
        av.a(av.e.f).post(new CallHandler.21..Lambda.1(this, paramAnonymousString1, paramAnonymousArrayOfString, paramAnonymousLong1, paramAnonymousString2, paramAnonymousLong2, l, paramAnonymousInt3, paramAnonymousInt1, paramAnonymousString3, paramAnonymousa));
        return true;
      }
      if (3 == paramAnonymousInt2)
      {
        av.a(av.e.f).post(new CallHandler.21..Lambda.2(this, paramAnonymousString1, paramAnonymousArrayOfString, paramAnonymousLong1, paramAnonymousString2, paramAnonymousLong2, l, paramAnonymousInt3, paramAnonymousString3, paramAnonymousa));
        return true;
      }
      return false;
    }

    private ConferenceInfo loadConferenceInfo(String paramAnonymousString, String[] paramAnonymousArrayOfString)
    {
      String str = CallHandler.this.mContext.getResources().getString(R.string.unknown);
      ConferenceInfo localConferenceInfo = ((ConferenceParticipantsRepository)CallHandler.this.mViberApplication.getLazyConferenceParticipantsRepository().get()).loadConferenceInfo(paramAnonymousString, paramAnonymousArrayOfString, str);
      if (localConferenceInfo != null)
        localConferenceInfo.setIsSelfInitiated(false);
      return localConferenceInfo;
    }

    public void onCallMissed(long paramAnonymousLong1, String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2, int paramAnonymousInt3, String paramAnonymousString3, int paramAnonymousInt4, String[] paramAnonymousArrayOfString, String paramAnonymousString4, long paramAnonymousLong2, long paramAnonymousLong3)
    {
      super.onCallMissed(paramAnonymousLong1, paramAnonymousString1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString2, paramAnonymousInt3, paramAnonymousString3, paramAnonymousInt4, paramAnonymousArrayOfString, paramAnonymousString4, paramAnonymousLong2, paramAnonymousLong3);
      insertMissedCallToCallLog(paramAnonymousLong1, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousArrayOfString, paramAnonymousLong2, paramAnonymousLong3, 0, paramAnonymousString3, null);
    }

    public boolean onGetMissedCalls(CMissedCall[] paramAnonymousArrayOfCMissedCall)
    {
      long[] arrayOfLong = new long[paramAnonymousArrayOfCMissedCall.length];
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      for (int i = 0; i < paramAnonymousArrayOfCMissedCall.length; i++)
      {
        CMissedCall localCMissedCall = paramAnonymousArrayOfCMissedCall[i];
        CallHandler.21..Lambda.0 local0 = new CallHandler.21..Lambda.0(arrayOfLong, i, localCMissedCall, localArrayList1, localArrayList2);
        if (!insertMissedCallToCallLog(localCMissedCall.getToken(), localCMissedCall.getMemberId(), localCMissedCall.getPhoneNumber(), localCMissedCall.getCallType(), localCMissedCall.getConferenceState(), localCMissedCall.getConferenceMemberIDs(), localCMissedCall.getCalledAt(), localCMissedCall.getDuration(), localCMissedCall.getFlags(), localCMissedCall.getToVln(), local0))
          local0.onInsert(null);
      }
      return true;
    }

    public void playTone(int paramAnonymousInt)
    {
      ViberApplication.getInstance().getRingtonePlayer().playInCallTone(paramAnonymousInt);
    }

    public void stopTone()
    {
      ViberApplication.getInstance().getRingtonePlayer().stopInCallTone();
    }
  };
  private SingleAdForCallFetcher mSingleAdForCallFetcher;
  private final SwitchToConferenceListenersStore mSwitchToConferenceListenersStore = new SwitchToConferenceListenersStore();
  private final TrustPeerController mTrustPeerController;
  private final ViberApplication mViberApplication;
  private final Handler mViberRtcHandler;
  private final WebRtcDialerController mWebRtcDialerController;
  private Map<Integer, List<Runnable>> pendingTasks = Collections.synchronizedMap(new WeakHashMap());

  public CallHandler(Context paramContext, ViberApplication paramViberApplication, DialerController paramDialerController, WebRtcDialerController paramWebRtcDialerController, TrustPeerController paramTrustPeerController, EngineDelegatesManager paramEngineDelegatesManager, Im2ConferenceApi paramIm2ConferenceApi)
  {
    this.mContext = paramContext;
    this.mViberApplication = paramViberApplication;
    this.mIm2ConferenceDelegate = paramIm2ConferenceApi;
    this.mDialerController = paramDialerController;
    this.mWebRtcDialerController = paramWebRtcDialerController;
    this.mTrustPeerController = paramTrustPeerController;
    this.mPermissionManager = new com.viber.voip.g.b.b()
    {
      protected com.viber.common.permission.c initInstance()
      {
        return com.viber.common.permission.c.a(CallHandler.this.mContext);
      }
    };
    this.mCallControllerHandler = av.e.a.a();
    this.mCallController = new CallController(this.mDialerController, this.mCallControllerHandler, this.mPermissionManager);
    this.mViberRtcHandler = av.e.e.a();
    paramEngineDelegatesManager.getTrustPeerCallsListener().registerDelegate(this.mCallController, this.mCallControllerHandler);
    paramEngineDelegatesManager.getDialerRemoteCallStateListener().registerDelegate(this.mCallController, this.mCallControllerHandler);
    paramEngineDelegatesManager.getDialerTransferCallListener().registerDelegate(this.mCallController, this.mCallControllerHandler);
    paramEngineDelegatesManager.getDialerOutgoingScreenListener().registerDelegate(this.mCallController, this.mCallControllerHandler);
    paramEngineDelegatesManager.getDialerCallInterruptionListener().registerDelegate(this.mCallController, this.mCallControllerHandler);
    paramEngineDelegatesManager.getDialerMuteStateListener().registerDelegateQueue(this.mCallController, this.mCallControllerHandler, new DialerControllerDelegate.DialerMuteState[] { this });
    paramEngineDelegatesManager.getDialerHoldStateListener().registerDelegateQueue(this.mCallController, this.mCallControllerHandler, new DialerControllerDelegate.DialerHoldState[] { this });
    paramEngineDelegatesManager.getDialerVideoListener().registerDelegateQueue(this.mCallController, this.mCallControllerHandler, new DialerControllerDelegate.DialerVideo[] { this });
    paramEngineDelegatesManager.getDialerLocalCallStateListener().registerDelegateQueue(this.mCallController, this.mCallControllerHandler, new DialerControllerDelegate.DialerLocalCallState[] { this });
    paramEngineDelegatesManager.getDialerPhoneStateListener().registerDelegateQueue(this.mCallController, this.mCallControllerHandler, new DialerControllerDelegate.DialerPhoneState[] { this });
    paramEngineDelegatesManager.getDialerCallbackListener().registerDelegateQueue(this.mCallController, this.mCallControllerHandler, new DialerControllerDelegate.DialerCallback[] { this });
    paramEngineDelegatesManager.getDialerIncomingScreenListener().registerDelegateQueue(this.mCallController, this.mCallControllerHandler, new DialerControllerDelegate.DialerIncomingScreen[] { this });
    paramEngineDelegatesManager.getWebRtcListener().registerDelegate(this, this.mCallControllerHandler);
    PhoneControllerDelegate[] arrayOfPhoneControllerDelegate = new PhoneControllerDelegate[1];
    arrayOfPhoneControllerDelegate[0] = this.mPhoneControllerDelegateAdapter;
    paramEngineDelegatesManager.registerDelegate(arrayOfPhoneControllerDelegate);
    Handler localHandler = av.e.e.a();
    StartCallListener localStartCallListener = new StartCallListener(ViberApplication.getApplication());
    paramEngineDelegatesManager.getDialerIncomingScreenListener().registerDelegate(localStartCallListener, localHandler);
    paramEngineDelegatesManager.getDialerOutgoingScreenListener().registerDelegate(localStartCallListener, localHandler);
    addCallInfoReadyListener(localStartCallListener);
    this.mCallNotifier = new com.viber.voip.notif.i.a();
    addCallInfoReadyListener(this.mCallNotifier);
    paramEngineDelegatesManager.getDialerPhoneStateListener().registerDelegate(this.mCallNotifier, this.mCallControllerHandler);
    paramEngineDelegatesManager.getDialerLocalCallStateListener().registerDelegate(this.mCallNotifier, this.mCallControllerHandler);
    initRingerListener(paramEngineDelegatesManager);
  }

  private void askToHangupConference()
  {
    this.mCallControllerHandler.post(new CallHandler..Lambda.4(this));
  }

  private void cancelVideoPttPlayAndRecord()
  {
    com.viber.voip.u.d locald = this.mViberApplication.getMessagesManager().n();
    if (locald != null)
      locald.c();
    com.viber.voip.u.e locale = this.mViberApplication.getMessagesManager().o();
    if (locale != null)
      locale.e();
  }

  private void checkAndTrackContactDetailsCallSource(long paramLong, CallInfo paramCallInfo)
  {
    ContactDetailsAnalyticsCallInfo localContactDetailsAnalyticsCallInfo = (ContactDetailsAnalyticsCallInfo)paramCallInfo.getCustomProperty("contact_details_analytics_call_info");
    if (localContactDetailsAnalyticsCallInfo == null);
    int i;
    Boolean localBoolean;
    do
    {
      do
      {
        return;
        i = localContactDetailsAnalyticsCallInfo.callSource();
      }
      while (i == 0);
      localBoolean = localContactDetailsAnalyticsCallInfo.isViberUser();
    }
    while (localBoolean == null);
    switch (i)
    {
    case 2:
    default:
      return;
    case 1:
      ContactDetailsFragment.a(localBoolean.booleanValue(), 1, paramLong);
      return;
    case 3:
      ContactDetailsFragment.a(localBoolean.booleanValue(), 3, paramLong);
      return;
    case 4:
    }
    ContactDetailsFragment.a(localBoolean.booleanValue(), 4, paramLong);
  }

  private CallInfo createCallInfo(String paramString1, String paramString2, CallInfo.CallType paramCallType, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, com.viber.voip.model.a parama, String paramString3, ConferenceInfo paramConferenceInfo)
  {
    return createCallInfo(paramString1, paramString2, paramCallType, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, parama, paramString3, paramConferenceInfo, -1L, null);
  }

  private CallInfo createCallInfo(String paramString1, String paramString2, CallInfo.CallType paramCallType, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, com.viber.voip.model.a parama, String paramString3, ConferenceInfo paramConferenceInfo, long paramLong, String paramString4)
  {
    if ((CallInfo.CallType.INCOMING == paramCallType) && (paramInt == 0) && (d.m.e.d()))
      paramInt = 1;
    CallerInfo localCallerInfo = new CallerInfo(paramString1, paramString2, parama, this.mTrustPeerController.isPeerTrusted(paramString2).toEnum(), paramConferenceInfo);
    CallInfo localCallInfo;
    int i;
    if (CallInfo.CallType.INCOMING == paramCallType)
    {
      localCallInfo = this.mCallController.startInCall(localCallerInfo, paramInt, paramBoolean1, paramString3, paramLong, paramString4);
      localCallInfo.getInCallState().setConferenceSupported(this.mLastPeerConferenceSupportStatus);
      i = d.m.u.d();
      if (System.currentTimeMillis() < d.m.t.d())
        break label179;
    }
    label179: for (int j = 1; ; j = 0)
    {
      if ((i != 0) && (j != 0))
        localCallInfo.setShowAddToCallAnimation(true);
      inflateContactDetailsAnalyticsCallInfoInto(localCallInfo);
      localCallInfo.getInCallState().notifyObservers();
      notifyCallInfoReadyListeners(localCallInfo);
      return localCallInfo;
      localCallInfo = this.mCallController.startOutCall(localCallerInfo, paramBoolean2, paramBoolean3, paramBoolean4, paramString3, paramLong);
      break;
    }
  }

  private BasicRTCCall.SdpCallback createSdpNegotiationCallback(String paramString, final Runnable paramRunnable)
  {
    return new BasicRTCCall.SdpCallback()
    {
      public void onError()
      {
      }

      public void ready(final String paramAnonymousString)
      {
        if (paramAnonymousString.isEmpty())
        {
          paramRunnable.run();
          return;
        }
        CallHandler.this.mWebRtcDialerController.handleSendSdpOfferToHs(paramAnonymousString);
        CallHandler.this.mWebRtcDialerController.handleSendSdpOffer(paramAnonymousString, new SdpProcessedCallback()
        {
          public void onProcessed(String paramAnonymous2String)
          {
            if (paramAnonymous2String.isEmpty());
            while (CallHandler.this.mOneOnOneRtcCall == null)
              return;
            CallHandler.this.mOneOnOneRtcCall.applySdpAnswer(paramAnonymous2String, paramAnonymousString, new BasicRTCCall.Completion()
            {
              public void onFailure()
              {
                CallHandler.14.this.val$onCompleted.run();
              }

              public void onSuccess()
              {
                CallHandler.14.this.val$onCompleted.run();
              }
            });
          }
        });
      }
    };
  }

  private void doHandleDialFree(final Member paramMember, final boolean paramBoolean)
  {
    if (this.mOneOnOneRtcCall == null)
    {
      this.mOneOnOneRtcCall = ViberRTCCall.create(this);
      if (paramBoolean)
        ViberApplication.getInstance().logToCrashlytics("Start video call");
      this.mOneOnOneRtcCall.startOutgoingCall(paramBoolean, false, new BasicRTCCall.SdpCallback()
      {
        public void onError()
        {
          if (CallHandler.this.mOneOnOneRtcCall != null)
          {
            CallHandler.this.mOneOnOneRtcCall.deinitCall();
            CallHandler.access$1102(CallHandler.this, null);
          }
        }

        public void ready(String paramAnonymousString)
        {
          CallHandler.this.mWebRtcDialerController.handleDial(paramMember.getId(), paramAnonymousString, paramBoolean);
        }
      });
    }
  }

  private void doHandleDialViberOut(final boolean paramBoolean, final com.viber.voip.model.entity.g paramg, final String paramString)
  {
    if (this.mOneOnOneRtcCall == null)
    {
      this.mOneOnOneRtcCall = ViberRTCCall.create(this);
      this.mOneOnOneRtcCall.startOutgoingCall(false, true, new BasicRTCCall.SdpCallback()
      {
        public void onError()
        {
          if (CallHandler.this.mOneOnOneRtcCall != null)
          {
            CallHandler.this.mOneOnOneRtcCall.deinitCall();
            CallHandler.access$1102(CallHandler.this, null);
          }
        }

        public void ready(String paramAnonymousString)
        {
          WebRtcDialerController localWebRtcDialerController = CallHandler.this.mWebRtcDialerController;
          if (paramBoolean);
          for (String str = ((com.viber.voip.model.entity.k)paramg.a().iterator().next()).c(); ; str = paramString)
          {
            localWebRtcDialerController.handleDialViberOut(str, paramAnonymousString);
            return;
          }
        }
      });
    }
  }

  private void executePendingTasksForPhoneState(int paramInt)
  {
    List localList;
    synchronized (this.pendingTasks)
    {
      localList = (List)this.pendingTasks.put(Integer.valueOf(paramInt), null);
      if (localList == null)
        return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      ((Runnable)localIterator.next()).run();
  }

  private void handleDial(final ParticipantSelector.Participant paramParticipant, boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4)
  {
    try
    {
      final long l = CallInitiationId.getCurrentCallInitiationAttemptId();
      cancelVideoPttPlayAndRecord();
      if (!isValidCallStateInternal())
        this.mCallInitiationListenersStore.notifyListeners(0, l);
      while (true)
      {
        return;
        ((com.viber.voip.analytics.story.b.a.c)ViberApplication.getInstance().getEndCallEventCollector().get()).a();
        dr.a(paramParticipant, new dr.a()
        {
          @SuppressLint({"MissingPermission"})
          public void onCheckStatus(boolean paramAnonymousBoolean, int paramAnonymousInt, final ParticipantSelector.Participant paramAnonymousParticipant, com.viber.voip.model.entity.g paramAnonymousg)
          {
            switch (paramAnonymousInt)
            {
            case 3:
            default:
              return;
            case 4:
              ad.a().d();
              CallHandler.this.mCallInitiationListenersStore.notifyListeners(1, l);
              return;
            case 2:
              com.viber.voip.ui.dialogs.f.d().d();
              CallHandler.this.mCallInitiationListenersStore.notifyListeners(2, l);
              return;
            case 5:
            case 6:
              Intent localIntent = new Intent("android.intent.action.CALL");
              localIntent.setData(Uri.fromParts("tel", paramAnonymousParticipant.getNumber(), null));
              localIntent.setFlags(268435456);
              if (((com.viber.common.permission.c)CallHandler.this.mPermissionManager.get()).a(n.q))
                CallHandler.this.mContext.startActivity(localIntent);
              while (true)
              {
                CallHandler.this.mCallInitiationListenersStore.notifyListeners(3, l);
                return;
                ViberActionRunner.ao.a(CallHandler.this.mContext, n.q, 55, PendingIntent.getActivity(CallHandler.this.mContext, 0, localIntent, 0));
              }
            case -1:
              com.viber.voip.ui.dialogs.b.h().d();
              CallHandler.this.mCallInitiationListenersStore.notifyListeners(4, l);
              return;
            case 1:
              if ((!paramParticipant) || (CallHandler.this.isInvalidNumber(paramAnonymousParticipant)))
              {
                String str3 = paramAnonymousParticipant.getNumberOrUnknown(CallHandler.this.mContext);
                l.a(str3).b(-1, new Object[] { str3, "" }).d();
                CallHandler.this.mCallInitiationListenersStore.notifyListeners(5, l);
                return;
              }
              String str4 = "";
              if (paramBoolean2.getMemberId() != null)
                str4 = paramBoolean2.getMemberId();
              while (true)
              {
                Member localMember2 = new Member(str4, paramBoolean2.getNumber());
                if (!com.viber.voip.block.g.a(localMember2))
                  break;
                String str5 = paramBoolean2.getDisplayName();
                if (TextUtils.isEmpty(str5))
                  str5 = paramBoolean2.getNumber();
                CallHandler.this.showBlockedNumberDialog(localMember2, str5, paramParticipant, paramBoolean4, paramBoolean3);
                CallHandler.this.mCallInitiationListenersStore.notifyListeners(6, l);
                return;
                if (paramBoolean2.getNumber() != null)
                  str4 = paramBoolean2.getNumber();
              }
              CallHandler.this.createCallInfo(paramBoolean2.getNumber(), paramBoolean2.getNumber(), CallInfo.CallType.OUTGOING, 0, false, true, false, paramBoolean3, paramAnonymousg, "", null);
              CallHandler.this.doHandleDialViberOut(paramAnonymousBoolean, paramAnonymousg, paramBoolean2.getNumber());
              CallHandler.this.mCallInitiationListenersStore.notifyListeners(11, l);
              return;
            case 7:
              CallHandler.this.createCallInfo(paramAnonymousParticipant.getNumber(), paramAnonymousParticipant.getNumber(), CallInfo.CallType.OUTGOING, 0, false, true, false, paramBoolean3, paramAnonymousg, "", null);
              CallHandler.this.doHandleDialViberOut(paramAnonymousBoolean, paramAnonymousg, paramAnonymousParticipant.getNumber());
              CallHandler.this.mCallInitiationListenersStore.notifyListeners(11, l);
              return;
            case 0:
            }
            com.viber.voip.model.j localj = paramAnonymousg.a(new ci()
            {
              public boolean apply(com.viber.voip.model.j paramAnonymous2j)
              {
                return (paramAnonymous2j.a().equals(paramAnonymousParticipant.getMemberId())) || (paramAnonymous2j.c().equals(paramAnonymousParticipant.getNumber()));
              }
            });
            if (localj == null)
            {
              String str2 = "is local: " + paramAnonymousBoolean + paramAnonymousParticipant + paramAnonymousg;
              CallHandler.L.a(new IllegalArgumentException("NPE: no number data"), str2);
              localj = paramAnonymousg.n();
            }
            if (localj == null)
            {
              String str1 = "is local: " + paramAnonymousBoolean + paramAnonymousParticipant + paramAnonymousg;
              CallHandler.L.a(new IllegalArgumentException("NPE: no primary number data"), str1);
              com.viber.voip.ui.dialogs.k.n().d();
              CallHandler.this.mCallInitiationListenersStore.notifyListeners(7, l);
              return;
            }
            Member localMember1 = Member.from(localj);
            boolean bool1;
            if ((!this.val$checkNumber) || (!((Boolean)paramAnonymousg.c().get(localMember1)).booleanValue()))
            {
              bool1 = paramParticipant;
              if ((!paramParticipant) || (!CallHandler.this.shouldConnectViberOutCallForFree(paramAnonymousg)))
                break label978;
              bool1 = false;
            }
            label978: for (boolean bool2 = true; ; bool2 = false)
            {
              CallHandler.this.createCallInfo(paramAnonymousParticipant.getNumber(), localMember1.getId(), CallInfo.CallType.OUTGOING, 0, false, bool1, paramBoolean4, paramBoolean3, paramAnonymousg, "", null).putCustomProperty("next_call_vo_trigger_analytics", Boolean.valueOf(bool2));
              if (bool1)
              {
                CallHandler.this.doHandleDialViberOut(paramAnonymousBoolean, paramAnonymousg, paramAnonymousParticipant.getNumber());
                CallHandler.this.mCallInitiationListenersStore.notifyListeners(11, l);
                return;
              }
              CallHandler.this.doHandleDialFree(localMember1, paramBoolean4);
              if (paramBoolean4);
              for (int i = 10; ; i = 9)
              {
                CallHandler.this.mCallInitiationListenersStore.notifyListeners(i, l);
                return;
              }
              CallHandler.this.showBlockedNumberDialog(localMember1, paramAnonymousg.k(), paramParticipant, paramBoolean4, paramBoolean3);
              CallHandler.this.mCallInitiationListenersStore.notifyListeners(6, l);
              return;
            }
          }
        }
        , av.a(av.e.e));
      }
    }
    finally
    {
    }
  }

  private void handleHangupConference()
  {
    if (this.mConference != null)
    {
      this.mCurrentDialingConferenceDetails = null;
      this.mConference.leaveConference();
      CallStatistics localCallStatistics = this.mConference.getStats();
      this.mDialerController.handleReportStatistics(localCallStatistics);
      this.mConference.deinit();
      this.mConferenceInitializationListenersStore.notifyListeners(false, this.mConference);
      this.mConference = null;
    }
  }

  private void inflateContactDetailsAnalyticsCallInfoInto(CallInfo paramCallInfo)
  {
    if (this.mContactDetailsAnalyticsCallInfo != null)
    {
      paramCallInfo.putCustomProperty("contact_details_analytics_call_info", this.mContactDetailsAnalyticsCallInfo.copy());
      this.mContactDetailsAnalyticsCallInfo = null;
    }
  }

  private void initRingerListener(EngineDelegatesManager paramEngineDelegatesManager)
  {
    RingerListener localRingerListener = new RingerListener(this.mViberApplication.getRingtonePlayerLazy());
    paramEngineDelegatesManager.getDialerIncomingScreenListener().registerDelegate(localRingerListener, av.e.e.a());
    addCallInfoReadyListener(localRingerListener);
  }

  private boolean isInvalidNumber(ParticipantSelector.Participant paramParticipant)
  {
    return (TextUtils.isEmpty(paramParticipant.getNumber())) || (cg.c(paramParticipant.getNumber()));
  }

  private boolean isValidCallStateInternal()
  {
    Engine localEngine = this.mViberApplication.getEngine(true);
    CallInfo localCallInfo = localEngine.getCurrentCall();
    if ((localCallInfo != null) && (localCallInfo.isCalling()));
    for (int i = 1; i != 0; i = 0)
    {
      ViberApplication.getInstance().showToast(R.string.alert_dialog_call_blocked);
      return false;
    }
    if ((localEngine.getDialerController().getPhoneState() == 2) || (localEngine.isGSMCallActive()))
    {
      com.viber.voip.ui.dialogs.b.a().d();
      return false;
    }
    return true;
  }

  private SingleAdForCallFetcher obtainAdsAfterCallFetcher()
  {
    if (this.mSingleAdForCallFetcher == null)
      this.mSingleAdForCallFetcher = new SingleAdForCallFetcher(this.mViberApplication.getMessagesManager().i());
    return this.mSingleAdForCallFetcher;
  }

  private RTCCall obtainOneOnOneCall()
  {
    if (this.mOneOnOneRtcCall == null)
    {
      cancelVideoPttPlayAndRecord();
      this.mOneOnOneRtcCall = ViberRTCCall.create(this);
    }
    return this.mOneOnOneRtcCall;
  }

  private boolean shouldConnectViberOutCallForFree(com.viber.voip.model.entity.g paramg)
  {
    return (c.e.a.e()) && (paramg.p()) && (!d.bj.a.d());
  }

  private void showBlockedNumberDialog(Member paramMember, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ViberDialogHandlers.az localaz = new ViberDialogHandlers.az();
    localaz.c = paramBoolean1;
    localaz.d = paramBoolean2;
    localaz.e = paramBoolean3;
    localaz.b = Collections.singleton(paramMember);
    t.a(com.viber.common.d.c.a(this.mContext, R.string.dialog_424_title, new Object[] { paramString }), this.mContext.getString(R.string.dialog_424_message, new Object[] { paramString, paramString })).a(localaz).d();
  }

  public boolean addCallInfoReadyListener(CallInfoReadyListener paramCallInfoReadyListener)
  {
    if (this.mCallController.getCurrentCall() != null)
      paramCallInfoReadyListener.onCallInfoReady(this.mCallController.getCurrentCall());
    return this.callInfoListeners.add(paramCallInfoReadyListener);
  }

  public void checkSplashAfterCall()
  {
    CallInfo localCallInfo = getLastCallInfo();
    if (localCallInfo == null);
    int i;
    boolean bool;
    do
    {
      InCallState localInCallState;
      do
      {
        return;
        localInCallState = localCallInfo.getInCallState();
      }
      while (localInCallState.getCallStats().getCallDuration() <= 0L);
      i = localInCallState.getEndReason();
      bool = localCallInfo.isViberOut();
      if ((3 == localInCallState.getDisconnectStatus()) || (4 == i))
      {
        i locali1 = i.a();
        com.viber.voip.banner.d.j[] arrayOfj1 = new com.viber.voip.banner.d.j[1];
        if (bool);
        for (com.viber.voip.banner.d.j localj1 = com.viber.voip.banner.d.j.f; ; localj1 = com.viber.voip.banner.d.j.d)
        {
          arrayOfj1[0] = localj1;
          locali1.a(arrayOfj1);
          return;
        }
      }
    }
    while (((11 != i) && (3 != i)) || (!ViberApplication.getInstance().isOnForeground()));
    i locali2 = i.a();
    com.viber.voip.banner.d.j[] arrayOfj2 = new com.viber.voip.banner.d.j[1];
    if (bool);
    for (com.viber.voip.banner.d.j localj2 = com.viber.voip.banner.d.j.e; ; localj2 = com.viber.voip.banner.d.j.c)
    {
      arrayOfj2[0] = localj2;
      locali2.a(arrayOfj2);
      return;
    }
  }

  public CallInfo getCallInfo()
  {
    return this.mCallController.getCurrentCall();
  }

  public CallInitiationListenersStore getCallInitiationListenersStore()
  {
    return this.mCallInitiationListenersStore;
  }

  public com.viber.voip.notif.i.a getCallNotifier()
  {
    return this.mCallNotifier;
  }

  public ConferenceInitializationListenersStore getConferenceInitializationListenersStore()
  {
    return this.mConferenceInitializationListenersStore;
  }

  public long getCurrentCallToken()
  {
    return this.mDialerController.handleGetCallToken();
  }

  public ConferenceCall getCurrentConferenceCall()
  {
    return this.mConference;
  }

  public String getCurrentConferenceId()
  {
    return this.mLastConferenceId;
  }

  public InCallState getCurrentInCallState()
  {
    return this.mCallController.getCurrentInCallState();
  }

  public String getDeviceModel()
  {
    return Build.MODEL;
  }

  public CallInfo getLastCallInfo()
  {
    return this.mCallController.getLastCallInfo();
  }

  public RTCCall getRTCCall()
  {
    return this.mOneOnOneRtcCall;
  }

  public SwitchToConferenceListenersStore getSwitchToConferenceListenersStore()
  {
    return this.mSwitchToConferenceListenersStore;
  }

  public String getSystemName()
  {
    return "unknown";
  }

  public String getSystemVersion()
  {
    return Build.VERSION.SDK_INT + "(" + Build.VERSION.CODENAME + ")";
  }

  public String getViberVersion()
  {
    return "11.0.1.0";
  }

  public String getVoiceLibVersion()
  {
    return "pre-new-webrtc.346";
  }

  public String getWebRtcVersion()
  {
    return "70-23721-g4ab51cb-107043.3-112137.1-64";
  }

  public void handleAddPeersToConference(String[] paramArrayOfString)
  {
    if (this.mConference == null)
      return;
    this.mConference.invitePeers(paramArrayOfString);
  }

  public void handleAnswer(boolean paramBoolean)
  {
    if (this.mOneOnOneRtcCall == null)
      return;
    ((com.viber.voip.analytics.story.b.a.c)ViberApplication.getInstance().getEndCallEventCollector().get()).a();
    if (paramBoolean)
      ViberApplication.getInstance().logToCrashlytics("Answer video call");
    this.mDialerController.handleAnswer(paramBoolean);
    this.mOneOnOneRtcCall.getOffer(new BasicRTCCall.SdpCallback()
    {
      public void onError()
      {
      }

      public void ready(String paramAnonymousString)
      {
        CallHandler.this.mWebRtcDialerController.handleSendSdpOfferToHs(paramAnonymousString);
      }
    });
  }

  public void handleAnswerAudioConference()
  {
    long l1 = getCurrentCallToken();
    if ((this.mOneOnOneRtcCall != null) || (this.mConference != null))
      return;
    ((com.viber.voip.analytics.story.b.a.c)ViberApplication.getInstance().getEndCallEventCollector().get()).a();
    RTCConfCall localRTCConfCall = ViberRTCConfCall.create(this);
    long l2 = ViberApplication.getInstance().getEngine(true).getPhoneController().getMyCID();
    this.mConference = new ConferenceCall(this.mIm2ConferenceDelegate, localRTCConfCall, l2);
    this.mConference.addUiDelegate(this);
    this.mConferenceInitializationListenersStore.notifyListeners(true, this.mConference);
    this.mConference.joinConference(l1, new CallHandler..Lambda.3(this));
  }

  public void handleCameraFlip()
  {
    this.mCallController.handleCameraFlip();
  }

  public void handleDial(String paramString, boolean paramBoolean)
  {
    handleDial(ParticipantSelector.Participant.createUnknown(paramString), false, paramBoolean, true, this.mIsNextCallFromSecretConversation.getAndSet(false));
  }

  public void handleDial(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      handleDialViberOut(paramString);
      return;
    }
    handleDial(paramString, paramBoolean2);
  }

  public boolean handleDialAudioConference(final ConferenceInfo paramConferenceInfo, final long paramLong)
  {
    ConferenceParticipant[] arrayOfConferenceParticipant = paramConferenceInfo.getParticipants();
    if (!isValidCallStateInternal())
      return false;
    if ((this.mOneOnOneRtcCall != null) || (this.mConference != null))
      return false;
    ((com.viber.voip.analytics.story.b.a.c)ViberApplication.getInstance().getEndCallEventCollector().get()).a();
    RTCConfCall localRTCConfCall = ViberRTCConfCall.create(this);
    long l = ViberApplication.getInstance().getEngine(true).getPhoneController().getMyCID();
    this.mConference = new ConferenceCall(this.mIm2ConferenceDelegate, localRTCConfCall, l);
    this.mConference.addUiDelegate(this);
    this.mConferenceInitializationListenersStore.notifyListeners(true, this.mConference);
    final ArrayList localArrayList = new ArrayList();
    int i = arrayOfConferenceParticipant.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(arrayOfConferenceParticipant[j].getMemberId());
    this.mConference.createConference((String[])localArrayList.toArray(new String[0]), 0, new IConferenceCall.CreateConferenceCallback()
    {
      public void onConferenceCreated(IConferenceCall.UiDelegate.CreationStatus paramAnonymousCreationStatus, long paramAnonymousLong, String paramAnonymousString)
      {
        if (paramAnonymousCreationStatus != IConferenceCall.UiDelegate.CreationStatus.SUCCESS)
        {
          CallHandler.this.askToHangupConference();
          return;
        }
        CallHandler.access$1302(CallHandler.this, paramAnonymousString);
        av.a(av.e.f).post(new CallHandler.5..Lambda.0(this, localArrayList, paramAnonymousString, paramConferenceInfo, paramLong, paramAnonymousLong));
      }
    });
    return true;
  }

  public void handleDialViber(Member paramMember, boolean paramBoolean)
  {
    handleDial(ParticipantSelector.Participant.create(paramMember.getId(), paramMember.getPhoneNumber()), false, paramBoolean, true, this.mIsNextCallFromSecretConversation.getAndSet(false));
  }

  public void handleDialViberOut(String paramString)
  {
    handleDial(ParticipantSelector.Participant.createUnknown(paramString), true, false, true, this.mIsNextCallFromSecretConversation.getAndSet(false));
  }

  public void handleDialViberWithoutCheck(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    handleDial(ParticipantSelector.Participant.create(paramString), paramBoolean1, paramBoolean2, false, this.mIsNextCallFromSecretConversation.getAndSet(false));
  }

  public void handleDialWithoutCheck(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    handleDial(ParticipantSelector.Participant.createUnknown(paramString), paramBoolean1, paramBoolean2, false, this.mIsNextCallFromSecretConversation.getAndSet(false));
  }

  public void handleHangup()
  {
    this.mDialerController.handleHangup();
  }

  public boolean handleJoinOngoingAudioConference(long paramLong1, ConferenceInfo paramConferenceInfo, long paramLong2)
  {
    if (!isValidCallStateInternal())
      return false;
    if ((this.mOneOnOneRtcCall != null) || (this.mConference != null))
      return false;
    RTCConfCall localRTCConfCall = ViberRTCConfCall.create(this);
    long l = ViberApplication.getInstance().getEngine(true).getPhoneController().getMyCID();
    this.mConference = new ConferenceCall(this.mIm2ConferenceDelegate, localRTCConfCall, l);
    this.mConference.addUiDelegate(this);
    this.mConferenceInitializationListenersStore.notifyListeners(true, this.mConference);
    UserManager localUserManager = ViberApplication.getInstance().getUserManager();
    af localaf = localUserManager.getRegistrationValues();
    UserData localUserData = localUserManager.getUserData();
    ConferenceParticipant[] arrayOfConferenceParticipant1 = paramConferenceInfo.getParticipants();
    ConferenceParticipant[] arrayOfConferenceParticipant2 = (ConferenceParticipant[])Arrays.copyOf(arrayOfConferenceParticipant1, 1 + arrayOfConferenceParticipant1.length);
    ConferenceParticipant localConferenceParticipant = new ConferenceParticipant();
    localConferenceParticipant.setMemberId(localaf.l());
    localConferenceParticipant.setName(localUserData.getViberName());
    localConferenceParticipant.setImage(localUserData.getViberImage());
    arrayOfConferenceParticipant2[(-1 + arrayOfConferenceParticipant2.length)] = localConferenceParticipant;
    createCallInfo("", arrayOfConferenceParticipant2[0].getMemberId(), CallInfo.CallType.OUTGOING, 0, false, false, false, false, null, Long.toString(paramLong1), paramConferenceInfo, paramLong2, null);
    this.mCurrentDialingConferenceDetails = new JoiningConferenceData(false, paramLong1);
    this.mWebRtcDialerController.handleDialConference(paramLong1, false);
    return true;
  }

  public void handleLocalHold()
  {
    if (this.mConference != null)
    {
      this.mConference.hold();
      this.mHandleLocalHoldAction.run();
    }
    while (this.mOneOnOneRtcCall == null)
      return;
    this.mOneOnOneRtcCall.localHoldWithCompletion(createSdpNegotiationCallback("localHoldWithCompletion", this.mHandleLocalHoldAction));
  }

  public void handleLocalUnhold()
  {
    if (this.mConference != null)
    {
      this.mConference.unhold();
      this.mHandleLocalUnholdAction.run();
    }
    while (this.mOneOnOneRtcCall == null)
      return;
    this.mOneOnOneRtcCall.localUnholdWithCompletion(createSdpNegotiationCallback("localUnholdWithCompletion", this.mHandleLocalUnholdAction));
  }

  public void handleMute()
  {
    if (this.mOneOnOneRtcCall != null)
      this.mOneOnOneRtcCall.mute();
    if (this.mConference != null)
      this.mConference.mute();
    this.mCallController.mute();
    this.mDialerController.handleMute();
  }

  public void handleTransfer(boolean paramBoolean)
  {
    CallInfo localCallInfo = this.mCallController.getCurrentCall();
    if (localCallInfo == null)
      return;
    if (paramBoolean)
      localCallInfo.getInCallState().getCallStats().startCallTransfer();
    while (true)
    {
      localCallInfo.getInCallState().setTransferring(paramBoolean).notifyObservers();
      this.mDialerController.handleTransfer(paramBoolean);
      return;
      localCallInfo.getInCallState().getCallStats().stopCallTransfer();
    }
  }

  public boolean handleTransferToConferenceFrom1on1(final String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 1))
      return false;
    if ((this.mOneOnOneRtcCall == null) || ((this.mOneOnOneRtcCall != null) && (this.mConference != null)))
      return false;
    long l = ViberApplication.getInstance().getEngine(true).getPhoneController().getMyCID();
    this.mConference = new ConferenceCall(this.mIm2ConferenceDelegate, null, l);
    this.mConference.addUiDelegate(this);
    this.mConferenceInitializationListenersStore.notifyListeners(true, this.mConference);
    this.mConference.createConference(paramArrayOfString, this.mLastPeerCID, new IConferenceCall.CreateConferenceCallback()
    {
      public void onConferenceCreated(IConferenceCall.UiDelegate.CreationStatus paramAnonymousCreationStatus, final long paramAnonymousLong, String paramAnonymousString)
      {
        if (paramAnonymousCreationStatus != IConferenceCall.UiDelegate.CreationStatus.SUCCESS)
        {
          CallHandler.this.askToHangupConference();
          return;
        }
        CallHandler.this.mOneOnOneRtcCall.deinitCall();
        CallHandler.access$1102(CallHandler.this, null);
        CallHandler.this.mDialerController.handleSwitchedToConference(paramAnonymousLong);
        CallHandler.this.mViberRtcHandler.post(new Runnable()
        {
          public void run()
          {
            RTCConfCall localRTCConfCall = ViberRTCConfCall.create(CallHandler.this);
            CallHandler.this.mConference.setPeerConnection(localRTCConfCall);
            CallHandler.this.getCallInfo().switchToConference(CallHandler.8.this.val$peers, paramAnonymousLong, this.val$conferenceId, true);
            CallHandler.this.mConference.joinConference(paramAnonymousLong, new IConferenceCall.JoinConferenceCallback()
            {
              public void onJoinConference(boolean paramAnonymous3Boolean)
              {
                if (!paramAnonymous3Boolean);
                do
                {
                  return;
                  ViberApplication.getInstance().getRingtonePlayer().stopInCallTone();
                  CallHandler.this.mSwitchToConferenceListenersStore.notifyListeners();
                  if (CallHandler.this.getCurrentInCallState().isMuteEnabled())
                    CallHandler.this.mConference.mute();
                }
                while ((!CallHandler.this.getCurrentInCallState().isHoldEnabled()) || (!CallHandler.this.getCurrentInCallState().isHoldInitiator()));
                CallHandler.this.mConference.hold();
              }
            });
          }
        });
      }
    });
    return true;
  }

  public void handleUnmute()
  {
    if (this.mOneOnOneRtcCall != null)
      this.mOneOnOneRtcCall.unmute();
    if (this.mConference != null)
      this.mConference.unmute();
    this.mCallController.unmute();
    this.mDialerController.handleUnmute();
  }

  public void hideCallBack()
  {
  }

  public void hideReception()
  {
  }

  public boolean isLocalVideoAvailable()
  {
    return isLocalVideoCanBeAvailable();
  }

  public boolean isLocalVideoCanBeAvailable()
  {
    boolean bool1 = ((com.viber.common.permission.c)this.mPermissionManager.get()).a(new String[] { "android.permission.CAMERA" });
    boolean bool2 = q.a();
    if (!this.mViberApplication.getEngine(false).isReady())
      return bool2;
    return ((bool2) && (!bool1)) || (ViEVideoSupport.isVideoCallSupported());
  }

  public void localHold()
  {
    if (this.mOneOnOneRtcCall != null)
      this.mOneOnOneRtcCall.localHoldWithCompletion(createSdpNegotiationCallback("onLocalHold", new Runnable()
      {
        public void run()
        {
        }
      }));
    if (this.mConference != null)
      this.mConference.hold();
  }

  public void localUnhold()
  {
    if (this.mOneOnOneRtcCall != null)
      this.mOneOnOneRtcCall.localUnholdWithCompletion(createSdpNegotiationCallback("onLocalUnhold", new Runnable()
      {
        public void run()
        {
        }
      }));
    if (this.mConference != null)
      this.mConference.unhold();
  }

  public void mute()
  {
  }

  public void notifyCallInfoReadyListeners(CallInfo paramCallInfo)
  {
    Iterator localIterator = new HashSet(this.callInfoListeners).iterator();
    while (localIterator.hasNext())
      ((CallInfoReadyListener)localIterator.next()).onCallInfoReady(paramCallInfo);
  }

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    this.mLastPeerConferenceSupportStatus = false;
    if (this.mConference != null)
      handleHangupConference();
    if (this.mOneOnOneRtcCall != null)
    {
      this.mOneOnOneRtcCall.deinitCall();
      this.mOneOnOneRtcCall = null;
    }
    CallInfo localCallInfo = this.mCallController.getLastCallInfo();
    try
    {
      InCallState localInCallState = localCallInfo.getInCallState();
      CallStats localCallStats = localInCallState.getCallStats();
      long l = localCallStats.getCallDuration() / 1000L;
      localCallStats.getDataInterruptedMax();
      obtainAdsAfterCallFetcher().onCallStateChanged(8, localCallInfo);
      if ((l == 0L) && (localCallInfo.getType() == CallInfo.CallType.INCOMING) && (localInCallState.getEndReason() != 10));
      for (int i = 1; ; i = 0)
      {
        if ((localInCallState.getEndReason() != 14) && (localCallInfo.isViberOut()) && (l > 0L))
          l += 2L;
        if (i == 0)
          p.a(localInCallState.getCallToken(), localCallInfo, l, null);
        checkAndTrackContactDetailsCallSource(paramLong, localCallInfo);
        com.viber.voip.analytics.story.b.f localf = f.b.a(localCallInfo);
        ((com.viber.voip.analytics.story.b.a.c)ViberApplication.getInstance().getEndCallEventCollector().get()).a(localf, paramBoolean, paramInt1);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
    }
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.mOneOnOneRtcCall != null)
    {
      this.mOneOnOneRtcCall.startCall(paramInt);
      this.mOneOnOneRtcCall.getOffer(new BasicRTCCall.SdpCallback()
      {
        public void onError()
        {
        }

        public void ready(String paramAnonymousString)
        {
          CallHandler.this.mWebRtcDialerController.handleSendSdpOfferToHs(paramAnonymousString);
        }
      });
    }
  }

  public void onConferenceCreated(int paramInt, long paramLong, Map paramMap)
  {
    IConferenceCall.UiDelegate..CC.onConferenceCreated(this, paramInt, paramLong, paramMap);
  }

  public void onConferenceDialed()
  {
    if ((this.mCurrentDialingConferenceDetails == null) || (this.mConference == null))
      return;
    final JoiningConferenceData localJoiningConferenceData = this.mCurrentDialingConferenceDetails;
    this.mCurrentDialingConferenceDetails = null;
    this.mConference.joinConference(localJoiningConferenceData.callToken, new IConferenceCall.JoinConferenceCallback()
    {
      public void onJoinConference(boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          ((ConferenceCallsRepository)CallHandler.this.mViberApplication.getLazyConferenceCallsRepository().get()).makeConferenceWithCallTokenUnavailable(localJoiningConferenceData.callToken);
          CallHandler.this.handleHangup();
        }
      }
    });
  }

  public void onDisconnected()
  {
    handleHangup();
  }

  public void onFirstPeerJoined(ConferenceCall paramConferenceCall, String paramString)
  {
    CallInfo localCallInfo = this.mCallController.getCurrentCall();
    if (localCallInfo == null);
    InCallState localInCallState;
    do
    {
      return;
      localInCallState = localCallInfo.getInCallState();
    }
    while ((localInCallState == null) || (localInCallState.getState() == 3));
    this.mDialerController.handleCallStarted();
  }

  public void onHangup()
  {
    ViberApplication.getInstance().getRingtonePlayer().stopInCallTone();
  }

  public void onIceCandidateReceivedFromPeer(IceCandidate paramIceCandidate)
  {
    if (paramIceCandidate == null)
      throw new IllegalStateException("candidate");
    RTCCall localRTCCall = obtainOneOnOneCall();
    if (localRTCCall == null)
      return;
    localRTCCall.addPeerIceCandidate(paramIceCandidate);
  }

  public void onLastPeerLeft(ConferenceCall paramConferenceCall)
  {
  }

  public void onNewPeerConnectionNeeded()
  {
    this.mViberRtcHandler.post(new Runnable()
    {
      public void run()
      {
        RTCConfCall localRTCConfCall = ViberRTCConfCall.create(CallHandler.this);
        CallHandler.this.mConference.resetPeerConnection(localRTCConfCall);
      }
    });
  }

  public void onPeerCapabilities(int paramInt, boolean paramBoolean)
  {
    InCallState localInCallState = getCurrentInCallState();
    this.mLastPeerCID = paramInt;
    this.mLastPeerConferenceSupportStatus = paramBoolean;
    if (localInCallState != null)
      localInCallState.setConferenceSupported(paramBoolean);
  }

  public void onPeerTransferred(final ProcessedCallback paramProcessedCallback)
  {
    RTCCall localRTCCall = getRTCCall();
    if (localRTCCall == null)
    {
      paramProcessedCallback.onProcessed(false);
      return;
    }
    localRTCCall.finalizeTransfer(new BasicRTCCall.Completion()
    {
      public void onFailure()
      {
        paramProcessedCallback.onProcessed(false);
      }

      public void onSuccess()
      {
        paramProcessedCallback.onProcessed(true);
      }
    });
  }

  public int onPeerVideoEnded(int paramInt)
  {
    if (this.mOneOnOneRtcCall != null)
      this.mOneOnOneRtcCall.stopRecvVideo();
    return 0;
  }

  public int onPeerVideoStarted()
  {
    if (this.mOneOnOneRtcCall != null)
      this.mOneOnOneRtcCall.startRecvVideo(this.mContext);
    this.mDialerController.startRecvVideo();
    return 0;
  }

  public void onPeersChanged(Collection paramCollection)
  {
    IConferenceCall.UiDelegate..CC.onPeersChanged(this, paramCollection);
  }

  public void onPeersInvited(int paramInt, Map paramMap)
  {
    IConferenceCall.UiDelegate..CC.onPeersInvited(this, paramInt, paramMap);
  }

  public void onPhoneStateChanged(int paramInt)
  {
    executePendingTasksForPhoneState(paramInt);
    this.mViberApplication.getPhoneApp().updateWakeState(paramInt);
    CallInfo localCallInfo = getCallInfo();
    if ((localCallInfo == null) && (paramInt != 0))
      localCallInfo = getLastCallInfo();
    obtainAdsAfterCallFetcher().onCallStateChanged(paramInt, localCallInfo);
    if ((paramInt == 3) || (paramInt == 2))
      ((com.viber.voip.analytics.story.b.a.c)ViberApplication.getInstance().getEndCallEventCollector().get()).b();
  }

  public void onRemoteSdp(String paramString)
  {
    this.mWebRtcDialerController.handleSetRemoteSdp(paramString);
  }

  public void onSdpAnswerReceivedFromPeer(String paramString, int paramInt, final ProcessedCallback paramProcessedCallback)
  {
    RTCCall localRTCCall = obtainOneOnOneCall();
    if (localRTCCall == null)
      return;
    localRTCCall.applyPeerAnswer(paramString, paramInt, new BasicRTCCall.Completion()
    {
      public void onFailure()
      {
        paramProcessedCallback.onProcessed(false);
      }

      public void onSuccess()
      {
        paramProcessedCallback.onProcessed(true);
      }
    });
  }

  public void onSdpAnswerableOfferReceivedFromPeer(String paramString, int paramInt, final SdpProcessedCallback paramSdpProcessedCallback)
  {
    RTCCall localRTCCall = obtainOneOnOneCall();
    if (localRTCCall == null)
      return;
    localRTCCall.applySdpOffer(paramString, paramInt, new BasicRTCCall.SdpCallback()
    {
      public void onError()
      {
        paramSdpProcessedCallback.onProcessed("");
      }

      public void ready(String paramAnonymousString)
      {
        paramSdpProcessedCallback.onProcessed(paramAnonymousString);
      }
    });
  }

  public void onSdpOfferReceivedFromPeer(String paramString, int paramInt, boolean paramBoolean, final SdpProcessedCallback paramSdpProcessedCallback)
  {
    RTCCall localRTCCall = obtainOneOnOneCall();
    if (localRTCCall == null)
      return;
    localRTCCall.applyPeerOffer(paramString, paramInt, paramBoolean, new BasicRTCCall.SdpCallback()
    {
      public void onError()
      {
        paramSdpProcessedCallback.onProcessed("");
      }

      public void ready(String paramAnonymousString)
      {
        paramSdpProcessedCallback.onProcessed(paramAnonymousString);
      }
    });
  }

  public void onSelfVideoEnded(int paramInt)
  {
    if (this.mOneOnOneRtcCall == null);
    while ((paramInt == 8) || (paramInt == 7))
      return;
    this.mOneOnOneRtcCall.stopSendVideoWithCompletion(createSdpNegotiationCallback("stopSendVideoWithCompletion", new Runnable()
    {
      public void run()
      {
      }
    }));
  }

  public void onSelfVideoStarted()
  {
    if (this.mOneOnOneRtcCall == null)
      return;
    this.mOneOnOneRtcCall.startSendVideoWithCompletion(createSdpNegotiationCallback("startSendVideoWithCompletion", new Runnable()
    {
      public void run()
      {
      }
    }));
  }

  public void onSwitchToConferenceCall(final long paramLong, String paramString, Map<String, String> paramMap)
  {
    if ((this.mOneOnOneRtcCall == null) || (this.mConference != null))
      return;
    this.mOneOnOneRtcCall.deinitCall();
    this.mOneOnOneRtcCall = null;
    this.mDialerController.handleSwitchedToConference(paramLong);
    this.mLastConferenceId = paramString;
    RTCConfCall localRTCConfCall = ViberRTCConfCall.create(this);
    long l = ViberApplication.getInstance().getEngine(true).getPhoneController().getMyCID();
    this.mConference = new ConferenceCall(this.mIm2ConferenceDelegate, localRTCConfCall, l);
    this.mConference.addUiDelegate(this);
    this.mConferenceInitializationListenersStore.notifyListeners(true, this.mConference);
    this.mConference.joinConference(paramLong, new IConferenceCall.JoinConferenceCallback()
    {
      public void onJoinConference(boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          ((ConferenceCallsRepository)CallHandler.this.mViberApplication.getLazyConferenceCallsRepository().get()).makeConferenceWithCallTokenUnavailable(paramLong);
          CallHandler.this.handleHangup();
        }
        String[] arrayOfString;
        CallInfo localCallInfo;
        do
        {
          return;
          ViberApplication.getInstance().getRingtonePlayer().stopInCallTone();
          if (CallHandler.this.getCurrentInCallState().isMuteEnabled())
            CallHandler.this.mConference.mute();
          if ((CallHandler.this.getCurrentInCallState().isHoldEnabled()) && (CallHandler.this.getCurrentInCallState().isHoldInitiator()))
            CallHandler.this.mConference.hold();
          arrayOfString = new String[1];
          arrayOfString[0] = new af().l();
          localCallInfo = CallHandler.this.getCallInfo();
        }
        while (localCallInfo == null);
        localCallInfo.switchToConference(arrayOfString, paramLong, Long.toString(paramLong), false);
        CallHandler.this.mSwitchToConferenceListenersStore.notifyListeners();
      }
    });
  }

  public void onVideoCallEnded()
  {
  }

  public void onVideoCompatibility(boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public void onVolumeLevelChanged(Map paramMap, String paramString)
  {
    IConferenceCall.UiDelegate..CC.onVolumeLevelChanged(this, paramMap, paramString);
  }

  public void peerHold()
  {
    if (this.mOneOnOneRtcCall == null)
      return;
    this.mOneOnOneRtcCall.peerHoldWithCompletion(createSdpNegotiationCallback("peerHoldWithCompletion", new Runnable()
    {
      public void run()
      {
      }
    }));
  }

  public void peerUnhold()
  {
    if (this.mOneOnOneRtcCall == null)
      return;
    this.mOneOnOneRtcCall.peerUnholdWithCompletion(createSdpNegotiationCallback("peerUnholdWithCompletion", new Runnable()
    {
      public void run()
      {
      }
    }));
  }

  public void ready(PhoneController paramPhoneController)
  {
    this.mViberApplication.getSoundService().registerSpeakerStateListener(this.mCallController);
  }

  public boolean removeCallInfoReadyListener(CallInfoReadyListener paramCallInfoReadyListener)
  {
    return this.callInfoListeners.remove(paramCallInfoReadyListener);
  }

  public void sendIceCandidates(IceCandidate[] paramArrayOfIceCandidate)
  {
    this.mWebRtcDialerController.handleSendIceCandidates(paramArrayOfIceCandidate);
  }

  public void setContactDetailsAnalyticsCallInfo(ContactDetailsAnalyticsCallInfo paramContactDetailsAnalyticsCallInfo)
  {
    this.mContactDetailsAnalyticsCallInfo = paramContactDetailsAnalyticsCallInfo;
  }

  public void setNextCallIsFromSecretConversation(boolean paramBoolean)
  {
    this.mIsNextCallFromSecretConversation.set(paramBoolean);
  }

  public void showCallBack(int paramInt1, int paramInt2)
  {
  }

  public void showCallBlocked(int paramInt1, int paramInt2)
  {
  }

  public void showDialog(int paramInt, String paramString)
  {
  }

  public void showReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    if (this.mViberApplication.shouldBlockAllActivities())
    {
      handleHangup();
      return;
    }
    this.mLastConferenceId = paramString4;
    this.mCallReceptionHandler.showReception(paramString1, paramString2, paramBoolean, paramInt, paramString4, paramMap, paramString3, new CallReceptionHandler.OnCreateCallInfoCallback()
    {
      public void onShowReception(String paramAnonymousString1, String paramAnonymousString2, CallInfo.CallType paramAnonymousCallType, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3, boolean paramAnonymousBoolean4, com.viber.voip.model.a paramAnonymousa, boolean paramAnonymousBoolean5, String paramAnonymousString3, ConferenceInfo paramAnonymousConferenceInfo, String paramAnonymousString4)
      {
        String str1;
        if (TextUtils.isEmpty(paramAnonymousString1))
        {
          str1 = "private_number";
          if (!TextUtils.isEmpty(paramAnonymousString2))
            break label63;
        }
        label63: for (String str2 = str1; ; str2 = paramAnonymousString2)
        {
          CallHandler.this.createCallInfo(str1, str2, paramAnonymousCallType, paramAnonymousInt, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3, paramAnonymousBoolean4, paramAnonymousa, paramAnonymousString3, paramAnonymousConferenceInfo, -1L, paramAnonymousString4);
          return;
          str1 = paramAnonymousString1;
          break;
        }
      }
    });
  }

  public void startSendVideo()
  {
    if (this.mOneOnOneRtcCall == null)
      return;
    ViberApplication.getInstance().logToCrashlytics("Start send video");
    this.mOneOnOneRtcCall.startSendVideoWithCompletion(createSdpNegotiationCallback("startSendVideoWithCompletion", new Runnable()
    {
      public void run()
      {
        CallHandler.this.mDialerController.startSendVideo();
      }
    }));
  }

  public void stopSendVideo()
  {
    if (this.mOneOnOneRtcCall == null)
      return;
    this.mOneOnOneRtcCall.stopSendVideoWithCompletion(createSdpNegotiationCallback("stopSendVideoWithCompletion", new Runnable()
    {
      public void run()
      {
        CallHandler.this.mDialerController.stopSendVideo();
      }
    }));
  }

  public void submitNewPendingTaskForCallState(int paramInt, Runnable paramRunnable)
  {
    if (this.mCallController.getCurrentCall() == null)
      return;
    if ((this.mCallController.getCurrentCall() == null) || (paramInt == this.mCallController.getCurrentCall().getInCallState().getState()))
    {
      paramRunnable.run();
      return;
    }
    synchronized (this.pendingTasks)
    {
      Object localObject2 = (List)this.pendingTasks.get(Integer.valueOf(paramInt));
      if (localObject2 == null)
        localObject2 = new ArrayList();
      ((List)localObject2).add(paramRunnable);
      this.pendingTasks.put(Integer.valueOf(paramInt), localObject2);
      return;
    }
  }

  public void switchToGSM(final String paramString)
  {
    submitNewPendingTaskForCallState(0, new Runnable()
    {
      @SuppressLint({"MissingPermission"})
      public void run()
      {
        Intent localIntent = new Intent("android.intent.action.CALL", Uri.fromParts("tel", paramString, null));
        localIntent.setFlags(268435456);
        CallHandler.this.mContext.startActivity(localIntent);
      }
    });
  }

  public void unmute()
  {
  }

  public static abstract interface CallInfoReadyListener
  {
    public abstract void onCallInfoReady(CallInfo paramCallInfo);
  }

  public static class ContactDetailsAnalyticsCallInfo
  {
    private int mCallSource = 0;
    private Boolean mIsViberUser = null;

    public ContactDetailsAnalyticsCallInfo(boolean paramBoolean, int paramInt)
    {
      this.mIsViberUser = Boolean.valueOf(paramBoolean);
      this.mCallSource = paramInt;
    }

    public int callSource()
    {
      return this.mCallSource;
    }

    public ContactDetailsAnalyticsCallInfo copy()
    {
      return new ContactDetailsAnalyticsCallInfo(this.mIsViberUser.booleanValue(), this.mCallSource);
    }

    public Boolean isViberUser()
    {
      return this.mIsViberUser;
    }
  }

  private class JoiningConferenceData
  {
    public final long callToken;
    public final boolean isDialing;

    public JoiningConferenceData(boolean paramLong, long arg3)
    {
      this.isDialing = paramLong;
      Object localObject;
      this.callToken = localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallHandler
 * JD-Core Version:    0.6.2
 */