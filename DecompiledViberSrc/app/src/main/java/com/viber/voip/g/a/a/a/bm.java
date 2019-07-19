package com.viber.voip.g.a.a.a;

import com.viber.voip.messages.conversation.a.b;
import com.viber.voip.messages.conversation.a.f;
import com.viber.voip.messages.conversation.a.k;
import com.viber.voip.messages.conversation.a.m;
import dagger.a.d;
import javax.inject.Provider;

public final class bm
  implements d<com.viber.voip.messages.conversation.a.h>
{
  private final Provider<m> a;
  private final Provider<b> b;
  private final Provider<f> c;
  private final Provider<k> d;

  public bm(Provider<m> paramProvider, Provider<b> paramProvider1, Provider<f> paramProvider2, Provider<k> paramProvider3)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
  }

  public static bm a(Provider<m> paramProvider, Provider<b> paramProvider1, Provider<f> paramProvider2, Provider<k> paramProvider3)
  {
    return new bm(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public com.viber.voip.messages.conversation.a.h a()
  {
    return (com.viber.voip.messages.conversation.a.h)dagger.a.h.a(bk.a((m)this.a.get(), (b)this.b.get(), (f)this.c.get(), (k)this.d.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.a.bm
 * JD-Core Version:    0.6.2
 */