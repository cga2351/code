package com.viber.voip.g.a;

import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.k;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dp
  implements d<GroupController>
{
  private final Provider<k> a;

  public dp(Provider<k> paramProvider)
  {
    this.a = paramProvider;
  }

  public static dp a(Provider<k> paramProvider)
  {
    return new dp(paramProvider);
  }

  public static GroupController a(k paramk)
  {
    return (GroupController)h.a(dj.g(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public GroupController a()
  {
    return (GroupController)h.a(dj.g((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dp
 * JD-Core Version:    0.6.2
 */