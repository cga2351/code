package com.viber.voip.user;

import android.content.Context;
import com.viber.jni.apps.AppsController;
import com.viber.voip.ViberApplication;
import com.viber.voip.apps.h;
import com.viber.voip.h.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.ae;
import org.greenrobot.eventbus.EventBus;

public class UserManager
{
  private final ProfileNotification mProfileNotification;
  private final af mRegistrationValues;
  private final h mUserAppsController;
  private final UserData mUserData;

  public UserManager(AppsController paramAppsController)
  {
    EventBus localEventBus = a.b();
    this.mUserData = new UserData(localEventBus);
    this.mRegistrationValues = new af();
    this.mUserAppsController = new h(paramAppsController);
    this.mProfileNotification = new ProfileNotification(this.mUserData, d.ae.a, d.ae.b);
    localEventBus.register(this.mProfileNotification);
    this.mProfileNotification.init();
  }

  @Deprecated
  public static UserManager from(Context paramContext)
  {
    return ViberApplication.getInstance().getUserManager();
  }

  public void clear()
  {
    this.mUserData.clear();
    this.mUserAppsController.a();
    this.mProfileNotification.clear();
  }

  public h getAppsController()
  {
    return this.mUserAppsController;
  }

  public ProfileNotification getProfileNotification()
  {
    return this.mProfileNotification;
  }

  public af getRegistrationValues()
  {
    return this.mRegistrationValues;
  }

  public Member getUser()
  {
    return new Member(this.mRegistrationValues.l(), this.mRegistrationValues.g(), this.mUserData.getImage(), this.mUserData.getViberName(), this.mRegistrationValues.m(), this.mRegistrationValues.j(), this.mRegistrationValues.k());
  }

  public UserData getUserData()
  {
    return this.mUserData;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.UserManager
 * JD-Core Version:    0.6.2
 */