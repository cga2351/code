package com.viber.voip.settings.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.aq;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.bi;
import com.viber.voip.vln.e;

public class ay extends m
{
  private PreferenceScreen b;
  private final UserManager c;
  private final e d;
  private final Handler e;
  private final Runnable f = new az(this);

  public ay(Context paramContext, PreferenceScreen paramPreferenceScreen, UserManager paramUserManager, e parame)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramPreferenceScreen;
    this.c = paramUserManager;
    this.d = parame;
    this.e = av.a(av.e.a);
  }

  private void e()
  {
    this.d.b(true);
    this.d.a(true);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "open_react_native_screen", "Open react native screen").a(this).a());
    f(new x(this.a, x.a.d, d.aq.b.c(), "Base API URL").a(d.aq.b.f()).a(this).a(this).a());
    f(new x(this.a, x.a.d, d.aq.c.c(), "JS bundle URL").a(d.aq.c.f()).a(this).a(this).a());
    f(new x(this.a, x.a.c, d.aq.d.c(), "Enable JS bundle debug").a(Boolean.valueOf(d.aq.d.f())).a(this).a(this).a());
    f(new x(this.a, x.a.d, d.aq.a.c(), "Code push token").a(d.aq.a.f()).a(this).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("react_key");
    paramPreferenceGroup.c("React Native (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("open_react_native_screen"))
    {
      ViberActionRunner.bi.a(this.a, this.c.getRegistrationValues().l(), this.c.getRegistrationValues().g());
      return false;
    }
    return super.a(paramPreference);
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if (d.aq.c.c().equals(paramPreference.C()))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
      ((EditTextPreference)this.b.a(d.aq.c.c())).a((String)paramObject);
      localSharedPreferences.edit().putString("debug_http_host", (String)paramObject).commit();
    }
    this.e.removeCallbacks(this.f);
    this.e.postDelayed(this.f, 2000L);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ay
 * JD-Core Version:    0.6.2
 */