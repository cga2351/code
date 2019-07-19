package com.viber.voip.messages.conversation.a;

import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import dagger.a.c;
import dagger.a.d;
import javax.inject.Provider;

public final class g
  implements d<f>
{
  private final Provider<ConferenceCallsRepository> a;

  public g(Provider<ConferenceCallsRepository> paramProvider)
  {
    this.a = paramProvider;
  }

  public static g a(Provider<ConferenceCallsRepository> paramProvider)
  {
    return new g(paramProvider);
  }

  public f a()
  {
    return new f(c.b(this.a));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.a.g
 * JD-Core Version:    0.6.2
 */