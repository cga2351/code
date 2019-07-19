package com.viber.voip.phone.viber.incall;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.d.b;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import dagger.a.c;
import dagger.a.d;
import javax.inject.Provider;

public final class GenericInCallPresenter_Factory
  implements d<GenericInCallPresenter>
{
  private final Provider<CallHandler> callHandlerProvider;
  private final Provider<Engine> engineProvider;
  private final Provider<ConferenceParticipantMapper> mapperProvider;
  private final Provider<bs> messageEditHelperProvider;
  private final Provider<Handler> messagesHandlerProvider;
  private final Provider<b> participantManagerProvider;
  private final Provider<cj> reachabilityProvider;
  private final Provider<cn> resourcesProvider;
  private final Provider<UserManager> userManagerProvider;
  private final Provider<h> userStartsCallEventCollectorProvider;

  public GenericInCallPresenter_Factory(Provider<Handler> paramProvider, Provider<bs> paramProvider1, Provider<UserManager> paramProvider2, Provider<CallHandler> paramProvider3, Provider<cj> paramProvider4, Provider<Engine> paramProvider5, Provider<cn> paramProvider6, Provider<b> paramProvider7, Provider<ConferenceParticipantMapper> paramProvider8, Provider<h> paramProvider9)
  {
    this.messagesHandlerProvider = paramProvider;
    this.messageEditHelperProvider = paramProvider1;
    this.userManagerProvider = paramProvider2;
    this.callHandlerProvider = paramProvider3;
    this.reachabilityProvider = paramProvider4;
    this.engineProvider = paramProvider5;
    this.resourcesProvider = paramProvider6;
    this.participantManagerProvider = paramProvider7;
    this.mapperProvider = paramProvider8;
    this.userStartsCallEventCollectorProvider = paramProvider9;
  }

  public static GenericInCallPresenter_Factory create(Provider<Handler> paramProvider, Provider<bs> paramProvider1, Provider<UserManager> paramProvider2, Provider<CallHandler> paramProvider3, Provider<cj> paramProvider4, Provider<Engine> paramProvider5, Provider<cn> paramProvider6, Provider<b> paramProvider7, Provider<ConferenceParticipantMapper> paramProvider8, Provider<h> paramProvider9)
  {
    return new GenericInCallPresenter_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9);
  }

  public GenericInCallPresenter get()
  {
    return new GenericInCallPresenter((Handler)this.messagesHandlerProvider.get(), (bs)this.messageEditHelperProvider.get(), (UserManager)this.userManagerProvider.get(), (CallHandler)this.callHandlerProvider.get(), (cj)this.reachabilityProvider.get(), (Engine)this.engineProvider.get(), (cn)this.resourcesProvider.get(), (b)this.participantManagerProvider.get(), (ConferenceParticipantMapper)this.mapperProvider.get(), c.b(this.userStartsCallEventCollectorProvider));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incall.GenericInCallPresenter_Factory
 * JD-Core Version:    0.6.2
 */