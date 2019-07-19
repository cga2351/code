package com.viber.voip.settings.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.voip.av.e;
import com.viber.voip.registration.DebugAuthSecondaryActivity;
import com.viber.voip.registration.SelectCountryActivity;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class av extends m
{
  public av(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "country_list_key", "Show Country List").a(this).a());
    f(new x(this.a, x.a.a, "debug_show_isolated_from_background_dialog_key", "Show Postponed Error Dialog").a("Displays error dialog with 3 sec delay").a(this).a());
    if (ao.f())
    {
      f(new x(this.a, x.a.a, "auth_secondary_key", "Show Auth secondary dialog").a(this).a());
      f(new x(this.a, x.a.a, "auth_description_secondary_key", "Show Auth description dialog").a(this).a());
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("open_screen_key");
    paramPreferenceGroup.c("Open Screen (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("country_list_key"))
    {
      Intent localIntent3 = new Intent(this.a, SelectCountryActivity.class).addFlags(268435456);
      this.a.startActivity(localIntent3);
      return true;
    }
    if (str.equals("debug_show_isolated_from_background_dialog_key"))
    {
      com.viber.voip.av.a(av.e.a).postDelayed(aw.a, 3000L);
      return true;
    }
    if (str.equals("auth_secondary_key"))
    {
      Intent localIntent2 = new Intent(this.a, DebugAuthSecondaryActivity.class).addFlags(268435456);
      localIntent2.putExtra("extra_show_auth_dialog", true);
      this.a.startActivity(localIntent2);
      return true;
    }
    if (str.equals("auth_description_secondary_key"))
    {
      Intent localIntent1 = new Intent(this.a, DebugAuthSecondaryActivity.class).addFlags(268435456);
      localIntent1.putExtra("extra_show_auth_description_dialog", true);
      this.a.startActivity(localIntent1);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.av
 * JD-Core Version:    0.6.2
 */