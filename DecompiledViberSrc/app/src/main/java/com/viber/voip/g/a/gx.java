package com.viber.voip.g.a;

import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserManager;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gx
  implements d<ProfileNotification>
{
  private final Provider<UserManager> a;

  public static ProfileNotification a(UserManager paramUserManager)
  {
    return (ProfileNotification)h.a(gv.c(paramUserManager), "Cannot return null from a non-@Nullable @Provides method");
  }

  public ProfileNotification a()
  {
    return (ProfileNotification)h.a(gv.c((UserManager)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gx
 * JD-Core Version:    0.6.2
 */