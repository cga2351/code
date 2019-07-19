package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.cl;
import com.viber.voip.messages.k;
import com.viber.voip.registration.af;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;

public abstract class gv
{
  static ci a(k paramk)
  {
    return paramk.e();
  }

  static af a(UserManager paramUserManager)
  {
    return paramUserManager.getRegistrationValues();
  }

  static UserManager a(Engine paramEngine)
  {
    return paramEngine.getUserManager();
  }

  static cl b(k paramk)
  {
    return paramk.C();
  }

  static OnlineUserActivityHelper b(Engine paramEngine)
  {
    return paramEngine.getOnlineUserActivityHelper();
  }

  static UserData b(UserManager paramUserManager)
  {
    return paramUserManager.getUserData();
  }

  static ProfileNotification c(UserManager paramUserManager)
  {
    return paramUserManager.getProfileNotification();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gv
 * JD-Core Version:    0.6.2
 */