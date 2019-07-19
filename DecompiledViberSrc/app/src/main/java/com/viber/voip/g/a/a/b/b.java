package com.viber.voip.g.a.a.b;

import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsPresenter;
import dagger.a.h;
import javax.inject.Provider;

public final class b
  implements dagger.a.d<ChatExtensionDetailsPresenter>
{
  private final Provider<com.viber.voip.messages.extensions.b.b> a;
  private final Provider<com.viber.voip.messages.extensions.c> b;
  private final Provider<com.viber.voip.messages.extensions.a> c;
  private final Provider<com.viber.common.permission.c> d;
  private final Provider<com.viber.voip.messages.controller.publicaccount.d> e;
  private final Provider<com.viber.voip.app.b> f;
  private final Provider<o> g;
  private final Provider<com.viber.voip.analytics.story.c.c> h;

  public b(Provider<com.viber.voip.messages.extensions.b.b> paramProvider, Provider<com.viber.voip.messages.extensions.c> paramProvider1, Provider<com.viber.voip.messages.extensions.a> paramProvider2, Provider<com.viber.common.permission.c> paramProvider3, Provider<com.viber.voip.messages.controller.publicaccount.d> paramProvider4, Provider<com.viber.voip.app.b> paramProvider5, Provider<o> paramProvider6, Provider<com.viber.voip.analytics.story.c.c> paramProvider7)
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

  public static b a(Provider<com.viber.voip.messages.extensions.b.b> paramProvider, Provider<com.viber.voip.messages.extensions.c> paramProvider1, Provider<com.viber.voip.messages.extensions.a> paramProvider2, Provider<com.viber.common.permission.c> paramProvider3, Provider<com.viber.voip.messages.controller.publicaccount.d> paramProvider4, Provider<com.viber.voip.app.b> paramProvider5, Provider<o> paramProvider6, Provider<com.viber.voip.analytics.story.c.c> paramProvider7)
  {
    return new b(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7);
  }

  public ChatExtensionDetailsPresenter a()
  {
    return (ChatExtensionDetailsPresenter)h.a(a.a((com.viber.voip.messages.extensions.b.b)this.a.get(), (com.viber.voip.messages.extensions.c)this.b.get(), (com.viber.voip.messages.extensions.a)this.c.get(), (com.viber.common.permission.c)this.d.get(), (com.viber.voip.messages.controller.publicaccount.d)this.e.get(), (com.viber.voip.app.b)this.f.get(), (o)this.g.get(), (com.viber.voip.analytics.story.c.c)this.h.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.b
 * JD-Core Version:    0.6.2
 */