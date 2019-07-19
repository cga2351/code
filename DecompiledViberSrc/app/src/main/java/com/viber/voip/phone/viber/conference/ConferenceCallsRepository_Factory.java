package com.viber.voip.phone.viber.conference;

import android.os.Handler;
import com.viber.jni.EngineDelegatesManager;
import com.viber.voip.flatbuffers.b.b;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.data.ConferenceCallsDatabaseHelper;
import com.viber.voip.phone.viber.conference.mapper.ConferenceCallMapper;
import com.viber.voip.registration.af;
import com.viber.voip.util.cn;
import com.viber.voip.util.i.e;
import javax.inject.Provider;

public final class ConferenceCallsRepository_Factory
  implements dagger.a.d<ConferenceCallsRepository>
{
  private final Provider<com.viber.voip.util.d> appBackgroundCheckerProvider;
  private final Provider<Handler> backgroundExecutorProvider;
  private final Provider<CallHandler> callHandlerProvider;
  private final Provider<ConferenceCallMapper> conferenceCallMapperProvider;
  private final Provider<ConferenceCallsDatabaseHelper> conferenceDatabaseProvider;
  private final Provider<z> conversationQueryHelperProvider;
  private final Provider<EngineDelegatesManager> delegatesManagerProvider;
  private final Provider<b<ConferenceInfo>> jsonSerializerProvider;
  private final Provider<Handler> mainExecutorProvider;
  private final Provider<bs> messageEditHelperProvider;
  private final Provider<ConferenceParticipantsRepository> participantsRepositoryProvider;
  private final Provider<af> registrationValuesProvider;
  private final Provider<cn> resourcesProvider;
  private final Provider<e> timeProvider;

  public ConferenceCallsRepository_Factory(Provider<CallHandler> paramProvider, Provider<EngineDelegatesManager> paramProvider1, Provider<ConferenceCallMapper> paramProvider2, Provider<ConferenceCallsDatabaseHelper> paramProvider3, Provider<Handler> paramProvider4, Provider<Handler> paramProvider5, Provider<b<ConferenceInfo>> paramProvider6, Provider<com.viber.voip.util.d> paramProvider7, Provider<z> paramProvider8, Provider<bs> paramProvider9, Provider<ConferenceParticipantsRepository> paramProvider10, Provider<cn> paramProvider11, Provider<af> paramProvider12, Provider<e> paramProvider13)
  {
    this.callHandlerProvider = paramProvider;
    this.delegatesManagerProvider = paramProvider1;
    this.conferenceCallMapperProvider = paramProvider2;
    this.conferenceDatabaseProvider = paramProvider3;
    this.mainExecutorProvider = paramProvider4;
    this.backgroundExecutorProvider = paramProvider5;
    this.jsonSerializerProvider = paramProvider6;
    this.appBackgroundCheckerProvider = paramProvider7;
    this.conversationQueryHelperProvider = paramProvider8;
    this.messageEditHelperProvider = paramProvider9;
    this.participantsRepositoryProvider = paramProvider10;
    this.resourcesProvider = paramProvider11;
    this.registrationValuesProvider = paramProvider12;
    this.timeProvider = paramProvider13;
  }

  public static ConferenceCallsRepository_Factory create(Provider<CallHandler> paramProvider, Provider<EngineDelegatesManager> paramProvider1, Provider<ConferenceCallMapper> paramProvider2, Provider<ConferenceCallsDatabaseHelper> paramProvider3, Provider<Handler> paramProvider4, Provider<Handler> paramProvider5, Provider<b<ConferenceInfo>> paramProvider6, Provider<com.viber.voip.util.d> paramProvider7, Provider<z> paramProvider8, Provider<bs> paramProvider9, Provider<ConferenceParticipantsRepository> paramProvider10, Provider<cn> paramProvider11, Provider<af> paramProvider12, Provider<e> paramProvider13)
  {
    return new ConferenceCallsRepository_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11, paramProvider12, paramProvider13);
  }

  public ConferenceCallsRepository get()
  {
    return new ConferenceCallsRepository((CallHandler)this.callHandlerProvider.get(), (EngineDelegatesManager)this.delegatesManagerProvider.get(), (ConferenceCallMapper)this.conferenceCallMapperProvider.get(), (ConferenceCallsDatabaseHelper)this.conferenceDatabaseProvider.get(), (Handler)this.mainExecutorProvider.get(), (Handler)this.backgroundExecutorProvider.get(), (b)this.jsonSerializerProvider.get(), (com.viber.voip.util.d)this.appBackgroundCheckerProvider.get(), (z)this.conversationQueryHelperProvider.get(), (bs)this.messageEditHelperProvider.get(), (ConferenceParticipantsRepository)this.participantsRepositoryProvider.get(), (cn)this.resourcesProvider.get(), (af)this.registrationValuesProvider.get(), (e)this.timeProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ConferenceCallsRepository_Factory
 * JD-Core Version:    0.6.2
 */