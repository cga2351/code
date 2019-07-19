package com.viber.voip.messages.controller;

import android.app.KeyguardManager;
import android.content.Context;
import com.viber.voip.app.b;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.notif.g;
import dagger.a.c;
import dagger.a.d;
import javax.inject.Provider;

public final class br
  implements d<bn>
{
  private final Provider<Context> a;
  private final Provider<KeyguardManager> b;
  private final Provider<ab> c;
  private final Provider<g> d;
  private final Provider<b> e;

  public br(Provider<Context> paramProvider, Provider<KeyguardManager> paramProvider1, Provider<ab> paramProvider2, Provider<g> paramProvider3, Provider<b> paramProvider4)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static br a(Provider<Context> paramProvider, Provider<KeyguardManager> paramProvider1, Provider<ab> paramProvider2, Provider<g> paramProvider3, Provider<b> paramProvider4)
  {
    return new br(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public bn a()
  {
    return new bn((Context)this.a.get(), (KeyguardManager)this.b.get(), c.b(this.c), c.b(this.d), (b)this.e.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.br
 * JD-Core Version:    0.6.2
 */