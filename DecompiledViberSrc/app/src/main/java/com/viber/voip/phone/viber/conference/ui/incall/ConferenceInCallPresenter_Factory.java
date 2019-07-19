package com.viber.voip.phone.viber.conference.ui.incall;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceGroupCreationHelper;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceHoldStateResolver;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceMicStateResolver;
import com.viber.voip.phone.viber.conference.ui.controls.ConferenceSpeakerStateResolver;
import com.viber.voip.registration.af;
import com.viber.voip.user.editinfo.UserInfoRepository;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.i.e;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceInCallPresenter_Factory
  implements d<ConferenceInCallPresenter>
{
  private final Provider<Handler> backgroundExecutorProvider;
  private final Provider<CallHandler> callHandlerProvider;
  private final Provider<c> callsTrackerProvider;
  private final Provider<e> clockTimeProvider;
  private final Provider<ConferenceCallsRepository> conferenceCallsRepositoryProvider;
  private final Provider<ConferenceGroupCreationHelper> conferenceGroupCreationHelperProvider;
  private final Provider<Engine> engineProvider;
  private final Provider<ConferenceHoldStateResolver> holdStateResolverProvider;
  private final Provider<bs> messageEditHelperProvider;
  private final Provider<Handler> messagesExecutorProvider;
  private final Provider<ConferenceMicStateResolver> micStateResolverProvider;
  private final Provider<ConferenceParticipantMapper> participantMapperProvider;
  private final Provider<ConferenceParticipantsRepository> participantsRepositoryProvider;
  private final Provider<cj> reachabilityProvider;
  private final Provider<af> registrationValuesProvider;
  private final Provider<cn> resourceProvider;
  private final Provider<ConferenceSpeakerStateResolver> speakerStateResolverProvider;
  private final Provider<e> systemTimeProvider;
  private final Provider<Handler> uiExecutorProvider;
  private final Provider<UserInfoRepository> userInfoRepositoryProvider;

  public ConferenceInCallPresenter_Factory(Provider<UserInfoRepository> paramProvider, Provider<af> paramProvider1, Provider<CallHandler> paramProvider2, Provider<ConferenceSpeakerStateResolver> paramProvider3, Provider<ConferenceMicStateResolver> paramProvider4, Provider<ConferenceHoldStateResolver> paramProvider5, Provider<ConferenceParticipantsRepository> paramProvider6, Provider<ConferenceCallsRepository> paramProvider7, Provider<cn> paramProvider8, Provider<ConferenceParticipantMapper> paramProvider9, Provider<ConferenceGroupCreationHelper> paramProvider10, Provider<bs> paramProvider11, Provider<cj> paramProvider12, Provider<c> paramProvider13, Provider<Engine> paramProvider14, Provider<Handler> paramProvider15, Provider<Handler> paramProvider16, Provider<Handler> paramProvider17, Provider<e> paramProvider18, Provider<e> paramProvider19)
  {
    this.userInfoRepositoryProvider = paramProvider;
    this.registrationValuesProvider = paramProvider1;
    this.callHandlerProvider = paramProvider2;
    this.speakerStateResolverProvider = paramProvider3;
    this.micStateResolverProvider = paramProvider4;
    this.holdStateResolverProvider = paramProvider5;
    this.participantsRepositoryProvider = paramProvider6;
    this.conferenceCallsRepositoryProvider = paramProvider7;
    this.resourceProvider = paramProvider8;
    this.participantMapperProvider = paramProvider9;
    this.conferenceGroupCreationHelperProvider = paramProvider10;
    this.messageEditHelperProvider = paramProvider11;
    this.reachabilityProvider = paramProvider12;
    this.callsTrackerProvider = paramProvider13;
    this.engineProvider = paramProvider14;
    this.uiExecutorProvider = paramProvider15;
    this.backgroundExecutorProvider = paramProvider16;
    this.messagesExecutorProvider = paramProvider17;
    this.systemTimeProvider = paramProvider18;
    this.clockTimeProvider = paramProvider19;
  }

  public static ConferenceInCallPresenter_Factory create(Provider<UserInfoRepository> paramProvider, Provider<af> paramProvider1, Provider<CallHandler> paramProvider2, Provider<ConferenceSpeakerStateResolver> paramProvider3, Provider<ConferenceMicStateResolver> paramProvider4, Provider<ConferenceHoldStateResolver> paramProvider5, Provider<ConferenceParticipantsRepository> paramProvider6, Provider<ConferenceCallsRepository> paramProvider7, Provider<cn> paramProvider8, Provider<ConferenceParticipantMapper> paramProvider9, Provider<ConferenceGroupCreationHelper> paramProvider10, Provider<bs> paramProvider11, Provider<cj> paramProvider12, Provider<c> paramProvider13, Provider<Engine> paramProvider14, Provider<Handler> paramProvider15, Provider<Handler> paramProvider16, Provider<Handler> paramProvider17, Provider<e> paramProvider18, Provider<e> paramProvider19)
  {
    return new ConferenceInCallPresenter_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11, paramProvider12, paramProvider13, paramProvider14, paramProvider15, paramProvider16, paramProvider17, paramProvider18, paramProvider19);
  }

  public ConferenceInCallPresenter get()
  {
    return new ConferenceInCallPresenter((UserInfoRepository)this.userInfoRepositoryProvider.get(), (af)this.registrationValuesProvider.get(), (CallHandler)this.callHandlerProvider.get(), (ConferenceSpeakerStateResolver)this.speakerStateResolverProvider.get(), (ConferenceMicStateResolver)this.micStateResolverProvider.get(), (ConferenceHoldStateResolver)this.holdStateResolverProvider.get(), (ConferenceParticipantsRepository)this.participantsRepositoryProvider.get(), (ConferenceCallsRepository)this.conferenceCallsRepositoryProvider.get(), (cn)this.resourceProvider.get(), (ConferenceParticipantMapper)this.participantMapperProvider.get(), (ConferenceGroupCreationHelper)this.conferenceGroupCreationHelperProvider.get(), (bs)this.messageEditHelperProvider.get(), (cj)this.reachabilityProvider.get(), (c)this.callsTrackerProvider.get(), (Engine)this.engineProvider.get(), (Handler)this.uiExecutorProvider.get(), (Handler)this.backgroundExecutorProvider.get(), (Handler)this.messagesExecutorProvider.get(), (e)this.systemTimeProvider.get(), (e)this.clockTimeProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallPresenter_Factory
 * JD-Core Version:    0.6.2
 */