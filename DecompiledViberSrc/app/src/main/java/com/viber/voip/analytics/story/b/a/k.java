package com.viber.voip.analytics.story.b.a;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.registration.af;
import dagger.a.d;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

public final class k
  implements d<h>
{
  private final Provider<com.viber.voip.analytics.story.b.c> a;
  private final Provider<PhoneController> b;
  private final Provider<af> c;
  private final Provider<ConferenceParticipantsRepository> d;
  private final Provider<CallHandler> e;
  private final Provider<ScheduledExecutorService> f;

  public k(Provider<com.viber.voip.analytics.story.b.c> paramProvider, Provider<PhoneController> paramProvider1, Provider<af> paramProvider2, Provider<ConferenceParticipantsRepository> paramProvider3, Provider<CallHandler> paramProvider4, Provider<ScheduledExecutorService> paramProvider5)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
  }

  public static k a(Provider<com.viber.voip.analytics.story.b.c> paramProvider, Provider<PhoneController> paramProvider1, Provider<af> paramProvider2, Provider<ConferenceParticipantsRepository> paramProvider3, Provider<CallHandler> paramProvider4, Provider<ScheduledExecutorService> paramProvider5)
  {
    return new k(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }

  public h a()
  {
    return new h((com.viber.voip.analytics.story.b.c)this.a.get(), (PhoneController)this.b.get(), (af)this.c.get(), dagger.a.c.b(this.d), dagger.a.c.b(this.e), (ScheduledExecutorService)this.f.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.a.k
 * JD-Core Version:    0.6.2
 */