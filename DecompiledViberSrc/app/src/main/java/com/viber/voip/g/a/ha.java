package com.viber.voip.g.a;

import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ha
  implements d<UserData>
{
  private final Provider<UserManager> a;

  public static UserData a(UserManager paramUserManager)
  {
    return (UserData)h.a(gv.b(paramUserManager), "Cannot return null from a non-@Nullable @Provides method");
  }

  public UserData a()
  {
    return (UserData)h.a(gv.b((UserManager)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ha
 * JD-Core Version:    0.6.2
 */