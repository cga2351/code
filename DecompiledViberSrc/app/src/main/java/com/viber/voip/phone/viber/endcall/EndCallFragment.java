package com.viber.voip.phone.viber.endcall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.color;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.d.i;
import com.viber.voip.ads.d.j;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.analytics.story.o;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.banner.a.a.d;
import com.viber.voip.banner.a.a.f;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.phone.CallFragmentManager.CallFragmentManagerCallback;
import com.viber.voip.phone.PhoneFragmentActivity;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.AdsCallViewHolder;
import com.viber.voip.phone.viber.CallFragment;
import com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper;
import com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper.Listener;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.phone.viber.controller.CallStatusObserver;
import com.viber.voip.phone.viber.endcall.viewholders.EndCallViewHolder;
import com.viber.voip.phone.viber.endcall.viewholders.EndCallViewHolderBuilder;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.dz;
import java.lang.reflect.Field;
import javax.inject.Inject;

public class EndCallFragment extends CallFragment
{
  private static final Logger L = ViberEnv.getLogger();
  private AdsCallViewHolder mAdsCallViewHolder;

  @Inject
  g mAnalyticsManager;
  private CallFragmentManager.CallFragmentManagerCallback mCallFragmentManagerCallback;
  private CallStatusObserver mCallStatusObserver;

  @Inject
  dagger.a<ConferenceGroupCreationHelper> mConferenceGroupCreationHelper;
  private EndCallViewHolder mContentViewHolder;
  private EndCallStateResolver mEndCallStateResolver;

  @Inject
  ConferenceParticipantMapper mParticipantMapper;

  @Inject
  dagger.a<h> mUserStartsCallEventCollector;

