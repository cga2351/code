package com.viber.voip.phone.viber;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.p.a.a;
import com.viber.voip.phone.PhoneApp;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallMvpView;
import com.viber.voip.phone.viber.incall.GenericInCallMvpViewImpl;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class InCallFragment extends CallFragment
  implements a.a
{
  public static final boolean ENABLE_VOICE_CODEC_INFO;
  private com.viber.voip.p.a mCallProximityHelper;
  private Callbacks mCallbacks;

  @Inject
  dagger.a<c> mCallsTracker;

  @Inject
  dagger.a<ConferenceInCallMvpView> mConferenceInCallView;

  @Inject
  dagger.a<GenericInCallMvpViewImpl> mGenericInCallMvpView;
  private Boolean mIsConference;

  private View createView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIsConference = Boolean.valueOf(true);
      return ((ConferenceInCallMvpView)this.mConferenceInCallView.get()).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    this.mIsConference = Boolean.valueOf(false);
    View localView = ((GenericInCallMvpViewImpl)this.mGenericInCallMvpView.get()).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    ((GenericInCallMvpViewImpl)this.mGenericInCallMvpView.get()).setOnVideoClickListener(this.mCallbacks);
    return localView;
  }

  private void setFullscreenEnabled(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return;
    Window localWindow = localFragmentActivity.getWindow();
    if (paramBoolean)
    {
      localWindow.addFlags(1024);
      localWindow.getDecorView().setSystemUiVisibility(2);
      return;
    }
    localWindow.clearFlags(1024);
    localWindow.getDecorView().setSystemUiVisibility(0);
  }

  public boolean canGoBack()
  {
    if ((this.mIsConference == null) || (this.mIsConference.booleanValue()))
      return false;
    return ((GenericInCallMvpViewImpl)this.mGenericInCallMvpView.get()).viewHolderBack();
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    super.createViewPresenters(paramView, paramBundle);
    if (this.mIsConference.booleanValue())
    {
      ConferenceInCallMvpView localConferenceInCallMvpView = (ConferenceInCallMvpView)this.mConferenceInCallView.get();
      addMvpView(localConferenceInCallMvpView, localConferenceInCallMvpView.getPresenter(), paramBundle);
      if (paramBundle == null)
        ((c)this.mCallsTracker.get()).b();
      return;
    }
    GenericInCallMvpViewImpl localGenericInCallMvpViewImpl = (GenericInCallMvpViewImpl)this.mGenericInCallMvpView.get();
    addMvpView(localGenericInCallMvpViewImpl, localGenericInCallMvpViewImpl.getPresenter(), paramBundle);
  }

  public void enableBlackScreen(boolean paramBoolean)
  {
    View localView1 = getView();
    View localView2;
    if ((localView1 != null) && (localView1.getParent() != null))
    {
      localView2 = (View)localView1.getParent();
      if (paramBoolean)
        break label43;
    }
    label43: for (boolean bool = true; ; bool = false)
    {
      dj.b(localView2, bool);
      setFullscreenEnabled(paramBoolean);
      return;
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity.setVolumeControlStream(0);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mCallProximityHelper = ViberApplication.getInstance().getPhoneApp().getCallProximityHelper();
    CallInfo localCallInfo = getCallHandler().getCallInfo();
    if ((localCallInfo != null) && (localCallInfo.isConference()));
    for (boolean bool = true; ; bool = false)
    {
      View localView = createView(paramLayoutInflater, paramViewGroup, paramBundle, bool);
      if ((paramBundle == null) && (getSoundService().isSpeakerphoneOn()) && (!getSoundService().isUserWantsSpeaker()))
        getSoundService().setSpeakerphoneOn(false);
      return localView;
    }
  }

  public void onPause()
  {
    super.onPause();
    this.mCallProximityHelper.a(null);
  }

  public void onResume()
  {
    super.onResume();
    this.mCallProximityHelper.a(this);
  }

  public void setOnVideoClickListener(Callbacks paramCallbacks)
  {
    this.mCallbacks = paramCallbacks;
    if ((this.mIsConference != null) && (!this.mIsConference.booleanValue()))
      ((GenericInCallMvpViewImpl)this.mGenericInCallMvpView.get()).setOnVideoClickListener(this.mCallbacks);
  }

  public static abstract interface Callbacks
  {
    public abstract void onVideoButtonClicked();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.InCallFragment
 * JD-Core Version:    0.6.2
 */