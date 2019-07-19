package com.viber.voip.phone.viber.endcall;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import dagger.a;
import dagger.a.c;
import dagger.b;
import javax.inject.Provider;

public final class EndCallFragment_MembersInjector
  implements b<EndCallFragment>
{
  private final Provider<g> mAnalyticsManagerProvider;
  private final Provider<ConferenceGroupCreationHelper> mConferenceGroupCreationHelperProvider;
  private final Provider<ConferenceParticipantMapper> mParticipantMapperProvider;
  private final Provider<h> mUserStartsCallEventCollectorProvider;

  public EndCallFragment_MembersInjector(Provider<ConferenceGroupCreationHelper> paramProvider, Provider<g> paramProvider1, Provider<ConferenceParticipantMapper> paramProvider2, Provider<h> paramProvider3)
  {
    this.mConferenceGroupCreationHelperProvider = paramProvider;
    this.mAnalyticsManagerProvider = paramProvider1;
    this.mParticipantMapperProvider = paramProvider2;
    this.mUserStartsCallEventCollectorProvider = paramProvider3;
  }

  public static b<EndCallFragment> create(Provider<ConferenceGroupCreationHelper> paramProvider, Provider<g> paramProvider1, Provider<ConferenceParticipantMapper> paramProvider2, Provider<h> paramProvider3)
  {
    return new EndCallFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public static void injectMAnalyticsManager(EndCallFragment paramEndCallFragment, g paramg)
  {
    paramEndCallFragment.mAnalyticsManager = paramg;
  }

  public static void injectMConferenceGroupCreationHelper(EndCallFragment paramEndCallFragment, a<ConferenceGroupCreationHelper> parama)
  {
    paramEndCallFragment.mConferenceGroupCreationHelper = parama;
  }

  public static void injectMParticipantMapper(EndCallFragment paramEndCallFragment, ConferenceParticipantMapper paramConferenceParticipantMapper)
  {
    paramEndCallFragment.mParticipantMapper = paramConferenceParticipantMapper;
  }

  public static void injectMUserStartsCallEventCollector(EndCallFragment paramEndCallFragment, a<h> parama)
  {
    paramEndCallFragment.mUserStartsCallEventCollector = parama;
  }

  public void injectMembers(EndCallFragment paramEndCallFragment)
  {
    injectMConferenceGroupCreationHelper(paramEndCallFragment, c.b(this.mConferenceGroupCreationHelperProvider));
    injectMAnalyticsManager(paramEndCallFragment, (g)this.mAnalyticsManagerProvider.get());
    injectMParticipantMapper(paramEndCallFragment, (ConferenceParticipantMapper)this.mParticipantMapperProvider.get());
    injectMUserStartsCallEventCollector(paramEndCallFragment, c.b(this.mUserStartsCallEventCollectorProvider));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.EndCallFragment_MembersInjector
 * JD-Core Version:    0.6.2
 */