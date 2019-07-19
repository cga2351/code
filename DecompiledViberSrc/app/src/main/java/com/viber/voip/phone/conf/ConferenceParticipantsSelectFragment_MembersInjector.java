package com.viber.voip.phone.conf;

import com.viber.voip.contacts.ui.v;
import dagger.b;
import javax.inject.Provider;

public final class ConferenceParticipantsSelectFragment_MembersInjector
  implements b<ConferenceParticipantsSelectFragment>
{
  private final Provider<com.viber.voip.invitelinks.f> mCommunityFollowerInviteLinksHelperProvider;
  private final Provider<com.viber.voip.invitelinks.linkscreen.f> mLinkActionsInteractorProvider;
  private final Provider<com.viber.voip.analytics.story.e.c> mMessagesTrackerProvider;

  public ConferenceParticipantsSelectFragment_MembersInjector(Provider<com.viber.voip.analytics.story.e.c> paramProvider, Provider<com.viber.voip.invitelinks.f> paramProvider1, Provider<com.viber.voip.invitelinks.linkscreen.f> paramProvider2)
  {
    this.mMessagesTrackerProvider = paramProvider;
    this.mCommunityFollowerInviteLinksHelperProvider = paramProvider1;
    this.mLinkActionsInteractorProvider = paramProvider2;
  }

  public static b<ConferenceParticipantsSelectFragment> create(Provider<com.viber.voip.analytics.story.e.c> paramProvider, Provider<com.viber.voip.invitelinks.f> paramProvider1, Provider<com.viber.voip.invitelinks.linkscreen.f> paramProvider2)
  {
    return new ConferenceParticipantsSelectFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }

  public void injectMembers(ConferenceParticipantsSelectFragment paramConferenceParticipantsSelectFragment)
  {
    v.a(paramConferenceParticipantsSelectFragment, (com.viber.voip.analytics.story.e.c)this.mMessagesTrackerProvider.get());
    v.a(paramConferenceParticipantsSelectFragment, dagger.a.c.b(this.mCommunityFollowerInviteLinksHelperProvider));
    v.b(paramConferenceParticipantsSelectFragment, dagger.a.c.b(this.mLinkActionsInteractorProvider));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ConferenceParticipantsSelectFragment_MembersInjector
 * JD-Core Version:    0.6.2
 */