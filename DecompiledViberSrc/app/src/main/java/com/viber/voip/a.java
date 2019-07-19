package com.viber.voip;

import com.viber.voip.pixie.PixieController;
import com.viber.voip.user.UserManager;

public final class a
  implements dagger.b<AboutActivity>
{
  public static void a(AboutActivity paramAboutActivity, com.viber.voip.app.b paramb)
  {
    paramAboutActivity.b = paramb;
  }

  public static void a(AboutActivity paramAboutActivity, PixieController paramPixieController)
  {
    paramAboutActivity.d = paramPixieController;
  }

  public static void a(AboutActivity paramAboutActivity, UserManager paramUserManager)
  {
    paramAboutActivity.c = paramUserManager;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.a
 * JD-Core Version:    0.6.2
 */