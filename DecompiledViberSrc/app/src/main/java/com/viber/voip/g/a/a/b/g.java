package com.viber.voip.g.a.a.b;

import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.conversation.commongroups.i;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class g
  implements d<i>
{
  private final Provider<com.viber.voip.messages.conversation.commongroups.c> a;
  private final Provider<bv> b;

  public g(Provider<com.viber.voip.messages.conversation.commongroups.c> paramProvider, Provider<bv> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static g a(Provider<com.viber.voip.messages.conversation.commongroups.c> paramProvider, Provider<bv> paramProvider1)
  {
    return new g(paramProvider, paramProvider1);
  }

  public i a()
  {
    return (i)h.a(f.a((com.viber.voip.messages.conversation.commongroups.c)this.a.get(), dagger.a.c.b(this.b)), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.g
 * JD-Core Version:    0.6.2
 */