  private void close()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof PhoneFragmentActivity))
      localFragmentActivity.finish();
  }

  private CallInfo getCallInfo()
  {
    return getCallHandler().getLastCallInfo();
  }

  private void prepareAdsAfterCallOnCreateView(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    CallInfo localCallInfo = getCallInfo();
    d locald;
    if (localCallInfo == null)
    {
      locald = null;
      if (!shouldShowAds(locald))
        break label124;
      this.mAdsCallViewHolder = new AdsCallViewHolder(this, this.mCallFragmentManagerCallback, locald, this.mContentViewHolder.getAdMobCloseBtn());
      this.mAdsCallViewHolder.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      this.mAdsCallViewHolder.showAd(getActivity(), localCallInfo);
      if ((localCallInfo.getAdProviderType() == 2) || (localCallInfo.getAdProviderType() == 3))
        this.mContentViewHolder.adjustLayoutForAds();
    }
    label124: 
    while ((this.mEndCallStateResolver != EndCallStateResolver.TIMEOUT) || (this.mContentViewHolder.getAdMobCloseBtn() == null))
    {
      return;
      locald = ViberApplication.getInstance().getMessagesManager().i().a(localCallInfo.getAdsType());
      break;
    }
    this.mContentViewHolder.getAdMobCloseBtn().setVisibility(4);
  }

  private void setConferenceBackground()
  {
    this.mContentViewHolder.getPhotoView().setBackgroundResource(R.color.conference_call_bg);
    View localView1 = this.mContentViewHolder.getTopControls();
    if (localView1 != null)
      localView1.setBackground(null);
    View localView2 = this.mContentViewHolder.getButtonsLayout();
    if (localView2 != null)
      localView2.setBackground(null);
  }

  private boolean shouldShowAds(d paramd)
  {
    if ((paramd == null) || (paramd.j() == null));
    CallInfo localCallInfo;
    do
    {
      return false;
      localCallInfo = getCallInfo();
    }
    while ((localCallInfo == null) || (!localCallInfo.needShowAds()) || (!this.mEndCallStateResolver.isSuitableForAds()) || (paramd.j().e() == null) || (!paramd.j().e().w()));
    return true;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    try
    {
      Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(this, null);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
  }

  public void onAttach(Activity paramActivity)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramActivity);
    this.mCallFragmentManagerCallback = ((CallFragmentManager.CallFragmentManagerCallback)paramActivity);
    this.mAnalyticsManager = g.a();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    CallInfo localCallInfo = getCallInfo();
    this.mEndCallStateResolver = EndCallStateResolver.resolveCallState(localCallInfo);
    this.mContentViewHolder = new EndCallViewHolderBuilder(this.mEndCallStateResolver, localCallInfo).withViberOutListener(new ViberOutCallListener(null)).withSendMessageListener(new OpenConversationListener(null)).withChatsListener(new OpenChatsListener(null)).withRedialListener(new RedialCallListener(null)).withLearnMoreListener(new LearnMoreListener(null)).withCloseListener(new CloseListener(null)).build(paramLayoutInflater, paramViewGroup, this.mIsTablet);
    View localView = this.mContentViewHolder.getContentView();
    this.mEndCallStateResolver.resolveViewsState(localView);
    this.mCallStatusObserver = new CallStatusObserver(this.mContentViewHolder.getCallStatusView(), localCallInfo);
    prepareAdsAfterCallOnCreateView((ViewGroup)localView, paramLayoutInflater, paramBundle);
    if ((localCallInfo != null) && (localCallInfo.isConference()))
    {
      ((ConferenceGroupCreationHelper)this.mConferenceGroupCreationHelper.get()).register();
      setConferenceBackground();
    }
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.mAdsCallViewHolder != null)
      this.mAdsCallViewHolder.onDestroy();
    d[] arrayOfd = ViberApplication.getInstance().getMessagesManager().i().a();
    int i = arrayOfd.length;
    for (int j = 0; j < i; j++)
      arrayOfd[j].k();
    CallInfo localCallInfo = getCallInfo();
    if ((localCallInfo != null) && (localCallInfo.isConference()))
      ((ConferenceGroupCreationHelper)this.mConferenceGroupCreationHelper.get()).unregister();
  }

  public void onPause()
  {
    super.onPause();
    pauseAdsAfterCall();
  }

  public void onResume()
  {
    super.onResume();
    resumeAdsAfterCall();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mAdsCallViewHolder != null)
      this.mAdsCallViewHolder.saveInstanceState(paramBundle);
  }

  public void onStart()
  {
    super.onStart();
    CallInfo localCallInfo = getCallInfo();
    if (localCallInfo == null);
    CallerInfo localCallerInfo;
    com.viber.voip.model.a locala;
    do
    {
      return;
      this.mCallStatusObserver.setCallInfo(localCallInfo);
      this.mCallStatusObserver.update(localCallInfo.getInCallState(), localCallInfo.getInCallState().clone());
      localCallInfo.getInCallState().addObserver(this.mCallStatusObserver);
      localCallerInfo = localCallInfo.getCallerInfo();
      locala = localCallerInfo.getContact();
      this.mContentViewHolder.setCallInfo(localCallInfo);
    }
    while ((localCallInfo.isConference()) || (locala == null));
    Uri localUri = localCallerInfo.getCallerPhoto();
    loadPhoto(this.mContentViewHolder.getPhotoView(), localUri, this.mContentViewHolder.getPhotoPlaceholder());
  }

  public void onStop()
  {
    super.onStop();
    CallInfo localCallInfo = getCallInfo();
    int i = 0;
    if (localCallInfo != null)
    {
      InCallState localInCallState = localCallInfo.getInCallState();
      i = 0;
      if (localInCallState != null)
      {
        localCallInfo.getInCallState().deleteObserver(this.mCallStatusObserver);
        int j = localCallInfo.getInCallState().getState();
        i = 0;
        if (5 == j)
          i = 1;
      }
    }
    if (i == 0)
      getDialerController().handleClose();
  }

  public void pauseAdsAfterCall()
  {
    if (this.mAdsCallViewHolder != null)
      this.mAdsCallViewHolder.onHide();
  }

  public void resumeAdsAfterCall()
  {
    if (this.mAdsCallViewHolder != null)
      this.mAdsCallViewHolder.onShow();
  }

  private class CloseListener
    implements View.OnClickListener
  {
    private CloseListener()
    {
    }

    public void onClick(View paramView)
    {
      g.a().c().e().c("Close");
      EndCallFragment.this.close();
    }
  }

  private class LearnMoreListener
    implements View.OnClickListener
  {
    private LearnMoreListener()
    {
    }

    public void onClick(View paramView)
    {
      String str = paramView.getContext().getString(R.string.vo_block_user_learn_more);
      dz.a(paramView.getContext(), GenericWebViewActivity.b(paramView.getContext(), str, str));
      g.a().c().e().c("Learn More");
    }
  }

  private class OpenChatsListener
    implements View.OnClickListener
  {
    private OpenChatsListener()
    {
    }

    public void onClick(View paramView)
    {
      if (EndCallFragment.this.mAdsCallViewHolder != null)
        EndCallFragment.this.mAdsCallViewHolder.trackAdsAfterCallButtonsClick(6);
      y.a(paramView.getContext(), ViberActionRunner.ab.a(paramView.getContext()));
    }
  }

  private class OpenConversationListener
    implements View.OnClickListener
  {
    private OpenConversationListener()
    {
    }

    private void openGroup()
    {
      int i = 0;
      ConferenceParticipant[] arrayOfConferenceParticipant = EndCallFragment.this.getCallInfo().getCallerInfo().getConferenceInfo().getParticipants();
      GroupController.GroupMember[] arrayOfGroupMember = new GroupController.GroupMember[arrayOfConferenceParticipant.length];
      int j = arrayOfConferenceParticipant.length;
      int m;
      for (int k = 0; i < j; k = m)
      {
        ConferenceParticipant localConferenceParticipant = arrayOfConferenceParticipant[i];
        m = k + 1;
        arrayOfGroupMember[k] = EndCallFragment.this.mParticipantMapper.mapToGroupMember(localConferenceParticipant);
        i++;
      }
      ((ConferenceGroupCreationHelper)EndCallFragment.this.mConferenceGroupCreationHelper.get()).createGroup(arrayOfGroupMember, new ConferenceGroupCreationHelper.Listener()
      {
        public void onGroupCreateError()
        {
          EndCallFragment.this.close();
        }

        public void onGroupCreated(long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          Intent localIntent = m.a(paramAnonymousLong, false);
          EndCallFragment.this.startActivity(localIntent);
          EndCallFragment.this.close();
        }
      });
    }

    public void onClick(View paramView)
    {
      CallInfo localCallInfo = EndCallFragment.this.getCallInfo();
      CallerInfo localCallerInfo = localCallInfo.getCallerInfo();
      if ((EndCallFragment.this.mEndCallStateResolver == EndCallStateResolver.DEFAULT) && (EndCallFragment.this.mAdsCallViewHolder != null))
        EndCallFragment.this.mAdsCallViewHolder.trackAdsAfterCallButtonsClick(5);
      if (!localCallInfo.isConference())
      {
        ViberActionRunner.a(paramView.getContext(), localCallerInfo.getMemberId(), localCallerInfo.getPhoneNumber(), localCallerInfo.getName());
        EndCallFragment.this.close();
        return;
      }
      openGroup();
    }
  }

  private class RedialCallListener
    implements View.OnClickListener
  {
    private RedialCallListener()
    {
    }

    public void onClick(View paramView)
    {
      boolean bool1 = true;
      String str = EndCallFragment.this.getCallInfo().getCallerInfo().getPhoneNumber();
      boolean bool2 = EndCallFragment.this.getCallInfo().isViberOut();
      CallInitiationId.noteNextCallInitiationAttemptId();
      h localh = (h)EndCallFragment.this.mUserStartsCallEventCollector.get();
      h.a.a locala1 = h.a.i();
      String[] arrayOfString = new String[bool1];
      arrayOfString[0] = str;
      h.a.a locala2 = locala1.a(arrayOfString).a(bool2, false).a("Redial").b(bool2);
      if (!bool2);
      while (true)
      {
        localh.b(locala2.a(bool1).a());
        if (!bool2)
          break;
        EndCallFragment.this.getDialerController().handleDialViberOut(str);
        return;
        bool1 = false;
      }
      EndCallFragment.this.getDialerController().handleDial(str, false);
    }
  }

  private class ViberOutCallListener
    implements View.OnClickListener
  {
    private ViberOutCallListener()
    {
    }

    public void onClick(View paramView)
    {
      String str = EndCallFragment.this.getCallInfo().getCallerInfo().getPhoneNumber();
      CallInitiationId.noteNextCallInitiationAttemptId();
      ((h)EndCallFragment.this.mUserStartsCallEventCollector.get()).b(h.a.i().a(new String[] { str }).b("Viber Out").a("Redial").b(true).a());
      EndCallFragment.this.getDialerController().handleDialViberOut(str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.EndCallFragment
 * JD-Core Version:    0.6.2
 */