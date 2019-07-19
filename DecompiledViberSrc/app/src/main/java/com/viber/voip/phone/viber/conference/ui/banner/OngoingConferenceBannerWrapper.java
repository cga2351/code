package com.viber.voip.phone.viber.conference.ui.banner;

import android.view.LayoutInflater;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.b.b;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;

public class OngoingConferenceBannerWrapper
  implements b.b, OngoingConferenceBanner.Listener
{
  private final ConversationAlertView mAlertView;
  private OngoingConferenceBanner mBanner;
  private OngoingConferenceCallModel mConference;
  private LayoutInflater mInflater;
  private final Listener mListener;

  public OngoingConferenceBannerWrapper(ConversationAlertView paramConversationAlertView, Listener paramListener, LayoutInflater paramLayoutInflater)
  {
    this.mAlertView = paramConversationAlertView;
    this.mListener = paramListener;
    this.mInflater = paramLayoutInflater;
  }

  private OngoingConferenceBanner createBanner()
  {
    return new OngoingConferenceBanner(this.mAlertView, this, this, this.mInflater);
  }

  public void bind(ConversationItemLoaderEntity paramConversationItemLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    this.mConference = paramOngoingConferenceCallModel;
    if (paramOngoingConferenceCallModel == null)
    {
      hide();
      return;
    }
    if (this.mBanner == null)
      this.mBanner = createBanner();
    this.mBanner.bind(paramConversationItemLoaderEntity, paramOngoingConferenceCallModel);
    this.mAlertView.a(this.mBanner, false);
  }

  public void hide()
  {
    if (this.mBanner != null)
      this.mAlertView.a(this.mBanner.getMode(), false);
  }

  public void onAlertBannerVisibilityChanged(boolean paramBoolean)
  {
    this.mListener.onConferenceBannerVisibilityChanged(paramBoolean);
  }

  public void onBannerClicked()
  {
    if (this.mConference != null)
      this.mListener.onJoinConference(this.mConference.callToken, this.mConference.conferenceInfo, this.mConference.conversationId);
  }

  public static abstract interface Listener
  {
    public abstract void onConferenceBannerVisibilityChanged(boolean paramBoolean);

    public abstract void onJoinConference(long paramLong1, ConferenceInfo paramConferenceInfo, long paramLong2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.banner.OngoingConferenceBannerWrapper
 * JD-Core Version:    0.6.2
 */