package com.viber.voip.phone.viber.conference;

import android.os.Handler;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.registration.af;
import dagger.a.c;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceParticipantsRepository_Factory
  implements d<ConferenceParticipantsRepository>
{
  private final Provider<Handler> backgroundExecutorProvider;
  private final Provider<CallHandler> callHandlerProvider;
  private final Provider<DialerLocalCallStateListener> dialerLocalCallStateListenerProvider;
  private final Provider<Handler> mainExecutorProvider;
  private final Provider<ConferenceParticipantMapper> participantMapperProvider;
  private final Provider<af> registrationValuesProvider;
  private final Provider<ci> userDataControllerProvider;

  public ConferenceParticipantsRepository_Factory(Provider<af> paramProvider, Provider<CallHandler> paramProvider1, Provider<Handler> paramProvider2, Provider<Handler> paramProvider3, Provider<ConferenceParticipantMapper> paramProvider4, Provider<ci> paramProvider5, Provider<DialerLocalCallStateListener> paramProvider6)
  {
    this.registrationValuesProvider = paramProvider;
    this.callHandlerProvider = paramProvider1;
    this.mainExecutorProvider = paramProvider2;
    this.backgroundExecutorProvider = paramProvider3;
    this.participantMapperProvider = paramProvider4;
    this.userDataControllerProvider = paramProvider5;
    this.dialerLocalCallStateListenerProvider = paramProvider6;
  }

  public static ConferenceParticipantsRepository_Factory create(Provider<af> paramProvider, Provider<CallHandler> paramProvider1, Provider<Handler> paramProvider2, Provider<Handler> paramProvider3, Provider<ConferenceParticipantMapper> paramProvider4, Provider<ci> paramProvider5, Provider<DialerLocalCallStateListener> paramProvider6)
  {
    return new ConferenceParticipantsRepository_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }

  public ConferenceParticipantsRepository get()
  {
    return new ConferenceParticipantsRepository((af)this.registrationValuesProvider.get(), (CallHandler)this.callHandlerProvider.get(), (Handler)this.mainExecutorProvider.get(), (Handler)this.backgroundExecutorProvider.get(), (ConferenceParticipantMapper)this.participantMapperProvider.get(), c.b(this.userDataControllerProvider), (DialerLocalCallStateListener)this.dialerLocalCallStateListenerProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository_Factory
 * JD-Core Version:    0.6.2
 */