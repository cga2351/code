package com.viber.voip.g.a.a.b;

import com.viber.voip.messages.conversation.commongroups.CommonGroupsPresenter;
import com.viber.voip.messages.conversation.commongroups.i;
import dagger.a.d;
import javax.inject.Provider;

public final class h
  implements d<CommonGroupsPresenter>
{
  private final Provider<i> a;

  public h(Provider<i> paramProvider)
  {
    this.a = paramProvider;
  }

  public static h a(Provider<i> paramProvider)
  {
    return new h(paramProvider);
  }

  public CommonGroupsPresenter a()
  {
    return (CommonGroupsPresenter)dagger.a.h.a(f.a((i)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.h
 * JD-Core Version:    0.6.2
 */