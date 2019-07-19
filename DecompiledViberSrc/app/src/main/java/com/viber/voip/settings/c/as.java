package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.d;
import com.viber.voip.settings.d.ae;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserManager;

public class as extends m
{
  private final ProfileNotification b = UserManager.from(this.a).getProfileNotification();

  public as(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private String d()
  {
    boolean bool1 = this.b.showBanner();
    boolean bool2 = this.b.showBadge();
    return "Current state - Banner: " + bool1 + ", Badge: " + bool2;
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "debug_profile_notification_state_key", "Profile notification(Restart required)").a(d()).a(this).a());
    f(new x(this.a, x.a.a, "debug_reset_sticker_market_subtext_state_key", "Reset sticker market subtext state").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("more_screen");
    paramPreferenceGroup.c("More screen (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("debug_profile_notification_state_key"))
    {
      this.b.updateState();
      paramPreference.b(d());
    }
    while (true)
    {
      return super.a(paramPreference);
      if (paramPreference.C().equals("debug_reset_sticker_market_subtext_state_key"))
        d.ae.c.e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.as
 * JD-Core Version:    0.6.2
 */