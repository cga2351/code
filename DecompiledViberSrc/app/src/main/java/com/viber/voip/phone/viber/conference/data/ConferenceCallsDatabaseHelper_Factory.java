package com.viber.voip.phone.viber.conference.data;

import com.viber.provider.b;
import com.viber.voip.phone.viber.conference.mapper.ConferenceCallMapper;
import dagger.a.c;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceCallsDatabaseHelper_Factory
  implements d<ConferenceCallsDatabaseHelper>
{
  private final Provider<ConferenceCallMapper> conferenceCallMapperProvider;
  private final Provider<b> databaseProvider;

  public ConferenceCallsDatabaseHelper_Factory(Provider<b> paramProvider, Provider<ConferenceCallMapper> paramProvider1)
  {
    this.databaseProvider = paramProvider;
    this.conferenceCallMapperProvider = paramProvider1;
  }

  public static ConferenceCallsDatabaseHelper_Factory create(Provider<b> paramProvider, Provider<ConferenceCallMapper> paramProvider1)
  {
    return new ConferenceCallsDatabaseHelper_Factory(paramProvider, paramProvider1);
  }

  public ConferenceCallsDatabaseHelper get()
  {
    return new ConferenceCallsDatabaseHelper(c.b(this.databaseProvider), (ConferenceCallMapper)this.conferenceCallMapperProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.data.ConferenceCallsDatabaseHelper_Factory
 * JD-Core Version:    0.6.2
 */