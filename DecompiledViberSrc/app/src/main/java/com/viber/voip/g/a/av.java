package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.group.participants.ban.BannedParticipantsListPresenter;
import com.viber.voip.group.participants.ban.e;
import com.viber.voip.invitelinks.linkscreen.g;
import com.viber.voip.messages.controller.a;
import javax.inject.Provider;

public final class av
  implements dagger.a.d<BannedParticipantsListPresenter>
{
  private final Provider<e> a;
  private final Provider<a> b;
  private final Provider<Handler> c;
  private final Provider<Im2Exchanger> d;
  private final Provider<PhoneController> e;
  private final Provider<g> f;
  private final Provider<com.viber.voip.group.participants.settings.d> g;
  private final Provider<com.viber.voip.group.participants.ban.h> h;

  public av(Provider<e> paramProvider, Provider<a> paramProvider1, Provider<Handler> paramProvider2, Provider<Im2Exchanger> paramProvider3, Provider<PhoneController> paramProvider4, Provider<g> paramProvider5, Provider<com.viber.voip.group.participants.settings.d> paramProvider6, Provider<com.viber.voip.group.participants.ban.h> paramProvider7)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
    this.g = paramProvider6;
    this.h = paramProvider7;
  }

  public static av a(Provider<e> paramProvider, Provider<a> paramProvider1, Provider<Handler> paramProvider2, Provider<Im2Exchanger> paramProvider3, Provider<PhoneController> paramProvider4, Provider<g> paramProvider5, Provider<com.viber.voip.group.participants.settings.d> paramProvider6, Provider<com.viber.voip.group.participants.ban.h> paramProvider7)
  {
    return new av(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7);
  }

  public BannedParticipantsListPresenter a()
  {
    return (BannedParticipantsListPresenter)dagger.a.h.a(ar.a((e)this.a.get(), (a)this.b.get(), (Handler)this.c.get(), (Im2Exchanger)this.d.get(), (PhoneController)this.e.get(), (g)this.f.get(), (com.viber.voip.group.participants.settings.d)this.g.get(), (com.viber.voip.group.participants.ban.h)this.h.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.av
 * JD-Core Version:    0.6.2
 */