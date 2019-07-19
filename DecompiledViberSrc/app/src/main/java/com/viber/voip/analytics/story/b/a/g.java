package com.viber.voip.analytics.story.b.a;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.registration.af;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

public final class g
  implements dagger.a.d<c>
{
  private final Provider<com.viber.voip.analytics.story.b.c> a;
  private final Provider<PhoneController> b;
  private final Provider<af> c;
  private final Provider<ConferenceParticipantsRepository> d;
  private final Provider<ScheduledExecutorService> e;
  private final Provider<com.viber.voip.model.a.d> f;

  public g(Provider<com.viber.voip.analytics.story.b.c> paramProvider, Provider<PhoneController> paramProvider1, Provider<af> paramProvider2, Provider<ConferenceParticipantsRepository> paramProvider3, Provider<ScheduledExecutorService> paramProvider4, Provider<com.viber.voip.model.a.d> paramProvider5)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
  }

  public static g a(Provider<com.viber.voip.analytics.story.b.c> paramProvider, Provider<PhoneController> paramProvider1, Provider<af> paramProvider2, Provider<ConferenceParticipantsRepository> paramProvider3, Provider<ScheduledExecutorService> paramProvider4, Provider<com.viber.voip.model.a.d> paramProvider5)
  {
    return new g(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }

  public c a()
  {
    return new c((com.viber.voip.analytics.story.b.c)this.a.get(), (PhoneController)this.b.get(), (af)this.c.get(), (ConferenceParticipantsRepository)this.d.get(), (ScheduledExecutorService)this.e.get(), (com.viber.voip.model.a.d)this.f.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.a.g
 * JD-Core Version:    0.6.2
 */