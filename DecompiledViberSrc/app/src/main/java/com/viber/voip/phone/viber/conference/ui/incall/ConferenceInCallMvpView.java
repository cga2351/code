package com.viber.voip.phone.viber.conference.ui.incall;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.phone.viber.InCallFragment;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantModel;
import com.viber.voip.phone.viber.conference.ui.controls.ControlState;
import com.viber.voip.settings.d.m;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.b;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.p;
import com.viber.voip.widget.AccurateChronometer;
import com.viber.voip.widget.ToggleImageView;
import com.viber.voip.widget.animated.GlowingViewContainer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ConferenceInCallMvpView extends com.viber.voip.mvp.core.d<ConferenceInCallPresenter>
  implements View.OnClickListener, View.OnLongClickListener, ConferenceInCallContract.ConferenceMvpView, ConferenceParticipantsAdapter.OnInviteParticipantActionListener, ConferenceParticipantsAdapter.OnParticipantClickListener
{
  private View mAddParticipantView;
  private final Runnable mAdjustShadowAction = new ConferenceInCallMvpView..Lambda.0(this);
  private AccurateChronometer mConferenceDurationView;
  private View mConferenceMessage;
  private TextView mConferenceNameView;
  private View mConferenceParticipantsBottomShadow;
  private View mConferenceParticipantsTopShadow;
  private View mCoordinatorLayout;
  private final Fragment mFragment;
  private GlowingViewContainer mGlowingViewContainer;
  private final e mImageFetcher;
  private boolean mIsParticipantsListScrollable = false;
  private LinearLayoutManager mLinearLayoutManager;
  private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
  private RecyclerView.OnScrollListener mOnScrollListener;
  private int mParticipantItemHeight;
  private ConferenceParticipantsAdapter mParticipantsAdapter;
  private RecyclerView mParticipantsRecyclerView;
  private AppBarLayout mScrollAdjuster;
  private ToggleImageView mSilentCallView;
  private ToggleImageView mSpeakerPhoneView;
  private TextView mSpeakingPersonNameView;
  private ImageView mSpeakingPersonPhotoView;

  @Inject
  ConferenceInCallMvpView(InCallFragment paramInCallFragment, e parame, ConferenceInCallPresenter paramConferenceInCallPresenter, c paramc)
  {
    super(paramConferenceInCallPresenter, paramInCallFragment.getView());
    this.mFragment = paramInCallFragment;
    this.mImageFetcher = parame;
  }

  private void adjustTopBottomShadows()
  {
    if (this.mCoordinatorLayout == null)
      return;
    removeAdjustShadowActions();
    this.mParticipantsRecyclerView.postOnAnimation(this.mAdjustShadowAction);
  }

  private void clearOnOffsetChangedListener()
  {
    if (this.mOnOffsetChangedListener != null)
    {
      if (this.mScrollAdjuster != null)
        this.mScrollAdjuster.removeOnOffsetChangedListener(this.mOnOffsetChangedListener);
      this.mOnOffsetChangedListener = null;
    }
  }

  private void clearOnScrollListener()
  {
    if (this.mOnScrollListener != null)
    {
      if (this.mParticipantsRecyclerView != null)
        this.mParticipantsRecyclerView.removeOnScrollListener(this.mOnScrollListener);
      this.mOnScrollListener = null;
    }
  }

  private AppBarLayout.OnOffsetChangedListener getOnOffsetChangedListener(ConferenceViewsScrollAdjuster paramConferenceViewsScrollAdjuster)
  {
    if (this.mOnOffsetChangedListener == null)
      this.mOnOffsetChangedListener = new ConferenceInCallMvpView..Lambda.2(this, paramConferenceViewsScrollAdjuster);
    return this.mOnOffsetChangedListener;
  }

  private RecyclerView.OnScrollListener getOnScrollListener()
  {
    if (this.mOnScrollListener == null)
      this.mOnScrollListener = new RecyclerView.OnScrollListener()
      {
        public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          ConferenceInCallMvpView.this.adjustTopBottomShadows();
        }
      };
    return this.mOnScrollListener;
  }

  private void initScrollAdjuster(Context paramContext)
  {
    if (this.mScrollAdjuster == null)
    {
      this.mIsParticipantsListScrollable = true;
      return;
    }
    ConferenceViewsScrollAdjuster localConferenceViewsScrollAdjuster = new ConferenceViewsScrollAdjuster(paramContext.getResources(), this.mSpeakingPersonPhotoView, this.mGlowingViewContainer, this.mSpeakingPersonNameView, this.mConferenceNameView, this.mConferenceParticipantsTopShadow);
    this.mScrollAdjuster.addOnOffsetChangedListener(getOnOffsetChangedListener(localConferenceViewsScrollAdjuster));
    dj.a(this.mParticipantsRecyclerView, new ConferenceInCallMvpView..Lambda.1(this));
  }

  private void initShadowAdjuster()
  {
    if ((this.mConferenceParticipantsTopShadow != null) && (this.mConferenceParticipantsBottomShadow != null))
      this.mParticipantsRecyclerView.addOnScrollListener(getOnScrollListener());
  }

  private void removeAdjustShadowActions()
  {
    this.mParticipantsRecyclerView.removeCallbacks(this.mAdjustShadowAction);
  }

  private void updateControlState(ToggleImageView paramToggleImageView, ControlState paramControlState)
  {
    paramToggleImageView.setEnabled(paramControlState.enabled);
    paramToggleImageView.setChecked(paramControlState.checked);
  }

  private void updateParticipantsListScrollState()
  {
    if ((this.mScrollAdjuster != null) && (this.mScrollAdjuster.getHeight() > 0) && (this.mParticipantsRecyclerView.getHeight() > 0))
      if (this.mParticipantsRecyclerView.getHeight() - this.mScrollAdjuster.getHeight() >= this.mParticipantsAdapter.getItemCount() * this.mParticipantItemHeight)
        break label65;
    label65: for (boolean bool = true; ; bool = false)
    {
      this.mIsParticipantsListScrollable = bool;
      return;
    }
  }

  public void adjustConferenceStartTime(long paramLong)
  {
    this.mConferenceDurationView.setBase(paramLong);
    this.mConferenceDurationView.a();
  }

  public void displayConferenceName(String paramString)
  {
    this.mConferenceNameView.setText(paramString);
  }

  public void displayParticipantItems(List<ConferenceParticipantModel> paramList)
  {
    this.mParticipantsAdapter.submitList(paramList);
  }

  public void displaySpeakingPersonName(String paramString)
  {
    this.mSpeakingPersonNameView.setText(paramString);
  }

  public void displaySpeakingPersonPhoto(Uri paramUri, com.viber.voip.util.e.f paramf)
  {
    this.mImageFetcher.a(paramUri, this.mSpeakingPersonPhotoView, paramf);
  }

  public ConferenceInCallPresenter getPresenter()
  {
    return (ConferenceInCallPresenter)this.mPresenter;
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 108))
    {
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("added_participants");
      if ("com.viber.voip.action.ADD_PARTICIPANTS_TO_CONFERENCE".equals(paramIntent.getAction()))
      {
        ((ConferenceInCallPresenter)this.mPresenter).onInviteParticipantsToConference(localArrayList);
        return true;
      }
    }
    return super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public boolean onBackPressed()
  {
    ((ConferenceInCallPresenter)this.mPresenter).onBackPressed();
    return false;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.leaveConference)
      ((ConferenceInCallPresenter)this.mPresenter).onLeaveConferenceClicked();
    do
    {
      return;
      if (i == R.id.addParticipants)
      {
        ((ConferenceInCallPresenter)this.mPresenter).onAddParticipantClicked();
        return;
      }
      if (i == R.id.silentCall)
      {
        ((ConferenceInCallPresenter)this.mPresenter).onSilentCallClicked();
        return;
      }
      if (i == R.id.speakerPhone)
      {
        ((ConferenceInCallPresenter)this.mPresenter).onSpeakerPhoneClicked();
        return;
      }
    }
    while (i != R.id.conferenceMessage);
    ((ConferenceInCallPresenter)this.mPresenter).onMessageClicked();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.conference_incall_screen, paramViewGroup, false);
    localView.findViewById(R.id.leaveConference).setOnClickListener(this);
    this.mConferenceMessage = localView.findViewById(R.id.conferenceMessage);
    this.mConferenceMessage.setOnClickListener(this);
    this.mConferenceParticipantsTopShadow = localView.findViewById(R.id.conferenceParticipantsTopShadow);
    this.mConferenceParticipantsBottomShadow = localView.findViewById(R.id.conferenceParticipantsBottomShadow);
    this.mScrollAdjuster = ((AppBarLayout)localView.findViewById(R.id.appBarScrollAdjuster));
    this.mSilentCallView = ((ToggleImageView)localView.findViewById(R.id.silentCall));
    this.mSilentCallView.setOnClickListener(this);
    this.mSilentCallView.setOnLongClickListener(this);
    this.mSpeakerPhoneView = ((ToggleImageView)localView.findViewById(R.id.speakerPhone));
    this.mSpeakerPhoneView.setOnClickListener(this);
    this.mAddParticipantView = localView.findViewById(R.id.addParticipants);
    this.mAddParticipantView.setOnClickListener(this);
    this.mGlowingViewContainer = ((GlowingViewContainer)localView.findViewById(R.id.glowViewContainer));
    this.mSpeakingPersonPhotoView = ((ImageView)localView.findViewById(R.id.speakingPersonPhoto));
    this.mSpeakingPersonNameView = ((TextView)localView.findViewById(R.id.speakingPersonName));
    this.mConferenceNameView = ((TextView)localView.findViewById(R.id.conferenceName));
    this.mConferenceDurationView = ((AccurateChronometer)localView.findViewById(R.id.conferenceDuration));
    this.mCoordinatorLayout = localView.findViewById(R.id.coordinatorLayout);
    this.mLinearLayoutManager = new LinearLayoutManager(paramViewGroup.getContext(), 1, false)
    {
      public boolean canScrollVertically()
      {
        return (ConferenceInCallMvpView.this.mIsParticipantsListScrollable) && (super.canScrollVertically());
      }

      public void onLayoutCompleted(RecyclerView.State paramAnonymousState)
      {
        super.onLayoutCompleted(paramAnonymousState);
        ConferenceInCallMvpView.this.adjustTopBottomShadows();
        ConferenceInCallMvpView.this.updateParticipantsListScrollState();
      }
    };
    this.mParticipantsRecyclerView = ((RecyclerView)localView.findViewById(R.id.conferenceParticipants));
    this.mParticipantsRecyclerView.setLayoutManager(this.mLinearLayoutManager);
    this.mParticipantsAdapter = new ConferenceParticipantsAdapter(paramLayoutInflater);
    this.mParticipantsAdapter.setOnParticipantClickListener(this);
    this.mParticipantsAdapter.setOnInviteParticipantActionListener(this);
    this.mParticipantsRecyclerView.setAdapter(this.mParticipantsAdapter);
    this.mParticipantItemHeight = paramViewGroup.getResources().getDimensionPixelSize(R.dimen.conference_call_participant_item_height);
    initScrollAdjuster(paramViewGroup.getContext());
    initShadowAdjuster();
    return localView;
  }

  public void onDestroy()
  {
    clearOnOffsetChangedListener();
    clearOnScrollListener();
    removeAdjustShadowActions();
  }

  public boolean onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D1101))
    {
      if (paramInt == -1)
        ((ConferenceInCallPresenter)this.mPresenter).sendUpdateLink();
      while (true)
      {
        return true;
        ((ConferenceInCallPresenter)this.mPresenter).handleCancelSendUpdateLink();
      }
    }
    return false;
  }

  public void onInviteParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    ((ConferenceInCallPresenter)this.mPresenter).onInviteParticipantClicked(paramConferenceParticipantModel);
  }

  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == R.id.silentCall)
    {
      ((ConferenceInCallPresenter)this.mPresenter).onSilentCallLongClicked();
      return true;
    }
    return false;
  }

  public void onParticipantClicked(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    ((ConferenceInCallPresenter)this.mPresenter).onParticipantClicked(paramConferenceParticipantModel);
  }

  public void open1To1ConversationScreen(String paramString)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramString, "", "", false, false, false, false);
    this.mFragment.startActivity(localIntent);
  }

  public void openContactsSelectionScreen(String[] paramArrayOfString)
  {
    ViberActionRunner.r.a(this.mFragment, paramArrayOfString, d.m.w.d());
  }

  public void openGroupConversationScreen(long paramLong)
  {
    Intent localIntent = com.viber.voip.messages.m.a(paramLong, false);
    this.mFragment.startActivity(localIntent);
  }

  public void showGroupCreateError()
  {
    h.a locala = k.n();
    int i = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mFragment.getString(R.string.dialog_339_reason_create_group);
    locala.b(i, arrayOfObject).b(this.mFragment);
  }

  public void showNoConnectionError()
  {
    ad.a().b(this.mFragment);
  }

  public void showNoServiceError()
  {
    com.viber.voip.ui.dialogs.f.d().b(this.mFragment);
  }

  public void showPeersUnsupportedVersionError(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    String str = p.a(paramArrayOfConferenceParticipant, null);
    b.a(paramArrayOfConferenceParticipant.length, str).a(this.mFragment).b(this.mFragment);
  }

  public void startSpeakingPersonAnimation()
  {
    this.mGlowingViewContainer.a();
  }

  public void startSpeakingPersonVolumeLevelAnimation(long paramLong, float paramFloat)
  {
    this.mGlowingViewContainer.a(paramLong, paramFloat);
  }

  public void stopSpeakingPersonAnimation()
  {
    this.mGlowingViewContainer.b();
  }

  public void updateAddParticipantVisibility(boolean paramBoolean)
  {
    dj.b(this.mAddParticipantView, paramBoolean);
  }

  public void updateMessageVisibility(boolean paramBoolean)
  {
    dj.b(this.mConferenceMessage, paramBoolean);
  }

  public void updateSilentCallControlState(ControlState paramControlState, boolean paramBoolean)
  {
    ToggleImageView localToggleImageView1 = this.mSilentCallView;
    int i;
    ToggleImageView localToggleImageView2;
    Fragment localFragment;
    if (paramBoolean)
    {
      i = R.drawable.call_incall_mute;
      localToggleImageView1.setImageResource(i);
      localToggleImageView2 = this.mSilentCallView;
      localFragment = this.mFragment;
      if (!paramBoolean)
        break label71;
    }
    label71: for (int j = R.string.menu_call_mute; ; j = R.string.menu_call_hold)
    {
      localToggleImageView2.setContentDescription(localFragment.getString(j));
      updateControlState(this.mSilentCallView, paramControlState);
      return;
      i = R.drawable.call_incall_hold;
      break;
    }
  }

  public void updateSpeakerControlState(ControlState paramControlState)
  {
    updateControlState(this.mSpeakerPhoneView, paramControlState);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallMvpView
 * JD-Core Version:    0.6.2
 */