package com.viber.voip.g.a;

import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gy
  implements d<af>
{
  private final Provider<UserManager> a;

  public gy(Provider<UserManager> paramProvider)
  {
    this.a = paramProvider;
  }

  public static gy a(Provider<UserManager> paramProvider)
  {
    return new gy(paramProvider);
  }

  public static af a(UserManager paramUserManager)
  {
    return (af)h.a(gv.a(paramUserManager), "Cannot return null from a non-@Nullable @Provides method");
  }

  public af a()
  {
    return (af)h.a(gv.a((UserManager)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gy
 * JD-Core Version:    0.6.2
 */