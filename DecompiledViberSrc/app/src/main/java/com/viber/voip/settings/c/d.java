package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.h;
import com.viber.voip.settings.d.h;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.da;

public class d extends m
{
  public d(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "clear_auth_token_pref_key", "Clear Auth Token").a(this).a());
    f(new x(this.a, x.a.a, "copy_to_clipboard_auth_token_pref_key", "Copy Auth Token to clipboard").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("auth_key");
    paramPreferenceGroup.c("Auth (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str1 = paramPreference.C();
    if (str1.equals("clear_auth_token_pref_key"))
    {
      d.h.a.b();
      return true;
    }
    if (str1.equals("copy_to_clipboard_auth_token_pref_key"))
    {
      String str2 = d.h.a.d();
      da.a(this.a, str2, "Auth Token: " + str2);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.d
 * JD-Core Version:    0.6.2
 */