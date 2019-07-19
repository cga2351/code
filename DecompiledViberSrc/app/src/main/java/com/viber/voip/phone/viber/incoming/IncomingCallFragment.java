package com.viber.voip.phone.viber.incoming;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.c.a;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.array;
import com.viber.voip.R.drawable;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.CallFragmentManager;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.CallFragment;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.da;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.b;
import javax.inject.Inject;

public class IncomingCallFragment extends CallFragment
  implements View.OnKeyListener, PhoneViewHolder.Listener, TabletViewHolder.Listener
{
  private static final String ARG_ACCEPT_CALL = "accept_call";
  private static final String EXTRA_ACT_ON_INCOMING_CALL_WAS_TRACKED = "act_on_incoming_call_was_tracked";
  private static final String EXTRA_CALL_INITIATION_TIME = "call_initiation_time";
  private static final Logger L = ViberEnv.getLogger();

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.a> mActOnIncomingCallEventCollector;
  private boolean mActOnIncomingCallWasTracked;
  private CallFragmentManager mCallFragmentManager;
  private long mCallInitiationTime;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.c> mCallsTracker;
  private f mGroupFetcherConfig;
  private CallInfo mLastCallInfo;
  private final com.viber.common.permission.b mPermissionListener;

  @Inject
  com.viber.common.permission.c mPermissionManager;
  private ViewHolder mViewHolder;

  public IncomingCallFragment()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(31);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(51);
    this.mPermissionListener = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        CallInfo localCallInfo = IncomingCallFragment.this.getCallHandler().getCallInfo();
        if (localCallInfo == null)
          return;
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 31:
          IncomingCallFragment.this.acceptCall(localCallInfo, true);
          return;
        case 51:
        }
        IncomingCallFragment.this.acceptCall(localCallInfo, false);
      }
    };
  }

  private void acceptCall(CallInfo paramCallInfo, boolean paramBoolean)
  {
    paramCallInfo.getInCallState().setUserReaction(true);
    if (getActivity().getPackageManager().hasSystemFeature("android.hardware.microphone"))
    {
      if (paramCallInfo.isConference())
      {
        getCallHandler().handleAnswerAudioConference();
        return;
      }
      getCallHandler().handleAnswer(paramBoolean);
      return;
    }
    Toast.makeText(getActivity(), R.string.call_no_microphone, 0).show();
  }

  public static IncomingCallFragment createInstance(boolean paramBoolean)
  {
    IncomingCallFragment localIncomingCallFragment = new IncomingCallFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("accept_call", paramBoolean);
    localIncomingCallFragment.setArguments(localBundle);
    return localIncomingCallFragment;
  }

  private Dialog getSendMessageDialog()
  {
    return new c.a(getActivity()).c(R.array.quick_message_actions, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        CallInfo localCallInfo = IncomingCallFragment.this.getCallHandler().getCallInfo();
        if (localCallInfo != null)
          localCallInfo.getInCallState().setUserReaction(true);
        String[] arrayOfString = ViberApplication.getLocalizedResources().getStringArray(R.array.quick_message_actions);
        if (paramAnonymousInt == 4)
          IncomingCallFragment.this.handleDeclineWithMessage(null);
        while (true)
        {
          paramAnonymousDialogInterface.dismiss();
          return;
          IncomingCallFragment.this.handleDeclineWithMessage(arrayOfString[paramAnonymousInt]);
        }
      }
    }).a(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        CallInfo localCallInfo = IncomingCallFragment.this.getCallHandler().getCallInfo();
        if (localCallInfo != null)
          IncomingCallFragment.this.getRinger().playCallTone(localCallInfo);
        IncomingCallFragment.this.mViewHolder.updateCallControlsVisibility(true);
      }
    }).b();
  }

  private void handleArguments()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.getBoolean("accept_call", false)))
    {
      localBundle.remove("accept_call");
      onAcceptButtonClicked();
    }
  }

  private void handleDeclineWithMessage(String paramString)
  {
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    getDialerController().handleDecline();
    handleOpenConversation(localCallInfo, paramString);
  }

  private void rejectCall(CallInfo paramCallInfo)
  {
    paramCallInfo.getInCallState().setUserReaction(true);
    if (this.mCallFragmentManager != null)
      this.mCallFragmentManager.rejectCall();
    getDialerController().handleDecline();
  }

  private void startVideoCall(CallInfo paramCallInfo)
  {
    if (this.mPermissionManager.a(n.g))
    {
      acceptCall(paramCallInfo, true);
      return;
    }
    this.mPermissionManager.a(this, 31, n.g);
  }

  private void startVoiceCall(CallInfo paramCallInfo)
  {
    if (this.mPermissionManager.a(n.h))
    {
      acceptCall(paramCallInfo, false);
      return;
    }
    this.mPermissionManager.a(this, 51, n.h);
  }

  private void trackActOnIncomingCall(CallInfo paramCallInfo, String paramString)
  {
    if (this.mActOnIncomingCallWasTracked)
      return;
    long l = System.currentTimeMillis() - this.mCallInitiationTime;
    ((com.viber.voip.analytics.story.b.a.a)this.mActOnIncomingCallEventCollector.get()).a(paramCallInfo, paramString, l);
    this.mActOnIncomingCallWasTracked = true;
  }

  public void handleOpenConversation(CallInfo paramCallInfo, String paramString)
  {
    if (paramCallInfo != null)
    {
      if (da.a(paramString))
      {
        CallerInfo localCallerInfo = paramCallInfo.getCallerInfo();
        ViberActionRunner.a(getActivity(), localCallerInfo.getMemberId(), localCallerInfo.getPhoneNumber(), localCallerInfo.getName(), false);
      }
    }
    else
      return;
    String str1 = paramCallInfo.getCallerInfo().getMemberId();
    String str2 = paramCallInfo.getCallerInfo().getPhoneNumber();
    com.viber.voip.messages.m.a(new com.viber.voip.messages.controller.c.b(0L, str1, 0, 0).a(0, paramString, 0, null, 0), str2, null);
  }

  public void onAcceptButtonClicked()
  {
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if (localCallInfo == null);
    do
    {
      return;
      if (localCallInfo.isIncomingVideoCall())
      {
        startVideoCall(localCallInfo);
        trackActOnIncomingCall(localCallInfo, "Answer with Video");
        return;
      }
      startVoiceCall(localCallInfo);
      trackActOnIncomingCall(localCallInfo, "Answer");
    }
    while (!localCallInfo.isConference());
    ((com.viber.voip.analytics.story.b.c)this.mCallsTracker.get()).c("Incoming Call Screen");
  }

  public void onAcceptVideoButtonClicked()
  {
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if (localCallInfo == null)
      return;
    startVideoCall(localCallInfo);
    trackActOnIncomingCall(localCallInfo, "Answer with Video");
  }

  public void onAcceptVoiceButtonClicked()
  {
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if (localCallInfo == null);
    do
    {
      return;
      startVoiceCall(localCallInfo);
      trackActOnIncomingCall(localCallInfo, "Answer");
    }
    while (!localCallInfo.isConference());
    ((com.viber.voip.analytics.story.b.c)this.mCallsTracker.get()).c("Incoming Call Screen");
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity.setVolumeControlStream(2);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mLastCallInfo != null)
    {
      CallerInfo localCallerInfo = this.mLastCallInfo.getCallerInfo();
      this.mViewHolder.bindPhoto(this.mImageFetcher, this.mGroupFetcherConfig, localCallerInfo.getCallerPhoto(), localCallerInfo.getConferenceInfo());
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mGroupFetcherConfig = f.a(R.drawable.generic_image_sixty_x_sixty, f.b.b, false);
    if (paramBundle == null)
    {
      this.mCallInitiationTime = System.currentTimeMillis();
      this.mActOnIncomingCallWasTracked = false;
      return;
    }
    this.mCallInitiationTime = paramBundle.getLong("call_initiation_time");
    this.mActOnIncomingCallWasTracked = paramBundle.getBoolean("act_on_incoming_call_was_tracked");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool1 = true;
    View localView = paramLayoutInflater.inflate(R.layout.phone_incoming, paramViewGroup, false);
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    boolean bool2;
    boolean bool3;
    if ((localCallInfo != null) && (localCallInfo.isIncomingVideoCall()))
    {
      bool2 = bool1;
      if ((localCallInfo == null) || (!localCallInfo.isConference()))
        break label116;
      bool3 = bool1;
      label57: if ((localCallInfo == null) || (!localCallInfo.isViberIn()))
        break label122;
      label70: if (localCallInfo == null)
        break label128;
    }
    label128: for (String str = localCallInfo.getToNumber(); ; str = null)
    {
      if (!this.mIsTablet)
        break label134;
      this.mViewHolder = new TabletViewHolder(localView, this, bool2, str);
      return localView;
      bool2 = false;
      break;
      label116: bool3 = false;
      break label57;
      label122: bool1 = false;
      break label70;
    }
    label134: this.mViewHolder = new PhoneViewHolder(localView, this, bool2, bool3, bool1, str);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.mLastCallInfo == null);
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    }
    while ((localFragmentActivity == null) || (!localFragmentActivity.isFinishing()));
    trackActOnIncomingCall(this.mLastCallInfo, "None");
  }

  public void onDestroyView()
  {
    getView().setOnKeyListener(null);
    super.onDestroyView();
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && ((24 == paramKeyEvent.getKeyCode()) || (25 == paramKeyEvent.getKeyCode())))
      getRinger().stopCallTone();
    do
    {
      return true;
      switch (paramInt)
      {
      default:
        return false;
      case 5:
      }
    }
    while (paramKeyEvent.getAction() != 0);
    onAcceptButtonClicked();
    return true;
  }

  public void onMessageButtonClicked()
  {
    getRinger().stopCallTone();
    this.mViewHolder.updateCallControlsVisibility(false);
    getSendMessageDialog().show();
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if (localCallInfo != null)
      trackActOnIncomingCall(localCallInfo, "Send Message");
  }

  public void onPause()
  {
    super.onPause();
    this.mViewHolder.pauseCallStatusAnimation();
  }

  public void onRejectButtonClicked()
  {
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if (localCallInfo == null)
      return;
    rejectCall(localCallInfo);
    trackActOnIncomingCall(localCallInfo, "Ignore");
  }

  public void onResume()
  {
    super.onResume();
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if ((localCallInfo != null) && (this.mLastCallInfo != localCallInfo))
    {
      this.mLastCallInfo = localCallInfo;
      CallerInfo localCallerInfo = localCallInfo.getCallerInfo();
      this.mViewHolder.bindPhoto(this.mImageFetcher, this.mGroupFetcherConfig, localCallerInfo.getCallerPhoto(), localCallerInfo.getConferenceInfo());
      this.mViewHolder.bindName(localCallerInfo.getIncomingCallDisplayName());
      com.viber.voip.model.a locala = localCallerInfo.getContact();
      if ((this.mLastCallInfo.isConference()) || ((locala != null) && (locala.getId() > 0L)))
        this.mViewHolder.updateNotInContactListVisibility(false);
      this.mViewHolder.resumeCallStatusAnimation();
    }
    getView().setFocusableInTouchMode(true);
    getView().setFocusable(true);
    getView().setOnKeyListener(this);
    getView().requestFocus();
    handleArguments();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("call_initiation_time", this.mCallInitiationTime);
    paramBundle.putBoolean("act_on_incoming_call_was_tracked", this.mActOnIncomingCallWasTracked);
  }

  public void onStart()
  {
    super.onStart();
    this.mPermissionManager.a(this.mPermissionListener);
  }

  public void onStop()
  {
    this.mPermissionManager.b(this.mPermissionListener);
    super.onStop();
  }

  public void setCallFragmentManager(CallFragmentManager paramCallFragmentManager)
  {
    this.mCallFragmentManager = paramCallFragmentManager;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incoming.IncomingCallFragment
 * JD-Core Version:    0.6.2
 */