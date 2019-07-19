package com.viber.voip.g.a.a.b;

import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import dagger.a;
import javax.inject.Provider;

public final class d
  implements dagger.a.d<com.viber.voip.messages.conversation.chatinfo.a.h<com.viber.voip.messages.conversation.chatinfo.d.d>>
{
  private final Provider<ConferenceCallsRepository> a;

  public static com.viber.voip.messages.conversation.chatinfo.a.h<com.viber.voip.messages.conversation.chatinfo.d.d> a(a<ConferenceCallsRepository> parama)
  {
    return (com.viber.voip.messages.conversation.chatinfo.a.h)dagger.a.h.a(c.a(parama), "Cannot return null from a non-@Nullable @Provides method");
  }

  public com.viber.voip.messages.conversation.chatinfo.a.h<com.viber.voip.messages.conversation.chatinfo.d.d> a()
  {
    return (com.viber.voip.messages.conversation.chatinfo.a.h)dagger.a.h.a(c.a(dagger.a.c.b(this.a)), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.d
 * JD-Core Version:    0.6.2
 */