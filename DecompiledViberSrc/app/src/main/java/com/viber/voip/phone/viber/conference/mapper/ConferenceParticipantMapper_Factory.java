package com.viber.voip.phone.viber.conference.mapper;

import com.viber.voip.util.i.e;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceParticipantMapper_Factory
  implements d<ConferenceParticipantMapper>
{
  private final Provider<e> timeProvider;

  public ConferenceParticipantMapper_Factory(Provider<e> paramProvider)
  {
    this.timeProvider = paramProvider;
  }

  public static ConferenceParticipantMapper_Factory create(Provider<e> paramProvider)
  {
    return new ConferenceParticipantMapper_Factory(paramProvider);
  }

  public ConferenceParticipantMapper get()
  {
    return new ConferenceParticipantMapper((e)this.timeProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper_Factory
 * JD-Core Version:    0.6.2
 */