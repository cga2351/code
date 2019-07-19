package com.viber.voip.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.permission.b;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerOutgoingScreen;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerVideo;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.jni.dialer.DialerOutgoingScreenListener;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.jni.dialer.DialerVideoListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ac;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.i.c.b;
import com.viber.voip.messages.conversation.ui.ba;
import com.viber.voip.messages.ui.CallerContainer;
import com.viber.voip.messages.ui.cy.a;
import com.viber.voip.p.e;
import com.viber.voip.p.e.a;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.CallType;
import com.viber.voip.phone.call.CallInfo.VideoState;
import com.viber.voip.phone.call.CallStats;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore;
import com.viber.voip.phone.call.listeners.SwitchToConferenceListenersStore.Listener;
import com.viber.voip.phone.viber.InCallFragment;
import com.viber.voip.phone.viber.InCallFragment.Callbacks;
import com.viber.voip.phone.viber.UiDisplayedDuringCallAnalyticManager;
import com.viber.voip.phone.viber.VideoCallCallbacks;
import com.viber.voip.phone.viber.VideoCallFragment;
import com.viber.voip.phone.viber.endcall.EndCallFragment;
import com.viber.voip.phone.viber.incoming.IncomingCallFragment;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ag;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.dj;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class CallFragmentManager
  implements DialerControllerDelegate.DialerLocalCallState, DialerControllerDelegate.DialerOutgoingScreen, DialerControllerDelegate.DialerPhoneState, DialerControllerDelegate.DialerVideo, SwitchToConferenceListenersStore.Listener, InCallFragment.Callbacks, VideoCallCallbacks
{
  public static final long IN_ENDING_CALL_STATE_DURATION_MILLIS = 2500L;
  private static final Logger L = ViberEnv.getLogger();
  private boolean mAcceptIncomingCall;
  private WeakReference<FragmentActivity> mActivity;
  private final boolean mAllowFinish;
  private CallHandler mCallHandler;
  private EngineDelegatesManager mDelegatesManager;
  private final Runnable mEndCallWithPromotionAction = new CallFragmentManager..Lambda.1(this);
  private WeakReference<Fragment> mFragment;
  private final boolean mIsPortrait;
  private volatile boolean mIsProximityNearDistance;
  private boolean mIsTablet;
  private final cy.a mOnCallerContainerVisibilityCallback;
  private final b mPermissionListener;
  private final com.viber.common.permission.c mPermissionManager;
  private boolean mPermissionRequested;
  private final com.viber.voip.p.c mProximityHelper;
  private final e.a mProximityListener = new e.a()
  {
    public void onProximityChanged(boolean paramAnonymousBoolean)
    {
      if (CallFragmentManager.this.mIsProximityNearDistance != paramAnonymousBoolean)
      {
        CallFragmentManager.access$002(CallFragmentManager.this, paramAnonymousBoolean);
        Fragment localFragment = CallFragmentManager.this.getFragment();
        if ((!paramAnonymousBoolean) && ((localFragment instanceof EndCallFragment)) && (localFragment.isAdded()))
          av.a(av.e.a).post(CallFragmentManager.this.mResumeAdsAfterCallAction);
        if (((localFragment instanceof InCallFragment)) && (localFragment.isAdded()))
          av.a(av.e.a).post(new CallFragmentManager.1..Lambda.0(this, paramAnonymousBoolean));
      }
    }
  };
  private final Runnable mResumeAdsAfterCallAction = new CallFragmentManager..Lambda.0(this);
  private WeakReference<ba> mSlidingMenuIgnoreViewCallback;
  private final UiDisplayedDuringCallAnalyticManager mUiDisplayedDuringCallAnalyticManager;
  private final int mViewId;

  public CallFragmentManager(FragmentActivity paramFragmentActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(28);
    arrayOfPair[bool] = com.viber.voip.permissions.m.a(35);
    this.mPermissionListener = new f(null, arrayOfPair)
    {
      protected Context getContext()
      {
        Fragment localFragment = CallFragmentManager.this.getFragment();
        if (localFragment != null)
          return localFragment.getContext();
        return null;
      }

      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        if ((DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)) || ((DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) && (paramAnonymousInt2 != -1)))
          CallFragmentManager.access$502(CallFragmentManager.this, false);
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 28:
        case 35:
        }
        while (true)
        {
          CallFragmentManager.access$502(CallFragmentManager.this, false);
          return;
          CallFragmentManager.this.startVideoCall(true);
          continue;
          CallFragmentManager.this.startVideoCall(false);
        }
      }
    };
    this.mOnCallerContainerVisibilityCallback = new cy.a()
    {
      public void onVisibilityChanged(int paramAnonymousInt)
      {
        View localView = CallFragmentManager.this.container();
        if ((localView instanceof CallerContainer))
        {
          ((CallerContainer)localView).b(CallFragmentManager.this.mOnCallerContainerVisibilityCallback);
          if (localView.getVisibility() != 0)
            CallFragmentManager.this.removeCallFragments();
        }
      }
    };
    this.mActivity = new WeakReference(paramFragmentActivity);
    this.mViewId = paramInt;
    this.mAllowFinish = paramBoolean1;
    this.mIsTablet = paramBoolean2;
    if (!dj.c(paramFragmentActivity));
    while (true)
    {
      this.mIsPortrait = bool;
      Engine localEngine = ViberApplication.getInstance().getEngine(false);
      this.mDelegatesManager = localEngine.getDelegatesManager();
      this.mCallHandler = localEngine.getCallHandler();
      this.mProximityHelper = new e(paramFragmentActivity, this.mProximityListener);
      this.mPermissionManager = com.viber.common.permission.c.a(paramFragmentActivity);
      this.mUiDisplayedDuringCallAnalyticManager = new UiDisplayedDuringCallAnalyticManager(localEngine.getCdrController(), c.b.f);
      keepCallContainerOnTop();
      return;
      bool = false;
    }
  }

  private void cancelEndCall()
  {
    av.e.a.a().removeCallbacks(this.mEndCallWithPromotionAction);
  }

  private View container()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (this.mViewId > 0))
      return localFragmentActivity.findViewById(this.mViewId);
    return null;
  }

  private void continueTabletCallMode()
  {
    FragmentActivity localFragmentActivity = getActivity();
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if ((localFragmentActivity != null) && (localCallInfo != null) && (localCallInfo.getCallerInfo() != null))
    {
      if (!localCallInfo.isVln())
        break label49;
      ViberActionRunner.b(localFragmentActivity, ViberActionRunner.ab.a(localFragmentActivity));
    }
    while (true)
    {
      finish();
      return;
      label49: open1to1(localCallInfo);
    }
  }

  public static String currentTabletConversationCallerMemberId(boolean paramBoolean)
  {
    if (!paramBoolean);
    CallerInfo localCallerInfo;
    do
    {
      CallInfo localCallInfo;
      do
      {
        return null;
        localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
      }
      while ((localCallInfo == null) || (localCallInfo.isConference()) || ((!localCallInfo.isCallInProgress()) && (!localCallInfo.isCallInRingback())));
      localCallerInfo = localCallInfo.getCallerInfo();
    }
    while (localCallerInfo == null);
    return localCallerInfo.getMemberId();
  }

  private Fragment findFragment(FragmentType paramFragmentType)
  {
    Object localObject = null;
    FragmentActivity localFragmentActivity = getActivity();
    Fragment localFragment;
    if (localFragmentActivity != null)
    {
      localFragment = localFragmentActivity.getSupportFragmentManager().findFragmentByTag(paramFragmentType.tag());
      if ((localFragment == null) || (localFragment.getId() == this.mViewId))
        break label64;
      removeFragment(paramFragmentType);
    }
    while (true)
    {
      if (localObject == null)
        localObject = paramFragmentType.instantiate(this);
      return localObject;
      localFragment = null;
      break;
      label64: localObject = localFragment;
    }
  }

  private void finish()
  {
    cancelEndCall();
    this.mCallHandler.getSwitchToConferenceListenersStore().unregisterListener(this);
    if (this.mProximityHelper.a())
      this.mProximityHelper.c();
    if (this.mAllowFinish)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (isForegroundScene()))
        localFragmentActivity.finish();
    }
    while (true)
    {
      setFragment(null);
      return;
      updateContainerVisibility(8, null);
    }
  }

  private FragmentActivity getActivity()
  {
    if (this.mActivity != null)
      return (FragmentActivity)this.mActivity.get();
    return null;
  }

  private String getCallerName()
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if (localCallInfo != null)
      return localCallInfo.getCallerInfo().getNameOrPhoneNumber();
    return "";
  }

  private Fragment getFragment()
  {
    if (this.mFragment != null)
      return (Fragment)this.mFragment.get();
    return null;
  }

  private boolean isForegroundScene()
  {
    return getActivity() instanceof PhoneFragmentActivity;
  }

  private boolean isIncoming(CallInfo paramCallInfo)
  {
    return (CallInfo.CallType.INCOMING == paramCallInfo.getType()) && (!paramCallInfo.isCallInRingback()) && (!paramCallInfo.isCallInProgress()) && (!paramCallInfo.isCallAnswering()) && (!paramCallInfo.getInCallState().isCallEnded());
  }

  private void keepCallContainerOnTop()
  {
    if ((!this.mIsTablet) || (!this.mIsPortrait));
    View localView;
    do
    {
      return;
      localView = container();
    }
    while ((localView == null) || (!(localView.getParent() instanceof ViewGroup)));
    ((ViewGroup)localView.getParent()).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
    {
      public void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
      {
        if (!(paramAnonymousView2 instanceof CallerContainer))
        {
          View localView = CallFragmentManager.this.container();
          if ((localView != null) && (localView.getVisibility() == 0))
            localView.bringToFront();
        }
      }

      public void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2)
      {
      }
    });
  }

  private void makeCallContainerInvisible()
  {
    View localView = container();
    if ((this.mIsTablet) && ((localView instanceof CallerContainer)))
      ((CallerContainer)localView).a(this.mOnCallerContainerVisibilityCallback);
    dj.b(localView, false);
  }

  private void makeCallContainerVisible(FragmentType paramFragmentType)
  {
    View localView = container();
    if ((this.mIsTablet) && ((FragmentType.INCALL == paramFragmentType) || (FragmentType.VIDEO_CALL == paramFragmentType)) && ((localView instanceof CallerContainer)))
      dj.b(localView, true);
  }

  private void onCallUiGone()
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if (localCallInfo != null)
    {
      long l = localCallInfo.getInCallState().getCallStats().getCallDuration();
      this.mUiDisplayedDuringCallAnalyticManager.onCallUiGone(TimeUnit.MILLISECONDS.toSeconds(l));
    }
  }

  private void onCallUiVisible()
  {
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if (localCallInfo != null)
    {
      long l1 = this.mCallHandler.getCurrentCallToken();
      long l2 = localCallInfo.getInCallState().getCallStats().getCallDuration();
      this.mUiDisplayedDuringCallAnalyticManager.onCallUiVisible(l1, TimeUnit.MILLISECONDS.toSeconds(l2), localCallInfo.isViberOut(), localCallInfo.isConference());
    }
  }

  private void open1to1(CallInfo paramCallInfo)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramCallInfo.getCallerInfo().getMemberId(), paramCallInfo.getCallerInfo().getPhoneNumber(), "", false, false, false, false);
    ViberActionRunner.c(getActivity(), localIntent);
  }

  private void postEndCallAction(CallInfo paramCallInfo, long paramLong)
  {
    if ((!paramCallInfo.needShowAds()) && (!paramCallInfo.getInCallState().isDestinationBlocked()))
      av.e.a.a().postDelayed(this.mEndCallWithPromotionAction, paramLong);
  }

  public static String recentTabletConversationCallerMemberId(boolean paramBoolean)
  {
    if (!paramBoolean);
    CallerInfo localCallerInfo1;
    do
    {
      CallInfo localCallInfo2;
      do
      {
        Engine localEngine;
        CallerInfo localCallerInfo2;
        do
        {
          return null;
          localEngine = ViberApplication.getInstance().getEngine(false);
          CallInfo localCallInfo1 = localEngine.getCurrentCall();
          if ((localCallInfo1 == null) || (localCallInfo1.isConference()) || ((!localCallInfo1.isCallInProgress()) && (!localCallInfo1.isCallInRingback())))
            break;
          localCallerInfo2 = localCallInfo1.getCallerInfo();
        }
        while (localCallerInfo2 == null);
        return localCallerInfo2.getMemberId();
        localCallInfo2 = localEngine.getCallHandler().getLastCallInfo();
      }
      while ((localCallInfo2 == null) || (localCallInfo2.isConference()) || (localCallInfo2.getInCallState() == null) || (localCallInfo2.getInCallState().getEndTime() < 0L) || (System.currentTimeMillis() - localCallInfo2.getInCallState().getEndTime() > 2500L));
      localCallerInfo1 = localCallInfo2.getCallerInfo();
    }
    while (localCallerInfo1 == null);
    return localCallerInfo1.getMemberId();
  }

  private void registerDelegates()
  {
    Handler localHandler = av.e.a.a();
    this.mDelegatesManager.getDialerLocalCallStateListener().registerDelegateQueue(this.mCallHandler, localHandler, new VideoCallCallbacks[] { this });
    this.mDelegatesManager.getDialerPhoneStateListener().registerDelegateQueue(this.mCallHandler, localHandler, new DialerControllerDelegate.DialerPhoneState[] { this });
    this.mDelegatesManager.getDialerOutgoingScreenListener().registerDelegate(this, localHandler);
    registerVideoDelegates();
    this.mCallHandler.getSwitchToConferenceListenersStore().registerListener(this);
  }

  private void registerVideoDelegates()
  {
    Handler localHandler = av.e.a.a();
    this.mDelegatesManager.getDialerVideoListener().registerDelegateQueue(this.mCallHandler, localHandler, new DialerControllerDelegate.DialerVideo[] { this });
  }

  private void removeCallFragments()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      FragmentManager localFragmentManager = localFragmentActivity.getSupportFragmentManager();
      FragmentType[] arrayOfFragmentType = FragmentType.values();
      int i = arrayOfFragmentType.length;
      for (int j = 0; j < i; j++)
      {
        Fragment localFragment = localFragmentManager.findFragmentByTag(arrayOfFragmentType[j].tag());
        if (localFragment != null)
          localFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
      }
    }
  }

  private void removeFragment(FragmentType paramFragmentType)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      FragmentManager localFragmentManager = localFragmentActivity.getSupportFragmentManager();
      Fragment localFragment = localFragmentManager.findFragmentByTag(paramFragmentType.tag());
      if (localFragment != null)
        localFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
  }

  private boolean runEndCall()
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if ((localCallInfo != null) && (localCallInfo.isEndCallStarted()))
    {
      if ((getFragment() instanceof EndCallFragment))
      {
        cancelEndCall();
        postEndCallAction(localCallInfo, TimeUnit.SECONDS.toMillis(1L));
      }
      return false;
    }
    cancelEndCall();
    boolean bool = showFragment(FragmentType.END_CALL);
    if ((bool) && (localCallInfo != null))
      if (!localCallInfo.getInCallState().isFailed())
        break label101;
    label101: for (long l = 5000L; ; l = 1800L)
    {
      postEndCallAction(localCallInfo, l);
      if ((bool) && (localCallInfo != null))
        localCallInfo.markEndCallAsStarted();
      return bool;
    }
  }

  private void setFragment(Fragment paramFragment)
  {
    this.mFragment = new WeakReference(paramFragment);
  }

  private boolean shouldRunEndCall(CallInfo paramCallInfo)
  {
    if (paramCallInfo == null);
    InCallState localInCallState;
    int i;
    do
    {
      return false;
      localInCallState = paramCallInfo.getInCallState();
      i = localInCallState.getEndReason();
    }
    while (((localInCallState.getCallStats().getCallDuration() == 0L) && (CallInfo.CallType.INCOMING == paramCallInfo.getType())) || (11 == i) || (10 == i));
    return true;
  }

  private void showCallScreen(CallInfo paramCallInfo)
  {
    if (paramCallInfo == null)
      return;
    if (isIncoming(paramCallInfo))
    {
      showFragment(FragmentType.INCOMING);
      return;
    }
    if (paramCallInfo.getInCallState().isCallEnded())
    {
      runEndCall();
      return;
    }
    if ((paramCallInfo.getVideoState() == CallInfo.VideoState.MIN) || (paramCallInfo.getVideoState() == CallInfo.VideoState.MAX) || ((paramCallInfo.isOutgoing()) && (paramCallInfo.isOutgoingVideoCall())) || (paramCallInfo.getInCallState().isRemoteVideoStarted()))
    {
      startVideoCallSafe(false);
      return;
    }
    showFragment(FragmentType.INCALL);
  }

  private boolean showFragment(FragmentType paramFragmentType)
  {
    Fragment localFragment1 = getFragment();
    if ((localFragment1 instanceof InCallFragment))
    {
      ((InCallFragment)localFragment1).setOnVideoClickListener(null);
      onCallUiGone();
    }
    if ((localFragment1 instanceof VideoCallFragment))
    {
      VideoCallFragment localVideoCallFragment2 = (VideoCallFragment)localFragment1;
      localVideoCallFragment2.setVideoCallCallbacks(null);
      localVideoCallFragment2.setSlidingMenuIgnoreViewCallback(null);
    }
    if ((FragmentType.INCOMING == paramFragmentType) && (!this.mAllowFinish))
      return false;
    if ((FragmentType.INCOMING != paramFragmentType) && (this.mAllowFinish) && (this.mIsTablet))
    {
      continueTabletCallMode();
      return false;
    }
    FragmentActivity localFragmentActivity = getActivity();
    FragmentTransaction localFragmentTransaction;
    if ((localFragmentActivity != null) && (this.mViewId > 0))
    {
      Fragment localFragment2 = findFragment(paramFragmentType);
      if (localFragment2 != null)
      {
        setFragment(localFragment2);
        if (!localFragment2.isAdded())
        {
          if ((paramFragmentType == FragmentType.INCALL) && (this.mProximityHelper.a()))
            this.mProximityHelper.b();
          localFragmentTransaction = localFragmentActivity.getSupportFragmentManager().beginTransaction();
          localFragmentTransaction.replace(this.mViewId, localFragment2, paramFragmentType.tag());
          if (localFragmentActivity.isFinishing())
            break label287;
        }
      }
    }
    try
    {
      localFragmentTransaction.commitAllowingStateLoss();
      label200: updateContainerVisibility(0, paramFragmentType);
      Fragment localFragment3 = getFragment();
      if ((localFragment3 instanceof InCallFragment))
      {
        ((InCallFragment)localFragment3).setOnVideoClickListener(this);
        onCallUiVisible();
      }
      if ((localFragment3 instanceof VideoCallFragment))
      {
        VideoCallFragment localVideoCallFragment1 = (VideoCallFragment)localFragment3;
        localVideoCallFragment1.setVideoCallCallbacks(this);
        if (this.mSlidingMenuIgnoreViewCallback != null)
        {
          ba localba = (ba)this.mSlidingMenuIgnoreViewCallback.get();
          if (localba != null)
            localVideoCallFragment1.setSlidingMenuIgnoreViewCallback(localba);
        }
      }
      return true;
      label287: return false;
      return false;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label200;
    }
  }

  private void startVideoCallSafe(boolean paramBoolean)
  {
    if ((this.mPermissionManager.a(n.g)) || (!paramBoolean))
      startVideoCall(paramBoolean);
    Fragment localFragment;
    do
    {
      do
        return;
      while (this.mPermissionRequested);
      localFragment = getFragment();
    }
    while (localFragment == null);
    this.mPermissionManager.a(localFragment, 28, n.g);
    this.mPermissionRequested = true;
  }

  private void unregisterDelegates()
  {
    this.mDelegatesManager.getDialerLocalCallStateListener().removeDelegate(this);
    this.mDelegatesManager.getDialerPhoneStateListener().removeDelegate(this);
    this.mDelegatesManager.getDialerOutgoingScreenListener().removeDelegate(this);
    unregisterVideoDelegates();
  }

  private void unregisterVideoDelegates()
  {
    this.mDelegatesManager.getDialerVideoListener().removeDelegate(this);
  }

  private void updateContainerVisibility(int paramInt, FragmentType paramFragmentType)
  {
    View localView = container();
    if ((localView != null) && (paramInt != localView.getVisibility()))
    {
      if (paramInt == 0)
      {
        localView.setVisibility(paramInt);
        localView.bringToFront();
        makeCallContainerVisible(paramFragmentType);
      }
    }
    else
      return;
    makeCallContainerInvisible();
  }

  public boolean canGoBack(FragmentActivity paramFragmentActivity)
  {
    if (canVideoGoBack())
      return true;
    Fragment localFragment = getFragment();
    if (((localFragment instanceof InCallFragment)) && (((InCallFragment)localFragment).canGoBack()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean canVideoGoBack()
  {
    if ((getFragment() instanceof VideoCallFragment))
    {
      onVideoClosed();
      return true;
    }
    return false;
  }

  public void endCall()
  {
    this.mEndCallWithPromotionAction.run();
  }

  public void hideCall(String paramString, boolean paramBoolean)
  {
  }

  public boolean isReadyToShowAd()
  {
    return !this.mIsProximityNearDistance;
  }

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    if (!shouldRunEndCall(this.mCallHandler.getLastCallInfo()))
    {
      finish();
      return;
    }
    runEndCall();
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    registerVideoDelegates();
  }

  public void onDestroy(FragmentActivity paramFragmentActivity)
  {
    finish();
  }

  public void onHangup()
  {
  }

  public void onPause(FragmentActivity paramFragmentActivity)
  {
    unregisterDelegates();
    cancelEndCall();
    Fragment localFragment = getFragment();
    if ((localFragment instanceof InCallFragment))
    {
      ((InCallFragment)localFragment).setOnVideoClickListener(null);
      onCallUiGone();
    }
    if ((localFragment instanceof VideoCallFragment))
      ((VideoCallFragment)localFragment).setVideoCallCallbacks(null);
    if (((Context)this.mActivity.get() != null) && (this.mIsTablet) && (ac.a != 0))
      updateContainerVisibility(8, FragmentType.INCALL);
    MinimizedCallManager.getInstance().setCallStarted(false);
  }

  public int onPeerVideoEnded(int paramInt)
  {
    return 0;
  }

  public int onPeerVideoStarted()
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if ((localCallInfo != null) && (localCallInfo.isRemoteVideoAvailable()))
      startVideoCallSafe(false);
    return 0;
  }

  public void onPhoneStateChanged(int paramInt)
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if (localCallInfo == null);
    do
    {
      return;
      switch (paramInt)
      {
      default:
        return;
      case 2:
      case 3:
      }
    }
    while (localCallInfo.isOutgoingVideoCall());
    cancelEndCall();
    showFragment(FragmentType.INCALL);
  }

  public void onResume(FragmentActivity paramFragmentActivity)
  {
    registerDelegates();
    MinimizedCallManager.getInstance().setCallStarted(true);
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getInCallState().isCallEnded()))
      finish();
    while (true)
    {
      Fragment localFragment = getFragment();
      if ((localFragment instanceof InCallFragment))
      {
        ((InCallFragment)localFragment).setOnVideoClickListener(this);
        onCallUiVisible();
      }
      if ((localFragment instanceof VideoCallFragment))
        ((VideoCallFragment)localFragment).setVideoCallCallbacks(this);
      return;
      showCallScreen(localCallInfo);
    }
  }

  public void onSelfVideoEnded(int paramInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (paramInt == 0)
    {
      localCallInfo = this.mCallHandler.getLastCallInfo();
      if ((localFragmentActivity != null) && (localCallInfo != null) && (!localCallInfo.isRemoteVideoAvailable()))
      {
        locala = ag.a();
        arrayOfObject = new Object[1];
        arrayOfObject[0] = getCallerName();
        locala.b(-1, arrayOfObject).a(localFragmentActivity);
      }
    }
    while ((6 != paramInt) || (localFragmentActivity == null))
    {
      CallInfo localCallInfo;
      h.a locala;
      Object[] arrayOfObject;
      return;
    }
    ag.c().a(localFragmentActivity);
  }

  public void onSelfVideoStarted()
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if ((localCallInfo != null) && (localCallInfo.isLocalVideoAvailable()) && (this.mCallHandler.isLocalVideoAvailable()))
      startVideoCallSafe(true);
  }

  public void onStart(FragmentActivity paramFragmentActivity)
  {
    if (!this.mPermissionManager.c(this.mPermissionListener))
      this.mPermissionManager.a(this.mPermissionListener);
  }

  public void onStop(FragmentActivity paramFragmentActivity)
  {
    if (this.mPermissionManager.c(this.mPermissionListener))
      this.mPermissionManager.b(this.mPermissionListener);
  }

  public void onSwitchToConference()
  {
    av.e.a.a().post(new CallFragmentManager..Lambda.2(this));
  }

  public void onVideoButtonClicked()
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if (localCallInfo == null);
    while ((!localCallInfo.isLocalVideoAvailable()) || (!this.mCallHandler.isLocalVideoAvailable()))
      return;
    startVideoCallSafe(true);
  }

  public void onVideoCallEnded()
  {
  }

  public void onVideoClosed()
  {
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if ((localCallInfo != null) && (!localCallInfo.isCallEnding()) && (!(getFragment() instanceof InCallFragment)))
      showFragment(FragmentType.INCALL);
  }

  public void onVideoCompatibility(boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public void rejectCall()
  {
    finish();
  }

  public void setAcceptIncomingCall(boolean paramBoolean)
  {
    this.mAcceptIncomingCall = paramBoolean;
  }

  public void setSlidingMenuIgnoreViewCallback(ba paramba)
  {
    this.mSlidingMenuIgnoreViewCallback = new WeakReference(paramba);
  }

  public void showCall(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    showFragment(FragmentType.INCALL);
  }

  void startVideoCall(boolean paramBoolean)
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if ((localCallInfo == null) || (localCallInfo.isConference()));
    FragmentActivity localFragmentActivity;
    do
    {
      do
      {
        return;
        if (paramBoolean)
          this.mCallHandler.startSendVideo();
        if ((ViberApplication.isTablet(getActivity())) && (this.mCallHandler.getLastCallInfo().getVideoState() != CallInfo.VideoState.MIN))
          break;
      }
      while ((getFragment() instanceof VideoCallFragment));
      showFragment(FragmentType.VIDEO_CALL);
      return;
      localFragmentActivity = getActivity();
    }
    while (localFragmentActivity == null);
    localFragmentActivity.startActivity(new Intent(localFragmentActivity, TabletVideoCallActivity.class));
  }

  public static abstract interface CallFragmentManagerCallback
  {
    public abstract void endCall();

    public abstract boolean isReadyToShowAd();
  }

  private static enum FragmentType
  {
    private final String mTag;

    static
    {
      INCALL = new FragmentType("INCALL", 1, "incall_call");
      END_CALL = new FragmentType("END_CALL", 2, "end_call_call");
      VIDEO_CALL = new FragmentType("VIDEO_CALL", 3, "video_call");
      FragmentType[] arrayOfFragmentType = new FragmentType[4];
      arrayOfFragmentType[0] = INCOMING;
      arrayOfFragmentType[1] = INCALL;
      arrayOfFragmentType[2] = END_CALL;
      arrayOfFragmentType[3] = VIDEO_CALL;
    }

    private FragmentType(String paramString)
    {
      this.mTag = paramString;
    }

    public Fragment instantiate(CallFragmentManager paramCallFragmentManager)
    {
      if (INCOMING == this)
      {
        IncomingCallFragment localIncomingCallFragment = IncomingCallFragment.createInstance(paramCallFragmentManager.mAcceptIncomingCall);
        localIncomingCallFragment.setCallFragmentManager(paramCallFragmentManager);
        return localIncomingCallFragment;
      }
      if (INCALL == this)
        return new InCallFragment();
      if (END_CALL == this)
        return new EndCallFragment();
      if (VIDEO_CALL == this)
        return new VideoCallFragment();
      return null;
    }

    public String tag()
    {
      return this.mTag;
    }
  }

  private static abstract interface Timers
  {
    public static final int CLOSE_ON_CALL_ENDED_TIMER = 1800;
    public static final int CLOSE_ON_CALL_FAILED_TIMER = 5000;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.CallFragmentManager
 * JD-Core Version:    0.6.2
 */