package com.viber.voip.phone.viber.incall;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.viber.common.dialogs.m;
import com.viber.common.permission.c;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.mvp.core.d;
import com.viber.voip.phone.viber.CallControlsFragment;
import com.viber.voip.phone.viber.CallMenuFragment;
import com.viber.voip.phone.viber.CallViewHolder;
import com.viber.voip.phone.viber.InCallFragment;
import com.viber.voip.phone.viber.InCallFragment.Callbacks;
import com.viber.voip.phone.viber.PhoneKeypadFragment;
import com.viber.voip.phone.viber.PhoneKeypadFragment.KeypadVisibilityListener;
import com.viber.voip.phone.viber.controller.CallMenuButtons;
import com.viber.voip.phone.viber.controller.KeypadHolder;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

public class GenericInCallMvpViewImpl extends d<GenericInCallPresenter>
  implements View.OnClickListener, GenericInCallMvpView
{
  private Deque<View> mBackStackLast;
  private Map<ViewGroup, Deque<View>> mBackStacks = new HashMap();
  private com.viber.voip.util.e.a.a mBackgroundLoadListener;
  private CallControlsFragment mCallControlsViewHolder;
  private CallMenuFragment mCallMenuViewHolder;
  private InCallFragment.Callbacks mCallbacks;
  private View mCallerPhoto;
  private ImageView mCallerPhotoReal;
  private View mCloseKeypad;
  private ViewGroup mContainerLast;
  private ViewGroup mControlsContainer;
  private final com.viber.voip.contacts.ui.list.b mDelegate;
  private final com.viber.voip.app.b mDeviceConfiguration;
  private final InCallFragment mFragment;
  private final e mImageFetcher;
  private LayoutInflater mInflater;
  private PhoneKeypadFragment mPhoneKeypadViewHolder;
  private Bundle mSavedInstanceState;
  private Map<View, CallViewHolder> mViewHolders = new HashMap();
  private Map<CallViewHolder, View> mViews = new HashMap();

  @Inject
  public GenericInCallMvpViewImpl(InCallFragment paramInCallFragment, e parame, c paramc, com.viber.voip.app.b paramb, GenericInCallPresenter paramGenericInCallPresenter)
  {
    super(paramGenericInCallPresenter, paramInCallFragment.getView());
    this.mFragment = paramInCallFragment;
    this.mImageFetcher = parame;
    this.mDeviceConfiguration = paramb;
    this.mDelegate = new com.viber.voip.contacts.ui.list.b(paramGenericInCallPresenter, this.mFragment, paramc, 145);
  }

  private void loadPhoto(final View paramView, final Uri paramUri, final int paramInt)
  {
    dj.a(paramView, new Runnable()
    {
      public void run()
      {
        if ((paramView.getMeasuredWidth() > 0) && (paramView.getMeasuredHeight() > 0))
        {
          f.a locala;
          if (GenericInCallMvpViewImpl.this.mFragment.getActivity() != null)
          {
            locala = f.a(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), true).f();
            locala.b(Integer.valueOf(paramInt));
            locala.a(com.viber.voip.b.a.j);
            locala.c(true);
            if ((paramView instanceof ImageView))
              GenericInCallMvpViewImpl.this.mImageFetcher.a(paramUri, (ImageView)paramView, locala.c());
          }
          else
          {
            return;
          }
          GenericInCallMvpViewImpl.access$302(GenericInCallMvpViewImpl.this, new com.viber.voip.util.e.a.a(paramView));
          GenericInCallMvpViewImpl.this.mImageFetcher.a(paramUri, locala.c(), GenericInCallMvpViewImpl.this.mBackgroundLoadListener);
          return;
        }
        dj.a(paramView, this);
      }
    });
  }

  private Deque<View> viewBackStack(ViewGroup paramViewGroup)
  {
    Object localObject = (Deque)this.mBackStacks.get(paramViewGroup);
    if (localObject == null)
    {
      localObject = new LinkedList();
      this.mBackStacks.put(paramViewGroup, localObject);
    }
    return localObject;
  }

  private void viewHolderPause()
  {
    Iterator localIterator = this.mBackStacks.entrySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((Deque)((Map.Entry)localIterator.next()).getValue()).peek();
      if (localView != null)
        ((CallViewHolder)this.mViewHolders.get(localView)).onHide();
    }
  }

  private void viewHolderResume()
  {
    Iterator localIterator = this.mBackStacks.entrySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((Deque)((Map.Entry)localIterator.next()).getValue()).peek();
      if (localView != null)
        ((CallViewHolder)this.mViewHolders.get(localView)).onShow();
    }
  }

  private void viewHolderShow(CallViewHolder paramCallViewHolder, ViewGroup paramViewGroup)
  {
    Deque localDeque = viewBackStack(paramViewGroup);
    View localView1 = (View)this.mViews.get(paramCallViewHolder);
    if (localView1 == null)
    {
      localView1 = paramCallViewHolder.onCreateView(this.mInflater, paramViewGroup, this.mSavedInstanceState);
      this.mViews.put(paramCallViewHolder, localView1);
      this.mViewHolders.put(localView1, paramCallViewHolder);
    }
    View localView2 = localView1;
    View localView3 = (View)localDeque.peek();
    if (localView3 != null)
    {
      ((CallViewHolder)this.mViewHolders.get(localView3)).onHide();
      paramViewGroup.removeView(localView3);
    }
    localDeque.push(localView2);
    paramViewGroup.addView(localView2);
    paramCallViewHolder.onShow();
    this.mBackStackLast = localDeque;
    this.mContainerLast = paramViewGroup;
  }

  public void close()
  {
  }

  public void closeOnSuccess()
  {
  }

  public GenericInCallPresenter getPresenter()
  {
    return (GenericInCallPresenter)this.mPresenter;
  }

  public void loadPhoto(boolean paramBoolean, Uri paramUri)
  {
    if (this.mCallerPhoto != null)
    {
      if (!paramBoolean)
        break label43;
      loadPhoto(this.mCallerPhoto, paramUri, R.drawable.call_screen_bg);
    }
    while (true)
    {
      if (this.mCallerPhotoReal != null)
        loadPhoto(this.mCallerPhotoReal, paramUri, R.drawable.call_screen_bg);
      return;
      label43: dj.a(this.mCallerPhoto, j.a(this.mFragment.getResources(), R.drawable.call_screen_bg));
    }
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 108))
    {
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("added_participants");
      if ("com.viber.voip.action.CREATE_CONFERENCE_WITH_1ON1_PARTICIPANTS".equals(paramIntent.getAction()))
        ((GenericInCallPresenter)this.mPresenter).handleSelectConferenceParticipants(localArrayList);
      return true;
    }
    return false;
  }

  public void onClick(View paramView)
  {
    if (R.id.phone_end_call == paramView.getId())
      ((GenericInCallPresenter)this.mPresenter).handleEndCallClick();
    do
    {
      return;
      if (R.id.keypad == paramView.getId())
      {
        if (this.mDeviceConfiguration.a(this.mControlsContainer.getContext()));
        for (Object localObject = this.mControlsContainer.findViewById(this.mCallControlsViewHolder.getCallMenuPlace()); ; localObject = this.mControlsContainer)
        {
          ViewGroup localViewGroup = (ViewGroup)localObject;
          viewHolderShow(this.mPhoneKeypadViewHolder, localViewGroup);
          return;
        }
      }
    }
    while (R.id.call_btn_add_to_call != paramView.getId());
    ((GenericInCallPresenter)this.mPresenter).handleAddToCallClick();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mSavedInstanceState = paramBundle;
    this.mInflater = paramLayoutInflater;
    this.mCallControlsViewHolder = new CallControlsFragment(this.mFragment);
    this.mCallMenuViewHolder = new CallMenuFragment(this.mFragment);
    this.mPhoneKeypadViewHolder = new PhoneKeypadFragment(this.mFragment);
    View localView = paramLayoutInflater.inflate(R.layout.phone_incall, paramViewGroup, false);
    this.mControlsContainer = ((ViewGroup)localView.findViewById(R.id.phone_incall));
    this.mCloseKeypad = localView.findViewById(R.id.phone_close_keypad);
    if (!this.mDeviceConfiguration.a(this.mFragment.getActivity()))
    {
      this.mCallerPhoto = paramViewGroup;
      this.mCallerPhotoReal = ((ImageView)localView.findViewById(R.id.phone_photo_main));
      viewHolderShow(this.mCallControlsViewHolder, this.mControlsContainer);
      if (!this.mDeviceConfiguration.a(this.mFragment.getActivity()))
        break label305;
      localView.findViewById(R.id.phone_end_call).setOnClickListener(this);
    }
    while (true)
    {
      viewHolderShow(this.mCallMenuViewHolder, (ViewGroup)this.mControlsContainer.findViewById(this.mCallControlsViewHolder.getCallMenuPlace()));
      this.mCallMenuViewHolder.getCallMenuButtons().setOnKeypadClickListener(this);
      GenericInCallMvpViewImpl..Lambda.0 local0 = new GenericInCallMvpViewImpl..Lambda.0(this);
      if (this.mCloseKeypad != null)
      {
        this.mCloseKeypad.setOnClickListener(local0);
        this.mPhoneKeypadViewHolder.setKeypadVisibilityListener(new PhoneKeypadFragment.KeypadVisibilityListener()
        {
          public void onKeypadHide()
          {
            if (GenericInCallMvpViewImpl.this.mCloseKeypad != null)
              GenericInCallMvpViewImpl.this.mCloseKeypad.setVisibility(4);
          }

          public void onKeypadShow()
          {
            if (GenericInCallMvpViewImpl.this.mCloseKeypad != null)
              GenericInCallMvpViewImpl.this.mCloseKeypad.setVisibility(0);
          }
        });
      }
      this.mPhoneKeypadViewHolder.getKeypadHolder().setOnCloseListener(local0);
      this.mCallMenuViewHolder.getCallMenuButtons().setOnVideoClickListener(new GenericInCallMvpViewImpl..Lambda.1(this));
      return localView;
      if (!this.mDeviceConfiguration.a())
        break;
      this.mCallerPhoto = paramViewGroup.findViewById(R.id.phone_photo);
      break;
      label305: this.mControlsContainer.findViewById(R.id.phone_end_call).setOnClickListener(this);
    }
  }

  public void onDestroy()
  {
    if (this.mCallControlsViewHolder != null)
    {
      this.mCallControlsViewHolder.onDestroy();
      this.mCallControlsViewHolder = null;
    }
    if (this.mPhoneKeypadViewHolder != null)
    {
      this.mPhoneKeypadViewHolder.onDestroy();
      this.mPhoneKeypadViewHolder = null;
    }
    if (this.mCallMenuViewHolder != null)
    {
      this.mCallMenuViewHolder.onDestroy();
      this.mCallMenuViewHolder = null;
    }
    this.mViewHolders.clear();
    this.mBackStacks.clear();
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    return this.mDelegate.a(paramm, paramInt);
  }

  public void onPause()
  {
    viewHolderPause();
  }

  public void onResume()
  {
    viewHolderResume();
  }

  public void onStart()
  {
    this.mDelegate.onStart();
  }

  public void onStop()
  {
    this.mDelegate.onStop();
  }

  public void openConferenceParticipantsSelector(String paramString, int paramInt)
  {
    ViberActionRunner.r.a(this.mFragment, paramString, paramInt);
  }

  public void setOnVideoClickListener(InCallFragment.Callbacks paramCallbacks)
  {
    this.mCallbacks = paramCallbacks;
  }

  public void showAllParticipantsUnsupportedVersionError()
  {
    this.mDelegate.showAllParticipantsUnsupportedVersionError();
  }

  public void showGeneralError()
  {
    this.mDelegate.showGeneralError();
  }

  public void showNoConnectionError()
  {
    this.mDelegate.showNoConnectionError();
  }

  public void showNoServiceError()
  {
    this.mDelegate.showNoServiceError();
  }

  public void showParticipantsUnavailableError(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    this.mDelegate.showParticipantsUnavailableError(paramArrayOfConferenceParticipant);
  }

  public void showSomeParticipantsUnsupportedVersionError(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    this.mDelegate.showSomeParticipantsUnsupportedVersionError(paramArrayOfConferenceParticipant);
  }

  public boolean viewHolderBack()
  {
    if (this.mBackStackLast == null)
      return false;
    View localView1 = (View)this.mBackStackLast.poll();
    View localView2 = (View)this.mBackStackLast.peekLast();
    if ((localView1 != null) && (localView2 != null))
    {
      ((CallViewHolder)this.mViewHolders.get(localView1)).onHide();
      this.mContainerLast.removeView(localView1);
      ((CallViewHolder)this.mViewHolders.get(localView2)).onShow();
      this.mContainerLast.addView(localView2);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incall.GenericInCallMvpViewImpl
 * JD-Core Version:    0.6.2
 */