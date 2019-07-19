package com.viber.voip.phone.viber.conference.ui.banner;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.text.BidiFormatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.a.a;
import com.viber.voip.messages.conversation.ui.banner.b.b;
import com.viber.voip.messages.conversation.ui.banner.q;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.util.p;
import com.viber.voip.widget.AccurateChronometer;

public class OngoingConferenceBanner extends q
  implements View.OnClickListener
{
  private BidiFormatter mBidiFormatter;
  private final AccurateChronometer mChronometer;
  private final TextView mInviteText;
  private Listener mListener;
  private final TextView mParticipants;

  public OngoingConferenceBanner(ViewGroup paramViewGroup, Listener paramListener, b.b paramb, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.ongoing_conference_banner_layout, paramViewGroup, null, paramb, paramLayoutInflater);
    this.mListener = paramListener;
    this.layout.setOnClickListener(this);
    this.mInviteText = ((TextView)this.layout.findViewById(R.id.ongoingConferenceInviteText));
    this.mChronometer = ((AccurateChronometer)this.layout.findViewById(R.id.ongoingConferenceDuration));
    this.mParticipants = ((TextView)this.layout.findViewById(R.id.ongoingConferenceParticipants));
  }

  private void bindHeadline(ConversationItemLoaderEntity paramConversationItemLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    if (hasInviter(paramConversationItemLoaderEntity, paramOngoingConferenceCallModel))
    {
      TextView localTextView = this.mInviteText;
      Resources localResources = this.resources;
      int i = R.string.invited_you_to_call;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = p.a(paramConversationItemLoaderEntity.getParticipantName(), getBidiFormatter());
      localTextView.setText(localResources.getString(i, com.viber.common.d.c.a(arrayOfObject)));
    }
    while (true)
    {
      long l = Math.max(System.currentTimeMillis() - paramOngoingConferenceCallModel.startTimeMillis, 0L);
      this.mChronometer.setBase(SystemClock.elapsedRealtime() - l);
      return;
      this.mInviteText.setText(this.resources.getString(R.string.ongoing_call));
    }
  }

  private void bindParticipants(ConversationItemLoaderEntity paramConversationItemLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    ConferenceInfo localConferenceInfo = paramOngoingConferenceCallModel.conferenceInfo;
    if (hasInviter(paramConversationItemLoaderEntity, paramOngoingConferenceCallModel));
    for (String str1 = paramConversationItemLoaderEntity.getParticipantMemberId(); ; str1 = null)
    {
      String str2 = p.a(localConferenceInfo, str1);
      this.mParticipants.setText(this.resources.getString(R.string.with_items, new Object[] { str2 }));
      return;
    }
  }

  private BidiFormatter getBidiFormatter()
  {
    if (this.mBidiFormatter == null)
      this.mBidiFormatter = BidiFormatter.getInstance();
    return this.mBidiFormatter;
  }

  private boolean hasInviter(ConversationItemLoaderEntity paramConversationItemLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    return (!paramOngoingConferenceCallModel.conferenceInfo.isSelfInitiated()) && (paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.isConversation1on1());
  }

  public void bind(ConversationItemLoaderEntity paramConversationItemLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    bindHeadline(paramConversationItemLoaderEntity, paramOngoingConferenceCallModel);
    bindParticipants(paramConversationItemLoaderEntity, paramOngoingConferenceCallModel);
    this.mChronometer.a();
  }

  protected a createAlertViewUiCustomizer()
  {
    return new com.viber.voip.messages.conversation.ui.banner.a.c();
  }

  public int getAppearanceOrder()
  {
    return 1;
  }

  public ConversationAlertView.a getMode()
  {
    return ConversationAlertView.a.n;
  }

  public void onClick(View paramView)
  {
    if (R.id.ongoingConferenceBanner == paramView.getId())
      this.mListener.onBannerClicked();
  }

  public static abstract interface Listener
  {
    public abstract void onBannerClicked();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.banner.OngoingConferenceBanner
 * JD-Core Version:    0.6.2
 */