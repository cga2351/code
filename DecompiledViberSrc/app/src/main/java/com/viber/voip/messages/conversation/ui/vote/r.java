package com.viber.voip.messages.conversation.ui.vote;

import com.viber.voip.analytics.story.e.c;
import com.viber.voip.messages.k;
import dagger.a.d;
import javax.inject.Provider;

public final class r
  implements d<VotePresenter>
{
  private final Provider<k> a;
  private final Provider<c> b;

  public r(Provider<k> paramProvider, Provider<c> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static r a(Provider<k> paramProvider, Provider<c> paramProvider1)
  {
    return new r(paramProvider, paramProvider1);
  }

  public VotePresenter a()
  {
    return new VotePresenter((k)this.a.get(), (c)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.r
 * JD-Core Version:    0.6.2
 */