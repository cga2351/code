package com.viber.voip.phone.viber.conference.ui.incall;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.phone.viber.conference.model.ConferenceCallStatus;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantModel;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class ConferenceParticipantViewHolder extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ConferenceParticipantsAdapter.OnParticipantClickListener mClickListener;
  private final Context mContext;
  private final f mFetcherConfig;
  private final e mImageFetcher;
  private ConferenceParticipantModel mItem;
  private final View mJoinButton;
  private ConferenceParticipantsAdapter.OnInviteParticipantActionListener mJoinListener;
  private final TextView mName;
  private final ImageView mPhoto;
  private final Resources mResources;
  private final TextView mStatus;

  public ConferenceParticipantViewHolder(View paramView, ConferenceParticipantsAdapter.OnParticipantClickListener paramOnParticipantClickListener, ConferenceParticipantsAdapter.OnInviteParticipantActionListener paramOnInviteParticipantActionListener)
  {
    super(paramView);
    this.mContext = paramView.getContext();
    this.mResources = paramView.getResources();
    paramView.setOnClickListener(this);
    this.mClickListener = paramOnParticipantClickListener;
    this.mJoinListener = paramOnInviteParticipantActionListener;
    this.mPhoto = ((ImageView)paramView.findViewById(R.id.conferenceParticipantPhoto));
    this.mName = ((TextView)paramView.findViewById(R.id.conferenceParticipantName));
    this.mStatus = ((TextView)paramView.findViewById(R.id.conferenceParticipantStatus));
    this.mJoinButton = paramView.findViewById(R.id.joinParticipant);
    this.mJoinButton.setOnClickListener(this);
    this.mImageFetcher = e.a(paramView.getContext());
    this.mFetcherConfig = f.b(paramView.getContext());
  }

  private void bindCallStatusText(ConferenceCallStatus paramConferenceCallStatus)
  {
    int i = ContextCompat.getColor(this.mContext, R.color.conference_call_status_text);
    Object localObject;
    int j;
    switch (1.$SwitchMap$com$viber$voip$phone$conf$IConferenceCall$UiDelegate$PeerDetailedState[paramConferenceCallStatus.detailedState.ordinal()])
    {
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    default:
      localObject = this.mResources.getString(R.string.call_status_not_in_call);
      j = i;
    case 7:
    case 8:
    case 9:
    case 10:
    case 1:
    case 11:
    }
    while (true)
    {
      this.mStatus.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      ((Spannable)this.mStatus.getText()).setSpan(new ForegroundColorSpan(j), 0, this.mStatus.getText().length(), 18);
      return;
      String str = this.mResources.getString(R.string.call_status_in_call);
      int k = ContextCompat.getColor(this.mContext, R.color.conference_call_incall_status_text);
      localObject = str;
      j = k;
      continue;
      localObject = this.mResources.getString(R.string.call_status_hold);
      j = i;
      continue;
      localObject = this.mResources.getString(R.string.call_status_reconnecting);
      j = i;
      continue;
      localObject = this.mResources.getString(R.string.call_status_calling);
      j = i;
      continue;
      localObject = this.mResources.getString(R.string.call_status_busy);
      j = i;
      continue;
      localObject = this.mResources.getString(R.string.service_notifer_connecting);
      j = i;
    }
  }

  private boolean getJoinButtonVisibility(ConferenceCallStatus paramConferenceCallStatus)
  {
    switch (1.$SwitchMap$com$viber$voip$phone$conf$IConferenceCall$UiDelegate$PeerDetailedState[paramConferenceCallStatus.detailedState.ordinal()])
    {
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    return true;
  }

  public void bindTo(ConferenceParticipantModel paramConferenceParticipantModel)
  {
    this.mItem = paramConferenceParticipantModel;
    this.mImageFetcher.a(paramConferenceParticipantModel.photoUri, this.mPhoto, this.mFetcherConfig);
    this.mName.setText(paramConferenceParticipantModel.displayName);
    bindCallStatusText(paramConferenceParticipantModel.callStatus);
    dj.b(this.mJoinButton, getJoinButtonVisibility(paramConferenceParticipantModel.callStatus));
  }

  public void onClick(View paramView)
  {
    if (R.id.joinParticipant == paramView.getId())
      if (this.mJoinListener != null)
        this.mJoinListener.onInviteParticipantClicked(this.mItem);
    while (this.mClickListener == null)
      return;
    this.mClickListener.onParticipantClicked(this.mItem);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceParticipantViewHolder
 * JD-Core Version:    0.6.2
 */