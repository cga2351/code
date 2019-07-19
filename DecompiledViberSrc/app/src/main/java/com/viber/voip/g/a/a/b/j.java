package com.viber.voip.g.a.a.b;

import android.content.Context;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.community.b.a;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class j
  implements d<a>
{
  private final Provider<Context> a;
  private final Provider<ai> b;

  public j(Provider<Context> paramProvider, Provider<ai> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static j a(Provider<Context> paramProvider, Provider<ai> paramProvider1)
  {
    return new j(paramProvider, paramProvider1);
  }

  public a a()
  {
    return (a)h.a(i.a((Context)this.a.get(), (ai)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.j
 * JD-Core Version:    0.6.2
 */