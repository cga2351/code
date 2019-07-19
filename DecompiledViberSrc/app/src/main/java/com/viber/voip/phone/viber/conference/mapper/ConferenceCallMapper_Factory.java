package com.viber.voip.phone.viber.conference.mapper;

import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceCallMapper_Factory
  implements d<ConferenceCallMapper>
{
  private final Provider<a<ConferenceInfo>> jsonDeserializerProvider;

  public ConferenceCallMapper_Factory(Provider<a<ConferenceInfo>> paramProvider)
  {
    this.jsonDeserializerProvider = paramProvider;
  }

  public static ConferenceCallMapper_Factory create(Provider<a<ConferenceInfo>> paramProvider)
  {
    return new ConferenceCallMapper_Factory(paramProvider);
  }

  public ConferenceCallMapper get()
  {
    return new ConferenceCallMapper((a)this.jsonDeserializerProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.mapper.ConferenceCallMapper_Factory
 * JD-Core Version:    0.6.2
 */