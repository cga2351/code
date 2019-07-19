package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.common.b.h;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.settings.d.i;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class f extends m
{
  private PreferenceScreen b;

  public f(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramPreferenceScreen;
  }

  protected void a()
  {
    f(new x(this.a, x.a.d, d.i.h.c(), "Backgrounds config json url").a(d.i.h.d()).a(d.i.h.f()).a(this).a());
    f(new x(this.a, x.a.a, "reset_backgrounds_config_json_key", "Reset backgrounds config url").a(this).a());
    f(new x(this.a, x.a.d, d.i.i.c(), "Background json last modified date").a(d.i.i.d()).a(d.i.i.f()).a(this).a());
    f(new x(this.a, x.a.a, "clear_bg_timestamp_key", "Clear bg update timestamp").a(this).a());
    f(new x(this.a, x.a.a, "reset_user_selected_bg_key", "Reset user selected bg mark").a(this).a());
    f(new x(this.a, x.a.c, d.i.j.c(), "Enable slow animated changes").a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("backgrounds_key");
    paramPreferenceGroup.c("Backgrounds (Debug options)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("reset_backgrounds_config_json_key"))
    {
      d.i.h.a(ap.c().F);
      Preference localPreference = this.b.a(d.i.h.c());
      localPreference.b(ap.c().F);
      ((EditTextPreference)localPreference).a(ap.c().F);
      return true;
    }
    if (str.equals("clear_bg_timestamp_key"))
      d.i.b.a(0L);
    while (true)
    {
      return false;
      if (str.equals("reset_user_selected_bg_key"))
        d.i.f.a(true);
    }
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (str.equals(d.i.h.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (str.equals(d.i.i.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.f
 * JD-Core Version:    0.6.2
 */