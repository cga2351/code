package com.viber.voip.user.editinfo;

import com.viber.voip.messages.controller.ci;
import com.viber.voip.user.UserManager;
import dagger.a.c;
import dagger.a.d;
import javax.inject.Provider;

public final class UserInfoRepository_Factory
  implements d<UserInfoRepository>
{
  private final Provider<ci> userDataControllerProvider;
  private final Provider<UserManager> userManagerProvider;

  public UserInfoRepository_Factory(Provider<UserManager> paramProvider, Provider<ci> paramProvider1)
  {
    this.userManagerProvider = paramProvider;
    this.userDataControllerProvider = paramProvider1;
  }

  public static UserInfoRepository_Factory create(Provider<UserManager> paramProvider, Provider<ci> paramProvider1)
  {
    return new UserInfoRepository_Factory(paramProvider, paramProvider1);
  }

  public UserInfoRepository get()
  {
    return new UserInfoRepository((UserManager)this.userManagerProvider.get(), c.b(this.userDataControllerProvider));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.UserInfoRepository_Factory
 * JD-Core Version:    0.6.2
 */